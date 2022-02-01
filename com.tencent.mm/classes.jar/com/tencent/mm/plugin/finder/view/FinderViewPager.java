package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "historicalX", "", "isEnableViewPagerScroll", "", "()Z", "setEnableViewPagerScroll", "(Z)V", "isNeedInterceptFitWindow", "setNeedInterceptFitWindow", "viewRect", "Landroid/graphics/Rect;", "checkChildScrollHorizontally", "direction", "", "parent", "Landroid/view/ViewGroup;", "x", "y", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "requestFitSystemWindows", "", "CheckScrollHorizontally", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderViewPager
  extends ViewPager
{
  public static final b Companion;
  public static final String TAG = "Finder.ViewPager";
  private float historicalX;
  private boolean isEnableViewPagerScroll;
  private boolean isNeedInterceptFitWindow;
  private final Rect viewRect;
  
  static
  {
    AppMethodBeat.i(345130);
    Companion = new b((byte)0);
    AppMethodBeat.o(345130);
  }
  
  public FinderViewPager(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(345112);
    this.viewRect = new Rect();
    AppMethodBeat.o(345112);
  }
  
  public FinderViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(345118);
    this.viewRect = new Rect();
    AppMethodBeat.o(345118);
  }
  
  private final boolean checkChildScrollHorizontally(int paramInt, ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(345125);
    int k = paramViewGroup.getChildCount();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      View localView = paramViewGroup.getChildAt(i);
      if (((localView instanceof FinderViewPager.a)) && (((FinderViewPager.a)localView).a(paramInt, paramViewGroup, paramFloat1, paramFloat2)))
      {
        localView.getGlobalVisibleRect(this.viewRect);
        if (this.viewRect.contains((int)paramFloat1, (int)paramFloat2))
        {
          AppMethodBeat.o(345125);
          return true;
        }
      }
      else if (((localView instanceof ViewGroup)) && (checkChildScrollHorizontally(paramInt, (ViewGroup)localView, paramFloat1, paramFloat2)))
      {
        AppMethodBeat.o(345125);
        return true;
      }
      if (j >= k)
      {
        AppMethodBeat.o(345125);
        return false;
      }
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean isEnableViewPagerScroll()
  {
    return this.isEnableViewPagerScroll;
  }
  
  public final boolean isNeedInterceptFitWindow()
  {
    return this.isNeedInterceptFitWindow;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(345161);
    s.u(paramMotionEvent, "ev");
    if (!this.isEnableViewPagerScroll)
    {
      AppMethodBeat.o(345161);
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      this.historicalX = paramMotionEvent.getX();
    }
    while (!checkChildScrollHorizontally((int)(this.historicalX - paramMotionEvent.getX(0)), (ViewGroup)this, paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(345161);
      return bool;
    }
    AppMethodBeat.o(345161);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(345170);
    if (!this.isEnableViewPagerScroll)
    {
      AppMethodBeat.o(345170);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(345170);
    return bool;
  }
  
  public final void requestFitSystemWindows()
  {
    AppMethodBeat.i(345177);
    if (this.isNeedInterceptFitWindow)
    {
      AppMethodBeat.o(345177);
      return;
    }
    Log.i("Finder.ViewPager", "requestFitSystemWindows");
    super.requestFitSystemWindows();
    AppMethodBeat.o(345177);
  }
  
  public final void setEnableViewPagerScroll(boolean paramBoolean)
  {
    this.isEnableViewPagerScroll = paramBoolean;
  }
  
  public final void setNeedInterceptFitWindow(boolean paramBoolean)
  {
    this.isNeedInterceptFitWindow = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderViewPager
 * JD-Core Version:    0.7.0.1
 */