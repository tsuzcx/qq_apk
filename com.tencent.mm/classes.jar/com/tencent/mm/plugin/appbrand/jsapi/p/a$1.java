package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;

final class a$1
  extends a.b
{
  a$1(a parama, f paramf1, f paramf2, i parami)
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.a.1
 * JD-Core Version:    0.7.0.1
 */