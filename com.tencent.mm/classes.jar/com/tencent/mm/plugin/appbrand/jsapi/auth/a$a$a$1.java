package com.tencent.mm.plugin.appbrand.jsapi.auth;

import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.b.c.a;
import com.tencent.mm.plugin.appbrand.i;
import java.util.HashMap;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "appId", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1$1$1", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1$$special$$inlined$apply$lambda$1"})
final class a$a$a$1
  implements c.a
{
  a$a$a$1(a.a.a parama) {}
  
  public final void a(String arg1, b paramb)
  {
    AppMethodBeat.i(134645);
    if (paramb == b.gYh)
    {
      a.aBU();
      synchronized (a.aBT())
      {
        a.aBU();
        paramb = (a)a.aBT().remove(this.hDd.hDc.getAppId());
        if (paramb != null)
        {
          a.b(paramb);
          paramb = y.BMg;
        }
        AppMethodBeat.o(134645);
        return;
      }
    }
    AppMethodBeat.o(134645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.a.a.a.1
 * JD-Core Version:    0.7.0.1
 */