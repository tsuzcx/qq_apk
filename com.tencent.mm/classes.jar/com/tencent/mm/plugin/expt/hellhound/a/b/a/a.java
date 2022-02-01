package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements e
{
  private List<Pair<String, String>> sCM;
  private f sCN;
  WeakReference<g> sCO;
  p sCP;
  final a sCQ;
  private final RecyclerView.c sCR;
  private final b sCS;
  
  public a()
  {
    AppMethodBeat.i(220463);
    this.sCO = null;
    this.sCQ = new a((byte)0);
    this.sCR = new a.1(this);
    this.sCS = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject)
      {
        AppMethodBeat.i(220461);
        if ((paramAnonymousString1.equals("android/support/v7/widget/RecyclerView")) || (paramAnonymousString1.startsWith("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI")))
        {
          if (a.this.sCP == null)
          {
            AppMethodBeat.o(220461);
            return;
          }
          if ((paramAnonymousString2.equals("smoothScrollToPosition")) && ("(I)V".equals(paramAnonymousString3)))
          {
            if (a.this.sCO != null)
            {
              paramAnonymousString1 = (g)a.this.sCO.get();
              if (paramAnonymousString1 != null)
              {
                a.this.sCQ.sCU = true;
                paramAnonymousString1.getRecyclerView().post(a.this.sCQ);
              }
            }
            AppMethodBeat.o(220461);
            return;
          }
          if ((paramAnonymousString2.equals("scrollToPosition")) && ("(I)V".equals(paramAnonymousString3)) && (a.this.sCO != null))
          {
            paramAnonymousString1 = (g)a.this.sCO.get();
            if (paramAnonymousString1 != null)
            {
              a.this.sCQ.sCU = true;
              paramAnonymousString1.getRecyclerView().post(a.this.sCQ);
            }
          }
        }
        AppMethodBeat.o(220461);
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject) {}
    };
    AppMethodBeat.o(220463);
  }
  
  private static LinearLayoutManager l(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(220470);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (!(paramRecyclerView instanceof LinearLayoutManager))
    {
      AppMethodBeat.o(220470);
      return null;
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    AppMethodBeat.o(220470);
    return paramRecyclerView;
  }
  
  public final void a(f paramf, p paramp)
  {
    AppMethodBeat.i(220464);
    k.sFY.a(this);
    this.sCM = new ArrayList();
    this.sCM.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.sCM.add(Pair.create("scrollToPosition", "(I)V"));
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.a(this.sCM, this.sCS);
    this.sCN = paramf;
    this.sCP = paramp;
    AppMethodBeat.o(220464);
  }
  
  public final void a(m.a parama)
  {
    AppMethodBeat.i(220468);
    if (parama == null)
    {
      AppMethodBeat.o(220468);
      return;
    }
    List localList = parama.incrementList;
    if ((localList == null) || (localList.isEmpty()))
    {
      Log.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: incrementList is NULL");
      AppMethodBeat.o(220468);
      return;
    }
    Log.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: %s, %d", new Object[] { Integer.valueOf(parama.pullType), Integer.valueOf(localList.size()) });
    if (this.sCO != null)
    {
      parama = (g)this.sCO.get();
      if (parama != null)
      {
        this.sCQ.sCU = false;
        parama.getRecyclerView().post(this.sCQ);
      }
    }
    AppMethodBeat.o(220468);
  }
  
  public final void cOE() {}
  
  public final void cOF()
  {
    AppMethodBeat.i(220469);
    if (this.sCO != null)
    {
      g localg = (g)this.sCO.get();
      if (localg != null)
      {
        this.sCQ.sCU = false;
        localg.getRecyclerView().post(this.sCQ);
      }
    }
    AppMethodBeat.o(220469);
  }
  
  public final void e(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(220467);
    Object localObject1 = l(paramRecyclerView);
    if (localObject1 == null)
    {
      AppMethodBeat.o(220467);
      return;
    }
    int i = ((LinearLayoutManager)localObject1).ks();
    int j = ((LinearLayoutManager)localObject1).ku();
    ((LinearLayoutManager)localObject1).getItemCount();
    int k = Math.min(j - i + 1, paramRecyclerView.getChildCount());
    Object localObject2;
    if (this.sCO != null)
    {
      localObject2 = (g)this.sCO.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof g))
      {
        localObject1 = (g)localObject2;
        this.sCO = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          i = Math.max(i - ((g)localObject1).RqM.size(), 0);
          j = Math.max(j - ((g)localObject1).RqM.size(), 0);
          ((g)localObject1).b(this.sCR);
          ((g)localObject1).a(this.sCR);
        }
        for (;;)
        {
          j = Math.max(Math.min(j - i + 1, k), 0);
          if (this.sCN != null) {
            this.sCN.a(paramRecyclerView, i, j, paramInt);
          }
          AppMethodBeat.o(220467);
          return;
        }
      }
    }
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(220466);
    if (l(paramRecyclerView) == null)
    {
      AppMethodBeat.o(220466);
      return;
    }
    Object localObject2;
    if (this.sCO != null)
    {
      localObject2 = (g)this.sCO.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof g))
      {
        localObject1 = (g)localObject2;
        this.sCO = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((g)localObject1).b(this.sCR);
          ((g)localObject1).a(this.sCR);
        }
        if (this.sCN != null) {
          this.sCN.k(paramRecyclerView, paramInt);
        }
        AppMethodBeat.o(220466);
        return;
      }
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(220465);
    k.sFY.b(this);
    this.sCN = null;
    com.tencent.mm.hellhoundlib.a.axP();
    com.tencent.mm.hellhoundlib.a.b(this.sCM, this.sCS);
    this.sCP = null;
    if (this.sCO != null)
    {
      g localg = (g)this.sCO.get();
      if (localg != null)
      {
        localg.b(this.sCR);
        this.sCO.clear();
        this.sCO = null;
      }
    }
    AppMethodBeat.o(220465);
  }
  
  final class a
    implements Runnable
  {
    boolean sCU = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(220462);
      if (a.this.sCP != null) {
        a.this.sCP.md(this.sCU);
      }
      AppMethodBeat.o(220462);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */