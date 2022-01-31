package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.basic.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class l
  extends g
{
  private static String r = "attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nuniform int  bTransform;\nuniform mat4 textureTransform;\n\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n     gl_Position = position;\n    if (0 != bTransform){\n        textureCoordinate =  (textureTransform * inputTextureCoordinate).xy;\n    }else{\n        textureCoordinate = inputTextureCoordinate.xy;\n    }\n}\n";
  private int s = -1;
  private boolean t = false;
  
  public l()
  {
    this(r, "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
  }
  
  public l(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramString2, paramBoolean);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(146380);
    if (paramArrayOfFloat != null) {
      b(this.s, 1);
    }
    for (;;)
    {
      super.a(paramArrayOfFloat);
      AppMethodBeat.o(146380);
      return;
      b(this.s, 0);
    }
  }
  
  public boolean b()
  {
    AppMethodBeat.i(66940);
    boolean bool = super.b();
    this.s = GLES20.glGetUniformLocation(this.a, "bTransform");
    b(this.s, 0);
    AppMethodBeat.o(66940);
    return bool;
  }
  
  public void c(boolean paramBoolean)
  {
    AppMethodBeat.i(146381);
    if (paramBoolean != this.t)
    {
      this.t = paramBoolean;
      h();
    }
    AppMethodBeat.o(146381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.liteav.beauty.b.l
 * JD-Core Version:    0.7.0.1
 */