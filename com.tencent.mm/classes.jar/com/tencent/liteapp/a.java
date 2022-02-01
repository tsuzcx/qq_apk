package com.tencent.liteapp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/liteapp/WxaLiteApp;", "", "()V", "Companion", "Config", "wxa_lite_app_release"})
public final class a
{
  private static final String TAG = "WxaLiteApp.WxaLiteApp";
  public static Context appContext;
  public static a.b cqI;
  public static final a cqJ;
  public static String packageName;
  
  static
  {
    AppMethodBeat.i(197918);
    cqJ = new a((byte)0);
    TAG = "WxaLiteApp.WxaLiteApp";
    AppMethodBeat.o(197918);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/liteapp/WxaLiteApp$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "config", "Lcom/tencent/liteapp/WxaLiteApp$Config;", "getConfig", "()Lcom/tencent/liteapp/WxaLiteApp$Config;", "setConfig", "(Lcom/tencent/liteapp/WxaLiteApp$Config;)V", "packageName", "getPackageName", "setPackageName", "(Ljava/lang/String;)V", "checkInit", "", "checkLiteApp", "Lcom/tencent/liteapp/mgr/UpdateStatus;", "app", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "checkLiteAppAsync", "callback", "Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdaterCallback;", "deleteLiteApp", "", "appId", "fetchAll", "getLiteAppInfo", "getLiteAppList", "", "setup", "startLiteApp", "Lcom/tencent/liteapp/mgr/LauncherStatus;", "pagePath", "query", "startLiteAppAsync", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncherCallback;", "updateLiteApp", "wxa_lite_app_release"})
  public static final class a
  {
    public static a.b KA()
    {
      AppMethodBeat.i(197909);
      a.b localb = a.Kx();
      if (localb == null) {
        p.btv("config");
      }
      AppMethodBeat.o(197909);
      return localb;
    }
    
    public static Context getAppContext()
    {
      AppMethodBeat.i(197910);
      Context localContext = a.Ky();
      if (localContext == null) {
        p.btv("appContext");
      }
      AppMethodBeat.o(197910);
      return localContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.liteapp.a
 * JD-Core Version:    0.7.0.1
 */