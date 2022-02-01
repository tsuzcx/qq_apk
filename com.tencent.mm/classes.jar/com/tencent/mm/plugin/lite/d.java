package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.lite.game.LiteAppJsApiLogin;
import com.tencent.mm.plugin.lite.game.LiteAppJsApiStartGameWebview;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.ui.aj;
import com.tencent.wax.c.a.a;
import d.g.b.k;
import d.g.b.v.d;
import d.l;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.plugin.a.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit;", "", "()V", "Companion", "plugin-luggage-wechat-impl_release"})
public final class d
{
  private static String TAG;
  private static boolean cqf;
  public static final a tVF;
  
  static
  {
    AppMethodBeat.i(205645);
    tVF = new a((byte)0);
    TAG = "MicroMsg.LiteAppProcessProfileInit";
    AppMethodBeat.o(205645);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion;", "", "()V", "CALL_FROM_APP_UI", "", "CALL_FROM_APP_UI_HAD_INIT", "CALL_FROM_PROFILE_EXEC", "CALL_FROM_PROFILE_EXEC_HAD_INIT", "CALL_FROM_PROXY_UI", "CALL_FROM_PROXY_UI_HAD_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "isInit", "", "()Z", "setInit", "(Z)V", "copyLibsIfNotExists", "", "srcName", "dstLibPath", "doInit", "callFrom", "preloadEngine", "plugin-luggage-wechat-impl_release"})
  public static final class a
  {
    public static boolean Hy(int paramInt)
    {
      AppMethodBeat.i(205643);
      ac.i(d.access$getTAG$cp(), "doInit");
      if (!d.cWp())
      {
        j.load("wechatxlog");
        j.load("wechatmm");
        j.load("andromeda");
        j.load("wechatlv");
        ac.i(d.access$getTAG$cp(), "preloadEngine");
        LiteAppCenter.addJsApi("login", LiteAppJsApiLogin.class);
        LiteAppCenter.addJsApi("startWebView", com.tencent.mm.plugin.lite.c.a.class);
        LiteAppCenter.addJsApi("openUserProfile", com.tencent.mm.plugin.lite.e.b.class);
        LiteAppCenter.addJsApi("doGoToRecVideoList", com.tencent.mm.plugin.lite.e.a.class);
        LiteAppCenter.addJsApi("wxalited0d6cb88ac866bcdf3b738f1f3df8872", "startGameWebview", LiteAppJsApiStartGameWebview.class);
        LiteAppCenter.addJsApi("wxalited0d6cb88ac866bcdf3b738f1f3df8872", "startGameWebView", LiteAppJsApiStartGameWebview.class);
        Object localObject = (com.tencent.wax.c)a.tVG;
        localObject = new com.tencent.wax.d.a(ai.getContext()).a(FlutterView.b.KLe).a((com.tencent.wax.a)new com.tencent.mm.plugin.lite.b.a(ai.getContext())).a((a.a)new com.tencent.mm.plugin.lite.ui.b()).aTY("liteApp").a((com.tencent.wax.c)localObject).fHB();
        com.tencent.wax.d.fHA().a((com.tencent.wax.d.a)localObject);
        com.tencent.wax.d.fHA().init();
        ac.d(d.access$getTAG$cp(), "start init lvcpp");
        LiteAppCenter.setDarkMode(aj.DT());
        localObject = ai.getContext().getResources().getDisplayMetrics();
        int i = aj.jx(ai.getContext());
        int j = ((DisplayMetrics)localObject).densityDpi;
        int k = ((DisplayMetrics)localObject).widthPixels;
        int m = ((DisplayMetrics)localObject).heightPixels - i;
        float f = ((DisplayMetrics)localObject).density;
        localObject = aj.cl(ai.getContext());
        ac.i(d.access$getTAG$cp(), "SetDisplayParams w=%d h=%d screen=%d,%d, density=%f dpi=%d, statusBar=%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(((Point)localObject).x), Integer.valueOf(((Point)localObject).y), Float.valueOf(f), Integer.valueOf(j), Integer.valueOf(i) });
        LiteAppCenter.setDisplayParams(k / f, m / f, ((Point)localObject).x / f, ((Point)localObject).y / f, j, f);
        com.tencent.mm.plugin.lite.logic.c.cWu();
        localObject = com.tencent.mm.plugin.lite.logic.c.ajL("wxalitebaselibrary");
        if ((com.tencent.mm.sdk.platformtools.h.DEBUG) || (bt.eWm())) {
          if ((localObject != null) && (((com.tencent.mm.plugin.lite.d.b)localObject).cWv()))
          {
            ac.i(d.access$getTAG$cp(), "preload base lib using rdm version");
            LiteAppCenter.setPath(((com.tencent.mm.plugin.lite.d.b)localObject).field_pkgPath);
          }
        }
        for (;;)
        {
          ac.i(d.access$getTAG$cp(), "end init lvcpp");
          d.cWq();
          com.tencent.mm.plugin.report.service.h.wUl.dB(1404, paramInt);
          AppMethodBeat.o(205643);
          return false;
          ac.i(d.access$getTAG$cp(), "preload base lib using apk version");
          hu("flutter-view.runtime.js", ah.GDu + "/flutter-view.runtime.js");
          LiteAppCenter.setPath(ah.GDu);
          continue;
          if (localObject != null)
          {
            ac.i(d.access$getTAG$cp(), "preload base lib using version:" + ((com.tencent.mm.plugin.lite.d.b)localObject).field_pkgType);
            LiteAppCenter.setPath(((com.tencent.mm.plugin.lite.d.b)localObject).field_pkgPath);
          }
          else
          {
            ac.i(d.access$getTAG$cp(), "preload base lib using apk version");
            hu("flutter-view.runtime.js", ah.GDu + "/flutter-view.runtime.js");
            LiteAppCenter.setPath(ah.GDu);
          }
        }
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(205643);
        return true;
        com.tencent.mm.plugin.report.service.h.wUl.dB(1404, 1);
        continue;
        com.tencent.mm.plugin.report.service.h.wUl.dB(1404, 3);
      }
    }
    
    private static void hu(String paramString1, String paramString2)
    {
      AppMethodBeat.i(205644);
      try
      {
        paramString2 = new File(paramString2);
        if (paramString2.exists()) {
          paramString2.delete();
        }
        Object localObject = ai.getContext();
        k.g(localObject, "MMApplicationContext.getContext()");
        paramString1 = ((Context)localObject).getAssets().open(paramString1);
        paramString2 = new FileOutputStream(paramString2);
        localObject = new byte[1024];
        v.d locald = new v.d();
        for (;;)
        {
          int i = paramString1.read((byte[])localObject);
          locald.KUO = i;
          if (i == -1) {
            break;
          }
          paramString2.write((byte[])localObject, 0, locald.KUO);
        }
        paramString1.close();
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(205644);
        return;
      }
      paramString2.close();
      AppMethodBeat.o(205644);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "mRegistry", "Lio/flutter/plugin/common/PluginRegistry;", "kotlin.jvm.PlatformType", "registerPlugins"})
    static final class a
      implements com.tencent.wax.c
    {
      public static final a tVG;
      
      static
      {
        AppMethodBeat.i(205642);
        tVG = new a();
        AppMethodBeat.o(205642);
      }
      
      public final void a(m paramm)
      {
        AppMethodBeat.i(205641);
        io.flutter.a.a.registerWith(paramm);
        AppMethodBeat.o(205641);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.d
 * JD-Core Version:    0.7.0.1
 */