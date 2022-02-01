package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.y;

public abstract class d
{
  int index = -1;
  y qqV;
  String uSe;
  c uSf;
  a uSg;
  protected volatile e uSh;
  
  public d(String paramString, c paramc)
  {
    this.uSe = paramString;
    this.uSf = paramc;
  }
  
  public d(String paramString, c paramc, y paramy)
  {
    this.uSe = paramString;
    this.qqV = paramy;
    this.uSf = paramc;
  }
  
  public final void a(e parame)
  {
    this.uSh = parame;
  }
  
  protected final void ae(Bitmap paramBitmap)
  {
    e locale = this.uSh;
    if (locale != null) {
      locale.a(paramBitmap, this);
    }
  }
  
  public abstract void cSY();
  
  public final String cSZ()
  {
    if ((this.uSe == null) || (this.uSe.isEmpty())) {
      return null;
    }
    return this.uSe;
  }
  
  public final void cancel()
  {
    this.uSh = null;
  }
  
  public static abstract interface a
  {
    public abstract void destroy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.d
 * JD-Core Version:    0.7.0.1
 */