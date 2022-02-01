package com.tencent.mm.plugin.finder.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_TRANSLATION_Y", "DIRECTION_LEFT", "DIRECTION_RIGHT", "MAX_OFFSET", "MIN_OFFSET", "TAG", "", "animationListener", "com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$animationListener$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$animationListener$1;", "animationUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "direction", "dividingLine", "maxTransX", "maxTransY", "minTransX", "minTransY", "offsetX", "", "offsetY", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "touchDownTimestamp", "", "animToEdge", "hideStatePanel", "animationEnd", "Lkotlin/Function0;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "resetDefaultLayout", "showStatePanel", "plugin-finder_release"})
public final class FinderLiveLinkMicStateContainer
  extends RelativeLayout
{
  private final int DIRECTION_LEFT;
  private final int DIRECTION_RIGHT;
  private final String TAG;
  private int direction;
  private final int uyV;
  private final int uyW;
  private final int uyX;
  private int uyY;
  private int uyZ;
  private int uza;
  private int uzb;
  private float uzc;
  private float uzd;
  private int uze;
  private long uzf;
  private final a uzg;
  private final ValueAnimator.AnimatorUpdateListener uzh;
  private b<? super View, x> uzi;
  
  public FinderLiveLinkMicStateContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(247490);
    AppMethodBeat.o(247490);
  }
  
  public FinderLiveLinkMicStateContainer(final Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247489);
    this.TAG = "Finder.FinderLiveLinkMicStateContainer";
    this.uyW = au.az(paramContext).x;
    this.DIRECTION_LEFT = 1;
    this.uyX = at.fromDPToPix(paramContext, 116);
    this.direction = this.DIRECTION_RIGHT;
    this.uzg = new a(this, paramContext);
    this.uzh = ((ValueAnimator.AnimatorUpdateListener)new b(this));
    setNestedScrollingEnabled(true);
    setActivated(true);
    setClickable(true);
    if (this.direction == this.DIRECTION_RIGHT) {}
    for (float f = au.az(paramContext).x / 2.0F;; f = -(au.az(paramContext).x / 2.0F))
    {
      setTranslationX(f);
      AppMethodBeat.o(247489);
      return;
    }
  }
  
  public final void Q(final a<x> parama)
  {
    AppMethodBeat.i(247486);
    animate().translationX(0.0F).setListener((Animator.AnimatorListener)new e(this, parama)).setDuration(500L).start();
    AppMethodBeat.o(247486);
  }
  
  public final void R(final a<x> parama)
  {
    AppMethodBeat.i(247488);
    if (this.direction == this.DIRECTION_RIGHT)
    {
      animate().translationX(getMeasuredWidth()).setDuration(500L).setListener((Animator.AnimatorListener)new c(this, parama)).start();
      AppMethodBeat.o(247488);
      return;
    }
    animate().translationX(this.uyY - getMeasuredWidth()).setDuration(500L).setListener((Animator.AnimatorListener)new d(this)).start();
    AppMethodBeat.o(247488);
  }
  
  public final void diw()
  {
    AppMethodBeat.i(247485);
    Object localObject = getLayoutParams();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247485);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = this.uyX;
    AppMethodBeat.o(247485);
  }
  
  public final b<View, x> getOnClick()
  {
    return this.uzi;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(247484);
    Object localObject;
    if (paramMotionEvent != null)
    {
      localObject = Integer.valueOf(paramMotionEvent.getActionMasked());
      if (localObject != null) {
        break label59;
      }
      label23:
      if (localObject != null) {
        break label203;
      }
      label28:
      if (localObject != null) {
        break label486;
      }
    }
    label59:
    label203:
    label486:
    while (((Integer)localObject).intValue() != 3)
    {
      if (localObject != null) {
        break label523;
      }
      for (;;)
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(247484);
        return bool;
        localObject = null;
        break;
        if (((Integer)localObject).intValue() != 0) {
          break label23;
        }
        this.uzc = (paramMotionEvent.getRawX() - getLeft());
        this.uzd = (paramMotionEvent.getRawY() - getTop());
        this.uza = 0;
        this.uzb = (au.az(getContext()).y - getMeasuredHeight());
        this.uyY = 0;
        this.uyZ = (au.az(getContext()).x - getMeasuredWidth());
        this.uze = (au.az(getContext()).x / 2);
        this.uzf = System.currentTimeMillis();
        localObject = getContext();
        p.g(localObject, "context");
        setBackground(((Context)localObject).getResources().getDrawable(2131232618));
        startNestedScroll(2);
        continue;
        if (((Integer)localObject).intValue() != 2) {
          break label28;
        }
        Log.i(this.TAG, "x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY() + " rawx:" + paramMotionEvent.getRawX() + " rawy:" + paramMotionEvent.getRawY());
        float f2 = paramMotionEvent.getRawX();
        float f1 = paramMotionEvent.getRawY();
        if (j.aI(this.uyV, j.aJ(this.uyW, getLeft() + getMeasuredWidth() / 2.0F)) > this.uze) {}
        for (this.direction = this.DIRECTION_RIGHT;; this.direction = this.DIRECTION_LEFT)
        {
          f2 = j.aI(this.uyY, j.aJ(this.uyZ, au.az(getContext()).x - f2 - this.uzc));
          f1 = j.aI(this.uza, j.aJ(this.uzb, f1 - this.uzd));
          localObject = getLayoutParams();
          if (localObject != null) {
            break;
          }
          paramMotionEvent = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(247484);
          throw paramMotionEvent;
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd((int)f2);
        localObject = getLayoutParams();
        if (localObject == null)
        {
          paramMotionEvent = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(247484);
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
        break label571;
      }
      paramMotionEvent = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(247484);
      throw paramMotionEvent;
      label523:
      if (((Integer)localObject).intValue() != 1) {
        break;
      }
      if (System.currentTimeMillis() - this.uzf < ViewConfiguration.getTapTimeout())
      {
        localObject = this.uzi;
        if (localObject != null) {
          ((b)localObject).invoke(this);
        }
      }
    }
    label571:
    int i = ((ViewGroup.MarginLayoutParams)localObject).getMarginEnd();
    if (this.direction == this.DIRECTION_RIGHT)
    {
      localObject = ObjectAnimator.ofInt(new int[] { i, this.uyY }).setDuration(100L);
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)this.uzg);
      ((ValueAnimator)localObject).addUpdateListener(this.uzh);
      ((ValueAnimator)localObject).start();
    }
    for (;;)
    {
      this.uzf = 0L;
      this.uze = 0;
      stopNestedScroll();
      break;
      localObject = ObjectAnimator.ofInt(new int[] { i, this.uyZ }).setDuration(100L);
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)this.uzg);
      ((ValueAnimator)localObject).addUpdateListener(this.uzh);
      ((ValueAnimator)localObject).start();
    }
  }
  
  public final void setOnClick(b<? super View, x> paramb)
  {
    this.uzi = paramb;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$animationListener$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(Context paramContext) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(247476);
      if (FinderLiveLinkMicStateContainer.c(this.uzj) == FinderLiveLinkMicStateContainer.d(this.uzj))
      {
        this.uzj.setTranslationX(FinderLiveLinkMicStateContainer.e(this.uzj));
        this.uzj.setBackground(paramContext.getResources().getDrawable(2131232620));
        AppMethodBeat.o(247476);
        return;
      }
      this.uzj.setTranslationX(FinderLiveLinkMicStateContainer.f(this.uzj));
      this.uzj.setBackground(paramContext.getResources().getDrawable(2131232619));
      AppMethodBeat.o(247476);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(247475);
      FinderLiveLinkMicStateContainer localFinderLiveLinkMicStateContainer = this.uzj;
      if (FinderLiveLinkMicStateContainer.c(this.uzj) == FinderLiveLinkMicStateContainer.d(this.uzj)) {}
      for (paramAnimator = paramContext.getResources().getDrawable(2131232620);; paramAnimator = paramContext.getResources().getDrawable(2131232619))
      {
        localFinderLiveLinkMicStateContainer.setBackground(paramAnimator);
        AppMethodBeat.o(247475);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(FinderLiveLinkMicStateContainer paramFinderLiveLinkMicStateContainer) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(247477);
      Object localObject = this.uzj.getLayoutParams();
      if (localObject == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247477);
        throw paramValueAnimator;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      p.g(paramValueAnimator, "it");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(247477);
        throw paramValueAnimator;
      }
      ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(((Integer)paramValueAnimator).intValue());
      this.uzj.requestLayout();
      AppMethodBeat.o(247477);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$hideStatePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(247479);
      paramAnimator = parama;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = this.uzj.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247479);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = FinderLiveLinkMicStateContainer.b(this.uzj);
      FinderLiveLinkMicStateContainer.a(this.uzj, FinderLiveLinkMicStateContainer.d(this.uzj));
      AppMethodBeat.o(247479);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(247478);
      paramAnimator = parama;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = this.uzj.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247478);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = FinderLiveLinkMicStateContainer.b(this.uzj);
      FinderLiveLinkMicStateContainer.a(this.uzj, FinderLiveLinkMicStateContainer.d(this.uzj));
      AppMethodBeat.o(247478);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$hideStatePanel$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class d
    extends AnimatorListenerAdapter
  {
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(247481);
      this.uzj.setVisibility(8);
      paramAnimator = this.uzj.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247481);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = FinderLiveLinkMicStateContainer.b(this.uzj);
      paramAnimator = this.uzj.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247481);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).setMarginEnd(0);
      this.uzj.setTranslationX(au.az(this.uzj.getContext()).x / 2.0F);
      paramAnimator = this.uzj;
      Context localContext = this.uzj.getContext();
      p.g(localContext, "context");
      paramAnimator.setBackground(localContext.getResources().getDrawable(2131232620));
      FinderLiveLinkMicStateContainer.a(this.uzj, FinderLiveLinkMicStateContainer.d(this.uzj));
      AppMethodBeat.o(247481);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(247480);
      this.uzj.setVisibility(8);
      paramAnimator = this.uzj.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247480);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = FinderLiveLinkMicStateContainer.b(this.uzj);
      paramAnimator = this.uzj.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(247480);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).setMarginEnd(0);
      this.uzj.setTranslationX(au.az(this.uzj.getContext()).x / 2.0F);
      paramAnimator = this.uzj;
      Context localContext = this.uzj.getContext();
      p.g(localContext, "context");
      paramAnimator.setBackground(localContext.getResources().getDrawable(2131232620));
      FinderLiveLinkMicStateContainer.a(this.uzj, FinderLiveLinkMicStateContainer.d(this.uzj));
      AppMethodBeat.o(247480);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer$showStatePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder_release"})
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(247483);
      this.uzj.bringToFront();
      paramAnimator = parama;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(247483);
        return;
      }
      AppMethodBeat.o(247483);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(247482);
      this.uzj.bringToFront();
      paramAnimator = parama;
      if (paramAnimator != null)
      {
        paramAnimator.invoke();
        AppMethodBeat.o(247482);
        return;
      }
      AppMethodBeat.o(247482);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLinkMicStateContainer
 * JD-Core Version:    0.7.0.1
 */