package com.tencent.liteapp;

import android.content.Context;
import com.tencent.liteapp.c.a;
import com.tencent.liteapp.c.d;
import com.tencent.liteapp.c.e;
import com.tencent.liteapp.c.f;
import com.tencent.liteapp.c.g;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.c.a.a;
import io.flutter.embedding.engine.FlutterShellArgs;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.Arrays;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/liteapp/WxaLiteApp;", "", "()V", "Companion", "Config", "wxa_lite_app_release"}, k=1, mv={1, 1, 16})
public final class b
{
  private static final String TAG = "WxaLiteApp.WxaLiteApp";
  public static Context appContext;
  public static b efC;
  public static final a efD;
  public static String packageName;
  
  static
  {
    AppMethodBeat.i(218993);
    efD = new a((byte)0);
    TAG = "WxaLiteApp.WxaLiteApp";
    AppMethodBeat.o(218993);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/liteapp/WxaLiteApp$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "config", "Lcom/tencent/liteapp/WxaLiteApp$Config;", "getConfig", "()Lcom/tencent/liteapp/WxaLiteApp$Config;", "setConfig", "(Lcom/tencent/liteapp/WxaLiteApp$Config;)V", "packageName", "getPackageName", "setPackageName", "(Ljava/lang/String;)V", "checkInit", "", "checkLiteApp", "Lcom/tencent/liteapp/mgr/UpdateStatus;", "app", "Lcom/tencent/liteapp/storage/WxaLiteAppInfo;", "checkLiteAppAsync", "callback", "Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdaterCallback;", "checkLiteAppBaselib", "baselib", "Lcom/tencent/liteapp/storage/WxaLiteAppBaselibInfo;", "checkLiteAppBaselibAsync", "Lcom/tencent/liteapp/mgr/IWxaLiteAppBaselibUpdaterCallback;", "deleteBaselib", "", "majorVersion", "deleteLiteApp", "appId", "fetchAll", "getLiteAppBaselibInfo", "getLiteAppInfo", "getLiteAppLatestBaselib", "getLiteAppList", "", "setup", "startLiteApp", "Lcom/tencent/liteapp/mgr/LauncherStatus;", "query", "pagePath", "pageConfig", "startLiteAppAsync", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncherCallback;", "updateBaselib", "updateLiteApp", "wxa_lite_app_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    public static b.b anF()
    {
      AppMethodBeat.i(218994);
      b.b localb = b.anC();
      if (localb == null) {
        s.bIx("config");
      }
      AppMethodBeat.o(218994);
      return localb;
    }
    
    public static WxaLiteAppInfo et(String paramString)
    {
      AppMethodBeat.i(219008);
      s.t(paramString, "appId");
      if (anF() == null)
      {
        paramString = (Throwable)new RuntimeException("Please setup config first.");
        AppMethodBeat.o(219008);
        throw paramString;
      }
      if (anF().efJ == null)
      {
        paramString = (Throwable)new RuntimeException("Please setup storage first.");
        AppMethodBeat.o(219008);
        throw paramString;
      }
      if (anF().efG == null)
      {
        paramString = (Throwable)new RuntimeException("Please setup downloader first.");
        AppMethodBeat.o(219008);
        throw paramString;
      }
      if (anF().efH == null)
      {
        paramString = (Throwable)new RuntimeException("Please setup launcher first.");
        AppMethodBeat.o(219008);
        throw paramString;
      }
      paramString = anF().efJ;
      if (paramString == null) {
        s.klw();
      }
      paramString = paramString.anG();
      AppMethodBeat.o(219008);
      return paramString;
    }
    
    public static Context getAppContext()
    {
      AppMethodBeat.i(219000);
      Context localContext = b.anD();
      if (localContext == null) {
        s.bIx("appContext");
      }
      AppMethodBeat.o(219000);
      return localContext;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/liteapp/WxaLiteApp$Config;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dartEntryPoint", "", "(Landroid/content/Context;Ljava/lang/String;)V", "autoReleaseEngine", "", "getAutoReleaseEngine", "()Z", "setAutoReleaseEngine", "(Z)V", "downloader", "Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;", "getDownloader", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;", "setDownloader", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;)V", "flutterShellArgs", "Lio/flutter/embedding/engine/FlutterShellArgs;", "getFlutterShellArgs", "()Lio/flutter/embedding/engine/FlutterShellArgs;", "setFlutterShellArgs", "(Lio/flutter/embedding/engine/FlutterShellArgs;)V", "launcher", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "getLauncher", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "setLauncher", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;)V", "mAppContext", "getMAppContext", "()Landroid/content/Context;", "mDartEntryPoint", "getMDartEntryPoint", "()Ljava/lang/String;", "plugin", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "getPlugin", "()Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "setPlugin", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin;)V", "plugins", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlugins", "()Ljava/util/HashSet;", "setPlugins", "(Ljava/util/HashSet;)V", "preloadEngine", "getPreloadEngine", "setPreloadEngine", "preloadNextEngine", "getPreloadNextEngine", "setPreloadNextEngine", "releaseDefaultEngineWhenEmptyView", "getReleaseDefaultEngineWhenEmptyView", "setReleaseDefaultEngineWhenEmptyView", "router", "Lcom/tencent/wxa/WxaRouter;", "getRouter", "()Lcom/tencent/wxa/WxaRouter;", "setRouter", "(Lcom/tencent/wxa/WxaRouter;)V", "storage", "Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", "getStorage", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", "setStorage", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;)V", "updater", "Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;", "getUpdater", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;", "setUpdater", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;)V", "addFlutterPlugin", "", "p", "init", "flag", "loader", "setFlutterPlugin", "args", "", "([Ljava/lang/String;)Lcom/tencent/liteapp/WxaLiteApp$Config;", "setLogImp", "log", "Lcom/tencent/liteapp/log/IWxaLiteAppLog;", "enable", "s", "u", "setup", "wxa_lite_app_release"}, k=1, mv={1, 1, 16})
  public static final class b
  {
    public final String efE;
    public FlutterShellArgs efF;
    a efG;
    com.tencent.liteapp.c.b efH;
    private d efI;
    com.tencent.liteapp.c.c efJ;
    public com.tencent.wxa.c efK;
    public HashSet<FlutterPlugin> efL;
    public boolean efM;
    public boolean efN;
    public boolean efO;
    public boolean efP;
    public final Context mAppContext;
    
    public b(Context paramContext, String paramString)
    {
      AppMethodBeat.i(218999);
      this.efF = new FlutterShellArgs(new String[0]);
      this.efG = ((a)new e());
      this.efH = ((com.tencent.liteapp.c.b)new f());
      this.efI = ((d)new g());
      com.tencent.wxa.c localc = com.tencent.wxa.c.keQ();
      s.r(localc, "WxaRouter.getInstance()");
      this.efK = localc;
      this.efL = new HashSet();
      this.mAppContext = paramContext;
      this.efE = paramString;
      AppMethodBeat.o(218999);
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/liteapp/WxaLiteApp$Config$init$routerConfig$1", "Lcom/tencent/wxa/log/WxaRouterLog$LogImp;", "d", "", "TAG", "", "format", "objects", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "wxa_lite_app_release"}, k=1, mv={1, 1, 16})
    public static final class a
      implements a.a
    {
      public final void d(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(219037);
        s.t(paramString2, "format");
        s.t(paramVarArgs, "objects");
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
          AppMethodBeat.o(219037);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.d(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(219037);
      }
      
      public final void e(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(219030);
        s.t(paramString2, "format");
        s.t(paramVarArgs, "objects");
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
          AppMethodBeat.o(219030);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.e(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(219030);
      }
      
      public final void i(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(219015);
        s.t(paramString2, "format");
        s.t(paramVarArgs, "objects");
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
          AppMethodBeat.o(219015);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.i(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(219015);
      }
      
      public final void v(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(219025);
        s.t(paramString2, "format");
        s.t(paramVarArgs, "objects");
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
          AppMethodBeat.o(219025);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.v(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(219025);
      }
      
      public final void w(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(219020);
        s.t(paramString2, "format");
        s.t(paramVarArgs, "objects");
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
          AppMethodBeat.o(219020);
          return;
          i = 0;
          break;
        }
        label78:
        com.tencent.liteapp.b.b.w(paramString1, paramString2, new Object[0]);
        AppMethodBeat.o(219020);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteapp.b
 * JD-Core Version:    0.7.0.1
 */