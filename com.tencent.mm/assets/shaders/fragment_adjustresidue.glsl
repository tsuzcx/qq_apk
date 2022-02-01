precision mediump float;
varying highp vec2 coordinate;
uniform sampler2D inputImageTexture;
uniform sampler2D blurredImageTexture1;
uniform sampler2D blurredImageTexture3;
void main()
{
    vec3 orgColor = texture2D(inputImageTexture, coordinate).rgb;

    float y0 = orgColor.r;

    float y_lowpass1 = texture2D(blurredImageTexture1, coordinate).r;
    float y_lowpass3 = texture2D(blurredImageTexture3, coordinate).r;

    float y_residue = abs(y0-y_lowpass1)*255.0;
    y_residue = y_residue>8.0?8.0/y_residue:(y_residue>=1.0?1.0:y_residue);
    if (sign(y0-y_lowpass3)*sign(y0-y_lowpass1)<-0.5) y_residue=0.0;

    gl_FragColor = vec4(y_residue, orgColor.gb, 1.0);
}