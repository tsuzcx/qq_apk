package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class k
  extends j
{
  private static String y = "YUV420pToRGBFilter";
  private ByteBuffer r;
  private final int s;
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
    this.t = null;
    this.u = null;
    this.v = 0;
    this.w = 0;
    this.x = null;
    this.s = paramInt;
    TXCLog.i(y, "yuv Type ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(15110);
  }
  
  private int s()
  {
    AppMethodBeat.i(229855);
    GLES20.glBindTexture(3553, this.x[0]);
    if (this.r != null) {
      GLES20.glTexImage2D(3553, 0, 6408, this.e, this.f, 0, 6408, 5121, this.r);
    }
    int i = this.x[0];
    AppMethodBeat.o(229855);
    return i;
  }
  
  private void t()
  {
    AppMethodBeat.i(229858);
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
    if ((this.x != null) && (this.x[0] > 0))
    {
      GLES20.glDeleteTextures(1, this.x, 0);
      this.x = null;
    }
    AppMethodBeat.o(229858);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15112);
    if ((this.f == paramInt2) && (this.e == paramInt1))
    {
      AppMethodBeat.o(15112);
      return;
    }
    t();
    if (this.t == null)
    {
      this.t = new int[1];
      this.t[0] = TXCOpenGlUtils.a(paramInt1, paramInt2, 6409, 6409, this.t);
    }
    this.v = GLES20.glGetUniformLocation(q(), "yTexture");
    this.w = GLES20.glGetUniformLocation(q(), "uvTexture");
    if (1 == this.s)
    {
      this.u = new int[1];
      this.u[0] = TXCOpenGlUtils.a(paramInt1, paramInt2 / 2, 6409, 6409, this.u);
    }
    for (;;)
    {
      super.a(paramInt1, paramInt2);
      AppMethodBeat.o(15112);
      return;
      if (3 == this.s)
      {
        this.v = GLES20.glGetUniformLocation(q(), "yTexture");
        this.w = GLES20.glGetUniformLocation(q(), "uvTexture");
        this.u = new int[1];
        this.u[0] = TXCOpenGlUtils.a(paramInt1 / 2, paramInt2 / 2, 6410, 6410, this.u);
      }
      else if ((2 == this.s) && (this.x == null))
      {
        this.x = new int[1];
        this.x[0] = TXCOpenGlUtils.a(paramInt1, paramInt2, 6408, 6408, this.x);
      }
    }
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(15116);
    super.a(-1, paramFloatBuffer1, paramFloatBuffer2);
    AppMethodBeat.o(15116);
  }
  
  public void a(ByteBuffer paramByteBuffer)
  {
    this.r = paramByteBuffer;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(229872);
    if (paramArrayOfByte != null) {
      this.r = ByteBuffer.wrap(paramArrayOfByte);
    }
    AppMethodBeat.o(229872);
  }
  
  public boolean a()
  {
    int i = 7;
    AppMethodBeat.i(15111);
    if (this.s == 1)
    {
      this.a = NativeLoad.nativeLoadGLProgram(i);
      if ((this.a == 0) || (!b())) {
        break label124;
      }
    }
    label124:
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
    t();
    AppMethodBeat.o(15118);
  }
  
  public void i()
  {
    AppMethodBeat.i(15113);
    super.i();
    int[] arrayOfInt = null;
    if (this.e % 4 != 0)
    {
      arrayOfInt = new int[1];
      GLES20.glGetIntegerv(3317, arrayOfInt, 0);
      GLES20.glPixelStorei(3317, 1);
    }
    if (2 == this.s)
    {
      s();
      if (this.e % 4 == 0) {
        break label206;
      }
      if ((arrayOfInt != null) && (arrayOfInt[0] > 0))
      {
        GLES20.glPixelStorei(3317, arrayOfInt[0]);
        AppMethodBeat.o(15113);
      }
    }
    else
    {
      ByteBuffer localByteBuffer = this.r;
      if (this.s == 1) {}
      for (int i = 6409;; i = 6410)
      {
        TXCOpenGlUtils.a(localByteBuffer, i, this.e, this.f, new int[] { this.t[0], this.u[0] });
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.t[0]);
        GLES20.glUniform1i(this.v, 0);
        GLES20.glActiveTexture(33985);
        GLES20.glBindTexture(3553, this.u[0]);
        GLES20.glUniform1i(this.w, 1);
        break;
      }
    }
    GLES20.glPixelStorei(3317, 4);
    label206:
    AppMethodBeat.o(15113);
  }
  
  public int r()
  {
    AppMethodBeat.i(15115);
    if (2 == this.s)
    {
      i = s();
      GLES20.glBindTexture(3553, 0);
      AppMethodBeat.o(15115);
      return i;
    }
    int i = super.b(-1);
    AppMethodBeat.o(15115);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.k
 * JD-Core Version:    0.7.0.1
 */