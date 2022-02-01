package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteapp.a.b;
import com.tencent.liteapp.a.b.a;
import com.tencent.liteapp.a.b.b;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.jsapi.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wxa.c.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit;", "", "()V", "Companion", "luggage-lite-app_release"})
public final class a
{
  private static String TAG;
  private static boolean isInit;
  private static Map<String, String> yDO;
  public static final a yDP;
  
  static
  {
    AppMethodBeat.i(198963);
    yDP = new a((byte)0);
    TAG = "MicroMsg.LiteAppProcessProfileInit";
    yDO = (Map)new HashMap();
    AppMethodBeat.o(198963);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion;", "", "()V", "CALL_FROM_APP_UI", "", "CALL_FROM_APP_UI_HAD_INIT", "CALL_FROM_PROFILE_EXEC", "CALL_FROM_PROFILE_EXEC_HAD_INIT", "CALL_FROM_PROXY_UI", "CALL_FROM_PROXY_UI_HAD_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "isInit", "", "()Z", "setInit", "(Z)V", "qrUrlQueryMap", "", "getQrUrlQueryMap", "()Ljava/util/Map;", "setQrUrlQueryMap", "(Ljava/util/Map;)V", "copyLibs", "", "dstLibPath", "doInit", "callFrom", "preloadEngine", "readMetaFromAssets", "setBaseLibPath", "versionGreater", "first", "second", "luggage-lite-app_release"})
  public static final class a
  {
    private static void aCQ(String paramString)
    {
      AppMethodBeat.i(198962);
      int i = 0;
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        if (i < 2) {
          try
          {
            localObject1 = new String[] { "flutter-view.runtime.js", "meta.json" }[i];
            localObject2 = new o(paramString + '/' + (String)localObject1);
            if (((o)localObject2).exists()) {
              ((o)localObject2).delete();
            }
            Object localObject3 = MMApplicationContext.getContext();
            p.g(localObject3, "MMApplicationContext.getContext()");
            localObject1 = ((Context)localObject3).getAssets().open((String)localObject1);
            p.g(localObject1, "MMApplicationContext.get…t().assets.open(fileName)");
            localObject2 = s.ap((o)localObject2);
            p.g(localObject2, "VFSFileOp.openWrite(dstLibFile)");
            localObject3 = new byte[1024];
            z.d locald = new z.d();
            for (;;)
            {
              int j = ((InputStream)localObject1).read((byte[])localObject3);
              locald.SYE = j;
              if (j == -1) {
                break;
              }
              ((OutputStream)localObject2).write((byte[])localObject3, 0, locald.SYE);
            }
            AppMethodBeat.o(198962);
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
    
    public static void ecv()
    {
      Object localObject2 = null;
      AppMethodBeat.i(198959);
      com.tencent.mm.plugin.lite.b.f.ecC();
      Object localObject3 = com.tencent.mm.plugin.lite.b.f.aCT("wxalitebaselibrary");
      Object localObject1;
      String str;
      if (localObject3 != null)
      {
        localObject1 = ((WxaLiteAppInfo)localObject3).cri;
        if (localObject3 != null) {
          localObject2 = ((WxaLiteAppInfo)localObject3).md5;
        }
        localObject2 = com.tencent.mm.plugin.lite.b.h.aw("wxalitebaselibrary", (String)localObject1, (String)localObject2);
        localObject1 = new o((String)localObject2);
        if (!((o)localObject1).exists()) {
          ((o)localObject1).mkdirs();
        }
        localObject1 = LiteAppCenter.getBaseLibVersionByPath(s.k((String)localObject2, false));
        str = LiteAppCenter.getBaseLibVersionByString(ecw());
        Log.i(a.access$getTAG$cp(), "base lib localVersion:" + (String)localObject1 + ", assetsVersion:" + str);
        p.g(str, "assetsVersion");
        p.g(localObject1, "localVersion");
        if (!iv(str, (String)localObject1)) {
          break label308;
        }
        Log.i(a.access$getTAG$cp(), "copy base lib " + str + " to " + (String)localObject2);
        p.g(localObject2, "pkgPath");
        aCQ((String)localObject2);
        localObject1 = LiteAppCenter.getBaseLibVersionByPath((String)localObject2);
      }
      label303:
      label308:
      for (;;)
      {
        if (localObject3 != null)
        {
          str = LiteAppCenter.getBaseLibVersionByPath(((WxaLiteAppInfo)localObject3).path);
          localObject3 = ((WxaLiteAppInfo)localObject3).path;
          p.g(localObject1, "localVersion");
          p.g(str, "dbVersion");
          if (!iv((String)localObject1, str)) {
            break label303;
          }
        }
        for (;;)
        {
          Log.i(a.access$getTAG$cp(), "preload base lib localVersion:" + (String)localObject1 + ", dbVersion:" + str + ", path:" + (String)localObject2);
          c.setPath(s.k((String)localObject2, false));
          AppMethodBeat.o(198959);
          return;
          localObject1 = null;
          break;
          Log.i(a.access$getTAG$cp(), "preload base lib use local, path:".concat(String.valueOf(localObject2)));
          c.setPath(s.k((String)localObject2, false));
          AppMethodBeat.o(198959);
          return;
          localObject2 = localObject3;
        }
      }
    }
    
    private static String ecw()
    {
      AppMethodBeat.i(198961);
      Object localObject1 = MMApplicationContext.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getAssets().open("meta.json");
      p.g(localObject1, "MMApplicationContext.get…().assets.open(kMetaFile)");
      Object localObject2 = new byte[((InputStream)localObject1).available()];
      ((InputStream)localObject1).read((byte[])localObject2);
      localObject2 = new String((byte[])localObject2, kotlin.n.d.UTF_8);
      ((InputStream)localObject1).close();
      AppMethodBeat.o(198961);
      return localObject2;
    }
    
    private static boolean iv(String paramString1, String paramString2)
    {
      AppMethodBeat.i(198960);
      if (paramString1 != null) {
        if (((CharSequence)paramString1).length() != 0) {
          break label36;
        }
      }
      label36:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(198960);
        return false;
      }
      if (paramString2 != null) {
        if (((CharSequence)paramString2).length() != 0) {
          break label71;
        }
      }
      label71:
      for (i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(198960);
        return true;
      }
      paramString1 = n.a((CharSequence)paramString1, new String[] { "\\." });
      paramString2 = n.a((CharSequence)paramString2, new String[] { "\\." });
      int j = kotlin.k.j.na(paramString1.size(), paramString2.size());
      i = 0;
      while (i < j)
      {
        if (!p.j((String)paramString1.get(i), (String)paramString2.get(i)))
        {
          if (((String)paramString1.get(i)).length() > ((String)paramString2.get(i)).length())
          {
            AppMethodBeat.o(198960);
            return true;
          }
          if (((String)paramString1.get(i)).length() < ((String)paramString2.get(i)).length())
          {
            AppMethodBeat.o(198960);
            return false;
          }
          if (((String)paramString1.get(i)).compareTo((String)paramString2.get(i)) > 0)
          {
            AppMethodBeat.o(198960);
            return true;
          }
          AppMethodBeat.o(198960);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(198960);
      return true;
    }
    
    public final boolean Pv(int paramInt)
    {
      AppMethodBeat.i(198958);
      Log.i(a.access$getTAG$cp(), "doInit");
      com.tencent.mm.plugin.lite.b.f.ecC();
      if (!com.tencent.mm.plugin.lite.b.f.ecx())
      {
        Log.i(a.access$getTAG$cp(), "isLiteAppEnable = false");
        AppMethodBeat.o(198958);
        return false;
      }
      if (!a.ecs())
      {
        com.tencent.mm.compatible.util.j.load("wechatxlog");
        com.tencent.mm.compatible.util.j.load("wechatmm");
        com.tencent.mm.compatible.util.j.load("andromeda");
        com.tencent.mm.compatible.util.j.load("wechatlv");
        com.tencent.mm.compatible.util.j.load("flutter");
        Log.i(a.access$getTAG$cp(), "preloadEngine");
        c.addJsApi("triggerTestEvent", com.tencent.mm.plugin.lite.jsapi.a.g.class);
        c.addJsApi("login", com.tencent.mm.plugin.lite.jsapi.a.b.class);
        c.addJsApi("session", com.tencent.mm.plugin.lite.jsapi.a.d.class);
        c.addJsApi("startWebView", com.tencent.mm.plugin.lite.jsapi.a.f.class);
        c.addJsApi("openUserProfile", com.tencent.mm.plugin.lite.jsapi.b.b.class);
        c.addJsApi("doGoToRecVideoList", com.tencent.mm.plugin.lite.jsapi.b.a.class);
        c.addJsApi("launchMiniProgram", com.tencent.mm.plugin.lite.jsapi.a.a.class);
        c.addJsApi("sendAppMessage", com.tencent.mm.plugin.lite.jsapi.a.c.class);
        c.addJsApi("shareTimeline", e.class);
        Object localObject1 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.game.luggage.a.a.class);
        p.g(localObject1, "MMKernel.service(ILuggageGameService::class.java)");
        c.addJsApi(((com.tencent.mm.plugin.game.luggage.a.a)localObject1).dTm());
        localObject1 = MMApplicationContext.getContext();
        p.g(localObject1, "MMApplicationContext.getContext()");
        localObject1 = new a.b((Context)localObject1, "liteApp");
        Object localObject2 = (com.tencent.liteapp.b.a)new a.a.a();
        p.h(localObject2, "log");
        com.tencent.liteapp.b.b.a((com.tencent.liteapp.b.a)localObject2);
        localObject2 = com.tencent.liteapp.a.cqJ;
        p.h(localObject1, "config");
        p.h(localObject1, "<set-?>");
        com.tencent.liteapp.a.a((a.b)localObject1);
        localObject1 = com.tencent.liteapp.a.a.KA().mAppContext;
        p.h(localObject1, "<set-?>");
        com.tencent.liteapp.a.aw((Context)localObject1);
        localObject1 = com.tencent.liteapp.a.a.KA().mAppContext.getPackageName();
        p.g(localObject1, "this.config.mAppContext.packageName");
        p.h(localObject1, "<set-?>");
        com.tencent.liteapp.a.cK((String)localObject1);
        LiteAppCenter.updateDisplayParam(com.tencent.liteapp.a.a.getAppContext());
        localObject1 = com.tencent.liteapp.a.a.KA();
        localObject2 = new c.a(((a.b)localObject1).mAppContext).a((com.tencent.wxa.a)new com.tencent.liteapp.a.a()).a((com.tencent.wxa.a)new com.tencent.wxa.a.c()).brB(((a.b)localObject1).cqK).a((com.tencent.wxa.b)new a.b.a((a.b)localObject1)).a((com.tencent.wxa.c.a.a)new a.b.b()).hrK();
        ((a.b)localObject1).cqO.a((c.a)localObject2);
        ((a.b)localObject1).cqO.init();
        Log.d(a.access$getTAG$cp(), "start init lvcpp");
        boolean bool = ao.isDarkMode();
        c.init();
        c.updateDarkMode(bool);
        localObject1 = MMApplicationContext.getContext();
        localObject2 = ao.az((Context)localObject1);
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        Object localObject3 = ((Context)localObject1).getSystemService("window");
        if (localObject3 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.WindowManager");
          AppMethodBeat.o(198958);
          throw ((Throwable)localObject1);
        }
        ((WindowManager)localObject3).getDefaultDisplay().getMetrics(localDisplayMetrics);
        int i = au.ay((Context)localObject1);
        int j = au.aD((Context)localObject1);
        int k = localDisplayMetrics.densityDpi;
        int m = ((Point)localObject2).x;
        int n = ((Point)localObject2).y;
        float f1 = localDisplayMetrics.density;
        float f2 = 48.0F * f1;
        Log.i(a.access$getTAG$cp(), "SetDisplayParams w=%d h=%d screen=%d,%d, density=%f dpi=%d, statusBar=%d actionBarHeight:%f, navigationBarHeight:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(j) });
        c.setDisplayParams(m / f1, n / f1, ((Point)localObject2).x / f1, ((Point)localObject2).y / f1, k, f1, f2 / f1, i / f1, j / f1);
        ecv();
        Log.i(a.access$getTAG$cp(), "end init lvcpp");
        a.ect();
        com.tencent.mm.plugin.report.service.h.CyF.dN(1404, paramInt);
        AppMethodBeat.o(198958);
        return false;
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(198958);
        return true;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1404, 1);
        continue;
        com.tencent.mm.plugin.report.service.h.CyF.dN(1404, 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a
 * JD-Core Version:    0.7.0.1
 */