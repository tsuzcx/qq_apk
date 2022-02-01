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
import com.tencent.mm.ad.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.al;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.d;
import com.tencent.mm.plugin.i.a.s;
import com.tencent.mm.protocal.protobuf.anp;
import com.tencent.mm.protocal.protobuf.aot;
import com.tencent.mm.protocal.protobuf.apl;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.p;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyFooter", "Landroid/view/View;", "emptyTip", "Landroid/widget/TextView;", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "listView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "totalCount", "", "addNoMoreView", "", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderSelfFeedLikeListUI
  extends MMFinderUI
  implements f, s<apl>
{
  private static final String TAG = "Finder.FinderSelfFeedLikeListUI";
  public static final a shu;
  private HashMap _$_findViewCache;
  private long dtq;
  private int fTM;
  private TextView gWe;
  private boolean hasMore;
  private com.tencent.mm.bx.b rHF;
  private MMProcessBar seJ;
  private TextView seK;
  private atq seM;
  private boolean seN;
  private final ArrayList<aot> sec;
  private WxRecyclerView shr;
  private d shs;
  private View sht;
  
  static
  {
    AppMethodBeat.i(202874);
    shu = new a((byte)0);
    TAG = "Finder.FinderSelfFeedLikeListUI";
    AppMethodBeat.o(202874);
  }
  
  public FinderSelfFeedLikeListUI()
  {
    AppMethodBeat.i(202873);
    this.shs = new d();
    this.sec = new ArrayList();
    AppMethodBeat.o(202873);
  }
  
  private final void cCl()
  {
    AppMethodBeat.i(202869);
    al localal = new al(this.rHF, this.dtq, this.seN);
    g.aiU().b((n)localal);
    AppMethodBeat.o(202869);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(202867);
    setMMTitle(getString(2131766429, new Object[] { Integer.valueOf(this.fTM) }));
    AppMethodBeat.o(202867);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202877);
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
    AppMethodBeat.o(202877);
    return localView1;
  }
  
  public final void cCm()
  {
    AppMethodBeat.i(202872);
    Object localObject = this.sht;
    if (localObject == null) {
      p.bcb("emptyFooter");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.gWe;
    if (localObject == null) {
      p.bcb("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.seJ;
    if (localObject == null) {
      p.bcb("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(8);
    AppMethodBeat.o(202872);
  }
  
  public final int getLayoutId()
  {
    return 2131496254;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(202866);
    Object localObject = findViewById(2131307973);
    p.g(localObject, "findViewById(R.id.self_liked_recycler_view)");
    this.shr = ((WxRecyclerView)localObject);
    localObject = findViewById(2131299472);
    p.g(localObject, "findViewById(R.id.empty_tip)");
    this.gWe = ((TextView)localObject);
    localObject = findViewById(2131307853);
    p.g(localObject, "findViewById(R.id.loading_bar)");
    this.seJ = ((MMProcessBar)localObject);
    localObject = findViewById(2131307943);
    p.g(localObject, "findViewById(R.id.retry_tips)");
    this.seK = ((TextView)localObject);
    localObject = findViewById(2131307329);
    p.g(localObject, "findViewById(R.id.empty_footer)");
    this.sht = ((View)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.shr;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.shs);
    localObject = this.shr;
    if (localObject == null) {
      p.bcb("listView");
    }
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.i)new GridLayoutManager(5));
    localObject = this.shr;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((WxRecyclerView)localObject).b((RecyclerView.h)new c(this));
    localObject = this.shr;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((WxRecyclerView)localObject).setOnScrollListener((RecyclerView.m)new d(this));
    localObject = this.seK;
    if (localObject == null) {
      p.bcb("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new e(this));
    localObject = this.gWe;
    if (localObject == null) {
      p.bcb("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.shr;
    if (localObject == null) {
      p.bcb("listView");
    }
    ((WxRecyclerView)localObject).setVisibility(8);
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
    localObject = this.sht;
    if (localObject == null) {
      p.bcb("emptyFooter");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(202866);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202865);
    super.onCreate(paramBundle);
    g.aiU().a(3593, (f)this);
    g.aiU().a(3638, (f)this);
    try
    {
      paramBundle = new atq().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(202865);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      ad.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(202865);
      return;
    }
    this.seM = ((atq)paramBundle);
    this.dtq = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.dtq == 0L)
    {
      finish();
      ad.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(202865);
      return;
    }
    this.fTM = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.seN = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    cCl();
    AppMethodBeat.o(202865);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202870);
    super.onDestroy();
    g.aiU().b(3593, (f)this);
    g.aiU().b(3638, (f)this);
    AppMethodBeat.o(202870);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final n paramn)
  {
    final boolean bool = false;
    AppMethodBeat.i(202871);
    if ((paramn instanceof al))
    {
      ad.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramn == null)
        {
          paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(202871);
          throw paramString;
        }
        paramString = ((al)paramn).cym();
        if ((p.i(this.rHF, paramString) ^ true))
        {
          ad.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(202871);
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
        c.g((d.g.a.a)new f(this, paramn, bool));
        AppMethodBeat.o(202871);
        return;
      }
      if (this.rHF == null)
      {
        paramString = this.gWe;
        if (paramString == null) {
          p.bcb("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.shr;
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
        paramString = this.sht;
        if (paramString == null) {
          p.bcb("emptyFooter");
        }
        paramString.setVisibility(8);
      }
    }
    AppMethodBeat.o(202871);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202859);
      this.shv.finish();
      AppMethodBeat.o(202859);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(202860);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      int i = RecyclerView.bw(paramView);
      paramView = this.shv.getContext();
      p.g(paramView, "context");
      int j = (int)paramView.getResources().getDimension(2131165289);
      paramView = this.shv.getContext();
      p.g(paramView, "context");
      int k = (int)paramView.getResources().getDimension(2131165290);
      paramView = this.shv.getContext();
      p.g(paramView, "context");
      int m = (int)paramView.getResources().getDimension(2131165292);
      paramView = this.shv.getContext();
      p.g(paramView, "context");
      int n = (int)paramView.getResources().getDimension(2131165303);
      if (i < 5) {}
      for (paramRect.top = j;; paramRect.top = k) {
        switch (i % 5)
        {
        default: 
          paramRect.left = n;
          paramRect.right = n;
          AppMethodBeat.o(202860);
          return;
        }
      }
      paramRect.left = m;
      paramRect.right = n;
      AppMethodBeat.o(202860);
      return;
      paramRect.left = n;
      paramRect.right = m;
      AppMethodBeat.o(202860);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.m
  {
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(202862);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(202862);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(202861);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.b(paramRecyclerView, paramInt);
      if ((paramInt == 0) && (!paramRecyclerView.canScrollVertically(1)))
      {
        if (!FinderSelfFeedLikeListUI.a(this.shv)) {
          break label98;
        }
        FinderSelfFeedLikeListUI.b(this.shv);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(202861);
        return;
        label98:
        this.shv.cCm();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202863);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FinderSelfFeedLikeListUI.b(this.shv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202863);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSelfFeedLikeListUI
 * JD-Core Version:    0.7.0.1
 */