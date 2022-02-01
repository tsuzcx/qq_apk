package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.j;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.d
{
  public static final int CTRL_INDEX = 482;
  public static final String NAME = "loadVideoResource";
  
  static void a(f paramf, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234927);
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
      new b.j().h(paramf).Zh(paramString).bEo();
      AppMethodBeat.o(234927);
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
  
  public final void a(final f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(234926);
    if (paramJSONObject == null)
    {
      paramf.i(paramInt, h("fail:data nil", null));
      Log.w("MicroMsg.JsApiLoadVideoResource", "data is null");
      AppMethodBeat.o(234926);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("resources");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      Log.w("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
      paramf.i(paramInt, h("fail:dataArr nil", null));
      AppMethodBeat.o(234926);
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
        if (e.M(h.class) != null)
        {
          int m = ((h)e.M(h.class)).a(str, new com.tencent.mm.plugin.appbrand.jsapi.video.d()
          {
            public final void bO(String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(234925);
              Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadFail err_code = %s, url = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
              b.a(paramf, paramAnonymousString, -5, paramAnonymousInt);
              AppMethodBeat.o(234925);
            }
            
            public final void dN(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(234924);
              Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadSucc save_path = %s, url = %s", new Object[] { paramAnonymousString2, paramAnonymousString1 });
              paramAnonymousString2 = paramf;
              HashMap localHashMap = new HashMap();
              localHashMap.put("resource", paramAnonymousString1);
              paramAnonymousString1 = new JSONObject(localHashMap).toString();
              new b.k().h(paramAnonymousString2).Zh(paramAnonymousString1).bEo();
              AppMethodBeat.o(234924);
            }
          });
          i = k;
          if (m != 0)
          {
            Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo genPreLoad fail ret = %s, videoUrl = %s", new Object[] { Integer.valueOf(m), str });
            a(paramf, str, m, 0);
            i = k + 1;
          }
        }
      }
    }
    if ((k != 0) && (k == paramJSONObject.length())) {
      paramf.i(paramInt, h("fail", null));
    }
    AppMethodBeat.o(234926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.b
 * JD-Core Version:    0.7.0.1
 */