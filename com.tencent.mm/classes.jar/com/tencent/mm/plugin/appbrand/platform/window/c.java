package com.tencent.mm.plugin.appbrand.platform.window;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.k;

public abstract interface c
  extends k, g, Comparable<c>
{
  @Deprecated
  public abstract boolean EX();
  
  public abstract d a(d.b paramb);
  
  public abstract void a(int paramInt, AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime);
  
  public abstract boolean aXc();
  
  public abstract boolean aXi();
  
  public abstract e getOrientationHandler();
  
  public abstract Rect getSafeAreaInsets();
  
  public abstract c.c getStatusBar();
  
  public abstract DisplayMetrics getVDisplayMetrics();
  
  public abstract boolean isInMultiWindowMode();
  
  @Deprecated
  public abstract void setSoftOrientation(String paramString);
  
  public abstract void setWindowDescription(a parama);
  
  public static final class a
  {
    public final int colorPrimary;
    public final String label;
    public final int mdM;
    public final Bitmap mtC;
    
    public a(String paramString)
    {
      this(paramString, null, 0);
    }
    
    public a(String paramString, Bitmap paramBitmap, int paramInt)
    {
      this.label = paramString;
      this.mtC = paramBitmap;
      this.mdM = -1;
      this.colorPrimary = paramInt;
    }
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.c
 * JD-Core Version:    0.7.0.1
 */