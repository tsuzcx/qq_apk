package com.tencent.mm.plugin.finder.webview.ad;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.utils.ah;
import com.tencent.mm.plugin.finder.webview.BoxWebViewContainer;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.f;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ac;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog;", "Lcom/tencent/mm/ui/base/MMDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "callbackListener", "com/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$callbackListener$1", "Lcom/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$callbackListener$1;", "cancelable", "", "height", "", "isAtWebViewTop", "isDisallowIntercept", "mCloseView", "Landroid/widget/FrameLayout;", "mCodeMaskView", "Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "getMCodeMaskView", "()Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "setMCodeMaskView", "(Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;)V", "mContentView", "Lcom/tencent/mm/plugin/finder/webview/ad/WebViewFrameLayout;", "mContext", "mProgressBar", "Landroid/view/View;", "mRetryContainer", "mRootView", "Landroid/view/ViewGroup;", "mWebViewContainer", "Lcom/tencent/mm/plugin/finder/webview/BoxWebViewContainer;", "mmWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "retryListener", "Landroid/view/View$OnClickListener;", "width", "attachWebView", "", "webView", "calcExpectSize", "dismiss", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCancelable", "flag", "setCenterViewByHeight", "contentView", "horizontalMargin", "centerViewHeight", "setRetryListener", "listener", "show", "showProgress", "showRetry", "showWebView", "Companion", "plugin-finder_release"})
public final class a
  extends i
{
  public static final a Bsk;
  private boolean BqC;
  public WebViewFrameLayout Bsb;
  private FrameLayout Bsc;
  public BoxWebViewContainer Bsd;
  public View Bse;
  public View Bsf;
  public MultiCodeMaskView Bsg;
  public View.OnClickListener Bsh;
  private boolean Bsi;
  public final c Bsj;
  private boolean bxO;
  private int height;
  private Context mContext;
  private ViewGroup qoE;
  public MMWebView wIY;
  private int width;
  
  static
  {
    AppMethodBeat.i(266856);
    Bsk = new a((byte)0);
    AppMethodBeat.o(266856);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, b.k.CenterSheetDialog);
    AppMethodBeat.i(266855);
    this.mContext = paramContext;
    this.BqC = true;
    paramContext = ad.kS(this.mContext).inflate(b.g.finder_ad_webview_dialog_container_layout, null);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(266855);
      throw paramContext;
    }
    this.qoE = ((ViewGroup)paramContext);
    paramContext = LayoutInflater.from(this.mContext).inflate(b.g.finder_ad_webview_dialog_layout, null);
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.webview.ad.WebViewFrameLayout");
      AppMethodBeat.o(266855);
      throw paramContext;
    }
    this.Bsb = ((WebViewFrameLayout)paramContext);
    paramContext = this.Bsb;
    if (paramContext == null) {
      p.bGy("mContentView");
    }
    paramContext = paramContext.findViewById(b.f.close_img);
    p.j(paramContext, "mContentView.findViewById(R.id.close_img)");
    this.Bsc = ((FrameLayout)paramContext);
    paramContext = this.Bsb;
    if (paramContext == null) {
      p.bGy("mContentView");
    }
    paramContext = paramContext.findViewById(b.f.webview_container);
    p.j(paramContext, "mContentView.findViewById(R.id.webview_container)");
    this.Bsd = ((BoxWebViewContainer)paramContext);
    paramContext = this.Bsb;
    if (paramContext == null) {
      p.bGy("mContentView");
    }
    paramContext = paramContext.findViewById(b.f.finder_webview_tips_loading);
    p.j(paramContext, "mContentView.findViewByI…der_webview_tips_loading)");
    this.Bse = paramContext;
    paramContext = this.Bsb;
    if (paramContext == null) {
      p.bGy("mContentView");
    }
    paramContext = paramContext.findViewById(b.f.finder_webview_tips_retry);
    p.j(paramContext, "mContentView.findViewByI…inder_webview_tips_retry)");
    this.Bsf = paramContext;
    paramContext = this.Bsb;
    if (paramContext == null) {
      p.bGy("mContentView");
    }
    paramContext = paramContext.findViewById(b.f.multi_code_mask_view);
    p.j(paramContext, "mContentView.findViewByI….id.multi_code_mask_view)");
    this.Bsg = ((MultiCodeMaskView)paramContext);
    setCanceledOnTouchOutside(true);
    paramContext = this.Bsc;
    if (paramContext == null) {
      p.bGy("mCloseView");
    }
    paramContext.setOnClickListener((View.OnClickListener)new d(this));
    paramContext = this.Bsf;
    if (paramContext == null) {
      p.bGy("mRetryContainer");
    }
    paramContext.setOnClickListener((View.OnClickListener)new e(this));
    paramContext = this.qoE;
    if (paramContext == null) {
      p.bGy("mRootView");
    }
    paramContext.setOnClickListener((View.OnClickListener)new f(this));
    paramContext = this.Bsb;
    if (paramContext == null) {
      p.bGy("mContentView");
    }
    paramContext.setDialog((i)this);
    paramContext = ah.AFI;
    this.width = ah.getScreenWidth();
    paramContext = ah.AFI;
    this.height = (ah.getScreenHeight() - ax.getStatusBarHeight(this.mContext));
    int i = this.width;
    paramContext = getContext();
    p.j(paramContext, "context");
    i = (int)((i - (int)paramContext.getResources().getDimension(b.d.Edge_4A)) * 1.666666666666667D);
    Log.i("Finder.AdWebViewDialog", "width :" + this.width + " height:" + this.height + " expectHeight:" + i);
    Object localObject;
    int j;
    if (this.height > i)
    {
      paramContext = getContext();
      p.j(paramContext, "context");
      int k = (int)paramContext.getResources().getDimension(b.d.Edge_2A);
      paramContext = this.Bsb;
      if (paramContext == null) {
        p.bGy("mContentView");
      }
      paramContext = (View)paramContext;
      localObject = ah.AFI;
      j = ah.getScreenHeight();
      Log.i("Finder.AdWebViewDialog", "fullScreenHeight:" + j + " screenHeight statusBar: ");
      localObject = new FrameLayout.LayoutParams(-1, i);
      j = (j - i) / 2;
      ((FrameLayout.LayoutParams)localObject).leftMargin = k;
      ((FrameLayout.LayoutParams)localObject).rightMargin = k;
      i = this.height - i - j;
      if (i < 0) {
        break label748;
      }
    }
    for (;;)
    {
      ((FrameLayout.LayoutParams)localObject).topMargin = i;
      ((FrameLayout.LayoutParams)localObject).bottomMargin = j;
      ViewGroup localViewGroup = this.qoE;
      if (localViewGroup == null) {
        p.bGy("mRootView");
      }
      localViewGroup.addView(paramContext, (ViewGroup.LayoutParams)localObject);
      this.Bsi = true;
      this.Bsj = new c(this);
      AppMethodBeat.o(266855);
      return;
      i = this.height;
      paramContext = getContext();
      p.j(paramContext, "context");
      i -= (int)paramContext.getResources().getDimension(b.d.Edge_4A);
      break;
      label748:
      i = 0;
    }
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(266852);
    super.dismiss();
    MMWebView localMMWebView = this.wIY;
    if (localMMWebView != null)
    {
      localMMWebView.setWebViewCallbackClient(null);
      AppMethodBeat.o(266852);
      return;
    }
    AppMethodBeat.o(266852);
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(266846);
    super.onCreate(paramBundle);
    paramBundle = this.qoE;
    if (paramBundle == null) {
      p.bGy("mRootView");
    }
    setContentView((View)paramBundle);
    paramBundle = getWindow();
    if (paramBundle != null)
    {
      paramBundle.setLayout(this.width, this.height);
      WindowManager.LayoutParams localLayoutParams = paramBundle.getAttributes();
      localLayoutParams.width = this.width;
      localLayoutParams.height = this.height;
      localLayoutParams.gravity = 17;
      paramBundle.setAttributes(localLayoutParams);
      paramBundle.setWindowAnimations(b.k.FinderWebViewAnimation);
    }
    showProgress();
    AppMethodBeat.o(266846);
  }
  
  public final void setCancelable(boolean paramBoolean)
  {
    AppMethodBeat.i(266847);
    super.setCancelable(paramBoolean);
    this.bxO = paramBoolean;
    setCanceledOnTouchOutside(paramBoolean);
    AppMethodBeat.o(266847);
  }
  
  public final void show()
  {
    AppMethodBeat.i(266851);
    Log.i("Finder.AdWebViewDialog", "show");
    super.show();
    AppMethodBeat.o(266851);
  }
  
  public final void showProgress()
  {
    AppMethodBeat.i(266849);
    Log.i("Finder.AdWebViewDialog", "showProgress");
    Object localObject = this.Bsd;
    if (localObject == null) {
      p.bGy("mWebViewContainer");
    }
    ((BoxWebViewContainer)localObject).setVisibility(4);
    localObject = this.Bsf;
    if (localObject == null) {
      p.bGy("mRetryContainer");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.Bse;
    if (localObject == null) {
      p.bGy("mProgressBar");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.Bsb;
    if (localObject == null) {
      p.bGy("mContentView");
    }
    ((WebViewFrameLayout)localObject).setForceHandleEvent(true);
    AppMethodBeat.o(266849);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$Companion;", "", "()V", "SCROLL_HORIZONTAL_LEFT_LIMIT", "", "SCROLL_VERTICAL_TOP_LIMIT", "TAG", "", "WEB_VIEW_RATIO", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "l", "", "t", "oldl", "oldt", "onWebViewScrollChanged", "com/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$attachWebView$1$1"})
  public static final class b
    implements MMWebView.f
  {
    public b(a parama) {}
    
    public final void onWebViewScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      boolean bool = true;
      AppMethodBeat.i(276911);
      Log.v("Finder.AdWebViewDialog", "onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      a locala = this.Bsl;
      if (paramInt2 == 0) {}
      for (;;)
      {
        a.a(locala, bool);
        AppMethodBeat.o(276911);
        return;
        bool = false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$callbackListener$1", "Lcom/tencent/xweb/WebViewCallbackClient;", "computeScroll", "", "view", "Landroid/view/View;", "dispatchTouchEvent", "", "event", "Landroid/view/MotionEvent;", "invalidate", "onInterceptTouchEvent", "onOverScrolled", "scrollX", "", "scrollY", "clampedX", "clampedY", "webContentView", "onScrollChanged", "l", "t", "oldl", "oldt", "onTouchEvent", "overScrollBy", "deltaX", "deltaY", "scrollRangeX", "scrollRangeY", "maxOverScrollX", "maxOverScrollY", "isTouchEvent", "plugin-finder_release"})
  public static final class c
    implements ac
  {
    public final void computeScroll(View paramView)
    {
      AppMethodBeat.i(231668);
      paramView = a.b(this.Bsl);
      if (paramView != null)
      {
        paramView.hZQ();
        AppMethodBeat.o(231668);
        return;
      }
      AppMethodBeat.o(231668);
    }
    
    public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(231667);
      do
      {
        Log.i("Finder.AdWebViewDialog", "dispatchTouchEvent: event:".concat(String.valueOf(paramMotionEvent)));
      } while ((a.b(this.Bsl) != null) && (WebView.isX5()));
      AppMethodBeat.o(231667);
      return false;
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(231673);
      Log.i("Finder.AdWebViewDialog", "onInterceptTouchEvent: event:".concat(String.valueOf(paramMotionEvent)));
      paramView = a.b(this.Bsl);
      if ((paramView != null) && (WebView.isX5()))
      {
        boolean bool = paramView.aw(paramMotionEvent);
        AppMethodBeat.o(231673);
        return bool;
      }
      AppMethodBeat.o(231673);
      return false;
    }
    
    public final void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, View paramView)
    {
      AppMethodBeat.i(231669);
      Log.i("Finder.AdWebViewDialog", "onOverScrolled: scrollX:" + paramInt1 + " scrollY:" + paramInt2 + " clampedX:" + paramBoolean1 + " clampedY:" + paramBoolean2);
      paramView = a.b(this.Bsl);
      if (paramView != null)
      {
        paramView.g(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
        if ((paramBoolean2) && (paramInt2 < 200))
        {
          a.d(this.Bsl).setAllowVerticalIntercept(true);
          AppMethodBeat.o(231669);
          return;
        }
        if ((paramBoolean1) && (paramInt1 < 100)) {
          a.d(this.Bsl).setAllowHorizontalIntercept(true);
        }
        AppMethodBeat.o(231669);
        return;
      }
      AppMethodBeat.o(231669);
    }
    
    public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
    {
      AppMethodBeat.i(231675);
      Log.i("Finder.AdWebViewDialog", "onScrollChanged l:" + paramInt1 + ", t:" + paramInt2 + "  oldl:" + paramInt3 + " oldt:" + paramInt4);
      paramView = a.b(this.Bsl);
      if (paramView != null)
      {
        if (WebView.isX5()) {
          paramView.W(paramInt1, paramInt2, paramInt3, paramInt4);
        }
        AppMethodBeat.o(231675);
        return;
      }
      AppMethodBeat.o(231675);
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent, View paramView)
    {
      AppMethodBeat.i(231660);
      p.k(paramMotionEvent, "event");
      Log.i("Finder.AdWebViewDialog", "onTouchEvent event:" + paramMotionEvent + " view:" + paramView);
      paramView = a.b(this.Bsl);
      if ((paramView != null) && (WebView.isX5()))
      {
        switch (paramMotionEvent.getAction())
        {
        }
        for (;;)
        {
          boolean bool = paramView.au(paramMotionEvent);
          AppMethodBeat.o(231660);
          return bool;
          paramView.requestDisallowInterceptTouchEvent(a.c(this.Bsl));
        }
      }
      AppMethodBeat.o(231660);
      return false;
    }
    
    public final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean, View paramView)
    {
      AppMethodBeat.i(231664);
      Log.i("Finder.AdWebViewDialog", "overScrollBy: deltaX：" + paramInt1 + " deltaY：" + paramInt2 + " scrollX：" + paramInt3 + " scrollY:" + paramInt4 + "  scrollRangeX:" + paramInt5 + " scrollRangeY:" + paramInt6 + " maxOverScrollX:" + paramInt7 + " maxOverScrollY:" + paramInt8 + " isTouchEvent:" + paramBoolean);
      paramView = a.b(this.Bsl);
      if (paramView != null)
      {
        paramBoolean = paramView.b(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
        AppMethodBeat.o(231664);
        return paramBoolean;
      }
      AppMethodBeat.o(231664);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(222807);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Bsl.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(222807);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(240655);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      localObject = a.a(this.Bsl);
      if (localObject != null) {
        ((View.OnClickListener)localObject).onClick(paramView);
      }
      this.Bsl.showProgress();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(240655);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(273185);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.Bsl.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(273185);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.a
 * JD-Core Version:    0.7.0.1
 */