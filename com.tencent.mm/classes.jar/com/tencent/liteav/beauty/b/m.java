package com.tencent.liteav.beauty.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

public class m
  extends j
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
  
  public m() {}
  
  public m(float paramFloat1, Bitmap paramBitmap1, float paramFloat2, Bitmap paramBitmap2, float paramFloat3)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying highp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform sampler2D inputImageTexture2; // lookup texture 1\n uniform sampler2D inputImageTexture3; // lookup texture 2\n \n \n uniform lowp vec3 v3_params;\n uniform lowp vec2 v2_texs;\n \n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     mediump float blueColor = textureColor.b * 63.0;\n     \n     mediump vec2 quad1;\n     quad1.y = floor(floor(blueColor) / 8.0);\n     quad1.x = floor(blueColor) - (quad1.y * 8.0);\n     \n     mediump vec2 quad2;\n     quad2.y = floor(ceil(blueColor) / 8.0);\n     quad2.x = ceil(blueColor) - (quad2.y * 8.0);\n     \n     highp vec2 texPos1;\n     texPos1.x = (quad1.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos1.y = (quad1.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     highp vec2 texPos2;\n     texPos2.x = (quad2.x * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.r);\n     texPos2.y = (quad2.y * 0.125) + 0.5/512.0 + ((0.125 - 1.0/512.0) * textureColor.g);\n     \n     lowp vec4 newColor1;\n     lowp vec4 newColor2;\n     if(textureCoordinate.x <= v3_params.x) { \n       if(v2_texs.x == 1.0) { \n         newColor1 = texture2D(inputImageTexture2, texPos1);\n         newColor2 = texture2D(inputImageTexture2, texPos2);\n         lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n         gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.y);\n       } else { \n         gl_FragColor = textureColor;\n       } \n     } else {\n       if(v2_texs.y == 1.0) { \n         newColor1 = texture2D(inputImageTexture3, texPos1);\n         newColor2 = texture2D(inputImageTexture3, texPos2);\n         lowp vec4 newColor = mix(newColor1, newColor2, fract(blueColor));\n         gl_FragColor = mix(textureColor, vec4(newColor.rgb, textureColor.w), v3_params.z);\n       } else { \n         gl_FragColor = textureColor;\n       } \n     }\n }");
    AppMethodBeat.i(15047);
    this.B = new float[3];
    this.D = new float[2];
    this.r = paramFloat1;
    this.s = paramBitmap1;
    this.w = paramBitmap2;
    this.v = paramFloat2;
    this.z = paramFloat3;
    AppMethodBeat.o(15047);
  }
  
  public m(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(15051);
    a(this.r, paramFloat, 0.0F);
    AppMethodBeat.o(15051);
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
  
  public void a(float paramFloat1, final Bitmap paramBitmap1, float paramFloat2, final Bitmap paramBitmap2, float paramFloat3)
  {
    AppMethodBeat.i(15050);
    a(paramFloat1, paramFloat2, paramFloat3);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(15024);
        m.a(m.this, paramBitmap1);
        m.b(m.this, paramBitmap2);
        if (paramBitmap1 != null)
        {
          m.a(m.this, TXCOpenGlUtils.a(paramBitmap1, m.a(m.this), false));
          m.b(m.this)[0] = 1.0F;
        }
        while (paramBitmap2 != null)
        {
          m.b(m.this, TXCOpenGlUtils.a(paramBitmap2, m.c(m.this), false));
          m.b(m.this)[1] = 1.0F;
          AppMethodBeat.o(15024);
          return;
          if (m.a(m.this) != -1) {
            GLES20.glDeleteTextures(1, new int[] { m.a(m.this) }, 0);
          }
          m.a(m.this, -1);
          m.b(m.this)[0] = 0.0F;
        }
        if (m.c(m.this) != -1) {
          GLES20.glDeleteTextures(1, new int[] { m.c(m.this) }, 0);
        }
        m.b(m.this, -1);
        m.b(m.this)[1] = 0.0F;
        AppMethodBeat.o(15024);
      }
    });
    AppMethodBeat.o(15050);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(15048);
    this.t = GLES20.glGetUniformLocation(q(), "inputImageTexture2");
    this.x = GLES20.glGetUniformLocation(q(), "inputImageTexture3");
    this.A = GLES20.glGetUniformLocation(q(), "v3_params");
    this.C = GLES20.glGetUniformLocation(q(), "v2_texs");
    boolean bool = super.b();
    AppMethodBeat.o(15048);
    return bool;
  }
  
  public void c()
  {
    AppMethodBeat.i(15049);
    super.c();
    a(this.r, this.s, this.v, this.w, this.z);
    AppMethodBeat.o(15049);
  }
  
  public void e()
  {
    AppMethodBeat.i(15052);
    super.e();
    GLES20.glDeleteTextures(2, new int[] { this.u, this.y }, 0);
    this.u = -1;
    this.y = -1;
    AppMethodBeat.o(15052);
  }
  
  public void i()
  {
    AppMethodBeat.i(15053);
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
    AppMethodBeat.o(15053);
  }
  
  public void j()
  {
    AppMethodBeat.i(15054);
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
    AppMethodBeat.o(15054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.m
 * JD-Core Version:    0.7.0.1
 */