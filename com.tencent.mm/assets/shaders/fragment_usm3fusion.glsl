precision mediump float;
varying highp vec2 coordinate;
uniform float weight[4];
uniform float ratio;
uniform sampler2D inputImageTexture;
uniform sampler2D blurredImageTexture1;
uniform sampler2D blurredImageTexture2;
uniform sampler2D blurredImageTexture3;
vec3 YUV2RGB(vec3 yuv)
{
  yuv.y = yuv.y - 0.5;
  yuv.z = yuv.z - 0.5;
  vec3 rgb = vec3(0.0);
  rgb.r = yuv.x * 1.0 + yuv.y * 0.0 + yuv.z * 1.4;
    rgb.g = yuv.x * 1.0 + yuv.y * -0.343 + yuv.z * -0.711;
    rgb.b = yuv.x * 1.0 + yuv.y * 1.765 + yuv.z * 0.0;
  return rgb;
}
void main()
{
    vec3 orgColor = texture2D(inputImageTexture, coordinate).rgb;

    float y0 = orgColor.r;

    float y_lowpass1 = texture2D(blurredImageTexture1, coordinate).r;

    float y_lowpass2 = texture2D(blurredImageTexture2, coordinate).r;

    float y_lowpass3 = texture2D(blurredImageTexture3, coordinate).r;

    float y_residue = abs(y0-y_lowpass1);
    y_residue = y_residue>0.09412?(y_residue<0.18823?0.18823-y_residue:0.0):y_residue;  //24
    float ay_residue = y_residue*255.0;
    float resw1 = ratio/((1.0+exp(-(ay_residue-weight[0])))*(ay_residue+2.0))*y_residue;

    y_residue = abs(y0-y_lowpass2);
    y_residue = y_residue>0.09412?(y_residue<0.18823?0.18823-y_residue:0.0):y_residue; //24
    ay_residue = y_residue*255.0;
    float resw2 = ratio/((1.0+exp(-(ay_residue-weight[0])))*(ay_residue+2.0))*y_residue;

    y_residue = abs(y0-y_lowpass3);
    y_residue = y_residue>0.09412?(y_residue<0.18823?0.18823-y_residue:0.0):y_residue; //24
    ay_residue = y_residue*255.0;
    float resw3 = ratio/((1.0+exp(-(ay_residue-weight[0])))*(ay_residue+2.0))*y_residue;

    float resw;
    resw = y0-y_lowpass1>=0.0?pow(resw1, weight[1])*pow(resw2, weight[2])*pow(resw3, weight[3]):-pow(resw1, weight[1])*pow(resw2, weight[2])*pow(resw3, weight[3]);

    float cvalue = clamp(y0+resw, 0.0, 1.0);

    float val_weight = cvalue <= 0.75? 1.0 : (resw<0.0?1.0:pow((1.0-cvalue)/0.25,3.0));
    float yres = val_weight*cvalue + (1.0-val_weight)*y0;

    vec3 rgbColor = YUV2RGB(vec3(yres, orgColor.gb));
    gl_FragColor = vec4(rgbColor, 1.0);
    // if (coordinate.x<0.2 && coordinate.y<0.2) gl_FragColor = vec4(weight[0]*weight[1]<1.3?0.1:weight[0]*weight[1]<1.7?1.0:0.5);
}