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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.ht;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMProcessBar;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_BLACK_LIST", "", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "listView", "Landroid/widget/ListView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "totalCount", "addNoMoreView", "", "checkFinish", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderFriendRecommendUI
  extends MMFinderUI
  implements f, s<apy>
{
  private static final String TAG = "Finder.FinderFriendRecommendUI";
  public static final FinderFriendRecommendUI.a snE;
  private HashMap _$_findViewCache;
  private long duw;
  private int fVS;
  private TextView gYR;
  private boolean hasMore;
  private ListView jsM;
  private com.tencent.mm.bw.b rPQ;
  private com.tencent.mm.sdk.b.c<hd> seA;
  private final ArrayList<apg> smS;
  private final com.tencent.mm.plugin.finder.ui.c snA;
  private aug snB;
  private boolean snC;
  private final int snD;
  private MMProcessBar sny;
  private TextView snz;
  
  static
  {
    AppMethodBeat.i(203210);
    snE = new FinderFriendRecommendUI.a((byte)0);
    TAG = "Finder.FinderFriendRecommendUI";
    AppMethodBeat.o(203210);
  }
  
  public FinderFriendRecommendUI()
  {
    AppMethodBeat.i(203209);
    this.snA = new com.tencent.mm.plugin.finder.ui.c((Activity)this);
    this.smS = new ArrayList();
    this.snD = 2;
    AppMethodBeat.o(203209);
  }
  
  private final void cDW()
  {
    AppMethodBeat.i(203202);
    if ((this.fVS == 1) && (this.smS.size() == 1))
    {
      Object localObject = this.smS.get(0);
      p.g(localObject, "contactList[0]");
      localObject = (apg)localObject;
      if (((apg)localObject).GGt == 1)
      {
        ht localht = new ht();
        localht.dvp.dvq = ((apg)localObject).dvq;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localht);
      }
    }
    AppMethodBeat.o(203202);
  }
  
  private final void cDX()
  {
    AppMethodBeat.i(203205);
    am localam = new am(this.rPQ, this.duw, this.snC);
    g.ajj().b((n)localam);
    AppMethodBeat.o(203205);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(203203);
    setMMTitle(getString(2131766440, new Object[] { Integer.valueOf(this.fVS) }));
    AppMethodBeat.o(203203);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203215);
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
    AppMethodBeat.o(203215);
    return localView1;
  }
  
  public final void cDY()
  {
    AppMethodBeat.i(203208);
    ListView localListView = this.jsM;
    if (localListView == null) {
      p.bdF("listView");
    }
    if (localListView.getFooterViewsCount() == 0)
    {
      localListView = this.jsM;
      if (localListView == null) {
        p.bdF("listView");
      }
      localListView.addFooterView(View.inflate((Context)this, 2131494060, null));
    }
    AppMethodBeat.o(203208);
  }
  
  public final int getLayoutId()
  {
    return 2131496224;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(203200);
    Object localObject = findViewById(2131307405);
    p.g(localObject, "findViewById(R.id.finder_liked_list)");
    this.jsM = ((ListView)localObject);
    localObject = findViewById(2131299472);
    p.g(localObject, "findViewById(R.id.empty_tip)");
    this.gYR = ((TextView)localObject);
    localObject = findViewById(2131307853);
    p.g(localObject, "findViewById(R.id.loading_bar)");
    this.sny = ((MMProcessBar)localObject);
    localObject = findViewById(2131307943);
    p.g(localObject, "findViewById(R.id.retry_tips)");
    this.snz = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.jsM;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.snA);
    localObject = this.jsM;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.jsM;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    localObject = this.snz;
    if (localObject == null) {
      p.bdF("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new d(this));
    this.snA.rWl = ((d.g.a.b)new e(this));
    this.snA.rWm = ((d.g.a.b)new f(this));
    addIconOptionMenu(this.snD, -1, 2131689493, (MenuItem.OnMenuItemClickListener)new g(this));
    this.seA = ((com.tencent.mm.sdk.b.c)new h(this));
    com.tencent.mm.sdk.b.a.IvT.b(this.seA);
    localObject = this.gYR;
    if (localObject == null) {
      p.bdF("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.jsM;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((ListView)localObject).setVisibility(8);
    localObject = this.sny;
    if (localObject == null) {
      p.bdF("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(0);
    localObject = this.snz;
    if (localObject == null) {
      p.bdF("retryTips");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(203200);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(203201);
    cDW();
    super.onBackPressed();
    AppMethodBeat.o(203201);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203199);
    super.onCreate(paramBundle);
    g.ajj().a(3593, (f)this);
    g.ajj().a(3638, (f)this);
    try
    {
      paramBundle = new aug().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(203199);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      com.tencent.mm.sdk.platformtools.ae.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(203199);
      return;
    }
    this.snB = ((aug)paramBundle);
    this.duw = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.duw == 0L)
    {
      finish();
      com.tencent.mm.sdk.platformtools.ae.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(203199);
      return;
    }
    this.fVS = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.snC = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    cDX();
    AppMethodBeat.o(203199);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203206);
    super.onDestroy();
    g.ajj().b(3593, (f)this);
    g.ajj().b(3638, (f)this);
    com.tencent.mm.sdk.b.a.IvT.d(this.seA);
    AppMethodBeat.o(203206);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    final boolean bool = false;
    AppMethodBeat.i(203207);
    if ((paramn instanceof am))
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(203207);
          throw paramString;
        }
        paramString = ((am)paramn).czN();
        if ((p.i(this.rPQ, paramString) ^ true))
        {
          com.tencent.mm.sdk.platformtools.ae.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(203207);
          return;
        }
        if (this.rPQ == null) {
          bool = true;
        }
        if (bool)
        {
          this.fVS = ((am)paramn).czP().fVS;
          updateTitle();
        }
        this.hasMore = ((am)paramn).czK();
        this.rPQ = ((am)paramn).czI();
        com.tencent.mm.ac.c.h((d.g.a.a)new i(this, paramn, bool));
        AppMethodBeat.o(203207);
        return;
      }
      if (this.rPQ == null)
      {
        paramString = this.gYR;
        if (paramString == null) {
          p.bdF("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.jsM;
        if (paramString == null) {
          p.bdF("listView");
        }
        paramString.setVisibility(8);
        paramString = this.sny;
        if (paramString == null) {
          p.bdF("loadingBar");
        }
        paramString.setVisibility(8);
        paramString = this.snz;
        if (paramString == null) {
          p.bdF("retryTips");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(203207);
      return;
    }
    if ((paramn instanceof com.tencent.mm.plugin.finder.cgi.ae))
    {
      com.tencent.mm.sdk.platformtools.ae.i(TAG, "NetSceneFinderContactTag errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((com.tencent.mm.plugin.finder.cgi.ae)paramn).rQo == null) {
          AppMethodBeat.o(203207);
        }
      }
      else {
        t.makeText((Context)this, 2131755732, 0).show();
      }
    }
    AppMethodBeat.o(203207);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203190);
      FinderFriendRecommendUI.a(this.snF);
      this.snF.finish();
      AppMethodBeat.o(203190);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(203191);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFriendRecommendUI.b(this.snF))
        {
          FinderFriendRecommendUI.c(this.snF);
          AppMethodBeat.o(203191);
          return;
        }
        this.snF.cDY();
      }
      AppMethodBeat.o(203191);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203192);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      FinderFriendRecommendUI.c(this.snF);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203192);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<apg, z>
  {
    e(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<apg, z>
  {
    f(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203195);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramMenuItem = this.snF.getContext();
      p.g(paramMenuItem, "context");
      com.tencent.mm.plugin.finder.utils.a.Q((Context)paramMenuItem, null);
      AppMethodBeat.o(203195);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class h
    extends com.tencent.mm.sdk.b.c<hd>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7$callback$1$1"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      a(FinderFriendRecommendUI.h paramh, hd paramhd)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendRecommendUI
 * JD-Core Version:    0.7.0.1
 */