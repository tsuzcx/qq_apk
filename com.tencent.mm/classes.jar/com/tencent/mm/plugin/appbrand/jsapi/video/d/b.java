package com.tencent.mm.plugin.appbrand.jsapi.video.d;

import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
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
  
  static void a(f paramf, String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328206);
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
      new b.j().i(paramf).ZR(paramString).cpV();
      AppMethodBeat.o(328206);
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
    AppMethodBeat.i(328220);
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data nil"));
      Log.w("MicroMsg.JsApiLoadVideoResource", "data is null");
      AppMethodBeat.o(328220);
      return;
    }
    paramJSONObject = paramJSONObject.optJSONArray("resources");
    if ((paramJSONObject == null) || (paramJSONObject.length() == 0))
    {
      Log.w("MicroMsg.JsApiLoadVideoResource", "dataArr nil");
      paramf.callback(paramInt, ZP("fail:dataArr nil"));
      AppMethodBeat.o(328220);
      return;
    }
    int j = 0;
    int k = 0;
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
        if (e.T(g.class) != null)
        {
          int m = ((g)e.T(g.class)).a(str, new com.tencent.mm.plugin.appbrand.jsapi.video.c()
          {
            public final void cK(String paramAnonymousString, int paramAnonymousInt)
            {
              AppMethodBeat.i(328219);
              Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadFail err_code = %s, url = %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
              b.a(paramf, paramAnonymousString, -5, paramAnonymousInt);
              AppMethodBeat.o(328219);
            }
            
            public final void er(String paramAnonymousString1, String paramAnonymousString2)
            {
              AppMethodBeat.i(328212);
              Log.i("MicroMsg.JsApiLoadVideoResource", "leonlad downloadVideo onPreLoadSucc save_path = %s, url = %s", new Object[] { paramAnonymousString2, paramAnonymousString1 });
              paramAnonymousString2 = paramf;
              HashMap localHashMap = new HashMap();
              localHashMap.put("resource", paramAnonymousString1);
              paramAnonymousString1 = new JSONObject(localHashMap).toString();
              new b.k().i(paramAnonymousString2).ZR(paramAnonymousString1).cpV();
              AppMethodBeat.o(328212);
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
      paramf.callback(paramInt, ZP("fail"));
    }
    AppMethodBeat.o(328220);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.d.b
 * JD-Core Version:    0.7.0.1
 */