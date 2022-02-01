package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.h.a;
import com.tencent.mm.plugin.finder.feed.h.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.live.report.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1;", "presenter", "scene", "", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderFavTimelineUI
  extends FinderLoaderFeedUI<FinderFavFeedLoader, h.b, h.a>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final int scene;
  private h.a xMd;
  private h.b xMe;
  private FinderFavFeedLoader xMf;
  private final c xMg;
  
  public FinderFavTimelineUI()
  {
    AppMethodBeat.i(281989);
    this.TAG = "Finder.FinderFavTimelineUI";
    this.scene = 2;
    this.xMg = new c();
    AppMethodBeat.o(281989);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(281992);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(281992);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(281991);
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
    AppMethodBeat.o(281991);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(281984);
    Object localObject1 = this.xMe;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    localObject1 = ((b.b)localObject1).xvJ.getRecyclerView().getLayoutManager();
    if ((localObject1 instanceof LinearLayoutManager))
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
      localObject2 = this.xMf;
      if (localObject2 == null) {
        p.bGy("feedLoader");
      }
      setResult(-1, com.tencent.mm.plugin.finder.utils.aj.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
    }
    super.finish();
    AppMethodBeat.o(281984);
  }
  
  public final int getCommentScene()
  {
    return 21;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_fav_timeline_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(281975);
    Set localSet = ak.setOf(an.class);
    AppMethodBeat.o(281975);
    return localSet;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(281978);
    Object localObject1 = getContext();
    p.j(localObject1, "context");
    setMMTitle(((AppCompatActivity)localObject1).getResources().getString(b.j.finder_fav_list_title));
    this.xMd = new h.a((MMActivity)this, this.scene);
    localObject1 = (MMActivity)this;
    Object localObject2 = this.xMd;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    this.xMe = new h.b((MMActivity)localObject1, (h.a)localObject2, this.scene);
    localObject1 = z.bdh();
    p.j(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = g.Xox;
    localObject1 = new FinderFavFeedLoader((String)localObject1, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY(), true);
    localObject2 = getIntent();
    p.j(localObject2, "intent");
    ((FinderFavFeedLoader)localObject1).initFromCache((Intent)localObject2);
    ((FinderFavFeedLoader)localObject1).xGt = getIntent().getLongExtra("key_active_topic_id", 0L);
    ((FinderFavFeedLoader)localObject1).setInitDone((j)new a((FinderFavFeedLoader)localObject1, this));
    ((FinderFavFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new b(this));
    this.xMf = ((FinderFavFeedLoader)localObject1);
    localObject1 = this.xMe;
    if (localObject1 == null) {
      p.bGy("viewCallback");
    }
    ((b.b)localObject1).xvJ.getRecyclerView().a((RecyclerView.l)this.xMg);
    ((WeImageView)findViewById(b.f.backBtnIv)).setIconColor(getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_5));
    AppMethodBeat.o(281978);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(281988);
    h.b localb = this.xMe;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    localb.xvJ.getRecyclerView().b((RecyclerView.l)this.xMg);
    super.onDestroy();
    AppMethodBeat.o(281988);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(281986);
    super.onPause();
    Object localObject = k.yBj;
    localObject = this.xMe;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    k.b(((b.b)localObject).xvJ.getRecyclerView(), s.t.yGO, "21", c.yAj);
    AppMethodBeat.o(281986);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281985);
    super.onResume();
    Object localObject = k.yBj;
    localObject = this.xMe;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    k.b(((b.b)localObject).xvJ.getRecyclerView(), s.t.yGO, "21", c.yAi);
    AppMethodBeat.o(281985);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a(FinderFavFeedLoader paramFinderFavFeedLoader, FinderFavTimelineUI paramFinderFavTimelineUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(287314);
      Object localObject = FinderFavTimelineUI.a(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(287314);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).au(this.xMh.getInitPos(), 0);
        AppMethodBeat.o(287314);
        return;
      }
      AppMethodBeat.o(287314);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    b(FinderFavTimelineUI paramFinderFavTimelineUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(276094);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(276094);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(276092);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGO, "21", c.yAh);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(276092);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI
 * JD-Core Version:    0.7.0.1
 */