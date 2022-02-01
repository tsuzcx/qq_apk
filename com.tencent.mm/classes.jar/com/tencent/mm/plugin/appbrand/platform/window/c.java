package com.tencent.mm.plugin.appbrand.platform.window;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.m;

public abstract interface c
  extends m, g, Comparable<c>
{
  public abstract boolean RZ();
  
  public abstract d a(d.b paramb);
  
  public abstract void a(int paramInt, AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime);
  
  public abstract boolean bCS();
  
  public abstract boolean bCZ();
  
  public abstract Context getContext();
  
  public abstract e getOrientationHandler();
  
  public abstract Rect getSafeAreaInsets();
  
  public abstract DisplayMetrics getVDisplayMetrics();
  
  @Deprecated
  public abstract void setSoftOrientation(String paramString);
  
  public abstract void setWindowDescription(a parama);
  
  public static class a
  {
    public final int colorPrimary;
    public final String label;
    public final Bitmap qGu;
    public final int qpN;
    
    public a(String paramString)
    {
      this(paramString, null, 0);
    }
    
    public a(String paramString, Bitmap paramBitmap, int paramInt)
    {
      this.label = paramString;
      this.qGu = paramBitmap;
      this.qpN = -1;
      this.colorPrimary = paramInt;
    }
  }
  
  public static class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.c
 * JD-Core Version:    0.7.0.1
 */