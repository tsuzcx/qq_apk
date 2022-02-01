package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.l.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.view.recyclerview.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.expt.hellhound.a.b.b.e
{
  private final RecyclerView.c nez;
  private List<Pair<String, String>> rcg;
  private com.tencent.mm.plugin.expt.hellhound.a.a.e rch;
  WeakReference<d> rci;
  p rcj;
  final a rck;
  private final b rcl;
  
  public a()
  {
    AppMethodBeat.i(196033);
    this.rci = null;
    this.rck = new a((byte)0);
    this.nez = new a.1(this);
    this.rcl = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject)
      {
        AppMethodBeat.i(196031);
        if ((paramAnonymousString1.equals("android/support/v7/widget/RecyclerView")) || (paramAnonymousString1.startsWith("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI")))
        {
          if (a.this.rcj == null)
          {
            AppMethodBeat.o(196031);
            return;
          }
          if ((paramAnonymousString2.equals("smoothScrollToPosition")) && ("(I)V".equals(paramAnonymousString3)))
          {
            if (a.this.rci != null)
            {
              paramAnonymousString1 = (d)a.this.rci.get();
              if (paramAnonymousString1 != null)
              {
                a.this.rck.rcn = true;
                paramAnonymousString1.getRecyclerView().post(a.this.rck);
              }
            }
            AppMethodBeat.o(196031);
            return;
          }
          if ((paramAnonymousString2.equals("scrollToPosition")) && ("(I)V".equals(paramAnonymousString3)) && (a.this.rci != null))
          {
            paramAnonymousString1 = (d)a.this.rci.get();
            if (paramAnonymousString1 != null)
            {
              a.this.rck.rcn = true;
              paramAnonymousString1.getRecyclerView().post(a.this.rck);
            }
          }
        }
        AppMethodBeat.o(196031);
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject) {}
    };
    AppMethodBeat.o(196033);
  }
  
  private static LinearLayoutManager r(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(196040);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (!(paramRecyclerView instanceof LinearLayoutManager))
    {
      AppMethodBeat.o(196040);
      return null;
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    AppMethodBeat.o(196040);
    return paramRecyclerView;
  }
  
  public final void a(com.tencent.mm.plugin.expt.hellhound.a.a.e parame, p paramp)
  {
    AppMethodBeat.i(196034);
    j.reI.a(this);
    this.rcg = new ArrayList();
    this.rcg.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.rcg.add(Pair.create("scrollToPosition", "(I)V"));
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.a(this.rcg, this.rcl);
    this.rch = parame;
    this.rcj = paramp;
    AppMethodBeat.o(196034);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(196038);
    if (parama == null)
    {
      AppMethodBeat.o(196038);
      return;
    }
    List localList = parama.incrementList;
    if ((localList == null) || (localList.isEmpty()))
    {
      ae.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: incrementList is NULL");
      AppMethodBeat.o(196038);
      return;
    }
    ae.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: %s, %d", new Object[] { Integer.valueOf(parama.pullType), Integer.valueOf(localList.size()) });
    if (this.rci != null)
    {
      parama = (d)this.rci.get();
      if (parama != null)
      {
        this.rck.rcn = false;
        parama.getRecyclerView().post(this.rck);
      }
    }
    AppMethodBeat.o(196038);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(196036);
    if (r(paramRecyclerView) == null)
    {
      AppMethodBeat.o(196036);
      return;
    }
    Object localObject2;
    if (this.rci != null)
    {
      localObject2 = (d)this.rci.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof d))
      {
        localObject1 = (d)localObject2;
        this.rci = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((d)localObject1).b(this.nez);
          ((d)localObject1).a(this.nez);
        }
        if (this.rch != null) {
          this.rch.l(paramRecyclerView, paramInt);
        }
        AppMethodBeat.o(196036);
        return;
      }
    }
  }
  
  public final void cqe()
  {
    AppMethodBeat.i(196035);
    j.reI.b(this);
    this.rch = null;
    com.tencent.mm.hellhoundlib.a.ahD();
    com.tencent.mm.hellhoundlib.a.b(this.rcg, this.rcl);
    this.rcj = null;
    if (this.rci != null)
    {
      d locald = (d)this.rci.get();
      if (locald != null)
      {
        locald.b(this.nez);
        this.rci.clear();
        this.rci = null;
      }
    }
    AppMethodBeat.o(196035);
  }
  
  public final void cql() {}
  
  public final void cqm()
  {
    AppMethodBeat.i(196039);
    if (this.rci != null)
    {
      d locald = (d)this.rci.get();
      if (locald != null)
      {
        this.rck.rcn = false;
        locald.getRecyclerView().post(this.rck);
      }
    }
    AppMethodBeat.o(196039);
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(196037);
    Object localObject1 = r(paramRecyclerView);
    if (localObject1 == null)
    {
      AppMethodBeat.o(196037);
      return;
    }
    int i = ((LinearLayoutManager)localObject1).km();
    int j = ((LinearLayoutManager)localObject1).ko();
    ((LinearLayoutManager)localObject1).getItemCount();
    int k = Math.min(j - i + 1, paramRecyclerView.getChildCount());
    Object localObject2;
    if (this.rci != null)
    {
      localObject2 = (d)this.rci.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof d))
      {
        localObject1 = (d)localObject2;
        this.rci = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          i = Math.max(i - ((d)localObject1).LRV.size(), 0);
          j = Math.max(j - ((d)localObject1).LRV.size(), 0);
          ((d)localObject1).b(this.nez);
          ((d)localObject1).a(this.nez);
        }
        for (;;)
        {
          j = Math.max(Math.min(j - i + 1, k), 0);
          if (this.rch != null) {
            this.rch.a(paramRecyclerView, i, j, paramInt);
          }
          AppMethodBeat.o(196037);
          return;
        }
      }
    }
  }
  
  final class a
    implements Runnable
  {
    boolean rcn = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(196032);
      if (a.this.rcj != null) {
        a.this.rcj.kZ(this.rcn);
      }
      AppMethodBeat.o(196032);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */