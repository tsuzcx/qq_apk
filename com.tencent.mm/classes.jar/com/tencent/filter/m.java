package com.tencent.filter;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.util.d;
import com.tencent.view.f;

public abstract class m
{
  public int handle;
  public String name;
  
  public m(String paramString)
  {
    this.name = paramString;
    this.handle = -1;
  }
  
  public void clear() {}
  
  public void initialParams(int paramInt)
  {
    this.handle = GLES20.glGetUniformLocation(paramInt, this.name);
  }
  
  public abstract void setParams(int paramInt);
  
  public String toString()
  {
    return this.name;
  }
  
  public static final class a
    extends m
  {
    float[] bfT;
    
    public a(String paramString, float[] paramArrayOfFloat)
    {
      super();
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
      GLES20.glUniform1fv(this.handle, this.bfT.length, this.bfT, 0);
      f.checkGlError("FloatParam setParams");
    }
    
    public final String toString()
    {
      return this.name + "=" + this.bfT;
    }
  }
  
  public static final class j
    extends m
  {
    private final float[] bfU;
    
    public j(String paramString, float[] paramArrayOfFloat)
    {
      super();
      this.bfU = paramArrayOfFloat;
    }
    
    public final void setParams(int paramInt)
    {
      GLES20.glUniformMatrix4fv(this.handle, 1, false, this.bfU, 0);
    }
  }
  
  public static final class k
    extends m.n
  {
    Bitmap bfV;
    boolean bfW = false;
    
    public k(String paramString, Bitmap paramBitmap, int paramInt, boolean paramBoolean)
    {
      super(0, paramInt);
      this.bfW = paramBoolean;
      this.bfV = paramBitmap;
    }
    
    public final void clear()
    {
      GLES20.glActiveTexture(this.bfX);
      d.cRj().z(this.texture);
      super.clear();
      if ((this.bfW) && (this.bfV != null))
      {
        this.bfV.recycle();
        this.bfV = null;
      }
    }
    
    public final void g(Bitmap paramBitmap)
    {
      if ((this.bfW) && (this.bfV != null) && (!this.bfV.isRecycled())) {
        this.bfV.recycle();
      }
      this.bfV = paramBitmap;
      if ((this.bfV == null) || (this.bfV.isRecycled())) {
        return;
      }
      GLES20.glActiveTexture(this.bfX);
      GLES20.glBindTexture(3553, this.texture[0]);
      GLUtils.texImage2D(3553, 0, this.bfV, 0);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
    }
    
    public final void initialParams(int paramInt)
    {
      super.initialParams(paramInt);
      if ((this.bfV == null) || (this.bfV.isRecycled())) {
        return;
      }
      GLES20.glActiveTexture(this.bfX);
      d.cRj().y(this.texture);
      GLES20.glBindTexture(3553, this.texture[0]);
      GLUtils.texImage2D(3553, 0, this.bfV, 0);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.filter.m
 * JD-Core Version:    0.7.0.1
 */