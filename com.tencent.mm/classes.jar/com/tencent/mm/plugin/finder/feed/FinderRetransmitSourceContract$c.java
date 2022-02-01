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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class FinderRetransmitSourceContract$c
  extends u.b
{
  public FinderRetransmitSourceContract$c(MMActivity paramMMActivity, FinderRetransmitSourceContract.a parama)
  {
    super(paramMMActivity, (u.a)parama, 2, 4);
    AppMethodBeat.i(165858);
    AppMethodBeat.o(165858);
  }
  
  public final void T(ArrayList<al> paramArrayList)
  {
    AppMethodBeat.i(165857);
    p.h(paramArrayList, "data");
    super.T(paramArrayList);
    paramArrayList = this.rTF;
    View localView = z.jO((Context)this.fLP).inflate(2131494590, null);
    p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(165857);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.FinderRetransmitSourceContract.c
 * JD-Core Version:    0.7.0.1
 */