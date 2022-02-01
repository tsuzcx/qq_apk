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
import com.tencent.liteapp.report.WxaLiteAppStartReport;
import com.tencent.liteapp.storage.WxaLiteAppBaselibInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.lite.a.c.l;
import com.tencent.mm.plugin.lite.a.c.m;
import com.tencent.mm.plugin.lite.a.c.o;
import com.tencent.mm.plugin.lite.a.c.p;
import com.tencent.mm.plugin.lite.a.c.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.wxa.c.a;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit;", "", "()V", "Companion", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a JYS;
  private static Map<String, String> JYT;
  private static String TAG;
  private static boolean isInit;
  
  static
  {
    AppMethodBeat.i(271360);
    JYS = new a((byte)0);
    TAG = "MicroMsg.LiteAppProcessProfileInit";
    JYT = (Map)new HashMap();
    AppMethodBeat.o(271360);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion;", "", "()V", "CALL_FROM_APP_RECEOVER", "", "CALL_FROM_APP_UI", "CALL_FROM_APP_UI_HAD_INIT", "CALL_FROM_PROFILE_EXEC", "CALL_FROM_PROFILE_EXEC_HAD_INIT", "CALL_FROM_PROXY_UI", "CALL_FROM_PROXY_UI_HAD_INIT", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "isInit", "", "()Z", "setInit", "(Z)V", "qrUrlQueryMap", "", "getQrUrlQueryMap", "()Ljava/util/Map;", "setQrUrlQueryMap", "(Ljava/util/Map;)V", "copyLibs", "", "dstLibPath", "doInit", "Lcom/tencent/liteapp/report/WxaLiteAppStartReport;", "callFrom", "reportLiteApp", "preloadEngine", "readMetaFromAssets", "setBaseLibPath", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static void aJR(String paramString)
    {
      AppMethodBeat.i(271322);
      int i = 0;
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        if (i < 9) {
          try
          {
            localObject1 = new String[] { "flutter-view.runtime.js", "meta.json", "store.runtime.js", "flutter-view.base.js", "starter.js", "store.base.js", "VueForFlutterPage.framework.js", "Vue3ForFlutterPage.framework.js", "VuexForStore.framework.js" }[i];
            i += 1;
            localObject2 = new u(paramString + '/' + (String)localObject1);
            if (((u)localObject2).jKS()) {
              ((u)localObject2).diJ();
            }
            localObject1 = MMApplicationContext.getContext().getAssets().open((String)localObject1);
            s.s(localObject1, "getContext().assets.open(fileName)");
            localObject2 = y.ap((u)localObject2);
            s.s(localObject2, "openWrite(dstLibFile)");
            byte[] arrayOfByte = new byte[1024];
            for (;;)
            {
              int j = ((InputStream)localObject1).read(arrayOfByte);
              if (j == -1) {
                break;
              }
              ((OutputStream)localObject2).write(arrayOfByte, 0, j);
            }
            AppMethodBeat.o(271322);
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
      }
    }
    
    public static void fTQ()
    {
      AppMethodBeat.i(271303);
      com.tencent.mm.plugin.lite.logic.d.fUi();
      Object localObject1 = com.tencent.mm.plugin.lite.logic.d.fUj();
      Object localObject2 = LiteAppCenter.getBaseLibVersionByString(fTR());
      s.s(localObject2, "assetsVersion");
      String str = ((String)localObject2).substring(0, kotlin.n.n.a((CharSequence)localObject2, '.', 0, false, 6));
      s.s(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      if (localObject1 != null)
      {
        if (LiteAppCenter.versionGreater((String)localObject2, LiteAppCenter.getBaseLibVersionByPath(y.n(((WxaLiteAppBaselibInfo)localObject1).path, false))))
        {
          localObject1 = com.tencent.mm.plugin.lite.logic.f.aE(str, null, null);
          s.s(localObject1, "getLiteAppBaselibPath(as…MajorVersion, null, null)");
          localObject2 = new u((String)localObject1);
          if (!((u)localObject2).jKS()) {
            ((u)localObject2).jKY();
          }
          aJR((String)localObject1);
          localObject2 = new WxaLiteAppBaselibInfo();
          ((WxaLiteAppBaselibInfo)localObject2).egH = str;
          ((WxaLiteAppBaselibInfo)localObject2).path = ((String)localObject1);
          com.tencent.mm.plugin.lite.logic.d.fUi();
          com.tencent.mm.plugin.lite.logic.d.b((WxaLiteAppBaselibInfo)localObject2);
        }
        for (;;)
        {
          c.setPath(y.n((String)localObject1, false), "Vue");
          AppMethodBeat.o(271303);
          return;
          localObject1 = ((WxaLiteAppBaselibInfo)localObject1).path;
          s.s(localObject1, "info.path");
        }
      }
      localObject1 = com.tencent.mm.plugin.lite.logic.f.aE(str, null, null);
      s.s(localObject1, "getLiteAppBaselibPath(as…MajorVersion, null, null)");
      localObject2 = new u((String)localObject1);
      if (!((u)localObject2).jKS()) {
        ((u)localObject2).jKY();
      }
      aJR((String)localObject1);
      localObject2 = new WxaLiteAppBaselibInfo();
      ((WxaLiteAppBaselibInfo)localObject2).egH = str;
      ((WxaLiteAppBaselibInfo)localObject2).path = ((String)localObject1);
      com.tencent.mm.plugin.lite.logic.d.fUi();
      com.tencent.mm.plugin.lite.logic.d.b((WxaLiteAppBaselibInfo)localObject2);
      Log.i(a.access$getTAG$cp(), s.X("preload base lib use asset, path:", localObject1));
      c.setPath(y.n((String)localObject1, false), "Vue");
      AppMethodBeat.o(271303);
    }
    
    private static String fTR()
    {
      AppMethodBeat.i(271312);
      InputStream localInputStream = MMApplicationContext.getContext().getAssets().open("meta.json");
      s.s(localInputStream, "getContext().assets.open(kMetaFile)");
      Object localObject = new byte[localInputStream.available()];
      localInputStream.read((byte[])localObject);
      localObject = new String((byte[])localObject, kotlin.n.d.UTF_8);
      localInputStream.close();
      AppMethodBeat.o(271312);
      return localObject;
    }
    
    public final WxaLiteAppStartReport a(int paramInt, WxaLiteAppStartReport paramWxaLiteAppStartReport)
    {
      AppMethodBeat.i(271347);
      s.u(paramWxaLiteAppStartReport, "reportLiteApp");
      Log.i(a.access$getTAG$cp(), "doInit");
      com.tencent.mm.plugin.lite.logic.d.fUi();
      if (!com.tencent.mm.plugin.lite.logic.d.fTT())
      {
        Log.i(a.access$getTAG$cp(), "isLiteAppEnable = false");
        paramWxaLiteAppStartReport.egk = false;
        paramWxaLiteAppStartReport.baY = false;
        AppMethodBeat.o(271347);
        return paramWxaLiteAppStartReport;
      }
      paramWxaLiteAppStartReport.egk = true;
      if (!a.fTN())
      {
        com.tencent.mm.compatible.util.k.load("wechatxlog");
        com.tencent.mm.compatible.util.k.load("wechatmm");
        com.tencent.mm.compatible.util.k.load("andromeda");
        com.tencent.mm.compatible.util.k.load("wechatlv");
        com.tencent.mm.compatible.util.k.load("flutter");
        Log.i(a.access$getTAG$cp(), "preloadEngine");
        Object localObject1 = MMApplicationContext.getContext();
        s.s(localObject1, "getContext()");
        localObject1 = new b.b((Context)localObject1, "liteApp");
        Object localObject2 = (com.tencent.liteapp.b.a)new a();
        s.t(localObject2, "log");
        com.tencent.liteapp.b.b.a((com.tencent.liteapp.b.a)localObject2);
        paramWxaLiteAppStartReport.egu = System.currentTimeMillis();
        localObject2 = com.tencent.liteapp.b.efD;
        s.t(localObject1, "config");
        s.t(localObject1, "<set-?>");
        com.tencent.liteapp.b.a((b.b)localObject1);
        localObject1 = b.a.anF().mAppContext;
        s.t(localObject1, "<set-?>");
        com.tencent.liteapp.b.bc((Context)localObject1);
        localObject1 = b.a.anF().mAppContext.getPackageName();
        s.r(localObject1, "this.config.mAppContext.packageName");
        s.t(localObject1, "<set-?>");
        com.tencent.liteapp.b.es((String)localObject1);
        LiteAppCenter.updateDisplayParam(b.a.getAppContext(), 0L);
        localObject1 = b.a.anF();
        localObject2 = new c.a(((b.b)localObject1).mAppContext).a((com.tencent.wxa.b)new com.tencent.liteapp.a.a()).a((com.tencent.wxa.b)new com.tencent.wxa.a.c());
        ((c.a)localObject2).dartEntrypoint = ((b.b)localObject1).efE;
        Object localObject3 = ((b.b)localObject1).efL;
        ((c.a)localObject2).aidD.addAll((Collection)localObject3);
        ((c.a)localObject2).aidC = ((com.tencent.wxa.c.a.a)new b.b.a());
        localObject3 = com.tencent.liteapp.b.efD;
        ((c.a)localObject2).aidE = Boolean.valueOf(b.a.anF().efM);
        localObject3 = com.tencent.liteapp.b.efD;
        ((c.a)localObject2).aidF = Boolean.valueOf(b.a.anF().efN);
        localObject3 = com.tencent.liteapp.b.efD;
        ((c.a)localObject2).aidG = Boolean.valueOf(b.a.anF().efO);
        localObject3 = com.tencent.liteapp.b.efD;
        ((c.a)localObject2).aidH = Boolean.valueOf(b.a.anF().efP);
        ((c.a)localObject2).efF = ((b.b)localObject1).efF;
        ((b.b)localObject1).efK.aidn = ((c.a)localObject2);
        ((b.b)localObject1).efK.init();
        paramWxaLiteAppStartReport.egv = (System.currentTimeMillis() - paramWxaLiteAppStartReport.egu);
        Log.d(a.access$getTAG$cp(), "start init lvcpp");
        c.addJsApi("triggerTestEvent", m.class);
        c.addJsApi("login", com.tencent.mm.plugin.lite.a.c.g.class);
        c.addJsApi("session", com.tencent.mm.plugin.lite.a.c.j.class);
        c.addJsApi("startWebView", l.class);
        c.addJsApi("openUserProfile", com.tencent.mm.plugin.lite.a.f.b.class);
        c.addJsApi("doGoToRecVideoList", com.tencent.mm.plugin.lite.a.f.a.class);
        c.addJsApi("launchMiniProgram", com.tencent.mm.plugin.lite.a.c.f.class);
        c.addJsApi("sendAppMessage", com.tencent.mm.plugin.lite.a.c.i.class);
        c.addJsApi("webSendAppMessage", com.tencent.mm.plugin.lite.a.c.n.class);
        c.addJsApi("shareTimeline", com.tencent.mm.plugin.lite.a.c.k.class);
        c.addJsApi("webShareTimeline", o.class);
        c.addJsApi("openFinderView", com.tencent.mm.plugin.lite.a.d.j.class);
        c.addJsApi("profile", com.tencent.mm.plugin.lite.a.c.h.class);
        c.addJsApi("addContact", com.tencent.mm.plugin.lite.a.c.a.class);
        c.addJsApi("preloadMiniProgramContacts", com.tencent.mm.plugin.lite.a.a.b.class);
        c.addJsApi("preloadMiniProgramEnv", com.tencent.mm.plugin.lite.a.a.c.class);
        c.addJsApi("writeCommData", q.class);
        c.addJsApi("batchAddCard", com.tencent.mm.plugin.lite.a.c.b.class);
        c.addJsApi("calRqt", com.tencent.mm.plugin.lite.a.c.c.class);
        c.addJsApi("jumpToBizProfile", com.tencent.mm.plugin.lite.a.c.e.class);
        c.addJsApi("openFinderTopicView", com.tencent.mm.plugin.lite.a.d.i.class);
        c.addJsApi("openFinderPostView", com.tencent.mm.plugin.lite.a.d.e.class);
        localObject1 = com.tencent.mm.plugin.lite.a.d.b.Kay;
        c.addJsApi(com.tencent.mm.plugin.lite.a.d.b.fUd(), com.tencent.mm.plugin.lite.a.d.b.class);
        c.addJsApi("openFinderCreateAcctView", com.tencent.mm.plugin.lite.a.d.d.class);
        c.addJsApi("openChannelsActivity", com.tencent.mm.plugin.lite.a.d.c.class);
        c.addJsApi("openFinderProfile", com.tencent.mm.plugin.lite.a.d.f.class);
        c.addJsApi("openFinderSearchView", com.tencent.mm.plugin.lite.a.d.g.class);
        c.addJsApi("openFinderTimeLineView", com.tencent.mm.plugin.lite.a.d.h.class);
        c.addJsApi("prerenderMiniProgram", com.tencent.mm.plugin.lite.a.a.a.class);
        localObject1 = com.tencent.mm.plugin.lite.a.d.k.KaC;
        c.addJsApi(com.tencent.mm.plugin.lite.a.d.k.fUd(), com.tencent.mm.plugin.lite.a.d.k.class);
        localObject1 = p.Kat;
        c.addJsApi(p.fUd(), p.class);
        c.addJsApi("downloadGameVideo", com.tencent.mm.plugin.lite.a.e.a.class);
        c.addJsApi("getFinderLivePreviewMicCover", com.tencent.mm.plugin.lite.a.d.a.class);
        c.addJsApi("wxalite5d5719b5b15738e645a321789ebccb5d", "getUin", com.tencent.mm.plugin.lite.a.c.d.class);
        c.addJsApi(((com.tencent.mm.plugin.game.luggage.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.game.luggage.a.a.class)).fEp());
        c.addJsApi(com.tencent.mm.plugin.lite.a.b.a.g.fTY().JZW.JZS);
        c.addJsApi((Map)com.tencent.mm.plugin.lite.a.b.b.d.fUb().Kai.Kae);
        boolean bool = aw.isDarkMode();
        c.init();
        c.updateDarkMode(bool);
        c.fontScaleFollowSystem = false;
        localObject1 = MMApplicationContext.getContext();
        localObject2 = aw.bf((Context)localObject1);
        localObject3 = new DisplayMetrics();
        Object localObject4 = ((Context)localObject1).getSystemService("window");
        if (localObject4 == null)
        {
          paramWxaLiteAppStartReport = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
          AppMethodBeat.o(271347);
          throw paramWxaLiteAppStartReport;
        }
        ((WindowManager)localObject4).getDefaultDisplay().getMetrics((DisplayMetrics)localObject3);
        int i = bf.be((Context)localObject1);
        int j = bf.bk((Context)localObject1);
        int k = ((DisplayMetrics)localObject3).densityDpi;
        int m = ((Point)localObject2).x;
        int n = ((Point)localObject2).y;
        float f1 = ((DisplayMetrics)localObject3).density;
        float f2 = 48.0F * f1;
        Log.i(a.access$getTAG$cp(), "SetDisplayParams w=%d h=%d screen=%d,%d, density=%f dpi=%d, statusBar=%d actionBarHeight:%f, navigationBarHeight:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(((Point)localObject2).x), Integer.valueOf(((Point)localObject2).y), Float.valueOf(f1), Integer.valueOf(k), Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(j) });
        c.setDisplayParams(0L, m / f1, n / f1, ((Point)localObject2).x / f1, ((Point)localObject2).y / f1, k, f1, f2 / f1, i / f1, j / f1);
        paramWxaLiteAppStartReport.egx = System.currentTimeMillis();
        fTQ();
        paramWxaLiteAppStartReport.egy = (System.currentTimeMillis() - paramWxaLiteAppStartReport.egx);
        Log.i(a.access$getTAG$cp(), "end init lvcpp");
        a.fTO();
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1404, paramInt);
        paramWxaLiteAppStartReport.egw = false;
        paramWxaLiteAppStartReport.egt = false;
        paramWxaLiteAppStartReport.baY = false;
        AppMethodBeat.o(271347);
        return paramWxaLiteAppStartReport;
      }
      paramWxaLiteAppStartReport.egw = true;
      paramWxaLiteAppStartReport.egt = true;
      switch (paramInt)
      {
      }
      for (;;)
      {
        paramWxaLiteAppStartReport.baY = true;
        AppMethodBeat.o(271347);
        return paramWxaLiteAppStartReport;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1404, 1);
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.kJ(1404, 3);
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/lite/LiteAppProcessProfileInit$Companion$preloadEngine$1", "Lcom/tencent/liteapp/log/IWxaLiteAppLog;", "d", "", "TAG", "", "format", "objects", "", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", "i", "v", "w", "luggage-lite-app_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements com.tencent.liteapp.b.a
    {
      public final void d(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(271310);
        s.u(paramString2, "format");
        s.u(paramVarArgs, "objects");
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
          AppMethodBeat.o(271310);
          return;
          i = 0;
          break;
        }
        label74:
        Log.d(paramString1, paramString2);
        AppMethodBeat.o(271310);
      }
      
      public final void e(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(271305);
        s.u(paramString2, "format");
        s.u(paramVarArgs, "objects");
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
          AppMethodBeat.o(271305);
          return;
          i = 0;
          break;
        }
        label74:
        Log.e(paramString1, paramString2);
        AppMethodBeat.o(271305);
      }
      
      public final void i(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(271289);
        s.u(paramString2, "format");
        s.u(paramVarArgs, "objects");
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
          AppMethodBeat.o(271289);
          return;
          i = 0;
          break;
        }
        label74:
        Log.i(paramString1, paramString2);
        AppMethodBeat.o(271289);
      }
      
      public final void v(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(271299);
        s.u(paramString2, "format");
        s.u(paramVarArgs, "objects");
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
          AppMethodBeat.o(271299);
          return;
          i = 0;
          break;
        }
        label74:
        Log.v(paramString1, paramString2);
        AppMethodBeat.o(271299);
      }
      
      public final void w(String paramString1, String paramString2, Object... paramVarArgs)
      {
        int j = 1;
        AppMethodBeat.i(271294);
        s.u(paramString2, "format");
        s.u(paramVarArgs, "objects");
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
          AppMethodBeat.o(271294);
          return;
          i = 0;
          break;
        }
        label74:
        Log.w(paramString1, paramString2);
        AppMethodBeat.o(271294);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a
 * JD-Core Version:    0.7.0.1
 */