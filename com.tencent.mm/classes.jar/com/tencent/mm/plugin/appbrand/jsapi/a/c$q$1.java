package com.tencent.mm.plugin.appbrand.jsapi.a;

import a.f.b.j;
import a.l;
import android.content.Intent;
import b.a.a.a.a.a.a.a.a;
import com.tencent.luggage.g.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.phonenumber.k;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
final class c$q$1
  implements e.a
{
  c$q$1(c.q paramq) {}
  
  public final void b(int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(143767);
    com.tencent.mm.plugin.appbrand.s.m.runOnUiThread((Runnable)new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143766);
        Object localObject1 = this.hEy.hEx.hEp;
        Object localObject2 = k.iDv;
        ((com.tencent.mm.plugin.appbrand.phonenumber.m)localObject1).p((ArrayList)k.aKP());
        localObject1 = a.CKU;
        localObject2 = this.hEy.hEx.hEl.getAppId();
        j.p(localObject2, "env.appId");
        ((a)localObject1).azx((String)localObject2);
        AppMethodBeat.o(143766);
      }
    });
    AppMethodBeat.o(143767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.a.c.q.1
 * JD-Core Version:    0.7.0.1
 */