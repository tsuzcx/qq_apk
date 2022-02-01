package com.tencent.mm.plugin.finder.report;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/ScrollStatisticListener;", "ID", "Data", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "()V", "statisticUtil", "Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "(Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;)V", "exposeStatisticUtil", "getExposeStatisticUtil", "()Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "setExposeStatisticUtil", "firstVisibleItemPosition", "", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "attachRecyclerView", "", "isStatistic", "", "detachRecyclerView", "getData", "index", "(I)Ljava/lang/Object;", "getId", "handleData", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-finder_release"})
public abstract class an<ID, Data>
  extends RecyclerView.l
{
  private RecyclerView jLl;
  private int sCr = -1;
  private int sCs = -1;
  int xrh = -1;
  int xrj = -1;
  public a<ID> zZO = new a();
  
  private void p(final RecyclerView paramRecyclerView)
  {
    p.k(paramRecyclerView, "recyclerView");
    paramRecyclerView.post((Runnable)new a(this, paramRecyclerView));
  }
  
  public abstract ID PS(int paramInt);
  
  public void b(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    p.k(paramRecyclerView, "recyclerView");
    this.jLl = paramRecyclerView;
    paramRecyclerView.a((RecyclerView.l)this);
    a locala = this.zZO;
    if (locala != null) {
      locala.zTC = true;
    }
    if (paramBoolean) {
      p(paramRecyclerView);
    }
  }
  
  public void dQB()
  {
    this.jLl = null;
    Object localObject = this.jLl;
    if (localObject != null) {
      ((RecyclerView)localObject).b((RecyclerView.l)this);
    }
    localObject = this.zZO;
    if (localObject != null)
    {
      ((a)localObject).zTC = false;
      ((a)localObject).zTD = null;
    }
  }
  
  public final RecyclerView getRecyclerView()
  {
    return this.jLl;
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
    p.k(paramRecyclerView, "recyclerView");
    p(paramRecyclerView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bn(paramRecyclerView);
    localb.sg(paramInt1);
    localb.sg(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
    p.k(paramRecyclerView, "recyclerView");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "ID", "Data", "run"})
  static final class a
    implements Runnable
  {
    a(an paraman, RecyclerView paramRecyclerView) {}
    
    public final void run()
    {
      int i = 0;
      int k = 0;
      RecyclerView.v localv = null;
      Object localObject3 = null;
      AppMethodBeat.i(280293);
      Object localObject2 = paramRecyclerView.getLayoutManager();
      Object localObject1;
      label116:
      int j;
      if ((localObject2 instanceof LinearLayoutManager))
      {
        this.zZP.xrh = i.ov(0, ((LinearLayoutManager)localObject2).kJ());
        this.zZP.xrj = i.ov(0, ((LinearLayoutManager)localObject2).kL());
        localv = paramRecyclerView.cJ(this.zZP.xrh);
        if (localv != null)
        {
          localObject1 = Integer.valueOf(localv.md());
          if (localv == null) {
            break label214;
          }
          localObject2 = Integer.valueOf(localv.mc());
          if (!(p.h(localObject1, localObject2) ^ true)) {
            break label501;
          }
          localObject2 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
          if (localv == null) {
            break label220;
          }
        }
        label214:
        label220:
        for (localObject1 = Integer.valueOf(localv.md());; localObject1 = null)
        {
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", layoutPosition=");
          localObject1 = localObject3;
          if (localv != null) {
            localObject1 = Integer.valueOf(localv.mc());
          }
          Log.w("RecyclerViewAdapterEx", localObject1);
          AppMethodBeat.o(280293);
          return;
          localObject1 = null;
          break;
          localObject2 = null;
          break label116;
        }
      }
      else
      {
        if (!(localObject2 instanceof StaggeredGridLayoutManager)) {
          break label503;
        }
        localObject1 = ((StaggeredGridLayoutManager)localObject2).k(null);
        localObject2 = ((StaggeredGridLayoutManager)localObject2).l(null);
        localObject3 = this.zZP;
        if (localObject1 != null)
        {
          i = localObject1[0];
          if (localObject1 == null) {
            break label473;
          }
          j = localObject1[1];
          label282:
          ((an)localObject3).xrh = i.ow(i, j);
          localObject1 = this.zZP;
          if (localObject2 == null) {
            break label478;
          }
          i = localObject2[0];
          label308:
          j = k;
          if (localObject2 != null) {
            j = localObject2[1];
          }
          ((an)localObject1).xrj = i.ov(i, j);
          localObject3 = paramRecyclerView.cJ(this.zZP.xrh);
          if (localObject3 == null) {
            break label483;
          }
          localObject1 = Integer.valueOf(((RecyclerView.v)localObject3).md());
          label361:
          if (localObject3 == null) {
            break label489;
          }
          localObject2 = Integer.valueOf(((RecyclerView.v)localObject3).mc());
          label376:
          if (!(p.h(localObject1, localObject2) ^ true)) {
            break label501;
          }
          localObject2 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
          if (localObject3 == null) {
            break label495;
          }
        }
        label473:
        label478:
        label483:
        label489:
        label495:
        for (localObject1 = Integer.valueOf(((RecyclerView.v)localObject3).md());; localObject1 = null)
        {
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", layoutPosition=");
          localObject1 = localv;
          if (localObject3 != null) {
            localObject1 = Integer.valueOf(((RecyclerView.v)localObject3).mc());
          }
          Log.w("RecyclerViewAdapterEx", localObject1);
          AppMethodBeat.o(280293);
          return;
          i = 0;
          break;
          j = 0;
          break label282;
          i = 0;
          break label308;
          localObject1 = null;
          break label361;
          localObject2 = null;
          break label376;
        }
      }
      label501:
      i = 1;
      label503:
      if (i != 0)
      {
        localObject1 = (Set)new LinkedHashSet();
        i = this.zZP.xrh;
        j = this.zZP.xrj;
        if (i <= j) {
          for (;;)
          {
            ((Set)localObject1).add(this.zZP.PS(i));
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
        localObject2 = this.zZP.zZO;
        if (localObject2 != null)
        {
          ((a)localObject2).m((Set)localObject1);
          AppMethodBeat.o(280293);
          return;
        }
      }
      AppMethodBeat.o(280293);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.an
 * JD-Core Version:    0.7.0.1
 */