package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.l.a;
import com.tencent.mm.plugin.finder.feed.l.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderNewUIB;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "TAG", "", "autoRefresh", "", "emptyView", "Landroid/view/View;", "feedId", "", "feedLoader", "feedNonceId", "mPresenter", "mViewCallback", "scene", "", "title", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "updateTitle", "plugin-finder_release"})
public final class FinderNewUIB
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, l.b, l.a>
{
  private final String TAG = "Finder.FinderFeedReletedTimelineUI";
  private HashMap _$_findViewCache;
  private long dtq;
  private View nYl;
  private final int scene = 2;
  private FinderFeedRelTimelineLoader sea;
  private String sew = "";
  private l.a sfn;
  private l.b sfo;
  private String title = "";
  private boolean uP;
  
  private final void updateTitle()
  {
    AppMethodBeat.i(202775);
    if (bt.isNullOrNil(this.title))
    {
      setMMTitle(2131766973);
      AppMethodBeat.o(202775);
      return;
    }
    setMMTitle(this.title);
    AppMethodBeat.o(202775);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202782);
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
    AppMethodBeat.o(202782);
    return localView1;
  }
  
  public final int cAZ()
  {
    return 40;
  }
  
  public final int cBZ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496460;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(202774);
    this.dtq = getIntent().getLongExtra("FEED_ID", 0L);
    Object localObject2 = getIntent().getStringExtra("FEED_NONCE_ID");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.sew = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("TITLE_WORDING");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    this.uP = getIntent().getBooleanExtra("AUTO_REFRESH", false);
    localObject1 = findViewById(2131299478);
    p.g(localObject1, "findViewById(R.id.empty_view)");
    this.nYl = ((View)localObject1);
    if (this.uP)
    {
      localObject1 = this.nYl;
      if (localObject1 == null) {
        p.bcb("emptyView");
      }
      ((View)localObject1).setVisibility(0);
    }
    updateTitle();
    this.sfn = new l.a((MMActivity)this, this.scene, this.uP);
    localObject1 = (MMActivity)this;
    localObject2 = this.sfn;
    if (localObject2 == null) {
      p.bcb("mPresenter");
    }
    this.sfo = new l.b((MMActivity)localObject1, (l.a)localObject2, this.scene);
    long l = this.dtq;
    localObject1 = this.sew;
    localObject2 = a.KiD;
    localObject1 = new FinderFeedRelTimelineLoader(l, (String)localObject1, 0, null, 5, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).cOu(), 8);
    if (!this.uP)
    {
      localObject2 = getIntent();
      p.g(localObject2, "intent");
      ((FinderFeedRelTimelineLoader)localObject1).initFromCache((Intent)localObject2);
    }
    ((FinderFeedRelTimelineLoader)localObject1).setInitDone((h)new a((FinderFeedRelTimelineLoader)localObject1, this));
    ((FinderFeedRelTimelineLoader)localObject1).fetchEndCallback = ((b)new b(this));
    ((FinderFeedRelTimelineLoader)localObject1).sbo = ((b)new c(this));
    this.sea = ((FinderFeedRelTimelineLoader)localObject1);
    AppMethodBeat.o(202774);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderNewUIB$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderNewUIB paramFinderNewUIB) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(202771);
      Object localObject = FinderNewUIB.a(jdField_this).rTF.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          AppMethodBeat.o(202771);
          throw ((Throwable)localObject);
        }
        ((FinderLayoutManager)localObject).ag(this.sfp.getInitPos(), 0);
        AppMethodBeat.o(202771);
        return;
      }
      AppMethodBeat.o(202771);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIB$initOnCreate$1$2"})
  static final class b
    extends q
    implements b<IResponse<al>, z>
  {
    b(FinderNewUIB paramFinderNewUIB)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIB$initOnCreate$1$3"})
  static final class c
    extends q
    implements b<IResponse<al>, z>
  {
    c(FinderNewUIB paramFinderNewUIB)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB
 * JD-Core Version:    0.7.0.1
 */