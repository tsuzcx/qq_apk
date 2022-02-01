package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.storage.ak.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bbz;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.TouchableLayout.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.d;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "isFromHistory", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "addExposeItem", "", "id", "position", "type", "getCommentScene", "getLayoutId", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onContactItemLongClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearch", "isAccountEmpty", "reportSearchExpose", "needClear", "startSearch", "ContactSearchProfileAdapter", "FinderFeedSearchReporter", "plugin-finder_release"})
public final class FinderContactSearchUI
  extends MMFinderUI
  implements com.tencent.mm.ak.i, FTSEditTextView.a, a.b
{
  final String TAG;
  private HashMap _$_findViewCache;
  private int continueFlag;
  String dPI;
  private View hSw;
  private RecyclerView hak;
  private int jKy;
  private int offset;
  String query;
  private int requestType;
  private final com.tencent.mm.plugin.finder.event.base.c tId;
  private RefreshLoadMoreLayout tLS;
  private com.tencent.mm.bw.b tVM;
  boolean twi;
  private ArrayList<bbz> uae;
  private com.tencent.mm.ui.search.a ubO;
  private boolean vtF;
  boolean vtG;
  private HashMap<String, a> vtH;
  private TextView vtJ;
  private h vtK;
  private cf vtL;
  private final c vtR;
  private final g vtS;
  
  public FinderContactSearchUI()
  {
    AppMethodBeat.i(166742);
    this.TAG = "Finder.FinderContactSearchUI";
    this.query = "";
    this.uae = new ArrayList();
    this.dPI = "";
    this.vtF = true;
    this.vtH = new HashMap();
    this.tId = new com.tencent.mm.plugin.finder.event.base.c();
    this.vtR = new c(this);
    this.vtS = new g();
    AppMethodBeat.o(166742);
  }
  
  private final void auV(String paramString)
  {
    AppMethodBeat.i(166738);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.tVM = null;
    this.uae.clear();
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
    com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166738);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(251264);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(251264);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251263);
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
    AppMethodBeat.o(251263);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(166733);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(166733);
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
    paramString2 = this.vtK;
    if (paramString2 != null)
    {
      paramString2.auW(paramString1);
      AppMethodBeat.o(166733);
      return;
    }
    AppMethodBeat.o(166733);
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(166736);
    hideVKB();
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
        AppMethodBeat.o(166736);
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
      AppMethodBeat.o(166736);
      return true;
    }
    this.twi = false;
    auV((String)localObject1);
    Object localObject2 = this.vtK;
    if (localObject2 != null) {
      ((h)localObject2).auX((String)localObject1);
    }
    e.Cxv.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(166736);
    return false;
  }
  
  public final void dpw() {}
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(166734);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.l locall = com.tencent.mm.plugin.finder.report.l.vfB;
      com.tencent.mm.plugin.finder.report.l.doe();
    }
    AppMethodBeat.o(166734);
  }
  
  public final int getCommentScene()
  {
    return 6;
  }
  
  public final int getLayoutId()
  {
    return 2131494225;
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
    paramView = this.ubO;
    if (paramView == null) {
      p.btv("searchView");
    }
    paramView.getFtsEditText().awD();
    showVKB();
    AppMethodBeat.o(166735);
  }
  
  public final void onContactItemLongClick(View paramView)
  {
    AppMethodBeat.i(251261);
    p.h(paramView, "view");
    if (this.requestType == 8)
    {
      com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a((Context)getContext());
      if (this.hak == null) {
        p.btv("recyclerView");
      }
      final int i = RecyclerView.bw(paramView);
      Object localObject = new z.d();
      ((z.d)localObject).SYE = 1;
      localObject = (View.OnCreateContextMenuListener)new h((z.d)localObject);
      o.g localg = (o.g)new i(this, i);
      TouchableLayout.a locala1 = TouchableLayout.Rni;
      int j = TouchableLayout.hfC();
      locala1 = TouchableLayout.Rni;
      locala.a(paramView, i, 0L, (View.OnCreateContextMenuListener)localObject, localg, j, TouchableLayout.hfD());
      locala.gTx();
    }
    AppMethodBeat.o(251261);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166730);
    super.onCreate(paramBundle);
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
    this.requestType = getIntent().getIntExtra("request_type", 2);
    this.vtG = getIntent().getBooleanExtra("from_at_contact", false);
    this.vtF = getIntent().getBooleanExtra("need_history", true);
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
    if (this.vtF) {
      this.vtK = new h((MMActivity)this, (kotlin.g.a.b)new f(this));
    }
    for (;;)
    {
      if (this.vtG) {
        setResult(0, getIntent());
      }
      Log.i(this.TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.vtG) });
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
      paramBundle.setAdapter((RecyclerView.a)new a());
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
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).axQ(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.tId.a((com.tencent.mm.plugin.finder.event.base.d)new b());
      this.vtR.alive();
      paramBundle = this.hak;
      if (paramBundle == null) {
        p.btv("recyclerView");
      }
      paramBundle.a((RecyclerView.l)this.vtS);
      AppMethodBeat.o(166730);
      return;
      paramBundle = findViewById(2131302342);
      p.g(paramBundle, "findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166737);
    this.vtR.dead();
    Object localObject = this.vtK;
    if (localObject != null) {
      ((h)localObject).onDestroy();
    }
    this.tId.onRelease();
    g.azz().b(3820, (com.tencent.mm.ak.i)this);
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).b((RecyclerView.l)this.vtS);
    super.onDestroy();
    AppMethodBeat.o(166737);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(251259);
    super.onPause();
    Object localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    com.tencent.mm.plugin.finder.report.live.k.b((RecyclerView)localObject, s.p.voz, s.j.vnP.scene, com.tencent.mm.plugin.finder.report.live.c.vjg);
    AppMethodBeat.o(251259);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(251258);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    com.tencent.mm.plugin.finder.report.live.k.b((RecyclerView)localObject, s.p.voz, s.j.vnP.scene, com.tencent.mm.plugin.finder.report.live.c.vjf);
    AppMethodBeat.o(251258);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(166739);
    g.azz().b(3820, (com.tencent.mm.ak.i)this);
    int j = this.uae.size();
    int i = this.uae.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      e.Cxv.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.vtL;
      if (paramString != null) {}
      for (paramString = paramString.twl; paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166739);
        throw paramString;
      }
      paramq = paramString.zns;
      p.g(paramq, "response.infoList");
      Object localObject1 = (Iterable)paramq;
      paramq = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bbz)((Iterator)localObject1).next();
        paramq.add(Boolean.valueOf(this.uae.add(localObject2)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.tVM = paramString.tVM;
      i = this.uae.size();
      Log.i(this.TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.uae.size());
      paramq = this.query;
      boolean bool = paramString.zns.isEmpty();
      if (this.twi)
      {
        paramInt1 = 2;
        if (!bool) {
          break label514;
        }
        paramInt2 = 1;
        label313:
        paramString = com.tencent.mm.plugin.finder.report.k.vfA;
        paramString = com.tencent.mm.plugin.finder.report.k.vfA;
        localObject1 = com.tencent.mm.plugin.finder.report.k.dob();
        localObject2 = this.dPI;
        paramString = FinderReporterUIC.wzC;
        paramString = getContext();
        p.g(paramString, "context");
        paramString = FinderReporterUIC.a.fH((Context)paramString);
        if (paramString == null) {
          break label519;
        }
        paramString = paramString.dIx();
        label365:
        com.tencent.mm.plugin.finder.report.k.a((String)localObject1, (String)localObject2, paramq, 2, paramInt1, 2, paramInt2, 1, paramString);
        paramInt1 = i;
        label383:
        paramString = this.tLS;
        if (paramString == null) {
          p.btv("rlLayout");
        }
        paramString.apT(0);
        if (paramInt1 != 0) {
          break label544;
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
          AppMethodBeat.o(166739);
          return;
          paramInt1 = 1;
          break;
          label514:
          paramInt2 = 2;
          break label313;
          label519:
          paramString = null;
          break label365;
          e.Cxv.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break label383;
          label544:
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
          continue;
        }
        AppMethodBeat.o(166739);
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "bindData", "", "holder", "position", "", "bindImage", "", "getData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<RecyclerView.v>
  {
    private final void i(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(166724);
      Object localObject1 = FinderContactSearchUI.a(this.vtT).get(paramInt);
      p.g(localObject1, "contactList[position]");
      bbz localbbz = (bbz)localObject1;
      Object localObject2 = this.vtT;
      localObject1 = localbbz.contact;
      if (localObject1 != null) {}
      for (localObject1 = ((FinderContact)localObject1).username;; localObject1 = null)
      {
        FinderContactSearchUI.a((FinderContactSearchUI)localObject2, (String)localObject1, paramInt);
        if (paramv != null) {
          break;
        }
        paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
        AppMethodBeat.o(166724);
        throw paramv;
      }
      paramv = (c)paramv;
      localObject1 = (View.OnClickListener)new a(this, paramInt);
      localObject2 = (View.OnLongClickListener)new b(this);
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramv.a(localbbz, (View.OnClickListener)localObject1, (View.OnLongClickListener)localObject2, bool);
        AppMethodBeat.o(166724);
        return;
      }
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(166722);
      p.h(paramViewGroup, "parent");
      AppCompatActivity localAppCompatActivity = this.vtT.getContext();
      if (localAppCompatActivity == null) {
        p.hyc();
      }
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(2131494224, paramViewGroup, false);
      p.g(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(166722);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(166725);
      p.h(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(166725);
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(166723);
      p.h(paramv, "holder");
      p.h(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(166723);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166721);
      int i = FinderContactSearchUI.a(this.vtT).size();
      AppMethodBeat.o(166721);
      return i;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchUI.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166720);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
        p.g(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(166720);
          throw paramView;
        }
        bbz localbbz = (bbz)paramView;
        FinderContactSearchUI localFinderContactSearchUI = this.vtU.vtT;
        int j = paramInt;
        p.h(localbbz, "finderSearchInfo");
        if (localFinderContactSearchUI.vtG)
        {
          Log.i(localFinderContactSearchUI.TAG, "onContactItemClick select atContact");
          paramView = com.tencent.mm.plugin.finder.utils.d.vVg;
          localObject1 = localbbz.contact;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = new FinderContact();
          }
          paramView = com.tencent.mm.plugin.finder.utils.d.e(paramView);
          localFinderContactSearchUI.getIntent().putExtra("at_select_contact", paramView.toByteArray());
          localFinderContactSearchUI.setResult(-1, localFinderContactSearchUI.getIntent());
          localFinderContactSearchUI.finish();
        }
        label374:
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(166720);
          return;
          paramView = localbbz.contact;
          if ((paramView != null) && (paramView.liveStatus == 1))
          {
            localObject2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
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
            ((com.tencent.mm.plugin.finder.report.live.k)localObject2).a(null, paramView, j, s.p.voC, s.j.vnP.scene);
          }
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
          paramView = localFinderContactSearchUI.getContext();
          p.g(paramView, "context");
          FinderReporterUIC.a.a((Context)paramView, (Intent)localObject2, 0L, 7, false, 64);
          paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
          paramView = localFinderContactSearchUI.getContext();
          p.g(paramView, "context");
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)paramView, (Intent)localObject2);
          if (!localFinderContactSearchUI.twi) {
            break;
          }
          i = 2;
          paramView = com.tencent.mm.plugin.finder.report.k.vfA;
          localObject2 = localFinderContactSearchUI.dPI;
          String str1 = localFinderContactSearchUI.query;
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
          localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
          String str2 = com.tencent.mm.plugin.finder.report.k.dob();
          localObject1 = FinderReporterUIC.wzC;
          localObject1 = localFinderContactSearchUI.getContext();
          p.g(localObject1, "context");
          localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
          if (localObject1 == null) {
            break label671;
          }
          localObject1 = ((FinderReporterUIC)localObject1).dIx();
          com.tencent.mm.plugin.finder.report.k.a((String)localObject2, str1, 1, 1, paramView, j, 2, str2, i, (bbn)localObject1);
          paramView = com.tencent.mm.plugin.finder.report.k.vfA;
          localObject2 = localFinderContactSearchUI.dPI;
          str1 = localFinderContactSearchUI.query;
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
          localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
          str2 = com.tencent.mm.plugin.finder.report.k.dob();
          localObject1 = FinderReporterUIC.wzC;
          localObject1 = localFinderContactSearchUI.getContext();
          p.g(localObject1, "context");
          localObject1 = FinderReporterUIC.a.fH((Context)localObject1);
          if (localObject1 == null) {
            break label677;
          }
          localObject1 = ((FinderReporterUIC)localObject1).dIx();
          com.tencent.mm.plugin.finder.report.k.a((String)localObject2, str1, 1, 1, paramView, j, 2, str2, 2, i, (bbn)localObject1);
          paramView = FinderReporterUIC.wzC;
          paramView = localFinderContactSearchUI.getContext();
          p.g(paramView, "context");
          paramView = FinderReporterUIC.a.fH((Context)paramView);
        } while (paramView == null);
        label470:
        localObject1 = com.tencent.mm.plugin.finder.report.k.vfA;
        label583:
        int i = paramView.tCE;
        paramView = localbbz.contact;
        if (paramView != null) {}
        for (paramView = paramView.username;; paramView = null)
        {
          com.tencent.mm.plugin.finder.report.k.a(6, 0L, i, 1, paramView);
          break;
          i = 1;
          break label374;
          label671:
          localObject1 = null;
          break label470;
          label677:
          localObject1 = null;
          break label583;
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class b
      implements View.OnLongClickListener
    {
      b(FinderContactSearchUI.a parama) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(251247);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        localObject = this.vtU.vtT;
        p.g(paramView, "it");
        ((FinderContactSearchUI)localObject).onContactItemLongClick(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(251247);
        return true;
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$FinderFeedSearchReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public final class b
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(166726);
      p.h(paramb, "event");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        int i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIy;
        int j = ((com.tencent.mm.plugin.finder.event.base.h)paramb).tIA;
        if (i <= j)
        {
          FinderContactSearchUI localFinderContactSearchUI = this.vtT;
          paramb = ((bbz)FinderContactSearchUI.a(this.vtT).get(i)).contact;
          if (paramb != null) {}
          for (paramb = paramb.username;; paramb = null)
          {
            FinderContactSearchUI.a(localFinderContactSearchUI, paramb, i);
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
    
    public final boolean cZD()
    {
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hf>
  {
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderContactSearchUI.c paramc, hf paramhf)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderContactSearchUI paramFinderContactSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(166727);
      FinderContactSearchUI.b(this.vtT).getFtsEditText().gUA();
      this.vtT.hideVKB();
      AppMethodBeat.o(166727);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(251250);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(251250);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(251252);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(251252);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(166728);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.i(FinderContactSearchUI.d(this.vtT), "onLoadMoreBegin");
      Object localObject = FinderContactSearchUI.e(this.vtT);
      if (localObject != null)
      {
        if (FinderContactSearchUI.f(this.vtT) != 1) {
          break label250;
        }
        FinderContactSearchUI.a(this.vtT, new cf((String)localObject, FinderContactSearchUI.h(this.vtT), FinderContactSearchUI.i(this.vtT), FinderContactSearchUI.j(this.vtT), FinderContactSearchUI.k(this.vtT), null, 96));
        g.azz().b((com.tencent.mm.ak.q)FinderContactSearchUI.g(this.vtT));
        g.azz().a(3820, (com.tencent.mm.ak.i)this.vtT);
        localObject = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setText(2131760234);
          }
        }
        localObject = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
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
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(166728);
        return;
        label250:
        localObject = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setText(2131760235);
          }
        }
        localObject = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(2131303685);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderContactSearchUI.l(this.vtT).getLoadMoreFooter();
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
      AppMethodBeat.i(251251);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(251251);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    f(FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class g
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(251254);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(251254);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(251253);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
      com.tencent.mm.plugin.finder.report.live.k.b(paramRecyclerView, s.p.voz, s.j.vnP.scene, com.tencent.mm.plugin.finder.report.live.c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(251253);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$onContactItemLongClick$1", "Landroid/view/View$OnCreateContextMenuListener;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
  public static final class h
    implements View.OnCreateContextMenuListener
  {
    h(z.d paramd) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(251255);
      if (paramContextMenu != null)
      {
        paramContextMenu.add(0, this.vtW.SYE, 0, 2131760270);
        AppMethodBeat.o(251255);
        return;
      }
      AppMethodBeat.o(251255);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$onContactItemLongClick$2", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"})
  public static final class i
    implements o.g
  {
    i(int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(251257);
      if ((i >= 0) && (i < FinderContactSearchUI.a(this.vtT).size()))
      {
        paramMenuItem = (bbz)FinderContactSearchUI.a(this.vtT).get(i);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.contact;
          if (paramMenuItem != null)
          {
            com.tencent.mm.plugin.finder.storage.b localb = new com.tencent.mm.plugin.finder.storage.b();
            p.g(paramMenuItem, "it");
            localb.a(paramMenuItem, (ak.a)new a(this));
            AppMethodBeat.o(251257);
            return;
          }
        }
      }
      AppMethodBeat.o(251257);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$onContactItemLongClick$2$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onDel", "", "success", "", "plugin-finder_release"})
    public static final class a
      implements ak.a
    {
      a(FinderContactSearchUI.i parami) {}
      
      public final void nN(boolean paramBoolean)
      {
        AppMethodBeat.i(251256);
        if (paramBoolean)
        {
          FinderContactSearchUI.a(this.vtX.vtT).remove(this.vtX.uWy);
          RecyclerView.a locala = FinderContactSearchUI.m(this.vtX.vtT).getAdapter();
          if (locala != null)
          {
            locala.ck(this.vtX.uWy);
            AppMethodBeat.o(251256);
            return;
          }
          AppMethodBeat.o(251256);
          return;
        }
        u.makeText((Context)this.vtX.vtT.getContext(), (CharSequence)"failed", 0).show();
        AppMethodBeat.o(251256);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchUI
 * JD-Core Version:    0.7.0.1
 */