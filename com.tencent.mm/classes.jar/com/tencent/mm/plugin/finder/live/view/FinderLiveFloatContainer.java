package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_TRANSLATION_Y", "DIRECTION_LEFT", "DIRECTION_RIGHT", "MAX_OFFSET", "MIN_OFFSET", "TAG", "", "animationListener", "com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$animationListener$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$animationListener$1;", "animationUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "direction", "dividingLine", "extraBottomBoundary", "extraLeftBoundary", "extraRightBoundary", "extraTopBoundary", "focusBackground", "Landroid/graphics/drawable/Drawable;", "maxTransX", "maxTransY", "minTransX", "minTransY", "offsetX", "", "offsetY", "onAnimCallback", "Lkotlin/Function0;", "", "getOnAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setOnAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "onTouchCallback", "Landroid/view/MotionEvent;", "event", "getOnTouchCallback", "setOnTouchCallback", "touchDownTimestamp", "", "unfocusLeftBackground", "unfocusRightBackground", "animToEdge", "hideStatePanel", "animationEnd", "onTouchEvent", "", "resetDefaultLayout", "setExtraBoundary", "top", "bottom", "left", "right", "showStatePanel", "plugin-finder_release"})
public final class FinderLiveFloatContainer
  extends RelativeLayout
{
  private final int DIRECTION_LEFT;
  private final int DIRECTION_RIGHT;
  private final String TAG;
  private int direction;
  private final int yTJ;
  private final int yTK;
  private final int yTL;
  private int yTM;
  private int yTN;
  private int yTO;
  private int yTP;
  private float yTQ;
  private float yTR;
  private int yTS;
  private long yTT;
  public int yTU;
  public int yTV;
  public int yTW;
  public int yTX;
  private Drawable yTY;
  private Drawable yTZ;
  private Drawable yUa;
  private b<? super MotionEvent, x> yUb;
  private a<x> yUc;
  private final a yUd;
  private final ValueAnimator.AnimatorUpdateListener yUe;
  private b<? super View, x> yUf;
  
  public FinderLiveFloatContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(279963);
    AppMethodBeat.o(279963);
  }
  
  public FinderLiveFloatContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(279962);
    this.TAG = "Finder.FinderLiveLinkMicStateContainer";
    this.yTK = ax.au(paramContext).x;
    this.DIRECTION_LEFT = 1;
    this.yTL = aw.fromDPToPix(paramContext, 116);
    this.direction = this.DIRECTION_RIGHT;
    this.yUd = new a(this);
    this.yUe = ((ValueAnimator.AnimatorUpdateListener)new b(this));
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.l.FinderLiveFloatContainer);
      p.j(paramAttributeSet, "context.obtainStyledAttr…FinderLiveFloatContainer)");
      this.yTY = paramAttributeSet.getDrawable(b.l.FinderLiveFloatContainer_focus_background);
      this.yTZ = paramAttributeSet.getDrawable(b.l.FinderLiveFloatContainer_unfocus_left_background);
      this.yUa = paramAttributeSet.getDrawable(b.l.FinderLiveFloatContainer_unfocus_right_background);
      paramAttributeSet.recycle();
    }
    setNestedScrollingEnabled(true);
    setActivated(true);
    setClickable(true);
    if (this.direction == this.DIRECTION_RIGHT) {}
    for (float f = ax.au(paramContext).x / 2.0F;; f = -(ax.au(paramContext).x / 2.0F))
    {
      setTranslationX(f);
      AppMethodBeat.o(279962);
      return;
    }
  }
  
  public final void Q(final a<x> parama)
  {
    AppMethodBeat.i(279959);
    animate().translationX(0.0F).setListener((Animator.AnimatorListener)new e(this, parama)).setDuration(500L).start();
    AppMethodBeat.o(279959);
  }
  
  public final void R(final a<x> parama)
  {
    AppMethodBeat.i(279961);
    if (this.direction == this.DIRECTION_RIGHT)
    {
      animate().translationX(getMeasuredWidth()).setDuration(500L).setListener((Animator.AnimatorListener)new c(this, parama)).start();
      AppMethodBeat.o(279961);
      return;
    }
    animate().translationX(this.yTM - getMeasuredWidth()).setDuration(500L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(279961);
  }
  
  public final void dEZ()
  {
    AppMethodBeat.i(279957);
    Object localObject = getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(279957);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = this.yTL;
    AppMethodBeat.o(279957);
  }
  
  public final a<x> getOnAnimCallback()
  {
    return this.yUc;
  }
  
  public final b<View, x> getOnClick()
  {
    return this.yUf;
  }
  
  public final b<MotionEvent, x> getOnTouchCallback()
  {
    return this.yUb;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(279956);
    Object localObject;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (localObject != null) {
        break label81;
      }
      label24:
      if (localObject != null) {
        break label221;
      }
      label29:
      if (localObject != null) {
        break label508;
      }
    }
    label81:
    label221:
    label508:
    while (((Integer)localObject).intValue() != 3)
    {
      if (localObject != null) {
        break label547;
      }
      for (;;)
      {
        localObject = this.yUb;
        if (localObject != null) {
          ((b)localObject).invoke(paramMotionEvent);
        }
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(279956);
        return bool;
        localObject = null;
        break;
        if (((Integer)localObject).intValue() != 0) {
          break label24;
        }
        this.yTQ = (paramMotionEvent.getRawX() - getLeft());
        this.yTR = (paramMotionEvent.getRawY() - getTop());
        this.yTO = this.yTU;
        this.yTP = (ax.au(getContext()).y - getMeasuredHeight() - this.yTV);
        this.yTM = this.yTW;
        this.yTN = (ax.au(getContext()).x - getMeasuredWidth() - this.yTX);
        this.yTS = (ax.au(getContext()).x / 2);
        this.yTT = System.currentTimeMillis();
        setBackground(this.yTY);
        startNestedScroll(2);
        continue;
        if (((Integer)localObject).intValue() != 2) {
          break label29;
        }
        Log.i(this.TAG, "x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY() + " rawx:" + paramMotionEvent.getRawX() + " rawy:" + paramMotionEvent.getRawY());
        float f2 = paramMotionEvent.getRawX();
        float f1 = paramMotionEvent.getRawY();
        if (i.aP(this.yTJ, i.aQ(this.yTK, getLeft() + getMeasuredWidth() / 2.0F)) > this.yTS) {}
        for (this.direction = this.DIRECTION_RIGHT;; this.direction = this.DIRECTION_LEFT)
        {
          f2 = i.aP(this.yTM, i.aQ(this.yTN, ax.au(getContext()).x - f2 - this.yTQ));
          f1 = i.aP(this.yTO, i.aQ(this.yTP, f1 - this.yTR));
          localObject = getLayoutParams();
          if (localObject != null) {
            break;
          }
          paramMotionEvent = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(279956);
          throw paramMotionEvent;
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd((int)f2);
        localObject = getLayoutParams();
        if (localObject == null)
        {
          paramMotionEvent = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(279956);
          throw paramMotionEvent;
        }
        ((ViewGroup.MarginLayoutParams)localObject).topMargin = ((int)f1);
        requestLayout();
      }
    }
    for (;;)
    {
      localObject = getLayoutParams();
      if (localObject != null) {
        break label595;
      }
      paramMotionEvent = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(279956);
      throw paramMotionEvent;
      label547:
      if (((Integer)localObject).intValue() != 1) {
        break;
      }
      if (System.currentTimeMillis() - this.yTT < ViewConfiguration.getTapTimeout())
      {
        localObject = this.yUf;
        if (localObject != null) {
          ((b)localObject).invoke(this);
        }
      }
    }
    label595:
    int i = ((ViewGroup.MarginLayoutParams)localObject).getMarginEnd();
    if (this.direction == this.DIRECTION_RIGHT)
    {
      localObject = ObjectAnimator.ofInt(new int[] { i, this.yTM }).setDuration(100L);
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)this.yUd);
      ((ValueAnimator)localObject).addUpdateListener(this.yUe);
      ((ValueAnimator)localObject).start();
    }
    for (;;)
    {
      this.yTT = 0L;
      this.yTS = 0;
      stopNestedScroll();
      break;
      localObject = ObjectAnimator.ofInt(new int[] { i, this.yTN }).setDuration(100L);
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)this.yUd);
      ((ValueAnimator)localObject).addUpdateListener(this.yUe);
      ((ValueAnimator)localObject).start();
    }
  }
  
  public final void setOnAnimCallback(a<x> parama)
  {
    this.yUc = parama;
  }
  
  public final void setOnClick(b<? super View, x> paramb)
  {
    this.yUf = paramb;
  }
  
  public final void setOnTouchCallback(b<? super MotionEvent, x> paramb)
  {
    this.yUb = paramb;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$animationListener$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(262140);
      if (FinderLiveFloatContainer.c(this.yUg) == FinderLiveFloatContainer.d(this.yUg))
      {
        this.yUg.setTranslationX(FinderLiveFloatContainer.g(this.yUg));
        FinderLiveFloatContainer.e(this.yUg);
      }
      for (;;)
      {
        paramAnimator = this.yUg.getOnAnimCallback();
        if (paramAnimator == null) {
          break;
        }
        paramAnimator.invoke();
        AppMethodBeat.o(262140);
        return;
        this.yUg.setTranslationX(FinderLiveFloatContainer.h(this.yUg));
        FinderLiveFloatContainer.e(this.yUg);
      }
      AppMethodBeat.o(262140);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(262139);
      FinderLiveFloatContainer localFinderLiveFloatContainer = this.yUg;
      if (FinderLiveFloatContainer.c(this.yUg) == FinderLiveFloatContainer.d(this.yUg)) {}
      for (paramAnimator = FinderLiveFloatContainer.e(this.yUg);; paramAnimator = FinderLiveFloatContainer.f(this.yUg))
      {
        localFinderLiveFloatContainer.setBackground(paramAnimator);
        paramAnimator = this.yUg.getOnAnimCallback();
        if (paramAnimator == null) {
          break;
        }
        paramAnimator.invoke();
        AppMethodBeat.o(262139);
        return;
      }
      AppMethodBeat.o(262139);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(FinderLiveFloatContainer paramFinderLiveFloatContainer) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(289125);
      Object localObject = this.yUg.getLayoutParams();
      if (localObject == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(289125);
        throw paramValueAnimator;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      p.j(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(289125);
        throw paramValueAnimator;
      }
      ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(((Integer)paramValueAnimator).intValue());
      paramValueAnimator = this.yUg.getOnAnimCallback();
      if (paramValueAnimator != null) {
        paramValueAnimator.invoke();
      }
      this.yUg.requestLayout();
      AppMethodBeat.o(289125);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$hideStatePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(285248);
      paramAnimator = parama;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = this.yUg.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(285248);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = FinderLiveFloatContainer.b(this.yUg);
      FinderLiveFloatContainer.a(this.yUg, FinderLiveFloatContainer.d(this.yUg));
      AppMethodBeat.o(285248);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(285247);
      paramAnimator = parama;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = this.yUg.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(285247);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = FinderLiveFloatContainer.b(this.yUg);
      FinderLiveFloatContainer.a(this.yUg, FinderLiveFloatContainer.d(this.yUg));
      AppMethodBeat.o(285247);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$hideStatePanel$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(288071);
      this.yUg.setVisibility(8);
      paramAnimator = this.yUg.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(288071);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = FinderLiveFloatContainer.b(this.yUg);
      paramAnimator = this.yUg.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(288071);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).setMarginEnd(0);
      this.yUg.setTranslationX(ax.au(this.yUg.getContext()).x / 2.0F);
      this.yUg.setBackground(FinderLiveFloatContainer.e(this.yUg));
      FinderLiveFloatContainer.a(this.yUg, FinderLiveFloatContainer.d(this.yUg));
      AppMethodBeat.o(288071);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(288070);
      this.yUg.setVisibility(8);
      paramAnimator = this.yUg.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(288070);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = FinderLiveFloatContainer.b(this.yUg);
      paramAnimator = this.yUg.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(288070);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).setMarginEnd(0);
      this.yUg.setTranslationX(ax.au(this.yUg.getContext()).x / 2.0F);
      this.yUg.setBackground(FinderLiveFloatContainer.e(this.yUg));
      FinderLiveFloatContainer.a(this.yUg, FinderLiveFloatContainer.d(this.yUg));
      AppMethodBeat.o(288070);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$showStatePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(277866);
      this.yUg.bringToFront();
      paramAnimator = parama;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(277866);
        return;
      }
      AppMethodBeat.o(277866);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(277865);
      this.yUg.bringToFront();
      paramAnimator = parama;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(277865);
        return;
      }
      AppMethodBeat.o(277865);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveFloatContainer
 * JD-Core Version:    0.7.0.1
 */