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
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.b.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ax;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "direction", "fling", "", "onVisibilityListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShow", "", "getOnVisibilityListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityListener", "(Lkotlin/jvm/functions/Function1;)V", "totalConsumed", "hide", "hideNavigationBar", "window", "Landroid/view/Window;", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "child", "nestedScrollAxes", "onStopNestedScroll", "setContentBg", "background", "Landroid/graphics/drawable/Drawable;", "setContentView", "contentView", "show", "Companion", "plugin-logic_release"})
public class LiveBottomSheetPanel
  extends RelativeLayout
{
  public static final a kLb;
  private final String TAG;
  private int direction;
  private int kKY;
  private boolean kKZ;
  private b<? super Boolean, x> kLa;
  
  static
  {
    AppMethodBeat.i(190226);
    kLb = new a((byte)0);
    AppMethodBeat.o(190226);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(190223);
    AppMethodBeat.o(190223);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(190219);
    this.TAG = "MicroMsg.LiveBottomSheetPanel";
    this.direction = 1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.j.LiveBottomSheetPanel);
      p.j(paramAttributeSet, "context.obtainStyledAttr…ble.LiveBottomSheetPanel)");
      this.direction = paramAttributeSet.getInt(b.j.LiveBottomSheetPanel_sheetDirection, 1);
      paramAttributeSet.recycle();
    }
    View.inflate(paramContext, b.f.live_bottom_sheet_panel, (ViewGroup)this);
    AppMethodBeat.o(190219);
  }
  
  public static void b(Window paramWindow)
  {
    AppMethodBeat.i(190188);
    if (paramWindow != null)
    {
      paramWindow = paramWindow.getDecorView();
      p.j(paramWindow, "window.decorView");
      paramWindow.setSystemUiVisibility(7942);
    }
    AppMethodBeat.o(190188);
  }
  
  public final b<Boolean, x> getOnVisibilityListener()
  {
    return this.kLa;
  }
  
  public void hide()
  {
    AppMethodBeat.i(190178);
    if (this.direction == 0)
    {
      animate().translationX(ax.au(getContext()).x).setListener((Animator.AnimatorListener)new b(this)).start();
      AppMethodBeat.o(190178);
      return;
    }
    animate().translationY(ax.au(getContext()).y).setListener((Animator.AnimatorListener)new c(this)).start();
    AppMethodBeat.o(190178);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(190212);
    Log.d(this.TAG, "onNestedFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2 + " ViewConfiguration.getMinimumFlingVelocity():" + ViewConfiguration.getMinimumFlingVelocity());
    if (paramFloat2 > 0.0F)
    {
      this.kKZ = true;
      show();
    }
    for (;;)
    {
      paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(190212);
      return paramBoolean;
      if (paramFloat2 > 0.0F)
      {
        this.kKZ = true;
        hide();
      }
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(190192);
    Log.d(this.TAG, "onNestedPreScroll target:" + paramView + " dx:" + paramInt1 + " dy:" + paramInt2);
    AppMethodBeat.o(190192);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(190201);
    Log.d(this.TAG, "onNestedScroll target:" + paramView + " dxConsumed:" + paramInt1 + " dyConsumed:" + paramInt2 + " dxUnconsumed:" + paramInt3 + " dyUnconsumed:" + paramInt4);
    if (this.direction == 0)
    {
      this.kKY += paramInt3;
      setTranslationX(i.aQ(ax.au(getContext()).x, i.aP(0.0F, getTranslationX() - paramInt3)));
      AppMethodBeat.o(190201);
      return;
    }
    this.kKY += paramInt4;
    setTranslationY(i.aQ(ax.au(getContext()).y, i.aP(0.0F, getTranslationY() - paramInt4)));
    AppMethodBeat.o(190201);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(190191);
    Log.d(this.TAG, "onStartNestedScroll");
    this.kKY = 0;
    this.kKZ = false;
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(190191);
      return true;
    }
    AppMethodBeat.o(190191);
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(190207);
    if ((!this.kKZ) && (this.kKY != 0))
    {
      if ((this.kKY > 0) || (Math.abs(this.kKY) <= getHeight() / 5)) {
        break label101;
      }
      hide();
    }
    for (;;)
    {
      Log.d(this.TAG, "onStopNestedScroll child:" + paramView + ", totalConsumed:" + this.kKY);
      this.kKY = 0;
      this.kKZ = false;
      AppMethodBeat.o(190207);
      return;
      label101:
      show();
    }
  }
  
  public final void setContentBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(190176);
    setBackground(paramDrawable);
    AppMethodBeat.o(190176);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(190172);
    p.k(paramView, "contentView");
    addView(paramView);
    AppMethodBeat.o(190172);
  }
  
  public final void setOnVisibilityListener(b<? super Boolean, x> paramb)
  {
    this.kLa = paramb;
  }
  
  public void show()
  {
    Object localObject2 = null;
    AppMethodBeat.i(190184);
    Object localObject1 = this.kLa;
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
      AppMethodBeat.o(190184);
      return;
    }
    animate().setListener(null).translationY(0.0F).start();
    AppMethodBeat.o(190184);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/view/LiveBottomSheetPanel$Companion;", "", "()V", "DIRECTION_HORIZONTAL", "", "DIRECTION_VERTICAL", "plugin-logic_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(195625);
      paramAnimator = this.kLc.getOnVisibilityListener();
      if (paramAnimator != null)
      {
        paramAnimator.invoke(Boolean.FALSE);
        AppMethodBeat.o(195625);
        return;
      }
      AppMethodBeat.o(195625);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"})
  public static final class c
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(188970);
      paramAnimator = this.kLc.getOnVisibilityListener();
      if (paramAnimator != null)
      {
        paramAnimator.invoke(Boolean.FALSE);
        AppMethodBeat.o(188970);
        return;
      }
      AppMethodBeat.o(188970);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveBottomSheetPanel
 * JD-Core Version:    0.7.0.1
 */