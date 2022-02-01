package com.tencent.mm.plugin.lite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.jsapi.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "preloadLogin", "liteAppInfo", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "Companion", "luggage-lite-app_release"})
public final class LiteAppTaskPreloadReceiver
  extends BroadcastReceiver
{
  public static final a EfG;
  
  static
  {
    AppMethodBeat.i(234316);
    EfG = new a((byte)0);
    AppMethodBeat.o(234316);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(234313);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.WxaLiteAppTaskPreloadReceiver", "onReceive NULL intent.");
      AppMethodBeat.o(234313);
      return;
    }
    a.EfC.VE(6);
    if ((paramIntent.hasExtra("task")) && (paramIntent.hasExtra("appId")) && (p.h(paramIntent.getStringExtra("task"), "prelogin")))
    {
      localObject = paramIntent.getStringExtra("appId");
      f.eLH();
      paramContext = f.cY((String)localObject);
      if (paramContext != null) {
        break label182;
      }
      Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", (String)localObject + " is not existed");
    }
    for (;;)
    {
      if ((paramIntent.hasExtra("task")) && (p.h(paramIntent.getStringExtra("task"), "updateBaseLibPath")))
      {
        Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "receive set baselib path");
        paramContext = a.EfC;
        a.a.eLy();
      }
      if ((!paramIntent.hasExtra("task")) || (!p.h(paramIntent.getStringExtra("task"), "preloadLiteApp"))) {
        break label336;
      }
      if (paramIntent.hasExtra("appId")) {
        break;
      }
      AppMethodBeat.o(234313);
      return;
      label182:
      localObject = LiteAppCenter.getAuthUrl(paramContext.path, paramContext.appId, paramContext.coX);
      com.tencent.mm.plugin.lite.jsapi.a.EfS.a((String)localObject, (a.b)new b(paramContext));
    }
    paramContext = paramIntent.getStringExtra("appId");
    Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "receive preload liteapp: ".concat(String.valueOf(paramContext)));
    f.eLH();
    Object localObject = f.cY(paramContext);
    if (localObject == null)
    {
      Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", paramContext + " is not existed");
      AppMethodBeat.o(234313);
      return;
    }
    if (paramIntent.hasExtra("path"))
    {
      LiteAppCenter.preloadView(paramContext, paramIntent.getStringExtra("path"), u.n(((WxaLiteAppInfo)localObject).path, true), ((WxaLiteAppInfo)localObject).coX);
      AppMethodBeat.o(234313);
      return;
    }
    LiteAppCenter.preloadIndexView(paramContext, u.n(((WxaLiteAppInfo)localObject).path, true), ((WxaLiteAppInfo)localObject).coX);
    label336:
    AppMethodBeat.o(234313);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver$Companion;", "", "()V", "TAG", "", "kAppIdKey", "kPathKey", "kPreLoginTask", "kPreloadLiteApp", "kTaskKey", "kUpdateBaseLibPathTask", "luggage-lite-app_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver$preloadLogin$1", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key$LiteAppGetA8KeyCallback;", "onError", "", "onSuccess", "info", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key$AuthInfo;", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key;", "luggage-lite-app_release"})
  public static final class b
    implements a.b
  {
    b(WxaLiteAppInfo paramWxaLiteAppInfo) {}
    
    public final void a(com.tencent.mm.plugin.lite.jsapi.a.a parama)
    {
      AppMethodBeat.i(234299);
      p.k(parama, "info");
      Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key success:" + this.EfH.appId);
      LiteAppCenter.setAuthInfo(this.EfH.appId, parama.EfX, parama.mHeaders, parama.EfY, true);
      LiteAppCenter.setAuthInfo(this.EfH.appId, parama.EfX, parama.mHeaders, parama.EfY, false);
      AppMethodBeat.o(234299);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(234295);
      Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key fail: " + this.EfH.appId);
      AppMethodBeat.o(234295);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */