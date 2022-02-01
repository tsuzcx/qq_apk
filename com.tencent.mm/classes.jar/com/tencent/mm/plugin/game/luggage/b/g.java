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
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.json.JSONArray;
import org.json.JSONObject;

public class g
  extends br<a>
{
  public final void a(Context paramContext, String paramString, br.a parama)
  {
    AppMethodBeat.i(83063);
    AppMethodBeat.o(83063);
  }
  
  public final void b(final com.tencent.luggage.d.b<a>.a paramb)
  {
    AppMethodBeat.i(186854);
    Log.i("MicroMsg.JsApiClearGameData", "invokeInOwn");
    Object localObject2 = paramb.ctb.csi;
    Object localObject3 = (a)paramb.cta;
    if ((localObject3 instanceof i))
    {
      localObject1 = ((i)localObject3).ITw.getAppId();
      if (!Util.isNullOrNil((String)localObject1)) {
        break label238;
      }
      localObject1 = Uri.parse(Util.nullAsNil(((i)localObject3).coX()));
      if ((((Uri)localObject1).getHost() == null) || (!((Uri)localObject1).getHost().equals(WeChatHosts.domainString(2131761707))))
      {
        Log.i("MicroMsg.JsApiClearGameData", "appId is null");
        paramb.c("appid_null", null);
        AppMethodBeat.o(186854);
        return;
      }
    }
    Object localObject1 = "wx62d9035fd4fd2059";
    label238:
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
        h.a(MainProcessIPCService.dkO, (Parcelable)localObject2, a.class, new d() {});
        AppMethodBeat.o(186854);
        return;
        if (!bool) {
          break;
        }
        ((Bundle)localObject2).putBoolean("clearAll", bool);
      }
      Log.i("MicroMsg.JsApiClearGameData", "keys is null");
      paramb.c("fail", null);
      AppMethodBeat.o(186854);
      return;
    }
  }
  
  public final int dTs()
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