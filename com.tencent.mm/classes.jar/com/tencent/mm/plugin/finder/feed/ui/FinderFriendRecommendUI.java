package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.hz;
import com.tencent.mm.autogen.a.jw;
import com.tencent.mm.plugin.finder.cgi.bw;
import com.tencent.mm.plugin.finder.cgi.cl;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.ayv;
import com.tencent.mm.protocal.protobuf.bco;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.widget.MMProcessBar;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "MENU_BLACK_LIST", "", "actionInfo", "Lcom/tencent/mm/protocal/protobuf/FriendLikeFinderObject;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;", "Lkotlin/collections/ArrayList;", "emptyTip", "Landroid/widget/TextView;", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLikeEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedId", "", "hasMore", "", "isPosterView", "lastBuf", "Lcom/tencent/mm/protobuf/ByteString;", "listAdapter", "Lcom/tencent/mm/plugin/finder/ui/FinderFriendRecommendAdapter;", "listView", "Landroid/widget/ListView;", "loadingBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "retryTips", "totalCount", "addNoMoreView", "", "checkFinish", "doGetFriendRecommednScene", "getLayoutId", "initView", "merge", "contacts", "", "isFirstPage", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "showEmptyView", "showErrorView", "showListView", "showLoadingView", "updateTitle", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFriendRecommendUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, ck<bpp>
{
  public static final a Bnn;
  private static final String TAG;
  private com.tencent.mm.bx.b AyB;
  private final ArrayList<bco> BmO;
  private MMProcessBar Bno;
  private TextView Bnp;
  private final com.tencent.mm.plugin.finder.ui.d Bnq;
  private cak Bnr;
  private boolean Bns;
  private final int Bnt;
  private long feedId;
  private boolean hasMore;
  private int lNX;
  private TextView njh;
  private ListView qgc;
  private IListener<hz> qmO;
  
  static
  {
    AppMethodBeat.i(365133);
    Bnn = new a((byte)0);
    TAG = "Finder.FinderFriendRecommendUI";
    AppMethodBeat.o(365133);
  }
  
  public FinderFriendRecommendUI()
  {
    AppMethodBeat.i(365050);
    this.Bnq = new com.tencent.mm.plugin.finder.ui.d((Activity)this);
    this.BmO = new ArrayList();
    this.Bnt = 2;
    AppMethodBeat.o(365050);
  }
  
  private static final void a(FinderFriendRecommendUI paramFinderFriendRecommendUI, View paramView)
  {
    AppMethodBeat.i(365085);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderFriendRecommendUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderFriendRecommendUI, "this$0");
    paramFinderFriendRecommendUI.eeR();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365085);
  }
  
  private static final boolean a(FinderFriendRecommendUI paramFinderFriendRecommendUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365077);
    kotlin.g.b.s.u(paramFinderFriendRecommendUI, "this$0");
    paramFinderFriendRecommendUI.eeQ();
    paramFinderFriendRecommendUI.finish();
    AppMethodBeat.o(365077);
    return true;
  }
  
  private final void aMl()
  {
    AppMethodBeat.i(365061);
    setMMTitle(getString(e.h.finder_liked_ui_title, new Object[] { Integer.valueOf(this.lNX) }));
    AppMethodBeat.o(365061);
  }
  
  private static final boolean b(FinderFriendRecommendUI paramFinderFriendRecommendUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365091);
    kotlin.g.b.s.u(paramFinderFriendRecommendUI, "this$0");
    paramMenuItem = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramFinderFriendRecommendUI = paramFinderFriendRecommendUI.getContext();
    kotlin.g.b.s.s(paramFinderFriendRecommendUI, "context");
    com.tencent.mm.plugin.finder.utils.a.hd((Context)paramFinderFriendRecommendUI);
    AppMethodBeat.o(365091);
    return true;
  }
  
  private final void eeQ()
  {
    AppMethodBeat.i(365055);
    if ((this.lNX == 1) && (this.BmO.size() == 1))
    {
      Object localObject = this.BmO.get(0);
      kotlin.g.b.s.s(localObject, "contactList[0]");
      localObject = (bco)localObject;
      if (((bco)localObject).ZNz == 1)
      {
        jw localjw = new jw();
        localjw.hLu.hLv = ((bco)localObject).hLv;
        localjw.publish();
      }
    }
    AppMethodBeat.o(365055);
  }
  
  private final void eeR()
  {
    AppMethodBeat.i(365070);
    cl localcl = new cl(this.AyB, this.feedId, this.Bns);
    com.tencent.mm.kernel.h.aZW().a((p)localcl, 0);
    AppMethodBeat.o(365070);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void eeS()
  {
    AppMethodBeat.i(365207);
    ListView localListView2 = this.qgc;
    ListView localListView1 = localListView2;
    if (localListView2 == null)
    {
      kotlin.g.b.s.bIx("listView");
      localListView1 = null;
    }
    if (localListView1.getFooterViewsCount() == 0)
    {
      localListView2 = this.qgc;
      localListView1 = localListView2;
      if (localListView2 == null)
      {
        kotlin.g.b.s.bIx("listView");
        localListView1 = null;
      }
      localListView1.addFooterView(View.inflate((Context)this, e.f.finder_load_no_more_footer, null));
    }
    AppMethodBeat.o(365207);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_liked_list_layout;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(365170);
    Object localObject1 = findViewById(e.e.finder_liked_list);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_liked_list)");
    this.qgc = ((ListView)localObject1);
    localObject1 = findViewById(e.e.empty_tip);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.empty_tip)");
    this.njh = ((TextView)localObject1);
    localObject1 = findViewById(e.e.loading_bar);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.loading_bar)");
    this.Bno = ((MMProcessBar)localObject1);
    localObject1 = findViewById(e.e.retry_tips);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.retry_tips)");
    this.Bnp = ((TextView)localObject1);
    aMl();
    setBackBtn(new FinderFriendRecommendUI..ExternalSyntheticLambda1(this));
    localObject1 = this.qgc;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      ((ListView)localObject1).setAdapter((ListAdapter)this.Bnq);
      localObject1 = this.qgc;
      if (localObject1 != null) {
        break label432;
      }
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      label161:
      ((ListView)localObject1).setSelector((Drawable)new ColorDrawable(0));
      localObject1 = this.qgc;
      if (localObject1 != null) {
        break label435;
      }
      kotlin.g.b.s.bIx("listView");
      localObject1 = null;
      label193:
      ((ListView)localObject1).setOnScrollListener((AbsListView.OnScrollListener)new b(this));
      Object localObject3 = this.Bnp;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("retryTips");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(new FinderFriendRecommendUI..ExternalSyntheticLambda2(this));
      this.Bnq.AIb = ((kotlin.g.a.b)new c(this));
      this.Bnq.AIc = ((kotlin.g.a.b)new d(this));
      addIconOptionMenu(this.Bnt, -1, e.g.actionbar_icon_dark_more, new FinderFriendRecommendUI..ExternalSyntheticLambda0(this));
      this.qmO = ((IListener)new IListener(f.hfK)
      {
        @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
        static final class a
          extends u
          implements kotlin.g.a.a<ah>
        {
          a(FinderFriendRecommendUI paramFinderFriendRecommendUI, hz paramhz)
          {
            super();
          }
        }
      });
      localObject1 = this.qmO;
      if (localObject1 != null) {
        ((IListener)localObject1).alive();
      }
      localObject3 = this.njh;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("emptyTip");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(8);
      localObject3 = this.qgc;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("listView");
        localObject1 = null;
      }
      ((ListView)localObject1).setVisibility(8);
      localObject3 = this.Bno;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("loadingBar");
        localObject1 = null;
      }
      ((MMProcessBar)localObject1).setVisibility(0);
      localObject1 = this.Bnp;
      if (localObject1 != null) {
        break label438;
      }
      kotlin.g.b.s.bIx("retryTips");
      localObject1 = localObject2;
    }
    label432:
    label435:
    label438:
    for (;;)
    {
      ((TextView)localObject1).setVisibility(8);
      AppMethodBeat.o(365170);
      return;
      break;
      break label161;
      break label193;
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(365174);
    eeQ();
    super.onBackPressed();
    AppMethodBeat.o(365174);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365160);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.h.aZW().a(3593, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(3638, (com.tencent.mm.am.h)this);
    try
    {
      paramBundle = new cak().parseFrom(getIntent().getByteArrayExtra("ACTION_INFO"));
      if (paramBundle == null)
      {
        paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FriendLikeFinderObject");
        AppMethodBeat.o(365160);
        throw paramBundle;
      }
    }
    finally
    {
      finish();
      Log.w(TAG, "actionInfo invalid!");
      AppMethodBeat.o(365160);
      return;
    }
    this.Bnr = ((cak)paramBundle);
    this.feedId = getIntent().getLongExtra("FEED_ID", 0L);
    if (this.feedId == 0L)
    {
      finish();
      Log.w(TAG, "feedId is 0, invalid!");
      AppMethodBeat.o(365160);
      return;
    }
    this.lNX = getIntent().getIntExtra("INIT_TOTAL_COUNT", 0);
    this.Bns = getIntent().getBooleanExtra("VIEW_BY_POSTER", false);
    initView();
    eeR();
    AppMethodBeat.o(365160);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365179);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3593, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(3638, (com.tencent.mm.am.h)this);
    IListener localIListener = this.qmO;
    if (localIListener != null) {
      localIListener.dead();
    }
    AppMethodBeat.o(365179);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(365198);
    if ((paramp instanceof cl))
    {
      Log.i(TAG, "NetSceneFinderGetFriendRecommendList errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramp == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderGetFriendRecommendList");
          AppMethodBeat.o(365198);
          throw paramString;
        }
        paramString = ((cl)paramp).dVL();
        if (!kotlin.g.b.s.p(this.AyB, paramString))
        {
          Log.i(TAG, "not my buf, ignore!");
          AppMethodBeat.o(365198);
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
          com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramp, bool));
          AppMethodBeat.o(365198);
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
        paramp = this.qgc;
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
        paramString = this.Bnp;
        if (paramString == null)
        {
          kotlin.g.b.s.bIx("retryTips");
          paramString = localObject;
        }
        for (;;)
        {
          paramString.setVisibility(0);
          AppMethodBeat.o(365198);
          return;
        }
      }
    }
    else if ((paramp instanceof bw))
    {
      Log.i(TAG, "NetSceneFinderContactTag errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (((bw)paramp).AzK != null) {
          AppMethodBeat.o(365198);
        }
      }
      else {
        aa.makeText((Context)this, e.h.app_err_server_busy_tip, 0).show();
      }
    }
    AppMethodBeat.o(365198);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderFriendRecommendUI$initView$2", "Landroid/widget/AbsListView$OnScrollListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "onScrollStateChanged", "scrollState", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements AbsListView.OnScrollListener
  {
    b(FinderFriendRecommendUI paramFinderFriendRecommendUI) {}
    
    public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
      AppMethodBeat.i(364491);
      if ((paramInt == 0) && (paramAbsListView != null))
      {
        FinderFriendRecommendUI localFinderFriendRecommendUI = this.Bnu;
        if (!paramAbsListView.canScrollVertically(1))
        {
          if (FinderFriendRecommendUI.a(localFinderFriendRecommendUI))
          {
            FinderFriendRecommendUI.b(localFinderFriendRecommendUI);
            AppMethodBeat.o(364491);
            return;
          }
          localFinderFriendRecommendUI.eeS();
        }
      }
      AppMethodBeat.o(364491);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<bco, ah>
  {
    c(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "likeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLikeInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<bco, ah>
  {
    d(FinderFriendRecommendUI paramFinderFriendRecommendUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(FinderFriendRecommendUI paramFinderFriendRecommendUI, p paramp, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class initView$7$a
    extends u
    implements kotlin.g.a.a<ah>
  {
    initView$7$a(FinderFriendRecommendUI paramFinderFriendRecommendUI, hz paramhz)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderFriendRecommendUI
 * JD-Core Version:    0.7.0.1
 */