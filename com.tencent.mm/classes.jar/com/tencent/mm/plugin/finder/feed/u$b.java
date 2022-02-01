package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class u$b
  extends aa.b
{
  public u$b(MMActivity paramMMActivity, u.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (aa.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(276485);
    AppMethodBeat.o(276485);
  }
  
  public final void aa(ArrayList<bu> paramArrayList)
  {
    AppMethodBeat.i(276480);
    p.k(paramArrayList, "data");
    super.aa(paramArrayList);
    paramArrayList = this.xvJ;
    Object localObject = ad.kS((Context)this.iXq);
    aj localaj = aj.AGc;
    if (aj.isOtherEnableFullScreenEnjoy()) {}
    for (int i = b.g.load_more_full_footer_with_tips;; i = b.g.load_more_footer_with_tips)
    {
      localObject = ((LayoutInflater)localObject).inflate(i, null);
      p.j(localObject, "MMLayoutInflater.getInfl…e_footer_with_tips, null)");
      paramArrayList.setLoadMoreFooter((View)localObject);
      AppMethodBeat.o(276480);
      return;
    }
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(276483);
    View localView = this.iXq.findViewById(b.f.empty_view);
    AppMethodBeat.o(276483);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.u.b
 * JD-Core Version:    0.7.0.1
 */