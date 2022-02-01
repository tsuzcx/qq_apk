package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "getContext", "()Landroid/content/Context;", "forceUpdateOnNextLayout", "getItemCount", "Lkotlin/Function0;", "getGetItemCount", "()Lkotlin/jvm/functions/Function0;", "setGetItemCount", "(Lkotlin/jvm/functions/Function0;)V", "onItemSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function2;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function2;)V", "scrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "()I", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "onLayoutCompleted", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onScrollStateChanged", "updateSelectedChild", "force", "Companion", "plugin-finder_release"})
public final class FinderLiveLayoutManager
  extends LinearLayoutManager
{
  private static final String TAG = "MicroMsg.FinderLiveLayoutManager";
  public static final a uyL;
  private final Context context;
  private boolean uyI;
  public m<? super Integer, ? super View, x> uyJ;
  public a<Integer> uyK;
  private int va;
  private int vp;
  
  static
  {
    AppMethodBeat.i(247469);
    uyL = new a((byte)0);
    TAG = "MicroMsg.FinderLiveLayoutManager";
    AppMethodBeat.o(247469);
  }
  
  public FinderLiveLayoutManager(Context paramContext)
  {
    super(1, false);
    AppMethodBeat.i(247468);
    this.context = paramContext;
    this.va = -1;
    AppMethodBeat.o(247468);
  }
  
  private final int div()
  {
    int j = 0;
    int i = 0;
    int k = 0;
    AppMethodBeat.i(247465);
    if (getChildCount() == 1) {
      i = k;
    }
    for (;;)
    {
      AppMethodBeat.o(247465);
      return i;
      View localView;
      int n;
      if (super.canScrollHorizontally())
      {
        k = getWidth() / 2;
        m = getChildCount();
        for (;;)
        {
          if (j >= m) {
            break label223;
          }
          localView = getChildAt(j);
          if (localView == null) {
            p.hyc();
          }
          p.g(localView, "getChildAt(i)!!");
          n = localView.getLeft();
          localView = getChildAt(j);
          if (localView == null) {
            p.hyc();
          }
          p.g(localView, "getChildAt(i)!!");
          i = j;
          if ((n + localView.getRight()) / 2 == k) {
            break;
          }
          j += 1;
        }
      }
      k = getHeight() / 2;
      int m = getChildCount();
      j = i;
      for (;;)
      {
        if (j >= m) {
          break label223;
        }
        localView = getChildAt(j);
        if (localView == null) {
          p.hyc();
        }
        p.g(localView, "getChildAt(i)!!");
        n = localView.getTop();
        localView = getChildAt(j);
        if (localView == null) {
          p.hyc();
        }
        p.g(localView, "getChildAt(i)!!");
        i = j;
        if ((n + localView.getBottom()) / 2 == k) {
          break;
        }
        j += 1;
      }
      label223:
      i = -1;
    }
  }
  
  private final void nz(boolean paramBoolean)
  {
    AppMethodBeat.i(247464);
    int i = div();
    if (i >= 0)
    {
      View localView = getChildAt(i);
      if (localView == null) {
        p.hyc();
      }
      p.g(localView, "getChildAt(selectedChildIndex)!!");
      i = getPosition(localView);
      if ((i != this.va) || (paramBoolean))
      {
        this.va = i;
        m localm = this.uyJ;
        if (localm != null)
        {
          localm.invoke(Integer.valueOf(this.va), localView);
          AppMethodBeat.o(247464);
          return;
        }
      }
    }
    AppMethodBeat.o(247464);
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(247467);
    boolean bool = super.canScrollHorizontally();
    AppMethodBeat.o(247467);
    return bool;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(247466);
    if (getOrientation() == 1)
    {
      Object localObject = this.context.getResources();
      p.g(localObject, "context.resources");
      if (((Resources)localObject).getConfiguration().orientation == 1)
      {
        localObject = this.uyK;
        if (localObject != null)
        {
          localObject = (Integer)((a)localObject).invoke();
          if (localObject == null) {}
        }
        for (int i = ((Integer)localObject).intValue(); i > 1; i = 0)
        {
          AppMethodBeat.o(247466);
          return true;
        }
      }
    }
    AppMethodBeat.o(247466);
    return false;
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(247462);
    super.onLayoutCompleted(params);
    nz(this.uyI);
    this.uyI = false;
    AppMethodBeat.o(247462);
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(247463);
    super.onScrollStateChanged(paramInt);
    this.vp = paramInt;
    if (this.vp == 0) {
      nz(false);
    }
    AppMethodBeat.o(247463);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager
 * JD-Core Version:    0.7.0.1
 */