package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.bo;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.f;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyFooter", "Landroid/view/View;", "emptyTip", "Landroid/widget/TextView;", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "listView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "totalCount", "", "addNoMoreView", "", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"})
public final class FinderSelfFeedLikeListUI
  extends MMFinderUI
  implements i, aj<beo>
{
  private static final String TAG = "Finder.FinderSelfFeedLikeListUI";
  public static final a xSi;
  private HashMap _$_findViewCache;
  private long feedId;
  private boolean hasMore;
  private int jlf;
  private TextView kGj;
  private final ArrayList<awr> xMG;
  private MMProcessBar xNq;
  private TextView xNr;
  private bmq xNt;
  private boolean xNu;
  private WxRecyclerView xSf;
  private f xSg;
  private View xSh;
  private com.tencent.mm.cd.b xaw;
  
  static
  {
    AppMethodBeat.i(287455);
    xSi = new a((byte)0);
    TAG = "Finder.FinderSelfFeedLikeListUI";
    AppMethodBeat.o(287455);
  }
  
  public FinderSelfFeedLikeListUI()
  {
    AppMethodBeat.i(287454);
    this.xSg = new f();
    this.xMG = new ArrayList();
    AppMethodBeat.o(287454);
  }
  
  private final void dve()
  {
    AppMethodBeat.i(287450);
    bo localbo = new bo(this.xaw, this.feedId, this.xNu);
    h.aGY().b((com.tencent.mm.an.q)localbo);
    AppMethodBeat.o(287450);
  }
  
  private final void updateTitle()
  {
    AppMethodBeat.i(287447);
    setMMTitle(getString(b.j.finder_like_count, new Object[] { Integer.valueOf(this.jlf) }));
    AppMethodBeat.o(287447);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(287461);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(287461);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(287459);
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
    AppMethodBeat.o(287459);
    return localView1;
  }
  
  public final void dvf()
  {
    AppMethodBeat.i(287453);
    Object localObject = this.xSh;
    if (localObject == null) {
      p.bGy("emptyFooter");
    }
    ((View)localObject).setVisibility(0);
    localObject = this.kGj;
    if (localObject == null) {
      p.bGy("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.xNq;
    if (localObject == null) {
      p.bGy("loadingBar");
    }
    ((MMProcessBar)localObject).setVisibility(8);
    AppMethodBeat.o(287453);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_self_feed_like_list_layout;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(287446);
    Object localObject = findViewById(b.f.self_liked_recycler_view);
    p.j(localObject, "findViewById(R.id.self_liked_recycler_view)");
    this.xSf = ((WxRecyclerView)localObject);
    localObject = findViewById(b.f.empty_tip);
    p.j(localObject, "findViewById(R.id.empty_tip)");
    this.kGj = ((TextView)localObject);
    localObject = findViewById(b.f.loading_bar);
    p.j(localObject, "findViewById(R.id.loading_bar)");
    this.xNq = ((MMProcessBar)localObject);
    localObject = findViewById(b.f.retry_tips);
    p.j(localObject, "findViewById(R.id.retry_tips)");
    this.xNr = ((TextView)localObject);
    localObject = findViewById(b.f.empty_footer);
    p.j(localObject, "findViewById(R.id.empty_footer)");
    this.xSh = ((View)localObject);
    updateTitle();
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    localObject = this.xSf;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)this.xSg);
    localObject = this.xSf;
    if (localObject == null) {
      p.bGy("listView");
    }
    getContext();
    ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(5));
    localObject = this.xSf;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((WxRecyclerView)localObject).b((RecyclerView.h)new c(this));
    localObject = this.xSf;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((WxRecyclerView)localObject).setOnScrollListener((RecyclerView.l)new d(this));
    localObject = this.xNr;
    if (localObject == null) {
      p.bGy("retryTips");
    }
    ((TextView)localObject).setOnClickListener((View.OnClickListener)new e(this));
    localObject = this.kGj;
    if (localObject == null) {
      p.bGy("emptyTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.xSf;
    if (localObject == null) {
      p.bGy("listView");
    }
    ((WxRecyclerView)localObject).setVisibility(8);
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
    localObject = this.xSh;
    if (localObject == null) {
      p.bGy("emptyFooter");
    }
    ((View)localObject).setVisibility(8);
    AppMethodBeat.o(287446);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(287445);
    super.onCreate(paramBundle);
    h.aGY().a(3593, (i)this);
    h.aGY().a(3638, (i)this);
    try
    {
      paramBundle = new bmq().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(287445);
        throw paramBundle;
      }
    }
    catch (Throwable paramBundle)
    {
      finish();
      Log.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(287445);
      return;
    }
    this.xNt = ((bmq)paramBundle);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.feedId == 0L)
    {
      finish();
      Log.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(287445);
      return;
    }
    this.jlf = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.xNu = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    dve();
    AppMethodBeat.o(287445);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(287451);
    super.onDestroy();
    h.aGY().b(3593, (i)this);
    h.aGY().b(3638, (i)this);
    AppMethodBeat.o(287451);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    final boolean bool = false;
    AppMethodBeat.i(287452);
    if ((paramq instanceof bo))
    {
      Log.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramq == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(287452);
          throw paramString;
        }
        paramString = ((bo)paramq).dob();
        if ((p.h(this.xaw, paramString) ^ true))
        {
          Log.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(287452);
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
        d.uiThread((kotlin.g.a.a)new f(this, paramq, bool));
        AppMethodBeat.o(287452);
        return;
      }
      if (this.xaw == null)
      {
        paramString = this.kGj;
        if (paramString == null) {
          p.bGy("emptyTip");
        }
        paramString.setVisibility(8);
        paramString = this.xSf;
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
        paramString = this.xSh;
        if (paramString == null) {
          p.bGy("emptyFooter");
        }
        paramString.setVisibility(8);
      }
    }
    AppMethodBeat.o(287452);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(279387);
      this.xSj.finish();
      AppMethodBeat.o(279387);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"})
  public static final class c
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(283664);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      int i = RecyclerView.bh(paramView);
      paramView = this.xSj.getContext();
      p.j(paramView, "context");
      int j = (int)paramView.getResources().getDimension(b.d.Edge_2A);
      paramView = this.xSj.getContext();
      p.j(paramView, "context");
      int k = (int)paramView.getResources().getDimension(b.d.Edge_2_5_A);
      paramView = this.xSj.getContext();
      p.j(paramView, "context");
      int m = (int)paramView.getResources().getDimension(b.d.Edge_3A);
      paramView = this.xSj.getContext();
      p.j(paramView, "context");
      int n = (int)paramView.getResources().getDimension(b.d.Edge_A);
      if (i < 5) {}
      for (paramRect.top = j;; paramRect.top = k) {
        switch (i % 5)
        {
        default: 
          paramRect.left = n;
          paramRect.right = n;
          AppMethodBeat.o(283664);
          return;
        }
      }
      paramRect.left = m;
      paramRect.right = n;
      AppMethodBeat.o(283664);
      return;
      paramRect.left = n;
      paramRect.right = m;
      AppMethodBeat.o(283664);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"})
  public static final class d
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(287658);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if ((paramInt == 0) && (!paramRecyclerView.canScrollVertically(1)))
      {
        if (!FinderSelfFeedLikeListUI.a(this.xSj)) {
          break label98;
        }
        FinderSelfFeedLikeListUI.b(this.xSj);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(287658);
        return;
        label98:
        this.xSj.dvf();
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287659);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(287659);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(272258);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FinderSelfFeedLikeListUI.b(this.xSj);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(272258);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    f(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI, com.tencent.mm.an.q paramq, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSelfFeedLikeListUI
 * JD-Core Version:    0.7.0.1
 */