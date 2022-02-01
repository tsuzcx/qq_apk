package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends a
{
  public static final int CTRL_INDEX = 482;
  public static final String NAME = "loadVideoResource";
  
  static void a(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194418);
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
      new b.j().h(paramc).LO(paramString).beN();
      AppMethodBeat.o(194418);
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
  
  public final void a(final c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(194417);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:data nil", null));
      ac.w("MicroMsg.JsApiLoadVideoResource", "data is null");
      AppMethodBeat.o(194417);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("resources");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      ac.w("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
      paramc.h(paramInt, e("fail:dataArr nil", null));
      AppMethodBeat.o(194417);
      return;
    }
    int k = 0;
    int j = 0;
    if (j < paramJSONObject.length())
    {
      String str = paramJSONObject.optString(j, "");
      ac.d("MicroMsg.JsApiLoadVideoResource", "preLoadVideo videoUrl:%s", new Object[] { str });
      int i;
      if (bs.isNullOrNil(str))
      {
        ac.w("MicroMsg.JsApiLoadVideoResource", "videoUrl i nil");
        i = k + 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (e.K(l.class) != null)
        {
          int m = ((l)e.K(l.class)).a(str, new d()
          {
            public final void bD(String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(194416);
              ac.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadFail err_code = %s, url = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
              b.a(paramc, paramAnonymousString, -5, paramAnonymousInt);
              AppMethodBeat.o(194416);
            }
            
            public final void du(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(194415);
              ac.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadSucc save_path = %s, url = %s", new Object[] { paramAnonymousString2, paramAnonymousString1 });
              paramAnonymousString2 = paramc;
              HashMap localHashMap = new HashMap();
              localHashMap.put("resource", paramAnonymousString1);
              paramAnonymousString1 = new JSONObject(localHashMap).toString();
              new b.k().h(paramAnonymousString2).LO(paramAnonymousString1).beN();
              AppMethodBeat.o(194415);
            }
          });
          i = k;
          if (m != 0)
          {
            ac.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo genPreLoad fail ret = %s, videoUrl = %s", new Object[] { Integer.valueOf(m), str });
            a(paramc, str, m, 0);
            i = k + 1;
          }
        }
      }
    }
    if ((k != 0) && (k == paramJSONObject.length())) {
      paramc.h(paramInt, e("fail", null));
    }
    AppMethodBeat.o(194417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.b
 * JD-Core Version:    0.7.0.1
 */