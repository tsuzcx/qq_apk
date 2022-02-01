package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hr;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.convert.d;
import com.tencent.mm.plugin.finder.megavideo.loader.BaseMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "isSelf", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "Companion", "plugin-finder_release"})
public final class d$a
  extends a.a
{
  public static final a zxE;
  private final c zxD;
  
  static
  {
    AppMethodBeat.i(289119);
    zxE = new a((byte)0);
    AppMethodBeat.o(289119);
  }
  
  public d$a(MMActivity paramMMActivity, FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader)
  {
    super(paramMMActivity, (BaseMegaVideoLoader)paramFinderMegaVideoProfileLoader);
    AppMethodBeat.i(289118);
    this.zxD = new c(paramFinderMegaVideoProfileLoader);
    AppMethodBeat.o(289118);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(289114);
    p.k(paramb, "callback");
    super.a(paramb);
    this.zxD.alive();
    AppMethodBeat.o(289114);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(289108);
    this.zxg.requestLoadMore();
    AppMethodBeat.o(289108);
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(289110);
    BaseFeedLoader.requestInit$default(this.zxg, false, 1, null);
    AppMethodBeat.o(289110);
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(289112);
    a.b localb = this.zxf;
    if (localb != null)
    {
      localb.ab((ArrayList)this.zxg.getDataListJustForAdapter());
      AppMethodBeat.o(289112);
      return;
    }
    AppMethodBeat.o(289112);
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(289111);
    f localf = (f)new b(this);
    AppMethodBeat.o(289111);
    return localf;
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(289106);
    Object localObject = this.zxg;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader");
      AppMethodBeat.o(289106);
      throw ((Throwable)localObject);
    }
    boolean bool = p.h(((FinderMegaVideoProfileLoader)localObject).xcW, z.bdh());
    AppMethodBeat.o(289106);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(289117);
    super.onDetach();
    this.zxD.dead();
    AppMethodBeat.o(289117);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(289107);
    this.zxg.requestRefresh();
    AppMethodBeat.o(289107);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(291737);
      e locale = (e)new d(this.zxF);
      AppMethodBeat.o(291737);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hr>
  {
    c(FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements a<x>
    {
      a(d.a.c paramc, long paramLong)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.ui.d.a
 * JD-Core Version:    0.7.0.1
 */