package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.feed.a.b;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.q.a;
import com.tencent.mm.plugin.finder.feed.q.b;
import com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.f;
import d.g.a.m;
import d.g.b.u;
import d.g.b.v.e;
import d.g.b.w;
import d.y;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCacheFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCacheFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "setCommentPreloader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;)V", "distance", "", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "fromUser", "getFromUser", "setFromUser", "(Ljava/lang/String;)V", "isShareClickReport", "", "loader", "moreTipsLayout", "Landroid/view/View;", "parentBottom", "getParentBottom", "()I", "parentBottom$delegate", "Lkotlin/Lazy;", "presenter", "reportScene", "getReportScene", "setReportScene", "(I)V", "scene", "getScene", "setScene", "showFinderEntry", "tabType", "getTabType", "setTabType", "tipsLayout", "viewCallback", "checkBottomTips", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewBottomInWindow", "view", "getViewCallback", "initData", "initOnCreate", "initTipsLayout", "onDestroy", "showProgress", "ifShow", "showRetryTips", "plugin-finder_release"})
public final class FinderShareFeedRelUI
  extends FinderLoaderFeedUI<com.tencent.mm.plugin.finder.feed.model.g, q.b, n>
{
  private int IoU;
  private boolean KZN;
  private n KZO;
  private q.b KZP;
  private com.tencent.mm.plugin.finder.feed.model.g KZQ;
  private BaseFinderFeed KZR;
  private View KZS;
  private final f KZT;
  private int KZU;
  private final String TAG;
  private HashMap _$_findViewCache;
  String dpv;
  private long feedId;
  int pOf;
  private boolean qQh;
  private View qQj;
  com.tencent.mm.plugin.finder.feed.model.e qvy;
  private int scene;
  
  static
  {
    AppMethodBeat.i(199453);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(FinderShareFeedRelUI.class), "parentBottom", "getParentBottom()I")) };
    AppMethodBeat.o(199453);
  }
  
  public FinderShareFeedRelUI()
  {
    AppMethodBeat.i(199464);
    this.TAG = "Finder.FinderShareFeedRelUI";
    this.scene = 2;
    this.dpv = "";
    this.qvy = new com.tencent.mm.plugin.finder.feed.model.e((MMActivity)this);
    this.qQh = ((j)com.tencent.mm.kernel.g.ad(j.class)).showFinderEntry();
    this.KZT = d.g.E((d.g.a.a)new g(this));
    AppMethodBeat.o(199464);
  }
  
  private final int fVG()
  {
    AppMethodBeat.i(199454);
    int i = ((Number)this.KZT.getValue()).intValue();
    AppMethodBeat.o(199454);
    return i;
  }
  
  private static int gP(View paramView)
  {
    AppMethodBeat.i(199458);
    if (paramView.getHeight() <= 0)
    {
      AppMethodBeat.o(199458);
      return 0;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = arrayOfInt[1];
    int j = paramView.getHeight();
    AppMethodBeat.o(199458);
    return i + j;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199470);
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
    AppMethodBeat.o(199470);
    return localView1;
  }
  
  public final int fTB()
  {
    return 2;
  }
  
  public final void fVH()
  {
    AppMethodBeat.i(199457);
    Object localObject1 = this.KZS;
    if (localObject1 == null) {
      d.g.b.k.aPZ("moreTipsLayout");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = this.KZQ;
    if (localObject1 == null) {
      d.g.b.k.aPZ("loader");
    }
    if (((com.tencent.mm.plugin.finder.feed.model.g)localObject1).getDataListJustForAdapter().size() < 2)
    {
      AppMethodBeat.o(199457);
      return;
    }
    localObject1 = this.KZP;
    if (localObject1 == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    Object localObject2 = ((a.b)localObject1).quj.getRecyclerView().cj(0);
    localObject1 = this.KZP;
    if (localObject1 == null) {
      d.g.b.k.aPZ("viewCallback");
    }
    localObject1 = ((a.b)localObject1).quj.getRecyclerView().cj(1);
    if (localObject2 != null)
    {
      localObject2 = ((RecyclerView.v)localObject2).arI;
      d.g.b.k.g(localObject2, "firstItemView.itemView");
      int i = gP((View)localObject2);
      if ((fVG() > 0) && (fVG() - i < this.KZU))
      {
        localObject2 = this.KZS;
        if (localObject2 == null) {
          d.g.b.k.aPZ("moreTipsLayout");
        }
        ((View)localObject2).setVisibility(0);
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView.v)localObject1).arI;
          d.g.b.k.g(localObject1, "secondItemView.itemView");
          ((View)localObject1).setVisibility(4);
        }
        AppMethodBeat.o(199457);
        return;
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.v)localObject1).arI;
      d.g.b.k.g(localObject1, "secondItemView.itemView");
      ((View)localObject1).setVisibility(0);
    }
    AppMethodBeat.o(199457);
  }
  
  public final int getCommentScene()
  {
    return 25;
  }
  
  public final int getLayoutId()
  {
    return 2131494111;
  }
  
  public final void initOnCreate()
  {
    boolean bool = true;
    AppMethodBeat.i(199460);
    this.feedId = getIntent().getLongExtra("feed_object_id", 0L);
    final v.e locale = new v.e();
    Object localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    locale.Jhw = localObject1;
    this.pOf = getIntent().getIntExtra("report_scene", 0);
    this.dpv = getIntent().getStringExtra("from_user");
    this.IoU = getIntent().getIntExtra("tab_type", 0);
    if (this.feedId == 0L)
    {
      ad.w(this.TAG, "objectId 0, finish");
      finish();
    }
    localObject1 = findViewById(2131304742);
    d.g.b.k.g(localObject1, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.qQj = ((View)localObject1);
    localObject1 = findViewById(2131307784);
    d.g.b.k.g(localObject1, "findViewById(R.id.more_similar_feed_tip_layout)");
    this.KZS = ((View)localObject1);
    localObject1 = this.KZS;
    if (localObject1 == null) {
      d.g.b.k.aPZ("moreTipsLayout");
    }
    localObject1 = (TextView)((View)localObject1).findViewById(2131307369);
    d.g.b.k.g(localObject1, "tipsTv");
    ai.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = this.KZS;
    if (localObject1 == null) {
      d.g.b.k.aPZ("moreTipsLayout");
    }
    localObject1 = ((View)localObject1).findViewById(2131307782);
    int i;
    if (ai.Eq())
    {
      ((View)localObject1).setBackgroundResource(2131234879);
      localObject1 = this.KZS;
      if (localObject1 == null) {
        d.g.b.k.aPZ("moreTipsLayout");
      }
      ((View)localObject1).findViewById(2131307783).setOnClickListener((View.OnClickListener)f.KZY);
      this.KZU = com.tencent.mm.cd.a.fromDPToPix((Context)this, 104);
      if (this.feedId != 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.b.qKl;
        localObject1 = com.tencent.mm.plugin.finder.storage.data.b.a.qC(this.feedId);
        if (localObject1 != null)
        {
          ad.i(this.TAG, "use cache cacheTime=" + h.formatTime("yyyy-MM-dd HH:mm:ss", ((FinderItem)localObject1).getTimestamps() / 1000L) + ", cacheTime=" + ((FinderItem)localObject1).getTimestamps() + ' ' + "current=" + h.formatTime("yyyy-MM-dd HH:mm:ss", ce.asS() / 1000L) + ", urlValidDuration=" + ((FinderItem)localObject1).getFeedObject().urlValidDuration + 's');
          if ((((FinderItem)localObject1).getTimestamps() <= 0L) || (ce.asS() < ((FinderItem)localObject1).getTimestamps() + ((FinderItem)localObject1).getFeedObject().urlValidDuration * 1000L))
          {
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
            this.KZR = com.tencent.mm.plugin.finder.storage.logic.b.a.h((FinderItem)localObject1);
          }
        }
      }
      if (this.KZR == null)
      {
        ad.d(this.TAG, "cache null.show progress");
        kV(true);
      }
      i = this.scene;
      localObject1 = (MMActivity)this;
      if (this.qQh) {
        break label876;
      }
    }
    for (;;)
    {
      localObject1 = new n(i, (MMActivity)localObject1, bool);
      ((q.a)localObject1).objectId = this.feedId;
      localObject2 = (String)locale.Jhw;
      d.g.b.k.h(localObject2, "<set-?>");
      ((q.a)localObject1).objectNonceId = ((String)localObject2);
      ((q.a)localObject1).qHv = this.KZR;
      ((q.a)localObject1).KNg = ((m)new a((n)localObject1, this, locale));
      ((q.a)localObject1).KNh = ((d.g.a.b)new b((n)localObject1, this, locale));
      this.KZO = ((n)localObject1);
      localObject1 = (MMActivity)this;
      localObject2 = this.KZO;
      if (localObject2 == null) {
        d.g.b.k.aPZ("presenter");
      }
      this.KZP = new q.b((MMActivity)localObject1, (q.a)localObject2, this.scene);
      long l = this.feedId;
      i = this.IoU;
      localObject1 = com.tencent.mm.ui.component.a.LCX;
      localObject1 = new com.tencent.mm.plugin.finder.feed.model.g(l, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class)).fXs());
      ((com.tencent.mm.plugin.finder.feed.model.g)localObject1).KPL = ((d.g.a.b)new c(this));
      this.KZQ = ((com.tencent.mm.plugin.finder.feed.model.g)localObject1);
      if (this.pOf != 0) {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(1278L, 14L, 1L, false);
      }
      setMMTitle(2131759376);
      localObject1 = this.KZP;
      if (localObject1 == null) {
        d.g.b.k.aPZ("viewCallback");
      }
      ((a.b)localObject1).quj.getRecyclerView().a((RecyclerView.m)new d(this));
      localObject1 = this.KZO;
      if (localObject1 == null) {
        d.g.b.k.aPZ("presenter");
      }
      ((n)localObject1).Lac = ((d.g.a.b)new e(this));
      this.qvy.a(this.scene, 25, null);
      AppMethodBeat.o(199460);
      return;
      ((View)localObject1).setBackgroundResource(2131234878);
      break;
      label876:
      bool = false;
    }
  }
  
  public final void kV(boolean paramBoolean)
  {
    AppMethodBeat.i(199456);
    if (findViewById(2131307870) != null)
    {
      if (paramBoolean)
      {
        localView = findViewById(2131307870);
        d.g.b.k.g(localView, "findViewById<View>(R.id.share_feed_progress)");
        localView.setVisibility(0);
        AppMethodBeat.o(199456);
        return;
      }
      View localView = findViewById(2131307870);
      d.g.b.k.g(localView, "findViewById<View>(R.id.share_feed_progress)");
      localView.setVisibility(8);
    }
    AppMethodBeat.o(199456);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(199463);
    if ((this.pOf != 0) && (!this.KZN))
    {
      Object localObject = com.tencent.mm.plugin.finder.report.b.qFq;
      long l = this.feedId;
      int i = this.pOf;
      String str = this.dpv;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.b.a(l, i, (String)localObject, 0);
      this.KZN = true;
    }
    this.qvy.onDetach();
    super.onDestroy();
    AppMethodBeat.o(199463);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void yK(final boolean paramBoolean)
  {
    AppMethodBeat.i(199455);
    final v.e locale = new v.e();
    locale.Jhw = findViewById(2131304150);
    if ((View)locale.Jhw != null)
    {
      if (paramBoolean)
      {
        ((View)locale.Jhw).setVisibility(0);
        ((View)locale.Jhw).setOnClickListener((View.OnClickListener)new h(this, paramBoolean, locale));
        AppMethodBeat.o(199455);
        return;
      }
      ((View)locale.Jhw).setVisibility(8);
    }
    AppMethodBeat.o(199455);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$2$1"})
  static final class a
    extends d.g.b.l
    implements m<Integer, String, y>
  {
    a(n paramn, FinderShareFeedRelUI paramFinderShareFeedRelUI, v.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$2$2"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<FinderObject, y>
  {
    b(n paramn, FinderShareFeedRelUI paramFinderShareFeedRelUI, v.e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$3$1"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<IResponse<BaseFinderFeed>, y>
  {
    c(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$4", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(199447);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      this.KZW.fVH();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(199447);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(199448);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      super.b(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$4", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(199448);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "itemView", "Landroid/view/View;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<View, y>
  {
    e(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    public static final f KZY;
    
    static
    {
      AppMethodBeat.i(199450);
      KZY = new f();
      AppMethodBeat.o(199450);
    }
    
    public final void onClick(View paramView) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<Integer>
  {
    g(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$1$1"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderShareFeedRelUI paramFinderShareFeedRelUI, boolean paramBoolean, v.e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(199452);
      this.KZW.kV(true);
      ((View)locale.Jhw).setVisibility(8);
      FinderShareFeedRelUI.f(this.KZW).requestRefresh();
      AppMethodBeat.o(199452);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI
 * JD-Core Version:    0.7.0.1
 */