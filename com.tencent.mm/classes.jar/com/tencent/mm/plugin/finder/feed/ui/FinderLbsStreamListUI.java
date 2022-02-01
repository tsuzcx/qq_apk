package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.y.a;
import com.tencent.mm.plugin.finder.feed.x.a;
import com.tencent.mm.plugin.finder.feed.x.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.b.k;
import java.util.HashMap;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "initPos", "", "presenter", "saveResult", "", "scene", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "onDestroy", "plugin-finder_release"})
public final class FinderLbsStreamListUI
  extends FinderLoaderFeedUI<com.tencent.mm.plugin.finder.feed.model.y, x.b, x.a>
{
  private x.a KSv;
  private x.b KSw;
  private com.tencent.mm.plugin.finder.feed.model.y KSx;
  private boolean KSy;
  private final String TAG = "Finder.StreamTimelineUI";
  private HashMap _$_findViewCache;
  private int qvB;
  private long qxT;
  private final int scene = 2;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198516);
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
    AppMethodBeat.o(198516);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(198514);
    long l;
    Object localObject2;
    int i;
    int j;
    if (this.KSy)
    {
      Object localObject1 = this.KSw;
      if (localObject1 == null) {
        k.aPZ("viewCallback");
      }
      localObject1 = ((a.b)localObject1).quj.getRecyclerView().getLayoutManager();
      if ((localObject1 instanceof LinearLayoutManager))
      {
        l = System.currentTimeMillis();
        localObject2 = this.KSx;
        if (localObject2 == null) {
          k.aPZ("feedLoader");
        }
        localObject2 = ((com.tencent.mm.plugin.finder.feed.model.y)localObject2).getDataListJustForAdapter();
        Object localObject3 = this.KSx;
        if (localObject3 == null) {
          k.aPZ("feedLoader");
        }
        localObject3 = ((com.tencent.mm.plugin.finder.feed.model.y)localObject3).lastBuffer;
        y.a locala = com.tencent.mm.plugin.finder.feed.model.y.KQe;
        y.a.a(l, (List)localObject2, (com.tencent.mm.bx.b)localObject3);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("KEY_CACHE_ID", l);
        i = ((LinearLayoutManager)localObject1).jO();
        j = ((LinearLayoutManager)localObject1).jQ();
        if ((this.qvB < i) || (this.qvB > j)) {
          break label246;
        }
        ((Intent)localObject2).putExtra("KEY_CLICK_FEED_POSITION", -1);
      }
    }
    for (;;)
    {
      setResult(0, (Intent)localObject2);
      ad.i(this.TAG, "lxl resultCacheId:" + l + ", posStart:" + i + ", posEnd " + j + ", initPos:" + this.qvB);
      super.finish();
      AppMethodBeat.o(198514);
      return;
      label246:
      ((Intent)localObject2).putExtra("KEY_CLICK_FEED_POSITION", i);
    }
  }
  
  public final int getCommentScene()
  {
    return 16;
  }
  
  public final int getLayoutId()
  {
    return 2131496221;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198509);
    Object localObject1 = getIntent().getStringExtra("KEY_UI_TITLE");
    if (localObject1 != null) {}
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      setTitle((CharSequence)localObject1);
      setMMTitle(getTitle());
      this.qxT = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
      this.qvB = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
      this.KSy = getIntent().getBooleanExtra("KEY_SAVE_RESULT", false);
      this.KSv = new x.a((MMActivity)this, this.qxT, this.qvB, this.scene);
      localObject1 = (MMActivity)this;
      Object localObject2 = this.KSv;
      if (localObject2 == null) {
        k.aPZ("presenter");
      }
      this.KSw = new x.b((MMActivity)localObject1, (x.a)localObject2, this.scene);
      localObject1 = u.aqO();
      k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject2 = a.LCX;
      localObject1 = new com.tencent.mm.plugin.finder.feed.model.y((String)localObject1, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
      ((com.tencent.mm.plugin.finder.feed.model.y)localObject1).KPL = ((d.g.a.b)new a(this));
      this.KSx = ((com.tencent.mm.plugin.finder.feed.model.y)localObject1);
      AppMethodBeat.o(198509);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198513);
    super.onDestroy();
    y.a locala = com.tencent.mm.plugin.finder.feed.model.y.KQe;
    y.a.BI(this.qxT);
    AppMethodBeat.o(198513);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$1"})
  static final class a
    extends d.g.b.l
    implements d.g.a.b<IResponse<BaseFinderFeed>, d.y>
  {
    a(FinderLbsStreamListUI paramFinderLbsStreamListUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI
 * JD-Core Version:    0.7.0.1
 */