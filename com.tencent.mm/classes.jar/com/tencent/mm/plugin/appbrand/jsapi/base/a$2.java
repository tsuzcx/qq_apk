package com.tencent.mm.plugin.appbrand.jsapi.base;

import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.e.c;
import com.tencent.mm.plugin.appbrand.page.y;
import com.tencent.mm.sdk.platformtools.ai;

final class a$2
  implements e.c
{
  a$2(a parama, e parame, int paramInt, u.b paramb) {}
  
  public final void onDestroy()
  {
    this.gkV.b(this);
    ai.d(new a.2.1(this));
    this.gkV.agW().mh(this.gkY);
    this.giE.recycle();
    System.gc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.base.a.2
 * JD-Core Version:    0.7.0.1
 */