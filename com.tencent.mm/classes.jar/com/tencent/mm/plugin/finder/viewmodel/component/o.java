package com.tencent.mm.plugin.finder.viewmodel.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
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
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.g.b.ah.c;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "imageAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "imageFinalSize", "", "interpolator", "Landroid/view/animation/LinearInterpolator;", "pictureAnimIv", "Landroid/widget/ImageView;", "getPictureAnimIv", "()Landroid/widget/ImageView;", "setPictureAnimIv", "(Landroid/widget/ImageView;)V", "scaleRatio", "", "starAnimIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getStarAnimIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setStarAnimIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "starDownAnimator", "starFinalSize", "starMiddleSize", "starOriginalSize", "starUpAnimator", "startLocation", "", "targetRect", "Landroid/graphics/Rect;", "addViewToDecor", "", "child", "Landroid/view/View;", "isAdd", "", "params", "Landroid/view/ViewGroup$LayoutParams;", "animFav", "bitmap", "Landroid/graphics/Bitmap;", "startViewLocation", "animFrameImage", "animStar", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends UIComponent
{
  public static final o.a GOK;
  public final Rect CCC;
  public float EHT;
  public ImageView GOL;
  WeImageView GOM;
  public final int GON;
  private final int GOO;
  private final int GOP;
  private final int GOQ;
  public int[] GOR;
  private final LinearInterpolator GOS;
  public final ValueAnimator GOT;
  private final ValueAnimator GOU;
  private final ValueAnimator GOV;
  
  static
  {
    AppMethodBeat.i(337833);
    GOK = new o.a((byte)0);
    AppMethodBeat.o(337833);
  }
  
  public o(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(337723);
    this.GON = paramAppCompatActivity.getResources().getDimensionPixelSize(e.c.Edge_2A);
    this.GOO = paramAppCompatActivity.getResources().getDimensionPixelSize(e.c.Edge_5A);
    this.GOP = paramAppCompatActivity.getResources().getDimensionPixelSize(e.c.Edge_2A);
    this.GOQ = paramAppCompatActivity.getResources().getDimensionPixelSize(e.c.Edge_A);
    this.EHT = 1.0F;
    this.CCC = new Rect();
    this.GOS = new LinearInterpolator();
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramAppCompatActivity.setInterpolator((TimeInterpolator)this.GOS);
    paramAppCompatActivity.setDuration(400L);
    final ah.c localc1 = new ah.c();
    final ah.c localc2 = new ah.c();
    paramAppCompatActivity.addUpdateListener(new o..ExternalSyntheticLambda1(this, localc2, localc1));
    paramAppCompatActivity.addListener((Animator.AnimatorListener)new b(this, localc1, localc2));
    this.GOT = paramAppCompatActivity;
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramAppCompatActivity.setDuration(150L);
    paramAppCompatActivity.addUpdateListener(new o..ExternalSyntheticLambda0(this));
    paramAppCompatActivity.addListener((Animator.AnimatorListener)new d(this));
    this.GOU = paramAppCompatActivity;
    paramAppCompatActivity = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    paramAppCompatActivity.setDuration(300L);
    paramAppCompatActivity.setInterpolator((TimeInterpolator)this.GOS);
    localc1 = new ah.c();
    localc2 = new ah.c();
    paramAppCompatActivity.addUpdateListener(new o..ExternalSyntheticLambda2(this, localc1, localc2));
    paramAppCompatActivity.addListener((Animator.AnimatorListener)new c(this, localc1, localc2));
    this.GOV = paramAppCompatActivity;
    AppMethodBeat.o(337723);
  }
  
  private final void a(View paramView, boolean paramBoolean, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(337733);
    if (paramBoolean)
    {
      if (paramView.getParent() != null)
      {
        Log.i("FinderFavAnimUIC", "addViewToDecor: view already has parent view");
        ((ViewGroup)getActivity().getWindow().getDecorView()).removeView(paramView);
      }
      ((ViewGroup)getActivity().getWindow().getDecorView()).addView(paramView, paramLayoutParams);
      AppMethodBeat.o(337733);
      return;
    }
    ((ViewGroup)getActivity().getWindow().getDecorView()).removeView(paramView);
    AppMethodBeat.o(337733);
  }
  
  private static final void a(o paramo, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(337763);
    s.u(paramo, "this$0");
    WeImageView localWeImageView = paramo.GOM;
    if (localWeImageView != null)
    {
      float f1 = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - paramo.GOP / paramo.GOO);
      localWeImageView.setScaleX(f1);
      localWeImageView.setScaleY(f1);
      float f2 = paramo.CCC.left;
      localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
    }
    AppMethodBeat.o(337763);
  }
  
  private static final void a(o paramo, ah.c paramc1, ah.c paramc2, ValueAnimator paramValueAnimator)
  {
    Object localObject = null;
    AppMethodBeat.i(337757);
    s.u(paramo, "this$0");
    s.u(paramc1, "$destX");
    s.u(paramc2, "$destY");
    ImageView localImageView = paramo.GOL;
    float f1;
    float f2;
    if (localImageView != null)
    {
      f1 = 1.0F - paramValueAnimator.getAnimatedFraction() * (1.0F - paramo.EHT);
      localImageView.setScaleX(f1);
      localImageView.setScaleY(f1);
      int[] arrayOfInt2 = paramo.GOR;
      int[] arrayOfInt1 = arrayOfInt2;
      if (arrayOfInt2 == null)
      {
        s.bIx("startLocation");
        arrayOfInt1 = null;
      }
      f1 = arrayOfInt1[0];
      f2 = paramc1.aixa;
      arrayOfInt1 = paramo.GOR;
      paramc1 = arrayOfInt1;
      if (arrayOfInt1 == null)
      {
        s.bIx("startLocation");
        paramc1 = null;
      }
      localImageView.setTranslationX((f2 - paramc1[0]) * paramValueAnimator.getAnimatedFraction() + f1);
      arrayOfInt1 = paramo.GOR;
      paramc1 = arrayOfInt1;
      if (arrayOfInt1 == null)
      {
        s.bIx("startLocation");
        paramc1 = null;
      }
      f1 = paramc1[1];
      f2 = paramc2.aixa;
      paramo = paramo.GOR;
      if (paramo != null) {
        break label228;
      }
      s.bIx("startLocation");
      paramo = localObject;
    }
    label228:
    for (;;)
    {
      localImageView.setTranslationY((f2 - paramo[1]) * paramValueAnimator.getAnimatedFraction() + f1);
      AppMethodBeat.o(337757);
      return;
    }
  }
  
  private static final void b(o paramo, ah.c paramc1, ah.c paramc2, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(337777);
    s.u(paramo, "this$0");
    s.u(paramc1, "$startScale");
    s.u(paramc2, "$startTranslateY");
    WeImageView localWeImageView = paramo.GOM;
    if (localWeImageView != null)
    {
      if (paramValueAnimator.getAnimatedFraction() <= 0.5F)
      {
        float f1 = paramc1.aixa - paramValueAnimator.getAnimatedFraction() * 2.0F * (paramc1.aixa - paramo.GOQ / paramo.GOO);
        localWeImageView.setScaleX(f1);
        localWeImageView.setScaleY(f1);
        localWeImageView.setTranslationY(paramc2.aixa + paramValueAnimator.getAnimatedFraction() * paramo.GOP * 2.0F);
        float f2 = paramo.CCC.left;
        localWeImageView.setTranslationX((1.0F - f1) * localWeImageView.getWidth() / 2.0F + f2);
      }
      localWeImageView.setAlpha(1.0F - paramValueAnimator.getAnimatedFraction());
    }
    AppMethodBeat.o(337777);
  }
  
  public final void fnx()
  {
    AppMethodBeat.i(337862);
    Log.i("FinderFavAnimUIC", "[animStar]");
    if (this.GOM == null)
    {
      localObject = (o)this;
      ((o)localObject).GOM = new WeImageView((Context)((o)localObject).getActivity());
    }
    Object localObject = this.GOM;
    if (localObject != null)
    {
      ((WeImageView)localObject).setImageResource(e.g.finder_fav_anim_start);
      ((WeImageView)localObject).setIconColor(getActivity().getResources().getColor(e.b.Yellow_100));
      this.GOV.cancel();
      this.GOU.start();
    }
    AppMethodBeat.o(337862);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$imageAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(o paramo, ah.c paramc1, ah.c paramc2) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(338719);
      paramAnimator = this.GOW.GOL;
      if (paramAnimator != null) {
        o.a(this.GOW, (View)paramAnimator);
      }
      o.a(this.GOW);
      AppMethodBeat.o(338719);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      Object localObject = null;
      AppMethodBeat.i(338707);
      ImageView localImageView = this.GOW.GOL;
      o localo;
      ah.c localc1;
      ah.c localc2;
      if (localImageView != null)
      {
        localo = this.GOW;
        localc1 = localc1;
        localc2 = localc2;
        paramAnimator = new ViewGroup.LayoutParams(-1, -2);
        o.a(localo, (View)localImageView, paramAnimator);
        localImageView.setVisibility(0);
        localImageView.setScaleX(1.0F);
        localImageView.setScaleY(1.0F);
        localImageView.setPivotY(0.0F);
        int[] arrayOfInt = o.b(localo);
        paramAnimator = arrayOfInt;
        if (arrayOfInt == null)
        {
          s.bIx("startLocation");
          paramAnimator = null;
        }
        localImageView.setTranslationX(paramAnimator[0]);
        paramAnimator = o.b(localo);
        if (paramAnimator != null) {
          break label209;
        }
        s.bIx("startLocation");
        paramAnimator = localObject;
      }
      label209:
      for (;;)
      {
        localImageView.setTranslationY(paramAnimator[1]);
        localc1.aixa = (o.c(localo).top + (o.c(localo).height() - o.d(localo)) / 2.0F);
        localc2.aixa = (o.c(localo).left + (o.c(localo).width() - o.d(localo)) / 2.0F);
        AppMethodBeat.o(338707);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starDownAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(o paramo, ah.c paramc1, ah.c paramc2) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(338728);
      paramAnimator = this.GOW.GOM;
      if (paramAnimator != null) {
        o.a(this.GOW, (View)paramAnimator);
      }
      AppMethodBeat.o(338728);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(338711);
      paramAnimator = this.GOW.GOM;
      if (paramAnimator != null)
      {
        ah.c localc1 = localc1;
        ah.c localc2 = localc2;
        localc1.aixa = paramAnimator.getScaleX();
        localc2.aixa = paramAnimator.getTranslationY();
      }
      AppMethodBeat.o(338711);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderFavAnimUIC$starUpAnimator$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "isReverse", "", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(o paramo) {}
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(338746);
      o.e(this.GOW).start();
      AppMethodBeat.o(338746);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(338741);
      paramAnimator = this.GOW.GOM;
      if (paramAnimator != null)
      {
        o localo = this.GOW;
        paramAnimator.setVisibility(0);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(o.f(localo), o.f(localo));
        o.a(localo, (View)paramAnimator, localLayoutParams);
        paramAnimator.setScaleX(1.0F);
        paramAnimator.setScaleY(1.0F);
        paramAnimator.setPivotY(0.0F);
        paramAnimator.setAlpha(1.0F);
        paramAnimator.setTranslationX(o.c(localo).left);
        paramAnimator.setTranslationY(o.c(localo).top);
      }
      AppMethodBeat.o(338741);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.o
 * JD-Core Version:    0.7.0.1
 */