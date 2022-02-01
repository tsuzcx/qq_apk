package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.aa;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.c;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewHelper;", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper;", "Lcom/tencent/mm/plugin/finder/webview/IWebViewLongClickProvider;", "context", "Landroid/content/Context;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "uxInfo", "", "window", "Landroid/view/Window;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;Ljava/lang/String;Landroid/view/Window;)V", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "codeMaskView", "Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "getCodeMaskView", "()Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "setCodeMaskView", "(Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;)V", "isReleased", "", "longClickHelper", "Lcom/tencent/mm/plugin/finder/webview/WebViewLongClickHelper;", "mCurrentURL", "mWebViewStatusListeners", "", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper$IWebViewStateListener;", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "webViewClientListener", "com/tencent/mm/plugin/finder/webview/FinderWebViewHelper$webViewClientListener$1", "Lcom/tencent/mm/plugin/finder/webview/FinderWebViewHelper$webViewClientListener$1;", "webViewController", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "webViewControllerListener", "Lcom/tencent/mm/plugin/finder/webview/FinderWebViewController;", "addJsApiPool", "", "addWebViewStateListener", "listener", "clearWebViewStateListener", "getContext", "getController", "getCurrentURL", "getInvoke", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getMaskView", "getPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getTouchX", "", "getTouchY", "getWVTopOffset", "", "getWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "getWindow", "getWithInitWebView", "initWebView", "initWebViewController", "isRelease", "onCreateBoxWebViewEnd", "enablePreloadWebView", "enablePreloadFromFindTab", "useCache", "onCreateBoxWebViewStart", "onError", "onExecuteActionCode", "actionCode", "data", "Landroid/os/Bundle;", "onInitWebViewEnd", "onInitWebViewStart", "onWebViewReady", "release", "reload", "removeWebViewStateListener", "startLoadUrl", "Companion", "plugin-finder_release"})
public final class j
  implements k, l
{
  public static final a BrF;
  private h BrA;
  private final List<k.a> BrB;
  private BaseWebViewController BrC;
  private WebViewLongClickHelper BrD;
  private e BrE;
  private Window Bry;
  MultiCodeMaskView Brz;
  private Context context;
  private boolean isReleased;
  private String pFV;
  private c pHc;
  private qm sog;
  private BoxWebView soj;
  private String uxInfo;
  
  static
  {
    AppMethodBeat.i(221118);
    BrF = new a((byte)0);
    AppMethodBeat.o(221118);
  }
  
  public j(Context paramContext, qm paramqm, String paramString, Window paramWindow)
  {
    AppMethodBeat.i(221117);
    this.pFV = "";
    this.BrB = ((List)new ArrayList());
    this.BrE = new e(this);
    this.context = paramContext;
    this.sog = paramqm;
    this.Bry = paramWindow;
    this.uxInfo = paramString;
    AppMethodBeat.o(221117);
  }
  
  private final void elP()
  {
    AppMethodBeat.i(221098);
    Iterator localIterator = this.BrB.iterator();
    while (localIterator.hasNext()) {
      ((k.a)localIterator.next()).elP();
    }
    AppMethodBeat.o(221098);
  }
  
  private final void elS()
  {
    AppMethodBeat.i(221100);
    com.tencent.e.h.ZvG.bc((Runnable)new d(this));
    AppMethodBeat.o(221100);
  }
  
  public final void a(k.a parama)
  {
    AppMethodBeat.i(221090);
    if (!this.BrB.contains(parama)) {
      this.BrB.add(parama);
    }
    AppMethodBeat.o(221090);
  }
  
  public final MMWebView elR()
  {
    AppMethodBeat.i(221086);
    Object localObject1 = this.BrB.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((k.a)((Iterator)localObject1).next()).elM();
    }
    localObject1 = this.context;
    if (localObject1 == null) {
      p.iCn();
    }
    this.soj = f.a((Context)localObject1, (kotlin.g.a.q)new b(this));
    localObject1 = new h();
    Object localObject2 = this.context;
    if (localObject2 != null) {
      ((h)localObject1).aFX = new WeakReference(localObject2);
    }
    this.BrA = ((h)localObject1);
    localObject1 = (aa)com.tencent.mm.kernel.h.ae(aa.class);
    localObject2 = this.soj;
    if (localObject2 == null) {
      p.iCn();
    }
    this.BrC = ((aa)localObject1).a((MMWebView)localObject2, new BaseWebViewController.d(null, true, true, false, false, 41), null);
    localObject1 = this.BrC;
    if (localObject1 != null)
    {
      localObject2 = this.BrA;
      if (localObject2 != null)
      {
        BaseWebViewController localBaseWebViewController = this.BrC;
        if (localBaseWebViewController != null) {
          localBaseWebViewController.a((com.tencent.mm.plugin.webview.core.j)localObject2);
        }
        ((h)localObject2).Brt = new WeakReference(localObject1);
      }
      ((BaseWebViewController)localObject1).a((com.tencent.mm.plugin.webview.core.f)this.BrE);
      ((BaseWebViewController)localObject1).init();
    }
    elP();
    Log.i("Finder.AdWebViewImpl", "initWebView");
    com.tencent.e.h.ZvG.bg((Runnable)new c(this));
    this.BrD = new WebViewLongClickHelper((l)this);
    WebViewLongClickHelper.d((MMWebView)this.soj);
    localObject1 = this.BrD;
    if (localObject1 != null) {
      ((WebViewLongClickHelper)localObject1).emd();
    }
    localObject1 = this.soj;
    if (localObject1 == null) {
      p.iCn();
    }
    localObject1 = (MMWebView)localObject1;
    AppMethodBeat.o(221086);
    return localObject1;
  }
  
  public final e elT()
  {
    AppMethodBeat.i(221103);
    Object localObject = this.BrC;
    if (localObject != null)
    {
      localObject = ((BaseWebViewController)localObject).gSm();
      AppMethodBeat.o(221103);
      return localObject;
    }
    AppMethodBeat.o(221103);
    return null;
  }
  
  public final g elU()
  {
    BaseWebViewController localBaseWebViewController = this.BrC;
    if (localBaseWebViewController != null) {
      return localBaseWebViewController.pGD;
    }
    return null;
  }
  
  public final boolean elX()
  {
    return this.isReleased;
  }
  
  public final String elY()
  {
    AppMethodBeat.i(221109);
    Object localObject = this.BrC;
    if ((localObject != null) && (!Util.isNullOrNil(((BaseWebViewController)localObject).getCurrentUrl())))
    {
      str = ((BaseWebViewController)localObject).getCurrentUrl();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      AppMethodBeat.o(221109);
      return localObject;
    }
    String str = this.sog.Url;
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    AppMethodBeat.o(221109);
    return localObject;
  }
  
  public final int elZ()
  {
    AppMethodBeat.i(221112);
    int j = 0;
    int i = j;
    if (this.soj != null)
    {
      i = j;
      if (this.Bry != null)
      {
        Object localObject = this.Bry;
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((Window)localObject).getDecorView();
        p.j(localObject, "window!!.decorView");
        i = ((View)localObject).getMeasuredHeight();
        localObject = this.soj;
        if (localObject == null) {
          p.iCn();
        }
        i -= ((BoxWebView)localObject).getMeasuredHeight();
        ax.aB(this.context);
      }
    }
    Log.d("Finder.AdWebViewImpl", "getWVTopOffest :".concat(String.valueOf(i)));
    AppMethodBeat.o(221112);
    return i;
  }
  
  public final MultiCodeMaskView ema()
  {
    return this.Brz;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final BaseWebViewController getController()
  {
    return this.BrC;
  }
  
  public final MMWebView getWebView()
  {
    return (MMWebView)this.soj;
  }
  
  public final Window getWindow()
  {
    return this.Bry;
  }
  
  public final void release()
  {
    AppMethodBeat.i(221096);
    Log.i("Finder.AdWebViewImpl", "release destroy");
    this.isReleased = true;
    this.BrB.clear();
    Object localObject1 = this.BrC;
    if (localObject1 != null) {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((BaseWebViewController)localObject1).gSo()).a(null, null, null);
    }
    localObject1 = this.soj;
    if (localObject1 != null) {
      ((BoxWebView)localObject1).destroy();
    }
    this.soj = null;
    localObject1 = this.BrC;
    if (localObject1 != null) {
      ((BaseWebViewController)localObject1).onDestroy();
    }
    localObject1 = this.BrA;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.BrC;
      if (localObject2 != null) {
        ((BaseWebViewController)localObject2).b((com.tencent.mm.plugin.webview.core.j)localObject1);
      }
      ((h)localObject1).aFX = null;
    }
    localObject1 = this.BrC;
    if (localObject1 != null) {
      ((BaseWebViewController)localObject1).b((com.tencent.mm.plugin.webview.core.f)this.BrE);
    }
    this.BrA = null;
    localObject1 = this.Brz;
    if ((localObject1 != null) && (((MultiCodeMaskView)localObject1).getVisibility() == 0))
    {
      long l = 0L;
      if (this.BrD != null)
      {
        localObject2 = this.BrD;
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = ((WebViewLongClickHelper)localObject2).BrO;
        p.j(localObject2, "longClickHelper!!.mCodeSessionId");
        l = ((Long)localObject2).longValue();
      }
      ((MultiCodeMaskView)localObject1).F(l, false);
    }
    this.BrD = null;
    this.BrC = null;
    this.context = null;
    AppMethodBeat.o(221096);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(221088);
    elS();
    AppMethodBeat.o(221088);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.q<Boolean, Boolean, Boolean, x>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(289323);
      try
      {
        BoxWebView localBoxWebView = j.b(this.BrG);
        if (localBoxWebView != null) {
          localBoxWebView.a(null, null);
        }
        j.c(this.BrG);
        j.d(this.BrG);
        AppMethodBeat.o(289323);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.printErrStackTrace("Finder.AdWebViewImpl", localThrowable, "initWebView exception", new Object[0]);
        com.tencent.e.h.ZvG.bc((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(290764);
            BoxWebView localBoxWebView = j.b(this.BrH.BrG);
            if (localBoxWebView != null) {
              localBoxWebView.a(null, null);
            }
            j.c(this.BrH.BrG);
            j.d(this.BrH.BrG);
            AppMethodBeat.o(290764);
          }
        });
        AppMethodBeat.o(289323);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(j paramj) {}
    
    public final void run()
    {
      AppMethodBeat.i(259403);
      String str = com.tencent.mm.compatible.util.q.an(j.e(this.BrG), "UTF-8");
      str = j.f(this.BrG).Url + "&uxinfo=" + str;
      Log.i("Finder.AdWebViewImpl", "startLoadUrl %s", new Object[] { str });
      j.a(this.BrG, str);
      BaseWebViewController localBaseWebViewController = j.h(this.BrG);
      if (localBaseWebViewController != null)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("rawUrl", str);
        localIntent.putExtra("useJs", true);
        localBaseWebViewController.bj(localIntent);
        AppMethodBeat.o(259403);
        return;
      }
      AppMethodBeat.o(259403);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/webview/FinderWebViewHelper$webViewClientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageFinished", "onPageStarted", "onReceivedError", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "webResourceRequest", "Lcom/tencent/xweb/WebResourceRequest;", "webResourceResponse", "Lcom/tencent/xweb/WebResourceResponse;", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "webViewReady", "plugin-finder_release"})
  public static final class e
    extends com.tencent.mm.plugin.webview.core.f
  {
    private final void emb()
    {
      AppMethodBeat.i(280229);
      Log.i("Finder.AdWebViewImpl", "webViewReady");
      j.i(this.BrG);
      AppMethodBeat.o(280229);
    }
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(280231);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      Log.i("Finder.AdWebViewImpl", "onReceivedError errorCode :" + paramInt + " description:" + paramString1 + " failingUrl:" + paramString2);
      j.j(this.BrG);
      AppMethodBeat.o(280231);
    }
    
    public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      AppMethodBeat.i(280232);
      super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      Log.i("Finder.AdWebViewImpl", "onReceivedHttpError");
      j.j(this.BrG);
      AppMethodBeat.o(280232);
    }
    
    public final void a(WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(280233);
      super.a(paramWebView, paramr, paramSslError);
      Log.i("Finder.AdWebViewImpl", "onReceivedSslError");
      String str = j.g(this.BrG);
      if (Util.isNullOrNil(str))
      {
        Log.d("Finder.AdWebViewImpl", "urlStr == null, return");
        AppMethodBeat.o(280233);
        return;
      }
      if ((j.k(this.BrG) == null) && (paramWebView != null)) {
        j.a(this.BrG, new c(paramWebView.getContext(), paramWebView));
      }
      paramWebView = j.k(this.BrG);
      if (paramWebView != null) {
        paramWebView.a(str, paramr, paramSslError);
      }
      if (!WeChatEnvironment.isCoolassistEnv()) {
        j.j(this.BrG);
      }
      AppMethodBeat.o(280233);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(280230);
      super.b(paramWebView, paramString);
      Log.i("Finder.AdWebViewImpl", "onPageFinished :".concat(String.valueOf(paramString)));
      AppMethodBeat.o(280230);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(280226);
      super.e(paramWebView, paramString);
      Log.i("Finder.AdWebViewImpl", "onPageCommitVisible :".concat(String.valueOf(paramString)));
      emb();
      AppMethodBeat.o(280226);
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(280228);
      super.h(paramWebView, paramString);
      Log.i("Finder.AdWebViewImpl", "onPageStarted :".concat(String.valueOf(paramString)));
      emb();
      AppMethodBeat.o(280228);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.j
 * JD-Core Version:    0.7.0.1
 */