package com.tencent.mm.live.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "direction", "fling", "", "onVisibilityListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShow", "", "getOnVisibilityListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityListener", "(Lkotlin/jvm/functions/Function1;)V", "totalConsumed", "hide", "hideNavigationBar", "window", "Landroid/view/Window;", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "child", "nestedScrollAxes", "onStopNestedScroll", "setContentBg", "background", "Landroid/graphics/drawable/Drawable;", "setContentView", "contentView", "show", "Companion", "plugin-logic_release"})
public class LiveBottomSheetPanel
  extends RelativeLayout
{
  public static final a hWz;
  private final String TAG;
  private int direction;
  private int hWw;
  private boolean hWx;
  private b<? super Boolean, x> hWy;
  
  static
  {
    AppMethodBeat.i(208562);
    hWz = new a((byte)0);
    AppMethodBeat.o(208562);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(208561);
    AppMethodBeat.o(208561);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208560);
    this.TAG = "MicroMsg.LiveBottomSheetPanel";
    this.direction = 1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.a.LiveBottomSheetPanel);
      p.g(paramAttributeSet, "context.obtainStyledAttr…ble.LiveBottomSheetPanel)");
      this.direction = paramAttributeSet.getInt(0, 1);
      paramAttributeSet.recycle();
    }
    View.inflate(paramContext, 2131495243, (ViewGroup)this);
    AppMethodBeat.o(208560);
  }
  
  public static void b(Window paramWindow)
  {
    AppMethodBeat.i(208554);
    if (paramWindow != null)
    {
      paramWindow = paramWindow.getDecorView();
      p.g(paramWindow, "window.decorView");
      paramWindow.setSystemUiVisibility(7942);
    }
    AppMethodBeat.o(208554);
  }
  
  public final b<Boolean, x> getOnVisibilityListener()
  {
    return this.hWy;
  }
  
  public void hide()
  {
    AppMethodBeat.i(208552);
    if (this.direction == 0)
    {
      animate().translationX(au.az(getContext()).x).setListener((Animator.AnimatorListener)new b(this)).start();
      AppMethodBeat.o(208552);
      return;
    }
    animate().translationY(au.az(getContext()).y).setListener((Animator.AnimatorListener)new c(this)).start();
    AppMethodBeat.o(208552);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(208559);
    Log.d(this.TAG, "onNestedFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2 + " ViewConfiguration.getMinimumFlingVelocity():" + ViewConfiguration.getMinimumFlingVelocity());
    if (paramFloat2 > 0.0F)
    {
      this.hWx = true;
      show();
    }
    for (;;)
    {
      paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(208559);
      return paramBoolean;
      if (paramFloat2 > 0.0F)
      {
        this.hWx = true;
        hide();
      }
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(208556);
    Log.d(this.TAG, "onNestedPreScroll target:" + paramView + " dx:" + paramInt1 + " dy:" + paramInt2);
    AppMethodBeat.o(208556);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(208557);
    Log.d(this.TAG, "onNestedScroll target:" + paramView + " dxConsumed:" + paramInt1 + " dyConsumed:" + paramInt2 + " dxUnconsumed:" + paramInt3 + " dyUnconsumed:" + paramInt4);
    if (this.direction == 0)
    {
      this.hWw += paramInt3;
      setTranslationX(j.aJ(au.az(getContext()).x, j.aI(0.0F, getTranslationX() - paramInt3)));
      AppMethodBeat.o(208557);
      return;
    }
    this.hWw += paramInt4;
    setTranslationY(j.aJ(au.az(getContext()).y, j.aI(0.0F, getTranslationY() - paramInt4)));
    AppMethodBeat.o(208557);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(208555);
    Log.d(this.TAG, "onStartNestedScroll");
    this.hWw = 0;
    this.hWx = false;
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(208555);
      return true;
    }
    AppMethodBeat.o(208555);
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(208558);
    if (!this.hWx)
    {
      if (this.hWw <= 0) {
        break label78;
      }
      show();
    }
    for (;;)
    {
      Log.d(this.TAG, "onStopNestedScroll child:" + paramView + ", totalConsumed:" + this.hWw);
      this.hWw = 0;
      this.hWx = false;
      AppMethodBeat.o(208558);
      return;
      label78:
      if (this.hWw < 0) {
        hide();
      }
    }
  }
  
  public final void setContentBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(208551);
    setBackground(paramDrawable);
    AppMethodBeat.o(208551);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(208550);
    p.h(paramView, "contentView");
    addView(paramView);
    AppMethodBeat.o(208550);
  }
  
  public final void setOnVisibilityListener(b<? super Boolean, x> paramb)
  {
    this.hWy = paramb;
  }
  
  public void show()
  {
    Object localObject2 = null;
    AppMethodBeat.i(208553);
    Object localObject1 = this.hWy;
    if (localObject1 != null) {
      ((b)localObject1).invoke(Boolean.TRUE);
    }
    if (this.direction == 0)
    {
      animate().setListener(null).translationX(0.0F).start();
      Object localObject3 = getContext();
      localObject1 = localObject3;
      if (!(localObject3 instanceof Activity)) {
        localObject1 = null;
      }
      localObject3 = (Activity)localObject1;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((Activity)localObject3).getWindow();
      }
      b((Window)localObject1);
      AppMethodBeat.o(208553);
      return;
    }
    animate().setListener(null).translationY(0.0F).start();
    AppMethodBeat.o(208553);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/view/LiveBottomSheetPanel$Companion;", "", "()V", "DIRECTION_HORIZONTAL", "", "DIRECTION_VERTICAL", "plugin-logic_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(208548);
      paramAnimator = this.hWA.getOnVisibilityListener();
      if (paramAnimator != null)
      {
        paramAnimator.invoke(Boolean.FALSE);
        AppMethodBeat.o(208548);
        return;
      }
      AppMethodBeat.o(208548);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(208549);
      paramAnimator = this.hWA.getOnVisibilityListener();
      if (paramAnimator != null)
      {
        paramAnimator.invoke(Boolean.FALSE);
        AppMethodBeat.o(208549);
        return;
      }
      AppMethodBeat.o(208549);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveBottomSheetPanel
 * JD-Core Version:    0.7.0.1
 */