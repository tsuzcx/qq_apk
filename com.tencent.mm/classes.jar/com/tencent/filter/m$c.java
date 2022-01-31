package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.view.f;

public final class m$c
  extends m
{
  float[] bfT;
  
  public m$c(String paramString, float[] paramArrayOfFloat)
  {
    super(paramString);
    this.bfT = new float[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      this.bfT[i] = paramArrayOfFloat[i];
      i += 1;
    }
  }
  
  public final void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform2fv(this.handle, this.bfT.length / 2, this.bfT, 0);
    f.checkGlError("Float2sParam setParams");
  }
  
  public final String toString()
  {
    return this.name + "=" + this.bfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.m.c
 * JD-Core Version:    0.7.0.1
 */