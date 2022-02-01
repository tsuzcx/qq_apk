package com.tencent.mm.plugin.lite;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.liteapp.report.WxaLiteAppStartReport;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.a.b;
import com.tencent.mm.plugin.lite.logic.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.wxa.c;
import io.flutter.embedding.engine.FlutterEngine;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "preloadLogin", "liteAppInfo", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiteAppTaskPreloadReceiver
  extends BroadcastReceiver
{
  public static final a JYY;
  
  static
  {
    AppMethodBeat.i(271276);
    JYY = new a((byte)0);
    AppMethodBeat.o(271276);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(271280);
    if (paramIntent == null)
    {
      Log.e("MicroMsg.WxaLiteAppTaskPreloadReceiver", "onReceive NULL intent.");
      AppMethodBeat.o(271280);
      return;
    }
    a.JYS.a(6, new WxaLiteAppStartReport());
    if ((paramIntent.hasExtra("task")) && (paramIntent.hasExtra("appId")) && (s.p(paramIntent.getStringExtra("task"), "prelogin")))
    {
      localObject = paramIntent.getStringExtra("appId");
      d.fUi();
      paramContext = d.et((String)localObject);
      if (paramContext != null) {
        break label179;
      }
      Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", s.X((String)localObject, " is not existed"));
    }
    for (;;)
    {
      if ((paramIntent.hasExtra("task")) && (s.p(paramIntent.getStringExtra("task"), "updateBaseLibPath")))
      {
        Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", "receive set baselib path");
        paramContext = a.JYS;
        a.a.fTQ();
      }
      if ((!paramIntent.hasExtra("task")) || (!s.p(paramIntent.getStringExtra("task"), "preloadLiteApp"))) {
        break label345;
      }
      if (paramIntent.hasExtra("appId")) {
        break;
      }
      AppMethodBeat.o(271280);
      return;
      label179:
      localObject = LiteAppCenter.getAuthUrl(paramContext.path, paramContext.appId, paramContext.egI);
      com.tencent.mm.plugin.lite.a.a.JZm.a((String)localObject, (a.b)new b(paramContext));
    }
    paramContext = paramIntent.getStringExtra("appId");
    Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", s.X("receive preload liteapp: ", paramContext));
    d.fUi();
    Object localObject = d.et(paramContext);
    if (localObject == null)
    {
      Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", s.X(paramContext, " is not existed"));
      AppMethodBeat.o(271280);
      return;
    }
    FlutterEngine localFlutterEngine = c.keQ().OM(false);
    int i = c.keQ().d(localFlutterEngine);
    if (paramIntent.hasExtra("path"))
    {
      LiteAppCenter.preloadView(paramContext, paramIntent.getStringExtra("path"), y.n(((WxaLiteAppInfo)localObject).path, true), ((WxaLiteAppInfo)localObject).egI, i);
      AppMethodBeat.o(271280);
      return;
    }
    LiteAppCenter.preloadIndexView(paramContext, y.n(((WxaLiteAppInfo)localObject).path, true), ((WxaLiteAppInfo)localObject).egI, i);
    label345:
    AppMethodBeat.o(271280);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver$Companion;", "", "()V", "TAG", "", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/lite/LiteAppTaskPreloadReceiver$preloadLogin$1", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key$LiteAppGetA8KeyCallback;", "onError", "", "onSuccess", "info", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key$AuthInfo;", "Lcom/tencent/mm/plugin/lite/jsapi/LiteAppGetA8Key;", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a.b
  {
    b(WxaLiteAppInfo paramWxaLiteAppInfo) {}
    
    public final void a(com.tencent.mm.plugin.lite.a.a.a parama)
    {
      AppMethodBeat.i(271291);
      s.u(parama, "info");
      Log.i("MicroMsg.WxaLiteAppTaskPreloadReceiver", s.X("geta8key success:", this.JYZ.appId));
      LiteAppCenter.setAuthInfo(this.JYZ.appId, parama.JZr, parama.mHeaders, parama.JZs, true);
      LiteAppCenter.setAuthInfo(this.JYZ.appId, parama.JZr, parama.mHeaders, parama.JZs, false);
      AppMethodBeat.o(271291);
    }
    
    public final void atR()
    {
      AppMethodBeat.i(271286);
      Log.w("MicroMsg.WxaLiteAppTaskPreloadReceiver", s.X("geta8key fail: ", this.JYZ.appId));
      AppMethodBeat.o(271286);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.LiteAppTaskPreloadReceiver
 * JD-Core Version:    0.7.0.1
 */