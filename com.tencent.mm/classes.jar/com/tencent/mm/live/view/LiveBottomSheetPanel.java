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
import com.tencent.mm.ui.ar;
import d.g.a.b;
import d.g.b.p;
import d.k.h;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "fling", "", "onVisibilityListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShow", "", "getOnVisibilityListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityListener", "(Lkotlin/jvm/functions/Function1;)V", "totalConsumedY", "hide", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "child", "nestedScrollAxes", "onStopNestedScroll", "setContentBg", "background", "Landroid/graphics/drawable/Drawable;", "setContentView", "contentView", "show", "plugin-logic_release"})
public final class LiveBottomSheetPanel
  extends RelativeLayout
{
  private final String TAG;
  private int haX;
  private boolean haY;
  private b<? super Boolean, z> haZ;
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(212967);
    AppMethodBeat.o(212967);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(212966);
    this.TAG = "MicroMsg.LiveBottomSheetPanel";
    View.inflate(paramContext, 2131496304, (ViewGroup)this);
    AppMethodBeat.o(212966);
  }
  
  public final b<Boolean, z> getOnVisibilityListener()
  {
    return this.haZ;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(212959);
    animate().translationY(ar.ci(getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
    AppMethodBeat.o(212959);
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(212965);
    ad.d(this.TAG, "onNestedFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2 + " ViewConfiguration.getMinimumFlingVelocity():" + ViewConfiguration.getMinimumFlingVelocity());
    if (paramFloat2 > 0.0F)
    {
      this.haY = true;
      show();
    }
    for (;;)
    {
      paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(212965);
      return paramBoolean;
      if (paramFloat2 > 0.0F)
      {
        this.haY = true;
        hide();
      }
    }
  }
  
  public final void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(212962);
    ad.d(this.TAG, "onNestedPreScroll target:" + paramView + " dx:" + paramInt1 + " dy:" + paramInt2);
    AppMethodBeat.o(212962);
  }
  
  public final void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(212963);
    ad.d(this.TAG, "onNestedScroll target:" + paramView + " dxConsumed:" + paramInt1 + " dyConsumed:" + paramInt2 + " dxUnconsumed:" + paramInt3 + " dyUnconsumed:" + paramInt4);
    this.haX += paramInt4;
    setTranslationY(h.aw(ar.ci(getContext()).y, h.av(0.0F, getTranslationY() - paramInt4)));
    AppMethodBeat.o(212963);
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(212961);
    ad.d(this.TAG, "onStartNestedScroll");
    this.haX = 0;
    this.haY = false;
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(212961);
      return true;
    }
    AppMethodBeat.o(212961);
    return false;
  }
  
  public final void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(212964);
    if (!this.haY)
    {
      if (this.haX <= 0) {
        break label74;
      }
      show();
    }
    for (;;)
    {
      ad.d(this.TAG, "onStopNestedScroll child:" + paramView + ", totalConsumedY:" + this.haX);
      this.haX = 0;
      this.haY = false;
      AppMethodBeat.o(212964);
      return;
      label74:
      if (this.haX < 0) {
        hide();
      }
    }
  }
  
  public final void setContentBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(212958);
    setBackground(paramDrawable);
    AppMethodBeat.o(212958);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(212957);
    p.h(paramView, "contentView");
    addView(paramView);
    AppMethodBeat.o(212957);
  }
  
  public final void setOnVisibilityListener(b<? super Boolean, z> paramb)
  {
    this.haZ = paramb;
  }
  
  public final void show()
  {
    AppMethodBeat.i(212960);
    b localb = this.haZ;
    if (localb != null) {
      localb.invoke(Boolean.TRUE);
    }
    animate().setListener(null).translationY(0.0F).start();
    AppMethodBeat.o(212960);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(212956);
      paramAnimator = this.hba.getOnVisibilityListener();
      if (paramAnimator != null)
      {
        paramAnimator.invoke(Boolean.FALSE);
        AppMethodBeat.o(212956);
        return;
      }
      AppMethodBeat.o(212956);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveBottomSheetPanel
 * JD-Core Version:    0.7.0.1
 */