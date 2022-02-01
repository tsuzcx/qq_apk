package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.w;
import com.tencent.mm.plugin.finder.feed.v.a;
import com.tencent.mm.plugin.finder.feed.v.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import d.g.a.b;
import d.g.b.k;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFriendLikeLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "()V", "TAG", "", "cacheId", "", "feedLoader", "initPos", "", "presenter", "scene", "viewCallback", "getLayoutId", "getModel", "getPresenter", "getViewCallback", "initOnCreate", "", "plugin-finder_release"})
public final class FinderFriendLikeTimelineUI
  extends FinderLoaderFeedUI<w, v.b, v.a>
{
  private v.a KSd;
  private v.b KSe;
  private w KSf;
  private final String TAG = "Finder.FinderFavTimelineUI";
  private HashMap _$_findViewCache;
  private int qvB;
  private long qxT;
  private final int scene = 2;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198474);
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
    AppMethodBeat.o(198474);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131496204;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(198469);
    setMMTitle("");
    this.qxT = getIntent().getLongExtra("KEY_CACHE_ID", 0L);
    this.qvB = getIntent().getIntExtra("KEY_CLICK_FEED_POSITION", 0);
    this.KSd = new v.a((MMActivity)this, this.qxT, this.qvB, this.scene);
    Object localObject1 = (MMActivity)this;
    Object localObject2 = this.KSd;
    if (localObject2 == null) {
      k.aPZ("presenter");
    }
    this.KSe = new v.b((MMActivity)localObject1, (v.a)localObject2, this.scene, getCommentScene());
    localObject1 = u.aqO();
    k.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = a.LCX;
    localObject1 = new w((String)localObject1, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
    ((w)localObject1).KPL = ((b)new a(this));
    this.KSf = ((w)localObject1);
    AppMethodBeat.o(198469);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendLikeTimelineUI$initOnCreate$1$1"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendLikeTimelineUI
 * JD-Core Version:    0.7.0.1
 */