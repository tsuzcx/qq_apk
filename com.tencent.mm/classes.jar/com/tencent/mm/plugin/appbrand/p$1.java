package com.tencent.mm.plugin.appbrand;

import android.util.Pair;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.k;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.s;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import org.json.JSONObject;

final class p$1
  extends com.tencent.mm.plugin.appbrand.page.e
{
  p$1(p paramp) {}
  
  public final l o(Map<String, Object> paramMap)
  {
    paramMap = new JSONObject(paramMap);
    Object localObject = com.tencent.mm.plugin.appbrand.report.model.e.h((s)this.fAc.getRuntime().Zz().getCurrentPage().getCurrentPageView());
    int i = ((Integer)((Pair)localObject).first).intValue();
    localObject = (String)((Pair)localObject).second;
    try
    {
      paramMap.put("targetAction", i);
      paramMap.put("targetPagePath", localObject);
      super.tL(paramMap.toString());
      return this;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillEventOnAppEnterBackground ex = %s", new Object[] { localException });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.1
 * JD-Core Version:    0.7.0.1
 */