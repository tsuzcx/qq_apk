package com.tencent.mm.plugin.finder.report;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/report/ScrollStatisticListener;", "ID", "Data", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "()V", "statisticUtil", "Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "(Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;)V", "exposeStatisticUtil", "getExposeStatisticUtil", "()Lcom/tencent/mm/plugin/finder/report/ExposeStatisticUtil;", "setExposeStatisticUtil", "firstVisibleItemPosition", "", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "(I)V", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "attachRecyclerView", "", "isStatistic", "", "detachRecyclerView", "getData", "index", "(I)Ljava/lang/Object;", "getId", "handleData", "onScrollStateChanged", "newState", "onScrolled", "dx", "dy", "plugin-finder_release"})
public abstract class ak<ID, Data>
  extends RecyclerView.l
{
  RecyclerView hak;
  private int ptb = -1;
  private int ptc = -1;
  int tIA = -1;
  int tIy = -1;
  public a<ID> viV = new a();
  
  private void q(final RecyclerView paramRecyclerView)
  {
    p.h(paramRecyclerView, "recyclerView");
    paramRecyclerView.post((Runnable)new a(this, paramRecyclerView));
  }
  
  public abstract ID KG(int paramInt);
  
  public void b(RecyclerView paramRecyclerView, boolean paramBoolean)
  {
    p.h(paramRecyclerView, "recyclerView");
    this.hak = paramRecyclerView;
    paramRecyclerView.a((RecyclerView.l)this);
    a locala = this.viV;
    if (locala != null) {
      locala.vcL = true;
    }
    if (paramBoolean) {
      q(paramRecyclerView);
    }
  }
  
  public void doY()
  {
    this.hak = null;
    Object localObject = this.hak;
    if (localObject != null) {
      ((RecyclerView)localObject).b((RecyclerView.l)this);
    }
    localObject = this.viV;
    if (localObject != null)
    {
      ((a)localObject).vcL = false;
      ((a)localObject).vcM = null;
    }
  }
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    p.h(paramRecyclerView, "recyclerView");
    q(paramRecyclerView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    p.h(paramRecyclerView, "recyclerView");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/report/ScrollStatisticListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "ID", "Data", "run"})
  static final class a
    implements Runnable
  {
    a(ak paramak, RecyclerView paramRecyclerView) {}
    
    public final void run()
    {
      int i = 0;
      int k = 0;
      RecyclerView.v localv = null;
      Object localObject3 = null;
      AppMethodBeat.i(250883);
      Object localObject2 = paramRecyclerView.getLayoutManager();
      Object localObject1;
      label116:
      int j;
      if ((localObject2 instanceof LinearLayoutManager))
      {
        this.viW.tIy = j.mZ(0, ((LinearLayoutManager)localObject2).ks());
        this.viW.tIA = j.mZ(0, ((LinearLayoutManager)localObject2).ku());
        localv = paramRecyclerView.cg(this.viW.tIy);
        if (localv != null)
        {
          localObject1 = Integer.valueOf(localv.lR());
          if (localv == null) {
            break label214;
          }
          localObject2 = Integer.valueOf(localv.lQ());
          if (!(p.j(localObject1, localObject2) ^ true)) {
            break label501;
          }
          localObject2 = new StringBuilder("[onScrollStateChanged] invalid. adapterPosition=");
          if (localv == null) {
            break label220;
          }
        }
        label214:
        label220:
        for (localObject1 = Integer.valueOf(localv.lR());; localObject1 = null)
        {
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", layoutPosition=");
          localObject1 = localObject3;
          if (localv != null) {
            localObject1 = Integer.valueOf(localv.lQ());
          }
          Log.w("RecyclerViewAdapterEx", localObject1);
          AppMethodBeat.o(250883);
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
        localObject1 = ((StaggeredGridLayoutManager)localObject2).n(null);
        localObject2 = ((StaggeredGridLayoutManager)localObject2).o(null);
        localObject3 = this.viW;
        if (localObject1 != null)
        {
          i = localObject1[0];
          if (localObject1 == null) {
            break label473;
          }
          j = localObject1[1];
          label282:
          ((ak)localObject3).tIy = j.na(i, j);
          localObject1 = this.viW;
          if (localObject2 == null) {
            break label478;
          }
          i = localObject2[0];
          label308:
          j = k;
          if (localObject2 != null) {
            j = localObject2[1];
          }
          ((ak)localObject1).tIA = j.mZ(i, j);
          localObject3 = paramRecyclerView.cg(this.viW.tIy);
          if (localObject3 == null) {
            break label483;
          }
          localObject1 = Integer.valueOf(((RecyclerView.v)localObject3).lR());
          label361:
          if (localObject3 == null) {
            break label489;
          }
          localObject2 = Integer.valueOf(((RecyclerView.v)localObject3).lQ());
          label376:
          if (!(p.j(localObject1, localObject2) ^ true)) {
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
        for (localObject1 = Integer.valueOf(((RecyclerView.v)localObject3).lR());; localObject1 = null)
        {
          localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", layoutPosition=");
          localObject1 = localv;
          if (localObject3 != null) {
            localObject1 = Integer.valueOf(((RecyclerView.v)localObject3).lQ());
          }
          Log.w("RecyclerViewAdapterEx", localObject1);
          AppMethodBeat.o(250883);
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
        i = this.viW.tIy;
        j = this.viW.tIA;
        if (i <= j) {
          for (;;)
          {
            ((Set)localObject1).add(this.viW.KG(i));
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
        localObject2 = this.viW.viV;
        if (localObject2 != null)
        {
          ((a)localObject2).m((Set)localObject1);
          AppMethodBeat.o(250883);
          return;
        }
      }
      AppMethodBeat.o(250883);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ak
 * JD-Core Version:    0.7.0.1
 */