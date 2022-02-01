package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public class j
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(83069);
    ad.i("MicroMsg.JsApiGetGameData", "invokeInMM");
    Object localObject2 = parama.bZV.bZb;
    if (localObject2 == null)
    {
      ad.e("MicroMsg.JsApiGetGameData", "data is null");
      parama.a("null_data", null);
      AppMethodBeat.o(83069);
      return;
    }
    String str = ((JSONObject)localObject2).optString("preVerifyAppId");
    Object localObject1 = str;
    if (bt.isNullOrNil(str))
    {
      localObject1 = Uri.parse(bt.nullAsNil(((f)parama.bZU).bEx()));
      if ((((Uri)localObject1).getHost() != null) && (((Uri)localObject1).getHost().equals("game.weixin.qq.com"))) {
        localObject1 = "wx62d9035fd4fd2059";
      }
    }
    else
    {
      str = ((JSONObject)localObject2).optString("key");
      if (!bt.isNullOrNil(str)) {
        break label157;
      }
      ad.i("MicroMsg.JsApiGetGameData", "key is null");
      parama.a("null_key", null);
      AppMethodBeat.o(83069);
      return;
    }
    ad.i("MicroMsg.JsApiGetGameData", "appId is null");
    parama.a("appid_null", null);
    AppMethodBeat.o(83069);
    return;
    label157:
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("appId", (String)localObject1);
    ((Bundle)localObject2).putString("key", str);
    h.a("com.tencent.mm", (Parcelable)localObject2, a.class, new d() {});
    AppMethodBeat.o(83069);
  }
  
  public final int bQV()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getGameData";
  }
  
  static class a
    implements b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.j
 * JD-Core Version:    0.7.0.1
 */