package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
  extends bq<a>
{
  public final void a(Context paramContext, String paramString, bq.a parama)
  {
    AppMethodBeat.i(83063);
    AppMethodBeat.o(83063);
  }
  
  public final void b(final com.tencent.luggage.d.b<a>.a paramb)
  {
    AppMethodBeat.i(192993);
    ae.i("MicroMsg.JsApiClearGameData", "invokeInOwn");
    Object localObject2 = paramb.chh.cgn;
    Object localObject3 = (a)paramb.chg;
    if ((localObject3 instanceof com.tencent.mm.plugin.game.luggage.f.g))
    {
      localObject1 = ((com.tencent.mm.plugin.game.luggage.f.g)localObject3).EgL.getAppId();
      if (!bu.isNullOrNil((String)localObject1)) {
        break label234;
      }
      localObject1 = Uri.parse(bu.nullAsNil(((com.tencent.mm.plugin.game.luggage.f.g)localObject3).bRn()));
      if ((((Uri)localObject1).getHost() == null) || (!((Uri)localObject1).getHost().equals("game.weixin.qq.com")))
      {
        ae.i("MicroMsg.JsApiClearGameData", "appId is null");
        paramb.a("appid_null", null);
        AppMethodBeat.o(192993);
        return;
      }
    }
    Object localObject1 = "wx62d9035fd4fd2059";
    label234:
    for (;;)
    {
      localObject3 = ((JSONObject)localObject2).optJSONArray("keys");
      boolean bool = ((JSONObject)localObject2).optBoolean("clearAllData", false);
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("appId", (String)localObject1);
      if ((localObject3 != null) && (((JSONArray)localObject3).length() > 0)) {
        ((Bundle)localObject2).putString("keys", ((JSONArray)localObject3).toString());
      }
      for (;;)
      {
        h.a("com.tencent.mm", (Parcelable)localObject2, a.class, new d() {});
        AppMethodBeat.o(192993);
        return;
        if (!bool) {
          break;
        }
        ((Bundle)localObject2).putBoolean("clearAll", bool);
      }
      ae.i("MicroMsg.JsApiClearGameData", "keys is null");
      paramb.a("fail", null);
      AppMethodBeat.o(192993);
      return;
    }
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "clearGameData";
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.g
 * JD-Core Version:    0.7.0.1
 */