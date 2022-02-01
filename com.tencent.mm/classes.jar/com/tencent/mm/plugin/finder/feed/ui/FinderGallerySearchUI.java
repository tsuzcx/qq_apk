package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.cgi.dk;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.gallery.b.a;
import com.tencent.mm.plugin.finder.gallery.b.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.aa;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.search.l;
import com.tencent.mm.plugin.finder.search.l.b;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.m;
import com.tencent.mm.view.recyclerview.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "continueFlag", "", "feedList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "galleryConfig", "Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "getGalleryConfig", "()Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;", "setGalleryConfig", "(Lcom/tencent/mm/plugin/finder/gallery/FinderGalleryConfig;)V", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "isOtherEnableFullScreenEnjoy", "", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestId", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchSuggestionManager", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;", "searchType", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "tabType", "getTabType", "()I", "addClickItem", "", "id", "position", "addExposeItem", "addFinderObject", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getLayoutId", "goBack", "initContentView", "initData", "initSearchView", "initSuggestion", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onSwipeBack", "onTagClick", "index", "tag", "showLoadMoreFooter", "showNoMoreFooter", "startSearch", "hotSessionBuffer", "startSearchNextPage", "isPreload", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderGallerySearchUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, FTSEditTextView.c, FTSSearchView.b
{
  private RefreshLoadMoreLayout ATx;
  private com.tencent.mm.bx.b BgS;
  private TextView BnA;
  private com.tencent.mm.plugin.finder.search.j BnB;
  private l BnC;
  private dk BnD;
  public com.tencent.mm.plugin.finder.gallery.b Bnx;
  private FTSSearchView Bny;
  private boolean Bnz;
  private final String TAG;
  private int continueFlag;
  private ArrayList<cc> feedList;
  final int hJx;
  String hOG;
  private RecyclerView mkw;
  private View njN;
  private int offset;
  String query;
  int xVf;
  
  public FinderGallerySearchUI()
  {
    AppMethodBeat.i(365361);
    this.TAG = "Finder.FinderGallerySearchUI";
    this.query = "";
    this.feedList = new ArrayList();
    this.hOG = "";
    this.xVf = 1;
    this.hJx = 10000;
    AppMethodBeat.o(365361);
  }
  
  private static final void a(FinderGallerySearchUI paramFinderGallerySearchUI, View paramView)
  {
    AppMethodBeat.i(365401);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderGallerySearchUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderGallerySearchUI, "this$0");
    paramFinderGallerySearchUI.onClickBackBtn(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365401);
  }
  
  private static final void a(ah.d paramd1, FinderGallerySearchUI paramFinderGallerySearchUI, ah.d paramd2, boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(365417);
    kotlin.g.b.s.u(paramd1, "$originSize");
    kotlin.g.b.s.u(paramFinderGallerySearchUI, "this$0");
    kotlin.g.b.s.u(paramd2, "$currentSize");
    Object localObject;
    boolean bool1;
    if (paramd1.aixb != 0)
    {
      localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMH());
      if (paramFinderGallerySearchUI.continueFlag != 0)
      {
        bool1 = true;
        ((RefreshLoadMoreLayout.d)localObject).agJu = bool1;
        if (paramd2.aixb - paramd1.aixb > 0) {
          break label241;
        }
        bool1 = bool2;
        label86:
        ((RefreshLoadMoreLayout.d)localObject).pzq = bool1;
        ((RefreshLoadMoreLayout.d)localObject).agJv = (paramd2.aixb - paramd1.aixb);
        paramd2 = paramFinderGallerySearchUI.ATx;
        paramd1 = paramd2;
        if (paramd2 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          paramd1 = null;
        }
        paramd1.onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject);
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        paramFinderGallerySearchUI = paramFinderGallerySearchUI.mkw;
        paramd1 = paramFinderGallerySearchUI;
        if (paramFinderGallerySearchUI == null)
        {
          kotlin.g.b.s.bIx("recyclerView");
          paramd1 = null;
        }
        paramFinderGallerySearchUI = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramd1, paramFinderGallerySearchUI.aYi(), "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI", "onSceneEnd$lambda-6", "(Lkotlin/jvm/internal/Ref$IntRef;Lcom/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI;Lkotlin/jvm/internal/Ref$IntRef;Z)V", "Undefined", "scrollToPosition", "(I)V");
        paramd1.scrollToPosition(((Integer)paramFinderGallerySearchUI.sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramd1, "com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI", "onSceneEnd$lambda-6", "(Lkotlin/jvm/internal/Ref$IntRef;Lcom/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI;Lkotlin/jvm/internal/Ref$IntRef;Z)V", "Undefined", "scrollToPosition", "(I)V");
      }
      AppMethodBeat.o(365417);
      return;
      bool1 = false;
      break;
      label241:
      bool1 = false;
      break label86;
      localObject = paramFinderGallerySearchUI.ATx;
      paramd1 = (ah.d)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramd1 = null;
      }
      paramd1.aFW(paramd2.aixb);
    }
  }
  
  private static final boolean a(FinderGallerySearchUI paramFinderGallerySearchUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(365408);
    kotlin.g.b.s.u(paramFinderGallerySearchUI, "this$0");
    paramMotionEvent = paramFinderGallerySearchUI.Bny;
    paramView = paramMotionEvent;
    if (paramMotionEvent == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().dzv.clearFocus();
    paramFinderGallerySearchUI.hideVKB();
    AppMethodBeat.o(365408);
    return false;
  }
  
  private final void awb(String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(365376);
    Log.i(this.TAG, kotlin.g.b.s.X("startSearch query:", paramString));
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.BgS = null;
    this.feedList.clear();
    Object localObject2 = UUID.randomUUID().toString();
    kotlin.g.b.s.s(localObject2, "randomUUID().toString()");
    this.hOG = ((String)localObject2);
    if (this.BnD != null) {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD);
    }
    int i;
    switch (eeT().But.mUU)
    {
    default: 
      i = 0;
      int j = this.offset;
      localObject2 = this.hOG;
      com.tencent.mm.bx.b localb = this.BgS;
      com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
      this.BnD = new dk(paramString, j, (String)localObject2, localb, i, ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(as.class)).fou(), null, null, 384);
      paramString = this.BnD;
      if (paramString != null) {
        paramString.xVf = this.xVf;
      }
      paramString = this.BnD;
      if (paramString != null) {
        paramString.ADh = false;
      }
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.BnD, 0);
      com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)this);
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
      paramString = this.ATx;
      if (paramString == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = localObject1;
      }
      break;
    }
    for (;;)
    {
      paramString.setVisibility(8);
      AppMethodBeat.o(365376);
      return;
      i = 15;
      break;
      i = 16;
      break;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean aWU()
  {
    Object localObject3 = null;
    AppMethodBeat.i(365585);
    hideVKB();
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
      AppMethodBeat.o(365585);
      return true;
      localObject2 = kotlin.n.n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    this.xVf = 1;
    awb((String)localObject1);
    com.tencent.mm.plugin.finder.search.j localj = this.BnB;
    localObject2 = localj;
    if (localj == null)
    {
      kotlin.g.b.s.bIx("historyLogic");
      localObject2 = null;
    }
    ((com.tencent.mm.plugin.finder.search.j)localObject2).azd((String)localObject1);
    localObject1 = this.BnC;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("searchSuggestionManager");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((l)localObject1).ePg();
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 6L, 1L, false);
      AppMethodBeat.o(365585);
      return false;
    }
  }
  
  public final com.tencent.mm.plugin.finder.gallery.b eeT()
  {
    AppMethodBeat.i(365514);
    com.tencent.mm.plugin.finder.gallery.b localb = this.Bnx;
    if (localb != null)
    {
      AppMethodBeat.o(365514);
      return localb;
    }
    kotlin.g.b.s.bIx("galleryConfig");
    AppMethodBeat.o(365514);
    return null;
  }
  
  public final void eeU() {}
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(365570);
    if (paramBoolean)
    {
      aa localaa = aa.Fsi;
      aa.eMZ();
    }
    AppMethodBeat.o(365570);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_gallery_feed_search_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(365541);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    eeT().a((MMActivity)this, paramInt1, paramInt2, paramIntent, b.b.Buv);
    AppMethodBeat.o(365541);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(365623);
    finish();
    AppMethodBeat.o(365623);
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(365553);
    hideVKB();
    finish();
    AppMethodBeat.o(365553);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(365557);
    hideVKB();
    finish();
    AppMethodBeat.o(365557);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(365579);
    FTSSearchView localFTSSearchView = this.Bny;
    paramView = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().aWT();
    showVKB();
    AppMethodBeat.o(365579);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365533);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.gallery.b.Bus;
    paramBundle = getIntent();
    kotlin.g.b.s.s(paramBundle, "intent");
    paramBundle = b.a.au(paramBundle);
    kotlin.g.b.s.u(paramBundle, "<set-?>");
    this.Bnx = paramBundle;
    this.Bnz = eeT().egw();
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
      paramBundle.getFtsEditText().setHint(getString(e.h.app_search));
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
      if (this.Bnz)
      {
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.findViewById(e.e.cancel_btn).setVisibility(8);
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getSearchContainer().setBackground(null);
        int i = getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_64);
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getFtsEditText().getEditText().setTextColor(i);
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getSearchIcon().setIconColor(i);
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getFtsEditText().getClearBtn().getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.setBackgroundColor(getResources().getColor(e.b.full_black));
        setActionbarColor(getResources().getColor(e.b.full_black));
      }
      localObject2 = getSupportActionBar();
      if (localObject2 != null)
      {
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        ((ActionBar)localObject2).setCustomView((View)paramBundle);
      }
      ((FrameLayout)findViewById(e.e.full_actionbar)).setVisibility(8);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle = (WeImageView)paramBundle.findViewById(e.e.back_btn);
      if (paramBundle != null)
      {
        paramBundle.setVisibility(0);
        if (this.Bnz) {
          paramBundle.setIconColor(getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_64));
        }
        paramBundle.setOnClickListener(new FinderGallerySearchUI..ExternalSyntheticLambda0(this));
      }
      paramBundle = com.tencent.mm.plugin.finder.search.k.FxZ;
      com.tencent.mm.plugin.finder.search.k.ePf().clear();
      paramBundle = UUID.randomUUID().toString();
      kotlin.g.b.s.s(paramBundle, "randomUUID().toString()");
      this.hOG = paramBundle;
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
      this.BnB = new com.tencent.mm.plugin.finder.search.j((MMActivity)this, this.Bnz, (kotlin.g.a.b)new d(this));
      localObject2 = (MMActivity)this;
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle = paramBundle.getFtsEditText();
      kotlin.g.b.s.s(paramBundle, "searchView.ftsEditText");
      this.BnC = new l((MMActivity)localObject2, paramBundle, 0, 3, this.Bnz, false, (kotlin.g.a.b)new e(this));
      paramBundle = this.BnC;
      if (paramBundle != null) {
        break label1276;
      }
      kotlin.g.b.s.bIx("searchSuggestionManager");
      paramBundle = null;
      label756:
      paramBundle.a((l.b)new f(this));
      paramBundle = getContext().findViewById(e.e.rl_layout);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.rl_layout)");
      this.ATx = ((RefreshLoadMoreLayout)paramBundle);
      localObject1 = this.ATx;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
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
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1279;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label890:
      paramBundle.setLayoutManager(eeT().aq((Context)this, this.hJx));
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.a(eeT().Ot(this.hJx));
      localObject1 = new WxRecyclerAdapter(eeT().Os(this.hJx), this.feedList, true);
      ((i)localObject1).agOe = ((i.c)new a(this));
      ((WxRecyclerAdapter)localObject1).agOS = ((o)new b(this));
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1282;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label1014:
      paramBundle.setAdapter((RecyclerView.a)localObject1);
      localObject2 = af.mU((Context)getContext()).inflate(e.f.load_more_footer, null);
      localObject1 = this.ATx;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramBundle = null;
      }
      kotlin.g.b.s.s(localObject2, "loadmoreFooter");
      paramBundle.setLoadMoreFooter((View)localObject2);
      if (this.Bnz) {
        break label1285;
      }
      localObject1 = this.BnA;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramBundle = null;
      }
      paramBundle.setTextColor(getResources().getColor(e.b.hint_text_color));
      label1114:
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setOnTouchListener(new FinderGallerySearchUI..ExternalSyntheticLambda1(this));
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
        break label1374;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
    }
    label1282:
    label1285:
    label1374:
    for (;;)
    {
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new c(this));
      localObject2 = this.query;
      if (localObject2 != null)
      {
        localObject1 = this.BnC;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchSuggestionManager");
          paramBundle = null;
        }
        paramBundle.aAj((String)localObject2);
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getFtsEditText().V((String)localObject2, null);
      }
      AppMethodBeat.o(365533);
      return;
      break;
      label1276:
      break label756;
      label1279:
      break label890;
      break label1014;
      localObject1 = this.BnA;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("noResultView");
        paramBundle = null;
      }
      paramBundle.setTextColor(getResources().getColor(e.b.hot_tab_BW93));
      ((TouchableLayout)findViewById(e.e.uiContainer)).setBackgroundColor(getResources().getColor(e.b.full_black));
      paramBundle = (TextView)((View)localObject2).findViewById(e.e.load_more_footer_tip_tv);
      if (paramBundle == null) {
        break label1114;
      }
      paramBundle.setTextColor(getResources().getColor(e.b.BW_100_Alpha_0_3));
      break label1114;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365598);
    Object localObject = com.tencent.mm.plugin.finder.search.k.FxZ;
    com.tencent.mm.plugin.finder.search.k.ePf().clear();
    com.tencent.mm.plugin.finder.search.j localj = this.BnB;
    localObject = localj;
    if (localj == null)
    {
      kotlin.g.b.s.bIx("historyLogic");
      localObject = null;
    }
    ((com.tencent.mm.plugin.finder.search.j)localObject).onDestroy();
    com.tencent.mm.plugin.finder.storage.data.f.FMT.clearCache();
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(365598);
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    paramList = null;
    AppMethodBeat.i(365567);
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
        paramd = this.ATx;
        paramString2 = paramd;
        if (paramd == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          paramString2 = null;
        }
        paramString2.setVisibility(8);
      }
      paramString2 = this.BnB;
      if (paramString2 != null) {
        break label158;
      }
      kotlin.g.b.s.bIx("historyLogic");
      paramString2 = paramList;
    }
    label158:
    for (;;)
    {
      paramString2.aAg(paramString1);
      AppMethodBeat.o(365567);
      return;
      paramString2 = kotlin.n.n.bq((CharSequence)paramString1).toString();
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
    AppMethodBeat.i(365641);
    super.onPause();
    l locall2 = this.BnC;
    l locall1 = locall2;
    if (locall2 == null)
    {
      kotlin.g.b.s.bIx("searchSuggestionManager");
      locall1 = null;
    }
    locall1.onActivityPause();
    AppMethodBeat.o(365641);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(365633);
    super.onResume();
    l locall2 = this.BnC;
    l locall1 = locall2;
    if (locall2 == null)
    {
      kotlin.g.b.s.bIx("searchSuggestionManager");
      locall1 = null;
    }
    locall1.onActivityResume();
    AppMethodBeat.o(365633);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(365614);
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    ah.d locald1 = new ah.d();
    locald1.aixb = this.feedList.size();
    ah.d locald2 = new ah.d();
    locald2.aixb = this.feedList.size();
    boolean bool;
    if (this.continueFlag != 0)
    {
      bool = true;
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label622;
      }
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 7L, 1L, false);
      paramString = this.BnD;
      if (paramString != null) {
        break label133;
      }
    }
    label133:
    for (paramString = null;; paramString = paramString.ADk)
    {
      if (paramString != null) {
        break label141;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
      AppMethodBeat.o(365614);
      throw paramString;
      bool = false;
      break;
    }
    label141:
    paramp = paramString.AdW;
    kotlin.g.b.s.s(paramp, "response.objectList");
    Object localObject1 = (Iterable)paramp;
    paramp = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (FinderObject)((Iterator)localObject1).next();
      kotlin.g.b.s.s(localObject2, "it");
      Object localObject3 = FinderItem.Companion;
      localObject2 = FinderItem.a.e((FinderObject)localObject2, 16);
      localObject3 = com.tencent.mm.plugin.finder.search.k.FxZ;
      ((Map)com.tencent.mm.plugin.finder.search.k.ePf()).put(Long.valueOf(((FinderItem)localObject2).getId()), localObject2);
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      localObject2 = d.a.a((FinderItem)localObject2);
      this.feedList.add(localObject2);
      paramp.add(ah.aiuX);
    }
    this.offset = paramString.offset;
    this.continueFlag = paramString.continueFlag;
    this.BgS = paramString.BgS;
    locald2.aixb = this.feedList.size();
    paramp = this.TAG;
    localObject1 = new StringBuilder("onSceneEnd ").append(paramString.offset).append(' ').append(paramString.continueFlag).append(' ').append(this.feedList.size()).append(' ');
    paramString = this.BnD;
    if (paramString == null)
    {
      paramString = null;
      Log.i(paramp, paramString);
      label415:
      if (locald2.aixb != 0) {
        break label639;
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
      label506:
      if (locald1.aixb != 0) {
        break label725;
      }
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
    }
    for (;;)
    {
      paramp = this.ATx;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = null;
      }
      paramString.post(new FinderGallerySearchUI..ExternalSyntheticLambda2(locald1, this, locald2, bool));
      AppMethodBeat.o(365614);
      return;
      paramString = paramString.ADj;
      if (paramString == null)
      {
        paramString = null;
        break;
      }
      paramString = paramString.aacq;
      break;
      label622:
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1265L, 8L, 1L, false);
      break label415;
      label639:
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
      break label506;
      label725:
      if (locald1.aixb < locald2.aixb)
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
          paramString.bA(locald1.aixb, locald2.aixb - locald1.aixb);
        }
      }
    }
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(365590);
    super.onSwipeBack();
    hideVKB();
    AppMethodBeat.o(365590);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$1", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    a(FinderGallerySearchUI paramFinderGallerySearchUI) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$2", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "wxRVData", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements o
  {
    b(FinderGallerySearchUI paramFinderGallerySearchUI) {}
    
    public final void a(RecyclerView paramRecyclerView, m paramm)
    {
      AppMethodBeat.i(365526);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      kotlin.g.b.s.u(paramm, "wxRVData");
      if ((paramm.state == 0) || (paramm.state == 8))
      {
        paramRecyclerView = (Iterable)paramm.agOB;
        paramm = this.BnE;
        Iterator localIterator = paramRecyclerView.iterator();
        while (localIterator.hasNext())
        {
          paramRecyclerView = (com.tencent.mm.view.recyclerview.n)localIterator.next();
          com.tencent.mm.view.recyclerview.a locala = paramRecyclerView.agOG;
          if ((locala instanceof BaseFinderFeed))
          {
            String str1 = com.tencent.mm.ae.d.hF(locala.bZA());
            int i = paramRecyclerView.AOn;
            kotlin.g.b.s.u(str1, "id");
            paramRecyclerView = z.FrZ;
            String str2 = paramm.hOG;
            String str3 = paramm.query;
            paramRecyclerView = z.FrZ;
            String str4 = z.eMW();
            int j = paramm.xVf;
            paramRecyclerView = as.GSQ;
            paramRecyclerView = as.a.hu((Context)paramm);
            if (paramRecyclerView == null) {}
            for (paramRecyclerView = null;; paramRecyclerView = paramRecyclerView.fou())
            {
              z.a(str2, str3, 2, 2, str1, i, 3, str4, 1, j, paramRecyclerView);
              paramRecyclerView = com.tencent.mm.plugin.finder.gallery.f.BuT;
              com.tencent.mm.plugin.finder.gallery.f.R(locala.bZA(), paramm.hJx);
              break;
            }
          }
        }
      }
      AppMethodBeat.o(365526);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initContentView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "loadMoreType", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RefreshLoadMoreLayout.b
  {
    private boolean ATC = true;
    
    c(FinderGallerySearchUI paramFinderGallerySearchUI) {}
    
    public final void ND(int paramInt)
    {
      AppMethodBeat.i(365558);
      if ((this.ATC) && (paramInt > 0))
      {
        Object localObject1 = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = com.tencent.mm.ui.component.k.d((AppCompatActivity)this.BnE).q(as.class);
        kotlin.g.b.s.s(localObject1, "UICProvider.of(this@Find…rReporterUIC::class.java)");
        Object localObject2 = as.b((as)localObject1);
        if (localObject2 != null)
        {
          localObject1 = this.BnE;
          RecyclerView.l locall = ((com.tencent.mm.plugin.finder.event.base.f)localObject2).dYJ();
          localObject2 = FinderGallerySearchUI.m((FinderGallerySearchUI)localObject1);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("recyclerView");
            localObject1 = null;
          }
          locall.onScrollStateChanged((RecyclerView)localObject1, 5);
        }
        this.ATC = false;
      }
      AppMethodBeat.o(365558);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(365551);
      kotlin.g.b.s.u(paramd, "reason");
      Log.i(FinderGallerySearchUI.c(this.BnE), "onLoadMoreEnd");
      AppMethodBeat.o(365551);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(365545);
      Log.i(FinderGallerySearchUI.c(this.BnE), "onLoadMoreBegin");
      String str = FinderGallerySearchUI.i(this.BnE);
      if (str != null)
      {
        FinderGallerySearchUI localFinderGallerySearchUI = this.BnE;
        if (FinderGallerySearchUI.k(localFinderGallerySearchUI) == 1)
        {
          FinderGallerySearchUI.b(localFinderGallerySearchUI, str);
          AppMethodBeat.o(365545);
          return;
        }
        FinderGallerySearchUI.l(localFinderGallerySearchUI);
      }
      AppMethodBeat.o(365545);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    d(FinderGallerySearchUI paramFinderGallerySearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "suggestion", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    e(FinderGallerySearchUI paramFinderGallerySearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderGallerySearchUI$initSuggestion$2", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager$IVisibleChangeListener;", "onVisibleChange", "", "visibility", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements l.b
  {
    f(FinderGallerySearchUI paramFinderGallerySearchUI) {}
    
    public final void Oh(int paramInt)
    {
      Object localObject2 = null;
      FTSSearchView localFTSSearchView = null;
      AppMethodBeat.i(365516);
      if (paramInt == 0)
      {
        localObject2 = FinderGallerySearchUI.e(this.BnE);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("loadingView");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(8);
        localObject2 = FinderGallerySearchUI.f(this.BnE);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("noResultView");
          localObject1 = null;
        }
        ((TextView)localObject1).setVisibility(8);
        localObject1 = FinderGallerySearchUI.g(this.BnE);
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("rlLayout");
          localObject1 = localFTSSearchView;
        }
        for (;;)
        {
          ((RefreshLoadMoreLayout)localObject1).setVisibility(8);
          AppMethodBeat.o(365516);
          return;
        }
      }
      localFTSSearchView = FinderGallerySearchUI.b(this.BnE);
      Object localObject1 = localFTSSearchView;
      if (localFTSSearchView == null)
      {
        kotlin.g.b.s.bIx("searchView");
        localObject1 = null;
      }
      if (!Util.isNullOrNil(((FTSSearchView)localObject1).getFtsEditText().getEditText().getText().toString()))
      {
        localObject1 = FinderGallerySearchUI.g(this.BnE);
        if (localObject1 != null) {
          break label179;
        }
        kotlin.g.b.s.bIx("rlLayout");
        localObject1 = localObject2;
      }
      label179:
      for (;;)
      {
        ((RefreshLoadMoreLayout)localObject1).setVisibility(0);
        AppMethodBeat.o(365516);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderGallerySearchUI
 * JD-Core Version:    0.7.0.1
 */