package com.tencent.mm.plugin.appbrand.jsapi.a;

import a.f.b.j;
import a.l;
import b.a.a.a.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.phonenumber.k;
import com.tencent.mm.plugin.appbrand.phonenumber.m;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
final class c$p$1$1
  implements Runnable
{
  c$p$1$1(c.p.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(143763);
    Object localObject1 = this.hEv.hEu.hEp;
    Object localObject2 = k.iDv;
    ((m)localObject1).p((ArrayList)k.aKP());
    localObject2 = a.CKU;
    localObject1 = this.hEv.hEu.hEl;
    if (localObject1 != null) {}
    for (localObject1 = ((v)localObject1).getAppId();; localObject1 = null)
    {
      j.p(localObject1, "env?.appId");
      ((a)localObject2).azx((String)localObject1);
      AppMethodBeat.o(143763);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.p.1.1
 * JD-Core Version:    0.7.0.1
 */