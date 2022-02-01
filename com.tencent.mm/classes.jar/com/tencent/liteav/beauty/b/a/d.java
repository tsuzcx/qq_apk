package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.j;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  extends j
{
  private int r = -1;
  private int s = -1;
  private float t = 4.0F;
  private String u = "SmoothHorizontal";
  
  d()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(15000);
    super.a(paramInt1, paramInt2);
    if (paramInt1 > paramInt2) {
      if (paramInt2 < 540) {
        this.t = 2.0F;
      }
    }
    for (;;)
    {
      TXCLog.i(this.u, "m_textureRation " + this.t);
      a(this.r, this.t / paramInt1);
      a(this.s, this.t / paramInt2);
      AppMethodBeat.o(15000);
      return;
      this.t = 4.0F;
      continue;
      if (paramInt1 < 540) {
        this.t = 2.0F;
      } else {
        this.t = 4.0F;
      }
    }
  }
  
  public boolean a()
  {
    AppMethodBeat.i(14997);
    this.a = NativeLoad.nativeLoadGLProgram(13);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(14997);
      return bool;
    }
  }
  
  public boolean b()
  {
    AppMethodBeat.i(14998);
    super.b();
    r();
    AppMethodBeat.o(14998);
    return true;
  }
  
  public void r()
  {
    AppMethodBeat.i(233307);
    this.r = GLES20.glGetUniformLocation(q(), "texelWidthOffset");
    this.s = GLES20.glGetUniformLocation(q(), "texelHeightOffset");
    AppMethodBeat.o(233307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.d
 * JD-Core Version:    0.7.0.1
 */