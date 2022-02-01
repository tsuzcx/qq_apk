package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.v;

public abstract class d
{
  int index = -1;
  v nAz;
  String rGO;
  c rGP;
  a rGQ;
  protected volatile e rGR;
  
  public d(String paramString, c paramc)
  {
    this.rGO = paramString;
    this.rGP = paramc;
  }
  
  public d(String paramString, c paramc, v paramv)
  {
    this.rGO = paramString;
    this.nAz = paramv;
    this.rGP = paramc;
  }
  
  protected final void V(Bitmap paramBitmap)
  {
    e locale = this.rGR;
    if (locale != null) {
      locale.a(paramBitmap, this);
    }
  }
  
  public final void a(a parama)
  {
    this.rGQ = parama;
  }
  
  public final void a(e parame)
  {
    this.rGR = parame;
  }
  
  public final void cancel()
  {
    this.rGR = null;
  }
  
  public abstract void cqr();
  
  public final String cqs()
  {
    if ((this.rGO == null) || (this.rGO.isEmpty())) {
      return null;
    }
    return this.rGO;
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