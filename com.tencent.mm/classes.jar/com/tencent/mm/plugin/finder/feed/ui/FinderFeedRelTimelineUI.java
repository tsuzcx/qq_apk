package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.l.a;
import com.tencent.mm.plugin.finder.feed.l.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "mPresenter", "mViewCallback", "scene", "", "tabType", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedRelTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, l.b, l.a>
{
  private l.a Bmt;
  private l.b Bmu;
  private FinderFeedRelTimelineLoader Bmv;
  private final String TAG = "Finder.FinderFeedRelTimelineUI";
  private long feedId;
  private int hJx;
  private final int scene = 2;
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 20;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_feed_rel_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(365481);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    this.hJx = getIntent().getIntExtra("TAB_TYPE", 0);
    setMMTitle("");
    this.Bmt = new l.a((MMActivity)this, this.feedId, this.scene);
    MMActivity localMMActivity = (MMActivity)this;
    Object localObject2 = this.Bmt;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mPresenter");
      localObject1 = null;
    }
    this.Bmu = new l.b(localMMActivity, (l.a)localObject1, this.scene);
    long l = this.feedId;
    int i = this.hJx;
    localObject1 = k.aeZF;
    localObject1 = new FinderFeedRelTimelineLoader(l, "", i, null, 0, false, null, null, null, 0, ((as)k.d((AppCompatActivity)this).q(as.class)).fou(), 0.0F, 0.0F, 28664);
    ((FinderFeedRelTimelineLoader)localObject1).fetchEndCallback = ((b)new a(this));
    localObject2 = ah.aiuX;
    this.Bmv = ((FinderFeedRelTimelineLoader)localObject1);
    AppMethodBeat.o(365481);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<IResponse<cc>, ah>
  {
    a(FinderFeedRelTimelineUI paramFinderFeedRelTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI
 * JD-Core Version:    0.7.0.1
 */