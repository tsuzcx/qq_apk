package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements e
{
  WeakReference<com.tencent.mm.view.recyclerview.d> KFa;
  p KFb;
  final a KFc;
  private final b KFd;
  private final RecyclerView.c lWH;
  private List<Pair<String, String>> pGi;
  private com.tencent.mm.plugin.expt.hellhound.a.a.d pGj;
  
  public a()
  {
    AppMethodBeat.i(205393);
    this.KFa = null;
    this.KFc = new a((byte)0);
    this.lWH = new RecyclerView.c()
    {
      public final void as(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205386);
        super.as(paramAnonymousInt1, paramAnonymousInt2);
        a.a(a.this);
        AppMethodBeat.o(205386);
      }
      
      public final void at(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205388);
        super.at(paramAnonymousInt1, paramAnonymousInt2);
        a.a(a.this);
        AppMethodBeat.o(205388);
      }
      
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205389);
        super.au(paramAnonymousInt1, paramAnonymousInt2);
        a.a(a.this);
        AppMethodBeat.o(205389);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(205387);
        super.f(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        a.a(a.this);
        AppMethodBeat.o(205387);
      }
      
      public final void l(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
      {
        AppMethodBeat.i(205390);
        super.l(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
        a.a(a.this);
        AppMethodBeat.o(205390);
      }
      
      public final void onChanged()
      {
        AppMethodBeat.i(205385);
        super.onChanged();
        a.a(a.this);
        AppMethodBeat.o(205385);
      }
    };
    this.KFd = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject) {}
      
      public final void l(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(205391);
        if ((paramAnonymousString1.equals("android/support/v7/widget/RecyclerView")) || (paramAnonymousString1.startsWith("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI")))
        {
          if (a.this.KFb == null)
          {
            AppMethodBeat.o(205391);
            return;
          }
          if ((paramAnonymousString2.equals("smoothScrollToPosition")) && ("(I)V".equals(paramAnonymousString3)))
          {
            if (a.this.KFa != null)
            {
              paramAnonymousString1 = (com.tencent.mm.view.recyclerview.d)a.this.KFa.get();
              if (paramAnonymousString1 != null)
              {
                a.this.KFc.KFf = true;
                paramAnonymousString1.getRecyclerView().post(a.this.KFc);
              }
            }
            AppMethodBeat.o(205391);
            return;
          }
          if ((paramAnonymousString2.equals("scrollToPosition")) && ("(I)V".equals(paramAnonymousString3)) && (a.this.KFa != null))
          {
            paramAnonymousString1 = (com.tencent.mm.view.recyclerview.d)a.this.KFa.get();
            if (paramAnonymousString1 != null)
            {
              a.this.KFc.KFf = true;
              paramAnonymousString1.getRecyclerView().post(a.this.KFc);
            }
          }
        }
        AppMethodBeat.o(205391);
      }
    };
    AppMethodBeat.o(205393);
  }
  
  private static LinearLayoutManager u(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(205400);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (!(paramRecyclerView instanceof LinearLayoutManager))
    {
      AppMethodBeat.o(205400);
      return null;
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    AppMethodBeat.o(205400);
    return paramRecyclerView;
  }
  
  public final void a(com.tencent.mm.plugin.expt.hellhound.a.a.d paramd, p paramp)
  {
    AppMethodBeat.i(205394);
    j.KHt.a(this);
    this.pGi = new ArrayList();
    this.pGi.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.pGi.add(Pair.create("scrollToPosition", "(I)V"));
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.a(this.pGi, this.KFd);
    this.pGj = paramd;
    this.KFb = paramp;
    AppMethodBeat.o(205394);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(205398);
    if (parama == null)
    {
      AppMethodBeat.o(205398);
      return;
    }
    List localList = parama.incrementList;
    if ((localList == null) || (localList.isEmpty()))
    {
      ad.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: incrementList is NULL");
      AppMethodBeat.o(205398);
      return;
    }
    ad.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: %s, %d", new Object[] { Integer.valueOf(parama.pullType), Integer.valueOf(localList.size()) });
    if (this.KFa != null)
    {
      parama = (com.tencent.mm.view.recyclerview.d)this.KFa.get();
      if (parama != null)
      {
        this.KFc.KFf = false;
        parama.getRecyclerView().post(this.KFc);
      }
    }
    AppMethodBeat.o(205398);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(205396);
    if (u(paramRecyclerView) == null)
    {
      AppMethodBeat.o(205396);
      return;
    }
    Object localObject2;
    if (this.KFa != null)
    {
      localObject2 = (com.tencent.mm.view.recyclerview.d)this.KFa.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof com.tencent.mm.view.recyclerview.d))
      {
        localObject1 = (com.tencent.mm.view.recyclerview.d)localObject2;
        this.KFa = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((com.tencent.mm.view.recyclerview.d)localObject1).b(this.lWH);
          ((com.tencent.mm.view.recyclerview.d)localObject1).a(this.lWH);
        }
        if (this.pGj != null) {
          this.pGj.k(paramRecyclerView, paramInt);
        }
        AppMethodBeat.o(205396);
        return;
      }
    }
  }
  
  public final void ccd()
  {
    AppMethodBeat.i(205395);
    j.KHt.b(this);
    this.pGj = null;
    com.tencent.mm.hellhoundlib.a.adm();
    com.tencent.mm.hellhoundlib.a.b(this.pGi, this.KFd);
    this.KFb = null;
    if (this.KFa != null)
    {
      com.tencent.mm.view.recyclerview.d locald = (com.tencent.mm.view.recyclerview.d)this.KFa.get();
      if (locald != null)
      {
        locald.b(this.lWH);
        this.KFa.clear();
        this.KFa = null;
      }
    }
    AppMethodBeat.o(205395);
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(205397);
    Object localObject1 = u(paramRecyclerView);
    if (localObject1 == null)
    {
      AppMethodBeat.o(205397);
      return;
    }
    int i = ((LinearLayoutManager)localObject1).jO();
    int j = ((LinearLayoutManager)localObject1).jQ();
    ((LinearLayoutManager)localObject1).getItemCount();
    int k = Math.min(j - i + 1, paramRecyclerView.getChildCount());
    Object localObject2;
    if (this.KFa != null)
    {
      localObject2 = (com.tencent.mm.view.recyclerview.d)this.KFa.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof com.tencent.mm.view.recyclerview.d))
      {
        localObject1 = (com.tencent.mm.view.recyclerview.d)localObject2;
        this.KFa = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          i = Math.max(i - ((com.tencent.mm.view.recyclerview.d)localObject1).Ibl.size(), 0);
          j = Math.max(j - ((com.tencent.mm.view.recyclerview.d)localObject1).Ibl.size(), 0);
          ((com.tencent.mm.view.recyclerview.d)localObject1).b(this.lWH);
          ((com.tencent.mm.view.recyclerview.d)localObject1).a(this.lWH);
        }
        for (;;)
        {
          j = Math.max(Math.min(j - i + 1, k), 0);
          if (this.pGj != null) {
            this.pGj.a(paramRecyclerView, i, j, paramInt);
          }
          AppMethodBeat.o(205397);
          return;
        }
      }
    }
  }
  
  public final void fRs() {}
  
  public final void fRt()
  {
    AppMethodBeat.i(205399);
    if (this.KFa != null)
    {
      com.tencent.mm.view.recyclerview.d locald = (com.tencent.mm.view.recyclerview.d)this.KFa.get();
      if (locald != null)
      {
        this.KFc.KFf = false;
        locald.getRecyclerView().post(this.KFc);
      }
    }
    AppMethodBeat.o(205399);
  }
  
  final class a
    implements Runnable
  {
    boolean KFf = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(205392);
      if (a.this.KFb != null) {
        a.this.KFb.yx(this.KFf);
      }
      AppMethodBeat.o(205392);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */