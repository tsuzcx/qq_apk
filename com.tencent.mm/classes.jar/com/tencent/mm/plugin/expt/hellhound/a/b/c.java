package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.l.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.j;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "", "()V", "mCurPageName", "", "mStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "mWaterfallsFlowListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1;", "getLegalLayout", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "monitor", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "timestamp", "", "eventId", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class c
{
  public static final c.a qUg;
  public String qUd;
  public j qUe;
  public final b qUf;
  
  static
  {
    AppMethodBeat.i(210693);
    qUg = new c.a((byte)0);
    AppMethodBeat.o(210693);
  }
  
  public c()
  {
    AppMethodBeat.i(210692);
    this.qUf = new b(this);
    AppMethodBeat.o(210692);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "onLoadMoreBegin", "", "onLoadMoreEnd", "className", "", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(l.a parama)
    {
      AppMethodBeat.i(210690);
      j localj = c.a(this.qUh);
      if (localj != null)
      {
        ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd...");
        if (parama != null) {}
        for (List localList = parama.incrementList;; localList = null)
        {
          if (localList != null)
          {
            parama = parama.incrementList;
            if (parama == null) {
              p.gfZ();
            }
            if (!parama.isEmpty()) {
              break;
            }
          }
          ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd, no refresh feed !!!");
          localj.qXW.putAll((Map)localj.qYi);
          localj.qYi.clear();
          parama = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coS().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coV());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coT().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coW());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coU().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coX());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coV().clear();
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coW().clear();
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coX().clear();
          localj.qYa = localj.qYk;
          localj.qXY = localj.qYj;
          AppMethodBeat.o(210690);
          return;
        }
        localj.W((Map)localj.qYi);
        localj.a((Map)localj.qYi, System.currentTimeMillis());
        AppMethodBeat.o(210690);
        return;
      }
      AppMethodBeat.o(210690);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(210687);
      p.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(210687);
    }
    
    public final void coJ()
    {
      AppMethodBeat.i(210689);
      Object localObject = c.a(this.qUh);
      if (localObject != null)
      {
        ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshBegin...");
        long l = System.currentTimeMillis();
        ((j)localObject).qYk = ((j)localObject).qYa;
        ((j)localObject).qYj = ((j)localObject).qXY;
        ((j)localObject).qXY = l;
        ((j)localObject).qYa = 3;
        ((j)localObject).qYi.putAll((Map)((j)localObject).qXW);
        ((j)localObject).qXW.clear();
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coV().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coV().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coS());
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coW().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coW().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coT());
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coX().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coX().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.coU());
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.cpc();
        AppMethodBeat.o(210689);
        return;
      }
      AppMethodBeat.o(210689);
    }
    
    public final void coK()
    {
      AppMethodBeat.i(210691);
      if (c.a(this.qUh) != null) {
        j.cpk();
      }
      AppMethodBeat.o(210691);
    }
    
    public final void f(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(210688);
      p.h(paramRecyclerView, "recyclerView");
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = c.q(paramRecyclerView);
      if (localStaggeredGridLayoutManager == null)
      {
        AppMethodBeat.o(210688);
        return;
      }
      j localj = c.a(this.qUh);
      if (localj != null)
      {
        p.h(paramRecyclerView, "recyclerView");
        p.h(localStaggeredGridLayoutManager, "layoutManager");
        if (localStaggeredGridLayoutManager.jZ() == 2)
        {
          long l2 = System.currentTimeMillis();
          Object localObject1 = localj.qYh;
          label132:
          int i;
          label229:
          Object localObject3;
          Object localObject4;
          Object localObject2;
          if (localObject1 != null)
          {
            localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              localj.qYh = new WeakReference(localStaggeredGridLayoutManager);
            }
            localObject1 = localj.qTE;
            if (localObject1 == null) {
              break label322;
            }
            localObject1 = (RecyclerView)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              localj.qTE = new WeakReference(paramRecyclerView);
            }
            localObject1 = localStaggeredGridLayoutManager.n(null);
            paramInt = Math.min(localObject1[0], localObject1[1]);
            localObject1 = localStaggeredGridLayoutManager.mA();
            int j = Math.max(Math.max(localObject1[0], localObject1[1]) - j.qYl, 0);
            paramInt = Math.max(paramInt, j.qYl);
            i = j.qYl;
            localObject1 = (List)new ArrayList();
            i = paramInt - i;
            if (i >= j + 1) {
              break label784;
            }
            localObject3 = localStaggeredGridLayoutManager.bY(j.qYl + i);
            if (localObject3 != null)
            {
              localObject4 = b.dR((View)localObject3);
              p.g(localObject4, "HellhoundUtil.getCoordinateOnScreen(feedView)");
              localObject2 = (Integer)((Pair)localObject4).first;
              localObject4 = (Integer)((Pair)localObject4).second;
              localObject3 = localj.a((View)localObject3, i, paramRecyclerView);
              if (localObject3 != null) {
                break label328;
              }
            }
          }
          label669:
          label688:
          for (;;)
          {
            i += 1;
            break label229;
            localObject1 = null;
            break;
            label322:
            localObject1 = null;
            break label132;
            label328:
            if (((i)localObject3).feedId != null)
            {
              String str = ((i)localObject3).feedId;
              if (str == null) {
                p.gfZ();
              }
              ((List)localObject1).add(str);
              label378:
              boolean bool;
              if (localj.qXY <= 0L)
              {
                l1 = localj.qXZ;
                ((i)localObject3).qXn = l1;
                p.g(localObject2, "x");
                ((i)localObject3).x = ((Integer)localObject2).intValue();
                p.g(localObject4, "y");
                ((i)localObject3).y = ((Integer)localObject4).intValue();
                ((i)localObject3).position = i;
                j.b((i)localObject3);
                localj.c((i)localObject3);
                localj.d((i)localObject3);
                if (!((i)localObject3).cMS) {
                  break label669;
                }
                bool = false;
                label458:
                if ((bool) && (((i)localObject3).qXR <= 0L)) {
                  ((i)localObject3).qXR = l2;
                }
                if (((i)localObject3).cMS) {
                  break label688;
                }
                paramInt = 0;
                label490:
                if ((paramInt == 0) && (((i)localObject3).qXp > 0.0F)) {
                  break label745;
                }
                if (((i)localObject3).qXp <= 0.0F) {
                  ((i)localObject3).cMS = false;
                }
                if ((((i)localObject3).qXR <= 0L) || (((i)localObject3).qXS > 0L)) {
                  continue;
                }
                ((i)localObject3).qXS = l2;
                ((i)localObject3).qXU = (((i)localObject3).qXS - ((i)localObject3).qXR);
                localj.qYa = 0;
                ((i)localObject3).qXT = 0;
                if (((i)localObject3).qXn <= 0L) {
                  if (localj.qXY > 0L) {
                    break label758;
                  }
                }
              }
              label730:
              label745:
              label752:
              label758:
              for (long l1 = localj.qXZ;; l1 = localj.qXY)
              {
                ((i)localObject3).qXn = l1;
                localObject2 = a.qXa;
                a.a.a((i)localObject3);
                localObject2 = (Map)localj.qXW;
                localObject3 = ((i)localObject3).feedId;
                if (localObject2 != null) {
                  break label768;
                }
                paramRecyclerView = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(210688);
                throw paramRecyclerView;
                l1 = localj.qXY;
                break label378;
                bool = localj.e((i)localObject3);
                ((i)localObject3).cMS = bool;
                break label458;
                paramInt = ((i)localObject3).y;
                float f1 = paramInt;
                float f2 = ((i)localObject3).height;
                if ((paramInt >= localj.qYe) || (f1 + f2 <= localj.qYd))
                {
                  paramInt = 1;
                  if (paramInt != 0) {
                    break label752;
                  }
                }
                for (bool = true;; bool = false)
                {
                  ((i)localObject3).cMS = bool;
                  break label490;
                  break;
                  paramInt = 0;
                  break label730;
                }
              }
              ae.eV(localObject2).remove(localObject3);
            }
          }
          label768:
          label784:
          localj.b((List)localObject1, l2);
          paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.qVY;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.cpd();
        }
        AppMethodBeat.o(210688);
        return;
      }
      AppMethodBeat.o(210688);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c
 * JD-Core Version:    0.7.0.1
 */