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
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.amu;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.bvd;
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
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@com.tencent.mm.ui.base.a(7)
@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroid/support/design/widget/CoordinatorLayout;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getContactSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "ContactSearchProfileAdapter", "HeaderViewHolder", "plugin-finder_release"})
public final class FinderContactSearchIncludeFollowUI
  extends MMActivity
  implements f, FTSEditTextView.a, a.b
{
  static final String TAG = "Finder.FinderContactSearchIncludeFollowUI";
  public static final a ssN;
  private int continueFlag;
  String dwW;
  private View gWO;
  private RecyclerView gmV;
  private int iKR;
  private View kBS;
  private int offset;
  String query;
  private RefreshLoadMoreLayout rTF;
  private int requestType;
  private com.tencent.mm.bx.b sbF;
  private ArrayList<ard> sec;
  private com.tencent.mm.ui.search.a ssF;
  private boolean ssG;
  boolean ssH;
  HashMap<String, a> ssI;
  private CoordinatorLayout ssJ;
  private TextView ssK;
  private g ssL;
  private az ssM;
  
  static
  {
    AppMethodBeat.i(203432);
    ssN = new a((byte)0);
    TAG = "Finder.FinderContactSearchIncludeFollowUI";
    AppMethodBeat.o(203432);
  }
  
  public FinderContactSearchIncludeFollowUI()
  {
    AppMethodBeat.i(203431);
    this.query = "";
    this.sec = new ArrayList();
    this.dwW = "";
    this.ssG = true;
    this.ssI = new HashMap();
    AppMethodBeat.o(203431);
  }
  
  private final void ahT(String paramString)
  {
    AppMethodBeat.i(203427);
    mb(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.sbF = null;
    this.sec.clear();
    Object localObject = UUID.randomUUID().toString();
    p.g(localObject, "UUID.randomUUID().toString()");
    this.dwW = ((String)localObject);
    if (this.ssM != null) {
      com.tencent.mm.kernel.g.aiU().a((com.tencent.mm.al.n)this.ssM);
    }
    this.ssM = new az(paramString, this.offset, this.dwW, this.sbF, this.requestType, null, 32);
    com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)this.ssM);
    com.tencent.mm.kernel.g.aiU().a(3820, (f)this);
    paramString = this.gWO;
    if (paramString == null) {
      p.bcb("loadingView");
    }
    paramString.setVisibility(0);
    paramString = this.ssK;
    if (paramString == null) {
      p.bcb("noResultView");
    }
    paramString.setVisibility(8);
    paramString = this.rTF;
    if (paramString == null) {
      p.bcb("rlLayout");
    }
    paramString.setVisibility(8);
    paramString = this.gmV;
    if (paramString == null) {
      p.bcb("recyclerView");
    }
    localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(203427);
  }
  
  private final boolean cEE()
  {
    AppMethodBeat.i(203424);
    Object localObject1 = this.ssF;
    if (localObject1 == null) {
      p.bcb("searchView");
    }
    localObject1 = ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText();
    p.g(localObject1, "searchView.ftsEditText");
    localObject1 = ((FTSEditTextView)localObject1).getTotalQuery();
    if (localObject1 != null)
    {
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(203424);
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
      AppMethodBeat.o(203424);
      return true;
    }
    ahT((String)localObject1);
    Object localObject2 = this.ssL;
    if (localObject2 != null) {
      ((g)localObject2).ahW((String)localObject1);
    }
    AppMethodBeat.o(203424);
    return false;
  }
  
  private final int cEF()
  {
    AppMethodBeat.i(203429);
    Object localObject = this.gmV;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null)
      {
        i = ((RecyclerView.a)localObject).getItemCount();
        AppMethodBeat.o(203429);
        return i;
      }
    }
    int i = this.sec.size();
    AppMethodBeat.o(203429);
    return i;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(203420);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(203420);
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
      paramString2 = this.gWO;
      if (paramString2 == null) {
        p.bcb("loadingView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.ssK;
      if (paramString2 == null) {
        p.bcb("noResultView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.rTF;
      if (paramString2 == null) {
        p.bcb("rlLayout");
      }
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = this.ssL;
      if (paramString2 == null) {
        break;
      }
      paramString2.ahV(paramString1);
      AppMethodBeat.o(203420);
      return;
      cEE();
    }
    AppMethodBeat.o(203420);
  }
  
  public final boolean bzz()
  {
    AppMethodBeat.i(203423);
    hideVKB();
    if (cEE())
    {
      AppMethodBeat.o(203423);
      return true;
    }
    e.ygI.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(203423);
    return false;
  }
  
  public final void cED() {}
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(203426);
    super.finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(203426);
  }
  
  public final int getLayoutId()
  {
    return 2131496176;
  }
  
  public final void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(203421);
    if (paramBoolean)
    {
      i locali = i.soN;
      i.cDA();
    }
    AppMethodBeat.o(203421);
  }
  
  final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(203430);
    if (!bt.isNullOrNil(this.dwW)) {
      if (((Map)this.ssI).isEmpty()) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i locali = i.soN;
        i.a(this.dwW, this.query, this.ssI, 2);
        if (paramBoolean) {
          this.ssI.clear();
        }
      }
      AppMethodBeat.o(203430);
      return;
    }
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(203418);
    hideVKB();
    finish();
    AppMethodBeat.o(203418);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(203419);
    hideVKB();
    finish();
    AppMethodBeat.o(203419);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(203422);
    paramView = this.ssF;
    if (paramView == null) {
      p.bcb("searchView");
    }
    paramView.getFtsEditText().fJS();
    showVKB();
    AppMethodBeat.o(203422);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203417);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      p.g(paramBundle, "window");
      paramBundle.setStatusBarColor(getResources().getColor(2131101053));
    }
    this.ssF = new com.tencent.mm.ui.search.a((Context)this);
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(2131755882));
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().fJP();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.gfZ();
    }
    p.g(paramBundle, "supportActionBar!!");
    Object localObject1 = this.ssF;
    if (localObject1 == null) {
      p.bcb("searchView");
    }
    paramBundle.setCustomView((View)localObject1);
    this.requestType = getIntent().getIntExtra("request_type", 3);
    this.ssH = getIntent().getBooleanExtra("from_at_contact", false);
    this.ssG = getIntent().getBooleanExtra("need_history", false);
    paramBundle = h.stT;
    if (h.cEP() != null)
    {
      paramBundle = h.stT;
      Object localObject2 = h.cEP();
      if (localObject2 == null) {
        p.gfZ();
      }
      paramBundle = h.stT;
      h.a(null);
      localObject1 = ((amu)localObject2).dwW;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.dwW = paramBundle;
      localObject1 = ((amu)localObject2).query;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.query = paramBundle;
      this.offset = ((amu)localObject2).offset;
      this.continueFlag = ((amu)localObject2).continueFlag;
      this.sbF = ((amu)localObject2).sbF;
      this.iKR = ((amu)localObject2).Gmi;
      paramBundle = ((amu)localObject2).Gmj;
      p.g(paramBundle, "finderFeedObj.contactList");
      localObject1 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ard)((Iterator)localObject1).next();
        paramBundle.add(Boolean.valueOf(this.sec.add(localObject2)));
      }
    }
    paramBundle = UUID.randomUUID().toString();
    p.g(paramBundle, "UUID.randomUUID().toString()");
    this.dwW = paramBundle;
    this.query = "";
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().fJS();
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().fJR();
    if (this.ssG)
    {
      paramBundle = getContext().findViewById(2131300754);
      p.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(0);
      this.ssL = new g((MMActivity)this, (d.g.a.b)new f(this));
    }
    for (;;)
    {
      if (this.ssH) {
        setResult(0, getIntent());
      }
      ad.i(TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.ssH) });
      paramBundle = getContext().findViewById(2131304239);
      p.g(paramBundle, "context.findViewById(R.id.root)");
      this.kBS = paramBundle;
      paramBundle = getContext().findViewById(2131301992);
      p.g(paramBundle, "context.findViewById(R.id.main_rv)");
      this.ssJ = ((CoordinatorLayout)paramBundle);
      paramBundle = getContext().findViewById(2131304203);
      p.g(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.rTF = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.rTF;
      if (paramBundle == null) {
        p.bcb("rlLayout");
      }
      this.gmV = paramBundle.getRecyclerView();
      paramBundle = getContext().findViewById(2131302884);
      p.g(paramBundle, "context.findViewById(R.id.no_result_tv)");
      this.ssK = ((TextView)paramBundle);
      paramBundle = getContext().findViewById(2131301503);
      p.g(paramBundle, "context.findViewById(R.id.loading_layout)");
      this.gWO = paramBundle;
      paramBundle = new FinderLayoutManager((byte)0);
      localObject1 = this.gmV;
      if (localObject1 == null) {
        p.bcb("recyclerView");
      }
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)paramBundle);
      paramBundle = this.gmV;
      if (paramBundle == null) {
        p.bcb("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)new b((byte)0));
      paramBundle = this.gmV;
      if (paramBundle == null) {
        p.bcb("recyclerView");
      }
      paramBundle.setHasFixedSize(true);
      paramBundle = this.gmV;
      if (paramBundle == null) {
        p.bcb("recyclerView");
      }
      paramBundle.setItemViewCacheSize(5);
      paramBundle = this.gmV;
      if (paramBundle == null) {
        p.bcb("recyclerView");
      }
      paramBundle.setOnTouchListener((View.OnTouchListener)new d(this));
      paramBundle = this.rTF;
      if (paramBundle == null) {
        p.bcb("rlLayout");
      }
      paramBundle.setEnablePullDownHeader(false);
      paramBundle = this.rTF;
      if (paramBundle == null) {
        p.bcb("rlLayout");
      }
      localObject1 = com.tencent.mm.ui.z.jO((Context)getContext()).inflate(2131494590, null);
      p.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.rTF;
      if (paramBundle == null) {
        p.bcb("rlLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
      paramBundle = this.query;
      if (paramBundle != null)
      {
        localObject1 = this.ssF;
        if (localObject1 == null) {
          p.bcb("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText().H(paramBundle, null);
      }
      paramBundle = this.gmV;
      if (paramBundle == null) {
        p.bcb("recyclerView");
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
      paramBundle = this.gmV;
      if (paramBundle == null) {
        p.bcb("recyclerView");
      }
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(this.iKR, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(203417);
      return;
      paramBundle = getContext().findViewById(2131300754);
      p.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203425);
    g localg = this.ssL;
    if (localg != null) {
      localg.onDestroy();
    }
    mb(true);
    com.tencent.mm.kernel.g.aiU().b(3820, (f)this);
    super.onDestroy();
    AppMethodBeat.o(203425);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(203428);
    com.tencent.mm.kernel.g.aiU().b(3820, (f)this);
    int j = cEF();
    int i = cEF();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.ygI.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.ssM;
      if (paramString != null) {}
      for (paramString = paramString.rJS; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(203428);
        throw paramString;
      }
      paramn = paramString.vHi;
      p.g(paramn, "response.infoList");
      Object localObject = (Iterable)paramn;
      paramn = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ard localard = (ard)((Iterator)localObject).next();
        paramn.add(Boolean.valueOf(this.sec.add(localard)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.sbF = paramString.sbF;
      paramInt1 = cEF();
      ad.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.sec.size());
      paramString = this.rTF;
      if (paramString == null) {
        p.bcb("rlLayout");
      }
      paramString.afZ(0);
      if (paramInt1 != 0) {
        break label417;
      }
      paramString = this.gWO;
      if (paramString == null) {
        p.bcb("loadingView");
      }
      paramString.setVisibility(8);
      paramString = this.ssK;
      if (paramString == null) {
        p.bcb("noResultView");
      }
      paramString.setVisibility(0);
      paramString = this.rTF;
      if (paramString == null) {
        p.bcb("rlLayout");
      }
      paramString.setVisibility(8);
    }
    for (;;)
    {
      if (j == 0)
      {
        paramString = this.gmV;
        if (paramString == null) {
          p.bcb("recyclerView");
        }
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.notifyDataSetChanged();
          AppMethodBeat.o(203428);
          return;
          e.ygI.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label417:
          paramString = this.gWO;
          if (paramString == null) {
            p.bcb("loadingView");
          }
          paramString.setVisibility(8);
          paramString = this.ssK;
          if (paramString == null) {
            p.bcb("noResultView");
          }
          paramString.setVisibility(8);
          paramString = this.rTF;
          if (paramString == null) {
            p.bcb("rlLayout");
          }
          paramString.setVisibility(0);
          paramString = this.ssJ;
          if (paramString == null) {
            p.bcb("mainContainer");
          }
          paramString.setVisibility(0);
          paramString = this.kBS;
          if (paramString == null) {
            p.bcb("rootView");
          }
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setBackground(paramn.getResources().getDrawable(2131099648));
          continue;
        }
        AppMethodBeat.o(203428);
        return;
      }
    }
    if (j < paramInt1)
    {
      paramString = this.gmV;
      if (paramString == null) {
        p.bcb("recyclerView");
      }
      if (paramString != null)
      {
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.ar(j, paramInt1 - j);
          AppMethodBeat.o(203428);
          return;
        }
      }
    }
    AppMethodBeat.o(203428);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;I)V", "existFollowContact", "", "getExistFollowContact", "()Z", "setExistFollowContact", "(Z)V", "getRequestType", "()I", "unFollowContactIndex", "getUnFollowContactIndex", "setUnFollowContactIndex", "(I)V", "bindData", "", "holder", "position", "bindImage", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    private final int requestType = 3;
    private boolean ssO;
    private int ssP;
    
    private b() {}
    
    private final void i(RecyclerView.w paramw, final int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(203408);
      if ((paramw instanceof FinderContactSearchIncludeFollowUI.c))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderContactSearchIncludeFollowUI.c)paramw).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131765454));
          AppMethodBeat.o(203408);
          return;
        }
        ((FinderContactSearchIncludeFollowUI.c)paramw).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131765455));
        AppMethodBeat.o(203408);
        return;
      }
      ard localard;
      if ((this.requestType == 3) && (this.ssO) && (this.ssP != FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())) {
        if (paramInt < this.ssP + 1) {
          localard = (ard)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 1);
        }
      }
      for (;;)
      {
        p.g(localard, "if (requestType == Const…sition]\n                }");
        localObject = FinderContactSearchIncludeFollowUI.this;
        String str = localard.contact.username;
        p.g(str, "searchInfo.contact.username");
        p.h(str, "id");
        if (!((FinderContactSearchIncludeFollowUI)localObject).ssI.containsKey(str))
        {
          ad.d(FinderContactSearchIncludeFollowUI.TAG, "addExposeItem " + str + ' ' + paramInt + ' ' + 1);
          a locala = new a();
          locala.setId(str);
          locala.position = paramInt;
          locala.type = 1;
          locala.timeStamp = System.currentTimeMillis();
          ((Map)((FinderContactSearchIncludeFollowUI)localObject).ssI).put(str, locala);
          if (((FinderContactSearchIncludeFollowUI)localObject).ssI.size() % 30 == 0) {
            ((FinderContactSearchIncludeFollowUI)localObject).mb(false);
          }
        }
        if (paramw != null) {
          break;
        }
        paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
        AppMethodBeat.o(203408);
        throw paramw;
        localard = (ard)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 2);
        continue;
        localard = (ard)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt);
      }
      paramw = (c)paramw;
      Object localObject = (View.OnClickListener)new a(this, paramInt);
      if (paramInt != 0) {}
      for (;;)
      {
        paramw.a(localard, (View.OnClickListener)localObject, bool);
        AppMethodBeat.o(203408);
        return;
        bool = false;
      }
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(203406);
      p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        localObject = FinderContactSearchIncludeFollowUI.this;
        AppCompatActivity localAppCompatActivity = FinderContactSearchIncludeFollowUI.this.getContext();
        if (localAppCompatActivity == null) {
          p.gfZ();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496243, paramViewGroup, false);
        p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderContactSearchIncludeFollowUI.c((FinderContactSearchIncludeFollowUI)localObject, paramViewGroup);
        AppMethodBeat.o(203406);
        return paramViewGroup;
      }
      Object localObject = FinderContactSearchIncludeFollowUI.this.getContext();
      if (localObject == null) {
        p.gfZ();
      }
      paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(2131494018, paramViewGroup, false);
      p.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.w)new c(paramViewGroup);
      AppMethodBeat.o(203406);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(203409);
      p.h(paramw, "holder");
      i(paramw, paramInt);
      AppMethodBeat.o(203409);
    }
    
    public final void a(RecyclerView.w paramw, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(203407);
      p.h(paramw, "holder");
      p.h(paramList, "payloads");
      i(paramw, paramInt);
      AppMethodBeat.o(203407);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(203404);
      if ((this.requestType == 3) && (FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size() != 0))
      {
        this.ssP = 0;
        this.ssO = false;
        Iterator localIterator = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (ard)localIterator.next();
          c.a locala = com.tencent.mm.plugin.finder.api.c.rHn;
          localObject = ((ard)localObject).contact;
          if (localObject != null) {}
          for (localObject = ((FinderContact)localObject).username;; localObject = null)
          {
            if (!c.a.agZ((String)localObject)) {
              break label116;
            }
            this.ssO = true;
            this.ssP += 1;
            break;
          }
        }
        label116:
        if (this.ssO)
        {
          if (this.ssP == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
          {
            i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
            AppMethodBeat.o(203404);
            return i;
          }
          i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
          AppMethodBeat.o(203404);
          return i + 2;
        }
      }
      int i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
      AppMethodBeat.o(203404);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(203405);
      if ((this.requestType == 3) && (this.ssO))
      {
        if (this.ssP == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
        {
          AppMethodBeat.o(203405);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(203405);
          return 1;
        }
        if (paramInt == this.ssP + 1)
        {
          AppMethodBeat.o(203405);
          return 2;
        }
      }
      AppMethodBeat.o(203405);
      return 3;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchIncludeFollowUI.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203403);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        p.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(203403);
          throw paramView;
        }
        paramView = (ard)paramView;
        localObject1 = this.ssR.ssQ;
        int i = paramInt;
        p.h(paramView, "finderSearchInfo");
        Object localObject2;
        Object localObject3;
        if (((FinderContactSearchIncludeFollowUI)localObject1).ssH)
        {
          ad.i(FinderContactSearchIncludeFollowUI.TAG, "onContactItemClick select atContact");
          localObject2 = com.tencent.mm.plugin.finder.utils.b.sKO;
          localObject2 = paramView.contact;
          p.g(localObject2, "finderSearchInfo.contact");
          localObject2 = com.tencent.mm.plugin.finder.utils.b.c((FinderContact)localObject2);
          ((FinderContactSearchIncludeFollowUI)localObject1).getIntent().putExtra("at_select_contact", ((bvd)localObject2).toByteArray());
          localObject2 = ((FinderContactSearchIncludeFollowUI)localObject1).getIntent();
          localObject3 = com.tencent.mm.plugin.finder.api.c.rHn;
          paramView = paramView.contact;
          if (paramView != null)
          {
            paramView = paramView.username;
            ((Intent)localObject2).putExtra("is_follow", c.a.agZ(paramView));
            ((FinderContactSearchIncludeFollowUI)localObject1).setResult(-1, ((FinderContactSearchIncludeFollowUI)localObject1).getIntent());
            ((FinderContactSearchIncludeFollowUI)localObject1).finish();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203403);
          return;
          paramView = null;
          break;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("finder_username", paramView.contact.username);
          localObject3 = FinderReporterUIC.tcM;
          localObject3 = ((FinderContactSearchIncludeFollowUI)localObject1).getContext();
          p.g(localObject3, "context");
          FinderReporterUIC.a.a((Context)localObject3, (Intent)localObject2, 0L, 7, false, 64);
          localObject3 = com.tencent.mm.plugin.finder.utils.a.sKD;
          localObject3 = ((FinderContactSearchIncludeFollowUI)localObject1).getContext();
          p.g(localObject3, "context");
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject3, (Intent)localObject2);
          localObject2 = i.soN;
          localObject2 = ((FinderContactSearchIncludeFollowUI)localObject1).dwW;
          localObject3 = ((FinderContactSearchIncludeFollowUI)localObject1).query;
          String str = paramView.contact.username;
          p.g(str, "finderSearchInfo.contact.username");
          i.b((String)localObject2, (String)localObject3, 1, str, i, 2);
          localObject2 = FinderReporterUIC.tcM;
          localObject1 = ((FinderContactSearchIncludeFollowUI)localObject1).getContext();
          p.g(localObject1, "context");
          localObject1 = FinderReporterUIC.a.eY((Context)localObject1);
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.finder.report.h.soM;
            i = ((FinderReporterUIC)localObject1).rTD;
            paramView = paramView.contact.username;
            p.g(paramView, "finderSearchInfo.contact.username");
            com.tencent.mm.plugin.finder.report.h.a(6, 0L, i, 1, paramView);
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.w
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(203410);
      this$1 = localObject.findViewById(2131305948);
      p.g(FinderContactSearchIncludeFollowUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderContactSearchIncludeFollowUI.this);
      AppMethodBeat.o(203410);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(203411);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      FinderContactSearchIncludeFollowUI.b(this.ssQ).getFtsEditText().fHO();
      this.ssQ.hideVKB();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(203411);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(203413);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(203413);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203415);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203415);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203414);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203414);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(203412);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderContactSearchIncludeFollowUI.ssN;
      ad.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderContactSearchIncludeFollowUI.c(this.ssQ);
      if (localObject != null)
      {
        if (FinderContactSearchIncludeFollowUI.d(this.ssQ) != 1) {
          break label250;
        }
        FinderContactSearchIncludeFollowUI.a(this.ssQ, new az((String)localObject, FinderContactSearchIncludeFollowUI.f(this.ssQ), FinderContactSearchIncludeFollowUI.g(this.ssQ), FinderContactSearchIncludeFollowUI.h(this.ssQ), FinderContactSearchIncludeFollowUI.i(this.ssQ), null, 32));
        com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)FinderContactSearchIncludeFollowUI.e(this.ssQ));
        com.tencent.mm.kernel.g.aiU().a(3820, (f)this.ssQ);
        localObject = FinderContactSearchIncludeFollowUI.j(this.ssQ).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759244);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.ssQ).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.ssQ).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131308147);
          if (localObject != null) {
            ((View)localObject).setVisibility(8);
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(203412);
        return;
        label250:
        localObject = FinderContactSearchIncludeFollowUI.j(this.ssQ).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759245);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.ssQ).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.ssQ).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(2131308147);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<String, d.z>
  {
    f(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI
 * JD-Core Version:    0.7.0.1
 */