package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f.a.q;
import a.l;
import a.l.m;
import a.v;
import a.y;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.PreloadSession;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.h;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.o;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.eh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.e.l;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.t;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$TmplController;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ITmplController;", "webViewUI", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;)V", "TIMEOUT_TIME", "", "checkNotifyPageRunnable", "Ljava/lang/Runnable;", "isNextWebViewPreloaded", "", "isUseDataCache", "isUsePreloadWebView", "kv15862", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/Kv15862;", "receivePageData", "showProgressBarRunnable", "startGetPageData", "startLoadPage", "getWebViewUI", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "adjustFullUrl", "", "fullUrl", "afterCreate", "", "beforeCreate", "checkNotifyPage", "createJsApiHandler", "createWebView", "createWebViewClient", "finishAllCheck", "fixProgressBar", "notifyPageInfo", "pageInfo", "preloadWebview", "processCommonGetA8KeyFullUrl", "reqUrl", "httpHeader", "", "processData", "processGetA8Key", "data", "Landroid/os/Bundle;", "processGetA8KeyFail", "processGetAppContext", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "processLongClick", "processReport", "processState", "state", "", "removeShowProcess", "showBackBtnRes", "startGetA8Key", "url", "force", "supplyPageFinishInvoke", "tryPreloadNextWebView", "updateKV", "updatePageAuth", "plugin-brandservice_release"})
final class TmplWebViewToolUI$b
  implements a
{
  private long kdq;
  private long kdr;
  private boolean keA;
  private boolean keB;
  private final long keC;
  final com.tencent.mm.plugin.brandservice.ui.timeline.preload.f keD;
  private final Runnable keE;
  final Runnable keF;
  private boolean keG;
  private final TmplWebViewToolUI keH;
  private long kez;
  
  public TmplWebViewToolUI$b(TmplWebViewToolUI paramTmplWebViewToolUI)
  {
    AppMethodBeat.i(15069);
    this.keH = localObject;
    this.keC = 5000L;
    this.keD = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.f();
    this.keE = ((Runnable)new TmplWebViewToolUI.b.c(this));
    this.keF = ((Runnable)new TmplWebViewToolUI.b.i(this));
    AppMethodBeat.o(15069);
  }
  
  private static String Hm(String paramString)
  {
    AppMethodBeat.i(15066);
    paramString = (CharSequence)paramString;
    paramString = new a.l.k("http://").c(paramString, "https://");
    AppMethodBeat.o(15066);
    return paramString;
  }
  
  private final void aYW()
  {
    AppMethodBeat.i(152752);
    al.d((Runnable)new TmplWebViewToolUI.b.j(this));
    AppMethodBeat.o(152752);
  }
  
  public final void Hf(String paramString)
  {
    AppMethodBeat.i(15062);
    if ((paramString != null) && (a.f.b.j.e(paramString, TmplWebViewToolUI.e(this.keI))))
    {
      com.tencent.mm.plugin.webview.preload.a.gK(TmplWebViewToolUI.d(this.keI).uYL, 116);
      this.keD.kan = System.currentTimeMillis();
    }
    AppMethodBeat.o(15062);
  }
  
  public final void Hn(String paramString)
  {
    AppMethodBeat.i(15068);
    a.f.b.j.q(paramString, "pageInfo");
    ab.i(TmplWebViewToolUI.c(this.keI), "[notifyPageInfo]pageInfo:".concat(String.valueOf(paramString)));
    try
    {
      paramString = new JSONObject(paramString);
      JSONObject localJSONObject = new JSONObject(paramString.optString("performance"));
      long l1 = localJSONObject.getLong("compileTime");
      long l2 = localJSONObject.getLong("receivePageDataTimestamp");
      long l3 = localJSONObject.getLong("firstScreenTimestamp");
      long l4 = localJSONObject.getLong("firstScreenTime");
      this.keD.kah = l1;
      this.keD.kai = l2;
      this.keD.kae = l3;
      this.keD.kag = l4;
      if (a.f.b.j.e(paramString.optString("injectPageDataResult", "fail"), "ok"))
      {
        TmplWebViewToolUI.b(this.keI).setNotifyPageSuccess(true);
        this.keD.kaZ = true;
        this.keD.IE();
        com.tencent.mm.plugin.webview.preload.a.gK(TmplWebViewToolUI.d(this.keI).uYL, 131);
        com.tencent.mm.plugin.webview.preload.a.JZ(108);
      }
      for (;;)
      {
        this.keD.kaw = System.currentTimeMillis();
        aYV();
        al.ae(this.keE);
        if (this.keI.aYl()) {
          al.p((Runnable)new TmplWebViewToolUI.b.d(this), 300L);
        }
        AppMethodBeat.o(15068);
        return;
        this.keD.kbo = true;
        TmplWebViewToolUI.a(this.keI);
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace(TmplWebViewToolUI.c(this.keI), (Throwable)paramString, "", new Object[0]);
        this.keD.kbo = true;
        TmplWebViewToolUI.a(this.keI);
      }
    }
  }
  
  public final void I(Bundle paramBundle)
  {
    AppMethodBeat.i(15063);
    a.f.b.j.q(paramBundle, "data");
    String str = paramBundle.getString("geta8key_result_full_url");
    if (str == null) {
      a.f.b.j.ebi();
    }
    if (m.jw(str, "http://"))
    {
      JsapiPermissionWrapper localJsapiPermissionWrapper = new JsapiPermissionWrapper(paramBundle.getByteArray("geta8key_result_jsapi_perm_control_bytes"));
      paramBundle = new GeneralControlWrapper(paramBundle.getInt("geta8key_result_general_ctrl_b1"));
      TmplWebViewToolUI.k(this.keI).a(Hm(str), localJsapiPermissionWrapper, paramBundle);
    }
    AppMethodBeat.o(15063);
  }
  
  public final void J(Bundle paramBundle)
  {
    AppMethodBeat.i(15067);
    a.f.b.j.q(paramBundle, "data");
    com.tencent.mm.plugin.webview.preload.a.gK(TmplWebViewToolUI.d(this.keI).uYL, 118);
    this.keD.kao = System.currentTimeMillis();
    b.a(TmplWebViewToolUI.b(this.keI), "");
    if (TmplWebViewToolUI.l(this.keI) != null)
    {
      paramBundle = TmplWebViewToolUI.l(this.keI);
      a.f.b.j.p(paramBundle, "this@TmplWebViewToolUI.refreshMask");
      paramBundle.setVisibility(8);
    }
    AppMethodBeat.o(15067);
  }
  
  public final boolean a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(15064);
    a.f.b.j.q(paramString1, "reqUrl");
    a.f.b.j.q(paramString2, "fullUrl");
    a.f.b.j.q(paramMap, "httpHeader");
    com.tencent.mm.plugin.webview.preload.a.gK(TmplWebViewToolUI.d(this.keI).uYL, 117);
    this.keD.kao = System.currentTimeMillis();
    this.keD.kaY = true;
    aYV();
    this.keD.IE();
    b(paramString1, paramString2, paramMap);
    TmplWebViewToolUI.b(this.keI).a(true, Hm(paramString2), TmplWebViewToolUI.f(this.keI));
    this.keI.vfS.ail(Hm(paramString2));
    AppMethodBeat.o(15064);
    return true;
  }
  
  public final void aXV()
  {
    int j = 0;
    AppMethodBeat.i(15059);
    this.keI.getIntent().putExtra("show_native_web_view", true);
    al.p(this.keF, 500L);
    Object localObject1 = (b)c.a((Context)this.keI, TmplWebViewToolUI.d(this.keI));
    int i;
    label146:
    Object localObject2;
    label227:
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = c.b((Context)this.keI, TmplWebViewToolUI.d(this.keI));
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebView");
        AppMethodBeat.o(15059);
        throw ((Throwable)localObject1);
      }
      localObject1 = (b)localObject1;
      this.keA = false;
      com.tencent.mm.plugin.webview.preload.a.gK(TmplWebViewToolUI.d(this.keI).uYL, 111);
      if (!com.tencent.mm.plugin.webview.ui.tools.jsapi.f.c((WebView)localObject1)) {
        break label512;
      }
      i = 112;
      com.tencent.mm.plugin.webview.preload.a.JZ(i);
      localObject2 = this.keI;
      if (localObject1 == null) {
        a.f.b.j.ebi();
      }
      TmplWebViewToolUI.a((TmplWebViewToolUI)localObject2, (b)localObject1);
      localObject1 = TmplWebViewToolUI.b(this.keI);
      localObject2 = (a.f.a.b)TmplWebViewToolUI.b.e.keK;
      a.f.b.j.q(this, "context");
      a.f.b.j.q(localObject2, "callback");
      if (!((b)localObject1).kdC) {
        break label518;
      }
      ((a.f.a.b)localObject2).S(new WeakReference(this));
      ab.v(TmplWebViewToolUI.c(this.keI), "processData");
      this.kez = System.currentTimeMillis();
      this.kdq = this.keI.getIntent().getLongExtra(e.l.yVl, 0L);
      localObject1 = g.RI().Rj();
      a.f.b.j.p(localObject1, "MMKernel.process().current()");
      localObject1 = ((com.tencent.mm.kernel.b.h)localObject1).SC();
      localObject2 = this.keI.getIntent().getStringExtra(e.l.yVn);
      if (localObject2 != null) {
        break label539;
      }
      localObject1 = TmplWebViewToolUI.c(this.keI);
      localObject2 = new StringBuilder("dataKey is null, ");
      localObject3 = this.keI.getIntent();
      a.f.b.j.p(localObject3, "intent");
      ab.e((String)localObject1, com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.Q((Intent)localObject3));
      com.tencent.mm.plugin.webview.preload.a.JZ(151);
      localObject1 = com.tencent.mm.plugin.report.service.h.qsU;
      localObject2 = this.keI.getIntent();
      a.f.b.j.p(localObject2, "intent");
      ((com.tencent.mm.plugin.report.service.h)localObject1).e(17260, new Object[] { Integer.valueOf(1), com.tencent.mm.plugin.brandservice.ui.timeline.preload.d.Q((Intent)localObject2) });
      this.keI.finish();
    }
    for (;;)
    {
      if ((com.tencent.mm.sdk.platformtools.f.DEBUG) || (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (1 >= ab.getLogLevel())) {
        TmplWebViewToolUI.a(this.keI, (View.OnLongClickListener)new TmplWebViewToolUI.b.h(this));
      }
      AppMethodBeat.o(15059);
      return;
      if (((b)localObject1).getState() >= 2) {}
      for (boolean bool = true;; bool = false)
      {
        this.keA = bool;
        com.tencent.mm.plugin.webview.preload.a.gK(TmplWebViewToolUI.d(this.keI).uYL, 110);
        break;
      }
      label512:
      i = 119;
      break label146;
      label518:
      ((b)localObject1).kdD = ((a.f.a.a)new b.h((a.f.a.b)localObject2, this));
      break label227;
      label539:
      localObject3 = this.keD;
      if (((g.a)localObject1).eKF < this.kdq)
      {
        bool = true;
        label560:
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.f)localObject3).kaW = bool;
        if (!this.keD.kaW) {
          break label916;
        }
        i = 104;
        label579:
        com.tencent.mm.plugin.webview.preload.a.JZ(i);
        switch (o.a(this.keI.getIntent().getIntExtra(e.l.yVs, -1), this.kdq, Process.myPid(), ((g.a)localObject1).eKx))
        {
        }
      }
      for (;;)
      {
        this.keD.kaS = TmplWebViewToolUI.f(this.keI).kbS;
        this.keD.kaT = TmplWebViewToolUI.f(this.keI).kbT;
        this.keD.kaU = com.tencent.mm.plugin.webview.ui.tools.jsapi.f.c((WebView)TmplWebViewToolUI.b(this.keI));
        this.keD.kaV = TmplWebViewToolUI.f(this.keI).kaV;
        this.keD.kaD = ((g.a)localObject1).eKx;
        this.keD.kaE = ((g.a)localObject1).eKy;
        this.keD.kaF = ((g.a)localObject1).eKz;
        this.keD.kaG = ((g.a)localObject1).eKA;
        this.keD.kaH = ((g.a)localObject1).eKB;
        this.keD.kaI = ((g.a)localObject1).eKC;
        this.keD.kaJ = ((g.a)localObject1).eKD;
        this.keD.kaK = ((g.a)localObject1).eKE;
        this.keD.kaL = ((g.a)localObject1).eKF;
        this.keD.kad = this.kdq;
        this.keD.kaj = this.kez;
        this.keD.kbq = TmplWebViewToolUI.f(this.keI).kbq;
        i = j;
        if (!m.ap((CharSequence)TmplWebViewToolUI.b(this.keI).getNotifyPageInfoString())) {
          i = 1;
        }
        if (i == 0) {
          break label960;
        }
        ab.i(TmplWebViewToolUI.c(this.keI), "notifyPageInfo by intercept");
        Hn(TmplWebViewToolUI.b(this.keI).getNotifyPageInfoString());
        break;
        bool = false;
        break label560;
        label916:
        i = 103;
        break label579;
        this.keD.kaX = 1;
        this.kdq = ((g.a)localObject1).eKx;
        continue;
        this.keD.kaX = 2;
        this.kdq = -1L;
      }
      label960:
      TmplWebViewToolUI.b(this.keI).setOnNotifyPage((a.f.a.a)new TmplWebViewToolUI.b.f(this));
      PreloadLogic.kbJ.a(this, (String)localObject2, TmplWebViewToolUI.f(this.keI), (q)g.keL);
    }
  }
  
  public final void aXW()
  {
    AppMethodBeat.i(15061);
    ab.i(TmplWebViewToolUI.c(this.keI), "afterCreate isWebViewCreated:" + this.keA + " state:" + TmplWebViewToolUI.b(this.keI).getState());
    if (!TmplWebViewToolUI.b(this.keI).kdy)
    {
      ab.i(TmplWebViewToolUI.c(this.keI), "check notifyPage");
      al.p(this.keE, this.keC);
    }
    sG(TmplWebViewToolUI.b(this.keI).getState());
    TmplWebViewToolUI.b(this.keI).f((a.f.a.b)new a(this));
    if ((this.keA) && (this.keI.aYl())) {
      al.p((Runnable)new TmplWebViewToolUI.b.b(this), 1000L);
    }
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.f localf = this.keD;
    Object localObject = TmplWebViewToolUI.d(this.keI);
    a.f.b.j.q(localObject, "<set-?>");
    localf.jZV = ((TmplParams)localObject);
    localf = this.keD;
    localObject = TmplWebViewToolUI.e(this.keI);
    a.f.b.j.p(localObject, "getRawUrl()");
    a.f.b.j.q(localObject, "<set-?>");
    localf.url = ((String)localObject);
    this.keD.kaN = this.keA;
    this.keD.kaM = this.keB;
    this.keD.kbm = TmplWebViewToolUI.b(this.keI).getWebCoreType().name();
    if (this.keA) {}
    for (int i = 106;; i = 105)
    {
      com.tencent.mm.plugin.webview.preload.a.JZ(i);
      i.showToast("use preloaded webview:true");
      AppMethodBeat.o(15061);
      return;
    }
  }
  
  public final void aXX()
  {
    AppMethodBeat.i(152751);
    try
    {
      boolean bool = this.keG;
      if (bool) {
        return;
      }
      this.keG = true;
      Object localObject1 = y.BMg;
      bool = this.keI.getIntent().getBooleanExtra(e.l.yVk, true);
      ab.i(TmplWebViewToolUI.c(this.keI), "[preloadNextWebView] ".concat(String.valueOf(bool)));
      if (bool)
      {
        localObject1 = c.kdW;
        c.sC(TmplWebViewToolUI.f(this.keI).kbM);
      }
      AppMethodBeat.o(152751);
      return;
    }
    finally
    {
      AppMethodBeat.o(152751);
    }
  }
  
  public final boolean aXY()
  {
    return true;
  }
  
  public final boolean aXZ()
  {
    return true;
  }
  
  final void aYV()
  {
    AppMethodBeat.i(15060);
    this.keD.kax = TmplWebViewToolUI.g(this.keI).alb("onCreate");
    this.keD.kay = TmplWebViewToolUI.g(this.keI).alb("onUIInitStart");
    this.keD.kaz = TmplWebViewToolUI.g(this.keI).alb("onUIInitEnd");
    this.keD.kaA = TmplWebViewToolUI.g(this.keI).alb("onTryBindServiceStart");
    this.keD.kaA = TmplWebViewToolUI.g(this.keI).alb("onTryBindServiceEnd");
    this.keD.kaB = TmplWebViewToolUI.g(this.keI).alb("onPostBindedStart");
    this.keD.kaC = TmplWebViewToolUI.g(this.keI).alb("onPostBindedEnd");
    b localb = TmplWebViewToolUI.b(this.keI);
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.f localf = this.keD;
    a.f.b.j.q(localf, "kv");
    ab.v(localb.getTAG(), "terry trace updateKV");
    localf.kar = localb.getPerformanceHelper().alb("onInjectStart");
    localf.kas = localb.getPerformanceHelper().alb("onInjectEnd");
    localf.kau = localb.getPerformanceHelper().alb("onTmplLoadStart");
    localf.kav = localb.getPerformanceHelper().alb("onTmplLoadEnd");
    localf.kap = localb.getPerformanceHelper().alb("onCreateStart");
    localf.kaq = localb.getPerformanceHelper().alb("onCreateEnd");
    localf.kaP = localb.kdx;
    localf.kat = localb.getPerformanceHelper().alb("onWebInjectEnd");
    String str = localb.getRandomStr();
    a.f.b.j.p(str, "randomStr");
    a.f.b.j.q(str, "<set-?>");
    localf.key = str;
    localf.kaQ = localb.kaQ;
    AppMethodBeat.o(15060);
  }
  
  public final boolean aYa()
  {
    return true;
  }
  
  public final boolean aYb()
  {
    return true;
  }
  
  public final void b(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(15065);
    a.f.b.j.q(paramString1, "reqUrl");
    a.f.b.j.q(paramString2, "fullUrl");
    a.f.b.j.q(paramMap, "httpHeader");
    ab.i(TmplWebViewToolUI.c(this.keI), "[updatePageAuth]reqUrl:" + paramString1 + " fullUrl:" + paramString2 + " httpHeader:" + paramMap);
    TmplWebViewToolUI.b(this.keI).evaluateJavascript("history.replaceState({},\"\",\"" + Hm(paramString2) + "\");", null);
    paramString1 = TmplWebViewToolUI.b(this.keI).getSettings();
    a.f.b.j.p(paramString1, "tmplWebView.settings");
    paramString1 = paramString1.getUserAgentString();
    a.f.b.j.p(paramString1, "tmplWebView.settings.userAgentString");
    paramMap.put("User-agent", paramString1);
    this.keI.uQS.aiT(new JSONObject(paramMap).toString());
    paramString1 = Uri.parse(paramString2).getQueryParameter("pass_ticket");
    this.keI.uQS.aiS(paramString1);
    AppMethodBeat.o(15065);
  }
  
  final void sG(int paramInt)
  {
    AppMethodBeat.i(152750);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(152750);
      return;
      al.ae(this.keE);
      this.keD.kbo = true;
      TmplWebViewToolUI.a(this.keI);
      aYV();
      i.showToast("preloaded webview:error");
      ab.e(TmplWebViewToolUI.c(this.keI), "onReady fail, forceUseOriWebViewUI");
      AppMethodBeat.o(152750);
      return;
      aYW();
      AppMethodBeat.o(152750);
      return;
      ab.w(TmplWebViewToolUI.c(this.keI), "onReady success");
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "state", "", "invoke"})
  static final class a
    extends a.f.b.k
    implements a.f.a.b<Integer, y>
  {
    a(TmplWebViewToolUI.b paramb)
    {
      super();
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "context", "Ljava/lang/ref/WeakReference;", "", "result", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$MountableCGIResult;", "appMsgContext", "Lcom/tencent/mm/protocal/protobuf/AppMsgContext;", "invoke"})
  static final class g
    extends a.f.b.k
    implements q<WeakReference<Object>, PreloadLogic.h, eh, y>
  {
    public static final g keL;
    
    static
    {
      AppMethodBeat.i(154586);
      keL = new g();
      AppMethodBeat.o(154586);
    }
    
    g()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.b
 * JD-Core Version:    0.7.0.1
 */