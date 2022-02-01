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
import org.json.JSONArray;
import org.json.JSONObject;

public class h
  extends bv<com.tencent.luggage.d.a>
{
  public final void a(Context paramContext, String paramString, bv.a parama)
  {
    AppMethodBeat.i(83063);
    AppMethodBeat.o(83063);
  }
  
  public final void b(final b<com.tencent.luggage.d.a>.a paramb)
  {
    AppMethodBeat.i(277133);
    Log.i("MicroMsg.JsApiClearGameData", "invokeInOwn");
    Object localObject2 = paramb.eiZ.eif;
    Object localObject3 = (com.tencent.luggage.d.a)paramb.eiY;
    if ((localObject3 instanceof GameWebPage))
    {
      localObject1 = ((GameWebPage)localObject3).WGh.getAppId();
      if (!Util.isNullOrNil((String)localObject1)) {
        break label239;
      }
      localObject1 = Uri.parse(Util.nullAsNil(((GameWebPage)localObject3).dgY()));
      if ((((Uri)localObject1).getHost() == null) || (!((Uri)localObject1).getHost().equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com))))
      {
        Log.i("MicroMsg.JsApiClearGameData", "appId is null");
        paramb.a("appid_null", null);
        AppMethodBeat.o(277133);
        return;
      }
    }
    Object localObject1 = "wx62d9035fd4fd2059";
    label239:
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
        j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject2, a.class, new f() {});
        AppMethodBeat.o(277133);
        return;
        if (!bool) {
          break;
        }
        ((Bundle)localObject2).putBoolean("clearAll", bool);
      }
      Log.i("MicroMsg.JsApiClearGameData", "keys is null");
      paramb.a("fail", null);
      AppMethodBeat.o(277133);
      return;
    }
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "clearGameData";
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.h
 * JD-Core Version:    0.7.0.1
 */