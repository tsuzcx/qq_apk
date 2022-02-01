package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteapp.b.a;
import com.tencent.liteapp.b.b;
import com.tencent.liteapp.b.b.a;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.lite.jsapi.a.e;
import com.tencent.mm.plugin.lite.jsapi.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.wxa.c.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit;", "", "()V", "Companion", "luggage-lite-app_release"})
public final class a
{
  private static Map<String, String> EfB;
  public static final a EfC;
  private static String TAG;
  private static boolean isInit;
  
  static
  {
    AppMethodBeat.i(233575);
    EfC = new a((byte)0);
    TAG = "MicroMsg.LiteAppProcessProfileInit";
    EfB = (Map)new HashMap();
    AppMethodBeat.o(233575);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion;", "", "()V", "CALL_FROM_APP_RECEOVER", "", "CALL_FROM_APP_UI", "CALL_FROM_APP_UI_HAD_INIT", "CALL_FROM_PROFILE_EXEC", "CALL_FROM_PROFILE_EXEC_HAD_INIT", "CALL_FROM_PROXY_UI", "CALL_FROM_PROXY_UI_HAD_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "isInit", "", "()Z", "setInit", "(Z)V", "qrUrlQueryMap", "", "getQrUrlQueryMap", "()Ljava/util/Map;", "setQrUrlQueryMap", "(Ljava/util/Map;)V", "copyLibs", "", "dstLibPath", "doInit", "callFrom", "preloadEngine", "readMetaFromAssets", "setBaseLibPath", "luggage-lite-app_release"})
  public static final class a
  {
    private static void aMX(String paramString)
    {
      AppMethodBeat.i(234250);
      int i = 0;
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        if (i < 3) {
          try
          {
            localObject1 = new String[] { "flutter-view.runtime.js", "meta.json", "store.runtime.js" }[i];
            localObject2 = new q(paramString + '/' + (String)localObject1);
            if (((q)localObject2).ifE()) {
              ((q)localObject2).cFq();
            }
            Object localObject3 = MMApplicationContext.getContext();
            p.j(localObject3, "MMApplicationContext.getContext()");
            localObject1 = ((Context)localObject3).getAssets().open((String)localObject1);
            p.j(localObject1, "MMApplicationContext.get…t().assets.open(fileName)");
            localObject2 = u.an((q)localObject2);
            p.j(localObject2, "VFSFileOp.openWrite(dstLibFile)");
            localObject3 = new byte[1024];
            aa.d locald = new aa.d();
            for (;;)
            {
              int j = ((InputStream)localObject1).read((byte[])localObject3);
              locald.aaBA = j;
              if (j == -1) {
                break;
              }
              ((OutputStream)localObject2).write((byte[])localObject3, 0, locald.aaBA);
            }
            AppMethodBeat.o(234250);
          }
          catch (Exception paramString)
          {
            Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, "", new Object[0]);
          }
        } else {
          return;
        }
        ((InputStream)localObject1).close();
        ((OutputStream)localObject2).close();
        i += 1;
      }
    }
    
    public static void eLy()
    {
      Object localObject2 = null;
      AppMethodBeat.i(234247);
      com.tencent.mm.plugin.lite.b.f.eLH();
      Object localObject3 = com.tencent.mm.plugin.lite.b.f.cY("wxalitebaselibrary");
      Object localObject1;
      String str;
      if (localObject3 != null)
      {
        localObject1 = ((WxaLiteAppInfo)localObject3).coY;
        if (localObject3 != null) {
          localObject2 = ((WxaLiteAppInfo)localObject3).md5;
        }
        localObject2 = com.tencent.mm.plugin.lite.b.h.aq("wxalitebaselibrary", (String)localObject1, (String)localObject2);
        localObject1 = new q((String)localObject2);
        if (!((q)localObject1).ifE()) {
          ((q)localObject1).ifL();
        }
        localObject1 = LiteAppCenter.getBaseLibVersionByPath(u.n((String)localObject2, false));
        str = LiteAppCenter.getBaseLibVersionByString(eLz());
        Log.i(a.access$getTAG$cp(), "base lib localVersion:" + (String)localObject1 + ", assetsVersion:" + str);
        if (!LiteAppCenter.versionGreater(str, (String)localObject1)) {
          break label283;
        }
        Log.i(a.access$getTAG$cp(), "copy base lib " + str + " to " + (String)localObject2);
        p.j(localObject2, "pkgPath");
        aMX((String)localObject2);
        localObject1 = LiteAppCenter.getBaseLibVersionByPath((String)localObject2);
      }
      label278:
      label283:
      for (;;)
      {
        if (localObject3 != null)
        {
          str = LiteAppCenter.getBaseLibVersionByPath(((WxaLiteAppInfo)localObject3).path);
          localObject3 = ((WxaLiteAppInfo)localObject3).path;
          if (!LiteAppCenter.versionGreater((String)localObject1, str)) {
            break label278;
          }
        }
        for (;;)
        {
          Log.i(a.access$getTAG$cp(), "preload base lib localVersion:" + (String)localObject1 + ", dbVersion:" + str + ", path:" + (String)localObject2);
          c.setPath(u.n((String)localObject2, false));
          AppMethodBeat.o(234247);
          return;
          localObject1 = null;
          break;
          Log.i(a.access$getTAG$cp(), "preload base lib use local, path:".concat(String.valueOf(localObject2)));
          c.setPath(u.n((String)localObject2, false));
          AppMethodBeat.o(234247);
          return;
          localObject2 = localObject3;
        }
      }
    }
    
    private static String eLz()
    {
      AppMethodBeat.i(234249);
      Object localObject1 = MMApplicationContext.getContext();
      p.j(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getAssets().open("meta.json");
      p.j(localObject1, "MMApplicationContext.get…().assets.open(kMetaFile)");
      Object localObject2 = new byte[((InputStream)localObject1).available()];
      ((InputStream)localObject1).read((byte[])localObject2);
      localObject2 = new String((byte[])localObject2, kotlin.n.d.UTF_8);
      ((InputStream)localObject1).close();
      AppMethodBeat.o(234249);
      return localObject2;
    }
    
    public final boolean VE(int paramInt)
    {
      AppMethodBeat.i(234243);
      Log.i(a.access$getTAG$cp(), "doInit");
      com.tencent.mm.plugin.lite.b.f.eLH();
      if (!com.tencent.mm.plugin.lite.b.f.eLA())
      {
        Log.i(a.access$getTAG$cp(), "isLiteAppEnable = false");
        AppMethodBeat.o(234243);
        return false;
      }
      if (!a.eLv())
      {
        j.load("wechatxlog");
        j.load("wechatmm");
        j.load("andromeda");
        j.load("wechatlv");
        j.load("flutter");
        Log.i(a.access$getTAG$cp(), "preloadEngine");
        c.addJsApi("triggerTestEvent", com.tencent.mm.plugin.lite.jsapi.a.h.class);
        c.addJsApi("login", com.tencent.mm.plugin.lite.jsapi.a.b.class);
        c.addJsApi("session", e.class);
        c.addJsApi("startWebView", g.class);
        c.addJsApi("openUserProfile", com.tencent.mm.plugin.lite.jsapi.b.b.class);
        c.addJsApi("doGoToRecVideoList", com.tencent.mm.plugin.lite.jsapi.b.a.class);
        c.addJsApi("launchMiniProgram", com.tencent.mm.plugin.lite.jsapi.a.a.class);
        c.addJsApi("sendAppMessage", com.tencent.mm.plugin.lite.jsapi.a.d.class);
        c.addJsApi("shareTimeline", com.tencent.mm.plugin.lite.jsapi.a.f.class);
        c.addJsApi("openFinderView", com.tencent.mm.plugin.lite.jsapi.a.c.class);
        Object localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.game.luggage.a.a.class);
        p.j(localObject1, "MMKernel.service(ILuggageGameService::class.java)");
        c.addJsApi(((com.tencent.mm.plugin.game.luggage.a.a)localObject1).ewv());
        localObject1 = MMApplicationContext.getContext();
        p.j(localObject1, "MMApplicationContext.getContext()");
        localObject1 = new b.b((Context)localObject1, "liteApp");
        Object localObject2 = (com.tencent.liteapp.b.a)new a();
        p.k(localObject2, "log");
        com.tencent.liteapp.b.b.a((com.tencent.liteapp.b.a)localObject2);
        localObject2 = com.tencent.liteapp.b.cox;
        p.k(localObject1, "config");
        p.k(localObject1, "<set-?>");
        com.tencent.liteapp.b.a((b.b)localObject1);
        localObject1 = b.a.Nm().mAppContext;
        p.k(localObject1, "<set-?>");
        com.tencent.liteapp.b.ar((Context)localObject1);
        localObject1 = b.a.Nm().mAppContext.getPackageName();
        p.j(localObject1, "this.config.mAppContext.packageName");
        p.k(localObject1, "<set-?>");
        com.tencent.liteapp.b.cX((String)localObject1);
        LiteAppCenter.updateDisplayParam(b.a.getAppContext(), 0L);
        localObject1 = b.a.Nm();
        localObject2 = new c.a(((b.b)localObject1).mAppContext).a((com.tencent.wxa.b)new com.tencent.liteapp.a.a()).a((com.tencent.wxa.b)new com.tencent.wxa.a.c()).bEA(((b.b)localObject1).coy).k(((b.b)localObject1).coE).a((com.tencent.wxa.c.a.a)new b.b.a()).ivw();
        ((b.b)localObject1).coD.a((c.a)localObject2);
        ((b.b)localObject1).coD.init();
        Log.d(a.access$getTAG$cp(), "start init lvcpp");
        boolean bool = ar.isDarkMode();
        c.init();
        c.updateDarkMode(bool);
        localObject1 = MMApplicationContext.getContext();
        localObject2 = ar.au((Context)localObject1);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        Object localObject3 = ((Context)localObject1).getSystemService("window");
        if (localObject3 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.WindowManager");
          AppMethodBeat.o(234243);
          throw ((Throwable)localObject1);
        }
        ((WindowManager)localObject3).getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = ax.at((Context)localObject1);
        int j = ax.aB((Context)localObject1);
        int k = localDisplayMetrics.densityDpi;
        int m = ((Point)localObject2).x;
        int n = ((Point)localObject2).y;
        float f1 = localDisplayMetrics.density;
        float f2 = 48.0F * f1;
        Log.i(a.access$getTAG$cp(), "SetDisplayParams w=%d h=%d screen=%d,%d, density=%f dpi=%d, statusBar=%d actionBarHeight:%f, navigationBarHeight:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(j) });
        c.setDisplayParams(0L, m / f1, n / f1, ((Point)localObject2).x / f1, ((Point)localObject2).y / f1, k, f1, f2 / f1, i / f1, j / f1);
        eLy();
        Log.i(a.access$getTAG$cp(), "end init lvcpp");
        a.eLw();
        com.tencent.mm.plugin.report.service.h.IzE.el(1404, paramInt);
        AppMethodBeat.o(234243);
        return false;
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(234243);
        return true;
        com.tencent.mm.plugin.report.service.h.IzE.el(1404, 1);
        continue;
        com.tencent.mm.plugin.report.service.h.IzE.el(1404, 3);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion$preloadEngine$1", "Lcom/tencent/liteapp/log/IWxaLiteAppLog;", "d", "", "TAG", "", "format", "objects", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "luggage-lite-app_release"})
    public static final class a
      implements com.tencent.liteapp.b.a
    {
      public final void d(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(233668);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label68;
          }
        }
        label68:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label74;
          }
          Log.d(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
          AppMethodBeat.o(233668);
          return;
          i = 0;
          break;
        }
        label74:
        Log.d(paramString1, paramString2);
        AppMethodBeat.o(233668);
      }
      
      public final void e(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(233667);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label68;
          }
        }
        label68:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label74;
          }
          Log.e(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
          AppMethodBeat.o(233667);
          return;
          i = 0;
          break;
        }
        label74:
        Log.e(paramString1, paramString2);
        AppMethodBeat.o(233667);
      }
      
      public final void i(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(233660);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label68;
          }
        }
        label68:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label74;
          }
          Log.i(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
          AppMethodBeat.o(233660);
          return;
          i = 0;
          break;
        }
        label74:
        Log.i(paramString1, paramString2);
        AppMethodBeat.o(233660);
      }
      
      public final void v(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(233665);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label68;
          }
        }
        label68:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label74;
          }
          Log.v(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
          AppMethodBeat.o(233665);
          return;
          i = 0;
          break;
        }
        label74:
        Log.v(paramString1, paramString2);
        AppMethodBeat.o(233665);
      }
      
      public final void w(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(233663);
        p.k(paramString2, "format");
        p.k(paramVarArgs, "objects");
        if (paramVarArgs.length == 0)
        {
          i = 1;
          if (i == 0) {
            break label68;
          }
        }
        label68:
        for (int i = j;; i = 0)
        {
          if (i != 0) {
            break label74;
          }
          Log.w(paramString1, String.format(paramString2, Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
          AppMethodBeat.o(233663);
          return;
          i = 0;
          break;
        }
        label74:
        Log.w(paramString1, paramString2);
        AppMethodBeat.o(233663);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a
 * JD-Core Version:    0.7.0.1
 */