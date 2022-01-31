package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.view.f;

public final class m$b
  extends m
{
  float x;
  float y;
  
  public m$b(String paramString, float paramFloat1, float paramFloat2)
  {
    super(paramString);
    this.x = paramFloat1;
    this.y = paramFloat2;
  }
  
  public final void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform2f(this.handle, this.x, this.y);
    f.checkGlError("Float2fParam setParams");
  }
  
  public final String toString()
  {
    return this.name + "=" + this.x + ", " + this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.m.b
 * JD-Core Version:    0.7.0.1
 */