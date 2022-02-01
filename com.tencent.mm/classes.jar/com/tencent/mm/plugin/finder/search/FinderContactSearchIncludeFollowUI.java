package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.anr;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(7)
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroid/support/design/widget/CoordinatorLayout;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getContactSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "ContactSearchProfileAdapter", "HeaderViewHolder", "plugin-finder_release"})
public final class FinderContactSearchIncludeFollowUI
  extends MMActivity
  implements com.tencent.mm.ak.g, FTSEditTextView.a, a.b
{
  static final String TAG = "Finder.FinderContactSearchIncludeFollowUI";
  public static final FinderContactSearchIncludeFollowUI.a rAC;
  private int continueFlag;
  String dlj;
  private RecyclerView fTr;
  private View gDe;
  private int irO;
  private View khe;
  private int offset;
  String query;
  private g rAA;
  private as rAB;
  private com.tencent.mm.ui.search.a rAu;
  private boolean rAv;
  boolean rAw;
  HashMap<String, a> rAx;
  private CoordinatorLayout rAy;
  private TextView rAz;
  private int requestType;
  private RefreshLoadMoreLayout rfT;
  private com.tencent.mm.bw.b rmJ;
  private ArrayList<anr> rpr;
  
  static
  {
    AppMethodBeat.i(202867);
    rAC = new FinderContactSearchIncludeFollowUI.a((byte)0);
    TAG = "Finder.FinderContactSearchIncludeFollowUI";
    AppMethodBeat.o(202867);
  }
  
  public FinderContactSearchIncludeFollowUI()
  {
    AppMethodBeat.i(202866);
    this.query = "";
    this.rpr = new ArrayList();
    this.dlj = "";
    this.rAv = true;
    this.rAx = new HashMap();
    AppMethodBeat.o(202866);
  }
  
  private final void adT(String paramString)
  {
    AppMethodBeat.i(202862);
    lG(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.rmJ = null;
    this.rpr.clear();
    Object localObject = UUID.randomUUID().toString();
    k.g(localObject, "UUID.randomUUID().toString()");
    this.dlj = ((String)localObject);
    if (this.rAB != null) {
      com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)this.rAB);
    }
    this.rAB = new as(paramString, this.offset, this.dlj, this.rmJ, this.requestType, null, 32);
    com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)this.rAB);
    com.tencent.mm.kernel.g.agi().a(3820, (com.tencent.mm.ak.g)this);
    paramString = this.gDe;
    if (paramString == null) {
      k.aVY("loadingView");
    }
    paramString.setVisibility(0);
    paramString = this.rAz;
    if (paramString == null) {
      k.aVY("noResultView");
    }
    paramString.setVisibility(8);
    paramString = this.rfT;
    if (paramString == null) {
      k.aVY("rlLayout");
    }
    paramString.setVisibility(8);
    paramString = this.fTr;
    if (paramString == null) {
      k.aVY("recyclerView");
    }
    localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(202862);
  }
  
  private final boolean cxH()
  {
    AppMethodBeat.i(202859);
    Object localObject1 = this.rAu;
    if (localObject1 == null) {
      k.aVY("searchView");
    }
    localObject1 = ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText();
    k.g(localObject1, "searchView.ftsEditText");
    localObject1 = ((FTSEditTextView)localObject1).getTotalQuery();
    if (localObject1 != null)
    {
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(202859);
        throw ((Throwable)localObject1);
      }
      localObject2 = d.n.n.trim((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    if (bs.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(202859);
      return true;
    }
    adT((String)localObject1);
    Object localObject2 = this.rAA;
    if (localObject2 != null) {
      ((g)localObject2).adX((String)localObject1);
    }
    AppMethodBeat.o(202859);
    return false;
  }
  
  private final int cxI()
  {
    AppMethodBeat.i(202864);
    Object localObject = this.fTr;
    if (localObject == null) {
      k.aVY("recyclerView");
    }
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null)
      {
        i = ((RecyclerView.a)localObject).getItemCount();
        AppMethodBeat.o(202864);
        return i;
      }
    }
    int i = this.rpr.size();
    AppMethodBeat.o(202864);
    return i;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(202855);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(202855);
        throw paramString1;
      }
      paramString2 = d.n.n.trim((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    if (bs.isNullOrNil(paramString1))
    {
      paramString2 = this.gDe;
      if (paramString2 == null) {
        k.aVY("loadingView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.rAz;
      if (paramString2 == null) {
        k.aVY("noResultView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.rfT;
      if (paramString2 == null) {
        k.aVY("rlLayout");
      }
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = this.rAA;
      if (paramString2 == null) {
        break;
      }
      paramString2.adW(paramString1);
      AppMethodBeat.o(202855);
      return;
      cxH();
    }
    AppMethodBeat.o(202855);
  }
  
  public final boolean bvs()
  {
    AppMethodBeat.i(202858);
    hideVKB();
    if (cxH())
    {
      AppMethodBeat.o(202858);
      return true;
    }
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(202858);
    return false;
  }
  
  public final void cxG() {}
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(202861);
    super.finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(202861);
  }
  
  public final int getLayoutId()
  {
    return 2131496176;
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(202856);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.rxs;
      com.tencent.mm.plugin.finder.report.e.cwV();
    }
    AppMethodBeat.o(202856);
  }
  
  final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(202865);
    if (!bs.isNullOrNil(this.dlj)) {
      if (((Map)this.rAx).isEmpty()) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.rxs;
        com.tencent.mm.plugin.finder.report.e.a(this.dlj, this.query, this.rAx, 2);
        if (paramBoolean) {
          this.rAx.clear();
        }
      }
      AppMethodBeat.o(202865);
      return;
    }
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(202853);
    hideVKB();
    finish();
    AppMethodBeat.o(202853);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(202854);
    hideVKB();
    finish();
    AppMethodBeat.o(202854);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(202857);
    paramView = this.rAu;
    if (paramView == null) {
      k.aVY("searchView");
    }
    paramView.getFtsEditText().fte();
    showVKB();
    AppMethodBeat.o(202857);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202852);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      k.g(paramBundle, "window");
      paramBundle.setStatusBarColor(getResources().getColor(2131101053));
    }
    this.rAu = new com.tencent.mm.ui.search.a((Context)this);
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(2131755882));
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().ftb();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      k.fOy();
    }
    k.g(paramBundle, "supportActionBar!!");
    Object localObject1 = this.rAu;
    if (localObject1 == null) {
      k.aVY("searchView");
    }
    paramBundle.setCustomView((View)localObject1);
    this.requestType = getIntent().getIntExtra("request_type", 3);
    this.rAw = getIntent().getBooleanExtra("from_at_contact", false);
    this.rAv = getIntent().getBooleanExtra("need_history", false);
    paramBundle = h.rBC;
    if (h.cxS() != null)
    {
      paramBundle = h.rBC;
      Object localObject2 = h.cxS();
      if (localObject2 == null) {
        k.fOy();
      }
      paramBundle = h.rBC;
      h.a(null);
      localObject1 = ((ajw)localObject2).dlj;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.dlj = paramBundle;
      localObject1 = ((ajw)localObject2).query;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.query = paramBundle;
      this.offset = ((ajw)localObject2).offset;
      this.continueFlag = ((ajw)localObject2).continueFlag;
      this.rmJ = ((ajw)localObject2).rmJ;
      this.irO = ((ajw)localObject2).EEt;
      paramBundle = ((ajw)localObject2).rHC;
      k.g(paramBundle, "finderFeedObj.contactList");
      localObject1 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (anr)((Iterator)localObject1).next();
        paramBundle.add(Boolean.valueOf(this.rpr.add(localObject2)));
      }
    }
    paramBundle = UUID.randomUUID().toString();
    k.g(paramBundle, "UUID.randomUUID().toString()");
    this.dlj = paramBundle;
    this.query = "";
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().fte();
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().ftd();
    if (this.rAv)
    {
      paramBundle = getContext().findViewById(2131300754);
      k.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(0);
      this.rAA = new g((MMActivity)this, (d.g.a.b)new f(this));
    }
    for (;;)
    {
      if (this.rAw) {
        setResult(0, getIntent());
      }
      ac.i(TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.rAw) });
      paramBundle = getContext().findViewById(2131304239);
      k.g(paramBundle, "context.findViewById(R.id.root)");
      this.khe = paramBundle;
      paramBundle = getContext().findViewById(2131301992);
      k.g(paramBundle, "context.findViewById(R.id.main_rv)");
      this.rAy = ((CoordinatorLayout)paramBundle);
      paramBundle = getContext().findViewById(2131304203);
      k.g(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.rfT = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.rfT;
      if (paramBundle == null) {
        k.aVY("rlLayout");
      }
      this.fTr = paramBundle.getRecyclerView();
      paramBundle = getContext().findViewById(2131302884);
      k.g(paramBundle, "context.findViewById(R.id.no_result_tv)");
      this.rAz = ((TextView)paramBundle);
      paramBundle = getContext().findViewById(2131301503);
      k.g(paramBundle, "context.findViewById(R.id.loading_layout)");
      this.gDe = paramBundle;
      paramBundle = new FinderLayoutManager((byte)0);
      localObject1 = this.fTr;
      if (localObject1 == null) {
        k.aVY("recyclerView");
      }
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)paramBundle);
      paramBundle = this.fTr;
      if (paramBundle == null) {
        k.aVY("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)new b((byte)0));
      paramBundle = this.fTr;
      if (paramBundle == null) {
        k.aVY("recyclerView");
      }
      paramBundle.setHasFixedSize(true);
      paramBundle = this.fTr;
      if (paramBundle == null) {
        k.aVY("recyclerView");
      }
      paramBundle.setItemViewCacheSize(5);
      paramBundle = this.fTr;
      if (paramBundle == null) {
        k.aVY("recyclerView");
      }
      paramBundle.setOnTouchListener((View.OnTouchListener)new d(this));
      paramBundle = this.rfT;
      if (paramBundle == null) {
        k.aVY("rlLayout");
      }
      paramBundle.setEnablePullDownHeader(false);
      paramBundle = this.rfT;
      if (paramBundle == null) {
        k.aVY("rlLayout");
      }
      localObject1 = z.jD((Context)getContext()).inflate(2131494590, null);
      k.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.rfT;
      if (paramBundle == null) {
        k.aVY("rlLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
      paramBundle = this.query;
      if (paramBundle != null)
      {
        localObject1 = this.rAu;
        if (localObject1 == null) {
          k.aVY("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText().F(paramBundle, null);
      }
      paramBundle = this.fTr;
      if (paramBundle == null) {
        k.aVY("recyclerView");
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
      paramBundle = this.fTr;
      if (paramBundle == null) {
        k.aVY("recyclerView");
      }
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(this.irO, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(202852);
      return;
      paramBundle = getContext().findViewById(2131300754);
      k.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202860);
    g localg = this.rAA;
    if (localg != null) {
      localg.onDestroy();
    }
    lG(true);
    com.tencent.mm.kernel.g.agi().b(3820, (com.tencent.mm.ak.g)this);
    super.onDestroy();
    AppMethodBeat.o(202860);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(202863);
    com.tencent.mm.kernel.g.agi().b(3820, (com.tencent.mm.ak.g)this);
    int j = cxI();
    int i = cxI();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.rAB;
      if (paramString != null) {}
      for (paramString = paramString.qYC; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(202863);
        throw paramString;
      }
      paramn = paramString.uEi;
      k.g(paramn, "response.infoList");
      Object localObject = (Iterable)paramn;
      paramn = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        anr localanr = (anr)((Iterator)localObject).next();
        paramn.add(Boolean.valueOf(this.rpr.add(localanr)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.rmJ = paramString.rmJ;
      paramInt1 = cxI();
      ac.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.rpr.size());
      paramString = this.rfT;
      if (paramString == null) {
        k.aVY("rlLayout");
      }
      paramString.adz(0);
      if (paramInt1 != 0) {
        break label417;
      }
      paramString = this.gDe;
      if (paramString == null) {
        k.aVY("loadingView");
      }
      paramString.setVisibility(8);
      paramString = this.rAz;
      if (paramString == null) {
        k.aVY("noResultView");
      }
      paramString.setVisibility(0);
      paramString = this.rfT;
      if (paramString == null) {
        k.aVY("rlLayout");
      }
      paramString.setVisibility(8);
    }
    for (;;)
    {
      if (j == 0)
      {
        paramString = this.fTr;
        if (paramString == null) {
          k.aVY("recyclerView");
        }
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.notifyDataSetChanged();
          AppMethodBeat.o(202863);
          return;
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label417:
          paramString = this.gDe;
          if (paramString == null) {
            k.aVY("loadingView");
          }
          paramString.setVisibility(8);
          paramString = this.rAz;
          if (paramString == null) {
            k.aVY("noResultView");
          }
          paramString.setVisibility(8);
          paramString = this.rfT;
          if (paramString == null) {
            k.aVY("rlLayout");
          }
          paramString.setVisibility(0);
          paramString = this.rAy;
          if (paramString == null) {
            k.aVY("mainContainer");
          }
          paramString.setVisibility(0);
          paramString = this.khe;
          if (paramString == null) {
            k.aVY("rootView");
          }
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setBackground(paramn.getResources().getDrawable(2131099648));
          continue;
        }
        AppMethodBeat.o(202863);
        return;
      }
    }
    if (j < paramInt1)
    {
      paramString = this.fTr;
      if (paramString == null) {
        k.aVY("recyclerView");
      }
      if (paramString != null)
      {
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.aq(j, paramInt1 - j);
          AppMethodBeat.o(202863);
          return;
        }
      }
    }
    AppMethodBeat.o(202863);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;I)V", "existFollowContact", "", "getExistFollowContact", "()Z", "setExistFollowContact", "(Z)V", "getRequestType", "()I", "unFollowContactIndex", "getUnFollowContactIndex", "setUnFollowContactIndex", "(I)V", "bindData", "", "holder", "position", "bindImage", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    private boolean rAD;
    private int rAE;
    private final int requestType = 3;
    
    private b() {}
    
    private final void i(RecyclerView.w paramw, final int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(202843);
      if ((paramw instanceof FinderContactSearchIncludeFollowUI.c))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderContactSearchIncludeFollowUI.c)paramw).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131765454));
          AppMethodBeat.o(202843);
          return;
        }
        ((FinderContactSearchIncludeFollowUI.c)paramw).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131765455));
        AppMethodBeat.o(202843);
        return;
      }
      anr localanr;
      if ((this.requestType == 3) && (this.rAD) && (this.rAE != FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())) {
        if (paramInt < this.rAE + 1) {
          localanr = (anr)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 1);
        }
      }
      for (;;)
      {
        k.g(localanr, "if (requestType == Const…sition]\n                }");
        localObject = FinderContactSearchIncludeFollowUI.this;
        String str = localanr.contact.username;
        k.g(str, "searchInfo.contact.username");
        k.h(str, "id");
        if (!((FinderContactSearchIncludeFollowUI)localObject).rAx.containsKey(str))
        {
          ac.d(FinderContactSearchIncludeFollowUI.TAG, "addExposeItem " + str + ' ' + paramInt + ' ' + 1);
          a locala = new a();
          locala.adU(str);
          locala.position = paramInt;
          locala.type = 1;
          locala.timeStamp = System.currentTimeMillis();
          ((Map)((FinderContactSearchIncludeFollowUI)localObject).rAx).put(str, locala);
          if (((FinderContactSearchIncludeFollowUI)localObject).rAx.size() % 30 == 0) {
            ((FinderContactSearchIncludeFollowUI)localObject).lG(false);
          }
        }
        if (paramw != null) {
          break;
        }
        paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
        AppMethodBeat.o(202843);
        throw paramw;
        localanr = (anr)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 2);
        continue;
        localanr = (anr)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt);
      }
      paramw = (c)paramw;
      Object localObject = (View.OnClickListener)new a(this, paramInt);
      if (paramInt != 0) {}
      for (;;)
      {
        paramw.a(localanr, (View.OnClickListener)localObject, bool);
        AppMethodBeat.o(202843);
        return;
        bool = false;
      }
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(202841);
      k.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        localObject = FinderContactSearchIncludeFollowUI.this;
        AppCompatActivity localAppCompatActivity = FinderContactSearchIncludeFollowUI.this.getContext();
        if (localAppCompatActivity == null) {
          k.fOy();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496243, paramViewGroup, false);
        k.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderContactSearchIncludeFollowUI.c((FinderContactSearchIncludeFollowUI)localObject, paramViewGroup);
        AppMethodBeat.o(202841);
        return paramViewGroup;
      }
      Object localObject = FinderContactSearchIncludeFollowUI.this.getContext();
      if (localObject == null) {
        k.fOy();
      }
      paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(2131494018, paramViewGroup, false);
      k.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.w)new c(paramViewGroup);
      AppMethodBeat.o(202841);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(202844);
      k.h(paramw, "holder");
      i(paramw, paramInt);
      AppMethodBeat.o(202844);
    }
    
    public final void a(RecyclerView.w paramw, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(202842);
      k.h(paramw, "holder");
      k.h(paramList, "payloads");
      i(paramw, paramInt);
      AppMethodBeat.o(202842);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(202839);
      if ((this.requestType == 3) && (FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size() != 0))
      {
        this.rAE = 0;
        this.rAD = false;
        Iterator localIterator = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (anr)localIterator.next();
          b.a locala = com.tencent.mm.plugin.finder.api.b.qWt;
          localObject = ((anr)localObject).contact;
          if (localObject != null) {}
          for (localObject = ((FinderContact)localObject).username;; localObject = null)
          {
            if (!b.a.adk((String)localObject)) {
              break label116;
            }
            this.rAD = true;
            this.rAE += 1;
            break;
          }
        }
        label116:
        if (this.rAD)
        {
          if (this.rAE == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
          {
            i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
            AppMethodBeat.o(202839);
            return i;
          }
          i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
          AppMethodBeat.o(202839);
          return i + 2;
        }
      }
      int i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
      AppMethodBeat.o(202839);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(202840);
      if ((this.requestType == 3) && (this.rAD))
      {
        if (this.rAE == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
        {
          AppMethodBeat.o(202840);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(202840);
          return 1;
        }
        if (paramInt == this.rAE + 1)
        {
          AppMethodBeat.o(202840);
          return 2;
        }
      }
      AppMethodBeat.o(202840);
      return 3;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchIncludeFollowUI.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(202838);
        k.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(202838);
          throw paramView;
        }
        paramView = (anr)paramView;
        Object localObject1 = this.rAG.rAF;
        int i = paramInt;
        k.h(paramView, "finderSearchInfo");
        if (((FinderContactSearchIncludeFollowUI)localObject1).rAw)
        {
          ac.i(FinderContactSearchIncludeFollowUI.TAG, "onContactItemClick select atContact");
          localObject2 = com.tencent.mm.plugin.finder.utils.b.rOw;
          localObject2 = paramView.contact;
          k.g(localObject2, "finderSearchInfo.contact");
          localObject2 = com.tencent.mm.plugin.finder.utils.b.d((FinderContact)localObject2);
          ((FinderContactSearchIncludeFollowUI)localObject1).getIntent().putExtra("at_select_contact", ((bqq)localObject2).toByteArray());
          localObject2 = ((FinderContactSearchIncludeFollowUI)localObject1).getIntent();
          localObject3 = com.tencent.mm.plugin.finder.api.b.qWt;
          paramView = paramView.contact;
          if (paramView != null) {}
          for (paramView = paramView.username;; paramView = null)
          {
            ((Intent)localObject2).putExtra("is_follow", b.a.adk(paramView));
            ((FinderContactSearchIncludeFollowUI)localObject1).setResult(-1, ((FinderContactSearchIncludeFollowUI)localObject1).getIntent());
            ((FinderContactSearchIncludeFollowUI)localObject1).finish();
            AppMethodBeat.o(202838);
            return;
          }
        }
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("finder_username", paramView.contact.username);
        Object localObject3 = FinderReporterUIC.seQ;
        localObject3 = ((FinderContactSearchIncludeFollowUI)localObject1).getContext();
        k.g(localObject3, "context");
        FinderReporterUIC.a.a((Context)localObject3, (Intent)localObject2, 0L, 7, false, 64);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.rOv;
        localObject3 = ((FinderContactSearchIncludeFollowUI)localObject1).getContext();
        k.g(localObject3, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject3, (Intent)localObject2);
        localObject2 = com.tencent.mm.plugin.finder.report.e.rxs;
        localObject2 = ((FinderContactSearchIncludeFollowUI)localObject1).dlj;
        localObject3 = ((FinderContactSearchIncludeFollowUI)localObject1).query;
        String str = paramView.contact.username;
        k.g(str, "finderSearchInfo.contact.username");
        com.tencent.mm.plugin.finder.report.e.b((String)localObject2, (String)localObject3, 1, str, i, 2);
        localObject2 = FinderReporterUIC.seQ;
        localObject1 = ((FinderContactSearchIncludeFollowUI)localObject1).getContext();
        k.g(localObject1, "context");
        localObject1 = FinderReporterUIC.a.eV((Context)localObject1);
        if (localObject1 != null)
        {
          localObject2 = d.rxr;
          i = ((FinderReporterUIC)localObject1).rfR;
          paramView = paramView.contact.username;
          k.g(paramView, "finderSearchInfo.contact.username");
          d.a(6, 0L, i, 1, paramView);
          AppMethodBeat.o(202838);
          return;
        }
        AppMethodBeat.o(202838);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(202846);
      FinderContactSearchIncludeFollowUI.b(this.rAF).getFtsEditText().frb();
      this.rAF.hideVKB();
      AppMethodBeat.o(202846);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(202848);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202848);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(202850);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202850);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(202849);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202849);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(202847);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderContactSearchIncludeFollowUI.rAC;
      ac.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderContactSearchIncludeFollowUI.c(this.rAF);
      if (localObject != null)
      {
        if (FinderContactSearchIncludeFollowUI.d(this.rAF) != 1) {
          break label184;
        }
        FinderContactSearchIncludeFollowUI.a(this.rAF, new as((String)localObject, FinderContactSearchIncludeFollowUI.f(this.rAF), FinderContactSearchIncludeFollowUI.g(this.rAF), FinderContactSearchIncludeFollowUI.h(this.rAF), FinderContactSearchIncludeFollowUI.i(this.rAF), null, 32));
        com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)FinderContactSearchIncludeFollowUI.e(this.rAF));
        com.tencent.mm.kernel.g.agi().a(3820, (com.tencent.mm.ak.g)this.rAF);
        localObject = FinderContactSearchIncludeFollowUI.j(this.rAF).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759244);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(202847);
        return;
        label184:
        localObject = FinderContactSearchIncludeFollowUI.j(this.rAF).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759245);
          }
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    f(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI
 * JD-Core Version:    0.7.0.1
 */