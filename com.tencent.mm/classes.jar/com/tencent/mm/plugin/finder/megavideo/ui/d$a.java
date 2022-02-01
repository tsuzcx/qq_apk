package com.tencent.mm.plugin.finder.megavideo.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hk;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedLoader", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "feedProgressListener", "com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "isSelf", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "onDetach", "refreshRV", "data", "Landroid/content/Intent;", "requestRefresh", "Companion", "plugin-finder_release"})
public final class d$a
  extends a.a
{
  public static final a uLR;
  private final c uLQ;
  
  static
  {
    AppMethodBeat.i(248522);
    uLR = new a((byte)0);
    AppMethodBeat.o(248522);
  }
  
  public d$a(MMActivity paramMMActivity, FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader)
  {
    super(paramMMActivity, (BaseMegaVideoLoader)paramFinderMegaVideoProfileLoader);
    AppMethodBeat.i(248521);
    this.uLQ = new c(paramFinderMegaVideoProfileLoader);
    AppMethodBeat.o(248521);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(248518);
    p.h(paramb, "callback");
    super.a(paramb);
    this.uLQ.alive();
    AppMethodBeat.o(248518);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(248514);
    this.uLF.requestLoadMore();
    AppMethodBeat.o(248514);
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(248517);
    a.b localb = this.uLE;
    if (localb != null)
    {
      localb.ab((ArrayList)this.uLF.getDataListJustForAdapter());
      AppMethodBeat.o(248517);
      return;
    }
    AppMethodBeat.o(248517);
  }
  
  public final f dce()
  {
    AppMethodBeat.i(248516);
    f localf = (f)new b(this);
    AppMethodBeat.o(248516);
    return localf;
  }
  
  public final void dcp()
  {
    AppMethodBeat.i(248515);
    BaseFeedLoader.requestInit$default(this.uLF, false, 1, null);
    AppMethodBeat.o(248515);
  }
  
  public final boolean isSelf()
  {
    AppMethodBeat.i(248512);
    Object localObject = this.uLF;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader");
      AppMethodBeat.o(248512);
      throw ((Throwable)localObject);
    }
    boolean bool = p.j(((FinderMegaVideoProfileLoader)localObject).tvp, z.aUg());
    AppMethodBeat.o(248512);
    return bool;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(248520);
    super.onDetach();
    this.uLQ.dead();
    AppMethodBeat.o(248520);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(248513);
    this.uLF.requestRefresh();
    AppMethodBeat.o(248513);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
  public static final class b
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(248509);
      e locale = (e)new d(this.uLS);
      AppMethodBeat.o(248509);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter$feedProgressListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedPostProgressEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hk>
  {
    c(FinderMegaVideoProfileLoader paramFinderMegaVideoProfileLoader) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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