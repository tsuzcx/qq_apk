package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.n.a;
import com.tencent.mm.plugin.finder.feed.n.b;
import com.tencent.mm.plugin.finder.live.report.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "TAG", "", "autoRefresh", "", "emptyView", "Landroid/view/View;", "feedId", "", "feedLoader", "feedNonceId", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1;", "mPresenter", "mViewCallback", "relatedScene", "", "getRelatedScene", "()I", "relatedScene$delegate", "Lkotlin/Lazy;", "scene", "title", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "onDestroy", "onPause", "onResume", "updateTitle", "plugin-finder_release"})
public final class FinderFeedRelatedTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, n.b, n.a>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private boolean bFt;
  private long feedId;
  private final int scene;
  private View sxR;
  private String title;
  private FinderFeedRelTimelineLoader xMl;
  private n.a xMn;
  private n.b xMo;
  private String xMp;
  private final f xMq;
  private final d xMr;
  
  public FinderFeedRelatedTimelineUI()
  {
    AppMethodBeat.i(285091);
    this.TAG = "Finder.FinderFeedReletedTimelineUI";
    this.scene = 2;
    this.xMp = "";
    this.title = "";
    this.xMq = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.xMr = new d(this);
    AppMethodBeat.o(285091);
  }
  
  private final int dva()
  {
    AppMethodBeat.i(285080);
    int i = ((Number)this.xMq.getValue()).intValue();
    AppMethodBeat.o(285080);
    return i;
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(285082);
    setMMTitle(this.title);
    AppMethodBeat.o(285082);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(285098);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(285098);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(285097);
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
    AppMethodBeat.o(285097);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(285086);
    if (17 == dva())
    {
      AppMethodBeat.o(285086);
      return 96;
    }
    AppMethodBeat.o(285086);
    return 40;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_feed_related_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(285081);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    Object localObject2 = getIntent().getStringExtra("FEED_NONCE_ID");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.xMp = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("TITLE_WORDING");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    this.bFt = getIntent().getBooleanExtra("AUTO_REFRESH", false);
    float f1 = getIntent().getFloatExtra("POI_LATITUDE", 0.0F);
    float f2 = getIntent().getFloatExtra("POI_LONGITUDE", 0.0F);
    localObject1 = findViewById(b.f.emptyView);
    p.j(localObject1, "findViewById(R.id.emptyView)");
    this.sxR = ((View)localObject1);
    if (this.bFt)
    {
      localObject1 = this.sxR;
      if (localObject1 == null) {
        p.bGy("emptyView");
      }
      ((View)localObject1).setVisibility(0);
    }
    updateTitle();
    this.xMn = new n.a((MMActivity)this, this.scene, this.bFt);
    localObject1 = (MMActivity)this;
    localObject2 = this.xMn;
    if (localObject2 == null) {
      p.bGy("mPresenter");
    }
    this.xMo = new n.b((MMActivity)localObject1, (n.a)localObject2, this.scene, getCommentScene());
    long l = this.feedId;
    localObject1 = this.xMp;
    int i = dva();
    localObject2 = com.tencent.mm.ui.component.g.Xox;
    FinderFeedRelTimelineLoader localFinderFeedRelTimelineLoader = new FinderFeedRelTimelineLoader(l, (String)localObject1, 0, null, i, false, null, null, null, 0, ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(aj.class)).ekY(), f1, f2, 4072);
    if (!this.bFt)
    {
      localObject1 = getIntent();
      p.j(localObject1, "intent");
      localFinderFeedRelTimelineLoader.initFromCache((Intent)localObject1);
      if (17 == dva())
      {
        localObject1 = localFinderFeedRelTimelineLoader.getCache();
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.feed.model.q)localObject1).mXB;
          if (localObject1 != null)
          {
            if (((Collection)localObject1).isEmpty()) {
              break label571;
            }
            i = 1;
            if (i == 1)
            {
              localObject1 = localFinderFeedRelTimelineLoader.getCache();
              if (localObject1 == null) {
                break label576;
              }
              localObject1 = ((com.tencent.mm.plugin.finder.feed.model.q)localObject1).mXB;
              if (localObject1 == null) {
                break label576;
              }
            }
          }
        }
      }
    }
    label571:
    label576:
    for (localObject1 = (bu)((ArrayList)localObject1).get(0);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (!(localObject1 instanceof BaseFinderFeed)) {
        localObject2 = null;
      }
      localObject1 = (BaseFinderFeed)localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject();
        localObject2 = n.zWF;
        n.a((FinderObject)localObject1, getCommentScene());
      }
      localFinderFeedRelTimelineLoader.setInitDone((j)new a(localFinderFeedRelTimelineLoader, this));
      localFinderFeedRelTimelineLoader.fetchEndCallback = ((kotlin.g.a.b)new b(this));
      localFinderFeedRelTimelineLoader.xGJ = ((kotlin.g.a.b)new c(this));
      this.xMl = localFinderFeedRelTimelineLoader;
      localObject1 = this.xMo;
      if (localObject1 == null) {
        p.bGy("mViewCallback");
      }
      ((b.b)localObject1).xvJ.getRecyclerView().a((RecyclerView.l)this.xMr);
      AppMethodBeat.o(285081);
      return;
      i = 0;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(285088);
    n.b localb = this.xMo;
    if (localb == null) {
      p.bGy("mViewCallback");
    }
    localb.xvJ.getRecyclerView().b((RecyclerView.l)this.xMr);
    super.onDestroy();
    AppMethodBeat.o(285088);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(285090);
    super.onPause();
    if (17 == dva())
    {
      AppMethodBeat.o(285090);
      return;
    }
    Object localObject = k.yBj;
    localObject = this.xMo;
    if (localObject == null) {
      p.bGy("mViewCallback");
    }
    k.b(((b.b)localObject).xvJ.getRecyclerView(), s.t.yGO, "40", c.yAj);
    AppMethodBeat.o(285090);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(285089);
    super.onResume();
    if (17 == dva())
    {
      AppMethodBeat.o(285089);
      return;
    }
    Object localObject = k.yBj;
    localObject = this.xMo;
    if (localObject == null) {
      p.bGy("mViewCallback");
    }
    k.b(((b.b)localObject).xvJ.getRecyclerView(), s.t.yGO, "40", c.yAi);
    AppMethodBeat.o(285089);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$2", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(226078);
      Object localObject = FinderFeedRelatedTimelineUI.a(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(226078);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).au(this.xLu.getInitPos(), 0);
        AppMethodBeat.o(226078);
        return;
      }
      AppMethodBeat.o(226078);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$3"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    b(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$4"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    c(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(256234);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(256234);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(256230);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (17 == FinderFeedRelatedTimelineUI.d(this.xMs))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(256230);
        return;
      }
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGO, "40", c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(256230);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<Integer>
  {
    e(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFeedRelatedTimelineUI
 * JD-Core Version:    0.7.0.1
 */