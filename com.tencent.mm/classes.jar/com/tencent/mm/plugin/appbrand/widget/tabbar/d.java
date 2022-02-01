package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.q;

public abstract class d
{
  q iIL;
  int index = -1;
  String mns;
  c mnt;
  d.a mnu;
  protected volatile e mnv;
  
  public d(String paramString, c paramc)
  {
    this.mns = paramString;
    this.mnt = paramc;
  }
  
  public d(String paramString, c paramc, q paramq)
  {
    this.mns = paramString;
    this.iIL = paramq;
    this.mnt = paramc;
  }
  
  protected final void R(Bitmap paramBitmap)
  {
    e locale = this.mnv;
    if (locale != null) {
      locale.a(paramBitmap, this);
    }
  }
  
  public final void a(d.a parama)
  {
    this.mnu = parama;
  }
  
  public final void a(e parame)
  {
    this.mnv = parame;
  }
  
  public abstract void buM();
  
  public final String buN()
  {
    if ((this.mns == null) || (this.mns.isEmpty())) {
      return null;
    }
    return this.mns;
  }
  
  public final void cancel()
  {
    this.mnv = null;
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.d
 * JD-Core Version:    0.7.0.1
 */