package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.a;
import com.tencent.mm.plugin.expt.hellhound.ext.session.a.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.m.a;
import com.tencent.mm.plugin.finder.feed.m.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.r;
import kotlin.v;
import org.apache.commons.c.i;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedRelatedTimelineContract$Presenter;", "()V", "TAG", "", "autoRefresh", "", "emptyView", "Landroid/view/View;", "feedId", "", "feedLoader", "feedNonceId", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1;", "mPresenter", "mViewCallback", "relatedScene", "", "getRelatedScene", "()I", "relatedScene$delegate", "Lkotlin/Lazy;", "scene", "timestampOnCreate", "title", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewCallback", "goBack", "", "initOnCreate", "onBackPressed", "onDestroy", "onPause", "onResume", "updateTitle", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFeedRelatedTimelineUI
  extends FinderLoaderFeedUI<FinderFeedRelTimelineLoader, m.b, m.a>
{
  private long BkT;
  private final kotlin.j BmA;
  private final d BmB;
  private FinderFeedRelTimelineLoader Bmv;
  private m.a Bmx;
  private m.b Bmy;
  private String Bmz;
  private final String TAG;
  private boolean dyt;
  private long feedId;
  private final int scene;
  private String title;
  private View vDA;
  
  public FinderFeedRelatedTimelineUI()
  {
    AppMethodBeat.i(364510);
    this.TAG = "Finder.FinderFeedReletedTimelineUI";
    this.scene = 2;
    this.Bmz = "";
    this.title = "";
    this.BmA = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.BmB = new d(this);
    AppMethodBeat.o(364510);
  }
  
  private static final Map a(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI, String paramString)
  {
    Object localObject2 = null;
    AppMethodBeat.i(364563);
    kotlin.g.b.s.u(paramFinderFeedRelatedTimelineUI, "this$0");
    paramString = paramFinderFeedRelatedTimelineUI.getIntent();
    if (paramString == null)
    {
      paramString = null;
      paramString = String.valueOf(paramString);
      if (!i.hm(paramString)) {
        break label208;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW();
    }
    label208:
    for (;;)
    {
      String str = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
      Object localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr1 = v.Y("session_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      r localr2 = v.Y("finder_context_id", localObject1);
      str = com.tencent.mm.plugin.expt.hellhound.core.b.dIX();
      localObject1 = str;
      if (str == null) {
        localObject1 = "";
      }
      localObject1 = v.Y("finder_tab_context_id", localObject1);
      paramString = v.Y("extra_info", paramString);
      paramFinderFeedRelatedTimelineUI = paramFinderFeedRelatedTimelineUI.getIntent();
      if (paramFinderFeedRelatedTimelineUI == null) {}
      for (paramFinderFeedRelatedTimelineUI = localObject2;; paramFinderFeedRelatedTimelineUI = paramFinderFeedRelatedTimelineUI.getStringExtra("key_enter_source_info"))
      {
        paramFinderFeedRelatedTimelineUI = ak.e(new r[] { localr1, localr2, localObject1, paramString, v.Y("enter_source_info", String.valueOf(paramFinderFeedRelatedTimelineUI)) });
        AppMethodBeat.o(364563);
        return paramFinderFeedRelatedTimelineUI;
        paramString = paramString.getStringExtra("key_extra_info");
        break;
      }
    }
  }
  
  private static final boolean a(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364553);
    kotlin.g.b.s.u(paramFinderFeedRelatedTimelineUI, "this$0");
    paramFinderFeedRelatedTimelineUI.goBack();
    AppMethodBeat.o(364553);
    return true;
  }
  
  private final void aMl()
  {
    AppMethodBeat.i(364544);
    setMMTitle(this.title);
    AppMethodBeat.o(364544);
  }
  
  private final int eeJ()
  {
    AppMethodBeat.i(364519);
    int i = ((Number)this.BmA.getValue()).intValue();
    AppMethodBeat.o(364519);
    return i;
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(364537);
    finish();
    Object localObject1;
    String str1;
    String str2;
    long l1;
    long l2;
    long l3;
    long l4;
    Object localObject2;
    String str3;
    int i;
    Object localObject3;
    if (24 == eeJ())
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      str1 = c.dLD().dHN();
      str2 = getClass().getSimpleName();
      l1 = System.currentTimeMillis();
      l2 = this.BkT;
      l3 = this.BkT;
      l4 = System.currentTimeMillis();
      localObject2 = this.Bmv;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("feedLoader");
        localObject1 = null;
      }
      localObject1 = ((FinderFeedRelTimelineLoader)localObject1).getContextObj();
      if (localObject1 != null) {
        break label204;
      }
      localObject1 = "";
      str3 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      i = c.b.zHc.value;
      localObject3 = this.Bmv;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("feedLoader");
        localObject2 = null;
      }
      localObject2 = ((FinderFeedRelTimelineLoader)localObject2).getContextObj();
      if (localObject2 != null) {
        break label227;
      }
      localObject2 = "";
    }
    for (;;)
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      a.a.a(new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(str1, str2, l1 - l2, l3, l4, (String)localObject1, str3, i, com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW(), (String)localObject2, 1280));
      AppMethodBeat.o(364537);
      return;
      label204:
      localObject2 = ((bui)localObject1).zIB;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label227:
      localObject3 = ((bui)localObject2).zIO;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 2;
  }
  
  public final int getCommentScene()
  {
    AppMethodBeat.i(364654);
    if (17 == eeJ())
    {
      AppMethodBeat.o(364654);
      return 96;
    }
    if (24 == eeJ())
    {
      AppMethodBeat.o(364654);
      return 116;
    }
    AppMethodBeat.o(364654);
    return 40;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_feed_related_timeline_ui;
  }
  
  public final void initOnCreate()
  {
    AppMethodBeat.i(364632);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    Object localObject2 = getIntent().getStringExtra("FEED_NONCE_ID");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.Bmz = ((String)localObject1);
    localObject2 = getIntent().getStringExtra("TITLE_WORDING");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    this.title = ((String)localObject1);
    this.dyt = getIntent().getBooleanExtra("AUTO_REFRESH", false);
    float f1 = getIntent().getFloatExtra("POI_LATITUDE", 0.0F);
    float f2 = getIntent().getFloatExtra("POI_LONGITUDE", 0.0F);
    localObject1 = findViewById(e.e.emptyView);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.emptyView)");
    this.vDA = ((View)localObject1);
    if (this.dyt)
    {
      localObject2 = this.vDA;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("emptyView");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(0);
    }
    aMl();
    this.Bmx = new m.a((MMActivity)this, this.scene, this.dyt);
    Object localObject3 = (MMActivity)this;
    localObject2 = this.Bmx;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mPresenter");
      localObject1 = null;
    }
    this.Bmy = new m.b((MMActivity)localObject3, (m.a)localObject1, this.scene, getCommentScene());
    long l = this.feedId;
    localObject1 = this.Bmz;
    int i = eeJ();
    localObject2 = com.tencent.mm.ui.component.k.aeZF;
    localObject2 = new FinderFeedRelTimelineLoader(l, (String)localObject1, 0, null, i, false, null, null, null, 0, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(as.class)).fou(), f1, f2, 4072);
    if (!this.dyt)
    {
      localObject1 = getIntent();
      kotlin.g.b.s.s(localObject1, "intent");
      ((FinderFeedRelTimelineLoader)localObject2).initFromCache((Intent)localObject1);
      if (17 == eeJ())
      {
        localObject1 = ((FinderFeedRelTimelineLoader)localObject2).getCache();
        if (localObject1 == null) {
          break label696;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).pUj;
        if (localObject1 == null) {
          break label696;
        }
        if (((Collection)localObject1).isEmpty()) {
          break label691;
        }
        i = 1;
        if (i != 1) {
          break label696;
        }
        i = 1;
        label412:
        if (i != 0)
        {
          localObject1 = ((FinderFeedRelTimelineLoader)localObject2).getCache();
          if (localObject1 != null) {
            break label701;
          }
          localObject1 = null;
          label431:
          if (!(localObject1 instanceof BaseFinderFeed)) {
            break label733;
          }
        }
      }
    }
    label691:
    label696:
    label701:
    label733:
    for (localObject1 = (BaseFinderFeed)localObject1;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = ((BaseFinderFeed)localObject1).feedObject.getFeedObject();
        localObject3 = z.FrZ;
        z.a((FinderObject)localObject1, getCommentScene());
      }
      ((FinderFeedRelTimelineLoader)localObject2).setInitDone((com.tencent.mm.plugin.finder.feed.model.internal.j)new a(this, (FinderFeedRelTimelineLoader)localObject2));
      ((FinderFeedRelTimelineLoader)localObject2).fetchEndCallback = ((kotlin.g.a.b)new b(this));
      ((FinderFeedRelTimelineLoader)localObject2).BfX = ((kotlin.g.a.b)new c(this));
      localObject1 = ah.aiuX;
      this.Bmv = ((FinderFeedRelTimelineLoader)localObject2);
      localObject2 = this.Bmy;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewCallback");
        localObject1 = null;
      }
      ((b.b)localObject1).ATx.getRecyclerView().a((RecyclerView.l)this.BmB);
      if (24 == eeJ()) {
        this.BkT = System.currentTimeMillis();
      }
      setBackBtn(new FinderFeedRelatedTimelineUI..ExternalSyntheticLambda0(this));
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, com.tencent.mm.plugin.datareport.a.a.a.xgz);
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).g(this, getClass().getSimpleName());
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).eE(this);
      ((com.tencent.mm.plugin.datareport.a.b)h.ax(com.tencent.mm.plugin.datareport.a.b.class)).a(this, new FinderFeedRelatedTimelineUI..ExternalSyntheticLambda1(this));
      AppMethodBeat.o(364632);
      return;
      i = 0;
      break;
      i = 0;
      break label412;
      localObject1 = ((com.tencent.mm.plugin.finder.feed.model.s)localObject1).pUj;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label431;
      }
      localObject1 = (cc)((ArrayList)localObject1).get(0);
      break label431;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(364640);
    super.onBackPressed();
    goBack();
    AppMethodBeat.o(364640);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364665);
    m.b localb2 = this.Bmy;
    m.b localb1 = localb2;
    if (localb2 == null)
    {
      kotlin.g.b.s.bIx("mViewCallback");
      localb1 = null;
    }
    localb1.ATx.getRecyclerView().b((RecyclerView.l)this.BmB);
    super.onDestroy();
    AppMethodBeat.o(364665);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(364678);
    super.onPause();
    if (17 == eeJ())
    {
      AppMethodBeat.o(364678);
      return;
    }
    Object localObject3 = (ce)h.ax(ce.class);
    Object localObject2 = this.Bmy;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mViewCallback");
      localObject1 = null;
    }
    ((ce)localObject3).b(((b.b)localObject1).ATx.getRecyclerView(), q.w.DwQ, "40", com.tencent.mm.plugin.finder.live.report.d.Dng);
    String str1;
    String str2;
    long l1;
    long l2;
    long l3;
    long l4;
    String str3;
    int i;
    if (24 == eeJ())
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      str1 = c.dLD().dHN();
      str2 = getClass().getSimpleName();
      l1 = System.currentTimeMillis();
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      l2 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.dKU();
      localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      l3 = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.dKU();
      l4 = System.currentTimeMillis();
      localObject2 = this.Bmv;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("feedLoader");
        localObject1 = null;
      }
      localObject1 = ((FinderFeedRelTimelineLoader)localObject1).getContextObj();
      if (localObject1 != null) {
        break label287;
      }
      localObject1 = "";
      str3 = com.tencent.mm.plugin.expt.hellhound.ext.session.b.dLx().dLz();
      i = c.b.zHb.value;
      localObject3 = this.Bmv;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("feedLoader");
        localObject2 = null;
      }
      localObject2 = ((FinderFeedRelTimelineLoader)localObject2).getContextObj();
      if (localObject2 != null) {
        break label310;
      }
      localObject2 = "";
    }
    for (;;)
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.zIX;
      a.a.a(new com.tencent.mm.plugin.expt.hellhound.ext.b.c.b(str1, str2, l1 - l2, l3, l4, (String)localObject1, str3, i, com.tencent.mm.plugin.expt.hellhound.ext.b.d.d.dKW(), (String)localObject2, 1280));
      AppMethodBeat.o(364678);
      return;
      label287:
      localObject2 = ((bui)localObject1).zIB;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label310:
      localObject3 = ((bui)localObject2).zIO;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364671);
    super.onResume();
    if (17 == eeJ())
    {
      AppMethodBeat.o(364671);
      return;
    }
    ce localce = (ce)h.ax(ce.class);
    m.b localb = this.Bmy;
    Object localObject = localb;
    if (localb == null)
    {
      kotlin.g.b.s.bIx("mViewCallback");
      localObject = null;
    }
    localce.b(((b.b)localObject).ATx.getRecyclerView(), q.w.DwQ, "40", com.tencent.mm.plugin.finder.live.report.d.Dnf);
    if (24 == eeJ())
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.zIv;
      com.tencent.mm.plugin.expt.hellhound.ext.b.c.a.lY(System.currentTimeMillis());
    }
    AppMethodBeat.o(364671);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$initOnCreate$1$2", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.plugin.finder.feed.model.internal.j
  {
    a(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI, FinderFeedRelTimelineLoader paramFinderFeedRelTimelineLoader) {}
    
    public final void call(int paramInt)
    {
      AppMethodBeat.i(365382);
      Object localObject2 = FinderFeedRelatedTimelineUI.a(this.BmC);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewCallback");
        localObject1 = null;
      }
      localObject1 = ((b.b)localObject1).ATx.getRecyclerView().getLayoutManager();
      if (localObject1 != null)
      {
        localObject2 = this.BmD;
        ((FinderLinearLayoutManager)localObject1).bo(((FinderFeedRelTimelineLoader)localObject2).getInitPos(), 0);
      }
      AppMethodBeat.o(365382);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    b(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<IResponse<cc>, ah>
  {
    c(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(FinderFeedRelatedTimelineUI paramFinderFeedRelatedTimelineUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(365318);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(365318);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(365309);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      if (17 == FinderFeedRelatedTimelineUI.d(this.BmC))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(365309);
        return;
      }
      ((ce)h.ax(ce.class)).b(paramRecyclerView, q.w.DwQ, "40", com.tencent.mm.plugin.finder.live.report.d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFeedRelatedTimelineUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(365309);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
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