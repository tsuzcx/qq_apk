package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.wax.c.a.a;
import d.g.b.p;
import d.g.b.y.d;
import d.l;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.plugin.a.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit;", "", "()V", "Companion", "plugin-luggage-wechat-impl_release"})
public final class d
{
  private static String TAG;
  private static boolean cAX;
  public static final a uYh;
  
  static
  {
    AppMethodBeat.i(217229);
    uYh = new a((byte)0);
    TAG = "MicroMsg.LiteAppProcessProfileInit";
    AppMethodBeat.o(217229);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion;", "", "()V", "CALL_FROM_APP_UI", "", "CALL_FROM_APP_UI_HAD_INIT", "CALL_FROM_PROFILE_EXEC", "CALL_FROM_PROFILE_EXEC_HAD_INIT", "CALL_FROM_PROXY_UI", "CALL_FROM_PROXY_UI_HAD_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "isInit", "", "()Z", "setInit", "(Z)V", "copyLibsIfNotExists", "", "srcName", "dstLibPath", "doInit", "callFrom", "preloadEngine", "plugin-luggage-wechat-impl_release"})
  public static final class a
  {
    public static boolean IU(int paramInt)
    {
      AppMethodBeat.i(217227);
      ad.i(d.access$getTAG$cp(), "doInit");
      if (!d.dfA())
      {
        j.load("wechatxlog");
        j.load("wechatmm");
        j.load("andromeda");
        j.load("wechatlv");
        ad.i(d.access$getTAG$cp(), "preloadEngine");
        LiteAppCenter.addJsApi("login", com.tencent.mm.plugin.lite.c.b.class);
        LiteAppCenter.addJsApi("startWebView", com.tencent.mm.plugin.lite.c.c.class);
        LiteAppCenter.addJsApi("openUserProfile", com.tencent.mm.plugin.lite.e.b.class);
        LiteAppCenter.addJsApi("doGoToRecVideoList", com.tencent.mm.plugin.lite.e.a.class);
        LiteAppCenter.addJsApi("launchApplication", com.tencent.mm.plugin.lite.c.a.class);
        Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class);
        p.g(localObject, "MMKernel.service(ILuggageGameService::class.java)");
        LiteAppCenter.addJsApi("wxalited0d6cb88ac866bcdf3b738f1f3df8872", ((com.tencent.mm.plugin.game.luggage.a.a)localObject).cXb());
        localObject = (com.tencent.wax.c)a.uYi;
        localObject = new com.tencent.wax.d.a(aj.getContext()).a(FlutterView.b.MBV).a((com.tencent.wax.a)new com.tencent.mm.plugin.lite.b.a(aj.getContext())).a((a.a)new com.tencent.mm.plugin.lite.ui.b()).aZW("liteApp").a((com.tencent.wax.c)localObject).fYS();
        com.tencent.wax.d.fYR().a((com.tencent.wax.d.a)localObject);
        com.tencent.wax.d.fYR().init();
        ad.d(d.access$getTAG$cp(), "start init lvcpp");
        LiteAppCenter.setDarkMode(com.tencent.mm.ui.al.isDarkMode());
        localObject = aj.getContext().getResources().getDisplayMetrics();
        int i = com.tencent.mm.ui.al.aL(aj.getContext(), 0);
        int j = ((DisplayMetrics)localObject).densityDpi;
        int k = ((DisplayMetrics)localObject).widthPixels;
        int m = ((DisplayMetrics)localObject).heightPixels - i;
        float f = ((DisplayMetrics)localObject).density;
        localObject = com.tencent.mm.ui.al.ci(aj.getContext());
        ad.i(d.access$getTAG$cp(), "SetDisplayParams w=%d h=%d screen=%d,%d, density=%f dpi=%d, statusBar=%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(((Point)localObject).x), Integer.valueOf(((Point)localObject).y), Float.valueOf(f), Integer.valueOf(j), Integer.valueOf(i) });
        LiteAppCenter.setDisplayParams(k / f, m / f, ((Point)localObject).x / f, ((Point)localObject).y / f, j, f);
        com.tencent.mm.plugin.lite.logic.c.dfF();
        localObject = com.tencent.mm.plugin.lite.logic.c.aoy("wxalitebaselibrary");
        if ((i.DEBUG) || (bu.flW())) {
          if ((localObject != null) && (((com.tencent.mm.plugin.lite.d.b)localObject).dfH()))
          {
            ad.i(d.access$getTAG$cp(), "preload base lib using rdm version");
            LiteAppCenter.setPath(((com.tencent.mm.plugin.lite.d.b)localObject).field_pkgPath);
          }
        }
        for (;;)
        {
          ad.i(d.access$getTAG$cp(), "end init lvcpp");
          d.dfB();
          com.tencent.mm.plugin.report.service.g.yhR.dD(1404, paramInt);
          AppMethodBeat.o(217227);
          return false;
          ad.i(d.access$getTAG$cp(), "preload base lib using apk version");
          hG("flutter-view.runtime.js", com.tencent.mm.storage.al.IpN + "/flutter-view.runtime.js");
          LiteAppCenter.setPath(com.tencent.mm.storage.al.IpN);
          continue;
          if (localObject != null)
          {
            ad.i(d.access$getTAG$cp(), "preload base lib using version:" + ((com.tencent.mm.plugin.lite.d.b)localObject).field_pkgType);
            LiteAppCenter.setPath(((com.tencent.mm.plugin.lite.d.b)localObject).field_pkgPath);
          }
          else
          {
            ad.i(d.access$getTAG$cp(), "preload base lib using apk version");
            hG("flutter-view.runtime.js", com.tencent.mm.storage.al.IpN + "/flutter-view.runtime.js");
            LiteAppCenter.setPath(com.tencent.mm.storage.al.IpN);
          }
        }
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(217227);
        return true;
        com.tencent.mm.plugin.report.service.g.yhR.dD(1404, 1);
        continue;
        com.tencent.mm.plugin.report.service.g.yhR.dD(1404, 3);
      }
    }
    
    private static void hG(String paramString1, String paramString2)
    {
      AppMethodBeat.i(217228);
      try
      {
        paramString2 = new File(paramString2);
        if (paramString2.exists()) {
          paramString2.delete();
        }
        Object localObject = aj.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        paramString1 = ((Context)localObject).getAssets().open(paramString1);
        paramString2 = new FileOutputStream(paramString2);
        localObject = new byte[1024];
        y.d locald = new y.d();
        for (;;)
        {
          int i = paramString1.read((byte[])localObject);
          locald.MLT = i;
          if (i == -1) {
            break;
          }
          paramString2.write((byte[])localObject, 0, locald.MLT);
        }
        paramString1.close();
      }
      catch (Exception paramString1)
      {
        AppMethodBeat.o(217228);
        return;
      }
      paramString2.close();
      AppMethodBeat.o(217228);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "mRegistry", "Lio/flutter/plugin/common/PluginRegistry;", "kotlin.jvm.PlatformType", "registerPlugins"})
    static final class a
      implements com.tencent.wax.c
    {
      public static final a uYi;
      
      static
      {
        AppMethodBeat.i(217226);
        uYi = new a();
        AppMethodBeat.o(217226);
      }
      
      public final void a(m paramm)
      {
        AppMethodBeat.i(217225);
        io.flutter.a.a.registerWith(paramm);
        AppMethodBeat.o(217225);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.d
 * JD-Core Version:    0.7.0.1
 */