package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Pattern;
import org.apache.commons.b.g;
import org.json.JSONArray;
import org.json.JSONObject;

public class f
  extends c
{
  public static final int CTRL_INDEX = 63;
  public static final String NAME = "reportKeyValue";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46750);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("dataArray");
    if (localJSONArray == null)
    {
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46750);
      return;
    }
    int m = paramJSONObject.optInt("version", -1);
    l locall = (l)parame.au(l.class);
    if (locall == null)
    {
      Log.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
      parame.j(paramInt, h("fail:interrupted", null));
      AppMethodBeat.o(46750);
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
          boolean bool = Util.isNullOrNil(paramJSONObject);
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
                if (Util.nullAsNil(str).length() <= 1024) {
                  break label698;
                }
                localObject[i1] = str.substring(0, 1024);
                k = 1;
                break label698;
              }
              if (k == 0) {
                break label695;
              }
              localObject = g.a((Object[])localObject, ",");
              paramJSONObject = (JSONObject)localObject;
              localObject = paramJSONObject;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.JsApiReportKeyValue", "modify 15496 too large string-fields, e=%s", new Object[] { localException });
              localJSONObject = paramJSONObject;
              continue;
            }
            if (m < 2) {
              break label486;
            }
            paramJSONObject = b.amO(parame.getAppId());
            if (paramJSONObject != null) {
              break label358;
            }
            parame.j(paramInt, h("fail NULL QualitySystem instance", null));
            AppMethodBeat.o(46750);
            return;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        Log.e("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", new Object[] { paramJSONObject.getMessage() });
      }
      for (;;)
      {
        i += 1;
        break;
        label358:
        Log.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", new Object[] { Integer.valueOf(n), parame.getAppId(), Integer.valueOf(locall.nYR.pkgVersion), Integer.valueOf(locall.nYR.nHY + 1), localJSONObject });
        a.qIj.a(n, new Object[] { paramJSONObject.cBH, paramJSONObject.appId, Integer.valueOf(paramJSONObject.qNx), Integer.valueOf(paramJSONObject.qLQ), Integer.valueOf(paramJSONObject.apptype), localJSONObject });
        continue;
        label486:
        Log.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", new Object[] { Integer.valueOf(n), parame.getAppId(), Integer.valueOf(locall.nYR.pkgVersion), Integer.valueOf(locall.nYR.nHY + 1), localJSONObject });
        if (n == 15496) {
          h.IzE.a(n, new Object[] { parame.getAppId(), Integer.valueOf(locall.nYR.pkgVersion), Integer.valueOf(locall.nYR.nHY + 1), localJSONObject });
        } else {
          a.qIj.a(n, new Object[] { parame.getAppId(), Integer.valueOf(locall.nYR.pkgVersion), Integer.valueOf(locall.nYR.nHY + 1), localJSONObject });
        }
      }
      parame.j(paramInt, h("ok", null));
      AppMethodBeat.o(46750);
      return;
      label695:
      continue;
      label698:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.f
 * JD-Core Version:    0.7.0.1
 */