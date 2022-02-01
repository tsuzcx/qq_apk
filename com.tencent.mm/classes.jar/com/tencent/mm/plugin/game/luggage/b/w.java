package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONException;
import org.json.JSONObject;

public class w
  extends br<com.tencent.mm.plugin.game.luggage.f.g>
{
  public final void a(Context paramContext, String paramString, final bq.a parama)
  {
    AppMethodBeat.i(193002);
    JSONObject localJSONObject = com.tencent.mm.plugin.webview.luggage.c.b.PM(paramString);
    if (localJSONObject == null)
    {
      parama.f("invalid_data", null);
      AppMethodBeat.o(193002);
      return;
    }
    Bundle localBundle = new Bundle();
    boolean bool3 = false;
    bool1 = false;
    Object localObject1 = "";
    Object localObject5 = "";
    String str2 = "";
    Object localObject3 = str2;
    paramString = (String)localObject5;
    localObject4 = localObject1;
    bool2 = bool3;
    try
    {
      if (!localJSONObject.has("appId"))
      {
        localObject3 = str2;
        paramString = (String)localObject5;
        localObject4 = localObject1;
        bool2 = bool3;
        parama.f("invalid_data", null);
        AppMethodBeat.o(193002);
        return;
      }
      localObject3 = str2;
      paramString = (String)localObject5;
      localObject4 = localObject1;
      bool2 = bool3;
      localBundle.putString("appId", localJSONObject.getString("appId"));
      localObject3 = str2;
      paramString = (String)localObject5;
      localObject4 = localObject1;
      bool2 = bool3;
      String str1 = localJSONObject.getString("appId");
      localObject1 = localObject5;
      localObject3 = str2;
      paramString = (String)localObject5;
      localObject4 = str1;
      bool2 = bool3;
      if (localJSONObject.has("page"))
      {
        localObject3 = str2;
        paramString = (String)localObject5;
        localObject4 = str1;
        bool2 = bool3;
        localObject1 = localJSONObject.getString("page");
        localObject3 = str2;
        paramString = (String)localObject1;
        localObject4 = str1;
        bool2 = bool3;
        localBundle.putString("path", localJSONObject.getString("page"));
      }
      localObject3 = str2;
      paramString = (String)localObject1;
      localObject4 = str1;
      bool2 = bool3;
      if (localJSONObject.has("checkUpdate"))
      {
        localObject3 = str2;
        paramString = (String)localObject1;
        localObject4 = str1;
        bool2 = bool3;
        bool1 = localJSONObject.getBoolean("checkUpdate");
      }
      localObject5 = str2;
      localObject3 = str2;
      paramString = (String)localObject1;
      localObject4 = str1;
      bool2 = bool1;
      if (localJSONObject.has("query"))
      {
        localObject3 = str2;
        paramString = (String)localObject1;
        localObject4 = str1;
        bool2 = bool1;
        localObject5 = localJSONObject.getJSONObject("query").toString();
        localObject3 = localObject5;
        paramString = (String)localObject1;
        localObject4 = str1;
        bool2 = bool1;
        localBundle.putString("query", localJSONObject.getJSONObject("query").toString());
      }
      paramString = (String)localObject1;
      localObject1 = str1;
      localObject3 = localObject5;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ae.printErrStackTrace("JsApiOpenLiteApp", localJSONException, "", new Object[0]);
        parama.f("fail", null);
        Object localObject2 = localObject4;
        bool1 = bool2;
        continue;
        int i = 0;
      }
    }
    localBundle.putInt("nextAnimIn", 2130772144);
    localBundle.putInt("currentAnimOut", 2130772145);
    localObject4 = new StringBuilder();
    localObject3 = ((StringBuilder)localObject4).append((String)localObject1).append(",").append(paramString).append(",").append((String)localObject3).append(",");
    if (bool1)
    {
      i = 1;
      ((StringBuilder)localObject3).append(i);
      com.tencent.mm.plugin.report.service.g.yxI.kvStat(20980, ((StringBuilder)localObject4).toString());
      com.tencent.mm.plugin.report.service.g.yxI.n(1293L, 89L, 1L);
      ae.i("JsApiOpenLiteApp", "open liteapp:" + (String)localObject1 + ",page:" + paramString);
      ((a)com.tencent.mm.kernel.g.ab(a.class)).a(paramContext, localBundle, bool1, new a.a()
      {
        public final void cZN()
        {
          AppMethodBeat.i(193000);
          ae.i("JsApiOpenLiteApp", "JsApiOpenLiteApp success");
          parama.f(null, null);
          AppMethodBeat.o(193000);
        }
        
        public final void cZO()
        {
          AppMethodBeat.i(193001);
          ae.i("JsApiOpenLiteApp", "JsApiOpenLiteApp fail");
          parama.f("fail", null);
          AppMethodBeat.o(193001);
        }
      });
      AppMethodBeat.o(193002);
      return;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.game.luggage.f.g>.a paramb) {}
  
  public final int ced()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openLiteApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.w
 * JD-Core Version:    0.7.0.1
 */