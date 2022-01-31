package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class d
  extends g
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
    AppMethodBeat.i(66954);
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
      AppMethodBeat.o(66954);
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
    AppMethodBeat.i(66951);
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(13);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(66951);
      return bool;
    }
  }
  
  public boolean b()
  {
    AppMethodBeat.i(66952);
    super.b();
    q();
    AppMethodBeat.o(66952);
    return true;
  }
  
  public void q()
  {
    AppMethodBeat.i(66953);
    this.r = GLES20.glGetUniformLocation(p(), "texelWidthOffset");
    this.s = GLES20.glGetUniformLocation(p(), "texelHeightOffset");
    AppMethodBeat.o(66953);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.d
 * JD-Core Version:    0.7.0.1
 */