package com.tencent.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.util.d;

public final class m$l
  extends m.n
{
  public Bitmap bfV = null;
  public boolean update;
  
  public m$l(String paramString)
  {
    super(paramString, 0, 33987);
    boolean bool1 = bool2;
    if (this.bfV != null)
    {
      bool1 = bool2;
      if (!this.bfV.isRecycled()) {
        bool1 = true;
      }
    }
    this.update = bool1;
  }
  
  public final void clear()
  {
    GLES20.glActiveTexture(this.bfX);
    d.cRj().z(this.texture);
    super.clear();
  }
  
  public final void initialParams(int paramInt)
  {
    super.initialParams(paramInt);
    GLES20.glActiveTexture(this.bfX);
    d.cRj().y(this.texture);
  }
  
  public final void setParams(int paramInt)
  {
    if (this.update)
    {
      GLES20.glActiveTexture(this.bfX);
      GLES20.glBindTexture(3553, this.texture[0]);
    }
    try
    {
      GLUtils.texImage2D(3553, 0, this.bfV, 0);
      label38:
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      super.setParams(paramInt);
      this.update = false;
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.filter.m.l
 * JD-Core Version:    0.7.0.1
 */