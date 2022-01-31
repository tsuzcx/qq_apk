package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.view.f;

public final class m$d
  extends m
{
  float x;
  float y;
  float z;
  
  public m$d(String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    super(paramString);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
  }
  
  public final void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform3f(this.handle, this.x, this.y, this.z);
    f.checkGlError("Float3fParam setParams");
  }
  
  public final String toString()
  {
    return this.name + "=" + this.x + ", " + this.y + ", " + this.z;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.filter.m.d
 * JD-Core Version:    0.7.0.1
 */