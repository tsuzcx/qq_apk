package com.tencent.luggage.xweb_ext.extendplugin.b;

import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.luggage.xweb_ext.extendplugin.a;

public abstract interface c
{
  public abstract String a(String paramString, int paramInt, a parama);
  
  public abstract void a(com.tencent.luggage.xweb_ext.extendplugin.a.c paramc);
  
  public abstract void a(com.tencent.luggage.xweb_ext.extendplugin.c paramc);
  
  public abstract void onPluginDestroy(String paramString, int paramInt);
  
  public abstract void onPluginReady(String paramString, int paramInt, SurfaceTexture paramSurfaceTexture);
  
  public abstract void onPluginTouch(String paramString, int paramInt, MotionEvent paramMotionEvent);
  
  public abstract com.tencent.luggage.xweb_ext.extendplugin.c yi();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.b.c
 * JD-Core Version:    0.7.0.1
 */