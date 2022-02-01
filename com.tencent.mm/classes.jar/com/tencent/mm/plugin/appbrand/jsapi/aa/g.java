package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.report.a;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySessionRuntime;
import com.tencent.mm.plugin.appbrand.report.quality.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Pattern;
import org.apache.commons.c.i;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
  extends c
{
  public static final int CTRL_INDEX = 63;
  public static final String NAME = "reportKeyValue";
  
  public final void a(f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46750);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("dataArray");
    if (localJSONArray == null)
    {
      paramf.callback(paramInt, ZP("fail:invalid data"));
      AppMethodBeat.o(46750);
      return;
    }
    int m = paramJSONObject.optInt("version", -1);
    n localn = (n)paramf.aN(n.class);
    if (localn == null)
    {
      Log.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
      paramf.callback(paramInt, ZP("fail:interrupted"));
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
                  break label694;
                }
                localObject[i1] = str.substring(0, 1024);
                k = 1;
                break label694;
              }
              if (k == 0) {
                break label691;
              }
              localObject = i.b((Object[])localObject, ",");
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
              break label483;
            }
            paramJSONObject = b.afZ(paramf.getAppId());
            if (paramJSONObject != null) {
              break label355;
            }
            paramf.callback(paramInt, ZP("fail NULL QualitySystem instance"));
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
        label355:
        Log.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", new Object[] { Integer.valueOf(n), paramf.getAppId(), Integer.valueOf(localn.qYY.pkgVersion), Integer.valueOf(localn.qYY.qHO + 1), localJSONObject });
        a.tMQ.b(n, new Object[] { paramJSONObject.eup, paramJSONObject.appId, Integer.valueOf(paramJSONObject.tSh), Integer.valueOf(paramJSONObject.tQx), Integer.valueOf(paramJSONObject.apptype), localJSONObject });
        continue;
        label483:
        Log.i("MicroMsg.JsApiReportKeyValue", "report kv_%d{appId='%s',pkgVersion=%d,pkgDebugType=%d,value='%s'}", new Object[] { Integer.valueOf(n), paramf.getAppId(), Integer.valueOf(localn.qYY.pkgVersion), Integer.valueOf(localn.qYY.qHO + 1), localJSONObject });
        if (n == 15496) {
          h.OAn.b(n, new Object[] { paramf.getAppId(), Integer.valueOf(localn.qYY.pkgVersion), Integer.valueOf(localn.qYY.qHO + 1), localJSONObject });
        } else {
          a.tMQ.b(n, new Object[] { paramf.getAppId(), Integer.valueOf(localn.qYY.pkgVersion), Integer.valueOf(localn.qYY.qHO + 1), localJSONObject });
        }
      }
      paramf.callback(paramInt, ZP("ok"));
      AppMethodBeat.o(46750);
      return;
      label691:
      continue;
      label694:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.g
 * JD-Core Version:    0.7.0.1
 */