package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.s;

public abstract class d
{
  int index = -1;
  s kGT;
  String oFe;
  c oFf;
  a oFg;
  protected volatile e oFh;
  
  public d(String paramString, c paramc)
  {
    this.oFe = paramString;
    this.oFf = paramc;
  }
  
  public d(String paramString, c paramc, s params)
  {
    this.oFe = paramString;
    this.kGT = params;
    this.oFf = paramc;
  }
  
  protected final void X(Bitmap paramBitmap)
  {
    e locale = this.oFh;
    if (locale != null) {
      locale.a(paramBitmap, this);
    }
  }
  
  public final void a(a parama)
  {
    this.oFg = parama;
  }
  
  public final void a(e parame)
  {
    this.oFh = parame;
  }
  
  public final void cancel()
  {
    this.oFh = null;
  }
  
  public abstract void cdf();
  
  public final String cdg()
  {
    if ((this.oFe == null) || (this.oFe.isEmpty())) {
      return null;
    }
    return this.oFe;
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void destroy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.d
 * JD-Core Version:    0.7.0.1
 */