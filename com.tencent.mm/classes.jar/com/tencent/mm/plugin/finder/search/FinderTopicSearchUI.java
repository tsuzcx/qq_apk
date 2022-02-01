package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.cgi.dk;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.aa;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "needHistory", "", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "topicList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSearchInfo;", "Lkotlin/collections/ArrayList;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getLayoutId", "getTopicSize", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "HeaderViewHolder", "TopicSearchAdapter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTopicSearchUI
  extends MMActivity
  implements com.tencent.mm.am.h, FTSEditTextView.c, FTSSearchView.b
{
  public static final a Fyt;
  private static final String TAG;
  private RefreshLoadMoreLayout ATx;
  private com.tencent.mm.bx.b BgS;
  private TextView BnA;
  private j BnB;
  private dk BnD;
  private FTSSearchView Bny;
  private ArrayList<bxx> FvB;
  private boolean FvC;
  private HashMap<String, a> FvE;
  private CoordinatorLayout FvF;
  private int continueFlag;
  private String hOG;
  private RecyclerView mkw;
  private View njN;
  private int offset;
  private int pyl;
  private String query;
  private int requestType;
  private View rootView;
  
  static
  {
    AppMethodBeat.i(342632);
    Fyt = new a((byte)0);
    TAG = "Finder.FinderTopicSearchUI";
    AppMethodBeat.o(342632);
  }
  
  public FinderTopicSearchUI()
  {
    AppMethodBeat.i(342440);
    this.query = "";
    this.FvB = new ArrayList();
    this.hOG = "";
    this.FvC = true;
    this.FvE = new HashMap();
    AppMethodBeat.o(342440);
  }
  
  private static final boolean a(FinderTopicSearchUI paramFinderTopicSearchUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342500);
    kotlin.g.b.s.u(paramFinderTopicSearchUI, "this$0");
    paramMotionEvent = paramFinderTopicSearchUI.Bny;
    paramView = paramMotionEvent;
    if (paramMotionEvent == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().dzv.clearFocus();
    paramFinderTopicSearchUI.hideVKB();
    AppMethodBeat.o(342500);
    return false;
  }
  
  private final void awg(String paramString)
  {
    AppMethodBeat.i(342469);
    tZ(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.BgS = null;
    this.FvB.clear();
    Object localObject = UUID.randomUUID().toString();
    kotlin.g.b.s.s(localObject, "randomUUID().toString()");
    this.hOG = ((String)localObject);
    if (this.BnD != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD);
    }
    this.BnD = new dk(paramString, this.offset, this.hOG, this.BgS, this.requestType, null, null, null, 480);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD, 0);
    com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)this);
    localObject = this.njN;
    paramString = (String)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("loadingView");
      paramString = null;
    }
    paramString.setVisibility(0);
    localObject = this.BnA;
    paramString = (String)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("noResultView");
      paramString = null;
    }
    paramString.setVisibility(8);
    localObject = this.ATx;
    paramString = (String)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramString = null;
    }
    paramString.setVisibility(8);
    localObject = this.mkw;
    paramString = (String)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramString = null;
    }
    localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(342469);
  }
  
  private final boolean eOw()
  {
    AppMethodBeat.i(342454);
    Object localObject2 = this.Bny;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("searchView");
      localObject1 = null;
    }
    localObject1 = ((FTSSearchView)localObject1).getFtsEditText().getTotalQuery();
    if (localObject1 == null) {
      localObject1 = "";
    }
    while (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(342454);
      return true;
      localObject2 = n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    awg((String)localObject1);
    localObject2 = this.BnB;
    if (localObject2 != null) {
      ((j)localObject2).azd((String)localObject1);
    }
    AppMethodBeat.o(342454);
    return false;
  }
  
  private final int ePl()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342490);
    RecyclerView localRecyclerView = this.mkw;
    Object localObject1 = localRecyclerView;
    if (localRecyclerView == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      localObject1 = null;
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null) {}
    for (localObject1 = localObject2; localObject1 == null; localObject1 = Integer.valueOf(((RecyclerView.a)localObject1).getItemCount()))
    {
      i = this.FvB.size();
      AppMethodBeat.o(342490);
      return i;
    }
    int i = ((Integer)localObject1).intValue();
    AppMethodBeat.o(342490);
    return i;
  }
  
  private final void tZ(boolean paramBoolean)
  {
    AppMethodBeat.i(342478);
    if (!Util.isNullOrNil(this.hOG)) {
      if (((Map)this.FvE).isEmpty()) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aa localaa = aa.Fsi;
        aa.b(this.hOG, this.query, this.FvE, 2);
        if (paramBoolean) {
          this.FvE.clear();
        }
      }
      AppMethodBeat.o(342478);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean aWU()
  {
    AppMethodBeat.i(342716);
    hideVKB();
    if (eOw())
    {
      AppMethodBeat.o(342716);
      return true;
    }
    f.Ozc.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(342716);
    return false;
  }
  
  public final void eeU() {}
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(342816);
    super.finish();
    int i = e.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(342816);
  }
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(342735);
    if (paramBoolean)
    {
      aa localaa = aa.Fsi;
      aa.eMZ();
    }
    AppMethodBeat.o(342735);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_topic_search_ui;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(342709);
    hideVKB();
    finish();
    AppMethodBeat.o(342709);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(342703);
    hideVKB();
    finish();
    AppMethodBeat.o(342703);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(342744);
    FTSSearchView localFTSSearchView = this.Bny;
    paramView = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().aWT();
    showVKB();
    AppMethodBeat.o(342744);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(342686);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(e.b.transparent));
    }
    this.Bny = new FTSSearchView((Context)this);
    paramBundle = this.Bny;
    Object localObject1;
    Object localObject2;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
      paramBundle.setSearchViewListener((FTSSearchView.b)this);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setHint(getString(e.h.app_search));
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.c)this);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setCanDeleteTag(false);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().jBL();
      localObject2 = getSupportActionBar();
      kotlin.g.b.s.checkNotNull(localObject2);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      ((ActionBar)localObject2).setCustomView((View)paramBundle);
      this.requestType = getIntent().getIntExtra("request_type", 4);
      this.FvC = getIntent().getBooleanExtra("need_history", false);
      paramBundle = UUID.randomUUID().toString();
      kotlin.g.b.s.s(paramBundle, "randomUUID().toString()");
      this.hOG = paramBundle;
      this.query = "";
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().aWT();
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().aWS();
      if (!this.FvC) {
        break label987;
      }
      getContext().findViewById(e.e.history_lv).setVisibility(0);
      this.BnB = new j((MMActivity)this, (kotlin.g.a.b)new e(this));
      label396:
      Log.i(TAG, "initData");
      paramBundle = getContext().findViewById(e.e.root);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.root)");
      this.rootView = paramBundle;
      paramBundle = getContext().findViewById(e.e.main_rv);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.main_rv)");
      this.FvF = ((CoordinatorLayout)paramBundle);
      paramBundle = getContext().findViewById(e.e.rl_layout);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.ATx = ((RefreshLoadMoreLayout)paramBundle);
      localObject1 = this.ATx;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramBundle = null;
      }
      this.mkw = paramBundle.getRecyclerView();
      paramBundle = getContext().findViewById(e.e.no_result_tv);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.no_result_tv)");
      this.BnA = ((TextView)paramBundle);
      paramBundle = getContext().findViewById(e.e.loading_layout);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.loading_layout)");
      this.njN = paramBundle;
      localObject1 = new FinderLinearLayoutManager((Context)this);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1005;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label585:
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1008;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label610:
      paramBundle.setAdapter((RecyclerView.a)new c((byte)0));
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setHasFixedSize(true);
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setItemViewCacheSize(5);
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setOnTouchListener(new FinderTopicSearchUI..ExternalSyntheticLambda0(this));
      localObject1 = this.ATx;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramBundle = null;
      }
      paramBundle.setEnablePullDownHeader(false);
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label1011;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
      label746:
      localObject1 = af.mU((Context)getContext()).inflate(e.f.load_more_footer, null);
      kotlin.g.b.s.s(localObject1, "getInflater(context).inf…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label1014;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
    }
    label987:
    label1005:
    label1008:
    label1011:
    label1014:
    for (;;)
    {
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new d(this));
      localObject2 = this.query;
      if (localObject2 != null)
      {
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getFtsEditText().V((String)localObject2, null);
      }
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.bZE.notifyChanged();
      }
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      localObject1 = c.a(this.pyl, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(342686);
      return;
      break;
      getContext().findViewById(e.e.history_lv).setVisibility(8);
      break label396;
      break label585;
      break label610;
      break label746;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(342826);
    j localj = this.BnB;
    if (localj != null) {
      localj.onDestroy();
    }
    tZ(true);
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    super.onDestroy();
    AppMethodBeat.o(342826);
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    paramList = null;
    AppMethodBeat.i(342726);
    if (paramString1 == null)
    {
      paramString1 = "";
      if (!Util.isNullOrNil(paramString1)) {
        break label148;
      }
      paramd = this.njN;
      paramString2 = paramd;
      if (paramd == null)
      {
        kotlin.g.b.s.bIx("loadingView");
        paramString2 = null;
      }
      paramString2.setVisibility(8);
      paramd = this.BnA;
      paramString2 = paramd;
      if (paramd == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramString2 = null;
      }
      paramString2.setVisibility(8);
      paramString2 = this.ATx;
      if (paramString2 != null) {
        break label145;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramString2 = paramList;
      label95:
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = this.BnB;
      if (paramString2 != null) {
        paramString2.aAg(paramString1);
      }
      AppMethodBeat.o(342726);
      return;
      paramString2 = n.bq((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      paramString1 = "";
      break;
      label145:
      break label95;
      label148:
      eOw();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(342793);
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    int j = ePl();
    int i = ePl();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      f.Ozc.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.BnD;
      if (paramString == null) {}
      for (paramString = null; paramString == null; paramString = paramString.ADk)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(342793);
        throw paramString;
      }
      paramp = paramString.aacw;
      kotlin.g.b.s.s(paramp, "response.topicInfoList");
      Object localObject = (Iterable)paramp;
      paramp = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bxx localbxx = (bxx)((Iterator)localObject).next();
        paramp.add(Boolean.valueOf(this.FvB.add(localbxx)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.aacy;
      this.BgS = paramString.BgS;
      paramInt1 = ePl();
      Log.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.FvB.size());
      paramp = this.ATx;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = null;
      }
      paramString.aFW(0);
      if (paramInt1 != 0) {
        break label455;
      }
      paramp = this.njN;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("loadingView");
        paramString = null;
      }
      paramString.setVisibility(8);
      paramp = this.BnA;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramString = null;
      }
      paramString.setVisibility(0);
      paramp = this.ATx;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = null;
      }
      paramString.setVisibility(8);
    }
    for (;;)
    {
      if (j != 0) {
        break label607;
      }
      paramp = this.mkw;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramString = null;
      }
      paramString = paramString.getAdapter();
      if (paramString == null) {
        break label654;
      }
      paramString.bZE.notifyChanged();
      AppMethodBeat.o(342793);
      return;
      f.Ozc.idkeyStat(1265L, 11L, 1L, false);
      paramInt1 = i;
      break;
      label455:
      paramp = this.njN;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("loadingView");
        paramString = null;
      }
      paramString.setVisibility(8);
      paramp = this.BnA;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramString = null;
      }
      paramString.setVisibility(8);
      paramp = this.ATx;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = null;
      }
      paramString.setVisibility(0);
      paramp = this.FvF;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("mainContainer");
        paramString = null;
      }
      paramString.setVisibility(0);
      paramp = this.rootView;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("rootView");
        paramString = null;
      }
      paramString.setBackground(getContext().getResources().getDrawable(e.b.BG_0));
    }
    label607:
    if (j < paramInt1)
    {
      paramp = this.mkw;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramString = null;
      }
      paramString = paramString.getAdapter();
      if (paramString != null) {
        paramString.bA(j, paramInt1 - j);
      }
    }
    label654:
    AppMethodBeat.o(342793);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public b()
    {
      super();
      AppMethodBeat.i(342586);
      this$1 = localObject.findViewById(e.e.title_tv);
      kotlin.g.b.s.s(FinderTopicSearchUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderTopicSearchUI.this);
      AppMethodBeat.o(342586);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$TopicSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;I)V", "existFollowTopic", "", "getExistFollowTopic", "()Z", "setExistFollowTopic", "(Z)V", "getRequestType", "()I", "unFollowTopicIndex", "getUnFollowTopicIndex", "setUnFollowTopicIndex", "(I)V", "bindData", "", "holder", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private boolean Fyv;
    private int Fyw;
    private final int requestType;
    
    private c()
    {
      AppMethodBeat.i(342531);
      this.requestType = 4;
      AppMethodBeat.o(342531);
    }
    
    private final void j(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(342553);
      if ((paramv instanceof FinderTopicSearchUI.b))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderTopicSearchUI.b)paramv).titleTv.setText((CharSequence)this.Fyu.getString(e.h.finder_contact_search_follow_topic_header));
          AppMethodBeat.o(342553);
          return;
        }
        ((FinderTopicSearchUI.b)paramv).titleTv.setText((CharSequence)this.Fyu.getString(e.h.finder_contact_search_un_follow_topic_header));
        AppMethodBeat.o(342553);
        return;
      }
      Object localObject1;
      FinderTopicSearchUI localFinderTopicSearchUI;
      Object localObject2;
      if ((this.requestType == 4) && (this.Fyv) && (this.Fyw != FinderTopicSearchUI.j(this.Fyu).size())) {
        if (paramInt < this.Fyw + 1)
        {
          localObject1 = (bxx)FinderTopicSearchUI.j(this.Fyu).get(paramInt - 1);
          kotlin.g.b.s.s(localObject1, "if (requestType == Const…sition]\n                }");
          localFinderTopicSearchUI = this.Fyu;
          localObject2 = ((bxx)localObject1).hLt;
          if (localObject2 != null) {
            break label309;
          }
          localObject2 = "";
        }
      }
      for (;;)
      {
        FinderTopicSearchUI.a(localFinderTopicSearchUI, (String)localObject2, paramInt);
        localObject1 = ((bxx)localObject1).hLt;
        if (localObject1 != null)
        {
          ((TextView)paramv.caK.findViewById(e.e.follow_topic_news_title)).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramv.caK.getContext(), (CharSequence)((bxv)localObject1).topic));
          ((TextView)paramv.caK.findViewById(e.e.follow_topic_news_count)).setText((CharSequence)paramv.caK.getContext().getString(e.h.finder_news_count_num, new Object[] { r.ip(2, ((bxv)localObject1).feedCount) }));
        }
        AppMethodBeat.o(342553);
        return;
        localObject1 = (bxx)FinderTopicSearchUI.j(this.Fyu).get(paramInt - 2);
        break;
        localObject1 = (bxx)FinderTopicSearchUI.j(this.Fyu).get(paramInt);
        break;
        label309:
        String str = ((bxv)localObject2).topic;
        localObject2 = str;
        if (str == null) {
          localObject2 = "";
        }
      }
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(342592);
      kotlin.g.b.s.u(paramv, "holder");
      kotlin.g.b.s.u(paramList, "payloads");
      j(paramv, paramInt);
      AppMethodBeat.o(342592);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(342564);
      kotlin.g.b.s.u(paramViewGroup, "parent");
      if (paramInt == 3)
      {
        localObject = this.Fyu.getContext();
        kotlin.g.b.s.checkNotNull(localObject);
        paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(e.f.finder_follow_topic_item, paramViewGroup, false);
        kotlin.g.b.s.s(paramViewGroup, "contactLayout");
        paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
        AppMethodBeat.o(342564);
        return paramViewGroup;
      }
      Object localObject = this.Fyu;
      AppCompatActivity localAppCompatActivity = this.Fyu.getContext();
      kotlin.g.b.s.checkNotNull(localAppCompatActivity);
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(e.f.finder_post_at_header_item, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new FinderTopicSearchUI.b((FinderTopicSearchUI)localObject, paramViewGroup);
      AppMethodBeat.o(342564);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(342582);
      kotlin.g.b.s.u(paramv, "holder");
      j(paramv, paramInt);
      AppMethodBeat.o(342582);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(342571);
      if ((this.requestType == 3) && (FinderTopicSearchUI.j(this.Fyu).size() != 0))
      {
        this.Fyw = 0;
        this.Fyv = false;
        Iterator localIterator = FinderTopicSearchUI.j(this.Fyu).iterator();
        while (localIterator.hasNext())
        {
          bxv localbxv = ((bxx)localIterator.next()).hLt;
          boolean bool;
          if (localbxv == null)
          {
            bool = false;
            this.Fyv = bool;
            if (this.Fyv) {
              this.Fyw += 1;
            }
          }
          else
          {
            if (localbxv.followFlag > 0) {}
            for (bool = true;; bool = false) {
              break;
            }
          }
        }
        if (this.Fyv)
        {
          if (this.Fyw == FinderTopicSearchUI.j(this.Fyu).size())
          {
            i = FinderTopicSearchUI.j(this.Fyu).size();
            AppMethodBeat.o(342571);
            return i;
          }
          i = FinderTopicSearchUI.j(this.Fyu).size();
          AppMethodBeat.o(342571);
          return i + 2;
        }
      }
      int i = FinderTopicSearchUI.j(this.Fyu).size();
      AppMethodBeat.o(342571);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(342576);
      if ((this.requestType == 4) && (this.Fyv))
      {
        if (this.Fyw == FinderTopicSearchUI.j(this.Fyu).size())
        {
          AppMethodBeat.o(342576);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(342576);
          return 1;
        }
        if (paramInt == this.Fyw + 1)
        {
          AppMethodBeat.o(342576);
          return 2;
        }
      }
      AppMethodBeat.o(342576);
      return 3;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RefreshLoadMoreLayout.b
  {
    d(FinderTopicSearchUI paramFinderTopicSearchUI) {}
    
    public final void qI(int paramInt)
    {
      RefreshLoadMoreLayout localRefreshLoadMoreLayout2 = null;
      RefreshLoadMoreLayout localRefreshLoadMoreLayout1 = null;
      AppMethodBeat.i(342566);
      Object localObject = FinderContactSearchIncludeFollowUI.FvA;
      Log.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderTopicSearchUI.b(this.Fyu);
      if (localObject != null)
      {
        FinderTopicSearchUI localFinderTopicSearchUI = this.Fyu;
        if (FinderTopicSearchUI.c(localFinderTopicSearchUI) == 1)
        {
          FinderTopicSearchUI.a(localFinderTopicSearchUI, new dk((String)localObject, FinderTopicSearchUI.d(localFinderTopicSearchUI), FinderTopicSearchUI.e(localFinderTopicSearchUI), FinderTopicSearchUI.f(localFinderTopicSearchUI), FinderTopicSearchUI.g(localFinderTopicSearchUI), null, null, null, 480));
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)FinderTopicSearchUI.h(localFinderTopicSearchUI), 0);
          com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)localFinderTopicSearchUI);
          localRefreshLoadMoreLayout2 = FinderTopicSearchUI.i(localFinderTopicSearchUI);
          localObject = localRefreshLoadMoreLayout2;
          if (localRefreshLoadMoreLayout2 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            localObject = null;
          }
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject != null)
          {
            localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
            if (localObject != null) {
              ((TextView)localObject).setText(e.h.finder_load_more_footer_tip);
            }
          }
          localRefreshLoadMoreLayout2 = FinderTopicSearchUI.i(localFinderTopicSearchUI);
          localObject = localRefreshLoadMoreLayout2;
          if (localRefreshLoadMoreLayout2 == null)
          {
            kotlin.g.b.s.bIx("rlLayout");
            localObject = null;
          }
          localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
          if (localObject == null)
          {
            localObject = null;
            if (localObject != null) {
              ((TextView)localObject).setVisibility(0);
            }
            localRefreshLoadMoreLayout2 = FinderTopicSearchUI.i(localFinderTopicSearchUI);
            localObject = localRefreshLoadMoreLayout2;
            if (localRefreshLoadMoreLayout2 == null)
            {
              kotlin.g.b.s.bIx("rlLayout");
              localObject = null;
            }
            localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
            if (localObject != null) {
              break label276;
            }
          }
          label276:
          for (localObject = localRefreshLoadMoreLayout1;; localObject = ((View)localObject).findViewById(e.e.load_more_footer_end_layout))
          {
            if (localObject == null) {
              break label417;
            }
            ((View)localObject).setVisibility(8);
            AppMethodBeat.o(342566);
            return;
            localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
            break;
          }
        }
        localRefreshLoadMoreLayout1 = FinderTopicSearchUI.i(localFinderTopicSearchUI);
        localObject = localRefreshLoadMoreLayout1;
        if (localRefreshLoadMoreLayout1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(e.h.finder_load_more_no_result_tip);
          }
        }
        localRefreshLoadMoreLayout1 = FinderTopicSearchUI.i(localFinderTopicSearchUI);
        localObject = localRefreshLoadMoreLayout1;
        if (localRefreshLoadMoreLayout1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject != null) {
          break label423;
        }
        localObject = null;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localRefreshLoadMoreLayout1 = FinderTopicSearchUI.i(localFinderTopicSearchUI);
        localObject = localRefreshLoadMoreLayout1;
        if (localRefreshLoadMoreLayout1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject != null) {
          break label437;
        }
      }
      label417:
      label423:
      label437:
      for (localObject = localRefreshLoadMoreLayout2;; localObject = ((View)localObject).findViewById(e.e.load_more_footer_end_layout))
      {
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        AppMethodBeat.o(342566);
        return;
        localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    e(FinderTopicSearchUI paramFinderTopicSearchUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderTopicSearchUI
 * JD-Core Version:    0.7.0.1
 */