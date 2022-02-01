package com.tencent.mm.ct.a;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class g
  extends a
{
  public boolean YGN;
  private int[] YGO;
  public int YGR;
  public int YGS;
  public int YGT;
  public int YGU;
  private ByteBuffer YGV;
  private boolean YGW;
  private boolean YGX;
  private boolean YGY;
  private boolean YGZ;
  private Bitmap mBitmap;
  
  public g(String paramString)
  {
    this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n}", paramString);
  }
  
  public g(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
    AppMethodBeat.i(188138);
    this.YGU = -1;
    this.YGN = false;
    this.YGW = false;
    this.YGX = false;
    this.YGY = false;
    this.YGZ = false;
    a(i.YHb);
    AppMethodBeat.o(188138);
  }
  
  public void Pu()
  {
    AppMethodBeat.i(188141);
    super.Pu();
    this.YGR = GLES20.glGetAttribLocation(igt(), "inputTextureCoordinate2");
    this.YGS = GLES20.glGetUniformLocation(igt(), "inputImageTexture2");
    GLES20.glEnableVertexAttribArray(this.YGR);
    if (this.YGN)
    {
      GLES20.glGenFramebuffers(1, this.YGO, 0);
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      GLES20.glBindTexture(3553, arrayOfInt[0]);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexSubImage2D(3553, 0, 0, 0, 1080, 1853, 6408, 5121, null);
      this.YGU = arrayOfInt[0];
    }
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled())) {
      setBitmap(this.mBitmap);
    }
    AppMethodBeat.o(188141);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, FloatBuffer paramFloatBuffer1, FloatBuffer paramFloatBuffer2)
  {
    AppMethodBeat.i(188153);
    GLES20.glUseProgram(this.YFX);
    igs();
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    GLES20.glClear(16384);
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
    if (paramInt2 != -1)
    {
      GLES20.glActiveTexture(33987);
      GLES20.glBindTexture(3553, paramInt2);
      GLES20.glUniform1i(this.YGS, 3);
    }
    GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(this.YFY);
    GLES20.glDisableVertexAttribArray(this.YGa);
    GLES20.glDisableVertexAttribArray(this.YGT);
    GLES20.glDisableVertexAttribArray(this.YGR);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(188153);
  }
  
  public void a(i parami)
  {
    AppMethodBeat.i(188155);
    parami = k.a(parami, false);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    FloatBuffer localFloatBuffer = localByteBuffer.asFloatBuffer();
    localFloatBuffer.put(parami);
    localFloatBuffer.flip();
    this.YGV = localByteBuffer;
    AppMethodBeat.o(188155);
  }
  
  protected final void b(FloatBuffer paramFloatBuffer)
  {
    AppMethodBeat.i(188151);
    GLES20.glEnableVertexAttribArray(this.YGR);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, this.YGU);
    GLES20.glUniform1i(this.YGS, 2);
    paramFloatBuffer.position(0);
    GLES20.glVertexAttribPointer(this.YGR, 2, 5126, false, 0, paramFloatBuffer);
    AppMethodBeat.o(188151);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(188149);
    super.onDestroy();
    GLES20.glDeleteTextures(1, new int[] { this.YGU }, 0);
    this.YGU = -1;
    if (this.YGO != null)
    {
      GLES20.glDeleteFramebuffers(this.YGO.length, this.YGO, 0);
      this.YGO = null;
    }
    AppMethodBeat.o(188149);
  }
  
  public void setBitmap(final Bitmap paramBitmap)
  {
    AppMethodBeat.i(188145);
    if ((paramBitmap != null) && (paramBitmap.isRecycled()))
    {
      AppMethodBeat.o(188145);
      return;
    }
    this.mBitmap = paramBitmap;
    if (this.mBitmap == null)
    {
      AppMethodBeat.o(188145);
      return;
    }
    aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188132);
        if (g.this.YGU == -1)
        {
          if ((paramBitmap == null) || (paramBitmap.isRecycled()))
          {
            AppMethodBeat.o(188132);
            return;
          }
          GLES20.glActiveTexture(33986);
          g.this.YGU = h.aN(paramBitmap);
        }
        AppMethodBeat.o(188132);
      }
    });
    AppMethodBeat.o(188145);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ct.a.g
 * JD-Core Version:    0.7.0.1
 */