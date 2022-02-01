package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.view.LiveBottomSheetPanel;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel;", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "hide", "", "isLandscape", "", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onStartNestedScroll", "child", "nestedScrollAxes", "show", "plugin-finder_release"})
public final class FinderLiveShoppingPanel
  extends LiveBottomSheetPanel
{
  private final String TAG;
  
  public FinderLiveShoppingPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(248135);
    AppMethodBeat.o(248135);
  }
  
  public FinderLiveShoppingPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(248134);
    this.TAG = "FinderLiveShoppingPanel";
    AppMethodBeat.o(248134);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(248131);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "context.resources");
    if (((Resources)localObject).getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(248131);
      return true;
    }
    AppMethodBeat.o(248131);
    return false;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(248130);
    Object localObject = getContext();
    p.g(localObject, "context");
    localObject = ((Context)localObject).getResources();
    p.g(localObject, "context.resources");
    int i = ((Resources)localObject).getConfiguration().orientation;
    Log.i(this.TAG, "hide orientation:".concat(String.valueOf(i)));
    if (i == 2)
    {
      animate().translationX(au.az(getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
      AppMethodBeat.o(248130);
      return;
    }
    super.hide();
    AppMethodBeat.o(248130);
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(248133);
    if (!isLandscape())
    {
      paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(248133);
      return paramBoolean;
    }
    AppMethodBeat.o(248133);
    return false;
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(248132);
    if (!isLandscape())
    {
      boolean bool = super.onStartNestedScroll(paramView1, paramView2, paramInt);
      AppMethodBeat.o(248132);
      return bool;
    }
    AppMethodBeat.o(248132);
    return false;
  }
  
  public final void show()
  {
    Object localObject2 = null;
    AppMethodBeat.i(248129);
    Object localObject1 = getContext();
    p.g(localObject1, "context");
    localObject1 = ((Context)localObject1).getResources();
    p.g(localObject1, "context.resources");
    int i = ((Resources)localObject1).getConfiguration().orientation;
    Log.i(this.TAG, "show orientation:".concat(String.valueOf(i)));
    if (i == 2)
    {
      localObject1 = getOnVisibilityListener();
      if (localObject1 != null) {
        ((b)localObject1).invoke(Boolean.TRUE);
      }
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
      AppMethodBeat.o(248129);
      return;
    }
    super.show();
    AppMethodBeat.o(248129);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
  public static final class a
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(248128);
      paramAnimator = this.uHd.getOnVisibilityListener();
      if (paramAnimator != null)
      {
        paramAnimator.invoke(Boolean.FALSE);
        AppMethodBeat.o(248128);
        return;
      }
      AppMethodBeat.o(248128);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingPanel
 * JD-Core Version:    0.7.0.1
 */