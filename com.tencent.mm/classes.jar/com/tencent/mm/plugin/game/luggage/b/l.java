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
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.json.JSONObject;

public class l
  extends br<a>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<a>.a paramb)
  {
    AppMethodBeat.i(83069);
    Log.i("MicroMsg.JsApiGetGameData", "invokeInOwn");
    Object localObject2 = paramb.ctb.csi;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.JsApiGetGameData", "data is null");
      paramb.c("null_data", null);
      AppMethodBeat.o(83069);
      return;
    }
    Object localObject3 = (a)paramb.cta;
    if ((localObject3 instanceof i))
    {
      localObject1 = ((i)localObject3).ITw.getAppId();
      if (!Util.isNullOrNil((String)localObject1)) {
        break label225;
      }
      localObject1 = Uri.parse(Util.nullAsNil(((i)localObject3).coX()));
      if ((((Uri)localObject1).getHost() == null) || (!((Uri)localObject1).getHost().equals(WeChatHosts.domainString(2131761707))))
      {
        Log.i("MicroMsg.JsApiGetGameData", "appId is null");
        paramb.c("appid_null", null);
        AppMethodBeat.o(83069);
        return;
      }
    }
    Object localObject1 = "wx62d9035fd4fd2059";
    label225:
    for (;;)
    {
      localObject2 = ((JSONObject)localObject2).optString("key");
      if (Util.isNullOrNil((String)localObject2))
      {
        Log.i("MicroMsg.JsApiGetGameData", "key is null");
        paramb.c("null_key", null);
        AppMethodBeat.o(83069);
        return;
      }
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("appId", (String)localObject1);
      ((Bundle)localObject3).putString("key", (String)localObject2);
      h.a(MainProcessIPCService.dkO, (Parcelable)localObject3, a.class, new d() {});
      AppMethodBeat.o(83069);
      return;
    }
  }
  
  public final int dTs()
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.l
 * JD-Core Version:    0.7.0.1
 */