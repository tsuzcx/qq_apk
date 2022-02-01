package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.w.a;
import com.tencent.mm.plugin.finder.feed.w.b;
import com.tencent.mm.plugin.finder.live.report.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "()V", "TAG", "", "feedLoader", "onHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1;", "presenter", "saveResult", "", "scene", "", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "onDestroy", "onPause", "onResume", "plugin-finder_release"})
public final class FinderLbsStreamListUI
  extends FinderLoaderFeedUI<FinderLbsStreamFeedLoader, w.b, w.a>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final int scene;
  private w.a xOs;
  private w.b xOt;
  private FinderLbsStreamFeedLoader xOu;
  private boolean xOv;
  private final c xOw;
  
  public FinderLbsStreamListUI()
  {
    AppMethodBeat.i(281076);
    this.TAG = "Finder.StreamTimelineUI";
    this.scene = 2;
    this.xOw = new c();
    AppMethodBeat.o(281076);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(281079);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(281079);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(281078);
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
    AppMethodBeat.o(281078);
    return localView1;
  }
  
  public final int duR()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(281072);
    if (this.xOv)
    {
      Object localObject1 = this.xOt;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      localObject1 = ((b.b)localObject1).xvJ.getRecyclerView().getLayoutManager();
      if ((localObject1 instanceof LinearLayoutManager))
      {
        Object localObject2 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject2 = this.xOu;
        if (localObject2 == null) {
          p.bGy("feedLoader");
        }
        setResult(-1, com.tencent.mm.plugin.finder.utils.aj.a((BaseFinderFeedLoader)localObject2, (LinearLayoutManager)localObject1));
      }
    }
    super.finish();
    AppMethodBeat.o(281072);
  }
  
  public final int getCommentScene()
  {
    return 16;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_lbs_stream_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(281068);
    Object localObject1 = getIntent().getStringExtra("KEY_UI_TITLE");
    if (localObject1 != null) {}
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      setTitle((CharSequence)localObject1);
      setMMTitle(getTitle());
      this.xOv = getIntent().getBooleanExtra("KEY_SAVE_RESULT", false);
      this.xOs = new w.a((MMActivity)this, this.scene, (byte)0);
      localObject1 = (MMActivity)this;
      Object localObject2 = this.xOs;
      if (localObject2 == null) {
        p.bGy("presenter");
      }
      this.xOt = new w.b((MMActivity)localObject1, (w.a)localObject2, this.scene);
      localObject1 = z.bdh();
      p.j(localObject1, "ConfigStorageLogic.getMyFinderUsername()");
      localObject2 = g.Xox;
      localObject1 = new FinderLbsStreamFeedLoader((String)localObject1, ((com.tencent.mm.plugin.finder.viewmodel.component.aj)g.b((AppCompatActivity)this).i(com.tencent.mm.plugin.finder.viewmodel.component.aj.class)).ekY());
      localObject2 = getIntent();
      p.j(localObject2, "intent");
      ((FinderLbsStreamFeedLoader)localObject1).initFromCache((Intent)localObject2);
      ((FinderLbsStreamFeedLoader)localObject1).setInitDone((j)new a((FinderLbsStreamFeedLoader)localObject1, this));
      ((FinderLbsStreamFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new b(this));
      this.xOu = ((FinderLbsStreamFeedLoader)localObject1);
      localObject1 = this.xOt;
      if (localObject1 == null) {
        p.bGy("viewCallback");
      }
      ((b.b)localObject1).xvJ.getRecyclerView().a((RecyclerView.l)this.xOw);
      AppMethodBeat.o(281068);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(281075);
    w.b localb = this.xOt;
    if (localb == null) {
      p.bGy("viewCallback");
    }
    localb.xvJ.getRecyclerView().b((RecyclerView.l)this.xOw);
    super.onDestroy();
    AppMethodBeat.o(281075);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(281074);
    super.onPause();
    k localk = k.yBj;
    k.b(null, s.t.yGN, "16", c.yAj);
    AppMethodBeat.o(281074);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281073);
    super.onResume();
    k localk = k.yBj;
    k.b(null, s.t.yGN, "16", c.yAi);
    AppMethodBeat.o(281073);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements j
  {
    a(FinderLbsStreamFeedLoader paramFinderLbsStreamFeedLoader, FinderLbsStreamListUI paramFinderLbsStreamListUI) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(286186);
      Object localObject = FinderLbsStreamListUI.a(jdField_this).xvJ.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager");
          AppMethodBeat.o(286186);
          throw ((Throwable)localObject);
        }
        ((FinderLinearLayoutManager)localObject).au(this.xOx.getInitPos(), 0);
        AppMethodBeat.o(286186);
        return;
      }
      AppMethodBeat.o(286186);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$2"})
  static final class b
    extends q
    implements kotlin.g.a.b<IResponse<bu>, x>
  {
    b(FinderLbsStreamListUI paramFinderLbsStreamListUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(288613);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(288613);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(288612);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = k.yBj;
      k.b(paramRecyclerView, s.t.yGN, "16", c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(288612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI
 * JD-Core Version:    0.7.0.1
 */