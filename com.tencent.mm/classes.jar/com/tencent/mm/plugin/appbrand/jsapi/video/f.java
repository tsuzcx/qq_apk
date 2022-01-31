package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.luggage.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f
  extends a
{
  public static final int CTRL_INDEX = 483;
  public static final String NAME = "loadVideoResource";
  
  static void a(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    String str = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("errMsg", str);
      localHashMap.put("resource", paramString);
      paramString = new JSONObject(localHashMap).toString();
      new j.i().e(paramc).tM(paramString).dispatch();
      return;
      str = "args illegal";
      continue;
      str = "downloading";
      continue;
      str = "start download fail";
      continue;
      str = "create file fail";
      continue;
      str = "cdn download fail errCode:" + paramInt2;
    }
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramc.C(paramInt, h("fail:data nil", null));
      y.w("MicroMsg.JsApiLoadVideoResource", "data is null");
    }
    int k;
    do
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("resources");
      if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
      {
        y.w("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
        paramc.C(paramInt, h("fail:dataArr nil", null));
        return;
      }
      int j = 0;
      k = 0;
      if (j < paramJSONObject.length())
      {
        String str = paramJSONObject.optString(j, "");
        y.d("MicroMsg.JsApiLoadVideoResource", "preLoadVideo videoUrl:%s", new Object[] { str });
        int i;
        if (bk.bl(str))
        {
          y.w("MicroMsg.JsApiLoadVideoResource", "videoUrl i nil");
          i = k + 1;
        }
        for (;;)
        {
          j += 1;
          k = i;
          break;
          int m = ((d)e.i(d.class)).a(str, new f.1(this, paramc));
          i = k;
          if (m != 0)
          {
            y.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo genPreLoad fail ret = %s, videoUrl = %s", new Object[] { Integer.valueOf(m), str });
            a(paramc, str, m, 0);
            i = k + 1;
          }
        }
      }
    } while ((k == 0) || (k != paramJSONObject.length()));
    paramc.C(paramInt, h("fail", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.f
 * JD-Core Version:    0.7.0.1
 */