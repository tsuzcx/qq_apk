uniform mat4 uMVPMatrix;
uniform mat4 uSTMatrix;
attribute vec4 position;
attribute vec4 texCoord;
varying vec2 coordinate;
void main()
{
   gl_Position = uMVPMatrix * position;
   coordinate = (uSTMatrix * texCoord).xy;
}