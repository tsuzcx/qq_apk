package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dismissing", "", "value", "", "explainContent", "getExplainContent", "()Ljava/lang/String;", "setExplainContent", "(Ljava/lang/String;)V", "explainContentTv", "Landroid/widget/TextView;", "explainTitle", "getExplainTitle", "setExplainTitle", "explainTitleTv", "dismiss", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "dispatchKeyEventPreIme", "event", "Landroid/view/KeyEvent;", "show", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.permission.g
{
  private boolean mCE;
  private final TextView qcI;
  private final TextView qcJ;
  private String qcK;
  private String qcL;
  
  public d(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(268821);
    LayoutInflater.from(paramContext).inflate(au.g.app_brand_functional_page_privacy_explain_ui, (ViewGroup)this, true);
    setBackgroundColor(androidx.core.content.a.w(paramContext, au.c.white));
    GZ(false);
    Object localObject = findViewById(au.f.privacy_explain_title);
    p.j(localObject, "this.findViewById(R.id.privacy_explain_title)");
    this.qcI = ((TextView)localObject);
    localObject = findViewById(au.f.privacy_explain_content);
    p.j(localObject, "this.findViewById(R.id.privacy_explain_content)");
    this.qcJ = ((TextView)localObject);
    localObject = (WeImageView)findViewById(au.f.actionbar_back_btn);
    ((WeImageView)localObject).setIconColor(androidx.core.content.a.w(paramContext, au.c.BW_0_Alpha_0_9));
    ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    AppMethodBeat.o(268821);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(268819);
    if (this.mCE)
    {
      AppMethodBeat.o(268819);
      return;
    }
    this.mCE = true;
    animate().cancel();
    Animation localAnimation = getAnimation();
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.rib);
    localAnimation.setAnimationListener((Animation.AnimationListener)new b(this));
    startAnimation(localAnimation);
    AppMethodBeat.o(268819);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(268817);
    if ((w.al((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(268817);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          dismiss();
          AppMethodBeat.o(268817);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(268817);
    return bool;
  }
  
  public final String getExplainContent()
  {
    return this.qcL;
  }
  
  public final String getExplainTitle()
  {
    return this.qcK;
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(268818);
    p.k(paramg, "component");
    Context localContext = paramg.getContext();
    paramg = localContext;
    if (!(localContext instanceof Activity)) {
      paramg = null;
    }
    paramg = (Activity)paramg;
    if (paramg != null)
    {
      paramg = (ViewGroup)paramg.findViewById(16908290);
      if (paramg != null)
      {
        p.k(paramg, "parent");
        paramg.addView((View)this, new ViewGroup.LayoutParams(-1, -1));
        bringToFront();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        paramg = (View)this;
        paramg.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new d(paramg, this));
        AppMethodBeat.o(268818);
        return;
      }
    }
    AppMethodBeat.o(268818);
  }
  
  public final void j(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(268820);
    p.k(paramg, "component");
    dismiss();
    AppMethodBeat.o(268820);
  }
  
  public final void setExplainContent(String paramString)
  {
    AppMethodBeat.i(268815);
    this.qcL = paramString;
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.ba(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.qcJ.setText((CharSequence)"");
      AppMethodBeat.o(268815);
      return;
    }
    this.qcJ.setText(com.tencent.mm.plugin.appbrand.utils.html.c.a(paramString, false, (c.a)new c(this)));
    this.qcJ.setMovementMethod(LinkMovementMethod.getInstance());
    this.qcJ.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(268815);
  }
  
  public final void setExplainTitle(String paramString)
  {
    AppMethodBeat.i(268813);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = getContext().getString(au.i.appbrand_permission_authorize_explain_title);
      }
      this.qcK = paramString;
      this.qcI.setText((CharSequence)this.qcK);
      AppMethodBeat.o(268813);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(d paramd, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257221);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.qcM.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257221);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$dismiss$1$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
  public static final class b
    extends e
  {
    b(d paramd) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(282872);
      a.cP((View)this.qcM);
      AppMethodBeat.o(282872);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "performOpenUrl"})
  static final class c
    implements c.a
  {
    c(d paramd) {}
    
    public final void agt(String paramString)
    {
      AppMethodBeat.i(272347);
      Context localContext = this.qcM.getContext();
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("forceHideShare", true);
      com.tencent.mm.by.c.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(272347);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class d
    implements ViewTreeObserver.OnPreDrawListener
  {
    public d(View paramView, d paramd) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(265779);
      this.qco.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      View localView = this.qco;
      Animation localAnimation = AnimationUtils.loadAnimation(jdField_this.getContext(), MMFragmentActivity.a.rhY);
      localAnimation.setAnimationListener((Animation.AnimationListener)new a(localView, this));
      localView.startAnimation(localAnimation);
      AppMethodBeat.o(265779);
      return true;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$show$1$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$1"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(View paramView, d.d paramd) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(243505);
        paramAnimation = AndroidContextUtil.castActivityOrNull(jdField_this.qcM.getContext());
        if (paramAnimation != null)
        {
          com.tencent.mm.ui.statusbar.c.bA(paramAnimation).hXX();
          AppMethodBeat.o(243505);
          return;
        }
        AppMethodBeat.o(243505);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation) {}
      
      public final void onAnimationStart(Animation paramAnimation) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.d
 * JD-Core Version:    0.7.0.1
 */