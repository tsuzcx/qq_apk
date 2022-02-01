package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onAttach", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "Companion", "plugin-finder_release"})
public final class r$a
  extends c.a
{
  public static final a tOu;
  
  static
  {
    AppMethodBeat.i(243903);
    tOu = new a((byte)0);
    AppMethodBeat.o(243903);
  }
  
  public r$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(243902);
    AppMethodBeat.o(243902);
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(243898);
    p.h(paramb, "callback");
    super.a(paramb);
    AppMethodBeat.o(243898);
  }
  
  public final void boE()
  {
    AppMethodBeat.i(243896);
    this.tFM.requestLoadMore();
    AppMethodBeat.o(243896);
  }
  
  public final void dcb()
  {
    AppMethodBeat.i(243895);
    c.b localb = this.tMd;
    if (localb != null)
    {
      localb.ab((ArrayList)this.tFM.getDataListJustForAdapter());
      AppMethodBeat.o(243895);
      return;
    }
    AppMethodBeat.o(243895);
  }
  
  public final f dce()
  {
    AppMethodBeat.i(243900);
    Object localObject = this.tMd;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).dcs();; localObject = null)
    {
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((al)localObject).dcK();
      AppMethodBeat.o(243900);
      return localObject;
    }
  }
  
  public final void dcp()
  {
    AppMethodBeat.i(243897);
    BaseFeedLoader.requestInit$default(this.tFM, false, 1, null);
    AppMethodBeat.o(243897);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(243901);
    super.onDetach();
    FinderLbsStreamFeedLoader.a locala = FinderLbsStreamFeedLoader.tVL;
    Log.i(FinderLbsStreamFeedLoader.access$getTAG$cp(), "clearCache");
    FinderLbsStreamFeedLoader.ddA().clear();
    AppMethodBeat.o(243901);
  }
  
  public final void requestRefresh() {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.r.a
 * JD-Core Version:    0.7.0.1
 */