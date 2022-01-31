package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.i.e;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.v.i;
import com.tencent.mm.sdk.platformtools.y;

final class p$3
  implements e
{
  p$3(p paramp) {}
  
  public final void x(String paramString1, String paramString2)
  {
    y.e("MicroMsg.AppBrandService", "hy: wxa main context exception %s %s", new Object[] { paramString1, paramString2 });
    bc.a(this.fAc.ahK(), "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { i.wI(paramString1), i.wI(paramString2) }), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.3
 * JD-Core Version:    0.7.0.1
 */