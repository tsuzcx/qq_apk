package com.tencent.luggage.sdk.b.a.c;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.t.o;
import com.tencent.mm.plugin.appbrand.t.o.a;
import org.json.JSONObject;

final class b$5
  implements Runnable
{
  b$5(b paramb, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(140734);
    if (this.bEH.bEC) {
      try
      {
        ((c)b.d(this.bEH)).br("onSubPackageReady", new JSONObject().put("moduleName", this.bEK).toString());
        AppMethodBeat.o(140734);
        return;
      }
      catch (Exception localException)
      {
        d.e("Luggage.AppBrandMiniProgramServiceLogicImp", "loadModule using isolate context, notify but get exception %s");
        AppMethodBeat.o(140734);
        return;
      }
    }
    if ("__APP__".equals(this.bEK))
    {
      b.e(this.bEH);
      AppMethodBeat.o(140734);
      return;
    }
    Object localObject = new StringBuilder().append(this.bEK);
    if (this.bEK.endsWith("/")) {}
    for (String str = "";; str = "/")
    {
      str = str + "app-service.js";
      localObject = ax.c(((c)b.f(this.bEH)).wj(), str);
      long l = System.currentTimeMillis();
      o.a(((c)b.g(this.bEH)).wj(), ((c)b.h(this.bEH)).aAO(), str, (String)localObject, o.a.iXQ, new b.5.1(this, str, (String)localObject, l));
      AppMethodBeat.o(140734);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.luggage.sdk.b.a.c.b.5
 * JD-Core Version:    0.7.0.1
 */