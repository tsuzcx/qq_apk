package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.hm;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.finder.event.base.d;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.e;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.an;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
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
import java.util.Set;
import java.util.UUID;
import kotlin.a.ak;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "isForceNightMode", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchSuggestionManager", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;", "searchType", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "adapteNightMode", "", "addExposeItem", "id", "position", "type", "getCommentScene", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initContentView", "initData", "initSearchView", "initSuggestion", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onContactItemLongClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearch", "isAccountEmpty", "reportSearchExpose", "needClear", "startSearch", "ContactSearchProfileAdapter", "FinderFeedSearchReporter", "plugin-finder_release"})
public final class FinderContactSearchUI
  extends MMFinderUI
  implements com.tencent.mm.an.i, FTSEditTextView.b, a.b
{
  private final c Aac;
  private final i Aad;
  final String TAG;
  private HashMap _$_findViewCache;
  private int continueFlag;
  String fIY;
  private RecyclerView jLl;
  private View kGT;
  private int mBD;
  private int offset;
  String query;
  private int requestType;
  int uMD;
  private com.tencent.mm.cd.b xHE;
  private ArrayList<bip> xMG;
  private com.tencent.mm.ui.search.a xNC;
  private TextView xND;
  private i xNE;
  private k xNF;
  private cj xNG;
  private boolean xnL;
  private final com.tencent.mm.plugin.finder.event.base.c xqM;
  private RefreshLoadMoreLayout xvJ;
  private boolean zZT;
  boolean zZU;
  private HashMap<String, a> zZV;
  
  public FinderContactSearchUI()
  {
    AppMethodBeat.i(166742);
    this.TAG = "Finder.FinderContactSearchUI";
    this.query = "";
    this.xMG = new ArrayList();
    this.fIY = "";
    this.zZT = true;
    this.zZV = new HashMap();
    this.uMD = 1;
    this.xqM = new com.tencent.mm.plugin.finder.event.base.c();
    this.Aac = new c(this);
    this.Aad = new i();
    AppMethodBeat.o(166742);
  }
  
  private final void aEi(String paramString)
  {
    AppMethodBeat.i(166738);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.xHE = null;
    this.xMG.clear();
    Object localObject = UUID.randomUUID().toString();
    p.j(localObject, "UUID.randomUUID().toString()");
    this.fIY = ((String)localObject);
    if (this.xNG != null) {
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)this.xNG);
    }
    this.xNG = new cj(paramString, this.offset, this.fIY, this.xHE, this.requestType, null, null, null, 480);
    com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)this.xNG);
    com.tencent.mm.kernel.h.aGY().a(3820, (com.tencent.mm.an.i)this);
    paramString = this.kGT;
    if (paramString == null) {
      p.bGy("loadingView");
    }
    paramString.setVisibility(0);
    paramString = this.xND;
    if (paramString == null) {
      p.bGy("noResultView");
    }
    paramString.setVisibility(8);
    paramString = this.xvJ;
    if (paramString == null) {
      p.bGy("rlLayout");
    }
    paramString.setVisibility(8);
    paramString = this.jLl;
    if (paramString == null) {
      p.bGy("recyclerView");
    }
    localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166738);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(264097);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(264097);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(264096);
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
    AppMethodBeat.o(264096);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
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
      paramString2 = kotlin.n.n.bb((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    if (Util.isNullOrNil(paramString1))
    {
      paramString2 = this.kGT;
      if (paramString2 == null) {
        p.bGy("loadingView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.xND;
      if (paramString2 == null) {
        p.bGy("noResultView");
      }
      paramString2.setVisibility(8);
      paramString2 = this.xvJ;
      if (paramString2 == null) {
        p.bGy("rlLayout");
      }
      paramString2.setVisibility(8);
    }
    paramString2 = this.xNE;
    if (paramString2 != null)
    {
      paramString2.aEm(paramString1);
      AppMethodBeat.o(166733);
      return;
    }
    AppMethodBeat.o(166733);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(166736);
    hideVKB();
    Object localObject1 = this.xNC;
    if (localObject1 == null) {
      p.bGy("searchView");
    }
    localObject1 = ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText();
    p.j(localObject1, "searchView.ftsEditText");
    localObject1 = ((FTSEditTextView)localObject1).getTotalQuery();
    if (localObject1 != null)
    {
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(166736);
        throw ((Throwable)localObject1);
      }
      localObject2 = kotlin.n.n.bb((CharSequence)localObject1).toString();
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
    this.uMD = 1;
    aEi((String)localObject1);
    Object localObject2 = this.xNE;
    if (localObject2 != null) {
      ((i)localObject2).aEn((String)localObject1);
    }
    localObject1 = this.xNF;
    if (localObject1 == null) {
      p.bGy("searchSuggestionManager");
    }
    ((k)localObject1).dRj();
    f.Iyx.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(166736);
    return false;
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(166734);
    if (paramBoolean)
    {
      o localo = o.zWG;
      o.dPE();
    }
    AppMethodBeat.o(166734);
  }
  
  public final int getCommentScene()
  {
    return 6;
  }
  
  public final int getLayoutId()
  {
    if (this.xnL) {
      return b.g.finder_contact_search_ui_night_mode;
    }
    return b.g.finder_contact_search_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(264085);
    Object localObject = com.tencent.mm.plugin.finder.utils.aj.AGc;
    if (com.tencent.mm.plugin.finder.utils.aj.isOtherEnableFullScreenEnjoy())
    {
      localObject = ak.setOf(an.class);
      AppMethodBeat.o(264085);
      return localObject;
    }
    AppMethodBeat.o(264085);
    return null;
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
    paramView = this.xNC;
    if (paramView == null) {
      p.bGy("searchView");
    }
    paramView.getFtsEditText().aDU();
    showVKB();
    AppMethodBeat.o(166735);
  }
  
  public final void onContactItemLongClick(View paramView)
  {
    AppMethodBeat.i(264092);
    p.k(paramView, "view");
    if (this.requestType == 8)
    {
      com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a((Context)getContext());
      if (this.jLl == null) {
        p.bGy("recyclerView");
      }
      final int i = RecyclerView.bh(paramView);
      Object localObject = new aa.d();
      ((aa.d)localObject).aaBA = 1;
      localObject = (View.OnCreateContextMenuListener)new j((aa.d)localObject);
      q.g localg = (q.g)new k(this, i);
      TouchableLayout.a locala1 = TouchableLayout.YOD;
      int j = TouchableLayout.igZ();
      locala1 = TouchableLayout.YOD;
      locala.a(paramView, i, 0L, (View.OnCreateContextMenuListener)localObject, localg, j, TouchableLayout.iha());
      locala.hTd();
    }
    AppMethodBeat.o(264092);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166730);
    super.onCreate(paramBundle);
    this.xnL = getIntent().getBooleanExtra("is_force_night_mode", false);
    if (this.xnL)
    {
      paramBundle = getController();
      localObject1 = getContext();
      p.j(localObject1, "context");
      paramBundle.setActionbarColor(((AppCompatActivity)localObject1).getResources().getColor(b.c.Dark_0));
      setBackGroundColorResource(b.c.Dark_0);
    }
    this.xNC = new com.tencent.mm.ui.search.a((Context)this, this.xnL);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      p.bGy("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      p.bGy("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(b.j.app_search));
    paramBundle = this.xNC;
    if (paramBundle == null) {
      p.bGy("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.b)this);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      p.bGy("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      p.bGy("searchView");
    }
    paramBundle.getFtsEditText().hXB();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.iCn();
    }
    p.j(paramBundle, "supportActionBar!!");
    Object localObject1 = this.xNC;
    if (localObject1 == null) {
      p.bGy("searchView");
    }
    paramBundle.setCustomView((View)localObject1);
    this.requestType = getIntent().getIntExtra("request_type", 2);
    this.zZU = getIntent().getBooleanExtra("from_at_contact", false);
    this.zZT = getIntent().getBooleanExtra("need_history", true);
    paramBundle = j.Acs;
    if (j.dRh() != null)
    {
      paramBundle = j.Acs;
      localObject2 = j.dRh();
      if (localObject2 == null) {
        p.iCn();
      }
      paramBundle = j.Acs;
      j.a(null);
      localObject1 = ((ass)localObject2).fIY;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.fIY = paramBundle;
      localObject1 = ((ass)localObject2).query;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.query = paramBundle;
      this.offset = ((ass)localObject2).offset;
      this.continueFlag = ((ass)localObject2).continueFlag;
      this.xHE = ((ass)localObject2).xHE;
      this.mBD = ((ass)localObject2).SFT;
      paramBundle = ((ass)localObject2).SFU;
      p.j(paramBundle, "finderFeedObj.contactList");
      localObject1 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bip)((Iterator)localObject1).next();
        paramBundle.add(Boolean.valueOf(this.xMG.add(localObject2)));
      }
    }
    paramBundle = UUID.randomUUID().toString();
    p.j(paramBundle, "UUID.randomUUID().toString()");
    this.fIY = paramBundle;
    this.query = "";
    paramBundle = this.xNC;
    if (paramBundle == null) {
      p.bGy("searchView");
    }
    paramBundle.getFtsEditText().aDU();
    paramBundle = this.xNC;
    if (paramBundle == null) {
      p.bGy("searchView");
    }
    paramBundle.getFtsEditText().aDT();
    if (this.zZT) {
      this.xNE = new i((MMActivity)this, false, this.xnL, (kotlin.g.a.b)new f(this), (l)new g());
    }
    for (;;)
    {
      if (this.zZU) {
        setResult(0, getIntent());
      }
      Log.i(this.TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.zZU) });
      paramBundle = (MMActivity)this;
      localObject1 = this.xNC;
      if (localObject1 == null) {
        p.bGy("searchView");
      }
      localObject1 = ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText();
      p.j(localObject1, "searchView.ftsEditText");
      this.xNF = new k(paramBundle, (FTSEditTextView)localObject1, 0, 2, false, this.xnL, (kotlin.g.a.b)new h(this));
      paramBundle = getContext().findViewById(b.f.rl_layout);
      p.j(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.xvJ = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.xvJ;
      if (paramBundle == null) {
        p.bGy("rlLayout");
      }
      this.jLl = paramBundle.getRecyclerView();
      paramBundle = getContext().findViewById(b.f.no_result_tv);
      p.j(paramBundle, "context.findViewById(R.id.no_result_tv)");
      this.xND = ((TextView)paramBundle);
      paramBundle = getContext().findViewById(b.f.loading_layout);
      p.j(paramBundle, "context.findViewById(R.id.loading_layout)");
      this.kGT = paramBundle;
      if (!this.xnL) {
        break label948;
      }
      paramBundle = getContext().findViewById(b.f.main_rv);
      if (paramBundle != null) {
        break;
      }
      paramBundle = new kotlin.t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(166730);
      throw paramBundle;
      paramBundle = findViewById(b.f.history_lv);
      p.j(paramBundle, "findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
    localObject1 = this.xvJ;
    if (localObject1 == null) {
      p.bGy("rlLayout");
    }
    Object localObject2 = getContext();
    p.j(localObject2, "context");
    ((RefreshLoadMoreLayout)localObject1).setBackgroundColor(((AppCompatActivity)localObject2).getResources().getColor(b.c.Dark_0));
    localObject1 = getContext();
    p.j(localObject1, "context");
    paramBundle.setBackgroundColor(((AppCompatActivity)localObject1).getResources().getColor(b.c.Dark_0));
    label948:
    paramBundle = new FinderLinearLayoutManager((Context)this);
    localObject1 = this.jLl;
    if (localObject1 == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    paramBundle.setAdapter((RecyclerView.a)new a(this.xnL));
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    paramBundle.setHasFixedSize(true);
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    paramBundle.setItemViewCacheSize(5);
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    paramBundle.setOnTouchListener((View.OnTouchListener)new d(this));
    paramBundle = this.xvJ;
    if (paramBundle == null) {
      p.bGy("rlLayout");
    }
    paramBundle.setEnablePullDownHeader(false);
    paramBundle = this.xvJ;
    if (paramBundle == null) {
      p.bGy("rlLayout");
    }
    localObject1 = ad.kS((Context)getContext());
    if (this.xnL) {}
    for (int i = b.g.load_more_footer_night_mode;; i = b.g.load_more_footer)
    {
      localObject1 = ((LayoutInflater)localObject1).inflate(i, null);
      p.j(localObject1, "MMLayoutInflater.getInfl…oter\n            }, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.xvJ;
      if (paramBundle == null) {
        p.bGy("rlLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
      paramBundle = this.query;
      if (paramBundle != null)
      {
        localObject1 = this.xNF;
        if (localObject1 == null) {
          p.bGy("searchSuggestionManager");
        }
        ((k)localObject1).aEq(paramBundle);
        localObject1 = this.xNC;
        if (localObject1 == null) {
          p.bGy("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText().O(paramBundle, null);
      }
      paramBundle = this.jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.notifyDataSetChanged();
      }
      paramBundle = this.jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      localObject1 = com.tencent.mm.hellhoundlib.b.c.a(this.mBD, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.xqM.a((d)new b());
      this.Aac.alive();
      paramBundle = this.jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle.a((RecyclerView.l)this.Aad);
      AppMethodBeat.o(166730);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166737);
    this.Aac.dead();
    Object localObject = this.xNE;
    if (localObject != null) {
      ((i)localObject).onDestroy();
    }
    this.xqM.onRelease();
    com.tencent.mm.kernel.h.aGY().b(3820, (com.tencent.mm.an.i)this);
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).b((RecyclerView.l)this.Aad);
    super.onDestroy();
    AppMethodBeat.o(166737);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(264089);
    super.onPause();
    Object localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    com.tencent.mm.plugin.finder.live.report.k.b((RecyclerView)localObject, s.t.yGM, s.l.yFR.scene, com.tencent.mm.plugin.finder.live.report.c.yAj);
    localObject = this.xNF;
    if (localObject == null) {
      p.bGy("searchSuggestionManager");
    }
    ((k)localObject).onActivityPause();
    AppMethodBeat.o(264089);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(264087);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    com.tencent.mm.plugin.finder.live.report.k.b((RecyclerView)localObject, s.t.yGM, s.l.yFR.scene, com.tencent.mm.plugin.finder.live.report.c.yAi);
    localObject = this.xNF;
    if (localObject == null) {
      p.bGy("searchSuggestionManager");
    }
    ((k)localObject).onActivityResume();
    AppMethodBeat.o(264087);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(166739);
    com.tencent.mm.kernel.h.aGY().b(3820, (com.tencent.mm.an.i)this);
    int j = this.xMG.size();
    int i = this.xMG.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      f.Iyx.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.xNG;
      if (paramString != null) {}
      for (paramString = paramString.xea; paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166739);
        throw paramString;
      }
      paramq = paramString.ESJ;
      p.j(paramq, "response.infoList");
      Object localObject1 = (Iterable)paramq;
      paramq = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bip)((Iterator)localObject1).next();
        paramq.add(Boolean.valueOf(this.xMG.add(localObject2)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.xHE = paramString.xHE;
      paramInt2 = this.xMG.size();
      Log.i(this.TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.xMG.size());
      paramq = this.query;
      boolean bool = paramString.ESJ.isEmpty();
      i = this.uMD;
      if (bool)
      {
        paramInt1 = 1;
        paramString = com.tencent.mm.plugin.finder.report.n.zWF;
        paramString = com.tencent.mm.plugin.finder.report.n.zWF;
        localObject1 = com.tencent.mm.plugin.finder.report.n.dPC();
        localObject2 = this.fIY;
        paramString = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramString = getContext();
        p.j(paramString, "context");
        paramString = com.tencent.mm.plugin.finder.viewmodel.component.aj.a.fZ((Context)paramString);
        if (paramString == null) {
          break label510;
        }
        paramString = paramString.ekY();
        label361:
        com.tencent.mm.plugin.finder.report.n.a((String)localObject1, (String)localObject2, paramq, 2, i, 2, paramInt1, 1, paramString);
        paramInt1 = paramInt2;
        label379:
        paramString = this.xvJ;
        if (paramString == null) {
          p.bGy("rlLayout");
        }
        paramString.azs(0);
        if (paramInt1 != 0) {
          break label535;
        }
        paramString = this.kGT;
        if (paramString == null) {
          p.bGy("loadingView");
        }
        paramString.setVisibility(8);
        paramString = this.xND;
        if (paramString == null) {
          p.bGy("noResultView");
        }
        paramString.setVisibility(0);
        paramString = this.xvJ;
        if (paramString == null) {
          p.bGy("rlLayout");
        }
        paramString.setVisibility(8);
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        paramString = this.jLl;
        if (paramString == null) {
          p.bGy("recyclerView");
        }
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.notifyDataSetChanged();
          AppMethodBeat.o(166739);
          return;
          paramInt1 = 2;
          break;
          label510:
          paramString = null;
          break label361;
          f.Iyx.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break label379;
          label535:
          paramString = this.kGT;
          if (paramString == null) {
            p.bGy("loadingView");
          }
          paramString.setVisibility(8);
          paramString = this.xND;
          if (paramString == null) {
            p.bGy("noResultView");
          }
          paramString.setVisibility(8);
          paramString = this.xvJ;
          if (paramString == null) {
            p.bGy("rlLayout");
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
      paramString = this.jLl;
      if (paramString == null) {
        p.bGy("recyclerView");
      }
      if (paramString != null)
      {
        paramString = paramString.getAdapter();
        if (paramString != null)
        {
          paramString.aG(j, paramInt1 - j);
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
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isForceNightMode", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;Z)V", "()Z", "bindData", "", "holder", "position", "", "bindImage", "getData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class a
    extends RecyclerView.a<RecyclerView.v>
  {
    private final boolean xnL;
    
    public a()
    {
      boolean bool;
      this.xnL = bool;
    }
    
    private final void i(RecyclerView.v paramv, final int paramInt)
    {
      AppMethodBeat.i(290259);
      Object localObject1 = FinderContactSearchUI.a(FinderContactSearchUI.this).get(paramInt);
      p.j(localObject1, "contactList[position]");
      bip localbip = (bip)localObject1;
      Object localObject2 = FinderContactSearchUI.this;
      localObject1 = localbip.contact;
      if (localObject1 != null) {}
      for (localObject1 = ((FinderContact)localObject1).username;; localObject1 = null)
      {
        FinderContactSearchUI.a((FinderContactSearchUI)localObject2, (String)localObject1, paramInt);
        if (paramv != null) {
          break;
        }
        paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
        AppMethodBeat.o(290259);
        throw paramv;
      }
      paramv = (c)paramv;
      localObject1 = (View.OnClickListener)new a(this, paramInt);
      localObject2 = (View.OnLongClickListener)new b(this);
      if (paramInt != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramv.a(localbip, (View.OnClickListener)localObject1, (View.OnLongClickListener)localObject2, bool);
        AppMethodBeat.o(290259);
        return;
      }
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(290257);
      p.k(paramv, "holder");
      p.k(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(290257);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(290256);
      p.k(paramViewGroup, "parent");
      Object localObject = FinderContactSearchUI.this.getContext();
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((AppCompatActivity)localObject).getLayoutInflater();
      if (this.xnL) {}
      for (paramInt = b.g.finder_contact_search_item_night_mode;; paramInt = b.g.finder_contact_search_item)
      {
        paramViewGroup = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
        p.j(paramViewGroup, "contactLayout");
        if (!this.xnL) {
          bool = true;
        }
        paramViewGroup = (RecyclerView.v)new c(paramViewGroup, bool);
        AppMethodBeat.o(290256);
        return paramViewGroup;
      }
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(290260);
      p.k(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(290260);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166721);
      int i = FinderContactSearchUI.a(FinderContactSearchUI.this).size();
      AppMethodBeat.o(166721);
      return i;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchUI.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(166720);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        p.j(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(166720);
          throw paramView;
        }
        bip localbip = (bip)paramView;
        FinderContactSearchUI localFinderContactSearchUI = this.Aaf.Aae;
        int i = paramInt;
        p.k(localbip, "finderSearchInfo");
        if (localFinderContactSearchUI.zZU)
        {
          Log.i(localFinderContactSearchUI.TAG, "onContactItemClick select atContact");
          paramView = e.ACV;
          localObject1 = localbip.contact;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = new FinderContact();
          }
          paramView = e.f(paramView);
          localFinderContactSearchUI.getIntent().putExtra("at_select_contact", paramView.toByteArray());
          localFinderContactSearchUI.setResult(-1, localFinderContactSearchUI.getIntent());
          localFinderContactSearchUI.finish();
        }
        label466:
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(166720);
          return;
          paramView = localbip.contact;
          if ((paramView != null) && (paramView.liveStatus == 1))
          {
            localObject2 = com.tencent.mm.plugin.finder.live.report.k.yBj;
            paramView = localbip.contact;
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
            ((com.tencent.mm.plugin.finder.live.report.k)localObject2).a(null, paramView, i, s.t.yGP, s.l.yFR.scene);
          }
          Object localObject2 = new Intent();
          paramView = localbip.contact;
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
          paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramView = localFinderContactSearchUI.getContext();
          p.j(paramView, "context");
          com.tencent.mm.plugin.finder.viewmodel.component.aj.a.a((Context)paramView, (Intent)localObject2, 0L, 7, false, 64);
          paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
          paramView = localFinderContactSearchUI.getContext();
          p.j(paramView, "context");
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)paramView, (Intent)localObject2);
          int j = localFinderContactSearchUI.uMD;
          paramView = com.tencent.mm.plugin.finder.report.n.zWF;
          localObject2 = localFinderContactSearchUI.fIY;
          String str1 = localFinderContactSearchUI.query;
          paramView = localbip.contact;
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
          localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
          String str2 = com.tencent.mm.plugin.finder.report.n.dPC();
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          localObject1 = localFinderContactSearchUI.getContext();
          p.j(localObject1, "context");
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a.fZ((Context)localObject1);
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();
          com.tencent.mm.plugin.finder.report.n.a((String)localObject2, str1, 1, 1, paramView, i, 2, str2, j, (bid)localObject1);
          paramView = com.tencent.mm.plugin.finder.report.n.zWF;
          localObject2 = localFinderContactSearchUI.fIY;
          str1 = localFinderContactSearchUI.query;
          paramView = localbip.contact;
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
          localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
          str2 = com.tencent.mm.plugin.finder.report.n.dPC();
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          localObject1 = localFinderContactSearchUI.getContext();
          p.j(localObject1, "context");
          localObject1 = com.tencent.mm.plugin.finder.viewmodel.component.aj.a.fZ((Context)localObject1);
          if (localObject1 == null) {
            break label668;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject1).ekY();
          com.tencent.mm.plugin.finder.report.n.a((String)localObject2, str1, 1, 1, paramView, i, 2, str2, 2, j, (bid)localObject1);
          paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
          paramView = localFinderContactSearchUI.getContext();
          p.j(paramView, "context");
          paramView = com.tencent.mm.plugin.finder.viewmodel.component.aj.a.fZ((Context)paramView);
        } while (paramView == null);
        label579:
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        i = paramView.xkX;
        paramView = localbip.contact;
        if (paramView != null) {}
        for (paramView = paramView.username;; paramView = null)
        {
          com.tencent.mm.plugin.finder.report.n.a(6, 0L, i, 1, paramView);
          break;
          localObject1 = null;
          break label466;
          label668:
          localObject1 = null;
          break label579;
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class b
      implements View.OnLongClickListener
    {
      b(FinderContactSearchUI.a parama) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(271341);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        localObject = this.Aaf.Aae;
        p.j(paramView, "it");
        ((FinderContactSearchUI)localObject).onContactItemLongClick(paramView);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter$bindData$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(271341);
        return true;
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$FinderFeedSearchReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
  public final class b
    extends d
  {
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(166726);
      p.k(paramb, "event");
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        int i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrh;
        int j = ((com.tencent.mm.plugin.finder.event.base.h)paramb).xrj;
        if (i <= j)
        {
          FinderContactSearchUI localFinderContactSearchUI = this.Aae;
          paramb = ((bip)FinderContactSearchUI.a(this.Aae).get(i)).contact;
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
    
    public final boolean dpw()
    {
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedContactChangeEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class c
    extends IListener<hm>
  {
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderContactSearchUI.c paramc, hm paramhm)
      {
        super();
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderContactSearchUI paramFinderContactSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(166727);
      FinderContactSearchUI.c(this.Aae).getFtsEditText().hUu();
      this.Aae.hideVKB();
      AppMethodBeat.o(166727);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(285238);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(285238);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(285240);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(285240);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(166728);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.i(FinderContactSearchUI.d(this.Aae), "onLoadMoreBegin");
      Object localObject = FinderContactSearchUI.f(this.Aae);
      if (localObject != null)
      {
        if (FinderContactSearchUI.g(this.Aae) != 1) {
          break label257;
        }
        FinderContactSearchUI.a(this.Aae, new cj((String)localObject, FinderContactSearchUI.i(this.Aae), FinderContactSearchUI.j(this.Aae), FinderContactSearchUI.k(this.Aae), FinderContactSearchUI.l(this.Aae), null, null, null, 480));
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)FinderContactSearchUI.h(this.Aae));
        com.tencent.mm.kernel.h.aGY().a(3820, (com.tencent.mm.an.i)this.Aae);
        localObject = FinderContactSearchUI.m(this.Aae).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_footer_tip);
          }
        }
        localObject = FinderContactSearchUI.m(this.Aae).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderContactSearchUI.m(this.Aae).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(b.f.load_more_footer_end_layout);
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
        label257:
        localObject = FinderContactSearchUI.m(this.Aae).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_no_result_tip);
          }
        }
        localObject = FinderContactSearchUI.m(this.Aae).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderContactSearchUI.m(this.Aae).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = ((View)localObject).findViewById(b.f.load_more_footer_end_layout);
          if (localObject != null) {
            ((View)localObject).setVisibility(0);
          }
        }
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(285239);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(285239);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "query", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    f(FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initData$3", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "onClear", "", "plugin-finder_release"})
  public static final class g
    implements l
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "suggestion", "", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    h(FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class i
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(287391);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(287391);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287390);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
      com.tencent.mm.plugin.finder.live.report.k.b(paramRecyclerView, s.t.yGM, s.l.yFR.scene, com.tencent.mm.plugin.finder.live.report.c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(287390);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$onContactItemLongClick$1", "Landroid/view/View$OnCreateContextMenuListener;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"})
  public static final class j
    implements View.OnCreateContextMenuListener
  {
    j(aa.d paramd) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(288446);
      if (paramContextMenu != null)
      {
        paramContextMenu.add(0, this.Aah.aaBA, 0, b.j.finder_mod_block_poster_del);
        AppMethodBeat.o(288446);
        return;
      }
      AppMethodBeat.o(288446);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$onContactItemLongClick$2", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"})
  public static final class k
    implements q.g
  {
    k(int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(289231);
      if ((i >= 0) && (i < FinderContactSearchUI.a(this.Aae).size()))
      {
        paramMenuItem = (bip)FinderContactSearchUI.a(this.Aae).get(i);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.contact;
          if (paramMenuItem != null)
          {
            com.tencent.mm.plugin.finder.storage.c localc = new com.tencent.mm.plugin.finder.storage.c();
            p.j(paramMenuItem, "it");
            localc.a(paramMenuItem, (com.tencent.mm.plugin.finder.storage.aj.a)new a(this));
            AppMethodBeat.o(289231);
            return;
          }
        }
      }
      AppMethodBeat.o(289231);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$onContactItemLongClick$2$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onDel", "", "success", "", "plugin-finder_release"})
    public static final class a
      implements com.tencent.mm.plugin.finder.storage.aj.a
    {
      a(FinderContactSearchUI.k paramk) {}
      
      public final void pX(boolean paramBoolean)
      {
        AppMethodBeat.i(289261);
        if (paramBoolean)
        {
          FinderContactSearchUI.a(this.Aai.Aae).remove(this.Aai.zMM);
          RecyclerView.a locala = FinderContactSearchUI.n(this.Aai.Aae).getAdapter();
          if (locala != null)
          {
            locala.cN(this.Aai.zMM);
            AppMethodBeat.o(289261);
            return;
          }
          AppMethodBeat.o(289261);
          return;
        }
        com.tencent.mm.ui.base.w.makeText((Context)this.Aai.Aae.getContext(), (CharSequence)"failed", 0).show();
        AppMethodBeat.o(289261);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchUI
 * JD-Core Version:    0.7.0.1
 */