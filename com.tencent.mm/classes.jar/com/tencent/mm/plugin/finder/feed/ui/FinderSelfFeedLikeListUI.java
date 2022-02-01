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
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.h;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.protocal.protobuf.alo;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyFooter", "Landroid/view/View;", "emptyTip", "Landroid/widget/TextView;", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "listView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "totalCount", "", "addNoMoreView", "", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderSelfFeedLikeListUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.i.a.k<amf>
{
  private static final String TAG = "Finder.FinderSelfFeedLikeListUI";
  public static final FinderSelfFeedLikeListUI.a rsm;
  private HashMap _$_findViewCache;
  private long dig;
  private int fAw;
  private TextView gCu;
  private boolean hasMore;
  private MMProcessBar rpU;
  private TextView rpV;
  private com.tencent.mm.bw.b rpX;
  private apw rpY;
  private boolean rpZ;
  private final ArrayList<alo> rpr;
  private WxRecyclerView rsj;
  private h rsk;
  private View rsl;
  
  static
  {
    AppMethodBeat.i(202493);
    rsm = new FinderSelfFeedLikeListUI.a((byte)0);
    TAG = "Finder.FinderSelfFeedLikeListUI";
    AppMethodBeat.o(202493);
  }
  
  public FinderSelfFeedLikeListUI()
  {
    AppMethodBeat.i(202492);
    this.rsk = new h();
    this.rpr = new ArrayList();
    AppMethodBeat.o(202492);
  }
  
  private final void cvW()
  {
    AppMethodBeat.i(202488);
    ae localae = new ae(this.rpX, this.dig, this.rpZ);
    com.tencent.mm.kernel.g.agi().b((n)localae);
    AppMethodBeat.o(202488);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(202486);
    setMMTitle(getString(2131766429, new Object[] { Integer.valueOf(this.fAw) }));
    AppMethodBeat.o(202486);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202496);
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
    AppMethodBeat.o(202496);
    return localView1;
  }
  
  public final void cvX()
  {
    AppMethodBeat.i(202491);
    Object localObject = this.rsl;
    if (localObject == null) {
      d.g.b.k.aVY("emptyFooter");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.gCu;
    if (localObject == null) {
      d.g.b.k.aVY("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.rpU;
    if (localObject == null) {
      d.g.b.k.aVY("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(8);
    AppMethodBeat.o(202491);
  }
  
  public final int getLayoutId()
  {
    return 2131496254;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(202485);
    Object localObject = findViewById(2131307973);
    d.g.b.k.g(localObject, "findViewById(R.id.self_liked_recycler_view)");
    this.rsj = ((WxRecyclerView)localObject);
    localObject = findViewById(2131299472);
    d.g.b.k.g(localObject, "findViewById(R.id.empty_tip)");
    this.gCu = ((TextView)localObject);
    localObject = findViewById(2131307853);
    d.g.b.k.g(localObject, "findViewById(R.id.loading_bar)");
    this.rpU = ((MMProcessBar)localObject);
    localObject = findViewById(2131307943);
    d.g.b.k.g(localObject, "findViewById(R.id.retry_tips)");
    this.rpV = ((TextView)localObject);
    localObject = findViewById(2131307329);
    d.g.b.k.g(localObject, "findViewById(R.id.empty_footer)");
    this.rsl = ((View)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.rsj;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.rsk);
    localObject = this.rsj;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.i)new GridLayoutManager(5));
    localObject = this.rsj;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((WxRecyclerView)localObject).b((RecyclerView.h)new c(this));
    localObject = this.rsj;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((WxRecyclerView)localObject).setOnScrollListener((RecyclerView.m)new d(this));
    localObject = this.rpV;
    if (localObject == null) {
      d.g.b.k.aVY("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new e(this));
    localObject = this.gCu;
    if (localObject == null) {
      d.g.b.k.aVY("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.rsj;
    if (localObject == null) {
      d.g.b.k.aVY("listView");
    }
    ((WxRecyclerView)localObject).setVisibility(8);
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
    localObject = this.rsl;
    if (localObject == null) {
      d.g.b.k.aVY("emptyFooter");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(202485);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202484);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(3593, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().a(3638, (com.tencent.mm.ak.g)this);
    try
    {
      paramBundle = new apw().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(202484);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      ac.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(202484);
      return;
    }
    this.rpY = ((apw)paramBundle);
    this.dig = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.dig == 0L)
    {
      finish();
      ac.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(202484);
      return;
    }
    this.fAw = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.rpZ = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    cvW();
    AppMethodBeat.o(202484);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202489);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(3593, (com.tencent.mm.ak.g)this);
    com.tencent.mm.kernel.g.agi().b(3638, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(202489);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    final boolean bool = false;
    AppMethodBeat.i(202490);
    if ((paramn instanceof ae))
    {
      ac.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(202490);
          throw paramString;
        }
        paramString = ((ae)paramn).csv();
        if ((d.g.b.k.g(this.rpX, paramString) ^ true))
        {
          ac.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(202490);
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
        c.g((d.g.a.a)new f(this, paramn, bool));
        AppMethodBeat.o(202490);
        return;
      }
      if (this.rpX == null)
      {
        paramString = this.gCu;
        if (paramString == null) {
          d.g.b.k.aVY("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.rsj;
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
        paramString = this.rsl;
        if (paramString == null) {
          d.g.b.k.aVY("emptyFooter");
        }
        paramString.setVisibility(8);
      }
    }
    AppMethodBeat.o(202490);
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
    b(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202478);
      this.rsn.finish();
      AppMethodBeat.o(202478);
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(202479);
      d.g.b.k.h(paramRect, "outRect");
      d.g.b.k.h(paramView, "view");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(paramt, "state");
      int i = RecyclerView.bw(paramView);
      paramView = this.rsn.getContext();
      d.g.b.k.g(paramView, "context");
      int j = (int)paramView.getResources().getDimension(2131165289);
      paramView = this.rsn.getContext();
      d.g.b.k.g(paramView, "context");
      int k = (int)paramView.getResources().getDimension(2131165290);
      paramView = this.rsn.getContext();
      d.g.b.k.g(paramView, "context");
      int m = (int)paramView.getResources().getDimension(2131165292);
      paramView = this.rsn.getContext();
      d.g.b.k.g(paramView, "context");
      int n = (int)paramView.getResources().getDimension(2131165303);
      if (i < 5) {}
      for (paramRect.top = j;; paramRect.top = k) {
        switch (i % 5)
        {
        default: 
          paramRect.left = n;
          paramRect.right = n;
          AppMethodBeat.o(202479);
          return;
        }
      }
      paramRect.left = m;
      paramRect.right = n;
      AppMethodBeat.o(202479);
      return;
      paramRect.left = n;
      paramRect.right = m;
      AppMethodBeat.o(202479);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202481);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt1);
      localb.lS(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202481);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202480);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramRecyclerView);
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
      d.g.b.k.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if ((paramInt == 0) && (!paramRecyclerView.canScrollVertically(1)))
      {
        if (!FinderSelfFeedLikeListUI.a(this.rsn)) {
          break label98;
        }
        FinderSelfFeedLikeListUI.b(this.rsn);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(202480);
        return;
        label98:
        this.rsn.cvX();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202482);
      FinderSelfFeedLikeListUI.b(this.rsn);
      AppMethodBeat.o(202482);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSelfFeedLikeListUI
 * JD-Core Version:    0.7.0.1
 */