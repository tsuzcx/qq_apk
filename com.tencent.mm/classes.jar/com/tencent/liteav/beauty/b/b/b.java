package com.tencent.liteav.beauty.b.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b
  extends g
{
  private int r;
  private int s;
  private float[] t;
  private String u;
  
  public b()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    AppMethodBeat.i(67007);
    this.r = -1;
    this.s = -1;
    this.t = new float[4];
    this.u = "Beauty3Filter";
    AppMethodBeat.o(67007);
  }
  
  private void b(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(67015);
    c(this.s, paramArrayOfFloat);
    AppMethodBeat.o(67015);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(67012);
    this.t[0] = paramFloat;
    b(this.t);
    AppMethodBeat.o(67012);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(67011);
    super.a(paramInt1, paramInt2);
    c(paramInt1, paramInt2);
    AppMethodBeat.o(67011);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(67008);
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(14);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(67008);
      return bool;
    }
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(67013);
    this.t[1] = paramFloat;
    b(this.t);
    AppMethodBeat.o(67013);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(67009);
    boolean bool = super.b();
    this.r = GLES20.glGetUniformLocation(p(), "singleStepOffset");
    this.s = GLES20.glGetUniformLocation(p(), "beautyParams");
    a(5.0F);
    AppMethodBeat.o(67009);
    return bool;
  }
  
  public void c(float paramFloat)
  {
    AppMethodBeat.i(67014);
    this.t[2] = paramFloat;
    b(this.t);
    AppMethodBeat.o(67014);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(146362);
    a(this.r, new float[] { 2.0F / paramInt1, 2.0F / paramInt2 });
    AppMethodBeat.o(146362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.b.b
 * JD-Core Version:    0.7.0.1
 */