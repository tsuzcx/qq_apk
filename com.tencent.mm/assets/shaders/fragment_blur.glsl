precision mediump float;
varying vec2 TexCoord;
uniform sampler2D inputImageTexture;
varying vec2 TexCoord_shift1;
varying vec2 TexCoord_shift2;
varying vec2 TexCoord_shift3;
varying vec2 TexCoord_shift4;
varying vec2 TexCoord_shift5;
varying vec2 TexCoord_shift6;
varying vec2 TexCoord_shift7;
varying vec2 TexCoord_shift8;
void main()
{
    gl_FragColor = vec4((texture2D(inputImageTexture,TexCoord_shift1).r + texture2D(inputImageTexture,TexCoord_shift2).r + texture2D(inputImageTexture,TexCoord_shift3).r +
    texture2D(inputImageTexture,TexCoord_shift4).r + texture2D(inputImageTexture,TexCoord_shift5).r + texture2D(inputImageTexture,TexCoord_shift6).r +
    texture2D(inputImageTexture,TexCoord_shift7).r + texture2D(inputImageTexture,TexCoord_shift8).r + texture2D(inputImageTexture, TexCoord).r ) * 0.11111, texture2D(inputImageTexture, TexCoord).gb, 1.0);
}