package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.r.a;
import com.tencent.mm.plugin.finder.feed.r.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelTimelineContract$Presenter;", "()V", "TAG", "", "feedId", "", "feedLoader", "mPresenter", "mViewCallback", "scene", "", "tabType", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFeedRelTimelineUI
  extends FinderLoaderFeedUI<com.tencent.mm.plugin.finder.feed.model.b, r.b, r.a>
{
  private int IoU;
  private r.a KRD;
  private r.b KRE;
  private com.tencent.mm.plugin.finder.feed.model.b KRF;
  private final String TAG = "Finder.FinderFeedRelTimelineUI";
  private HashMap _$_findViewCache;
  private long feedId;
  private final int scene = 2;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198418);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(198418);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 20;
  }
  
  public final int getLayoutId()
  {
    return 2131496192;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198413);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    this.IoU = getIntent().getIntExtra("TAB_TYPE", 0);
    setMMTitle("");
    this.KRD = new r.a((MMActivity)this, this.feedId, this.scene);
    Object localObject = (MMActivity)this;
    r.a locala = this.KRD;
    if (locala == null) {
      k.aPZ("mPresenter");
    }
    this.KRE = new r.b((MMActivity)localObject, locala, this.scene);
    long l = this.feedId;
    int i = this.IoU;
    localObject = a.LCX;
    localObject = new com.tencent.mm.plugin.finder.feed.model.b(l, i, null, 0, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs(), 12);
    ((com.tencent.mm.plugin.finder.feed.model.b)localObject).KPL = ((d.g.a.b)new a(this));
    this.KRF = ((com.tencent.mm.plugin.finder.feed.model.b)localObject);
    AppMethodBeat.o(198413);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelTimelineUI$initOnCreate$1$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderFeedRelTimelineUI paramFinderFeedRelTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelTimelineUI
 * JD-Core Version:    0.7.0.1
 */