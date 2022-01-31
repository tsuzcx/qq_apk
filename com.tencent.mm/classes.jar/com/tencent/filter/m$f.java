package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.view.f;

public final class m$f
  extends m
{
  float value;
  
  public m$f(String paramString, float paramFloat)
  {
    super(paramString);
    this.value = paramFloat;
  }
  
  public final void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform1f(this.handle, this.value);
    f.checkGlError("FloatParam setParams");
  }
  
  public final String toString()
  {
    return this.name + "=" + this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.filter.m.f
 * JD-Core Version:    0.7.0.1
 */