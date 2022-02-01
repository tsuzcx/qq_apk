package com.tencent.mm.cm.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class h
  extends a
{
  public boolean RfT;
  private int[] RfU;
  public int RfX;
  public int RfY;
  public int RfZ;
  public int Rga;
  private ByteBuffer Rgb;
  private boolean Rgc;
  private boolean Rgd;
  private boolean Rge;
  private boolean Rgf;
  private Bitmap mBitmap;
  
  public h(String paramString)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", paramString);
  }
  
  public h(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(190261);
    this.Rga = -1;
    this.RfT = false;
    this.Rgc = false;
    this.Rgd = false;
    this.Rge = false;
    this.Rgf = false;
    a(j.Rgh);
    AppMethodBeat.o(190261);
  }
  
  public void MC()
  {
    AppMethodBeat.i(190262);
    super.MC();
    this.RfX = GLES20.glGetAttribLocation(hfa(), "inputTextureCoordinate2");
    this.RfY = GLES20.glGetUniformLocation(hfa(), "inputImageTexture2");
    GLES20.glEnableVertexAttribArray(this.RfX);
    if (this.RfT)
    {
      GLES20.glGenFramebuffers(1, this.RfU, 0);
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, 1080, 1853, 6408, 5121, null);
      this.Rga = arrayOfInt[0];
    }
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      setBitmap(this.mBitmap);
    }
    AppMethodBeat.o(190262);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(190266);
    GLES20.glUseProgram(this.Rfd);
    heZ();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
    paramFloatBuffer1.position(0);
    GLES20.glVertexAttribPointer(this.Rfe, 2, 5126, false, 0, paramFloatBuffer1);
    GLES20.glEnableVertexAttribArray(this.Rfe);
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.Rfg, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.Rfg);
    if (paramInt1 != -1)
    {
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt1);
      GLES20.glUniform1i(this.Rff, 0);
    }
    paramFloatBuffer2.position(0);
    GLES20.glVertexAttribPointer(this.RfX, 2, 5126, false, 0, paramFloatBuffer2);
    GLES20.glEnableVertexAttribArray(this.RfX);
    if (paramInt2 != -1)
    {
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glUniform1i(this.RfY, 3);
    }
    GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.Rfe);
    GLES20.glDisableVertexAttribArray(this.Rfg);
    GLES20.glDisableVertexAttribArray(this.RfZ);
    GLES20.glDisableVertexAttribArray(this.RfX);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(190266);
  }
  
  public void a(j paramj)
  {
    AppMethodBeat.i(190267);
    paramj = l.a(paramj, false);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(paramj);
    localFloatBuffer.flip();
    this.Rgb = localByteBuffer;
    AppMethodBeat.o(190267);
  }
  
  protected final void b(FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(190265);
    GLES20.glEnableVertexAttribArray(this.RfX);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.Rga);
    GLES20.glUniform1i(this.RfY, 2);
    paramFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(this.RfX, 2, 5126, false, 0, paramFloatBuffer);
    AppMethodBeat.o(190265);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(190264);
    super.onDestroy();
    GLES20.glDeleteTextures(1, new int[] { this.Rga }, 0);
    this.Rga = -1;
    if (this.RfU != null)
    {
      GLES20.glDeleteFramebuffers(this.RfU.length, this.RfU, 0);
      this.RfU = null;
    }
    AppMethodBeat.o(190264);
  }
  
  public void setBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(190263);
    if ((paramBitmap != null) && (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(190263);
      return;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap == null)
    {
      AppMethodBeat.o(190263);
      return;
    }
    aR(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(190260);
        if (h.this.Rga == -1)
        {
          if ((paramBitmap == null) || (paramBitmap.isRecycled()))
          {
            AppMethodBeat.o(190260);
            return;
          }
          GLES20.glActiveTexture(33986);
          h.this.Rga = i.aO(paramBitmap);
        }
        AppMethodBeat.o(190260);
      }
    });
    AppMethodBeat.o(190263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cm.a.h
 * JD-Core Version:    0.7.0.1
 */