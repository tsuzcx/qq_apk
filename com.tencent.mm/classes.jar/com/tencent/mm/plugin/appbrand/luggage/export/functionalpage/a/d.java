package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.t;
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
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dismissing", "", "value", "", "explainContent", "getExplainContent", "()Ljava/lang/String;", "setExplainContent", "(Ljava/lang/String;)V", "explainContentTv", "Landroid/widget/TextView;", "explainTitle", "getExplainTitle", "setExplainTitle", "explainTitleTv", "dismiss", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "dispatchKeyEventPreIme", "event", "Landroid/view/KeyEvent;", "show", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.ui.statusbar.b
  implements g
{
  private boolean iOL;
  private final TextView lUK;
  private final TextView lUL;
  private String lUM;
  private String lUN;
  
  public d(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(223803);
    LayoutInflater.from(paramContext).inflate(2131496379, (ViewGroup)this, true);
    setBackgroundColor(android.support.v4.content.b.n(paramContext, 2131101179));
    yL(false);
    Object localObject = findViewById(2131308182);
    p.g(localObject, "this.findViewById(R.id.privacy_explain_title)");
    this.lUK = ((TextView)localObject);
    localObject = findViewById(2131308181);
    p.g(localObject, "this.findViewById(R.id.privacy_explain_content)");
    this.lUL = ((TextView)localObject);
    localObject = (WeImageView)findViewById(2131296397);
    ((WeImageView)localObject).setIconColor(android.support.v4.content.b.n(paramContext, 2131099664));
    ((WeImageView)localObject).setOnClickListener((View.OnClickListener)new a(this, paramContext));
    AppMethodBeat.o(223803);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(223802);
    if (this.iOL)
    {
      AppMethodBeat.o(223802);
      return;
    }
    this.iOL = true;
    animate().cancel();
    Animation localAnimation = getAnimation();
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.mTl);
    localAnimation.setAnimationListener((Animation.AnimationListener)new b(this));
    startAnimation(localAnimation);
    AppMethodBeat.o(223802);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(223800);
    if ((t.aC((View)this)) && (paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode()))
    {
      KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
      if (localDispatcherState != null)
      {
        if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
        {
          localDispatcherState.startTracking(paramKeyEvent, this);
          AppMethodBeat.o(223800);
          return true;
        }
        if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
        {
          dismiss();
          AppMethodBeat.o(223800);
          return true;
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(223800);
    return bool;
  }
  
  public final String getExplainContent()
  {
    return this.lUN;
  }
  
  public final String getExplainTitle()
  {
    return this.lUM;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.d paramd)
  {
    AppMethodBeat.i(223801);
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
        AppMethodBeat.o(223801);
        return;
      }
    }
    AppMethodBeat.o(223801);
  }
  
  public final void setExplainContent(String paramString)
  {
    AppMethodBeat.i(223799);
    this.lUN = paramString;
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.aD(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.lUL.setText((CharSequence)"");
      AppMethodBeat.o(223799);
      return;
    }
    this.lUL.setText(com.tencent.mm.plugin.appbrand.utils.html.c.a(paramString, false, (c.a)new c(this)));
    this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
    this.lUL.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(223799);
  }
  
  public final void setExplainTitle(String paramString)
  {
    AppMethodBeat.i(223798);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = getContext().getString(2131756008);
      }
      this.lUM = paramString;
      this.lUK.setText((CharSequence)this.lUM);
      AppMethodBeat.o(223798);
      return;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(d paramd, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(223794);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.lUO.dismiss();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(223794);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$dismiss$1$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"})
  public static final class b
    extends com.tencent.mm.ui.widget.c
  {
    b(d paramd) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(223795);
      a.cG((View)this.lUO);
      AppMethodBeat.o(223795);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "url", "", "kotlin.jvm.PlatformType", "performOpenUrl"})
  static final class c
    implements c.a
  {
    c(d paramd) {}
    
    public final void Pu(String paramString)
    {
      AppMethodBeat.i(223796);
      Context localContext = this.lUO.getContext();
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramString);
      localIntent.putExtra("forceHideShare", true);
      com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent);
      AppMethodBeat.o(223796);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"})
  public static final class d
    implements ViewTreeObserver.OnPreDrawListener
  {
    public d(View paramView, d paramd) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(223797);
      this.lUs.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      this.lUs.startAnimation(AnimationUtils.loadAnimation(jdField_this.getContext(), MMFragmentActivity.a.mTi));
      AppMethodBeat.o(223797);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.d
 * JD-Core Version:    0.7.0.1
 */