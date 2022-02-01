package com.tencent.mm.cm.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class f
  extends g
{
  public int agCq;
  public int agCr;
  public int agCs;
  public int agCt;
  public boolean agCu;
  private ByteBuffer agCv;
  private Bitmap mBitmap;
  private int[] mFrameBuffer;
  
  public f(String paramString)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", paramString);
  }
  
  private f(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(231139);
    this.agCt = -1;
    this.agCu = true;
    a(i.agCH);
    AppMethodBeat.o(231139);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(231171);
    GLES20.glUseProgram(this.agBF);
    jLF();
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.agBG, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.agBG);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.agBI, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.agBI);
    if (paramInt1 != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(this.agBH, 0);
    }
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.agCx, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.agCx);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, paramInt2);
    GLES20.glUniform1i(this.agCy, 2);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.agCq, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.agCq);
    GLES20.glActiveTexture(33987);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(this.agCr, 3);
    GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.agBG);
    GLES20.glDisableVertexAttribArray(this.agBI);
    GLES20.glDisableVertexAttribArray(this.agCz);
    GLES20.glDisableVertexAttribArray(this.agCx);
    GLES20.glDisableVertexAttribArray(this.agCs);
    GLES20.glDisableVertexAttribArray(this.agCq);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(231171);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(231176);
    parami = k.a(parami, false);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(parami);
    localFloatBuffer.flip();
    this.agCv = localByteBuffer;
    AppMethodBeat.o(231176);
  }
  
  public void apC()
  {
    AppMethodBeat.i(231147);
    super.apC();
    this.agCs = GLES20.glGetAttribLocation(this.agBF, "position");
    this.agCq = GLES20.glGetAttribLocation(jLG(), "inputTextureCoordinate3");
    this.agCr = GLES20.glGetUniformLocation(jLG(), "inputImageTexture3");
    GLES20.glEnableVertexAttribArray(this.agCq);
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      setBitmap(this.mBitmap);
    }
    AppMethodBeat.o(231147);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(231163);
    super.onDestroy();
    GLES20.glDeleteTextures(1, new int[] { this.agCt }, 0);
    this.agCt = -1;
    if (this.mFrameBuffer != null)
    {
      GLES20.glDeleteFramebuffers(this.mFrameBuffer.length, this.mFrameBuffer, 0);
      this.mFrameBuffer = null;
    }
    AppMethodBeat.o(231163);
  }
  
  public final void setBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(231156);
    if ((paramBitmap != null) && (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(231156);
      return;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap == null)
    {
      AppMethodBeat.o(231156);
      return;
    }
    bg(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231148);
        if (f.this.agCt == -1)
        {
          if ((paramBitmap == null) || (paramBitmap.isRecycled()))
          {
            AppMethodBeat.o(231148);
            return;
          }
          GLES20.glActiveTexture(33987);
          f.this.agCt = h.bh(paramBitmap);
        }
        AppMethodBeat.o(231148);
      }
    });
    AppMethodBeat.o(231156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.f
 * JD-Core Version:    0.7.0.1
 */