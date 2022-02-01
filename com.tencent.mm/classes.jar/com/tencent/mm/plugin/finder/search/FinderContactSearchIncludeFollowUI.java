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
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.finder.api.b.a;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.report.d;
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

@com.tencent.mm.ui.base.a(7)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroid/support/design/widget/CoordinatorLayout;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getContactSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "ContactSearchProfileAdapter", "HeaderViewHolder", "plugin-finder_release"})
public final class FinderContactSearchIncludeFollowUI
  extends MMActivity
  implements com.tencent.mm.al.g, FTSEditTextView.a, a.b
{
  public static final a KVO;
  static final String TAG = "Finder.FinderContactSearchIncludeFollowUI";
  boolean KVM;
  private CoordinatorLayout KVN;
  private int continueFlag;
  String dnB;
  private RecyclerView fPw;
  private int hRJ;
  private View jGG;
  private View lZo;
  private int offset;
  private ArrayList<aky> qHA;
  private boolean qHB;
  HashMap<String, a> qHC;
  private TextView qHD;
  private h qHE;
  private aa qHF;
  private com.tencent.mm.ui.search.a qHy;
  private com.tencent.mm.bx.b qHz;
  String query;
  private RefreshLoadMoreLayout quj;
  private int requestType;
  
  static
  {
    AppMethodBeat.i(198914);
    KVO = new a((byte)0);
    TAG = "Finder.FinderContactSearchIncludeFollowUI";
    AppMethodBeat.o(198914);
  }
  
  public FinderContactSearchIncludeFollowUI()
  {
    AppMethodBeat.i(198913);
    this.query = "";
    this.qHA = new ArrayList();
    this.dnB = "";
    this.qHB = true;
    this.qHC = new HashMap();
    AppMethodBeat.o(198913);
  }
  
  private final void Zl(String paramString)
  {
    AppMethodBeat.i(198909);
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
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(198909);
  }
  
  private final boolean fTY()
  {
    AppMethodBeat.i(198906);
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
        AppMethodBeat.o(198906);
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
      AppMethodBeat.o(198906);
      return true;
    }
    Zl((String)localObject1);
    Object localObject2 = this.qHE;
    if (localObject2 != null) {
      ((h)localObject2).Zp((String)localObject1);
    }
    AppMethodBeat.o(198906);
    return false;
  }
  
  private final int fTZ()
  {
    AppMethodBeat.i(198911);
    Object localObject = this.fPw;
    if (localObject == null) {
      k.aPZ("recyclerView");
    }
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null)
      {
        i = ((RecyclerView.a)localObject).getItemCount();
        AppMethodBeat.o(198911);
        return i;
      }
    }
    int i = this.qHA.size();
    AppMethodBeat.o(198911);
    return i;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(198902);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(198902);
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
    for (;;)
    {
      paramString2 = this.qHE;
      if (paramString2 == null) {
        break;
      }
      paramString2.Zo(paramString1);
      AppMethodBeat.o(198902);
      return;
      fTY();
    }
    AppMethodBeat.o(198902);
  }
  
  public final boolean bow()
  {
    AppMethodBeat.i(198905);
    hideVKB();
    if (fTY())
    {
      AppMethodBeat.o(198905);
      return true;
    }
    e.vIY.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(198905);
    return false;
  }
  
  public final void cok() {}
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(198908);
    super.finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(198908);
  }
  
  public final int getLayoutId()
  {
    return 2131496175;
  }
  
  public final void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(198903);
    if (paramBoolean)
    {
      d locald = d.qFr;
      d.cnB();
    }
    AppMethodBeat.o(198903);
  }
  
  final void lc(boolean paramBoolean)
  {
    AppMethodBeat.i(198912);
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
        d locald = d.qFr;
        d.a(this.dnB, this.query, this.qHC, 2);
        if (paramBoolean) {
          this.qHC.clear();
        }
      }
      AppMethodBeat.o(198912);
      return;
    }
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(198900);
    hideVKB();
    finish();
    AppMethodBeat.o(198900);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(198901);
    hideVKB();
    finish();
    AppMethodBeat.o(198901);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(198904);
    paramView = this.qHy;
    if (paramView == null) {
      k.aPZ("searchView");
    }
    paramView.getFtsEditText().fdj();
    showVKB();
    AppMethodBeat.o(198904);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198899);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      k.g(paramBundle, "window");
      paramBundle.setStatusBarColor(getResources().getColor(2131101053));
    }
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
    this.requestType = getIntent().getIntExtra("request_type", 3);
    this.KVM = getIntent().getBooleanExtra("from_at_contact", false);
    this.qHB = getIntent().getBooleanExtra("need_history", false);
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
    if (this.qHB)
    {
      paramBundle = getContext().findViewById(2131300754);
      k.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(0);
      this.qHE = new h((MMActivity)this, (d.g.a.b)new f(this));
    }
    for (;;)
    {
      if (this.KVM) {
        setResult(0, getIntent());
      }
      ad.i(TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.KVM) });
      paramBundle = getContext().findViewById(2131304239);
      k.g(paramBundle, "context.findViewById(R.id.root)");
      this.jGG = paramBundle;
      paramBundle = getContext().findViewById(2131301992);
      k.g(paramBundle, "context.findViewById(R.id.main_rv)");
      this.KVN = ((CoordinatorLayout)paramBundle);
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
      paramBundle.setAdapter((RecyclerView.a)new b((byte)0));
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
      paramBundle.setOnTouchListener((View.OnTouchListener)new d(this));
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
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
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
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).adn(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(198899);
      return;
      paramBundle = getContext().findViewById(2131300754);
      k.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198907);
    h localh = this.qHE;
    if (localh != null) {
      localh.onDestroy();
    }
    lc(true);
    com.tencent.mm.kernel.g.aeS().b(3820, (com.tencent.mm.al.g)this);
    super.onDestroy();
    AppMethodBeat.o(198907);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(198910);
    com.tencent.mm.kernel.g.aeS().b(3820, (com.tencent.mm.al.g)this);
    int j = fTZ();
    int i = fTZ();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.vIY.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.qHF;
      if (paramString != null) {}
      for (paramString = paramString.qpw; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(198910);
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
      paramInt1 = fTZ();
      ad.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.qHA.size());
      paramString = this.quj;
      if (paramString == null) {
        k.aPZ("rlLayout");
      }
      paramString.abh(0);
      if (paramInt1 != 0) {
        break label417;
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
          AppMethodBeat.o(198910);
          return;
          e.vIY.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label417:
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
          paramString = this.KVN;
          if (paramString == null) {
            k.aPZ("mainContainer");
          }
          paramString.setVisibility(0);
          paramString = this.jGG;
          if (paramString == null) {
            k.aPZ("rootView");
          }
          paramn = getContext();
          k.g(paramn, "context");
          paramString.setBackground(paramn.getResources().getDrawable(2131099648));
          continue;
        }
        AppMethodBeat.o(198910);
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
          AppMethodBeat.o(198910);
          return;
        }
      }
    }
    AppMethodBeat.o(198910);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;I)V", "existFollowContact", "", "getExistFollowContact", "()Z", "setExistFollowContact", "(Z)V", "getRequestType", "()I", "unFollowContactIndex", "getUnFollowContactIndex", "setUnFollowContactIndex", "(I)V", "bindData", "", "holder", "position", "bindImage", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    private boolean KVP;
    private int KVQ;
    private final int requestType = 3;
    
    private b() {}
    
    private final void i(RecyclerView.v paramv, final int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(198890);
      if ((paramv instanceof FinderContactSearchIncludeFollowUI.c))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderContactSearchIncludeFollowUI.c)paramv).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131765432));
          AppMethodBeat.o(198890);
          return;
        }
        ((FinderContactSearchIncludeFollowUI.c)paramv).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131765433));
        AppMethodBeat.o(198890);
        return;
      }
      aky localaky;
      if ((this.requestType == 3) && (this.KVP) && (this.KVQ != FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())) {
        if (paramInt < this.KVQ + 1) {
          localaky = (aky)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 1);
        }
      }
      for (;;)
      {
        k.g(localaky, "if (requestType == Const…sition]\n                }");
        localObject = FinderContactSearchIncludeFollowUI.this;
        String str = localaky.contact.username;
        k.g(str, "searchInfo.contact.username");
        k.h(str, "id");
        if (!((FinderContactSearchIncludeFollowUI)localObject).qHC.containsKey(str))
        {
          ad.d(FinderContactSearchIncludeFollowUI.TAG, "addExposeItem " + str + ' ' + paramInt + ' ' + 1);
          a locala = new a();
          locala.Zm(str);
          locala.position = paramInt;
          locala.type = 1;
          locala.timeStamp = System.currentTimeMillis();
          ((Map)((FinderContactSearchIncludeFollowUI)localObject).qHC).put(str, locala);
          if (((FinderContactSearchIncludeFollowUI)localObject).qHC.size() % 30 == 0) {
            ((FinderContactSearchIncludeFollowUI)localObject).lc(false);
          }
        }
        if (paramv != null) {
          break;
        }
        paramv = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
        AppMethodBeat.o(198890);
        throw paramv;
        localaky = (aky)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 2);
        continue;
        localaky = (aky)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt);
      }
      paramv = (c)paramv;
      Object localObject = (View.OnClickListener)new a(this, paramInt);
      if (paramInt != 0) {}
      for (;;)
      {
        paramv.a(localaky, (View.OnClickListener)localObject, bool);
        AppMethodBeat.o(198890);
        return;
        bool = false;
      }
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(198888);
      k.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        localObject = FinderContactSearchIncludeFollowUI.this;
        AppCompatActivity localAppCompatActivity = FinderContactSearchIncludeFollowUI.this.getContext();
        if (localAppCompatActivity == null) {
          k.fvU();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496242, paramViewGroup, false);
        k.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderContactSearchIncludeFollowUI.c((FinderContactSearchIncludeFollowUI)localObject, paramViewGroup);
        AppMethodBeat.o(198888);
        return paramViewGroup;
      }
      Object localObject = FinderContactSearchIncludeFollowUI.this.getContext();
      if (localObject == null) {
        k.fvU();
      }
      paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(2131494018, paramViewGroup, false);
      k.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(198888);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(198891);
      k.h(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(198891);
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(198889);
      k.h(paramv, "holder");
      k.h(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(198889);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(198886);
      if ((this.requestType == 3) && (FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size() != 0))
      {
        this.KVQ = 0;
        this.KVP = false;
        Iterator localIterator = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (aky)localIterator.next();
          b.a locala = com.tencent.mm.plugin.finder.api.b.qnX;
          localObject = ((aky)localObject).contact;
          if (localObject != null) {}
          for (localObject = ((FinderContact)localObject).username;; localObject = null)
          {
            if (!b.a.YO((String)localObject)) {
              break label116;
            }
            this.KVP = true;
            this.KVQ += 1;
            break;
          }
        }
        label116:
        if (this.KVP)
        {
          if (this.KVQ == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
          {
            i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
            AppMethodBeat.o(198886);
            return i;
          }
          i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
          AppMethodBeat.o(198886);
          return i + 2;
        }
      }
      int i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
      AppMethodBeat.o(198886);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(198887);
      if ((this.requestType == 3) && (this.KVP))
      {
        if (this.KVQ == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
        {
          AppMethodBeat.o(198887);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(198887);
          return 1;
        }
        if (paramInt == this.KVQ + 1)
        {
          AppMethodBeat.o(198887);
          return 2;
        }
      }
      AppMethodBeat.o(198887);
      return 3;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchIncludeFollowUI.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(198885);
        k.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(198885);
          throw paramView;
        }
        paramView = (aky)paramView;
        Object localObject1 = this.KVS.KVR;
        int i = paramInt;
        k.h(paramView, "finderSearchInfo");
        if (((FinderContactSearchIncludeFollowUI)localObject1).KVM)
        {
          ad.i(FinderContactSearchIncludeFollowUI.TAG, "onContactItemClick select atContact");
          localObject2 = com.tencent.mm.plugin.finder.utils.n.LaC;
          localObject2 = paramView.contact;
          k.g(localObject2, "finderSearchInfo.contact");
          localObject2 = com.tencent.mm.plugin.finder.utils.n.d((FinderContact)localObject2);
          ((FinderContactSearchIncludeFollowUI)localObject1).getIntent().putExtra("at_select_contact", ((ebc)localObject2).toByteArray());
          localObject2 = ((FinderContactSearchIncludeFollowUI)localObject1).getIntent();
          localObject3 = com.tencent.mm.plugin.finder.api.b.qnX;
          paramView = paramView.contact;
          if (paramView != null) {}
          for (paramView = paramView.username;; paramView = null)
          {
            ((Intent)localObject2).putExtra("is_follow", b.a.YO(paramView));
            ((FinderContactSearchIncludeFollowUI)localObject1).setResult(-1, ((FinderContactSearchIncludeFollowUI)localObject1).getIntent());
            ((FinderContactSearchIncludeFollowUI)localObject1).finish();
            AppMethodBeat.o(198885);
            return;
          }
        }
        Object localObject2 = new Intent();
        ((Intent)localObject2).putExtra("finder_username", paramView.contact.username);
        Object localObject3 = FinderReporterUIC.Ljl;
        localObject3 = ((FinderContactSearchIncludeFollowUI)localObject1).getContext();
        k.g(localObject3, "context");
        FinderReporterUIC.a.a((Context)localObject3, (Intent)localObject2, 0L, 7, false, 64);
        localObject3 = com.tencent.mm.plugin.finder.utils.a.qSb;
        localObject3 = ((FinderContactSearchIncludeFollowUI)localObject1).getContext();
        k.g(localObject3, "context");
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject3, (Intent)localObject2);
        localObject2 = d.qFr;
        localObject2 = ((FinderContactSearchIncludeFollowUI)localObject1).dnB;
        localObject3 = ((FinderContactSearchIncludeFollowUI)localObject1).query;
        String str = paramView.contact.username;
        k.g(str, "finderSearchInfo.contact.username");
        d.b((String)localObject2, (String)localObject3, 1, str, i, 2);
        localObject2 = FinderReporterUIC.Ljl;
        localObject1 = ((FinderContactSearchIncludeFollowUI)localObject1).getContext();
        k.g(localObject1, "context");
        localObject1 = FinderReporterUIC.a.lB((Context)localObject1);
        if (localObject1 != null)
        {
          localObject2 = com.tencent.mm.plugin.finder.report.b.qFq;
          i = ((FinderReporterUIC)localObject1).qqE;
          paramView = paramView.contact.username;
          k.g(paramView, "finderSearchInfo.contact.username");
          com.tencent.mm.plugin.finder.report.b.a(6, 0L, i, 1, paramView);
          AppMethodBeat.o(198885);
          return;
        }
        AppMethodBeat.o(198885);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(198892);
      this$1 = localObject.findViewById(2131305948);
      k.g(FinderContactSearchIncludeFollowUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderContactSearchIncludeFollowUI.this);
      AppMethodBeat.o(198892);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(198893);
      FinderContactSearchIncludeFollowUI.b(this.KVR).getFtsEditText().fbk();
      this.KVR.hideVKB();
      AppMethodBeat.o(198893);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(198897);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(198897);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(198895);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      super.agP(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(198895);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(198896);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(198896);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(198894);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderContactSearchIncludeFollowUI.KVO;
      ad.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderContactSearchIncludeFollowUI.c(this.KVR);
      if (localObject != null)
      {
        if (FinderContactSearchIncludeFollowUI.d(this.KVR) != 1) {
          break label184;
        }
        FinderContactSearchIncludeFollowUI.a(this.KVR, new aa((String)localObject, FinderContactSearchIncludeFollowUI.f(this.KVR), FinderContactSearchIncludeFollowUI.g(this.KVR), FinderContactSearchIncludeFollowUI.h(this.KVR), FinderContactSearchIncludeFollowUI.i(this.KVR), null, 32));
        com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)FinderContactSearchIncludeFollowUI.e(this.KVR));
        com.tencent.mm.kernel.g.aeS().a(3820, (com.tencent.mm.al.g)this.KVR);
        localObject = FinderContactSearchIncludeFollowUI.j(this.KVR).getLoadMoreFooter();
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
        AppMethodBeat.o(198894);
        return;
        label184:
        localObject = FinderContactSearchIncludeFollowUI.j(this.KVR).getLoadMoreFooter();
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
  static final class f
    extends d.g.b.l
    implements d.g.a.b<String, d.y>
  {
    f(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI
 * JD-Core Version:    0.7.0.1
 */