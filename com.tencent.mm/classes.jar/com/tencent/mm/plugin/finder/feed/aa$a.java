package com.tencent.mm.plugin.finder.feed;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.c;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class aa$a
  extends b.a
{
  public aa$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(202032);
    AppMethodBeat.o(202032);
  }
  
  public final void aTt()
  {
    AppMethodBeat.i(202029);
    this.rTS.requestLoadMore();
    AppMethodBeat.o(202029);
  }
  
  public final void cAA()
  {
    AppMethodBeat.i(202027);
    Object localObject = this.rTQ;
    if (localObject != null) {
      ((b.b)localObject).U((ArrayList)this.rTS.getDataListJustForAdapter());
    }
    localObject = this.rTQ;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).rTF;
      if (localObject != null)
      {
        localObject = (TextView)((RefreshLoadMoreLayout)localObject).findViewById(2131301486);
        if (localObject != null)
        {
          ((TextView)localObject).setTextColor(this.fLP.getResources().getColor(2131099670));
          AppMethodBeat.o(202027);
          return;
        }
      }
    }
    AppMethodBeat.o(202027);
  }
  
  public final c cAE()
  {
    AppMethodBeat.i(202031);
    Object localObject = this.rTQ;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cAR();; localObject = null)
    {
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((z)localObject).cBj();
      AppMethodBeat.o(202031);
      return localObject;
    }
  }
  
  public final void cAO()
  {
    AppMethodBeat.i(202030);
    BaseFeedLoader.requestInit$default(this.rTS, false, 1, null);
    AppMethodBeat.o(202030);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202028);
    this.rTS.requestRefresh();
    AppMethodBeat.o(202028);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa.a
 * JD-Core Version:    0.7.0.1
 */