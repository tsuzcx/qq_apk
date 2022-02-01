package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.u;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.plugin.appbrand.utils.html.c.a;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dismissing", "", "value", "", "explainContent", "getExplainContent", "()Ljava/lang/String;", "setExplainContent", "(Ljava/lang/String;)V", "explainContentTv", "Landroid/widget/TextView;", "explainTitle", "getExplainTitle", "setExplainTitle", "explainTitleTv", "dismiss", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "dispatchKeyEventPreIme", "event", "Landroid/view/KeyEvent;", "show", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.ui.statusbar.b
  implements g
{
  private boolean jLA;
  private final TextView ncu;
  private final TextView ncv;
  private String ncw;
  private String ncx;
  
  public d(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(229030);
    LayoutInflater.from(paramContext).inflate(2131493033, (ViewGroup)this, true);
    setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131101424));
    CF(false);
    Object localObject = findViewById(2131306133);
    p.g(localObject, "this.findViewById(R.id.privacy_explain_title)");
    this.ncu = ((TextView)localObject);
    localObject = findViewById(2131306132);
    p.g(localObject, "this.findViewById(R.id.privacy_explain_content)");
    this.ncv = ((TextView)localObject);
    localObject = (WeImageView)findViewById(2131296422);
    ((WeImageView)localObject).setIconColor(android.support.v4.content.b.n(paramContext, 2131099669));
    ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    AppMethodBeat.o(229030);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(229029);
    if (this.jLA)
    {
      AppMethodBeat.o(229029);
      return;
    }
    this.jLA = true;
    animate().cancel();
    Animation localAnimation = getAnimation();
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.ogp);
    localAnimation.setAnimationListener((Animation.AnimationListener)new b(this));
    startAnimation(localAnimation);
    AppMethodBeat.o(229029);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(229027);
    if ((u.aD((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(229027);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          dismiss();
          AppMethodBeat.o(229027);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(229027);
    return bool;
  }
  
  public final String getExplainContent()
  {
    return this.ncx;
  }
  
  public final String getExplainTitle()
  {
    return this.ncw;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(229028);
    p.h(paramd, "component");
    Context localContext = paramd.getContext();
    paramd = localContext;
    if (!(localContext instanceof Activity)) {
      paramd = null;
    }
    paramd = (Activity)paramd;
    if (paramd != null)
    {
      paramd = (ViewGroup)paramd.findViewById(16908290);
      if (paramd != null)
      {
        p.h(paramd, "parent");
        paramd.addView((View)this, new ViewGroup.LayoutParams(-1, -1));
        bringToFront();
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        paramd = (View)this;
        paramd.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new d(paramd, this));
        AppMethodBeat.o(229028);
        return;
      }
    }
    AppMethodBeat.o(229028);
  }
  
  public final void setExplainContent(String paramString)
  {
    AppMethodBeat.i(229026);
    this.ncx = paramString;
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.aL(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.ncv.setText((CharSequence)"");
      AppMethodBeat.o(229026);
      return;
    }
    this.ncv.setText(com.tencent.mm.plugin.appbrand.utils.html.c.a(paramString, false, (c.a)new c(this)));
    this.ncv.setMovementMethod(LinkMovementMethod.getInstance());
    this.ncv.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(229026);
  }
  
  public final void setExplainTitle(String paramString)
  {
    AppMethodBeat.i(229025);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = getContext().getString(2131756123);
      }
      this.ncw = paramString;
      this.ncu.setText((CharSequence)this.ncw);
      AppMethodBeat.o(229025);
      return;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(d paramd, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(229020);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.ncy.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(229020);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$dismiss$1$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
  public static final class b
    extends com.tencent.mm.ui.widget.c
  {
    b(d paramd) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(229021);
      a.cw((View)this.ncy);
      AppMethodBeat.o(229021);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "performOpenUrl"})
  static final class c
    implements c.a
  {
    c(d paramd) {}
    
    public final void YF(String paramString)
    {
      AppMethodBeat.i(229022);
      Context localContext = this.ncy.getContext();
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("forceHideShare", true);
      com.tencent.mm.br.c.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(229022);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class d
    implements ViewTreeObserver.OnPreDrawListener
  {
    public d(View paramView, d paramd) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(229024);
      this.nca.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      View localView = this.nca;
      Animation localAnimation = AnimationUtils.loadAnimation(jdField_this.getContext(), MMFragmentActivity.a.ogm);
      localAnimation.setAnimationListener((Animation.AnimationListener)new a(localView, this));
      localView.startAnimation(localAnimation);
      AppMethodBeat.o(229024);
      return true;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$show$1$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$1"})
    public static final class a
      implements Animation.AnimationListener
    {
      a(View paramView, d.d paramd) {}
      
      public final void onAnimationEnd(Animation paramAnimation)
      {
        AppMethodBeat.i(229023);
        paramAnimation = AndroidContextUtil.castActivityOrNull(jdField_this.ncy.getContext());
        if (paramAnimation != null)
        {
          com.tencent.mm.ui.statusbar.c.bt(paramAnimation).requestApplyInsets();
          AppMethodBeat.o(229023);
          return;
        }
        AppMethodBeat.o(229023);
      }
      
      public final void onAnimationRepeat(Animation paramAnimation) {}
      
      public final void onAnimationStart(Animation paramAnimation) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.d
 * JD-Core Version:    0.7.0.1
 */