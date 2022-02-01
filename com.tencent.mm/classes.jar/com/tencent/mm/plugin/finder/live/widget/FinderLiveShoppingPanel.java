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
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel;", "Lcom/tencent/mm/live/view/LiveBottomSheetPanel;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "hide", "", "isLandscape", "", "onNestedFling", "target", "Landroid/view/View;", "velocityX", "", "velocityY", "consumed", "onStartNestedScroll", "child", "nestedScrollAxes", "show", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveShoppingPanel
  extends LiveBottomSheetPanel
{
  private final String TAG;
  
  public FinderLiveShoppingPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(362031);
    AppMethodBeat.o(362031);
  }
  
  public FinderLiveShoppingPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(362023);
    this.TAG = "FinderLiveShoppingPanel";
    AppMethodBeat.o(362023);
  }
  
  private final boolean isLandscape()
  {
    AppMethodBeat.i(362038);
    if (getContext().getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(362038);
      return true;
    }
    AppMethodBeat.o(362038);
    return false;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(362057);
    int i = getContext().getResources().getConfiguration().orientation;
    Log.i(this.TAG, s.X("hide orientation:", Integer.valueOf(i)));
    if (i == 2)
    {
      animate().translationX(bf.bf(getContext()).y).setListener((Animator.AnimatorListener)new a(this)).start();
      AppMethodBeat.o(362057);
      return;
    }
    super.hide();
    AppMethodBeat.o(362057);
  }
  
  public final boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(362070);
    if (!isLandscape())
    {
      paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
      AppMethodBeat.o(362070);
      return paramBoolean;
    }
    AppMethodBeat.o(362070);
    return false;
  }
  
  public final boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(362064);
    if (!isLandscape())
    {
      boolean bool = super.onStartNestedScroll(paramView1, paramView2, paramInt);
      AppMethodBeat.o(362064);
      return bool;
    }
    AppMethodBeat.o(362064);
    return false;
  }
  
  public final void show()
  {
    AppMethodBeat.i(362052);
    int i = getContext().getResources().getConfiguration().orientation;
    Log.i(this.TAG, s.X("show orientation:", Integer.valueOf(i)));
    if (i == 2)
    {
      Object localObject = getOnVisibilityListener();
      if (localObject != null) {
        ((b)localObject).invoke(Boolean.TRUE);
      }
      animate().setListener(null).translationX(0.0F).start();
      localObject = getContext();
      if ((localObject instanceof Activity))
      {
        localObject = (Activity)localObject;
        if (localObject != null) {
          break label112;
        }
      }
      label112:
      for (localObject = null;; localObject = ((Activity)localObject).getWindow())
      {
        b((Window)localObject);
        AppMethodBeat.o(362052);
        return;
        localObject = null;
        break;
      }
    }
    super.show();
    AppMethodBeat.o(362052);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(FinderLiveShoppingPanel paramFinderLiveShoppingPanel) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(361018);
      paramAnimator = this.Eux.getOnVisibilityListener();
      if (paramAnimator != null) {
        paramAnimator.invoke(Boolean.FALSE);
      }
      AppMethodBeat.o(361018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingPanel
 * JD-Core Version:    0.7.0.1
 */