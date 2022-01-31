package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.view.f;

public final class m$g
  extends m
{
  float[] bfT;
  
  public m$g(String paramString, float[] paramArrayOfFloat)
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
    switch (this.bfT.length)
    {
    default: 
      GLES20.glUniform1fv(this.handle, this.bfT.length, this.bfT, 0);
    }
    for (;;)
    {
      f.checkGlError("FloatsParam setParams");
      return;
      GLES20.glUniform1f(this.handle, this.bfT[0]);
      continue;
      GLES20.glUniform2fv(this.handle, 1, this.bfT, 0);
      continue;
      GLES20.glUniform3fv(this.handle, 1, this.bfT, 0);
      continue;
      GLES20.glUniform4fv(this.handle, 1, this.bfT, 0);
      continue;
      GLES20.glUniformMatrix3fv(this.handle, 1, false, this.bfT, 0);
      continue;
      GLES20.glUniformMatrix4fv(this.handle, 1, false, this.bfT, 0);
    }
  }
  
  public final String toString()
  {
    return this.name + "=" + this.bfT.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.m.g
 * JD-Core Version:    0.7.0.1
 */