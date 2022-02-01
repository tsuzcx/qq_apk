package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "(II)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public class FinderStaggeredGridLayoutManager
  extends StaggeredGridLayoutManager
{
  public static final a qZn;
  
  static
  {
    AppMethodBeat.i(168540);
    qZn = new a((byte)0);
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
  
  public final void a(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(200278);
    if (ad.getLogLevel() <= 1) {
      ad.d("Finder.StaggeredGridLayoutManager", "[smoothScrollToPosition] position=" + paramInt + " state=" + params);
    }
    super.a(paramRecyclerView, params, paramInt);
    AppMethodBeat.o(200278);
  }
  
  public final void af(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200280);
    if (ad.getLogLevel() <= 1) {
      ad.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt1 + " offset=" + paramInt2);
    }
    super.af(paramInt1, paramInt2);
    AppMethodBeat.o(200280);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(200277);
    if (ad.getLogLevel() <= 1) {
      ad.d("Finder.StaggeredGridLayoutManager", "[scrollVerticallyBy] dy=" + paramInt + " state=" + params);
    }
    paramInt = super.b(paramInt, paramo, params);
    AppMethodBeat.o(200277);
    return paramInt;
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(168538);
    try
    {
      super.c(paramo, params);
      AppMethodBeat.o(168538);
      return;
    }
    catch (IndexOutOfBoundsException paramo)
    {
      ad.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)paramo, "", new Object[0]);
      AppMethodBeat.o(168538);
    }
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(200279);
    if (ad.getLogLevel() <= 1) {
      ad.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt + ' ');
    }
    super.ca(paramInt);
    AppMethodBeat.o(200279);
  }
  
  public final void la()
  {
    AppMethodBeat.i(168539);
    super.la();
    try
    {
      Method localMethod = RecyclerView.class.getDeclaredMethod("kJ", new Class[0]);
      k.g(localMethod, "method");
      localMethod.setAccessible(true);
      Object localObject = RecyclerView.i.class.getDeclaredField("akA");
      k.g(localObject, "field");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(this);
      if (localObject != null)
      {
        localMethod.invoke(localObject, new Object[0]);
        ad.i("Finder.StaggeredGridLayoutManager", "markItemDecorInsetsDirty");
        AppMethodBeat.o(168539);
        return;
      }
      AppMethodBeat.o(168539);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)localException, "", new Object[0]);
      AppMethodBeat.o(168539);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */