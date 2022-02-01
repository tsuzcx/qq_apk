package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.br.a;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.plugin.wepkg.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import org.json.JSONObject;

public class ah
  extends br<a>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<a>.a paramb)
  {
    AppMethodBeat.i(83092);
    Log.i("MicroMsg.JsApiSetGameData", "invokeInOwn");
    Object localObject2 = paramb.ctb.csi;
    if (localObject2 == null)
    {
      Log.e("MicroMsg.JsApiSetGameData", "data is null");
      paramb.c("null_data", null);
      AppMethodBeat.o(83092);
      return;
    }
    a locala = (a)paramb.cta;
    if ((locala instanceof i))
    {
      str1 = ((i)locala).ITw.getAppId();
      localObject1 = str1;
      if (!Util.isNullOrNil(str1)) {
        break label152;
      }
      localObject1 = Uri.parse(Util.nullAsNil(((i)locala).coX()));
      if ((((Uri)localObject1).getHost() == null) || (!((Uri)localObject1).getHost().equals(WeChatHosts.domainString(2131761707))))
      {
        Log.i("MicroMsg.JsApiSetGameData", "appId is null");
        paramb.c("appid_null", null);
        AppMethodBeat.o(83092);
        return;
      }
    }
    Object localObject1 = "wx62d9035fd4fd2059";
    label152:
    String str1 = ((JSONObject)localObject2).optString("key");
    final String str2 = ((JSONObject)localObject2).optString("value");
    String str3 = ((JSONObject)localObject2).optString("weight", "1");
    String str4 = ((JSONObject)localObject2).optString("expireTime");
    boolean bool1 = ((JSONObject)localObject2).optBoolean("autoClean", true);
    boolean bool2 = ((JSONObject)localObject2).optBoolean("pageCache", false);
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)) || (str1.length() > 80))
    {
      Log.i("MicroMsg.JsApiSetGameData", "key or value is invalid");
      paramb.c("null_key", null);
      AppMethodBeat.o(83092);
      return;
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("appId", (String)localObject1);
    ((Bundle)localObject2).putString("key", str1);
    ((Bundle)localObject2).putString("weight", str3);
    ((Bundle)localObject2).putString("expireTime", str4);
    ((Bundle)localObject2).putBoolean("autoClean", bool1);
    com.tencent.mm.plugin.webview.b.b.gam();
    long l = com.tencent.mm.plugin.webview.b.b.lM(str1, str2);
    ((Bundle)localObject2).putLong("storeSize", l);
    if ((l <= 204800L) && (!bool2)) {
      ((Bundle)localObject2).putString("value", str2);
    }
    if (bool2) {
      if ((locala instanceof i))
      {
        if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.rOO, 0) == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = ((i)locala).dTP().JLM;
          Log.i("MicroMsg.JsApiSetGameData", "isOpenPageCache:%b, allowSetPageCache:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (bool1) {
            break;
          }
          paramb.c("close_page_cache", null);
          AppMethodBeat.o(83092);
          return;
        }
        if (!bool2)
        {
          paramb.c("ban_set_page_cache", null);
          AppMethodBeat.o(83092);
        }
      }
      else
      {
        paramb.c("ban_set_page_cache", null);
      }
    }
    h.a(MainProcessIPCService.dkO, (Parcelable)localObject2, a.class, new d() {});
    AppMethodBeat.o(83092);
  }
  
  public final int dTs()
  {
    return 0;
  }
  
  public final String name()
  {
    return "setGameData";
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ah
 * JD-Core Version:    0.7.0.1
 */