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
import android.support.v7.widget.RecyclerView.t;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.d;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.apy;
import com.tencent.mm.protocal.protobuf.aug;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyFooter", "Landroid/view/View;", "emptyTip", "Landroid/widget/TextView;", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "listView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "totalCount", "", "addNoMoreView", "", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderSelfFeedLikeListUI
  extends MMFinderUI
  implements f, s<apy>
{
  private static final String TAG = "Finder.FinderSelfFeedLikeListUI";
  public static final FinderSelfFeedLikeListUI.a sqp;
  private HashMap _$_findViewCache;
  private long duw;
  private int fVS;
  private TextView gYR;
  private boolean hasMore;
  private com.tencent.mm.bw.b rPQ;
  private final ArrayList<apg> smS;
  private aug snB;
  private boolean snC;
  private MMProcessBar sny;
  private TextView snz;
  private WxRecyclerView sqm;
  private d sqn;
  private View sqo;
  
  static
  {
    AppMethodBeat.i(203353);
    sqp = new FinderSelfFeedLikeListUI.a((byte)0);
    TAG = "Finder.FinderSelfFeedLikeListUI";
    AppMethodBeat.o(203353);
  }
  
  public FinderSelfFeedLikeListUI()
  {
    AppMethodBeat.i(203352);
    this.sqn = new d();
    this.smS = new ArrayList();
    AppMethodBeat.o(203352);
  }
  
  private final void cDX()
  {
    AppMethodBeat.i(203348);
    am localam = new am(this.rPQ, this.duw, this.snC);
    g.ajj().b((n)localam);
    AppMethodBeat.o(203348);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(203346);
    setMMTitle(getString(2131766429, new Object[] { Integer.valueOf(this.fVS) }));
    AppMethodBeat.o(203346);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203356);
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
    AppMethodBeat.o(203356);
    return localView1;
  }
  
  public final void cDY()
  {
    AppMethodBeat.i(203351);
    Object localObject = this.sqo;
    if (localObject == null) {
      p.bdF("emptyFooter");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.gYR;
    if (localObject == null) {
      p.bdF("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.sny;
    if (localObject == null) {
      p.bdF("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(8);
    AppMethodBeat.o(203351);
  }
  
  public final int getLayoutId()
  {
    return 2131496254;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(203345);
    Object localObject = findViewById(2131307973);
    p.g(localObject, "findViewById(R.id.self_liked_recycler_view)");
    this.sqm = ((WxRecyclerView)localObject);
    localObject = findViewById(2131299472);
    p.g(localObject, "findViewById(R.id.empty_tip)");
    this.gYR = ((TextView)localObject);
    localObject = findViewById(2131307853);
    p.g(localObject, "findViewById(R.id.loading_bar)");
    this.sny = ((MMProcessBar)localObject);
    localObject = findViewById(2131307943);
    p.g(localObject, "findViewById(R.id.retry_tips)");
    this.snz = ((TextView)localObject);
    localObject = findViewById(2131307329);
    p.g(localObject, "findViewById(R.id.empty_footer)");
    this.sqo = ((View)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderSelfFeedLikeListUI.b(this));
    localObject = this.sqm;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.sqn);
    localObject = this.sqm;
    if (localObject == null) {
      p.bdF("listView");
    }
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.i)new GridLayoutManager(5));
    localObject = this.sqm;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((WxRecyclerView)localObject).b((RecyclerView.h)new c(this));
    localObject = this.sqm;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((WxRecyclerView)localObject).setOnScrollListener((RecyclerView.m)new d(this));
    localObject = this.snz;
    if (localObject == null) {
      p.bdF("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new FinderSelfFeedLikeListUI.e(this));
    localObject = this.gYR;
    if (localObject == null) {
      p.bdF("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.sqm;
    if (localObject == null) {
      p.bdF("listView");
    }
    ((WxRecyclerView)localObject).setVisibility(8);
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
    localObject = this.sqo;
    if (localObject == null) {
      p.bdF("emptyFooter");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(203345);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203344);
    super.onCreate(paramBundle);
    g.ajj().a(3593, (f)this);
    g.ajj().a(3638, (f)this);
    try
    {
      paramBundle = new aug().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(203344);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      ae.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(203344);
      return;
    }
    this.snB = ((aug)paramBundle);
    this.duw = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.duw == 0L)
    {
      finish();
      ae.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(203344);
      return;
    }
    this.fVS = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.snC = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    cDX();
    AppMethodBeat.o(203344);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203349);
    super.onDestroy();
    g.ajj().b(3593, (f)this);
    g.ajj().b(3638, (f)this);
    AppMethodBeat.o(203349);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    final boolean bool = false;
    AppMethodBeat.i(203350);
    if ((paramn instanceof am))
    {
      ae.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(203350);
          throw paramString;
        }
        paramString = ((am)paramn).czN();
        if ((p.i(this.rPQ, paramString) ^ true))
        {
          ae.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(203350);
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
        c.h((d.g.a.a)new f(this, paramn, bool));
        AppMethodBeat.o(203350);
        return;
      }
      if (this.rPQ == null)
      {
        paramString = this.gYR;
        if (paramString == null) {
          p.bdF("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.sqm;
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
        paramString = this.sqo;
        if (paramString == null) {
          p.bdF("emptyFooter");
        }
        paramString.setVisibility(8);
      }
    }
    AppMethodBeat.o(203350);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(203339);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      int i = RecyclerView.bw(paramView);
      paramView = this.sqq.getContext();
      p.g(paramView, "context");
      int j = (int)paramView.getResources().getDimension(2131165289);
      paramView = this.sqq.getContext();
      p.g(paramView, "context");
      int k = (int)paramView.getResources().getDimension(2131165290);
      paramView = this.sqq.getContext();
      p.g(paramView, "context");
      int m = (int)paramView.getResources().getDimension(2131165292);
      paramView = this.sqq.getContext();
      p.g(paramView, "context");
      int n = (int)paramView.getResources().getDimension(2131165303);
      if (i < 5) {}
      for (paramRect.top = j;; paramRect.top = k) {
        switch (i % 5)
        {
        default: 
          paramRect.left = n;
          paramRect.right = n;
          AppMethodBeat.o(203339);
          return;
        }
      }
      paramRect.left = m;
      paramRect.right = n;
      AppMethodBeat.o(203339);
      return;
      paramRect.left = n;
      paramRect.right = m;
      AppMethodBeat.o(203339);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(203341);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(203341);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(203340);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if ((paramInt == 0) && (!paramRecyclerView.canScrollVertically(1)))
      {
        if (!FinderSelfFeedLikeListUI.a(this.sqq)) {
          break label98;
        }
        FinderSelfFeedLikeListUI.b(this.sqq);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(203340);
        return;
        label98:
        this.sqq.cDY();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    f(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI, n paramn, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSelfFeedLikeListUI
 * JD-Core Version:    0.7.0.1
 */