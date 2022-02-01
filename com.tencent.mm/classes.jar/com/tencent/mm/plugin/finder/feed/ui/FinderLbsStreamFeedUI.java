package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.b.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.q.a;
import com.tencent.mm.plugin.finder.feed.q.b;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "title", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "plugin-finder_release"})
public final class FinderLbsStreamFeedUI
  extends FinderBaseGridFeedUI<q.b, q.a>
{
  private final String TAG = "Finder.LbsStreamFeedUI";
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader rTS;
  private final int scene = 2;
  private q.a seU;
  private q.b seV;
  private String title = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202746);
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
    AppMethodBeat.o(202746);
    return localView1;
  }
  
  public final int cAZ()
  {
    return 16;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final BaseFinderFeedLoader cCh()
  {
    AppMethodBeat.i(202741);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rTS;
    if (localBaseFinderFeedLoader == null) {
      p.bcb("feedLoader");
    }
    AppMethodBeat.o(202741);
    return localBaseFinderFeedLoader;
  }
  
  public final int getLayoutId()
  {
    return 2131496221;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202742);
    Object localObject2 = getIntent().getStringExtra("KEY_UI_TITLE");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = u.aAu();
    p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = a.KiD;
    localObject1 = new FinderLbsStreamFeedLoader((String)localObject1, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu());
    localObject2 = getIntent();
    p.g(localObject2, "intent");
    ((FinderLbsStreamFeedLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderLbsStreamFeedLoader)localObject1).fetchEndCallback = ((b)new a(this));
    this.rTS = ((BaseFinderFeedLoader)localObject1);
    localObject1 = (MMActivity)this;
    localObject2 = this.rTS;
    if (localObject2 == null) {
      p.bcb("feedLoader");
    }
    this.seU = new q.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.seV = new q.b((MMActivity)this, this.scene, this.title);
    localObject1 = this.seV;
    if (localObject1 == null) {
      p.bcb("viewCallback");
    }
    localObject2 = this.seU;
    if (localObject2 == null) {
      p.bcb("presenter");
    }
    ((q.b)localObject1).a((b.a)localObject2);
    AppMethodBeat.o(202742);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI$initOnCreate$1$1"})
  static final class a
    extends q
    implements b<IResponse<al>, z>
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