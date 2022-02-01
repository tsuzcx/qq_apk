package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.f.b.a.dx;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cj;
import com.tencent.mm.plugin.finder.gallery.b.a;
import com.tencent.mm.plugin.finder.gallery.b.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.search.k.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "continueFlag", "", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "setGalleryConfig", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;)V", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "isOtherEnableFullScreenEnjoy", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestId", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchSuggestionManager", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;", "searchType", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "tabType", "getTabType", "()I", "addClickItem", "", "id", "position", "addExposeItem", "addFinderObject", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLayoutId", "goBack", "initContentView", "initData", "initSearchView", "initSuggestion", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onSwipeBack", "onTagClick", "index", "tag", "showLoadMoreFooter", "showNoMoreFooter", "startSearch", "hotSessionBuffer", "startSearchNextPage", "isPreload", "plugin-finder_release"})
public final class FinderGallerySearchUI
  extends MMFinderUI
  implements com.tencent.mm.an.i, FTSEditTextView.b, a.b
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private int continueFlag;
  final int fEH;
  String fIY;
  private ArrayList<bu> feedList;
  private RecyclerView jLl;
  private View kGT;
  private int offset;
  String query;
  int uMD;
  private boolean xAM;
  private com.tencent.mm.cd.b xHE;
  public com.tencent.mm.plugin.finder.gallery.b xNB;
  private com.tencent.mm.ui.search.a xNC;
  private TextView xND;
  private com.tencent.mm.plugin.finder.search.i xNE;
  private com.tencent.mm.plugin.finder.search.k xNF;
  private cj xNG;
  private RefreshLoadMoreLayout xvJ;
  
  public FinderGallerySearchUI()
  {
    AppMethodBeat.i(224713);
    this.TAG = "Finder.FinderGallerySearchUI";
    this.query = "";
    this.feedList = new ArrayList();
    this.fIY = "";
    this.uMD = 1;
    this.fEH = 10000;
    AppMethodBeat.o(224713);
  }
  
  private final void aBK(String paramString)
  {
    AppMethodBeat.i(224681);
    Log.i(this.TAG, "startSearch query:".concat(String.valueOf(paramString)));
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.xHE = null;
    this.feedList.clear();
    Object localObject = UUID.randomUUID().toString();
    p.j(localObject, "UUID.randomUUID().toString()");
    this.fIY = ((String)localObject);
    if (this.xNG != null) {
      h.aGY().a((com.tencent.mm.an.q)this.xNG);
    }
    localObject = this.xNB;
    if (localObject == null) {
      p.bGy("galleryConfig");
    }
    int i;
    switch (((com.tencent.mm.plugin.finder.gallery.b)localObject).xTx.kqZ)
    {
    default: 
      i = 0;
    }
    for (;;)
    {
      int j = this.offset;
      localObject = this.fIY;
      com.tencent.mm.cd.b localb = this.xHE;
      g localg = g.Xox;
      this.xNG = new cj(paramString, j, (String)localObject, localb, i, ((aj)g.b((AppCompatActivity)this).i(aj.class)).ekY(), null, null, 384);
      paramString = this.xNG;
      if (paramString != null) {
        paramString.uMD = this.uMD;
      }
      paramString = this.xNG;
      if (paramString != null) {
        paramString.xdX = false;
      }
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
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI", "startSearch", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "Undefined", "scrollToPosition", "(I)V");
      paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI", "startSearch", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;)V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(224681);
      return;
      i = 15;
      continue;
      i = 16;
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(224736);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(224736);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(224735);
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
    AppMethodBeat.o(224735);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(224666);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(224666);
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
    if (paramString2 == null) {
      p.bGy("historyLogic");
    }
    paramString2.aEm(paramString1);
    AppMethodBeat.o(224666);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(224671);
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
        AppMethodBeat.o(224671);
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
      AppMethodBeat.o(224671);
      return true;
    }
    this.uMD = 1;
    aBK((String)localObject1);
    Object localObject2 = this.xNE;
    if (localObject2 == null) {
      p.bGy("historyLogic");
    }
    ((com.tencent.mm.plugin.finder.search.i)localObject2).aEn((String)localObject1);
    localObject1 = this.xNF;
    if (localObject1 == null) {
      p.bGy("searchSuggestionManager");
    }
    ((com.tencent.mm.plugin.finder.search.k)localObject1).dRj();
    com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1265L, 6L, 1L, false);
    AppMethodBeat.o(224671);
    return false;
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(224668);
    if (paramBoolean)
    {
      o localo = o.zWG;
      o.dPE();
    }
    AppMethodBeat.o(224668);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_gallery_feed_search_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(224659);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.finder.gallery.b localb = this.xNB;
    if (localb == null) {
      p.bGy("galleryConfig");
    }
    localb.a((MMActivity)this, paramInt1, paramInt2, paramIntent, b.b.xTA);
    AppMethodBeat.o(224659);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(224705);
    finish();
    AppMethodBeat.o(224705);
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(224660);
    hideVKB();
    finish();
    AppMethodBeat.o(224660);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(224662);
    hideVKB();
    finish();
    AppMethodBeat.o(224662);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(224669);
    paramView = this.xNC;
    if (paramView == null) {
      p.bGy("searchView");
    }
    paramView.getFtsEditText().aDU();
    showVKB();
    AppMethodBeat.o(224669);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(224657);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.gallery.b.xTy;
    paramBundle = getIntent();
    p.j(paramBundle, "intent");
    this.xNB = b.a.aj(paramBundle);
    paramBundle = this.xNB;
    if (paramBundle == null) {
      p.bGy("galleryConfig");
    }
    this.xAM = paramBundle.dwb();
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
    if (this.xAM)
    {
      paramBundle = this.xNC;
      if (paramBundle == null) {
        p.bGy("searchView");
      }
      paramBundle = paramBundle.findViewById(b.f.cancel_btn);
      p.j(paramBundle, "searchView.findViewById<View>(R.id.cancel_btn)");
      paramBundle.setVisibility(8);
      paramBundle = this.xNC;
      if (paramBundle == null) {
        p.bGy("searchView");
      }
      paramBundle = paramBundle.getSearchContainer();
      p.j(paramBundle, "searchView.searchContainer");
      paramBundle.setBackground(null);
      int i = getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_64);
      paramBundle = this.xNC;
      if (paramBundle == null) {
        p.bGy("searchView");
      }
      paramBundle = paramBundle.getFtsEditText();
      p.j(paramBundle, "searchView.ftsEditText");
      paramBundle.getEditText().setTextColor(i);
      paramBundle = this.xNC;
      if (paramBundle == null) {
        p.bGy("searchView");
      }
      paramBundle.getSearchIcon().setIconColor(i);
      paramBundle = this.xNC;
      if (paramBundle == null) {
        p.bGy("searchView");
      }
      paramBundle = paramBundle.getFtsEditText();
      p.j(paramBundle, "searchView.ftsEditText");
      paramBundle = paramBundle.getClearBtn();
      p.j(paramBundle, "searchView.ftsEditText.clearBtn");
      paramBundle.getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      paramBundle = this.xNC;
      if (paramBundle == null) {
        p.bGy("searchView");
      }
      paramBundle.setBackgroundColor(getResources().getColor(b.c.full_black));
      setActionbarColor(getResources().getColor(b.c.full_black));
    }
    paramBundle = getSupportActionBar();
    if (paramBundle != null)
    {
      localObject = this.xNC;
      if (localObject == null) {
        p.bGy("searchView");
      }
      paramBundle.setCustomView((View)localObject);
    }
    paramBundle = (FrameLayout)_$_findCachedViewById(b.f.full_actionbar);
    p.j(paramBundle, "full_actionbar");
    paramBundle.setVisibility(8);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      p.bGy("searchView");
    }
    paramBundle = (WeImageView)paramBundle.findViewById(b.f.back_btn);
    if (paramBundle != null)
    {
      paramBundle.setVisibility(0);
      if (this.xAM) {
        paramBundle.setIconColor(getResources().getColor(b.c.hot_tab_BW_100_Alpha_0_64));
      }
      paramBundle.setOnClickListener((View.OnClickListener)new f(this));
    }
    paramBundle = com.tencent.mm.plugin.finder.search.j.Acs;
    com.tencent.mm.plugin.finder.search.j.dRi().clear();
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
    this.xNE = new com.tencent.mm.plugin.finder.search.i((MMActivity)this, this.xAM, (kotlin.g.a.b)new e(this));
    paramBundle = (MMActivity)this;
    Object localObject = this.xNC;
    if (localObject == null) {
      p.bGy("searchView");
    }
    localObject = ((com.tencent.mm.ui.search.a)localObject).getFtsEditText();
    p.j(localObject, "searchView.ftsEditText");
    this.xNF = new com.tencent.mm.plugin.finder.search.k(paramBundle, (FTSEditTextView)localObject, 0, 3, this.xAM, false, (kotlin.g.a.b)new g(this));
    paramBundle = this.xNF;
    if (paramBundle == null) {
      p.bGy("searchSuggestionManager");
    }
    paramBundle.a((k.b)new h(this));
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
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    localObject = this.xNB;
    if (localObject == null) {
      p.bGy("galleryConfig");
    }
    paramBundle.setLayoutManager(((com.tencent.mm.plugin.finder.gallery.b)localObject).ft((Context)this));
    paramBundle = this.jLl;
    if (paramBundle == null) {
      p.bGy("recyclerView");
    }
    localObject = this.xNB;
    if (localObject == null) {
      p.bGy("galleryConfig");
    }
    paramBundle.b(((com.tencent.mm.plugin.finder.gallery.b)localObject).dwc());
    paramBundle = this.xNB;
    if (paramBundle == null) {
      p.bGy("galleryConfig");
    }
    paramBundle = new WxRecyclerAdapter(paramBundle.dwa(), this.feedList, true);
    paramBundle.YSn = ((h.c)new a(this));
    paramBundle.YTa = ((m)new b(this));
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle);
    paramBundle = ad.kS((Context)getContext()).inflate(b.g.load_more_footer, null);
    localObject = this.xvJ;
    if (localObject == null) {
      p.bGy("rlLayout");
    }
    p.j(paramBundle, "loadmoreFooter");
    ((RefreshLoadMoreLayout)localObject).setLoadMoreFooter(paramBundle);
    if (!this.xAM)
    {
      paramBundle = this.xND;
      if (paramBundle == null) {
        p.bGy("noResultView");
      }
      paramBundle.setTextColor(getResources().getColor(b.c.hint_text_color));
    }
    for (;;)
    {
      paramBundle = this.jLl;
      if (paramBundle == null) {
        p.bGy("recyclerView");
      }
      paramBundle.setOnTouchListener((View.OnTouchListener)new c(this));
      paramBundle = this.xvJ;
      if (paramBundle == null) {
        p.bGy("rlLayout");
      }
      paramBundle.setEnablePullDownHeader(false);
      paramBundle = this.xvJ;
      if (paramBundle == null) {
        p.bGy("rlLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new d(this));
      paramBundle = this.query;
      if (paramBundle != null)
      {
        localObject = this.xNF;
        if (localObject == null) {
          p.bGy("searchSuggestionManager");
        }
        ((com.tencent.mm.plugin.finder.search.k)localObject).aEq(paramBundle);
        localObject = this.xNC;
        if (localObject == null) {
          p.bGy("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject).getFtsEditText().O(paramBundle, null);
      }
      paramBundle = com.tencent.mm.plugin.finder.gallery.f.xUa;
      paramBundle = new dx();
      paramBundle.qZ(com.tencent.mm.plugin.finder.gallery.f.sessionId);
      paramBundle.kd(com.tencent.mm.plugin.finder.gallery.f.xTY);
      paramBundle.ke(1L);
      paramBundle.ra(com.tencent.mm.plugin.finder.gallery.f.MS(10000));
      paramBundle.kf(com.tencent.mm.plugin.finder.gallery.f.MR(10000));
      paramBundle.rb("");
      paramBundle.rc(String.valueOf(cm.bfE()));
      paramBundle.bpa();
      com.tencent.mm.plugin.finder.gallery.f.a((com.tencent.mm.plugin.report.a)paramBundle);
      AppMethodBeat.o(224657);
      return;
      localObject = this.xND;
      if (localObject == null) {
        p.bGy("noResultView");
      }
      ((TextView)localObject).setTextColor(getResources().getColor(b.c.hot_tab_BW93));
      ((TouchableLayout)_$_findCachedViewById(b.f.uiContainer)).setBackgroundColor(getResources().getColor(b.c.full_black));
      paramBundle = (TextView)paramBundle.findViewById(b.f.load_more_footer_tip_tv);
      if (paramBundle != null) {
        paramBundle.setTextColor(getResources().getColor(b.c.BW_100_Alpha_0_3));
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(224675);
    Object localObject = com.tencent.mm.plugin.finder.search.j.Acs;
    com.tencent.mm.plugin.finder.search.j.dRi().clear();
    localObject = this.xNE;
    if (localObject == null) {
      p.bGy("historyLogic");
    }
    ((com.tencent.mm.plugin.finder.search.i)localObject).onDestroy();
    com.tencent.mm.plugin.finder.storage.data.f.Anc.clearCache();
    h.aGY().b(3820, (com.tencent.mm.an.i)this);
    hideVKB();
    localObject = com.tencent.mm.plugin.finder.gallery.f.xUa;
    localObject = new dx();
    ((dx)localObject).qZ(com.tencent.mm.plugin.finder.gallery.f.sessionId);
    ((dx)localObject).kd(com.tencent.mm.plugin.finder.gallery.f.xTY);
    ((dx)localObject).ke(3L);
    ((dx)localObject).ra(com.tencent.mm.plugin.finder.gallery.f.MS(10000));
    ((dx)localObject).kf(com.tencent.mm.plugin.finder.gallery.f.MR(10000));
    ((dx)localObject).rb("");
    ((dx)localObject).rc(String.valueOf(cm.bfE()));
    ((dx)localObject).bpa();
    com.tencent.mm.plugin.finder.gallery.f.a((com.tencent.mm.plugin.report.a)localObject);
    super.onDestroy();
    AppMethodBeat.o(224675);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(224710);
    super.onPause();
    com.tencent.mm.plugin.finder.search.k localk = this.xNF;
    if (localk == null) {
      p.bGy("searchSuggestionManager");
    }
    localk.onActivityPause();
    AppMethodBeat.o(224710);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(224708);
    super.onResume();
    com.tencent.mm.plugin.finder.search.k localk = this.xNF;
    if (localk == null) {
      p.bGy("searchSuggestionManager");
    }
    localk.onActivityResume();
    AppMethodBeat.o(224708);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(224703);
    h.aGY().b(3820, (com.tencent.mm.an.i)this);
    paramq = new aa.d();
    paramq.aaBA = this.feedList.size();
    final aa.d locald = new aa.d();
    locald.aaBA = this.feedList.size();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1265L, 7L, 1L, false);
      paramString = this.xNG;
      if (paramString != null) {}
      for (paramString = paramString.xea; paramString == null; paramString = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(224703);
        throw paramString;
      }
      Object localObject1 = paramString.wHI;
      p.j(localObject1, "response.objectList");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (FinderObject)((Iterator)localObject2).next();
        p.j(localObject3, "it");
        Object localObject4 = FinderItem.Companion;
        localObject3 = FinderItem.a.b((FinderObject)localObject3, 16);
        localObject4 = com.tencent.mm.plugin.finder.search.j.Acs;
        ((Map)com.tencent.mm.plugin.finder.search.j.dRi()).put(Long.valueOf(((FinderItem)localObject3).getId()), localObject3);
        localObject4 = com.tencent.mm.plugin.finder.storage.logic.c.AnK;
        localObject3 = c.a.a((FinderItem)localObject3);
        this.feedList.add(localObject3);
        ((Collection)localObject1).add(x.aazN);
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.xHE = paramString.xHE;
      locald.aaBA = this.feedList.size();
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("onSceneEnd ").append(paramString.offset).append(' ').append(paramString.continueFlag).append(' ').append(this.feedList.size()).append(' ');
      paramString = this.xNG;
      if (paramString != null)
      {
        paramString = paramString.xdZ;
        if (paramString != null)
        {
          paramString = paramString.SSO;
          Log.i((String)localObject1, paramString);
          label411:
          if (locald.aaBA != 0) {
            break label581;
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
          label481:
          if (paramq.aaBA != 0) {
            break label646;
          }
          paramString = this.jLl;
          if (paramString == null) {
            p.bGy("recyclerView");
          }
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.notifyDataSetChanged();
          }
        }
      }
    }
    for (;;)
    {
      paramString = this.xvJ;
      if (paramString == null) {
        p.bGy("rlLayout");
      }
      paramString.post((Runnable)new i(this, paramq, locald));
      AppMethodBeat.o(224703);
      return;
      paramString = null;
      break;
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1265L, 8L, 1L, false);
      break label411;
      label581:
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
      break label481;
      label646:
      if (paramq.aaBA < locald.aaBA)
      {
        paramString = this.jLl;
        if (paramString == null) {
          p.bGy("recyclerView");
        }
        if (paramString != null)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.aG(paramq.aaBA, locald.aaBA - paramq.aaBA);
          }
        }
      }
    }
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(224672);
    super.onSwipeBack();
    hideVKB();
    AppMethodBeat.o(224672);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
  public static final class a
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$2", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "wxRVData", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
  public static final class b
    implements m
  {
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.k paramk)
    {
      AppMethodBeat.i(288996);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramk, "wxRVData");
      if ((paramk.state == 0) || (paramk.state == 8))
      {
        paramk = ((Iterable)paramk.YSK).iterator();
        while (paramk.hasNext())
        {
          Object localObject2 = (com.tencent.mm.view.recyclerview.l)paramk.next();
          Object localObject1 = ((com.tencent.mm.view.recyclerview.l)localObject2).YSP;
          if ((localObject1 instanceof BaseFinderFeed))
          {
            paramRecyclerView = this.xNH;
            localObject1 = d.Fw(((com.tencent.mm.view.recyclerview.a)localObject1).mf());
            int i = ((com.tencent.mm.view.recyclerview.l)localObject2).xre;
            p.k(localObject1, "id");
            localObject2 = com.tencent.mm.plugin.finder.report.n.zWF;
            localObject2 = paramRecyclerView.fIY;
            String str = paramRecyclerView.query;
            Object localObject3 = com.tencent.mm.plugin.finder.report.n.zWF;
            localObject3 = com.tencent.mm.plugin.finder.report.n.dPC();
            int j = paramRecyclerView.uMD;
            aj.a locala = aj.Bnu;
            paramRecyclerView = aj.a.fZ((Context)paramRecyclerView);
            if (paramRecyclerView != null) {}
            for (paramRecyclerView = paramRecyclerView.ekY();; paramRecyclerView = null)
            {
              com.tencent.mm.plugin.finder.report.n.a((String)localObject2, str, 2, 2, (String)localObject1, i, 3, (String)localObject3, 1, j, paramRecyclerView);
              break;
            }
          }
        }
      }
      AppMethodBeat.o(288996);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(FinderGallerySearchUI paramFinderGallerySearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(281036);
      FinderGallerySearchUI.b(this.xNH).getFtsEditText().hUu();
      this.xNH.hideVKB();
      AppMethodBeat.o(281036);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
  public static final class d
    extends RefreshLoadMoreLayout.a
  {
    private boolean xvR = true;
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(282337);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(282337);
    }
    
    public final void Mw(int paramInt)
    {
      AppMethodBeat.i(282335);
      if ((this.xvR) && (paramInt > 0))
      {
        Object localObject = g.Xox;
        localObject = aj.d((aj)g.b((AppCompatActivity)this.xNH).i(aj.class));
        if (localObject != null) {
          ((com.tencent.mm.plugin.finder.event.base.f)localObject).dqn().onScrollStateChanged(FinderGallerySearchUI.l(this.xNH), 5);
        }
        this.xvR = false;
      }
      AppMethodBeat.o(282335);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(282332);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      Log.i(FinderGallerySearchUI.c(this.xNH), "onLoadMoreEnd");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(282332);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(282330);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.i(FinderGallerySearchUI.c(this.xNH), "onLoadMoreBegin");
      String str = FinderGallerySearchUI.i(this.xNH);
      if (str != null)
      {
        if (FinderGallerySearchUI.j(this.xNH) != 1) {
          break label78;
        }
        FinderGallerySearchUI.b(this.xNH, str);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(282330);
        return;
        label78:
        FinderGallerySearchUI.k(this.xNH);
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(282339);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(282339);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    e(FinderGallerySearchUI paramFinderGallerySearchUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initSearchView$1$1"})
  static final class f
    implements View.OnClickListener
  {
    f(FinderGallerySearchUI paramFinderGallerySearchUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(289746);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initSearchView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xNH.onClickBackBtn(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initSearchView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(289746);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "suggestion", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    g(FinderGallerySearchUI paramFinderGallerySearchUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initSuggestion$2", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$IVisibleChangeListener;", "onVisibleChange", "", "visibility", "", "plugin-finder_release"})
  public static final class h
    implements k.b
  {
    public final void MJ(int paramInt)
    {
      AppMethodBeat.i(290430);
      if (paramInt == 0)
      {
        FinderGallerySearchUI.e(this.xNH).setVisibility(8);
        FinderGallerySearchUI.f(this.xNH).setVisibility(8);
        FinderGallerySearchUI.g(this.xNH).setVisibility(8);
        AppMethodBeat.o(290430);
        return;
      }
      Object localObject = FinderGallerySearchUI.b(this.xNH).getFtsEditText();
      p.j(localObject, "searchView.ftsEditText");
      localObject = ((FTSEditTextView)localObject).getEditText();
      p.j(localObject, "searchView.ftsEditText.editText");
      if (!Util.isNullOrNil(((EditText)localObject).getText().toString())) {
        FinderGallerySearchUI.g(this.xNH).setVisibility(0);
      }
      AppMethodBeat.o(290430);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class i
    implements Runnable
  {
    i(FinderGallerySearchUI paramFinderGallerySearchUI, aa.d paramd1, aa.d paramd2) {}
    
    public final void run()
    {
      boolean bool2 = true;
      AppMethodBeat.i(272583);
      if (paramq.aaBA != 0)
      {
        Object localObject = RefreshLoadMoreLayout.c.YNO;
        localObject = new RefreshLoadMoreLayout.c(RefreshLoadMoreLayout.c.iht());
        if (FinderGallerySearchUI.j(this.xNH) != 0)
        {
          bool1 = true;
          ((RefreshLoadMoreLayout.c)localObject).YNF = bool1;
          if (locald.aaBA - paramq.aaBA > 0) {
            break label115;
          }
        }
        label115:
        for (boolean bool1 = bool2;; bool1 = false)
        {
          ((RefreshLoadMoreLayout.c)localObject).mCI = bool1;
          ((RefreshLoadMoreLayout.c)localObject).YNG = (locald.aaBA - paramq.aaBA);
          FinderGallerySearchUI.g(this.xNH).onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.c)localObject);
          AppMethodBeat.o(272583);
          return;
          bool1 = false;
          break;
        }
      }
      FinderGallerySearchUI.g(this.xNH).azs(locald.aaBA);
      AppMethodBeat.o(272583);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGallerySearchUI
 * JD-Core Version:    0.7.0.1
 */