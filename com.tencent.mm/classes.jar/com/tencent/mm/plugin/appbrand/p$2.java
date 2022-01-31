package com.tencent.mm.plugin.appbrand;

import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.o;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.plugin.appbrand.report.model.b;
import com.tencent.mm.plugin.appbrand.report.model.c;
import com.tencent.mm.plugin.appbrand.report.model.e;
import com.tencent.mm.plugin.appbrand.report.model.h;
import com.tencent.mm.plugin.appbrand.report.model.h.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONObject;

final class p$2
  extends f
{
  p$2(p paramp, boolean paramBoolean) {}
  
  public final l o(Map<String, Object> paramMap)
  {
    paramMap.put("scene", Integer.valueOf(this.fAc.getRuntime().aag()));
    Object localObject = this.fAc.getRuntime().aac().aef();
    if (localObject != null) {
      paramMap.put("shareInfo", localObject);
    }
    paramMap = new JSONObject(paramMap);
    localObject = this.fAc.getRuntime();
    if (this.fAd) {
      e.a((n)localObject, paramMap);
    }
    for (;;)
    {
      super.tL(paramMap.toString());
      return this;
      try
      {
        e.b((n)localObject, paramMap);
        paramMap.put("referpagepath", ((n)localObject).aad().getReporter().gYc.aok().gYC);
        paramMap.put("clickTimestamp", ((s)((n)localObject).aad().getCurrentPage().getCurrentPageView()).gUj.gYk);
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterForeground ex = %s", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.2
 * JD-Core Version:    0.7.0.1
 */