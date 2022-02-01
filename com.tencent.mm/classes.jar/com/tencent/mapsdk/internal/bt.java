package com.tencent.mapsdk.internal;

import android.view.MotionEvent;
import android.view.View;

public abstract interface bt
{
  public abstract void a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(Object paramObject, int paramInt1, int paramInt2);
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract boolean e();
  
  public abstract int getHeight();
  
  public abstract View getView();
  
  public abstract int getWidth();
  
  public abstract void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean onTouchEvent(MotionEvent paramMotionEvent);
  
  public abstract void setMapOpaque(boolean paramBoolean);
  
  public abstract void setZOrderMediaOverlay(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bt
 * JD-Core Version:    0.7.0.1
 */