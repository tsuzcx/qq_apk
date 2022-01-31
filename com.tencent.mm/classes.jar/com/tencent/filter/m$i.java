package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.view.f;

public final class m$i
  extends m
{
  int value;
  
  public m$i(String paramString, int paramInt)
  {
    super(paramString);
    this.value = paramInt;
  }
  
  public final void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform1i(this.handle, this.value);
    f.checkGlError("IntParam setParams");
  }
  
  public final String toString()
  {
    return this.name + "=" + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.m.i
 * JD-Core Version:    0.7.0.1
 */