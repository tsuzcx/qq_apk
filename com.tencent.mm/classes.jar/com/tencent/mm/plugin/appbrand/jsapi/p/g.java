package com.tencent.mm.plugin.appbrand.jsapi.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = 63;
  public static final String NAME = "reportKeyValue";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(131431);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("dataArray");
    if (localJSONArray == null)
    {
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(131431);
      return;
    }
    int m = paramJSONObject.optInt("version", -1);
    com.tencent.mm.plugin.appbrand.config.h localh = (com.tencent.mm.plugin.appbrand.config.h)paramc.U(com.tencent.mm.plugin.appbrand.config.h.class);
    if (localh == null)
    {
      ab.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
      paramc.h(paramInt, j("fail null config", null));
      AppMethodBeat.o(131431);
      return;
    }
    int i = 0;
    if (i < localJSONArray.length()) {}
    for (;;)
    {
      int n;
      int j;
      JSONObject localJSONObject;
      try
      {
        paramJSONObject = localJSONArray.getJSONObject(i);
        n = paramJSONObject.optInt("key");
        paramJSONObject = paramJSONObject.optString("value");
        if (n > 0)
        {
          boolean bool = bo.isNullOrNil(paramJSONObject);
          if (!bool)
          {
            Object localObject = paramJSONObject;
            if (n == 15496) {}
            try
            {
              localObject = paramJSONObject.split(Pattern.quote(","));
              int k = 0;
              j = 0;
              if (j < 4)
              {
                int i1 = new int[] { 17, 11, 9, 2 }[j];
                String str = localObject[i1];
                if (bo.nullAsNil(str).length() <= 1024) {
                  break label631;
                }
                localObject[i1] = str.substring(0, 1024);
                k = 1;
                break label631;
              }
              if (k == 0) {
                break label628;
              }
              localObject = org.apache.commons.b.g.b((Object[])localObject, ",");
              paramJSONObject = (JSONObject)localObject;
              localObject = paramJSONObject;
            }
            catch (Exception localException)
            {
              ab.e("MicroMsg.JsApiReportKeyValue", "modify 15496 too large string-fields, e=%s", new Object[] { localException });
              localJSONObject = paramJSONObject;
              continue;
            }
            if (m < 2) {
              break label486;
            }
            paramJSONObject = com.tencent.mm.plugin.appbrand.report.quality.a.EM(paramc.getAppId());
            if (paramJSONObject != null) {
              break label358;
            }
            paramc.h(paramInt, j("fail NULL QualitySystem instance", null));
            AppMethodBeat.o(131431);
            return;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        ab.e("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", new Object[] { paramJSONObject.getMessage() });
      }
      for (;;)
      {
        i += 1;
        break;
        label358:
        ab.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", new Object[] { Integer.valueOf(n), paramc.getAppId(), Integer.valueOf(localh.hiX.gXf), Integer.valueOf(localh.hiX.gXe + 1), localJSONObject });
        com.tencent.mm.plugin.report.service.h.qsU.e(n, new Object[] { paramJSONObject.ikX, paramJSONObject.appId, Integer.valueOf(paramJSONObject.iIG), Integer.valueOf(paramJSONObject.iIF), Integer.valueOf(paramJSONObject.apptype), localJSONObject });
        continue;
        label486:
        ab.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", new Object[] { Integer.valueOf(n), paramc.getAppId(), Integer.valueOf(localh.hiX.gXf), Integer.valueOf(localh.hiX.gXe + 1), localJSONObject });
        com.tencent.mm.plugin.report.service.h.qsU.e(n, new Object[] { paramc.getAppId(), Integer.valueOf(localh.hiX.gXf), Integer.valueOf(localh.hiX.gXe + 1), localJSONObject });
      }
      paramc.h(paramInt, j("ok", null));
      AppMethodBeat.o(131431);
      return;
      label628:
      continue;
      label631:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.g
 * JD-Core Version:    0.7.0.1
 */