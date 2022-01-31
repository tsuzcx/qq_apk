package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g
  extends a
{
  public static final int CTRL_INDEX = 483;
  public static final String NAME = "loadVideoResource";
  
  static void a(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(126562);
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
      new k.j().j(paramc).BN(paramString).aBz();
      AppMethodBeat.o(126562);
      return;
      str = "args illegal";
      continue;
      str = "downloading";
      continue;
      str = "start download fail";
      continue;
      str = "create file fail";
      continue;
      str = "cdn download fail errCode:".concat(String.valueOf(paramInt2));
    }
  }
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(126561);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, j("fail:data nil", null));
      ab.w("MicroMsg.JsApiLoadVideoResource", "data is null");
      AppMethodBeat.o(126561);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("resources");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      ab.w("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
      paramc.h(paramInt, j("fail:dataArr nil", null));
      AppMethodBeat.o(126561);
      return;
    }
    int k = 0;
    int j = 0;
    if (j < paramJSONObject.length())
    {
      String str = paramJSONObject.optString(j, "");
      ab.d("MicroMsg.JsApiLoadVideoResource", "preLoadVideo videoUrl:%s", new Object[] { str });
      int i;
      if (bo.isNullOrNil(str))
      {
        ab.w("MicroMsg.JsApiLoadVideoResource", "videoUrl i nil");
        i = k + 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        int m = ((e)com.tencent.luggage.a.e.q(e.class)).a(str, new g.1(this, paramc));
        i = k;
        if (m != 0)
        {
          ab.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo genPreLoad fail ret = %s, videoUrl = %s", new Object[] { Integer.valueOf(m), str });
          a(paramc, str, m, 0);
          i = k + 1;
        }
      }
    }
    if ((k != 0) && (k == paramJSONObject.length())) {
      paramc.h(paramInt, j("fail", null));
    }
    AppMethodBeat.o(126561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.g
 * JD-Core Version:    0.7.0.1
 */