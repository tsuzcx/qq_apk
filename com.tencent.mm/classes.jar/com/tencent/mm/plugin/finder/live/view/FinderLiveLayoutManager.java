package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "orientation", "", "(Landroid/content/Context;I)V", "(Landroid/content/Context;)V", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "getContext", "()Landroid/content/Context;", "enableExtraLayoutSpace", "getEnableExtraLayoutSpace", "()Z", "setEnableExtraLayoutSpace", "(Z)V", "extraLayoutSpace", "getExtraLayoutSpace", "()I", "setExtraLayoutSpace", "(I)V", "forceUpdateOnNextLayout", "getItemCount", "Lkotlin/Function0;", "getGetItemCount", "()Lkotlin/jvm/functions/Function0;", "setGetItemCount", "(Lkotlin/jvm/functions/Function0;)V", "onItemSelected", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "position", "Landroid/view/View;", "child", "reSelect", "", "getOnItemSelected", "()Lkotlin/jvm/functions/Function3;", "setOnItemSelected", "(Lkotlin/jvm/functions/Function3;)V", "scrollState", "getScrollState", "setScrollState", "<set-?>", "selectedPosition", "getSelectedPosition", "canScrollHorizontally", "canScrollVertically", "findSelectedChildIndex", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onLayoutCompleted", "onScrollStateChanged", "updateSelectedChild", "force", "Companion", "plugin-finder_release"})
public final class FinderLiveLayoutManager
  extends LinearLayoutManager
{
  private static final String TAG = "MicroMsg.FinderLiveLayoutManager";
  public static final a yUD;
  public int bFP;
  private int bFx;
  public final Context context;
  private int uqm;
  public kotlin.g.a.q<? super Integer, ? super View, ? super Boolean, x> yUA;
  public kotlin.g.a.a<Integer> yUB;
  private boolean yUC;
  private boolean yUz;
  
  static
  {
    AppMethodBeat.i(279024);
    yUD = new a((byte)0);
    TAG = "MicroMsg.FinderLiveLayoutManager";
    AppMethodBeat.o(279024);
  }
  
  public FinderLiveLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt, false);
    AppMethodBeat.i(279023);
    this.context = paramContext;
    this.bFx = -1;
    paramContext = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.imF().aSr()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.yUC = bool;
      this.uqm = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), 1.0F);
      AppMethodBeat.o(279023);
      return;
    }
  }
  
  private void U(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    int i = 0;
    int k = 0;
    AppMethodBeat.i(279018);
    if (getChildCount() == 1) {
      i = k;
    }
    for (;;)
    {
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if (localView == null) {
          p.iCn();
        }
        p.j(localView, "getChildAt(selectedChildIndex)!!");
        i = getPosition(localView);
        if ((i != this.bFx) || (paramBoolean1) || (paramBoolean2))
        {
          this.bFx = i;
          kotlin.g.a.q localq = this.yUA;
          if (localq != null)
          {
            localq.c(Integer.valueOf(this.bFx), localView, Boolean.valueOf(paramBoolean2));
            AppMethodBeat.o(279018);
            return;
            int n;
            if (super.canScrollHorizontally())
            {
              k = getWidth() / 2;
              m = getChildCount();
              for (;;)
              {
                if (j >= m) {
                  break label334;
                }
                localView = getChildAt(j);
                if (localView == null) {
                  p.iCn();
                }
                p.j(localView, "getChildAt(i)!!");
                n = localView.getLeft();
                localView = getChildAt(j);
                if (localView == null) {
                  p.iCn();
                }
                p.j(localView, "getChildAt(i)!!");
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
                break label334;
              }
              localView = getChildAt(j);
              if (localView == null) {
                p.iCn();
              }
              p.j(localView, "getChildAt(i)!!");
              n = localView.getTop();
              localView = getChildAt(j);
              if (localView == null) {
                p.iCn();
              }
              p.j(localView, "getChildAt(i)!!");
              i = j;
              if ((n + localView.getBottom()) / 2 == k) {
                break;
              }
              j += 1;
            }
          }
        }
      }
      AppMethodBeat.o(279018);
      return;
      label334:
      i = -1;
    }
  }
  
  public final int b(RecyclerView.s params)
  {
    AppMethodBeat.i(279022);
    if (this.yUC)
    {
      if (this.uqm == -1)
      {
        i = super.b(params);
        AppMethodBeat.o(279022);
        return i;
      }
      i = this.uqm;
      AppMethodBeat.o(279022);
      return i;
    }
    int i = super.b(params);
    AppMethodBeat.o(279022);
    return i;
  }
  
  public final boolean canScrollHorizontally()
  {
    AppMethodBeat.i(279021);
    boolean bool = super.canScrollHorizontally();
    AppMethodBeat.o(279021);
    return bool;
  }
  
  public final boolean canScrollVertically()
  {
    AppMethodBeat.i(279020);
    if (getOrientation() == 1)
    {
      Object localObject = this.context.getResources();
      p.j(localObject, "context.resources");
      if (((Resources)localObject).getConfiguration().orientation == 1)
      {
        localObject = this.yUB;
        if (localObject != null)
        {
          localObject = (Integer)((kotlin.g.a.a)localObject).invoke();
          if (localObject == null) {}
        }
        for (int i = ((Integer)localObject).intValue(); i > 1; i = 0)
        {
          AppMethodBeat.o(279020);
          return true;
        }
      }
    }
    AppMethodBeat.o(279020);
    return false;
  }
  
  public final void onLayoutCompleted(RecyclerView.s params)
  {
    AppMethodBeat.i(279016);
    super.onLayoutCompleted(params);
    com.tencent.mm.ae.d.a(0L, (kotlin.g.a.a)new b(this));
    AppMethodBeat.o(279016);
  }
  
  public final void onScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(279017);
    super.onScrollStateChanged(paramInt);
    this.bFP = paramInt;
    if (this.bFP == 0) {
      a(this, false, false, 3);
    }
    AppMethodBeat.o(279017);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLayoutManager$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(FinderLiveLayoutManager paramFinderLiveLayoutManager)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveLayoutManager
 * JD-Core Version:    0.7.0.1
 */