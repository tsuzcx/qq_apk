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
import com.tencent.mm.ak.i;
import com.tencent.mm.g.a.hh;
import com.tencent.mm.g.a.ii;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.finder.cgi.bl;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMProcessBar;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_BLACK_LIST", "", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "listView", "Landroid/widget/ListView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "totalCount", "addNoMoreView", "", "checkFinish", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderFriendRecommendUI
  extends MMFinderUI
  implements i, ai<ayt>
{
  private static final String TAG = "Finder.FinderFriendRecommendUI";
  public static final a uaU;
  private HashMap _$_findViewCache;
  private long feedId;
  private int gAZ;
  private TextView hRM;
  private boolean hasMore;
  private ListView krb;
  private IListener<hh> tOh;
  private com.tencent.mm.bw.b tsO;
  private MMProcessBar uaO;
  private TextView uaP;
  private final com.tencent.mm.plugin.finder.ui.d uaQ;
  private bfp uaR;
  private boolean uaS;
  private final int uaT;
  private final ArrayList<aul> uae;
  
  static
  {
    AppMethodBeat.i(245282);
    uaU = new a((byte)0);
    TAG = "Finder.FinderFriendRecommendUI";
    AppMethodBeat.o(245282);
  }
  
  public FinderFriendRecommendUI()
  {
    AppMethodBeat.i(245281);
    this.uaQ = new com.tencent.mm.plugin.finder.ui.d((Activity)this);
    this.uae = new ArrayList();
    this.uaT = 2;
    AppMethodBeat.o(245281);
  }
  
  private final void ddW()
  {
    AppMethodBeat.i(245274);
    if ((this.gAZ == 1) && (this.uae.size() == 1))
    {
      Object localObject = this.uae.get(0);
      p.g(localObject, "contactList[0]");
      localObject = (aul)localObject;
      if (((aul)localObject).LFn == 1)
      {
        ii localii = new ii();
        localii.dMV.dMW = ((aul)localObject).dMW;
        EventCenter.instance.publish((IEvent)localii);
      }
    }
    AppMethodBeat.o(245274);
  }
  
  private final void ddX()
  {
    AppMethodBeat.i(245277);
    bl localbl = new bl(this.tsO, this.feedId, this.uaS);
    g.azz().b((com.tencent.mm.ak.q)localbl);
    AppMethodBeat.o(245277);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(245275);
    setMMTitle(getString(2131759855, new Object[] { Integer.valueOf(this.gAZ) }));
    AppMethodBeat.o(245275);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245288);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245288);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245287);
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
    AppMethodBeat.o(245287);
    return localView1;
  }
  
  public final void ddY()
  {
    AppMethodBeat.i(245280);
    ListView localListView = this.krb;
    if (localListView == null) {
      p.btv("listView");
    }
    if (localListView.getFooterViewsCount() == 0)
    {
      localListView = this.krb;
      if (localListView == null) {
        p.btv("listView");
      }
      localListView.addFooterView(View.inflate((Context)this, 2131494490, null));
    }
    AppMethodBeat.o(245280);
  }
  
  public final int getLayoutId()
  {
    return 2131494360;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(245272);
    Object localObject = findViewById(2131300862);
    p.g(localObject, "findViewById(R.id.finder_liked_list)");
    this.krb = ((ListView)localObject);
    localObject = findViewById(2131300101);
    p.g(localObject, "findViewById(R.id.empty_tip)");
    this.hRM = ((TextView)localObject);
    localObject = findViewById(2131303694);
    p.g(localObject, "findViewById(R.id.loading_bar)");
    this.uaO = ((MMProcessBar)localObject);
    localObject = findViewById(2131307048);
    p.g(localObject, "findViewById(R.id.retry_tips)");
    this.uaP = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.uaQ);
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    localObject = this.uaP;
    if (localObject == null) {
      p.btv("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new d(this));
    this.uaQ.tBx = ((kotlin.g.a.b)new e(this));
    this.uaQ.tBy = ((kotlin.g.a.b)new f(this));
    addIconOptionMenu(this.uaT, -1, 2131689495, (MenuItem.OnMenuItemClickListener)new g(this));
    this.tOh = ((IListener)new h(this));
    EventCenter.instance.add(this.tOh);
    localObject = this.hRM;
    if (localObject == null) {
      p.btv("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.krb;
    if (localObject == null) {
      p.btv("listView");
    }
    ((ListView)localObject).setVisibility(8);
    localObject = this.uaO;
    if (localObject == null) {
      p.btv("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(0);
    localObject = this.uaP;
    if (localObject == null) {
      p.btv("retryTips");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(245272);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(245273);
    ddW();
    super.onBackPressed();
    AppMethodBeat.o(245273);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245271);
    super.onCreate(paramBundle);
    g.azz().a(3593, (i)this);
    g.azz().a(3638, (i)this);
    try
    {
      paramBundle = new bfp().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(245271);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      Log.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(245271);
      return;
    }
    this.uaR = ((bfp)paramBundle);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.feedId == 0L)
    {
      finish();
      Log.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(245271);
      return;
    }
    this.gAZ = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.uaS = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    ddX();
    AppMethodBeat.o(245271);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245278);
    super.onDestroy();
    g.azz().b(3593, (i)this);
    g.azz().b(3638, (i)this);
    EventCenter.instance.removeListener(this.tOh);
    AppMethodBeat.o(245278);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    final boolean bool = false;
    AppMethodBeat.i(245279);
    if ((paramq instanceof bl))
    {
      Log.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(245279);
          throw paramString;
        }
        paramString = ((bl)paramq).cYn();
        if ((p.j(this.tsO, paramString) ^ true))
        {
          Log.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(245279);
          return;
        }
        if (this.tsO == null) {
          bool = true;
        }
        if (bool)
        {
          this.gAZ = ((bl)paramq).cYx().gAZ;
          updateTitle();
        }
        this.hasMore = ((bl)paramq).cYp();
        this.tsO = ((bl)paramq).cYm();
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new i(this, paramq, bool));
        AppMethodBeat.o(245279);
        return;
      }
      if (this.tsO == null)
      {
        paramString = this.hRM;
        if (paramString == null) {
          p.btv("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.krb;
        if (paramString == null) {
          p.btv("listView");
        }
        paramString.setVisibility(8);
        paramString = this.uaO;
        if (paramString == null) {
          p.btv("loadingBar");
        }
        paramString.setVisibility(8);
        paramString = this.uaP;
        if (paramString == null) {
          p.btv("retryTips");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(245279);
      return;
    }
    if ((paramq instanceof ay))
    {
      Log.i(TAG, "NetSceneFinderContactTag errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((ay)paramq).ttq == null) {
          AppMethodBeat.o(245279);
        }
      }
      else {
        u.makeText((Context)this, 2131755803, 0).show();
      }
    }
    AppMethodBeat.o(245279);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245262);
      FinderFriendRecommendUI.a(this.uaV);
      this.uaV.finish();
      AppMethodBeat.o(245262);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(245263);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFriendRecommendUI.b(this.uaV))
        {
          FinderFriendRecommendUI.c(this.uaV);
          AppMethodBeat.o(245263);
          return;
        }
        this.uaV.ddY();
      }
      AppMethodBeat.o(245263);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245264);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderFriendRecommendUI.c(this.uaV);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245264);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<aul, x>
  {
    e(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<aul, x>
  {
    f(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245267);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramMenuItem = this.uaV.getContext();
      p.g(paramMenuItem, "context");
      com.tencent.mm.plugin.finder.utils.a.fx((Context)paramMenuItem);
      AppMethodBeat.o(245267);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class h
    extends IListener<hh>
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7$callback$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderFriendRecommendUI.h paramh, hh paramhh)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(FinderFriendRecommendUI paramFinderFriendRecommendUI, com.tencent.mm.ak.q paramq, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendRecommendUI
 * JD-Core Version:    0.7.0.1
 */