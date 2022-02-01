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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMProcessBar;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_BLACK_LIST", "", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "listView", "Landroid/widget/ListView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "totalCount", "addNoMoreView", "", "checkFinish", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderFriendRecommendUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.i.a.k<amf>
{
  private static final String TAG = "Finder.FinderFriendRecommendUI";
  public static final FinderFriendRecommendUI.a rqb;
  private HashMap _$_findViewCache;
  private long dig;
  private int fAw;
  private TextView gCu;
  private boolean hasMore;
  private ListView iWK;
  private com.tencent.mm.sdk.b.c<gy> rhM;
  private MMProcessBar rpU;
  private TextView rpV;
  private final com.tencent.mm.plugin.finder.ui.g rpW;
  private com.tencent.mm.bw.b rpX;
  private apw rpY;
  private boolean rpZ;
  private final ArrayList<alo> rpr;
  private final int rqa;
  
  static
  {
    AppMethodBeat.i(202408);
    rqb = new FinderFriendRecommendUI.a((byte)0);
    TAG = "Finder.FinderFriendRecommendUI";
    AppMethodBeat.o(202408);
  }
  
  public FinderFriendRecommendUI()
  {
    AppMethodBeat.i(202407);
    this.rpW = new com.tencent.mm.plugin.finder.ui.g((Activity)this);
    this.rpr = new ArrayList();
    this.rqa = 2;
    AppMethodBeat.o(202407);
  }
  
  private final void cvV()
  {
    AppMethodBeat.i(202400);
    if ((this.fAw == 1) && (this.rpr.size() == 1))
    {
      Object localObject = this.rpr.get(0);
      d.g.b.k.g(localObject, "contactList[0]");
      localObject = (alo)localObject;
      if (((alo)localObject).EFh == 1)
      {
        hl localhl = new hl();
        localhl.diz.diA = ((alo)localObject).diA;
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localhl);
      }
    }
    AppMethodBeat.o(202400);
  }
  
  private final void cvW()
  {
    AppMethodBeat.i(202403);
    ae localae = new ae(this.rpX, this.dig, this.rpZ);
    com.tencent.mm.kernel.g.agi().b((n)localae);
    AppMethodBeat.o(202403);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(202401);
    setMMTitle(getString(2131766440, new Object[] { Integer.valueOf(this.fAw) }));
    AppMethodBeat.o(202401);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202413);
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
    AppMethodBeat.o(202413);
    return localView1;
  }
  
  public final void cvX()
  {
    AppMethodBeat.i(202406);
    ListView localListView = this.iWK;
    if (localListView == null) {
      d.g.b.k.aVY("listView");
    }
    if (localListView.getFooterViewsCount() == 0)
    {
      localListView = this.iWK;
      if (localListView == null) {
        d.g.b.k.aVY("listView");
      }
      localListView.addFooterView(View.inflate((Context)this, 2131494060, null));
    }
    AppMethodBeat.o(202406);
  }
  
  public final int getLayoutId()
  {
    return 2131496224;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(202398);
    Object localObject = findViewById(2131307405);
    d.g.b.k.g(localObject, "findViewById(R.id.finder_liked_list)");
    this.iWK = ((ListView)localObject);
    localObject = findViewById(2131299472);
    d.g.b.k.g(localObject, "findViewById(R.id.empty_tip)");
    this.gCu = ((TextView)localObject);
    localObject = findViewById(2131307853);
    d.g.b.k.g(localObject, "findViewById(R.id.loading_bar)");
    this.rpU = ((MMProcessBar)localObject);
    localObject = findViewById(2131307943);
    d.g.b.k.g(localObject, "findViewById(R.id.retry_tips)");
    this.rpV = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.iWK;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.rpW);
    localObject = this.iWK;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.iWK;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    localObject = this.rpV;
    if (localObject == null) {
      d.g.b.k.aVY("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new d(this));
    this.rpW.rbj = ((d.g.a.b)new e(this));
    this.rpW.rbk = ((d.g.a.b)new f(this));
    addIconOptionMenu(this.rqa, -1, 2131689493, (MenuItem.OnMenuItemClickListener)new g(this));
    this.rhM = ((com.tencent.mm.sdk.b.c)new h(this));
    com.tencent.mm.sdk.b.a.GpY.b(this.rhM);
    localObject = this.gCu;
    if (localObject == null) {
      d.g.b.k.aVY("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.iWK;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((ListView)localObject).setVisibility(8);
    localObject = this.rpU;
    if (localObject == null) {
      d.g.b.k.aVY("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(0);
    localObject = this.rpV;
    if (localObject == null) {
      d.g.b.k.aVY("retryTips");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(202398);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(202399);
    cvV();
    super.onBackPressed();
    AppMethodBeat.o(202399);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202397);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(3593, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().a(3638, (com.tencent.mm.ak.g)this);
    try
    {
      paramBundle = new apw().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(202397);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      ac.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(202397);
      return;
    }
    this.rpY = ((apw)paramBundle);
    this.dig = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.dig == 0L)
    {
      finish();
      ac.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(202397);
      return;
    }
    this.fAw = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.rpZ = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    cvW();
    AppMethodBeat.o(202397);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202404);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(3593, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().b(3638, (com.tencent.mm.ak.g)this);
    com.tencent.mm.sdk.b.a.GpY.d(this.rhM);
    AppMethodBeat.o(202404);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    final boolean bool = false;
    AppMethodBeat.i(202405);
    if ((paramn instanceof ae))
    {
      ac.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(202405);
          throw paramString;
        }
        paramString = ((ae)paramn).csv();
        if ((d.g.b.k.g(this.rpX, paramString) ^ true))
        {
          ac.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(202405);
          return;
        }
        if (this.rpX == null) {
          bool = true;
        }
        if (bool)
        {
          this.fAw = ((ae)paramn).csx().fAw;
          updateTitle();
        }
        this.hasMore = ((ae)paramn).css();
        this.rpX = ((ae)paramn).csq();
        com.tencent.mm.ac.c.g((d.g.a.a)new i(this, paramn, bool));
        AppMethodBeat.o(202405);
        return;
      }
      if (this.rpX == null)
      {
        paramString = this.gCu;
        if (paramString == null) {
          d.g.b.k.aVY("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.iWK;
        if (paramString == null) {
          d.g.b.k.aVY("listView");
        }
        paramString.setVisibility(8);
        paramString = this.rpU;
        if (paramString == null) {
          d.g.b.k.aVY("loadingBar");
        }
        paramString.setVisibility(8);
        paramString = this.rpV;
        if (paramString == null) {
          d.g.b.k.aVY("retryTips");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(202405);
      return;
    }
    if ((paramn instanceof x))
    {
      ac.i(TAG, "NetSceneFinderContactTag errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        t.makeText((Context)this, 2131755732, 0).show();
      }
    }
    AppMethodBeat.o(202405);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202388);
      FinderFriendRecommendUI.a(this.rqc);
      this.rqc.finish();
      AppMethodBeat.o(202388);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(202389);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFriendRecommendUI.b(this.rqc))
        {
          FinderFriendRecommendUI.c(this.rqc);
          AppMethodBeat.o(202389);
          return;
        }
        this.rqc.cvX();
      }
      AppMethodBeat.o(202389);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202390);
      FinderFriendRecommendUI.c(this.rqc);
      AppMethodBeat.o(202390);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<alo, y>
  {
    e(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<alo, y>
  {
    f(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202393);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.rOv;
      paramMenuItem = this.rqc.getContext();
      d.g.b.k.g(paramMenuItem, "context");
      com.tencent.mm.plugin.finder.utils.a.Q((Context)paramMenuItem, null);
      AppMethodBeat.o(202393);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class h
    extends com.tencent.mm.sdk.b.c<gy>
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(FinderFriendRecommendUI.h paramh, gy paramgy)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(FinderFriendRecommendUI paramFinderFriendRecommendUI, n paramn, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendRecommendUI
 * JD-Core Version:    0.7.0.1
 */