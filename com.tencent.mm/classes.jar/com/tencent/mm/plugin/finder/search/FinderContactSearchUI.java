package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.as;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "addExposeItem", "", "id", "position", "type", "getLayoutId", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "ContactSearchProfileAdapter", "FinderFeedSearchReporter", "plugin-finder_release"})
public final class FinderContactSearchUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g, FTSEditTextView.a, a.b
{
  final String TAG;
  private HashMap _$_findViewCache;
  private int continueFlag;
  String dlj;
  private RecyclerView fTr;
  private View gDe;
  private int irO;
  private int offset;
  String query;
  private g rAA;
  private as rAB;
  private com.tencent.mm.ui.search.a rAu;
  private boolean rAv;
  boolean rAw;
  private HashMap<String, a> rAx;
  private TextView rAz;
  private final com.tencent.mm.plugin.finder.event.base.c rdn;
  private int requestType;
  private RefreshLoadMoreLayout rfT;
  private com.tencent.mm.bw.b rmJ;
  private ArrayList<anr> rpr;
  
  public FinderContactSearchUI()
  {
    AppMethodBeat.i(166742);
    this.TAG = "Finder.FinderContactSearchUI";
    this.query = "";
    this.rpr = new ArrayList();
    this.dlj = "";
    this.rAv = true;
    this.rAx = new HashMap();
    this.rdn = new com.tencent.mm.plugin.finder.event.base.c();
    AppMethodBeat.o(166742);
  }
  
  private final void adT(String paramString)
  {
    AppMethodBeat.i(166738);
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
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166738);
  }
  
  private final void lG(boolean paramBoolean)
  {
    AppMethodBeat.i(166741);
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
      AppMethodBeat.o(166741);
      return;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202874);
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
    AppMethodBeat.o(202874);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(166733);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(166733);
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
    paramString2 = this.rAA;
    if (paramString2 != null)
    {
      paramString2.adW(paramString1);
      AppMethodBeat.o(166733);
      return;
    }
    AppMethodBeat.o(166733);
  }
  
  public final boolean bvs()
  {
    AppMethodBeat.i(166736);
    hideVKB();
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
        AppMethodBeat.o(166736);
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
      AppMethodBeat.o(166736);
      return true;
    }
    adT((String)localObject1);
    Object localObject2 = this.rAA;
    if (localObject2 != null) {
      ((g)localObject2).adX((String)localObject1);
    }
    com.tencent.mm.plugin.report.e.wTc.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(166736);
    return false;
  }
  
  public final void cxG() {}
  
  public final void dc(String paramString, int paramInt)
  {
    AppMethodBeat.i(166740);
    k.h(paramString, "id");
    if (!this.rAx.containsKey(paramString))
    {
      ac.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt + ' ' + 1);
      a locala = new a();
      locala.adU(paramString);
      locala.position = paramInt;
      locala.type = 1;
      locala.timeStamp = System.currentTimeMillis();
      ((Map)this.rAx).put(paramString, locala);
      if (this.rAx.size() % 30 == 0) {
        lG(false);
      }
    }
    AppMethodBeat.o(166740);
  }
  
  public final int getLayoutId()
  {
    return 2131494019;
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(166734);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.e locale = com.tencent.mm.plugin.finder.report.e.rxs;
      com.tencent.mm.plugin.finder.report.e.cwV();
    }
    AppMethodBeat.o(166734);
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(166731);
    hideVKB();
    finish();
    AppMethodBeat.o(166731);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(166732);
    hideVKB();
    finish();
    AppMethodBeat.o(166732);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(166735);
    paramView = this.rAu;
    if (paramView == null) {
      k.aVY("searchView");
    }
    paramView.getFtsEditText().fte();
    showVKB();
    AppMethodBeat.o(166735);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166730);
    super.onCreate(paramBundle);
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
    this.requestType = getIntent().getIntExtra("request_type", 2);
    this.rAw = getIntent().getBooleanExtra("from_at_contact", false);
    this.rAv = getIntent().getBooleanExtra("need_history", true);
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
    if (this.rAv) {
      this.rAA = new g((MMActivity)this, (d.g.a.b)new e(this));
    }
    if (this.rAw) {
      setResult(0, getIntent());
    }
    ac.i(this.TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.rAw) });
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
    paramBundle.setAdapter((RecyclerView.a)new a());
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
    paramBundle.setOnTouchListener((View.OnTouchListener)new c(this));
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
    paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new d(this));
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
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aeD(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
    paramBundle.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).lR(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
    this.rdn.a((com.tencent.mm.plugin.finder.event.base.d)new b());
    AppMethodBeat.o(166730);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166737);
    g localg = this.rAA;
    if (localg != null) {
      localg.onDestroy();
    }
    lG(true);
    this.rdn.onRelease();
    com.tencent.mm.kernel.g.agi().b(3820, (com.tencent.mm.ak.g)this);
    super.onDestroy();
    AppMethodBeat.o(166737);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(166739);
    com.tencent.mm.kernel.g.agi().b(3820, (com.tencent.mm.ak.g)this);
    int j = this.rpr.size();
    int i = this.rpr.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.rAB;
      if (paramString != null) {}
      for (paramString = paramString.qYC; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166739);
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
      paramInt1 = this.rpr.size();
      ac.i(this.TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.rpr.size());
      paramString = this.rfT;
      if (paramString == null) {
        k.aVY("rlLayout");
      }
      paramString.adz(0);
      if (paramInt1 != 0) {
        break label426;
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
          AppMethodBeat.o(166739);
          return;
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label426:
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
          continue;
        }
        AppMethodBeat.o(166739);
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
          AppMethodBeat.o(166739);
          return;
        }
      }
    }
    AppMethodBeat.o(166739);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "bindData", "", "holder", "position", "", "bindImage", "", "getItemCount", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<RecyclerView.w>
  {
    private final void i(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(166724);
      Object localObject1 = FinderContactSearchUI.a(this.rAH).get(paramInt);
      k.g(localObject1, "contactList[position]");
      localObject1 = (anr)localObject1;
      Object localObject2 = this.rAH;
      String str = ((anr)localObject1).contact.username;
      k.g(str, "searchInfo.contact.username");
      ((FinderContactSearchUI)localObject2).dc(str, paramInt);
      if (paramw == null)
      {
        paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
        AppMethodBeat.o(166724);
        throw paramw;
      }
      paramw = (c)paramw;
      localObject2 = (View.OnClickListener)new a(this, paramInt);
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramw.a((anr)localObject1, (View.OnClickListener)localObject2, bool);
        AppMethodBeat.o(166724);
        return;
      }
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(166722);
      k.h(paramViewGroup, "parent");
      AppCompatActivity localAppCompatActivity = this.rAH.getContext();
      if (localAppCompatActivity == null) {
        k.fOy();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494018, paramViewGroup, false);
      k.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.w)new c(paramViewGroup);
      AppMethodBeat.o(166722);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(166725);
      k.h(paramw, "holder");
      i(paramw, paramInt);
      AppMethodBeat.o(166725);
    }
    
    public final void a(RecyclerView.w paramw, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(166723);
      k.h(paramw, "holder");
      k.h(paramList, "payloads");
      i(paramw, paramInt);
      AppMethodBeat.o(166723);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166721);
      int i = FinderContactSearchUI.a(this.rAH).size();
      AppMethodBeat.o(166721);
      return i;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchUI.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166720);
        k.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(166720);
          throw paramView;
        }
        paramView = (anr)paramView;
        Object localObject1 = this.rAI.rAH;
        int i = paramInt;
        k.h(paramView, "finderSearchInfo");
        if (((FinderContactSearchUI)localObject1).rAw)
        {
          ac.i(((FinderContactSearchUI)localObject1).TAG, "onContactItemClick select atContact");
          localObject2 = com.tencent.mm.plugin.finder.utils.b.rOw;
          paramView = paramView.contact;
          k.g(paramView, "finderSearchInfo.contact");
          paramView = com.tencent.mm.plugin.finder.utils.b.d(paramView);
          ((FinderContactSearchUI)localObject1).getIntent().putExtra("at_select_contact", paramView.toByteArray());
          ((FinderContactSearchUI)localObject1).setResult(-1, ((FinderContactSearchUI)localObject1).getIntent());
          ((FinderContactSearchUI)localObject1).finish();
          AppMethodBeat.o(166720);
          return;
        }
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("finder_username", paramView.contact.username);
        Object localObject3 = FinderReporterUIC.seQ;
        localObject3 = ((FinderContactSearchUI)localObject1).getContext();
        k.g(localObject3, "context");
        FinderReporterUIC.a.a((Context)localObject3, (Intent)localObject2, 0L, 7, false, 64);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.rOv;
        localObject3 = ((FinderContactSearchUI)localObject1).getContext();
        k.g(localObject3, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject3, (Intent)localObject2);
        localObject2 = com.tencent.mm.plugin.finder.report.e.rxs;
        localObject2 = ((FinderContactSearchUI)localObject1).dlj;
        localObject3 = ((FinderContactSearchUI)localObject1).query;
        String str = paramView.contact.username;
        k.g(str, "finderSearchInfo.contact.username");
        com.tencent.mm.plugin.finder.report.e.b((String)localObject2, (String)localObject3, 1, str, i, 2);
        localObject2 = FinderReporterUIC.seQ;
        localObject1 = ((FinderContactSearchUI)localObject1).getContext();
        k.g(localObject1, "context");
        localObject1 = FinderReporterUIC.a.eV((Context)localObject1);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.d.rxr;
          i = ((FinderReporterUIC)localObject1).rfR;
          paramView = paramView.contact.username;
          k.g(paramView, "finderSearchInfo.contact.username");
          com.tencent.mm.plugin.finder.report.d.a(6, 0L, i, 1, paramView);
          AppMethodBeat.o(166720);
          return;
        }
        AppMethodBeat.o(166720);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$FinderFeedSearchReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(166726);
      k.h(paramb, "event");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        int i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rdH;
        int j = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rdJ;
        if (i <= j) {
          for (;;)
          {
            paramb = this.rAH;
            String str = ((anr)FinderContactSearchUI.a(this.rAH).get(i)).contact.username;
            k.g(str, "contactList[i].contact.username");
            paramb.dc(str, i);
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(166726);
    }
    
    public final boolean csW()
    {
      return true;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(FinderContactSearchUI paramFinderContactSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(166727);
      FinderContactSearchUI.b(this.rAH).getFtsEditText().frb();
      this.rAH.hideVKB();
      AppMethodBeat.o(166727);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class d
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(202871);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(202871);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(202873);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202873);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(202872);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(202872);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(166728);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ac.i(FinderContactSearchUI.c(this.rAH), "onLoadMoreBegin");
      Object localObject = FinderContactSearchUI.d(this.rAH);
      if (localObject != null)
      {
        if (FinderContactSearchUI.e(this.rAH) != 1) {
          break label184;
        }
        FinderContactSearchUI.a(this.rAH, new as((String)localObject, FinderContactSearchUI.g(this.rAH), FinderContactSearchUI.h(this.rAH), FinderContactSearchUI.i(this.rAH), FinderContactSearchUI.j(this.rAH), null, 32));
        com.tencent.mm.kernel.g.agi().b((com.tencent.mm.ak.n)FinderContactSearchUI.f(this.rAH));
        com.tencent.mm.kernel.g.agi().a(3820, (com.tencent.mm.ak.g)this.rAH);
        localObject = FinderContactSearchUI.k(this.rAH).getLoadMoreFooter();
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
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(166728);
        return;
        label184:
        localObject = FinderContactSearchUI.k(this.rAH).getLoadMoreFooter();
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
  static final class e
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    e(FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchUI
 * JD-Core Version:    0.7.0.1
 */