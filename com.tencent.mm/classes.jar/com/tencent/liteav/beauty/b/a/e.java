package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCBuild;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class e
  extends t
{
  private String A = "SmoothVertical";
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private int x = -1;
  private float y = 2.0F;
  private float z = 0.5F;
  
  e()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(14994);
    this.z = paramFloat;
    TXCLog.i(this.A, "setBeautyLevel ".concat(String.valueOf(paramFloat)));
    a(this.t, paramFloat);
    AppMethodBeat.o(14994);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14996);
    super.a(paramInt1, paramInt2);
    if (paramInt1 > paramInt2) {
      if (paramInt2 < 540) {
        this.y = 2.0F;
      }
    }
    for (;;)
    {
      TXCLog.i(this.A, "m_textureRation " + this.y);
      a(this.r, this.y / paramInt1);
      a(this.s, this.y / paramInt2);
      AppMethodBeat.o(14996);
      return;
      this.y = 4.0F;
      continue;
      if (paramInt1 < 540) {
        this.y = 2.0F;
      } else {
        this.y = 4.0F;
      }
    }
  }
  
  public boolean a()
  {
    AppMethodBeat.i(14992);
    if ((TXCBuild.Brand().equals("samsung")) && (TXCBuild.Model().equals("GT-I9500")) && (TXCBuild.Version().equals("4.3")))
    {
      this.a = NativeLoad.nativeLoadGLProgram(15);
      if ((this.a == 0) || (!b())) {
        break label95;
      }
    }
    label95:
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(14992);
      return bool;
      this.a = NativeLoad.nativeLoadGLProgram(5);
      break;
    }
  }
  
  public boolean b()
  {
    AppMethodBeat.i(14993);
    super.b();
    r();
    AppMethodBeat.o(14993);
    return true;
  }
  
  public void r()
  {
    AppMethodBeat.i(229770);
    this.r = GLES20.glGetUniformLocation(q(), "texelWidthOffset");
    this.s = GLES20.glGetUniformLocation(q(), "texelHeightOffset");
    this.t = GLES20.glGetUniformLocation(q(), "smoothDegree");
    AppMethodBeat.o(229770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.e
 * JD-Core Version:    0.7.0.1
 */