package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroid/support/design/widget/CoordinatorLayout;", "needHistory", "", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "topicList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSearchInfo;", "Lkotlin/collections/ArrayList;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getLayoutId", "getTopicSize", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "HeaderViewHolder", "TopicSearchAdapter", "plugin-finder_release"})
public final class FinderTopicSearchUI
  extends MMActivity
  implements i, FTSEditTextView.a, a.b
{
  private static final String TAG = "Finder.FinderTopicSearchUI";
  public static final a vvv;
  private HashMap _$_findViewCache;
  private int continueFlag;
  private String dPI;
  private View hSw;
  private RecyclerView hak;
  private int jKy;
  private View lJI;
  private int offset;
  private String query;
  private int requestType;
  private RefreshLoadMoreLayout tLS;
  private com.tencent.mm.bw.b tVM;
  private com.tencent.mm.ui.search.a ubO;
  private ArrayList<bdu> vtE;
  private boolean vtF;
  private HashMap<String, a> vtH;
  private CoordinatorLayout vtI;
  private TextView vtJ;
  private h vtK;
  private cf vtL;
  
  static
  {
    AppMethodBeat.i(251398);
    vvv = new a((byte)0);
    TAG = "Finder.FinderTopicSearchUI";
    AppMethodBeat.o(251398);
  }
  
  public FinderTopicSearchUI()
  {
    AppMethodBeat.i(251397);
    this.query = "";
    this.vtE = new ArrayList();
    this.dPI = "";
    this.vtF = true;
    this.vtH = new HashMap();
    AppMethodBeat.o(251397);
  }
  
  private final void auV(String paramString)
  {
    AppMethodBeat.i(251394);
    ov(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.tVM = null;
    this.vtE.clear();
    Object localObject = UUID.randomUUID().toString();
    p.g(localObject, "UUID.randomUUID().toString()");
    this.dPI = ((String)localObject);
    if (this.vtL != null) {
      g.azz().a((com.tencent.mm.ak.q)this.vtL);
    }
    this.vtL = new cf(paramString, this.offset, this.dPI, this.tVM, this.requestType, null, 96);
    g.azz().b((com.tencent.mm.ak.q)this.vtL);
    g.azz().a(3820, (i)this);
    paramString = this.hSw;
    if (paramString == null) {
      p.btv("loadingView");
    }
    paramString.setVisibility(0);
    paramString = this.vtJ;
    if (paramString == null) {
      p.btv("noResultView");
    }
    paramString.setVisibility(8);
    paramString = this.tLS;
    if (paramString == null) {
      p.btv("rlLayout");
    }
    paramString.setVisibility(8);
    paramString = this.hak;
    if (paramString == null) {
      p.btv("recyclerView");
    }
    localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(251394);
  }
  
  private final boolean dpx()
  {
    AppMethodBeat.i(251393);
    Object localObject1 = this.ubO;
    if (localObject1 == null) {
      p.btv("searchView");
    }
    localObject1 = ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText();
    p.g(localObject1, "searchView.ftsEditText");
    localObject1 = ((FTSEditTextView)localObject1).getTotalQuery();
    if (localObject1 != null)
    {
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(251393);
        throw ((Throwable)localObject1);
      }
      localObject2 = n.trim((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(251393);
      return true;
    }
    auV((String)localObject1);
    Object localObject2 = this.vtK;
    if (localObject2 != null) {
      ((h)localObject2).auX((String)localObject1);
    }
    AppMethodBeat.o(251393);
    return false;
  }
  
  private final int dqc()
  {
    AppMethodBeat.i(251396);
    Object localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null)
      {
        i = ((RecyclerView.a)localObject).getItemCount();
        AppMethodBeat.o(251396);
        return i;
      }
    }
    int i = this.vtE.size();
    AppMethodBeat.o(251396);
    return i;
  }
  
  private final void ov(boolean paramBoolean)
  {
    AppMethodBeat.i(251395);
    if (!Util.isNullOrNil(this.dPI)) {
      if (((Map)this.vtH).isEmpty()) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.finder.report.l locall = com.tencent.mm.plugin.finder.report.l.vfB;
        com.tencent.mm.plugin.finder.report.l.a(this.dPI, this.query, this.vtH, 2);
        if (paramBoolean) {
          this.vtH.clear();
        }
      }
      AppMethodBeat.o(251395);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(251404);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(251404);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251403);
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
    AppMethodBeat.o(251403);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(251387);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(251387);
        throw paramString1;
      }
      paramString2 = n.trim((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    if (Util.isNullOrNil(paramString1))
    {
      paramString2 = this.hSw;
      if (paramString2 == null) {
        p.btv("loadingView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.vtJ;
      if (paramString2 == null) {
        p.btv("noResultView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.tLS;
      if (paramString2 == null) {
        p.btv("rlLayout");
      }
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = this.vtK;
      if (paramString2 == null) {
        break;
      }
      paramString2.auW(paramString1);
      AppMethodBeat.o(251387);
      return;
      dpx();
    }
    AppMethodBeat.o(251387);
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(251386);
    hideVKB();
    if (dpx())
    {
      AppMethodBeat.o(251386);
      return true;
    }
    e.Cxv.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(251386);
    return false;
  }
  
  public final void dpw() {}
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(251388);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.l locall = com.tencent.mm.plugin.finder.report.l.vfB;
      com.tencent.mm.plugin.finder.report.l.doe();
    }
    AppMethodBeat.o(251388);
  }
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(251391);
    super.finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(251391);
  }
  
  public final int getLayoutId()
  {
    return 2131494660;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(251385);
    hideVKB();
    finish();
    AppMethodBeat.o(251385);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(251384);
    hideVKB();
    finish();
    AppMethodBeat.o(251384);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(251389);
    paramView = this.ubO;
    if (paramView == null) {
      p.btv("searchView");
    }
    paramView.getFtsEditText().awD();
    showVKB();
    AppMethodBeat.o(251389);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251383);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      p.g(paramBundle, "window");
      paramBundle.setStatusBarColor(getResources().getColor(2131101287));
    }
    this.ubO = new com.tencent.mm.ui.search.a((Context)this);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      p.btv("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      p.btv("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(2131755972));
    paramBundle = this.ubO;
    if (paramBundle == null) {
      p.btv("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      p.btv("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      p.btv("searchView");
    }
    paramBundle.getFtsEditText().gWY();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.hyc();
    }
    p.g(paramBundle, "supportActionBar!!");
    Object localObject = this.ubO;
    if (localObject == null) {
      p.btv("searchView");
    }
    paramBundle.setCustomView((View)localObject);
    this.requestType = getIntent().getIntExtra("request_type", 4);
    this.vtF = getIntent().getBooleanExtra("need_history", false);
    paramBundle = UUID.randomUUID().toString();
    p.g(paramBundle, "UUID.randomUUID().toString()");
    this.dPI = paramBundle;
    this.query = "";
    paramBundle = this.ubO;
    if (paramBundle == null) {
      p.btv("searchView");
    }
    paramBundle.getFtsEditText().awD();
    paramBundle = this.ubO;
    if (paramBundle == null) {
      p.btv("searchView");
    }
    paramBundle.getFtsEditText().awC();
    if (this.vtF)
    {
      paramBundle = getContext().findViewById(2131302342);
      p.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(0);
      this.vtK = new h((MMActivity)this, (kotlin.g.a.b)new f(this));
    }
    for (;;)
    {
      Log.i(TAG, "initData");
      paramBundle = getContext().findViewById(2131307157);
      p.g(paramBundle, "context.findViewById(R.id.root)");
      this.lJI = paramBundle;
      paramBundle = getContext().findViewById(2131304329);
      p.g(paramBundle, "context.findViewById(R.id.main_rv)");
      this.vtI = ((CoordinatorLayout)paramBundle);
      paramBundle = getContext().findViewById(2131307118);
      p.g(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.tLS = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.tLS;
      if (paramBundle == null) {
        p.btv("rlLayout");
      }
      this.hak = paramBundle.getRecyclerView();
      paramBundle = getContext().findViewById(2131305461);
      p.g(paramBundle, "context.findViewById(R.id.no_result_tv)");
      this.vtJ = ((TextView)paramBundle);
      paramBundle = getContext().findViewById(2131303706);
      p.g(paramBundle, "context.findViewById(R.id.loading_layout)");
      this.hSw = paramBundle;
      paramBundle = new FinderLinearLayoutManager((Context)this);
      localObject = this.hak;
      if (localObject == null) {
        p.btv("recyclerView");
      }
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)new c((byte)0));
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setHasFixedSize(true);
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setItemViewCacheSize(5);
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setOnTouchListener((View.OnTouchListener)new d(this));
      paramBundle = this.tLS;
      if (paramBundle == null) {
        p.btv("rlLayout");
      }
      paramBundle.setEnablePullDownHeader(false);
      paramBundle = this.tLS;
      if (paramBundle == null) {
        p.btv("rlLayout");
      }
      localObject = aa.jQ((Context)getContext()).inflate(2131495297, null);
      p.g(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject);
      paramBundle = this.tLS;
      if (paramBundle == null) {
        p.btv("rlLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
      paramBundle = this.query;
      if (paramBundle != null)
      {
        localObject = this.ubO;
        if (localObject == null) {
          p.btv("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject).getFtsEditText().O(paramBundle, null);
      }
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      localObject = com.tencent.mm.hellhoundlib.b.c.a(this.jKy, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(251383);
      return;
      paramBundle = getContext().findViewById(2131302342);
      p.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(251392);
    h localh = this.vtK;
    if (localh != null) {
      localh.onDestroy();
    }
    ov(true);
    g.azz().b(3820, (i)this);
    super.onDestroy();
    AppMethodBeat.o(251392);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(251390);
    g.azz().b(3820, (i)this);
    int j = dqc();
    int i = dqc();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.Cxv.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.vtL;
      if (paramString != null) {}
      for (paramString = paramString.twl; paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(251390);
        throw paramString;
      }
      paramq = paramString.LLh;
      p.g(paramq, "response.topicInfoList");
      Object localObject = (Iterable)paramq;
      paramq = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bdu localbdu = (bdu)((Iterator)localObject).next();
        paramq.add(Boolean.valueOf(this.vtE.add(localbdu)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.LLj;
      this.tVM = paramString.tVM;
      paramInt1 = dqc();
      Log.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.vtE.size());
      paramString = this.tLS;
      if (paramString == null) {
        p.btv("rlLayout");
      }
      paramString.apT(0);
      if (paramInt1 != 0) {
        break label417;
      }
      paramString = this.hSw;
      if (paramString == null) {
        p.btv("loadingView");
      }
      paramString.setVisibility(8);
      paramString = this.vtJ;
      if (paramString == null) {
        p.btv("noResultView");
      }
      paramString.setVisibility(0);
      paramString = this.tLS;
      if (paramString == null) {
        p.btv("rlLayout");
      }
      paramString.setVisibility(8);
    }
    for (;;)
    {
      if (j == 0)
      {
        paramString = this.hak;
        if (paramString == null) {
          p.btv("recyclerView");
        }
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.notifyDataSetChanged();
          AppMethodBeat.o(251390);
          return;
          e.Cxv.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label417:
          paramString = this.hSw;
          if (paramString == null) {
            p.btv("loadingView");
          }
          paramString.setVisibility(8);
          paramString = this.vtJ;
          if (paramString == null) {
            p.btv("noResultView");
          }
          paramString.setVisibility(8);
          paramString = this.tLS;
          if (paramString == null) {
            p.btv("rlLayout");
          }
          paramString.setVisibility(0);
          paramString = this.vtI;
          if (paramString == null) {
            p.btv("mainContainer");
          }
          paramString.setVisibility(0);
          paramString = this.lJI;
          if (paramString == null) {
            p.btv("rootView");
          }
          paramq = getContext();
          p.g(paramq, "context");
          paramString.setBackground(paramq.getResources().getDrawable(2131099648));
          continue;
        }
        AppMethodBeat.o(251390);
        return;
      }
    }
    if (j < paramInt1)
    {
      paramString = this.hak;
      if (paramString == null) {
        p.btv("recyclerView");
      }
      if (paramString != null)
      {
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.as(j, paramInt1 - j);
          AppMethodBeat.o(251390);
          return;
        }
      }
    }
    AppMethodBeat.o(251390);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public b()
    {
      super();
      AppMethodBeat.i(251370);
      this$1 = localObject.findViewById(2131309249);
      p.g(FinderTopicSearchUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderTopicSearchUI.this);
      AppMethodBeat.o(251370);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$TopicSearchAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;I)V", "existFollowTopic", "", "getExistFollowTopic", "()Z", "setExistFollowTopic", "(Z)V", "getRequestType", "()I", "unFollowTopicIndex", "getUnFollowTopicIndex", "setUnFollowTopicIndex", "(I)V", "bindData", "", "holder", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private final int requestType = 4;
    private boolean vvx;
    private int vvy;
    
    private c() {}
    
    private final void j(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(251376);
      if ((paramv instanceof FinderTopicSearchUI.b))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderTopicSearchUI.b)paramv).titleTv.setText((CharSequence)FinderTopicSearchUI.this.getString(2131759611));
          AppMethodBeat.o(251376);
          return;
        }
        ((FinderTopicSearchUI.b)paramv).titleTv.setText((CharSequence)FinderTopicSearchUI.this.getString(2131759613));
        AppMethodBeat.o(251376);
        return;
      }
      Object localObject1;
      if ((this.requestType == 4) && (this.vvx) && (this.vvy != FinderTopicSearchUI.a(FinderTopicSearchUI.this).size())) {
        if (paramInt < this.vvy + 1) {
          localObject1 = (bdu)FinderTopicSearchUI.a(FinderTopicSearchUI.this).get(paramInt - 1);
        }
      }
      for (;;)
      {
        p.g(localObject1, "if (requestType == Const…sition]\n                }");
        FinderTopicSearchUI localFinderTopicSearchUI = FinderTopicSearchUI.this;
        Object localObject2 = ((bdu)localObject1).dMU;
        if (localObject2 != null)
        {
          localObject3 = ((bds)localObject2).dST;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        FinderTopicSearchUI.a(localFinderTopicSearchUI, (String)localObject2, paramInt);
        localObject1 = ((bdu)localObject1).dMU;
        if (localObject1 == null) {
          break;
        }
        localObject2 = paramv.aus.findViewById(2131301656);
        p.g(localObject2, "holder.itemView.findView….follow_topic_news_title)");
        localObject2 = (TextView)localObject2;
        Object localObject3 = paramv.aus;
        p.g(localObject3, "holder.itemView");
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(((View)localObject3).getContext(), (CharSequence)((bds)localObject1).dST));
        localObject2 = paramv.aus.findViewById(2131301655);
        p.g(localObject2, "holder.itemView.findView….follow_topic_news_count)");
        localObject2 = (TextView)localObject2;
        paramv = paramv.aus;
        p.g(paramv, "holder.itemView");
        ((TextView)localObject2).setText((CharSequence)paramv.getContext().getString(2131760327, new Object[] { k.gm(2, ((bds)localObject1).LzC) }));
        AppMethodBeat.o(251376);
        return;
        localObject1 = (bdu)FinderTopicSearchUI.a(FinderTopicSearchUI.this).get(paramInt - 2);
        continue;
        localObject1 = (bdu)FinderTopicSearchUI.a(FinderTopicSearchUI.this).get(paramInt);
      }
      AppMethodBeat.o(251376);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(251371);
      p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        localObject = FinderTopicSearchUI.this;
        AppCompatActivity localAppCompatActivity = FinderTopicSearchUI.this.getContext();
        if (localAppCompatActivity == null) {
          p.hyc();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494564, paramViewGroup, false);
        p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderTopicSearchUI.b((FinderTopicSearchUI)localObject, paramViewGroup);
        AppMethodBeat.o(251371);
        return paramViewGroup;
      }
      Object localObject = FinderTopicSearchUI.this.getContext();
      if (localObject == null) {
        p.hyc();
      }
      paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(2131494324, paramViewGroup, false);
      p.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(251371);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(251374);
      p.h(paramv, "holder");
      j(paramv, paramInt);
      AppMethodBeat.o(251374);
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(251375);
      p.h(paramv, "holder");
      p.h(paramList, "payloads");
      j(paramv, paramInt);
      AppMethodBeat.o(251375);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(251372);
      if ((this.requestType == 3) && (FinderTopicSearchUI.a(FinderTopicSearchUI.this).size() != 0))
      {
        this.vvy = 0;
        this.vvx = false;
        Iterator localIterator = FinderTopicSearchUI.a(FinderTopicSearchUI.this).iterator();
        if (localIterator.hasNext())
        {
          bds localbds = ((bdu)localIterator.next()).dMU;
          boolean bool;
          if (localbds != null) {
            if (localbds.followFlag > 0) {
              bool = true;
            }
          }
          for (;;)
          {
            this.vvx = bool;
            if (!this.vvx) {
              break label120;
            }
            this.vvy += 1;
            break;
            bool = false;
            continue;
            bool = false;
          }
        }
        label120:
        if (this.vvx)
        {
          if (this.vvy == FinderTopicSearchUI.a(FinderTopicSearchUI.this).size())
          {
            i = FinderTopicSearchUI.a(FinderTopicSearchUI.this).size();
            AppMethodBeat.o(251372);
            return i;
          }
          i = FinderTopicSearchUI.a(FinderTopicSearchUI.this).size();
          AppMethodBeat.o(251372);
          return i + 2;
        }
      }
      int i = FinderTopicSearchUI.a(FinderTopicSearchUI.this).size();
      AppMethodBeat.o(251372);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(251373);
      if ((this.requestType == 4) && (this.vvx))
      {
        if (this.vvy == FinderTopicSearchUI.a(FinderTopicSearchUI.this).size())
        {
          AppMethodBeat.o(251373);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(251373);
          return 1;
        }
        if (paramInt == this.vvy + 1)
        {
          AppMethodBeat.o(251373);
          return 2;
        }
      }
      AppMethodBeat.o(251373);
      return 3;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderTopicSearchUI paramFinderTopicSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251377);
      FinderTopicSearchUI.b(this.vvw).getFtsEditText().gUA();
      this.vvw.hideVKB();
      AppMethodBeat.o(251377);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(251379);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(251379);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(251381);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(251381);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(251378);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderContactSearchIncludeFollowUI.vtM;
      Log.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderTopicSearchUI.c(this.vvw);
      if (localObject != null)
      {
        if (FinderTopicSearchUI.d(this.vvw) != 1) {
          break label250;
        }
        FinderTopicSearchUI.a(this.vvw, new cf((String)localObject, FinderTopicSearchUI.f(this.vvw), FinderTopicSearchUI.g(this.vvw), FinderTopicSearchUI.h(this.vvw), FinderTopicSearchUI.i(this.vvw), null, 96));
        g.azz().b((com.tencent.mm.ak.q)FinderTopicSearchUI.e(this.vvw));
        g.azz().a(3820, (i)this.vvw);
        localObject = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setText(2131760234);
          }
        }
        localObject = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131303684);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(251378);
        return;
        label250:
        localObject = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setText(2131760235);
          }
        }
        localObject = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderTopicSearchUI.j(this.vvw).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131303684);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(251380);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(251380);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    f(FinderTopicSearchUI paramFinderTopicSearchUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderTopicSearchUI
 * JD-Core Version:    0.7.0.1
 */