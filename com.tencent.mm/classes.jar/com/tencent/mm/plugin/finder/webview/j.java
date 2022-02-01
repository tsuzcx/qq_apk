package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab;
import com.tencent.mm.plugin.box.webview.BoxWebView;
import com.tencent.mm.plugin.finder.webview.ad.ScrollFrameLayout;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.stub.b;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import com.tencent.xweb.t;
import com.tencent.xweb.x5.export.external.extension.proxy.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewHelper;", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper;", "Lcom/tencent/mm/plugin/finder/webview/IWebViewLongClickProvider;", "context", "Landroid/content/Context;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "window", "Landroid/view/Window;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;Landroid/view/Window;)V", "boxWebView", "Lcom/tencent/mm/plugin/box/webview/BoxWebView;", "codeMaskView", "Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "getCodeMaskView", "()Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "setCodeMaskView", "(Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;)V", "dialogWindow", "getDialogWindow", "()Landroid/view/Window;", "setDialogWindow", "(Landroid/view/Window;)V", "errorRunnable", "Ljava/lang/Runnable;", "isReleased", "", "longClickHelper", "Lcom/tencent/mm/plugin/finder/webview/WebViewLongClickHelper;", "mCurrentURL", "", "mWebViewStatusListeners", "", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper$IWebViewStateListener;", "posProvider", "Lcom/tencent/mm/plugin/finder/webview/IDetectPosProvider;", "getPosProvider", "()Lcom/tencent/mm/plugin/finder/webview/IDetectPosProvider;", "setPosProvider", "(Lcom/tencent/mm/plugin/finder/webview/IDetectPosProvider;)V", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "webViewClientListener", "com/tencent/mm/plugin/finder/webview/FinderWebViewHelper$webViewClientListener$1", "Lcom/tencent/mm/plugin/finder/webview/FinderWebViewHelper$webViewClientListener$1;", "webViewController", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "webViewControllerListener", "Lcom/tencent/mm/plugin/finder/webview/FinderWebViewController;", "addWebViewStateListener", "", "listener", "clearWebViewStateListener", "getContext", "getController", "getCurrentURL", "getInvoke", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getMaskView", "getPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getTouchX", "", "()Ljava/lang/Float;", "getTouchY", "getWVTopOffset", "", "getWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "getWindow", "getWithInitWebView", "initWebView", "initWebViewController", "isRelease", "onCreateBoxWebViewEnd", "enablePreloadWebView", "enablePreloadFromFindTab", "useCache", "onCreateBoxWebViewStart", "onError", "onExecuteActionCode", "actionCode", "data", "Landroid/os/Bundle;", "onInitWebViewEnd", "onInitWebViewStart", "onWebViewReady", "release", "reload", "reloadUrl", "url", "removeWebViewStateListener", "startLoadUrl", "isReload", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements l, m
{
  public static final a GXT;
  public Window GXU;
  public MultiCodeMaskView GXV;
  private k GXW;
  private g GXX;
  private final List<l.a> GXY;
  private BaseWebViewController GXZ;
  private WebViewLongClickHelper GYa;
  private d GYb;
  private final Runnable GYc;
  private Context context;
  private boolean isReleased;
  private String sLe;
  private d sMc;
  private rx vAe;
  private BoxWebView vAh;
  
  static
  {
    AppMethodBeat.i(334559);
    GXT = new a((byte)0);
    AppMethodBeat.o(334559);
  }
  
  private j(Context paramContext, rx paramrx)
  {
    AppMethodBeat.i(334454);
    this.sLe = "";
    this.GXY = ((List)new ArrayList());
    this.GYb = new d(this);
    this.GYc = new j..ExternalSyntheticLambda0(this);
    this.context = paramContext;
    this.vAe = paramrx;
    this.GXU = null;
    AppMethodBeat.o(334454);
  }
  
  private static final void a(j paramj)
  {
    AppMethodBeat.i(334490);
    s.u(paramj, "this$0");
    paramj.atR();
    AppMethodBeat.o(334490);
  }
  
  private static final void a(j paramj, String paramString)
  {
    AppMethodBeat.i(334515);
    s.u(paramj, "this$0");
    s.u(paramString, "$url");
    rx localrx = paramj.vAe;
    if (localrx != null) {
      localrx.Url = paramString;
    }
    paramj = paramj.GXZ;
    if (paramj != null) {
      paramj.loadUrl(paramString, null, false);
    }
    AppMethodBeat.o(334515);
  }
  
  private static final void a(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(334508);
    s.u(paramj, "this$0");
    Object localObject1 = paramj.vAe;
    if (localObject1 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      Log.i("Finder.AdWebViewImpl", s.X("startLoadUrl ", localObject1));
      paramj.sLe = ((String)localObject1);
      if (paramBoolean) {
        break;
      }
      paramj = paramj.GXZ;
      if (paramj == null) {
        break label134;
      }
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("rawUrl", (String)localObject1);
      ((Intent)localObject2).putExtra("useJs", true);
      ((Intent)localObject2).putExtra("startTime", System.currentTimeMillis());
      localObject1 = ah.aiuX;
      paramj.bJ((Intent)localObject2);
      AppMethodBeat.o(334508);
      return;
      localObject2 = ((rx)localObject1).Url;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    paramj = paramj.GXZ;
    if (paramj != null) {
      paramj.reload();
    }
    label134:
    AppMethodBeat.o(334508);
  }
  
  private final void atR()
  {
    AppMethodBeat.i(334475);
    Iterator localIterator = this.GXY.iterator();
    while (localIterator.hasNext()) {
      ((l.a)localIterator.next()).atR();
    }
    AppMethodBeat.o(334475);
  }
  
  private static final void b(j paramj)
  {
    AppMethodBeat.i(334496);
    s.u(paramj, "this$0");
    BoxWebView localBoxWebView = paramj.vAh;
    if (localBoxWebView != null) {
      localBoxWebView.a(null, null);
    }
    paramj.fpV();
    paramj = paramj.GXY.iterator();
    while (paramj.hasNext()) {
      ((l.a)paramj.next()).fpT();
    }
    AppMethodBeat.o(334496);
  }
  
  private final void fpS()
  {
    AppMethodBeat.i(334469);
    Iterator localIterator = this.GXY.iterator();
    while (localIterator.hasNext()) {
      ((l.a)localIterator.next()).fpS();
    }
    AppMethodBeat.o(334469);
  }
  
  private final void fpV()
  {
    AppMethodBeat.i(334484);
    com.tencent.threadpool.h.ahAA.bk(new j..ExternalSyntheticLambda3(this, false));
    AppMethodBeat.o(334484);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(334615);
    if (!this.GXY.contains(parama)) {
      this.GXY.add(parama);
    }
    AppMethodBeat.o(334615);
  }
  
  public final void aCT(String paramString)
  {
    AppMethodBeat.i(334631);
    s.u(paramString, "url");
    com.tencent.threadpool.h.ahAA.bk(new j..ExternalSyntheticLambda2(this, paramString));
    AppMethodBeat.o(334631);
  }
  
  public final boolean bpe()
  {
    return this.isReleased;
  }
  
  public final MMWebView fpU()
  {
    AppMethodBeat.i(334608);
    Object localObject1 = this.GXY.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((l.a)((Iterator)localObject1).next()).fpP();
    }
    localObject1 = this.context;
    s.checkNotNull(localObject1);
    this.vAh = f.a((Context)localObject1, (q)new b(this));
    localObject1 = new g();
    Object localObject2 = this.context;
    if (localObject2 != null) {
      ((g)localObject1).contextRef = new WeakReference(localObject2);
    }
    this.GXX = ((g)localObject1);
    localObject1 = (ab)com.tencent.mm.kernel.h.ax(ab.class);
    localObject2 = this.vAh;
    s.checkNotNull(localObject2);
    this.GXZ = ((ab)localObject1).a((MMWebView)localObject2, new BaseWebViewController.d(null, true, true, false, false, false, 105), null);
    localObject1 = this.GXZ;
    if (localObject1 != null)
    {
      localObject2 = this.GXX;
      if (localObject2 != null)
      {
        Object localObject3 = this.GXZ;
        if (localObject3 != null) {
          ((BaseWebViewController)localObject3).a((com.tencent.mm.plugin.webview.core.l)localObject2);
        }
        ((g)localObject2).GXD = new WeakReference(localObject1);
        localObject3 = ((g)localObject2).GXD;
        s.checkNotNull(localObject3);
        ((g)localObject2).GXF = ((b)new g.b((g)localObject2, (WeakReference)localObject3));
        ((g)localObject2).GXE = new WeakReference(this.GYc);
      }
      ((BaseWebViewController)localObject1).a((com.tencent.mm.plugin.webview.core.h)this.GYb);
      localObject2 = this.vAh;
      if (localObject2 != null) {
        ((BoxWebView)localObject2).setWebViewClientExtension((a)new c(this));
      }
      ((BaseWebViewController)localObject1).init();
    }
    fpS();
    Log.i("Finder.AdWebViewImpl", "initWebView");
    com.tencent.threadpool.h.ahAA.bk(new j..ExternalSyntheticLambda1(this));
    this.GYa = new WebViewLongClickHelper((m)this);
    WebViewLongClickHelper.d((MMWebView)this.vAh);
    localObject1 = this.GYa;
    if (localObject1 != null) {
      ((WebViewLongClickHelper)localObject1).fqh();
    }
    localObject1 = this.vAh;
    s.checkNotNull(localObject1);
    localObject1 = (MMWebView)localObject1;
    AppMethodBeat.o(334608);
    return localObject1;
  }
  
  public final e fpW()
  {
    AppMethodBeat.i(334636);
    Object localObject = this.GXZ;
    if (localObject == null)
    {
      AppMethodBeat.o(334636);
      return null;
    }
    localObject = ((BaseWebViewController)localObject).irJ();
    AppMethodBeat.o(334636);
    return localObject;
  }
  
  public final com.tencent.mm.plugin.webview.e.g fpX()
  {
    BaseWebViewController localBaseWebViewController = this.GXZ;
    if (localBaseWebViewController == null) {
      return null;
    }
    return localBaseWebViewController.sLD;
  }
  
  public final Float fpY()
  {
    AppMethodBeat.i(334647);
    Object localObject = this.GXW;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label53;
      }
      localObject = ScrollFrameLayout.GYN;
    }
    label53:
    for (float f = ScrollFrameLayout.fqs();; f = ((Float)localObject).floatValue())
    {
      AppMethodBeat.o(334647);
      return Float.valueOf(f);
      localObject = Float.valueOf(((k)localObject).fqe());
      break;
    }
  }
  
  public final Float fpZ()
  {
    AppMethodBeat.i(334654);
    Object localObject = this.GXW;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label53;
      }
      localObject = ScrollFrameLayout.GYN;
    }
    label53:
    for (float f = ScrollFrameLayout.fqt();; f = ((Float)localObject).floatValue())
    {
      AppMethodBeat.o(334654);
      return Float.valueOf(f);
      localObject = Float.valueOf(((k)localObject).fqf());
      break;
    }
  }
  
  public final String fqa()
  {
    AppMethodBeat.i(334687);
    Object localObject = this.GXZ;
    if ((localObject != null) && (!Util.isNullOrNil(((BaseWebViewController)localObject).getCurrentUrl())))
    {
      localObject = ((BaseWebViewController)localObject).getCurrentUrl();
      if (localObject == null)
      {
        AppMethodBeat.o(334687);
        return "";
      }
      AppMethodBeat.o(334687);
      return localObject;
    }
    localObject = this.vAe;
    if (localObject == null)
    {
      AppMethodBeat.o(334687);
      return "";
    }
    localObject = ((rx)localObject).Url;
    if (localObject == null)
    {
      AppMethodBeat.o(334687);
      return "";
    }
    AppMethodBeat.o(334687);
    return localObject;
  }
  
  public final int fqb()
  {
    AppMethodBeat.i(334698);
    int j = 0;
    int i = j;
    if (this.vAh != null)
    {
      i = j;
      if (this.GXU != null)
      {
        Object localObject = this.GXU;
        s.checkNotNull(localObject);
        i = ((Window)localObject).getDecorView().getMeasuredHeight();
        localObject = this.vAh;
        s.checkNotNull(localObject);
        i = i - ((BoxWebView)localObject).getMeasuredHeight() - bf.bk(this.context);
      }
    }
    Log.d("Finder.AdWebViewImpl", s.X("getWVTopOffset :", Integer.valueOf(i)));
    AppMethodBeat.o(334698);
    return i;
  }
  
  public final MultiCodeMaskView fqc()
  {
    return this.GXV;
  }
  
  public final Context getContext()
  {
    return this.context;
  }
  
  public final BaseWebViewController getController()
  {
    return this.GXZ;
  }
  
  public final MMWebView getWebView()
  {
    return (MMWebView)this.vAh;
  }
  
  public final Window getWindow()
  {
    return this.GXU;
  }
  
  public final void release()
  {
    AppMethodBeat.i(334623);
    Log.i("Finder.AdWebViewImpl", "release destroy");
    this.isReleased = true;
    this.GXY.clear();
    Object localObject1 = this.GXZ;
    if (localObject1 != null) {
      com.tencent.mm.plugin.webview.ui.tools.jsapi.k.auP(((BaseWebViewController)localObject1).irL()).a(null, null, null);
    }
    localObject1 = this.vAh;
    if (localObject1 != null) {
      ((BoxWebView)localObject1).destroy();
    }
    this.vAh = null;
    localObject1 = this.GXZ;
    if (localObject1 != null) {
      ((BaseWebViewController)localObject1).onDestroy();
    }
    localObject1 = this.GXX;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = this.GXZ;
      if (localObject2 != null) {
        ((BaseWebViewController)localObject2).b((com.tencent.mm.plugin.webview.core.l)localObject1);
      }
      ((g)localObject1).contextRef = null;
    }
    localObject1 = this.GXZ;
    if (localObject1 != null) {
      ((BaseWebViewController)localObject1).b((com.tencent.mm.plugin.webview.core.h)this.GYb);
    }
    this.GXX = null;
    localObject1 = this.GXV;
    if ((localObject1 != null) && (((MultiCodeMaskView)localObject1).getVisibility() == 0))
    {
      long l = 0L;
      if (this.GYa != null)
      {
        localObject2 = this.GYa;
        s.checkNotNull(localObject2);
        localObject2 = ((WebViewLongClickHelper)localObject2).GYk;
        s.s(localObject2, "longClickHelper!!.mCodeSessionId");
        l = ((Number)localObject2).longValue();
      }
      ((MultiCodeMaskView)localObject1).P(l, false);
    }
    this.GYa = null;
    this.GXZ = null;
    this.context = null;
    AppMethodBeat.o(334623);
  }
  
  public final void reload()
  {
    AppMethodBeat.i(334610);
    fpV();
    AppMethodBeat.o(334610);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements q<Boolean, Boolean, Boolean, ah>
  {
    b(j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/FinderWebViewHelper$initWebViewController$1$2", "Lcom/tencent/xweb/x5/export/external/extension/proxy/ProxyWebViewClientExtension;", "onMiscCallBack", "", "method", "", "bundle", "Landroid/os/Bundle;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends a
  {
    c(j paramj) {}
    
    public final Object onMiscCallBack(String paramString, Bundle paramBundle)
    {
      AppMethodBeat.i(334487);
      Log.i("Finder.AdWebViewImpl", "method bundle :" + paramString + "  bundle:" + paramBundle);
      int i;
      if (s.p(paramString, "shouldInterceptLoadError"))
      {
        if (paramBundle != null) {
          break label117;
        }
        i = 0;
        if (paramBundle != null) {
          break label127;
        }
        paramString = "";
        label57:
        if (paramBundle != null) {
          break label147;
        }
        paramBundle = "";
      }
      for (;;)
      {
        Log.i("Finder.AdWebViewImpl", "errCode :" + i + " description:" + paramString + " failingUrl:" + paramBundle);
        j.d(this.GYd);
        AppMethodBeat.o(334487);
        return null;
        label117:
        i = paramBundle.getInt("errorCode");
        break;
        label127:
        paramString = paramBundle.getString("description");
        if (paramString == null)
        {
          paramString = "";
          break label57;
        }
        break label57;
        label147:
        String str = paramBundle.getString("failingUrl");
        paramBundle = str;
        if (str == null) {
          paramBundle = "";
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/FinderWebViewHelper$webViewClientListener$1", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "onPageCommitVisible", "", "webview", "Lcom/tencent/xweb/WebView;", "url", "", "onPageFinished", "onPageStarted", "onReceivedError", "view", "request", "Lcom/tencent/xweb/WebResourceRequest;", "error", "Lcom/tencent/xweb/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "webResourceRequest", "webResourceResponse", "Lcom/tencent/xweb/WebResourceResponse;", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "Landroid/net/http/SslError;", "webViewReady", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends com.tencent.mm.plugin.webview.core.h
  {
    d(j paramj) {}
    
    private final void fqd()
    {
      AppMethodBeat.i(334492);
      Log.i("Finder.AdWebViewImpl", "webViewReady");
      j.e(this.GYd);
      AppMethodBeat.o(334492);
    }
    
    public final void a(WebResourceRequest paramWebResourceRequest, ac paramac)
    {
      AppMethodBeat.i(334526);
      StringBuilder localStringBuilder = new StringBuilder("onReceivedError request :").append(paramWebResourceRequest).append(" error:").append(paramac).append(" isForMain:");
      if (paramWebResourceRequest == null)
      {
        paramac = null;
        Log.i("Finder.AdWebViewImpl", paramac);
        if ((paramWebResourceRequest == null) || (paramWebResourceRequest.isForMainFrame() != true)) {
          break label100;
        }
      }
      label100:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          j.d(this.GYd);
        }
        AppMethodBeat.o(334526);
        return;
        paramac = Boolean.valueOf(paramWebResourceRequest.isForMainFrame());
        break;
      }
    }
    
    public final void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(334519);
      super.a(paramWebView, paramInt, paramString1, paramString2);
      Log.i("Finder.AdWebViewImpl", "onReceivedError errorCode :" + paramInt + " description:" + paramString1 + " failingUrl:" + paramString2);
      AppMethodBeat.o(334519);
    }
    
    public final void a(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
    {
      AppMethodBeat.i(334534);
      super.a(paramWebView, paramWebResourceRequest, paramWebResourceResponse);
      if (paramWebResourceRequest == null)
      {
        paramWebView = null;
        Log.i("Finder.AdWebViewImpl", s.X("onReceivedHttpError :", paramWebView));
        if ((paramWebResourceRequest == null) || (paramWebResourceRequest.isForMainFrame() != true)) {
          break label77;
        }
      }
      label77:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          j.d(this.GYd);
        }
        AppMethodBeat.o(334534);
        return;
        paramWebView = Boolean.valueOf(paramWebResourceRequest.isForMainFrame());
        break;
      }
    }
    
    public final void a(WebView paramWebView, t paramt, SslError paramSslError)
    {
      AppMethodBeat.i(334543);
      super.a(paramWebView, paramt, paramSslError);
      Log.i("Finder.AdWebViewImpl", "onReceivedSslError");
      String str = j.f(this.GYd);
      if (Util.isNullOrNil(str))
      {
        Log.d("Finder.AdWebViewImpl", "urlStr == null, return");
        AppMethodBeat.o(334543);
        return;
      }
      if ((j.g(this.GYd) == null) && (paramWebView != null)) {
        j.a(this.GYd, new d(paramWebView.getContext(), paramWebView));
      }
      paramWebView = j.g(this.GYd);
      if (paramWebView != null) {
        paramWebView.a(str, paramt, paramSslError);
      }
      if (!WeChatEnvironment.isCoolassistEnv()) {
        j.d(this.GYd);
      }
      AppMethodBeat.o(334543);
    }
    
    public final void b(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(334512);
      super.b(paramWebView, paramString);
      Log.i("Finder.AdWebViewImpl", s.X("onPageFinished :", paramString));
      AppMethodBeat.o(334512);
    }
    
    public final void e(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(334498);
      super.e(paramWebView, paramString);
      Log.i("Finder.AdWebViewImpl", s.X("onPageCommitVisible :", paramString));
      fqd();
      AppMethodBeat.o(334498);
    }
    
    public final void h(WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(334506);
      super.h(paramWebView, paramString);
      Log.i("Finder.AdWebViewImpl", s.X("onPageStarted :", paramString));
      fqd();
      AppMethodBeat.o(334506);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.j
 * JD-Core Version:    0.7.0.1
 */