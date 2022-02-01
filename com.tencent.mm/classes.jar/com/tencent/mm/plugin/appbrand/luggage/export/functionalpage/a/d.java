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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView;", "Lcom/tencent/mm/ui/statusbar/DrawStatusBarFrameLayout;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePrivacyExplainPresenterView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dismissing", "", "value", "", "explainContent", "getExplainContent", "()Ljava/lang/String;", "setExplainContent", "(Ljava/lang/String;)V", "explainContentTv", "Landroid/widget/TextView;", "explainTitle", "getExplainTitle", "setExplainTitle", "explainTitleTv", "dismiss", "", "component", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "dispatchKeyEventPreIme", "event", "Landroid/view/KeyEvent;", "show", "parent", "Landroid/view/ViewGroup;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.permission.g
{
  private boolean pzm;
  private final TextView thB;
  private final TextView thC;
  private String thD;
  private String thE;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(319956);
    LayoutInflater.from(paramContext).inflate(ba.g.app_brand_functional_page_privacy_explain_ui, (ViewGroup)this, true);
    setBackgroundColor(androidx.core.content.a.w(paramContext, ba.c.white));
    MU(false);
    Object localObject = findViewById(ba.f.privacy_explain_title);
    s.s(localObject, "this.findViewById(R.id.privacy_explain_title)");
    this.thB = ((TextView)localObject);
    localObject = findViewById(ba.f.privacy_explain_content);
    s.s(localObject, "this.findViewById(R.id.privacy_explain_content)");
    this.thC = ((TextView)localObject);
    localObject = (WeImageView)findViewById(ba.f.actionbar_back_btn);
    ((WeImageView)localObject).setIconColor(androidx.core.content.a.w(paramContext, ba.c.BW_0_Alpha_0_9));
    ((WeImageView)localObject).setOnClickListener(new d..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(319956);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(319971);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramd, "this$0");
    paramd.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(319971);
  }
  
  private static final void a(d paramd, String paramString)
  {
    AppMethodBeat.i(319975);
    s.u(paramd, "this$0");
    paramd = paramd.getContext();
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("forceHideShare", true);
    paramString = ah.aiuX;
    com.tencent.mm.br.c.b(paramd, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(319975);
  }
  
  private void dismiss()
  {
    AppMethodBeat.i(319964);
    if (this.pzm)
    {
      AppMethodBeat.o(319964);
      return;
    }
    this.pzm = true;
    animate().cancel();
    Animation localAnimation = getAnimation();
    if (localAnimation != null) {
      localAnimation.cancel();
    }
    localAnimation = AnimationUtils.loadAnimation(getContext(), MMFragmentActivity.a.upX);
    localAnimation.setAnimationListener((Animation.AnimationListener)new a(this));
    startAnimation(localAnimation);
    AppMethodBeat.o(319964);
  }
  
  public final boolean dispatchKeyEventPreIme(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(320012);
    if (z.ay((View)this))
    {
      int i;
      if ((paramKeyEvent != null) && (4 == paramKeyEvent.getKeyCode())) {
        i = 1;
      }
      while (i != 0)
      {
        KeyEvent.DispatcherState localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
          {
            localDispatcherState.startTracking(paramKeyEvent, this);
            AppMethodBeat.o(320012);
            return true;
            i = 0;
          }
          else if ((1 == paramKeyEvent.getAction()) && (!paramKeyEvent.isCanceled()) && (localDispatcherState.isTracking(paramKeyEvent)))
          {
            dismiss();
            AppMethodBeat.o(320012);
            return true;
          }
        }
      }
    }
    boolean bool = super.dispatchKeyEventPreIme(paramKeyEvent);
    AppMethodBeat.o(320012);
    return bool;
  }
  
  public final String getExplainContent()
  {
    return this.thE;
  }
  
  public final String getExplainTitle()
  {
    return this.thD;
  }
  
  public final void h(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(320025);
    s.u(paramg, "component");
    paramg = paramg.getContext();
    if ((paramg instanceof Activity)) {}
    for (paramg = (Activity)paramg;; paramg = null)
    {
      if (paramg != null)
      {
        paramg = (ViewGroup)paramg.findViewById(16908290);
        if (paramg != null)
        {
          s.u(paramg, "parent");
          paramg.addView((View)this, new ViewGroup.LayoutParams(-1, -1));
          bringToFront();
          setFocusable(true);
          setFocusableInTouchMode(true);
          requestFocus();
          paramg = (View)this;
          paramg.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new b(paramg, this));
        }
      }
      AppMethodBeat.o(320025);
      return;
    }
  }
  
  public final void i(com.tencent.mm.plugin.appbrand.g paramg)
  {
    AppMethodBeat.i(320030);
    s.u(paramg, "component");
    dismiss();
    AppMethodBeat.o(320030);
  }
  
  public final void setExplainContent(String paramString)
  {
    AppMethodBeat.i(320008);
    this.thE = paramString;
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (n.bp(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.thC.setText((CharSequence)"");
      AppMethodBeat.o(320008);
      return;
    }
    this.thC.setText(com.tencent.mm.plugin.appbrand.utils.html.c.a(paramString, false, new d..ExternalSyntheticLambda1(this)));
    this.thC.setMovementMethod(LinkMovementMethod.getInstance());
    this.thC.setLinkTextColor(Color.parseColor("#FF576B95"));
    AppMethodBeat.o(320008);
  }
  
  public final void setExplainTitle(String paramString)
  {
    AppMethodBeat.i(319992);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramString = getContext().getString(ba.i.appbrand_permission_authorize_explain_title);
      }
      this.thD = paramString;
      this.thB.setText((CharSequence)this.thD);
      AppMethodBeat.o(319992);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$dismiss$1$1", "Lcom/tencent/mm/ui/widget/MMAnimationListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends e
  {
    a(d paramd) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(319979);
      a.dx((View)this.thF);
      AppMethodBeat.o(319979);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalAuthorizePesenterViewUtilsKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ViewTreeObserver.OnPreDrawListener
  {
    public b(View paramView, d paramd) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(319994);
      this.thi.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      View localView = this.thi;
      Animation localAnimation = AnimationUtils.loadAnimation(jdField_this.getContext(), MMFragmentActivity.a.upU);
      localAnimation.setAnimationListener((Animation.AnimationListener)new d.c(jdField_this));
      localView.startAnimation(localAnimation);
      AppMethodBeat.o(319994);
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/luggage/export/functionalpage/ui/FunctionalPagePrivacyExplainPresenterUIView$show$1$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animation.AnimationListener
  {
    c(d paramd) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(319985);
      paramAnimation = AndroidContextUtil.castActivityOrNull(this.thF.getContext());
      if (paramAnimation != null) {
        com.tencent.mm.ui.statusbar.c.ch(paramAnimation).jCH();
      }
      AppMethodBeat.o(319985);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.a.d
 * JD-Core Version:    0.7.0.1
 */