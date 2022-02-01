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
import com.tencent.mm.plugin.finder.b.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bkr;
import com.tencent.mm.protocal.protobuf.bkt;
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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "needHistory", "", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "topicList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSearchInfo;", "Lkotlin/collections/ArrayList;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getLayoutId", "getTopicSize", "handleSearch", "initContentView", "initData", "initSearchView", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "HeaderViewHolder", "TopicSearchAdapter", "plugin-finder_release"})
public final class FinderTopicSearchUI
  extends MMActivity
  implements com.tencent.mm.an.i, FTSEditTextView.b, a.b
{
  public static final a AcH;
  private static final String TAG = "Finder.FinderTopicSearchUI";
  private HashMap _$_findViewCache;
  private int continueFlag;
  private String fIY;
  private RecyclerView jLl;
  private View kGT;
  private int mBD;
  private View oFW;
  private int offset;
  private String query;
  private int requestType;
  private com.tencent.mm.cd.b xHE;
  private com.tencent.mm.ui.search.a xNC;
  private TextView xND;
  private i xNE;
  private cj xNG;
  private RefreshLoadMoreLayout xvJ;
  private ArrayList<bkt> zZS;
  private boolean zZT;
  private HashMap<String, a> zZV;
  private CoordinatorLayout zZW;
  
  static
  {
    AppMethodBeat.i(246873);
    AcH = new a((byte)0);
    TAG = "Finder.FinderTopicSearchUI";
    AppMethodBeat.o(246873);
  }
  
  public FinderTopicSearchUI()
  {
    AppMethodBeat.i(246872);
    this.query = "";
    this.zZS = new ArrayList();
    this.fIY = "";
    this.zZT = true;
    this.zZV = new HashMap();
    AppMethodBeat.o(246872);
  }
  
  private final void aEi(String paramString)
  {
    AppMethodBeat.i(246866);
    qF(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.xHE = null;
    this.zZS.clear();
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
    com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(246866);
  }
  
  private final boolean dQD()
  {
    AppMethodBeat.i(246864);
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
        AppMethodBeat.o(246864);
        throw ((Throwable)localObject1);
      }
      localObject2 = n.bb((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(246864);
      return true;
    }
    aEi((String)localObject1);
    Object localObject2 = this.xNE;
    if (localObject2 != null) {
      ((i)localObject2).aEn((String)localObject1);
    }
    AppMethodBeat.o(246864);
    return false;
  }
  
  private final int dRo()
  {
    AppMethodBeat.i(246871);
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
        AppMethodBeat.o(246871);
        return i;
      }
    }
    int i = this.zZS.size();
    AppMethodBeat.o(246871);
    return i;
  }
  
  private final void qF(boolean paramBoolean)
  {
    AppMethodBeat.i(246869);
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
      AppMethodBeat.o(246869);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(246881);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(246881);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(246879);
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
    AppMethodBeat.o(246879);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(246852);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(246852);
        throw paramString1;
      }
      paramString2 = n.bb((CharSequence)paramString1).toString();
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
      AppMethodBeat.o(246852);
      return;
      dQD();
    }
    AppMethodBeat.o(246852);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(246849);
    hideVKB();
    if (dQD())
    {
      AppMethodBeat.o(246849);
      return true;
    }
    f.Iyx.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(246849);
    return false;
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(246853);
    if (paramBoolean)
    {
      o localo = o.zWG;
      o.dPE();
    }
    AppMethodBeat.o(246853);
  }
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(246862);
    super.finish();
    int i = b.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(246862);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_topic_search_ui;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(246847);
    hideVKB();
    finish();
    AppMethodBeat.o(246847);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(246846);
    hideVKB();
    finish();
    AppMethodBeat.o(246846);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(246855);
    paramView = this.xNC;
    if (paramView == null) {
      p.bGy("searchView");
    }
    paramView.getFtsEditText().aDU();
    showVKB();
    AppMethodBeat.o(246855);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(246843);
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
    Object localObject = this.xNC;
    if (localObject == null) {
      p.bGy("searchView");
    }
    paramBundle.setCustomView((View)localObject);
    this.requestType = getIntent().getIntExtra("request_type", 4);
    this.zZT = getIntent().getBooleanExtra("need_history", false);
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
      Log.i(TAG, "initData");
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
      localObject = this.jLl;
      if (localObject == null) {
        p.bGy("recyclerView");
      }
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)paramBundle);
      paramBundle = this.jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle.setAdapter((RecyclerView.a)new c((byte)0));
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
      localObject = ad.kS((Context)getContext()).inflate(b.g.load_more_footer, null);
      p.j(localObject, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject);
      paramBundle = this.xvJ;
      if (paramBundle == null) {
        p.bGy("rlLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new e(this));
      paramBundle = this.query;
      if (paramBundle != null)
      {
        localObject = this.xNC;
        if (localObject == null) {
          p.bGy("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject).getFtsEditText().O(paramBundle, null);
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
      localObject = com.tencent.mm.hellhoundlib.b.c.a(this.mBD, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(246843);
      return;
      paramBundle = getContext().findViewById(b.f.history_lv);
      p.j(paramBundle, "context.findViewById<View>(R.id.history_lv)");
      paramBundle.setVisibility(8);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(246863);
    i locali = this.xNE;
    if (locali != null) {
      locali.onDestroy();
    }
    qF(true);
    h.aGY().b(3820, (com.tencent.mm.an.i)this);
    super.onDestroy();
    AppMethodBeat.o(246863);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(246860);
    h.aGY().b(3820, (com.tencent.mm.an.i)this);
    int j = dRo();
    int i = dRo();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      f.Iyx.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.xNG;
      if (paramString != null) {}
      for (paramString = paramString.xea; paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(246860);
        throw paramString;
      }
      paramq = paramString.SSU;
      p.j(paramq, "response.topicInfoList");
      Object localObject = (Iterable)paramq;
      paramq = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkt localbkt = (bkt)((Iterator)localObject).next();
        paramq.add(Boolean.valueOf(this.zZS.add(localbkt)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.SSW;
      this.xHE = paramString.xHE;
      paramInt1 = dRo();
      Log.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.zZS.size());
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
          AppMethodBeat.o(246860);
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
          paramString = this.oFW;
          if (paramString == null) {
            p.bGy("rootView");
          }
          paramq = getContext();
          p.j(paramq, "context");
          paramString.setBackground(paramq.getResources().getDrawable(b.c.BG_0));
          continue;
        }
        AppMethodBeat.o(246860);
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
          AppMethodBeat.o(246860);
          return;
        }
      }
    }
    AppMethodBeat.o(246860);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"})
  public final class b
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public b()
    {
      super();
      AppMethodBeat.i(230858);
      this$1 = localObject.findViewById(b.f.title_tv);
      p.j(FinderTopicSearchUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderTopicSearchUI.this);
      AppMethodBeat.o(230858);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI$TopicSearchAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderTopicSearchUI;I)V", "existFollowTopic", "", "getExistFollowTopic", "()Z", "setExistFollowTopic", "(Z)V", "getRequestType", "()I", "unFollowTopicIndex", "getUnFollowTopicIndex", "setUnFollowTopicIndex", "(I)V", "bindData", "", "holder", "position", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"})
  public final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private boolean AcJ;
    private int AcK;
    private final int requestType = 4;
    
    private final void j(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(276427);
      if ((paramv instanceof FinderTopicSearchUI.b))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderTopicSearchUI.b)paramv).titleTv.setText((CharSequence)this.AcI.getString(b.j.finder_contact_search_follow_topic_header));
          AppMethodBeat.o(276427);
          return;
        }
        ((FinderTopicSearchUI.b)paramv).titleTv.setText((CharSequence)this.AcI.getString(b.j.finder_contact_search_un_follow_topic_header));
        AppMethodBeat.o(276427);
        return;
      }
      Object localObject1;
      if ((this.requestType == 4) && (this.AcJ) && (this.AcK != FinderTopicSearchUI.a(this.AcI).size())) {
        if (paramInt < this.AcK + 1) {
          localObject1 = (bkt)FinderTopicSearchUI.a(this.AcI).get(paramInt - 1);
        }
      }
      for (;;)
      {
        p.j(localObject1, "if (requestType == Const…sition]\n                }");
        FinderTopicSearchUI localFinderTopicSearchUI = this.AcI;
        Object localObject2 = ((bkt)localObject1).fGc;
        if (localObject2 != null)
        {
          localObject3 = ((bkr)localObject2).topic;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = "";
        }
        FinderTopicSearchUI.a(localFinderTopicSearchUI, (String)localObject2, paramInt);
        localObject1 = ((bkt)localObject1).fGc;
        if (localObject1 == null) {
          break;
        }
        localObject2 = paramv.amk.findViewById(b.f.follow_topic_news_title);
        p.j(localObject2, "holder.itemView.findView….follow_topic_news_title)");
        localObject2 = (TextView)localObject2;
        Object localObject3 = paramv.amk;
        p.j(localObject3, "holder.itemView");
        ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(((View)localObject3).getContext(), (CharSequence)((bkr)localObject1).topic));
        localObject2 = paramv.amk.findViewById(b.f.follow_topic_news_count);
        p.j(localObject2, "holder.itemView.findView….follow_topic_news_count)");
        localObject2 = (TextView)localObject2;
        paramv = paramv.amk;
        p.j(paramv, "holder.itemView");
        ((TextView)localObject2).setText((CharSequence)paramv.getContext().getString(b.j.finder_news_count_num, new Object[] { m.gY(2, ((bkr)localObject1).feedCount) }));
        AppMethodBeat.o(276427);
        return;
        localObject1 = (bkt)FinderTopicSearchUI.a(this.AcI).get(paramInt - 2);
        continue;
        localObject1 = (bkt)FinderTopicSearchUI.a(this.AcI).get(paramInt);
      }
      AppMethodBeat.o(276427);
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(276426);
      p.k(paramv, "holder");
      p.k(paramList, "payloads");
      j(paramv, paramInt);
      AppMethodBeat.o(276426);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(276422);
      p.k(paramViewGroup, "parent");
      switch (paramInt)
      {
      default: 
        localObject = this.AcI;
        AppCompatActivity localAppCompatActivity = this.AcI.getContext();
        if (localAppCompatActivity == null) {
          p.iCn();
        }
        paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(b.g.finder_post_at_header_item, paramViewGroup, false);
        p.j(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
        paramViewGroup = (RecyclerView.v)new FinderTopicSearchUI.b((FinderTopicSearchUI)localObject, paramViewGroup);
        AppMethodBeat.o(276422);
        return paramViewGroup;
      }
      Object localObject = this.AcI.getContext();
      if (localObject == null) {
        p.iCn();
      }
      paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(b.g.finder_follow_topic_item, paramViewGroup, false);
      p.j(paramViewGroup, "contactLayout");
      paramViewGroup = (RecyclerView.v)new c(paramViewGroup);
      AppMethodBeat.o(276422);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(276425);
      p.k(paramv, "holder");
      j(paramv, paramInt);
      AppMethodBeat.o(276425);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(276423);
      if ((this.requestType == 3) && (FinderTopicSearchUI.a(this.AcI).size() != 0))
      {
        this.AcK = 0;
        this.AcJ = false;
        Iterator localIterator = FinderTopicSearchUI.a(this.AcI).iterator();
        if (localIterator.hasNext())
        {
          bkr localbkr = ((bkt)localIterator.next()).fGc;
          boolean bool;
          if (localbkr != null) {
            if (localbkr.followFlag > 0) {
              bool = true;
            }
          }
          for (;;)
          {
            this.AcJ = bool;
            if (!this.AcJ) {
              break label120;
            }
            this.AcK += 1;
            break;
            bool = false;
            continue;
            bool = false;
          }
        }
        label120:
        if (this.AcJ)
        {
          if (this.AcK == FinderTopicSearchUI.a(this.AcI).size())
          {
            i = FinderTopicSearchUI.a(this.AcI).size();
            AppMethodBeat.o(276423);
            return i;
          }
          i = FinderTopicSearchUI.a(this.AcI).size();
          AppMethodBeat.o(276423);
          return i + 2;
        }
      }
      int i = FinderTopicSearchUI.a(this.AcI).size();
      AppMethodBeat.o(276423);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(276424);
      if ((this.requestType == 4) && (this.AcJ))
      {
        if (this.AcK == FinderTopicSearchUI.a(this.AcI).size())
        {
          AppMethodBeat.o(276424);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(276424);
          return 1;
        }
        if (paramInt == this.AcK + 1)
        {
          AppMethodBeat.o(276424);
          return 2;
        }
      }
      AppMethodBeat.o(276424);
      return 3;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderTopicSearchUI paramFinderTopicSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(279639);
      FinderTopicSearchUI.b(this.AcI).getFtsEditText().hUu();
      this.AcI.hideVKB();
      AppMethodBeat.o(279639);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "plugin-finder_release"})
  public static final class e
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(285936);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(285936);
    }
    
    public final void a(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(285938);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.a(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(285938);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(285935);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Object localObject = FinderContactSearchIncludeFollowUI.zZX;
      Log.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderTopicSearchUI.c(this.AcI);
      if (localObject != null)
      {
        if (FinderTopicSearchUI.d(this.AcI) != 1) {
          break label257;
        }
        FinderTopicSearchUI.a(this.AcI, new cj((String)localObject, FinderTopicSearchUI.f(this.AcI), FinderTopicSearchUI.g(this.AcI), FinderTopicSearchUI.h(this.AcI), FinderTopicSearchUI.i(this.AcI), null, null, null, 480));
        h.aGY().b((com.tencent.mm.an.q)FinderTopicSearchUI.e(this.AcI));
        h.aGY().a(3820, (com.tencent.mm.an.i)this.AcI);
        localObject = FinderTopicSearchUI.j(this.AcI).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_footer_tip);
          }
        }
        localObject = FinderTopicSearchUI.j(this.AcI).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(0);
          }
        }
        localObject = FinderTopicSearchUI.j(this.AcI).getLoadMoreFooter();
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
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(285935);
        return;
        label257:
        localObject = FinderTopicSearchUI.j(this.AcI).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setText(b.j.finder_load_more_no_result_tip);
          }
        }
        localObject = FinderTopicSearchUI.j(this.AcI).getLoadMoreFooter();
        if (localObject != null)
        {
          localObject = (TextView)((View)localObject).findViewById(b.f.load_more_footer_tip_tv);
          if (localObject != null) {
            ((TextView)localObject).setVisibility(8);
          }
        }
        localObject = FinderTopicSearchUI.j(this.AcI).getLoadMoreFooter();
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
      AppMethodBeat.i(285937);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderTopicSearchUI$initContentView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(285937);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    f(FinderTopicSearchUI paramFinderTopicSearchUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderTopicSearchUI
 * JD-Core Version:    0.7.0.1
 */