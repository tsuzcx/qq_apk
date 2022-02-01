package com.tencent.mm.plugin.expt.hellhound.a.b.a;

import android.util.Pair;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.b;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.e;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.k;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.m.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a
  implements e
{
  private List<Pair<String, String>> wiG;
  private f wiH;
  WeakReference<h> wiI;
  p wiJ;
  final a wiK;
  private final RecyclerView.c wiL;
  private final b wiM;
  
  public a()
  {
    AppMethodBeat.i(253850);
    this.wiI = null;
    this.wiK = new a((byte)0);
    this.wiL = new a.1(this);
    this.wiM = new b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject)
      {
        AppMethodBeat.i(250896);
        if ((paramAnonymousString1.equals("androidx/recyclerview/widget/RecyclerView")) || (paramAnonymousString1.startsWith("com/tencent/mm/plugin/finder/feed/ui/FinderTimelineUI")))
        {
          if (a.this.wiJ == null)
          {
            AppMethodBeat.o(250896);
            return;
          }
          if ((paramAnonymousString2.equals("smoothScrollToPosition")) && ("(I)V".equals(paramAnonymousString3)))
          {
            if (a.this.wiI != null)
            {
              paramAnonymousString1 = (h)a.this.wiI.get();
              if (paramAnonymousString1 != null)
              {
                a.this.wiK.wiO = true;
                paramAnonymousString1.getRecyclerView().post(a.this.wiK);
              }
            }
            AppMethodBeat.o(250896);
            return;
          }
          if ((paramAnonymousString2.equals("scrollToPosition")) && ("(I)V".equals(paramAnonymousString3)) && (a.this.wiI != null))
          {
            paramAnonymousString1 = (h)a.this.wiI.get();
            if (paramAnonymousString1 != null)
            {
              a.this.wiK.wiO = true;
              paramAnonymousString1.getRecyclerView().post(a.this.wiK);
            }
          }
        }
        AppMethodBeat.o(250896);
      }
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject) {}
    };
    AppMethodBeat.o(253850);
  }
  
  private static LinearLayoutManager j(RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(253858);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (!(paramRecyclerView instanceof LinearLayoutManager))
    {
      AppMethodBeat.o(253858);
      return null;
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    AppMethodBeat.o(253858);
    return paramRecyclerView;
  }
  
  public final void a(f paramf, p paramp)
  {
    AppMethodBeat.i(253851);
    k.wlT.a(this);
    this.wiG = new ArrayList();
    this.wiG.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.wiG.add(Pair.create("scrollToPosition", "(I)V"));
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.a(this.wiG, this.wiM);
    this.wiH = paramf;
    this.wiJ = paramp;
    AppMethodBeat.o(253851);
  }
  
  public final void a(m.a parama)
  {
    AppMethodBeat.i(253856);
    if (parama == null)
    {
      AppMethodBeat.o(253856);
      return;
    }
    List localList = parama.incrementList;
    if ((localList == null) || (localList.isEmpty()))
    {
      Log.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: incrementList is NULL");
      AppMethodBeat.o(253856);
      return;
    }
    Log.w("HABBYGE-MALI.FeedFlowCallback", "mRefreshEndListener, onRefreshEnd: %s, %d", new Object[] { Integer.valueOf(parama.pullType), Integer.valueOf(localList.size()) });
    if (this.wiI != null)
    {
      parama = (h)this.wiI.get();
      if (parama != null)
      {
        this.wiK.wiO = false;
        parama.getRecyclerView().post(this.wiK);
      }
    }
    AppMethodBeat.o(253856);
  }
  
  public final void d(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(253854);
    Object localObject1 = j(paramRecyclerView);
    if (localObject1 == null)
    {
      AppMethodBeat.o(253854);
      return;
    }
    int i = ((LinearLayoutManager)localObject1).kJ();
    int j = ((LinearLayoutManager)localObject1).kL();
    ((LinearLayoutManager)localObject1).getItemCount();
    int k = Math.min(j - i + 1, paramRecyclerView.getChildCount());
    Object localObject2;
    if (this.wiI != null)
    {
      localObject2 = (h)this.wiI.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof h))
      {
        localObject1 = (h)localObject2;
        this.wiI = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          i = Math.max(i - ((h)localObject1).YSk.size(), 0);
          j = Math.max(j - ((h)localObject1).YSk.size(), 0);
          ((h)localObject1).b(this.wiL);
          ((h)localObject1).a(this.wiL);
        }
        for (;;)
        {
          j = Math.max(Math.min(j - i + 1, k), 0);
          if (this.wiH != null) {
            this.wiH.a(paramRecyclerView, i, j, paramInt);
          }
          AppMethodBeat.o(253854);
          return;
        }
      }
    }
  }
  
  public final void ddw() {}
  
  public final void ddx()
  {
    AppMethodBeat.i(253857);
    if (this.wiI != null)
    {
      h localh = (h)this.wiI.get();
      if (localh != null)
      {
        this.wiK.wiO = false;
        localh.getRecyclerView().post(this.wiK);
      }
    }
    AppMethodBeat.o(253857);
  }
  
  public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(253853);
    if (j(paramRecyclerView) == null)
    {
      AppMethodBeat.o(253853);
      return;
    }
    Object localObject2;
    if (this.wiI != null)
    {
      localObject2 = (h)this.wiI.get();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      localObject2 = paramRecyclerView.getAdapter();
      if ((localObject2 instanceof h))
      {
        localObject1 = (h)localObject2;
        this.wiI = new WeakReference(localObject1);
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          ((h)localObject1).b(this.wiL);
          ((h)localObject1).a(this.wiL);
        }
        if (this.wiH != null) {
          this.wiH.k(paramRecyclerView, paramInt);
        }
        AppMethodBeat.o(253853);
        return;
      }
    }
  }
  
  public final void stopMonitor()
  {
    AppMethodBeat.i(253852);
    k.wlT.b(this);
    this.wiH = null;
    com.tencent.mm.hellhoundlib.a.aFg();
    com.tencent.mm.hellhoundlib.a.b(this.wiG, this.wiM);
    this.wiJ = null;
    if (this.wiI != null)
    {
      h localh = (h)this.wiI.get();
      if (localh != null)
      {
        localh.b(this.wiL);
        this.wiI.clear();
        this.wiI = null;
      }
    }
    AppMethodBeat.o(253852);
  }
  
  final class a
    implements Runnable
  {
    boolean wiO = false;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(252283);
      if (a.this.wiJ != null) {
        a.this.wiJ.np(this.wiO);
      }
      AppMethodBeat.o(252283);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.a.a
 * JD-Core Version:    0.7.0.1
 */