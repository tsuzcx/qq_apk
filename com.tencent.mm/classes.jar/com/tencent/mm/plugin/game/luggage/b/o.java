package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.luggage.j.f;
import com.tencent.mm.plugin.game.luggage.page.GameWebPage;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv;
import com.tencent.mm.plugin.webview.luggage.jsapi.bv.a;
import com.tencent.mm.plugin.webview.luggage.x;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.json.JSONObject;

public class o
  extends bv<com.tencent.luggage.d.a>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<com.tencent.luggage.d.a>.a paramb)
  {
    AppMethodBeat.i(83069);
    Log.i("MicroMsg.JsApiGetGameData", "invokeInOwn");
    Object localObject2 = paramb.eiZ.eif;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.JsApiGetGameData", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(83069);
      return;
    }
    Object localObject3 = (com.tencent.luggage.d.a)paramb.eiY;
    if ((localObject3 instanceof GameWebPage))
    {
      localObject1 = ((GameWebPage)localObject3).WGh.getAppId();
      if (!Util.isNullOrNil((String)localObject1)) {
        break label226;
      }
      localObject1 = Uri.parse(Util.nullAsNil(((GameWebPage)localObject3).dgY()));
      if ((((Uri)localObject1).getHost() == null) || (!((Uri)localObject1).getHost().equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com))))
      {
        Log.i("MicroMsg.JsApiGetGameData", "appId is null");
        paramb.a("appid_null", null);
        AppMethodBeat.o(83069);
        return;
      }
    }
    Object localObject1 = "wx62d9035fd4fd2059";
    label226:
    for (;;)
    {
      localObject2 = ((JSONObject)localObject2).optString("key");
      if (Util.isNullOrNil((String)localObject2))
      {
        Log.i("MicroMsg.JsApiGetGameData", "key is null");
        paramb.a("null_key", null);
        AppMethodBeat.o(83069);
        return;
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("appId", (String)localObject1);
      ((Bundle)localObject3).putString("key", (String)localObject2);
      j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject3, a.class, new f() {});
      AppMethodBeat.o(83069);
      return;
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "getGameData";
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.o
 * JD-Core Version:    0.7.0.1
 */