package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.game.luggage.d.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.bn.a;
import com.tencent.mm.plugin.webview.luggage.jsapi.bo;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONObject;

public class z
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(83092);
    ac.i("MicroMsg.JsApiSetGameData", "invokeInOwn");
    Object localObject2 = parama.bWS.bVY;
    if (localObject2 == null)
    {
      ac.e("MicroMsg.JsApiSetGameData", "data is null");
      parama.a("null_data", null);
      AppMethodBeat.o(83092);
      return;
    }
    String str1 = ((JSONObject)localObject2).optString("preVerifyAppId");
    Object localObject1 = str1;
    final String str2;
    String str3;
    String str4;
    boolean bool1;
    boolean bool2;
    if (bs.isNullOrNil(str1))
    {
      localObject1 = Uri.parse(bs.nullAsNil(((f)parama.bWR).bLL()));
      if ((((Uri)localObject1).getHost() != null) && (((Uri)localObject1).getHost().equals("game.weixin.qq.com"))) {
        localObject1 = "wx62d9035fd4fd2059";
      }
    }
    else
    {
      str1 = ((JSONObject)localObject2).optString("key");
      str2 = ((JSONObject)localObject2).optString("value");
      str3 = ((JSONObject)localObject2).optString("weight", "1");
      str4 = ((JSONObject)localObject2).optString("expireTime");
      bool1 = ((JSONObject)localObject2).optBoolean("autoClean", true);
      bool2 = ((JSONObject)localObject2).optBoolean("pageCache", false);
      if ((!bs.isNullOrNil(str1)) && (!bs.isNullOrNil(str2)) && (str1.length() <= 80)) {
        break label232;
      }
      ac.i("MicroMsg.JsApiSetGameData", "key or value is invalid");
      parama.a("null_key", null);
      AppMethodBeat.o(83092);
      return;
    }
    ac.i("MicroMsg.JsApiSetGameData", "appId is null");
    parama.a("appid_null", null);
    AppMethodBeat.o(83092);
    return;
    label232:
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("appId", (String)localObject1);
    ((Bundle)localObject2).putString("key", str1);
    ((Bundle)localObject2).putString("weight", str3);
    ((Bundle)localObject2).putString("expireTime", str4);
    ((Bundle)localObject2).putBoolean("autoClean", bool1);
    com.tencent.mm.plugin.webview.b.b.eze();
    long l = com.tencent.mm.plugin.webview.b.b.kk(str1, str2);
    ((Bundle)localObject2).putLong("storeSize", l);
    if ((l <= 204800L) && (!bool2)) {
      ((Bundle)localObject2).putString("value", str2);
    }
    if (bool2)
    {
      if (((com.tencent.mm.game.report.a.b)g.ab(com.tencent.mm.game.report.a.b.class)).a(b.a.pMD, 0) == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        bool2 = ((f)parama.bWR).cOT().CZz;
        ac.i("MicroMsg.JsApiSetGameData", "isOpenPageCache:%b, allowSetPageCache:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if (bool1) {
          break;
        }
        parama.a("close_page_cache", null);
        AppMethodBeat.o(83092);
        return;
      }
      if (!bool2)
      {
        parama.a("ban_set_page_cache", null);
        AppMethodBeat.o(83092);
        return;
      }
    }
    h.a("com.tencent.mm", (Parcelable)localObject2, a.class, new d() {});
    AppMethodBeat.o(83092);
  }
  
  public final int bYk()
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
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.z
 * JD-Core Version:    0.7.0.1
 */