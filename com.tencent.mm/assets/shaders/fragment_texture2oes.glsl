precision mediump float;
varying highp vec2 coordinate;
uniform sampler2D inputImageTexture;
uniform int mode;
void main()
{
    vec3 orgColor = texture2D(inputImageTexture, coordinate).rgb;
    gl_FragColor = vec4(orgColor, 1.0);
}