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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "Landroid/support/v4/view/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "historicalX", "", "isEnableViewPagerScroll", "", "viewRect", "Landroid/graphics/Rect;", "checkChildScrollHorizontally", "direction", "", "parent", "Landroid/view/ViewGroup;", "x", "y", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "CheckScrollHorizontally", "Companion", "plugin-finder_release"})
public final class FinderViewPager
  extends ViewPager
{
  public static final FinderViewPager.b Companion;
  public static final String TAG = "Finder.ViewPager";
  private HashMap _$_findViewCache;
  private float historicalX;
  private final boolean isEnableViewPagerScroll;
  private final Rect viewRect;
  
  static
  {
    AppMethodBeat.i(205883);
    Companion = new FinderViewPager.b((byte)0);
    AppMethodBeat.o(205883);
  }
  
  public FinderViewPager(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(205881);
    paramContext = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cIQ().value()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isEnableViewPagerScroll = bool;
      this.viewRect = new Rect();
      AppMethodBeat.o(205881);
      return;
    }
  }
  
  public FinderViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(205882);
    paramContext = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cIQ().value()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.isEnableViewPagerScroll = bool;
      this.viewRect = new Rect();
      AppMethodBeat.o(205882);
      return;
    }
  }
  
  private final boolean checkChildScrollHorizontally(int paramInt, ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(205878);
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
          AppMethodBeat.o(205878);
          return true;
        }
      }
      else if (((localView instanceof ViewGroup)) && (checkChildScrollHorizontally(paramInt, (ViewGroup)localView, paramFloat1, paramFloat2)))
      {
        AppMethodBeat.o(205878);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(205878);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(205885);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(205885);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(205884);
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
    AppMethodBeat.o(205884);
    return localView1;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205879);
    p.h(paramMotionEvent, "ev");
    if (!this.isEnableViewPagerScroll)
    {
      AppMethodBeat.o(205879);
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      this.historicalX = paramMotionEvent.getX();
    }
    while (!checkChildScrollHorizontally((int)(this.historicalX - paramMotionEvent.getX(0)), (ViewGroup)this, paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(205879);
      return bool;
    }
    AppMethodBeat.o(205879);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(205880);
    if (!this.isEnableViewPagerScroll)
    {
      AppMethodBeat.o(205880);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(205880);
    return bool;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "", "canScrollHorizontally", "", "direction", "", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean a(int paramInt, ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderViewPager
 * JD-Core Version:    0.7.0.1
 */