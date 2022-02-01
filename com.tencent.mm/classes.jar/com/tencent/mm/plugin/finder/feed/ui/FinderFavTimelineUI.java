package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.h.a;
import com.tencent.mm.plugin.finder.feed.h.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1;", "presenter", "scene", "", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderFavTimelineUI
  extends FinderLoaderFeedUI<FinderFavFeedLoader, h.b, h.a>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final int scene;
  private h.a tZO;
  private h.b tZP;
  private FinderFavFeedLoader tZQ;
  private final c tZR;
  
  public FinderFavTimelineUI()
  {
    AppMethodBeat.i(245158);
    this.TAG = "Finder.FinderFavTimelineUI";
    this.scene = 2;
    this.tZR = new c();
    AppMethodBeat.o(245158);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245161);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245161);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245160);
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
    AppMethodBeat.o(245160);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245154);
    Object localObject1 = this.tZP;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    localObject1 = ((b.b)localObject1).tLS.getRecyclerView().getLayoutManager();
    if ((localObject1 instanceof LinearLayoutManager))
    {
      Object localObject2 = y.vXH;
      localObject2 = this.tZQ;
      if (localObject2 == null) {
        p.btv("feedLoader");
      }
      setResult(-1, y.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
    }
    super.finish();
    AppMethodBeat.o(245154);
  }
  
  public final int getCommentScene()
  {
    return 21;
  }
  
  public final int getLayoutId()
  {
    return 2131494252;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245150);
    Object localObject1 = getContext();
    p.g(localObject1, "context");
    setMMTitle(((AppCompatActivity)localObject1).getResources().getString(2131759709));
    this.tZO = new h.a((MMActivity)this, this.scene);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.tZO;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    this.tZP = new h.b((MMActivity)localObject1, (h.a)localObject2, this.scene);
    localObject1 = z.aUg();
    p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = new FinderFavFeedLoader((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx(), true);
    localObject2 = getIntent();
    p.g(localObject2, "intent");
    ((FinderFavFeedLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderFavFeedLoader)localObject1).setInitDone((h)new a((FinderFavFeedLoader)localObject1, this));
    ((FinderFavFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new b(this));
    this.tZQ = ((FinderFavFeedLoader)localObject1);
    localObject1 = this.tZP;
    if (localObject1 == null) {
      p.btv("viewCallback");
    }
    ((b.b)localObject1).tLS.getRecyclerView().a((RecyclerView.l)this.tZR);
    AppMethodBeat.o(245150);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245157);
    h.b localb = this.tZP;
    if (localb == null) {
      p.btv("viewCallback");
    }
    localb.tLS.getRecyclerView().b((RecyclerView.l)this.tZR);
    super.onDestroy();
    AppMethodBeat.o(245157);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245156);
    super.onPause();
    Object localObject = k.vkd;
    localObject = this.tZP;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    k.b(((b.b)localObject).tLS.getRecyclerView(), s.p.voB, "21", c.vjg);
    AppMethodBeat.o(245156);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245155);
    super.onResume();
    Object localObject = k.vkd;
    localObject = this.tZP;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    k.b(((b.b)localObject).tLS.getRecyclerView(), s.p.voB, "21", c.vjf);
    AppMethodBeat.o(245155);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderFavFeedLoader paramFinderFavFeedLoader, FinderFavTimelineUI paramFinderFavTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245146);
      Object localObject = FinderFavTimelineUI.a(jdField_this).tLS.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(245146);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).ah(this.tZS.getInitPos(), 0);
        AppMethodBeat.o(245146);
        return;
      }
      AppMethodBeat.o(245146);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    b(FinderFavTimelineUI paramFinderFavTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(245149);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(245149);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(245148);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.vkd;
      k.b(paramRecyclerView, s.p.voB, "21", c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(245148);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI
 * JD-Core Version:    0.7.0.1
 */