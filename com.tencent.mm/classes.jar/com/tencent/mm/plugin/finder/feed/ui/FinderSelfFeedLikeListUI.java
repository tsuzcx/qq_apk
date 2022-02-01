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
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.s;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.bl;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.h;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.protocal.protobuf.asc;
import com.tencent.mm.protocal.protobuf.aul;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.bfp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyFooter", "Landroid/view/View;", "emptyTip", "Landroid/widget/TextView;", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "listView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "totalCount", "", "addNoMoreView", "", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderSelfFeedLikeListUI
  extends MMFinderUI
  implements i, ai<ayt>
{
  private static final String TAG = "Finder.FinderSelfFeedLikeListUI";
  public static final a ucS;
  private HashMap _$_findViewCache;
  private long feedId;
  private int gAZ;
  private TextView hRM;
  private boolean hasMore;
  private com.tencent.mm.bw.b tsO;
  private MMProcessBar uaO;
  private TextView uaP;
  private bfp uaR;
  private boolean uaS;
  private final ArrayList<aul> uae;
  private WxRecyclerView ucP;
  private h ucQ;
  private View ucR;
  
  static
  {
    AppMethodBeat.i(245533);
    ucS = new a((byte)0);
    TAG = "Finder.FinderSelfFeedLikeListUI";
    AppMethodBeat.o(245533);
  }
  
  public FinderSelfFeedLikeListUI()
  {
    AppMethodBeat.i(245532);
    this.ucQ = new h();
    this.uae = new ArrayList();
    AppMethodBeat.o(245532);
  }
  
  private final void ddX()
  {
    AppMethodBeat.i(245528);
    bl localbl = new bl(this.tsO, this.feedId, this.uaS);
    g.azz().b((com.tencent.mm.ak.q)localbl);
    AppMethodBeat.o(245528);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(245526);
    setMMTitle(getString(2131759830, new Object[] { Integer.valueOf(this.gAZ) }));
    AppMethodBeat.o(245526);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245537);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245537);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245536);
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
    AppMethodBeat.o(245536);
    return localView1;
  }
  
  public final void ddY()
  {
    AppMethodBeat.i(245531);
    Object localObject = this.ucR;
    if (localObject == null) {
      p.btv("emptyFooter");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.hRM;
    if (localObject == null) {
      p.btv("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.uaO;
    if (localObject == null) {
      p.btv("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(8);
    AppMethodBeat.o(245531);
  }
  
  public final int getLayoutId()
  {
    return 2131494618;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(245525);
    Object localObject = findViewById(2131307591);
    p.g(localObject, "findViewById(R.id.self_liked_recycler_view)");
    this.ucP = ((WxRecyclerView)localObject);
    localObject = findViewById(2131300101);
    p.g(localObject, "findViewById(R.id.empty_tip)");
    this.hRM = ((TextView)localObject);
    localObject = findViewById(2131303694);
    p.g(localObject, "findViewById(R.id.loading_bar)");
    this.uaO = ((MMProcessBar)localObject);
    localObject = findViewById(2131307048);
    p.g(localObject, "findViewById(R.id.retry_tips)");
    this.uaP = ((TextView)localObject);
    localObject = findViewById(2131300090);
    p.g(localObject, "findViewById(R.id.empty_footer)");
    this.ucR = ((View)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.ucP;
    if (localObject == null) {
      p.btv("listView");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.ucQ);
    localObject = this.ucP;
    if (localObject == null) {
      p.btv("listView");
    }
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(5));
    localObject = this.ucP;
    if (localObject == null) {
      p.btv("listView");
    }
    ((WxRecyclerView)localObject).b((RecyclerView.h)new c(this));
    localObject = this.ucP;
    if (localObject == null) {
      p.btv("listView");
    }
    ((WxRecyclerView)localObject).setOnScrollListener((RecyclerView.l)new d(this));
    localObject = this.uaP;
    if (localObject == null) {
      p.btv("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new e(this));
    localObject = this.hRM;
    if (localObject == null) {
      p.btv("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.ucP;
    if (localObject == null) {
      p.btv("listView");
    }
    ((WxRecyclerView)localObject).setVisibility(8);
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
    localObject = this.ucR;
    if (localObject == null) {
      p.btv("emptyFooter");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(245525);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245524);
    super.onCreate(paramBundle);
    g.azz().a(3593, (i)this);
    g.azz().a(3638, (i)this);
    try
    {
      paramBundle = new bfp().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(245524);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      Log.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(245524);
      return;
    }
    this.uaR = ((bfp)paramBundle);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.feedId == 0L)
    {
      finish();
      Log.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(245524);
      return;
    }
    this.gAZ = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.uaS = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    ddX();
    AppMethodBeat.o(245524);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245529);
    super.onDestroy();
    g.azz().b(3593, (i)this);
    g.azz().b(3638, (i)this);
    AppMethodBeat.o(245529);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.q paramq)
  {
    final boolean bool = false;
    AppMethodBeat.i(245530);
    if ((paramq instanceof bl))
    {
      Log.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(245530);
          throw paramString;
        }
        paramString = ((bl)paramq).cYn();
        if ((p.j(this.tsO, paramString) ^ true))
        {
          Log.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(245530);
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
        d.h((kotlin.g.a.a)new f(this, paramq, bool));
        AppMethodBeat.o(245530);
        return;
      }
      if (this.tsO == null)
      {
        paramString = this.hRM;
        if (paramString == null) {
          p.btv("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.ucP;
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
        paramString = this.ucR;
        if (paramString == null) {
          p.btv("emptyFooter");
        }
        paramString.setVisibility(8);
      }
    }
    AppMethodBeat.o(245530);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245518);
      this.ucT.finish();
      AppMethodBeat.o(245518);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(245519);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      int i = RecyclerView.bw(paramView);
      paramView = this.ucT.getContext();
      p.g(paramView, "context");
      int j = (int)paramView.getResources().getDimension(2131165296);
      paramView = this.ucT.getContext();
      p.g(paramView, "context");
      int k = (int)paramView.getResources().getDimension(2131165297);
      paramView = this.ucT.getContext();
      p.g(paramView, "context");
      int m = (int)paramView.getResources().getDimension(2131165299);
      paramView = this.ucT.getContext();
      p.g(paramView, "context");
      int n = (int)paramView.getResources().getDimension(2131165314);
      if (i < 5) {}
      for (paramRect.top = j;; paramRect.top = k) {
        switch (i % 5)
        {
        default: 
          paramRect.left = n;
          paramRect.right = n;
          AppMethodBeat.o(245519);
          return;
        }
      }
      paramRect.left = m;
      paramRect.right = n;
      AppMethodBeat.o(245519);
      return;
      paramRect.left = n;
      paramRect.right = m;
      AppMethodBeat.o(245519);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(245520);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if ((paramInt == 0) && (!paramRecyclerView.canScrollVertically(1)))
      {
        if (!FinderSelfFeedLikeListUI.a(this.ucT)) {
          break label98;
        }
        FinderSelfFeedLikeListUI.b(this.ucT);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(245520);
        return;
        label98:
        this.ucT.ddY();
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(245521);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(245521);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245522);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderSelfFeedLikeListUI.b(this.ucT);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245522);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI, com.tencent.mm.ak.q paramq, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSelfFeedLikeListUI
 * JD-Core Version:    0.7.0.1
 */