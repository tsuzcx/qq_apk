package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama)
  {
    AppMethodBeat.i(83063);
    ad.i("MicroMsg.JsApiClearGameData", "invokeInMM");
    try
    {
      paramContext = new JSONObject(paramString);
      if (paramContext == null)
      {
        ad.e("MicroMsg.JsApiClearGameData", "data is null");
        parama.f("null_data", null);
        AppMethodBeat.o(83063);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
      Object localObject = paramContext.optString("preVerifyAppId");
      paramString = (String)localObject;
      boolean bool;
      if (bt.isNullOrNil((String)localObject))
      {
        paramString = Uri.parse(paramContext.optString("currentUrl"));
        if ((paramString.getHost() != null) && (paramString.getHost().equals("game.weixin.qq.com"))) {
          paramString = "wx62d9035fd4fd2059";
        }
      }
      else
      {
        localObject = paramContext.optJSONArray("keys");
        bool = paramContext.optBoolean("clearAllData", false);
        if ((localObject == null) || (((JSONArray)localObject).length() <= 0)) {
          break label173;
        }
        b.ejJ().b(paramString, (JSONArray)localObject);
        parama.f(null, null);
        AppMethodBeat.o(83063);
        return;
      }
      ad.i("MicroMsg.JsApiClearGameData", "appId is null");
      parama.f("appid_null", null);
      AppMethodBeat.o(83063);
      return;
      label173:
      if (bool)
      {
        b.ejJ().avM(paramString);
        parama.f(null, null);
        AppMethodBeat.o(83063);
        return;
      }
      ad.i("MicroMsg.JsApiClearGameData", "keys is null");
      parama.f("fail", null);
      AppMethodBeat.o(83063);
    }
  }
  
  public final void b(a<f>.a parama) {}
  
  public final int bQV()
  {
    return 1;
  }
  
  public final String name()
  {
    return "clearGameData";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */