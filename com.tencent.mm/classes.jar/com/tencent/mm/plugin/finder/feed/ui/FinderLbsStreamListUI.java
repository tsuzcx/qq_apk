package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.s.a;
import com.tencent.mm.plugin.finder.feed.s.b;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "()V", "TAG", "", "feedLoader", "onHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1;", "presenter", "saveResult", "", "scene", "", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderLbsStreamListUI
  extends FinderLoaderFeedUI<FinderLbsStreamFeedLoader, s.b, s.a>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final int scene;
  private s.a ubc;
  private s.b ubd;
  private FinderLbsStreamFeedLoader ube;
  private boolean ubf;
  private final c ubg;
  
  public FinderLbsStreamListUI()
  {
    AppMethodBeat.i(245311);
    this.TAG = "Finder.StreamTimelineUI";
    this.scene = 2;
    this.ubg = new c();
    AppMethodBeat.o(245311);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245314);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245314);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245313);
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
    AppMethodBeat.o(245313);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(245307);
    if (this.ubf)
    {
      Object localObject1 = this.ubd;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      localObject1 = ((b.b)localObject1).tLS.getRecyclerView().getLayoutManager();
      if ((localObject1 instanceof LinearLayoutManager))
      {
        Object localObject2 = y.vXH;
        localObject2 = this.ube;
        if (localObject2 == null) {
          p.btv("feedLoader");
        }
        setResult(-1, y.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
      }
    }
    super.finish();
    AppMethodBeat.o(245307);
  }
  
  public final int getCommentScene()
  {
    return 16;
  }
  
  public final int getLayoutId()
  {
    return 2131494356;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245303);
    Object localObject1 = getIntent().getStringExtra("KEY_UI_TITLE");
    if (localObject1 != null) {}
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      setTitle((CharSequence)localObject1);
      setMMTitle(getTitle());
      this.ubf = getIntent().getBooleanExtra("KEY_SAVE_RESULT", false);
      this.ubc = new s.a((MMActivity)this, this.scene, (byte)0);
      localObject1 = (MMActivity)this;
      Object localObject2 = this.ubc;
      if (localObject2 == null) {
        p.btv("presenter");
      }
      this.ubd = new s.b((MMActivity)localObject1, (s.a)localObject2, this.scene);
      localObject1 = z.aUg();
      p.g(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject2 = com.tencent.mm.ui.component.a.PRN;
      localObject1 = new FinderLbsStreamFeedLoader((String)localObject1, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx());
      localObject2 = getIntent();
      p.g(localObject2, "intent");
      ((FinderLbsStreamFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderLbsStreamFeedLoader)localObject1).setInitDone((h)new a((FinderLbsStreamFeedLoader)localObject1, this));
      ((FinderLbsStreamFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new b(this));
      this.ube = ((FinderLbsStreamFeedLoader)localObject1);
      localObject1 = this.ubd;
      if (localObject1 == null) {
        p.btv("viewCallback");
      }
      ((b.b)localObject1).tLS.getRecyclerView().a((RecyclerView.l)this.ubg);
      AppMethodBeat.o(245303);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245310);
    s.b localb = this.ubd;
    if (localb == null) {
      p.btv("viewCallback");
    }
    localb.tLS.getRecyclerView().b((RecyclerView.l)this.ubg);
    super.onDestroy();
    AppMethodBeat.o(245310);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245309);
    super.onPause();
    k localk = k.vkd;
    k.b(null, s.p.voA, "16", c.vjg);
    AppMethodBeat.o(245309);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245308);
    super.onResume();
    k localk = k.vkd;
    k.b(null, s.p.voA, "16", c.vjf);
    AppMethodBeat.o(245308);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderLbsStreamFeedLoader paramFinderLbsStreamFeedLoader, FinderLbsStreamListUI paramFinderLbsStreamListUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245298);
      Object localObject = FinderLbsStreamListUI.a(jdField_this).tLS.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(245298);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).ah(this.ubh.getInitPos(), 0);
        AppMethodBeat.o(245298);
        return;
      }
      AppMethodBeat.o(245298);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    b(FinderLbsStreamListUI paramFinderLbsStreamListUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(245302);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(245302);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(245301);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.vkd;
      k.b(paramRecyclerView, s.p.voA, "16", c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(245301);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI
 * JD-Core Version:    0.7.0.1
 */