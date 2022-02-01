package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import com.tencent.mm.plugin.appbrand.q;

public abstract class d
{
  int index = -1;
  q jiP;
  String mPt;
  c mPu;
  a mPv;
  protected volatile e mPw;
  
  public d(String paramString, c paramc)
  {
    this.mPt = paramString;
    this.mPu = paramc;
  }
  
  public d(String paramString, c paramc, q paramq)
  {
    this.mPt = paramString;
    this.jiP = paramq;
    this.mPu = paramc;
  }
  
  protected final void R(Bitmap paramBitmap)
  {
    e locale = this.mPw;
    if (locale != null) {
      locale.a(paramBitmap, this);
    }
  }
  
  public final void a(a parama)
  {
    this.mPv = parama;
  }
  
  public final void a(e parame)
  {
    this.mPw = parame;
  }
  
  public abstract void bBJ();
  
  public final String bBK()
  {
    if ((this.mPt == null) || (this.mPt.isEmpty())) {
      return null;
    }
    return this.mPt;
  }
  
  public final void cancel()
  {
    this.mPw = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.d
 * JD-Core Version:    0.7.0.1
 */