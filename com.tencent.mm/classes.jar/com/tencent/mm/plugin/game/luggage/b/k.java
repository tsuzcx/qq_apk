package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
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
import org.json.JSONObject;

public class k
  extends bq<a>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<a>.a paramb)
  {
    AppMethodBeat.i(83069);
    ae.i("MicroMsg.JsApiGetGameData", "invokeInOwn");
    Object localObject2 = paramb.chh.cgn;
    if (localObject2 == null)
    {
      ae.e("MicroMsg.JsApiGetGameData", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(83069);
      return;
    }
    Object localObject3 = (a)paramb.chg;
    if ((localObject3 instanceof com.tencent.mm.plugin.game.luggage.f.g))
    {
      localObject1 = ((com.tencent.mm.plugin.game.luggage.f.g)localObject3).EgL.getAppId();
      if (!bu.isNullOrNil((String)localObject1)) {
        break label221;
      }
      localObject1 = Uri.parse(bu.nullAsNil(((com.tencent.mm.plugin.game.luggage.f.g)localObject3).bRn()));
      if ((((Uri)localObject1).getHost() == null) || (!((Uri)localObject1).getHost().equals("game.weixin.qq.com")))
      {
        ae.i("MicroMsg.JsApiGetGameData", "appId is null");
        paramb.a("appid_null", null);
        AppMethodBeat.o(83069);
        return;
      }
    }
    Object localObject1 = "wx62d9035fd4fd2059";
    label221:
    for (;;)
    {
      localObject2 = ((JSONObject)localObject2).optString("key");
      if (bu.isNullOrNil((String)localObject2))
      {
        ae.i("MicroMsg.JsApiGetGameData", "key is null");
        paramb.a("null_key", null);
        AppMethodBeat.o(83069);
        return;
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("appId", (String)localObject1);
      ((Bundle)localObject3).putString("key", (String)localObject2);
      h.a("com.tencent.mm", (Parcelable)localObject3, a.class, new d() {});
      AppMethodBeat.o(83069);
      return;
    }
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getGameData";
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.k
 * JD-Core Version:    0.7.0.1
 */