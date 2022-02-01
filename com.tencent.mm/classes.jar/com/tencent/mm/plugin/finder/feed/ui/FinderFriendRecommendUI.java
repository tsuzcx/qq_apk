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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.g.a.yq;
import com.tencent.mm.plugin.finder.cgi.aq;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.h;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.dys;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMProcessBar;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_BLACK_LIST", "", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "listView", "Landroid/widget/ListView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "totalCount", "addNoMoreView", "", "checkFinish", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderFriendRecommendUI
  extends MMFinderUI
  implements com.tencent.mm.al.g, i<ajw>
{
  public static final a KSn;
  private static final String TAG = "Finder.FinderFriendRecommendUI";
  private MMProcessBar KSh;
  private TextView KSi;
  private final h KSj;
  private dzz KSk;
  private boolean KSl;
  private final int KSm;
  private HashMap _$_findViewCache;
  private long feedId;
  private int fwP;
  private boolean hasMore;
  private ListView iwH;
  private final ArrayList<dzd> qHA;
  private TextView qKU;
  private com.tencent.mm.bx.b qKW;
  private com.tencent.mm.sdk.b.c<hf> xpb;
  
  static
  {
    AppMethodBeat.i(198495);
    KSn = new a((byte)0);
    TAG = "Finder.FinderFriendRecommendUI";
    AppMethodBeat.o(198495);
  }
  
  public FinderFriendRecommendUI()
  {
    AppMethodBeat.i(198494);
    this.KSj = new h((Activity)this);
    this.qHA = new ArrayList();
    this.KSm = 2;
    AppMethodBeat.o(198494);
  }
  
  private final void fTI()
  {
    AppMethodBeat.i(198487);
    if ((this.fwP == 1) && (this.qHA.size() == 1))
    {
      Object localObject = this.qHA.get(0);
      k.g(localObject, "contactList[0]");
      localObject = (dzd)localObject;
      if (((dzd)localObject).LxF == 1)
      {
        yq localyq = new yq();
        localyq.aUI.hKD = ((dzd)localObject).hKD;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localyq);
      }
    }
    AppMethodBeat.o(198487);
  }
  
  private final void fTJ()
  {
    AppMethodBeat.i(198490);
    at localat = new at(this.qKW, this.feedId, this.KSl);
    com.tencent.mm.kernel.g.aeS().b((n)localat);
    AppMethodBeat.o(198490);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(198488);
    setMMTitle(getString(2131766427, new Object[] { Integer.valueOf(this.fwP) }));
    AppMethodBeat.o(198488);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198500);
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
    AppMethodBeat.o(198500);
    return localView1;
  }
  
  public final void fTK()
  {
    AppMethodBeat.i(198493);
    ListView localListView = this.iwH;
    if (localListView == null) {
      k.aPZ("listView");
    }
    if (localListView.getFooterViewsCount() == 0)
    {
      localListView = this.iwH;
      if (localListView == null) {
        k.aPZ("listView");
      }
      localListView.addFooterView(View.inflate((Context)this, 2131494060, null));
    }
    AppMethodBeat.o(198493);
  }
  
  public final int getLayoutId()
  {
    return 2131496223;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(198485);
    Object localObject = findViewById(2131307336);
    k.g(localObject, "findViewById(R.id.finder_liked_list)");
    this.iwH = ((ListView)localObject);
    localObject = findViewById(2131299472);
    k.g(localObject, "findViewById(R.id.empty_tip)");
    this.qKU = ((TextView)localObject);
    localObject = findViewById(2131307774);
    k.g(localObject, "findViewById(R.id.loading_bar)");
    this.KSh = ((MMProcessBar)localObject);
    localObject = findViewById(2131307836);
    k.g(localObject, "findViewById(R.id.retry_tips)");
    this.KSi = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.KSj);
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    localObject = this.KSi;
    if (localObject == null) {
      k.aPZ("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new d(this));
    this.KSj.KKO = ((d.g.a.b)new e(this));
    this.KSj.KKP = ((d.g.a.b)new f(this));
    addIconOptionMenu(this.KSm, -1, 2131689493, (MenuItem.OnMenuItemClickListener)new g(this));
    this.xpb = ((com.tencent.mm.sdk.b.c)new h(this));
    com.tencent.mm.sdk.b.a.ESL.b(this.xpb);
    localObject = this.qKU;
    if (localObject == null) {
      k.aPZ("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.iwH;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((ListView)localObject).setVisibility(8);
    localObject = this.KSh;
    if (localObject == null) {
      k.aPZ("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(0);
    localObject = this.KSi;
    if (localObject == null) {
      k.aPZ("retryTips");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(198485);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(198486);
    fTI();
    super.onBackPressed();
    AppMethodBeat.o(198486);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198484);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(3593, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().a(3638, (com.tencent.mm.al.g)this);
    try
    {
      paramBundle = new dzz().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(198484);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      ad.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(198484);
      return;
    }
    this.KSk = ((dzz)paramBundle);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.feedId == 0L)
    {
      finish();
      ad.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(198484);
      return;
    }
    this.fwP = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.KSl = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    fTJ();
    AppMethodBeat.o(198484);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198491);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(3593, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().b(3638, (com.tencent.mm.al.g)this);
    com.tencent.mm.sdk.b.a.ESL.d(this.xpb);
    AppMethodBeat.o(198491);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    final boolean bool = false;
    AppMethodBeat.i(198492);
    if ((paramn instanceof at))
    {
      ad.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(198492);
          throw paramString;
        }
        paramString = ((at)paramn).fRY();
        if ((k.g(this.qKW, paramString) ^ true))
        {
          ad.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(198492);
          return;
        }
        if (this.qKW == null) {
          bool = true;
        }
        if (bool)
        {
          this.fwP = ((at)paramn).fSa().fwP;
          updateTitle();
        }
        this.hasMore = ((at)paramn).fRW();
        this.qKW = ((at)paramn).ckJ();
        com.tencent.mm.ad.c.g((d.g.a.a)new i(this, paramn, bool));
        AppMethodBeat.o(198492);
        return;
      }
      if (this.qKW == null)
      {
        paramString = this.qKU;
        if (paramString == null) {
          k.aPZ("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.iwH;
        if (paramString == null) {
          k.aPZ("listView");
        }
        paramString.setVisibility(8);
        paramString = this.KSh;
        if (paramString == null) {
          k.aPZ("loadingBar");
        }
        paramString.setVisibility(8);
        paramString = this.KSi;
        if (paramString == null) {
          k.aPZ("retryTips");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(198492);
      return;
    }
    if ((paramn instanceof aq))
    {
      ad.i(TAG, "NetSceneFinderContactTag errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        t.makeText((Context)this, 2131755732, 0).show();
      }
    }
    AppMethodBeat.o(198492);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198475);
      FinderFriendRecommendUI.a(this.KSo);
      this.KSo.finish();
      AppMethodBeat.o(198475);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(198476);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFriendRecommendUI.b(this.KSo))
        {
          FinderFriendRecommendUI.c(this.KSo);
          AppMethodBeat.o(198476);
          return;
        }
        this.KSo.fTK();
      }
      AppMethodBeat.o(198476);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198477);
      FinderFriendRecommendUI.c(this.KSo);
      AppMethodBeat.o(198477);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<dzd, y>
  {
    e(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<dzd, y>
  {
    f(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198480);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.qSb;
      paramMenuItem = this.KSo.getContext();
      k.g(paramMenuItem, "context");
      com.tencent.mm.plugin.finder.utils.a.ah((Context)paramMenuItem, null);
      AppMethodBeat.o(198480);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class h
    extends com.tencent.mm.sdk.b.c<hf>
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7$callback$1$1"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(FinderFriendRecommendUI.h paramh, hf paramhf)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendRecommendUI
 * JD-Core Version:    0.7.0.1
 */