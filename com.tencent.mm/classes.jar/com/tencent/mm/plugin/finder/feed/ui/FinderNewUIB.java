package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.l.a;
import com.tencent.mm.plugin.finder.feed.l.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderNewUIB;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "TAG", "", "autoRefresh", "", "emptyView", "Landroid/view/View;", "feedId", "", "feedLoader", "feedNonceId", "getRelScene", "", "isCanLoadMore", "jumpHotTabTip", "mPresenter", "mViewCallback", "scene", "title", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "initOnCreate", "", "updateTitle", "plugin-finder_release"})
public final class FinderNewUIB
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, l.b, l.a>
{
  private final String TAG = "Finder.FinderFeedReletedTimelineUI";
  private HashMap _$_findViewCache;
  private long duw;
  private View odU;
  private final int scene = 2;
  private FinderFeedRelTimelineLoader smQ;
  private String snl = "";
  private l.a soc;
  private l.b sod;
  private int soe;
  private boolean sof;
  private String sog = "";
  private String title = "";
  private boolean uP;
  
  private final void updateTitle()
  {
    AppMethodBeat.i(203254);
    if (bu.isNullOrNil(this.title))
    {
      setMMTitle(2131766973);
      AppMethodBeat.o(203254);
      return;
    }
    setMMTitle(this.title);
    AppMethodBeat.o(203254);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203261);
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
    AppMethodBeat.o(203261);
    return localView1;
  }
  
  public final int cCL()
  {
    return 40;
  }
  
  public final int cDL()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131496460;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(203253);
    this.soe = getIntent().getIntExtra("GET_REL_SCENE", 0);
    this.duw = getIntent().getLongExtra("FEED_ID", 0L);
    Object localObject2 = getIntent().getStringExtra("FEED_NONCE_ID");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.snl = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("TITLE_WORDING");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    this.uP = getIntent().getBooleanExtra("AUTO_REFRESH", false);
    this.sof = getIntent().getBooleanExtra("CAN_LOAD_MORE", true);
    localObject2 = getIntent().getStringExtra("NO_MORE_JUMP_HOT_TITLE");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.sog = ((String)localObject1);
    localObject1 = findViewById(2131299478);
    p.g(localObject1, "findViewById(R.id.empty_view)");
    this.odU = ((View)localObject1);
    if (this.uP)
    {
      localObject1 = this.odU;
      if (localObject1 == null) {
        p.bdF("emptyView");
      }
      ((View)localObject1).setVisibility(0);
    }
    updateTitle();
    this.soc = new l.a((MMActivity)this, this.scene, this.uP);
    localObject1 = (MMActivity)this;
    localObject2 = this.soc;
    if (localObject2 == null) {
      p.bdF("mPresenter");
    }
    this.sod = ((l.b)new d(this, (MMActivity)localObject1, (l.a)localObject2, this.scene));
    long l = this.duw;
    localObject1 = this.snl;
    boolean bool = this.sof;
    localObject2 = a.KEX;
    localObject1 = new FinderFeedRelTimelineLoader(l, (String)localObject1, 0, null, 5, bool, ((FinderReporterUIC)a.s((MMActivity)this).get(FinderReporterUIC.class)).cQZ(), 8);
    if (!this.uP)
    {
      localObject2 = getIntent();
      p.g(localObject2, "intent");
      ((FinderFeedRelTimelineLoader)localObject1).initFromCache((Intent)localObject2);
    }
    ((FinderFeedRelTimelineLoader)localObject1).setInitDone((h)new a((FinderFeedRelTimelineLoader)localObject1, this));
    ((FinderFeedRelTimelineLoader)localObject1).fetchEndCallback = ((b)new b(this));
    ((FinderFeedRelTimelineLoader)localObject1).skd = ((b)new c(this));
    this.smQ = ((FinderFeedRelTimelineLoader)localObject1);
    AppMethodBeat.o(203253);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderNewUIB$initOnCreate$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
  public static final class a
    implements h
  {
    a(FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader, FinderNewUIB paramFinderNewUIB) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(203248);
      Object localObject = FinderNewUIB.b(jdField_this).scj.getRecyclerView().getLayoutManager();
      if (localObject != null)
      {
        if (localObject == null)
        {
          localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager");
          AppMethodBeat.o(203248);
          throw ((Throwable)localObject);
        }
        ((FinderLayoutManager)localObject).ag(this.soh.getInitPos(), 0);
      }
      if (!FinderNewUIB.a(jdField_this)) {
        RefreshLoadMoreLayout.f(FinderNewUIB.b(jdField_this).scj);
      }
      AppMethodBeat.o(203248);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIB$initOnCreate$2$2"})
  static final class b
    extends q
    implements b<IResponse<am>, d.z>
  {
    b(FinderNewUIB paramFinderNewUIB)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderNewUIB$initOnCreate$2$3"})
  static final class c
    extends q
    implements b<IResponse<am>, d.z>
  {
    c(FinderNewUIB paramFinderNewUIB)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderNewUIB$initOnCreate$1", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "getLoadMoreFooter", "Landroid/view/View;", "plugin-finder_release"})
  public static final class d
    extends l.b
  {
    d(MMActivity paramMMActivity, l.a parama, int paramInt1, int paramInt2)
    {
      super(paramInt1, paramInt2);
    }
    
    public final View getLoadMoreFooter()
    {
      AppMethodBeat.i(203252);
      if (!FinderNewUIB.a(this.soi))
      {
        localView = com.tencent.mm.ui.z.jV((Context)this.fNT).inflate(2131496527, (ViewGroup)this.scj, false);
        localView.setOnClickListener((View.OnClickListener)new FinderNewUIB.d.a(this));
        p.g(localView, "footer");
        AppMethodBeat.o(203252);
        return localView;
      }
      View localView = super.getLoadMoreFooter();
      AppMethodBeat.o(203252);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderNewUIB
 * JD-Core Version:    0.7.0.1
 */