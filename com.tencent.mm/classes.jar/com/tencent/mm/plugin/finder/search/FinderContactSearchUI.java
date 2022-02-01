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
import com.tencent.mm.al.f;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.plugin.finder.cgi.az;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "addExposeItem", "", "id", "position", "type", "getLayoutId", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "ContactSearchProfileAdapter", "FinderFeedSearchReporter", "plugin-finder_release"})
public final class FinderContactSearchUI
  extends MMFinderUI
  implements f, FTSEditTextView.a, a.b
{
  final String TAG;
  private HashMap _$_findViewCache;
  private int continueFlag;
  String dwW;
  private View gWO;
  private RecyclerView gmV;
  private int iKR;
  private int offset;
  String query;
  private final com.tencent.mm.plugin.finder.event.base.c rQJ;
  private RefreshLoadMoreLayout rTF;
  private int requestType;
  private com.tencent.mm.bx.b sbF;
  private ArrayList<ard> sec;
  private com.tencent.mm.ui.search.a ssF;
  private boolean ssG;
  boolean ssH;
  private HashMap<String, a> ssI;
  private TextView ssK;
  private g ssL;
  private az ssM;
  private final c ssS;
  
  public FinderContactSearchUI()
  {
    AppMethodBeat.i(166742);
    this.TAG = "Finder.FinderContactSearchUI";
    this.query = "";
    this.sec = new ArrayList();
    this.dwW = "";
    this.ssG = true;
    this.ssI = new HashMap();
    this.rQJ = new com.tencent.mm.plugin.finder.event.base.c();
    this.ssS = new c(this);
    AppMethodBeat.o(166742);
  }
  
  private final void ahT(String paramString)
  {
    AppMethodBeat.i(166738);
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
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166738);
  }
  
  private final void mb(boolean paramBoolean)
  {
    AppMethodBeat.i(166741);
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
      AppMethodBeat.o(166741);
      return;
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203442);
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
    AppMethodBeat.o(203442);
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
    paramString2 = this.ssL;
    if (paramString2 != null)
    {
      paramString2.ahV(paramString1);
      AppMethodBeat.o(166733);
      return;
    }
    AppMethodBeat.o(166733);
  }
  
  public final boolean bzz()
  {
    AppMethodBeat.i(166736);
    hideVKB();
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
    ahT((String)localObject1);
    Object localObject2 = this.ssL;
    if (localObject2 != null) {
      ((g)localObject2).ahW((String)localObject1);
    }
    e.ygI.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(166736);
    return false;
  }
  
  public final void cED() {}
  
  public final void jdMethod_do(String paramString, int paramInt)
  {
    AppMethodBeat.i(166740);
    p.h(paramString, "id");
    if (!this.ssI.containsKey(paramString))
    {
      ad.d(this.TAG, "addExposeItem " + paramString + ' ' + paramInt + ' ' + 1);
      a locala = new a();
      locala.setId(paramString);
      locala.position = paramInt;
      locala.type = 1;
      locala.timeStamp = System.currentTimeMillis();
      ((Map)this.ssI).put(paramString, locala);
      if (this.ssI.size() % 30 == 0) {
        mb(false);
      }
    }
    AppMethodBeat.o(166740);
  }
  
  public final int getLayoutId()
  {
    return 2131494019;
  }
  
  public final void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(166734);
    if (paramBoolean)
    {
      i locali = i.soN;
      i.cDA();
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
    paramView = this.ssF;
    if (paramView == null) {
      p.bcb("searchView");
    }
    paramView.getFtsEditText().fJS();
    showVKB();
    AppMethodBeat.o(166735);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166730);
    super.onCreate(paramBundle);
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
    this.requestType = getIntent().getIntExtra("request_type", 2);
    this.ssH = getIntent().getBooleanExtra("from_at_contact", false);
    this.ssG = getIntent().getBooleanExtra("need_history", true);
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
    if (this.ssG) {
      this.ssL = new g((MMActivity)this, (d.g.a.b)new f(this));
    }
    if (this.ssH) {
      setResult(0, getIntent());
    }
    ad.i(this.TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.ssH) });
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
    paramBundle.setAdapter((RecyclerView.a)new a());
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
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).ahp(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
    paramBundle.ca(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
    this.rQJ.a((d)new b());
    this.ssS.alive();
    AppMethodBeat.o(166730);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166737);
    this.ssS.dead();
    g localg = this.ssL;
    if (localg != null) {
      localg.onDestroy();
    }
    mb(true);
    this.rQJ.onRelease();
    com.tencent.mm.kernel.g.aiU().b(3820, (f)this);
    super.onDestroy();
    AppMethodBeat.o(166737);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(166739);
    com.tencent.mm.kernel.g.aiU().b(3820, (f)this);
    int j = this.sec.size();
    int i = this.sec.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.ygI.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.ssM;
      if (paramString != null) {}
      for (paramString = paramString.rJS; paramString == null; paramString = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166739);
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
      paramInt1 = this.sec.size();
      ad.i(this.TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.sec.size());
      paramString = this.rTF;
      if (paramString == null) {
        p.bcb("rlLayout");
      }
      paramString.afZ(0);
      if (paramInt1 != 0) {
        break label427;
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
          AppMethodBeat.o(166739);
          return;
          e.ygI.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label427:
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
          continue;
        }
        AppMethodBeat.o(166739);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "bindData", "", "holder", "position", "", "bindImage", "", "getItemCount", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<RecyclerView.w>
  {
    private final void i(RecyclerView.w paramw, final int paramInt)
    {
      AppMethodBeat.i(166724);
      Object localObject1 = FinderContactSearchUI.a(this.ssT).get(paramInt);
      p.g(localObject1, "contactList[position]");
      localObject1 = (ard)localObject1;
      Object localObject2 = this.ssT;
      String str = ((ard)localObject1).contact.username;
      p.g(str, "searchInfo.contact.username");
      ((FinderContactSearchUI)localObject2).jdMethod_do(str, paramInt);
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
        paramw.a((ard)localObject1, (View.OnClickListener)localObject2, bool);
        AppMethodBeat.o(166724);
        return;
      }
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(166722);
      p.h(paramViewGroup, "parent");
      AppCompatActivity localAppCompatActivity = this.ssT.getContext();
      if (localAppCompatActivity == null) {
        p.gfZ();
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
      int i = FinderContactSearchUI.a(this.ssT).size();
      AppMethodBeat.o(166721);
      return i;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchUI.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166720);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
        p.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(166720);
          throw paramView;
        }
        paramView = (ard)paramView;
        localObject1 = this.ssU.ssT;
        int i = paramInt;
        p.h(paramView, "finderSearchInfo");
        Object localObject2;
        if (((FinderContactSearchUI)localObject1).ssH)
        {
          ad.i(((FinderContactSearchUI)localObject1).TAG, "onContactItemClick select atContact");
          localObject2 = com.tencent.mm.plugin.finder.utils.b.sKO;
          paramView = paramView.contact;
          p.g(paramView, "finderSearchInfo.contact");
          paramView = com.tencent.mm.plugin.finder.utils.b.c(paramView);
          ((FinderContactSearchUI)localObject1).getIntent().putExtra("at_select_contact", paramView.toByteArray());
          ((FinderContactSearchUI)localObject1).setResult(-1, ((FinderContactSearchUI)localObject1).getIntent());
          ((FinderContactSearchUI)localObject1).finish();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(166720);
          return;
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("finder_username", paramView.contact.username);
          Object localObject3 = FinderReporterUIC.tcM;
          localObject3 = ((FinderContactSearchUI)localObject1).getContext();
          p.g(localObject3, "context");
          FinderReporterUIC.a.a((Context)localObject3, (Intent)localObject2, 0L, 7, false, 64);
          localObject3 = com.tencent.mm.plugin.finder.utils.a.sKD;
          localObject3 = ((FinderContactSearchUI)localObject1).getContext();
          p.g(localObject3, "context");
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)localObject3, (Intent)localObject2);
          localObject2 = i.soN;
          localObject2 = ((FinderContactSearchUI)localObject1).dwW;
          localObject3 = ((FinderContactSearchUI)localObject1).query;
          String str = paramView.contact.username;
          p.g(str, "finderSearchInfo.contact.username");
          i.b((String)localObject2, (String)localObject3, 1, str, i, 2);
          localObject2 = FinderReporterUIC.tcM;
          localObject1 = ((FinderContactSearchUI)localObject1).getContext();
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$FinderFeedSearchReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public final class b
    extends d
  {
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(166726);
      p.h(paramb, "event");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        int i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rRd;
        int j = ((com.tencent.mm.plugin.finder.event.base.h)paramb).rRf;
        if (i <= j) {
          for (;;)
          {
            paramb = this.ssT;
            String str = ((ard)FinderContactSearchUI.a(this.ssT).get(i)).contact.username;
            p.g(str, "contactList[i].contact.username");
            paramb.jdMethod_do(str, i);
            if (i == j) {
              break;
            }
            i += 1;
          }
        }
      }
      AppMethodBeat.o(166726);
    }
    
    public final boolean cyW()
    {
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends com.tencent.mm.sdk.b.c<ha>
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements d.g.a.a<d.z>
    {
      a(FinderContactSearchUI.c paramc, ha paramha)
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
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
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      FinderContactSearchUI.b(this.ssT).getFtsEditText().fHO();
      this.ssT.hideVKB();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(166727);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(203438);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(203438);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203440);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203440);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(203439);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(203439);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(166728);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ad.i(FinderContactSearchUI.c(this.ssT), "onLoadMoreBegin");
      Object localObject = FinderContactSearchUI.d(this.ssT);
      if (localObject != null)
      {
        if (FinderContactSearchUI.e(this.ssT) != 1) {
          break label250;
        }
        FinderContactSearchUI.a(this.ssT, new az((String)localObject, FinderContactSearchUI.g(this.ssT), FinderContactSearchUI.h(this.ssT), FinderContactSearchUI.i(this.ssT), FinderContactSearchUI.j(this.ssT), null, 32));
        com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)FinderContactSearchUI.f(this.ssT));
        com.tencent.mm.kernel.g.aiU().a(3820, (f)this.ssT);
        localObject = FinderContactSearchUI.k(this.ssT).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759244);
          }
        }
        localObject = FinderContactSearchUI.k(this.ssT).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderContactSearchUI.k(this.ssT).getLoadMoreFooter();
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
        localObject = FinderContactSearchUI.k(this.ssT).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setText(2131759245);
          }
        }
        localObject = FinderContactSearchUI.k(this.ssT).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131301486);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderContactSearchUI.k(this.ssT).getLoadMoreFooter();
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
    f(FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchUI
 * JD-Core Version:    0.7.0.1
 */