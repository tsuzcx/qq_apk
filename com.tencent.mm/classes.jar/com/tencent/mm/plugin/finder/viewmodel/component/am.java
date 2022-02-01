package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.f;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "lastPosition", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerView$delegate", "Lkotlin/Lazy;", "tabType", "getTabType", "()I", "tabType$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-finder_release"})
public final class am
  extends UIComponent
  implements com.tencent.mm.an.i
{
  private static final HashMap<Integer, Long> BoD;
  public static final a BoE;
  private int BoC;
  private final f zQD;
  private final f zVl;
  
  static
  {
    AppMethodBeat.i(251146);
    BoE = new a((byte)0);
    BoD = new HashMap();
    AppMethodBeat.o(251146);
  }
  
  public am(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(251144);
    this.zQD = kotlin.g.ar((a)new c(this));
    this.zVl = kotlin.g.ar((a)new d(this));
    this.BoC = -1;
    AppMethodBeat.o(251144);
  }
  
  private final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(251134);
    RecyclerView localRecyclerView = (RecyclerView)this.zQD.getValue();
    AppMethodBeat.o(251134);
    return localRecyclerView;
  }
  
  private final int getTabType()
  {
    AppMethodBeat.i(251138);
    int i = ((Number)this.zVl.getValue()).intValue();
    AppMethodBeat.o(251138);
    return i;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251140);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aGY().a(3901, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(251140);
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(251142);
    super.onCreateAfter(paramBundle);
    paramBundle = com.tencent.mm.ui.component.g.Xox;
    paramBundle = getRecyclerView().getContext();
    if (paramBundle == null)
    {
      paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(251142);
      throw paramBundle;
    }
    paramBundle = ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)paramBundle).i(aj.class)).RZ(getTabType());
    if (paramBundle != null) {
      paramBundle.a((d)new b(this));
    }
    ((Map)BoD).put(Integer.valueOf(getTabType()), Long.valueOf(0L));
    AppMethodBeat.o(251142);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(251141);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(3901, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(251141);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(251143);
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq != null))
    {
      paramString = paramq.getReqResp();
      if (paramString != null)
      {
        paramString.getReqObj();
        AppMethodBeat.o(251143);
        return;
      }
    }
    AppMethodBeat.o(251143);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$Companion;", "", "()V", "TAG", "", "partialExposeMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "takePartialExposeObject", "tabType", "plugin-finder_release"})
  public static final class a
  {
    public static long Sb(int paramInt)
    {
      AppMethodBeat.i(271146);
      Long localLong = (Long)am.elr().remove(Integer.valueOf(paramInt));
      if (localLong != null)
      {
        long l = localLong.longValue();
        AppMethodBeat.o(271146);
        return l;
      }
      AppMethodBeat.o(271146);
      return 0L;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/viewmodel/component/FinderStreamPartialExposeUIC$onCreateAfter$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isAsync", "", "isCareEvent", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
  public static final class b
    extends d
  {
    public final void a(b paramb)
    {
      AppMethodBeat.i(285109);
      p.k(paramb, "ev");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        Object localObject = am.a(this.BoF).getLayoutManager();
        if ((localObject instanceof LinearLayoutManager))
        {
          int i = ((LinearLayoutManager)localObject).kL();
          if (i > am.b(this.BoF))
          {
            localObject = am.a(this.BoF).cK(i);
            if ((localObject instanceof com.tencent.mm.view.recyclerview.i))
            {
              localObject = ((com.tencent.mm.view.recyclerview.i)localObject).ihX();
              if ((localObject instanceof BaseFinderFeed))
              {
                l = ((BaseFinderFeed)localObject).feedObject.getId();
                if (((com.tencent.mm.plugin.finder.event.base.h)paramb).xrl != l)
                {
                  ((Map)am.elr()).put(Integer.valueOf(am.c(this.BoF)), Long.valueOf(l));
                  Log.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + am.c(this.BoF) + " lastId=" + l + ' ' + ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrl + " position=" + i);
                  am.a(this.BoF, i);
                }
              }
            }
          }
        }
        localObject = (Long)am.elr().get(Integer.valueOf(am.c(this.BoF)));
        long l = ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrl;
        if (localObject == null)
        {
          AppMethodBeat.o(285109);
          return;
        }
        if (((Long)localObject).longValue() == l)
        {
          ((Map)am.elr()).put(Integer.valueOf(am.c(this.BoF)), Long.valueOf(0L));
          Log.i("Finder.StreamPartialExposeUIC", "[onScrollStateChanged] tabType=" + am.c(this.BoF) + " reset");
        }
      }
      AppMethodBeat.o(285109);
    }
    
    public final boolean a(c paramc, b paramb)
    {
      AppMethodBeat.i(285111);
      p.k(paramc, "dispatcher");
      p.k(paramb, "event");
      boolean bool = paramb instanceof com.tencent.mm.plugin.finder.event.base.h;
      AppMethodBeat.o(285111);
      return bool;
    }
    
    public final boolean dpw()
    {
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements a<RecyclerView>
  {
    c(am paramam)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements a<Integer>
  {
    d(am paramam)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.am
 * JD-Core Version:    0.7.0.1
 */