package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.u;
import d.g.b.w;
import d.v;
import java.util.HashMap;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "lastPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "tabType", "getTabType", "()I", "tabType$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderStreamPartialExposeUIC
  extends UIComponent
  implements com.tencent.mm.al.g
{
  private static final HashMap<Integer, Long> Ljn;
  public static final a Ljo;
  private final d.f Lga;
  private final d.f LhT;
  private int tZz;
  
  static
  {
    AppMethodBeat.i(200485);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderStreamPartialExposeUIC.class), "recyclerView", "getRecyclerView()Landroid/support/v7/widget/RecyclerView;")), (d.l.k)w.a(new u(w.bk(FinderStreamPartialExposeUIC.class), "tabType", "getTabType()I")) };
    Ljo = new a((byte)0);
    Ljn = new HashMap();
    AppMethodBeat.o(200485);
  }
  
  public FinderStreamPartialExposeUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(200492);
    this.Lga = d.g.E((d.g.a.a)new c(this));
    this.LhT = d.g.E((d.g.a.a)new d(this));
    this.tZz = -1;
    AppMethodBeat.o(200492);
  }
  
  private final int epE()
  {
    AppMethodBeat.i(200487);
    int i = ((Number)this.LhT.getValue()).intValue();
    AppMethodBeat.o(200487);
    return i;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(200486);
    RecyclerView localRecyclerView = (RecyclerView)this.Lga.getValue();
    AppMethodBeat.o(200486);
    return localRecyclerView;
  }
  
  public final void ba(Bundle paramBundle)
  {
    AppMethodBeat.i(200490);
    super.ba(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.LCX;
    paramBundle = getRecyclerView().getContext();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(200490);
      throw paramBundle;
    }
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramBundle).get(FinderReporterUIC.class)).ahZ(epE());
    if (paramBundle != null) {
      paramBundle.a((com.tencent.mm.plugin.finder.event.base.f)new b(this));
    }
    ((Map)Ljn).put(Integer.valueOf(epE()), Long.valueOf(0L));
    AppMethodBeat.o(200490);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(200488);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(3901, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(200488);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(200489);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(3901, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(200489);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(200491);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn != null))
    {
      paramString = paramn.getReqResp();
      if (paramString != null)
      {
        paramString.getReqObj();
        AppMethodBeat.o(200491);
        return;
      }
    }
    AppMethodBeat.o(200491);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$Companion;", "", "()V", "TAG", "", "partialExposeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "takePartialExposeObject", "tabType", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class b
    extends com.tencent.mm.plugin.finder.event.base.f
  {
    public final void a(c paramc)
    {
      AppMethodBeat.i(200481);
      d.g.b.k.h(paramc, "ev");
      if ((paramc instanceof i))
      {
        Object localObject = FinderStreamPartialExposeUIC.a(this.Ljp).getLayoutManager();
        if ((localObject instanceof LinearLayoutManager))
        {
          int i = ((LinearLayoutManager)localObject).jQ();
          if (i > FinderStreamPartialExposeUIC.b(this.Ljp))
          {
            localObject = FinderStreamPartialExposeUIC.a(this.Ljp).cj(i);
            if ((localObject instanceof e))
            {
              localObject = ((e)localObject).fjf();
              if ((localObject instanceof BaseFinderFeed))
              {
                l = ((BaseFinderFeed)localObject).feedObject.getId();
                if (((i)paramc).qsk != l)
                {
                  ((Map)FinderStreamPartialExposeUIC.fXx()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.Ljp)), Long.valueOf(l));
                  ad.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.Ljp) + " lastId=" + l + ' ' + ((i)paramc).qsk + " position=" + i);
                  FinderStreamPartialExposeUIC.a(this.Ljp, i);
                }
              }
            }
          }
        }
        localObject = (Long)FinderStreamPartialExposeUIC.fXx().get(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.Ljp)));
        long l = ((i)paramc).qsk;
        if (localObject == null)
        {
          AppMethodBeat.o(200481);
          return;
        }
        if (((Long)localObject).longValue() == l)
        {
          ((Map)FinderStreamPartialExposeUIC.fXx()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.Ljp)), Long.valueOf(0L));
          ad.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.Ljp) + " reset");
        }
      }
      AppMethodBeat.o(200481);
    }
    
    public final boolean a(d paramd, c paramc)
    {
      AppMethodBeat.i(200482);
      d.g.b.k.h(paramd, "dispatcher");
      d.g.b.k.h(paramc, "event");
      boolean bool = paramc instanceof i;
      AppMethodBeat.o(200482);
      return bool;
    }
    
    public final boolean clc()
    {
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<RecyclerView>
  {
    c(FinderStreamPartialExposeUIC paramFinderStreamPartialExposeUIC)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    d(FinderStreamPartialExposeUIC paramFinderStreamPartialExposeUIC)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC
 * JD-Core Version:    0.7.0.1
 */