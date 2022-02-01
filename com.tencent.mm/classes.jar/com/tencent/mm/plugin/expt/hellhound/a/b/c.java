package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Pair;
import android.view.View;
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
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "", "()V", "mCurPageName", "", "mStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "mWaterfallsFlowListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1;", "getLegalLayout", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "monitor", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "timestamp", "", "eventId", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class c
{
  public static final c.a sCK;
  public String sCH;
  public j sCI;
  public final b sCJ;
  
  static
  {
    AppMethodBeat.i(220825);
    sCK = new c.a((byte)0);
    AppMethodBeat.o(220825);
  }
  
  public c()
  {
    AppMethodBeat.i(220824);
    this.sCJ = new b(this);
    AppMethodBeat.o(220824);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "onLoadMoreBegin", "", "onLoadMoreEnd", "className", "", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(m.a parama)
    {
      AppMethodBeat.i(220822);
      j localj = c.a(this.sCL);
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
              p.hyc();
            }
            if (!parama.isEmpty()) {
              break;
            }
          }
          Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd, no refresh feed !!!");
          localj.sHy.putAll((Map)localj.sHK);
          localj.sHK.clear();
          parama = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOW().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOZ());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOX().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPa());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOY().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPb());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOZ().clear();
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPa().clear();
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPb().clear();
          localj.sHC = localj.sHM;
          localj.sHA = localj.sHL;
          AppMethodBeat.o(220822);
          return;
        }
        localj.af((Map)localj.sHK);
        localj.a((Map)localj.sHK, System.currentTimeMillis());
        AppMethodBeat.o(220822);
        return;
      }
      AppMethodBeat.o(220822);
    }
    
    public final void cOE()
    {
      AppMethodBeat.i(220821);
      Object localObject = c.a(this.sCL);
      if (localObject != null)
      {
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshBegin...");
        long l = System.currentTimeMillis();
        ((j)localObject).sHM = ((j)localObject).sHC;
        ((j)localObject).sHL = ((j)localObject).sHA;
        ((j)localObject).sHA = l;
        ((j)localObject).sHC = 3;
        ((j)localObject).sHK.putAll((Map)((j)localObject).sHy);
        ((j)localObject).sHy.clear();
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOZ().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOZ().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOW());
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPa().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPa().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOX());
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPb().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPb().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOY());
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.cPj();
        AppMethodBeat.o(220821);
        return;
      }
      AppMethodBeat.o(220821);
    }
    
    public final void cOF()
    {
      AppMethodBeat.i(220823);
      if (c.a(this.sCL) != null) {
        j.cPu();
      }
      AppMethodBeat.o(220823);
    }
    
    public final void e(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(220820);
      p.h(paramRecyclerView, "recyclerView");
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = c.k(paramRecyclerView);
      if (localStaggeredGridLayoutManager == null)
      {
        AppMethodBeat.o(220820);
        return;
      }
      j localj = c.a(this.sCL);
      if (localj != null)
      {
        p.h(paramRecyclerView, "recyclerView");
        p.h(localStaggeredGridLayoutManager, "layoutManager");
        if (localStaggeredGridLayoutManager.ki() == 2)
        {
          long l2 = System.currentTimeMillis();
          Object localObject1 = localj.sHJ;
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
              localj.sHJ = new WeakReference(localStaggeredGridLayoutManager);
            }
            localObject1 = localj.sCb;
            if (localObject1 == null) {
              break label323;
            }
            localObject1 = (RecyclerView)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              localj.sCb = new WeakReference(paramRecyclerView);
            }
            localObject1 = localStaggeredGridLayoutManager.n(null);
            paramInt = Math.min(localObject1[0], localObject1[1]);
            localObject1 = localStaggeredGridLayoutManager.o(null);
            int j = Math.max(Math.max(localObject1[0], localObject1[1]) - j.sHN, 0);
            paramInt = Math.max(paramInt, j.sHN);
            i = j.sHN;
            localObject1 = (List)new ArrayList();
            i = paramInt - i;
            if (i >= j + 1) {
              break label785;
            }
            localObject3 = localStaggeredGridLayoutManager.findViewByPosition(j.sHN + i);
            if (localObject3 != null)
            {
              localObject4 = b.dJ((View)localObject3);
              p.g(localObject4, "HellhoundUtil.getCoordinateOnScreen(feedView)");
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
                p.hyc();
              }
              ((List)localObject1).add(str);
              label379:
              boolean bool;
              if (localj.sHA <= 0L)
              {
                l1 = localj.sHB;
                ((i)localObject3).sGJ = l1;
                p.g(localObject2, "x");
                ((i)localObject3).x = ((Integer)localObject2).intValue();
                p.g(localObject4, "y");
                ((i)localObject3).y = ((Integer)localObject4).intValue();
                ((i)localObject3).position = i;
                j.b((i)localObject3);
                localj.c((i)localObject3);
                localj.d((i)localObject3);
                if (!((i)localObject3).ddZ) {
                  break label670;
                }
                bool = false;
                label459:
                if ((bool) && (((i)localObject3).sHt <= 0L)) {
                  ((i)localObject3).sHt = l2;
                }
                if (((i)localObject3).ddZ) {
                  break label689;
                }
                paramInt = 0;
                label491:
                if ((paramInt == 0) && (((i)localObject3).sGL > 0.0F)) {
                  break label746;
                }
                if (((i)localObject3).sGL <= 0.0F) {
                  ((i)localObject3).ddZ = false;
                }
                if ((((i)localObject3).sHt <= 0L) || (((i)localObject3).sHu > 0L)) {
                  continue;
                }
                ((i)localObject3).sHu = l2;
                ((i)localObject3).sHw = (((i)localObject3).sHu - ((i)localObject3).sHt);
                localj.sHC = 0;
                ((i)localObject3).sHv = 0;
                if (((i)localObject3).sGJ <= 0L) {
                  if (localj.sHA > 0L) {
                    break label759;
                  }
                }
              }
              label731:
              label746:
              label753:
              label759:
              for (long l1 = localj.sHB;; l1 = localj.sHA)
              {
                ((i)localObject3).sGJ = l1;
                localObject2 = a.sGv;
                a.a.a((i)localObject3);
                localObject2 = (Map)localj.sHy;
                localObject3 = ((i)localObject3).feedId;
                if (localObject2 != null) {
                  break label769;
                }
                paramRecyclerView = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(220820);
                throw paramRecyclerView;
                l1 = localj.sHA;
                break label379;
                bool = localj.e((i)localObject3);
                ((i)localObject3).ddZ = bool;
                break label459;
                paramInt = ((i)localObject3).y;
                float f1 = paramInt;
                float f2 = ((i)localObject3).height;
                if ((paramInt >= localj.sHG) || (f1 + f2 <= localj.sHF))
                {
                  paramInt = 1;
                  if (paramInt != 0) {
                    break label753;
                  }
                }
                for (bool = true;; bool = false)
                {
                  ((i)localObject3).ddZ = bool;
                  break label491;
                  break;
                  paramInt = 0;
                  break label731;
                }
              }
              af.fd(localObject2).remove(localObject3);
            }
          }
          label769:
          label785:
          localj.c((List)localObject1, l2);
          paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.cPk();
        }
        AppMethodBeat.o(220820);
        return;
      }
      AppMethodBeat.o(220820);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(220819);
      p.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(220819);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c
 * JD-Core Version:    0.7.0.1
 */