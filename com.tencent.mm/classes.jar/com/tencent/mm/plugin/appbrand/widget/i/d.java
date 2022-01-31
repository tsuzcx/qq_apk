package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.r;

public abstract class d
{
  r hxb;
  int index = -1;
  String jxc;
  c jxd;
  d.a jxe;
  protected volatile e jxf;
  
  public d(String paramString, c paramc)
  {
    this.jxc = paramString;
    this.jxd = paramc;
  }
  
  public d(String paramString, c paramc, r paramr)
  {
    this.jxc = paramString;
    this.hxb = paramr;
    this.jxd = paramc;
  }
  
  protected final void G(Bitmap paramBitmap)
  {
    e locale = this.jxf;
    if (locale != null) {
      locale.a(paramBitmap, this);
    }
  }
  
  public final void a(d.a parama)
  {
    this.jxe = parama;
  }
  
  public final void a(e parame)
  {
    this.jxf = parame;
  }
  
  public abstract void aSq();
  
  public final String aSr()
  {
    if ((this.jxc == null) || (this.jxc.isEmpty())) {
      return null;
    }
    return this.jxc;
  }
  
  public final void cancel()
  {
    this.jxf = null;
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.d
 * JD-Core Version:    0.7.0.1
 */