package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsStreamFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.feed.x.a;
import com.tencent.mm.plugin.finder.feed.x.b;
import com.tencent.mm.plugin.finder.live.report.d;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsStreamFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "()V", "TAG", "", "feedLoader", "onHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1;", "presenter", "saveResult", "", "scene", "", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "onDestroy", "onPause", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLbsStreamListUI
  extends FinderLoaderFeedUI<FinderLbsStreamFeedLoader, x.b, x.a>
{
  private x.a Bot;
  private x.b Bou;
  private FinderLbsStreamFeedLoader Bov;
  private boolean Bow;
  private final c Box;
  private final String TAG;
  private final int scene;
  
  public FinderLbsStreamListUI()
  {
    AppMethodBeat.i(365575);
    this.TAG = "Finder.StreamTimelineUI";
    this.scene = 2;
    this.Box = new c();
    AppMethodBeat.o(365575);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(365620);
    if (this.Bow)
    {
      Object localObject2 = this.Bou;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      RecyclerView.LayoutManager localLayoutManager = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if ((localLayoutManager instanceof LinearLayoutManager))
      {
        localObject1 = av.GiL;
        localObject2 = this.Bov;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("feedLoader");
          localObject1 = null;
        }
        setResult(-1, av.a((BaseFinderFeedLoader)localObject1, (LinearLayoutManager)localLayoutManager));
      }
    }
    super.finish();
    AppMethodBeat.o(365620);
  }
  
  public final int getCommentScene()
  {
    return 16;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_lbs_stream_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365594);
    Object localObject1 = getIntent().getStringExtra("KEY_UI_TITLE");
    if (localObject1 == null)
    {
      localObject1 = (CharSequence)"";
      setTitle((CharSequence)localObject1);
      setMMTitle(getTitle());
      this.Bow = getIntent().getBooleanExtra("KEY_SAVE_RESULT", false);
      this.Bot = new x.a((MMActivity)this, this.scene, (byte)0);
      MMActivity localMMActivity = (MMActivity)this;
      Object localObject3 = this.Bot;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      this.Bou = new x.b(localMMActivity, (x.a)localObject1, this.scene);
      localObject1 = z.bAW();
      s.s(localObject1, "getMyFinderUsername()");
      localObject3 = k.aeZF;
      localObject1 = new FinderLbsStreamFeedLoader((String)localObject1, ((as)k.d((AppCompatActivity)this).q(as.class)).fou());
      localObject3 = getIntent();
      s.s(localObject3, "intent");
      ((FinderLbsStreamFeedLoader)localObject1).initFromCache((Intent)localObject3);
      ((FinderLbsStreamFeedLoader)localObject1).setInitDone((j)new a(this, (FinderLbsStreamFeedLoader)localObject1));
      ((FinderLbsStreamFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new b(this));
      localObject3 = ah.aiuX;
      this.Bov = ((FinderLbsStreamFeedLoader)localObject1);
      localObject1 = this.Bou;
      if (localObject1 != null) {
        break label260;
      }
      s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    label260:
    for (;;)
    {
      ((b.b)localObject1).ATx.getRecyclerView().a((RecyclerView.l)this.Box);
      AppMethodBeat.o(365594);
      return;
      localObject1 = (CharSequence)localObject1;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365647);
    x.b localb2 = this.Bou;
    x.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("viewCallback");
      localb1 = null;
    }
    localb1.ATx.getRecyclerView().b((RecyclerView.l)this.Box);
    super.onDestroy();
    AppMethodBeat.o(365647);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(365638);
    super.onPause();
    ((ce)h.ax(ce.class)).b(null, q.w.DwP, "16", d.Dng);
    AppMethodBeat.o(365638);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365629);
    super.onResume();
    ((ce)h.ax(ce.class)).b(null, q.w.DwP, "16", d.Dnf);
    AppMethodBeat.o(365629);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements j
  {
    a(FinderLbsStreamListUI paramFinderLbsStreamListUI, FinderLbsStreamFeedLoader paramFinderLbsStreamFeedLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(364427);
      Object localObject2 = FinderLbsStreamListUI.a(this.Boy);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject2 = this.Boz;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderLbsStreamFeedLoader)localObject2).getInitPos(), 0);
      }
      AppMethodBeat.o(364427);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    b(FinderLbsStreamListUI paramFinderLbsStreamListUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(364460);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(364460);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(364453);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)h.ax(ce.class)).b(paramRecyclerView, q.w.DwP, "16", d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLbsStreamListUI$onHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(364453);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLbsStreamListUI
 * JD-Core Version:    0.7.0.1
 */