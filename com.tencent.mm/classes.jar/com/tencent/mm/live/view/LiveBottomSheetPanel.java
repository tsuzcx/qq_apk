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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.ar;
import d.g.a.b;
import d.g.b.p;
import d.k.j;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "fling", "", "onVisibilityListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShow", "", "getOnVisibilityListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityListener", "(Lkotlin/jvm/functions/Function1;)V", "totalConsumedY", "hide", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "child", "nestedScrollAxes", "onStopNestedScroll", "setContentBg", "background", "Landroid/graphics/drawable/Drawable;", "setContentView", "contentView", "show", "plugin-logic_release"})
public final class LiveBottomSheetPanel
  extends RelativeLayout
{
  private final String TAG;
  private int hdL;
  private boolean hdM;
  private b<? super Boolean, z> hdN;
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(216597);
    AppMethodBeat.o(216597);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(216596);
    this.TAG = "MicroMsg.LiveBottomSheetPanel";
    View.inflate(paramContext, 2131496304, (ViewGroup)this);
    AppMethodBeat.o(216596);
  }
  
  public final b<Boolean, z> getOnVisibilityListener()
  {
    return this.hdN;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(216589);
    animate().translationY(ar.ck(getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    AppMethodBeat.o(216589);
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(216595);
    ae.d(this.TAG, "onNestedFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2 + " ViewConfiguration.getMinimumFlingVelocity():" + ViewConfiguration.getMinimumFlingVelocity());
    if (paramFloat2 > 0.0F)
    {
      this.hdM = true;
      show();
    }
    for (;;)
    {
      paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(216595);
      return paramBoolean;
      if (paramFloat2 > 0.0F)
      {
        this.hdM = true;
        hide();
      }
    }
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(216592);
    ae.d(this.TAG, "onNestedPreScroll target:" + paramView + " dx:" + paramInt1 + " dy:" + paramInt2);
    AppMethodBeat.o(216592);
  }
  
  public final void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(216593);
    ae.d(this.TAG, "onNestedScroll target:" + paramView + " dxConsumed:" + paramInt1 + " dyConsumed:" + paramInt2 + " dxUnconsumed:" + paramInt3 + " dyUnconsumed:" + paramInt4);
    this.hdL += paramInt4;
    setTranslationY(j.aw(ar.ck(getContext()).y, j.av(0.0F, getTranslationY() - paramInt4)));
    AppMethodBeat.o(216593);
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(216591);
    ae.d(this.TAG, "onStartNestedScroll");
    this.hdL = 0;
    this.hdM = false;
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(216591);
      return true;
    }
    AppMethodBeat.o(216591);
    return false;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(216594);
    if (!this.hdM)
    {
      if (this.hdL <= 0) {
        break label74;
      }
      show();
    }
    for (;;)
    {
      ae.d(this.TAG, "onStopNestedScroll child:" + paramView + ", totalConsumedY:" + this.hdL);
      this.hdL = 0;
      this.hdM = false;
      AppMethodBeat.o(216594);
      return;
      label74:
      if (this.hdL < 0) {
        hide();
      }
    }
  }
  
  public final void setContentBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(216588);
    setBackground(paramDrawable);
    AppMethodBeat.o(216588);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(216587);
    p.h(paramView, "contentView");
    addView(paramView);
    AppMethodBeat.o(216587);
  }
  
  public final void setOnVisibilityListener(b<? super Boolean, z> paramb)
  {
    this.hdN = paramb;
  }
  
  public final void show()
  {
    AppMethodBeat.i(216590);
    b localb = this.hdN;
    if (localb != null) {
      localb.invoke(Boolean.TRUE);
    }
    animate().setListener(null).translationY(0.0F).start();
    AppMethodBeat.o(216590);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(216586);
      paramAnimator = this.hdO.getOnVisibilityListener();
      if (paramAnimator != null)
      {
        paramAnimator.invoke(Boolean.FALSE);
        AppMethodBeat.o(216586);
        return;
      }
      AppMethodBeat.o(216586);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveBottomSheetPanel
 * JD-Core Version:    0.7.0.1
 */