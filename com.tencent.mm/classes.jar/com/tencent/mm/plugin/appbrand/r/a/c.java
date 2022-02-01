package com.tencent.mm.plugin.appbrand.r.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.ac;

public abstract interface c
  extends k, Comparable<c>
{
  public static final a lOO = new a(0, 0);
  
  public abstract d a(d.b paramb);
  
  public abstract boolean aTE();
  
  public abstract boolean aTs();
  
  public abstract boolean aTx();
  
  public abstract e getOrientationHandler();
  
  public abstract Rect getSafeAreaInsets();
  
  public abstract d getStatusBar();
  
  public abstract DisplayMetrics getVDisplayMetrics();
  
  public abstract void setResizeable(boolean paramBoolean);
  
  public abstract void setSoftOrientation(String paramString);
  
  public abstract void setWindowDescription(b paramb);
  
  public static final class a
  {
    public final int b;
    public final int l;
    public final int r;
    public final int t;
    
    public a(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193506);
      this.l = paramInt1;
      this.r = paramInt2;
      this.t = 0;
      this.b = 0;
      ac.v("MicroMsg.WindowCompatInfo", "WindowCompatInfo: l = [%d], r = [%d], t = [%d], b = [%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(193506);
    }
  }
  
  public static final class b
  {
    public final int colorPrimary;
    public final Bitmap lOP;
    public final String label;
    public final int lzV;
    
    public b(String paramString)
    {
      this(paramString, null, 0);
    }
    
    public b(String paramString, Bitmap paramBitmap, int paramInt)
    {
      this.label = paramString;
      this.lOP = paramBitmap;
      this.lzV = -1;
      this.colorPrimary = paramInt;
    }
  }
  
  public static final class c {}
  
  public static final class d
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.a.c
 * JD-Core Version:    0.7.0.1
 */