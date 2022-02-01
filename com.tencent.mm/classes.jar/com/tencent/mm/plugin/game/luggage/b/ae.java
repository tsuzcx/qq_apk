package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.j.a;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.lite.api.c.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class ae
  extends bw<GameWebPage>
{
  public final void a(Context paramContext, String paramString, final bv.a parama)
  {
    AppMethodBeat.i(277168);
    Object localObject2 = com.tencent.mm.plugin.webview.luggage.c.c.ZL(paramString);
    if (localObject2 == null)
    {
      parama.j("invalid_data", null);
      AppMethodBeat.o(277168);
      return;
    }
    Bundle localBundle = new Bundle();
    paramString = "";
    Object localObject1 = "";
    for (;;)
    {
      try
      {
        if (!((JSONObject)localObject2).has("appId"))
        {
          parama.j("invalid_appid", null);
          AppMethodBeat.o(277168);
          return;
        }
        localBundle.putString("appId", ((JSONObject)localObject2).getString("appId"));
        String str1 = ((JSONObject)localObject2).getString("appId");
        if (((JSONObject)localObject2).has("page"))
        {
          paramString = ((JSONObject)localObject2).getString("page");
          localBundle.putString("path", ((JSONObject)localObject2).getString("page"));
        }
        if (!((JSONObject)localObject2).has("checkUpdate")) {
          break label483;
        }
        bool = ((JSONObject)localObject2).getBoolean("checkUpdate");
        if (((JSONObject)localObject2).has("query"))
        {
          localObject1 = ((JSONObject)localObject2).getJSONObject("query").toString();
          localBundle.putString("query", ((JSONObject)localObject2).getJSONObject("query").toString());
        }
        if ((((JSONObject)localObject2).has("transparent")) && (((JSONObject)localObject2).getBoolean("transparent"))) {
          localBundle.putBoolean("transparent", true);
        }
        if (((JSONObject)localObject2).has("mode"))
        {
          String str2 = ((JSONObject)localObject2).getString("mode");
          if (!Util.isNullOrNil(str2)) {
            localBundle.putString("mode", str2);
          }
        }
        if (((JSONObject)localObject2).has("sheet_height"))
        {
          localObject2 = ((JSONObject)localObject2).getString("sheet_height");
          if (!Util.isNullOrNil((String)localObject2)) {
            localBundle.putString("sheet_height", (String)localObject2);
          }
        }
        localBundle.putInt("nextAnimIn", j.a.slide_right_in);
        localBundle.putInt("currentAnimOut", j.a.slide_right_out);
        localObject2 = new StringBuilder();
        localObject1 = ((StringBuilder)localObject2).append(str1).append(",").append(paramString).append(",").append((String)localObject1).append(",");
        if (bool)
        {
          i = 1;
          ((StringBuilder)localObject1).append(i);
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(20980, ((StringBuilder)localObject2).toString());
          com.tencent.mm.plugin.report.service.h.OAn.p(1293L, 89L, 1L);
          Log.i("JsApiOpenLiteApp", "open liteapp:" + str1 + ",page:" + paramString);
          ((com.tencent.mm.plugin.lite.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.lite.api.c.class)).a(paramContext, localBundle, bool, true, new c.a()
          {
            public final void csx()
            {
              AppMethodBeat.i(277155);
              Log.i("JsApiOpenLiteApp", "JsApiOpenLiteApp success");
              parama.j(null, null);
              AppMethodBeat.o(277155);
            }
            
            public final void csy()
            {
              AppMethodBeat.i(277159);
              Log.i("JsApiOpenLiteApp", "JsApiOpenLiteApp fail");
              parama.j("fail", null);
              AppMethodBeat.o(277159);
            }
          });
          AppMethodBeat.o(277168);
          return;
        }
      }
      catch (JSONException paramContext)
      {
        Log.printErrStackTrace("JsApiOpenLiteApp", paramContext, "", new Object[0]);
        parama.j("fail", null);
        AppMethodBeat.o(277168);
        return;
      }
      int i = 0;
      continue;
      label483:
      boolean bool = false;
    }
  }
  
  public final void b(b<GameWebPage>.a paramb) {}
  
  public final int dgI()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openLiteApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ae
 * JD-Core Version:    0.7.0.1
 */