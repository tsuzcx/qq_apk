#extension GL_OES_EGL_image_external : require
precision mediump float;
varying highp vec2 coordinate;
uniform samplerExternalOES inputImageTexture;
uniform int mode;
vec3 RGB2YUV(vec3 rgb)
{
    vec3 yuv = vec3(0.0);
    yuv.x = rgb.r * 0.299 + rgb.g * 0.587 + rgb.b * 0.114;
    yuv.y = rgb.r * -0.169 + rgb.g * -0.331 + rgb.b * 0.5 + 0.5;
    yuv.z = rgb.r * 0.5 + rgb.g * -0.419 + rgb.b * -0.081 + 0.5;
    return yuv;
}
void main()
{
    vec3 orgColor = texture2D(inputImageTexture, coordinate).rgb;
    vec3 yuvColor = mode==1?RGB2YUV(orgColor):orgColor;
    gl_FragColor = vec4(yuvColor, 1.0);
}