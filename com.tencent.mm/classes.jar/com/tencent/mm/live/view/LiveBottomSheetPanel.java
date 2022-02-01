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
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "direction", "getDirection", "()I", "setDirection", "(I)V", "fling", "", "onVisibilityListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isShow", "", "getOnVisibilityListener", "()Lkotlin/jvm/functions/Function1;", "setOnVisibilityListener", "(Lkotlin/jvm/functions/Function1;)V", "totalConsumed", "hide", "hideNavigationBar", "window", "Landroid/view/Window;", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onNestedPreScroll", "dx", "dy", "", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "child", "nestedScrollAxes", "onStopNestedScroll", "setContentBg", "background", "Landroid/graphics/drawable/Drawable;", "setContentView", "contentView", "show", "Companion", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public class LiveBottomSheetPanel
  extends RelativeLayout
{
  public static final LiveBottomSheetPanel.a nnb;
  private final String TAG;
  private int direction;
  private int nnc;
  private boolean nnd;
  private b<? super Boolean, ah> nne;
  
  static
  {
    AppMethodBeat.i(246120);
    nnb = new LiveBottomSheetPanel.a((byte)0);
    AppMethodBeat.o(246120);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(246111);
    AppMethodBeat.o(246111);
  }
  
  public LiveBottomSheetPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246101);
    this.TAG = "MicroMsg.LiveBottomSheetPanel";
    this.direction = 1;
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, b.j.LiveBottomSheetPanel);
      s.s(paramAttributeSet, "context.obtainStyledAttr…ble.LiveBottomSheetPanel)");
      this.direction = paramAttributeSet.getInt(b.j.LiveBottomSheetPanel_sheetDirection, 1);
      paramAttributeSet.recycle();
    }
    View.inflate(paramContext, b.f.live_bottom_sheet_panel, (ViewGroup)this);
    AppMethodBeat.o(246101);
  }
  
  public static void b(Window paramWindow)
  {
    AppMethodBeat.i(246114);
    if (paramWindow != null) {
      paramWindow.getDecorView().setSystemUiVisibility(7942);
    }
    AppMethodBeat.o(246114);
  }
  
  protected final int getDirection()
  {
    return this.direction;
  }
  
  public final b<Boolean, ah> getOnVisibilityListener()
  {
    return this.nne;
  }
  
  public void hide()
  {
    AppMethodBeat.i(246155);
    if (this.direction == 0)
    {
      animate().translationX(bf.bf(getContext()).x).setListener((Animator.AnimatorListener)new b(this)).start();
      AppMethodBeat.o(246155);
      return;
    }
    animate().translationY(bf.bf(getContext()).y).setListener((Animator.AnimatorListener)new c(this)).start();
    AppMethodBeat.o(246155);
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(246192);
    Log.d(this.TAG, "onNestedFling velocityX:" + paramFloat1 + " velocityY:" + paramFloat2 + " ViewConfiguration.getMinimumFlingVelocity():" + ViewConfiguration.getMinimumFlingVelocity());
    if (paramFloat2 > 0.0F)
    {
      this.nnd = true;
      show();
    }
    for (;;)
    {
      paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(246192);
      return paramBoolean;
      if (paramFloat2 > 0.0F)
      {
        this.nnd = true;
        hide();
      }
    }
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(246171);
    Log.d(this.TAG, "onNestedPreScroll target:" + paramView + " dx:" + paramInt1 + " dy:" + paramInt2);
    AppMethodBeat.o(246171);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(246175);
    Log.d(this.TAG, "onNestedScroll target:" + paramView + " dxConsumed:" + paramInt1 + " dyConsumed:" + paramInt2 + " dxUnconsumed:" + paramInt3 + " dyUnconsumed:" + paramInt4);
    if (this.direction == 0)
    {
      this.nnc += paramInt3;
      setTranslationX(k.bu(bf.bf(getContext()).x, k.bt(0.0F, getTranslationX() - paramInt3)));
      AppMethodBeat.o(246175);
      return;
    }
    this.nnc += paramInt4;
    setTranslationY(k.bu(bf.bf(getContext()).y, k.bt(0.0F, getTranslationY() - paramInt4)));
    AppMethodBeat.o(246175);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(246167);
    Log.d(this.TAG, "onStartNestedScroll target:" + paramView2 + ",nestedScrollAxes:" + paramInt);
    this.nnc = 0;
    this.nnd = false;
    if ((paramInt & 0x2) != 0)
    {
      AppMethodBeat.o(246167);
      return true;
    }
    AppMethodBeat.o(246167);
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(246183);
    if ((!this.nnd) && (this.nnc != 0))
    {
      if ((this.nnc > 0) || (Math.abs(this.nnc) <= getHeight() / 5)) {
        break label101;
      }
      hide();
    }
    for (;;)
    {
      Log.d(this.TAG, "onStopNestedScroll child:" + paramView + ", totalConsumed:" + this.nnc);
      this.nnc = 0;
      this.nnd = false;
      AppMethodBeat.o(246183);
      return;
      label101:
      show();
    }
  }
  
  public final void setContentBg(Drawable paramDrawable)
  {
    AppMethodBeat.i(246152);
    setBackground(paramDrawable);
    AppMethodBeat.o(246152);
  }
  
  public final void setContentView(View paramView)
  {
    AppMethodBeat.i(246145);
    s.u(paramView, "contentView");
    addView(paramView);
    AppMethodBeat.o(246145);
  }
  
  protected final void setDirection(int paramInt)
  {
    this.direction = paramInt;
  }
  
  public final void setOnVisibilityListener(b<? super Boolean, ah> paramb)
  {
    this.nne = paramb;
  }
  
  public void show()
  {
    AppMethodBeat.i(246161);
    Object localObject = this.nne;
    if (localObject != null) {
      ((b)localObject).invoke(Boolean.TRUE);
    }
    if (this.direction == 0)
    {
      animate().setListener(null).translationX(0.0F).start();
      localObject = getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        if (localObject != null) {
          break label86;
        }
      }
      label86:
      for (localObject = null;; localObject = ((Activity)localObject).getWindow())
      {
        b((Window)localObject);
        AppMethodBeat.o(246161);
        return;
        localObject = null;
        break;
      }
    }
    animate().setListener(null).translationY(0.0F).start();
    AppMethodBeat.o(246161);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(LiveBottomSheetPanel paramLiveBottomSheetPanel) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(246021);
      paramAnimator = this.nnf.getOnVisibilityListener();
      if (paramAnimator != null) {
        paramAnimator.invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(246021);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/live/view/LiveBottomSheetPanel$hide$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(LiveBottomSheetPanel paramLiveBottomSheetPanel) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(246020);
      paramAnimator = this.nnf.getOnVisibilityListener();
      if (paramAnimator != null) {
        paramAnimator.invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(246020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.view.LiveBottomSheetPanel
 * JD-Core Version:    0.7.0.1
 */