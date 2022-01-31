package com.tencent.filter;

import android.opengl.GLES20;
import com.tencent.view.f;

public class m$n
  extends m
{
  int bfX;
  int[] texture = { 0 };
  
  public m$n(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.bfX = paramInt2;
    this.texture[0] = paramInt1;
  }
  
  public void clear()
  {
    super.clear();
    this.texture[0] = 0;
  }
  
  public void setParams(int paramInt)
  {
    int i = 0;
    if ((this.handle < 0) || (this.texture[0] == 0)) {
      return;
    }
    GLES20.glActiveTexture(this.bfX);
    GLES20.glBindTexture(3553, this.texture[0]);
    paramInt = i;
    switch (this.bfX)
    {
    default: 
      paramInt = i;
    }
    for (;;)
    {
      GLES20.glUniform1i(this.handle, paramInt);
      f.checkGlError("TextureParam setParams");
      return;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
      continue;
      paramInt = 6;
      continue;
      paramInt = 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.filter.m.n
 * JD-Core Version:    0.7.0.1
 */