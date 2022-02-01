package com.tencent.mm.plugin.finder.event.base;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.utils.i;
import com.tencent.mm.plugin.finder.utils.i.e;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/event/base/DataChangeEventSubscriber;", "Lcom/tencent/mm/plugin/finder/event/base/EventSubscriber;", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "(Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;Landroid/support/v7/widget/RecyclerView;)V", "getBehavior", "publish", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
public final class b
  extends g<RecyclerView.c>
{
  private final RecyclerView fPw;
  
  public b(d paramd, RecyclerView paramRecyclerView)
  {
    super(paramd);
    AppMethodBeat.i(178139);
    this.fPw = paramRecyclerView;
    AppMethodBeat.o(178139);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(178138);
    k.h(paramc, "event");
    if ((paramc instanceof a))
    {
      if ((this.fPw.getLayoutManager() instanceof LinearLayoutManager))
      {
        Object localObject1 = (a)paramc;
        Object localObject2 = this.fPw.getLayoutManager();
        if (localObject2 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(178138);
          throw paramc;
        }
        ((a)localObject1).qsi = ((LinearLayoutManager)localObject2).jO();
        localObject1 = (a)paramc;
        localObject2 = this.fPw.getLayoutManager();
        if (localObject2 == null)
        {
          paramc = new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
          AppMethodBeat.o(178138);
          throw paramc;
        }
        ((a)localObject1).qsj = ((LinearLayoutManager)localObject2).jQ();
        localObject1 = i.qTa;
        localObject1 = i.j(this.fPw, ((a)paramc).qsi, ((a)paramc).qsj);
        ((a)paramc).qsk = ((i.e)localObject1).feedId;
        localObject2 = (a)paramc;
        String str = ((i.e)localObject1).mediaId;
        k.h(str, "<set-?>");
        ((a)localObject2).qsm = str;
        ((a)paramc).qsl = ((i.e)localObject1).qHv;
      }
      super.b(paramc);
    }
    AppMethodBeat.o(178138);
  }
  
  public final RecyclerView.c cle()
  {
    AppMethodBeat.i(165549);
    RecyclerView.c localc = (RecyclerView.c)new a(this);
    AppMethodBeat.o(165549);
    return localc;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/event/base/DataChangeEventSubscriber$getBehavior$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "plugin-finder_release"})
  public static final class a
    extends RecyclerView.c
  {
    public final void as(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165543);
      super.as(paramInt1, paramInt2);
      a locala = new a(1);
      this.qso.b((c)locala);
      AppMethodBeat.o(165543);
    }
    
    public final void at(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165545);
      super.at(paramInt1, paramInt2);
      a locala = new a(5);
      this.qso.b((c)locala);
      AppMethodBeat.o(165545);
    }
    
    public final void au(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(165546);
      super.au(paramInt1, paramInt2);
      a locala = new a(2);
      this.qso.b((c)locala);
      AppMethodBeat.o(165546);
    }
    
    public final void f(int paramInt1, int paramInt2, Object paramObject)
    {
      AppMethodBeat.i(165544);
      as(paramInt1, paramInt2);
      a locala = new a(1);
      locala.ahc = paramObject;
      this.qso.b((c)locala);
      AppMethodBeat.o(165544);
    }
    
    public final void l(int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(165547);
      super.l(paramInt1, paramInt2, paramInt3);
      a locala = new a(1);
      this.qso.b((c)locala);
      AppMethodBeat.o(165547);
    }
    
    public final void onChanged()
    {
      AppMethodBeat.i(165542);
      super.onChanged();
      a locala = new a(1);
      this.qso.b((c)locala);
      AppMethodBeat.o(165542);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.event.base.b
 * JD-Core Version:    0.7.0.1
 */