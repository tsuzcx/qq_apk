package com.tencent.mm.ct.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class f
  extends g
{
  public int YGJ;
  public int YGK;
  public int YGL;
  public int YGM;
  public boolean YGN;
  private int[] YGO;
  private ByteBuffer YGP;
  private Bitmap mBitmap;
  
  public f(String paramString)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", paramString);
  }
  
  private f(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(188118);
    this.YGM = -1;
    this.YGN = true;
    a(i.YHb);
    AppMethodBeat.o(188118);
  }
  
  public void Pu()
  {
    AppMethodBeat.i(188119);
    super.Pu();
    this.YGL = GLES20.glGetAttribLocation(this.YFX, "position");
    this.YGJ = GLES20.glGetAttribLocation(igt(), "inputTextureCoordinate3");
    this.YGK = GLES20.glGetUniformLocation(igt(), "inputImageTexture3");
    GLES20.glEnableVertexAttribArray(this.YGJ);
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      setBitmap(this.mBitmap);
    }
    AppMethodBeat.o(188119);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(188125);
    GLES20.glUseProgram(this.YFX);
    igs();
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.YFY, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.YFY);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.YGa, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.YGa);
    if (paramInt1 != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(this.YFZ, 0);
    }
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.YGR, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.YGR);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(this.YGS, 2);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.YGJ, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.YGJ);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(this.YGK, 3);
    GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.YFY);
    GLES20.glDisableVertexAttribArray(this.YGa);
    GLES20.glDisableVertexAttribArray(this.YGT);
    GLES20.glDisableVertexAttribArray(this.YGR);
    GLES20.glDisableVertexAttribArray(this.YGL);
    GLES20.glDisableVertexAttribArray(this.YGJ);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(188125);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(188127);
    parami = k.a(parami, false);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(parami);
    localFloatBuffer.flip();
    this.YGP = localByteBuffer;
    AppMethodBeat.o(188127);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(188124);
    super.onDestroy();
    GLES20.glDeleteTextures(1, new int[] { this.YGM }, 0);
    this.YGM = -1;
    if (this.YGO != null)
    {
      GLES20.glDeleteFramebuffers(this.YGO.length, this.YGO, 0);
      this.YGO = null;
    }
    AppMethodBeat.o(188124);
  }
  
  public final void setBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(188121);
    if ((paramBitmap != null) && (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(188121);
      return;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap == null)
    {
      AppMethodBeat.o(188121);
      return;
    }
    aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188107);
        if (f.this.YGM == -1)
        {
          if ((paramBitmap == null) || (paramBitmap.isRecycled()))
          {
            AppMethodBeat.o(188107);
            return;
          }
          GLES20.glActiveTexture(33987);
          f.this.YGM = h.aN(paramBitmap);
        }
        AppMethodBeat.o(188107);
      }
    });
    AppMethodBeat.o(188121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ct.a.f
 * JD-Core Version:    0.7.0.1
 */