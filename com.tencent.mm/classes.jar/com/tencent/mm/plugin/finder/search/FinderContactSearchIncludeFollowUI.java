package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.utils.e;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
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
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "topicList", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSearchInfo;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getContactSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "isTopicSearch", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "ContactSearchProfileAdapter", "HeaderViewHolder", "plugin-finder_release"})
public final class FinderContactSearchIncludeFollowUI
  extends MMActivity
  implements com.tencent.mm.an.i, FTSEditTextView.b, a.b
{
  static final String TAG = "Finder.FinderContactSearchIncludeFollowUI";
  public static final a zZX;
  private HashMap _$_findViewCache;
  private int continueFlag;
  String fIY;
  private RecyclerView jLl;
  private View kGT;
  private int mBD;
  private View oFW;
  private int offset;
  String query;
  private int requestType;
  private com.tencent.mm.cd.b xHE;
  private ArrayList<bip> xMG;
  private com.tencent.mm.ui.search.a xNC;
  private TextView xND;
  private i xNE;
  private cj xNG;
  private RefreshLoadMoreLayout xvJ;
  private ArrayList<bkt> zZS;
  private boolean zZT;
  boolean zZU;
  HashMap<String, a> zZV;
  private CoordinatorLayout zZW;
  
  static
  {
    AppMethodBeat.i(288319);
    zZX = new a((byte)0);
    TAG = "Finder.FinderContactSearchIncludeFollowUI";
    AppMethodBeat.o(288319);
  }
  
  public FinderContactSearchIncludeFollowUI()
  {
    AppMethodBeat.i(288318);
    this.query = "";
    this.xMG = new ArrayList();
    this.zZS = new ArrayList();
    this.fIY = "";
    this.zZT = true;
    this.zZV = new HashMap();
    AppMethodBeat.o(288318);
  }
  
  private final void aEi(String paramString)
  {
    AppMethodBeat.i(288314);
    qF(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.xHE = null;
    if (this.requestType == 4) {
      this.zZS.clear();
    }
    for (;;)
    {
      Object localObject = UUID.randomUUID().toString();
      p.j(localObject, "UUID.randomUUID().toString()");
      this.fIY = ((String)localObject);
      if (this.xNG != null) {
        h.aGY().a((com.tencent.mm.an.q)this.xNG);
      }
      this.xNG = new cj(paramString, this.offset, this.fIY, this.xHE, this.requestType, null, null, null, 480);
      h.aGY().b((com.tencent.mm.an.q)this.xNG);
      h.aGY().a(3820, (com.tencent.mm.an.i)this);
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
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
      paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
      paramString = this.oFW;
      if (paramString == null) {
        p.bGy("rootView");
      }
      localObject = getContext();
      p.j(localObject, "context");
      paramString.setBackground(((AppCompatActivity)localObject).getResources().getDrawable(b.c.BG_0));
      AppMethodBeat.o(288314);
      return;
      this.xMG.clear();
    }
  }
  
  private final boolean dQD()
  {
    AppMethodBeat.i(288311);
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
        AppMethodBeat.o(288311);
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
      AppMethodBeat.o(288311);
      return true;
    }
    aEi((String)localObject1);
    Object localObject2 = this.xNE;
    if (localObject2 != null) {
      ((i)localObject2).aEn((String)localObject1);
    }
    AppMethodBeat.o(288311);
    return false;
  }
  
  private final int dQE()
  {
    AppMethodBeat.i(288316);
    Object localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (localObject != null)
      {
        i = ((RecyclerView.a)localObject).getItemCount();
        AppMethodBeat.o(288316);
        return i;
      }
    }
    int i = this.xMG.size();
    AppMethodBeat.o(288316);
    return i;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(288326);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(288326);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(288325);
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
    AppMethodBeat.o(288325);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(288306);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(288306);
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
    for (;;)
    {
      paramString2 = this.xNE;
      if (paramString2 == null) {
        break;
      }
      paramString2.aEm(paramString1);
      AppMethodBeat.o(288306);
      return;
      dQD();
    }
    AppMethodBeat.o(288306);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(288310);
    hideVKB();
    if (dQD())
    {
      AppMethodBeat.o(288310);
      return true;
    }
    f.Iyx.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(288310);
    return false;
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(288308);
    if (paramBoolean)
    {
      o localo = o.zWG;
      o.dPE();
    }
    AppMethodBeat.o(288308);
  }
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(288313);
    super.finish();
    int i = b.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(288313);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_contact_search_include_follow_ui;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(288304);
    hideVKB();
    finish();
    AppMethodBeat.o(288304);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(288305);
    hideVKB();
    finish();
    AppMethodBeat.o(288305);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(288309);
    paramView = this.xNC;
    if (paramView == null) {
      p.bGy("searchView");
    }
    paramView.getFtsEditText().aDU();
    showVKB();
    AppMethodBeat.o(288309);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(288303);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      p.j(paramBundle, "window");
      paramBundle.setStatusBarColor(getResources().getColor(b.c.transparent));
    }
    this.xNC = new com.tencent.mm.ui.search.a((Context)this);
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
    this.requestType = getIntent().getIntExtra("request_type", 3);
    this.zZU = getIntent().getBooleanExtra("from_at_contact", false);
    this.zZT = getIntent().getBooleanExtra("need_history", false);
    paramBundle = j.Acs;
    if (j.dRh() != null)
    {
      paramBundle = j.Acs;
      Object localObject2 = j.dRh();
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
    if (this.zZT)
    {
      paramBundle = getContext().findViewById(b.f.history_lv);
      p.j(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(0);
      this.xNE = new i((MMActivity)this, (kotlin.g.a.b)new f(this));
    }
    for (;;)
    {
      if (this.zZU) {
        setResult(0, getIntent());
      }
      Log.i(TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.zZU) });
      paramBundle = getContext().findViewById(b.f.root);
      p.j(paramBundle, "context.findViewById(R.id.root)");
      this.oFW = paramBundle;
      paramBundle = getContext().findViewById(b.f.main_rv);
      p.j(paramBundle, "context.findViewById(R.id.main_rv)");
      this.zZW = ((CoordinatorLayout)paramBundle);
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
      paramBundle.setAdapter((RecyclerView.a)new b((byte)0));
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
      localObject1 = ad.kS((Context)getContext()).inflate(b.g.load_more_footer, null);
      p.j(localObject1, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.xvJ;
      if (paramBundle == null) {
        p.bGy("rlLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
      paramBundle = this.query;
      if (paramBundle != null)
      {
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
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(288303);
      return;
      paramBundle = getContext().findViewById(b.f.history_lv);
      p.j(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(288312);
    i locali = this.xNE;
    if (locali != null) {
      locali.onDestroy();
    }
    qF(true);
    h.aGY().b(3820, (com.tencent.mm.an.i)this);
    super.onDestroy();
    AppMethodBeat.o(288312);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(288315);
    h.aGY().b(3820, (com.tencent.mm.an.i)this);
    int j = dQE();
    int i = dQE();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      f.Iyx.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.xNG;
      if (paramString != null) {}
      for (paramString = paramString.xea; paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(288315);
        throw paramString;
      }
      paramq = paramString.ESJ;
      p.j(paramq, "response.infoList");
      Object localObject = (Iterable)paramq;
      paramq = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bip localbip = (bip)((Iterator)localObject).next();
        paramq.add(Boolean.valueOf(this.xMG.add(localbip)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.xHE = paramString.xHE;
      paramInt1 = dQE();
      Log.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.xMG.size());
      paramString = this.xvJ;
      if (paramString == null) {
        p.bGy("rlLayout");
      }
      paramString.azs(0);
      if (paramInt1 != 0) {
        break label417;
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
          AppMethodBeat.o(288315);
          return;
          f.Iyx.idkeyStat(1265L, 11L, 1L, false);
          paramInt1 = i;
          break;
          label417:
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
          paramString = this.zZW;
          if (paramString == null) {
            p.bGy("mainContainer");
          }
          paramString.setVisibility(0);
          continue;
        }
        AppMethodBeat.o(288315);
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
          AppMethodBeat.o(288315);
          return;
        }
      }
    }
    AppMethodBeat.o(288315);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final void qF(boolean paramBoolean)
  {
    AppMethodBeat.i(288317);
    if (!Util.isNullOrNil(this.fIY)) {
      if (((Map)this.zZV).isEmpty()) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        o localo = o.zWG;
        o.a(this.fIY, this.query, this.zZV, 2);
        if (paramBoolean) {
          this.zZV.clear();
        }
      }
      AppMethodBeat.o(288317);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;I)V", "existFollowContact", "", "getExistFollowContact", "()Z", "setExistFollowContact", "(Z)V", "getRequestType", "()I", "unFollowContactIndex", "getUnFollowContactIndex", "setUnFollowContactIndex", "(I)V", "bindData", "", "holder", "position", "bindImage", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    private final int requestType = 3;
    private boolean zZY;
    private int zZZ;
    
    private final void i(RecyclerView.v paramv, final int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(288586);
      if ((paramv instanceof FinderContactSearchIncludeFollowUI.c))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderContactSearchIncludeFollowUI.c)paramv).titleTv.setText((CharSequence)this.Aaa.getString(b.j.finder_contact_search_follow_header));
          AppMethodBeat.o(288586);
          return;
        }
        ((FinderContactSearchIncludeFollowUI.c)paramv).titleTv.setText((CharSequence)this.Aaa.getString(b.j.finder_contact_search_un_follow_header));
        AppMethodBeat.o(288586);
        return;
      }
      bip localbip;
      Object localObject2;
      Object localObject1;
      if ((this.requestType == 3) && (this.zZY) && (this.zZZ != FinderContactSearchIncludeFollowUI.a(this.Aaa).size())) {
        if (paramInt < this.zZZ + 1)
        {
          localbip = (bip)FinderContactSearchIncludeFollowUI.a(this.Aaa).get(paramInt - 1);
          p.j(localbip, "if (requestType == Const…sition]\n                }");
          localObject2 = this.Aaa;
          localObject1 = localbip.contact;
          if (localObject1 != null)
          {
            localObject1 = ((FinderContact)localObject1).username;
            if (localObject1 != null) {
              break label451;
            }
          }
          localObject1 = "";
        }
      }
      label451:
      for (;;)
      {
        p.k(localObject1, "id");
        if (!((FinderContactSearchIncludeFollowUI)localObject2).zZV.containsKey(localObject1))
        {
          Log.d(FinderContactSearchIncludeFollowUI.TAG, "addExposeItem " + (String)localObject1 + ' ' + paramInt + ' ' + 1);
          a locala = new a();
          locala.setId((String)localObject1);
          locala.position = paramInt;
          locala.type = 1;
          locala.timeStamp = System.currentTimeMillis();
          ((Map)((FinderContactSearchIncludeFollowUI)localObject2).zZV).put(localObject1, locala);
          if (((FinderContactSearchIncludeFollowUI)localObject2).zZV.size() % 30 == 0) {
            ((FinderContactSearchIncludeFollowUI)localObject2).qF(false);
          }
        }
        if (paramv == null)
        {
          paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.search.FinderMixSearchContactItemHolder");
          AppMethodBeat.o(288586);
          throw paramv;
          localbip = (bip)FinderContactSearchIncludeFollowUI.a(this.Aaa).get(paramInt - 2);
          break;
          localbip = (bip)FinderContactSearchIncludeFollowUI.a(this.Aaa).get(paramInt);
          break;
        }
        localObject1 = (c)paramv;
        localObject2 = (View.OnClickListener)new a(this, paramInt);
        if (paramInt != 0) {}
        for (;;)
        {
          c.a((c)localObject1, localbip, (View.OnClickListener)localObject2, bool, 4);
          paramv = paramv.amk.findViewById(b.f.follow_tv);
          if (paramv == null) {
            break;
          }
          paramv.setVisibility(8);
          AppMethodBeat.o(288586);
          return;
          bool = false;
        }
        AppMethodBeat.o(288586);
        return;
      }
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(288585);
      p.k(paramv, "holder");
      p.k(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(288585);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(288584);
      p.k(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        localObject = this.Aaa;
        AppCompatActivity localAppCompatActivity = this.Aaa.getContext();
        if (localAppCompatActivity == null) {
          p.iCn();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(b.g.finder_post_at_header_item, paramViewGroup, false);
        p.j(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderContactSearchIncludeFollowUI.c((FinderContactSearchIncludeFollowUI)localObject, paramViewGroup);
        AppMethodBeat.o(288584);
        return paramViewGroup;
      }
      Object localObject = this.Aaa.getContext();
      if (localObject == null) {
        p.iCn();
      }
      paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(b.g.finder_contact_search_item, paramViewGroup, false);
      p.j(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(288584);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(288587);
      p.k(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(288587);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(288582);
      if ((this.requestType == 3) && (FinderContactSearchIncludeFollowUI.a(this.Aaa).size() != 0))
      {
        this.zZZ = 0;
        this.zZY = false;
        Iterator localIterator = FinderContactSearchIncludeFollowUI.a(this.Aaa).iterator();
        if (localIterator.hasNext())
        {
          bip localbip = (bip)localIterator.next();
          Object localObject = FinderContactSearchIncludeFollowUI.zZX;
          String str = FinderContactSearchIncludeFollowUI.access$getTAG$cp();
          StringBuilder localStringBuilder = new StringBuilder("getItemCount isFollow:");
          localObject = localbip.contact;
          if (localObject != null)
          {
            localObject = ((FinderContact)localObject).username;
            label104:
            Log.i(str, (String)localObject);
            localObject = d.wZQ;
            localObject = localbip.contact;
            if (localObject == null) {
              break label167;
            }
          }
          label167:
          for (localObject = ((FinderContact)localObject).username;; localObject = null)
          {
            if (!d.a.aAN((String)localObject)) {
              break label172;
            }
            this.zZY = true;
            this.zZZ += 1;
            break;
            localObject = null;
            break label104;
          }
        }
        label172:
        if (this.zZY)
        {
          if (this.zZZ == FinderContactSearchIncludeFollowUI.a(this.Aaa).size())
          {
            i = FinderContactSearchIncludeFollowUI.a(this.Aaa).size();
            AppMethodBeat.o(288582);
            return i;
          }
          i = FinderContactSearchIncludeFollowUI.a(this.Aaa).size();
          AppMethodBeat.o(288582);
          return i + 2;
        }
      }
      int i = FinderContactSearchIncludeFollowUI.a(this.Aaa).size();
      AppMethodBeat.o(288582);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(288583);
      if ((this.requestType == 3) && (this.zZY))
      {
        if (this.zZZ == FinderContactSearchIncludeFollowUI.a(this.Aaa).size())
        {
          AppMethodBeat.o(288583);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(288583);
          return 1;
        }
        if (paramInt == this.zZZ + 1)
        {
          AppMethodBeat.o(288583);
          return 2;
        }
      }
      AppMethodBeat.o(288583);
      return 3;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(FinderContactSearchIncludeFollowUI.b paramb, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(286256);
        Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
        p.j(paramView, "it");
        paramView = paramView.getTag();
        if (paramView == null)
        {
          paramView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
          AppMethodBeat.o(286256);
          throw paramView;
        }
        bip localbip = (bip)paramView;
        FinderContactSearchIncludeFollowUI localFinderContactSearchIncludeFollowUI = this.Aab.Aaa;
        int i = paramInt;
        p.k(localbip, "finderSearchInfo");
        if (localFinderContactSearchIncludeFollowUI.zZU)
        {
          Log.i(FinderContactSearchIncludeFollowUI.TAG, "onContactItemClick select atContact");
          paramView = e.ACV;
          localObject1 = localbip.contact;
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = new FinderContact();
          }
          paramView = e.f(paramView);
          localFinderContactSearchIncludeFollowUI.getIntent().putExtra("at_select_contact", paramView.toByteArray());
          localObject1 = localFinderContactSearchIncludeFollowUI.getIntent();
          paramView = d.wZQ;
          paramView = localbip.contact;
          if (paramView != null)
          {
            paramView = paramView.username;
            ((Intent)localObject1).putExtra("is_follow", d.a.aAN(paramView));
            localFinderContactSearchIncludeFollowUI.setResult(-1, localFinderContactSearchIncludeFollowUI.getIntent());
            localFinderContactSearchIncludeFollowUI.finish();
          }
        }
        label358:
        do
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter$bindData$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(286256);
          return;
          paramView = null;
          break;
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
          paramView = aj.Bnu;
          paramView = localFinderContactSearchIncludeFollowUI.getContext();
          p.j(paramView, "context");
          aj.a.a((Context)paramView, (Intent)localObject2, 0L, 7, false, 64);
          paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
          paramView = localFinderContactSearchIncludeFollowUI.getContext();
          p.j(paramView, "context");
          com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)paramView, (Intent)localObject2);
          paramView = o.zWG;
          localObject1 = localFinderContactSearchIncludeFollowUI.fIY;
          localObject2 = localFinderContactSearchIncludeFollowUI.query;
          paramView = localbip.contact;
          if (paramView == null) {
            break label430;
          }
          paramView = paramView.username;
          o.e((String)localObject1, (String)localObject2, paramView, i);
          paramView = aj.Bnu;
          paramView = localFinderContactSearchIncludeFollowUI.getContext();
          p.j(paramView, "context");
          paramView = aj.a.fZ((Context)paramView);
        } while (paramView == null);
        localObject1 = com.tencent.mm.plugin.finder.report.n.zWF;
        i = paramView.xkX;
        paramView = localbip.contact;
        if (paramView != null) {}
        for (paramView = paramView.username;; paramView = null)
        {
          com.tencent.mm.plugin.finder.report.n.a(6, 0L, i, 1, paramView);
          break;
          label430:
          paramView = null;
          break label358;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class c
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(288670);
      this$1 = localObject.findViewById(b.f.title_tv);
      p.j(FinderContactSearchIncludeFollowUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderContactSearchIncludeFollowUI.this);
      AppMethodBeat.o(288670);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(271092);
      FinderContactSearchIncludeFollowUI.b(this.Aaa).getFtsEditText().hUu();
      this.Aaa.hideVKB();
      AppMethodBeat.o(271092);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(258201);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(258201);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(258203);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(258203);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(258198);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderContactSearchIncludeFollowUI.zZX;
      Log.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderContactSearchIncludeFollowUI.c(this.Aaa);
      if (localObject != null)
      {
        if (FinderContactSearchIncludeFollowUI.d(this.Aaa) != 1) {
          break label257;
        }
        FinderContactSearchIncludeFollowUI.a(this.Aaa, new cj((String)localObject, FinderContactSearchIncludeFollowUI.f(this.Aaa), FinderContactSearchIncludeFollowUI.g(this.Aaa), FinderContactSearchIncludeFollowUI.h(this.Aaa), FinderContactSearchIncludeFollowUI.i(this.Aaa), null, null, null, 480));
        h.aGY().b((com.tencent.mm.an.q)FinderContactSearchIncludeFollowUI.e(this.Aaa));
        h.aGY().a(3820, (com.tencent.mm.an.i)this.Aaa);
        localObject = FinderContactSearchIncludeFollowUI.j(this.Aaa).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_footer_tip);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.Aaa).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.Aaa).getLoadMoreFooter();
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
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(258198);
        return;
        label257:
        localObject = FinderContactSearchIncludeFollowUI.j(this.Aaa).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_no_result_tip);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.Aaa).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderContactSearchIncludeFollowUI.j(this.Aaa).getLoadMoreFooter();
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
      AppMethodBeat.i(258202);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(258202);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
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