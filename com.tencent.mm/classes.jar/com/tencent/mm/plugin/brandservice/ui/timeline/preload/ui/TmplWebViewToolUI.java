package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f;
import a.f.b.t;
import a.f.b.v;
import a.y;
import android.app.Activity;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.PreloadSession;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.m;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.w;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "_tmplWebView", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "httpHeader", "", "isA8KeyDone", "", "isDestroied", "isForceUrl", "()Z", "isForceUrl$delegate", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazy;", "isRefreshWebViewByGetA8Key", "isTmplWebView", "lazyMgr", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "getLazyMgr", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ResettableLazyManager;", "openType", "", "getOpenType", "()I", "openType$delegate", "pfullUrl", "rawUrlFromIntent", "getRawUrlFromIntent", "rawUrlFromIntent$delegate", "Lkotlin/Lazy;", "session", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "getSession", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "session$delegate", "tempWebViewClient", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;", "getTempWebViewClient", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;", "setTempWebViewClient", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;)V", "tmplController", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ITmplController;", "getTmplController", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ITmplController;", "setTmplController", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/ITmplController;)V", "tmplParams", "Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "getTmplParams", "()Lcom/tencent/mm/plugin/webview/preload/TmplParams;", "tmplParams$delegate", "tmplWebView", "getTmplWebView", "()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;", "tmplWebView$delegate", "tmplWebViewId", "canTryPreloadNextWebView", "createJsApiHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/jsapi/JsApiHandler;", "createWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "createWebViewClient", "Lcom/tencent/xweb/WebViewClient;", "enableMinimize", "enableWvSHA1", "finish", "", "forceUseOriWebViewUI", "forceUrl", "getWebChromeClient", "Lcom/tencent/xweb/WebChromeClient;", "initTmplWebView", "isFastLoadPage", "isWebViewPreloaded", "loadForceUrl", "fullScreen", "modifyForceUrl", "url", "needInvokePageFinished", "notifyPageInfo", "pageInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPageReady", "onReset", "onResetAfterCreate", "onResetBeforeCreate", "onTmplPageFinish", "isTmpl", "processCommonGetA8KeyFullUrl", "reqUrl", "fullUrl", "processGetA8Key", "data", "processGetA8KeyFail", "refreshWebView", "showBackBtnRes", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$StartGetA8KeyResult;", "force", "updatePageAuth", "Companion", "TmplController", "plugin-brandservice_release"})
public class TmplWebViewToolUI
  extends WebViewUI
{
  public static final TmplWebViewToolUI.a kex;
  protected final com.tencent.mm.plugin.brandservice.ui.timeline.preload.l keg;
  private int keh;
  private b kei;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kej;
  protected a kek;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kel;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k kem;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k ken;
  private final com.tencent.mm.plugin.brandservice.ui.timeline.preload.k keo;
  private boolean kep;
  private boolean keq;
  private String ker;
  private Map<String, String> kes;
  private boolean ket;
  private WebViewUI.h keu;
  private final f kev;
  protected boolean kew;
  
  static
  {
    AppMethodBeat.i(15083);
    eOJ = new a.j.k[] { (a.j.k)v.a(new t(v.aG(TmplWebViewToolUI.class), "tmplWebView", "getTmplWebView()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebView;")), (a.j.k)v.a(new t(v.aG(TmplWebViewToolUI.class), "openType", "getOpenType()I")), (a.j.k)v.a(new t(v.aG(TmplWebViewToolUI.class), "session", "getSession()Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;")), (a.j.k)v.a(new t(v.aG(TmplWebViewToolUI.class), "isForceUrl", "isForceUrl()Z")), (a.j.k)v.a(new t(v.aG(TmplWebViewToolUI.class), "tmplParams", "getTmplParams()Lcom/tencent/mm/plugin/webview/preload/TmplParams;")), (a.j.k)v.a(new t(v.aG(TmplWebViewToolUI.class), "rawUrlFromIntent", "getRawUrlFromIntent()Ljava/lang/String;")) };
    kex = new TmplWebViewToolUI.a((byte)0);
    AppMethodBeat.o(15083);
  }
  
  public TmplWebViewToolUI()
  {
    AppMethodBeat.i(15101);
    this.keg = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.l();
    this.kej = m.a(this.keg, (a.f.a.a)new TmplWebViewToolUI.k(this));
    this.kel = m.a(this.keg, (a.f.a.a)new f(this));
    this.kem = m.a(this.keg, (a.f.a.a)new h(this));
    this.ken = m.a(this.keg, (a.f.a.a)new e(this));
    this.keo = m.a(this.keg, (a.f.a.a)new TmplWebViewToolUI.j(this));
    this.keu = ((WebViewUI.h)new TmplWebViewToolUI.i(this));
    this.kev = a.g.j((a.f.a.a)new g(this));
    this.kew = true;
    AppMethodBeat.o(15101);
  }
  
  private final void Hl(String paramString)
  {
    AppMethodBeat.i(152763);
    g.a locala = com.tencent.mm.plugin.brandservice.ui.timeline.preload.g.kbz;
    if (g.a.aXz())
    {
      AppMethodBeat.o(152763);
      return;
    }
    this.kew = false;
    com.tencent.mm.plugin.webview.preload.a.JZ(102);
    al.d((Runnable)new TmplWebViewToolUI.c(this, paramString));
    AppMethodBeat.o(152763);
  }
  
  private final TmplParams aXn()
  {
    AppMethodBeat.i(15086);
    TmplParams localTmplParams = (TmplParams)this.keo.a(eOJ[4]);
    AppMethodBeat.o(15086);
    return localTmplParams;
  }
  
  private final b aYJ()
  {
    AppMethodBeat.i(152757);
    b localb = (b)this.kej.a(eOJ[0]);
    AppMethodBeat.o(152757);
    return localb;
  }
  
  private final int aYL()
  {
    AppMethodBeat.i(15085);
    int i = ((Number)this.kel.a(eOJ[1])).intValue();
    AppMethodBeat.o(15085);
    return i;
  }
  
  private final PreloadLogic.PreloadSession aYM()
  {
    AppMethodBeat.i(138518);
    PreloadLogic.PreloadSession localPreloadSession = (PreloadLogic.PreloadSession)this.kem.a(eOJ[2]);
    AppMethodBeat.o(138518);
    return localPreloadSession;
  }
  
  private final String getTAG()
  {
    AppMethodBeat.i(15084);
    String str = "MicroMsg.TmplWebViewToolUI:" + this.keh;
    AppMethodBeat.o(15084);
    return str;
  }
  
  protected String Hh(String paramString)
  {
    AppMethodBeat.i(152765);
    a.f.b.j.q(paramString, "url");
    paramString = com.tencent.mm.plugin.brandservice.ui.timeline.preload.p.I(com.tencent.mm.plugin.brandservice.ui.timeline.preload.p.dk(com.tencent.mm.plugin.brandservice.ui.timeline.preload.p.dk(com.tencent.mm.plugin.brandservice.ui.timeline.preload.p.dk(paramString, "fasttmpl_flag"), "fasttmpl_type"), "fasttmpl_fullversion"), "forceh5", "1");
    AppMethodBeat.o(152765);
    return paramString;
  }
  
  public final void J(Bundle paramBundle)
  {
    AppMethodBeat.i(15095);
    a.f.b.j.q(paramBundle, "data");
    a locala = this.kek;
    if (locala == null) {
      a.f.b.j.ays("tmplController");
    }
    locala.J(paramBundle);
    AppMethodBeat.o(15095);
  }
  
  public final boolean P(Bundle paramBundle)
  {
    AppMethodBeat.i(15092);
    a.f.b.j.q(paramBundle, "data");
    Object localObject = this.kek;
    if (localObject == null) {
      a.f.b.j.ays("tmplController");
    }
    ((a)localObject).I(paramBundle);
    localObject = paramBundle.getString("geta8key_result_req_url");
    a locala = this.kek;
    if (locala == null) {
      a.f.b.j.ays("tmplController");
    }
    if (((locala instanceof TmplWebViewToolUI.b)) && (localObject != null) && (a.f.b.j.e(localObject, daZ()))) {
      d.m((String)localObject, paramBundle);
    }
    boolean bool = super.P(paramBundle);
    AppMethodBeat.o(15092);
    return bool;
  }
  
  protected final void a(a parama)
  {
    AppMethodBeat.i(152759);
    a.f.b.j.q(parama, "<set-?>");
    this.kek = parama;
    AppMethodBeat.o(152759);
  }
  
  protected void aJe()
  {
    AppMethodBeat.i(154589);
    ab.d(getTAG(), "onPageReady");
    Object localObject = this.kei;
    if (localObject != null) {
      ((b)localObject).aJe();
    }
    localObject = this.kek;
    if (localObject == null) {
      a.f.b.j.ays("tmplController");
    }
    if (!(localObject instanceof a.a))
    {
      localObject = this.kei;
      if (localObject != null)
      {
        ((b)localObject).aYE();
        AppMethodBeat.o(154589);
        return;
      }
    }
    AppMethodBeat.o(154589);
  }
  
  public final a aYK()
  {
    AppMethodBeat.i(152758);
    a locala = this.kek;
    if (locala == null) {
      a.f.b.j.ays("tmplController");
    }
    AppMethodBeat.o(152758);
    return locala;
  }
  
  public final com.tencent.xweb.p aYN()
  {
    try
    {
      AppMethodBeat.i(154588);
      if (this.veY == null) {
        this.veY = ((com.tencent.xweb.p)new TmplWebViewToolUI.d(this));
      }
      com.tencent.xweb.p localp = this.veY;
      a.f.b.j.p(localp, "webChromeClient");
      AppMethodBeat.o(154588);
      return localp;
    }
    finally {}
  }
  
  public void aYO()
  {
    AppMethodBeat.i(152761);
    super.aYO();
    if (((Boolean)this.ken.a(eOJ[3])).booleanValue()) {
      this.kek = ((a)new a.a());
    }
    for (;;)
    {
      a locala = this.kek;
      if (locala == null) {
        a.f.b.j.ays("tmplController");
      }
      locala.aXV();
      AppMethodBeat.o(152761);
      return;
      if ((aXn().kbM == -1) || (bo.isNullOrNil(aXn().uYJ)))
      {
        ab.i(getTAG(), "initTmpl() tmplParams is null");
        this.kek = ((a)new a.a());
        com.tencent.mm.plugin.webview.preload.a.kS(109);
        com.tencent.mm.plugin.webview.preload.a.JZ(101);
      }
      else
      {
        ab.i(getTAG(), "initTmpl() TmplController");
        this.kek = ((a)new TmplWebViewToolUI.b(this, this));
      }
    }
  }
  
  public final com.tencent.mm.plugin.webview.ui.tools.jsapi.d aYP()
  {
    AppMethodBeat.i(15096);
    Object localObject = this.kek;
    if (localObject == null) {
      a.f.b.j.ays("tmplController");
    }
    if (!((a)localObject).aXZ())
    {
      localObject = super.aYP();
      a.f.b.j.p(localObject, "super.createJsApiHandler()");
      AppMethodBeat.o(15096);
      return localObject;
    }
    aYJ().getJsApiHandler().e(this.igU);
    aYJ().getJsApiHandler().KQ(hashCode());
    aYJ().getJsApiHandler().a(this.igV);
    this.igV.a(aYJ().keN, JsapiPermissionWrapper.wib, GeneralControlWrapper.whY);
    localObject = aYJ().getJsApiHandler();
    a.f.b.j.p(localObject, "tmplWebView.jsApiHandler");
    AppMethodBeat.o(15096);
    return localObject;
  }
  
  public final boolean aYQ()
  {
    return false;
  }
  
  public final boolean aYR()
  {
    return false;
  }
  
  public final boolean aYS()
  {
    return true;
  }
  
  public final void aYT()
  {
    AppMethodBeat.i(15100);
    a locala = this.kek;
    if (locala == null) {
      a.f.b.j.ays("tmplController");
    }
    if (!(locala instanceof a.a))
    {
      this.kew = false;
      this.kek = ((a)new a.a());
      ax(daZ(), true);
      this.ket = true;
      AppMethodBeat.o(15100);
      return;
    }
    super.aYT();
    AppMethodBeat.o(15100);
  }
  
  public final boolean aYU()
  {
    return this.kew;
  }
  
  public final boolean aYb()
  {
    AppMethodBeat.i(15098);
    a locala = this.kek;
    if (locala == null) {
      a.f.b.j.ays("tmplController");
    }
    if (locala.aYb())
    {
      AppMethodBeat.o(15098);
      return false;
    }
    boolean bool = super.aYb();
    AppMethodBeat.o(15098);
    return bool;
  }
  
  public MMWebView aYh()
  {
    AppMethodBeat.i(15089);
    Object localObject = this.kek;
    if (localObject == null) {
      a.f.b.j.ays("tmplController");
    }
    if (!((a)localObject).aXY())
    {
      localObject = super.aYh();
      AppMethodBeat.o(15089);
      return localObject;
    }
    localObject = (MMWebView)aYJ();
    AppMethodBeat.o(15089);
    return localObject;
  }
  
  public boolean aYi()
  {
    return true;
  }
  
  public w aYk()
  {
    AppMethodBeat.i(15097);
    Object localObject = this.kek;
    if (localObject == null) {
      a.f.b.j.ays("tmplController");
    }
    if (!((a)localObject).aYa())
    {
      localObject = super.aYk();
      a.f.b.j.p(localObject, "super.createWebViewClient()");
      AppMethodBeat.o(15097);
      return localObject;
    }
    localObject = (w)this.keu;
    AppMethodBeat.o(15097);
    return localObject;
  }
  
  protected boolean aYl()
  {
    return true;
  }
  
  public void aYm()
  {
    AppMethodBeat.i(152762);
    a locala = this.kek;
    if (locala == null) {
      a.f.b.j.ays("tmplController");
    }
    locala.aXW();
    super.aYm();
    AppMethodBeat.o(152762);
  }
  
  protected void aw(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(152766);
    a.f.b.j.q(paramString, "forceUrl");
    Hl(paramString);
    AppMethodBeat.o(152766);
  }
  
  public final WebViewUI.w ax(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(15091);
    Object localObject = this.kek;
    if (localObject == null) {
      a.f.b.j.ays("tmplController");
    }
    ((a)localObject).Hf(paramString);
    localObject = this.kek;
    if (localObject == null) {
      a.f.b.j.ays("tmplController");
    }
    if (((localObject instanceof TmplWebViewToolUI.b)) && (a.f.b.j.e(paramString, daZ())))
    {
      localObject = d.Hj(paramString);
      if ((localObject != null) && (!at.isConnected(ah.getContext())))
      {
        this.vfS.vcK = true;
        P((Bundle)localObject);
        b.a(aYJ(), "");
        paramString = WebViewUI.w.vgZ;
        AppMethodBeat.o(15091);
        return paramString;
      }
    }
    paramString = super.ax(paramString, paramBoolean);
    a.f.b.j.p(paramString, "super.startGetA8Key(url, force)");
    AppMethodBeat.o(15091);
    return paramString;
  }
  
  public final void b(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(15094);
    a.f.b.j.q(paramString1, "reqUrl");
    a.f.b.j.q(paramString2, "fullUrl");
    a.f.b.j.q(paramMap, "httpHeader");
    a locala = this.kek;
    if (locala == null) {
      a.f.b.j.ays("tmplController");
    }
    locala.b(paramString1, paramString2, paramMap);
    com.tencent.mm.plugin.webview.preload.a.JZ(109);
    AppMethodBeat.o(15094);
  }
  
  public final void c(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    AppMethodBeat.i(15093);
    a.f.b.j.q(paramString1, "reqUrl");
    a.f.b.j.q(paramString2, "fullUrl");
    a.f.b.j.q(paramMap, "httpHeader");
    ab.v(getTAG(), "processCommonGetA8KeyFullUrl:".concat(String.valueOf(paramString1)));
    a locala = this.kek;
    if (locala == null) {
      a.f.b.j.ays("tmplController");
    }
    if (locala.a(paramString1, paramString2, paramMap))
    {
      this.keq = true;
      this.ker = paramString2;
      this.kes = paramMap;
      AppMethodBeat.o(15093);
      return;
    }
    super.c(paramString1, paramString2, paramMap);
    AppMethodBeat.o(15093);
  }
  
  public void finish()
  {
    AppMethodBeat.i(15088);
    super.finish();
    if ((aYL() != -1) && (aYL() == 1)) {
      deJ();
    }
    AppMethodBeat.o(15088);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(15087);
    super.onCreate(paramBundle);
    AppMethodBeat.o(15087);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(15090);
    this.kep = true;
    super.onDestroy();
    AppMethodBeat.o(15090);
  }
  
  public void onReset()
  {
    AppMethodBeat.i(152760);
    this.kek = ((a)new a.a());
    this.kei = null;
    com.tencent.mm.plugin.brandservice.ui.timeline.preload.l locall = this.keg;
    synchronized (locall.kct)
    {
      Iterator localIterator = ((Iterable)locall.kct).iterator();
      if (localIterator.hasNext()) {
        ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.j)localIterator.next()).reset();
      }
    }
    localObject.kct.clear();
    y localy = y.BMg;
    super.onReset();
    AppMethodBeat.o(152760);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class b$d
    implements Runnable
  {
    b$d(TmplWebViewToolUI.b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(15051);
      if (TmplWebViewToolUI.h(this.keJ.keI))
      {
        AppMethodBeat.o(15051);
        return;
      }
      this.keJ.aXX();
      AppMethodBeat.o(15051);
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$TmplController$supplyPageFinishInvoke$1", "Ljava/lang/Runnable;", "run", "", "plugin-brandservice_release"})
  public static final class b$j
    implements Runnable
  {
    public final void run()
    {
      AppMethodBeat.i(15058);
      int i = 0;
      try
      {
        boolean bool = TmplWebViewToolUI.h(this.keJ.keI);
        if (bool) {
          return;
        }
        ab.i(TmplWebViewToolUI.c(this.keJ.keI), "[supplyPageFinishInvoke]");
        if (TmplWebViewToolUI.b(this.keJ.keI) != null)
        {
          TmplWebViewToolUI.i(this.keJ.keI);
          i = 1;
        }
        y localy = y.BMg;
        if (i != 0) {
          TmplWebViewToolUI.b(this.keJ.keI).getCurWebviewClient().b((WebView)TmplWebViewToolUI.b(this.keJ.keI), TmplWebViewToolUI.b(this.keJ.keI).getUrl());
        }
        if (TmplWebViewToolUI.b(this.keJ.keI).getDelayInitJsAPI()) {
          TmplWebViewToolUI.j(this.keJ.keI);
        }
        AppMethodBeat.o(15058);
        return;
      }
      finally
      {
        AppMethodBeat.o(15058);
      }
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class e
    extends a.f.b.k
    implements a.f.a.a<Boolean>
  {
    e(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class f
    extends a.f.b.k
    implements a.f.a.a<Integer>
  {
    f(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class g
    extends a.f.b.k
    implements a.f.a.a<String>
  {
    g(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
  }
  
  @a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "invoke"})
  static final class h
    extends a.f.b.k
    implements a.f.a.a<PreloadLogic.PreloadSession>
  {
    h(TmplWebViewToolUI paramTmplWebViewToolUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI
 * JD-Core Version:    0.7.0.1
 */