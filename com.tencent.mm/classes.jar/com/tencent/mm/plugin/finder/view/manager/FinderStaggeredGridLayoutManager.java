package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "(II)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public class FinderStaggeredGridLayoutManager
  extends StaggeredGridLayoutManager
{
  public static final FinderStaggeredGridLayoutManager.a sbn;
  
  static
  {
    AppMethodBeat.i(168540);
    sbn = new FinderStaggeredGridLayoutManager.a((byte)0);
    AppMethodBeat.o(168540);
  }
  
  public FinderStaggeredGridLayoutManager(int paramInt)
  {
    super(paramInt);
  }
  
  public FinderStaggeredGridLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.t paramt, int paramInt)
  {
    AppMethodBeat.i(204348);
    if (ac.getLogLevel() <= 1) {
      ac.d("Finder.StaggeredGridLayoutManager", "[smoothScrollToPosition] position=" + paramInt + " state=" + paramt);
    }
    super.a(paramRecyclerView, paramt, paramInt);
    AppMethodBeat.o(204348);
  }
  
  public final void af(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204350);
    if (ac.getLogLevel() <= 1) {
      ac.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt1 + " offset=" + paramInt2);
    }
    super.af(paramInt1, paramInt2);
    AppMethodBeat.o(204350);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(204347);
    if (ac.getLogLevel() <= 1) {
      ac.d("Finder.StaggeredGridLayoutManager", "[scrollVerticallyBy] dy=" + paramInt + " state=" + paramt);
    }
    paramInt = super.b(paramInt, paramo, paramt);
    AppMethodBeat.o(204347);
    return paramInt;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(168538);
    try
    {
      super.c(paramo, paramt);
      AppMethodBeat.o(168538);
      return;
    }
    catch (IndexOutOfBoundsException paramo)
    {
      ac.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)paramo, "", new Object[0]);
      AppMethodBeat.o(168538);
    }
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(204349);
    if (ac.getLogLevel() <= 1) {
      ac.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt + ' ');
    }
    super.ca(paramInt);
    AppMethodBeat.o(204349);
  }
  
  public final void li()
  {
    AppMethodBeat.i(168539);
    super.li();
    try
    {
      Method localMethod = RecyclerView.class.getDeclaredMethod("kR", new Class[0]);
      k.g(localMethod, "method");
      localMethod.setAccessible(true);
      Object localObject = RecyclerView.i.class.getDeclaredField("alu");
      k.g(localObject, "field");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        localMethod.invoke(localObject, new Object[0]);
        ac.i("Finder.StaggeredGridLayoutManager", "markItemDecorInsetsDirty");
        AppMethodBeat.o(168539);
        return;
      }
      AppMethodBeat.o(168539);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(168539);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */