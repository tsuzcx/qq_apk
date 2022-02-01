package com.tencent.liteapp;

import android.content.Context;
import com.tencent.liteapp.c.b;
import com.tencent.liteapp.c.d;
import com.tencent.liteapp.c.e;
import com.tencent.liteapp.c.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/liteapp/WxaLiteApp$Config;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dartEntryPoint", "", "(Landroid/content/Context;Ljava/lang/String;)V", "downloader", "Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;", "getDownloader", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;", "setDownloader", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppDownloader;)V", "launcher", "Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "getLauncher", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;", "setLauncher", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppLauncher;)V", "mAppContext", "getMAppContext", "()Landroid/content/Context;", "mDartEntryPoint", "getMDartEntryPoint", "()Ljava/lang/String;", "plugin", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "getPlugin", "()Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "setPlugin", "(Lio/flutter/embedding/engine/plugins/FlutterPlugin;)V", "plugins", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getPlugins", "()Ljava/util/HashSet;", "setPlugins", "(Ljava/util/HashSet;)V", "router", "Lcom/tencent/wxa/WxaRouter;", "getRouter", "()Lcom/tencent/wxa/WxaRouter;", "setRouter", "(Lcom/tencent/wxa/WxaRouter;)V", "storage", "Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", "getStorage", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;", "setStorage", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppStorage;)V", "updater", "Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;", "getUpdater", "()Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;", "setUpdater", "(Lcom/tencent/liteapp/mgr/IWxaLiteAppUpdater;)V", "addFlutterPlugin", "", "p", "init", "loader", "setFlutterPlugin", "setLogImp", "log", "Lcom/tencent/liteapp/log/IWxaLiteAppLog;", "s", "u", "setup", "wxa_lite_app_release"})
public final class a$b
{
  public final String cqK;
  private com.tencent.liteapp.c.a cqL;
  private b cqM;
  private com.tencent.liteapp.c.c cqN;
  public com.tencent.wxa.c cqO;
  HashSet<io.flutter.embedding.engine.plugins.a> cqP;
  public final Context mAppContext;
  
  public a$b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(197917);
    this.cqL = ((com.tencent.liteapp.c.a)new d());
    this.cqM = ((b)new e());
    this.cqN = ((com.tencent.liteapp.c.c)new f());
    com.tencent.wxa.c localc = com.tencent.wxa.c.hrH();
    p.g(localc, "WxaRouter.getInstance()");
    this.cqO = localc;
    this.cqP = new HashSet();
    this.mAppContext = paramContext;
    this.cqK = paramString;
    AppMethodBeat.o(197917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.liteapp.a.b
 * JD-Core Version:    0.7.0.1
 */