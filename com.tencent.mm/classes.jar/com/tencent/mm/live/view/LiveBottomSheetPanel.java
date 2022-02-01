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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ap;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "fling", "", "onVisibilityListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShow", "", "getOnVisibilityListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityListener", "(Lkotlin/jvm/functions/Function1;)V", "totalConsumedY", "hide", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "child", "nestedScrollAxes", "onStopNestedScroll", "setContentBg", "background", "Landroid/graphics/drawable/Drawable;", "setContentView", "contentView", "show", "plugin-logic_release"})
public final class LiveBottomSheetPanel
  extends RelativeLayout
{
  private final String TAG;
  private int gHn;
  private boolean gHo;
  private b<? super Boolean, y> gHp;
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(190677);
    AppMethodBeat.o(190677);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190676);
    this.TAG = "MicroMsg.LiveBottomSheetPanel";
    View.inflate(paramContext, 2131496304, (ViewGroup)this);
    AppMethodBeat.o(190676);
  }
  
  public final b<Boolean, y> getOnVisibilityListener()
  {
    return this.gHp;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(190669);
    animate().translationY(ap.cl(getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    AppMethodBeat.o(190669);
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(190675);
    ac.d(this.TAG, "onNestedFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2 + " ViewConfiguration.getMinimumFlingVelocity():" + ViewConfiguration.getMinimumFlingVelocity());
    if (paramFloat2 > 0.0F)
    {
      this.gHo = true;
      show();
    }
    for (;;)
    {
      paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(190675);
      return paramBoolean;
      if (paramFloat2 > 0.0F)
      {
        this.gHo = true;
        hide();
      }
    }
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(190672);
    ac.d(this.TAG, "onNestedPreScroll target:" + paramView + " dx:" + paramInt1 + " dy:" + paramInt2);
    AppMethodBeat.o(190672);
  }
  
  public final void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190673);
    ac.d(this.TAG, "onNestedScroll target:" + paramView + " dxConsumed:" + paramInt1 + " dyConsumed:" + paramInt2 + " dxUnconsumed:" + paramInt3 + " dyUnconsumed:" + paramInt4);
    this.gHn += paramInt4;
    float f2 = ap.cl(getContext()).y;
    float f1 = getTranslationY() - paramInt4;
    if (0.0F < f1) {
      if (f2 <= f1) {
        break label133;
      }
    }
    for (;;)
    {
      setTranslationY(f1);
      AppMethodBeat.o(190673);
      return;
      f1 = 0.0F;
      break;
      label133:
      f1 = f2;
    }
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(190671);
    ac.d(this.TAG, "onStartNestedScroll");
    this.gHn = 0;
    this.gHo = false;
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(190671);
      return true;
    }
    AppMethodBeat.o(190671);
    return false;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(190674);
    if (!this.gHo)
    {
      if (this.gHn <= 0) {
        break label74;
      }
      show();
    }
    for (;;)
    {
      ac.d(this.TAG, "onStopNestedScroll child:" + paramView + ", totalConsumedY:" + this.gHn);
      this.gHn = 0;
      this.gHo = false;
      AppMethodBeat.o(190674);
      return;
      label74:
      if (this.gHn < 0) {
        hide();
      }
    }
  }
  
  public final void setContentBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(190668);
    setBackground(paramDrawable);
    AppMethodBeat.o(190668);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(190667);
    k.h(paramView, "contentView");
    addView(paramView);
    AppMethodBeat.o(190667);
  }
  
  public final void setOnVisibilityListener(b<? super Boolean, y> paramb)
  {
    this.gHp = paramb;
  }
  
  public final void show()
  {
    AppMethodBeat.i(190670);
    b localb = this.gHp;
    if (localb != null) {
      localb.ay(Boolean.TRUE);
    }
    animate().setListener(null).translationY(0.0F).start();
    AppMethodBeat.o(190670);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(190666);
      paramAnimator = this.gHq.getOnVisibilityListener();
      if (paramAnimator != null)
      {
        paramAnimator.ay(Boolean.FALSE);
        AppMethodBeat.o(190666);
        return;
      }
      AppMethodBeat.o(190666);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveBottomSheetPanel
 * JD-Core Version:    0.7.0.1
 */