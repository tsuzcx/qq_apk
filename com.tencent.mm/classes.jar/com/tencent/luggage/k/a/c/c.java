package com.tencent.luggage.k.a.c;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.k.a.a;

public abstract interface c
{
  public abstract com.tencent.luggage.k.a.c Fr();
  
  public abstract String a(String paramString, int paramInt, a parama);
  
  public abstract void a(com.tencent.luggage.k.a.b.c paramc);
  
  public abstract void a(com.tencent.luggage.k.a.c paramc);
  
  public abstract void m(String paramString, int paramInt);
  
  public abstract void onPluginDestroy(String paramString, int paramInt);
  
  public abstract void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture);
  
  public abstract void onPluginScreenshotTaken(String paramString, int paramInt, Bitmap paramBitmap);
  
  public abstract void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.k.a.c.c
 * JD-Core Version:    0.7.0.1
 */