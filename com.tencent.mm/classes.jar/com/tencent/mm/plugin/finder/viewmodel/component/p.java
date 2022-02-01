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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.aa.c;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "imageAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "imageFinalSize", "", "interpolator", "Landroid/view/animation/LinearInterpolator;", "pictureAnimIv", "Landroid/widget/ImageView;", "getPictureAnimIv", "()Landroid/widget/ImageView;", "setPictureAnimIv", "(Landroid/widget/ImageView;)V", "scaleRatio", "", "starAnimIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStarAnimIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setStarAnimIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "starDownAnimator", "starFinalSize", "starMiddleSize", "starOriginalSize", "starUpAnimator", "startLocation", "", "targetRect", "Landroid/graphics/Rect;", "addViewToDecor", "", "child", "Landroid/view/View;", "isAdd", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "animFav", "bitmap", "Landroid/graphics/Bitmap;", "startViewLocation", "animFrameImage", "animStar", "Companion", "plugin-finder_release"})
public final class p
  extends UIComponent
{
  public static final p.g BjK;
  private final int BjA;
  private final int BjB;
  private final int BjC;
  public float BjD;
  public final Rect BjE;
  public int[] BjF;
  private final LinearInterpolator BjG;
  public final ValueAnimator BjH;
  private final ValueAnimator BjI;
  private final ValueAnimator BjJ;
  public ImageView Bjx;
  WeImageView Bjy;
  public final int Bjz;
  
  static
  {
    AppMethodBeat.i(289083);
    BjK = new p.g((byte)0);
    AppMethodBeat.o(289083);
  }
  
  public p(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(289082);
    this.Bjz = paramAppCompatActivity.getResources().getDimensionPixelSize(b.d.Edge_2A);
    this.BjA = paramAppCompatActivity.getResources().getDimensionPixelSize(b.d.Edge_5A);
    this.BjB = paramAppCompatActivity.getResources().getDimensionPixelSize(b.d.Edge_2A);
    this.BjC = paramAppCompatActivity.getResources().getDimensionPixelSize(b.d.Edge_A);
    this.BjD = 1.0F;
    this.BjE = new Rect();
    this.BjG = new LinearInterpolator();
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    kotlin.g.b.p.j(paramAppCompatActivity, "it");
    paramAppCompatActivity.setInterpolator((TimeInterpolator)this.BjG);
    paramAppCompatActivity.setDuration(400L);
    final aa.c localc1 = new aa.c();
    localc1.aaBz = 0.0F;
    final aa.c localc2 = new aa.c();
    localc2.aaBz = 0.0F;
    paramAppCompatActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(localc2, localc1, this));
    paramAppCompatActivity.addListener((Animator.AnimatorListener)new b(localc1, localc2, this));
    this.BjH = paramAppCompatActivity;
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    kotlin.g.b.p.j(paramAppCompatActivity, "it");
    paramAppCompatActivity.setDuration(150L);
    paramAppCompatActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
    paramAppCompatActivity.addListener((Animator.AnimatorListener)new d(this));
    this.BjI = paramAppCompatActivity;
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    kotlin.g.b.p.j(paramAppCompatActivity, "it");
    paramAppCompatActivity.setDuration(300L);
    paramAppCompatActivity.setInterpolator((TimeInterpolator)this.BjG);
    localc1 = new aa.c();
    localc1.aaBz = 0.0F;
    localc2 = new aa.c();
    localc2.aaBz = 0.0F;
    paramAppCompatActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(localc1, localc2, this));
    paramAppCompatActivity.addListener((Animator.AnimatorListener)new f(localc1, localc2, this));
    this.BjJ = paramAppCompatActivity;
    AppMethodBeat.o(289082);
  }
  
  private final void a(View paramView, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(289080);
    if (paramBoolean)
    {
      if (paramView.getParent() != null)
      {
        Log.i("FinderFavAnimUIC", "addViewToDecor: view already has parent view");
        localObject = getActivity().getWindow();
        kotlin.g.b.p.j(localObject, "activity.window");
        localObject = ((Window)localObject).getDecorView();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(289080);
          throw paramView;
        }
        ((ViewGroup)localObject).removeView(paramView);
      }
      Object localObject = getActivity().getWindow();
      kotlin.g.b.p.j(localObject, "activity.window");
      localObject = ((Window)localObject).getDecorView();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(289080);
        throw paramView;
      }
      ((ViewGroup)localObject).addView(paramView, paramLayoutParams);
      AppMethodBeat.o(289080);
      return;
    }
    paramLayoutParams = getActivity().getWindow();
    kotlin.g.b.p.j(paramLayoutParams, "activity.window");
    paramLayoutParams = paramLayoutParams.getDecorView();
    if (paramLayoutParams == null)
    {
      paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(289080);
      throw paramView;
    }
    ((ViewGroup)paramLayoutParams).removeView(paramView);
    AppMethodBeat.o(289080);
  }
  
  public final void ekx()
  {
    AppMethodBeat.i(289079);
    Log.i("FinderFavAnimUIC", "[animStar]");
    if (this.Bjy == null)
    {
      localObject = (p)this;
      ((p)localObject).Bjy = new WeImageView((Context)((p)localObject).getActivity());
      localObject = x.aazN;
    }
    Object localObject = this.Bjy;
    if (localObject != null)
    {
      ((WeImageView)localObject).setImageResource(b.i.finder_fav_anim_start);
      ((WeImageView)localObject).setIconColor(getActivity().getResources().getColor(b.c.Yellow_100));
      this.BjJ.cancel();
      this.BjI.start();
      AppMethodBeat.o(289079);
      return;
    }
    AppMethodBeat.o(289079);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(aa.c paramc1, aa.c paramc2, p paramp) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(286124);
      ImageView localImageView = jdField_this.Bjx;
      if (localImageView != null)
      {
        kotlin.g.b.p.j(paramValueAnimator, "anim");
        float f = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - p.a(jdField_this));
        localImageView.setScaleX(f);
        localImageView.setScaleY(f);
        localImageView.setTranslationX(p.b(jdField_this)[0] + (this.BjL.aaBz - p.b(jdField_this)[0]) * paramValueAnimator.getAnimatedFraction());
        localImageView.setTranslationY(p.b(jdField_this)[1] + (localc1.aaBz - p.b(jdField_this)[1]) * paramValueAnimator.getAnimatedFraction());
        AppMethodBeat.o(286124);
        return;
      }
      AppMethodBeat.o(286124);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(aa.c paramc1, aa.c paramc2, p paramp) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(274914);
      paramAnimator = jdField_this.Bjx;
      if (paramAnimator != null) {
        p.a(jdField_this, (View)paramAnimator);
      }
      p.e(jdField_this);
      AppMethodBeat.o(274914);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(274913);
      paramAnimator = jdField_this.Bjx;
      if (paramAnimator != null)
      {
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
        p.a(jdField_this, (View)paramAnimator, localLayoutParams);
        paramAnimator.setVisibility(0);
        paramAnimator.setScaleX(1.0F);
        paramAnimator.setScaleY(1.0F);
        paramAnimator.setPivotY(0.0F);
        paramAnimator.setTranslationX(p.b(jdField_this)[0]);
        paramAnimator.setTranslationY(p.b(jdField_this)[1]);
        this.BjM.aaBz = (p.c(jdField_this).top + (p.c(jdField_this).height() - p.d(jdField_this)) / 2.0F);
        localc2.aaBz = (p.c(jdField_this).left + (p.c(jdField_this).width() - p.d(jdField_this)) / 2.0F);
        AppMethodBeat.o(274913);
        return;
      }
      AppMethodBeat.o(274913);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$1"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(p paramp) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(286237);
      WeImageView localWeImageView = this.BjN.Bjy;
      if (localWeImageView != null)
      {
        kotlin.g.b.p.j(paramValueAnimator, "anim");
        float f1 = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - p.f(this.BjN) / p.g(this.BjN));
        localWeImageView.setScaleX(f1);
        localWeImageView.setScaleY(f1);
        float f2 = p.c(this.BjN).left;
        localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
        AppMethodBeat.o(286237);
        return;
      }
      AppMethodBeat.o(286237);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(p paramp) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(291915);
      p.h(this.BjN).start();
      AppMethodBeat.o(291915);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(291913);
      paramAnimator = this.BjN.Bjy;
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(0);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(p.g(this.BjN), p.g(this.BjN));
        p.a(this.BjN, (View)paramAnimator, localLayoutParams);
        paramAnimator.setScaleX(1.0F);
        paramAnimator.setScaleY(1.0F);
        paramAnimator.setPivotY(0.0F);
        paramAnimator.setAlpha(1.0F);
        paramAnimator.setTranslationX(p.c(this.BjN).left);
        paramAnimator.setTranslationY(p.c(this.BjN).top);
        AppMethodBeat.o(291913);
        return;
      }
      AppMethodBeat.o(291913);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$1"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(aa.c paramc1, aa.c paramc2, p paramp) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(285450);
      WeImageView localWeImageView = jdField_this.Bjy;
      if (localWeImageView != null)
      {
        kotlin.g.b.p.j(paramValueAnimator, "anim");
        if (paramValueAnimator.getAnimatedFraction() <= 0.5F)
        {
          float f1 = this.BjO.aaBz - paramValueAnimator.getAnimatedFraction() * 2.0F * (this.BjO.aaBz - p.i(jdField_this) / p.g(jdField_this));
          localWeImageView.setScaleX(f1);
          localWeImageView.setScaleY(f1);
          localWeImageView.setTranslationY(localc2.aaBz + paramValueAnimator.getAnimatedFraction() * p.f(jdField_this) * 2.0F);
          float f2 = p.c(jdField_this).left;
          localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
        }
        localWeImageView.setAlpha(1.0F - paramValueAnimator.getAnimatedFraction());
        AppMethodBeat.o(285450);
        return;
      }
      AppMethodBeat.o(285450);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(aa.c paramc1, aa.c paramc2, p paramp) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(277972);
      paramAnimator = jdField_this.Bjy;
      if (paramAnimator != null)
      {
        p.a(jdField_this, (View)paramAnimator);
        AppMethodBeat.o(277972);
        return;
      }
      AppMethodBeat.o(277972);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(277971);
      paramAnimator = jdField_this.Bjy;
      if (paramAnimator != null)
      {
        this.BjO.aaBz = paramAnimator.getScaleX();
        localc2.aaBz = paramAnimator.getTranslationY();
        AppMethodBeat.o(277971);
        return;
      }
      AppMethodBeat.o(277971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.p
 * JD-Core Version:    0.7.0.1
 */