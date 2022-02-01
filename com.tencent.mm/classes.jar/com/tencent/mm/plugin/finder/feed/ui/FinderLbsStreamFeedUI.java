package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.r.a;
import com.tencent.mm.plugin.finder.feed.r.b;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "title", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "plugin-finder_release"})
public final class FinderLbsStreamFeedUI
  extends FinderBaseGridFeedUI<r.b, r.a>
{
  private final String TAG = "Finder.LbsStreamFeedUI";
  private HashMap _$_findViewCache;
  private final int scene = 2;
  public BaseFinderFeedLoader tFM;
  private String title = "";
  private r.a uaZ;
  private r.b uba;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245297);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245297);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245296);
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
    AppMethodBeat.o(245296);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final BaseFinderFeedLoader ddZ()
  {
    AppMethodBeat.i(245290);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.tFM;
    if (localBaseFinderFeedLoader == null) {
      p.btv("feedLoader");
    }
    AppMethodBeat.o(245290);
    return localBaseFinderFeedLoader;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(245294);
    c localc = c.vCb;
    if (((Number)c.dtX().value()).intValue() != 0)
    {
      AppMethodBeat.o(245294);
      return 43;
    }
    AppMethodBeat.o(245294);
    return 16;
  }
  
  public final int getLayoutId()
  {
    return 2131494355;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245291);
    Object localObject2 = getIntent().getStringExtra("KEY_UI_TITLE");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = z.aUg();
    p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = a.PRN;
    localObject1 = new FinderLbsStreamFeedLoader((String)localObject1, ((FinderReporterUIC)a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
    localObject2 = getIntent();
    p.g(localObject2, "intent");
    ((FinderLbsStreamFeedLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderLbsStreamFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new a(this));
    this.tFM = ((BaseFinderFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    getCommentScene();
    localObject2 = this.tFM;
    if (localObject2 == null) {
      p.btv("feedLoader");
    }
    this.uaZ = new r.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.uba = new r.b((MMActivity)this, this.scene, getCommentScene(), this.title);
    localObject1 = this.uba;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject2 = this.uaZ;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    ((r.b)localObject1).a((c.a)localObject2);
    AppMethodBeat.o(245291);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI$initOnCreate$1$1"})
  static final class a
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    a(FinderLbsStreamFeedUI paramFinderLbsStreamFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamFeedUI
 * JD-Core Version:    0.7.0.1
 */