package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 482;
  public static final String NAME = "loadVideoResource";
  
  static void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228724);
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
      new b.j().j(parame).agU(paramString).bPO();
      AppMethodBeat.o(228724);
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
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(228718);
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data nil", null));
      Log.w("MicroMsg.JsApiLoadVideoResource", "data is null");
      AppMethodBeat.o(228718);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("resources");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      Log.w("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
      parame.j(paramInt, h("fail:dataArr nil", null));
      AppMethodBeat.o(228718);
      return;
    }
    int k = 0;
    int j = 0;
    if (j < paramJSONObject.length())
    {
      String str = paramJSONObject.optString(j, "");
      Log.d("MicroMsg.JsApiLoadVideoResource", "preLoadVideo videoUrl:%s", new Object[] { str });
      int i;
      if (Util.isNullOrNil(str))
      {
        Log.w("MicroMsg.JsApiLoadVideoResource", "videoUrl i nil");
        i = k + 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (com.tencent.luggage.a.e.K(g.class) != null)
        {
          int m = ((g)com.tencent.luggage.a.e.K(g.class)).a(str, new com.tencent.mm.plugin.appbrand.jsapi.video.c()
          {
            public final void cl(String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(227666);
              Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadFail err_code = %s, url = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
              b.a(parame, paramAnonymousString, -5, paramAnonymousInt);
              AppMethodBeat.o(227666);
            }
            
            public final void dY(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(227662);
              Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadSucc save_path = %s, url = %s", new Object[] { paramAnonymousString2, paramAnonymousString1 });
              paramAnonymousString2 = parame;
              HashMap localHashMap = new HashMap();
              localHashMap.put("resource", paramAnonymousString1);
              paramAnonymousString1 = new JSONObject(localHashMap).toString();
              new b.k().j(paramAnonymousString2).agU(paramAnonymousString1).bPO();
              AppMethodBeat.o(227662);
            }
          });
          i = k;
          if (m != 0)
          {
            Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo genPreLoad fail ret = %s, videoUrl = %s", new Object[] { Integer.valueOf(m), str });
            a(parame, str, m, 0);
            i = k + 1;
          }
        }
      }
    }
    if ((k != 0) && (k == paramJSONObject.length())) {
      parame.j(paramInt, h("fail", null));
    }
    AppMethodBeat.o(228718);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.b
 * JD-Core Version:    0.7.0.1
 */