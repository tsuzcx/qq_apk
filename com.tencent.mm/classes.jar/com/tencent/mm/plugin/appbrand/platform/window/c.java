package com.tencent.mm.plugin.appbrand.platform.window;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.n;

public abstract interface c
  extends n, g, Comparable<c>
{
  @Deprecated
  public abstract boolean OD();
  
  public abstract d a(d.b paramb);
  
  public abstract void a(int paramInt, AppBrandRuntime paramAppBrandRuntime);
  
  public abstract void a(WxaWindowLayoutParams paramWxaWindowLayoutParams, AppBrandRuntime paramAppBrandRuntime);
  
  public abstract boolean bsc();
  
  public abstract boolean bsj();
  
  public abstract Context getContext();
  
  public abstract e getOrientationHandler();
  
  public abstract Rect getSafeAreaInsets();
  
  public abstract DisplayMetrics getVDisplayMetrics();
  
  public abstract boolean isInMultiWindowMode();
  
  @Deprecated
  public abstract void setSoftOrientation(String paramString);
  
  public abstract void setWindowDescription(a parama);
  
  public static final class a
  {
    public final int colorPrimary;
    public final String label;
    public final Bitmap nEk;
    public final int noe;
    
    public a(String paramString)
    {
      this(paramString, null, 0);
    }
    
    public a(String paramString, Bitmap paramBitmap, int paramInt)
    {
      this.label = paramString;
      this.nEk = paramBitmap;
      this.noe = -1;
      this.colorPrimary = paramInt;
    }
  }
  
  public static final class b {}
  
  public static final class c
  {
    public int height;
    public int visibility = 0;
    
    public final String toString()
    {
      AppMethodBeat.i(176697);
      String str = "WindowStatusBar{height=" + this.height + ", visibility=" + this.visibility + '}';
      AppMethodBeat.o(176697);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.c
 * JD-Core Version:    0.7.0.1
 */