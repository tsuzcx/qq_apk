package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.a;
import com.tencent.mm.plugin.finder.feed.model.internal.f;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.model.l.a;
import com.tencent.mm.plugin.finder.feed.model.l.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.k;
import d.v;
import java.util.ArrayList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "initLastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "initDataList", "", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;Lcom/tencent/mm/protobuf/ByteString;Ljava/util/List;)V", "getInitDataList", "()Ljava/util/List;", "getInitLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class u$a
  extends c.a
{
  final b rju;
  private final List<BaseFinderFeed> rjv;
  
  public u$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader, b paramb, List<? extends BaseFinderFeed> paramList)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(201782);
    this.rju = paramb;
    this.rjv = paramList;
    AppMethodBeat.o(201782);
  }
  
  public final void aQh()
  {
    AppMethodBeat.i(201778);
    this.rgh.requestLoadMore();
    AppMethodBeat.o(201778);
  }
  
  public final void cuB()
  {
    AppMethodBeat.i(201779);
    a.initData$default(this.rgh, (g)new l.b(this.rjv, 0L, (f)new a(this)), false, 2, null);
    AppMethodBeat.o(201779);
  }
  
  public final void cur()
  {
    AppMethodBeat.i(201777);
    c.b localb = this.rgf;
    if (localb != null)
    {
      localb.U((ArrayList)this.rgh.getDataListJustForAdapter());
      AppMethodBeat.o(201777);
      return;
    }
    AppMethodBeat.o(201777);
  }
  
  public final c cut()
  {
    AppMethodBeat.i(201780);
    Object localObject = this.rgf;
    if (localObject != null) {}
    for (localObject = ((c.b)localObject).cuF();; localObject = null)
    {
      if (localObject == null) {
        k.fOy();
      }
      localObject = ((r)localObject).cuS();
      AppMethodBeat.o(201780);
      return localObject;
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(201781);
    super.onDetach();
    l.a locala = com.tencent.mm.plugin.finder.feed.model.l.rng;
    l.a.clearCache();
    AppMethodBeat.o(201781);
  }
  
  public final void requestRefresh() {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/FinderRelatedFeedUIContract$Presenter$loadInitData$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements f
  {
    public final void call(int paramInt)
    {
      AppMethodBeat.i(201776);
      Object localObject = this.rjw.rgh;
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderRelatedLoader");
        AppMethodBeat.o(201776);
        throw ((Throwable)localObject);
      }
      ((com.tencent.mm.plugin.finder.feed.model.l)localObject).lastBuffer = this.rjw.rju;
      AppMethodBeat.o(201776);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u.a
 * JD-Core Version:    0.7.0.1
 */