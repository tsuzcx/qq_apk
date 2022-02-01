package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.game.luggage.j.a;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.lite.a.a.a;
import com.tencent.mm.plugin.webview.luggage.c.c;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class aa
  extends bs<i>
{
  public final void a(Context paramContext, String paramString, final br.a parama)
  {
    AppMethodBeat.i(231063);
    JSONObject localJSONObject = c.agO(paramString);
    if (localJSONObject == null)
    {
      parama.i("invalid_data", null);
      AppMethodBeat.o(231063);
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
        AppMethodBeat.o(231063);
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
      paramString = (String)localObject2;
      localObject1 = localObject3;
      localObject4 = str2;
      bool2 = bool1;
      if (localJSONObject.has("mode"))
      {
        paramString = (String)localObject2;
        localObject1 = localObject3;
        localObject4 = str2;
        bool2 = bool1;
        str3 = localJSONObject.getString("mode");
        paramString = (String)localObject2;
        localObject1 = localObject3;
        localObject4 = str2;
        bool2 = bool1;
        if (!Util.isNullOrNil(str3))
        {
          paramString = (String)localObject2;
          localObject1 = localObject3;
          localObject4 = str2;
          bool2 = bool1;
          localBundle.putString("mode", str3);
        }
      }
      paramString = (String)localObject2;
      localObject1 = localObject3;
      localObject4 = str2;
      bool2 = bool1;
      if (localJSONObject.has("sheet_height"))
      {
        paramString = (String)localObject2;
        localObject1 = localObject3;
        localObject4 = str2;
        bool2 = bool1;
        str3 = localJSONObject.getString("sheet_height");
        paramString = (String)localObject2;
        localObject1 = localObject3;
        localObject4 = str2;
        bool2 = bool1;
        if (!Util.isNullOrNil(str3))
        {
          paramString = (String)localObject2;
          localObject1 = localObject3;
          localObject4 = str2;
          bool2 = bool1;
          localBundle.putString("sheet_height", str3);
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
    localBundle.putInt("nextAnimIn", j.a.slide_right_in);
    localBundle.putInt("currentAnimOut", j.a.slide_right_out);
    localObject3 = new StringBuilder();
    localObject2 = ((StringBuilder)localObject3).append(localObject1).append(",").append(paramString).append(",").append((String)localObject2).append(",");
    if (bool1)
    {
      i = 1;
      ((StringBuilder)localObject2).append(i);
      com.tencent.mm.plugin.report.service.h.IzE.kvStat(20980, ((StringBuilder)localObject3).toString());
      com.tencent.mm.plugin.report.service.h.IzE.p(1293L, 89L, 1L);
      Log.i("JsApiOpenLiteApp", "open liteapp:" + localObject1 + ",page:" + paramString);
      ((a)com.tencent.mm.kernel.h.ae(a.class)).a(paramContext, localBundle, bool1, new a.a()
      {
        public final void ewC()
        {
          AppMethodBeat.i(231276);
          Log.i("JsApiOpenLiteApp", "JsApiOpenLiteApp success");
          parama.i(null, null);
          AppMethodBeat.o(231276);
        }
        
        public final void ewD()
        {
          AppMethodBeat.i(231277);
          Log.i("JsApiOpenLiteApp", "JsApiOpenLiteApp fail");
          parama.i("fail", null);
          AppMethodBeat.o(231277);
        }
      });
      AppMethodBeat.o(231063);
      return;
    }
  }
  
  public final void b(b<i>.a paramb) {}
  
  public final int cDj()
  {
    return 1;
  }
  
  public final String name()
  {
    return "openLiteApp";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.aa
 * JD-Core Version:    0.7.0.1
 */