package com.tencent.mm.plugin.finder.search;

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
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.hx;
import com.tencent.mm.plugin.finder.cgi.dk;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.ar.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.component.az;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.v;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
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
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "contactChangelistener", "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$contactChangelistener$1;", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "eventDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "isForceNightMode", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mOnHellScrollListener", "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchSuggestionManager", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;", "searchType", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "adapteNightMode", "", "addExposeItem", "id", "position", "type", "getCommentScene", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initContentView", "initData", "initSearchView", "initSuggestion", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onContactItemLongClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearch", "isAccountEmpty", "reportSearchExpose", "needClear", "startSearch", "ContactSearchProfileAdapter", "FinderFeedSearchReporter", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderContactSearchUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, FTSEditTextView.c, FTSSearchView.b
{
  private boolean ALp;
  private final com.tencent.mm.plugin.finder.event.base.c ANW;
  private RefreshLoadMoreLayout ATx;
  private com.tencent.mm.bx.b BgS;
  private ArrayList<buy> BmO;
  private TextView BnA;
  private j BnB;
  private l BnC;
  private dk BnD;
  private FTSSearchView Bny;
  private boolean FvC;
  boolean FvD;
  private HashMap<String, a> FvE;
  private final contactChangelistener.1 FvJ;
  private final g FvK;
  final String TAG;
  private int continueFlag;
  String hOG;
  private RecyclerView mkw;
  private View njN;
  private int offset;
  private int pyl;
  String query;
  private int requestType;
  int xVf;
  
  public FinderContactSearchUI()
  {
    AppMethodBeat.i(166742);
    this.TAG = "Finder.FinderContactSearchUI";
    this.query = "";
    this.BmO = new ArrayList();
    this.hOG = "";
    this.FvC = true;
    this.FvE = new HashMap();
    this.xVf = 1;
    this.ANW = new com.tencent.mm.plugin.finder.event.base.c();
    this.FvJ = new IListener(com.tencent.mm.app.f.hfK)
    {
      @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
      static final class a
        extends u
        implements kotlin.g.a.a<ah>
      {
        a(hx paramhx, FinderContactSearchUI paramFinderContactSearchUI)
        {
          super();
        }
      }
    };
    this.FvK = new g();
    AppMethodBeat.o(166742);
  }
  
  private static final boolean a(FinderContactSearchUI paramFinderContactSearchUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342477);
    kotlin.g.b.s.u(paramFinderContactSearchUI, "this$0");
    paramMotionEvent = paramFinderContactSearchUI.Bny;
    paramView = paramMotionEvent;
    if (paramMotionEvent == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().dzv.clearFocus();
    paramFinderContactSearchUI.hideVKB();
    AppMethodBeat.o(342477);
    return false;
  }
  
  private final void awg(String paramString)
  {
    AppMethodBeat.i(166738);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.BgS = null;
    this.BmO.clear();
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
    localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(166738);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean aWU()
  {
    Object localObject2 = null;
    AppMethodBeat.i(166736);
    hideVKB();
    Object localObject3 = this.Bny;
    Object localObject1 = localObject3;
    if (localObject3 == null)
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
      AppMethodBeat.o(166736);
      return true;
      localObject3 = n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = "";
      }
    }
    this.xVf = 1;
    awg((String)localObject1);
    localObject3 = this.BnB;
    if (localObject3 != null) {
      ((j)localObject3).azd((String)localObject1);
    }
    localObject1 = this.BnC;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("searchSuggestionManager");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((l)localObject1).ePg();
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 9L, 1L, false);
      AppMethodBeat.o(166736);
      return false;
    }
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(166734);
    if (paramBoolean)
    {
      com.tencent.mm.plugin.finder.report.aa localaa = com.tencent.mm.plugin.finder.report.aa.Fsi;
      com.tencent.mm.plugin.finder.report.aa.eMZ();
    }
    AppMethodBeat.o(166734);
  }
  
  public final int getCommentScene()
  {
    return 6;
  }
  
  public final int getLayoutId()
  {
    if (this.ALp) {
      return e.f.finder_contact_search_ui_night_mode;
    }
    return e.f.finder_contact_search_ui;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(342608);
    Set localSet = ar.setOf(az.class);
    AppMethodBeat.o(342608);
    return localSet;
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
    FTSSearchView localFTSSearchView = this.Bny;
    paramView = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().aWT();
    showVKB();
    AppMethodBeat.o(166735);
  }
  
  public final void onContactItemLongClick(View paramView)
  {
    AppMethodBeat.i(342700);
    kotlin.g.b.s.u(paramView, "view");
    if (this.requestType == 8)
    {
      com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a((Context)getContext());
      if (this.mkw == null) {
        kotlin.g.b.s.bIx("recyclerView");
      }
      int i = RecyclerView.bA(paramView);
      Object localObject = new ah.d();
      ((ah.d)localObject).aixb = 1;
      localObject = (View.OnCreateContextMenuListener)new h((ah.d)localObject);
      u.i locali = (u.i)new i(i, this);
      TouchableLayout.a locala1 = TouchableLayout.agKp;
      int j = TouchableLayout.jMn();
      locala1 = TouchableLayout.agKp;
      locala.a(paramView, i, 0L, (View.OnCreateContextMenuListener)localObject, locali, j, TouchableLayout.jMo());
      locala.cMz();
    }
    AppMethodBeat.o(342700);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(166730);
    super.onCreate(paramBundle);
    this.ALp = getIntent().getBooleanExtra("is_force_night_mode", false);
    if (this.ALp)
    {
      getController().setActionbarColor(getContext().getResources().getColor(e.b.Dark_0));
      setBackGroundColorResource(e.b.Dark_0);
    }
    this.Bny = new FTSSearchView((Context)this, this.ALp);
    paramBundle = this.Bny;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
    }
    Object localObject3;
    for (;;)
    {
      paramBundle.setSearchViewListener((FTSSearchView.b)this);
      localObject2 = this.Bny;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setHint(getString(e.h.app_search));
      localObject2 = this.Bny;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.c)this);
      localObject2 = this.Bny;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setCanDeleteTag(false);
      localObject2 = this.Bny;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().jBL();
      localObject3 = getSupportActionBar();
      kotlin.g.b.s.checkNotNull(localObject3);
      localObject2 = this.Bny;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      ((ActionBar)localObject3).setCustomView((View)paramBundle);
      this.requestType = getIntent().getIntExtra("request_type", 2);
      this.FvD = getIntent().getBooleanExtra("from_at_contact", false);
      this.FvC = getIntent().getBooleanExtra("need_history", true);
      paramBundle = k.FxZ;
      if (k.ePe() == null) {
        break;
      }
      paramBundle = k.FxZ;
      localObject3 = k.ePe();
      kotlin.g.b.s.checkNotNull(localObject3);
      paramBundle = k.FxZ;
      k.a(null);
      localObject2 = ((axg)localObject3).hOG;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null) {
        paramBundle = "";
      }
      this.hOG = paramBundle;
      localObject2 = ((axg)localObject3).query;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null) {
        paramBundle = "";
      }
      this.query = paramBundle;
      this.offset = ((axg)localObject3).offset;
      this.continueFlag = ((axg)localObject3).continueFlag;
      this.BgS = ((axg)localObject3).BgS;
      this.pyl = ((axg)localObject3).ERV;
      paramBundle = ((axg)localObject3).ZIt;
      kotlin.g.b.s.s(paramBundle, "finderFeedObj.contactList");
      localObject2 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (buy)((Iterator)localObject2).next();
        paramBundle.add(Boolean.valueOf(this.BmO.add(localObject3)));
      }
    }
    paramBundle = UUID.randomUUID().toString();
    kotlin.g.b.s.s(paramBundle, "randomUUID().toString()");
    this.hOG = paramBundle;
    this.query = "";
    Object localObject2 = this.Bny;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
    }
    paramBundle.getFtsEditText().aWT();
    localObject2 = this.Bny;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
    }
    paramBundle.getFtsEditText().aWS();
    if (this.FvC) {
      this.BnB = new j((MMActivity)this, false, this.ALp, (kotlin.g.a.b)new d(this), (m)new e());
    }
    for (;;)
    {
      if (this.FvD) {
        setResult(0, getIntent());
      }
      Log.i(this.TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.FvD) });
      localObject3 = (MMActivity)this;
      localObject2 = this.Bny;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle = paramBundle.getFtsEditText();
      kotlin.g.b.s.s(paramBundle, "searchView.ftsEditText");
      this.BnC = new l((MMActivity)localObject3, paramBundle, 0, 2, false, this.ALp, (kotlin.g.a.b)new f(this));
      paramBundle = getContext().findViewById(e.e.rl_layout);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.ATx = ((RefreshLoadMoreLayout)paramBundle);
      localObject2 = this.ATx;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
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
      if (!this.ALp) {
        break label991;
      }
      localObject3 = getContext().findViewById(e.e.main_rv);
      if (localObject3 != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(166730);
      throw paramBundle;
      findViewById(e.e.history_lv).setVisibility(8);
    }
    localObject2 = this.ATx;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
    }
    paramBundle.setBackgroundColor(getContext().getResources().getColor(e.b.Dark_0));
    ((View)localObject3).setBackgroundColor(getContext().getResources().getColor(e.b.Dark_0));
    label991:
    localObject2 = new FinderLinearLayoutManager((Context)this);
    paramBundle = this.mkw;
    label1047:
    label1198:
    int i;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)localObject2);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1551;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      paramBundle.setAdapter((RecyclerView.a)new a(this.ALp));
      localObject2 = this.mkw;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setHasFixedSize(true);
      localObject2 = this.mkw;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setItemViewCacheSize(5);
      localObject2 = this.mkw;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setOnTouchListener(new FinderContactSearchUI..ExternalSyntheticLambda0(this));
      localObject2 = this.ATx;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramBundle = null;
      }
      paramBundle.setEnablePullDownHeader(false);
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label1554;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
      localObject2 = af.mU((Context)getContext());
      if (!this.ALp) {
        break label1557;
      }
      i = e.f.load_more_footer_night_mode;
      label1221:
      localObject2 = ((LayoutInflater)localObject2).inflate(i, null);
      kotlin.g.b.s.s(localObject2, "getInflater(context).inf…oter\n            }, null)");
      paramBundle.setLoadMoreFooter((View)localObject2);
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label1564;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
      label1261:
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new c(this));
      localObject3 = this.query;
      if (localObject3 != null)
      {
        localObject2 = this.BnC;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("searchSuggestionManager");
          paramBundle = null;
        }
        paramBundle.aAj((String)localObject3);
        localObject2 = this.Bny;
        paramBundle = (Bundle)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getFtsEditText().V((String)localObject3, null);
      }
      localObject2 = this.mkw;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.bZE.notifyChanged();
      }
      localObject2 = this.mkw;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      localObject2 = com.tencent.mm.hellhoundlib.b.c.a(this.pyl, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      this.ANW.a((com.tencent.mm.plugin.finder.event.base.d)new b());
      this.FvJ.alive();
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1567;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = localObject1;
    }
    label1551:
    label1554:
    label1557:
    label1564:
    label1567:
    for (;;)
    {
      paramBundle.a((RecyclerView.l)this.FvK);
      AppMethodBeat.o(166730);
      return;
      break;
      break label1047;
      break label1198;
      i = e.f.load_more_footer;
      break label1221;
      break label1261;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166737);
    this.FvJ.dead();
    Object localObject = this.BnB;
    if (localObject != null) {
      ((j)localObject).onDestroy();
    }
    this.ANW.onRelease();
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    localObject = this.mkw;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      localObject = null;
    }
    for (;;)
    {
      ((RecyclerView)localObject).b((RecyclerView.l)this.FvK);
      super.onDestroy();
      AppMethodBeat.o(166737);
      return;
    }
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    paramList = null;
    AppMethodBeat.i(166733);
    if (paramString1 == null)
    {
      paramString1 = "";
      if (Util.isNullOrNil(paramString1))
      {
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
      }
    }
    label145:
    for (;;)
    {
      paramString2.setVisibility(8);
      paramString2 = this.BnB;
      if (paramString2 != null) {
        paramString2.aAg(paramString1);
      }
      AppMethodBeat.o(166733);
      return;
      paramString2 = n.bq((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      paramString1 = "";
      break;
    }
  }
  
  public final void onPause()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342673);
    super.onPause();
    ce localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
    RecyclerView localRecyclerView = this.mkw;
    Object localObject1 = localRecyclerView;
    if (localRecyclerView == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      localObject1 = null;
    }
    localce.b((RecyclerView)localObject1, q.w.DwO, q.n.Dtv.scene, com.tencent.mm.plugin.finder.live.report.d.Dng);
    localObject1 = this.BnC;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("searchSuggestionManager");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((l)localObject1).onActivityPause();
      AppMethodBeat.o(342673);
      return;
    }
  }
  
  public final void onResume()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342665);
    super.onResume();
    ce localce = (ce)com.tencent.mm.kernel.h.ax(ce.class);
    RecyclerView localRecyclerView = this.mkw;
    Object localObject1 = localRecyclerView;
    if (localRecyclerView == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      localObject1 = null;
    }
    localce.b((RecyclerView)localObject1, q.w.DwO, q.n.Dtv.scene, com.tencent.mm.plugin.finder.live.report.d.Dnf);
    localObject1 = this.BnC;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("searchSuggestionManager");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((l)localObject1).onActivityResume();
      AppMethodBeat.o(342665);
      return;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(166739);
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    int j = this.BmO.size();
    int i = this.BmO.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.BnD;
      if (paramString == null) {}
      for (paramString = null; paramString == null; paramString = paramString.ADk)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(166739);
        throw paramString;
      }
      paramp = paramString.KNn;
      kotlin.g.b.s.s(paramp, "response.infoList");
      Object localObject1 = (Iterable)paramp;
      paramp = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (buy)((Iterator)localObject1).next();
        paramp.add(Boolean.valueOf(this.BmO.add(localObject2)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.BgS = paramString.BgS;
      paramInt2 = this.BmO.size();
      Log.i(this.TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.BmO.size());
      paramp = this.query;
      boolean bool = paramString.KNn.isEmpty();
      i = this.xVf;
      if (bool)
      {
        paramInt1 = 1;
        paramString = z.FrZ;
        paramString = z.FrZ;
        localObject1 = z.eMW();
        localObject2 = this.hOG;
        paramString = as.GSQ;
        paramString = getContext();
        kotlin.g.b.s.s(paramString, "context");
        paramString = as.a.hu((Context)paramString);
        if (paramString != null) {
          break label545;
        }
        paramString = null;
        label358:
        z.a((String)localObject1, (String)localObject2, paramp, 2, i, 2, paramInt1, 1, paramString);
        paramInt1 = paramInt2;
        label376:
        paramp = this.ATx;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          paramString = null;
        }
        paramString.aFW(0);
        if (paramInt1 != 0) {
          break label573;
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
    }
    for (;;)
    {
      if (j != 0) {
        break label659;
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
        break label706;
      }
      paramString.bZE.notifyChanged();
      AppMethodBeat.o(166739);
      return;
      paramInt1 = 2;
      break;
      label545:
      paramString = paramString.fou();
      break label358;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 11L, 1L, false);
      paramInt1 = i;
      break label376;
      label573:
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
    }
    label659:
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
    label706:
    AppMethodBeat.o(166739);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mm/plugin/findersdk/api/IContactSearchProfileAdapter;", "isForceNightMode", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;Z)V", "()Z", "bindData", "", "holder", "position", "", "bindImage", "getData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "getItemCount", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends RecyclerView.a<RecyclerView.v>
    implements v
  {
    private final boolean ALp;
    
    public a()
    {
      AppMethodBeat.i(342509);
      boolean bool;
      this.ALp = bool;
      AppMethodBeat.o(342509);
    }
    
    private static final void a(FinderContactSearchUI paramFinderContactSearchUI, int paramInt, View paramView)
    {
      AppMethodBeat.i(342530);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderContactSearchUI);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).sc(paramInt);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      kotlin.g.b.s.u(paramFinderContactSearchUI, "this$0");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramFinderContactSearchUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
        AppMethodBeat.o(342530);
        throw paramFinderContactSearchUI;
      }
      localObject2 = (buy)paramView;
      kotlin.g.b.s.u(localObject2, "finderSearchInfo");
      if (paramFinderContactSearchUI.FvD)
      {
        Log.i(paramFinderContactSearchUI.TAG, "onContactItemClick select atContact");
        paramView = com.tencent.mm.plugin.finder.utils.h.Gga;
        localObject1 = ((buy)localObject2).contact;
        paramView = (View)localObject1;
        if (localObject1 == null) {
          paramView = new FinderContact();
        }
        paramView = com.tencent.mm.plugin.finder.utils.h.i(paramView);
        localObject1 = paramFinderContactSearchUI.getIntent();
        if (paramView == null)
        {
          paramView = null;
          ((Intent)localObject1).putExtra("at_select_contact", paramView);
          paramFinderContactSearchUI.setResult(-1, paramFinderContactSearchUI.getIntent());
          paramFinderContactSearchUI.finish();
        }
      }
      int i;
      label238:
      boolean bool;
      label265:
      label307:
      label336:
      label484:
      do
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(342530);
        return;
        paramView = paramView.toByteArray();
        break;
        paramView = ((buy)localObject2).contact;
        if ((paramView == null) || (paramView.liveStatus != 1)) {
          break label654;
        }
        i = 1;
        if (i != 0)
        {
          localObject3 = (ce)com.tencent.mm.kernel.h.ax(ce.class);
          paramView = ((buy)localObject2).contact;
          if (paramView != null) {
            break label659;
          }
          paramView = "";
          ((ce)localObject3).a(null, paramView, paramInt, q.w.DwR, q.n.Dtv.scene);
        }
        Object localObject3 = new Intent();
        paramView = ((buy)localObject2).contact;
        if (paramView != null) {
          break label679;
        }
        paramView = "";
        ((Intent)localObject3).putExtra("finder_username", paramView);
        paramView = ((buy)localObject2).contact;
        if ((paramView == null) || (com.tencent.mm.plugin.finder.api.c.c(paramView))) {
          break label699;
        }
        bool = true;
        ((Intent)localObject3).putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", bool);
        paramView = as.GSQ;
        paramView = paramFinderContactSearchUI.getContext();
        kotlin.g.b.s.s(paramView, "context");
        as.a.a((Context)paramView, (Intent)localObject3, 0L, 7, false, 64);
        paramView = com.tencent.mm.plugin.finder.utils.a.GfO;
        localObject1 = paramFinderContactSearchUI.getContext();
        kotlin.g.b.s.s(localObject1, "context");
        paramView.enterFinderProfileUI((Context)localObject1, (Intent)localObject3);
        i = paramFinderContactSearchUI.xVf;
        paramView = z.FrZ;
        localObject3 = paramFinderContactSearchUI.hOG;
        String str1 = paramFinderContactSearchUI.query;
        paramView = ((buy)localObject2).contact;
        if (paramView != null) {
          break label705;
        }
        paramView = "";
        localObject1 = z.FrZ;
        String str2 = z.eMW();
        localObject1 = as.GSQ;
        localObject1 = paramFinderContactSearchUI.getContext();
        kotlin.g.b.s.s(localObject1, "context");
        localObject1 = as.a.hu((Context)localObject1);
        if (localObject1 != null) {
          break label725;
        }
        localObject1 = null;
        z.a((String)localObject3, str1, 1, 1, paramView, paramInt, 2, str2, i, (bui)localObject1);
        paramView = z.FrZ;
        localObject3 = paramFinderContactSearchUI.hOG;
        str1 = paramFinderContactSearchUI.query;
        paramView = ((buy)localObject2).contact;
        if (paramView != null) {
          break label735;
        }
        paramView = "";
        localObject1 = z.FrZ;
        str2 = z.eMW();
        localObject1 = as.GSQ;
        localObject1 = paramFinderContactSearchUI.getContext();
        kotlin.g.b.s.s(localObject1, "context");
        localObject1 = as.a.hu((Context)localObject1);
        if (localObject1 != null) {
          break label755;
        }
        localObject1 = null;
        z.a((String)localObject3, str1, 1, 1, paramView, paramInt, 2, str2, 2, i, (bui)localObject1);
        paramView = as.GSQ;
        paramFinderContactSearchUI = paramFinderContactSearchUI.getContext();
        kotlin.g.b.s.s(paramFinderContactSearchUI, "context");
        paramFinderContactSearchUI = as.a.hu((Context)paramFinderContactSearchUI);
      } while (paramFinderContactSearchUI == null);
      label438:
      label576:
      paramView = z.FrZ;
      label530:
      paramInt = paramFinderContactSearchUI.AJo;
      paramFinderContactSearchUI = ((buy)localObject2).contact;
      if (paramFinderContactSearchUI == null) {}
      for (paramFinderContactSearchUI = null;; paramFinderContactSearchUI = paramFinderContactSearchUI.username)
      {
        z.a(6, 0L, paramInt, 1, paramFinderContactSearchUI);
        break;
        label654:
        i = 0;
        break label238;
        label659:
        localObject1 = paramView.username;
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label265;
        }
        paramView = "";
        break label265;
        label679:
        localObject1 = paramView.username;
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label307;
        }
        paramView = "";
        break label307;
        label699:
        bool = false;
        break label336;
        label705:
        localObject1 = paramView.username;
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label438;
        }
        paramView = "";
        break label438;
        label725:
        localObject1 = ((as)localObject1).fou();
        break label484;
        label735:
        localObject1 = paramView.username;
        paramView = (View)localObject1;
        if (localObject1 != null) {
          break label530;
        }
        paramView = "";
        break label530;
        label755:
        localObject1 = ((as)localObject1).fou();
        break label576;
      }
    }
    
    private static final boolean a(FinderContactSearchUI paramFinderContactSearchUI, View paramView)
    {
      AppMethodBeat.i(342539);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderContactSearchUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
      kotlin.g.b.s.u(paramFinderContactSearchUI, "this$0");
      kotlin.g.b.s.s(paramView, "it");
      paramFinderContactSearchUI.onContactItemLongClick(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$ContactSearchProfileAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(342539);
      return true;
    }
    
    private final void i(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(342517);
      Object localObject1 = FinderContactSearchUI.m(FinderContactSearchUI.this).get(paramInt);
      kotlin.g.b.s.s(localObject1, "contactList[position]");
      buy localbuy = (buy)localObject1;
      Object localObject2 = FinderContactSearchUI.this;
      localObject1 = localbuy.contact;
      if (localObject1 == null)
      {
        localObject1 = null;
        FinderContactSearchUI.a((FinderContactSearchUI)localObject2, (String)localObject1, paramInt);
        paramv = (d)paramv;
        localObject1 = new FinderContactSearchUI.a..ExternalSyntheticLambda0(FinderContactSearchUI.this, paramInt);
        localObject2 = new FinderContactSearchUI.a..ExternalSyntheticLambda1(FinderContactSearchUI.this);
        if (paramInt == 0) {
          break label129;
        }
      }
      label129:
      for (boolean bool = true;; bool = false)
      {
        paramv.a(localbuy, (View.OnClickListener)localObject1, (View.OnLongClickListener)localObject2, bool);
        AppMethodBeat.o(342517);
        return;
        localObject1 = ((FinderContact)localObject1).username;
        break;
      }
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(342575);
      kotlin.g.b.s.u(paramv, "holder");
      kotlin.g.b.s.u(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(342575);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      boolean bool = false;
      AppMethodBeat.i(342569);
      kotlin.g.b.s.u(paramViewGroup, "parent");
      Object localObject = FinderContactSearchUI.this.getContext();
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((AppCompatActivity)localObject).getLayoutInflater();
      if (this.ALp) {}
      for (paramInt = e.f.finder_contact_search_item_night_mode;; paramInt = e.f.finder_contact_search_item)
      {
        paramViewGroup = ((LayoutInflater)localObject).inflate(paramInt, paramViewGroup, false);
        kotlin.g.b.s.s(paramViewGroup, "contactLayout");
        if (!this.ALp) {
          bool = true;
        }
        paramViewGroup = (RecyclerView.v)new d(paramViewGroup, bool);
        AppMethodBeat.o(342569);
        return paramViewGroup;
      }
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(342581);
      kotlin.g.b.s.u(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(342581);
    }
    
    public final ArrayList<buy> dwi()
    {
      AppMethodBeat.i(342585);
      ArrayList localArrayList = FinderContactSearchUI.m(FinderContactSearchUI.this);
      AppMethodBeat.o(342585);
      return localArrayList;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(166721);
      int i = FinderContactSearchUI.m(FinderContactSearchUI.this).size();
      AppMethodBeat.o(166721);
      return i;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI$FinderFeedSearchReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchUI;)V", "isAsync", "", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.event.base.d
  {
    public b()
    {
      AppMethodBeat.i(342671);
      AppMethodBeat.o(342671);
    }
    
    public final void a(com.tencent.mm.plugin.finder.event.base.b paramb)
    {
      AppMethodBeat.i(166726);
      kotlin.g.b.s.u(paramb, "event");
      int i;
      int j;
      if ((paramb instanceof com.tencent.mm.plugin.finder.event.base.h))
      {
        i = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOr;
        j = ((com.tencent.mm.plugin.finder.event.base.h)paramb).AOt;
        if (i > j) {}
      }
      for (;;)
      {
        FinderContactSearchUI localFinderContactSearchUI = this.FvL;
        paramb = ((buy)FinderContactSearchUI.m(this.FvL).get(i)).contact;
        if (paramb == null) {}
        for (paramb = null;; paramb = paramb.username)
        {
          FinderContactSearchUI.a(localFinderContactSearchUI, paramb, i);
          if (i != j) {
            break;
          }
          AppMethodBeat.o(166726);
          return;
        }
        i += 1;
      }
    }
    
    public final boolean dXA()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RefreshLoadMoreLayout.b
  {
    c(FinderContactSearchUI paramFinderContactSearchUI) {}
    
    public final void qI(int paramInt)
    {
      RefreshLoadMoreLayout localRefreshLoadMoreLayout2 = null;
      RefreshLoadMoreLayout localRefreshLoadMoreLayout1 = null;
      AppMethodBeat.i(342660);
      Log.i(FinderContactSearchUI.c(this.FvL), "onLoadMoreBegin");
      Object localObject = FinderContactSearchUI.e(this.FvL);
      if (localObject != null)
      {
        FinderContactSearchUI localFinderContactSearchUI = this.FvL;
        if (FinderContactSearchUI.f(localFinderContactSearchUI) == 1)
        {
          FinderContactSearchUI.a(localFinderContactSearchUI, new dk((String)localObject, FinderContactSearchUI.g(localFinderContactSearchUI), FinderContactSearchUI.h(localFinderContactSearchUI), FinderContactSearchUI.i(localFinderContactSearchUI), FinderContactSearchUI.j(localFinderContactSearchUI), null, null, null, 480));
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)FinderContactSearchUI.k(localFinderContactSearchUI), 0);
          com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)localFinderContactSearchUI);
          localRefreshLoadMoreLayout2 = FinderContactSearchUI.l(localFinderContactSearchUI);
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
          localRefreshLoadMoreLayout2 = FinderContactSearchUI.l(localFinderContactSearchUI);
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
            localRefreshLoadMoreLayout2 = FinderContactSearchUI.l(localFinderContactSearchUI);
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
            AppMethodBeat.o(342660);
            return;
            localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
            break;
          }
        }
        localRefreshLoadMoreLayout1 = FinderContactSearchUI.l(localFinderContactSearchUI);
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
        localRefreshLoadMoreLayout1 = FinderContactSearchUI.l(localFinderContactSearchUI);
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
        localRefreshLoadMoreLayout1 = FinderContactSearchUI.l(localFinderContactSearchUI);
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
        AppMethodBeat.o(342660);
        return;
        localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class contactChangelistener$1$a
    extends u
    implements kotlin.g.a.a<ah>
  {
    contactChangelistener$1$a(hx paramhx, FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "query", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    d(FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$initData$3", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "onClear", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements m
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "suggestion", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    f(FinderContactSearchUI paramFinderContactSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(342607);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(342607);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(342601);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(paramRecyclerView, q.w.DwO, q.n.Dtv.scene, com.tencent.mm.plugin.finder.live.report.d.Dne);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchUI$mOnHellScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(342601);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$onContactItemLongClick$1", "Landroid/view/View$OnCreateContextMenuListener;", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements View.OnCreateContextMenuListener
  {
    h(ah.d paramd) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(342580);
      if (paramContextMenu != null) {
        paramContextMenu.add(0, this.FvM.aixb, 0, e.h.finder_mod_block_poster_del);
      }
      AppMethodBeat.o(342580);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$onContactItemLongClick$2", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements u.i
  {
    i(int paramInt, FinderContactSearchUI paramFinderContactSearchUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, final int paramInt)
    {
      AppMethodBeat.i(342620);
      if ((this.EXC >= 0) && (this.EXC < FinderContactSearchUI.m(jdField_this).size()))
      {
        paramMenuItem = (buy)FinderContactSearchUI.m(jdField_this).get(this.EXC);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.contact;
          if (paramMenuItem != null)
          {
            FinderContactSearchUI localFinderContactSearchUI = jdField_this;
            paramInt = this.EXC;
            new com.tencent.mm.plugin.finder.storage.c().a(paramMenuItem, (ar.a)new a(localFinderContactSearchUI, paramInt));
          }
        }
      }
      AppMethodBeat.o(342620);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderContactSearchUI$onContactItemLongClick$2$onMMMenuItemSelected$1$1", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig$OnItemDelCallBack;", "onDel", "", "success", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements ar.a
    {
      a(FinderContactSearchUI paramFinderContactSearchUI, int paramInt) {}
      
      public final void tb(boolean paramBoolean)
      {
        AppMethodBeat.i(342311);
        if (paramBoolean)
        {
          FinderContactSearchUI.m(this.FvL).remove(paramInt);
          RecyclerView localRecyclerView = FinderContactSearchUI.n(this.FvL);
          Object localObject = localRecyclerView;
          if (localRecyclerView == null)
          {
            kotlin.g.b.s.bIx("recyclerView");
            localObject = null;
          }
          localObject = ((RecyclerView)localObject).getAdapter();
          if (localObject != null)
          {
            ((RecyclerView.a)localObject).fX(paramInt);
            AppMethodBeat.o(342311);
          }
        }
        else
        {
          com.tencent.mm.ui.base.aa.makeText((Context)this.FvL.getContext(), (CharSequence)"failed", 0).show();
        }
        AppMethodBeat.o(342311);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchUI
 * JD-Core Version:    0.7.0.1
 */