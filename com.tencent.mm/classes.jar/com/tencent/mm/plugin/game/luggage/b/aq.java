package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
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

public class aq
  extends bv<com.tencent.luggage.d.a>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<com.tencent.luggage.d.a>.a paramb)
  {
    AppMethodBeat.i(83092);
    Log.i("MicroMsg.JsApiSetGameData", "invokeInOwn");
    Object localObject2 = paramb.eiZ.eif;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.JsApiSetGameData", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(83092);
      return;
    }
    com.tencent.luggage.d.a locala = (com.tencent.luggage.d.a)paramb.eiY;
    if ((locala instanceof GameWebPage))
    {
      str1 = ((GameWebPage)locala).WGh.getAppId();
      localObject1 = str1;
      if (!Util.isNullOrNil(str1)) {
        break label153;
      }
      localObject1 = Uri.parse(Util.nullAsNil(((GameWebPage)locala).dgY()));
      if ((((Uri)localObject1).getHost() == null) || (!((Uri)localObject1).getHost().equals(WeChatHosts.domainString(j.f.host_game_weixin_qq_com))))
      {
        Log.i("MicroMsg.JsApiSetGameData", "appId is null");
        paramb.a("appid_null", null);
        AppMethodBeat.o(83092);
        return;
      }
    }
    Object localObject1 = "wx62d9035fd4fd2059";
    label153:
    String str1 = ((JSONObject)localObject2).optString("key");
    final String str2 = ((JSONObject)localObject2).optString("value");
    String str3 = ((JSONObject)localObject2).optString("weight", "1");
    String str4 = ((JSONObject)localObject2).optString("expireTime");
    boolean bool1 = ((JSONObject)localObject2).optBoolean("autoClean", true);
    boolean bool2 = ((JSONObject)localObject2).optBoolean("pageCache", false);
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)) || (str1.length() > 80))
    {
      Log.i("MicroMsg.JsApiSetGameData", "key or value is invalid");
      paramb.a("null_key", null);
      AppMethodBeat.o(83092);
      return;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("appId", (String)localObject1);
    ((Bundle)localObject2).putString("key", str1);
    ((Bundle)localObject2).putString("weight", str3);
    ((Bundle)localObject2).putString("expireTime", str4);
    ((Bundle)localObject2).putBoolean("autoClean", bool1);
    com.tencent.mm.plugin.webview.b.b.isU();
    long l = com.tencent.mm.plugin.webview.b.b.ob(str1, str2);
    ((Bundle)localObject2).putLong("storeSize", l);
    if ((l <= 204800L) && (!bool2)) {
      ((Bundle)localObject2).putString("value", str2);
    }
    if (bool2) {
      if ((locala instanceof GameWebPage))
      {
        if (((com.tencent.mm.game.report.a.b)h.ax(com.tencent.mm.game.report.a.b.class)).a(c.a.yHK, 0) == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = ((GameWebPage)locala).fES().XEE;
          Log.i("MicroMsg.JsApiSetGameData", "isOpenPageCache:%b, allowSetPageCache:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (bool1) {
            break;
          }
          paramb.a("close_page_cache", null);
          AppMethodBeat.o(83092);
          return;
        }
        if (!bool2)
        {
          paramb.a("ban_set_page_cache", null);
          AppMethodBeat.o(83092);
        }
      }
      else
      {
        paramb.a("ban_set_page_cache", null);
      }
    }
    j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localObject2, a.class, new com.tencent.mm.ipcinvoker.f() {});
    AppMethodBeat.o(83092);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setGameData";
  }
  
  @com.tencent.mm.ipcinvoker.c.a
  static class a
    implements d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.aq
 * JD-Core Version:    0.7.0.1
 */