package com.tencent.luggage.game.d.a.a;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.cj;
import com.tencent.mm.plugin.appbrand.jsruntime.h;
import com.tencent.mm.plugin.appbrand.jsruntime.o;
import com.tencent.mm.plugin.appbrand.utils.p;
import com.tencent.mm.plugin.appbrand.x.b;
import com.tencent.mm.plugin.appbrand.x.b.a;
import com.tencent.mm.sdk.platformtools.ad;

final class a$1
  implements h
{
  a$1(a parama) {}
  
  public final void u(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130540);
    Object localObject = (c)this.ckh.El();
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((c)localObject).aYh())
    {
      AppMethodBeat.o(130540);
      return;
    }
    ad.e("Luggage.AppBrandGameServiceLogicImp", "[WAGameJsException] hy: wxa main context exception %s %s", new Object[] { paramString1, paramString2 });
    cj.a((o)localObject, "onError", String.format("{'message':'%s', 'stack': '%s'}", new Object[] { p.Vc(paramString1), p.Vc(paramString2) }), 0);
    b.a.byl();
    b.K("WeAppLaunch", paramString1, paramString2);
    AppMethodBeat.o(130540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.luggage.game.d.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */