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
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.protocal.protobuf.cjj;
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
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroid/support/design/widget/CoordinatorLayout;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "topicList", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSearchInfo;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getContactSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "isTopicSearch", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "ContactSearchProfileAdapter", "HeaderViewHolder", "plugin-finder_release"})
public final class FinderContactSearchIncludeFollowUI
  extends MMActivity
  implements com.tencent.mm.ak.i, FTSEditTextView.a, a.b
{
  static final String TAG = "Finder.FinderContactSearchIncludeFollowUI";
  public static final a vtM;
  private HashMap _$_findViewCache;
  private int continueFlag;
  String dPI;
  private View hSw;
  private RecyclerView hak;
  private int jKy;
  private View lJI;
  private int offset;
  String query;
  private int requestType;
  private RefreshLoadMoreLayout tLS;
  private com.tencent.mm.bw.b tVM;
  private ArrayList<bbz> uae;
  private com.tencent.mm.ui.search.a ubO;
  private ArrayList<bdu> vtE;
  private boolean vtF;
  boolean vtG;
  HashMap<String, a> vtH;
  private CoordinatorLayout vtI;
  private TextView vtJ;
  private h vtK;
  private cf vtL;
  
  static
  {
    AppMethodBeat.i(251241);
    vtM = new a((byte)0);
    TAG = "Finder.FinderContactSearchIncludeFollowUI";
    AppMethodBeat.o(251241);
  }
  
  public FinderContactSearchIncludeFollowUI()
  {
    AppMethodBeat.i(251240);
    this.query = "";
    this.uae = new ArrayList();
    this.vtE = new ArrayList();
    this.dPI = "";
    this.vtF = true;
    this.vtH = new HashMap();
    AppMethodBeat.o(251240);
  }
  
  private final void auV(String paramString)
  {
    AppMethodBeat.i(251236);
    ov(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.tVM = null;
    if (this.requestType == 4) {
      this.vtE.clear();
    }
    for (;;)
    {
      Object localObject = UUID.randomUUID().toString();
      p.g(localObject, "UUID.randomUUID().toString()");
      this.dPI = ((String)localObject);
      if (this.vtL != null) {
        g.azz().a((com.tencent.mm.ak.q)this.vtL);
      }
      this.vtL = new cf(paramString, this.offset, this.dPI, this.tVM, this.requestType, null, 96);
      g.azz().b((com.tencent.mm.ak.q)this.vtL);
      g.azz().a(3820, (com.tencent.mm.ak.i)this);
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
      com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
      paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
      paramString = this.lJI;
      if (paramString == null) {
        p.btv("rootView");
      }
      localObject = getContext();
      p.g(localObject, "context");
      paramString.setBackground(((AppCompatActivity)localObject).getResources().getDrawable(2131099648));
      AppMethodBeat.o(251236);
      return;
      this.uae.clear();
    }
  }
  
  private final boolean dpx()
  {
    AppMethodBeat.i(251233);
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
        AppMethodBeat.o(251233);
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
      AppMethodBeat.o(251233);
      return true;
    }
    auV((String)localObject1);
    Object localObject2 = this.vtK;
    if (localObject2 != null) {
      ((h)localObject2).auX((String)localObject1);
    }
    AppMethodBeat.o(251233);
    return false;
  }
  
  private final int dpy()
  {
    AppMethodBeat.i(251238);
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
        AppMethodBeat.o(251238);
        return i;
      }
    }
    int i = this.uae.size();
    AppMethodBeat.o(251238);
    return i;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(251246);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(251246);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251245);
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
    AppMethodBeat.o(251245);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(251229);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(251229);
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
      AppMethodBeat.o(251229);
      return;
      dpx();
    }
    AppMethodBeat.o(251229);
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(251232);
    hideVKB();
    if (dpx())
    {
      AppMethodBeat.o(251232);
      return true;
    }
    e.Cxv.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(251232);
    return false;
  }
  
  public final void dpw() {}
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(251230);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.l locall = com.tencent.mm.plugin.finder.report.l.vfB;
      com.tencent.mm.plugin.finder.report.l.doe();
    }
    AppMethodBeat.o(251230);
  }
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(251235);
    super.finish();
    overridePendingTransition(2130771986, 2130771986);
    AppMethodBeat.o(251235);
  }
  
  public final int getLayoutId()
  {
    return 2131494223;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(251227);
    hideVKB();
    finish();
    AppMethodBeat.o(251227);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(251228);
    hideVKB();
    finish();
    AppMethodBeat.o(251228);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(251231);
    paramView = this.ubO;
    if (paramView == null) {
      p.btv("searchView");
    }
    paramView.getFtsEditText().awD();
    showVKB();
    AppMethodBeat.o(251231);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(251226);
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
    Object localObject1 = this.ubO;
    if (localObject1 == null) {
      p.btv("searchView");
    }
    paramBundle.setCustomView((View)localObject1);
    this.requestType = getIntent().getIntExtra("request_type", 3);
    this.vtG = getIntent().getBooleanExtra("from_at_contact", false);
    this.vtF = getIntent().getBooleanExtra("need_history", false);
    paramBundle = i.vvu;
    if (i.dqa() != null)
    {
      paramBundle = i.vvu;
      Object localObject2 = i.dqa();
      if (localObject2 == null) {
        p.hyc();
      }
      paramBundle = i.vvu;
      i.a(null);
      localObject1 = ((aqw)localObject2).dPI;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.dPI = paramBundle;
      localObject1 = ((aqw)localObject2).query;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.query = paramBundle;
      this.offset = ((aqw)localObject2).offset;
      this.continueFlag = ((aqw)localObject2).continueFlag;
      this.tVM = ((aqw)localObject2).tVM;
      this.jKy = ((aqw)localObject2).LCH;
      paramBundle = ((aqw)localObject2).LCI;
      p.g(paramBundle, "finderFeedObj.contactList");
      localObject1 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bbz)((Iterator)localObject1).next();
        paramBundle.add(Boolean.valueOf(this.uae.add(localObject2)));
      }
    }
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
      if (this.vtG) {
        setResult(0, getIntent());
      }
      Log.i(TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.vtG) });
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
      localObject1 = this.hak;
      if (localObject1 == null) {
        p.btv("recyclerView");
      }
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)new b((byte)0));
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
      localObject1 = aa.jQ((Context)getContext()).inflate(2131495297, null);
      p.g(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.tLS;
      if (paramBundle == null) {
        p.btv("rlLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
      paramBundle = this.query;
      if (paramBundle != null)
      {
        localObject1 = this.ubO;
        if (localObject1 == null) {
          p.btv("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText().O(paramBundle, null);
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
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(this.jKy, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(251226);
      return;
      paramBundle = getContext().findViewById(2131302342);
      p.g(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(251234);
    h localh = this.vtK;
    if (localh != null) {
      localh.onDestroy();
    }
    ov(true);
    g.azz().b(3820, (com.tencent.mm.ak.i)this);
    super.onDestroy();
    AppMethodBeat.o(251234);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(251237);
    g.azz().b(3820, (com.tencent.mm.ak.i)this);
    int j = dpy();
    int i = dpy();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.Cxv.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.vtL;
      if (paramString != null) {}
      for (paramString = paramString.twl; paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(251237);
        throw paramString;
      }
      paramq = paramString.zns;
      p.g(paramq, "response.infoList");
      Object localObject = (Iterable)paramq;
      paramq = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bbz localbbz = (bbz)((Iterator)localObject).next();
        paramq.add(Boolean.valueOf(this.uae.add(localbbz)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.tVM = paramString.tVM;
      paramInt1 = dpy();
      Log.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.uae.size());
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
          AppMethodBeat.o(251237);
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
          continue;
        }
        AppMethodBeat.o(251237);
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
          AppMethodBeat.o(251237);
          return;
        }
      }
    }
    AppMethodBeat.o(251237);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final void ov(boolean paramBoolean)
  {
    AppMethodBeat.i(251239);
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
      AppMethodBeat.o(251239);
      return;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;I)V", "existFollowContact", "", "getExistFollowContact", "()Z", "setExistFollowContact", "(Z)V", "getRequestType", "()I", "unFollowContactIndex", "getUnFollowContactIndex", "setUnFollowContactIndex", "(I)V", "bindData", "", "holder", "position", "bindImage", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    private final int requestType = 3;
    private boolean vtN;
    private int vtO;
    
    private b() {}
    
    private final void i(RecyclerView.v paramv, final int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(251217);
      if ((paramv instanceof FinderContactSearchIncludeFollowUI.c))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderContactSearchIncludeFollowUI.c)paramv).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131759610));
          AppMethodBeat.o(251217);
          return;
        }
        ((FinderContactSearchIncludeFollowUI.c)paramv).titleTv.setText((CharSequence)FinderContactSearchIncludeFollowUI.this.getString(2131759612));
        AppMethodBeat.o(251217);
        return;
      }
      bbz localbbz;
      Object localObject2;
      Object localObject1;
      if ((this.requestType == 3) && (this.vtN) && (this.vtO != FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())) {
        if (paramInt < this.vtO + 1)
        {
          localbbz = (bbz)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 1);
          p.g(localbbz, "if (requestType == Const…sition]\n                }");
          localObject2 = FinderContactSearchIncludeFollowUI.this;
          localObject1 = localbbz.contact;
          if (localObject1 != null)
          {
            localObject1 = ((FinderContact)localObject1).username;
            if (localObject1 != null) {
              break label448;
            }
          }
          localObject1 = "";
        }
      }
      label448:
      for (;;)
      {
        p.h(localObject1, "id");
        if (!((FinderContactSearchIncludeFollowUI)localObject2).vtH.containsKey(localObject1))
        {
          Log.d(FinderContactSearchIncludeFollowUI.TAG, "addExposeItem " + (String)localObject1 + ' ' + paramInt + ' ' + 1);
          a locala = new a();
          locala.setId((String)localObject1);
          locala.position = paramInt;
          locala.type = 1;
          locala.timeStamp = System.currentTimeMillis();
          ((Map)((FinderContactSearchIncludeFollowUI)localObject2).vtH).put(localObject1, locala);
          if (((FinderContactSearchIncludeFollowUI)localObject2).vtH.size() % 30 == 0) {
            ((FinderContactSearchIncludeFollowUI)localObject2).ov(false);
          }
        }
        if (paramv == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
          AppMethodBeat.o(251217);
          throw paramv;
          localbbz = (bbz)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt - 2);
          break;
          localbbz = (bbz)FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).get(paramInt);
          break;
        }
        localObject1 = (c)paramv;
        localObject2 = (View.OnClickListener)new a(this, paramInt);
        if (paramInt != 0) {}
        for (;;)
        {
          c.a((c)localObject1, localbbz, (View.OnClickListener)localObject2, bool, 4);
          paramv = paramv.aus.findViewById(2131301657);
          if (paramv == null) {
            break;
          }
          paramv.setVisibility(8);
          AppMethodBeat.o(251217);
          return;
          bool = false;
        }
        AppMethodBeat.o(251217);
        return;
      }
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(251215);
      p.h(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        localObject = FinderContactSearchIncludeFollowUI.this;
        AppCompatActivity localAppCompatActivity = FinderContactSearchIncludeFollowUI.this.getContext();
        if (localAppCompatActivity == null) {
          p.hyc();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494564, paramViewGroup, false);
        p.g(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderContactSearchIncludeFollowUI.c((FinderContactSearchIncludeFollowUI)localObject, paramViewGroup);
        AppMethodBeat.o(251215);
        return paramViewGroup;
      }
      Object localObject = FinderContactSearchIncludeFollowUI.this.getContext();
      if (localObject == null) {
        p.hyc();
      }
      paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(2131494224, paramViewGroup, false);
      p.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(251215);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(251218);
      p.h(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(251218);
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(251216);
      p.h(paramv, "holder");
      p.h(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(251216);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(251213);
      if ((this.requestType == 3) && (FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size() != 0))
      {
        this.vtO = 0;
        this.vtN = false;
        Iterator localIterator = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).iterator();
        if (localIterator.hasNext())
        {
          bbz localbbz = (bbz)localIterator.next();
          Object localObject = FinderContactSearchIncludeFollowUI.vtM;
          String str = FinderContactSearchIncludeFollowUI.access$getTAG$cp();
          StringBuilder localStringBuilder = new StringBuilder("getItemCount isFollow:");
          localObject = localbbz.contact;
          if (localObject != null)
          {
            localObject = ((FinderContact)localObject).username;
            label104:
            Log.i(str, (String)localObject);
            localObject = com.tencent.mm.plugin.finder.api.c.tsp;
            localObject = localbbz.contact;
            if (localObject == null) {
              break label167;
            }
          }
          label167:
          for (localObject = ((FinderContact)localObject).username;; localObject = null)
          {
            if (!c.a.asJ((String)localObject)) {
              break label172;
            }
            this.vtN = true;
            this.vtO += 1;
            break;
            localObject = null;
            break label104;
          }
        }
        label172:
        if (this.vtN)
        {
          if (this.vtO == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
          {
            i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
            AppMethodBeat.o(251213);
            return i;
          }
          i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
          AppMethodBeat.o(251213);
          return i + 2;
        }
      }
      int i = FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size();
      AppMethodBeat.o(251213);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(251214);
      if ((this.requestType == 3) && (this.vtN))
      {
        if (this.vtO == FinderContactSearchIncludeFollowUI.a(FinderContactSearchIncludeFollowUI.this).size())
        {
          AppMethodBeat.o(251214);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(251214);
          return 1;
        }
        if (paramInt == this.vtO + 1)
        {
          AppMethodBeat.o(251214);
          return 2;
        }
      }
      AppMethodBeat.o(251214);
      return 3;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchIncludeFollowUI.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(251212);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        p.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(251212);
          throw paramView;
        }
        bbz localbbz = (bbz)paramView;
        FinderContactSearchIncludeFollowUI localFinderContactSearchIncludeFollowUI = this.vtQ.vtP;
        int i = paramInt;
        p.h(localbbz, "finderSearchInfo");
        if (localFinderContactSearchIncludeFollowUI.vtG)
        {
          Log.i(FinderContactSearchIncludeFollowUI.TAG, "onContactItemClick select atContact");
          paramView = d.vVg;
          localObject1 = localbbz.contact;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = new FinderContact();
          }
          paramView = d.e(paramView);
          localFinderContactSearchIncludeFollowUI.getIntent().putExtra("at_select_contact", paramView.toByteArray());
          localObject1 = localFinderContactSearchIncludeFollowUI.getIntent();
          paramView = com.tencent.mm.plugin.finder.api.c.tsp;
          paramView = localbbz.contact;
          if (paramView != null)
          {
            paramView = paramView.username;
            ((Intent)localObject1).putExtra("is_follow", c.a.asJ(paramView));
            localFinderContactSearchIncludeFollowUI.setResult(-1, localFinderContactSearchIncludeFollowUI.getIntent());
            localFinderContactSearchIncludeFollowUI.finish();
          }
        }
        label358:
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251212);
          return;
          paramView = null;
          break;
          Object localObject2 = new Intent();
          paramView = localbbz.contact;
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
          paramView = FinderReporterUIC.wzC;
          paramView = localFinderContactSearchIncludeFollowUI.getContext();
          p.g(paramView, "context");
          FinderReporterUIC.a.a((Context)paramView, (Intent)localObject2, 0L, 7, false, 64);
          paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
          paramView = localFinderContactSearchIncludeFollowUI.getContext();
          p.g(paramView, "context");
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)paramView, (Intent)localObject2);
          paramView = com.tencent.mm.plugin.finder.report.l.vfB;
          localObject1 = localFinderContactSearchIncludeFollowUI.dPI;
          localObject2 = localFinderContactSearchIncludeFollowUI.query;
          paramView = localbbz.contact;
          if (paramView == null) {
            break label430;
          }
          paramView = paramView.username;
          com.tencent.mm.plugin.finder.report.l.e((String)localObject1, (String)localObject2, paramView, i);
          paramView = FinderReporterUIC.wzC;
          paramView = localFinderContactSearchIncludeFollowUI.getContext();
          p.g(paramView, "context");
          paramView = FinderReporterUIC.a.fH((Context)paramView);
        } while (paramView == null);
        localObject1 = k.vfA;
        i = paramView.tCE;
        paramView = localbbz.contact;
        if (paramView != null) {}
        for (paramView = paramView.username;; paramView = null)
        {
          k.a(6, 0L, i, 1, paramView);
          break;
          label430:
          paramView = null;
          break label358;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$HeaderViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(251219);
      this$1 = localObject.findViewById(2131309249);
      p.g(FinderContactSearchIncludeFollowUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderContactSearchIncludeFollowUI.this);
      AppMethodBeat.o(251219);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251220);
      FinderContactSearchIncludeFollowUI.b(this.vtP).getFtsEditText().gUA();
      this.vtP.hideVKB();
      AppMethodBeat.o(251220);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(251222);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(251222);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(251224);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(251224);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(251221);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderContactSearchIncludeFollowUI.vtM;
      Log.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderContactSearchIncludeFollowUI.c(this.vtP);
      if (localObject != null)
      {
        if (FinderContactSearchIncludeFollowUI.d(this.vtP) != 1) {
          break label250;
        }
        FinderContactSearchIncludeFollowUI.a(this.vtP, new cf((String)localObject, FinderContactSearchIncludeFollowUI.f(this.vtP), FinderContactSearchIncludeFollowUI.g(this.vtP), FinderContactSearchIncludeFollowUI.h(this.vtP), FinderContactSearchIncludeFollowUI.i(this.vtP), null, 96));
        g.azz().b((com.tencent.mm.ak.q)FinderContactSearchIncludeFollowUI.e(this.vtP));
        g.azz().a(3820, (com.tencent.mm.ak.i)this.vtP);
        localObject = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setText(2131760234);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
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
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(251221);
        return;
        label250:
        localObject = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setText(2131760235);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.vtP).getLoadMoreFooter();
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
      AppMethodBeat.i(251223);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(251223);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
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