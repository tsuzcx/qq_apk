package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "Landroid/support/v4/view/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "historicalX", "", "isEnableViewPagerScroll", "", "viewRect", "Landroid/graphics/Rect;", "checkChildScrollHorizontally", "direction", "", "parent", "Landroid/view/ViewGroup;", "x", "y", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "CheckScrollHorizontally", "Companion", "plugin-finder_release"})
public final class FinderViewPager
  extends ViewPager
{
  public static final b Companion;
  public static final String TAG = "Finder.ViewPager";
  private HashMap _$_findViewCache;
  private float historicalX;
  private final boolean isEnableViewPagerScroll;
  private final Rect viewRect;
  
  static
  {
    AppMethodBeat.i(205241);
    Companion = new b((byte)0);
    AppMethodBeat.o(205241);
  }
  
  public FinderViewPager(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205239);
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGR().value()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isEnableViewPagerScroll = bool;
      this.viewRect = new Rect();
      AppMethodBeat.o(205239);
      return;
    }
  }
  
  public FinderViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205240);
    paramContext = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cGR().value()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isEnableViewPagerScroll = bool;
      this.viewRect = new Rect();
      AppMethodBeat.o(205240);
      return;
    }
  }
  
  private final boolean checkChildScrollHorizontally(int paramInt, ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205236);
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if (((localView instanceof a)) && (((a)localView).a(paramInt, paramViewGroup)))
      {
        localView.getGlobalVisibleRect(this.viewRect);
        if (this.viewRect.contains((int)paramFloat1, (int)paramFloat2))
        {
          AppMethodBeat.o(205236);
          return true;
        }
      }
      else if (((localView instanceof ViewGroup)) && (checkChildScrollHorizontally(paramInt, (ViewGroup)localView, paramFloat1, paramFloat2)))
      {
        AppMethodBeat.o(205236);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(205236);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(205243);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(205243);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(205242);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(205242);
    return localView1;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205237);
    p.h(paramMotionEvent, "ev");
    if (!this.isEnableViewPagerScroll)
    {
      AppMethodBeat.o(205237);
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      this.historicalX = paramMotionEvent.getX();
    }
    while (!checkChildScrollHorizontally((int)(this.historicalX - paramMotionEvent.getX(0)), (ViewGroup)this, paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(205237);
      return bool;
    }
    AppMethodBeat.o(205237);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205238);
    if (!this.isEnableViewPagerScroll)
    {
      AppMethodBeat.o(205238);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(205238);
    return bool;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "", "canScrollHorizontally", "", "direction", "", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean a(int paramInt, ViewGroup paramViewGroup);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderViewPager
 * JD-Core Version:    0.7.0.1
 */