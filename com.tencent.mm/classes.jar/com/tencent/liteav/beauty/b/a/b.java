package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.beauty.b.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  extends t
{
  private int r = -1;
  private int s = -1;
  private int t = -1;
  private final String x = "BeautyBlend";
  
  public b()
  {
    super("varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  private void q()
  {
    AppMethodBeat.i(66959);
    this.s = GLES20.glGetUniformLocation(p(), "whiteDegree");
    this.r = GLES20.glGetUniformLocation(p(), "contrast");
    this.t = GLES20.glGetUniformLocation(p(), "ruddyDegree");
    AppMethodBeat.o(66959);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(66957);
    TXCLog.i("BeautyBlend", "setBrightLevel ".concat(String.valueOf(paramFloat)));
    a(this.s, paramFloat);
    AppMethodBeat.o(66957);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(66955);
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(12);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(66955);
      return bool;
    }
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(66958);
    a(this.t, paramFloat / 2.0F);
    AppMethodBeat.o(66958);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(66956);
    super.b();
    q();
    AppMethodBeat.o(66956);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.a.b
 * JD-Core Version:    0.7.0.1
 */