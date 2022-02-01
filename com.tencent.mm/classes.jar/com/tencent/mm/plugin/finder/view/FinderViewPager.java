package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "historicalX", "", "isEnableViewPagerScroll", "", "()Z", "setEnableViewPagerScroll", "(Z)V", "viewRect", "Landroid/graphics/Rect;", "checkChildScrollHorizontally", "direction", "", "parent", "Landroid/view/ViewGroup;", "x", "y", "enableScrollHorizontall", "Landroid/view/View;", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "CheckScrollHorizontally", "Companion", "plugin-finder_release"})
public final class FinderViewPager
  extends ViewPager
{
  public static final b Companion;
  public static final String TAG = "Finder.ViewPager";
  private HashMap _$_findViewCache;
  private float historicalX;
  private boolean isEnableViewPagerScroll;
  private final Rect viewRect;
  
  static
  {
    AppMethodBeat.i(290388);
    Companion = new b((byte)0);
    AppMethodBeat.o(290388);
  }
  
  public FinderViewPager(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(290386);
    this.viewRect = new Rect();
    AppMethodBeat.o(290386);
  }
  
  public FinderViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(290387);
    this.viewRect = new Rect();
    AppMethodBeat.o(290387);
  }
  
  private final boolean checkChildScrollHorizontally(int paramInt, ViewGroup paramViewGroup, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(290382);
    int j = paramViewGroup.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      p.j(localView, "view");
      if (enableScrollHorizontall(localView, paramFloat1, paramFloat2))
      {
        AppMethodBeat.o(290382);
        return true;
      }
      if (((localView instanceof a)) && (((a)localView).a(paramInt, paramViewGroup)))
      {
        localView.getGlobalVisibleRect(this.viewRect);
        if (this.viewRect.contains((int)paramFloat1, (int)paramFloat2))
        {
          AppMethodBeat.o(290382);
          return true;
        }
      }
      else if (((localView instanceof ViewGroup)) && (checkChildScrollHorizontally(paramInt, (ViewGroup)localView, paramFloat1, paramFloat2)))
      {
        AppMethodBeat.o(290382);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(290382);
    return false;
  }
  
  private final boolean enableScrollHorizontall(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(290383);
    paramView = paramView.findViewById(b.f.live_list_layout);
    if (paramView != null)
    {
      paramView.getGlobalVisibleRect(this.viewRect);
      if (this.viewRect.contains((int)paramFloat1, (int)paramFloat2))
      {
        AppMethodBeat.o(290383);
        return true;
      }
    }
    AppMethodBeat.o(290383);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(290390);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(290390);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(290389);
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
    AppMethodBeat.o(290389);
    return localView1;
  }
  
  public final boolean isEnableViewPagerScroll()
  {
    return this.isEnableViewPagerScroll;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290384);
    p.k(paramMotionEvent, "ev");
    if (!this.isEnableViewPagerScroll)
    {
      AppMethodBeat.o(290384);
      return false;
    }
    if (paramMotionEvent.getAction() == 0) {
      this.historicalX = paramMotionEvent.getX();
    }
    while (!checkChildScrollHorizontally((int)(this.historicalX - paramMotionEvent.getX(0)), (ViewGroup)this, paramMotionEvent.getX(), paramMotionEvent.getY()))
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(290384);
      return bool;
    }
    AppMethodBeat.o(290384);
    return false;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(290385);
    if (!this.isEnableViewPagerScroll)
    {
      AppMethodBeat.o(290385);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(290385);
    return bool;
  }
  
  public final void setEnableViewPagerScroll(boolean paramBoolean)
  {
    this.isEnableViewPagerScroll = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "", "canScrollHorizontally", "", "direction", "", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract boolean a(int paramInt, ViewGroup paramViewGroup);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/FinderViewPager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderViewPager
 * JD-Core Version:    0.7.0.1
 */