package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "(II)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public class FinderStaggeredGridLayoutManager
  extends StaggeredGridLayoutManager
{
  public static final a wto;
  
  static
  {
    AppMethodBeat.i(168540);
    wto = new a((byte)0);
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
  
  public final void ah(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(255284);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt1 + " offset=" + paramInt2);
    }
    super.ah(paramInt1, paramInt2);
    AppMethodBeat.o(255284);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(168538);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(168538);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)paramn, "", new Object[0]);
      AppMethodBeat.o(168538);
    }
  }
  
  public void requestSimpleAnimationsInNextLayout()
  {
    AppMethodBeat.i(168539);
    super.requestSimpleAnimationsInNextLayout();
    try
    {
      Method localMethod = RecyclerView.class.getDeclaredMethod("lo", new Class[0]);
      p.g(localMethod, "RecyclerView::class.java…arkItemDecorInsetsDirty\")");
      localMethod.setAccessible(true);
      Object localObject = RecyclerView.LayoutManager.class.getDeclaredField("mRecyclerView");
      p.g(localObject, "RecyclerView.LayoutManag…redField(\"mRecyclerView\")");
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
    AppMethodBeat.i(255283);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt + ' ');
    }
    super.scrollToPosition(paramInt);
    AppMethodBeat.o(255283);
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(255281);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[scrollVerticallyBy] dy=" + paramInt + " state=" + params);
    }
    paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
    AppMethodBeat.o(255281);
    return paramInt;
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(255282);
    if (Log.getLogLevel() <= 1) {
      Log.d("Finder.StaggeredGridLayoutManager", "[smoothScrollToPosition] position=" + paramInt + " state=" + params);
    }
    super.smoothScrollToPosition(paramRecyclerView, params, paramInt);
    AppMethodBeat.o(255282);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */