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
import com.tencent.mm.plugin.finder.feed.f.a;
import com.tencent.mm.plugin.finder.feed.f.b;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "initPos", "", "presenter", "scene", "viewCallback", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFavTimelineUI
  extends FinderLoaderFeedUI<d, f.b, f.a>
{
  private final String TAG = "Finder.FinderFavTimelineUI";
  private HashMap _$_findViewCache;
  private long rhr;
  private int rht;
  private f.a rpj;
  private f.b rpk;
  private d rpl;
  private final int scene = 2;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202324);
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
    AppMethodBeat.o(202324);
    return localView1;
  }
  
  public final int cuI()
  {
    return 21;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496184;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202319);
    Object localObject1 = getContext();
    k.g(localObject1, "context");
    setMMTitle(((AppCompatActivity)localObject1).getResources().getString(2131766394));
    this.rhr = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.rht = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    this.rpj = new f.a((MMActivity)this, this.rhr, this.rht, this.scene);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.rpj;
    if (localObject2 == null) {
      k.aVY("presenter");
    }
    this.rpk = new f.b((MMActivity)localObject1, (f.a)localObject2, this.scene);
    localObject1 = u.axE();
    k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = a.IrY;
    localObject1 = new d((String)localObject1, ((FinderReporterUIC)a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
    ((d)localObject1).rmE = ((b)new a(this));
    this.rpl = ((d)localObject1);
    AppMethodBeat.o(202319);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$initOnCreate$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI
 * JD-Core Version:    0.7.0.1
 */