package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Resources;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.h.a;
import com.tencent.mm.plugin.finder.feed.h.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.ae;
import com.tencent.mm.plugin.finder.viewmodel.component.ag;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.az;
import com.tencent.mm.plugin.finder.viewmodel.component.c;
import com.tencent.mm.plugin.finder.viewmodel.component.f;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavTimelineContract$Presenter;", "()V", "TAG", "", "feedLoader", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1;", "presenter", "scene", "", "viewCallback", "finish", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "loadJumpInfoOnInit", "feedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onDestroy", "onPause", "onResume", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFavTimelineUI
  extends FinderLoaderFeedUI<FinderFavFeedLoader, h.b, h.a>
{
  private h.a Bmn;
  private h.b Bmo;
  private FinderFavFeedLoader Bmp;
  private final c Bmq;
  private final String TAG;
  private final int scene;
  
  public FinderFavTimelineUI()
  {
    AppMethodBeat.i(365242);
    this.TAG = "Finder.FinderFavTimelineUI";
    this.scene = 2;
    this.Bmq = new c();
    AppMethodBeat.o(365242);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(365302);
    Object localObject2 = this.Bmo;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("viewCallback");
      localObject1 = null;
    }
    RecyclerView.LayoutManager localLayoutManager = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
    if ((localLayoutManager instanceof LinearLayoutManager))
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.av.GiL;
      localObject2 = this.Bmp;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("feedLoader");
        localObject1 = null;
      }
      setResult(-1, com.tencent.mm.plugin.finder.utils.av.a((BaseFinderFeedLoader)localObject1, (LinearLayoutManager)localLayoutManager));
    }
    super.finish();
    AppMethodBeat.o(365302);
  }
  
  public final int getCommentScene()
  {
    return 21;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_fav_timeline_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(365261);
    Set localSet = ar.setOf(new Class[] { az.class, com.tencent.mm.plugin.finder.viewmodel.teenmode.b.class, ag.class, ae.class, com.tencent.mm.plugin.finder.viewmodel.component.av.class, f.class, c.class });
    AppMethodBeat.o(365261);
    return localSet;
  }
  
  public final void initOnCreate()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365275);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXJ().bmg()).intValue() == 0)
    {
      setMMTitle(getContext().getResources().getString(e.h.finder_fav_list_title));
      this.Bmn = new h.a((MMActivity)this, this.scene);
      MMActivity localMMActivity = (MMActivity)this;
      Object localObject3 = this.Bmn;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("presenter");
        localObject1 = null;
      }
      this.Bmo = new h.b(localMMActivity, (h.a)localObject1, this.scene);
      localObject1 = z.bAW();
      s.s(localObject1, "getMyFinderUsername()");
      localObject3 = k.aeZF;
      localObject1 = new FinderFavFeedLoader((String)localObject1, ((as)k.d((AppCompatActivity)this).q(as.class)).fou(), true);
      localObject3 = getIntent();
      s.s(localObject3, "intent");
      ((FinderFavFeedLoader)localObject1).initFromCache((Intent)localObject3);
      ((FinderFavFeedLoader)localObject1).BfA = getIntent().getLongExtra("key_active_topic_id", 0L);
      ((FinderFavFeedLoader)localObject1).setInitDone((j)new a(this, (FinderFavFeedLoader)localObject1));
      ((FinderFavFeedLoader)localObject1).fetchEndCallback = ((kotlin.g.a.b)new b(this));
      localObject3 = ah.aiuX;
      this.Bmp = ((FinderFavFeedLoader)localObject1);
      localObject1 = this.Bmo;
      if (localObject1 != null) {
        break label302;
      }
      s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    label302:
    for (;;)
    {
      ((b.b)localObject1).ATx.getRecyclerView().a((RecyclerView.l)this.Bmq);
      ((WeImageView)findViewById(e.e.backBtnIv)).setIconColor(getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_5));
      AppMethodBeat.o(365275);
      return;
      setMMTitle(getContext().getResources().getString(e.h.finder_fav_list_title2));
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365324);
    h.b localb2 = this.Bmo;
    h.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("viewCallback");
      localb1 = null;
    }
    localb1.ATx.getRecyclerView().b((RecyclerView.l)this.Bmq);
    super.onDestroy();
    AppMethodBeat.o(365324);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(365319);
    super.onPause();
    ce localce = (ce)h.ax(ce.class);
    h.b localb2 = this.Bmo;
    h.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("viewCallback");
      localb1 = null;
    }
    localce.b(localb1.ATx.getRecyclerView(), q.w.DwQ, "21", com.tencent.mm.plugin.finder.live.report.d.Dng);
    AppMethodBeat.o(365319);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365310);
    super.onResume();
    ce localce = (ce)h.ax(ce.class);
    h.b localb2 = this.Bmo;
    h.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("viewCallback");
      localb1 = null;
    }
    localce.b(localb1.ATx.getRecyclerView(), q.w.DwQ, "21", com.tencent.mm.plugin.finder.live.report.d.Dnf);
    AppMethodBeat.o(365310);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements j
  {
    a(FinderFavTimelineUI paramFinderFavTimelineUI, FinderFavFeedLoader paramFinderFavFeedLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(364862);
      Object localObject2 = FinderFavTimelineUI.a(this.Bmr);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject2 = this.Bms;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderFavFeedLoader)localObject2).getInitPos(), 0);
      }
      FinderFavTimelineUI.gh((List)this.Bms.getDataList());
      AppMethodBeat.o(364862);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    b(FinderFavTimelineUI paramFinderFavTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(364884);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(364884);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(364879);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)h.ax(ce.class)).b(paramRecyclerView, q.w.DwQ, "21", com.tencent.mm.plugin.finder.live.report.d.Dne);
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFavTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(364879);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFavTimelineUI
 * JD-Core Version:    0.7.0.1
 */