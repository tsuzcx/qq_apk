package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.basic.d.d;
import java.nio.FloatBuffer;

public class l
  extends d
{
  private int A;
  private float[] B;
  private int C;
  private float[] D;
  private float r;
  private Bitmap s;
  private int t;
  private int u = -1;
  private float v;
  private Bitmap w;
  private int x;
  private int y = -1;
  private float z;
  
  public l() {}
  
  public l(float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture 1\n uniform sampler2D inputImageTexture3; // lookup texture 2\n \n \n uniform lowp vec3 v3_params;\n uniform lowp vec2 v2_texs;\n \n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     mediump float blueColor = textureColor.b * 63.0;\n     \n     mediump vec2 quad1;\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     mediump vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     highp vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     highp vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     lowp vec4 newColor1;\n     lowp vec4 newColor2;\n     if(textureCoordinate.x <= v3_params.x) { \n       if(v2_texs.x == 1.0) { \n         newColor1 = texture2D(inputImageTexture2, texPos1);\n         newColor2 = texture2D(inputImageTexture2, texPos2);\n         lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n         gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.y);\n       } else { \n         gl_FragColor = textureColor;\n       } \n     } else {\n       if(v2_texs.y == 1.0) { \n         newColor1 = texture2D(inputImageTexture3, texPos1);\n         newColor2 = texture2D(inputImageTexture3, texPos2);\n         lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n         gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.z);\n       } else { \n         gl_FragColor = textureColor;\n       } \n     }\n }");
    this.B = new float[3];
    this.D = new float[2];
    this.r = paramFloat1;
    this.s = paramBitmap1;
    this.w = paramBitmap2;
    this.v = paramFloat2;
    this.z = paramFloat3;
  }
  
  public l(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void a(float paramFloat)
  {
    a(this.r, paramFloat, 0.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.r = paramFloat1;
    this.v = paramFloat2;
    this.z = paramFloat3;
    this.B[0] = this.r;
    this.B[1] = this.v;
    this.B[2] = this.z;
  }
  
  public void a(float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    a(paramFloat1, paramFloat2, paramFloat3);
    a(new l.1(this, paramBitmap1, paramBitmap2));
  }
  
  public boolean b()
  {
    this.t = GLES20.glGetUniformLocation(p(), "inputImageTexture2");
    this.x = GLES20.glGetUniformLocation(p(), "inputImageTexture3");
    this.A = GLES20.glGetUniformLocation(p(), "v3_params");
    this.C = GLES20.glGetUniformLocation(p(), "v2_texs");
    return super.b();
  }
  
  public void c()
  {
    super.c();
    a(this.r, this.s, this.v, this.w, this.z);
  }
  
  public void e()
  {
    super.e();
    GLES20.glDeleteTextures(2, new int[] { this.u, this.y }, 0);
    this.u = -1;
    this.y = -1;
  }
  
  protected void i()
  {
    if (this.u != -1)
    {
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, this.u);
      GLES20.glUniform1i(this.t, 3);
    }
    if (this.y != -1)
    {
      GLES20.glActiveTexture(33988);
      GLES20.glBindTexture(3553, this.y);
      GLES20.glUniform1i(this.x, 4);
    }
    GLES20.glUniform2fv(this.C, 1, FloatBuffer.wrap(this.D));
    GLES20.glUniform3fv(this.A, 1, FloatBuffer.wrap(this.B));
  }
  
  protected void j()
  {
    if (this.u != -1)
    {
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, 0);
      GLES20.glActiveTexture(33984);
    }
    if (this.y != -1)
    {
      GLES20.glActiveTexture(33988);
      GLES20.glBindTexture(3553, 0);
      GLES20.glActiveTexture(33984);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.l
 * JD-Core Version:    0.7.0.1
 */