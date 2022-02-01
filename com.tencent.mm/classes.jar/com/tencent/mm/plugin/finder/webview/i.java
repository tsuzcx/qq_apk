package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.finder.e.i;
import com.tencent.mm.plugin.finder.webview.ad.ScrollFrameLayout;
import com.tencent.mm.plugin.finder.webview.ad.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.MMWebView;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewDialogWrapper;", "", "context", "Landroid/content/Context;", "finderWebViewHelper", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper;", "dialog", "Lcom/tencent/mm/plugin/finder/webview/ad/FinderScrollDialog;", "dialogHelper", "Lcom/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper;", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper;Lcom/tencent/mm/plugin/finder/webview/ad/FinderScrollDialog;Lcom/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper;Landroid/content/DialogInterface$OnDismissListener;)V", "isAttachedToWindow", "", "isOnError", "lifecycleObserver", "com/tencent/mm/plugin/finder/webview/FinderWebViewDialogWrapper$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/webview/FinderWebViewDialogWrapper$lifecycleObserver$1;", "mmActivity", "Lcom/tencent/mm/ui/MMActivity;", "pendingShow", "showAfterWebViewReady", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "webViewReady", "addLifeCycleObserver", "", "dismissDialog", "exitType", "", "initDialog", "initWebView", "isShowingDialog", "onDismiss", "realShow", "setDebugListener", "setOnScrollTopTopListener", "listener", "Lcom/tencent/mm/plugin/finder/webview/ad/IScrollToTopListener;", "setShowAfterWebViewPageReady", "setWebViewStatusListener", "webViewStatusListener", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper$IWebViewStateListener;", "showDialog", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i.a GXI;
  private static boolean GXR;
  private final l GXJ;
  final com.tencent.mm.plugin.finder.webview.ad.b GXK;
  final d GXL;
  private boolean GXM;
  private boolean GXN;
  boolean GXO;
  private boolean GXP;
  private final FinderWebViewDialogWrapper.lifecycleObserver.1 GXQ;
  private final Context context;
  private final DialogInterface.OnDismissListener iaY;
  boolean isAttachedToWindow;
  private MMWebView webView;
  private MMActivity wrG;
  
  static
  {
    AppMethodBeat.i(334546);
    GXI = new i.a((byte)0);
    AppMethodBeat.o(334546);
  }
  
  public i(Context paramContext, l paraml, com.tencent.mm.plugin.finder.webview.ad.b paramb, d paramd, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(334452);
    this.context = paramContext;
    this.GXJ = paraml;
    this.GXK = paramb;
    this.GXL = paramd;
    this.iaY = paramOnDismissListener;
    this.GXQ = new FinderWebViewDialogWrapper.lifecycleObserver.1(this);
    this.GXJ.a((l.a)new b(this));
    this.webView = this.GXJ.fpU();
    paramContext = this.GXK.getWindow();
    if (paramContext != null) {
      paramContext.setWindowAnimations(e.i.WebViewDialog);
    }
    this.GXK.setOnDismissListener(new i..ExternalSyntheticLambda0(this));
    paramContext = this.GXL;
    paraml = this.webView;
    s.checkNotNull(paraml);
    paramContext.e(paraml);
    this.GXL.GZf = new i..ExternalSyntheticLambda1(this);
    paramContext = this.GXL;
    paraml = (kotlin.g.a.b)new i.c(this);
    s.u(paraml, "listener");
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      paramContext.GZh = paraml;
    }
    if ((this.context instanceof MMActivity))
    {
      this.wrG = ((MMActivity)this.context);
      ((MMActivity)this.context).getLifecycle().addObserver((p)this.GXQ);
    }
    AppMethodBeat.o(334452);
  }
  
  private static final void a(i parami, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(334471);
    s.u(parami, "this$0");
    Log.i("Finder.AdCenterDialog", "onDismiss");
    GXR = false;
    parami.GXL.onDismiss((DialogInterface)parami.GXK);
    paramDialogInterface = parami.wrG;
    if (paramDialogInterface != null)
    {
      paramDialogInterface = paramDialogInterface.getLifecycle();
      if (paramDialogInterface != null) {
        paramDialogInterface.removeObserver((p)parami.GXQ);
      }
    }
    parami.GXN = false;
    paramDialogInterface = parami.GXJ;
    if (paramDialogInterface != null) {
      paramDialogInterface.release();
    }
    paramDialogInterface = parami.iaY;
    if (paramDialogInterface != null) {
      paramDialogInterface.onDismiss((DialogInterface)parami.GXK);
    }
    AppMethodBeat.o(334471);
  }
  
  private static final void a(i parami, View paramView)
  {
    AppMethodBeat.i(334480);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/webview/FinderWebViewDialogWrapper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "this$0");
    parami.GXJ.reload();
    a.a(new Object(), "com/tencent/mm/plugin/finder/webview/FinderWebViewDialogWrapper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(334480);
  }
  
  private final void fpN()
  {
    AppMethodBeat.i(334461);
    Log.i("Finder.AdCenterDialog", "realShow");
    this.GXK.show();
    GXR = true;
    AppMethodBeat.o(334461);
  }
  
  public final void fpM()
  {
    AppMethodBeat.i(334566);
    Log.i("Finder.AdCenterDialog", "showDialog showAfterWebViewReady: %b, webViewReady: %b", new Object[] { Boolean.valueOf(this.GXO), Boolean.valueOf(this.GXM) });
    if (this.GXO)
    {
      if (!this.GXM)
      {
        this.GXN = true;
        AppMethodBeat.o(334566);
        return;
      }
      fpN();
      AppMethodBeat.o(334566);
      return;
    }
    fpN();
    AppMethodBeat.o(334566);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/FinderWebViewDialogWrapper$initWebView$1", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper$IWebViewStateListener;", "onCreateBoxWebViewEnd", "", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "onCreateBoxWebViewStart", "onError", "onExecuteActionCode", "actionCode", "", "data", "Landroid/os/Bundle;", "onInitWebViewEnd", "onInitWebViewStart", "onWebViewReady", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements l.a
  {
    b(i parami) {}
    
    public final void atR()
    {
      Object localObject2 = null;
      AppMethodBeat.i(334420);
      Log.i("Finder.AdCenterDialog", "onError");
      i.h(this.GXS);
      d locald = i.g(this.GXS);
      Log.i("Finder.DialogScrollViewHelper", "showRetry");
      RelativeInterceptScrollLayout localRelativeInterceptScrollLayout = locald.GZb;
      Object localObject1 = localRelativeInterceptScrollLayout;
      if (localRelativeInterceptScrollLayout == null)
      {
        s.bIx("mWebViewContainer");
        localObject1 = null;
      }
      ((RelativeInterceptScrollLayout)localObject1).setVisibility(4);
      localObject1 = locald.GZd;
      if (localObject1 == null)
      {
        s.bIx("mRetryContainer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((View)localObject1).setVisibility(0);
        localObject1 = locald.GZc;
        if (localObject1 != null) {
          ((MMProcessBar)localObject1).jEO();
        }
        localObject1 = locald.GZc;
        if (localObject1 != null) {
          ((MMProcessBar)localObject1).setVisibility(8);
        }
        locald.GYZ.setForceHandleEvent(true);
        AppMethodBeat.o(334420);
        return;
      }
    }
    
    public final void fpP()
    {
      AppMethodBeat.i(334379);
      Log.i("Finder.AdCenterDialog", "onCreateBoxWebViewStart");
      AppMethodBeat.o(334379);
    }
    
    public final void fpQ()
    {
      AppMethodBeat.i(334383);
      Log.i("Finder.AdCenterDialog", "onCreateBoxWebViewEnd");
      AppMethodBeat.o(334383);
    }
    
    public final void fpR()
    {
      Object localObject2 = null;
      AppMethodBeat.i(334394);
      if ((i.a(this.GXS)) || (i.b(this.GXS)))
      {
        AppMethodBeat.o(334394);
        return;
      }
      i.c(this.GXS);
      Log.i("Finder.AdCenterDialog", "onWebViewReady showAfterWebViewReady: %b, pendingShow: %b", new Object[] { Boolean.valueOf(i.d(this.GXS)), Boolean.valueOf(i.e(this.GXS)) });
      d locald;
      Object localObject1;
      if (i.d(this.GXS))
      {
        if (i.e(this.GXS))
        {
          i.f(this.GXS);
          this.GXS.fpM();
          AppMethodBeat.o(334394);
        }
      }
      else
      {
        locald = i.g(this.GXS);
        Log.i("Finder.DialogScrollViewHelper", "showWebView");
        RelativeInterceptScrollLayout localRelativeInterceptScrollLayout = locald.GZb;
        localObject1 = localRelativeInterceptScrollLayout;
        if (localRelativeInterceptScrollLayout == null)
        {
          s.bIx("mWebViewContainer");
          localObject1 = null;
        }
        ((RelativeInterceptScrollLayout)localObject1).setVisibility(0);
        localObject1 = locald.GZd;
        if (localObject1 != null) {
          break label225;
        }
        s.bIx("mRetryContainer");
        localObject1 = localObject2;
      }
      label225:
      for (;;)
      {
        ((View)localObject1).setVisibility(8);
        localObject1 = locald.GZc;
        if (localObject1 != null) {
          ((MMProcessBar)localObject1).jEO();
        }
        localObject1 = locald.GZc;
        if (localObject1 != null) {
          ((MMProcessBar)localObject1).setVisibility(8);
        }
        locald.GYZ.setForceHandleEvent(false);
        AppMethodBeat.o(334394);
        return;
      }
    }
    
    public final void fpS()
    {
      AppMethodBeat.i(334404);
      Log.i("Finder.AdCenterDialog", "onInitWebViewStart");
      AppMethodBeat.o(334404);
    }
    
    public final void fpT()
    {
      AppMethodBeat.i(334411);
      Log.i("Finder.AdCenterDialog", "onInitWebViewEnd");
      AppMethodBeat.o(334411);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.i
 * JD-Core Version:    0.7.0.1
 */