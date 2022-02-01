package com.tencent.mm.plugin.finder.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "tabType", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;I)V", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "getTabType", "()I", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class e
  extends c.a
{
  private final int fEH;
  private final b xNB;
  
  public e(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader, b paramb, int paramInt)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(289943);
    this.xNB = paramb;
    this.fEH = paramInt;
    AppMethodBeat.o(289943);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(289938);
    this.xnX.requestLoadMore();
    AppMethodBeat.o(289938);
  }
  
  public final void dsF()
  {
    AppMethodBeat.i(289939);
    BaseFeedLoader.requestInit$default(this.xnX, false, 1, null);
    AppMethodBeat.o(289939);
  }
  
  public final void dsr()
  {
    AppMethodBeat.i(289942);
    c.b localb = this.xvU;
    if (localb != null)
    {
      localb.ab((ArrayList)this.xnX.getDataListJustForAdapter());
      AppMethodBeat.o(289942);
      return;
    }
    AppMethodBeat.o(289942);
  }
  
  public final f dsu()
  {
    AppMethodBeat.i(289940);
    f localf = this.xNB.dwa();
    AppMethodBeat.o(289940);
    return localf;
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(289937);
    this.xnX.requestRefresh();
    AppMethodBeat.o(289937);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.gallery.e
 * JD-Core Version:    0.7.0.1
 */