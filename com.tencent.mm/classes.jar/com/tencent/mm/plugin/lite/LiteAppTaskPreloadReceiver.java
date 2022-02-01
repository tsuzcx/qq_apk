package com.tencent.mm.plugin.lite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.b.f;
import com.tencent.mm.plugin.lite.jsapi.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "preloadLogin", "liteAppInfo", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "Companion", "luggage-lite-app_release"})
public final class LiteAppTaskPreloadReceiver
  extends BroadcastReceiver
{
  public static final a yDT;
  
  static
  {
    AppMethodBeat.i(198967);
    yDT = new a((byte)0);
    AppMethodBeat.o(198967);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(198966);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.WxaLiteAppTaskPreloadReceiver", "onReceive NULL intent.");
      AppMethodBeat.o(198966);
      return;
    }
    String str;
    if ((paramIntent.hasExtra("task")) && (paramIntent.hasExtra("appId")) && (p.j(paramIntent.getStringExtra("task"), "prelogin")))
    {
      str = paramIntent.getStringExtra("appId");
      f.ecC();
      paramContext = f.aCT(str);
      if (paramContext != null) {
        break label141;
      }
      Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", str + " is not existed");
    }
    for (;;)
    {
      if ((paramIntent.hasExtra("task")) && (p.j(paramIntent.getStringExtra("task"), "updateBaseLibPath")))
      {
        Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "receive set baselib path");
        paramContext = a.yDP;
        a.a.ecv();
      }
      AppMethodBeat.o(198966);
      return;
      label141:
      p.h(paramContext, "liteAppInfo");
      str = LiteAppCenter.getAuthUrl(paramContext.path, paramContext.appId, paramContext.crh);
      com.tencent.mm.plugin.lite.jsapi.a.yEf.a(str, (a.b)new b(paramContext));
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver$Companion;", "", "()V", "TAG", "", "kAppIdKey", "kPathKey", "kPreLoginTask", "kTaskKey", "kUpdateBaseLibPathTask", "luggage-lite-app_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver$preloadLogin$1", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key$LiteAppGetA8KeyCallback;", "onError", "", "onSuccess", "info", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key$AuthInfo;", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key;", "luggage-lite-app_release"})
  public static final class b
    implements a.b
  {
    b(WxaLiteAppInfo paramWxaLiteAppInfo) {}
    
    public final void a(com.tencent.mm.plugin.lite.jsapi.a.a parama)
    {
      AppMethodBeat.i(198965);
      p.h(parama, "info");
      Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key success:" + this.yDU.appId);
      LiteAppCenter.setAuthInfo(this.yDU.appId, parama.yEk, parama.mHeaders, parama.yEl);
      AppMethodBeat.o(198965);
    }
    
    public final void onError()
    {
      AppMethodBeat.i(198964);
      Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", "geta8key fail: " + this.yDU.appId);
      AppMethodBeat.o(198964);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */