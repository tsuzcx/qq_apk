package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.i;
import com.tencent.mm.plugin.finder.feed.model.k;
import com.tencent.mm.plugin.finder.live.component.y;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/FinderFriendFoldedTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "feedId", "", "username", "", "scene", "", "isEnableFullScreen", "", "(Lcom/tencent/mm/ui/MMActivity;JLjava/lang/String;IZ)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getFeedId", "()J", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getScene", "()I", "getUsername", "()Ljava/lang/String;", "isEnableFullScreenEnjoyByScene", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
public final class r$a
  extends aa.a
{
  private final long feedId;
  private final int scene;
  private final String username;
  private final i xve;
  private final k xvf;
  private final boolean xyG;
  
  public r$a(MMActivity paramMMActivity, long paramLong, String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramMMActivity);
    AppMethodBeat.i(248745);
    this.feedId = paramLong;
    this.username = paramString;
    this.scene = paramInt;
    this.xyG = paramBoolean;
    paramString = g.Xox;
    this.xve = ((com.tencent.mm.plugin.finder.viewmodel.component.l)g.b((AppCompatActivity)paramMMActivity).i(com.tencent.mm.plugin.finder.viewmodel.component.l.class)).xve;
    paramString = g.Xox;
    this.xvf = ((y)g.b((AppCompatActivity)paramMMActivity).i(y.class)).yci;
    AppMethodBeat.o(248745);
  }
  
  public final void a(BaseFinderFeedLoader paramBaseFinderFeedLoader, aa.b paramb)
  {
    AppMethodBeat.i(248738);
    p.k(paramBaseFinderFeedLoader, "model");
    p.k(paramb, "callback");
    super.a(paramBaseFinderFeedLoader, paramb);
    this.xve.a(this.scene, this.xkX, (b)new a(this));
    paramBaseFinderFeedLoader = aj.Bnu;
    paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
    if (paramBaseFinderFeedLoader != null)
    {
      paramBaseFinderFeedLoader = aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader != null) {
        paramBaseFinderFeedLoader.a((d)this.xve);
      }
    }
    paramb = this.xvf;
    m localm = (m)new b(this);
    paramBaseFinderFeedLoader = this.xvC;
    if (paramBaseFinderFeedLoader != null) {}
    for (paramBaseFinderFeedLoader = paramBaseFinderFeedLoader.xvJ.getRecyclerView();; paramBaseFinderFeedLoader = null)
    {
      paramb.a(localm, paramBaseFinderFeedLoader);
      paramBaseFinderFeedLoader = aj.Bnu;
      paramBaseFinderFeedLoader = aj.a.fZ((Context)this.iXq);
      if (paramBaseFinderFeedLoader == null) {
        break;
      }
      paramBaseFinderFeedLoader = aj.a(paramBaseFinderFeedLoader);
      if (paramBaseFinderFeedLoader == null) {
        break;
      }
      paramBaseFinderFeedLoader.a((d)this.xvf);
      AppMethodBeat.o(248738);
      return;
    }
    AppMethodBeat.o(248738);
  }
  
  public final void byN()
  {
    AppMethodBeat.i(248734);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestLoadMore();
      AppMethodBeat.o(248734);
      return;
    }
    AppMethodBeat.o(248734);
  }
  
  public final boolean dsq()
  {
    return this.xyG;
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(248741);
    this.xve.onDetach();
    Object localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = aj.a((aj)localObject);
      if (localObject != null) {
        ((c)localObject).b((d)this.xve);
      }
    }
    this.xvf.onDetach();
    localObject = aj.Bnu;
    localObject = aj.a.fZ((Context)this.iXq);
    if (localObject != null)
    {
      localObject = aj.a((aj)localObject);
      if (localObject != null) {
        ((c)localObject).b((d)this.xvf);
      }
    }
    super.onDetach();
    AppMethodBeat.o(248741);
  }
  
  public final void requestRefresh()
  {
    AppMethodBeat.i(248732);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.xnX;
    if (localBaseFinderFeedLoader != null)
    {
      localBaseFinderFeedLoader.requestRefresh();
      AppMethodBeat.o(248732);
      return;
    }
    AppMethodBeat.o(248732);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
  static final class a
    extends q
    implements b<Integer, bu>
  {
    a(r.a parama)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
  static final class b
    extends q
    implements m<Integer, Integer, LinkedList<bu>>
  {
    b(r.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.r.a
 * JD-Core Version:    0.7.0.1
 */