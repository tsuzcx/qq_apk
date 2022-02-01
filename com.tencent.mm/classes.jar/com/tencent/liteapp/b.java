package com.tencent.liteapp;

import android.content.Context;
import com.tencent.liteapp.c.d;
import com.tencent.liteapp.c.e;
import com.tencent.liteapp.c.f;
import com.tencent.liteapp.c.g;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.c.a.a;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/WxaLiteApp;", "", "()V", "Companion", "Config", "wxa_lite_app_release"})
public final class b
{
  private static final String TAG = "WxaLiteApp.WxaLiteApp";
  public static Context appContext;
  public static b cow;
  public static final a cox;
  public static String packageName;
  
  static
  {
    AppMethodBeat.i(259156);
    cox = new a((byte)0);
    TAG = "WxaLiteApp.WxaLiteApp";
    AppMethodBeat.o(259156);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/WxaLiteApp$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "config", "Lcom/tencent/liteapp/WxaLiteApp$Config;", "getConfig", "()Lcom/tencent/liteapp/WxaLiteApp$Config;", "setConfig", "(Lcom/tencent/liteapp/WxaLiteApp$Config;)V", "packageName", "getPackageName", "setPackageName", "(Ljava/lang/String;)V", "checkInit", "", "checkLiteApp", "Lcom/tencent/liteapp/mgr/UpdateStatus;", "app", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "checkLiteAppAsync", "callback", "Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdaterCallback;", "deleteLiteApp", "", "appId", "fetchAll", "getLiteAppInfo", "getLiteAppList", "", "setup", "startLiteApp", "Lcom/tencent/liteapp/mgr/LauncherStatus;", "query", "pagePath", "pageConfig", "startLiteAppAsync", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncherCallback;", "updateLiteApp", "wxa_lite_app_release"})
  public static final class a
  {
    public static b.b Nm()
    {
      AppMethodBeat.i(259137);
      b.b localb = b.Nj();
      if (localb == null) {
        p.bGy("config");
      }
      AppMethodBeat.o(259137);
      return localb;
    }
    
    public static WxaLiteAppInfo cY(String paramString)
    {
      AppMethodBeat.i(259142);
      p.k(paramString, "appId");
      if (Nm() == null)
      {
        paramString = (Throwable)new RuntimeException("Please setup config first.");
        AppMethodBeat.o(259142);
        throw paramString;
      }
      if (Nm().coC == null)
      {
        paramString = (Throwable)new RuntimeException("Please setup storage first.");
        AppMethodBeat.o(259142);
        throw paramString;
      }
      if (Nm().coz == null)
      {
        paramString = (Throwable)new RuntimeException("Please setup downloader first.");
        AppMethodBeat.o(259142);
        throw paramString;
      }
      if (Nm().coA == null)
      {
        paramString = (Throwable)new RuntimeException("Please setup launcher first.");
        AppMethodBeat.o(259142);
        throw paramString;
      }
      paramString = Nm().coC;
      if (paramString == null) {
        p.iCn();
      }
      paramString = paramString.Nn();
      AppMethodBeat.o(259142);
      return paramString;
    }
    
    public static Context getAppContext()
    {
      AppMethodBeat.i(259139);
      Context localContext = b.Nk();
      if (localContext == null) {
        p.bGy("appContext");
      }
      AppMethodBeat.o(259139);
      return localContext;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/liteapp/WxaLiteApp$Config;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dartEntryPoint", "", "(Landroid/content/Context;Ljava/lang/String;)V", "downloader", "Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;", "getDownloader", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;", "setDownloader", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;)V", "launcher", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "getLauncher", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "setLauncher", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;)V", "mAppContext", "getMAppContext", "()Landroid/content/Context;", "mDartEntryPoint", "getMDartEntryPoint", "()Ljava/lang/String;", "plugin", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "getPlugin", "()Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "setPlugin", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin;)V", "plugins", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlugins", "()Ljava/util/HashSet;", "setPlugins", "(Ljava/util/HashSet;)V", "router", "Lcom/tencent/wxa/WxaRouter;", "getRouter", "()Lcom/tencent/wxa/WxaRouter;", "setRouter", "(Lcom/tencent/wxa/WxaRouter;)V", "storage", "Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", "getStorage", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", "setStorage", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;)V", "updater", "Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;", "getUpdater", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;", "setUpdater", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;)V", "addFlutterPlugin", "", "p", "init", "loader", "setFlutterPlugin", "setLogImp", "log", "Lcom/tencent/liteapp/log/IWxaLiteAppLog;", "s", "u", "setup", "wxa_lite_app_release"})
  public static final class b
  {
    com.tencent.liteapp.c.b coA;
    private d coB;
    com.tencent.liteapp.c.c coC;
    public com.tencent.wxa.c coD;
    public HashSet<io.flutter.embedding.engine.plugins.a> coE;
    public final String coy;
    com.tencent.liteapp.c.a coz;
    public final Context mAppContext;
    
    public b(Context paramContext, String paramString)
    {
      AppMethodBeat.i(259155);
      this.coz = ((com.tencent.liteapp.c.a)new e());
      this.coA = ((com.tencent.liteapp.c.b)new f());
      this.coB = ((d)new g());
      com.tencent.wxa.c localc = com.tencent.wxa.c.ivt();
      p.j(localc, "WxaRouter.getInstance()");
      this.coD = localc;
      this.coE = new HashSet();
      this.mAppContext = paramContext;
      this.coy = paramString;
      AppMethodBeat.o(259155);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/liteapp/WxaLiteApp$Config$init$routerConfig$1", "Lcom/tencent/wxa/log/WxaRouterLog$LogImp;", "d", "", "TAG", "", "format", "objects", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "wxa_lite_app_release"})
    public static final class a
      implements a.a
    {
      public final void d(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(259153);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label72;
          }
        }
        label72:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label78;
          }
          com.tencent.liteapp.b.b.d(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)), new Object[0]);
          AppMethodBeat.o(259153);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.d(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(259153);
      }
      
      public final void e(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(259152);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label72;
          }
        }
        label72:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label78;
          }
          com.tencent.liteapp.b.b.e(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)), new Object[0]);
          AppMethodBeat.o(259152);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.e(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(259152);
      }
      
      public final void i(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(259149);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label72;
          }
        }
        label72:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label78;
          }
          com.tencent.liteapp.b.b.i(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)), new Object[0]);
          AppMethodBeat.o(259149);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.i(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(259149);
      }
      
      public final void v(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(259151);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label72;
          }
        }
        label72:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label78;
          }
          com.tencent.liteapp.b.b.v(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)), new Object[0]);
          AppMethodBeat.o(259151);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.v(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(259151);
      }
      
      public final void w(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(259150);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label72;
          }
        }
        label72:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label78;
          }
          com.tencent.liteapp.b.b.w(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)), new Object[0]);
          AppMethodBeat.o(259150);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.w(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(259150);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.b
 * JD-Core Version:    0.7.0.1
 */