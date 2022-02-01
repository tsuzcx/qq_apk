package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.view.recyclerview.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.expt.hellhound.a.b.b.e
{
  private final RecyclerView.c myJ;
  private List<Pair<String, String>> qll;
  private com.tencent.mm.plugin.expt.hellhound.a.a.e qlm;
  WeakReference<d> qln;
  p qlo;
  final a qlp;
  private final b qlq;
  
  public a()
  {
    AppMethodBeat.i(195226);
    this.qln = null;
    this.qlp = new a((byte)0);
    this.myJ = new a.1(this);
    this.qlq = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject) {}
      
      public final void l(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
      {
        AppMethodBeat.i(195224);
        if ((paramAnonymousString1.equals("android/support/v7/widget/RecyclerView")) || (paramAnonymousString1.startsWith("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI")))
        {
          if (a.this.qlo == null)
          {
            AppMethodBeat.o(195224);
            return;
          }
          if ((paramAnonymousString2.equals("smoothScrollToPosition")) && ("(I)V".equals(paramAnonymousString3)))
          {
            if (a.this.qln != null)
            {
              paramAnonymousString1 = (d)a.this.qln.get();
              if (paramAnonymousString1 != null)
              {
                a.this.qlp.qls = true;
                paramAnonymousString1.getRecyclerView().post(a.this.qlp);
              }
            }
            AppMethodBeat.o(195224);
            return;
          }
          if ((paramAnonymousString2.equals("scrollToPosition")) && ("(I)V".equals(paramAnonymousString3)) && (a.this.qln != null))
          {
            paramAnonymousString1 = (d)a.this.qln.get();
            if (paramAnonymousString1 != null)
            {
              a.this.qlp.qls = true;
              paramAnonymousString1.getRecyclerView().post(a.this.qlp);
            }
          }
        }
        AppMethodBeat.o(195224);
      }
    };
    AppMethodBeat.o(195226);
  }
  
  private static LinearLayoutManager r(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(195233);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (!(paramRecyclerView instanceof LinearLayoutManager))
    {
      AppMethodBeat.o(195233);
      return null;
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    AppMethodBeat.o(195233);
    return paramRecyclerView;
  }
  
  public final void a(com.tencent.mm.plugin.expt.hellhound.a.a.e parame, p paramp)
  {
    AppMethodBeat.i(195227);
    j.qnH.a(this);
    this.qll = new ArrayList();
    this.qll.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.qll.add(Pair.create("scrollToPosition", "(I)V"));
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.a(this.qll, this.qlq);
    this.qlm = parame;
    this.qlo = paramp;
    AppMethodBeat.o(195227);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(195231);
    if (parama == null)
    {
      AppMethodBeat.o(195231);
      return;
    }
    List localList = parama.incrementList;
    if ((localList == null) || (localList.isEmpty()))
    {
      ac.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: incrementList is NULL");
      AppMethodBeat.o(195231);
      return;
    }
    ac.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: %s, %d", new Object[] { Integer.valueOf(parama.pullType), Integer.valueOf(localList.size()) });
    if (this.qln != null)
    {
      parama = (d)this.qln.get();
      if (parama != null)
      {
        this.qlp.qls = false;
        parama.getRecyclerView().post(this.qlp);
      }
    }
    AppMethodBeat.o(195231);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(195229);
    if (r(paramRecyclerView) == null)
    {
      AppMethodBeat.o(195229);
      return;
    }
    Object localObject2;
    if (this.qln != null)
    {
      localObject2 = (d)this.qln.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof d))
      {
        localObject1 = (d)localObject2;
        this.qln = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((d)localObject1).b(this.myJ);
          ((d)localObject1).a(this.myJ);
        }
        if (this.qlm != null) {
          this.qlm.k(paramRecyclerView, paramInt);
        }
        AppMethodBeat.o(195229);
        return;
      }
    }
  }
  
  public final void cjq()
  {
    AppMethodBeat.i(195228);
    j.qnH.b(this);
    this.qlm = null;
    com.tencent.mm.hellhoundlib.a.aeC();
    com.tencent.mm.hellhoundlib.a.b(this.qll, this.qlq);
    this.qlo = null;
    if (this.qln != null)
    {
      d locald = (d)this.qln.get();
      if (locald != null)
      {
        locald.b(this.myJ);
        this.qln.clear();
        this.qln = null;
      }
    }
    AppMethodBeat.o(195228);
  }
  
  public final void cjx() {}
  
  public final void cjy()
  {
    AppMethodBeat.i(195232);
    if (this.qln != null)
    {
      d locald = (d)this.qln.get();
      if (locald != null)
      {
        this.qlp.qls = false;
        locald.getRecyclerView().post(this.qlp);
      }
    }
    AppMethodBeat.o(195232);
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(195230);
    Object localObject1 = r(paramRecyclerView);
    if (localObject1 == null)
    {
      AppMethodBeat.o(195230);
      return;
    }
    int i = ((LinearLayoutManager)localObject1).jW();
    int j = ((LinearLayoutManager)localObject1).jY();
    ((LinearLayoutManager)localObject1).getItemCount();
    int k = Math.min(j - i + 1, paramRecyclerView.getChildCount());
    Object localObject2;
    if (this.qln != null)
    {
      localObject2 = (d)this.qln.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof d))
      {
        localObject1 = (d)localObject2;
        this.qln = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          i = Math.max(i - ((d)localObject1).JCb.size(), 0);
          j = Math.max(j - ((d)localObject1).JCb.size(), 0);
          ((d)localObject1).b(this.myJ);
          ((d)localObject1).a(this.myJ);
        }
        for (;;)
        {
          j = Math.max(Math.min(j - i + 1, k), 0);
          if (this.qlm != null) {
            this.qlm.a(paramRecyclerView, i, j, paramInt);
          }
          AppMethodBeat.o(195230);
          return;
        }
      }
    }
  }
  
  final class a
    implements Runnable
  {
    boolean qls = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(195225);
      if (a.this.qlo != null) {
        a.this.qlo.kH(this.qls);
      }
      AppMethodBeat.o(195225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */