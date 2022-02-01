package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.g.b.y.c;
import d.l;
import d.v;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "imageAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "imageFinalSize", "", "interpolator", "Landroid/view/animation/LinearInterpolator;", "pictureAnimIv", "Landroid/widget/ImageView;", "getPictureAnimIv", "()Landroid/widget/ImageView;", "setPictureAnimIv", "(Landroid/widget/ImageView;)V", "scaleRatio", "", "starAnimIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStarAnimIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setStarAnimIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "starDownAnimator", "starFinalSize", "starMiddleSize", "starOriginalSize", "starUpAnimator", "startLocation", "", "targetRect", "Landroid/graphics/Rect;", "addViewToDecor", "", "child", "Landroid/view/View;", "isAdd", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "animFav", "bitmap", "Landroid/graphics/Bitmap;", "startViewLocation", "animFrameImage", "animStar", "Companion", "plugin-finder_release"})
public final class FinderFavAnimUIC
  extends UIComponent
{
  public static final FinderFavAnimUIC.g tmf;
  public ImageView tlS;
  WeImageView tlT;
  public final int tlU;
  private final int tlV;
  private final int tlW;
  private final int tlX;
  public float tlY;
  public final Rect tlZ;
  public int[] tma;
  private final LinearInterpolator tmb;
  public final ValueAnimator tmc;
  private final ValueAnimator tmd;
  private final ValueAnimator tme;
  
  static
  {
    AppMethodBeat.i(206149);
    tmf = new FinderFavAnimUIC.g((byte)0);
    AppMethodBeat.o(206149);
  }
  
  public FinderFavAnimUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206148);
    this.tlU = paramMMActivity.getResources().getDimensionPixelSize(2131165289);
    this.tlV = paramMMActivity.getResources().getDimensionPixelSize(2131165296);
    this.tlW = paramMMActivity.getResources().getDimensionPixelSize(2131165289);
    this.tlX = paramMMActivity.getResources().getDimensionPixelSize(2131165303);
    this.tlY = 1.0F;
    this.tlZ = new Rect();
    this.tmb = new LinearInterpolator();
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramMMActivity, "it");
    paramMMActivity.setInterpolator((TimeInterpolator)this.tmb);
    paramMMActivity.setDuration(400L);
    final y.c localc1 = new y.c();
    localc1.NiV = 0.0F;
    final y.c localc2 = new y.c();
    localc2.NiV = 0.0F;
    paramMMActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(localc2, localc1, this));
    paramMMActivity.addListener((Animator.AnimatorListener)new b(localc1, localc2, this));
    this.tmc = paramMMActivity;
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramMMActivity, "it");
    paramMMActivity.setDuration(150L);
    paramMMActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
    paramMMActivity.addListener((Animator.AnimatorListener)new d(this));
    this.tmd = paramMMActivity;
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramMMActivity, "it");
    paramMMActivity.setDuration(300L);
    paramMMActivity.setInterpolator((TimeInterpolator)this.tmb);
    localc1 = new y.c();
    localc1.NiV = 0.0F;
    localc2 = new y.c();
    localc2.NiV = 0.0F;
    paramMMActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(localc1, localc2, this));
    paramMMActivity.addListener((Animator.AnimatorListener)new f(localc1, localc2, this));
    this.tme = paramMMActivity;
    AppMethodBeat.o(206148);
  }
  
  private final void a(View paramView, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(206146);
    if (paramBoolean)
    {
      if (paramView.getParent() != null)
      {
        ae.i("FinderFavAnimUIC", "addViewToDecor: view already has parent view");
        localObject = getActivity().getWindow();
        p.g(localObject, "activity.window");
        localObject = ((Window)localObject).getDecorView();
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(206146);
          throw paramView;
        }
        ((ViewGroup)localObject).removeView(paramView);
      }
      Object localObject = getActivity().getWindow();
      p.g(localObject, "activity.window");
      localObject = ((Window)localObject).getDecorView();
      if (localObject == null)
      {
        paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(206146);
        throw paramView;
      }
      ((ViewGroup)localObject).addView(paramView, paramLayoutParams);
      AppMethodBeat.o(206146);
      return;
    }
    paramLayoutParams = getActivity().getWindow();
    p.g(paramLayoutParams, "activity.window");
    paramLayoutParams = paramLayoutParams.getDecorView();
    if (paramLayoutParams == null)
    {
      paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(206146);
      throw paramView;
    }
    ((ViewGroup)paramLayoutParams).removeView(paramView);
    AppMethodBeat.o(206146);
  }
  
  public final void cQS()
  {
    AppMethodBeat.i(206145);
    ae.i("FinderFavAnimUIC", "[animStar]");
    if (this.tlT == null)
    {
      localObject = (FinderFavAnimUIC)this;
      ((FinderFavAnimUIC)localObject).tlT = new WeImageView((Context)((FinderFavAnimUIC)localObject).getActivity());
      localObject = z.Nhr;
    }
    Object localObject = this.tlT;
    if (localObject != null)
    {
      ((WeImageView)localObject).setImageResource(2131691595);
      ((WeImageView)localObject).setIconColor(getActivity().getResources().getColor(2131099830));
      this.tme.cancel();
      this.tmd.start();
      AppMethodBeat.o(206145);
      return;
    }
    AppMethodBeat.o(206145);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(y.c paramc1, y.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(206136);
      ImageView localImageView = jdField_this.tlS;
      if (localImageView != null)
      {
        p.g(paramValueAnimator, "anim");
        float f = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - FinderFavAnimUIC.a(jdField_this));
        localImageView.setScaleX(f);
        localImageView.setScaleY(f);
        localImageView.setTranslationX(FinderFavAnimUIC.b(jdField_this)[0] + (this.tmg.NiV - FinderFavAnimUIC.b(jdField_this)[0]) * paramValueAnimator.getAnimatedFraction());
        localImageView.setTranslationY(FinderFavAnimUIC.b(jdField_this)[1] + (localc1.NiV - FinderFavAnimUIC.b(jdField_this)[1]) * paramValueAnimator.getAnimatedFraction());
        AppMethodBeat.o(206136);
        return;
      }
      AppMethodBeat.o(206136);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(y.c paramc1, y.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(206138);
      paramAnimator = jdField_this.tlS;
      if (paramAnimator != null) {
        FinderFavAnimUIC.a(jdField_this, (View)paramAnimator);
      }
      FinderFavAnimUIC.e(jdField_this);
      AppMethodBeat.o(206138);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(206137);
      paramAnimator = jdField_this.tlS;
      if (paramAnimator != null)
      {
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
        FinderFavAnimUIC.a(jdField_this, (View)paramAnimator, localLayoutParams);
        paramAnimator.setVisibility(0);
        paramAnimator.setScaleX(1.0F);
        paramAnimator.setScaleY(1.0F);
        paramAnimator.setPivotY(0.0F);
        paramAnimator.setTranslationX(FinderFavAnimUIC.b(jdField_this)[0]);
        paramAnimator.setTranslationY(FinderFavAnimUIC.b(jdField_this)[1]);
        this.tmh.NiV = (FinderFavAnimUIC.c(jdField_this).top + (FinderFavAnimUIC.c(jdField_this).height() - FinderFavAnimUIC.d(jdField_this)) / 2.0F);
        localc2.NiV = (FinderFavAnimUIC.c(jdField_this).left + (FinderFavAnimUIC.c(jdField_this).width() - FinderFavAnimUIC.d(jdField_this)) / 2.0F);
        AppMethodBeat.o(206137);
        return;
      }
      AppMethodBeat.o(206137);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$1"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(206139);
      WeImageView localWeImageView = this.tmi.tlT;
      if (localWeImageView != null)
      {
        p.g(paramValueAnimator, "anim");
        float f1 = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - FinderFavAnimUIC.f(this.tmi) / FinderFavAnimUIC.g(this.tmi));
        localWeImageView.setScaleX(f1);
        localWeImageView.setScaleY(f1);
        float f2 = FinderFavAnimUIC.c(this.tmi).left;
        localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
        AppMethodBeat.o(206139);
        return;
      }
      AppMethodBeat.o(206139);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(206141);
      FinderFavAnimUIC.h(this.tmi).start();
      AppMethodBeat.o(206141);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(206140);
      paramAnimator = this.tmi.tlT;
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(0);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(FinderFavAnimUIC.g(this.tmi), FinderFavAnimUIC.g(this.tmi));
        FinderFavAnimUIC.a(this.tmi, (View)paramAnimator, localLayoutParams);
        paramAnimator.setScaleX(1.0F);
        paramAnimator.setScaleY(1.0F);
        paramAnimator.setPivotY(0.0F);
        paramAnimator.setAlpha(1.0F);
        paramAnimator.setTranslationX(FinderFavAnimUIC.c(this.tmi).left);
        paramAnimator.setTranslationY(FinderFavAnimUIC.c(this.tmi).top);
        AppMethodBeat.o(206140);
        return;
      }
      AppMethodBeat.o(206140);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$1"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(y.c paramc1, y.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(206142);
      WeImageView localWeImageView = jdField_this.tlT;
      if (localWeImageView != null)
      {
        p.g(paramValueAnimator, "anim");
        if (paramValueAnimator.getAnimatedFraction() <= 0.5F)
        {
          float f1 = this.tmj.NiV - paramValueAnimator.getAnimatedFraction() * 2.0F * (this.tmj.NiV - FinderFavAnimUIC.i(jdField_this) / FinderFavAnimUIC.g(jdField_this));
          localWeImageView.setScaleX(f1);
          localWeImageView.setScaleY(f1);
          localWeImageView.setTranslationY(localc2.NiV + paramValueAnimator.getAnimatedFraction() * FinderFavAnimUIC.f(jdField_this) * 2.0F);
          float f2 = FinderFavAnimUIC.c(jdField_this).left;
          localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
        }
        localWeImageView.setAlpha(1.0F - paramValueAnimator.getAnimatedFraction());
        AppMethodBeat.o(206142);
        return;
      }
      AppMethodBeat.o(206142);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(y.c paramc1, y.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(206144);
      paramAnimator = jdField_this.tlT;
      if (paramAnimator != null)
      {
        FinderFavAnimUIC.a(jdField_this, (View)paramAnimator);
        AppMethodBeat.o(206144);
        return;
      }
      AppMethodBeat.o(206144);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(206143);
      paramAnimator = jdField_this.tlT;
      if (paramAnimator != null)
      {
        this.tmj.NiV = paramAnimator.getScaleX();
        localc2.NiV = paramAnimator.getTranslationY();
        AppMethodBeat.o(206143);
        return;
      }
      AppMethodBeat.o(206143);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFavAnimUIC
 * JD-Core Version:    0.7.0.1
 */