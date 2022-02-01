package com.tencent.liteav.basic.opengl;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.FloatBuffer;

public class k
  extends j
{
  public boolean r;
  private float[] s;
  private int t;
  
  public k()
  {
    super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nuniform mat4 textureTransform;\nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = (textureTransform * inputTextureCoordinate).xy;\n}", "#extension GL_OES_EGL_image_external : require\n\nvarying lowp vec2 textureCoordinate;\n \nuniform samplerExternalOES inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    AppMethodBeat.i(230240);
    this.s = new float[16];
    this.r = false;
    this.o = true;
    AppMethodBeat.o(230240);
  }
  
  public void a(int paramInt, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(230278);
    GLES20.glUseProgram(this.a);
    k();
    if ((!n()) || (this.s == null))
    {
      AppMethodBeat.o(230278);
      return;
    }
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.b);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.d);
    GLES20.glUniformMatrix4fv(this.t, 1, false, this.s, 0);
    if (paramInt != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(36197, paramInt);
      GLES20.glUniform1i(this.c, 0);
    }
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.b);
    GLES20.glDisableVertexAttribArray(this.d);
    GLES20.glBindTexture(36197, 0);
    AppMethodBeat.o(230278);
  }
  
  public void a(float[] paramArrayOfFloat)
  {
    this.s = paramArrayOfFloat;
  }
  
  public boolean b()
  {
    AppMethodBeat.i(230248);
    boolean bool = super.b();
    this.t = GLES20.glGetUniformLocation(this.a, "textureTransform");
    if ((bool) && (GLES20.glGetError() == 0))
    {
      AppMethodBeat.o(230248);
      return true;
    }
    AppMethodBeat.o(230248);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.opengl.k
 * JD-Core Version:    0.7.0.1
 */