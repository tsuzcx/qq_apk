package com.tencent.mm.plugin.expt.hellhound.ext.b.a;

import android.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.plugin.expt.hellhound.ext.a.f;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements e
{
  private List<Pair<String, String>> zEJ;
  private f zEK;
  WeakReference<i> zEL;
  p zEM;
  final a zEN;
  private final RecyclerView.c zEO;
  private final b zEP;
  
  public a()
  {
    AppMethodBeat.i(300363);
    this.zEL = null;
    this.zEN = new a((byte)0);
    this.zEO = new a.1(this);
    this.zEP = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(300512);
        if ((paramAnonymousString1.equals("androidx/recyclerview/widget/RecyclerView")) || (paramAnonymousString1.startsWith("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI")))
        {
          if (a.this.zEM == null)
          {
            AppMethodBeat.o(300512);
            return;
          }
          if ((paramAnonymousString3.equals("smoothScrollToPosition")) && ("(I)V".equals(paramAnonymousString4)))
          {
            if (a.this.zEL != null)
            {
              paramAnonymousString1 = (i)a.this.zEL.get();
              if (paramAnonymousString1 != null)
              {
                a.this.zEN.zER = true;
                paramAnonymousString1.getRecyclerView().post(a.this.zEN);
              }
            }
            AppMethodBeat.o(300512);
            return;
          }
          if ((paramAnonymousString3.equals("scrollToPosition")) && ("(I)V".equals(paramAnonymousString4)) && (a.this.zEL != null))
          {
            paramAnonymousString1 = (i)a.this.zEL.get();
            if (paramAnonymousString1 != null)
            {
              a.this.zEN.zER = true;
              paramAnonymousString1.getRecyclerView().post(a.this.zEN);
            }
          }
        }
        AppMethodBeat.o(300512);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject) {}
    };
    AppMethodBeat.o(300363);
  }
  
  private static LinearLayoutManager n(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(300369);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (!(paramRecyclerView instanceof LinearLayoutManager))
    {
      AppMethodBeat.o(300369);
      return null;
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    AppMethodBeat.o(300369);
    return paramRecyclerView;
  }
  
  public final void a(f paramf, p paramp)
  {
    AppMethodBeat.i(300384);
    k.zHQ.a(this);
    this.zEJ = new ArrayList();
    this.zEJ.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.zEJ.add(Pair.create("scrollToPosition", "(I)V"));
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.a(this.zEJ, this.zEP);
    this.zEK = paramf;
    this.zEM = paramp;
    AppMethodBeat.o(300384);
  }
  
  public final void a(m.a parama)
  {
    AppMethodBeat.i(300430);
    if (parama == null)
    {
      AppMethodBeat.o(300430);
      return;
    }
    List localList = parama.incrementList;
    if ((localList == null) || (localList.isEmpty()))
    {
      Log.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: incrementList is NULL");
      AppMethodBeat.o(300430);
      return;
    }
    Log.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: %s, %d", new Object[] { Integer.valueOf(parama.pullType), Integer.valueOf(localList.size()) });
    if (this.zEL != null)
    {
      parama = (i)this.zEL.get();
      if (parama != null)
      {
        this.zEN.zER = false;
        parama.getRecyclerView().post(this.zEN);
      }
    }
    AppMethodBeat.o(300430);
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(300411);
    Object localObject1 = n(paramRecyclerView);
    if (localObject1 == null)
    {
      AppMethodBeat.o(300411);
      return;
    }
    int i = ((LinearLayoutManager)localObject1).Ju();
    int j = ((LinearLayoutManager)localObject1).Jw();
    ((LinearLayoutManager)localObject1).getItemCount();
    int k = Math.min(j - i + 1, paramRecyclerView.getChildCount());
    Object localObject2;
    if (this.zEL != null)
    {
      localObject2 = (i)this.zEL.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof i))
      {
        localObject1 = (i)localObject2;
        this.zEL = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          i = Math.max(i - ((i)localObject1).agOb.size(), 0);
          j = Math.max(j - ((i)localObject1).agOb.size(), 0);
          ((i)localObject1).b(this.zEO);
          ((i)localObject1).a(this.zEO);
        }
        for (;;)
        {
          j = Math.max(Math.min(j - i + 1, k), 0);
          if (this.zEK != null) {
            this.zEK.a(paramRecyclerView, i, j, paramInt);
          }
          AppMethodBeat.o(300411);
          return;
        }
      }
    }
  }
  
  public final void dKe() {}
  
  public final void dKf()
  {
    AppMethodBeat.i(300435);
    if (this.zEL != null)
    {
      i locali = (i)this.zEL.get();
      if (locali != null)
      {
        this.zEN.zER = false;
        locali.getRecyclerView().post(this.zEN);
      }
    }
    AppMethodBeat.o(300435);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(300402);
    if (n(paramRecyclerView) == null)
    {
      AppMethodBeat.o(300402);
      return;
    }
    Object localObject2;
    if (this.zEL != null)
    {
      localObject2 = (i)this.zEL.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof i))
      {
        localObject1 = (i)localObject2;
        this.zEL = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((i)localObject1).b(this.zEO);
          ((i)localObject1).a(this.zEO);
        }
        if (this.zEK != null) {
          this.zEK.k(paramRecyclerView, paramInt);
        }
        AppMethodBeat.o(300402);
        return;
      }
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(300395);
    k.zHQ.b(this);
    this.zEK = null;
    com.tencent.mm.hellhoundlib.a.aYh();
    com.tencent.mm.hellhoundlib.a.b(this.zEJ, this.zEP);
    this.zEM = null;
    if (this.zEL != null)
    {
      i locali = (i)this.zEL.get();
      if (locali != null)
      {
        locali.b(this.zEO);
        this.zEL.clear();
        this.zEL = null;
      }
    }
    AppMethodBeat.o(300395);
  }
  
  final class a
    implements Runnable
  {
    boolean zER = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(300503);
      if (a.this.zEM != null) {
        a.this.zEM.oP(this.zER);
      }
      AppMethodBeat.o(300503);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.a.a
 * JD-Core Version:    0.7.0.1
 */