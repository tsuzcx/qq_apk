package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "(II)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public class FinderStaggeredGridLayoutManager
  extends StaggeredGridLayoutManager
{
  public static final a BfF;
  
  static
  {
    AppMethodBeat.i(168540);
    BfF = new a((byte)0);
    AppMethodBeat.o(168540);
  }
  
  public FinderStaggeredGridLayoutManager(int paramInt)
  {
    super(paramInt, 1);
  }
  
  public FinderStaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final void au(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(289436);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt1 + " offset=" + paramInt2);
    }
    super.au(paramInt1, paramInt2);
    AppMethodBeat.o(289436);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(289432);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(289432);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)paramn, "", new Object[0]);
      AppMethodBeat.o(289432);
    }
  }
  
  public void requestSimpleAnimationsInNextLayout()
  {
    AppMethodBeat.i(168539);
    super.requestSimpleAnimationsInNextLayout();
    try
    {
      Method localMethod = RecyclerView.class.getDeclaredMethod("lB", new Class[0]);
      p.j(localMethod, "RecyclerView::class.java…arkItemDecorInsetsDirty\")");
      localMethod.setAccessible(true);
      Object localObject = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
      p.j(localObject, "RecyclerView.LayoutManag…redField(\"mRecyclerView\")");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        localMethod.invoke(localObject, new Object[0]);
        Log.i("Finder.StaggeredGridLayoutManager", "markItemDecorInsetsDirty");
        AppMethodBeat.o(168539);
        return;
      }
      AppMethodBeat.o(168539);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(168539);
    }
  }
  
  public void scrollToPosition(int paramInt)
  {
    AppMethodBeat.i(289435);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt + ' ');
    }
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(289435);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(289433);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[scrollVerticallyBy] dy=" + paramInt + " state=" + params);
    }
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    AppMethodBeat.o(289433);
    return paramInt;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(289434);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[smoothScrollToPosition] position=" + paramInt + " state=" + params);
    }
    super.smoothScrollToPosition(paramRecyclerView, params, paramInt);
    AppMethodBeat.o(289434);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */