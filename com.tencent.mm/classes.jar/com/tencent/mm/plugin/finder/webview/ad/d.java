package com.tencent.mm.plugin.finder.webview.ad;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.webview.RelativeInterceptScrollLayout;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.i;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.xweb.af;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper;", "Landroid/content/DialogInterface$OnDismissListener;", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMDialog;", "container", "Lcom/tencent/mm/plugin/finder/webview/ad/ScrollFrameLayout;", "(Lcom/tencent/mm/ui/widget/dialog/MMDialog;Lcom/tencent/mm/plugin/finder/webview/ad/ScrollFrameLayout;)V", "blurIv", "Landroid/widget/ImageView;", "callbackListener", "com/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper$callbackListener$1", "Lcom/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper$callbackListener$1;", "codeMaskView", "Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "getCodeMaskView", "()Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "setCodeMaskView", "(Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;)V", "context", "Landroid/content/Context;", "debugListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper$DebugInfo;", "Lkotlin/ParameterName;", "name", "debugInfo", "", "isAtWebViewTop", "", "isDisallowIntercept", "mCloseView", "Landroid/widget/FrameLayout;", "mProgressBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "mRetryContainer", "Landroid/view/View;", "mWebViewContainer", "Lcom/tencent/mm/plugin/finder/webview/RelativeInterceptScrollLayout;", "maskIv", "mmWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "retryListener", "Landroid/view/View$OnClickListener;", "attachDialog", "attachWebView", "webView", "initView", "onDismiss", "Landroid/content/DialogInterface;", "setBlur", "blurRadius", "", "factor", "setOnDebugInfoListener", "listener", "setRetryListener", "setScrollToTopListener", "Lcom/tencent/mm/plugin/finder/webview/ad/IScrollToTopListener;", "showDebugDialog", "showProgress", "showRetry", "showWebView", "Companion", "DebugInfo", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements DialogInterface.OnDismissListener
{
  public static final d.a GYY;
  private MMWebView Aft;
  public MultiCodeMaskView GXV;
  private final i GYB;
  public final ScrollFrameLayout GYZ;
  private FrameLayout GZa;
  public RelativeInterceptScrollLayout GZb;
  public MMProcessBar GZc;
  public View GZd;
  private ImageView GZe;
  public View.OnClickListener GZf;
  private boolean GZg;
  public kotlin.g.a.b<? super d.b, ah> GZh;
  private final d.c GZi;
  private Context context;
  private boolean pvw;
  private ImageView wQf;
  
  static
  {
    AppMethodBeat.i(334723);
    GYY = new d.a((byte)0);
    AppMethodBeat.o(334723);
  }
  
  public d(i parami, ScrollFrameLayout paramScrollFrameLayout)
  {
    AppMethodBeat.i(334650);
    this.GYB = parami;
    this.GYZ = paramScrollFrameLayout;
    parami = this.GYZ.getContext();
    s.s(parami, "container.context");
    this.context = parami;
    this.pvw = true;
    this.GZg = true;
    parami = this.GYZ.findViewById(e.e.close_img);
    s.s(parami, "container.findViewById(R.id.close_img)");
    this.GZa = ((FrameLayout)parami);
    parami = this.GYZ.findViewById(e.e.webview_container);
    s.s(parami, "container.findViewById(R.id.webview_container)");
    this.GZb = ((RelativeInterceptScrollLayout)parami);
    this.GZc = ((MMProcessBar)this.GYZ.findViewById(e.e.finder_webview_tips_loading));
    parami = this.GYZ.findViewById(e.e.finder_webview_tips_retry);
    s.s(parami, "container.findViewById(R…inder_webview_tips_retry)");
    this.GZd = parami;
    parami = this.GYZ.findViewById(e.e.multi_code_mask_view);
    s.s(parami, "container.findViewById(R.id.multi_code_mask_view)");
    parami = (MultiCodeMaskView)parami;
    s.u(parami, "<set-?>");
    this.GXV = parami;
    this.GZe = ((ImageView)this.GYZ.findViewById(e.e.close_blur));
    this.wQf = ((ImageView)this.GYZ.findViewById(e.e.close_mask));
    parami = new com.tencent.mm.videocomposition.effect.a();
    paramScrollFrameLayout = this.context.getResources();
    int i;
    if (paramScrollFrameLayout == null)
    {
      i = 0;
      paramScrollFrameLayout = this.context.getResources();
      if (paramScrollFrameLayout != null) {
        break label520;
      }
      label256:
      paramScrollFrameLayout = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      paramScrollFrameLayout.eraseColor(Color.parseColor("#CCFDFDFD"));
      s.s(paramScrollFrameLayout, "bitmap");
      parami.setInputBitmap(paramScrollFrameLayout);
      parami.setOutputSize(i, j);
      paramScrollFrameLayout = parami.HkF.GpO.jQj();
      paramScrollFrameLayout.setRadius(40.0F);
      paramScrollFrameLayout.eC(5.0F);
      parami.aW((kotlin.g.a.b)new d.d(this));
      parami = this.wQf;
      if (parami != null) {
        parami.setImageDrawable((Drawable)new ColorDrawable(this.context.getResources().getColor(e.b.Blur_1)));
      }
      paramScrollFrameLayout = this.GZa;
      parami = paramScrollFrameLayout;
      if (paramScrollFrameLayout == null)
      {
        s.bIx("mCloseView");
        parami = null;
      }
      parami.setOnClickListener(new d..ExternalSyntheticLambda1(this));
      paramScrollFrameLayout = this.GZd;
      parami = paramScrollFrameLayout;
      if (paramScrollFrameLayout == null)
      {
        s.bIx("mRetryContainer");
        parami = null;
      }
      parami.setOnClickListener(new d..ExternalSyntheticLambda2(this));
      parami = this.GZa;
      if (parami != null) {
        break label532;
      }
      s.bIx("mCloseView");
      parami = localObject;
      label451:
      parami.setOnLongClickListener(new d..ExternalSyntheticLambda3(this));
      if (!(this.GYZ instanceof BottomScrollFrameLayout)) {
        break label535;
      }
      ((BottomScrollFrameLayout)this.GYZ).setDialog(this.GYB);
    }
    for (;;)
    {
      showProgress();
      this.GZi = new d.c(this);
      AppMethodBeat.o(334650);
      return;
      i = paramScrollFrameLayout.getDimensionPixelSize(e.c.Edge_5A);
      break;
      label520:
      j = paramScrollFrameLayout.getDimensionPixelSize(e.c.Edge_2A);
      break label256;
      label532:
      break label451;
      label535:
      if ((this.GYZ instanceof CenterScrollFrameLayout)) {
        ((CenterScrollFrameLayout)this.GYZ).setDialog(this.GYB);
      }
    }
  }
  
  private static final void a(d paramd, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    AppMethodBeat.i(334700);
    s.u(paramd, "this$0");
    Log.v("Finder.DialogScrollViewHelper", "onWebViewScrollChanged l: %d, t: %d, oldl: %d, oldt: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (paramInt2 == 0) {}
    for (;;)
    {
      paramd.pvw = bool;
      AppMethodBeat.o(334700);
      return;
      bool = false;
    }
  }
  
  private static final void a(d paramd, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(334693);
    s.u(paramd, "this$0");
    if ((paramDialogInterface instanceof e))
    {
      paramDialogInterface = (e)paramDialogInterface;
      if (paramDialogInterface != null) {
        break label69;
      }
      paramDialogInterface = "";
    }
    for (;;)
    {
      paramd = paramd.GZh;
      if (paramd != null) {
        paramd.invoke(new d.b(paramDialogInterface));
      }
      AppMethodBeat.o(334693);
      return;
      paramDialogInterface = null;
      break;
      label69:
      String str = paramDialogInterface.jHE();
      paramDialogInterface = str;
      if (str == null) {
        paramDialogInterface = "";
      }
    }
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(334672);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    if ((paramd.GYZ instanceof BottomScrollFrameLayout)) {
      ((BottomScrollFrameLayout)paramd.GYZ).fqq();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(334672);
      return;
      paramd.GYB.dismiss();
    }
  }
  
  private static final void b(d paramd, View paramView)
  {
    AppMethodBeat.i(334678);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    localObject = paramd.GZf;
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick(paramView);
    }
    paramd.showProgress();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(334678);
  }
  
  private static final boolean c(d paramd, View paramView)
  {
    AppMethodBeat.i(334683);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramd, "this$0");
    if ((WeChatEnvironment.hasDebugger()) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE)) {
      new e.a(paramd.context).bDD("取消").bDC("确认").c(new d..ExternalSyntheticLambda0(paramd)).bDA("请输入调试Webview url！").jHH().show();
    }
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.hellhoundlib.a.a.a(bool, new Object(), "com/tencent/mm/plugin/finder/webview/ad/ScrollWebViewDialogHelper", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(334683);
      return bool;
    }
  }
  
  private void showProgress()
  {
    Object localObject2 = null;
    AppMethodBeat.i(334659);
    Log.i("Finder.DialogScrollViewHelper", "showProgress");
    RelativeInterceptScrollLayout localRelativeInterceptScrollLayout = this.GZb;
    Object localObject1 = localRelativeInterceptScrollLayout;
    if (localRelativeInterceptScrollLayout == null)
    {
      s.bIx("mWebViewContainer");
      localObject1 = null;
    }
    ((RelativeInterceptScrollLayout)localObject1).setVisibility(4);
    localObject1 = this.GZd;
    if (localObject1 == null)
    {
      s.bIx("mRetryContainer");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((View)localObject1).setVisibility(8);
      localObject1 = this.GZc;
      if (localObject1 != null) {
        ((MMProcessBar)localObject1).setVisibility(0);
      }
      localObject1 = this.GZc;
      if (localObject1 != null) {
        ((MMProcessBar)localObject1).jEP();
      }
      this.GYZ.setForceHandleEvent(true);
      AppMethodBeat.o(334659);
      return;
    }
  }
  
  public final void e(MMWebView paramMMWebView)
  {
    AppMethodBeat.i(334765);
    s.u(paramMMWebView, "webView");
    this.Aft = paramMMWebView;
    paramMMWebView = this.Aft;
    if (paramMMWebView != null)
    {
      paramMMWebView.a(new d..ExternalSyntheticLambda4(this));
      paramMMWebView = this.GZb;
      if (paramMMWebView != null) {
        break label107;
      }
      s.bIx("mWebViewContainer");
      paramMMWebView = null;
    }
    label107:
    for (;;)
    {
      paramMMWebView.addView((View)this.Aft, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
      paramMMWebView = this.Aft;
      if (paramMMWebView != null) {
        paramMMWebView.setWebViewCallbackClient((af)this.GZi);
      }
      AppMethodBeat.o(334765);
      return;
    }
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(334772);
    paramDialogInterface = this.Aft;
    if (paramDialogInterface != null) {
      paramDialogInterface.setWebViewCallbackClient(null);
    }
    AppMethodBeat.o(334772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.d
 * JD-Core Version:    0.7.0.1
 */