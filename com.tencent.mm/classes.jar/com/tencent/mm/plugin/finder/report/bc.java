package com.tencent.mm.plugin.finder.report;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/ScrollStatisticListener;", "ID", "Data", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "()V", "statisticUtil", "Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "(Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;)V", "exposeStatisticUtil", "getExposeStatisticUtil", "()Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "setExposeStatisticUtil", "firstVisibleItemPosition", "", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "attachRecyclerView", "", "isStatistic", "", "detachRecyclerView", "getData", "index", "(I)Ljava/lang/Object;", "getId", "handleData", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class bc<ID, Data>
  extends RecyclerView.l
{
  private int AOr = -1;
  private int AOt = -1;
  public a<ID> FuL = new a();
  private RecyclerView mkw;
  private int vIj = -1;
  private int vIk = -1;
  
  private void A(RecyclerView paramRecyclerView)
  {
    s.u(paramRecyclerView, "recyclerView");
    paramRecyclerView.post(new bc..ExternalSyntheticLambda0(paramRecyclerView, this));
  }
  
  private static final void a(RecyclerView paramRecyclerView, bc parambc)
  {
    RecyclerView.v localv = null;
    Object localObject2 = null;
    int i = 0;
    int k = 0;
    s.u(paramRecyclerView, "$recyclerView");
    s.u(parambc, "this$0");
    Object localObject1 = paramRecyclerView.getLayoutManager();
    if ((localObject1 instanceof LinearLayoutManager))
    {
      parambc.AOr = k.qu(0, ((LinearLayoutManager)localObject1).Ju());
      parambc.AOt = k.qu(0, ((LinearLayoutManager)localObject1).Jw());
      localv = paramRecyclerView.w(parambc.AOr, false);
      if (localv == null)
      {
        paramRecyclerView = null;
        if (localv != null) {
          break label166;
        }
        localObject1 = null;
        label95:
        if (s.p(paramRecyclerView, localObject1)) {
          break label445;
        }
        parambc = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
        if (localv != null) {
          break label179;
        }
        paramRecyclerView = null;
        label121:
        parambc = parambc.append(paramRecyclerView).append(", layoutPosition=");
        if (localv != null) {
          break label191;
        }
        paramRecyclerView = (RecyclerView)localObject2;
        label140:
        Log.w("RecyclerViewAdapterEx", paramRecyclerView);
      }
    }
    label166:
    label179:
    label191:
    label247:
    label380:
    do
    {
      return;
      paramRecyclerView = Integer.valueOf(localv.KJ());
      break;
      localObject1 = Integer.valueOf(localv.KI());
      break label95;
      paramRecyclerView = Integer.valueOf(localv.KJ());
      break label121;
      paramRecyclerView = Integer.valueOf(localv.KI());
      break label140;
      if ((localObject1 instanceof StaggeredGridLayoutManager))
      {
        localObject2 = ((StaggeredGridLayoutManager)localObject1).n(null);
        localObject1 = ((StaggeredGridLayoutManager)localObject1).o(null);
        if (localObject2 == null)
        {
          i = 0;
          if (localObject2 != null) {
            break label372;
          }
          j = 0;
          parambc.AOr = k.qv(i, j);
          if (localObject1 != null) {
            break label380;
          }
          i = 0;
          if (localObject1 != null) {
            break label388;
          }
          j = k;
          parambc.AOt = k.qu(i, j);
          localObject2 = paramRecyclerView.fT(parambc.AOr);
          if (localObject2 != null) {
            break label396;
          }
          paramRecyclerView = null;
          if (localObject2 != null) {
            break label408;
          }
          localObject1 = null;
          if (s.p(paramRecyclerView, localObject1)) {
            break label445;
          }
          parambc = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
          if (localObject2 != null) {
            break label421;
          }
          paramRecyclerView = null;
          parambc = parambc.append(paramRecyclerView).append(", layoutPosition=");
          if (localObject2 != null) {
            break label433;
          }
        }
        for (paramRecyclerView = localv;; paramRecyclerView = Integer.valueOf(((RecyclerView.v)localObject2).KI()))
        {
          Log.w("RecyclerViewAdapterEx", paramRecyclerView);
          return;
          i = localObject2[0];
          break;
          j = localObject2[1];
          break label247;
          i = localObject1[0];
          break label263;
          j = localObject1[1];
          break label271;
          paramRecyclerView = Integer.valueOf(((RecyclerView.v)localObject2).KJ());
          break label297;
          localObject1 = Integer.valueOf(((RecyclerView.v)localObject2).KI());
          break label305;
          paramRecyclerView = Integer.valueOf(((RecyclerView.v)localObject2).KJ());
          break label331;
        }
        i = 1;
      }
    } while (i == 0);
    label263:
    label271:
    label297:
    label305:
    label331:
    label372:
    paramRecyclerView = (Set)new LinkedHashSet();
    label388:
    label396:
    label408:
    label421:
    label433:
    label445:
    i = parambc.AOr;
    int j = parambc.AOt;
    if (i <= j) {}
    for (;;)
    {
      paramRecyclerView.add(parambc.SZ(i));
      if (i == j)
      {
        parambc = parambc.FuL;
        if (parambc == null) {
          break;
        }
        parambc.u(paramRecyclerView);
        return;
      }
      i += 1;
    }
  }
  
  public final void SX(int paramInt)
  {
    this.AOr = paramInt;
  }
  
  public final void SY(int paramInt)
  {
    this.AOt = paramInt;
  }
  
  public abstract ID SZ(int paramInt);
  
  public void b(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    s.u(paramRecyclerView, "recyclerView");
    this.mkw = paramRecyclerView;
    paramRecyclerView.a((RecyclerView.l)this);
    a locala = this.FuL;
    if (locala != null) {
      locala.Fnn = true;
    }
    if (paramBoolean) {
      A(paramRecyclerView);
    }
  }
  
  public final int dYN()
  {
    return this.AOr;
  }
  
  public final int dYO()
  {
    return this.AOt;
  }
  
  public void eNY()
  {
    this.mkw = null;
    Object localObject = this.mkw;
    if (localObject != null) {
      ((RecyclerView)localObject).b((RecyclerView.l)this);
    }
    localObject = this.FuL;
    if (localObject != null)
    {
      ((a)localObject).Fnn = false;
      ((a)localObject).Fno = null;
    }
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.mkw;
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
    s.u(paramRecyclerView, "recyclerView");
    A(paramRecyclerView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.cH(paramRecyclerView);
    localb.sc(paramInt1);
    localb.sc(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
    s.u(paramRecyclerView, "recyclerView");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.bc
 * JD-Core Version:    0.7.0.1
 */