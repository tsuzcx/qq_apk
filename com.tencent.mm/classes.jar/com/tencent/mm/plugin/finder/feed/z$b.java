package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderRelatedTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class z$b
  extends u.b
{
  public z$b(MMActivity paramMMActivity, z.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (u.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(202021);
    AppMethodBeat.o(202021);
  }
  
  public final void T(ArrayList<al> paramArrayList)
  {
    AppMethodBeat.i(202020);
    p.h(paramArrayList, "data");
    super.T(paramArrayList);
    paramArrayList = this.rTF;
    View localView = z.jO((Context)this.fLP).inflate(2131494590, null);
    p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(202020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.z.b
 * JD-Core Version:    0.7.0.1
 */