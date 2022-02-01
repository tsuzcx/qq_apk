package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "lastPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "tabType", "getTabType", "()I", "tabType$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderStreamPartialExposeUIC
  extends UIComponent
  implements com.tencent.mm.al.f
{
  private static final HashMap<Integer, Long> tcP;
  public static final a tcQ;
  private final d.f sWQ;
  private final d.f taY;
  private int tcO;
  
  static
  {
    AppMethodBeat.i(205670);
    tcQ = new a((byte)0);
    tcP = new HashMap();
    AppMethodBeat.o(205670);
  }
  
  public FinderStreamPartialExposeUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(205669);
    this.sWQ = d.g.O((d.g.a.a)new c(this));
    this.taY = d.g.O((d.g.a.a)new d(this));
    this.tcO = -1;
    AppMethodBeat.o(205669);
  }
  
  private final int cBz()
  {
    AppMethodBeat.i(205664);
    int i = ((Number)this.taY.getValue()).intValue();
    AppMethodBeat.o(205664);
    return i;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(205663);
    RecyclerView localRecyclerView = (RecyclerView)this.sWQ.getValue();
    AppMethodBeat.o(205663);
    return localRecyclerView;
  }
  
  public final void ac(Bundle paramBundle)
  {
    AppMethodBeat.i(205667);
    super.ac(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.KiD;
    paramBundle = getRecyclerView().getContext();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(205667);
      throw paramBundle;
    }
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramBundle).get(FinderReporterUIC.class)).Gy(cBz());
    if (paramBundle != null) {
      paramBundle.a((d)new b(this));
    }
    ((Map)tcP).put(Integer.valueOf(cBz()), Long.valueOf(0L));
    AppMethodBeat.o(205667);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205665);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aiU().a(3901, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(205665);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205666);
    super.onDestroy();
    com.tencent.mm.kernel.g.aiU().b(3901, (com.tencent.mm.al.f)this);
    AppMethodBeat.o(205666);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(205668);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn != null))
    {
      paramString = paramn.getReqResp();
      if (paramString != null)
      {
        paramString.getReqObj();
        AppMethodBeat.o(205668);
        return;
      }
    }
    AppMethodBeat.o(205668);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$Companion;", "", "()V", "TAG", "", "partialExposeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "takePartialExposeObject", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static long GA(int paramInt)
    {
      AppMethodBeat.i(205658);
      Long localLong = (Long)FinderStreamPartialExposeUIC.cOz().remove(Integer.valueOf(paramInt));
      if (localLong != null)
      {
        long l = localLong.longValue();
        AppMethodBeat.o(205658);
        return l;
      }
      AppMethodBeat.o(205658);
      return 0L;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class b
    extends d
  {
    public final void a(b paramb)
    {
      AppMethodBeat.i(205659);
      p.h(paramb, "ev");
      if ((paramb instanceof h))
      {
        Object localObject = FinderStreamPartialExposeUIC.a(this.tcR).getLayoutManager();
        if ((localObject instanceof LinearLayoutManager))
        {
          int i = ((LinearLayoutManager)localObject).ko();
          if (i > FinderStreamPartialExposeUIC.b(this.tcR))
          {
            localObject = FinderStreamPartialExposeUIC.a(this.tcR).ci(i);
            if ((localObject instanceof e))
            {
              localObject = ((e)localObject).fQC();
              if ((localObject instanceof BaseFinderFeed))
              {
                l = ((BaseFinderFeed)localObject).feedObject.getId();
                if (((h)paramb).rRj != l)
                {
                  ((Map)FinderStreamPartialExposeUIC.cOz()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.tcR)), Long.valueOf(l));
                  ad.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.tcR) + " lastId=" + l + ' ' + ((h)paramb).rRj + " position=" + i);
                  FinderStreamPartialExposeUIC.a(this.tcR, i);
                }
              }
            }
          }
        }
        localObject = (Long)FinderStreamPartialExposeUIC.cOz().get(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.tcR)));
        long l = ((h)paramb).rRj;
        if (localObject == null)
        {
          AppMethodBeat.o(205659);
          return;
        }
        if (((Long)localObject).longValue() == l)
        {
          ((Map)FinderStreamPartialExposeUIC.cOz()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.tcR)), Long.valueOf(0L));
          ad.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.tcR) + " reset");
        }
      }
      AppMethodBeat.o(205659);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(205660);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      boolean bool = paramb instanceof h;
      AppMethodBeat.o(205660);
      return bool;
    }
    
    public final boolean cyW()
    {
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<RecyclerView>
  {
    c(FinderStreamPartialExposeUIC paramFinderStreamPartialExposeUIC)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<Integer>
  {
    d(FinderStreamPartialExposeUIC paramFinderStreamPartialExposeUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC
 * JD-Core Version:    0.7.0.1
 */