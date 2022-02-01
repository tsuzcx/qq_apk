package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class h
  extends com.tencent.liteav.basic.c.h
{
  private int r;
  private float s;
  
  public h()
  {
    this(1.2F);
  }
  
  public h(float paramFloat)
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \n uniform sampler2D inputImageTexture;\n uniform lowp float gamma;\n \n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     \n     gl_FragColor = vec4(pow(textureColor.rgb, vec3(gamma)), textureColor.w);\n }");
    this.s = paramFloat;
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(15089);
    this.s = paramFloat;
    a(this.r, this.s);
    AppMethodBeat.o(15089);
  }
  
  public boolean b()
  {
    AppMethodBeat.i(15087);
    boolean bool = super.b();
    this.r = GLES20.glGetUniformLocation(p(), "gamma");
    AppMethodBeat.o(15087);
    return bool;
  }
  
  public void c()
  {
    AppMethodBeat.i(15088);
    super.c();
    a(this.s);
    AppMethodBeat.o(15088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.h
 * JD-Core Version:    0.7.0.1
 */