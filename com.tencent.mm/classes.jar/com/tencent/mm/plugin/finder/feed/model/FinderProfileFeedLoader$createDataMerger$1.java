package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader.a;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.d;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.z;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$createDataMerger$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader$DefaultDataMerger;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mergeRefresh", "", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "next", "Lkotlin/Function1;", "plugin-finder_release"})
public final class FinderProfileFeedLoader$createDataMerger$1
  extends BaseFeedLoader<am>.a
{
  FinderProfileFeedLoader$createDataMerger$1()
  {
    super(localBaseFeedLoader);
  }
  
  public final void mergeRefresh(final IResponse<am> paramIResponse, final b<? super IResponse<am>, z> paramb)
  {
    AppMethodBeat.i(202910);
    p.h(paramIResponse, "response");
    Object localObject = RefreshLoadMoreLayout.c.LOa;
    localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.fUx());
    c.h((a)new q(new com.tencent.mm.plugin.finder.feed.model.internal.l(7, paramIResponse.getIncrementList(), false, 12))
    {
      public final void invoke()
      {
        AppMethodBeat.i(202909);
        this.this$0.convertOpToReason(this.$op, this.$reason);
        this.this$0.this$0.dispatcher().c(this.$reason);
        b localb = paramb;
        if (localb != null)
        {
          localb.invoke(paramIResponse);
          AppMethodBeat.o(202909);
          return;
        }
        AppMethodBeat.o(202909);
      }
    });
    AppMethodBeat.o(202910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader.createDataMerger.1
 * JD-Core Version:    0.7.0.1
 */