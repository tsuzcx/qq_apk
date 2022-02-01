package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.plugin.findersdk.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "(II)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "smoothScrollToPositionInCenter", "Companion", "FinderStaggeredGridSmoothScroller", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderStaggeredGridLayoutManager
  extends StaggeredGridLayoutManager
{
  public static final FinderStaggeredGridLayoutManager.a GHW;
  
  static
  {
    AppMethodBeat.i(168540);
    GHW = new FinderStaggeredGridLayoutManager.a((byte)0);
    AppMethodBeat.o(168540);
  }
  
  public FinderStaggeredGridLayoutManager(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public FinderStaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final void bo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(346154);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt1 + " offset=" + paramInt2);
    }
    super.bo(paramInt1, paramInt2);
    AppMethodBeat.o(346154);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(346121);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(346121);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)paramn, "", new Object[0]);
      AppMethodBeat.o(346121);
      return;
    }
    catch (IllegalStateException paramn)
    {
      Log.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)paramn, "", new Object[0]);
      e.a.a((e)b.HbT, "onLayoutChildren_error", false, null, false, (a)FinderStaggeredGridLayoutManager.c.GHX, 28);
      AppMethodBeat.o(346121);
    }
  }
  
  public void requestSimpleAnimationsInNextLayout()
  {
    AppMethodBeat.i(168539);
    super.requestSimpleAnimationsInNextLayout();
    try
    {
      Method localMethod = RecyclerView.class.getDeclaredMethod("Kl", new Class[0]);
      localMethod.setAccessible(true);
      Object localObject = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        localMethod.invoke(localObject, new Object[0]);
        Log.i("Finder.StaggeredGridLayoutManager", "markItemDecorInsetsDirty");
        AppMethodBeat.o(168539);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(168539);
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(346147);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt + ' ');
    }
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(346147);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(346131);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[scrollVerticallyBy] dy=" + paramInt + " state=" + params);
    }
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    AppMethodBeat.o(346131);
    return paramInt;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(346139);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[smoothScrollToPosition] position=" + paramInt + " state=" + params);
    }
    super.smoothScrollToPosition(paramRecyclerView, params, paramInt);
    AppMethodBeat.o(346139);
  }
  
  public final void u(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(346168);
    s.u(paramRecyclerView, "recyclerView");
    long l = System.currentTimeMillis();
    MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
    s.s(localMotionEvent, "obtain(currentTime,curre…nt.ACTION_CANCEL,0f,0f,0)");
    ViewParent localViewParent = paramRecyclerView.getParent();
    if (localViewParent == null)
    {
      paramRecyclerView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(346168);
      throw paramRecyclerView;
    }
    ((ViewGroup)localViewParent).dispatchTouchEvent(localMotionEvent);
    paramRecyclerView = (RecyclerView.r)new b(paramRecyclerView.getContext());
    paramRecyclerView.cag = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(346168);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager$FinderStaggeredGridSmoothScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends o
  {
    public b(Context paramContext)
    {
      super();
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      AppMethodBeat.i(346069);
      s.u(paramDisplayMetrics, "displayMetrics");
      float f = 10.0F / paramDisplayMetrics.densityDpi;
      AppMethodBeat.o(346069);
      return f;
    }
    
    public final int g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return (paramInt4 - paramInt3) / 2 + paramInt3 - ((paramInt2 - paramInt1) / 2 + paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */