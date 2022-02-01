package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.j;
import com.tencent.mm.plugin.finder.feed.o.a;
import com.tencent.mm.plugin.finder.feed.o.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "title", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "plugin-finder_release"})
public final class FinderLbsStreamFeedUI
  extends FinderBaseGridFeedUI<o.b, o.a>
{
  private final String TAG = "Finder.LbsStreamFeedUI";
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader rgh;
  private o.a rqg;
  private o.b rqh;
  private final int scene = 2;
  private String title = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202420);
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
    AppMethodBeat.o(202420);
    return localView1;
  }
  
  public final int cuI()
  {
    return 16;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final BaseFinderFeedLoader cvR()
  {
    AppMethodBeat.i(202415);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.rgh;
    if (localBaseFinderFeedLoader == null) {
      k.aVY("feedLoader");
    }
    AppMethodBeat.o(202415);
    return localBaseFinderFeedLoader;
  }
  
  public final int getLayoutId()
  {
    return 2131496221;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202416);
    Object localObject2 = getIntent().getStringExtra("KEY_UI_TITLE");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = (MMActivity)this;
    localObject2 = u.axE();
    k.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    a locala = a.IrY;
    localObject2 = new j((String)localObject2, ((FinderReporterUIC)a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
    ((j)localObject2).rmE = ((b)new a(this));
    this.rgh = ((BaseFinderFeedLoader)localObject2);
    localObject2 = this.rgh;
    if (localObject2 == null) {
      k.aVY("feedLoader");
    }
    this.rqg = new o.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.rqh = new o.b((MMActivity)this, this.scene, this.title);
    localObject1 = this.rqh;
    if (localObject1 == null) {
      k.aVY("viewCallback");
    }
    localObject2 = this.rqg;
    if (localObject2 == null) {
      k.aVY("presenter");
    }
    ((o.b)localObject1).a((c.a)localObject2);
    AppMethodBeat.o(202416);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI$getLoader$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderLbsStreamFeedUI paramFinderLbsStreamFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamFeedUI
 * JD-Core Version:    0.7.0.1
 */