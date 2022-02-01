package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "scene", "", "commentScene", "isAutoRefresh", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;IIZ)V", "()Z", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$c
  extends ae.b
{
  private final boolean ASS;
  
  public a$c(MMActivity paramMMActivity, a.b paramb, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramMMActivity, (ae.a)paramb, paramInt1, paramInt2);
    AppMethodBeat.i(362558);
    this.ASS = paramBoolean;
    AppMethodBeat.o(362558);
  }
  
  public final void af(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(362572);
    s.u(paramArrayList, "data");
    super.af(paramArrayList);
    paramArrayList = this.ATx;
    View localView = af.mU((Context)this.lzt).inflate(e.f.load_more_footer_dark, null);
    s.s(localView, "getInflater(context).inf…d_more_footer_dark, null)");
    paramArrayList.setLoadMoreFooter(localView);
    AppMethodBeat.o(362572);
  }
  
  public final void ebi()
  {
    AppMethodBeat.i(362562);
    ((ae.a)this.ATv).dUL();
    if (this.ASS) {
      ((ae.a)this.ATv).requestRefresh();
    }
    AppMethodBeat.o(362562);
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