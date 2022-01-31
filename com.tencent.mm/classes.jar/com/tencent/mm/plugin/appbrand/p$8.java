package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.appcache.aq;
import com.tencent.mm.plugin.appbrand.v.l;
import com.tencent.mm.plugin.appbrand.v.l.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class p$8
  implements Runnable
{
  p$8(p paramp, String paramString) {}
  
  public final void run()
  {
    if (p.b(this.fAc)) {
      try
      {
        this.fAc.aX("onSubPackageReady", new JSONObject().put("moduleName", this.fAh).toString());
        return;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppBrandService", "loadModule using isolate context, notify but get exception %s");
        return;
      }
    }
    if ("__APP__".equals(this.fAh))
    {
      p.c(this.fAc);
      return;
    }
    Object localObject = new StringBuilder().append(this.fAh);
    if (this.fAh.endsWith("/")) {}
    for (String str = "";; str = "/")
    {
      str = str + "app-service.js";
      localObject = aq.a(p.a(this.fAc), str);
      h.nFQ.a(370L, 30L, 1L, false);
      l.a(this.fAc.getRuntime(), this.fAc.ahK(), str, (String)localObject, l.a.hlw, new p.8.1(this));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.8
 * JD-Core Version:    0.7.0.1
 */