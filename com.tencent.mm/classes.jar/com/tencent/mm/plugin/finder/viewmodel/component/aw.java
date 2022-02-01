package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "lastPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "tabType", "getTabType", "()I", "tabType$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aw
  extends UIComponent
  implements com.tencent.mm.am.h
{
  public static final a GUC;
  private static final HashMap<Integer, Long> GUD;
  private int BuD;
  private final kotlin.j CNQ;
  private final kotlin.j Fqc;
  
  static
  {
    AppMethodBeat.i(338082);
    GUC = new a((byte)0);
    GUD = new HashMap();
    AppMethodBeat.o(338082);
  }
  
  public aw(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338028);
    this.CNQ = kotlin.k.cm((a)new c(this));
    this.Fqc = kotlin.k.cm((a)new d(this));
    this.BuD = -1;
    AppMethodBeat.o(338028);
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(338035);
    RecyclerView localRecyclerView = (RecyclerView)this.CNQ.getValue();
    AppMethodBeat.o(338035);
    return localRecyclerView;
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(338040);
    int i = ((Number)this.Fqc.getValue()).intValue();
    AppMethodBeat.o(338040);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338091);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3901, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(338091);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(338107);
    super.onCreateAfter(paramBundle);
    paramBundle = com.tencent.mm.ui.component.k.aeZF;
    paramBundle = getRecyclerView().getContext();
    if (paramBundle == null)
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(338107);
      throw paramBundle;
    }
    paramBundle = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)paramBundle).q(as.class)).Vr(getTabType());
    if (paramBundle != null) {
      paramBundle.a((d)new b(this));
    }
    ((Map)GUD).put(Integer.valueOf(getTabType()), Long.valueOf(0L));
    AppMethodBeat.o(338107);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338096);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3901, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(338096);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(338117);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramp != null))
    {
      paramString = paramp.getReqResp();
      if (paramString != null) {
        paramString.getReqObj();
      }
    }
    AppMethodBeat.o(338117);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$Companion;", "", "()V", "TAG", "", "partialExposeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "takePartialExposeObject", "tabType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static long Vt(int paramInt)
    {
      AppMethodBeat.i(338436);
      Long localLong = (Long)aw.foX().remove(Integer.valueOf(paramInt));
      if (localLong == null)
      {
        AppMethodBeat.o(338436);
        return 0L;
      }
      long l = localLong.longValue();
      AppMethodBeat.o(338436);
      return l;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends d
  {
    b(aw paramaw) {}
    
    public final void a(b paramb)
    {
      AppMethodBeat.i(338424);
      kotlin.g.b.s.u(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        Object localObject = aw.a(this.GUE).getLayoutManager();
        if ((localObject instanceof LinearLayoutManager))
        {
          int i = ((LinearLayoutManager)localObject).Jw();
          if (i > aw.b(this.GUE))
          {
            localObject = aw.a(this.GUE).fU(i);
            if ((localObject instanceof com.tencent.mm.view.recyclerview.j))
            {
              localObject = ((com.tencent.mm.view.recyclerview.j)localObject).CSA;
              if ((localObject instanceof BaseFinderFeed))
              {
                l = ((BaseFinderFeed)localObject).feedObject.getId();
                if (((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv != l)
                {
                  ((Map)aw.foX()).put(Integer.valueOf(aw.c(this.GUE)), Long.valueOf(l));
                  Log.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + aw.c(this.GUE) + " lastId=" + l + ' ' + ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv + " position=" + i);
                  aw.a(this.GUE, i);
                }
              }
            }
          }
        }
        localObject = (Long)aw.foX().get(Integer.valueOf(aw.c(this.GUE)));
        long l = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOv;
        if (localObject == null)
        {
          AppMethodBeat.o(338424);
          return;
        }
        if (((Long)localObject).longValue() == l)
        {
          ((Map)aw.foX()).put(Integer.valueOf(aw.c(this.GUE)), Long.valueOf(0L));
          Log.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + aw.c(this.GUE) + " reset");
        }
      }
      AppMethodBeat.o(338424);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(338438);
      kotlin.g.b.s.u(paramc, "dispatcher");
      kotlin.g.b.s.u(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.base.h;
      AppMethodBeat.o(338438);
      return bool;
    }
    
    public final boolean dXA()
    {
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<RecyclerView>
  {
    c(aw paramaw)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<Integer>
  {
    d(aw paramaw)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.aw
 * JD-Core Version:    0.7.0.1
 */