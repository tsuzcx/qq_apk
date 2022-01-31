package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;

final class b$1
  extends b.b
{
  b$1(b paramb, f paramf1, f paramf2, i parami)
  {
    super(paramf1);
  }
  
  public final void onDestroy()
  {
    g.b(this.gfy.getAppId(), this);
    this.gAB.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.b.1
 * JD-Core Version:    0.7.0.1
 */