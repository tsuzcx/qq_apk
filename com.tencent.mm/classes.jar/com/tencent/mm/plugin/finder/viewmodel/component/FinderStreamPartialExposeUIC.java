package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Map;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "lastPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "tabType", "getTabType", "()I", "tabType$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class FinderStreamPartialExposeUIC
  extends UIComponent
  implements i
{
  private static final HashMap<Integer, Long> wAs;
  public static final a wAt;
  private final f vPc;
  private final f vau;
  private int wAr;
  
  static
  {
    AppMethodBeat.i(255968);
    wAt = new a((byte)0);
    wAs = new HashMap();
    AppMethodBeat.o(255968);
  }
  
  public FinderStreamPartialExposeUIC(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(255967);
    this.vau = kotlin.g.ah((kotlin.g.a.a)new c(this));
    this.vPc = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.wAr = -1;
    AppMethodBeat.o(255967);
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(255961);
    RecyclerView localRecyclerView = (RecyclerView)this.vau.getValue();
    AppMethodBeat.o(255961);
    return localRecyclerView;
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(255962);
    int i = ((Number)this.vPc.getValue()).intValue();
    AppMethodBeat.o(255962);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(255963);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.azz().a(3901, (i)this);
    AppMethodBeat.o(255963);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(255965);
    super.onCreateAfter(paramBundle);
    paramBundle = com.tencent.mm.ui.component.a.PRN;
    paramBundle = getRecyclerView().getContext();
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(255965);
      throw paramBundle;
    }
    paramBundle = ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)paramBundle).get(FinderReporterUIC.class)).MF(getTabType());
    if (paramBundle != null) {
      paramBundle.a((d)new b(this));
    }
    ((Map)wAs).put(Integer.valueOf(getTabType()), Long.valueOf(0L));
    AppMethodBeat.o(255965);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(255964);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(3901, (i)this);
    AppMethodBeat.o(255964);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(255966);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq != null))
    {
      paramString = paramq.getReqResp();
      if (paramString != null)
      {
        paramString.getReqObj();
        AppMethodBeat.o(255966);
        return;
      }
    }
    AppMethodBeat.o(255966);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$Companion;", "", "()V", "TAG", "", "partialExposeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "takePartialExposeObject", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static long MH(int paramInt)
    {
      AppMethodBeat.i(255956);
      Long localLong = (Long)FinderStreamPartialExposeUIC.dIJ().remove(Integer.valueOf(paramInt));
      if (localLong != null)
      {
        long l = localLong.longValue();
        AppMethodBeat.o(255956);
        return l;
      }
      AppMethodBeat.o(255956);
      return 0L;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class b
    extends d
  {
    public final void a(b paramb)
    {
      AppMethodBeat.i(255957);
      p.h(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        Object localObject = FinderStreamPartialExposeUIC.a(this.wAu).getLayoutManager();
        if ((localObject instanceof LinearLayoutManager))
        {
          int i = ((LinearLayoutManager)localObject).ku();
          if (i > FinderStreamPartialExposeUIC.b(this.wAu))
          {
            localObject = FinderStreamPartialExposeUIC.a(this.wAu).ch(i);
            if ((localObject instanceof com.tencent.mm.view.recyclerview.h))
            {
              localObject = ((com.tencent.mm.view.recyclerview.h)localObject).hgv();
              if ((localObject instanceof BaseFinderFeed))
              {
                l = ((BaseFinderFeed)localObject).feedObject.getId();
                if (((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC != l)
                {
                  ((Map)FinderStreamPartialExposeUIC.dIJ()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.wAu)), Long.valueOf(l));
                  Log.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.wAu) + " lastId=" + l + ' ' + ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC + " position=" + i);
                  FinderStreamPartialExposeUIC.a(this.wAu, i);
                }
              }
            }
          }
        }
        localObject = (Long)FinderStreamPartialExposeUIC.dIJ().get(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.wAu)));
        long l = ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIC;
        if (localObject == null)
        {
          AppMethodBeat.o(255957);
          return;
        }
        if (((Long)localObject).longValue() == l)
        {
          ((Map)FinderStreamPartialExposeUIC.dIJ()).put(Integer.valueOf(FinderStreamPartialExposeUIC.c(this.wAu)), Long.valueOf(0L));
          Log.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + FinderStreamPartialExposeUIC.c(this.wAu) + " reset");
        }
      }
      AppMethodBeat.o(255957);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(255958);
      p.h(paramc, "dispatcher");
      p.h(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.base.h;
      AppMethodBeat.o(255958);
      return bool;
    }
    
    public final boolean cZD()
    {
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<RecyclerView>
  {
    c(FinderStreamPartialExposeUIC paramFinderStreamPartialExposeUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
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