package com.tencent.mm.plugin.expt.hellhound.a.b;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Pair;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.l.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.i;
import com.tencent.mm.plugin.expt.hellhound.a.b.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.aa;
import d.g.b.k;
import d.l;
import d.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "onLoadMoreBegin", "", "onLoadMoreEnd", "className", "", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
public final class b$b
  implements e
{
  public final void a(l.a parama)
  {
    AppMethodBeat.i(205084);
    j localj = b.a(this.KEZ);
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
            k.fvU();
          }
          if (!parama.isEmpty()) {
            break;
          }
        }
        ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd, no refresh feed !!!");
        localj.KIF.putAll((Map)localj.KIR);
        localj.KIR.clear();
        parama = c.KGM;
        c.fRA().addAll((Collection)c.fRD());
        c.fRB().addAll((Collection)c.fRE());
        c.fRC().addAll((Collection)c.fRF());
        c.fRD().clear();
        c.fRE().clear();
        c.fRF().clear();
        localj.KIJ = localj.KIT;
        localj.KIH = localj.KIS;
        AppMethodBeat.o(205084);
        return;
      }
      localj.bZ((Map)localj.KIR);
      localj.a((Map)localj.KIR, System.currentTimeMillis());
      AppMethodBeat.o(205084);
      return;
    }
    AppMethodBeat.o(205084);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(205081);
    k.h(paramRecyclerView, "recyclerView");
    AppMethodBeat.o(205081);
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(205082);
    k.h(paramRecyclerView, "recyclerView");
    StaggeredGridLayoutManager localStaggeredGridLayoutManager = b.q(paramRecyclerView);
    if (localStaggeredGridLayoutManager == null)
    {
      AppMethodBeat.o(205082);
      return;
    }
    j localj = b.a(this.KEZ);
    if (localj != null)
    {
      k.h(paramRecyclerView, "recyclerView");
      k.h(localStaggeredGridLayoutManager, "layoutManager");
      if (localStaggeredGridLayoutManager.jB() == 2)
      {
        long l2 = System.currentTimeMillis();
        Object localObject1 = localj.KIQ;
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
            localj.KIQ = new WeakReference(localStaggeredGridLayoutManager);
          }
          localObject1 = localj.pFP;
          if (localObject1 == null) {
            break label322;
          }
          localObject1 = (RecyclerView)((WeakReference)localObject1).get();
          if (localObject1 == null) {
            localj.pFP = new WeakReference(paramRecyclerView);
          }
          localObject1 = localStaggeredGridLayoutManager.x(null);
          paramInt = Math.min(localObject1[0], localObject1[1]);
          localObject1 = localStaggeredGridLayoutManager.ma();
          int j = Math.max(Math.max(localObject1[0], localObject1[1]) - j.qui, 0);
          paramInt = Math.max(paramInt, j.qui);
          i = j.qui;
          localObject1 = (List)new ArrayList();
          i = paramInt - i;
          if (i >= j + 1) {
            break label784;
          }
          localObject3 = localStaggeredGridLayoutManager.bY(j.qui + i);
          if (localObject3 != null)
          {
            localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.gM((View)localObject3);
            k.g(localObject4, "HellhoundUtil.getCoordinateOnScreen(feedView)");
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
              k.fvU();
            }
            ((List)localObject1).add(str);
            label378:
            boolean bool;
            if (localj.KIH <= 0L)
            {
              l1 = localj.KII;
              ((i)localObject3).KHZ = l1;
              k.g(localObject2, "x");
              ((i)localObject3).x = ((Integer)localObject2).intValue();
              k.g(localObject4, "y");
              ((i)localObject3).y = ((Integer)localObject4).intValue();
              ((i)localObject3).position = i;
              j.b((i)localObject3);
              localj.c((i)localObject3);
              localj.d((i)localObject3);
              if (!((i)localObject3).cEL) {
                break label669;
              }
              bool = false;
              label458:
              if ((bool) && (((i)localObject3).KIA <= 0L)) {
                ((i)localObject3).KIA = l2;
              }
              if (((i)localObject3).cEL) {
                break label688;
              }
              paramInt = 0;
              label490:
              if ((paramInt == 0) && (((i)localObject3).KIb > 0.0F)) {
                break label745;
              }
              if (((i)localObject3).KIb <= 0.0F) {
                ((i)localObject3).cEL = false;
              }
              if ((((i)localObject3).KIA <= 0L) || (((i)localObject3).KIB > 0L)) {
                continue;
              }
              ((i)localObject3).KIB = l2;
              ((i)localObject3).KID = (((i)localObject3).KIB - ((i)localObject3).KIA);
              localj.KIJ = 0;
              ((i)localObject3).KIC = 0;
              if (((i)localObject3).KHZ <= 0L) {
                if (localj.KIH > 0L) {
                  break label758;
                }
              }
            }
            label730:
            label745:
            label752:
            label758:
            for (long l1 = localj.KII;; l1 = localj.KIH)
            {
              ((i)localObject3).KHZ = l1;
              localObject2 = a.KHO;
              a.a.a((i)localObject3);
              localObject2 = (Map)localj.KIF;
              localObject3 = ((i)localObject3).feedId;
              if (localObject2 != null) {
                break label768;
              }
              paramRecyclerView = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
              AppMethodBeat.o(205082);
              throw paramRecyclerView;
              l1 = localj.KIH;
              break label378;
              bool = localj.e((i)localObject3);
              ((i)localObject3).cEL = bool;
              break label458;
              paramInt = ((i)localObject3).y;
              float f1 = paramInt;
              float f2 = ((i)localObject3).height;
              if ((paramInt >= localj.KIN) || (f1 + f2 <= localj.KIM))
              {
                paramInt = 1;
                if (paramInt != 0) {
                  break label752;
                }
              }
              for (bool = true;; bool = false)
              {
                ((i)localObject3).cEL = bool;
                break label490;
                break;
                paramInt = 0;
                break label730;
              }
            }
            aa.eP(localObject2).remove(localObject3);
          }
        }
        label768:
        label784:
        localj.e((List)localObject1, l2);
        paramRecyclerView = c.KGM;
        c.a.fRL();
      }
      AppMethodBeat.o(205082);
      return;
    }
    AppMethodBeat.o(205082);
  }
  
  public final void fRs()
  {
    AppMethodBeat.i(205083);
    Object localObject = b.a(this.KEZ);
    if (localObject != null)
    {
      ad.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshBegin...");
      long l = System.currentTimeMillis();
      ((j)localObject).KIT = ((j)localObject).KIJ;
      ((j)localObject).KIS = ((j)localObject).KIH;
      ((j)localObject).KIH = l;
      ((j)localObject).KIJ = 3;
      ((j)localObject).KIR.putAll((Map)((j)localObject).KIF);
      ((j)localObject).KIF.clear();
      localObject = c.KGM;
      c.fRD().clear();
      c.fRD().addAll((Collection)c.fRA());
      c.fRE().clear();
      c.fRE().addAll((Collection)c.fRB());
      c.fRF().clear();
      c.fRF().addAll((Collection)c.fRC());
      localObject = c.KGM;
      c.a.fRK();
      AppMethodBeat.o(205083);
      return;
    }
    AppMethodBeat.o(205083);
  }
  
  public final void fRt()
  {
    AppMethodBeat.i(205085);
    if (b.a(this.KEZ) != null) {
      j.fRP();
    }
    AppMethodBeat.o(205085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.b
 * JD-Core Version:    0.7.0.1
 */