package com.tencent.mm.plugin.appbrand.jsapi.o;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends a
{
  public static final int CTRL_INDEX = 63;
  public static final String NAME = "reportKeyValue";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optJSONArray("dataArray");
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail", null));
      return;
    }
    com.tencent.mm.plugin.appbrand.config.i locali = (com.tencent.mm.plugin.appbrand.config.i)paramc.D(com.tencent.mm.plugin.appbrand.config.i.class);
    if (locali == null)
    {
      y.e("MicroMsg.JsApiReportKeyValue", "config is Null!");
      paramc.C(paramInt, h("fail", null));
      return;
    }
    int i = 0;
    for (;;)
    {
      if (i >= paramJSONObject.length()) {
        break label206;
      }
      try
      {
        Object localObject = paramJSONObject.getJSONObject(i);
        int j = ((JSONObject)localObject).optInt("key");
        localObject = ((JSONObject)localObject).optString("value");
        if ((j > 0) && (!bk.bl((String)localObject))) {
          h.nFQ.f(j, new Object[] { paramc.getAppId(), Integer.valueOf(locali.fPS.fEN), Integer.valueOf(locali.fPS.fEM + 1), localObject });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.JsApiReportKeyValue", "AppBrandComponent parse report value failed : %s", new Object[] { localException.getMessage() });
        }
      }
      i += 1;
    }
    label206:
    paramc.C(paramInt, h("ok", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.c
 * JD-Core Version:    0.7.0.1
 */