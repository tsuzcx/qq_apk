package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ce;
import com.tencent.mm.plugin.finder.feed.b.b;
import com.tencent.mm.plugin.finder.feed.h.a;
import com.tencent.mm.plugin.finder.feed.h.b;
import com.tencent.mm.plugin.finder.feed.model.c;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderLoaderFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.logic.b.a;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import d.g.a.m;
import d.g.b.u;
import d.g.b.v.f;
import d.g.b.w;
import d.y;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLoaderFeedUI;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedShareRelativeListLoader;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailRelUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/ui/ShareRelPresenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "cacheFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCacheFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCacheFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "setCommentPreloader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;)V", "distance", "", "feedId", "", "getFeedId", "()J", "setFeedId", "(J)V", "fromUser", "getFromUser", "setFromUser", "(Ljava/lang/String;)V", "isShareClickReport", "", "loader", "moreTipsLayout", "Landroid/view/View;", "parentBottom", "getParentBottom", "()I", "parentBottom$delegate", "Lkotlin/Lazy;", "presenter", "reportScene", "getReportScene", "setReportScene", "(I)V", "scene", "getScene", "setScene", "showFinderEntry", "tabType", "getTabType", "setTabType", "tipsLayout", "viewCallback", "checkBottomTips", "", "getCommentScene", "getLayoutId", "getModel", "getPresenter", "getReportType", "getViewBottomInWindow", "view", "getViewCallback", "initData", "initOnCreate", "initTipsLayout", "onDestroy", "showProgress", "ifShow", "showRetryTips", "plugin-finder_release"})
public final class FinderShareFeedRelUI
  extends FinderLoaderFeedUI<com.tencent.mm.plugin.finder.feed.model.f, h.b, n>
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private long dig;
  private int diw;
  String dng;
  int qwN;
  private boolean rLM;
  private View rLO;
  private boolean rLQ;
  private n rLV;
  private h.b rLW;
  private com.tencent.mm.plugin.finder.feed.model.f rLX;
  private BaseFinderFeed rLY;
  private View rLZ;
  private final d.f rMa;
  private int rMb;
  c rfE;
  private int scene;
  
  static
  {
    AppMethodBeat.i(203429);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bn(FinderShareFeedRelUI.class), "parentBottom", "getParentBottom()I")) };
    AppMethodBeat.o(203429);
  }
  
  public FinderShareFeedRelUI()
  {
    AppMethodBeat.i(203440);
    this.TAG = "Finder.FinderShareFeedRelUI";
    this.scene = 2;
    this.dng = "";
    this.rfE = new c((MMActivity)this);
    this.rLM = ((com.tencent.mm.plugin.i.a.l)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.i.a.l.class)).showFinderEntry();
    this.rMa = d.g.K((d.g.a.a)new FinderShareFeedRelUI.g(this));
    AppMethodBeat.o(203440);
  }
  
  private final int cCn()
  {
    AppMethodBeat.i(203430);
    int i = ((Number)this.rMa.getValue()).intValue();
    AppMethodBeat.o(203430);
    return i;
  }
  
  private static int dZ(View paramView)
  {
    AppMethodBeat.i(203434);
    if (paramView.getHeight() <= 0)
    {
      AppMethodBeat.o(203434);
      return 0;
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    int i = arrayOfInt[1];
    int j = paramView.getHeight();
    AppMethodBeat.o(203434);
    return i + j;
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203446);
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
    AppMethodBeat.o(203446);
    return localView1;
  }
  
  public final void cCo()
  {
    AppMethodBeat.i(203433);
    Object localObject1 = this.rLZ;
    if (localObject1 == null) {
      d.g.b.k.aVY("moreTipsLayout");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = this.rLX;
    if (localObject1 == null) {
      d.g.b.k.aVY("loader");
    }
    if (((com.tencent.mm.plugin.finder.feed.model.f)localObject1).getDataListJustForAdapter().size() < 2)
    {
      AppMethodBeat.o(203433);
      return;
    }
    localObject1 = this.rLW;
    if (localObject1 == null) {
      d.g.b.k.aVY("viewCallback");
    }
    Object localObject2 = ((b.b)localObject1).rfT.getRecyclerView().ci(0);
    localObject1 = this.rLW;
    if (localObject1 == null) {
      d.g.b.k.aVY("viewCallback");
    }
    localObject1 = ((b.b)localObject1).rfT.getRecyclerView().ci(1);
    if (localObject2 != null)
    {
      localObject2 = ((RecyclerView.w)localObject2).asD;
      d.g.b.k.g(localObject2, "firstItemView.itemView");
      int i = dZ((View)localObject2);
      if ((cCn() > 0) && (cCn() - i < this.rMb))
      {
        localObject2 = this.rLZ;
        if (localObject2 == null) {
          d.g.b.k.aVY("moreTipsLayout");
        }
        ((View)localObject2).setVisibility(0);
        if (localObject1 != null)
        {
          localObject1 = ((RecyclerView.w)localObject1).asD;
          d.g.b.k.g(localObject1, "secondItemView.itemView");
          ((View)localObject1).setVisibility(4);
        }
        AppMethodBeat.o(203433);
        return;
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((RecyclerView.w)localObject1).asD;
      d.g.b.k.g(localObject1, "secondItemView.itemView");
      ((View)localObject1).setVisibility(0);
    }
    AppMethodBeat.o(203433);
  }
  
  public final int cuI()
  {
    return 25;
  }
  
  public final int cvJ()
  {
    return 2;
  }
  
  public final int getLayoutId()
  {
    return 2131494111;
  }
  
  public final void initOnCreate()
  {
    boolean bool = true;
    AppMethodBeat.i(203436);
    this.dig = getIntent().getLongExtra("feed_object_id", 0L);
    Object localObject3 = new v.f();
    Object localObject2 = getIntent().getStringExtra("feed_object_nonceId");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    ((v.f)localObject3).KUQ = localObject1;
    this.qwN = getIntent().getIntExtra("report_scene", 0);
    this.dng = getIntent().getStringExtra("from_user");
    this.diw = getIntent().getIntExtra("tab_type", 0);
    if (this.dig == 0L)
    {
      ac.w(this.TAG, "objectId 0, finish");
      finish();
    }
    localObject1 = findViewById(2131304742);
    d.g.b.k.g(localObject1, "findViewById(R.id.share_feed_detail_tips_layout)");
    this.rLO = ((View)localObject1);
    localObject1 = findViewById(2131307871);
    d.g.b.k.g(localObject1, "findViewById(R.id.more_similar_feed_tip_layout)");
    this.rLZ = ((View)localObject1);
    localObject1 = this.rLZ;
    if (localObject1 == null) {
      d.g.b.k.aVY("moreTipsLayout");
    }
    localObject1 = (TextView)((View)localObject1).findViewById(2131307438);
    d.g.b.k.g(localObject1, "tipsTv");
    aj.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = this.rLZ;
    if (localObject1 == null) {
      d.g.b.k.aVY("moreTipsLayout");
    }
    localObject1 = ((View)localObject1).findViewById(2131307869);
    int i;
    if (aj.DT())
    {
      ((View)localObject1).setBackgroundResource(2131234883);
      localObject1 = this.rLZ;
      if (localObject1 == null) {
        d.g.b.k.aVY("moreTipsLayout");
      }
      ((View)localObject1).findViewById(2131307870).setOnClickListener((View.OnClickListener)FinderShareFeedRelUI.f.rMf);
      this.rMb = com.tencent.mm.cc.a.fromDPToPix((Context)this, 104);
      if (this.dig != 0L)
      {
        localObject1 = com.tencent.mm.plugin.finder.storage.data.d.rEF;
        localObject1 = d.a.uS(this.dig);
        if (localObject1 != null)
        {
          ac.i(this.TAG, "use cache cacheTime=" + h.formatTime("yyyy-MM-dd HH:mm:ss", ((FinderItem)localObject1).getTimestamps() / 1000L) + ", cacheTime=" + ((FinderItem)localObject1).getTimestamps() + ' ' + "current=" + h.formatTime("yyyy-MM-dd HH:mm:ss", ce.azJ() / 1000L) + ", urlValidDuration=" + ((FinderItem)localObject1).getFeedObject().urlValidDuration + 's');
          if ((((FinderItem)localObject1).getTimestamps() <= 0L) || (ce.azJ() < ((FinderItem)localObject1).getTimestamps() + ((FinderItem)localObject1).getFeedObject().urlValidDuration * 1000L))
          {
            localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
            this.rLY = b.a.i((FinderItem)localObject1);
          }
        }
      }
      if (this.rLY == null)
      {
        ac.d(this.TAG, "cache null.show progress");
        lA(true);
      }
      i = this.scene;
      localObject1 = (MMActivity)this;
      if (this.rLM) {
        break label1001;
      }
    }
    for (;;)
    {
      localObject1 = new n(i, (MMActivity)localObject1, bool);
      ((h.a)localObject1).qXP = this.dig;
      localObject2 = (String)((v.f)localObject3).KUQ;
      d.g.b.k.h(localObject2, "<set-?>");
      ((h.a)localObject1).objectNonceId = ((String)localObject2);
      ((h.a)localObject1).rdD = this.rLY;
      ((h.a)localObject1).rhv = ((m)new a((n)localObject1, this, (v.f)localObject3));
      ((h.a)localObject1).rhw = ((d.g.a.b)new b((n)localObject1, this, (v.f)localObject3));
      this.rLV = ((n)localObject1);
      localObject1 = (MMActivity)this;
      localObject2 = this.rLV;
      if (localObject2 == null) {
        d.g.b.k.aVY("presenter");
      }
      this.rLW = new h.b((MMActivity)localObject1, (h.a)localObject2, this.scene);
      long l = this.dig;
      i = this.diw;
      localObject1 = com.tencent.mm.ui.component.a.IrY;
      localObject3 = new com.tencent.mm.plugin.finder.feed.model.f(l, i, ((FinderReporterUIC)com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class)).cGb());
      localObject2 = getIntent().getStringExtra("key_from_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      d.g.b.k.h(localObject1, "<set-?>");
      ((com.tencent.mm.plugin.finder.feed.model.f)localObject3).dtD = ((String)localObject1);
      localObject2 = getIntent().getStringExtra("key_to_user_name");
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      d.g.b.k.h(localObject1, "<set-?>");
      ((com.tencent.mm.plugin.finder.feed.model.f)localObject3).dfJ = ((String)localObject1);
      ac.i(((com.tencent.mm.plugin.finder.feed.model.f)localObject3).getTAG(), "fromUserName=" + ((com.tencent.mm.plugin.finder.feed.model.f)localObject3).dtD + ",toUserName=" + ((com.tencent.mm.plugin.finder.feed.model.f)localObject3).dfJ);
      ((com.tencent.mm.plugin.finder.feed.model.f)localObject3).rmE = ((d.g.a.b)new c(this));
      this.rLX = ((com.tencent.mm.plugin.finder.feed.model.f)localObject3);
      if (this.qwN != 0) {
        e.wTc.idkeyStat(1278L, 14L, 1L, false);
      }
      setMMTitle(2131759376);
      localObject1 = this.rLW;
      if (localObject1 == null) {
        d.g.b.k.aVY("viewCallback");
      }
      ((b.b)localObject1).rfT.getRecyclerView().a((RecyclerView.m)new FinderShareFeedRelUI.d(this));
      localObject1 = this.rLV;
      if (localObject1 == null) {
        d.g.b.k.aVY("presenter");
      }
      ((n)localObject1).rMs = ((d.g.a.b)new FinderShareFeedRelUI.e(this));
      this.rfE.a(this.scene, 25, null);
      AppMethodBeat.o(203436);
      return;
      ((View)localObject1).setBackgroundResource(2131234882);
      break;
      label1001:
      bool = false;
    }
  }
  
  public final void lA(boolean paramBoolean)
  {
    AppMethodBeat.i(203432);
    if (findViewById(2131307978) != null)
    {
      if (paramBoolean)
      {
        localView = findViewById(2131307978);
        d.g.b.k.g(localView, "findViewById<View>(R.id.share_feed_progress)");
        localView.setVisibility(0);
        AppMethodBeat.o(203432);
        return;
      }
      View localView = findViewById(2131307978);
      d.g.b.k.g(localView, "findViewById<View>(R.id.share_feed_progress)");
      localView.setVisibility(8);
    }
    AppMethodBeat.o(203432);
  }
  
  public final void lN(final boolean paramBoolean)
  {
    AppMethodBeat.i(203431);
    final v.f localf = new v.f();
    localf.KUQ = findViewById(2131304150);
    if ((View)localf.KUQ != null)
    {
      if (paramBoolean)
      {
        ((View)localf.KUQ).setVisibility(0);
        ((View)localf.KUQ).setOnClickListener((View.OnClickListener)new h(this, paramBoolean, localf));
        AppMethodBeat.o(203431);
        return;
      }
      ((View)localf.KUQ).setVisibility(8);
    }
    AppMethodBeat.o(203431);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203439);
    if ((this.qwN != 0) && (!this.rLQ))
    {
      Object localObject = com.tencent.mm.plugin.finder.report.d.rxr;
      long l = this.dig;
      int i = this.qwN;
      String str = this.dng;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      com.tencent.mm.plugin.finder.report.d.a(l, i, (String)localObject, 0);
      this.rLQ = true;
    }
    this.rfE.onDetach();
    super.onDestroy();
    AppMethodBeat.o(203439);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errcode", "", "errMsg", "", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$2$1"})
  static final class a
    extends d.g.b.l
    implements m<Integer, String, y>
  {
    a(n paramn, FinderShareFeedRelUI paramFinderShareFeedRelUI, v.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$2$2"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<FinderObject, y>
  {
    b(n paramn, FinderShareFeedRelUI paramFinderShareFeedRelUI, v.f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$initData$3$1"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<IResponse<BaseFinderFeed>, y>
  {
    c(FinderShareFeedRelUI paramFinderShareFeedRelUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderShareFeedRelUI$showRetryTips$1$1"})
  static final class h
    implements View.OnClickListener
  {
    h(FinderShareFeedRelUI paramFinderShareFeedRelUI, boolean paramBoolean, v.f paramf) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203428);
      this.rMd.lA(true);
      ((View)localf.KUQ).setVisibility(8);
      FinderShareFeedRelUI.f(this.rMd).requestRefresh();
      AppMethodBeat.o(203428);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI
 * JD-Core Version:    0.7.0.1
 */