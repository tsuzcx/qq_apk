package com.tencent.mm.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ap;
import d.g.a.b;
import d.g.b.k;
import d.k.h;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "fling", "", "onVisibilityListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShow", "", "getOnVisibilityListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityListener", "(Lkotlin/jvm/functions/Function1;)V", "totalConsumedY", "hide", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "child", "nestedScrollAxes", "onStopNestedScroll", "setContentBg", "background", "Landroid/graphics/drawable/Drawable;", "setContentView", "contentView", "show", "plugin-logic_release"})
public final class LiveBottomSheetPanel
  extends RelativeLayout
{
  private int KAF;
  private boolean KAG;
  private b<? super Boolean, y> KAH;
  private final String TAG;
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(203449);
    AppMethodBeat.o(203449);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(203448);
    this.TAG = "MicroMsg.LiveBottomSheetPanel";
    View.inflate(paramContext, 2131496295, (ViewGroup)this);
    AppMethodBeat.o(203448);
  }
  
  public final b<Boolean, y> getOnVisibilityListener()
  {
    return this.KAH;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(203441);
    animate().translationY(ap.cf(getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    AppMethodBeat.o(203441);
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(203447);
    ad.d(this.TAG, "onNestedFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2 + " ViewConfiguration.getMinimumFlingVelocity():" + ViewConfiguration.getMinimumFlingVelocity());
    if (paramFloat2 > 0.0F)
    {
      this.KAG = true;
      show();
    }
    for (;;)
    {
      paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(203447);
      return paramBoolean;
      if (paramFloat2 > 0.0F)
      {
        this.KAG = true;
        hide();
      }
    }
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(203444);
    ad.d(this.TAG, "onNestedPreScroll target:" + paramView + " dx:" + paramInt1 + " dy:" + paramInt2);
    AppMethodBeat.o(203444);
  }
  
  public final void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(203445);
    ad.d(this.TAG, "onNestedScroll target:" + paramView + " dxConsumed:" + paramInt1 + " dyConsumed:" + paramInt2 + " dxUnconsumed:" + paramInt3 + " dyUnconsumed:" + paramInt4);
    this.KAF += paramInt4;
    float f2 = ap.cf(getContext()).y;
    float f1 = getTranslationY() - paramInt4;
    if (0.0F < f1) {}
    for (;;)
    {
      setTranslationY(h.ar(f2, f1));
      AppMethodBeat.o(203445);
      return;
      f1 = 0.0F;
    }
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(203443);
    ad.d(this.TAG, "onStartNestedScroll");
    this.KAF = 0;
    this.KAG = false;
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(203443);
      return true;
    }
    AppMethodBeat.o(203443);
    return false;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(203446);
    if (!this.KAG)
    {
      if (this.KAF <= 0) {
        break label74;
      }
      show();
    }
    for (;;)
    {
      ad.d(this.TAG, "onStopNestedScroll child:" + paramView + ", totalConsumedY:" + this.KAF);
      this.KAF = 0;
      this.KAG = false;
      AppMethodBeat.o(203446);
      return;
      label74:
      if (this.KAF < 0) {
        hide();
      }
    }
  }
  
  public final void setContentBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(203440);
    setBackground(paramDrawable);
    AppMethodBeat.o(203440);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(203439);
    k.h(paramView, "contentView");
    addView(paramView);
    AppMethodBeat.o(203439);
  }
  
  public final void setOnVisibilityListener(b<? super Boolean, y> paramb)
  {
    this.KAH = paramb;
  }
  
  public final void show()
  {
    AppMethodBeat.i(203442);
    b localb = this.KAH;
    if (localb != null) {
      localb.aA(Boolean.TRUE);
    }
    animate().setListener(null).translationY(0.0F).start();
    AppMethodBeat.o(203442);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(203438);
      paramAnimator = this.KAI.getOnVisibilityListener();
      if (paramAnimator != null)
      {
        paramAnimator.aA(Boolean.FALSE);
        AppMethodBeat.o(203438);
        return;
      }
      AppMethodBeat.o(203438);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveBottomSheetPanel
 * JD-Core Version:    0.7.0.1
 */