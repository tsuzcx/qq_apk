package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq;
import com.tencent.mm.plugin.webview.luggage.jsapi.bq.a;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONObject;

public class ae
  extends bq<a>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<a>.a paramb)
  {
    AppMethodBeat.i(83092);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiSetGameData", "invokeInOwn");
    Object localObject2 = paramb.chh.cgn;
    if (localObject2 == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.JsApiSetGameData", "data is null");
      paramb.a("null_data", null);
      AppMethodBeat.o(83092);
      return;
    }
    a locala = (a)paramb.chg;
    if ((locala instanceof com.tencent.mm.plugin.game.luggage.f.g))
    {
      str1 = ((com.tencent.mm.plugin.game.luggage.f.g)locala).EgL.getAppId();
      localObject1 = str1;
      if (!bu.isNullOrNil(str1)) {
        break label149;
      }
      localObject1 = Uri.parse(bu.nullAsNil(((com.tencent.mm.plugin.game.luggage.f.g)locala).bRn()));
      if ((((Uri)localObject1).getHost() == null) || (!((Uri)localObject1).getHost().equals("game.weixin.qq.com")))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiSetGameData", "appId is null");
        paramb.a("appid_null", null);
        AppMethodBeat.o(83092);
        return;
      }
    }
    Object localObject1 = "wx62d9035fd4fd2059";
    label149:
    String str1 = ((JSONObject)localObject2).optString("key");
    final String str2 = ((JSONObject)localObject2).optString("value");
    String str3 = ((JSONObject)localObject2).optString("weight", "1");
    String str4 = ((JSONObject)localObject2).optString("expireTime");
    boolean bool1 = ((JSONObject)localObject2).optBoolean("autoClean", true);
    boolean bool2 = ((JSONObject)localObject2).optBoolean("pageCache", false);
    if ((bu.isNullOrNil(str1)) || (bu.isNullOrNil(str2)) || (str1.length() > 80))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiSetGameData", "key or value is invalid");
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
    com.tencent.mm.plugin.webview.b.b.eRE();
    long l = com.tencent.mm.plugin.webview.b.b.kP(str1, str2);
    ((Bundle)localObject2).putLong("storeSize", l);
    if ((l <= 204800L) && (!bool2)) {
      ((Bundle)localObject2).putString("value", str2);
    }
    if (bool2) {
      if ((locala instanceof com.tencent.mm.plugin.game.luggage.f.g))
      {
        if (((com.tencent.mm.game.report.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.game.report.a.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qxb, 0) == 1) {}
        for (bool1 = true;; bool1 = false)
        {
          bool2 = ((com.tencent.mm.plugin.game.luggage.f.g)locala).dag().EVT;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.JsApiSetGameData", "isOpenPageCache:%b, allowSetPageCache:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
    h.a("com.tencent.mm", (Parcelable)localObject2, a.class, new com.tencent.mm.ipcinvoker.d() {});
    AppMethodBeat.o(83092);
  }
  
  public final int ced()
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.ae
 * JD-Core Version:    0.7.0.1
 */