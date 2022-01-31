package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.view.f;

public final class m$h
  extends m
{
  int[] value = new int[0];
  
  public m$h(String paramString)
  {
    super(paramString);
  }
  
  public final void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform1iv(this.handle, this.value.length, this.value, 0);
    f.checkGlError("FloatParam setParams");
  }
  
  public final String toString()
  {
    return this.name + "=" + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.filter.m.h
 * JD-Core Version:    0.7.0.1
 */