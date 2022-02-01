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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/FinderSnsPostUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "initViewCallback", "", "loadInitData", "loadMoreData", "requestRefresh", "plugin-finder_release"})
public final class aa$a
  extends b.a
{
  public aa$a(MMActivity paramMMActivity, BaseFinderFeedLoader paramBaseFinderFeedLoader)
  {
    super(paramMMActivity, paramBaseFinderFeedLoader);
    AppMethodBeat.i(202496);
    AppMethodBeat.o(202496);
  }
  
  public final void aTS()
  {
    AppMethodBeat.i(202493);
    this.scw.requestLoadMore();
    AppMethodBeat.o(202493);
  }
  
  public final void cCA()
  {
    AppMethodBeat.i(202494);
    BaseFeedLoader.requestInit$default(this.scw, false, 1, null);
    AppMethodBeat.o(202494);
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(202491);
    Object localObject = this.scu;
    if (localObject != null) {
      ((b.b)localObject).U((ArrayList)this.scw.getDataListJustForAdapter());
    }
    localObject = this.scu;
    if (localObject != null)
    {
      localObject = ((b.b)localObject).scj;
      if (localObject != null)
      {
        localObject = (TextView)((RefreshLoadMoreLayout)localObject).findViewById(2131301486);
        if (localObject != null)
        {
          ((TextView)localObject).setTextColor(this.fNT.getResources().getColor(2131099670));
          AppMethodBeat.o(202491);
          return;
        }
      }
    }
    AppMethodBeat.o(202491);
  }
  
  public final c cCq()
  {
    AppMethodBeat.i(202495);
    Object localObject = this.scu;
    if (localObject != null) {}
    for (localObject = ((b.b)localObject).cCD();; localObject = null)
    {
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((z)localObject).cCV();
      AppMethodBeat.o(202495);
      return localObject;
    }
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(202492);
    this.scw.requestRefresh();
    AppMethodBeat.o(202492);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.aa.a
 * JD-Core Version:    0.7.0.1
 */