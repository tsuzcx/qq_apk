package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
public final class q$b
  extends v.b
{
  public q$b(MMActivity paramMMActivity, q.a parama, int paramInt1, int paramInt2)
  {
    super(paramMMActivity, (v.a)parama, paramInt1, paramInt2);
    AppMethodBeat.i(243885);
    AppMethodBeat.o(243885);
  }
  
  public final void aa(ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(243883);
    p.h(paramArrayList, "data");
    super.aa(paramArrayList);
    paramArrayList = this.tLS;
    Object localObject = aa.jQ((Context)this.gte);
    y localy = y.vXH;
    if (y.isOtherEnableFullScreenEnjoy()) {}
    for (int i = 2131495300;; i = 2131495299)
    {
      localObject = ((LayoutInflater)localObject).inflate(i, null);
      p.g(localObject, "MMLayoutInflater.getInfl…e_footer_with_tips, null)");
      paramArrayList.setLoadMoreFooter((View)localObject);
      AppMethodBeat.o(243883);
      return;
    }
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(243884);
    View localView = this.gte.findViewById(2131300111);
    AppMethodBeat.o(243884);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.q.b
 * JD-Core Version:    0.7.0.1
 */