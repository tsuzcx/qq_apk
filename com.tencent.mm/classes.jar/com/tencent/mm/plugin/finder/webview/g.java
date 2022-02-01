package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.b.k;
import com.tencent.mm.plugin.finder.webview.ad.WebViewFrameLayout;
import com.tencent.mm.plugin.finder.webview.ad.a.b;
import com.tencent.mm.protocal.protobuf.qm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.f;
import com.tencent.xweb.ac;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/FinderAdCenterDialog;", "", "context", "Landroid/content/Context;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "uxInfo", "", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "dialWebViewHelper", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper;", "(Landroid/content/Context;Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;Ljava/lang/String;Landroid/content/DialogInterface$OnDismissListener;Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper;)V", "finderWebViewHelper", "isAttachedToWindow", "", "isOnError", "lifecycleObserver", "com/tencent/mm/plugin/finder/webview/FinderAdCenterDialog$lifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/webview/FinderAdCenterDialog$lifecycleObserver$1;", "mDialog", "Lcom/tencent/mm/plugin/finder/webview/ad/AdWebViewDialog;", "mmActivity", "Lcom/tencent/mm/ui/MMActivity;", "pendingShow", "showAfterWebViewReady", "webView", "Lcom/tencent/mm/ui/widget/MMWebView;", "webViewReady", "dismissDialog", "", "exitType", "", "init", "initDialog", "isShowingDialog", "onDismiss", "realShow", "setShowAfterWebViewPageReady", "setWebViewStatusListener", "webViewStatusListener", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper$IWebViewStateListener;", "showDialog", "Companion", "plugin-finder_release"})
public final class g
{
  public static final a Brr;
  private k Brk;
  com.tencent.mm.plugin.finder.webview.ad.a Brl;
  private boolean Brm;
  private boolean Brn;
  boolean Bro;
  private boolean Brp;
  private final FinderAdCenterDialog.lifecycleObserver.1 Brq;
  private final Context context;
  private final DialogInterface.OnDismissListener fVb;
  boolean isAttachedToWindow;
  private final qm sog;
  private MMActivity tnf;
  private final String uxInfo;
  private MMWebView webView;
  
  static
  {
    AppMethodBeat.i(285183);
    Brr = new a((byte)0);
    AppMethodBeat.o(285183);
  }
  
  private g(Context paramContext, qm paramqm, String paramString)
  {
    AppMethodBeat.i(285182);
    this.context = paramContext;
    this.sog = paramqm;
    this.uxInfo = paramString;
    this.fVb = null;
    this.Brl = new com.tencent.mm.plugin.finder.webview.ad.a(this.context);
    this.Brq = new FinderAdCenterDialog.lifecycleObserver.1(this);
    paramContext = new j(this.context, this.sog, this.uxInfo, this.Brl.getWindow());
    paramqm = this.Brl.Bsg;
    if (paramqm == null) {
      p.bGy("mCodeMaskView");
    }
    paramContext.Brz = paramqm;
    this.Brk = ((k)paramContext);
    paramContext = this.Brk;
    if (paramContext != null) {
      paramContext.a((k.a)new k.a()
      {
        public final void elM()
        {
          AppMethodBeat.i(265486);
          Log.i("Finder.AdCenterDialog", "onCreateBoxWebViewStart");
          AppMethodBeat.o(265486);
        }
        
        public final void elN()
        {
          AppMethodBeat.i(265487);
          Log.i("Finder.AdCenterDialog", "onCreateBoxWebViewEnd");
          AppMethodBeat.o(265487);
        }
        
        public final void elO()
        {
          AppMethodBeat.i(265489);
          if ((g.c(this.Brs)) || (g.e(this.Brs)))
          {
            AppMethodBeat.o(265489);
            return;
          }
          g.d(this.Brs);
          Log.i("Finder.AdCenterDialog", "onWebViewReady showAfterWebViewReady: %b, pendingShow: %b", new Object[] { Boolean.valueOf(g.g(this.Brs)), Boolean.valueOf(g.h(this.Brs)) });
          if (g.g(this.Brs))
          {
            if (g.h(this.Brs))
            {
              g.i(this.Brs);
              this.Brs.elK();
              AppMethodBeat.o(265489);
            }
          }
          else
          {
            Object localObject1 = g.j(this.Brs);
            Log.i("Finder.AdWebViewDialog", "showWebView");
            Object localObject2 = ((com.tencent.mm.plugin.finder.webview.ad.a)localObject1).Bsd;
            if (localObject2 == null) {
              p.bGy("mWebViewContainer");
            }
            ((BoxWebViewContainer)localObject2).setVisibility(0);
            localObject2 = ((com.tencent.mm.plugin.finder.webview.ad.a)localObject1).Bsf;
            if (localObject2 == null) {
              p.bGy("mRetryContainer");
            }
            ((View)localObject2).setVisibility(8);
            localObject2 = ((com.tencent.mm.plugin.finder.webview.ad.a)localObject1).Bse;
            if (localObject2 == null) {
              p.bGy("mProgressBar");
            }
            ((View)localObject2).setVisibility(8);
            localObject1 = ((com.tencent.mm.plugin.finder.webview.ad.a)localObject1).Bsb;
            if (localObject1 == null) {
              p.bGy("mContentView");
            }
            ((WebViewFrameLayout)localObject1).setForceHandleEvent(false);
          }
          AppMethodBeat.o(265489);
        }
        
        public final void elP()
        {
          AppMethodBeat.i(265490);
          Log.i("Finder.AdCenterDialog", "onInitWebViewStart");
          AppMethodBeat.o(265490);
        }
        
        public final void elQ()
        {
          AppMethodBeat.i(265491);
          Log.i("Finder.AdCenterDialog", "onInitWebViewEnd");
          AppMethodBeat.o(265491);
        }
        
        public final void onError()
        {
          AppMethodBeat.i(265492);
          Log.i("Finder.AdCenterDialog", "onError");
          g.f(this.Brs);
          Object localObject1 = g.j(this.Brs);
          Log.i("Finder.AdWebViewDialog", "showRetry");
          Object localObject2 = ((com.tencent.mm.plugin.finder.webview.ad.a)localObject1).Bsd;
          if (localObject2 == null) {
            p.bGy("mWebViewContainer");
          }
          ((BoxWebViewContainer)localObject2).setVisibility(4);
          localObject2 = ((com.tencent.mm.plugin.finder.webview.ad.a)localObject1).Bsf;
          if (localObject2 == null) {
            p.bGy("mRetryContainer");
          }
          ((View)localObject2).setVisibility(0);
          localObject2 = ((com.tencent.mm.plugin.finder.webview.ad.a)localObject1).Bse;
          if (localObject2 == null) {
            p.bGy("mProgressBar");
          }
          ((View)localObject2).setVisibility(8);
          localObject1 = ((com.tencent.mm.plugin.finder.webview.ad.a)localObject1).Bsb;
          if (localObject1 == null) {
            p.bGy("mContentView");
          }
          ((WebViewFrameLayout)localObject1).setForceHandleEvent(true);
          AppMethodBeat.o(265492);
        }
      });
    }
    paramContext = this.Brk;
    if (paramContext != null) {}
    for (paramContext = paramContext.elR();; paramContext = null)
    {
      this.webView = paramContext;
      this.Brm = false;
      paramContext = this.Brl.getWindow();
      if (paramContext != null) {
        paramContext.setWindowAnimations(b.k.WebViewDialog);
      }
      paramContext = this.Brl;
      paramqm = this.webView;
      if (paramqm == null) {
        p.iCn();
      }
      p.k(paramqm, "webView");
      paramContext.wIY = paramqm;
      paramqm = paramContext.wIY;
      if (paramqm != null)
      {
        paramqm.a((MMWebView.f)new a.b(paramContext));
        paramqm = paramContext.Bsd;
        if (paramqm == null) {
          p.bGy("mWebViewContainer");
        }
        paramqm.addView((View)paramContext.wIY, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -2));
      }
      paramqm = paramContext.wIY;
      if (paramqm != null) {
        paramqm.setWebViewCallbackClient((ac)paramContext.Bsj);
      }
      this.Brl.setOnDismissListener((DialogInterface.OnDismissListener)new b(this));
      this.Brl.Bsh = ((View.OnClickListener)new c(this));
      if ((this.context instanceof MMActivity))
      {
        this.tnf = ((MMActivity)this.context);
        ((MMActivity)this.context).getLifecycle().a((androidx.lifecycle.k)this.Brq);
      }
      AppMethodBeat.o(285182);
      return;
    }
  }
  
  private final void elL()
  {
    AppMethodBeat.i(285181);
    Log.i("Finder.AdCenterDialog", "realShow");
    this.Brl.show();
    AppMethodBeat.o(285181);
  }
  
  public final void elK()
  {
    AppMethodBeat.i(285180);
    Log.i("Finder.AdCenterDialog", "showDialog showAfterWebViewReady: %b, webViewReady: %b", new Object[] { Boolean.valueOf(this.Bro), Boolean.valueOf(this.Brm) });
    if (this.Bro)
    {
      if (!this.Brm)
      {
        this.Brn = true;
        AppMethodBeat.o(285180);
        return;
      }
      elL();
      AppMethodBeat.o(285180);
      return;
    }
    elL();
    AppMethodBeat.o(285180);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/FinderAdCenterDialog$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
  static final class b
    implements DialogInterface.OnDismissListener
  {
    b(g paramg) {}
    
    public final void onDismiss(DialogInterface paramDialogInterface)
    {
      AppMethodBeat.i(268697);
      g.a(this.Brs);
      AppMethodBeat.o(268697);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(g paramg) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(269873);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/webview/FinderAdCenterDialog$initDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = g.b(this.Brs);
      if (paramView != null) {
        paramView.reload();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/webview/FinderAdCenterDialog$initDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(269873);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.g
 * JD-Core Version:    0.7.0.1
 */