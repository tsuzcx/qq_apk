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
import android.view.accessibility.AccessibilityEvent;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.uitl.AccUtil;
import com.tencent.mm.plugin.finder.live.p.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DIRECTION_LEFT", "DIRECTION_RIGHT", "MAX_OFFSET", "MIN_OFFSET", "TAG", "", "animationListener", "com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$animationListener$1", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$animationListener$1;", "animationUpdateListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "defaultTranslationY", "getDefaultTranslationY", "()I", "setDefaultTranslationY", "(I)V", "direction", "dividingLine", "extraBottomBoundary", "extraLeftBoundary", "extraRightBoundary", "extraTopBoundary", "focusBackground", "Landroid/graphics/drawable/Drawable;", "maxTransX", "maxTransY", "minTransX", "minTransY", "needInterceptTouchEvent", "", "getNeedInterceptTouchEvent", "()Z", "setNeedInterceptTouchEvent", "(Z)V", "offsetX", "", "offsetY", "onAnimCallback", "Lkotlin/Function0;", "", "getOnAnimCallback", "()Lkotlin/jvm/functions/Function0;", "setOnAnimCallback", "(Lkotlin/jvm/functions/Function0;)V", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "onTouchCallback", "Landroid/view/MotionEvent;", "event", "getOnTouchCallback", "setOnTouchCallback", "touchDownTimestamp", "", "unfocusLeftBackground", "unfocusRightBackground", "animToEdge", "hideStatePanel", "animationEnd", "onInitializeAccessibilityEvent", "Landroid/view/accessibility/AccessibilityEvent;", "onInterceptTouchEvent", "ev", "onTouchEvent", "resetDefaultLayout", "setExtraBoundary", "top", "bottom", "left", "right", "showStatePanel", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveFloatContainer
  extends RelativeLayout
{
  private final int DMB;
  private final int DMC;
  private final int DMD;
  private final int DME;
  private int DMF;
  private int DMG;
  private int DMH;
  private int DMI;
  private int DMJ;
  private long DMK;
  public int DML;
  public int DMM;
  public int DMN;
  public int DMO;
  private Drawable DMP;
  private Drawable DMQ;
  private Drawable DMR;
  private b<? super MotionEvent, ah> DMS;
  private a<ah> DMT;
  private boolean DMU;
  private int DMV;
  private final a DMW;
  private final ValueAnimator.AnimatorUpdateListener DMX;
  private b<? super View, ah> DMY;
  private final String TAG;
  private float bbJ;
  private float bbK;
  private int direction;
  
  public FinderLiveFloatContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(357915);
    AppMethodBeat.o(357915);
  }
  
  public FinderLiveFloatContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(357909);
    this.TAG = "Finder.FinderLiveLinkMicStateContainer";
    this.DMC = bf.bf(paramContext).x;
    this.DME = 1;
    this.direction = this.DMD;
    this.DMV = bd.fromDPToPix(paramContext, 116);
    this.DMW = new a(this);
    this.DMX = new FinderLiveFloatContainer..ExternalSyntheticLambda0(this);
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, p.j.hac);
      s.s(paramAttributeSet, "context.obtainStyledAttr…FinderLiveFloatContainer)");
      this.DMP = paramAttributeSet.getDrawable(p.j.Cuz);
      this.DMQ = paramAttributeSet.getDrawable(p.j.CuA);
      this.DMR = paramAttributeSet.getDrawable(p.j.CuB);
      paramAttributeSet.recycle();
    }
    setNestedScrollingEnabled(true);
    setActivated(true);
    setClickable(true);
    if (this.direction == this.DMD) {}
    for (float f = bf.bf(paramContext).x / 2.0F;; f = -(bf.bf(paramContext).x / 2.0F))
    {
      setTranslationX(f);
      AppMethodBeat.o(357909);
      return;
    }
  }
  
  private static final void a(FinderLiveFloatContainer paramFinderLiveFloatContainer, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(357928);
    s.u(paramFinderLiveFloatContainer, "this$0");
    Object localObject = paramFinderLiveFloatContainer.getLayoutParams();
    if (localObject == null)
    {
      paramFinderLiveFloatContainer = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(357928);
      throw paramFinderLiveFloatContainer;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramFinderLiveFloatContainer = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(357928);
      throw paramFinderLiveFloatContainer;
    }
    ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd(((Integer)paramValueAnimator).intValue());
    paramValueAnimator = paramFinderLiveFloatContainer.getOnAnimCallback();
    if (paramValueAnimator != null) {
      paramValueAnimator.invoke();
    }
    paramFinderLiveFloatContainer.requestLayout();
    AppMethodBeat.o(357928);
  }
  
  public final void bm(final a<ah> parama)
  {
    AppMethodBeat.i(358095);
    animate().translationX(0.0F).setListener((Animator.AnimatorListener)new d(this, parama)).setDuration(500L).start();
    AppMethodBeat.o(358095);
  }
  
  public final void bn(a<ah> parama)
  {
    AppMethodBeat.i(358104);
    if (this.direction == this.DMD)
    {
      animate().translationX(getMeasuredWidth()).setDuration(500L).setListener((Animator.AnimatorListener)new b(parama, this)).start();
      AppMethodBeat.o(358104);
      return;
    }
    animate().translationX(this.DMF - getMeasuredWidth()).setDuration(500L).setListener((Animator.AnimatorListener)new c(this)).start();
    AppMethodBeat.o(358104);
  }
  
  public final void evm()
  {
    AppMethodBeat.i(358090);
    Object localObject = getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(358090);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = this.DMV;
    AppMethodBeat.o(358090);
  }
  
  public final int getDefaultTranslationY()
  {
    return this.DMV;
  }
  
  public final boolean getNeedInterceptTouchEvent()
  {
    return this.DMU;
  }
  
  public final a<ah> getOnAnimCallback()
  {
    return this.DMT;
  }
  
  public final b<View, ah> getOnClick()
  {
    return this.DMY;
  }
  
  public final b<MotionEvent, ah> getOnTouchCallback()
  {
    return this.DMS;
  }
  
  public final void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 1;
    AppMethodBeat.i(358085);
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    if ((paramAccessibilityEvent != null) && ((paramAccessibilityEvent.getEventType() & 0x1) == 1)) {}
    for (;;)
    {
      if ((i != 0) && (AccUtil.INSTANCE.isAccessibilityEnabled()))
      {
        paramAccessibilityEvent = this.DMY;
        if (paramAccessibilityEvent != null) {
          paramAccessibilityEvent.invoke(this);
        }
      }
      AppMethodBeat.o(358085);
      return;
      i = 0;
    }
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(358036);
    if (this.DMU)
    {
      AppMethodBeat.o(358036);
      return true;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(358036);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(358056);
    Object localObject;
    if (paramMotionEvent == null)
    {
      localObject = null;
      if (localObject != null) {
        break label81;
      }
      label18:
      if (localObject != null) {
        break label221;
      }
      label23:
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
        localObject = this.DMS;
        if (localObject != null) {
          ((b)localObject).invoke(paramMotionEvent);
        }
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(358056);
        return bool;
        localObject = Integer.valueOf(paramMotionEvent.getActionMasked());
        break;
        if (((Integer)localObject).intValue() != 0) {
          break label18;
        }
        this.bbJ = (paramMotionEvent.getRawX() - getLeft());
        this.bbK = (paramMotionEvent.getRawY() - getTop());
        this.DMH = this.DML;
        this.DMI = (bf.bf(getContext()).y - getMeasuredHeight() - this.DMM);
        this.DMF = this.DMN;
        this.DMG = (bf.bf(getContext()).x - getMeasuredWidth() - this.DMO);
        this.DMJ = (bf.bf(getContext()).x / 2);
        this.DMK = System.currentTimeMillis();
        setBackground(this.DMP);
        startNestedScroll(2);
        continue;
        if (((Integer)localObject).intValue() != 2) {
          break label23;
        }
        Log.i(this.TAG, "x:" + paramMotionEvent.getX() + " y:" + paramMotionEvent.getY() + " rawx:" + paramMotionEvent.getRawX() + " rawy:" + paramMotionEvent.getRawY());
        float f2 = paramMotionEvent.getRawX();
        float f1 = paramMotionEvent.getRawY();
        if (k.bt(this.DMB, k.bu(this.DMC, getLeft() + getMeasuredWidth() / 2.0F)) > this.DMJ) {}
        for (this.direction = this.DMD;; this.direction = this.DME)
        {
          f2 = k.bt(this.DMF, k.bu(this.DMG, bf.bf(getContext()).x - f2 - this.bbJ));
          f1 = k.bt(this.DMH, k.bu(this.DMI, f1 - this.bbK));
          localObject = getLayoutParams();
          if (localObject != null) {
            break;
          }
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(358056);
          throw paramMotionEvent;
        }
        ((ViewGroup.MarginLayoutParams)localObject).setMarginEnd((int)f2);
        localObject = getLayoutParams();
        if (localObject == null)
        {
          paramMotionEvent = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
          AppMethodBeat.o(358056);
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
      paramMotionEvent = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(358056);
      throw paramMotionEvent;
      label547:
      if (((Integer)localObject).intValue() != 1) {
        break;
      }
      if (System.currentTimeMillis() - this.DMK < ViewConfiguration.getTapTimeout())
      {
        localObject = this.DMY;
        if (localObject != null) {
          ((b)localObject).invoke(this);
        }
      }
    }
    label595:
    int i = ((ViewGroup.MarginLayoutParams)localObject).getMarginEnd();
    if (this.direction == this.DMD)
    {
      localObject = ObjectAnimator.ofInt(new int[] { i, this.DMF }).setDuration(100L);
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)this.DMW);
      ((ValueAnimator)localObject).addUpdateListener(this.DMX);
      ((ValueAnimator)localObject).start();
    }
    for (;;)
    {
      this.DMK = 0L;
      this.DMJ = 0;
      stopNestedScroll();
      break;
      localObject = ObjectAnimator.ofInt(new int[] { i, this.DMG }).setDuration(100L);
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)this.DMW);
      ((ValueAnimator)localObject).addUpdateListener(this.DMX);
      ((ValueAnimator)localObject).start();
    }
  }
  
  public final void setDefaultTranslationY(int paramInt)
  {
    this.DMV = paramInt;
  }
  
  public final void setNeedInterceptTouchEvent(boolean paramBoolean)
  {
    this.DMU = paramBoolean;
  }
  
  public final void setOnAnimCallback(a<ah> parama)
  {
    this.DMT = parama;
  }
  
  public final void setOnClick(b<? super View, ah> paramb)
  {
    this.DMY = paramb;
  }
  
  public final void setOnTouchCallback(b<? super MotionEvent, ah> paramb)
  {
    this.DMS = paramb;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$animationListener$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(FinderLiveFloatContainer paramFinderLiveFloatContainer) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(358140);
      if (FinderLiveFloatContainer.d(this.DMZ) == FinderLiveFloatContainer.b(this.DMZ))
      {
        this.DMZ.setTranslationX(FinderLiveFloatContainer.f(this.DMZ));
        FinderLiveFloatContainer.c(this.DMZ);
      }
      for (;;)
      {
        paramAnimator = this.DMZ.getOnAnimCallback();
        if (paramAnimator != null) {
          paramAnimator.invoke();
        }
        AppMethodBeat.o(358140);
        return;
        this.DMZ.setTranslationX(FinderLiveFloatContainer.g(this.DMZ));
        FinderLiveFloatContainer.c(this.DMZ);
      }
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358130);
      FinderLiveFloatContainer localFinderLiveFloatContainer = this.DMZ;
      if (FinderLiveFloatContainer.d(this.DMZ) == FinderLiveFloatContainer.b(this.DMZ)) {}
      for (paramAnimator = FinderLiveFloatContainer.c(this.DMZ);; paramAnimator = FinderLiveFloatContainer.e(this.DMZ))
      {
        localFinderLiveFloatContainer.setBackground(paramAnimator);
        paramAnimator = this.DMZ.getOnAnimCallback();
        if (paramAnimator != null) {
          paramAnimator.invoke();
        }
        AppMethodBeat.o(358130);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$hideStatePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(a<ah> parama, FinderLiveFloatContainer paramFinderLiveFloatContainer) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(358143);
      paramAnimator = this.DNa;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = jdField_this.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(358143);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = jdField_this.getDefaultTranslationY();
      FinderLiveFloatContainer.a(jdField_this, FinderLiveFloatContainer.b(jdField_this));
      AppMethodBeat.o(358143);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358136);
      paramAnimator = this.DNa;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      paramAnimator = jdField_this.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(358136);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = jdField_this.getDefaultTranslationY();
      FinderLiveFloatContainer.a(jdField_this, FinderLiveFloatContainer.b(jdField_this));
      AppMethodBeat.o(358136);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$hideStatePanel$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(FinderLiveFloatContainer paramFinderLiveFloatContainer) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(358146);
      this.DMZ.setVisibility(8);
      paramAnimator = this.DMZ.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(358146);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = this.DMZ.getDefaultTranslationY();
      paramAnimator = this.DMZ.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(358146);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).setMarginEnd(0);
      this.DMZ.setTranslationX(bf.bf(this.DMZ.getContext()).x / 2.0F);
      this.DMZ.setBackground(FinderLiveFloatContainer.c(this.DMZ));
      FinderLiveFloatContainer.a(this.DMZ, FinderLiveFloatContainer.b(this.DMZ));
      AppMethodBeat.o(358146);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358135);
      this.DMZ.setVisibility(8);
      paramAnimator = this.DMZ.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(358135);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).topMargin = this.DMZ.getDefaultTranslationY();
      paramAnimator = this.DMZ.getLayoutParams();
      if (paramAnimator == null)
      {
        paramAnimator = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(358135);
        throw paramAnimator;
      }
      ((ViewGroup.MarginLayoutParams)paramAnimator).setMarginEnd(0);
      this.DMZ.setTranslationX(bf.bf(this.DMZ.getContext()).x / 2.0F);
      this.DMZ.setBackground(FinderLiveFloatContainer.c(this.DMZ));
      FinderLiveFloatContainer.a(this.DMZ, FinderLiveFloatContainer.b(this.DMZ));
      AppMethodBeat.o(358135);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/view/FinderLiveFloatContainer$showStatePanel$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends AnimatorListenerAdapter
  {
    d(FinderLiveFloatContainer paramFinderLiveFloatContainer, a<ah> parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(358189);
      this.DMZ.bringToFront();
      paramAnimator = parama;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(358189);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(358183);
      this.DMZ.bringToFront();
      paramAnimator = parama;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(358183);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveFloatContainer
 * JD-Core Version:    0.7.0.1
 */