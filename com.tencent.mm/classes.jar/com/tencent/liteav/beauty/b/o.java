package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o
  extends h
{
  private static float[] C = { 0.1826F, 0.6142F, 0.062F, -0.1006F, -0.3386F, 0.4392F, 0.4392F, -0.3989F, -0.0403F };
  private static float[] D = { 0.256816F, 0.504154F, 0.0979137F, -0.148246F, -0.29102F, 0.439266F, 0.439271F, -0.367833F, -0.071438F };
  private static float[] E = { 0.0625F, 0.5F, 0.5F };
  private String A = "RGBA2I420Filter";
  private int B = 1;
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private int u = -1;
  private int v = -1;
  private int w = -1;
  private int x = -1;
  private int y = -1;
  private int z = -1;
  
  public o(int paramInt)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    this.B = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15061);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      TXCLog.e(this.A, "width or height is error!");
      AppMethodBeat.o(15061);
      return;
    }
    if ((this.f == paramInt2) && (this.e == paramInt1))
    {
      AppMethodBeat.o(15061);
      return;
    }
    super.a(paramInt1, paramInt2);
    TXCLog.i(this.A, "RGBA2I420Filter width " + paramInt1 + " height " + paramInt2);
    a(this.r, paramInt1);
    a(this.s, paramInt2);
    AppMethodBeat.o(15061);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(15059);
    if (1 == this.B)
    {
      NativeLoad.getInstance();
      this.a = NativeLoad.nativeLoadGLProgram(8);
      TXCLog.i(this.A, "RGB-->I420 init!");
      if ((this.a == 0) || (!b())) {
        break label182;
      }
    }
    label182:
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(15059);
      return bool;
      if (3 == this.B)
      {
        TXCLog.i(this.A, "RGB-->NV21 init!");
        NativeLoad.getInstance();
        this.a = NativeLoad.nativeLoadGLProgram(11);
        break;
      }
      if (2 == this.B)
      {
        TXCLog.i(this.A, "RGBA Format init!");
        bool = super.a();
        AppMethodBeat.o(15059);
        return bool;
      }
      TXCLog.i(this.A, "don't support format " + this.B + " use default I420");
      NativeLoad.getInstance();
      this.a = NativeLoad.nativeLoadGLProgram(8);
      break;
    }
  }
  
  public boolean b()
  {
    AppMethodBeat.i(15060);
    super.b();
    this.r = GLES20.glGetUniformLocation(this.a, "width");
    this.s = GLES20.glGetUniformLocation(this.a, "height");
    AppMethodBeat.o(15060);
    return true;
  }
  
  public void c()
  {
    AppMethodBeat.i(15062);
    super.c();
    AppMethodBeat.o(15062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.o
 * JD-Core Version:    0.7.0.1
 */