package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.model.h;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.n.a;
import com.tencent.mm.plugin.finder.feed.n.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "initPos", "", "presenter", "scene", "viewCallback", "getLayoutId", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFriendLikeTimelineUI
  extends FinderLoaderFeedUI<h, n.b, n.a>
{
  private final String TAG = "Finder.FinderFavTimelineUI";
  private HashMap _$_findViewCache;
  private long rhr;
  private int rht;
  private n.a rpQ;
  private n.b rpR;
  private h rpS;
  private final int scene = 2;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202387);
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
    AppMethodBeat.o(202387);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496205;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202382);
    setMMTitle("");
    this.rhr = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.rht = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    this.rpQ = new n.a((MMActivity)this, this.rhr, this.rht, this.scene);
    Object localObject1 = (MMActivity)this;
    Object localObject2 = this.rpQ;
    if (localObject2 == null) {
      k.aVY("presenter");
    }
    this.rpR = new n.b((MMActivity)localObject1, (n.a)localObject2, this.scene, cuI());
    localObject1 = u.axE();
    k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = a.IrY;
    localObject1 = new h((String)localObject1, ((FinderReporterUIC)a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
    ((h)localObject1).rmE = ((b)new a(this));
    this.rpS = ((h)localObject1);
    AppMethodBeat.o(202382);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$1$1"})
  static final class a
    extends d.g.b.l
    implements b<IResponse<BaseFinderFeed>, y>
  {
    a(FinderFriendLikeTimelineUI paramFinderFriendLikeTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI
 * JD-Core Version:    0.7.0.1
 */