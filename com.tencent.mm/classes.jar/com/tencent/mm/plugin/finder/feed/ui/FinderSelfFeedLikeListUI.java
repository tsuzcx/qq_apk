package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.cgi.cl;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.g;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyFooter", "Landroid/view/View;", "emptyTip", "Landroid/widget/TextView;", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderSelfFeedLikeListAdapter;", "listView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "totalCount", "", "addNoMoreView", "", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderSelfFeedLikeListUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, ck<bpp>
{
  public static final a BrB;
  private static final String TAG;
  private com.tencent.mm.bx.b AyB;
  private final ArrayList<bco> BmO;
  private MMProcessBar Bno;
  private TextView Bnp;
  private cak Bnr;
  private boolean Bns;
  private WxRecyclerView BrC;
  private g BrD;
  private View BrE;
  private long feedId;
  private boolean hasMore;
  private int lNX;
  private TextView njh;
  
  static
  {
    AppMethodBeat.i(364757);
    BrB = new a((byte)0);
    TAG = "Finder.FinderSelfFeedLikeListUI";
    AppMethodBeat.o(364757);
  }
  
  public FinderSelfFeedLikeListUI()
  {
    AppMethodBeat.i(364695);
    this.BrD = new g();
    this.BmO = new ArrayList();
    AppMethodBeat.o(364695);
  }
  
  private static final void a(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI, View paramView)
  {
    AppMethodBeat.i(364721);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderSelfFeedLikeListUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderSelfFeedLikeListUI, "this$0");
    paramFinderSelfFeedLikeListUI.eeR();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364721);
  }
  
  private static final boolean a(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364714);
    kotlin.g.b.s.u(paramFinderSelfFeedLikeListUI, "this$0");
    paramFinderSelfFeedLikeListUI.finish();
    AppMethodBeat.o(364714);
    return true;
  }
  
  private final void aMl()
  {
    AppMethodBeat.i(364700);
    setMMTitle(getString(e.h.finder_like_count, new Object[] { Integer.valueOf(this.lNX) }));
    AppMethodBeat.o(364700);
  }
  
  private final void eeR()
  {
    AppMethodBeat.i(364708);
    cl localcl = new cl(this.AyB, this.feedId, this.Bns);
    com.tencent.mm.kernel.h.aZW().a((p)localcl, 0);
    AppMethodBeat.o(364708);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void eeS()
  {
    Object localObject2 = null;
    AppMethodBeat.i(364813);
    Object localObject3 = this.BrE;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("emptyFooter");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localObject3 = this.njh;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("emptyTip");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(8);
    localObject1 = this.Bno;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("loadingBar");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((MMProcessBar)localObject1).setVisibility(8);
      AppMethodBeat.o(364813);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_self_feed_like_list_layout;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(364789);
    Object localObject1 = findViewById(e.e.self_liked_recycler_view);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.self_liked_recycler_view)");
    this.BrC = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(e.e.empty_tip);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.empty_tip)");
    this.njh = ((TextView)localObject1);
    localObject1 = findViewById(e.e.loading_bar);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.loading_bar)");
    this.Bno = ((MMProcessBar)localObject1);
    localObject1 = findViewById(e.e.retry_tips);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.retry_tips)");
    this.Bnp = ((TextView)localObject1);
    localObject1 = findViewById(e.e.empty_footer);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.empty_footer)");
    this.BrE = ((View)localObject1);
    aMl();
    setBackBtn(new FinderSelfFeedLikeListUI..ExternalSyntheticLambda0(this));
    localObject1 = this.BrC;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)this.BrD);
      localObject1 = this.BrC;
      if (localObject1 != null) {
        break label418;
      }
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      label179:
      getContext();
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new GridLayoutManager(5));
      localObject1 = this.BrC;
      if (localObject1 != null) {
        break label421;
      }
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      label215:
      ((RecyclerView)localObject1).a((RecyclerView.h)new b(this));
      localObject1 = this.BrC;
      if (localObject1 != null) {
        break label424;
      }
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      label246:
      ((WxRecyclerView)localObject1).setOnScrollListener((RecyclerView.l)new c(this));
      Object localObject3 = this.Bnp;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("retryTips");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(new FinderSelfFeedLikeListUI..ExternalSyntheticLambda1(this));
      localObject3 = this.njh;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(8);
      localObject3 = this.BrC;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("listView");
        localObject1 = null;
      }
      ((WxRecyclerView)localObject1).setVisibility(8);
      localObject3 = this.Bno;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("loadingBar");
        localObject1 = null;
      }
      ((MMProcessBar)localObject1).setVisibility(0);
      localObject3 = this.Bnp;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("retryTips");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = this.BrE;
      if (localObject1 != null) {
        break label427;
      }
      kotlin.g.b.s.bIx("emptyFooter");
      localObject1 = localObject2;
    }
    label418:
    label421:
    label424:
    label427:
    for (;;)
    {
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(364789);
      return;
      break;
      break label179;
      break label215;
      break label246;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364779);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3593, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(3638, (com.tencent.mm.am.h)this);
    try
    {
      paramBundle = new cak().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(364779);
        throw paramBundle;
      }
    }
    finally
    {
      finish();
      Log.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(364779);
      return;
    }
    this.Bnr = ((cak)paramBundle);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.feedId == 0L)
    {
      finish();
      Log.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(364779);
      return;
    }
    this.lNX = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.Bns = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    eeR();
    AppMethodBeat.o(364779);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364796);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3593, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3638, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(364796);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(364808);
    if ((paramp instanceof cl))
    {
      Log.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(364808);
          throw paramString;
        }
        paramString = ((cl)paramp).dVL();
        if (!kotlin.g.b.s.p(this.AyB, paramString))
        {
          Log.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(364808);
          return;
        }
        if (this.AyB == null) {}
        for (final boolean bool = true;; bool = false)
        {
          if (bool)
          {
            this.lNX = ((cl)paramp).dVV().lNX;
            aMl();
          }
          this.hasMore = ((cl)paramp).dVN();
          this.AyB = ((cl)paramp).dVJ();
          d.uiThread((kotlin.g.a.a)new d(this, paramp, bool));
          AppMethodBeat.o(364808);
          return;
        }
      }
      if (this.AyB == null)
      {
        paramp = this.njh;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("emptyTip");
          paramString = null;
        }
        paramString.setVisibility(8);
        paramp = this.BrC;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("listView");
          paramString = null;
        }
        paramString.setVisibility(8);
        paramp = this.Bno;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("loadingBar");
          paramString = null;
        }
        paramString.setVisibility(8);
        paramp = this.Bnp;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("retryTips");
          paramString = null;
        }
        paramString.setVisibility(0);
        paramString = this.BrE;
        if (paramString != null) {
          break label361;
        }
        kotlin.g.b.s.bIx("emptyFooter");
        paramString = localObject;
      }
    }
    label361:
    for (;;)
    {
      paramString.setVisibility(8);
      AppMethodBeat.o(364808);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.h
  {
    b(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(364904);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramView, "view");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      kotlin.g.b.s.u(params, "state");
      int i = RecyclerView.bA(paramView);
      int j = (int)this.BrF.getContext().getResources().getDimension(e.c.Edge_2A);
      int k = (int)this.BrF.getContext().getResources().getDimension(e.c.Edge_2_5_A);
      int m = (int)this.BrF.getContext().getResources().getDimension(e.c.Edge_3A);
      int n = (int)this.BrF.getContext().getResources().getDimension(e.c.Edge_A);
      if (i < 5) {}
      for (paramRect.top = j;; paramRect.top = k) {
        switch (i % 5)
        {
        default: 
          paramRect.left = n;
          paramRect.right = n;
          AppMethodBeat.o(364904);
          return;
        }
      }
      paramRect.left = m;
      paramRect.right = n;
      AppMethodBeat.o(364904);
      return;
      paramRect.left = n;
      paramRect.right = m;
      AppMethodBeat.o(364904);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.l
  {
    c(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(364908);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        localObject = this.BrF;
        if (!paramRecyclerView.canScrollVertically(1))
        {
          if (!FinderSelfFeedLikeListUI.a((FinderSelfFeedLikeListUI)localObject)) {
            break label97;
          }
          FinderSelfFeedLikeListUI.b((FinderSelfFeedLikeListUI)localObject);
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(364908);
        return;
        label97:
        ((FinderSelfFeedLikeListUI)localObject).eeS();
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(364913);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderSelfFeedLikeListUI$initView$3", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(364913);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(FinderSelfFeedLikeListUI paramFinderSelfFeedLikeListUI, p paramp, boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderSelfFeedLikeListUI
 * JD-Core Version:    0.7.0.1
 */