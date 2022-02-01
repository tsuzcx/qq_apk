package com.tencent.mm.plugin.lite;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.al;
import com.tencent.wax.c.a.a;
import d.g.b.p;
import d.g.b.y.d;
import d.l;
import d.n.n;
import io.flutter.embedding.android.FlutterView.b;
import io.flutter.plugin.a.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit;", "", "()V", "Companion", "plugin-luggage-wechat-impl_release"})
public final class d
{
  private static String TAG;
  private static boolean cBE;
  public static final a vjW;
  
  static
  {
    AppMethodBeat.i(217875);
    vjW = new a((byte)0);
    TAG = "MicroMsg.LiteAppProcessProfileInit";
    AppMethodBeat.o(217875);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion;", "", "()V", "CALL_FROM_APP_UI", "", "CALL_FROM_APP_UI_HAD_INIT", "CALL_FROM_PROFILE_EXEC", "CALL_FROM_PROFILE_EXEC_HAD_INIT", "CALL_FROM_PROXY_UI", "CALL_FROM_PROXY_UI_HAD_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "isInit", "", "()Z", "setInit", "(Z)V", "copyLibs", "", "dstLibPath", "doInit", "callFrom", "preloadEngine", "readMetaFromAssets", "setBaseLibPath", "versionGreater", "first", "second", "plugin-luggage-wechat-impl_release"})
  public static final class a
  {
    public static boolean Js(int paramInt)
    {
      AppMethodBeat.i(217870);
      ae.i(d.access$getTAG$cp(), "doInit");
      if (!d.dis())
      {
        com.tencent.mm.compatible.util.j.load("wechatxlog");
        com.tencent.mm.compatible.util.j.load("wechatmm");
        com.tencent.mm.compatible.util.j.load("andromeda");
        com.tencent.mm.compatible.util.j.load("wechatlv");
        ae.i(d.access$getTAG$cp(), "preloadEngine");
        LiteAppCenter.addJsApi("login", com.tencent.mm.plugin.lite.c.b.class);
        LiteAppCenter.addJsApi("session", com.tencent.mm.plugin.lite.c.d.class);
        LiteAppCenter.addJsApi("startWebView", com.tencent.mm.plugin.lite.c.e.class);
        LiteAppCenter.addJsApi("openUserProfile", com.tencent.mm.plugin.lite.e.b.class);
        LiteAppCenter.addJsApi("doGoToRecVideoList", com.tencent.mm.plugin.lite.e.a.class);
        LiteAppCenter.addJsApi("launchApplication", com.tencent.mm.plugin.lite.c.a.class);
        LiteAppCenter.addJsApi("sendAppMessage", com.tencent.mm.plugin.lite.c.c.class);
        Object localObject = com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.game.luggage.a.a.class);
        p.g(localObject, "MMKernel.service(ILuggageGameService::class.java)");
        LiteAppCenter.addJsApi(((com.tencent.mm.plugin.game.luggage.a.a)localObject).cZI());
        localObject = (com.tencent.wax.c)a.vjX;
        localObject = new com.tencent.wax.d.a(ak.getContext()).a(FlutterView.b.MZa).a((com.tencent.wax.a)new com.tencent.mm.plugin.lite.b.a(ak.getContext())).a((a.a)new com.tencent.mm.plugin.lite.ui.c()).bbz("liteApp").a((com.tencent.wax.c)localObject).gds();
        com.tencent.wax.d.gdr().a((com.tencent.wax.d.a)localObject);
        com.tencent.wax.d.gdr().init();
        ae.d(d.access$getTAG$cp(), "start init lvcpp");
        LiteAppCenter.updateDarkMode(al.isDarkMode());
        localObject = ak.getContext().getResources().getDisplayMetrics();
        int i = al.aL(ak.getContext(), 0);
        int j = ((DisplayMetrics)localObject).densityDpi;
        int k = ((DisplayMetrics)localObject).widthPixels;
        int m = ((DisplayMetrics)localObject).heightPixels - i;
        float f = ((DisplayMetrics)localObject).density;
        localObject = al.ck(ak.getContext());
        ae.i(d.access$getTAG$cp(), "SetDisplayParams w=%d h=%d screen=%d,%d, density=%f dpi=%d, statusBar=%d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(((Point)localObject).x), Integer.valueOf(((Point)localObject).y), Float.valueOf(f), Integer.valueOf(j), Integer.valueOf(i) });
        LiteAppCenter.setDisplayParams(k / f, m / f, ((Point)localObject).x / f, ((Point)localObject).y / f, j, f);
        diu();
        ae.i(d.access$getTAG$cp(), "end init lvcpp");
        d.dit();
        com.tencent.mm.plugin.report.service.g.yxI.dD(1404, paramInt);
        AppMethodBeat.o(217870);
        return false;
      }
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(217870);
        return true;
        com.tencent.mm.plugin.report.service.g.yxI.dD(1404, 1);
        continue;
        com.tencent.mm.plugin.report.service.g.yxI.dD(1404, 3);
      }
    }
    
    private static void apx(String paramString)
    {
      AppMethodBeat.i(217874);
      int i = 0;
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        if (i < 2) {
          try
          {
            localObject1 = new String[] { "flutter-view.runtime.js", "meta.json" }[i];
            localObject2 = new File(paramString + '/' + (String)localObject1);
            if (((File)localObject2).exists()) {
              ((File)localObject2).delete();
            }
            Object localObject3 = ak.getContext();
            p.g(localObject3, "MMApplicationContext.getContext()");
            localObject1 = ((Context)localObject3).getAssets().open((String)localObject1);
            localObject2 = new FileOutputStream((File)localObject2);
            localObject3 = new byte[1024];
            y.d locald = new y.d();
            for (;;)
            {
              int j = ((InputStream)localObject1).read((byte[])localObject3);
              locald.NiW = j;
              if (j == -1) {
                break;
              }
              ((FileOutputStream)localObject2).write((byte[])localObject3, 0, locald.NiW);
            }
            AppMethodBeat.o(217874);
          }
          catch (Exception paramString)
          {
            ae.printErrStackTrace(d.access$getTAG$cp(), (Throwable)paramString, "", new Object[0]);
          }
        } else {
          return;
        }
        ((InputStream)localObject1).close();
        ((FileOutputStream)localObject2).close();
        i += 1;
      }
    }
    
    public static void diu()
    {
      AppMethodBeat.i(217871);
      com.tencent.mm.plugin.lite.logic.c.diz();
      Object localObject3 = com.tencent.mm.plugin.lite.logic.c.apC("wxalitebaselibrary");
      Object localObject2 = am.IKj + "/pkg";
      Object localObject1 = new File((String)localObject2);
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdirs();
      }
      if ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (bv.fpR()))
      {
        if ((localObject3 != null) && (((com.tencent.mm.plugin.lite.d.e)localObject3).diD()))
        {
          ae.i(d.access$getTAG$cp(), "preload base lib using rdm version");
          LiteAppCenter.setPath(((com.tencent.mm.plugin.lite.d.e)localObject3).field_pkgPath);
          AppMethodBeat.o(217871);
          return;
        }
        ae.i(d.access$getTAG$cp(), "preload base lib using apk version");
        apx((String)localObject2);
        LiteAppCenter.setPath((String)localObject2);
        AppMethodBeat.o(217871);
        return;
      }
      localObject1 = LiteAppCenter.getBaseLibVersionByPath((String)localObject2);
      String str = LiteAppCenter.getBaseLibVersionByString(div());
      ae.i(d.access$getTAG$cp(), "base lib localVersion:" + (String)localObject1 + ", assetsVersion:" + str);
      p.g(str, "assetsVersion");
      p.g(localObject1, "localVersion");
      if (hN(str, (String)localObject1))
      {
        ae.i(d.access$getTAG$cp(), "copy base lib " + str + " to " + (String)localObject2);
        apx((String)localObject2);
        localObject1 = LiteAppCenter.getBaseLibVersionByPath((String)localObject2);
      }
      for (;;)
      {
        if (localObject3 != null)
        {
          str = LiteAppCenter.getBaseLibVersionByPath(((com.tencent.mm.plugin.lite.d.e)localObject3).field_pkgPath);
          localObject3 = ((com.tencent.mm.plugin.lite.d.e)localObject3).field_pkgPath;
          p.g(localObject1, "localVersion");
          p.g(str, "dbVersion");
          if (!hN((String)localObject1, str)) {
            break label360;
          }
        }
        for (;;)
        {
          ae.i(d.access$getTAG$cp(), "preload base lib localVersion:" + (String)localObject1 + ", dbVersion:" + str + ", path:" + (String)localObject2);
          LiteAppCenter.setPath((String)localObject2);
          AppMethodBeat.o(217871);
          return;
          ae.i(d.access$getTAG$cp(), "preload base lib use local, path:".concat(String.valueOf(localObject2)));
          LiteAppCenter.setPath((String)localObject2);
          AppMethodBeat.o(217871);
          return;
          label360:
          localObject2 = localObject3;
        }
      }
    }
    
    private static String div()
    {
      AppMethodBeat.i(217873);
      Object localObject1 = ak.getContext();
      p.g(localObject1, "MMApplicationContext.getContext()");
      localObject1 = ((Context)localObject1).getAssets().open("meta.json");
      Object localObject2 = new byte[((InputStream)localObject1).available()];
      ((InputStream)localObject1).read((byte[])localObject2);
      localObject2 = new String((byte[])localObject2, d.n.d.UTF_8);
      ((InputStream)localObject1).close();
      AppMethodBeat.o(217873);
      return localObject2;
    }
    
    private static boolean hN(String paramString1, String paramString2)
    {
      AppMethodBeat.i(217872);
      if (paramString1 != null) {
        if (((CharSequence)paramString1).length() != 0) {
          break label36;
        }
      }
      label36:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(217872);
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
        AppMethodBeat.o(217872);
        return true;
      }
      paramString1 = n.a((CharSequence)paramString1, new String[] { "\\." });
      paramString2 = n.a((CharSequence)paramString2, new String[] { "\\." });
      int j = d.k.j.lx(paramString1.size(), paramString2.size());
      i = 0;
      while (i < j)
      {
        if (!p.i((String)paramString1.get(i), (String)paramString2.get(i)))
        {
          if (((String)paramString1.get(i)).length() > ((String)paramString2.get(i)).length())
          {
            AppMethodBeat.o(217872);
            return true;
          }
          if (((String)paramString1.get(i)).length() < ((String)paramString2.get(i)).length())
          {
            AppMethodBeat.o(217872);
            return false;
          }
          if (((String)paramString1.get(i)).compareTo((String)paramString2.get(i)) > 0)
          {
            AppMethodBeat.o(217872);
            return true;
          }
          AppMethodBeat.o(217872);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(217872);
      return false;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "mRegistry", "Lio/flutter/plugin/common/PluginRegistry;", "kotlin.jvm.PlatformType", "registerPlugins"})
    static final class a
      implements com.tencent.wax.c
    {
      public static final a vjX;
      
      static
      {
        AppMethodBeat.i(217869);
        vjX = new a();
        AppMethodBeat.o(217869);
      }
      
      public final void a(m paramm)
      {
        AppMethodBeat.i(217868);
        io.flutter.a.a.registerWith(paramm);
        AppMethodBeat.o(217868);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.d
 * JD-Core Version:    0.7.0.1
 */