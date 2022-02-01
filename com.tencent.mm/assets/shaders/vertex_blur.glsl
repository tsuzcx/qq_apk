uniform mat4 uMVPMatrix;
uniform mat4 uSTMatrix;
attribute vec4 position;
attribute vec4 texCoord;
uniform highp vec2 texSize;
uniform highp float Offset;
varying vec2 TexCoord;
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
   gl_Position = uMVPMatrix * position;
   TexCoord = (uSTMatrix * texCoord).xy;
   TexCoord_shift1 = vec2(float(int(TexCoord.x * texSize.x - Offset ))/texSize.x, float(int(TexCoord.y * texSize.y))/texSize.y);
   TexCoord_shift2 = vec2(float(int(TexCoord.x * texSize.x + Offset ))/texSize.x, float(int(TexCoord.y * texSize.y))/texSize.y);
   TexCoord_shift3 = vec2(float(int(TexCoord.x * texSize.x))/texSize.x, float(int(TexCoord.y * texSize.y - Offset))/texSize.y);
   TexCoord_shift4 = vec2(float(int(TexCoord.x * texSize.x))/texSize.x, float(int(TexCoord.y * texSize.y + Offset))/texSize.y);

   TexCoord_shift5 = vec2(float(int(TexCoord.x * texSize.x - Offset))/texSize.x, float(int(TexCoord.y * texSize.y - Offset ))/texSize.y);
   TexCoord_shift6 = vec2(float(int(TexCoord.x * texSize.x + Offset))/texSize.x, float(int(TexCoord.y * texSize.y + Offset ))/texSize.y);
   TexCoord_shift7 = vec2(float(int(TexCoord.x * texSize.x - Offset))/texSize.x, float(int(TexCoord.y * texSize.y + Offset ))/texSize.y);
   TexCoord_shift8 = vec2(float(int(TexCoord.x * texSize.x + Offset))/texSize.x, float(int(TexCoord.y * texSize.y - Offset ))/texSize.y);
}