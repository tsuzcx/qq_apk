package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class h$b
  extends aa.b
{
  public h$b(MMActivity paramMMActivity, h.a parama, int paramInt)
  {
    super(paramMMActivity, (aa.a)parama, paramInt, 21);
    AppMethodBeat.i(280010);
    AppMethodBeat.o(280010);
  }
  
  public final void aa(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(280009);
    p.k(paramArrayList, "data");
    super.aa(paramArrayList);
    paramArrayList = this.xvJ;
    Object localObject = ad.kS((Context)this.iXq);
    if (dsA()) {}
    for (int i = b.g.load_more_footer_dark;; i = b.g.load_more_footer)
    {
      localObject = ((LayoutInflater)localObject).inflate(i, null);
      p.j(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramArrayList.setLoadMoreFooter((View)localObject);
      AppMethodBeat.o(280009);
      return;
    }
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.h.b
 * JD-Core Version:    0.7.0.1
 */