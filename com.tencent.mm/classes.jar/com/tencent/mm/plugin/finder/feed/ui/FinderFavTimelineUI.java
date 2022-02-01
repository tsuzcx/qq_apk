package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.p.a;
import com.tencent.mm.plugin.finder.feed.p.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "initPos", "", "presenter", "scene", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFavTimelineUI
  extends FinderLoaderFeedUI<com.tencent.mm.plugin.finder.feed.model.a, p.b, p.a>
{
  private p.b KRA;
  private com.tencent.mm.plugin.finder.feed.model.a KRB;
  private p.a KRz;
  private final String TAG = "Finder.FinderFavTimelineUI";
  private HashMap _$_findViewCache;
  private int qvB;
  private long qxT;
  private final int scene = 2;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198411);
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
    AppMethodBeat.o(198411);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    return 21;
  }
  
  public final int getLayoutId()
  {
    return 2131496183;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198406);
    Object localObject1 = getContext();
    k.g(localObject1, "context");
    setMMTitle(((AppCompatActivity)localObject1).getResources().getString(2131766238));
    this.qxT = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.qvB = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    this.KRz = new p.a((MMActivity)this, this.qxT, this.qvB, this.scene);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.KRz;
    if (localObject2 == null) {
      k.aPZ("presenter");
    }
    this.KRA = new p.b((MMActivity)localObject1, (p.a)localObject2, this.scene);
    localObject1 = u.aqO();
    k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = com.tencent.mm.ui.component.a.LCX;
    localObject1 = new com.tencent.mm.plugin.finder.feed.model.a((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
    ((com.tencent.mm.plugin.finder.feed.model.a)localObject1).KPL = ((b)new a(this));
    this.KRB = ((com.tencent.mm.plugin.finder.feed.model.a)localObject1);
    AppMethodBeat.o(198406);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$initOnCreate$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderFavTimelineUI paramFinderFavTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI
 * JD-Core Version:    0.7.0.1
 */