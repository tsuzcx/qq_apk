package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.regex.Pattern;
import org.apache.commons.b.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 63;
  public static final String NAME = "reportKeyValue";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46750);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("dataArray");
    if (localJSONArray == null)
    {
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46750);
      return;
    }
    int m = paramJSONObject.optInt("version", -1);
    k localk = (k)paramc.ar(k.class);
    if (localk == null)
    {
      ad.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
      paramc.h(paramInt, e("fail:interrupted", null));
      AppMethodBeat.o(46750);
      return;
    }
    int i = 0;
    if (i < localJSONArray.length()) {}
    for (;;)
    {
      int n;
      int j;
      Object localObject2;
      JSONObject localJSONObject;
      try
      {
        paramJSONObject = localJSONArray.getJSONObject(i);
        n = paramJSONObject.optInt("key");
        paramJSONObject = paramJSONObject.optString("value");
        if (n > 0)
        {
          boolean bool = bt.isNullOrNil(paramJSONObject);
          if (!bool)
          {
            Object localObject1 = paramJSONObject;
            if (n == 15496) {}
            try
            {
              localObject1 = paramJSONObject.split(Pattern.quote(","));
              int k = 0;
              j = 0;
              if (j < 4)
              {
                int i1 = new int[] { 17, 11, 9, 2 }[j];
                localObject2 = localObject1[i1];
                if (bt.nullAsNil((String)localObject2).length() <= 1024) {
                  break label634;
                }
                localObject1[i1] = ((String)localObject2).substring(0, 1024);
                k = 1;
                break label634;
              }
              if (k == 0) {
                break label631;
              }
              localObject1 = g.a((Object[])localObject1, ",");
              paramJSONObject = (JSONObject)localObject1;
              localObject1 = paramJSONObject;
            }
            catch (Exception localException)
            {
              ad.e("MicroMsg.JsApiReportKeyValue", "modify 15496 too large string-fields, e=%s", new Object[] { localException });
              localJSONObject = paramJSONObject;
              continue;
            }
            if (m < 2) {
              break label488;
            }
            paramJSONObject = com.tencent.mm.plugin.appbrand.report.quality.a.ME(paramc.getAppId());
            if (paramJSONObject != null) {
              break label358;
            }
            paramc.h(paramInt, e("fail NULL QualitySystem instance", null));
            AppMethodBeat.o(46750);
            return;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ad.e("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", new Object[] { paramJSONObject.getMessage() });
      }
      for (;;)
      {
        i += 1;
        break;
        label358:
        ad.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", new Object[] { Integer.valueOf(n), paramc.getAppId(), Integer.valueOf(localk.jdS.pkgVersion), Integer.valueOf(localk.jdS.iOQ + 1), localJSONObject });
        localObject2 = com.tencent.mm.plugin.appbrand.report.a.loy;
        com.tencent.mm.plugin.appbrand.report.a.f(n, new Object[] { paramJSONObject.kGa, paramJSONObject.appId, Integer.valueOf(paramJSONObject.lty), Integer.valueOf(paramJSONObject.lrW), Integer.valueOf(paramJSONObject.apptype), localJSONObject });
        continue;
        label488:
        ad.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", new Object[] { Integer.valueOf(n), paramc.getAppId(), Integer.valueOf(localk.jdS.pkgVersion), Integer.valueOf(localk.jdS.iOQ + 1), localJSONObject });
        paramJSONObject = com.tencent.mm.plugin.appbrand.report.a.loy;
        com.tencent.mm.plugin.appbrand.report.a.f(n, new Object[] { paramc.getAppId(), Integer.valueOf(localk.jdS.pkgVersion), Integer.valueOf(localk.jdS.iOQ + 1), localJSONObject });
      }
      paramc.h(paramInt, e("ok", null));
      AppMethodBeat.o(46750);
      return;
      label631:
      continue;
      label634:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.f
 * JD-Core Version:    0.7.0.1
 */