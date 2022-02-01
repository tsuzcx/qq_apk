package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.r;

public abstract class d
{
  int index = -1;
  r jFj;
  String nva;
  c nvb;
  a nvc;
  protected volatile e nvd;
  
  public d(String paramString, c paramc)
  {
    this.nva = paramString;
    this.nvb = paramc;
  }
  
  public d(String paramString, c paramc, r paramr)
  {
    this.nva = paramString;
    this.jFj = paramr;
    this.nvb = paramc;
  }
  
  protected final void S(Bitmap paramBitmap)
  {
    e locale = this.nvd;
    if (locale != null) {
      locale.a(paramBitmap, this);
    }
  }
  
  public final void a(a parama)
  {
    this.nvc = parama;
  }
  
  public final void a(e parame)
  {
    this.nvd = parame;
  }
  
  public abstract void bGG();
  
  public final String bGH()
  {
    if ((this.nva == null) || (this.nva.isEmpty())) {
      return null;
    }
    return this.nva;
  }
  
  public final void cancel()
  {
    this.nvd = null;
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