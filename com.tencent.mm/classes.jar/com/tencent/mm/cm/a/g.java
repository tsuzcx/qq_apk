package com.tencent.mm.cm.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class g
  extends a
{
  public int agCA;
  private ByteBuffer agCB;
  private boolean agCC;
  private boolean agCD;
  private boolean agCE;
  private boolean agCF;
  public boolean agCu;
  public int agCx;
  public int agCy;
  public int agCz;
  private Bitmap mBitmap;
  private int[] mFrameBuffer;
  
  public g(String paramString)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", paramString);
  }
  
  public g(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(231120);
    this.agCA = -1;
    this.agCu = false;
    this.agCC = false;
    this.agCD = false;
    this.agCE = false;
    this.agCF = false;
    a(i.agCH);
    AppMethodBeat.o(231120);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(231167);
    GLES20.glUseProgram(this.agBF);
    jLF();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
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
    if (paramInt2 != -1)
    {
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glUniform1i(this.agCy, 3);
    }
    GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.agBG);
    GLES20.glDisableVertexAttribArray(this.agBI);
    GLES20.glDisableVertexAttribArray(this.agCz);
    GLES20.glDisableVertexAttribArray(this.agCx);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(231167);
  }
  
  public void a(i parami)
  {
    AppMethodBeat.i(231173);
    parami = k.a(parami, false);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(parami);
    localFloatBuffer.flip();
    this.agCB = localByteBuffer;
    AppMethodBeat.o(231173);
  }
  
  public void apC()
  {
    AppMethodBeat.i(231132);
    super.apC();
    this.agCx = GLES20.glGetAttribLocation(jLG(), "inputTextureCoordinate2");
    this.agCy = GLES20.glGetUniformLocation(jLG(), "inputImageTexture2");
    GLES20.glEnableVertexAttribArray(this.agCx);
    if (this.agCu)
    {
      GLES20.glGenFramebuffers(1, this.mFrameBuffer, 0);
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, 1080, 1853, 6408, 5121, null);
      this.agCA = arrayOfInt[0];
    }
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      setBitmap(this.mBitmap);
    }
    AppMethodBeat.o(231132);
  }
  
  protected final void b(FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(231157);
    GLES20.glEnableVertexAttribArray(this.agCx);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.agCA);
    GLES20.glUniform1i(this.agCy, 2);
    paramFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(this.agCx, 2, 5126, false, 0, paramFloatBuffer);
    AppMethodBeat.o(231157);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(231149);
    super.onDestroy();
    GLES20.glDeleteTextures(1, new int[] { this.agCA }, 0);
    this.agCA = -1;
    if (this.mFrameBuffer != null)
    {
      GLES20.glDeleteFramebuffers(this.mFrameBuffer.length, this.mFrameBuffer, 0);
      this.mFrameBuffer = null;
    }
    AppMethodBeat.o(231149);
  }
  
  public void setBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(231141);
    if ((paramBitmap != null) && (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(231141);
      return;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap == null)
    {
      AppMethodBeat.o(231141);
      return;
    }
    bg(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231100);
        if (g.this.agCA == -1)
        {
          if ((paramBitmap == null) || (paramBitmap.isRecycled()))
          {
            AppMethodBeat.o(231100);
            return;
          }
          GLES20.glActiveTexture(33986);
          g.this.agCA = h.bh(paramBitmap);
        }
        AppMethodBeat.o(231100);
      }
    });
    AppMethodBeat.o(231141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cm.a.g
 * JD-Core Version:    0.7.0.1
 */