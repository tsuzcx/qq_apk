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
import com.tencent.mm.ak.f;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.finder.cgi.ba;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "addExposeItem", "", "id", "position", "type", "getLayoutId", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "ContactSearchProfileAdapter", "FinderFeedSearchReporter", "plugin-finder_release"})
public final class FinderContactSearchUI
  extends MMFinderUI
  implements f, FTSEditTextView.a, a.b
{
  final String TAG;
  private HashMap _$_findViewCache;
  private int continueFlag;
  String dyb;
  private View gZB;
  private RecyclerView gpr;
  private int iNK;
  private int offset;
  String query;
  private final com.tencent.mm.plugin.finder.event.base.c rZl;
  private int requestType;
  private com.tencent.mm.ui.search.a sCP;
  private boolean sCQ;
  boolean sCR;
  private HashMap<String, a> sCS;
  private TextView sCU;
  private g sCV;
  private ba sCW;
  private final c sDc;
  private RefreshLoadMoreLayout scj;
  private com.tencent.mm.bw.b skw;
  private ArrayList<ars> smS;
  
  public FinderContactSearchUI()
  {
    AppMethodBeat.i(166742);
    this.TAG = "Finder.FinderContactSearchUI";
    this.query = "";
    this.smS = new ArrayList();
    this.dyb = "";
    this.sCQ = true;
    this.sCS = new HashMap();
    this.rZl = new com.tencent.mm.plugin.finder.event.base.c();
    this.sDc = new c(this);
    AppMethodBeat.o(166742);
  }
  
  private final void aiR(String paramString)
  {
    AppMethodBeat.i(166738);
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
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166738);
  }
  
  private final void mc(boolean paramBoolean)
  {
    AppMethodBeat.i(166741);
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
      AppMethodBeat.o(166741);
      return;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204001);
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
    AppMethodBeat.o(204001);
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
    paramString2 = this.sCV;
    if (paramString2 != null)
    {
      paramString2.aiT(paramString1);
      AppMethodBeat.o(166733);
      return;
    }
    AppMethodBeat.o(166733);
  }
  
  public final boolean bAu()
  {
    AppMethodBeat.i(166736);
    hideVKB();
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
    if (bu.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(166736);
      return true;
    }
    aiR((String)localObject1);
    Object localObject2 = this.sCV;
    if (localObject2 != null) {
      ((g)localObject2).aiU((String)localObject1);
    }
    e.ywz.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(166736);
    return false;
  }
  
  public final void cGz() {}
  
  public final void dt(String paramString, int paramInt)
  {
    AppMethodBeat.i(166740);
    if ((paramString != null) && (!this.sCS.containsKey(paramString)))
    {
      ae.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt + ' ' + 1);
      a locala = new a();
      locala.setId(paramString);
      locala.position = paramInt;
      locala.type = 1;
      locala.timeStamp = System.currentTimeMillis();
      ((Map)this.sCS).put(paramString, locala);
      if (this.sCS.size() % 30 == 0) {
        mc(false);
      }
    }
    AppMethodBeat.o(166740);
  }
  
  public final int getLayoutId()
  {
    return 2131494019;
  }
  
  public final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(166734);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.j localj = com.tencent.mm.plugin.finder.report.j.syU;
      com.tencent.mm.plugin.finder.report.j.cFv();
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
    paramView = this.sCP;
    if (paramView == null) {
      p.bdF("searchView");
    }
    paramView.getFtsEditText().fOj();
    showVKB();
    AppMethodBeat.o(166735);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166730);
    super.onCreate(paramBundle);
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
    this.requestType = getIntent().getIntExtra("request_type", 2);
    this.sCR = getIntent().getBooleanExtra("from_at_contact", false);
    this.sCQ = getIntent().getBooleanExtra("need_history", true);
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
    if (this.sCQ) {
      this.sCV = new g((MMActivity)this, (d.g.a.b)new f(this));
    }
    if (this.sCR) {
      setResult(0, getIntent());
    }
    ae.i(this.TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.sCR) });
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
    paramBundle.setAdapter((RecyclerView.a)new a());
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
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahE(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
    paramBundle.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
    this.rZl.a((d)new b());
    this.sDc.alive();
    AppMethodBeat.o(166730);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166737);
    this.sDc.dead();
    g localg = this.sCV;
    if (localg != null) {
      localg.onDestroy();
    }
    mc(true);
    this.rZl.onRelease();
    com.tencent.mm.kernel.g.ajj().b(3820, (f)this);
    super.onDestroy();
    AppMethodBeat.o(166737);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(166739);
    com.tencent.mm.kernel.g.ajj().b(3820, (f)this);
    int j = this.smS.size();
    int i = this.smS.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.ywz.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.sCW;
      if (paramString != null) {}
      for (paramString = paramString.rSg; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166739);
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
      paramInt1 = this.smS.size();
      ae.i(this.TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.smS.size());
      paramString = this.scj;
      if (paramString == null) {
        p.bdF("rlLayout");
      }
      paramString.agI(0);
      if (paramInt1 != 0) {
        break label427;
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
          AppMethodBeat.o(166739);
          return;
          e.ywz.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label427:
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
          continue;
        }
        AppMethodBeat.o(166739);
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "bindData", "", "holder", "position", "", "bindImage", "", "getItemCount", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<RecyclerView.w>
  {
    private final void i(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(166724);
      Object localObject = FinderContactSearchUI.a(this.sDd).get(paramInt);
      p.g(localObject, "contactList[position]");
      ars localars = (ars)localObject;
      FinderContactSearchUI localFinderContactSearchUI = this.sDd;
      localObject = localars.contact;
      if (localObject != null) {}
      for (localObject = ((FinderContact)localObject).username;; localObject = null)
      {
        localFinderContactSearchUI.dt((String)localObject, paramInt);
        if (paramw != null) {
          break;
        }
        paramw = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
        AppMethodBeat.o(166724);
        throw paramw;
      }
      paramw = (c)paramw;
      localObject = (View.OnClickListener)new a(this, paramInt);
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramw.a(localars, (View.OnClickListener)localObject, bool);
        AppMethodBeat.o(166724);
        return;
      }
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(166722);
      p.h(paramViewGroup, "parent");
      AppCompatActivity localAppCompatActivity = this.sDd.getContext();
      if (localAppCompatActivity == null) {
        p.gkB();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494018, paramViewGroup, false);
      p.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.w)new c(paramViewGroup);
      AppMethodBeat.o(166722);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      AppMethodBeat.i(166725);
      p.h(paramw, "holder");
      i(paramw, paramInt);
      AppMethodBeat.o(166725);
    }
    
    public final void a(RecyclerView.w paramw, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(166723);
      p.h(paramw, "holder");
      p.h(paramList, "payloads");
      i(paramw, paramInt);
      AppMethodBeat.o(166723);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166721);
      int i = FinderContactSearchUI.a(this.sDd).size();
      AppMethodBeat.o(166721);
      return i;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchUI.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166720);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
        p.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(166720);
          throw paramView;
        }
        ars localars = (ars)paramView;
        FinderContactSearchUI localFinderContactSearchUI = this.sDe.sDd;
        int i = paramInt;
        p.h(localars, "finderSearchInfo");
        if (localFinderContactSearchUI.sCR)
        {
          ae.i(localFinderContactSearchUI.TAG, "onContactItemClick select atContact");
          paramView = com.tencent.mm.plugin.finder.utils.b.sWa;
          localObject1 = localars.contact;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = new FinderContact();
          }
          paramView = com.tencent.mm.plugin.finder.utils.b.e(paramView);
          localFinderContactSearchUI.getIntent().putExtra("at_select_contact", paramView.toByteArray());
          localFinderContactSearchUI.setResult(-1, localFinderContactSearchUI.getIntent());
          localFinderContactSearchUI.finish();
        }
        label319:
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(166720);
          return;
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
          paramView = localFinderContactSearchUI.getContext();
          p.g(paramView, "context");
          FinderReporterUIC.a.a((Context)paramView, (Intent)localObject2, 0L, 7, false, 64);
          paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
          paramView = localFinderContactSearchUI.getContext();
          p.g(paramView, "context");
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)paramView, (Intent)localObject2);
          paramView = com.tencent.mm.plugin.finder.report.j.syU;
          localObject1 = localFinderContactSearchUI.dyb;
          localObject2 = localFinderContactSearchUI.query;
          paramView = localars.contact;
          if (paramView == null) {
            break;
          }
          paramView = paramView.username;
          com.tencent.mm.plugin.finder.report.j.b((String)localObject1, (String)localObject2, 1, paramView, i, 2);
          paramView = FinderReporterUIC.tnG;
          paramView = localFinderContactSearchUI.getContext();
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
          paramView = null;
          break label319;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$FinderFeedSearchReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public final class b
    extends d
  {
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(166726);
      p.h(paramb, "event");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        int i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rZF;
        int j = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rZH;
        if (i <= j)
        {
          FinderContactSearchUI localFinderContactSearchUI = this.sDd;
          paramb = ((ars)FinderContactSearchUI.a(this.sDd).get(i)).contact;
          if (paramb != null) {}
          for (paramb = paramb.username;; paramb = null)
          {
            localFinderContactSearchUI.dt(paramb, i);
            if (i == j) {
              break label96;
            }
            i += 1;
            break;
          }
        }
      }
      label96:
      AppMethodBeat.o(166726);
    }
    
    public final boolean cAA()
    {
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<hb>
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      a(FinderContactSearchUI.c paramc, hb paramhb)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderContactSearchUI paramFinderContactSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(166727);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      FinderContactSearchUI.b(this.sDd).getFtsEditText().fMg();
      this.sDd.hideVKB();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(166727);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(203997);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(203997);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203999);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203999);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203998);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203998);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(166728);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ae.i(FinderContactSearchUI.c(this.sDd), "onLoadMoreBegin");
      Object localObject = FinderContactSearchUI.d(this.sDd);
      if (localObject != null)
      {
        if (FinderContactSearchUI.e(this.sDd) != 1) {
          break label250;
        }
        FinderContactSearchUI.a(this.sDd, new ba((String)localObject, FinderContactSearchUI.g(this.sDd), FinderContactSearchUI.h(this.sDd), FinderContactSearchUI.i(this.sDd), FinderContactSearchUI.j(this.sDd), null, 32));
        com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)FinderContactSearchUI.f(this.sDd));
        com.tencent.mm.kernel.g.ajj().a(3820, (f)this.sDd);
        localObject = FinderContactSearchUI.k(this.sDd).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759244);
          }
        }
        localObject = FinderContactSearchUI.k(this.sDd).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderContactSearchUI.k(this.sDd).getLoadMoreFooter();
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
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(166728);
        return;
        label250:
        localObject = FinderContactSearchUI.k(this.sDd).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759245);
          }
        }
        localObject = FinderContactSearchUI.k(this.sDd).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderContactSearchUI.k(this.sDd).getLoadMoreFooter();
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
    f(FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchUI
 * JD-Core Version:    0.7.0.1
 */