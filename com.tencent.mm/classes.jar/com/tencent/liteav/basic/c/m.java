package com.tencent.liteav.basic.c;

import android.graphics.SurfaceTexture;
import javax.microedition.khronos.egl.EGLContext;

public abstract interface m
{
  public abstract void a();
  
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2);
  
  public abstract void a(Runnable paramRunnable);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void a(byte[] paramArrayOfByte);
  
  public abstract EGLContext getGLContext();
  
  public abstract SurfaceTexture getSurfaceTexture();
  
  public abstract void setRendMirror(int paramInt);
  
  public abstract void setRendMode(int paramInt);
  
  public abstract void setSurfaceTextureListener(n paramn);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.basic.c.m
 * JD-Core Version:    0.7.0.1
 */