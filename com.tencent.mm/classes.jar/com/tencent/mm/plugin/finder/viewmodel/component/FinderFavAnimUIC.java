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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.g.b.y.c;
import d.l;
import d.v;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "imageAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "imageFinalSize", "", "interpolator", "Landroid/view/animation/LinearInterpolator;", "pictureAnimIv", "Landroid/widget/ImageView;", "getPictureAnimIv", "()Landroid/widget/ImageView;", "setPictureAnimIv", "(Landroid/widget/ImageView;)V", "scaleRatio", "", "starAnimIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStarAnimIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setStarAnimIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "starDownAnimator", "starFinalSize", "starMiddleSize", "starOriginalSize", "starUpAnimator", "startLocation", "", "targetRect", "Landroid/graphics/Rect;", "addViewToDecor", "", "child", "Landroid/view/View;", "isAdd", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "animFav", "bitmap", "Landroid/graphics/Bitmap;", "startViewLocation", "animFrameImage", "animStar", "Companion", "plugin-finder_release"})
public final class FinderFavAnimUIC
  extends UIComponent
{
  public static final FinderFavAnimUIC.g tbq;
  public ImageView tbd;
  WeImageView tbe;
  public final int tbf;
  private final int tbg;
  private final int tbh;
  private final int tbi;
  public float tbj;
  public final Rect tbk;
  public int[] tbl;
  private final LinearInterpolator tbm;
  public final ValueAnimator tbn;
  private final ValueAnimator tbo;
  private final ValueAnimator tbp;
  
  static
  {
    AppMethodBeat.i(205539);
    tbq = new FinderFavAnimUIC.g((byte)0);
    AppMethodBeat.o(205539);
  }
  
  public FinderFavAnimUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205538);
    this.tbf = paramMMActivity.getResources().getDimensionPixelSize(2131165289);
    this.tbg = paramMMActivity.getResources().getDimensionPixelSize(2131165296);
    this.tbh = paramMMActivity.getResources().getDimensionPixelSize(2131165289);
    this.tbi = paramMMActivity.getResources().getDimensionPixelSize(2131165303);
    this.tbj = 1.0F;
    this.tbk = new Rect();
    this.tbm = new LinearInterpolator();
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramMMActivity, "it");
    paramMMActivity.setInterpolator((TimeInterpolator)this.tbm);
    paramMMActivity.setDuration(400L);
    final y.c localc1 = new y.c();
    localc1.MLS = 0.0F;
    final y.c localc2 = new y.c();
    localc2.MLS = 0.0F;
    paramMMActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(localc2, localc1, this));
    paramMMActivity.addListener((Animator.AnimatorListener)new b(localc1, localc2, this));
    this.tbn = paramMMActivity;
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramMMActivity, "it");
    paramMMActivity.setDuration(150L);
    paramMMActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this));
    paramMMActivity.addListener((Animator.AnimatorListener)new d(this));
    this.tbo = paramMMActivity;
    paramMMActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    p.g(paramMMActivity, "it");
    paramMMActivity.setDuration(300L);
    paramMMActivity.setInterpolator((TimeInterpolator)this.tbm);
    localc1 = new y.c();
    localc1.MLS = 0.0F;
    localc2 = new y.c();
    localc2.MLS = 0.0F;
    paramMMActivity.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new e(localc1, localc2, this));
    paramMMActivity.addListener((Animator.AnimatorListener)new f(localc1, localc2, this));
    this.tbp = paramMMActivity;
    AppMethodBeat.o(205538);
  }
  
  private final void a(View paramView, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(205536);
    if (paramBoolean)
    {
      if (paramView.getParent() != null)
      {
        ad.i("FinderFavAnimUIC", "addViewToDecor: view already has parent view");
        localObject = getActivity().getWindow();
        p.g(localObject, "activity.window");
        localObject = ((Window)localObject).getDecorView();
        if (localObject == null)
        {
          paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(205536);
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
        AppMethodBeat.o(205536);
        throw paramView;
      }
      ((ViewGroup)localObject).addView(paramView, paramLayoutParams);
      AppMethodBeat.o(205536);
      return;
    }
    paramLayoutParams = getActivity().getWindow();
    p.g(paramLayoutParams, "activity.window");
    paramLayoutParams = paramLayoutParams.getDecorView();
    if (paramLayoutParams == null)
    {
      paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(205536);
      throw paramView;
    }
    ((ViewGroup)paramLayoutParams).removeView(paramView);
    AppMethodBeat.o(205536);
  }
  
  public final void cOn()
  {
    AppMethodBeat.i(205535);
    ad.i("FinderFavAnimUIC", "[animStar]");
    if (this.tbe == null)
    {
      localObject = (FinderFavAnimUIC)this;
      ((FinderFavAnimUIC)localObject).tbe = new WeImageView((Context)((FinderFavAnimUIC)localObject).getActivity());
      localObject = z.MKo;
    }
    Object localObject = this.tbe;
    if (localObject != null)
    {
      ((WeImageView)localObject).setImageResource(2131691595);
      ((WeImageView)localObject).setIconColor(getActivity().getResources().getColor(2131099830));
      this.tbp.cancel();
      this.tbo.start();
      AppMethodBeat.o(205535);
      return;
    }
    AppMethodBeat.o(205535);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(y.c paramc1, y.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(205526);
      ImageView localImageView = jdField_this.tbd;
      if (localImageView != null)
      {
        p.g(paramValueAnimator, "anim");
        float f = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - FinderFavAnimUIC.a(jdField_this));
        localImageView.setScaleX(f);
        localImageView.setScaleY(f);
        localImageView.setTranslationX(FinderFavAnimUIC.b(jdField_this)[0] + (this.tbr.MLS - FinderFavAnimUIC.b(jdField_this)[0]) * paramValueAnimator.getAnimatedFraction());
        localImageView.setTranslationY(FinderFavAnimUIC.b(jdField_this)[1] + (localc1.MLS - FinderFavAnimUIC.b(jdField_this)[1]) * paramValueAnimator.getAnimatedFraction());
        AppMethodBeat.o(205526);
        return;
      }
      AppMethodBeat.o(205526);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(y.c paramc1, y.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(205528);
      paramAnimator = jdField_this.tbd;
      if (paramAnimator != null) {
        FinderFavAnimUIC.a(jdField_this, (View)paramAnimator);
      }
      FinderFavAnimUIC.e(jdField_this);
      AppMethodBeat.o(205528);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(205527);
      paramAnimator = jdField_this.tbd;
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
        this.tbs.MLS = (FinderFavAnimUIC.c(jdField_this).top + (FinderFavAnimUIC.c(jdField_this).height() - FinderFavAnimUIC.d(jdField_this)) / 2.0F);
        localc2.MLS = (FinderFavAnimUIC.c(jdField_this).left + (FinderFavAnimUIC.c(jdField_this).width() - FinderFavAnimUIC.d(jdField_this)) / 2.0F);
        AppMethodBeat.o(205527);
        return;
      }
      AppMethodBeat.o(205527);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$1"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(205529);
      WeImageView localWeImageView = this.tbt.tbe;
      if (localWeImageView != null)
      {
        p.g(paramValueAnimator, "anim");
        float f1 = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - FinderFavAnimUIC.f(this.tbt) / FinderFavAnimUIC.g(this.tbt));
        localWeImageView.setScaleX(f1);
        localWeImageView.setScaleY(f1);
        float f2 = FinderFavAnimUIC.c(this.tbt).left;
        localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
        AppMethodBeat.o(205529);
        return;
      }
      AppMethodBeat.o(205529);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(205531);
      FinderFavAnimUIC.h(this.tbt).start();
      AppMethodBeat.o(205531);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(205530);
      paramAnimator = this.tbt.tbe;
      if (paramAnimator != null)
      {
        paramAnimator.setVisibility(0);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(FinderFavAnimUIC.g(this.tbt), FinderFavAnimUIC.g(this.tbt));
        FinderFavAnimUIC.a(this.tbt, (View)paramAnimator, localLayoutParams);
        paramAnimator.setScaleX(1.0F);
        paramAnimator.setScaleY(1.0F);
        paramAnimator.setPivotY(0.0F);
        paramAnimator.setAlpha(1.0F);
        paramAnimator.setTranslationX(FinderFavAnimUIC.c(this.tbt).left);
        paramAnimator.setTranslationY(FinderFavAnimUIC.c(this.tbt).top);
        AppMethodBeat.o(205530);
        return;
      }
      AppMethodBeat.o(205530);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "anim", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$1"})
  static final class e
    implements ValueAnimator.AnimatorUpdateListener
  {
    e(y.c paramc1, y.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(205532);
      WeImageView localWeImageView = jdField_this.tbe;
      if (localWeImageView != null)
      {
        p.g(paramValueAnimator, "anim");
        if (paramValueAnimator.getAnimatedFraction() <= 0.5F)
        {
          float f1 = this.tbu.MLS - paramValueAnimator.getAnimatedFraction() * 2.0F * (this.tbu.MLS - FinderFavAnimUIC.i(jdField_this) / FinderFavAnimUIC.g(jdField_this));
          localWeImageView.setScaleX(f1);
          localWeImageView.setScaleY(f1);
          localWeImageView.setTranslationY(localc2.MLS + paramValueAnimator.getAnimatedFraction() * FinderFavAnimUIC.f(jdField_this) * 2.0F);
          float f2 = FinderFavAnimUIC.c(jdField_this).left;
          localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
        }
        localWeImageView.setAlpha(1.0F - paramValueAnimator.getAnimatedFraction());
        AppMethodBeat.o(205532);
        return;
      }
      AppMethodBeat.o(205532);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"})
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(y.c paramc1, y.c paramc2, FinderFavAnimUIC paramFinderFavAnimUIC) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(205534);
      paramAnimator = jdField_this.tbe;
      if (paramAnimator != null)
      {
        FinderFavAnimUIC.a(jdField_this, (View)paramAnimator);
        AppMethodBeat.o(205534);
        return;
      }
      AppMethodBeat.o(205534);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(205533);
      paramAnimator = jdField_this.tbe;
      if (paramAnimator != null)
      {
        this.tbu.MLS = paramAnimator.getScaleX();
        localc2.MLS = paramAnimator.getTranslationY();
        AppMethodBeat.o(205533);
        return;
      }
      AppMethodBeat.o(205533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderFavAnimUIC
 * JD-Core Version:    0.7.0.1
 */