package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.view.f;

public final class m$e
  extends m
{
  float w;
  float x;
  float y;
  float z;
  
  public m$e(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    super(paramString);
    this.x = paramFloat1;
    this.y = paramFloat2;
    this.z = paramFloat3;
    this.w = paramFloat4;
  }
  
  public final void setParams(int paramInt)
  {
    if (this.handle < 0) {
      return;
    }
    GLES20.glUniform4f(this.handle, this.x, this.y, this.z, this.w);
    f.checkGlError("Float4fParam setParams");
  }
  
  public final String toString()
  {
    return this.name + "=" + this.x + ", " + this.y + ", " + this.z + ", " + this.w;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.m.e
 * JD-Core Version:    0.7.0.1
 */