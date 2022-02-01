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
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.event.base.f;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aik;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import d.a.j;
import d.g.b.k;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "addExposeItem", "", "id", "position", "type", "getLayoutId", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "ContactSearchProfileAdapter", "FinderFeedSearchReporter", "plugin-finder_release"})
public final class FinderContactSearchUI
  extends MMFinderUI
  implements com.tencent.mm.al.g, FTSEditTextView.a, a.b
{
  boolean KVM;
  final String TAG;
  private HashMap _$_findViewCache;
  private int continueFlag;
  String dnB;
  private RecyclerView fPw;
  private int hRJ;
  private View lZo;
  private int offset;
  private ArrayList<aky> qHA;
  private boolean qHB;
  private HashMap<String, a> qHC;
  private TextView qHD;
  private h qHE;
  private aa qHF;
  private com.tencent.mm.ui.search.a qHy;
  private com.tencent.mm.bx.b qHz;
  private final com.tencent.mm.plugin.finder.event.base.d qsx;
  String query;
  private RefreshLoadMoreLayout quj;
  private int requestType;
  
  public FinderContactSearchUI()
  {
    AppMethodBeat.i(166742);
    this.TAG = "Finder.FinderContactSearchUI";
    this.query = "";
    this.qHA = new ArrayList();
    this.dnB = "";
    this.qHB = true;
    this.qHC = new HashMap();
    this.qsx = new com.tencent.mm.plugin.finder.event.base.d();
    AppMethodBeat.o(166742);
  }
  
  private final void Zl(String paramString)
  {
    AppMethodBeat.i(166738);
    lc(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.qHz = null;
    this.qHA.clear();
    Object localObject = UUID.randomUUID().toString();
    k.g(localObject, "UUID.randomUUID().toString()");
    this.dnB = ((String)localObject);
    if (this.qHF != null) {
      com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)this.qHF);
    }
    this.qHF = new aa(paramString, this.offset, this.dnB, this.qHz, this.requestType, null, 32);
    com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)this.qHF);
    com.tencent.mm.kernel.g.aeS().a(3820, (com.tencent.mm.al.g)this);
    paramString = this.lZo;
    if (paramString == null) {
      k.aPZ("loadingView");
    }
    paramString.setVisibility(0);
    paramString = this.qHD;
    if (paramString == null) {
      k.aPZ("noResultView");
    }
    paramString.setVisibility(8);
    paramString = this.quj;
    if (paramString == null) {
      k.aPZ("rlLayout");
    }
    paramString.setVisibility(8);
    paramString = this.fPw;
    if (paramString == null) {
      k.aPZ("recyclerView");
    }
    localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166738);
  }
  
  private final void lc(boolean paramBoolean)
  {
    AppMethodBeat.i(166741);
    if (!bt.isNullOrNil(this.dnB)) {
      if (((Map)this.qHC).isEmpty()) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.qFr;
        com.tencent.mm.plugin.finder.report.d.a(this.dnB, this.query, this.qHC, 2);
        if (paramBoolean) {
          this.qHC.clear();
        }
      }
      AppMethodBeat.o(166741);
      return;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198921);
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
    AppMethodBeat.o(198921);
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
    if (bt.isNullOrNil(paramString1))
    {
      paramString2 = this.lZo;
      if (paramString2 == null) {
        k.aPZ("loadingView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.qHD;
      if (paramString2 == null) {
        k.aPZ("noResultView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.quj;
      if (paramString2 == null) {
        k.aPZ("rlLayout");
      }
      paramString2.setVisibility(8);
    }
    paramString2 = this.qHE;
    if (paramString2 != null)
    {
      paramString2.Zo(paramString1);
      AppMethodBeat.o(166733);
      return;
    }
    AppMethodBeat.o(166733);
  }
  
  public final boolean bow()
  {
    AppMethodBeat.i(166736);
    hideVKB();
    Object localObject1 = this.qHy;
    if (localObject1 == null) {
      k.aPZ("searchView");
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
    if (bt.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(166736);
      return true;
    }
    Zl((String)localObject1);
    Object localObject2 = this.qHE;
    if (localObject2 != null) {
      ((h)localObject2).Zp((String)localObject1);
    }
    e.vIY.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(166736);
    return false;
  }
  
  public final void cW(String paramString, int paramInt)
  {
    AppMethodBeat.i(166740);
    k.h(paramString, "id");
    if (!this.qHC.containsKey(paramString))
    {
      ad.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt + ' ' + 1);
      a locala = new a();
      locala.Zm(paramString);
      locala.position = paramInt;
      locala.type = 1;
      locala.timeStamp = System.currentTimeMillis();
      ((Map)this.qHC).put(paramString, locala);
      if (this.qHC.size() % 30 == 0) {
        lc(false);
      }
    }
    AppMethodBeat.o(166740);
  }
  
  public final void cok() {}
  
  public final int getLayoutId()
  {
    return 2131494019;
  }
  
  public final void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(166734);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.d locald = com.tencent.mm.plugin.finder.report.d.qFr;
      com.tencent.mm.plugin.finder.report.d.cnB();
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
    paramView = this.qHy;
    if (paramView == null) {
      k.aPZ("searchView");
    }
    paramView.getFtsEditText().fdj();
    showVKB();
    AppMethodBeat.o(166735);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166730);
    super.onCreate(paramBundle);
    this.qHy = new com.tencent.mm.ui.search.a((Context)this);
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(2131755882));
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().fdg();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      k.fvU();
    }
    k.g(paramBundle, "supportActionBar!!");
    Object localObject1 = this.qHy;
    if (localObject1 == null) {
      k.aPZ("searchView");
    }
    paramBundle.setCustomView((View)localObject1);
    this.requestType = getIntent().getIntExtra("request_type", 2);
    this.KVM = getIntent().getBooleanExtra("from_at_contact", false);
    this.qHB = getIntent().getBooleanExtra("need_history", true);
    paramBundle = i.qIB;
    if (i.cov() != null)
    {
      paramBundle = i.qIB;
      Object localObject2 = i.cov();
      if (localObject2 == null) {
        k.fvU();
      }
      paramBundle = i.qIB;
      i.a(null);
      localObject1 = ((aik)localObject2).dnB;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.dnB = paramBundle;
      localObject1 = ((aik)localObject2).query;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.query = paramBundle;
      this.offset = ((aik)localObject2).offset;
      this.continueFlag = ((aik)localObject2).continueFlag;
      this.qHz = ((aik)localObject2).qHz;
      this.hRJ = ((aik)localObject2).Dlc;
      paramBundle = ((aik)localObject2).qMq;
      k.g(paramBundle, "finderFeedObj.contactList");
      localObject1 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (aky)((Iterator)localObject1).next();
        paramBundle.add(Boolean.valueOf(this.qHA.add(localObject2)));
      }
    }
    paramBundle = UUID.randomUUID().toString();
    k.g(paramBundle, "UUID.randomUUID().toString()");
    this.dnB = paramBundle;
    this.query = "";
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().fdj();
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().fdi();
    if (this.qHB) {
      this.qHE = new h((MMActivity)this, (d.g.a.b)new e(this));
    }
    if (this.KVM) {
      setResult(0, getIntent());
    }
    ad.i(this.TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.KVM) });
    paramBundle = getContext().findViewById(2131304203);
    k.g(paramBundle, "context.findViewById(R.id.rl_layout)");
    this.quj = ((RefreshLoadMoreLayout)paramBundle);
    paramBundle = this.quj;
    if (paramBundle == null) {
      k.aPZ("rlLayout");
    }
    this.fPw = paramBundle.getRecyclerView();
    paramBundle = getContext().findViewById(2131302884);
    k.g(paramBundle, "context.findViewById(R.id.no_result_tv)");
    this.qHD = ((TextView)paramBundle);
    paramBundle = getContext().findViewById(2131301503);
    k.g(paramBundle, "context.findViewById(R.id.loading_layout)");
    this.lZo = paramBundle;
    paramBundle = new FinderLayoutManager((byte)0);
    localObject1 = this.fPw;
    if (localObject1 == null) {
      k.aPZ("recyclerView");
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)paramBundle);
    paramBundle = this.fPw;
    if (paramBundle == null) {
      k.aPZ("recyclerView");
    }
    paramBundle.setAdapter((RecyclerView.a)new a());
    paramBundle = this.fPw;
    if (paramBundle == null) {
      k.aPZ("recyclerView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.fPw;
    if (paramBundle == null) {
      k.aPZ("recyclerView");
    }
    paramBundle.setItemViewCacheSize(5);
    paramBundle = this.fPw;
    if (paramBundle == null) {
      k.aPZ("recyclerView");
    }
    paramBundle.setOnTouchListener((View.OnTouchListener)new c(this));
    paramBundle = this.quj;
    if (paramBundle == null) {
      k.aPZ("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.quj;
    if (paramBundle == null) {
      k.aPZ("rlLayout");
    }
    localObject1 = com.tencent.mm.ui.y.js((Context)getContext()).inflate(2131494590, null);
    k.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
    paramBundle.setLoadMoreFooter((View)localObject1);
    paramBundle = this.quj;
    if (paramBundle == null) {
      k.aPZ("rlLayout");
    }
    paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new d(this));
    paramBundle = this.query;
    if (paramBundle != null)
    {
      localObject1 = this.qHy;
      if (localObject1 == null) {
        k.aPZ("searchView");
      }
      ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText().J(paramBundle, null);
    }
    paramBundle = this.fPw;
    if (paramBundle == null) {
      k.aPZ("recyclerView");
    }
    paramBundle = paramBundle.getAdapter();
    if (paramBundle != null) {
      paramBundle.notifyDataSetChanged();
    }
    paramBundle = this.fPw;
    if (paramBundle == null) {
      k.aPZ("recyclerView");
    }
    localObject1 = com.tencent.mm.hellhoundlib.b.c.a(this.hRJ, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
    paramBundle.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
    this.qsx.a((f)new b());
    AppMethodBeat.o(166730);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166737);
    h localh = this.qHE;
    if (localh != null) {
      localh.onDestroy();
    }
    lc(true);
    this.qsx.onRelease();
    com.tencent.mm.kernel.g.aeS().b(3820, (com.tencent.mm.al.g)this);
    super.onDestroy();
    AppMethodBeat.o(166737);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(166739);
    com.tencent.mm.kernel.g.aeS().b(3820, (com.tencent.mm.al.g)this);
    int j = this.qHA.size();
    int i = this.qHA.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.vIY.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.qHF;
      if (paramString != null) {}
      for (paramString = paramString.qpw; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166739);
        throw paramString;
      }
      paramn = paramString.tvP;
      k.g(paramn, "response.infoList");
      Object localObject = (Iterable)paramn;
      paramn = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aky localaky = (aky)((Iterator)localObject).next();
        paramn.add(Boolean.valueOf(this.qHA.add(localaky)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.qHz = paramString.qHz;
      paramInt1 = this.qHA.size();
      ad.i(this.TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.qHA.size());
      paramString = this.quj;
      if (paramString == null) {
        k.aPZ("rlLayout");
      }
      paramString.abh(0);
      if (paramInt1 != 0) {
        break label426;
      }
      paramString = this.lZo;
      if (paramString == null) {
        k.aPZ("loadingView");
      }
      paramString.setVisibility(8);
      paramString = this.qHD;
      if (paramString == null) {
        k.aPZ("noResultView");
      }
      paramString.setVisibility(0);
      paramString = this.quj;
      if (paramString == null) {
        k.aPZ("rlLayout");
      }
      paramString.setVisibility(8);
    }
    for (;;)
    {
      if (j == 0)
      {
        paramString = this.fPw;
        if (paramString == null) {
          k.aPZ("recyclerView");
        }
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.notifyDataSetChanged();
          AppMethodBeat.o(166739);
          return;
          e.vIY.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label426:
          paramString = this.lZo;
          if (paramString == null) {
            k.aPZ("loadingView");
          }
          paramString.setVisibility(8);
          paramString = this.qHD;
          if (paramString == null) {
            k.aPZ("noResultView");
          }
          paramString.setVisibility(8);
          paramString = this.quj;
          if (paramString == null) {
            k.aPZ("rlLayout");
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
      paramString = this.fPw;
      if (paramString == null) {
        k.aPZ("recyclerView");
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "bindData", "", "holder", "position", "", "bindImage", "", "getItemCount", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<RecyclerView.v>
  {
    private final void i(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(166724);
      Object localObject1 = FinderContactSearchUI.a(this.qHG).get(paramInt);
      k.g(localObject1, "contactList[position]");
      localObject1 = (aky)localObject1;
      Object localObject2 = this.qHG;
      String str = ((aky)localObject1).contact.username;
      k.g(str, "searchInfo.contact.username");
      ((FinderContactSearchUI)localObject2).cW(str, paramInt);
      if (paramv == null)
      {
        paramv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
        AppMethodBeat.o(166724);
        throw paramv;
      }
      paramv = (c)paramv;
      localObject2 = (View.OnClickListener)new a(this, paramInt);
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramv.a((aky)localObject1, (View.OnClickListener)localObject2, bool);
        AppMethodBeat.o(166724);
        return;
      }
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(166722);
      k.h(paramViewGroup, "parent");
      AppCompatActivity localAppCompatActivity = this.qHG.getContext();
      if (localAppCompatActivity == null) {
        k.fvU();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494018, paramViewGroup, false);
      k.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(166722);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(166725);
      k.h(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(166725);
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(166723);
      k.h(paramv, "holder");
      k.h(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(166723);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166721);
      int i = FinderContactSearchUI.a(this.qHG).size();
      AppMethodBeat.o(166721);
      return i;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
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
        paramView = (aky)paramView;
        Object localObject1 = this.qHH.qHG;
        int i = paramInt;
        k.h(paramView, "finderSearchInfo");
        if (((FinderContactSearchUI)localObject1).KVM)
        {
          ad.i(((FinderContactSearchUI)localObject1).TAG, "onContactItemClick select atContact");
          localObject2 = com.tencent.mm.plugin.finder.utils.n.LaC;
          paramView = paramView.contact;
          k.g(paramView, "finderSearchInfo.contact");
          paramView = com.tencent.mm.plugin.finder.utils.n.d(paramView);
          ((FinderContactSearchUI)localObject1).getIntent().putExtra("at_select_contact", paramView.toByteArray());
          ((FinderContactSearchUI)localObject1).setResult(-1, ((FinderContactSearchUI)localObject1).getIntent());
          ((FinderContactSearchUI)localObject1).finish();
          AppMethodBeat.o(166720);
          return;
        }
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("finder_username", paramView.contact.username);
        Object localObject3 = FinderReporterUIC.Ljl;
        localObject3 = ((FinderContactSearchUI)localObject1).getContext();
        k.g(localObject3, "context");
        FinderReporterUIC.a.a((Context)localObject3, (Intent)localObject2, 0L, 7, false, 64);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.qSb;
        localObject3 = ((FinderContactSearchUI)localObject1).getContext();
        k.g(localObject3, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject3, (Intent)localObject2);
        localObject2 = com.tencent.mm.plugin.finder.report.d.qFr;
        localObject2 = ((FinderContactSearchUI)localObject1).dnB;
        localObject3 = ((FinderContactSearchUI)localObject1).query;
        String str = paramView.contact.username;
        k.g(str, "finderSearchInfo.contact.username");
        com.tencent.mm.plugin.finder.report.d.b((String)localObject2, (String)localObject3, 1, str, i, 2);
        localObject2 = FinderReporterUIC.Ljl;
        localObject1 = ((FinderContactSearchUI)localObject1).getContext();
        k.g(localObject1, "context");
        localObject1 = FinderReporterUIC.a.lB((Context)localObject1);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
          i = ((FinderReporterUIC)localObject1).qqE;
          paramView = paramView.contact.username;
          k.g(paramView, "finderSearchInfo.contact.username");
          com.tencent.mm.plugin.finder.report.b.a(6, 0L, i, 1, paramView);
          AppMethodBeat.o(166720);
          return;
        }
        AppMethodBeat.o(166720);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$FinderFeedSearchReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public final class b
    extends f
  {
    public final void a(com.tencent.mm.plugin.finder.event.base.c paramc)
    {
      AppMethodBeat.i(166726);
      k.h(paramc, "event");
      if ((paramc instanceof com.tencent.mm.plugin.finder.event.base.i))
      {
        int i = ((com.tencent.mm.plugin.finder.event.base.i)paramc).qsi;
        int j = ((com.tencent.mm.plugin.finder.event.base.i)paramc).qsj;
        if (i <= j) {
          for (;;)
          {
            paramc = this.qHG;
            String str = ((aky)FinderContactSearchUI.a(this.qHG).get(i)).contact.username;
            k.g(str, "contactList[i].contact.username");
            paramc.cW(str, i);
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(166726);
    }
    
    public final boolean clc()
    {
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(FinderContactSearchUI paramFinderContactSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(166727);
      FinderContactSearchUI.b(this.qHG).getFtsEditText().fbk();
      this.qHG.hideVKB();
      AppMethodBeat.o(166727);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class d
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(198920);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(198920);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(198918);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      super.agP(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(198918);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(198919);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(198919);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(166728);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ad.i(FinderContactSearchUI.c(this.qHG), "onLoadMoreBegin");
      Object localObject = FinderContactSearchUI.d(this.qHG);
      if (localObject != null)
      {
        if (FinderContactSearchUI.e(this.qHG) != 1) {
          break label184;
        }
        FinderContactSearchUI.a(this.qHG, new aa((String)localObject, FinderContactSearchUI.g(this.qHG), FinderContactSearchUI.h(this.qHG), FinderContactSearchUI.i(this.qHG), FinderContactSearchUI.j(this.qHG), null, 32));
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)FinderContactSearchUI.f(this.qHG));
        com.tencent.mm.kernel.g.aeS().a(3820, (com.tencent.mm.al.g)this.qHG);
        localObject = FinderContactSearchUI.k(this.qHG).getLoadMoreFooter();
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
        localObject = FinderContactSearchUI.k(this.qHG).getLoadMoreFooter();
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    e(FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchUI
 * JD-Core Version:    0.7.0.1
 */