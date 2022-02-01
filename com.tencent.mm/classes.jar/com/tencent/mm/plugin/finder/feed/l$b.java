package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "getLoadMoreFooter", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public class l$b
  extends u.b
{
  public l$b(MMActivity paramMMActivity, l.a parama, int paramInt)
  {
    super(paramMMActivity, (u.a)parama, paramInt, 40);
    AppMethodBeat.i(202283);
    AppMethodBeat.o(202283);
  }
  
  public final void T(ArrayList<am> paramArrayList)
  {
    AppMethodBeat.i(202281);
    p.h(paramArrayList, "data");
    super.T(paramArrayList);
    this.scj.setLoadMoreFooter(getLoadMoreFooter());
    AppMethodBeat.o(202281);
  }
  
  public View getLoadMoreFooter()
  {
    AppMethodBeat.i(202282);
    View localView = z.jV((Context)this.fNT).inflate(2131494590, null);
    p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    AppMethodBeat.o(202282);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.l.b
 * JD-Core Version:    0.7.0.1
 */