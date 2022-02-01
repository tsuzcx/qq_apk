package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.d.i;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

public class k
  extends g
{
  private static String y = "YUV420pToRGBFilter";
  private byte[] r;
  private int s;
  private int[] t;
  private int[] u;
  private int v;
  private int w;
  private int[] x;
  
  public k(int paramInt)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    AppMethodBeat.i(15110);
    this.r = null;
    this.s = 1;
    this.t = null;
    this.u = null;
    this.v = 0;
    this.w = 0;
    this.x = null;
    this.s = paramInt;
    TXCLog.i(y, "yuv Type ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(15110);
  }
  
  private int r()
  {
    AppMethodBeat.i(15115);
    GLES20.glBindTexture(3553, this.x[0]);
    if (this.r != null)
    {
      NativeLoad.getInstance();
      NativeLoad.nativeglTexImage2D(3553, 0, 6408, this.e, this.f, 0, 6408, 5121, this.r, 0);
    }
    int i = this.x[0];
    AppMethodBeat.o(15115);
    return i;
  }
  
  private void s()
  {
    AppMethodBeat.i(15117);
    if ((this.t != null) && (this.t[0] > 0))
    {
      GLES20.glDeleteTextures(1, this.t, 0);
      this.t = null;
    }
    if ((this.u != null) && (this.u[0] > 0))
    {
      GLES20.glDeleteTextures(1, this.u, 0);
      this.u = null;
    }
    AppMethodBeat.o(15117);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15112);
    if ((this.f == paramInt2) && (this.e == paramInt1))
    {
      AppMethodBeat.o(15112);
      return;
    }
    s();
    if (this.t == null)
    {
      this.t = new int[1];
      this.t[0] = i.a(paramInt1, paramInt2, 6409, 6409, this.t);
    }
    this.v = GLES20.glGetUniformLocation(p(), "yTexture");
    this.w = GLES20.glGetUniformLocation(p(), "uvTexture");
    if (1 == this.s)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glActiveTexture(33985);
      this.u = new int[1];
      this.u[0] = i.a(paramInt1, paramInt2 / 2, 6409, 6409, this.u);
      GLES20.glUniform1i(this.v, 0);
      GLES20.glUniform1i(this.w, 1);
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2);
      AppMethodBeat.o(15112);
      return;
      if (3 == this.s)
      {
        GLES20.glActiveTexture(33984);
        GLES20.glActiveTexture(33985);
        this.v = GLES20.glGetUniformLocation(p(), "yTexture");
        this.w = GLES20.glGetUniformLocation(p(), "uvTexture");
        this.u = new int[1];
        this.u[0] = i.a(paramInt1 / 2, paramInt2 / 2, 6410, 6410, this.u);
        GLES20.glUniform1i(this.v, 0);
        GLES20.glUniform1i(this.w, 1);
      }
      else if ((2 == this.s) && (this.x == null))
      {
        this.x = new int[1];
        this.x[0] = i.a(paramInt1, paramInt2, 6408, 6408, this.x);
      }
    }
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(15116);
    super.a(-1, paramFloatBuffer1, paramFloatBuffer2);
    AppMethodBeat.o(15116);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.r = paramArrayOfByte;
  }
  
  public boolean a()
  {
    int i = 7;
    AppMethodBeat.i(15111);
    if (this.s == 1)
    {
      NativeLoad.getInstance();
      this.a = NativeLoad.nativeLoadGLProgram(i);
      if ((this.a == 0) || (!b())) {
        break label128;
      }
    }
    label128:
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(15111);
      return bool;
      if (this.s == 3)
      {
        i = 9;
        break;
      }
      if (this.s == 2)
      {
        bool = super.a();
        AppMethodBeat.o(15111);
        return bool;
      }
      TXCLog.e(y, "don't support yuv format " + this.s);
      break;
    }
  }
  
  public void e()
  {
    AppMethodBeat.i(15118);
    super.e();
    s();
    AppMethodBeat.o(15118);
  }
  
  public void i()
  {
    AppMethodBeat.i(15113);
    super.i();
    int[] arrayOfInt;
    if (this.e % 4 != 0)
    {
      arrayOfInt = new int[1];
      GLES20.glGetIntegerv(3317, arrayOfInt, 0);
      GLES20.glPixelStorei(3317, 1);
    }
    for (;;)
    {
      if (1 == this.s)
      {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.t[0]);
        GLES20.glUniform1i(this.v, 0);
        NativeLoad.getInstance();
        NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, this.f, 0, 6409, 5121, this.r, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.u[0]);
        GLES20.glUniform1i(this.w, 1);
        NativeLoad.getInstance();
        NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, this.f / 2, 0, 6409, 5121, this.r, this.e * this.f);
      }
      while (this.e % 4 != 0) {
        if ((arrayOfInt != null) && (arrayOfInt[0] > 0))
        {
          GLES20.glPixelStorei(3317, arrayOfInt[0]);
          AppMethodBeat.o(15113);
          return;
          if (3 == this.s)
          {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.t[0]);
            GLES20.glUniform1i(this.v, 0);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.e, this.f, 0, 6409, 5121, this.r, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.u[0]);
            GLES20.glUniform1i(this.w, 1);
            NativeLoad.getInstance();
            int i = this.e / 2;
            int j = this.f / 2;
            byte[] arrayOfByte = this.r;
            int k = this.e;
            NativeLoad.nativeglTexImage2D(3553, 0, 6410, i, j, 0, 6410, 5121, arrayOfByte, this.f * k);
          }
          else if (2 == this.s)
          {
            r();
          }
        }
        else
        {
          GLES20.glPixelStorei(3317, 4);
        }
      }
      AppMethodBeat.o(15113);
      return;
      arrayOfInt = null;
    }
  }
  
  public int q()
  {
    AppMethodBeat.i(15114);
    if (2 == this.s)
    {
      i = r();
      GLES20.glBindTexture(3553, 0);
      AppMethodBeat.o(15114);
      return i;
    }
    int i = super.b(-1);
    AppMethodBeat.o(15114);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.k
 * JD-Core Version:    0.7.0.1
 */