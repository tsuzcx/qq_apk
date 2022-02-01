package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class z
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(186881);
    JSONObject localJSONObject = com.tencent.mm.plugin.webview.luggage.c.b.Zc(paramString);
    if (localJSONObject == null)
    {
      parama.i("invalid_data", null);
      AppMethodBeat.o(186881);
      return;
    }
    Bundle localBundle = new Bundle();
    boolean bool3 = false;
    bool1 = false;
    Object localObject3 = "";
    Object localObject2 = "";
    String str3 = "";
    paramString = str3;
    localObject1 = localObject2;
    localObject4 = localObject3;
    bool2 = bool3;
    try
    {
      if (!localJSONObject.has("appId"))
      {
        paramString = str3;
        localObject1 = localObject2;
        localObject4 = localObject3;
        bool2 = bool3;
        parama.i("invalid_appid", null);
        AppMethodBeat.o(186881);
        return;
      }
      paramString = str3;
      localObject1 = localObject2;
      localObject4 = localObject3;
      bool2 = bool3;
      localBundle.putString("appId", localJSONObject.getString("appId"));
      paramString = str3;
      localObject1 = localObject2;
      localObject4 = localObject3;
      bool2 = bool3;
      String str2 = localJSONObject.getString("appId");
      localObject3 = localObject2;
      paramString = str3;
      localObject1 = localObject2;
      localObject4 = str2;
      bool2 = bool3;
      if (localJSONObject.has("page"))
      {
        paramString = str3;
        localObject1 = localObject2;
        localObject4 = str2;
        bool2 = bool3;
        localObject3 = localJSONObject.getString("page");
        paramString = str3;
        localObject1 = localObject3;
        localObject4 = str2;
        bool2 = bool3;
        localBundle.putString("path", localJSONObject.getString("page"));
      }
      paramString = str3;
      localObject1 = localObject3;
      localObject4 = str2;
      bool2 = bool3;
      if (localJSONObject.has("checkUpdate"))
      {
        paramString = str3;
        localObject1 = localObject3;
        localObject4 = str2;
        bool2 = bool3;
        bool1 = localJSONObject.getBoolean("checkUpdate");
      }
      localObject2 = str3;
      paramString = str3;
      localObject1 = localObject3;
      localObject4 = str2;
      bool2 = bool1;
      if (localJSONObject.has("query"))
      {
        paramString = str3;
        localObject1 = localObject3;
        localObject4 = str2;
        bool2 = bool1;
        localObject2 = localJSONObject.getJSONObject("query").toString();
        paramString = (String)localObject2;
        localObject1 = localObject3;
        localObject4 = str2;
        bool2 = bool1;
        localBundle.putString("query", localJSONObject.getJSONObject("query").toString());
      }
      paramString = (String)localObject2;
      localObject1 = localObject3;
      localObject4 = str2;
      bool2 = bool1;
      if (localJSONObject.has("transparent"))
      {
        paramString = (String)localObject2;
        localObject1 = localObject3;
        localObject4 = str2;
        bool2 = bool1;
        if (localJSONObject.getBoolean("transparent"))
        {
          paramString = (String)localObject2;
          localObject1 = localObject3;
          localObject4 = str2;
          bool2 = bool1;
          localBundle.putBoolean("transparent", true);
        }
      }
      paramString = (String)localObject3;
      localObject1 = str2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.printErrStackTrace("JsApiOpenLiteApp", localJSONException, "", new Object[0]);
        parama.i("fail", null);
        bool1 = bool2;
        String str1 = paramString;
        paramString = localObject1;
        localObject1 = localObject4;
        continue;
        int i = 0;
      }
    }
    localBundle.putInt("nextAnimIn", 2130772169);
    localBundle.putInt("currentAnimOut", 2130772170);
    localObject3 = new StringBuilder();
    localObject2 = ((StringBuilder)localObject3).append(localObject1).append(",").append(paramString).append(",").append((String)localObject2).append(",");
    if (bool1)
    {
      i = 1;
      ((StringBuilder)localObject2).append(i);
      h.CyF.kvStat(20980, ((StringBuilder)localObject3).toString());
      h.CyF.n(1293L, 89L, 1L);
      Log.i("JsApiOpenLiteApp", "open liteapp:" + localObject1 + ",page:" + paramString);
      ((a)g.af(a.class)).a(paramContext, localBundle, bool1, new a.a()
      {
        public final void dTt()
        {
          AppMethodBeat.i(186879);
          Log.i("JsApiOpenLiteApp", "JsApiOpenLiteApp success");
          parama.i(null, null);
          AppMethodBeat.o(186879);
        }
        
        public final void dTu()
        {
          AppMethodBeat.i(186880);
          Log.i("JsApiOpenLiteApp", "JsApiOpenLiteApp fail");
          parama.i("fail", null);
          AppMethodBeat.o(186880);
        }
      });
      AppMethodBeat.o(186881);
      return;
    }
  }
  
  public final void b(com.tencent.luggage.d.b<i>.a paramb) {}
  
  public final int dTs()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openLiteApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.z
 * JD-Core Version:    0.7.0.1
 */