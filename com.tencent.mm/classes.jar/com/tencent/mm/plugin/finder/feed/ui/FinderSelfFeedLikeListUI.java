package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.s;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.dys;
import com.tencent.mm.protocal.protobuf.dzd;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyFooter", "Landroid/view/View;", "emptyTip", "Landroid/widget/TextView;", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "listView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "totalCount", "", "addNoMoreView", "", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderSelfFeedLikeListUI
  extends MMFinderUI
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.i.a.i<ajw>
{
  public static final a KSX;
  private static final String TAG = "Finder.FinderSelfFeedLikeListUI";
  private WxRecyclerView KSU;
  private com.tencent.mm.plugin.finder.ui.i KSV;
  private View KSW;
  private MMProcessBar KSh;
  private TextView KSi;
  private dzz KSk;
  private boolean KSl;
  private HashMap _$_findViewCache;
  private long feedId;
  private int fwP;
  private boolean hasMore;
  private final ArrayList<dzd> qHA;
  private TextView qKU;
  private com.tencent.mm.bx.b qKW;
  
  static
  {
    AppMethodBeat.i(198572);
    KSX = new a((byte)0);
    TAG = "Finder.FinderSelfFeedLikeListUI";
    AppMethodBeat.o(198572);
  }
  
  public FinderSelfFeedLikeListUI()
  {
    AppMethodBeat.i(198571);
    this.KSV = new com.tencent.mm.plugin.finder.ui.i();
    this.qHA = new ArrayList();
    AppMethodBeat.o(198571);
  }
  
  private final void fTJ()
  {
    AppMethodBeat.i(198567);
    at localat = new at(this.qKW, this.feedId, this.KSl);
    com.tencent.mm.kernel.g.aeS().b((n)localat);
    AppMethodBeat.o(198567);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(198565);
    setMMTitle(getString(2131766416, new Object[] { Integer.valueOf(this.fwP) }));
    AppMethodBeat.o(198565);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198575);
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
    AppMethodBeat.o(198575);
    return localView1;
  }
  
  public final void fTK()
  {
    AppMethodBeat.i(198570);
    Object localObject = this.KSW;
    if (localObject == null) {
      k.aPZ("emptyFooter");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.qKU;
    if (localObject == null) {
      k.aPZ("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.KSh;
    if (localObject == null) {
      k.aPZ("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(8);
    AppMethodBeat.o(198570);
  }
  
  public final int getLayoutId()
  {
    return 2131496253;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(198564);
    Object localObject = findViewById(2131307865);
    k.g(localObject, "findViewById(R.id.self_liked_recycler_view)");
    this.KSU = ((WxRecyclerView)localObject);
    localObject = findViewById(2131299472);
    k.g(localObject, "findViewById(R.id.empty_tip)");
    this.qKU = ((TextView)localObject);
    localObject = findViewById(2131307774);
    k.g(localObject, "findViewById(R.id.loading_bar)");
    this.KSh = ((MMProcessBar)localObject);
    localObject = findViewById(2131307836);
    k.g(localObject, "findViewById(R.id.retry_tips)");
    this.KSi = ((TextView)localObject);
    localObject = findViewById(2131307298);
    k.g(localObject, "findViewById(R.id.empty_footer)");
    this.KSW = ((View)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.KSU;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.KSV);
    localObject = this.KSU;
    if (localObject == null) {
      k.aPZ("listView");
    }
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.i)new GridLayoutManager(5));
    localObject = this.KSU;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((WxRecyclerView)localObject).b((RecyclerView.h)new c(this));
    localObject = this.KSU;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((WxRecyclerView)localObject).setOnScrollListener((RecyclerView.m)new d(this));
    localObject = this.KSi;
    if (localObject == null) {
      k.aPZ("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new e(this));
    localObject = this.qKU;
    if (localObject == null) {
      k.aPZ("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.KSU;
    if (localObject == null) {
      k.aPZ("listView");
    }
    ((WxRecyclerView)localObject).setVisibility(8);
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
    localObject = this.KSW;
    if (localObject == null) {
      k.aPZ("emptyFooter");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(198564);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198563);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.aeS().a(3593, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().a(3638, (com.tencent.mm.al.g)this);
    try
    {
      paramBundle = new dzz().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(198563);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      ad.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(198563);
      return;
    }
    this.KSk = ((dzz)paramBundle);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.feedId == 0L)
    {
      finish();
      ad.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(198563);
      return;
    }
    this.fwP = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.KSl = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    fTJ();
    AppMethodBeat.o(198563);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198568);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(3593, (com.tencent.mm.al.g)this);
    com.tencent.mm.kernel.g.aeS().b(3638, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(198568);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    final boolean bool = false;
    AppMethodBeat.i(198569);
    if ((paramn instanceof at))
    {
      ad.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(198569);
          throw paramString;
        }
        paramString = ((at)paramn).fRY();
        if ((k.g(this.qKW, paramString) ^ true))
        {
          ad.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(198569);
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
        c.g((d.g.a.a)new f(this, paramn, bool));
        AppMethodBeat.o(198569);
        return;
      }
      if (this.qKW == null)
      {
        paramString = this.qKU;
        if (paramString == null) {
          k.aPZ("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.KSU;
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
        paramString = this.KSW;
        if (paramString == null) {
          k.aPZ("emptyFooter");
        }
        paramString.setVisibility(8);
      }
    }
    AppMethodBeat.o(198569);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198557);
      this.KSY.finish();
      AppMethodBeat.o(198557);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(198558);
      k.h(paramRect, "outRect");
      k.h(paramView, "view");
      k.h(paramRecyclerView, "parent");
      k.h(params, "state");
      int i = RecyclerView.bw(paramView);
      paramView = this.KSY.getContext();
      k.g(paramView, "context");
      int j = (int)paramView.getResources().getDimension(2131165289);
      paramView = this.KSY.getContext();
      k.g(paramView, "context");
      int k = (int)paramView.getResources().getDimension(2131165290);
      paramView = this.KSY.getContext();
      k.g(paramView, "context");
      int m = (int)paramView.getResources().getDimension(2131165292);
      paramView = this.KSY.getContext();
      k.g(paramView, "context");
      int n = (int)paramView.getResources().getDimension(2131165303);
      if (i < 5) {}
      for (paramRect.top = j;; paramRect.top = k) {
        switch (i % 5)
        {
        default: 
          paramRect.left = n;
          paramRect.right = n;
          AppMethodBeat.o(198558);
          return;
        }
      }
      paramRect.left = m;
      paramRect.right = n;
      AppMethodBeat.o(198558);
      return;
      paramRect.left = n;
      paramRect.right = m;
      AppMethodBeat.o(198558);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(198560);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt1);
      localb.lT(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
      k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(198560);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(198559);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramRecyclerView);
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
      k.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if ((paramInt == 0) && (!paramRecyclerView.canScrollVertically(1)))
      {
        if (!FinderSelfFeedLikeListUI.a(this.KSY)) {
          break label98;
        }
        FinderSelfFeedLikeListUI.b(this.KSY);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(198559);
        return;
        label98:
        this.KSY.fTK();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198561);
      FinderSelfFeedLikeListUI.b(this.KSY);
      AppMethodBeat.o(198561);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI, n paramn, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSelfFeedLikeListUI
 * JD-Core Version:    0.7.0.1
 */