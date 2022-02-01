package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.event.base.h;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "lastPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "tabType", "getTabType", "()I", "tabType$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderStreamPartialExposeUIC
  extends UIComponent
  implements com.tencent.mm.ak.f
{
  private static final HashMap<Integer, Long> tnJ;
  public static final FinderStreamPartialExposeUIC.a tnK;
  private final d.f tie;
  private final d.f tlN;
  private int tnI;
  
  static
  {
    AppMethodBeat.i(206299);
    tnK = new FinderStreamPartialExposeUIC.a((byte)0);
    tnJ = new HashMap();
    AppMethodBeat.o(206299);
  }
  
  public FinderStreamPartialExposeUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(206298);
    this.tie = d.g.O((d.g.a.a)new c(this));
    this.tlN = d.g.O((d.g.a.a)new d(this));
    this.tnI = -1;
    AppMethodBeat.o(206298);
  }
  
  private final int cDl()
  {
    AppMethodBeat.i(206293);
    int i = ((Number)this.tlN.getValue()).intValue();
    AppMethodBeat.o(206293);
    return i;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(206292);
    RecyclerView localRecyclerView = (RecyclerView)this.tie.getValue();
    AppMethodBeat.o(206292);
    return localRecyclerView;
  }
  
  public final void ad(Bundle paramBundle)
  {
    AppMethodBeat.i(206296);
    super.ad(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.KEX;
    paramBundle = getRecyclerView().getContext();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(206296);
      throw paramBundle;
    }
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramBundle).get(FinderReporterUIC.class)).GV(cDl());
    if (paramBundle != null) {
      paramBundle.a((d)new b(this));
    }
    ((Map)tnJ).put(Integer.valueOf(cDl()), Long.valueOf(0L));
    AppMethodBeat.o(206296);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206294);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.ajj().a(3901, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(206294);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206295);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(3901, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(206295);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(206297);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn != null))
    {
      paramString = paramn.getReqResp();
      if (paramString != null)
      {
        paramString.getReqObj();
        AppMethodBeat.o(206297);
        return;
      }
    }
    AppMethodBeat.o(206297);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class b
    extends d
  {
    public final void a(b paramb)
    {
      AppMethodBeat.i(206288);
      p.h(paramb, "ev");
      if ((paramb instanceof h))
      {
        Object localObject = FinderStreamPartialExposeUIC.a(this.tnL).getLayoutManager();
        if ((localObject instanceof LinearLayoutManager))
        {
          int i = ((LinearLayoutManager)localObject).ko();
          if (i > FinderStreamPartialExposeUIC.b(this.tnL))
          {
            localObject = FinderStreamPartialExposeUIC.a(this.tnL).ci(i);
            if ((localObject instanceof e))
            {
              localObject = ((e)localObject).fUY();
              if ((localObject instanceof BaseFinderFeed))
              {
                l = ((BaseFinderFeed)localObject).feedObject.getId();
                if (((h)paramb).rZL != l)
                {
                  ((Map)FinderStreamPartialExposeUIC.cRe()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.tnL)), Long.valueOf(l));
                  ae.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.tnL) + " lastId=" + l + ' ' + ((h)paramb).rZL + " position=" + i);
                  FinderStreamPartialExposeUIC.a(this.tnL, i);
                }
              }
            }
          }
        }
        localObject = (Long)FinderStreamPartialExposeUIC.cRe().get(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.tnL)));
        long l = ((h)paramb).rZL;
        if (localObject == null)
        {
          AppMethodBeat.o(206288);
          return;
        }
        if (((Long)localObject).longValue() == l)
        {
          ((Map)FinderStreamPartialExposeUIC.cRe()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.tnL)), Long.valueOf(0L));
          ae.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.tnL) + " reset");
        }
      }
      AppMethodBeat.o(206288);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(206289);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      boolean bool = paramb instanceof h;
      AppMethodBeat.o(206289);
      return bool;
    }
    
    public final boolean cAA()
    {
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<RecyclerView>
  {
    c(FinderStreamPartialExposeUIC paramFinderStreamPartialExposeUIC)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC
 * JD-Core Version:    0.7.0.1
 */