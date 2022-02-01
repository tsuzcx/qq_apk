package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.q;

public abstract class d
{
  int index = -1;
  q jCl;
  String npQ;
  c npR;
  a npS;
  protected volatile e npT;
  
  public d(String paramString, c paramc)
  {
    this.npQ = paramString;
    this.npR = paramc;
  }
  
  public d(String paramString, c paramc, q paramq)
  {
    this.npQ = paramString;
    this.jCl = paramq;
    this.npR = paramc;
  }
  
  protected final void R(Bitmap paramBitmap)
  {
    e locale = this.npT;
    if (locale != null) {
      locale.a(paramBitmap, this);
    }
  }
  
  public final void a(a parama)
  {
    this.npS = parama;
  }
  
  public final void a(e parame)
  {
    this.npT = parame;
  }
  
  public abstract void bFL();
  
  public final String bFM()
  {
    if ((this.npQ == null) || (this.npQ.isEmpty())) {
      return null;
    }
    return this.npQ;
  }
  
  public final void cancel()
  {
    this.npT = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.d
 * JD-Core Version:    0.7.0.1
 */