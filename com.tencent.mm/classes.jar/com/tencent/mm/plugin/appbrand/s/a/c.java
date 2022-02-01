package com.tencent.mm.plugin.appbrand.s.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.platformtools.ad;

public abstract interface c
  extends k, Comparable<c>
{
  public static final a lmM = new a(0, 0);
  
  public abstract d a(d.b paramb);
  
  public abstract boolean aMC();
  
  public abstract boolean aMH();
  
  public abstract boolean aMO();
  
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
      AppMethodBeat.i(194516);
      this.l = paramInt1;
      this.r = paramInt2;
      this.t = 0;
      this.b = 0;
      ad.v("MicroMsg.WindowCompatInfo", "WindowCompatInfo: l = [%d], r = [%d], t = [%d], b = [%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(0), Integer.valueOf(0) });
      AppMethodBeat.o(194516);
    }
  }
  
  public static final class b
  {
    public final int colorPrimary;
    public final int kYl;
    public final String label;
    public final Bitmap lmN;
    
    public b(String paramString)
    {
      this(paramString, null, 0);
    }
    
    public b(String paramString, Bitmap paramBitmap, int paramInt)
    {
      this.label = paramString;
      this.lmN = paramBitmap;
      this.kYl = -1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.a.c
 * JD-Core Version:    0.7.0.1
 */