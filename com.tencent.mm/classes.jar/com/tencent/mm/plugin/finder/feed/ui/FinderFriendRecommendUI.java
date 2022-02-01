package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.hs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMProcessBar;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_BLACK_LIST", "", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "listView", "Landroid/widget/ListView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "totalCount", "addNoMoreView", "", "checkFinish", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderFriendRecommendUI
  extends MMFinderUI
  implements f, s<apl>
{
  private static final String TAG = "Finder.FinderFriendRecommendUI";
  public static final a seP;
  private HashMap _$_findViewCache;
  private long dtq;
  private int fTM;
  private TextView gWe;
  private boolean hasMore;
  private ListView jpT;
  private com.tencent.mm.bx.b rHF;
  private com.tencent.mm.sdk.b.c<hc> rVT;
  private MMProcessBar seJ;
  private TextView seK;
  private final com.tencent.mm.plugin.finder.ui.c seL;
  private atq seM;
  private boolean seN;
  private final int seO;
  private final ArrayList<aot> sec;
  
  static
  {
    AppMethodBeat.i(202734);
    seP = new a((byte)0);
    TAG = "Finder.FinderFriendRecommendUI";
    AppMethodBeat.o(202734);
  }
  
  public FinderFriendRecommendUI()
  {
    AppMethodBeat.i(202733);
    this.seL = new com.tencent.mm.plugin.finder.ui.c((Activity)this);
    this.sec = new ArrayList();
    this.seO = 2;
    AppMethodBeat.o(202733);
  }
  
  private final void cCk()
  {
    AppMethodBeat.i(202726);
    if ((this.fTM == 1) && (this.sec.size() == 1))
    {
      Object localObject = this.sec.get(0);
      p.g(localObject, "contactList[0]");
      localObject = (aot)localObject;
      if (((aot)localObject).Gnn == 1)
      {
        hs localhs = new hs();
        localhs.duk.dul = ((aot)localObject).dul;
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localhs);
      }
    }
    AppMethodBeat.o(202726);
  }
  
  private final void cCl()
  {
    AppMethodBeat.i(202729);
    al localal = new al(this.rHF, this.dtq, this.seN);
    g.aiU().b((n)localal);
    AppMethodBeat.o(202729);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(202727);
    setMMTitle(getString(2131766440, new Object[] { Integer.valueOf(this.fTM) }));
    AppMethodBeat.o(202727);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202739);
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
    AppMethodBeat.o(202739);
    return localView1;
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(202732);
    ListView localListView = this.jpT;
    if (localListView == null) {
      p.bcb("listView");
    }
    if (localListView.getFooterViewsCount() == 0)
    {
      localListView = this.jpT;
      if (localListView == null) {
        p.bcb("listView");
      }
      localListView.addFooterView(View.inflate((Context)this, 2131494060, null));
    }
    AppMethodBeat.o(202732);
  }
  
  public final int getLayoutId()
  {
    return 2131496224;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(202724);
    Object localObject = findViewById(2131307405);
    p.g(localObject, "findViewById(R.id.finder_liked_list)");
    this.jpT = ((ListView)localObject);
    localObject = findViewById(2131299472);
    p.g(localObject, "findViewById(R.id.empty_tip)");
    this.gWe = ((TextView)localObject);
    localObject = findViewById(2131307853);
    p.g(localObject, "findViewById(R.id.loading_bar)");
    this.seJ = ((MMProcessBar)localObject);
    localObject = findViewById(2131307943);
    p.g(localObject, "findViewById(R.id.retry_tips)");
    this.seK = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.jpT;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.seL);
    localObject = this.jpT;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.jpT;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    localObject = this.seK;
    if (localObject == null) {
      p.bcb("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new d(this));
    this.seL.rNT = ((d.g.a.b)new e(this));
    this.seL.rNU = ((d.g.a.b)new f(this));
    addIconOptionMenu(this.seO, -1, 2131689493, (MenuItem.OnMenuItemClickListener)new g(this));
    this.rVT = ((com.tencent.mm.sdk.b.c)new h(this));
    com.tencent.mm.sdk.b.a.IbL.b(this.rVT);
    localObject = this.gWe;
    if (localObject == null) {
      p.bcb("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.jpT;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((ListView)localObject).setVisibility(8);
    localObject = this.seJ;
    if (localObject == null) {
      p.bcb("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(0);
    localObject = this.seK;
    if (localObject == null) {
      p.bcb("retryTips");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(202724);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(202725);
    cCk();
    super.onBackPressed();
    AppMethodBeat.o(202725);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202723);
    super.onCreate(paramBundle);
    g.aiU().a(3593, (f)this);
    g.aiU().a(3638, (f)this);
    try
    {
      paramBundle = new atq().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(202723);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(202723);
      return;
    }
    this.seM = ((atq)paramBundle);
    this.dtq = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.dtq == 0L)
    {
      finish();
      com.tencent.mm.sdk.platformtools.ad.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(202723);
      return;
    }
    this.fTM = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.seN = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    cCl();
    AppMethodBeat.o(202723);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202730);
    super.onDestroy();
    g.aiU().b(3593, (f)this);
    g.aiU().b(3638, (f)this);
    com.tencent.mm.sdk.b.a.IbL.d(this.rVT);
    AppMethodBeat.o(202730);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    final boolean bool = false;
    AppMethodBeat.i(202731);
    if ((paramn instanceof al))
    {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(202731);
          throw paramString;
        }
        paramString = ((al)paramn).cym();
        if ((p.i(this.rHF, paramString) ^ true))
        {
          com.tencent.mm.sdk.platformtools.ad.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(202731);
          return;
        }
        if (this.rHF == null) {
          bool = true;
        }
        if (bool)
        {
          this.fTM = ((al)paramn).cyo().fTM;
          updateTitle();
        }
        this.hasMore = ((al)paramn).cyj();
        this.rHF = ((al)paramn).cyh();
        com.tencent.mm.ad.c.g((d.g.a.a)new i(this, paramn, bool));
        AppMethodBeat.o(202731);
        return;
      }
      if (this.rHF == null)
      {
        paramString = this.gWe;
        if (paramString == null) {
          p.bcb("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.jpT;
        if (paramString == null) {
          p.bcb("listView");
        }
        paramString.setVisibility(8);
        paramString = this.seJ;
        if (paramString == null) {
          p.bcb("loadingBar");
        }
        paramString.setVisibility(8);
        paramString = this.seK;
        if (paramString == null) {
          p.bcb("retryTips");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(202731);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.finder.cgi.ad))
    {
      com.tencent.mm.sdk.platformtools.ad.i(TAG, "NetSceneFinderContactTag errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.finder.cgi.ad)paramn).rId == null) {
          AppMethodBeat.o(202731);
        }
      }
      else {
        t.makeText((Context)this, 2131755732, 0).show();
      }
    }
    AppMethodBeat.o(202731);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202714);
      FinderFriendRecommendUI.a(this.seQ);
      this.seQ.finish();
      AppMethodBeat.o(202714);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(202715);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFriendRecommendUI.b(this.seQ))
        {
          FinderFriendRecommendUI.c(this.seQ);
          AppMethodBeat.o(202715);
          return;
        }
        this.seQ.cCm();
      }
      AppMethodBeat.o(202715);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202716);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderFriendRecommendUI.c(this.seQ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202716);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<aot, z>
  {
    e(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<aot, z>
  {
    f(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202719);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramMenuItem = this.seQ.getContext();
      p.g(paramMenuItem, "context");
      com.tencent.mm.plugin.finder.utils.a.Q((Context)paramMenuItem, null);
      AppMethodBeat.o(202719);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class h
    extends com.tencent.mm.sdk.b.c<hc>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7$callback$1$1"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      a(FinderFriendRecommendUI.h paramh, hc paramhc)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    i(FinderFriendRecommendUI paramFinderFriendRecommendUI, n paramn, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendRecommendUI
 * JD-Core Version:    0.7.0.1
 */