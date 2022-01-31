package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c$a
  extends s
{
  private int x = -1;
  private int y = -1;
  private int z = -1;
  
  public c$a()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(66936);
    a(this.x, c.a(paramFloat));
    AppMethodBeat.o(66936);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66934);
    if ((this.f == paramInt2) && (this.e == paramInt1))
    {
      AppMethodBeat.o(66934);
      return;
    }
    super.a(paramInt1, paramInt2);
    this.x = GLES20.glGetUniformLocation(p(), "smoothDegree");
    this.y = GLES20.glGetUniformLocation(p(), "brightDegree");
    this.z = GLES20.glGetUniformLocation(p(), "ruddyDegree");
    AppMethodBeat.o(66934);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(66933);
    NativeLoad.getInstance();
    this.a = NativeLoad.nativeLoadGLProgram(1);
    if ((this.a != 0) && (b())) {}
    for (this.g = true;; this.g = false)
    {
      c();
      boolean bool = this.g;
      AppMethodBeat.o(66933);
      return bool;
    }
  }
  
  public void b(float paramFloat)
  {
    AppMethodBeat.i(66937);
    a(this.y, paramFloat / 3.0F);
    AppMethodBeat.o(66937);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(66935);
    boolean bool = super.b();
    AppMethodBeat.o(66935);
    return bool;
  }
  
  public void c(float paramFloat)
  {
    AppMethodBeat.i(66938);
    a(this.z, paramFloat / 10.0F / 2.0F);
    AppMethodBeat.o(66938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.c.a
 * JD-Core Version:    0.7.0.1
 */