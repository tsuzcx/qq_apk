package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.m.a;
import com.tencent.mm.plugin.finder.feed.m.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "TAG", "", "autoRefresh", "", "emptyView", "Landroid/view/View;", "feedId", "", "feedLoader", "feedNonceId", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1;", "mPresenter", "mViewCallback", "relatedScene", "", "scene", "title", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "onPause", "onResume", "updateTitle", "plugin-finder_release"})
public final class FinderFeedRelatedTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, m.b, m.a>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private long feedId;
  private View poS;
  private final int scene;
  private FinderFeedRelTimelineLoader tZW;
  private m.a tZY;
  private m.b tZZ;
  private String title;
  private boolean uW;
  private String uaa;
  private int uab;
  private final d uac;
  
  public FinderFeedRelatedTimelineUI()
  {
    AppMethodBeat.i(245183);
    this.TAG = "Finder.FinderFeedReletedTimelineUI";
    this.scene = 2;
    this.uaa = "";
    this.title = "";
    this.uac = new d(this);
    AppMethodBeat.o(245183);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(245176);
    setMMTitle(this.title);
    AppMethodBeat.o(245176);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245188);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245188);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245187);
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
    AppMethodBeat.o(245187);
    return localView1;
  }
  
  public final int ddN()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    if (17 == this.uab) {
      return 27;
    }
    return 40;
  }
  
  public final int getLayoutId()
  {
    return 2131494299;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(245175);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    Object localObject2 = getIntent().getStringExtra("FEED_NONCE_ID");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.uaa = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("TITLE_WORDING");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    this.uW = getIntent().getBooleanExtra("AUTO_REFRESH", false);
    this.uab = getIntent().getIntExtra("GET_REL_SCENE", 5);
    localObject1 = com.tencent.mm.ui.component.a.PRN;
    ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).tCE = getCommentScene();
    localObject1 = findViewById(2131300078);
    p.g(localObject1, "findViewById(R.id.emptyView)");
    this.poS = ((View)localObject1);
    if (this.uW)
    {
      localObject1 = this.poS;
      if (localObject1 == null) {
        p.btv("emptyView");
      }
      ((View)localObject1).setVisibility(0);
    }
    updateTitle();
    this.tZY = new m.a((MMActivity)this, this.scene, this.uW);
    localObject1 = (MMActivity)this;
    localObject2 = this.tZY;
    if (localObject2 == null) {
      p.btv("mPresenter");
    }
    this.tZZ = new m.b((MMActivity)localObject1, (m.a)localObject2, this.scene, getCommentScene());
    long l = this.feedId;
    localObject1 = this.uaa;
    int i = this.uab;
    localObject2 = com.tencent.mm.ui.component.a.PRN;
    localObject1 = new FinderFeedRelTimelineLoader(l, (String)localObject1, 0, null, i, false, null, null, null, 0, ((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class)).dIx(), 4072);
    if (!this.uW)
    {
      localObject2 = getIntent();
      p.g(localObject2, "intent");
      ((FinderFeedRelTimelineLoader)localObject1).initFromCache((Intent)localObject2);
    }
    ((FinderFeedRelTimelineLoader)localObject1).setInitDone((h)new a((FinderFeedRelTimelineLoader)localObject1, this));
    ((FinderFeedRelTimelineLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new b(this));
    ((FinderFeedRelTimelineLoader)localObject1).tVa = ((kotlin.g.a.b)new c(this));
    this.tZW = ((FinderFeedRelTimelineLoader)localObject1);
    localObject1 = this.tZZ;
    if (localObject1 == null) {
      p.btv("mViewCallback");
    }
    ((b.b)localObject1).tLS.getRecyclerView().a((RecyclerView.l)this.uac);
    AppMethodBeat.o(245175);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245180);
    m.b localb = this.tZZ;
    if (localb == null) {
      p.btv("mViewCallback");
    }
    localb.tLS.getRecyclerView().b((RecyclerView.l)this.uac);
    super.onDestroy();
    AppMethodBeat.o(245180);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(245182);
    super.onPause();
    if (17 == this.uab)
    {
      AppMethodBeat.o(245182);
      return;
    }
    Object localObject = k.vkd;
    localObject = this.tZZ;
    if (localObject == null) {
      p.btv("mViewCallback");
    }
    k.b(((b.b)localObject).tLS.getRecyclerView(), s.p.voB, "40", c.vjg);
    AppMethodBeat.o(245182);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245181);
    super.onResume();
    if (17 == this.uab)
    {
      AppMethodBeat.o(245181);
      return;
    }
    Object localObject = k.vkd;
    localObject = this.tZZ;
    if (localObject == null) {
      p.btv("mViewCallback");
    }
    k.b(((b.b)localObject).tLS.getRecyclerView(), s.p.voB, "40", c.vjf);
    AppMethodBeat.o(245181);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(245170);
      Object localObject = FinderFeedRelatedTimelineUI.a(jdField_this).tLS.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(245170);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).ah(this.tZf.getInitPos(), 0);
        AppMethodBeat.o(245170);
        return;
      }
      AppMethodBeat.o(245170);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    b(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$3"})
  static final class c
    extends q
    implements kotlin.g.a.b<IResponse<bo>, x>
  {
    c(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(245174);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(245174);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(245173);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (17 == FinderFeedRelatedTimelineUI.d(this.uad))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(245173);
        return;
      }
      localObject = k.vkd;
      k.b(paramRecyclerView, s.p.voB, "40", c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(245173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelatedTimelineUI
 * JD-Core Version:    0.7.0.1
 */