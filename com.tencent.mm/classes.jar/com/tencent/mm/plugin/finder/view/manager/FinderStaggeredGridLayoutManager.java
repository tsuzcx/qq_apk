package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager;", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "spanCount", "", "orientation", "(II)V", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onLayoutChildren", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "reflectMarkItemDecorInsetsDirty", "requestSimpleAnimationsInNextLayout", "scrollToPosition", "position", "scrollToPositionWithOffset", "offset", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "recyclerView", "Companion", "plugin-finder_release"})
public class FinderStaggeredGridLayoutManager
  extends StaggeredGridLayoutManager
{
  public static final a sYE;
  
  static
  {
    AppMethodBeat.i(168540);
    sYE = new a((byte)0);
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
    AppMethodBeat.i(205362);
    if (ad.getLogLevel() <= 1) {
      ad.d("Finder.StaggeredGridLayoutManager", "[smoothScrollToPosition] position=" + paramInt + " state=" + paramt);
    }
    super.a(paramRecyclerView, paramt, paramInt);
    AppMethodBeat.o(205362);
  }
  
  public final void ag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205364);
    if (ad.getLogLevel() <= 1) {
      ad.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt1 + " offset=" + paramInt2);
    }
    super.ag(paramInt1, paramInt2);
    AppMethodBeat.o(205364);
  }
  
  public final int b(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(205361);
    if (ad.getLogLevel() <= 1) {
      ad.d("Finder.StaggeredGridLayoutManager", "[scrollVerticallyBy] dy=" + paramInt + " state=" + paramt);
    }
    paramInt = super.b(paramInt, paramo, paramt);
    AppMethodBeat.o(205361);
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
      ad.printErrStackTrace("Finder.StaggeredGridLayoutManager", (Throwable)paramo, "", new Object[0]);
      AppMethodBeat.o(168538);
    }
  }
  
  public final void ca(int paramInt)
  {
    AppMethodBeat.i(205363);
    if (ad.getLogLevel() <= 1) {
      ad.d("Finder.StaggeredGridLayoutManager", "[scrollToPosition] position=" + paramInt + ' ');
    }
    super.ca(paramInt);
    AppMethodBeat.o(205363);
  }
  
  public final void lA()
  {
    AppMethodBeat.i(168539);
    super.lA();
    try
    {
      Method localMethod = RecyclerView.class.getDeclaredMethod("lh", new Class[0]);
      p.g(localMethod, "method");
      localMethod.setAccessible(true);
      Object localObject = RecyclerView.i.class.getDeclaredField("anl");
      p.g(localObject, "field");
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/manager/FinderStaggeredGridLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.manager.FinderStaggeredGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */