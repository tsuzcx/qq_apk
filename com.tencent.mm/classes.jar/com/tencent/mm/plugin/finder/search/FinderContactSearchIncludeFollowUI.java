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
import com.tencent.mm.ak.f;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.ba;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.view.manager.FinderLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
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
@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroid/support/design/widget/CoordinatorLayout;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getContactSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "ContactSearchProfileAdapter", "HeaderViewHolder", "plugin-finder_release"})
public final class FinderContactSearchIncludeFollowUI
  extends MMActivity
  implements f, FTSEditTextView.a, a.b
{
  static final String TAG = "Finder.FinderContactSearchIncludeFollowUI";
  public static final FinderContactSearchIncludeFollowUI.a sCX;
  private int continueFlag;
  String dyb;
  private View gZB;
  private RecyclerView gpr;
  private int iNK;
  private View kFh;
  private int offset;
  String query;
  private int requestType;
  private com.tencent.mm.ui.search.a sCP;
  private boolean sCQ;
  boolean sCR;
  HashMap<String, a> sCS;
  private CoordinatorLayout sCT;
  private TextView sCU;
  private g sCV;
  private ba sCW;
  private RefreshLoadMoreLayout scj;
  private com.tencent.mm.bw.b skw;
  private ArrayList<ars> smS;
  
  static
  {
    AppMethodBeat.i(203991);
    sCX = new FinderContactSearchIncludeFollowUI.a((byte)0);
    TAG = "Finder.FinderContactSearchIncludeFollowUI";
    AppMethodBeat.o(203991);
  }
  
  public FinderContactSearchIncludeFollowUI()
  {
    AppMethodBeat.i(203990);
    this.query = "";
    this.smS = new ArrayList();
    this.dyb = "";
    this.sCQ = true;
    this.sCS = new HashMap();
    AppMethodBeat.o(203990);
  }
  
  private final void aiR(String paramString)
  {
    AppMethodBeat.i(203986);
    mc(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.skw = null;
    this.smS.clear();
    Object localObject = UUID.randomUUID().toString();
    p.g(localObject, "UUID.randomUUID().toString()");
    this.dyb = ((String)localObject);
    if (this.sCW != null) {
      com.tencent.mm.kernel.g.ajj().a((com.tencent.mm.ak.n)this.sCW);
    }
    this.sCW = new ba(paramString, this.offset, this.dyb, this.skw, this.requestType, null, 32);
    com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)this.sCW);
    com.tencent.mm.kernel.g.ajj().a(3820, (f)this);
    paramString = this.gZB;
    if (paramString == null) {
      p.bdF("loadingView");
    }
    paramString.setVisibility(0);
    paramString = this.sCU;
    if (paramString == null) {
      p.bdF("noResultView");
    }
    paramString.setVisibility(8);
    paramString = this.scj;
    if (paramString == null) {
      p.bdF("rlLayout");
    }
    paramString.setVisibility(8);
    paramString = this.gpr;
    if (paramString == null) {
      p.bdF("recyclerView");
    }
    localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(203986);
  }
  
  private final boolean cGA()
  {
    AppMethodBeat.i(203983);
    Object localObject1 = this.sCP;
    if (localObject1 == null) {
      p.bdF("searchView");
    }
    localObject1 = ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText();
    p.g(localObject1, "searchView.ftsEditText");
    localObject1 = ((FTSEditTextView)localObject1).getTotalQuery();
    if (localObject1 != null)
    {
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(203983);
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
    if (bu.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(203983);
      return true;
    }
    aiR((String)localObject1);
    Object localObject2 = this.sCV;
    if (localObject2 != null) {
      ((g)localObject2).aiU((String)localObject1);
    }
    AppMethodBeat.o(203983);
    return false;
  }
  
  private final int cGB()
  {
    AppMethodBeat.i(203988);
    Object localObject = this.gpr;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null)
      {
        i = ((RecyclerView.a)localObject).getItemCount();
        AppMethodBeat.o(203988);
        return i;
      }
    }
    int i = this.smS.size();
    AppMethodBeat.o(203988);
    return i;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(203979);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(203979);
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
    if (bu.isNullOrNil(paramString1))
    {
      paramString2 = this.gZB;
      if (paramString2 == null) {
        p.bdF("loadingView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.sCU;
      if (paramString2 == null) {
        p.bdF("noResultView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.scj;
      if (paramString2 == null) {
        p.bdF("rlLayout");
      }
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = this.sCV;
      if (paramString2 == null) {
        break;
      }
      paramString2.aiT(paramString1);
      AppMethodBeat.o(203979);
      return;
      cGA();
    }
    AppMethodBeat.o(203979);
  }
  
  public final boolean bAu()
  {
    AppMethodBeat.i(203982);
    hideVKB();
    if (cGA())
    {
      AppMethodBeat.o(203982);
      return true;
    }
    e.ywz.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(203982);
    return false;
  }
  
  public final void cGz() {}
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(203985);
    super.finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(203985);
  }
  
  public final int getLayoutId()
  {
    return 2131496176;
  }
  
  public final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(203980);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.j localj = com.tencent.mm.plugin.finder.report.j.syU;
      com.tencent.mm.plugin.finder.report.j.cFv();
    }
    AppMethodBeat.o(203980);
  }
  
  final void mc(boolean paramBoolean)
  {
    AppMethodBeat.i(203989);
    if (!bu.isNullOrNil(this.dyb)) {
      if (((Map)this.sCS).isEmpty()) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        com.tencent.mm.plugin.finder.report.j localj = com.tencent.mm.plugin.finder.report.j.syU;
        com.tencent.mm.plugin.finder.report.j.a(this.dyb, this.query, this.sCS, 2);
        if (paramBoolean) {
          this.sCS.clear();
        }
      }
      AppMethodBeat.o(203989);
      return;
    }
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(203977);
    hideVKB();
    finish();
    AppMethodBeat.o(203977);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(203978);
    hideVKB();
    finish();
    AppMethodBeat.o(203978);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(203981);
    paramView = this.sCP;
    if (paramView == null) {
      p.bdF("searchView");
    }
    paramView.getFtsEditText().fOj();
    showVKB();
    AppMethodBeat.o(203981);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203976);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      p.g(paramBundle, "window");
      paramBundle.setStatusBarColor(getResources().getColor(2131101053));
    }
    this.sCP = new com.tencent.mm.ui.search.a((Context)this);
    paramBundle = this.sCP;
    if (paramBundle == null) {
      p.bdF("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.sCP;
    if (paramBundle == null) {
      p.bdF("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(2131755882));
    paramBundle = this.sCP;
    if (paramBundle == null) {
      p.bdF("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
    paramBundle = this.sCP;
    if (paramBundle == null) {
      p.bdF("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.sCP;
    if (paramBundle == null) {
      p.bdF("searchView");
    }
    paramBundle.getFtsEditText().fOg();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.gkB();
    }
    p.g(paramBundle, "supportActionBar!!");
    Object localObject1 = this.sCP;
    if (localObject1 == null) {
      p.bdF("searchView");
    }
    paramBundle.setCustomView((View)localObject1);
    this.requestType = getIntent().getIntExtra("request_type", 3);
    this.sCR = getIntent().getBooleanExtra("from_at_contact", false);
    this.sCQ = getIntent().getBooleanExtra("need_history", false);
    paramBundle = h.sEe;
    if (h.cGL() != null)
    {
      paramBundle = h.sEe;
      Object localObject2 = h.cGL();
      if (localObject2 == null) {
        p.gkB();
      }
      paramBundle = h.sEe;
      h.a(null);
      localObject1 = ((ang)localObject2).dyb;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.dyb = paramBundle;
      localObject1 = ((ang)localObject2).query;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.query = paramBundle;
      this.offset = ((ang)localObject2).offset;
      this.continueFlag = ((ang)localObject2).continueFlag;
      this.skw = ((ang)localObject2).skw;
      this.iNK = ((ang)localObject2).GFk;
      paramBundle = ((ang)localObject2).GFl;
      p.g(paramBundle, "finderFeedObj.contactList");
      localObject1 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ars)((Iterator)localObject1).next();
        paramBundle.add(Boolean.valueOf(this.smS.add(localObject2)));
      }
    }
    paramBundle = UUID.randomUUID().toString();
    p.g(paramBundle, "UUID.randomUUID().toString()");
    this.dyb = paramBundle;
    this.query = "";
    paramBundle = this.sCP;
    if (paramBundle == null) {
      p.bdF("searchView");
    }
    paramBundle.getFtsEditText().fOj();
    paramBundle = this.sCP;
    if (paramBundle == null) {
      p.bdF("searchView");
    }
    paramBundle.getFtsEditText().fOi();
    if (this.sCQ)
    {
      paramBundle = getContext().findViewById(2131300754);
      p.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(0);
      this.sCV = new g((MMActivity)this, (d.g.a.b)new f(this));
    }
    for (;;)
    {
      if (this.sCR) {
        setResult(0, getIntent());
      }
      ae.i(TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.sCR) });
      paramBundle = getContext().findViewById(2131304239);
      p.g(paramBundle, "context.findViewById(R.id.root)");
      this.kFh = paramBundle;
      paramBundle = getContext().findViewById(2131301992);
      p.g(paramBundle, "context.findViewById(R.id.main_rv)");
      this.sCT = ((CoordinatorLayout)paramBundle);
      paramBundle = getContext().findViewById(2131304203);
      p.g(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.scj = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.scj;
      if (paramBundle == null) {
        p.bdF("rlLayout");
      }
      this.gpr = paramBundle.getRecyclerView();
      paramBundle = getContext().findViewById(2131302884);
      p.g(paramBundle, "context.findViewById(R.id.no_result_tv)");
      this.sCU = ((TextView)paramBundle);
      paramBundle = getContext().findViewById(2131301503);
      p.g(paramBundle, "context.findViewById(R.id.loading_layout)");
      this.gZB = paramBundle;
      paramBundle = new FinderLayoutManager((byte)0);
      localObject1 = this.gpr;
      if (localObject1 == null) {
        p.bdF("recyclerView");
      }
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.i)paramBundle);
      paramBundle = this.gpr;
      if (paramBundle == null) {
        p.bdF("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)new b((byte)0));
      paramBundle = this.gpr;
      if (paramBundle == null) {
        p.bdF("recyclerView");
      }
      paramBundle.setHasFixedSize(true);
      paramBundle = this.gpr;
      if (paramBundle == null) {
        p.bdF("recyclerView");
      }
      paramBundle.setItemViewCacheSize(5);
      paramBundle = this.gpr;
      if (paramBundle == null) {
        p.bdF("recyclerView");
      }
      paramBundle.setOnTouchListener((View.OnTouchListener)new d(this));
      paramBundle = this.scj;
      if (paramBundle == null) {
        p.bdF("rlLayout");
      }
      paramBundle.setEnablePullDownHeader(false);
      paramBundle = this.scj;
      if (paramBundle == null) {
        p.bdF("rlLayout");
      }
      localObject1 = com.tencent.mm.ui.z.jV((Context)getContext()).inflate(2131494590, null);
      p.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.scj;
      if (paramBundle == null) {
        p.bdF("rlLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
      paramBundle = this.query;
      if (paramBundle != null)
      {
        localObject1 = this.sCP;
        if (localObject1 == null) {
          p.bdF("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText().I(paramBundle, null);
      }
      paramBundle = this.gpr;
      if (paramBundle == null) {
        p.bdF("recyclerView");
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
      paramBundle = this.gpr;
      if (paramBundle == null) {
        p.bdF("recyclerView");
      }
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(this.iNK, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(203976);
      return;
      paramBundle = getContext().findViewById(2131300754);
      p.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203984);
    g localg = this.sCV;
    if (localg != null) {
      localg.onDestroy();
    }
    mc(true);
    com.tencent.mm.kernel.g.ajj().b(3820, (f)this);
    super.onDestroy();
    AppMethodBeat.o(203984);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(203987);
    com.tencent.mm.kernel.g.ajj().b(3820, (f)this);
    int j = cGB();
    int i = cGB();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.ywz.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.sCW;
      if (paramString != null) {}
      for (paramString = paramString.rSg; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(203987);
        throw paramString;
      }
      paramn = paramString.vTm;
      p.g(paramn, "response.infoList");
      Object localObject = (Iterable)paramn;
      paramn = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ars localars = (ars)((Iterator)localObject).next();
        paramn.add(Boolean.valueOf(this.smS.add(localars)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.skw = paramString.skw;
      paramInt1 = cGB();
      ae.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.smS.size());
      paramString = this.scj;
      if (paramString == null) {
        p.bdF("rlLayout");
      }
      paramString.agI(0);
      if (paramInt1 != 0) {
        break label417;
      }
      paramString = this.gZB;
      if (paramString == null) {
        p.bdF("loadingView");
      }
      paramString.setVisibility(8);
      paramString = this.sCU;
      if (paramString == null) {
        p.bdF("noResultView");
      }
      paramString.setVisibility(0);
      paramString = this.scj;
      if (paramString == null) {
        p.bdF("rlLayout");
      }
      paramString.setVisibility(8);
    }
    for (;;)
    {
      if (j == 0)
      {
        paramString = this.gpr;
        if (paramString == null) {
          p.bdF("recyclerView");
        }
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.notifyDataSetChanged();
          AppMethodBeat.o(203987);
          return;
          e.ywz.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label417:
          paramString = this.gZB;
          if (paramString == null) {
            p.bdF("loadingView");
          }
          paramString.setVisibility(8);
          paramString = this.sCU;
          if (paramString == null) {
            p.bdF("noResultView");
          }
          paramString.setVisibility(8);
          paramString = this.scj;
          if (paramString == null) {
            p.bdF("rlLayout");
          }
          paramString.setVisibility(0);
          paramString = this.sCT;
          if (paramString == null) {
            p.bdF("mainContainer");
          }
          paramString.setVisibility(0);
          paramString = this.kFh;
          if (paramString == null) {
            p.bdF("rootView");
          }
          paramn = getContext();
          p.g(paramn, "context");
          paramString.setBackground(paramn.getResources().getDrawable(2131099648));
          continue;
        }
        AppMethodBeat.o(203987);
        return;
      }
    }
    if (j < paramInt1)
    {
      paramString = this.gpr;
      if (paramString == null) {
        p.bdF("recyclerView");
      }
      if (paramString != null)
      {
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.ar(j, paramInt1 - j);
          AppMethodBeat.o(203987);
          return;
        }
      }
    }
    AppMethodBeat.o(203987);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;I)V", "existFollowContact", "", "getExistFollowContact", "()Z", "setExistFollowContact", "(Z)V", "getRequestType", "()I", "unFollowContactIndex", "getUnFollowContactIndex", "setUnFollowContactIndex", "(I)V", "bindData", "", "holder", "position", "bindImage", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.w>
  {
    private final int requestType = 3;
    private boolean sCY;
    private int sCZ;
    
    private b() {}
    
    private final void i(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(203967);
      if ((paramw instanceof FinderContactSearchIncludeFollowUI.c))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderContactSearchIncludeFollowUI.c)paramw).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131765454));
          AppMethodBeat.o(203967);
          return;
        }
        ((FinderContactSearchIncludeFollowUI.c)paramw).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131765455));
        AppMethodBeat.o(203967);
        return;
      }
      ars localars;
      FinderContactSearchIncludeFollowUI localFinderContactSearchIncludeFollowUI;
      Object localObject;
      if ((this.requestType == 3) && (this.sCY) && (this.sCZ != FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())) {
        if (paramInt < this.sCZ + 1)
        {
          localars = (ars)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 1);
          p.g(localars, "if (requestType == Const…sition]\n                }");
          localFinderContactSearchIncludeFollowUI = FinderContactSearchIncludeFollowUI.this;
          localObject = localars.contact;
          if (localObject != null)
          {
            localObject = ((FinderContact)localObject).username;
            if (localObject != null) {
              break label419;
            }
          }
          localObject = "";
        }
      }
      label419:
      for (;;)
      {
        p.h(localObject, "id");
        if (!localFinderContactSearchIncludeFollowUI.sCS.containsKey(localObject))
        {
          ae.d(FinderContactSearchIncludeFollowUI.TAG, "addExposeItem " + (String)localObject + ' ' + paramInt + ' ' + 1);
          a locala = new a();
          locala.setId((String)localObject);
          locala.position = paramInt;
          locala.type = 1;
          locala.timeStamp = System.currentTimeMillis();
          ((Map)localFinderContactSearchIncludeFollowUI.sCS).put(localObject, locala);
          if (localFinderContactSearchIncludeFollowUI.sCS.size() % 30 == 0) {
            localFinderContactSearchIncludeFollowUI.mc(false);
          }
        }
        if (paramw == null)
        {
          paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
          AppMethodBeat.o(203967);
          throw paramw;
          localars = (ars)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 2);
          break;
          localars = (ars)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt);
          break;
        }
        paramw = (c)paramw;
        localObject = (View.OnClickListener)new a(this, paramInt);
        if (paramInt != 0) {}
        for (boolean bool = true;; bool = false)
        {
          paramw.a(localars, (View.OnClickListener)localObject, bool);
          AppMethodBeat.o(203967);
          return;
        }
      }
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(203965);
      p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        localObject = FinderContactSearchIncludeFollowUI.this;
        AppCompatActivity localAppCompatActivity = FinderContactSearchIncludeFollowUI.this.getContext();
        if (localAppCompatActivity == null) {
          p.gkB();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131496243, paramViewGroup, false);
        p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.w)new FinderContactSearchIncludeFollowUI.c((FinderContactSearchIncludeFollowUI)localObject, paramViewGroup);
        AppMethodBeat.o(203965);
        return paramViewGroup;
      }
      Object localObject = FinderContactSearchIncludeFollowUI.this.getContext();
      if (localObject == null) {
        p.gkB();
      }
      paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(2131494018, paramViewGroup, false);
      p.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.w)new c(paramViewGroup);
      AppMethodBeat.o(203965);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(203968);
      p.h(paramw, "holder");
      i(paramw, paramInt);
      AppMethodBeat.o(203968);
    }
    
    public final void a(RecyclerView.w paramw, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(203966);
      p.h(paramw, "holder");
      p.h(paramList, "payloads");
      i(paramw, paramInt);
      AppMethodBeat.o(203966);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(203963);
      if ((this.requestType == 3) && (FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size() != 0))
      {
        this.sCZ = 0;
        this.sCY = false;
        Iterator localIterator = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (ars)localIterator.next();
          c.a locala = com.tencent.mm.plugin.finder.api.c.rPy;
          localObject = ((ars)localObject).contact;
          if (localObject != null) {}
          for (localObject = ((FinderContact)localObject).username;; localObject = null)
          {
            if (!c.a.ahW((String)localObject)) {
              break label116;
            }
            this.sCY = true;
            this.sCZ += 1;
            break;
          }
        }
        label116:
        if (this.sCY)
        {
          if (this.sCZ == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
          {
            i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
            AppMethodBeat.o(203963);
            return i;
          }
          i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
          AppMethodBeat.o(203963);
          return i + 2;
        }
      }
      int i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
      AppMethodBeat.o(203963);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(203964);
      if ((this.requestType == 3) && (this.sCY))
      {
        if (this.sCZ == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
        {
          AppMethodBeat.o(203964);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(203964);
          return 1;
        }
        if (paramInt == this.sCZ + 1)
        {
          AppMethodBeat.o(203964);
          return 2;
        }
      }
      AppMethodBeat.o(203964);
      return 3;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchIncludeFollowUI.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(203962);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        p.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(203962);
          throw paramView;
        }
        ars localars = (ars)paramView;
        FinderContactSearchIncludeFollowUI localFinderContactSearchIncludeFollowUI = this.sDb.sDa;
        int i = paramInt;
        p.h(localars, "finderSearchInfo");
        if (localFinderContactSearchIncludeFollowUI.sCR)
        {
          ae.i(FinderContactSearchIncludeFollowUI.TAG, "onContactItemClick select atContact");
          paramView = com.tencent.mm.plugin.finder.utils.b.sWa;
          localObject1 = localars.contact;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = new FinderContact();
          }
          paramView = com.tencent.mm.plugin.finder.utils.b.e(paramView);
          localFinderContactSearchIncludeFollowUI.getIntent().putExtra("at_select_contact", paramView.toByteArray());
          localObject1 = localFinderContactSearchIncludeFollowUI.getIntent();
          paramView = com.tencent.mm.plugin.finder.api.c.rPy;
          paramView = localars.contact;
          if (paramView != null)
          {
            paramView = paramView.username;
            ((Intent)localObject1).putExtra("is_follow", c.a.ahW(paramView));
            localFinderContactSearchIncludeFollowUI.setResult(-1, localFinderContactSearchIncludeFollowUI.getIntent());
            localFinderContactSearchIncludeFollowUI.finish();
          }
        }
        label358:
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(203962);
          return;
          paramView = null;
          break;
          Object localObject2 = new Intent();
          paramView = localars.contact;
          if (paramView != null)
          {
            localObject1 = paramView.username;
            paramView = (View)localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            paramView = "";
          }
          ((Intent)localObject2).putExtra("finder_username", paramView);
          paramView = FinderReporterUIC.tnG;
          paramView = localFinderContactSearchIncludeFollowUI.getContext();
          p.g(paramView, "context");
          FinderReporterUIC.a.a((Context)paramView, (Intent)localObject2, 0L, 7, false, 64);
          paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
          paramView = localFinderContactSearchIncludeFollowUI.getContext();
          p.g(paramView, "context");
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)paramView, (Intent)localObject2);
          paramView = com.tencent.mm.plugin.finder.report.j.syU;
          localObject1 = localFinderContactSearchIncludeFollowUI.dyb;
          localObject2 = localFinderContactSearchIncludeFollowUI.query;
          paramView = localars.contact;
          if (paramView == null) {
            break label432;
          }
          paramView = paramView.username;
          com.tencent.mm.plugin.finder.report.j.b((String)localObject1, (String)localObject2, 1, paramView, i, 2);
          paramView = FinderReporterUIC.tnG;
          paramView = localFinderContactSearchIncludeFollowUI.getContext();
          p.g(paramView, "context");
          paramView = FinderReporterUIC.a.fc((Context)paramView);
        } while (paramView == null);
        localObject1 = i.syT;
        i = paramView.sch;
        paramView = localars.contact;
        if (paramView != null) {}
        for (paramView = paramView.username;; paramView = null)
        {
          i.a(6, 0L, i, 1, paramView);
          break;
          label432:
          paramView = null;
          break label358;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.w
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(203969);
      this$1 = localObject.findViewById(2131305948);
      p.g(FinderContactSearchIncludeFollowUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderContactSearchIncludeFollowUI.this);
      AppMethodBeat.o(203969);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(203970);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      FinderContactSearchIncludeFollowUI.b(this.sDa).getFtsEditText().fMg();
      this.sDa.hideVKB();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(203970);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(203972);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(203972);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203974);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203974);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203973);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203973);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(203971);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderContactSearchIncludeFollowUI.sCX;
      ae.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderContactSearchIncludeFollowUI.c(this.sDa);
      if (localObject != null)
      {
        if (FinderContactSearchIncludeFollowUI.d(this.sDa) != 1) {
          break label250;
        }
        FinderContactSearchIncludeFollowUI.a(this.sDa, new ba((String)localObject, FinderContactSearchIncludeFollowUI.f(this.sDa), FinderContactSearchIncludeFollowUI.g(this.sDa), FinderContactSearchIncludeFollowUI.h(this.sDa), FinderContactSearchIncludeFollowUI.i(this.sDa), null, 32));
        com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)FinderContactSearchIncludeFollowUI.e(this.sDa));
        com.tencent.mm.kernel.g.ajj().a(3820, (f)this.sDa);
        localObject = FinderContactSearchIncludeFollowUI.j(this.sDa).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759244);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.sDa).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.sDa).getLoadMoreFooter();
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
        AppMethodBeat.o(203971);
        return;
        label250:
        localObject = FinderContactSearchIncludeFollowUI.j(this.sDa).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759245);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.sDa).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.sDa).getLoadMoreFooter();
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI
 * JD-Core Version:    0.7.0.1
 */