package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.multitask.ui.bg.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgContainerView", "Landroid/view/ViewGroup;", "value", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;)V", "contentView", "desktopView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView;", "isAnimating", "", "myDesktopViewModel", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandMyDesktopViewModel;", "recentDesktopViewModel", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandRecentDesktopViewModel;", "titleTV", "Landroid/widget/TextView;", "animateHideDesktopView", "", "animateShowDesktopView", "desktopTypeIsMy", "hideDesktopViewDirectly", "isBack", "initBackground", "isDesktopViewShowing", "notifyCloseHeader", "reason", "animateDuration", "notifyTeenModeStatusUpdated", "showDesktopView", "isRecent", "updateAlpha", "alpha", "", "updateStatusBarHeight", "height", "CallbackWrap", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandDesktopContainerView
  extends FrameLayout
{
  public static final AppBrandDesktopContainerView.b rpv;
  public boolean isAnimating;
  private final TextView mNb;
  public final ViewGroup rpp;
  public final ViewGroup rpq;
  public final AppBrandDesktopView rpr;
  private final e rps;
  private final f rpt;
  private AppBrandDesktopView.b rpu;
  
  static
  {
    AppMethodBeat.i(278387);
    rpv = new AppBrandDesktopContainerView.b((byte)0);
    AppMethodBeat.o(278387);
  }
  
  public AppBrandDesktopContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public AppBrandDesktopContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(278386);
    this.rps = new e();
    this.rpt = new f();
    this.rpq = ((ViewGroup)new FrameLayout(paramContext));
    addView((View)this.rpq, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = getContext();
    p.j(paramAttributeSet, "context");
    paramAttributeSet = new GradientColorBackgroundView(paramAttributeSet);
    this.rpq.addView((View)paramAttributeSet, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    Object localObject = com.tencent.mm.plugin.multitask.ui.bg.a.FKj;
    localObject = a.a.fbG();
    paramAttributeSet.setColor(((com.tencent.mm.plugin.multitask.ui.bg.a)localObject).jCp, ((com.tencent.mm.plugin.multitask.ui.bg.a)localObject).jCq);
    paramAttributeSet.setUpdateMode(1);
    paramAttributeSet = new FrameLayout(getContext());
    paramAttributeSet.setBackgroundColor(com.tencent.mm.ci.a.w(getContext(), au.c.UN_BW_0_Alpha_0_3));
    this.rpq.addView((View)paramAttributeSet, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    this.rpq.setVisibility(8);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(au.g.app_brand_desktop_container, (ViewGroup)this, false);
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(278386);
      throw paramContext;
    }
    this.rpp = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = this.rpp.findViewById(au.f.app_brand_desktop_view);
    p.j(paramAttributeSet, "contentView.findViewById…d.app_brand_desktop_view)");
    this.rpr = ((AppBrandDesktopView)paramAttributeSet);
    paramAttributeSet = this.rpp.findViewById(au.f.app_brand_desktop_title);
    p.j(paramAttributeSet, "contentView.findViewById….app_brand_desktop_title)");
    this.mNb = ((TextView)paramAttributeSet);
    ((WeImageView)this.rpp.findViewById(au.f.actionbar_up_indicator_btn)).setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276388);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!AppBrandDesktopContainerView.a(this.rpw).cnI()) {
          this.rpw.cnl();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276388);
      }
    });
    addView((View)this.rpp, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = this.rpp.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(278386);
      throw paramContext;
    }
    ((FrameLayout.LayoutParams)paramAttributeSet).topMargin = ax.getStatusBarHeight(paramContext);
    paramContext = this.rpp.getLayoutParams();
    if (paramContext == null)
    {
      paramContext = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(278386);
      throw paramContext;
    }
    ((FrameLayout.LayoutParams)paramContext).bottomMargin = com.tencent.mm.ci.a.aZ(getContext(), au.d.app_brand_desktop_close_area_height);
    this.rpp.setVisibility(8);
    AppMethodBeat.o(278386);
  }
  
  public final void cnl()
  {
    AppMethodBeat.i(278382);
    if (!cnm())
    {
      AppMethodBeat.o(278382);
      return;
    }
    Log.i("MicroMsg.AppBrandDesktopContainerView", "animateHideDesktopView");
    this.isAnimating = true;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.rpp, "translationX", new float[] { 0.0F, getWidth() });
    localObjectAnimator1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localObjectAnimator1.setDuration(300L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.rpp, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator2.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localObjectAnimator2.setDuration(300L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.rpq, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator3.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localObjectAnimator3.setDuration(300L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { (Animator)localObjectAnimator1, (Animator)localObjectAnimator2, (Animator)localObjectAnimator3 });
    localAnimatorSet.addListener((Animator.AnimatorListener)new c(this));
    localAnimatorSet.start();
    AppMethodBeat.o(278382);
  }
  
  public final boolean cnm()
  {
    AppMethodBeat.i(278384);
    if (this.rpp.getVisibility() == 0)
    {
      AppMethodBeat.o(278384);
      return true;
    }
    AppMethodBeat.o(278384);
    return false;
  }
  
  public final AppBrandDesktopView.b getCallback()
  {
    return this.rpu;
  }
  
  public final void kc(boolean paramBoolean)
  {
    AppMethodBeat.i(278381);
    Log.i("MicroMsg.AppBrandDesktopContainerView", "showDesktopView %b %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(cnm()) });
    if (cnm())
    {
      AppMethodBeat.o(278381);
      return;
    }
    Object localObject2 = this.rpr;
    if (paramBoolean) {}
    for (Object localObject1 = (c)this.rpt;; localObject1 = (c)this.rps)
    {
      ((AppBrandDesktopView)localObject2).a((c)localObject1);
      this.mNb.setText((CharSequence)this.rpr.getViewModel().aBd());
      Log.i("MicroMsg.AppBrandDesktopContainerView", "animateShowDesktopView");
      this.rpp.setVisibility(0);
      this.rpp.setTranslationX(getWidth());
      this.rpp.setAlpha(0.0F);
      this.rpq.setVisibility(0);
      this.rpq.setAlpha(0.0F);
      this.isAnimating = true;
      localObject1 = ObjectAnimator.ofFloat(this.rpp, "translationX", new float[] { getWidth(), 0.0F });
      ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
      ((ObjectAnimator)localObject1).setDuration(300L);
      localObject2 = ObjectAnimator.ofFloat(this.rpp, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)new LinearInterpolator());
      ((ObjectAnimator)localObject2).setDuration(300L);
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.rpq, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
      localObjectAnimator.setDuration(300L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { (Animator)localObject1, (Animator)localObject2, (Animator)localObjectAnimator });
      localAnimatorSet.addListener((Animator.AnimatorListener)new d(this));
      localAnimatorSet.start();
      AppMethodBeat.o(278381);
      return;
    }
  }
  
  public final void kd(boolean paramBoolean)
  {
    AppMethodBeat.i(278383);
    Log.i("MicroMsg.AppBrandDesktopContainerView", "hideDesktopViewDirectly");
    this.rpp.setVisibility(8);
    this.rpq.setVisibility(8);
    this.rpr.reset(paramBoolean);
    AppMethodBeat.o(278383);
  }
  
  public final void setCallback(AppBrandDesktopView.b paramb)
  {
    AppMethodBeat.i(278380);
    if (paramb == null)
    {
      AppMethodBeat.o(278380);
      return;
    }
    this.rpu = ((AppBrandDesktopView.b)new a(paramb));
    this.rpr.setCallback(this.rpu);
    AppMethodBeat.o(278380);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView$CallbackWrap;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView;Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;)V", "getDelegate", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;", "closeHeader", "", "closeReason", "", "launchAppBrandWithCheck", "pos", "item", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "kotlin.jvm.PlatformType", "isMyWeApp", "", "fromDesktop", "notifyDesktopBeginClose", "notifyDesktopClosed", "isBack", "onItemClicked", "tryCloseOnPause", "reportOnDesktopViewAppear", "isMy", "count", "reportOnItemAppear", "appItem", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "isDesktop", "isLoadMore", "reportOnItemClicked", "itemType", "reportOnItemManualAddDeleteWeApp", "insert", "page", "reportOnItemReorderWeApp", "startPos", "endPos", "plugin-appbrand-integration_release"})
  public final class a
    implements AppBrandDesktopView.b
  {
    private final AppBrandDesktopView.b rpx;
    
    public a()
    {
      AppMethodBeat.i(266589);
      this.rpx = localObject;
      AppMethodBeat.o(266589);
    }
    
    public final void DC(int paramInt)
    {
      AppMethodBeat.i(266590);
      this.rpx.DC(paramInt);
      AppMethodBeat.o(266590);
    }
    
    public final void a(int paramInt, AppBrandDesktopView.a parama, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(266591);
      this.rpx.a(paramInt, parama, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(266591);
    }
    
    public final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(266597);
      this.rpx.a(paramLocalUsageInfo, paramInt1, paramInt2);
      AppMethodBeat.o(266597);
    }
    
    public final void a(LocalUsageInfo paramLocalUsageInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(266594);
      this.rpx.a(paramLocalUsageInfo, paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(266594);
    }
    
    public final void a(boolean paramBoolean1, LocalUsageInfo paramLocalUsageInfo, int paramInt1, boolean paramBoolean2, int paramInt2)
    {
      AppMethodBeat.i(266596);
      this.rpx.a(paramBoolean1, paramLocalUsageInfo, paramInt1, paramBoolean2, paramInt2);
      AppMethodBeat.o(266596);
    }
    
    public final void c(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(266595);
      this.rpx.c(paramInt, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(266595);
    }
    
    public final void ke(boolean paramBoolean)
    {
      AppMethodBeat.i(266592);
      this.rpx.ke(paramBoolean);
      AppMethodBeat.o(266592);
    }
    
    public final void z(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(266593);
      this.rpx.z(paramBoolean, paramInt);
      AppMethodBeat.o(266593);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView$animateHideDesktopView$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(269014);
      AppBrandDesktopContainerView.b(this.rpw);
      this.rpw.kd(true);
      AppMethodBeat.o(269014);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView$animateShowDesktopView$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(284537);
      AppBrandDesktopContainerView.b(this.rpw);
      AppMethodBeat.o(284537);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class e
    implements Runnable
  {
    public e(AppBrandDesktopContainerView paramAppBrandDesktopContainerView, int paramInt1, int paramInt2) {}
    
    public final void run()
    {
      AppMethodBeat.i(284213);
      Log.i("MicroMsg.AppBrandDesktopContainerView", "notifyCloseHeader " + this.nQg + ' ' + this.rpy);
      AppBrandDesktopContainerView.a(this.rpw).reset(false);
      this.rpw.kd(false);
      AppMethodBeat.o(284213);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainerView
 * JD-Core Version:    0.7.0.1
 */