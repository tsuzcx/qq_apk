package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.d;
import com.tencent.liteav.basic.d.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class k
  extends d
{
  private static String z = "YUV420pToRGBFilter";
  private ByteBuffer r = null;
  private byte[] s = null;
  private int t = 1;
  private int[] u = null;
  private int[] v = null;
  private int w = 0;
  private int x = 0;
  private int[] y = null;
  
  public k(int paramInt)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    this.t = paramInt;
    TXCLog.i(z, "yuv Type " + paramInt);
  }
  
  private int r()
  {
    GLES20.glBindTexture(3553, this.y[0]);
    if (this.s != null)
    {
      NativeLoad.getInstance();
      NativeLoad.nativeglTexImage2D(3553, 0, 6408, this.e, this.f, 0, 6408, 5121, this.s, 0);
    }
    return this.y[0];
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.f == paramInt2) && (this.e == paramInt1)) {
      return;
    }
    if (1 == this.t)
    {
      this.u = new int[1];
      this.u[0] = f.a(paramInt1, paramInt2 * 3 / 2, 6409, 6409, this.u);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.u[0]);
      GLES20.glBindTexture(3553, 0);
      GLES20.glUniform1i(this.c, 0);
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2);
      return;
      if (3 == this.t)
      {
        GLES20.glActiveTexture(33984);
        GLES20.glActiveTexture(33985);
        this.w = GLES20.glGetUniformLocation(p(), "yTexture");
        this.x = GLES20.glGetUniformLocation(p(), "uvTexture");
        if (this.u == null)
        {
          this.u = new int[1];
          this.u[0] = f.a(paramInt1, paramInt2, 6409, 6409, this.u);
        }
        if (this.v == null)
        {
          this.v = new int[1];
          this.v[0] = f.a(paramInt1 / 2, paramInt2 / 2, 6410, 6410, this.v);
        }
        GLES20.glUniform1i(this.w, 0);
        GLES20.glUniform1i(this.x, 1);
      }
      else if ((2 == this.t) && (this.y == null))
      {
        this.y = new int[1];
        this.y[0] = f.a(paramInt1, paramInt2, 6408, 6408, this.y);
      }
    }
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    super.a(-1, paramFloatBuffer1, paramFloatBuffer2);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.s = paramArrayOfByte;
  }
  
  public boolean a()
  {
    int i = 7;
    if (this.t == 1)
    {
      NativeLoad.getInstance();
      this.a = NativeLoad.nativeLoadGLProgram(i);
      if ((this.a == 0) || (!b())) {
        break label106;
      }
    }
    label106:
    for (this.g = true;; this.g = false)
    {
      c();
      return this.g;
      if (this.t == 3)
      {
        i = 9;
        break;
      }
      if (this.t == 2) {
        return super.a();
      }
      TXCLog.e(z, "don't support yuv format " + this.t);
      break;
    }
  }
  
  public void e()
  {
    super.e();
    if ((this.u != null) && (this.u[0] > 0))
    {
      GLES20.glDeleteTextures(1, this.u, 0);
      this.u = null;
    }
    if ((this.v != null) && (this.v[0] > 0))
    {
      GLES20.glDeleteTextures(1, this.v, 0);
      this.v = null;
    }
    if ((this.y != null) && (this.y[0] > 0))
    {
      GLES20.glDeleteTextures(1, this.y, 0);
      this.y = null;
    }
  }
  
  protected void i()
  {
    super.i();
    if (1 == this.t)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.u[0]);
      GLES20.glUniform1i(this.c, 0);
      NativeLoad.getInstance();
      NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, this.f * 3 / 2, 0, 6409, 5121, this.s, 0);
    }
    do
    {
      return;
      if (3 == this.t)
      {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.u[0]);
        GLES20.glUniform1i(this.w, 0);
        NativeLoad.getInstance();
        NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, this.f, 0, 6409, 5121, this.s, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.v[0]);
        GLES20.glUniform1i(this.x, 1);
        NativeLoad.getInstance();
        int i = this.e / 2;
        int j = this.f / 2;
        byte[] arrayOfByte = this.s;
        int k = this.e;
        NativeLoad.nativeglTexImage2D(3553, 0, 6410, i, j, 0, 6410, 5121, arrayOfByte, this.f * k);
        return;
      }
    } while (2 != this.t);
    r();
  }
  
  public int q()
  {
    if (2 == this.t)
    {
      int i = r();
      GLES20.glBindTexture(3553, 0);
      return i;
    }
    return super.b(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.k
 * JD-Core Version:    0.7.0.1
 */