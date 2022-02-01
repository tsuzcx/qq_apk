package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "scene", "", "commentScene", "isAutoRefresh", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;IIZ)V", "()Z", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
public final class a$c
  extends v.b
{
  private final boolean tLC;
  
  public a$c(MMActivity paramMMActivity, a.b paramb, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramMMActivity, (v.a)paramb, paramInt1, paramInt2);
    AppMethodBeat.i(243672);
    this.tLC = paramBoolean;
    AppMethodBeat.o(243672);
  }
  
  public final void aa(ArrayList<bo> paramArrayList)
  {
    AppMethodBeat.i(243671);
    p.h(paramArrayList, "data");
    super.aa(paramArrayList);
    paramArrayList = this.tLS;
    View localView = aa.jQ((Context)this.gte).inflate(2131495297, null);
    p.g(localView, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(243671);
  }
  
  public final void dbY()
  {
    AppMethodBeat.i(243670);
    Object localObject = this.tLY;
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.Presenter");
      AppMethodBeat.o(243670);
      throw ((Throwable)localObject);
    }
    ((v.a)localObject).dcp();
    if (this.tLC)
    {
      localObject = this.tLY;
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.Presenter");
        AppMethodBeat.o(243670);
        throw ((Throwable)localObject);
      }
      ((v.a)localObject).requestRefresh();
    }
    AppMethodBeat.o(243670);
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.c
 * JD-Core Version:    0.7.0.1
 */