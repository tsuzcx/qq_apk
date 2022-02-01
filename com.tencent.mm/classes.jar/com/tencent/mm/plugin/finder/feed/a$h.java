package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.k;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class a$h
  extends r.b
{
  public a$h(MMActivity paramMMActivity, a.g paramg, int paramInt)
  {
    super(paramMMActivity, (r.a)paramg, paramInt, 13);
    AppMethodBeat.i(201514);
    AppMethodBeat.o(201514);
  }
  
  public final void T(ArrayList<BaseFinderFeed> paramArrayList)
  {
    AppMethodBeat.i(201513);
    k.h(paramArrayList, "data");
    super.T(paramArrayList);
    paramArrayList = this.rfT;
    View localView = z.jD((Context)this.iMV).inflate(2131494590, null);
    k.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(201513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.h
 * JD-Core Version:    0.7.0.1
 */