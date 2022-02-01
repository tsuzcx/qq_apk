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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.e;
import d.f;
import d.g.b.u;
import d.g.b.w;
import d.v;
import java.util.HashMap;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "lastPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "tabType", "getTabType", "()I", "tabType$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderStreamPartialExposeUIC
  extends UIComponent
  implements com.tencent.mm.ak.g
{
  private static final HashMap<Integer, Long> seT;
  public static final a seU;
  private final f rZE;
  private final f sdw;
  private int seS;
  
  static
  {
    AppMethodBeat.i(204614);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderStreamPartialExposeUIC.class), "recyclerView", "getRecyclerView()Landroid/support/v7/widget/RecyclerView;")), (d.l.k)w.a(new u(w.bn(FinderStreamPartialExposeUIC.class), "tabType", "getTabType()I")) };
    seU = new a((byte)0);
    seT = new HashMap();
    AppMethodBeat.o(204614);
  }
  
  public FinderStreamPartialExposeUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(204621);
    this.rZE = d.g.K((d.g.a.a)new c(this));
    this.sdw = d.g.K((d.g.a.a)new d(this));
    this.seS = -1;
    AppMethodBeat.o(204621);
  }
  
  private final int cvi()
  {
    AppMethodBeat.i(204616);
    int i = ((Number)this.sdw.getValue()).intValue();
    AppMethodBeat.o(204616);
    return i;
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(204615);
    RecyclerView localRecyclerView = (RecyclerView)this.rZE.getValue();
    AppMethodBeat.o(204615);
    return localRecyclerView;
  }
  
  public final void Z(Bundle paramBundle)
  {
    AppMethodBeat.i(204619);
    super.Z(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.IrY;
    paramBundle = getRecyclerView().getContext();
    if (paramBundle == null)
    {
      paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(204619);
      throw paramBundle;
    }
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)paramBundle).get(FinderReporterUIC.class)).Fi(cvi());
    if (paramBundle != null) {
      paramBundle.a((d)new b(this));
    }
    ((Map)seT).put(Integer.valueOf(cvi()), Long.valueOf(0L));
    AppMethodBeat.o(204619);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(204617);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(3901, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(204617);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(204618);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(3901, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(204618);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(204620);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn != null))
    {
      paramString = paramn.getReqResp();
      if (paramString != null)
      {
        paramString.getReqObj();
        AppMethodBeat.o(204620);
        return;
      }
    }
    AppMethodBeat.o(204620);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$Companion;", "", "()V", "TAG", "", "partialExposeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "takePartialExposeObject", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static long Fk(int paramInt)
    {
      AppMethodBeat.i(204609);
      Long localLong = (Long)FinderStreamPartialExposeUIC.cGg().remove(Integer.valueOf(paramInt));
      if (localLong != null)
      {
        long l = localLong.longValue();
        AppMethodBeat.o(204609);
        return l;
      }
      AppMethodBeat.o(204609);
      return 0L;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class b
    extends d
  {
    public final void a(b paramb)
    {
      AppMethodBeat.i(204610);
      d.g.b.k.h(paramb, "ev");
      if ((paramb instanceof h))
      {
        Object localObject = FinderStreamPartialExposeUIC.a(this.seV).getLayoutManager();
        if ((localObject instanceof LinearLayoutManager))
        {
          int i = ((LinearLayoutManager)localObject).jY();
          if (i > FinderStreamPartialExposeUIC.b(this.seV))
          {
            localObject = FinderStreamPartialExposeUIC.a(this.seV).ci(i);
            if ((localObject instanceof e))
            {
              localObject = ((e)localObject).fzs();
              if ((localObject instanceof BaseFinderFeed))
              {
                l = ((BaseFinderFeed)localObject).feedObject.getId();
                if (((h)paramb).rdL != l)
                {
                  ((Map)FinderStreamPartialExposeUIC.cGg()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.seV)), Long.valueOf(l));
                  ac.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.seV) + " lastId=" + l + ' ' + ((h)paramb).rdL + " position=" + i);
                  FinderStreamPartialExposeUIC.a(this.seV, i);
                }
              }
            }
          }
        }
        localObject = (Long)FinderStreamPartialExposeUIC.cGg().get(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.seV)));
        long l = ((h)paramb).rdL;
        if (localObject == null)
        {
          AppMethodBeat.o(204610);
          return;
        }
        if (((Long)localObject).longValue() == l)
        {
          ((Map)FinderStreamPartialExposeUIC.cGg()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.seV)), Long.valueOf(0L));
          ac.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.seV) + " reset");
        }
      }
      AppMethodBeat.o(204610);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(204611);
      d.g.b.k.h(paramc, "dispatcher");
      d.g.b.k.h(paramb, "event");
      boolean bool = paramb instanceof h;
      AppMethodBeat.o(204611);
      return bool;
    }
    
    public final boolean csW()
    {
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<RecyclerView>
  {
    c(FinderStreamPartialExposeUIC paramFinderStreamPartialExposeUIC)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderStreamPartialExposeUIC
 * JD-Core Version:    0.7.0.1
 */