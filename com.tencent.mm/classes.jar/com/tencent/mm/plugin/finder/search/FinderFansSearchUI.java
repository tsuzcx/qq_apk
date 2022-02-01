package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.tencent.mm.ah.a.l;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.cgi.ca;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bpp;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderFansSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModBlackList;", "()V", "adapter", "Lcom/tencent/mm/plugin/finder/search/FinderFansSearchUI$FansSearchAdapter;", "continueFlag", "", "fansList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderFansContact;", "Lkotlin/collections/ArrayList;", "finderBottomSheet", "Lcom/tencent/mm/plugin/finder/view/FinderBottomSheet;", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "netSceneFinderFansSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderFansSearch;", "noResultView", "Landroid/widget/TextView;", "query", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestId", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchSessionId", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "enableActivityAnimation", "", "finish", "", "getCommentScene", "getFansListSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateBeforeSetContentView", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearch", "isAccountEmpty", "startSearch", "ContactViewHolder", "FansSearchAdapter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFansSearchUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, ck<bpp>, FTSEditTextView.c, FTSSearchView.b
{
  private RefreshLoadMoreLayout ATx;
  private com.tencent.mm.bx.b BgS;
  private TextView BnA;
  private FTSSearchView Bny;
  private String Fsa;
  private CoordinatorLayout FvF;
  private ArrayList<axc> FvN;
  private b FvO;
  private ca FvP;
  private com.tencent.mm.plugin.finder.view.d FvQ;
  private int continueFlag;
  private String hOG;
  private RecyclerView mkw;
  private View njN;
  private String query;
  private View rootView;
  
  public FinderFansSearchUI()
  {
    AppMethodBeat.i(342355);
    this.query = "";
    this.FvN = new ArrayList();
    this.hOG = "";
    this.Fsa = "";
    AppMethodBeat.o(342355);
  }
  
  private static final boolean a(FinderFansSearchUI paramFinderFansSearchUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342388);
    kotlin.g.b.s.u(paramFinderFansSearchUI, "this$0");
    paramMotionEvent = paramFinderFansSearchUI.Bny;
    paramView = paramMotionEvent;
    if (paramMotionEvent == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().dzv.clearFocus();
    paramFinderFansSearchUI.hideVKB();
    AppMethodBeat.o(342388);
    return false;
  }
  
  private final void awg(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(342374);
    this.query = paramString;
    this.continueFlag = 0;
    this.BgS = null;
    this.FvN.clear();
    Object localObject2 = UUID.randomUUID().toString();
    kotlin.g.b.s.s(localObject2, "randomUUID().toString()");
    this.hOG = ((String)localObject2);
    localObject2 = this.FvP;
    if (localObject2 != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject2);
    }
    this.FvP = new ca(paramString, this.BgS, (byte)0);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.FvP, 0);
    com.tencent.mm.kernel.h.aZW().a(6665, (com.tencent.mm.am.h)this);
    localObject2 = this.njN;
    paramString = (String)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("loadingView");
      paramString = null;
    }
    paramString.setVisibility(0);
    localObject2 = this.BnA;
    paramString = (String)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("noResultView");
      paramString = null;
    }
    paramString.setVisibility(8);
    localObject2 = this.ATx;
    paramString = (String)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramString = null;
    }
    paramString.setVisibility(8);
    localObject2 = this.mkw;
    paramString = (String)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramString = null;
    }
    localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/search/FinderFansSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/search/FinderFansSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString = this.rootView;
    if (paramString == null)
    {
      kotlin.g.b.s.bIx("rootView");
      paramString = localObject1;
    }
    for (;;)
    {
      paramString.setBackground(getContext().getResources().getDrawable(e.b.BG_0));
      AppMethodBeat.o(342374);
      return;
    }
  }
  
  private final boolean eOw()
  {
    AppMethodBeat.i(342362);
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
      AppMethodBeat.o(342362);
      return true;
      localObject2 = n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    awg((String)localObject1);
    AppMethodBeat.o(342362);
    return false;
  }
  
  private final int eOy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342379);
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
      i = this.FvN.size();
      AppMethodBeat.o(342379);
      return i;
    }
    int i = ((Integer)localObject1).intValue();
    AppMethodBeat.o(342379);
    return i;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean aWU()
  {
    AppMethodBeat.i(342510);
    hideVKB();
    if (eOw())
    {
      AppMethodBeat.o(342510);
      return true;
    }
    AppMethodBeat.o(342510);
    return false;
  }
  
  public final void eeU() {}
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(342520);
    super.finish();
    int i = e.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(342520);
  }
  
  public final void fq(boolean paramBoolean) {}
  
  public final int getCommentScene()
  {
    return 75;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_fans_search;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(342483);
    hideVKB();
    finish();
    AppMethodBeat.o(342483);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(342488);
    hideVKB();
    finish();
    AppMethodBeat.o(342488);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(342505);
    FTSSearchView localFTSSearchView = this.Bny;
    paramView = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().aWT();
    showVKB();
    AppMethodBeat.o(342505);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(342466);
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
      paramBundle.getFtsEditText().setHint(getString(e.h.app_search_your_fans));
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
      paramBundle = UUID.randomUUID().toString();
      kotlin.g.b.s.s(paramBundle, "randomUUID().toString()");
      this.Fsa = paramBundle;
      this.FvO = new b();
      paramBundle = findViewById(e.e.root);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.root)");
      this.rootView = paramBundle;
      paramBundle = findViewById(e.e.main_rv);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.main_rv)");
      this.FvF = ((CoordinatorLayout)paramBundle);
      paramBundle = findViewById(e.e.rl_layout);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.rl_layout)");
      this.ATx = ((RefreshLoadMoreLayout)paramBundle);
      localObject1 = this.ATx;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramBundle = null;
      }
      this.mkw = paramBundle.getRecyclerView();
      paramBundle = findViewById(e.e.no_result_tv);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.no_result_tv)");
      this.BnA = ((TextView)paramBundle);
      paramBundle = findViewById(e.e.loading_layout);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.loading_layout)");
      this.njN = paramBundle;
      localObject1 = new FinderLinearLayoutManager((Context)this);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label896;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label487:
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label899;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label512:
      localObject2 = this.FvO;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
      }
      paramBundle.setAdapter((RecyclerView.a)localObject1);
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
      paramBundle.setOnTouchListener(new FinderFansSearchUI..ExternalSyntheticLambda0(this));
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
        break label902;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
      label659:
      localObject1 = af.mU((Context)getContext()).inflate(e.f.load_more_footer, null);
      kotlin.g.b.s.s(localObject1, "getInflater(context).inf…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label905;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
    }
    label896:
    label899:
    label902:
    label905:
    for (;;)
    {
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new c(this));
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
      localObject1 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/search/FinderFansSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/finder/search/FinderFansSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(342466);
      return;
      break;
      break label487;
      break label512;
      break label659;
    }
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(342452);
    super.onCreateBeforeSetContentView();
    setTheme(a.l.MMTheme_Holo_Transparent);
    AppMethodBeat.o(342452);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(342514);
    com.tencent.mm.kernel.h.aZW().b(6665, (com.tencent.mm.am.h)this);
    super.onDestroy();
    AppMethodBeat.o(342514);
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    paramString2 = null;
    AppMethodBeat.i(342499);
    if (paramString1 == null)
    {
      paramString1 = "";
      if (!Util.isNullOrNil(paramString1)) {
        break label128;
      }
      paramList = this.njN;
      paramString1 = paramList;
      if (paramList == null)
      {
        kotlin.g.b.s.bIx("loadingView");
        paramString1 = null;
      }
      paramString1.setVisibility(8);
      paramList = this.BnA;
      paramString1 = paramList;
      if (paramList == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramString1 = null;
      }
      paramString1.setVisibility(8);
      paramString1 = this.ATx;
      if (paramString1 != null) {
        break label125;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramString1 = paramString2;
    }
    label125:
    for (;;)
    {
      paramString1.setVisibility(8);
      AppMethodBeat.o(342499);
      return;
      paramList = n.bq((CharSequence)paramString1).toString();
      paramString1 = paramList;
      if (paramList != null) {
        break;
      }
      paramString1 = "";
      break;
    }
    label128:
    eOw();
    AppMethodBeat.o(342499);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(342529);
    com.tencent.mm.kernel.h.aZW().b(6665, (com.tencent.mm.am.h)this);
    int j = eOy();
    int i = j;
    if (paramInt1 == 0)
    {
      i = j;
      if (paramInt2 == 0)
      {
        paramString = this.FvP;
        if (paramString == null) {}
        for (paramString = null; paramString == null; paramString = paramString.ABZ)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchFansResponse");
          AppMethodBeat.o(342529);
          throw paramString;
        }
        paramp = paramString.ZJv;
        kotlin.g.b.s.s(paramp, "response.fansContactList");
        Object localObject1 = (Iterable)paramp;
        paramp = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (axc)((Iterator)localObject1).next();
          paramp.add(Boolean.valueOf(this.FvN.add(localObject2)));
        }
        this.continueFlag = paramString.continueFlag;
        this.BgS = paramString.BgS;
        i = eOy();
        Log.i("Finder.FinderFansSearchUI", "onSceneEnd " + paramString.continueFlag + ' ' + this.FvN.size());
        paramp = this.query;
        if (!paramString.ZJv.isEmpty()) {
          break label479;
        }
        paramInt1 = 1;
        paramString = z.FrZ;
        localObject1 = this.Fsa;
        Object localObject2 = this.hOG;
        paramString = as.GSQ;
        paramString = getContext();
        kotlin.g.b.s.s(paramString, "context");
        paramString = as.a.hu((Context)paramString);
        if (paramString != null) {
          break label484;
        }
        paramString = null;
        label304:
        z.a((String)localObject1, (String)localObject2, paramp, 2, 1, 2, paramInt1, 0, paramString);
      }
    }
    paramp = this.ATx;
    paramString = paramp;
    if (paramp == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramString = null;
    }
    paramString.aFW(0);
    if (i == 0)
    {
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
      paramp = this.mkw;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramString = null;
      }
      paramString = paramString.getAdapter();
      if (paramString != null) {
        paramString.bZE.notifyChanged();
      }
      AppMethodBeat.o(342529);
      return;
      label479:
      paramInt1 = 2;
      break;
      label484:
      paramString = paramString.fou();
      break label304;
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
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderFansSearchUI$ContactViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderFansSearchUI;Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "beforeTip", "Landroid/widget/TextView;", "getBeforeTip", "()Landroid/widget/TextView;", "clickArea", "Landroid/widget/RelativeLayout;", "getClickArea", "()Landroid/widget/RelativeLayout;", "nicknameTv", "getNicknameTv", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class a
    extends RecyclerView.v
  {
    final TextView FvR;
    final RelativeLayout FvS;
    final ImageView lKK;
    final TextView nicknameTv;
    
    public a()
    {
      super();
      AppMethodBeat.i(342345);
      this$1 = localObject.findViewById(e.e.avatar_iv);
      kotlin.g.b.s.s(FinderFansSearchUI.this, "itemView.findViewById(R.id.avatar_iv)");
      this.lKK = ((ImageView)FinderFansSearchUI.this);
      this$1 = localObject.findViewById(e.e.nickname_tv);
      kotlin.g.b.s.s(FinderFansSearchUI.this, "itemView.findViewById(R.id.nickname_tv)");
      this.nicknameTv = ((TextView)FinderFansSearchUI.this);
      this$1 = localObject.findViewById(e.e.before_split_tv);
      kotlin.g.b.s.s(FinderFansSearchUI.this, "itemView.findViewById(R.id.before_split_tv)");
      this.FvR = ((TextView)FinderFansSearchUI.this);
      this$1 = localObject.findViewById(e.e.fans_main_layout);
      kotlin.g.b.s.s(FinderFansSearchUI.this, "itemView.findViewById(R.id.fans_main_layout)");
      this.FvS = ((RelativeLayout)FinderFansSearchUI.this);
      AppMethodBeat.o(342345);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderFansSearchUI$FansSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderFansSearchUI;)V", "getItemCount", "", "getShowBefore", "makeHighlightString", "", "origin", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    public b()
    {
      AppMethodBeat.i(342346);
      AppMethodBeat.o(342346);
    }
    
    private static final void a(FinderFansSearchUI paramFinderFansSearchUI, axc paramaxc, View paramView)
    {
      AppMethodBeat.i(342361);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderFansSearchUI);
      localb.cH(paramaxc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderFansSearchUI$FansSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramFinderFansSearchUI, "this$0");
      kotlin.g.b.s.u(paramaxc, "$fans");
      FinderFansSearchUI.a(paramFinderFansSearchUI, com.tencent.mm.plugin.finder.ui.b.a(paramaxc, (Context)paramFinderFansSearchUI, (kotlin.g.a.b)new a(paramFinderFansSearchUI)));
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderFansSearchUI$FansSearchAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342361);
    }
    
    private final int eOz()
    {
      AppMethodBeat.i(342352);
      Object localObject = (List)FinderFansSearchUI.f(this.FvT);
      localObject = ((List)localObject).listIterator(((List)localObject).size());
      while (((ListIterator)localObject).hasPrevious())
      {
        if (((axc)((ListIterator)localObject).previous()).eQp == 1) {}
        for (int i = 1; i != 0; i = 0)
        {
          i = ((ListIterator)localObject).nextIndex();
          AppMethodBeat.o(342352);
          return i;
        }
      }
      AppMethodBeat.o(342352);
      return -1;
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(342380);
      kotlin.g.b.s.u(paramViewGroup, "parent");
      Object localObject = this.FvT.getContext();
      kotlin.g.b.s.checkNotNull(localObject);
      paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(e.f.finder_fans_list_item, paramViewGroup, false);
      localObject = this.FvT;
      kotlin.g.b.s.s(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.v)new FinderFansSearchUI.a((FinderFansSearchUI)localObject, paramViewGroup);
      AppMethodBeat.o(342380);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(342398);
      kotlin.g.b.s.u(paramv, "holder");
      if (!(paramv instanceof FinderFansSearchUI.a))
      {
        AppMethodBeat.o(342398);
        return;
      }
      Object localObject1 = FinderFansSearchUI.f(this.FvT).get(paramInt);
      kotlin.g.b.s.s(localObject1, "fansList[position]");
      axc localaxc = (axc)localObject1;
      localObject1 = localaxc.contact;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if (localObject1 == null)
      {
        localObject1 = "";
        localObject1 = Util.nullAsNil((String)localObject1);
        if (localaxc.displayFlag != 0) {
          break label259;
        }
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject2 = com.tencent.mm.plugin.finder.loader.p.eCq();
        localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
        localObject3 = ((FinderFansSearchUI.a)paramv).lKK;
        localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExO));
        label121:
        localObject3 = ((FinderFansSearchUI.a)paramv).nicknameTv;
        localObject4 = MMApplicationContext.getContext();
        localObject1 = localaxc.contact;
        if (localObject1 != null) {
          break label309;
        }
        localObject1 = "";
        label148:
        if (!Util.isNullOrNil((String)localObject1)) {
          break label329;
        }
        localObject1 = (CharSequence)"";
        label161:
        ((TextView)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.d((Context)localObject4, (CharSequence)localObject1, ((FinderFansSearchUI.a)paramv).nicknameTv.getTextSize()));
        if ((eOz() != paramInt) || (paramInt == getItemCount() - 1)) {
          break label362;
        }
        ((FinderFansSearchUI.a)paramv).FvR.setVisibility(0);
      }
      for (;;)
      {
        if (!localaxc.hHq) {
          break label377;
        }
        ((FinderFansSearchUI.a)paramv).FvS.setOnClickListener(null);
        AppMethodBeat.o(342398);
        return;
        localObject2 = ((FinderContact)localObject1).headUrl;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = "";
        break;
        label259:
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject1 = new com.tencent.mm.plugin.finder.loader.b((String)localObject1);
        localObject3 = ((FinderFansSearchUI.a)paramv).lKK;
        localObject4 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject2).a(localObject1, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        break label121;
        label309:
        localObject2 = ((FinderContact)localObject1).nickname;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label148;
        }
        localObject1 = "";
        break label148;
        label329:
        localObject1 = (CharSequence)Html.fromHtml("<font color=\"#06AD56\">" + (String)localObject1 + "</font>");
        break label161;
        label362:
        ((FinderFansSearchUI.a)paramv).FvR.setVisibility(8);
      }
      label377:
      ((FinderFansSearchUI.a)paramv).FvS.setOnClickListener(new FinderFansSearchUI.b..ExternalSyntheticLambda0(this.FvT, localaxc));
      AppMethodBeat.o(342398);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(342373);
      int i = FinderFansSearchUI.f(this.FvT).size();
      AppMethodBeat.o(342373);
      return i;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "fansId", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<String, ah>
    {
      a(FinderFansSearchUI paramFinderFansSearchUI)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderFansSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RefreshLoadMoreLayout.b
  {
    c(FinderFansSearchUI paramFinderFansSearchUI) {}
    
    public final void qI(int paramInt)
    {
      RefreshLoadMoreLayout localRefreshLoadMoreLayout2 = null;
      RefreshLoadMoreLayout localRefreshLoadMoreLayout1 = null;
      AppMethodBeat.i(342350);
      Log.i("Finder.FinderFansSearchUI", "onLoadMoreBegin");
      Object localObject = FinderFansSearchUI.a(this.FvT);
      if (localObject != null)
      {
        FinderFansSearchUI localFinderFansSearchUI = this.FvT;
        if (FinderFansSearchUI.b(localFinderFansSearchUI) == 1)
        {
          FinderFansSearchUI.a(localFinderFansSearchUI, new ca((String)localObject, FinderFansSearchUI.c(localFinderFansSearchUI), (byte)0));
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)FinderFansSearchUI.d(localFinderFansSearchUI), 0);
          com.tencent.mm.kernel.h.aZW().a(6665, (com.tencent.mm.am.h)localFinderFansSearchUI);
          localRefreshLoadMoreLayout2 = FinderFansSearchUI.e(localFinderFansSearchUI);
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
          localRefreshLoadMoreLayout2 = FinderFansSearchUI.e(localFinderFansSearchUI);
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
            localRefreshLoadMoreLayout2 = FinderFansSearchUI.e(localFinderFansSearchUI);
            localObject = localRefreshLoadMoreLayout2;
            if (localRefreshLoadMoreLayout2 == null)
            {
              kotlin.g.b.s.bIx("rlLayout");
              localObject = null;
            }
            localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
            if (localObject != null) {
              break label251;
            }
          }
          label251:
          for (localObject = localRefreshLoadMoreLayout1;; localObject = ((View)localObject).findViewById(e.e.load_more_footer_end_layout))
          {
            if (localObject == null) {
              break label392;
            }
            ((View)localObject).setVisibility(8);
            AppMethodBeat.o(342350);
            return;
            localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
            break;
          }
        }
        localRefreshLoadMoreLayout1 = FinderFansSearchUI.e(localFinderFansSearchUI);
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
        localRefreshLoadMoreLayout1 = FinderFansSearchUI.e(localFinderFansSearchUI);
        localObject = localRefreshLoadMoreLayout1;
        if (localRefreshLoadMoreLayout1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject != null) {
          break label398;
        }
        localObject = null;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(8);
        }
        localRefreshLoadMoreLayout1 = FinderFansSearchUI.e(localFinderFansSearchUI);
        localObject = localRefreshLoadMoreLayout1;
        if (localRefreshLoadMoreLayout1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject = null;
        }
        localObject = ((RefreshLoadMoreLayout)localObject).getLoadMoreFooter();
        if (localObject != null) {
          break label412;
        }
      }
      label392:
      label398:
      label412:
      for (localObject = localRefreshLoadMoreLayout2;; localObject = ((View)localObject).findViewById(e.e.load_more_footer_end_layout))
      {
        if (localObject != null) {
          ((View)localObject).setVisibility(0);
        }
        AppMethodBeat.o(342350);
        return;
        localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(aux paramaux, FinderFansSearchUI paramFinderFansSearchUI, bpp parambpp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderFansSearchUI
 * JD-Core Version:    0.7.0.1
 */