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
import com.tencent.mm.sdk.platformtools.ac;
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

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "", "()V", "mCurPageName", "", "mStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "mWaterfallsFlowListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1;", "getLegalLayout", "Landroid/support/v7/widget/StaggeredGridLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "monitor", "", "activity", "Landroid/app/Activity;", "fragment", "Landroid/support/v4/app/Fragment;", "timestamp", "", "eventId", "", "unmonitor", "Companion", "plugin-expt_release"})
public final class b
{
  public static final b.a qlj;
  public String qlg;
  public j qlh;
  public final b qli;
  
  static
  {
    AppMethodBeat.i(195346);
    qlj = new b.a((byte)0);
    AppMethodBeat.o(195346);
  }
  
  public b()
  {
    AppMethodBeat.i(195345);
    this.qli = new b(this);
    AppMethodBeat.o(195345);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "onLoadMoreBegin", "", "onLoadMoreEnd", "className", "", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"})
  public static final class b
    implements e
  {
    public final void a(l.a parama)
    {
      AppMethodBeat.i(195343);
      j localj = b.a(this.qlk);
      if (localj != null)
      {
        ac.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd...");
        if (parama != null) {}
        for (List localList = parama.incrementList;; localList = null)
        {
          if (localList != null)
          {
            parama = parama.incrementList;
            if (parama == null) {
              k.fOy();
            }
            if (!parama.isEmpty()) {
              break;
            }
          }
          ac.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd, no refresh feed !!!");
          localj.qoX.putAll((Map)localj.qpj);
          localj.qpj.clear();
          parama = c.qna;
          c.cjH().addAll((Collection)c.cjK());
          c.cjI().addAll((Collection)c.cjL());
          c.cjJ().addAll((Collection)c.cjM());
          c.cjK().clear();
          c.cjL().clear();
          c.cjM().clear();
          localj.qpb = localj.qpl;
          localj.qoZ = localj.qpk;
          AppMethodBeat.o(195343);
          return;
        }
        localj.U((Map)localj.qpj);
        localj.a((Map)localj.qpj, System.currentTimeMillis());
        AppMethodBeat.o(195343);
        return;
      }
      AppMethodBeat.o(195343);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(195340);
      k.h(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(195340);
    }
    
    public final void cjx()
    {
      AppMethodBeat.i(195342);
      Object localObject = b.a(this.qlk);
      if (localObject != null)
      {
        ac.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshBegin...");
        long l = System.currentTimeMillis();
        ((j)localObject).qpl = ((j)localObject).qpb;
        ((j)localObject).qpk = ((j)localObject).qoZ;
        ((j)localObject).qoZ = l;
        ((j)localObject).qpb = 3;
        ((j)localObject).qpj.putAll((Map)((j)localObject).qoX);
        ((j)localObject).qoX.clear();
        localObject = c.qna;
        c.cjK().clear();
        c.cjK().addAll((Collection)c.cjH());
        c.cjL().clear();
        c.cjL().addAll((Collection)c.cjI());
        c.cjM().clear();
        c.cjM().addAll((Collection)c.cjJ());
        localObject = c.qna;
        c.a.cjR();
        AppMethodBeat.o(195342);
        return;
      }
      AppMethodBeat.o(195342);
    }
    
    public final void cjy()
    {
      AppMethodBeat.i(195344);
      if (b.a(this.qlk) != null) {
        j.cjW();
      }
      AppMethodBeat.o(195344);
    }
    
    public final void f(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(195341);
      k.h(paramRecyclerView, "recyclerView");
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = b.q(paramRecyclerView);
      if (localStaggeredGridLayoutManager == null)
      {
        AppMethodBeat.o(195341);
        return;
      }
      j localj = b.a(this.qlk);
      if (localj != null)
      {
        k.h(paramRecyclerView, "recyclerView");
        k.h(localStaggeredGridLayoutManager, "layoutManager");
        if (localStaggeredGridLayoutManager.jJ() == 2)
        {
          long l2 = System.currentTimeMillis();
          Object localObject1 = localj.qpi;
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
              localj.qpi = new WeakReference(localStaggeredGridLayoutManager);
            }
            localObject1 = localj.qkI;
            if (localObject1 == null) {
              break label322;
            }
            localObject1 = (RecyclerView)((WeakReference)localObject1).get();
            if (localObject1 == null) {
              localj.qkI = new WeakReference(paramRecyclerView);
            }
            localObject1 = localStaggeredGridLayoutManager.n(null);
            paramInt = Math.min(localObject1[0], localObject1[1]);
            localObject1 = localStaggeredGridLayoutManager.mi();
            int j = Math.max(Math.max(localObject1[0], localObject1[1]) - j.qpm, 0);
            paramInt = Math.max(paramInt, j.qpm);
            i = j.qpm;
            localObject1 = (List)new ArrayList();
            i = paramInt - i;
            if (i >= j + 1) {
              break label784;
            }
            localObject3 = localStaggeredGridLayoutManager.bY(j.qpm + i);
            if (localObject3 != null)
            {
              localObject4 = com.tencent.mm.plugin.expt.hellhound.core.b.dO((View)localObject3);
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
                k.fOy();
              }
              ((List)localObject1).add(str);
              label378:
              boolean bool;
              if (localj.qoZ <= 0L)
              {
                l1 = localj.qpa;
                ((i)localObject3).qoq = l1;
                k.g(localObject2, "x");
                ((i)localObject3).x = ((Integer)localObject2).intValue();
                k.g(localObject4, "y");
                ((i)localObject3).y = ((Integer)localObject4).intValue();
                ((i)localObject3).position = i;
                j.b((i)localObject3);
                localj.c((i)localObject3);
                localj.d((i)localObject3);
                if (!((i)localObject3).cBT) {
                  break label669;
                }
                bool = false;
                label458:
                if ((bool) && (((i)localObject3).qoS <= 0L)) {
                  ((i)localObject3).qoS = l2;
                }
                if (((i)localObject3).cBT) {
                  break label688;
                }
                paramInt = 0;
                label490:
                if ((paramInt == 0) && (((i)localObject3).qos > 0.0F)) {
                  break label745;
                }
                if (((i)localObject3).qos <= 0.0F) {
                  ((i)localObject3).cBT = false;
                }
                if ((((i)localObject3).qoS <= 0L) || (((i)localObject3).qoT > 0L)) {
                  continue;
                }
                ((i)localObject3).qoT = l2;
                ((i)localObject3).qoV = (((i)localObject3).qoT - ((i)localObject3).qoS);
                localj.qpb = 0;
                ((i)localObject3).qoU = 0;
                if (((i)localObject3).qoq <= 0L) {
                  if (localj.qoZ > 0L) {
                    break label758;
                  }
                }
              }
              label730:
              label745:
              label752:
              label758:
              for (long l1 = localj.qpa;; l1 = localj.qoZ)
              {
                ((i)localObject3).qoq = l1;
                localObject2 = a.qoc;
                a.a.a((i)localObject3);
                localObject2 = (Map)localj.qoX;
                localObject3 = ((i)localObject3).feedId;
                if (localObject2 != null) {
                  break label768;
                }
                paramRecyclerView = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(195341);
                throw paramRecyclerView;
                l1 = localj.qoZ;
                break label378;
                bool = localj.e((i)localObject3);
                ((i)localObject3).cBT = bool;
                break label458;
                paramInt = ((i)localObject3).y;
                float f1 = paramInt;
                float f2 = ((i)localObject3).height;
                if ((paramInt >= localj.qpf) || (f1 + f2 <= localj.qpe))
                {
                  paramInt = 1;
                  if (paramInt != 0) {
                    break label752;
                  }
                }
                for (bool = true;; bool = false)
                {
                  ((i)localObject3).cBT = bool;
                  break label490;
                  break;
                  paramInt = 0;
                  break label730;
                }
              }
              aa.eS(localObject2).remove(localObject3);
            }
          }
          label768:
          label784:
          localj.b((List)localObject1, l2);
          paramRecyclerView = c.qna;
          c.a.cjS();
        }
        AppMethodBeat.o(195341);
        return;
      }
      AppMethodBeat.o(195341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b
 * JD-Core Version:    0.7.0.1
 */