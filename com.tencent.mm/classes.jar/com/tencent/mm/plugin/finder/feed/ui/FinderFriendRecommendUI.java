package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
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
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.f.a.ho;
import com.tencent.mm.f.a.ix;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ba;
import com.tencent.mm.plugin.finder.cgi.bo;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMProcessBar;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_BLACK_LIST", "", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "listView", "Landroid/widget/ListView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "totalCount", "addNoMoreView", "", "checkFinish", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderFriendRecommendUI
  extends MMFinderUI
  implements i, aj<beo>
{
  private static final String TAG = "Finder.FinderFriendRecommendUI";
  public static final a xNw;
  private HashMap _$_findViewCache;
  private long feedId;
  private boolean hasMore;
  private int jlf;
  private TextView kGj;
  private ListView niO;
  private final ArrayList<awr> xMG;
  private MMProcessBar xNq;
  private TextView xNr;
  private final com.tencent.mm.plugin.finder.ui.d xNs;
  private bmq xNt;
  private boolean xNu;
  private final int xNv;
  private com.tencent.mm.cd.b xaw;
  private IListener<ho> xyI;
  
  static
  {
    AppMethodBeat.i(223023);
    xNw = new a((byte)0);
    TAG = "Finder.FinderFriendRecommendUI";
    AppMethodBeat.o(223023);
  }
  
  public FinderFriendRecommendUI()
  {
    AppMethodBeat.i(223020);
    this.xNs = new com.tencent.mm.plugin.finder.ui.d((Activity)this);
    this.xMG = new ArrayList();
    this.xNv = 2;
    AppMethodBeat.o(223020);
  }
  
  private final void dvd()
  {
    AppMethodBeat.i(222981);
    if ((this.jlf == 1) && (this.xMG.size() == 1))
    {
      Object localObject = this.xMG.get(0);
      p.j(localObject, "contactList[0]");
      localObject = (awr)localObject;
      if (((awr)localObject).SJo == 1)
      {
        ix localix = new ix();
        localix.fGd.fGe = ((awr)localObject).fGe;
        EventCenter.instance.publish((IEvent)localix);
      }
    }
    AppMethodBeat.o(222981);
  }
  
  private final void dve()
  {
    AppMethodBeat.i(222987);
    bo localbo = new bo(this.xaw, this.feedId, this.xNu);
    h.aGY().b((com.tencent.mm.an.q)localbo);
    AppMethodBeat.o(222987);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(222983);
    setMMTitle(getString(b.j.finder_liked_ui_title, new Object[] { Integer.valueOf(this.jlf) }));
    AppMethodBeat.o(222983);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(223036);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(223036);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(223034);
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
    AppMethodBeat.o(223034);
    return localView1;
  }
  
  public final void dvf()
  {
    AppMethodBeat.i(223019);
    ListView localListView = this.niO;
    if (localListView == null) {
      p.bGy("listView");
    }
    if (localListView.getFooterViewsCount() == 0)
    {
      localListView = this.niO;
      if (localListView == null) {
        p.bGy("listView");
      }
      localListView.addFooterView(View.inflate((Context)this, b.g.finder_load_no_more_footer, null));
    }
    AppMethodBeat.o(223019);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_liked_list_layout;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(222978);
    Object localObject = findViewById(b.f.finder_liked_list);
    p.j(localObject, "findViewById(R.id.finder_liked_list)");
    this.niO = ((ListView)localObject);
    localObject = findViewById(b.f.empty_tip);
    p.j(localObject, "findViewById(R.id.empty_tip)");
    this.kGj = ((TextView)localObject);
    localObject = findViewById(b.f.loading_bar);
    p.j(localObject, "findViewById(R.id.loading_bar)");
    this.xNq = ((MMProcessBar)localObject);
    localObject = findViewById(b.f.retry_tips);
    p.j(localObject, "findViewById(R.id.retry_tips)");
    this.xNr = ((TextView)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setAdapter((ListAdapter)this.xNs);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setSelector((Drawable)new ColorDrawable(0));
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setOnScrollListener((AbsListView.OnScrollListener)new c(this));
    localObject = this.xNr;
    if (localObject == null) {
      p.bGy("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new d(this));
    this.xNs.xjj = ((kotlin.g.a.b)new e(this));
    this.xNs.xjk = ((kotlin.g.a.b)new f(this));
    addIconOptionMenu(this.xNv, -1, b.i.actionbar_icon_dark_more, (MenuItem.OnMenuItemClickListener)new g(this));
    this.xyI = ((IListener)new h(this));
    EventCenter.instance.add(this.xyI);
    localObject = this.kGj;
    if (localObject == null) {
      p.bGy("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.niO;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((ListView)localObject).setVisibility(8);
    localObject = this.xNq;
    if (localObject == null) {
      p.bGy("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(0);
    localObject = this.xNr;
    if (localObject == null) {
      p.bGy("retryTips");
    }
    ((TextView)localObject).setVisibility(8);
    AppMethodBeat.o(222978);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(222980);
    dvd();
    super.onBackPressed();
    AppMethodBeat.o(222980);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(222969);
    super.onCreate(paramBundle);
    h.aGY().a(3593, (i)this);
    h.aGY().a(3638, (i)this);
    try
    {
      paramBundle = new bmq().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(222969);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      Log.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(222969);
      return;
    }
    this.xNt = ((bmq)paramBundle);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.feedId == 0L)
    {
      finish();
      Log.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(222969);
      return;
    }
    this.jlf = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.xNu = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    dve();
    AppMethodBeat.o(222969);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(222992);
    super.onDestroy();
    h.aGY().b(3593, (i)this);
    h.aGY().b(3638, (i)this);
    EventCenter.instance.removeListener(this.xyI);
    AppMethodBeat.o(222992);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    final boolean bool = false;
    AppMethodBeat.i(223016);
    if ((paramq instanceof bo))
    {
      Log.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(223016);
          throw paramString;
        }
        paramString = ((bo)paramq).dob();
        if ((p.h(this.xaw, paramString) ^ true))
        {
          Log.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(223016);
          return;
        }
        if (this.xaw == null) {
          bool = true;
        }
        if (bool)
        {
          this.jlf = ((bo)paramq).dol().jlf;
          updateTitle();
        }
        this.hasMore = ((bo)paramq).dod();
        this.xaw = ((bo)paramq).doa();
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new i(this, paramq, bool));
        AppMethodBeat.o(223016);
        return;
      }
      if (this.xaw == null)
      {
        paramString = this.kGj;
        if (paramString == null) {
          p.bGy("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.niO;
        if (paramString == null) {
          p.bGy("listView");
        }
        paramString.setVisibility(8);
        paramString = this.xNq;
        if (paramString == null) {
          p.bGy("loadingBar");
        }
        paramString.setVisibility(8);
        paramString = this.xNr;
        if (paramString == null) {
          p.bGy("retryTips");
        }
        paramString.setVisibility(0);
      }
      AppMethodBeat.o(223016);
      return;
    }
    if ((paramq instanceof ba))
    {
      Log.i(TAG, "NetSceneFinderContactTag errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((ba)paramq).xbh == null) {
          AppMethodBeat.o(223016);
        }
      }
      else {
        w.makeText((Context)this, b.j.app_err_server_busy_tip, 0).show();
      }
    }
    AppMethodBeat.o(223016);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(287171);
      FinderFriendRecommendUI.a(this.xNx);
      this.xNx.finish();
      AppMethodBeat.o(287171);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"})
  public static final class c
    implements AbsListView.OnScrollListener
  {
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(261908);
      if ((paramInt == 0) && (paramAbsListView != null) && (!paramAbsListView.canScrollVertically(1)))
      {
        if (FinderFriendRecommendUI.b(this.xNx))
        {
          FinderFriendRecommendUI.c(this.xNx);
          AppMethodBeat.o(261908);
          return;
        }
        this.xNx.dvf();
      }
      AppMethodBeat.o(261908);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(277664);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderFriendRecommendUI.c(this.xNx);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277664);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<awr, x>
  {
    e(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<awr, x>
  {
    f(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(270887);
      paramMenuItem = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramMenuItem = this.xNx.getContext();
      p.j(paramMenuItem, "context");
      com.tencent.mm.plugin.finder.utils.a.fJ((Context)paramMenuItem);
      AppMethodBeat.o(270887);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class h
    extends IListener<ho>
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$7$callback$1$1"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderFriendRecommendUI.h paramh, ho paramho)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(FinderFriendRecommendUI paramFinderFriendRecommendUI, com.tencent.mm.an.q paramq, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendRecommendUI
 * JD-Core Version:    0.7.0.1
 */