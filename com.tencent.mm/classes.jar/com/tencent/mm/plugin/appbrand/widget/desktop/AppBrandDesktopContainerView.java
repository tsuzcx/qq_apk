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
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.multitask.ui.bg.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgContainerView", "Landroid/view/ViewGroup;", "value", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;", "callback", "getCallback", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;)V", "contentView", "getContentView", "()Landroid/view/ViewGroup;", "desktopView", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView;", "isAnimating", "", "myDesktopViewModel", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandMyDesktopViewModel;", "recentDesktopViewModel", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandRecentDesktopViewModel;", "titleTV", "Landroid/widget/TextView;", "animateHideDesktopView", "", "animateShowDesktopView", "hasIcon", "desktopTypeIsMy", "hideDesktopViewDirectly", "isBack", "initBackground", "isDesktopViewShowing", "notifyCloseHeader", "reason", "animateDuration", "notifyTeenModeStatusUpdated", "showDesktopView", "isRecent", "updateAlpha", "alpha", "", "updateStatusBarHeight", "height", "CallbackWrap", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandDesktopContainerView
  extends FrameLayout
{
  public static final AppBrandDesktopContainerView.b uzA;
  public boolean isAnimating;
  private final TextView pJJ;
  public final ViewGroup uzB;
  public final ViewGroup uzC;
  public final AppBrandDesktopView uzD;
  private final e uzE;
  private final f uzF;
  private AppBrandDesktopView.b uzG;
  
  static
  {
    AppMethodBeat.i(324303);
    uzA = new AppBrandDesktopContainerView.b((byte)0);
    AppMethodBeat.o(324303);
  }
  
  public AppBrandDesktopContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(324279);
    AppMethodBeat.o(324279);
  }
  
  public AppBrandDesktopContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(324271);
    this.uzE = new e();
    this.uzF = new f();
    this.uzC = ((ViewGroup)new FrameLayout(paramContext));
    addView((View)this.uzC, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = getContext();
    s.s(paramAttributeSet, "context");
    paramAttributeSet = new GradientColorBackgroundView(paramAttributeSet);
    this.uzC.addView((View)paramAttributeSet, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    Object localObject = com.tencent.mm.plugin.multitask.ui.bg.a.LFw;
    localObject = a.a.gkK();
    paramAttributeSet.setColor(((com.tencent.mm.plugin.multitask.ui.bg.a)localObject).mcd, ((com.tencent.mm.plugin.multitask.ui.bg.a)localObject).mce);
    paramAttributeSet.setUpdateMode(1);
    paramAttributeSet = new FrameLayout(getContext());
    paramAttributeSet.setBackgroundColor(com.tencent.mm.cd.a.w(getContext(), ba.c.UN_BW_0_Alpha_0_3));
    this.uzC.addView((View)paramAttributeSet, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    this.uzC.setVisibility(8);
    paramAttributeSet = LayoutInflater.from(paramContext).inflate(ba.g.app_brand_desktop_container, (ViewGroup)this, false);
    if (paramAttributeSet == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(324271);
      throw paramContext;
    }
    this.uzB = ((ViewGroup)paramAttributeSet);
    paramAttributeSet = this.uzB.findViewById(ba.f.app_brand_desktop_view);
    s.s(paramAttributeSet, "contentView.findViewById…d.app_brand_desktop_view)");
    this.uzD = ((AppBrandDesktopView)paramAttributeSet);
    paramAttributeSet = this.uzB.findViewById(ba.f.app_brand_desktop_title);
    s.s(paramAttributeSet, "contentView.findViewById….app_brand_desktop_title)");
    this.pJJ = ((TextView)paramAttributeSet);
    ((WeImageView)this.uzB.findViewById(ba.f.actionbar_up_indicator_btn)).setOnClickListener(new AppBrandDesktopContainerView..ExternalSyntheticLambda0(this));
    addView((View)this.uzB, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramAttributeSet = this.uzB.getLayoutParams();
    if (paramAttributeSet == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(324271);
      throw paramContext;
    }
    ((FrameLayout.LayoutParams)paramAttributeSet).topMargin = bf.getStatusBarHeight(paramContext);
    paramContext = this.uzB.getLayoutParams();
    if (paramContext == null)
    {
      paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(324271);
      throw paramContext;
    }
    ((FrameLayout.LayoutParams)paramContext).bottomMargin = com.tencent.mm.cd.a.bs(getContext(), ba.d.app_brand_desktop_close_area_height);
    this.uzB.setVisibility(8);
    AppMethodBeat.o(324271);
  }
  
  private static final void a(int paramInt1, int paramInt2, AppBrandDesktopContainerView paramAppBrandDesktopContainerView)
  {
    AppMethodBeat.i(324288);
    s.u(paramAppBrandDesktopContainerView, "this$0");
    Log.i("MicroMsg.AppBrandDesktopContainerView", "notifyCloseHeader " + paramInt1 + ' ' + paramInt2);
    paramAppBrandDesktopContainerView.uzD.reset(false);
    paramAppBrandDesktopContainerView.ln(false);
    AppMethodBeat.o(324288);
  }
  
  private static final void a(AppBrandDesktopContainerView paramAppBrandDesktopContainerView, View paramView)
  {
    AppMethodBeat.i(324285);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramAppBrandDesktopContainerView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramAppBrandDesktopContainerView, "this$0");
    if (!paramAppBrandDesktopContainerView.uzD.uAR) {
      paramAppBrandDesktopContainerView.cPh();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(324285);
  }
  
  public final void H(boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(324362);
    Log.i("MicroMsg.AppBrandDesktopContainerView", "showDesktopView %b %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(cPi()) });
    if (cPi())
    {
      AppMethodBeat.o(324362);
      return;
    }
    Object localObject2 = this.uzD;
    Object localObject1;
    Object localObject3;
    if (paramBoolean1)
    {
      localObject1 = (c)this.uzF;
      Log.i("MicroMsg.AppBrandDesktopView", "desktop show:%d", new Object[] { Integer.valueOf(((c)localObject1).cPD()) });
      ((AppBrandDesktopView)localObject2).uzT = ((c)localObject1);
      if (((AppBrandDesktopView)localObject2).uzX == null)
      {
        localObject3 = ((AppBrandDesktopView)localObject2).getRootView();
        if (localObject3 != null) {
          ((AppBrandDesktopView)localObject2).uzX = ((AppBrandDesktopDragView)((View)localObject3).findViewById(ba.f.drag_feature_view));
        }
      }
      else
      {
        Log.i("MicroMsg.AppBrandDesktopView", "configDragFeatureView");
        ((AppBrandDesktopView)localObject2).uzX.setRecyclerView((RecyclerView)localObject2);
        ((AppBrandDesktopView)localObject2).uzX.setList(((AppBrandDesktopView)localObject2).mDataList);
        ((AppBrandDesktopView)localObject2).uzX.setAppBrandDragCallback(((AppBrandDesktopView)localObject2).uAe);
        ((AppBrandDesktopView)localObject2).uzX.setViewWidth(((AppBrandDesktopView)localObject2).mViewWidth);
        ((AppBrandDesktopView)localObject2).uzX.setCanMyWeAppMove(true);
        ((AppBrandDesktopView)localObject2).uzX.setShouldDoDeleteAnimation(true);
        ((DragRecyclerView)localObject2).uBe = ((AppBrandDesktopView)localObject2).uzX;
      }
      localObject3 = ((AppBrandDesktopView)localObject2).uzX;
      if (((c)localObject1).cPD() != 1) {
        break label710;
      }
      paramBoolean1 = true;
      label236:
      ((AppBrandDesktopDragView)localObject3).lr(paramBoolean1);
      if (((AppBrandDesktopView)localObject2).uzT != null)
      {
        ((AppBrandDesktopView)localObject2).mDataList.clear();
        if (((AppBrandDesktopView)localObject2).uzV) {
          ((AppBrandDesktopView)localObject2).mDataList.add(new AppBrandDesktopView.a(4));
        }
        localObject1 = ((AppBrandDesktopView)localObject2).uzT.cPE();
        Log.i("MicroMsg.AppBrandDesktopView", "jacob get dataList " + AppBrandDesktopView.dL((List)localObject1));
        ((AppBrandDesktopView)localObject2).mDataList.addAll((Collection)localObject1);
        ((AppBrandDesktopView)localObject2).cPA();
        ((AppBrandDesktopView)localObject2).cPy();
        localObject3 = ((AppBrandDesktopView)localObject2).uzG;
        if (((AppBrandDesktopView)localObject2).uzT.cPD() != 2) {
          break label715;
        }
      }
    }
    label710:
    label715:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((AppBrandDesktopView.b)localObject3).x(paramBoolean1, ((List)localObject1).size());
      Log.i("MicroMsg.AppBrandDesktopView", "make data, search:%b count:%d", new Object[] { Boolean.valueOf(((AppBrandDesktopView)localObject2).uzV), Integer.valueOf(((List)localObject1).size()) });
      this.pJJ.setText((CharSequence)this.uzD.getViewModel().aUa());
      Log.i("MicroMsg.AppBrandDesktopContainerView", "animateShowDesktopView");
      this.uzB.setVisibility(0);
      this.uzB.setTranslationX(getWidth());
      this.uzB.setAlpha(0.0F);
      this.uzC.setVisibility(0);
      this.uzC.setAlpha(0.0F);
      this.isAnimating = true;
      localObject1 = ObjectAnimator.ofFloat(this.uzB, "translationX", new float[] { getWidth(), 0.0F });
      ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
      ((ObjectAnimator)localObject1).setDuration(300L);
      localObject2 = ObjectAnimator.ofFloat(this.uzB, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)new LinearInterpolator());
      ((ObjectAnimator)localObject2).setDuration(300L);
      localObject3 = ObjectAnimator.ofFloat(this.uzC, "alpha", new float[] { 0.0F, 1.0F });
      ((ObjectAnimator)localObject3).setInterpolator((TimeInterpolator)new LinearInterpolator());
      ((ObjectAnimator)localObject3).setDuration(300L);
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { (Animator)localObject1, (Animator)localObject2, (Animator)localObject3 });
      localAnimatorSet.addListener((Animator.AnimatorListener)new d(this, paramBoolean2));
      localAnimatorSet.start();
      AppMethodBeat.o(324362);
      return;
      localObject1 = (c)this.uzE;
      break;
      paramBoolean1 = false;
      break label236;
    }
  }
  
  public final void cPh()
  {
    AppMethodBeat.i(324370);
    if (!cPi())
    {
      AppMethodBeat.o(324370);
      return;
    }
    Log.i("MicroMsg.AppBrandDesktopContainerView", "animateHideDesktopView");
    this.isAnimating = true;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.uzB, "translationX", new float[] { 0.0F, getWidth() });
    localObjectAnimator1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localObjectAnimator1.setDuration(300L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.uzB, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator2.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localObjectAnimator2.setDuration(300L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.uzC, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator3.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
    localObjectAnimator3.setDuration(300L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(new Animator[] { (Animator)localObjectAnimator1, (Animator)localObjectAnimator2, (Animator)localObjectAnimator3 });
    localAnimatorSet.addListener((Animator.AnimatorListener)new c(this));
    localAnimatorSet.start();
    AppMethodBeat.o(324370);
  }
  
  public final boolean cPi()
  {
    AppMethodBeat.i(324383);
    if (this.uzB.getVisibility() == 0)
    {
      AppMethodBeat.o(324383);
      return true;
    }
    AppMethodBeat.o(324383);
    return false;
  }
  
  public final void fX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(324346);
    AppBrandDesktopContainerView..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = new AppBrandDesktopContainerView..ExternalSyntheticLambda1(paramInt1, paramInt2, this);
    if ((paramInt1 == 15) && (cPi())) {}
    for (long l = paramInt2;; l = 0L)
    {
      postDelayed(localExternalSyntheticLambda1, l);
      AppMethodBeat.o(324346);
      return;
    }
  }
  
  public final AppBrandDesktopView.b getCallback()
  {
    return this.uzG;
  }
  
  public final ViewGroup getContentView()
  {
    return this.uzB;
  }
  
  public final void ln(boolean paramBoolean)
  {
    AppMethodBeat.i(324376);
    Log.i("MicroMsg.AppBrandDesktopContainerView", "hideDesktopViewDirectly");
    this.uzB.setVisibility(8);
    this.uzC.setVisibility(8);
    this.uzD.reset(paramBoolean);
    AppMethodBeat.o(324376);
  }
  
  public final void setCallback(AppBrandDesktopView.b paramb)
  {
    AppMethodBeat.i(324340);
    if (paramb == null)
    {
      AppMethodBeat.o(324340);
      return;
    }
    this.uzG = ((AppBrandDesktopView.b)new a(paramb));
    this.uzD.setCallback(this.uzG);
    AppMethodBeat.o(324340);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView$CallbackWrap;", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;", "delegate", "(Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView;Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;)V", "getDelegate", "()Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$Callback;", "closeHeader", "", "closeReason", "", "launchAppBrandWithCheck", "pos", "item", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopView$AppBrandItem;", "kotlin.jvm.PlatformType", "isMyWeApp", "", "fromDesktop", "notifyDesktopBeginClose", "notifyDesktopClosed", "isBack", "onItemClicked", "tryCloseOnPause", "reportOnDesktopViewAppear", "isMy", "count", "reportOnItemAppear", "appItem", "Lcom/tencent/mm/plugin/appbrand/appusage/LocalUsageInfo;", "isDesktop", "isLoadMore", "reportOnItemClicked", "itemType", "appID", "", "reportOnItemManualAddDeleteWeApp", "insert", "page", "reportOnItemReorderWeApp", "startPos", "endPos", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    implements AppBrandDesktopView.b
  {
    private final AppBrandDesktopView.b uzH;
    
    public a()
    {
      AppMethodBeat.i(324239);
      this.uzH = localObject;
      AppMethodBeat.o(324239);
    }
    
    public final void Eb(int paramInt)
    {
      AppMethodBeat.i(324242);
      this.uzH.Eb(paramInt);
      AppMethodBeat.o(324242);
    }
    
    public final void a(int paramInt, AppBrandDesktopView.a parama, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(324244);
      this.uzH.a(paramInt, parama, paramBoolean1, paramBoolean2);
      AppMethodBeat.o(324244);
    }
    
    public final void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString)
    {
      AppMethodBeat.i(324262);
      this.uzH.a(paramInt, paramBoolean1, paramBoolean2, paramString);
      AppMethodBeat.o(324262);
    }
    
    public final void a(LocalUsageInfo paramLocalUsageInfo, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(324267);
      this.uzH.a(paramLocalUsageInfo, paramInt1, paramInt2);
      AppMethodBeat.o(324267);
    }
    
    public final void a(LocalUsageInfo paramLocalUsageInfo, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(324257);
      this.uzH.a(paramLocalUsageInfo, paramBoolean1, paramBoolean2, paramBoolean3);
      AppMethodBeat.o(324257);
    }
    
    public final void a(boolean paramBoolean1, LocalUsageInfo paramLocalUsageInfo, int paramInt1, boolean paramBoolean2, int paramInt2)
    {
      AppMethodBeat.i(324263);
      this.uzH.a(paramBoolean1, paramLocalUsageInfo, paramInt1, paramBoolean2, paramInt2);
      AppMethodBeat.o(324263);
    }
    
    public final void lo(boolean paramBoolean)
    {
      AppMethodBeat.i(324248);
      this.uzH.lo(paramBoolean);
      AppMethodBeat.o(324248);
    }
    
    public final void x(boolean paramBoolean, int paramInt)
    {
      AppMethodBeat.i(324253);
      this.uzH.x(paramBoolean, paramInt);
      AppMethodBeat.o(324253);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView$animateHideDesktopView$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(AppBrandDesktopContainerView paramAppBrandDesktopContainerView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(324238);
      AppBrandDesktopContainerView.a(this.uzI);
      this.uzI.ln(true);
      AppMethodBeat.o(324238);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopContainerView$animateShowDesktopView$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(AppBrandDesktopContainerView paramAppBrandDesktopContainerView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(324247);
      AppBrandDesktopContainerView.a(this.uzI);
      if ((paramBoolean2) && (AppBrandDesktopContainerView.b(this.uzI) != null))
      {
        Object localObject = AppBrandDesktopContainerView.b(this.uzI);
        if (((AppBrandDesktopView)localObject).bUp != null)
        {
          int i = ((AppBrandDesktopView)localObject).bUp.getItemCount();
          if (i <= 0)
          {
            AppMethodBeat.o(324247);
            return;
          }
          paramAnimator = new AppBrandDesktopView.3((AppBrandDesktopView)localObject, ((AppBrandDesktopView)localObject).getContext());
          paramAnimator.cag = (i - 1);
          localObject = ((AppBrandDesktopView)localObject).getLayoutManager();
          if (localObject != null) {
            ((RecyclerView.LayoutManager)localObject).startSmoothScroll(paramAnimator);
          }
        }
      }
      AppMethodBeat.o(324247);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainerView
 * JD-Core Version:    0.7.0.1
 */