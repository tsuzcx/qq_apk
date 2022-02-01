package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.view.recyclerview.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements com.tencent.mm.plugin.expt.hellhound.a.b.b.e
{
  private final RecyclerView.c mZr;
  private List<Pair<String, String>> qUi;
  private com.tencent.mm.plugin.expt.hellhound.a.a.e qUj;
  WeakReference<d> qUk;
  p qUl;
  final a qUm;
  private final b qUn;
  
  public a()
  {
    AppMethodBeat.i(210373);
    this.qUk = null;
    this.qUm = new a((byte)0);
    this.mZr = new a.1(this);
    this.qUn = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject)
      {
        AppMethodBeat.i(210371);
        if ((paramAnonymousString1.equals("android/support/v7/widget/RecyclerView")) || (paramAnonymousString1.startsWith("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI")))
        {
          if (a.this.qUl == null)
          {
            AppMethodBeat.o(210371);
            return;
          }
          if ((paramAnonymousString2.equals("smoothScrollToPosition")) && ("(I)V".equals(paramAnonymousString3)))
          {
            if (a.this.qUk != null)
            {
              paramAnonymousString1 = (d)a.this.qUk.get();
              if (paramAnonymousString1 != null)
              {
                a.this.qUm.qUp = true;
                paramAnonymousString1.getRecyclerView().post(a.this.qUm);
              }
            }
            AppMethodBeat.o(210371);
            return;
          }
          if ((paramAnonymousString2.equals("scrollToPosition")) && ("(I)V".equals(paramAnonymousString3)) && (a.this.qUk != null))
          {
            paramAnonymousString1 = (d)a.this.qUk.get();
            if (paramAnonymousString1 != null)
            {
              a.this.qUm.qUp = true;
              paramAnonymousString1.getRecyclerView().post(a.this.qUm);
            }
          }
        }
        AppMethodBeat.o(210371);
      }
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject) {}
    };
    AppMethodBeat.o(210373);
  }
  
  private static LinearLayoutManager r(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(210380);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (!(paramRecyclerView instanceof LinearLayoutManager))
    {
      AppMethodBeat.o(210380);
      return null;
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    AppMethodBeat.o(210380);
    return paramRecyclerView;
  }
  
  public final void a(com.tencent.mm.plugin.expt.hellhound.a.a.e parame, p paramp)
  {
    AppMethodBeat.i(210374);
    j.qWF.a(this);
    this.qUi = new ArrayList();
    this.qUi.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.qUi.add(Pair.create("scrollToPosition", "(I)V"));
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.a(this.qUi, this.qUn);
    this.qUj = parame;
    this.qUl = paramp;
    AppMethodBeat.o(210374);
  }
  
  public final void a(l.a parama)
  {
    AppMethodBeat.i(210378);
    if (parama == null)
    {
      AppMethodBeat.o(210378);
      return;
    }
    List localList = parama.incrementList;
    if ((localList == null) || (localList.isEmpty()))
    {
      ad.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: incrementList is NULL");
      AppMethodBeat.o(210378);
      return;
    }
    ad.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: %s, %d", new Object[] { Integer.valueOf(parama.pullType), Integer.valueOf(localList.size()) });
    if (this.qUk != null)
    {
      parama = (d)this.qUk.get();
      if (parama != null)
      {
        this.qUm.qUp = false;
        parama.getRecyclerView().post(this.qUm);
      }
    }
    AppMethodBeat.o(210378);
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(210376);
    if (r(paramRecyclerView) == null)
    {
      AppMethodBeat.o(210376);
      return;
    }
    Object localObject2;
    if (this.qUk != null)
    {
      localObject2 = (d)this.qUk.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof d))
      {
        localObject1 = (d)localObject2;
        this.qUk = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((d)localObject1).b(this.mZr);
          ((d)localObject1).a(this.mZr);
        }
        if (this.qUj != null) {
          this.qUj.l(paramRecyclerView, paramInt);
        }
        AppMethodBeat.o(210376);
        return;
      }
    }
  }
  
  public final void coC()
  {
    AppMethodBeat.i(210375);
    j.qWF.b(this);
    this.qUj = null;
    com.tencent.mm.hellhoundlib.a.aho();
    com.tencent.mm.hellhoundlib.a.b(this.qUi, this.qUn);
    this.qUl = null;
    if (this.qUk != null)
    {
      d locald = (d)this.qUk.get();
      if (locald != null)
      {
        locald.b(this.mZr);
        this.qUk.clear();
        this.qUk = null;
      }
    }
    AppMethodBeat.o(210375);
  }
  
  public final void coJ() {}
  
  public final void coK()
  {
    AppMethodBeat.i(210379);
    if (this.qUk != null)
    {
      d locald = (d)this.qUk.get();
      if (locald != null)
      {
        this.qUm.qUp = false;
        locald.getRecyclerView().post(this.qUm);
      }
    }
    AppMethodBeat.o(210379);
  }
  
  public final void f(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(210377);
    Object localObject1 = r(paramRecyclerView);
    if (localObject1 == null)
    {
      AppMethodBeat.o(210377);
      return;
    }
    int i = ((LinearLayoutManager)localObject1).km();
    int j = ((LinearLayoutManager)localObject1).ko();
    ((LinearLayoutManager)localObject1).getItemCount();
    int k = Math.min(j - i + 1, paramRecyclerView.getChildCount());
    Object localObject2;
    if (this.qUk != null)
    {
      localObject2 = (d)this.qUk.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof d))
      {
        localObject1 = (d)localObject2;
        this.qUk = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          i = Math.max(i - ((d)localObject1).Lvi.size(), 0);
          j = Math.max(j - ((d)localObject1).Lvi.size(), 0);
          ((d)localObject1).b(this.mZr);
          ((d)localObject1).a(this.mZr);
        }
        for (;;)
        {
          j = Math.max(Math.min(j - i + 1, k), 0);
          if (this.qUj != null) {
            this.qUj.a(paramRecyclerView, i, j, paramInt);
          }
          AppMethodBeat.o(210377);
          return;
        }
      }
    }
  }
  
  final class a
    implements Runnable
  {
    boolean qUp = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(210372);
      if (a.this.qUl != null) {
        a.this.qUl.kZ(this.qUp);
      }
      AppMethodBeat.o(210372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */