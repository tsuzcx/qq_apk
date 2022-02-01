package com.tencent.mm.cm.a;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  int Gxi = -1;
  int Rfu = -1;
  
  public final void lU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(190234);
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = 1;
    GLES20.glGenFramebuffers(1, arrayOfInt1, 0);
    int[] arrayOfInt2 = new int[1];
    GLES20.glGenTextures(1, arrayOfInt2, 0);
    GLES20.glBindTexture(3553, arrayOfInt2[0]);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    this.Gxi = arrayOfInt2[0];
    GLES20.glBindTexture(3553, this.Gxi);
    GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.Gxi, 0);
    GLES20.glCheckFramebufferStatus(36160);
    GLES20.glBindTexture(3553, 0);
    this.Rfu = arrayOfInt1[0];
    AppMethodBeat.o(190234);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cm.a.c
 * JD-Core Version:    0.7.0.1
 */