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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.z.c;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "imageAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "imageFinalSize", "", "interpolator", "Landroid/view/animation/LinearInterpolator;", "pictureAnimIv", "Landroid/widget/ImageView;", "getPictureAnimIv", "()Landroid/widget/ImageView;", "setPictureAnimIv", "(Landroid/widget/ImageView;)V", "scaleRatio", "", "starAnimIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStarAnimIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setStarAnimIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "starDownAnimator", "starFinalSize", "starMiddleSize", "starOriginalSize", "starUpAnimator", "startLocation", "", "targetRect", "Landroid/graphics/Rect;", "addViewToDecor", "", "child", "Landroid/view/View;", "isAdd", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "animFav", "bitmap", "Landroid/graphics/Bitmap;", "startViewLocation", "animFrameImage", "animStar", "Companion", "plugin-finder_release"})
public final class FinderFavAnimUIC
  extends UIComponent
{
  public static final FinderFavAnimUIC.g wvS;
  public ImageView wvF;
  WeImageView wvG;
  public final int wvH;
  private final int wvI;
  private final int wvJ;
  private final int wvK;
  public float wvL;
  public final Rect wvM;
  public int[] wvN;
  private final LinearInterpolator wvO;
  public final ValueAnimator wvP;
  private final ValueAnimator wvQ;
  private final ValueAnimator wvR;
  
  static
  {
    AppMethodBeat.i(255478);
    wvS = new FinderFavAnimUIC.g((byte)0);
    AppMethodBeat.o(255478);
  }
  
  public FinderFavAnimUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(255477);
    this.wvH = paramAppCompatActivity.getResources().getDimensionPixelSize(2131165296);
    this.wvI = paramAppCompatActivity.getResources().getDimensionPixelSize(2131165306);
    this.wvJ = paramAppCompatActivity.getResources().getDimensionPixelSize(2131165296);
    this.wvK = paramAppCompatActivity.getResources().getDimensionPixelSize(2131165314);
    this.wvL = 1.0F;
    this.wvM = new Rect();
    this.wvO = new LinearInterpolator();
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramAppCompatActivity, "it");
    paramAppCompatActivity.setInterpolator((TimeInterpolator)this.wvO);
    paramAppCompatActivity.setDuration(400L);
    final z.c localc1 = new z.c();
    localc1.SYD = 0.0F;
    final z.c localc2 = new z.c();
    localc2.SYD = 0.0F;
    paramAppCompatActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(localc2, localc1, this));
    paramAppCompatActivity.addListener((Animator.AnimatorListener)new b(localc1, localc2, this));
    this.wvP = paramAppCompatActivity;
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramAppCompatActivity, "it");
    paramAppCompatActivity.setDuration(150L);
    paramAppCompatActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
    paramAppCompatActivity.addListener((Animator.AnimatorListener)new d(this));
    this.wvQ = paramAppCompatActivity;
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramAppCompatActivity, "it");
    paramAppCompatActivity.setDuration(300L);
    paramAppCompatActivity.setInterpolator((TimeInterpolator)this.wvO);
    localc1 = new z.c();
    localc1.SYD = 0.0F;
    localc2 = new z.c();
    localc2.SYD = 0.0F;
    paramAppCompatActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(localc1, localc2, this));
    paramAppCompatActivity.addListener((Animator.AnimatorListener)new f(localc1, localc2, this));
    this.wvR = paramAppCompatActivity;
    AppMethodBeat.o(255477);
  }
  
  private final void a(View paramView, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(255475);
    if (paramBoolean)
    {
      if (paramView.getParent() != null)
      {
        Log.i("FinderFavAnimUIC", "addViewToDecor: view already has parent view");
        localObject = getActivity().getWindow();
        p.g(localObject, "activity.window");
        localObject = ((Window)localObject).getDecorView();
        if (localObject == null)
        {
          paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(255475);
          throw paramView;
        }
        ((ViewGroup)localObject).removeView(paramView);
      }
      Object localObject = getActivity().getWindow();
      p.g(localObject, "activity.window");
      localObject = ((Window)localObject).getDecorView();
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(255475);
        throw paramView;
      }
      ((ViewGroup)localObject).addView(paramView, paramLayoutParams);
      AppMethodBeat.o(255475);
      return;
    }
    paramLayoutParams = getActivity().getWindow();
    p.g(paramLayoutParams, "activity.window");
    paramLayoutParams = paramLayoutParams.getDecorView();
    if (paramLayoutParams == null)
    {
      paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(255475);
      throw paramView;
    }
    ((ViewGroup)paramLayoutParams).removeView(paramView);
    AppMethodBeat.o(255475);
  }
  
  public final void dIa()
  {
    AppMethodBeat.i(255474);
    Log.i("FinderFavAnimUIC", "[animStar]");
    if (this.wvG == null)
    {
      localObject = (FinderFavAnimUIC)this;
      ((FinderFavAnimUIC)localObject).wvG = new WeImageView((Context)((FinderFavAnimUIC)localObject).getActivity());
      localObject = x.SXb;
    }
    Object localObject = this.wvG;
    if (localObject != null)
    {
      ((WeImageView)localObject).setImageResource(2131690231);
      ((WeImageView)localObject).setIconColor(getActivity().getResources().getColor(2131099847));
      this.wvR.cancel();
      this.wvQ.start();
      AppMethodBeat.o(255474);
      return;
    }
    AppMethodBeat.o(255474);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(z.c paramc1, z.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(255465);
      ImageView localImageView = jdField_this.wvF;
      if (localImageView != null)
      {
        p.g(paramValueAnimator, "anim");
        float f = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - FinderFavAnimUIC.a(jdField_this));
        localImageView.setScaleX(f);
        localImageView.setScaleY(f);
        localImageView.setTranslationX(FinderFavAnimUIC.b(jdField_this)[0] + (this.wvT.SYD - FinderFavAnimUIC.b(jdField_this)[0]) * paramValueAnimator.getAnimatedFraction());
        localImageView.setTranslationY(FinderFavAnimUIC.b(jdField_this)[1] + (localc1.SYD - FinderFavAnimUIC.b(jdField_this)[1]) * paramValueAnimator.getAnimatedFraction());
        AppMethodBeat.o(255465);
        return;
      }
      AppMethodBeat.o(255465);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(z.c paramc1, z.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(255467);
      paramAnimator = jdField_this.wvF;
      if (paramAnimator != null) {
        FinderFavAnimUIC.a(jdField_this, (View)paramAnimator);
      }
      FinderFavAnimUIC.e(jdField_this);
      AppMethodBeat.o(255467);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(255466);
      paramAnimator = jdField_this.wvF;
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
        this.wvU.SYD = (FinderFavAnimUIC.c(jdField_this).top + (FinderFavAnimUIC.c(jdField_this).height() - FinderFavAnimUIC.d(jdField_this)) / 2.0F);
        localc2.SYD = (FinderFavAnimUIC.c(jdField_this).left + (FinderFavAnimUIC.c(jdField_this).width() - FinderFavAnimUIC.d(jdField_this)) / 2.0F);
        AppMethodBeat.o(255466);
        return;
      }
      AppMethodBeat.o(255466);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$1"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(255468);
      WeImageView localWeImageView = this.wvV.wvG;
      if (localWeImageView != null)
      {
        p.g(paramValueAnimator, "anim");
        float f1 = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - FinderFavAnimUIC.f(this.wvV) / FinderFavAnimUIC.g(this.wvV));
        localWeImageView.setScaleX(f1);
        localWeImageView.setScaleY(f1);
        float f2 = FinderFavAnimUIC.c(this.wvV).left;
        localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
        AppMethodBeat.o(255468);
        return;
      }
      AppMethodBeat.o(255468);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(255470);
      FinderFavAnimUIC.h(this.wvV).start();
      AppMethodBeat.o(255470);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(255469);
      paramAnimator = this.wvV.wvG;
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(0);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(FinderFavAnimUIC.g(this.wvV), FinderFavAnimUIC.g(this.wvV));
        FinderFavAnimUIC.a(this.wvV, (View)paramAnimator, localLayoutParams);
        paramAnimator.setScaleX(1.0F);
        paramAnimator.setScaleY(1.0F);
        paramAnimator.setPivotY(0.0F);
        paramAnimator.setAlpha(1.0F);
        paramAnimator.setTranslationX(FinderFavAnimUIC.c(this.wvV).left);
        paramAnimator.setTranslationY(FinderFavAnimUIC.c(this.wvV).top);
        AppMethodBeat.o(255469);
        return;
      }
      AppMethodBeat.o(255469);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$1"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(z.c paramc1, z.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(255471);
      WeImageView localWeImageView = jdField_this.wvG;
      if (localWeImageView != null)
      {
        p.g(paramValueAnimator, "anim");
        if (paramValueAnimator.getAnimatedFraction() <= 0.5F)
        {
          float f1 = this.wvW.SYD - paramValueAnimator.getAnimatedFraction() * 2.0F * (this.wvW.SYD - FinderFavAnimUIC.i(jdField_this) / FinderFavAnimUIC.g(jdField_this));
          localWeImageView.setScaleX(f1);
          localWeImageView.setScaleY(f1);
          localWeImageView.setTranslationY(localc2.SYD + paramValueAnimator.getAnimatedFraction() * FinderFavAnimUIC.f(jdField_this) * 2.0F);
          float f2 = FinderFavAnimUIC.c(jdField_this).left;
          localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
        }
        localWeImageView.setAlpha(1.0F - paramValueAnimator.getAnimatedFraction());
        AppMethodBeat.o(255471);
        return;
      }
      AppMethodBeat.o(255471);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(z.c paramc1, z.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(255473);
      paramAnimator = jdField_this.wvG;
      if (paramAnimator != null)
      {
        FinderFavAnimUIC.a(jdField_this, (View)paramAnimator);
        AppMethodBeat.o(255473);
        return;
      }
      AppMethodBeat.o(255473);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(255472);
      paramAnimator = jdField_this.wvG;
      if (paramAnimator != null)
      {
        this.wvW.SYD = paramAnimator.getScaleX();
        localc2.SYD = paramAnimator.getTranslationY();
        AppMethodBeat.o(255472);
        return;
      }
      AppMethodBeat.o(255472);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFavAnimUIC
 * JD-Core Version:    0.7.0.1
 */