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
import d.g.b.p;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "", "()V", "mCurPageName", "", "mStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "mWaterfallsFlowListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1;", "getLegalLayout", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "monitor", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "timestamp", "", "eventId", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class c
{
  public static final c.a rce;
  public String rcb;
  public j rcc;
  public final b rcd;
  
  static
  {
    AppMethodBeat.i(196360);
    rce = new c.a((byte)0);
    AppMethodBeat.o(196360);
  }
  
  public c()
  {
    AppMethodBeat.i(196359);
    this.rcd = new b(this);
    AppMethodBeat.o(196359);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "onLoadMoreBegin", "", "onLoadMoreEnd", "className", "", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(l.a parama)
    {
      AppMethodBeat.i(196357);
      j localj = c.a(this.rcf);
      if (localj != null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd...");
        if (parama != null) {}
        for (List localList = parama.incrementList;; localList = null)
        {
          if (localList != null)
          {
            parama = parama.incrementList;
            if (parama == null) {
              p.gkB();
            }
            if (!parama.isEmpty()) {
              break;
            }
          }
          com.tencent.mm.sdk.platformtools.ae.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd, no refresh feed !!!");
          localj.rgc.putAll((Map)localj.rgo);
          localj.rgo.clear();
          parama = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqu().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqx());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqv().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqy());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqw().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqz());
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqx().clear();
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqy().clear();
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqz().clear();
          localj.rgg = localj.rgq;
          localj.rge = localj.rgp;
          AppMethodBeat.o(196357);
          return;
        }
        localj.ac((Map)localj.rgo);
        localj.a((Map)localj.rgo, System.currentTimeMillis());
        AppMethodBeat.o(196357);
        return;
      }
      AppMethodBeat.o(196357);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(196354);
      p.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(196354);
    }
    
    public final void cql()
    {
      AppMethodBeat.i(196356);
      Object localObject = c.a(this.rcf);
      if (localObject != null)
      {
        com.tencent.mm.sdk.platformtools.ae.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshBegin...");
        long l = System.currentTimeMillis();
        ((j)localObject).rgq = ((j)localObject).rgg;
        ((j)localObject).rgp = ((j)localObject).rge;
        ((j)localObject).rge = l;
        ((j)localObject).rgg = 3;
        ((j)localObject).rgo.putAll((Map)((j)localObject).rgc);
        ((j)localObject).rgc.clear();
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqx().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqx().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqu());
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqy().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqy().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqv());
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqz().clear();
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqz().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cqw());
        localObject = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.cqE();
        AppMethodBeat.o(196356);
        return;
      }
      AppMethodBeat.o(196356);
    }
    
    public final void cqm()
    {
      AppMethodBeat.i(196358);
      if (c.a(this.rcf) != null) {
        j.cqM();
      }
      AppMethodBeat.o(196358);
    }
    
    public final void f(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(196355);
      p.h(paramRecyclerView, "recyclerView");
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = c.q(paramRecyclerView);
      if (localStaggeredGridLayoutManager == null)
      {
        AppMethodBeat.o(196355);
        return;
      }
      j localj = c.a(this.rcf);
      if (localj != null)
      {
        p.h(paramRecyclerView, "recyclerView");
        p.h(localStaggeredGridLayoutManager, "layoutManager");
        if (localStaggeredGridLayoutManager.jZ() == 2)
        {
          long l2 = System.currentTimeMillis();
          Object localObject1 = localj.rgn;
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
              localj.rgn = new WeakReference(localStaggeredGridLayoutManager);
            }
            localObject1 = localj.rbC;
            if (localObject1 == null) {
              break label322;
            }
            localObject1 = (RecyclerView)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              localj.rbC = new WeakReference(paramRecyclerView);
            }
            localObject1 = localStaggeredGridLayoutManager.n(null);
            paramInt = Math.min(localObject1[0], localObject1[1]);
            localObject1 = localStaggeredGridLayoutManager.mA();
            int j = Math.max(Math.max(localObject1[0], localObject1[1]) - j.rgr, 0);
            paramInt = Math.max(paramInt, j.rgr);
            i = j.rgr;
            localObject1 = (List)new ArrayList();
            i = paramInt - i;
            if (i >= j + 1) {
              break label784;
            }
            localObject3 = localStaggeredGridLayoutManager.bY(j.rgr + i);
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
                p.gkB();
              }
              ((List)localObject1).add(str);
              label378:
              boolean bool;
              if (localj.rge <= 0L)
              {
                l1 = localj.rgf;
                ((i)localObject3).rft = l1;
                p.g(localObject2, "x");
                ((i)localObject3).x = ((Integer)localObject2).intValue();
                p.g(localObject4, "y");
                ((i)localObject3).y = ((Integer)localObject4).intValue();
                ((i)localObject3).position = i;
                j.b((i)localObject3);
                localj.c((i)localObject3);
                localj.d((i)localObject3);
                if (!((i)localObject3).cNB) {
                  break label669;
                }
                bool = false;
                label458:
                if ((bool) && (((i)localObject3).rfX <= 0L)) {
                  ((i)localObject3).rfX = l2;
                }
                if (((i)localObject3).cNB) {
                  break label688;
                }
                paramInt = 0;
                label490:
                if ((paramInt == 0) && (((i)localObject3).rfv > 0.0F)) {
                  break label745;
                }
                if (((i)localObject3).rfv <= 0.0F) {
                  ((i)localObject3).cNB = false;
                }
                if ((((i)localObject3).rfX <= 0L) || (((i)localObject3).rfY > 0L)) {
                  continue;
                }
                ((i)localObject3).rfY = l2;
                ((i)localObject3).rga = (((i)localObject3).rfY - ((i)localObject3).rfX);
                localj.rgg = 0;
                ((i)localObject3).rfZ = 0;
                if (((i)localObject3).rft <= 0L) {
                  if (localj.rge > 0L) {
                    break label758;
                  }
                }
              }
              label730:
              label745:
              label752:
              label758:
              for (long l1 = localj.rgf;; l1 = localj.rge)
              {
                ((i)localObject3).rft = l1;
                localObject2 = a.rff;
                a.a.a((i)localObject3);
                localObject2 = (Map)localj.rgc;
                localObject3 = ((i)localObject3).feedId;
                if (localObject2 != null) {
                  break label768;
                }
                paramRecyclerView = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(196355);
                throw paramRecyclerView;
                l1 = localj.rge;
                break label378;
                bool = localj.e((i)localObject3);
                ((i)localObject3).cNB = bool;
                break label458;
                paramInt = ((i)localObject3).y;
                float f1 = paramInt;
                float f2 = ((i)localObject3).height;
                if ((paramInt >= localj.rgk) || (f1 + f2 <= localj.rgj))
                {
                  paramInt = 1;
                  if (paramInt != 0) {
                    break label752;
                  }
                }
                for (bool = true;; bool = false)
                {
                  ((i)localObject3).cNB = bool;
                  break label490;
                  break;
                  paramInt = 0;
                  break label730;
                }
              }
              d.g.b.ae.eY(localObject2).remove(localObject3);
            }
          }
          label768:
          label784:
          localj.b((List)localObject1, l2);
          paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.rdX;
          com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a.cqF();
        }
        AppMethodBeat.o(196355);
        return;
      }
      AppMethodBeat.o(196355);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c
 * JD-Core Version:    0.7.0.1
 */