package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.publish.l.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;", "scene", "", "commentScene", "isAutoRefresh", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderPreviewTimelineUIContract$Presenter;IIZ)V", "()Z", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am$c
  extends ae.b
{
  private final boolean ASS;
  
  public am$c(MMActivity paramMMActivity, am.b paramb, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    super(paramMMActivity, (ae.a)paramb, paramInt1, paramInt2);
    AppMethodBeat.i(363833);
    this.ASS = paramBoolean;
    AppMethodBeat.o(363833);
  }
  
  public final void af(ArrayList<cc> paramArrayList)
  {
    AppMethodBeat.i(363853);
    s.u(paramArrayList, "data");
    super.af(paramArrayList);
    paramArrayList = this.ATx;
    View localView = af.mU((Context)this.lzt).inflate(l.f.load_more_footer, null);
    s.s(localView, "getInflater(context).inf…t.load_more_footer, null)");
    paramArrayList.setLoadMoreFooter(localView);
    if (this.ATx.getRecyclerView().getItemDecorationCount() > 0) {
      this.ATx.getRecyclerView().JL();
    }
    AppMethodBeat.o(363853);
  }
  
  public final void ebi()
  {
    AppMethodBeat.i(363842);
    ((ae.a)this.ATv).dUL();
    if (this.ASS) {
      ((ae.a)this.ATv).requestRefresh();
    }
    AppMethodBeat.o(363842);
  }
  
  public final View getEmptyView()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.am.c
 * JD-Core Version:    0.7.0.1
 */