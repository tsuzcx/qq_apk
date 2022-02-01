package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.g.z;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.r;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.game.e.b.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.d;
import com.tencent.mm.plugin.appbrand.jsapi.webview.c;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.e;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.f;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.plugin.appbrand.report.model.t;
import com.tencent.mm.plugin.appbrand.ui.o;
import com.tencent.mm.plugin.appbrand.widget.input.u.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.base.MMFalseProgressBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.af;
import com.tencent.xweb.x;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract;", "context", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;", "pv", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "(Lcom/tencent/mm/plugin/appbrand/ui/AppBrandRuntimePersistentContextWrapper;Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeWC;Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;)V", "A8KEY_SCENE", "", "IFRAME_A8KEY_SCENE", "REPORTER", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IReporter;", "getREPORTER", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IReporter;", "REPORTER$delegate", "Lkotlin/Lazy;", "url", "", "currentUrl", "_currentUrl", "()Ljava/lang/String;", "setCurrentUrl", "(Ljava/lang/String;)V", "exitReportContextObj", "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$exitReportContextObj$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$exitReportContextObj$1;", "gameResourceReporter", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_19358;", "kotlin.jvm.PlatformType", "<set-?>", "htmlId", "getHtmlId", "()I", "", "isDestroyed", "()Z", "keyboardListener", "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$keyboardListener$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$keyboardListener$1;", "keyboardListenerRegistry", "Lcom/tencent/mm/plugin/appbrand/widget/input/AppBrandKeyboardListener;", "mPullDown", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "getMPullDown", "()Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPullDownExtension;", "mWebViewCallbackClient", "Lcom/tencent/xweb/WebViewCallbackClient;", "onVisibilityChangedListeners", "Landroidx/collection/ArraySet;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView$OnVisibilityChangedListener;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/bwc/OnVisibilityChangedListener;", "progressBar", "Lcom/tencent/mm/ui/base/MMFalseProgressBar;", "proxyWebViewClientExtension", "Lcom/tencent/xweb/x5/export/external/extension/proxy/ProxyWebViewClientExtension;", "reportCanvasDataEventRunnable", "Ljava/lang/Runnable;", "viewActiveStateEmitter", "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$viewActiveStateEmitter$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$viewActiveStateEmitter$1;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "webViewController", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewController;", "getWebViewController", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewController;", "webViewController$delegate", "xwVideoControl", "Lcom/tencent/xweb/VideoControl;", "xwVideoOrientationControlSupported", "getXwVideoOrientationControlSupported", "debugEnabled", "destroy", "", "dispatchEvent", "jObj", "Lorg/json/JSONObject;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getAndroidContext", "Landroid/content/Context;", "getAndroidView", "Landroid/view/View;", "getAppId", "getBinderID", "getController", "getCurrentUrl", "getExitReporter", "Lcom/tencent/mm/plugin/appbrand/report/model/kv_14992;", "getJsApiReportArgs", "", "()[Ljava/lang/String;", "getPageView", "getReporter", "getWebView", "injectEnvVar", "isGame", "navigateBack", "notifyProgressBarEnd", "notifyProgressBarStart", "offVisibilityChange", "l", "onAttachedToWindow", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "_heightMeasureSpec", "onPageCommitVisible", "onPageFinished", "onPageStarted", "onReceivedError", "errorCode", "message", "onReceivedTitle", "title", "onVisibilityChange", "onWebViewClosed", "pauseRendering", "registerKeyboardListener", "reportGameResourceUrl", "pageUrl", "request", "Lcom/tencent/xweb/WebResourceRequest;", "resetContext", "restoreRendering", "runOnUiThread", "r", "scrollToTop", "setAndroidViewId", "id", "setCoverViewId", "shouldHookActivityRequestedOrientation", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends FrameLayout
  implements g, g.c
{
  public static final f.b sMG;
  private boolean aUP;
  private final com.tencent.mm.plugin.appbrand.w qxY;
  private final af sLl;
  private final com.tencent.xweb.x5.export.external.extension.proxy.a sLm;
  private final com.tencent.mm.plugin.appbrand.page.ah sMH;
  private final int sMI;
  private final int sMJ;
  private int sMK;
  private String sML;
  private com.tencent.mm.plugin.appbrand.widget.input.u sMM;
  private final f.e sMN;
  private final f.h sMO;
  private final MMWebView sMP;
  private final MMFalseProgressBar sMQ;
  private final com.tencent.xweb.w sMR;
  private final kotlin.j sMS;
  private final androidx.b.b<g.c.a> sMT;
  private final t sMU;
  private final kotlin.j sMV;
  private final d sMW;
  private final Runnable sMX;
  
  static
  {
    AppMethodBeat.i(327666);
    sMG = new f.b((byte)0);
    AppMethodBeat.o(327666);
  }
  
  private f(o paramo, com.tencent.mm.plugin.appbrand.w paramw, com.tencent.mm.plugin.appbrand.page.ah paramah)
  {
    super((Context)paramo);
    AppMethodBeat.i(327598);
    this.qxY = paramw;
    this.sMH = paramah;
    int i;
    com.tencent.xweb.ad localad;
    String str;
    if (cxI())
    {
      i = 55;
      this.sMI = i;
      i = j;
      if (cxI()) {
        i = 55;
      }
      this.sMJ = i;
      this.sMN = new f.e(this);
      this.sMO = new f.h(this);
      this.sMS = k.cm((kotlin.g.a.a)new f.i(this));
      this.sLl = ((af)new f.f(this));
      this.sLm = ((com.tencent.xweb.x5.export.external.extension.proxy.a)new f.g(this));
      Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "<init> start hash[" + hashCode() + ']');
      paramw = MMWebView.a.nL((Context)paramo);
      kotlin.g.b.s.s(paramw, "create(context)");
      this.sMP = paramw;
      paramah = this.sMP;
      paramah.setBackgroundColor(0);
      localad = paramah.getSettings();
      localad.kfS();
      localad.setJavaScriptEnabled(true);
      localad.setMediaPlaybackRequiresUserGesture(false);
      localad.kfU();
      paramah.setHorizontalScrollBarEnabled(false);
      paramah.setVerticalScrollBarEnabled(false);
      localad.setBuiltInZoomControls(true);
      localad.setLoadWithOverviewMode(true);
      localad.kfN();
      localad.kfM();
      localad.setGeolocationEnabled(true);
      localad.setJavaScriptCanOpenWindowsAutomatically(true);
      localad.kfP();
      localad.kfR();
      localad.kfV();
      paramah.setWebViewCallbackClient(this.sLl);
      paramah.setWebViewClientExtension(this.sLm);
      localad.setUsingForAppBrand(2);
      str = localad.getUserAgentString();
      paramw = (r.a)com.tencent.luggage.a.e.T(r.a.class);
      if (paramw != null) {
        break label716;
      }
      paramw = (r.a)new com.tencent.mm.plugin.appbrand.luggage.b.e((Context)paramo);
    }
    label716:
    for (;;)
    {
      kotlin.g.b.s.s(str, "currentUa");
      if (!kotlin.n.n.i((CharSequence)str, (CharSequence)" MicroMessenger/")) {
        localad.setUserAgentString(r.a((Context)paramo, str, paramw) + " miniProgram/" + this.qxY.mAppId);
      }
      paramah.setDownloadListener(new f..ExternalSyntheticLambda0(this));
      this.sMR = paramah.setVideoJsCallback((x)new a(this));
      Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "<init> end WebView construct hash[" + hashCode() + ']');
      addView((View)this.sMP, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      paramw = new MMFalseProgressBar((Context)paramo);
      paramw.setProgressDrawable(com.tencent.mm.cd.a.m((Context)paramo, ba.e.mm_webview_progress_horizontal));
      paramah = kotlin.ah.aiuX;
      this.sMQ = paramw;
      addView((View)this.sMQ, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix((Context)paramo, 3)));
      this.sMH.a(new f..ExternalSyntheticLambda1(this));
      paramo = c.sLo;
      c.a((g.c)this);
      Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "<init> end hash[" + hashCode() + "], supportOrientationControl[" + getXwVideoOrientationControlSupported() + ']');
      this.sMT = new androidx.b.b();
      this.sMU = this.qxY.ccN().getReporter().cBn();
      this.sMV = k.cm((kotlin.g.a.a)new c(this));
      this.sMW = new d();
      this.sMX = new f..ExternalSyntheticLambda3(this);
      AppMethodBeat.o(327598);
      return;
      i = 49;
      break;
    }
  }
  
  public static final f a(Context paramContext, com.tencent.mm.plugin.appbrand.w paramw, com.tencent.mm.plugin.appbrand.page.ah paramah)
  {
    AppMethodBeat.i(327655);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramw, "rt");
    kotlin.g.b.s.u(paramah, "pv");
    paramContext = o.fj(paramContext);
    kotlin.g.b.s.s(paramContext, "forAppBrandUI(context)");
    paramContext = new f(paramContext, paramw, paramah, (byte)0);
    AppMethodBeat.o(327655);
    return paramContext;
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(327642);
    kotlin.g.b.s.u(paramf, "this$0");
    if (!paramf.aUP)
    {
      Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "destroy hash[%d]", new Object[] { Integer.valueOf(paramf.hashCode()) });
      paramf.getWebViewController().cleanup();
      paramf.sMP.stopLoading();
      paramf.getWebViewController().isC();
      paramf.bm(MMApplicationContext.getContext());
      if (!paramf.sMP.mDestroyed) {
        paramf.sMP.destroy();
      }
      paramf.sMT.clear();
      c localc = c.sLo;
      c.b((g.c)paramf);
      paramf.aUP = true;
    }
    AppMethodBeat.o(327642);
  }
  
  private static final void a(f paramf, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    AppMethodBeat.i(327638);
    kotlin.g.b.s.u(paramf, "this$0");
    Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "onDownloadStart page[%s], downloadUrl[%s], userAgent[%s], contentDisposition[%s], mime[%s], contentLength[%d], allowDownloadByExpt[%b]", new Object[] { paramf.sMH.cgR(), paramString1, paramString2, paramString3, paramString4, Long.valueOf(paramLong), Boolean.FALSE });
    paramf.getREPORTER().zJ(0);
    AppMethodBeat.o(327638);
  }
  
  private static final void b(f paramf)
  {
    AppMethodBeat.i(327647);
    kotlin.g.b.s.u(paramf, "this$0");
    paramf.sMQ.start();
    AppMethodBeat.o(327647);
  }
  
  private static final void c(f paramf)
  {
    AppMethodBeat.i(327650);
    kotlin.g.b.s.u(paramf, "this$0");
    paramf.sMQ.finish();
    AppMethodBeat.o(327650);
  }
  
  private final void cxH()
  {
    AppMethodBeat.i(327629);
    this.sMP.evaluateJavascript("window.__wxjs_environment = \"miniprogram\";", null);
    AppMethodBeat.o(327629);
  }
  
  private final void cxZ()
  {
    AppMethodBeat.i(327625);
    if (AndroidContextUtil.castActivityOrNull(getContext()) == null)
    {
      AppMethodBeat.o(327625);
      return;
    }
    com.tencent.mm.plugin.appbrand.widget.input.u localu = com.tencent.mm.plugin.appbrand.widget.input.n.ef((View)this);
    if (localu != null) {
      localu.a((u.c)this.sMN);
    }
    kotlin.ah localah = kotlin.ah.aiuX;
    this.sMM = localu;
    AppMethodBeat.o(327625);
  }
  
  private static final void d(f paramf)
  {
    AppMethodBeat.i(327653);
    kotlin.g.b.s.u(paramf, "this$0");
    new com.tencent.mm.plugin.appbrand.game.e.b.b().a((com.tencent.mm.plugin.appbrand.y)paramf.qxY.ccO(), b.a.rrD, paramf.getHtmlId());
    AppMethodBeat.o(327653);
  }
  
  private final com.tencent.mm.plugin.appbrand.page.a.f getMPullDown()
  {
    AppMethodBeat.i(327609);
    com.tencent.mm.plugin.appbrand.page.a.f localf = (com.tencent.mm.plugin.appbrand.page.a.f)this.sMH.aa(com.tencent.mm.plugin.appbrand.page.a.f.class);
    AppMethodBeat.o(327609);
    return localf;
  }
  
  private final g.b getREPORTER()
  {
    AppMethodBeat.i(327632);
    g.b localb = (g.b)this.sMV.getValue();
    AppMethodBeat.o(327632);
    return localb;
  }
  
  private final d<f> getWebViewController()
  {
    AppMethodBeat.i(327620);
    d locald = (d)this.sMS.getValue();
    AppMethodBeat.o(327620);
    return locald;
  }
  
  private final boolean getXwVideoOrientationControlSupported()
  {
    AppMethodBeat.i(327615);
    com.tencent.xweb.w localw = this.sMR;
    if ((localw != null) && (localw.kfw() == true))
    {
      AppMethodBeat.o(327615);
      return true;
    }
    AppMethodBeat.o(327615);
    return false;
  }
  
  private final void setCurrentUrl(String paramString)
  {
    AppMethodBeat.i(327602);
    this.sML = paramString;
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {}
    }
    for (;;)
    {
      try
      {
        paramString = Uri.parse(paramString).getHost();
        localObject = (CharSequence)paramString;
        if (localObject == null) {
          break label166;
        }
        if (((CharSequence)localObject).length() != 0) {
          break label176;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(327602);
        return;
      }
      if (i != 0)
      {
        paramString = getMPullDown();
        if (paramString != null)
        {
          paramString.setPullDownText("");
          AppMethodBeat.o(327602);
        }
      }
      else
      {
        localObject = getMPullDown();
        if (localObject != null)
        {
          ((com.tencent.mm.plugin.appbrand.page.a.f)localObject).setPullDownText(getContext().getString(ba.i.webview_logo_url, new Object[] { paramString }));
          AppMethodBeat.o(327602);
          return;
          paramString = getMPullDown();
          if (paramString != null) {
            paramString.setPullDownText("");
          }
        }
      }
      AppMethodBeat.o(327602);
      return;
      label166:
      i = 1;
      continue;
      i = 0;
      break;
      label176:
      i = 0;
    }
  }
  
  public final void C(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(327733);
    new g.f().h((com.tencent.mm.plugin.appbrand.jsapi.f)this.sMH).w("htmlId", Integer.valueOf(this.sMK)).w("errorCode", Integer.valueOf(paramInt)).w("description", paramString2).w("src", paramString1).cpV();
    AppMethodBeat.o(327733);
  }
  
  public final void a(g.c.a parama)
  {
    AppMethodBeat.i(327676);
    if (parama == null)
    {
      AppMethodBeat.o(327676);
      return;
    }
    if (this.aUP)
    {
      AppMethodBeat.o(327676);
      return;
    }
    this.sMT.add(parama);
    AppMethodBeat.o(327676);
  }
  
  public final void a(String paramString, WebResourceRequest paramWebResourceRequest)
  {
    AppMethodBeat.i(327741);
    this.sMU.a(this.sMH, paramString, paramWebResourceRequest);
    AppMethodBeat.o(327741);
  }
  
  public final void acw(String paramString)
  {
    AppMethodBeat.i(327716);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; (i != 0) || (URLUtil.isValidUrl(paramString)); i = 0)
    {
      AppMethodBeat.o(327716);
      return;
    }
    this.sMH.Zy(paramString);
    AppMethodBeat.o(327716);
  }
  
  public final void acx(String paramString)
  {
    AppMethodBeat.i(327731);
    Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "onPageCommitVisible url[%s] hash[%d] destroyed[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.aUP) });
    if (this.aUP)
    {
      AppMethodBeat.o(327731);
      return;
    }
    setCurrentUrl(paramString);
    cxH();
    AppMethodBeat.o(327731);
  }
  
  public final void apO()
  {
    AppMethodBeat.i(327684);
    this.sMP.getView().scrollTo(this.sMP.getScrollX(), 0);
    AppMethodBeat.o(327684);
  }
  
  public final boolean aqJ()
  {
    AppMethodBeat.i(327679);
    boolean bool = this.qxY.aqJ();
    AppMethodBeat.o(327679);
    return bool;
  }
  
  public final void av(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327682);
    com.tencent.mm.plugin.appbrand.jsapi.s locals = new com.tencent.mm.plugin.appbrand.jsapi.webview.d().a((com.tencent.mm.plugin.appbrand.jsapi.f)this.sMH.ccO(), this.sMH.getComponentId());
    String str = paramJSONObject.toString();
    paramJSONObject = str;
    if (str == null) {
      paramJSONObject = "";
    }
    locals.ZQ(paramJSONObject).cpV();
    AppMethodBeat.o(327682);
  }
  
  public final void bm(Context paramContext)
  {
    AppMethodBeat.i(327683);
    if (paramContext == null)
    {
      AppMethodBeat.o(327683);
      return;
    }
    Context localContext = getContext();
    if (localContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.ui.AppBrandRuntimePersistentContextWrapper");
      AppMethodBeat.o(327683);
      throw paramContext;
    }
    ((o)localContext).setBaseContext(paramContext);
    try
    {
      this.sMP.bm(paramContext);
      label61:
      getController().bm(paramContext);
      if (AndroidContextUtil.castActivityOrNull(getContext()) != null)
      {
        cxZ();
        AppMethodBeat.o(327683);
        return;
      }
      this.sMM = null;
      AppMethodBeat.o(327683);
      return;
    }
    catch (Exception localException)
    {
      break label61;
    }
  }
  
  public final void cxC()
  {
    AppMethodBeat.i(327696);
    Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "restoreRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.sMP.onShow();
    AppMethodBeat.o(327696);
  }
  
  public final void cxD()
  {
    AppMethodBeat.i(327698);
    Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "pauseRendering hash[%d]", new Object[] { Integer.valueOf(hashCode()) });
    this.sMP.onHide();
    AppMethodBeat.o(327698);
  }
  
  public final boolean cxE()
  {
    AppMethodBeat.i(327681);
    if (!getXwVideoOrientationControlSupported())
    {
      AppMethodBeat.o(327681);
      return true;
    }
    AppMethodBeat.o(327681);
    return false;
  }
  
  public final boolean cxF()
  {
    AppMethodBeat.i(327711);
    if (this.aUP)
    {
      AppMethodBeat.o(327711);
      return false;
    }
    if (this.sMP.canGoBack())
    {
      getExitReporter().a(this.sMH, true);
      this.sMP.goBack();
      this.sMW.sMZ = true;
      AppMethodBeat.o(327711);
      return true;
    }
    getExitReporter().a(this.sMH, false);
    AppMethodBeat.o(327711);
    return false;
  }
  
  public final void cxG()
  {
    AppMethodBeat.i(327735);
    this.qxY.ccN().aeD("scene_other");
    AppMethodBeat.o(327735);
  }
  
  public final boolean cxI()
  {
    AppMethodBeat.i(327745);
    try
    {
      if (this.qxY.ccM().eoX) {}
      for (bool = this.qxY.ccM().epB;; bool = this.qxY.ccM().epz)
      {
        AppMethodBeat.o(327745);
        return bool;
      }
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
  
  public final void cya()
  {
    AppMethodBeat.i(327720);
    runOnUiThread(new f..ExternalSyntheticLambda5(this));
    AppMethodBeat.o(327720);
  }
  
  public final void cyb()
  {
    AppMethodBeat.i(327722);
    runOnUiThread(new f..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(327722);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(327677);
    removeCallbacks(this.sMX);
    f..ExternalSyntheticLambda2 localExternalSyntheticLambda2 = new f..ExternalSyntheticLambda2(this);
    if (MMHandlerThread.isMainThread())
    {
      localExternalSyntheticLambda2.run();
      AppMethodBeat.o(327677);
      return;
    }
    MMHandlerThread.postToMainThread(localExternalSyntheticLambda2);
    AppMethodBeat.o(327677);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(327685);
    kotlin.g.b.s.u(paramMotionEvent, "ev");
    if (this.aUP)
    {
      AppMethodBeat.o(327685);
      return false;
    }
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if (!bool)
      {
        paramMotionEvent = getMPullDown();
        if (paramMotionEvent != null) {
          paramMotionEvent.requestDisallowInterceptTouchEvent(false);
        }
      }
      AppMethodBeat.o(327685);
      return bool;
      com.tencent.mm.plugin.appbrand.page.a.f localf = getMPullDown();
      if (localf != null)
      {
        localf.requestDisallowInterceptTouchEvent(true);
        continue;
        localf = getMPullDown();
        if (localf != null) {
          localf.requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  public final void eG(String paramString)
  {
    AppMethodBeat.i(327726);
    Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "onPageStarted url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.aUP), Boolean.valueOf(z.ay((View)this)) });
    if (this.aUP)
    {
      AppMethodBeat.o(327726);
      return;
    }
    cxH();
    new g.e().h((com.tencent.mm.plugin.appbrand.jsapi.f)this.sMH).w("src", paramString).w("htmlId", Integer.valueOf(this.sMK)).cpV();
    AppMethodBeat.o(327726);
  }
  
  public final void eH(String paramString)
  {
    AppMethodBeat.i(327729);
    Log.i("MicroMsg.AppBrand.HTMLWebViewWithBWC", "onPageFinished url[%s] hash[%d] destroyed[%b] attached[%b]", new Object[] { paramString, Integer.valueOf(hashCode()), Boolean.valueOf(this.aUP), Boolean.valueOf(z.ay((View)this)) });
    if (this.aUP)
    {
      AppMethodBeat.o(327729);
      return;
    }
    setCurrentUrl(paramString);
    cxH();
    d locald = this.sMW;
    if ((!locald.sNa) && (!locald.sMZ)) {
      getExitReporter().a(this.sMH, locald.sML, paramString);
    }
    locald.sNa = false;
    locald.sMZ = false;
    locald.sML = paramString;
    new g.d().h((com.tencent.mm.plugin.appbrand.jsapi.f)this.sMH).w("src", paramString).w("htmlId", Integer.valueOf(this.sMK)).cpV();
    postDelayed(this.sMX, 1000L);
    AppMethodBeat.o(327729);
  }
  
  public final Context getAndroidContext()
  {
    AppMethodBeat.i(327699);
    Context localContext = getContext();
    kotlin.g.b.s.s(localContext, "this.context");
    AppMethodBeat.o(327699);
    return localContext;
  }
  
  public final View getAndroidView()
  {
    return (View)this;
  }
  
  public final String getAppId()
  {
    AppMethodBeat.i(327678);
    String str = this.qxY.mAppId;
    kotlin.g.b.s.checkNotNull(str);
    AppMethodBeat.o(327678);
    return str;
  }
  
  public final int getBinderID()
  {
    AppMethodBeat.i(327675);
    int i = getController().getBinderID();
    AppMethodBeat.o(327675);
    return i;
  }
  
  public final d<f> getController()
  {
    AppMethodBeat.i(327674);
    d locald = getWebViewController();
    AppMethodBeat.o(327674);
    return locald;
  }
  
  public final String getCurrentUrl()
  {
    return this.sML;
  }
  
  public final com.tencent.mm.plugin.appbrand.report.model.s getExitReporter()
  {
    AppMethodBeat.i(327748);
    com.tencent.mm.plugin.appbrand.report.model.s locals = this.qxY.ccN().getReporter().cBm();
    kotlin.g.b.s.s(locals, "rt.pageContainer.reporte…tmlWebViewUrlExitReporter");
    AppMethodBeat.o(327748);
    return locals;
  }
  
  public final int getHtmlId()
  {
    return this.sMK;
  }
  
  public final String[] getJsApiReportArgs()
  {
    AppMethodBeat.i(327737);
    if (this.aUP)
    {
      arrayOfString = (String[])new String[0];
      AppMethodBeat.o(327737);
      return arrayOfString;
    }
    String[] arrayOfString = com.tencent.mm.plugin.appbrand.jsapi.webview.b.c(this.sMH);
    kotlin.g.b.s.s(arrayOfString, "getJsApiReportArgs(pv)");
    AppMethodBeat.o(327737);
    return arrayOfString;
  }
  
  public final com.tencent.mm.plugin.appbrand.page.ah getPageView()
  {
    return this.sMH;
  }
  
  public final g.b getReporter()
  {
    AppMethodBeat.i(327746);
    g.b localb = getREPORTER();
    AppMethodBeat.o(327746);
    return localb;
  }
  
  public final MMWebView getWebView()
  {
    return this.sMP;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(327693);
    super.onAttachedToWindow();
    cxZ();
    this.sMH.a((i.d)this.sMO);
    this.sMH.a((i.b)this.sMO);
    if (this.sMH.eny) {
      this.sMO.onForeground();
    }
    AppMethodBeat.o(327693);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(327694);
    super.onDetachedFromWindow();
    if (!this.sMH.isRunning())
    {
      this.sMO.onBackground();
      destroy();
    }
    com.tencent.mm.plugin.appbrand.widget.input.u localu = this.sMM;
    if (localu != null) {
      localu.b((u.c)this.sMN);
    }
    this.sMH.b((i.d)this.sMO);
    this.sMH.b((i.b)this.sMO);
    AppMethodBeat.o(327694);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(327688);
    int i = paramInt2;
    Object localObject;
    if ((getParent() instanceof ViewGroup))
    {
      localObject = getParent();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(327688);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup)localObject;
      switch (View.MeasureSpec.getMode(paramInt2))
      {
      default: 
        i = paramInt2;
      }
    }
    for (;;)
    {
      super.onMeasure(paramInt1, i);
      AppMethodBeat.o(327688);
      return;
      i = View.MeasureSpec.makeMeasureSpec(((ViewGroup)localObject).getMeasuredHeight(), -2147483648);
      continue;
      i = View.MeasureSpec.makeMeasureSpec(Math.max(0, Math.min(((ViewGroup)localObject).getMeasuredHeight(), View.MeasureSpec.getSize(paramInt2))), -2147483648);
      continue;
      i = paramInt2;
      if (View.MeasureSpec.getSize(paramInt2) > ((ViewGroup)localObject).getMeasuredHeight()) {
        i = View.MeasureSpec.makeMeasureSpec(((ViewGroup)localObject).getMeasuredHeight(), 1073741824);
      }
    }
  }
  
  public final void runOnUiThread(Runnable paramRunnable)
  {
    AppMethodBeat.i(327680);
    this.sMH.post(paramRunnable);
    AppMethodBeat.o(327680);
  }
  
  public final void setAndroidViewId(int paramInt)
  {
    AppMethodBeat.i(327704);
    getAndroidView().setId(paramInt);
    AppMethodBeat.o(327704);
  }
  
  public final void setCoverViewId(int paramInt)
  {
    this.sMK = paramInt;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$1$3", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandXWVideoJsCallbackIMPL;", "onSetRequestedOrientation", "", "orientationInt", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.plugin.appbrand.jsapi.webview.f
  {
    a(f paramf) {}
    
    public final boolean Bu(int paramInt)
    {
      AppMethodBeat.i(327483);
      com.tencent.mm.plugin.appbrand.platform.window.d locald = f.i(this.sMY).getFullscreenImpl();
      if (locald == null)
      {
        Log.w("MicroMsg.AppBrand.HTMLWebViewWithBWC", "onSetRequestedOrientation hash[%d] NULL fullscreenImpl", new Object[] { Integer.valueOf(this.sMY.hashCode()) });
        AppMethodBeat.o(327483);
        return false;
      }
      locald.zb(d.a.CT(paramInt));
      AppMethodBeat.o(327483);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$REPORTER$2$1"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<1>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLWebViewWithBWC$exitReportContextObj$1", "", "currentUrl", "", "getCurrentUrl", "()Ljava/lang/String;", "setCurrentUrl", "(Ljava/lang/String;)V", "isFirstLoad", "", "()Z", "setFirstLoad", "(Z)V", "isOnNavBack", "setOnNavBack", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    String sML;
    boolean sMZ;
    boolean sNa = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.f
 * JD-Core Version:    0.7.0.1
 */