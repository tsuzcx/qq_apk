package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.m.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.j;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.ag;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "", "()V", "mCurPageName", "", "mStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "mWaterfallsFlowListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1;", "getLegalLayout", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "monitor", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "timestamp", "", "eventId", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class c
{
  public static final c.a wiE;
  public String wiB;
  public j wiC;
  public final b wiD;
  
  static
  {
    AppMethodBeat.i(252033);
    wiE = new c.a((byte)0);
    AppMethodBeat.o(252033);
  }
  
  public c()
  {
    AppMethodBeat.i(252032);
    this.wiD = new b(this);
    AppMethodBeat.o(252032);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "onLoadMoreBegin", "", "onLoadMoreEnd", "className", "", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(m.a parama)
    {
      AppMethodBeat.i(256759);
      j localj = c.a(this.wiF);
      if (localj != null)
      {
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd...");
        if (parama != null) {}
        for (List localList = parama.incrementList;; localList = null)
        {
          if (localList != null)
          {
            parama = parama.incrementList;
            if (parama == null) {
              p.iCn();
            }
            if (!parama.isEmpty()) {
              break;
            }
          }
          Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd, no refresh feed !!!");
          localj.wnt.putAll((Map)localj.wnF);
          localj.wnF.clear();
          parama = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddP().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddS());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddQ().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddT());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddR().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddU());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddS().clear();
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddT().clear();
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddU().clear();
          localj.wnx = localj.wnH;
          localj.wnv = localj.wnG;
          AppMethodBeat.o(256759);
          return;
        }
        localj.X((Map)localj.wnF);
        localj.a((Map)localj.wnF, System.currentTimeMillis());
        AppMethodBeat.o(256759);
        return;
      }
      AppMethodBeat.o(256759);
    }
    
    public final void d(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(256754);
      p.k(paramRecyclerView, "recyclerView");
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = c.i(paramRecyclerView);
      if (localStaggeredGridLayoutManager == null)
      {
        AppMethodBeat.o(256754);
        return;
      }
      j localj = c.a(this.wiF);
      if (localj != null)
      {
        p.k(paramRecyclerView, "recyclerView");
        p.k(localStaggeredGridLayoutManager, "layoutManager");
        if (localStaggeredGridLayoutManager.ku() == 2)
        {
          long l2 = System.currentTimeMillis();
          Object localObject1 = localj.wnE;
          label132:
          int i;
          label230:
          Object localObject3;
          Object localObject4;
          Object localObject2;
          if (localObject1 != null)
          {
            localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              localj.wnE = new WeakReference(localStaggeredGridLayoutManager);
            }
            localObject1 = localj.whW;
            if (localObject1 == null) {
              break label323;
            }
            localObject1 = (RecyclerView)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              localj.whW = new WeakReference(paramRecyclerView);
            }
            localObject1 = localStaggeredGridLayoutManager.k(null);
            paramInt = Math.min(localObject1[0], localObject1[1]);
            localObject1 = localStaggeredGridLayoutManager.l(null);
            int j = Math.max(Math.max(localObject1[0], localObject1[1]) - j.wnI, 0);
            paramInt = Math.max(paramInt, j.wnI);
            i = j.wnI;
            localObject1 = (List)new ArrayList();
            i = paramInt - i;
            if (i >= j + 1) {
              break label785;
            }
            localObject3 = localStaggeredGridLayoutManager.findViewByPosition(j.wnI + i);
            if (localObject3 != null)
            {
              localObject4 = b.eh((View)localObject3);
              p.j(localObject4, "HellhoundUtil.getCoordinateOnScreen(feedView)");
              localObject2 = (Integer)((Pair)localObject4).first;
              localObject4 = (Integer)((Pair)localObject4).second;
              localObject3 = localj.a((View)localObject3, i, paramRecyclerView);
              if (localObject3 != null) {
                break label329;
              }
            }
          }
          label670:
          label689:
          for (;;)
          {
            i += 1;
            break label230;
            localObject1 = null;
            break;
            label323:
            localObject1 = null;
            break label132;
            label329:
            if (((i)localObject3).feedId != null)
            {
              String str = ((i)localObject3).feedId;
              if (str == null) {
                p.iCn();
              }
              ((List)localObject1).add(str);
              label379:
              boolean bool;
              if (localj.wnv <= 0L)
              {
                l1 = localj.wnw;
                ((i)localObject3).wmE = l1;
                p.j(localObject2, "x");
                ((i)localObject3).x = ((Integer)localObject2).intValue();
                p.j(localObject4, "y");
                ((i)localObject3).y = ((Integer)localObject4).intValue();
                ((i)localObject3).position = i;
                j.b((i)localObject3);
                localj.c((i)localObject3);
                localj.d((i)localObject3);
                if (!((i)localObject3).dic) {
                  break label670;
                }
                bool = false;
                label459:
                if ((bool) && (((i)localObject3).wno <= 0L)) {
                  ((i)localObject3).wno = l2;
                }
                if (((i)localObject3).dic) {
                  break label689;
                }
                paramInt = 0;
                label491:
                if ((paramInt == 0) && (((i)localObject3).wmG > 0.0F)) {
                  break label746;
                }
                if (((i)localObject3).wmG <= 0.0F) {
                  ((i)localObject3).dic = false;
                }
                if ((((i)localObject3).wno <= 0L) || (((i)localObject3).wnp > 0L)) {
                  continue;
                }
                ((i)localObject3).wnp = l2;
                ((i)localObject3).wnr = (((i)localObject3).wnp - ((i)localObject3).wno);
                localj.wnx = 0;
                ((i)localObject3).wnq = 0;
                if (((i)localObject3).wmE <= 0L) {
                  if (localj.wnv > 0L) {
                    break label759;
                  }
                }
              }
              label731:
              label746:
              label753:
              label759:
              for (long l1 = localj.wnw;; l1 = localj.wnv)
              {
                ((i)localObject3).wmE = l1;
                localObject2 = a.wmq;
                a.a.a((i)localObject3);
                localObject2 = (Map)localj.wnt;
                localObject3 = ((i)localObject3).feedId;
                if (localObject2 != null) {
                  break label769;
                }
                paramRecyclerView = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(256754);
                throw paramRecyclerView;
                l1 = localj.wnv;
                break label379;
                bool = localj.e((i)localObject3);
                ((i)localObject3).dic = bool;
                break label459;
                paramInt = ((i)localObject3).y;
                float f1 = paramInt;
                float f2 = ((i)localObject3).height;
                if ((paramInt >= localj.wnB) || (f1 + f2 <= localj.wnA))
                {
                  paramInt = 1;
                  if (paramInt != 0) {
                    break label753;
                  }
                }
                for (bool = true;; bool = false)
                {
                  ((i)localObject3).dic = bool;
                  break label491;
                  break;
                  paramInt = 0;
                  break label731;
                }
              }
              ag.fk(localObject2).remove(localObject3);
            }
          }
          label769:
          label785:
          localj.b((List)localObject1, l2);
          paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.dee();
        }
        AppMethodBeat.o(256754);
        return;
      }
      AppMethodBeat.o(256754);
    }
    
    public final void ddw()
    {
      AppMethodBeat.i(256756);
      Object localObject = c.a(this.wiF);
      if (localObject != null)
      {
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshBegin...");
        long l = System.currentTimeMillis();
        ((j)localObject).wnH = ((j)localObject).wnx;
        ((j)localObject).wnG = ((j)localObject).wnv;
        ((j)localObject).wnv = l;
        ((j)localObject).wnx = 3;
        ((j)localObject).wnF.putAll((Map)((j)localObject).wnt);
        ((j)localObject).wnt.clear();
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddS().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddS().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddP());
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddT().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddT().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddQ());
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddU().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddU().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddR());
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.ded();
        AppMethodBeat.o(256756);
        return;
      }
      AppMethodBeat.o(256756);
    }
    
    public final void ddx()
    {
      AppMethodBeat.i(256762);
      if (c.a(this.wiF) != null) {
        j.deo();
      }
      AppMethodBeat.o(256762);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(256750);
      p.k(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(256750);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c
 * JD-Core Version:    0.7.0.1
 */