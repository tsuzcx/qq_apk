package com.tencent.mm.plugin.expt.hellhound.ext.b;

import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.m.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.ext.b.d.i;
import com.tencent.mm.plugin.expt.hellhound.ext.b.d.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor;", "", "()V", "mCurPageName", "", "mStatistics", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/WaterfallsFlowStatistics;", "mWaterfallsFlowListener", "com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1;", "getLegalLayout", "Landroidx/recyclerview/widget/StaggeredGridLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "monitor", "", "activity", "Landroid/app/Activity;", "fragment", "Landroidx/fragment/app/Fragment;", "timestamp", "", "eventId", "", "unmonitor", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a zEE;
  public String zEF;
  public j zEG;
  public final b zEH;
  
  static
  {
    AppMethodBeat.i(300276);
    zEE = new c.a((byte)0);
    AppMethodBeat.o(300276);
  }
  
  public c()
  {
    AppMethodBeat.i(300253);
    this.zEH = new b(this);
    AppMethodBeat.o(300253);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/expt/hellhound/ext/finder/WaterfallsFlowMonitor$mWaterfallsFlowListener$1", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/IRecyclerMonitorListener;", "onLoadMoreBegin", "", "onLoadMoreEnd", "className", "", "args", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RefreshLoadMoreCallback$ArgsOnFetchDone;", "onRefreshBegin", "onRefreshEnd", "onScrollStateChanged", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements e
  {
    b(c paramc) {}
    
    public final void a(m.a parama)
    {
      AppMethodBeat.i(300299);
      j localj = c.a(this.zEI);
      if (localj != null)
      {
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd...");
        if (parama == null) {}
        for (List localList = null;; localList = parama.incrementList)
        {
          if (localList != null)
          {
            parama = parama.incrementList;
            s.checkNotNull(parama);
            if (!parama.isEmpty()) {
              break;
            }
          }
          Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshEnd, no refresh feed !!!");
          localj.zJx.putAll((Map)localj.zJJ);
          localj.zJJ.clear();
          parama = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKz().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKC());
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKA().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKD());
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKB().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKE());
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKC().clear();
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKD().clear();
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKE().clear();
          localj.zJB = localj.zJL;
          localj.zJz = localj.zJK;
          AppMethodBeat.o(300299);
          return;
        }
        localj.ah((Map)localj.zJJ);
        localj.a((Map)localj.zJJ, System.currentTimeMillis());
      }
      AppMethodBeat.o(300299);
    }
    
    public final void d(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(300291);
      s.u(paramRecyclerView, "recyclerView");
      StaggeredGridLayoutManager localStaggeredGridLayoutManager = c.m(paramRecyclerView);
      if (localStaggeredGridLayoutManager == null)
      {
        AppMethodBeat.o(300291);
        return;
      }
      j localj = c.a(this.zEI);
      long l2;
      Object localObject1;
      label118:
      int i;
      int j;
      if (localj != null)
      {
        s.u(paramRecyclerView, "recyclerView");
        s.u(localStaggeredGridLayoutManager, "layoutManager");
        if (localStaggeredGridLayoutManager.bWl == 2)
        {
          l2 = System.currentTimeMillis();
          localObject1 = localj.zJI;
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 == null) {
              localj.zJI = new WeakReference(localStaggeredGridLayoutManager);
            }
            localObject1 = localj.zDZ;
            if (localObject1 != null) {
              break label633;
            }
            localObject1 = null;
            if (localObject1 == null) {
              localj.zDZ = new WeakReference(paramRecyclerView);
            }
            localObject1 = localStaggeredGridLayoutManager.n(null);
            paramInt = Math.min(localObject1[0], localObject1[1]);
            localObject1 = localStaggeredGridLayoutManager.o(null);
            i = Math.max(Math.max(localObject1[0], localObject1[1]) - j.zJM, 0);
            paramInt = Math.max(paramInt, j.zJM) - j.zJM;
            localObject1 = (List)new ArrayList();
            j = i + 1;
            if (paramInt >= j) {
              break label775;
            }
          }
        }
      }
      for (;;)
      {
        i = paramInt + 1;
        Object localObject3 = localStaggeredGridLayoutManager.findViewByPosition(j.zJM + paramInt);
        if (localObject3 != null)
        {
          Object localObject4 = b.fb((View)localObject3);
          s.s(localObject4, "getCoordinateOnScreen(feedView)");
          Object localObject2 = (Integer)((Pair)localObject4).first;
          localObject4 = (Integer)((Pair)localObject4).second;
          localObject3 = localj.a((View)localObject3, paramInt, paramRecyclerView);
          if ((localObject3 != null) && (((i)localObject3).feedId != null))
          {
            String str = ((i)localObject3).feedId;
            s.checkNotNull(str);
            ((List)localObject1).add(str);
            label340:
            boolean bool;
            if (localj.zJz <= 0L)
            {
              l1 = localj.zJA;
              ((i)localObject3).zIH = l1;
              s.s(localObject2, "x");
              ((i)localObject3).x = ((Integer)localObject2).intValue();
              s.s(localObject4, "y");
              ((i)localObject3).y = ((Integer)localObject4).intValue();
              ((i)localObject3).position = paramInt;
              j.b((i)localObject3);
              localj.c((i)localObject3);
              localj.d((i)localObject3);
              if (!((i)localObject3).fhR) {
                break label656;
              }
              bool = false;
              label419:
              if ((bool) && (((i)localObject3).zJr <= 0L)) {
                ((i)localObject3).zJr = l2;
              }
              if (((i)localObject3).fhR) {
                break label675;
              }
              paramInt = 0;
              if ((paramInt == 0) && (((i)localObject3).zIJ > 0.0F)) {
                break label768;
              }
              if (((i)localObject3).zIJ <= 0.0F) {
                ((i)localObject3).fhR = false;
              }
              if ((((i)localObject3).zJr <= 0L) || (((i)localObject3).zJs > 0L)) {
                break label768;
              }
              ((i)localObject3).zJs = l2;
              ((i)localObject3).zJu = (((i)localObject3).zJs - ((i)localObject3).zJr);
              localj.zJB = 0;
              ((i)localObject3).zJt = 0;
              if (((i)localObject3).zIH <= 0L) {
                if (localj.zJz > 0L) {
                  break label745;
                }
              }
            }
            label656:
            label675:
            label717:
            label739:
            label745:
            for (long l1 = localj.zJA;; l1 = localj.zJz)
            {
              ((i)localObject3).zIH = l1;
              localObject2 = a.zIv;
              a.a.a((i)localObject3);
              localObject2 = (Map)localj.zJx;
              localObject3 = ((i)localObject3).feedId;
              if (localObject2 != null) {
                break label755;
              }
              paramRecyclerView = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
              AppMethodBeat.o(300291);
              throw paramRecyclerView;
              localObject1 = (StaggeredGridLayoutManager)((WeakReference)localObject1).get();
              break;
              label633:
              localObject1 = (RecyclerView)((WeakReference)localObject1).get();
              break label118;
              l1 = localj.zJz;
              break label340;
              bool = localj.e((i)localObject3);
              ((i)localObject3).fhR = bool;
              break label419;
              paramInt = ((i)localObject3).y;
              float f1 = paramInt;
              float f2 = ((i)localObject3).height;
              if ((paramInt >= localj.zJF) || (f1 + f2 <= localj.zJE))
              {
                paramInt = 1;
                if (paramInt != 0) {
                  break label739;
                }
              }
              for (bool = true;; bool = false)
              {
                ((i)localObject3).fhR = bool;
                break;
                paramInt = 0;
                break label717;
              }
            }
            label755:
            an.hJ(localObject2).remove(localObject3);
          }
        }
        label768:
        if (i >= j)
        {
          label775:
          localj.c((List)localObject1, l2);
          paramRecyclerView = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.dKO();
          AppMethodBeat.o(300291);
          return;
        }
        paramInt = i;
      }
    }
    
    public final void dKe()
    {
      AppMethodBeat.i(300295);
      Object localObject = c.a(this.zEI);
      if (localObject != null)
      {
        Log.i("HABBYGE-MALI.WaterfallsFlowStatistics", "computeOnRefreshBegin...");
        long l = System.currentTimeMillis();
        ((j)localObject).zJL = ((j)localObject).zJB;
        ((j)localObject).zJK = ((j)localObject).zJz;
        ((j)localObject).zJz = l;
        ((j)localObject).zJB = 3;
        ((j)localObject).zJJ.putAll((Map)((j)localObject).zJx);
        ((j)localObject).zJx.clear();
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKC().clear();
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKC().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKz());
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKD().clear();
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKD().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKA());
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKE().clear();
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKE().addAll((Collection)com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKB());
        localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
        com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.dKN();
      }
      AppMethodBeat.o(300295);
    }
    
    public final void dKf()
    {
      AppMethodBeat.i(300304);
      if (c.a(this.zEI) != null) {
        j.dLd();
      }
      AppMethodBeat.o(300304);
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(300278);
      s.u(paramRecyclerView, "recyclerView");
      AppMethodBeat.o(300278);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.c
 * JD-Core Version:    0.7.0.1
 */