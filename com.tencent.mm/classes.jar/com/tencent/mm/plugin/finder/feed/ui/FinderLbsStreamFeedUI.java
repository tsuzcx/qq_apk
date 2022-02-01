package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.n.a;
import com.tencent.mm.plugin.finder.feed.w.a;
import com.tencent.mm.plugin.finder.feed.w.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.k;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderBaseGridFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamFeedUIContract$LbsStreamFeedPresenter;", "()V", "TAG", "", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "presenter", "scene", "", "title", "viewCallback", "getCommentScene", "getLayoutId", "getLoader", "getPresenter", "getReportType", "getViewCallback", "initAfterAttach", "", "initOnCreate", "plugin-finder_release"})
public final class FinderLbsStreamFeedUI
  extends FinderBaseGridFeedUI<w.b, w.a>
{
  private w.a KSs;
  private w.b KSt;
  private final String TAG = "Finder.LbsStreamFeedUI";
  private HashMap _$_findViewCache;
  public BaseFinderFeedLoader qvo;
  private final int scene = 2;
  private String title = "";
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198507);
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
    AppMethodBeat.o(198507);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final BaseFinderFeedLoader fTF()
  {
    AppMethodBeat.i(198502);
    BaseFinderFeedLoader localBaseFinderFeedLoader = this.qvo;
    if (localBaseFinderFeedLoader == null) {
      k.aPZ("feedLoader");
    }
    AppMethodBeat.o(198502);
    return localBaseFinderFeedLoader;
  }
  
  public final int getCommentScene()
  {
    return 16;
  }
  
  public final int getLayoutId()
  {
    return 2131496220;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198503);
    Object localObject2 = getIntent().getStringExtra("KEY_UI_TITLE");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    setMMTitle(this.title);
    localObject1 = (MMActivity)this;
    localObject2 = u.aqO();
    k.g(localObject2, "ConfigStorageLogic.getMyFinderUsername()");
    a locala = a.LCX;
    localObject2 = new com.tencent.mm.plugin.finder.feed.model.y((String)localObject2, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
    ((com.tencent.mm.plugin.finder.feed.model.y)localObject2).KPL = ((b)new a(this));
    this.qvo = ((BaseFinderFeedLoader)localObject2);
    localObject2 = this.qvo;
    if (localObject2 == null) {
      k.aPZ("feedLoader");
    }
    this.KSs = new w.a((MMActivity)localObject1, (BaseFinderFeedLoader)localObject2);
    this.KSt = new w.b((MMActivity)this, this.scene, this.title);
    localObject1 = this.KSt;
    if (localObject1 == null) {
      k.aPZ("viewCallback");
    }
    localObject2 = this.KSs;
    if (localObject2 == null) {
      k.aPZ("presenter");
    }
    ((w.b)localObject1).a((n.a)localObject2);
    AppMethodBeat.o(198503);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamFeedUI$getLoader$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, d.y>
  {
    a(FinderLbsStreamFeedUI paramFinderLbsStreamFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamFeedUI
 * JD-Core Version:    0.7.0.1
 */