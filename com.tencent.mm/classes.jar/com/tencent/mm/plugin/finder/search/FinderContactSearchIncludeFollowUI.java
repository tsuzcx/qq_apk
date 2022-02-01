package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.dk;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.aa;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.buy;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(7)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "contactList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/protocal/protobuf/FinderSearchInfo;", "Lkotlin/collections/ArrayList;", "continueFlag", "", "exposeMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "fromAtContact", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mainContainer", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "needHistory", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", "query", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "requestId", "requestType", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rootView", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "topicList", "Lcom/tencent/mm/protocal/protobuf/FinderTopicSearchInfo;", "addExposeItem", "", "id", "position", "type", "enableActivityAnimation", "finish", "getContactSize", "getLayoutId", "handleSearch", "initContentView", "initData", "initSearchView", "isTopicSearch", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onContactItemClick", "finderSearchInfo", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onTagClick", "index", "tag", "reportSearchExpose", "needClear", "startSearch", "Companion", "ContactSearchProfileAdapter", "HeaderViewHolder", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderContactSearchIncludeFollowUI
  extends MMActivity
  implements com.tencent.mm.am.h, FTSEditTextView.c, FTSSearchView.b
{
  public static final a FvA;
  static final String TAG;
  private RefreshLoadMoreLayout ATx;
  private com.tencent.mm.bx.b BgS;
  private ArrayList<buy> BmO;
  private TextView BnA;
  private j BnB;
  private dk BnD;
  private FTSSearchView Bny;
  private ArrayList<bxx> FvB;
  private boolean FvC;
  private boolean FvD;
  HashMap<String, a> FvE;
  private CoordinatorLayout FvF;
  private int continueFlag;
  private String hOG;
  private RecyclerView mkw;
  private View njN;
  private int offset;
  private int pyl;
  private String query;
  private int requestType;
  private View rootView;
  
  static
  {
    AppMethodBeat.i(342857);
    FvA = new a((byte)0);
    TAG = "Finder.FinderContactSearchIncludeFollowUI";
    AppMethodBeat.o(342857);
  }
  
  public FinderContactSearchIncludeFollowUI()
  {
    AppMethodBeat.i(342780);
    this.query = "";
    this.BmO = new ArrayList();
    this.FvB = new ArrayList();
    this.hOG = "";
    this.FvC = true;
    this.FvE = new HashMap();
    AppMethodBeat.o(342780);
  }
  
  private static final boolean a(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342809);
    kotlin.g.b.s.u(paramFinderContactSearchIncludeFollowUI, "this$0");
    paramMotionEvent = paramFinderContactSearchIncludeFollowUI.Bny;
    paramView = paramMotionEvent;
    if (paramMotionEvent == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().dzv.clearFocus();
    paramFinderContactSearchIncludeFollowUI.hideVKB();
    AppMethodBeat.o(342809);
    return false;
  }
  
  private final void awg(String paramString)
  {
    AppMethodBeat.i(342795);
    tZ(true);
    this.query = paramString;
    this.offset = 0;
    this.continueFlag = 0;
    this.BgS = null;
    if (this.requestType == 4) {
      this.FvB.clear();
    }
    for (;;)
    {
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
      localObject = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
      paramString.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
      localObject = this.rootView;
      paramString = (String)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("rootView");
        paramString = null;
      }
      paramString.setBackground(getContext().getResources().getDrawable(e.b.BG_0));
      AppMethodBeat.o(342795);
      return;
      this.BmO.clear();
    }
  }
  
  private final boolean eOw()
  {
    AppMethodBeat.i(342786);
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
      AppMethodBeat.o(342786);
      return true;
      localObject2 = n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    awg((String)localObject1);
    localObject2 = this.BnB;
    if (localObject2 != null) {
      ((j)localObject2).azd((String)localObject1);
    }
    AppMethodBeat.o(342786);
    return false;
  }
  
  private final int eOx()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342800);
    RecyclerView localRecyclerView = this.mkw;
    Object localObject1 = localRecyclerView;
    if (localRecyclerView == null)
    {
      kotlin.g.b.s.bIx("recyclerView");
      localObject1 = null;
    }
    localObject1 = ((RecyclerView)localObject1).getAdapter();
    if (localObject1 == null) {}
    for (localObject1 = localObject2; localObject1 == null; localObject1 = Integer.valueOf(((RecyclerView.a)localObject1).getItemCount()))
    {
      i = this.BmO.size();
      AppMethodBeat.o(342800);
      return i;
    }
    int i = ((Integer)localObject1).intValue();
    AppMethodBeat.o(342800);
    return i;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(buy parambuy, int paramInt)
  {
    AppMethodBeat.i(342963);
    kotlin.g.b.s.u(parambuy, "finderSearchInfo");
    Object localObject2;
    if (this.FvD)
    {
      Log.i(TAG, "onContactItemClick select atContact");
      localObject1 = com.tencent.mm.plugin.finder.utils.h.Gga;
      localObject2 = parambuy.contact;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new FinderContact();
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.h.i((FinderContact)localObject1);
      localObject2 = getIntent();
      if (localObject1 == null)
      {
        localObject1 = null;
        ((Intent)localObject2).putExtra("at_select_contact", (byte[])localObject1);
        localObject1 = getIntent();
        localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
        parambuy = parambuy.contact;
        if (parambuy != null) {
          break label148;
        }
      }
      label148:
      for (parambuy = null;; parambuy = parambuy.username)
      {
        ((Intent)localObject1).putExtra("is_follow", d.a.a(parambuy, null, false, false, 14));
        setResult(-1, getIntent());
        finish();
        AppMethodBeat.o(342963);
        return;
        localObject1 = ((djg)localObject1).toByteArray();
        break;
      }
    }
    Object localObject3 = new Intent();
    Object localObject1 = parambuy.contact;
    if (localObject1 == null)
    {
      localObject1 = "";
      ((Intent)localObject3).putExtra("finder_username", (String)localObject1);
      localObject1 = as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      as.a.a((Context)localObject1, (Intent)localObject3, 0L, 7, false, 64);
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
      ((com.tencent.mm.plugin.finder.utils.a)localObject1).enterFinderProfileUI((Context)localObject2, (Intent)localObject3);
      localObject1 = aa.Fsi;
      localObject2 = this.hOG;
      localObject3 = this.query;
      localObject1 = parambuy.contact;
      if (localObject1 != null) {
        break label368;
      }
      localObject1 = null;
      label274:
      aa.h((String)localObject2, (String)localObject3, (String)localObject1, paramInt);
      localObject1 = as.GSQ;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null)
      {
        localObject2 = z.FrZ;
        paramInt = ((as)localObject1).AJo;
        parambuy = parambuy.contact;
        if (parambuy != null) {
          break label376;
        }
      }
    }
    label368:
    label376:
    for (parambuy = null;; parambuy = parambuy.username)
    {
      z.a(6, 0L, paramInt, 1, parambuy);
      AppMethodBeat.o(342963);
      return;
      localObject2 = ((FinderContact)localObject1).username;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      localObject1 = ((FinderContact)localObject1).username;
      break label274;
    }
  }
  
  public final boolean aWU()
  {
    AppMethodBeat.i(342941);
    hideVKB();
    if (eOw())
    {
      AppMethodBeat.o(342941);
      return true;
    }
    f.Ozc.idkeyStat(1265L, 9L, 1L, false);
    AppMethodBeat.o(342941);
    return false;
  }
  
  public final void eeU() {}
  
  public final boolean enableActivityAnimation()
  {
    return false;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(342950);
    super.finish();
    int i = e.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(342950);
  }
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(342936);
    if (paramBoolean)
    {
      aa localaa = aa.Fsi;
      aa.eMZ();
    }
    AppMethodBeat.o(342936);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_contact_search_include_follow_ui;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(342910);
    hideVKB();
    finish();
    AppMethodBeat.o(342910);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(342919);
    hideVKB();
    finish();
    AppMethodBeat.o(342919);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(342938);
    FTSSearchView localFTSSearchView = this.Bny;
    paramView = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().aWT();
    showVKB();
    AppMethodBeat.o(342938);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(342897);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramBundle = getWindow();
      paramBundle.addFlags(-2147483648);
      paramBundle.setStatusBarColor(getResources().getColor(e.b.transparent));
    }
    this.Bny = new FTSSearchView((Context)this);
    paramBundle = this.Bny;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
    }
    Object localObject2;
    for (;;)
    {
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
      localObject2 = getSupportActionBar();
      kotlin.g.b.s.checkNotNull(localObject2);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("searchView");
        paramBundle = null;
      }
      ((ActionBar)localObject2).setCustomView((View)paramBundle);
      this.requestType = getIntent().getIntExtra("request_type", 3);
      this.FvD = getIntent().getBooleanExtra("from_at_contact", false);
      this.FvC = getIntent().getBooleanExtra("need_history", false);
      paramBundle = k.FxZ;
      if (k.ePe() == null) {
        break;
      }
      paramBundle = k.FxZ;
      localObject2 = k.ePe();
      kotlin.g.b.s.checkNotNull(localObject2);
      paramBundle = k.FxZ;
      k.a(null);
      localObject1 = ((axg)localObject2).hOG;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.hOG = paramBundle;
      localObject1 = ((axg)localObject2).query;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = "";
      }
      this.query = paramBundle;
      this.offset = ((axg)localObject2).offset;
      this.continueFlag = ((axg)localObject2).continueFlag;
      this.BgS = ((axg)localObject2).BgS;
      this.pyl = ((axg)localObject2).ERV;
      paramBundle = ((axg)localObject2).ZIt;
      kotlin.g.b.s.s(paramBundle, "finderFeedObj.contactList");
      localObject1 = (Iterable)paramBundle;
      paramBundle = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (buy)((Iterator)localObject1).next();
        paramBundle.add(Boolean.valueOf(this.BmO.add(localObject2)));
      }
    }
    paramBundle = UUID.randomUUID().toString();
    kotlin.g.b.s.s(paramBundle, "randomUUID().toString()");
    this.hOG = paramBundle;
    this.query = "";
    Object localObject1 = this.Bny;
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
    if (this.FvC)
    {
      getContext().findViewById(e.e.history_lv).setVisibility(0);
      this.BnB = new j((MMActivity)this, (kotlin.g.a.b)new e(this));
      if (this.FvD) {
        setResult(0, getIntent());
      }
      Log.i(TAG, "fromAtContact:%s", new Object[] { Boolean.valueOf(this.FvD) });
      paramBundle = getContext().findViewById(e.e.root);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.root)");
      this.rootView = paramBundle;
      paramBundle = getContext().findViewById(e.e.main_rv);
      kotlin.g.b.s.s(paramBundle, "context.findViewById(R.id.main_rv)");
      this.FvF = ((CoordinatorLayout)paramBundle);
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
      localObject1 = new FinderLinearLayoutManager((Context)this);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1222;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label806:
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)localObject1);
      paramBundle = this.mkw;
      if (paramBundle != null) {
        break label1225;
      }
      kotlin.g.b.s.bIx("recyclerView");
      paramBundle = null;
      label831:
      paramBundle.setAdapter((RecyclerView.a)new b((byte)0));
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setHasFixedSize(true);
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setItemViewCacheSize(5);
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle.setOnTouchListener(new FinderContactSearchIncludeFollowUI..ExternalSyntheticLambda0(this));
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
        break label1228;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
      label967:
      localObject1 = af.mU((Context)getContext()).inflate(e.f.load_more_footer, null);
      kotlin.g.b.s.s(localObject1, "getInflater(context).inf…t.load_more_footer, null)");
      paramBundle.setLoadMoreFooter((View)localObject1);
      paramBundle = this.ATx;
      if (paramBundle != null) {
        break label1231;
      }
      kotlin.g.b.s.bIx("rlLayout");
      paramBundle = null;
    }
    label1222:
    label1225:
    label1228:
    label1231:
    for (;;)
    {
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new d(this));
      localObject2 = this.query;
      if (localObject2 != null)
      {
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.getFtsEditText().V((String)localObject2, null);
      }
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      paramBundle = paramBundle.getAdapter();
      if (paramBundle != null) {
        paramBundle.bZE.notifyChanged();
      }
      localObject1 = this.mkw;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("recyclerView");
        paramBundle = null;
      }
      localObject1 = c.a(this.pyl, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      paramBundle.scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
      AppMethodBeat.o(342897);
      return;
      getContext().findViewById(e.e.history_lv).setVisibility(8);
      break;
      break label806;
      break label831;
      break label967;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(342944);
    j localj = this.BnB;
    if (localj != null) {
      localj.onDestroy();
    }
    tZ(true);
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    super.onDestroy();
    AppMethodBeat.o(342944);
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    paramList = null;
    AppMethodBeat.i(342929);
    if (paramString1 == null)
    {
      paramString1 = "";
      if (!Util.isNullOrNil(paramString1)) {
        break label148;
      }
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
      label95:
      paramString2.setVisibility(8);
    }
    for (;;)
    {
      paramString2 = this.BnB;
      if (paramString2 != null) {
        paramString2.aAg(paramString1);
      }
      AppMethodBeat.o(342929);
      return;
      paramString2 = n.bq((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      paramString1 = "";
      break;
      label145:
      break label95;
      label148:
      eOw();
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(342956);
    com.tencent.mm.kernel.h.aZW().b(3820, (com.tencent.mm.am.h)this);
    int j = eOx();
    int i = eOx();
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      f.Ozc.idkeyStat(1265L, 10L, 1L, false);
      paramString = this.BnD;
      if (paramString == null) {}
      for (paramString = null; paramString == null; paramString = paramString.ADk)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
        AppMethodBeat.o(342956);
        throw paramString;
      }
      paramp = paramString.KNn;
      kotlin.g.b.s.s(paramp, "response.infoList");
      Object localObject = (Iterable)paramp;
      paramp = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        buy localbuy = (buy)((Iterator)localObject).next();
        paramp.add(Boolean.valueOf(this.BmO.add(localbuy)));
      }
      this.offset = paramString.offset;
      this.continueFlag = paramString.continueFlag;
      this.BgS = paramString.BgS;
      paramInt1 = eOx();
      Log.i(TAG, "onSceneEnd " + paramString.offset + ' ' + paramString.continueFlag + ' ' + this.BmO.size());
      paramp = this.ATx;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("rlLayout");
        paramString = null;
      }
      paramString.aFW(0);
      if (paramInt1 != 0) {
        break label455;
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
    for (;;)
    {
      if (j != 0) {
        break label568;
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
        break label615;
      }
      paramString.bZE.notifyChanged();
      AppMethodBeat.o(342956);
      return;
      f.Ozc.idkeyStat(1265L, 11L, 1L, false);
      paramInt1 = i;
      break;
      label455:
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
      paramp = this.FvF;
      paramString = paramp;
      if (paramp == null)
      {
        kotlin.g.b.s.bIx("mainContainer");
        paramString = null;
      }
      paramString.setVisibility(0);
    }
    label568:
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
    label615:
    AppMethodBeat.o(342956);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final void tZ(boolean paramBoolean)
  {
    AppMethodBeat.i(342958);
    if (!Util.isNullOrNil(this.hOG)) {
      if (((Map)this.FvE).isEmpty()) {
        break label75;
      }
    }
    label75:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        aa localaa = aa.Fsi;
        aa.b(this.hOG, this.query, this.FvE, 2);
        if (paramBoolean) {
          this.FvE.clear();
        }
      }
      AppMethodBeat.o(342958);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "VIEW_TYPE_DEFAULT", "", "VIEW_TYPE_FOLLOW_HEADER", "VIEW_TYPE_UN_FOLLOW_HEADER", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "requestType", "", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;I)V", "existFollowContact", "", "getExistFollowContact", "()Z", "setExistFollowContact", "(Z)V", "getRequestType", "()I", "unFollowContactIndex", "getUnFollowContactIndex", "setUnFollowContactIndex", "(I)V", "bindData", "", "holder", "position", "bindImage", "getItemCount", "getItemViewType", "onBindViewHolder", "payloads", "", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends RecyclerView.a<RecyclerView.v>
  {
    private boolean FvG;
    private int FvH;
    private final int requestType;
    
    private b()
    {
      AppMethodBeat.i(342357);
      this.requestType = 3;
      AppMethodBeat.o(342357);
    }
    
    private static final void a(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI, int paramInt, View paramView)
    {
      AppMethodBeat.i(342387);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramFinderContactSearchIncludeFollowUI);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramFinderContactSearchIncludeFollowUI, "this$0");
      paramView = paramView.getTag();
      if (paramView == null)
      {
        paramFinderContactSearchIncludeFollowUI = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchInfo");
        AppMethodBeat.o(342387);
        throw paramFinderContactSearchIncludeFollowUI;
      }
      paramFinderContactSearchIncludeFollowUI.a((buy)paramView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$ContactSearchProfileAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(342387);
    }
    
    private final void i(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(342376);
      if ((paramv instanceof FinderContactSearchIncludeFollowUI.c))
      {
        if (getItemViewType(paramInt) == 1)
        {
          ((FinderContactSearchIncludeFollowUI.c)paramv).titleTv.setText((CharSequence)this.FvI.getString(e.h.finder_contact_search_follow_header));
          AppMethodBeat.o(342376);
          return;
        }
        ((FinderContactSearchIncludeFollowUI.c)paramv).titleTv.setText((CharSequence)this.FvI.getString(e.h.finder_contact_search_un_follow_header));
        AppMethodBeat.o(342376);
        return;
      }
      buy localbuy;
      Object localObject2;
      Object localObject1;
      if ((this.requestType == 3) && (this.FvG) && (this.FvH != FinderContactSearchIncludeFollowUI.j(this.FvI).size())) {
        if (paramInt < this.FvH + 1)
        {
          localbuy = (buy)FinderContactSearchIncludeFollowUI.j(this.FvI).get(paramInt - 1);
          kotlin.g.b.s.s(localbuy, "if (requestType == Const…sition]\n                }");
          localObject2 = this.FvI;
          localObject1 = localbuy.contact;
          if (localObject1 != null) {
            break label407;
          }
          localObject1 = "";
          label168:
          kotlin.g.b.s.u(localObject1, "id");
          if (!((FinderContactSearchIncludeFollowUI)localObject2).FvE.containsKey(localObject1))
          {
            Log.d(FinderContactSearchIncludeFollowUI.TAG, "addExposeItem " + (String)localObject1 + ' ' + paramInt + ' ' + 1);
            a locala = new a();
            locala.setId((String)localObject1);
            locala.position = paramInt;
            locala.type = 1;
            locala.timeStamp = System.currentTimeMillis();
            ((Map)((FinderContactSearchIncludeFollowUI)localObject2).FvE).put(localObject1, locala);
            if (((FinderContactSearchIncludeFollowUI)localObject2).FvE.size() % 30 == 0) {
              ((FinderContactSearchIncludeFollowUI)localObject2).tZ(false);
            }
          }
          localObject1 = (d)paramv;
          localObject2 = new FinderContactSearchIncludeFollowUI.b..ExternalSyntheticLambda0(this.FvI, paramInt);
          if (paramInt == 0) {
            break label429;
          }
        }
      }
      label407:
      label429:
      for (boolean bool = true;; bool = false)
      {
        d.a((d)localObject1, localbuy, (View.OnClickListener)localObject2, bool, 4);
        paramv = paramv.caK.findViewById(e.e.follow_tv);
        if (paramv != null) {
          paramv.setVisibility(8);
        }
        AppMethodBeat.o(342376);
        return;
        localbuy = (buy)FinderContactSearchIncludeFollowUI.j(this.FvI).get(paramInt - 2);
        break;
        localbuy = (buy)FinderContactSearchIncludeFollowUI.j(this.FvI).get(paramInt);
        break;
        localObject1 = ((FinderContact)localObject1).username;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label168;
        }
        break label168;
      }
    }
    
    public final void a(RecyclerView.v paramv, int paramInt, List<Object> paramList)
    {
      AppMethodBeat.i(342418);
      kotlin.g.b.s.u(paramv, "holder");
      kotlin.g.b.s.u(paramList, "payloads");
      i(paramv, paramInt);
      AppMethodBeat.o(342418);
    }
    
    public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(342414);
      kotlin.g.b.s.u(paramViewGroup, "parent");
      if (paramInt == 3)
      {
        localObject = this.FvI.getContext();
        kotlin.g.b.s.checkNotNull(localObject);
        paramViewGroup = ((AppCompatActivity)localObject).getLayoutInflater().inflate(e.f.finder_contact_search_item, paramViewGroup, false);
        kotlin.g.b.s.s(paramViewGroup, "contactLayout");
        paramViewGroup = (RecyclerView.v)new d(paramViewGroup);
        AppMethodBeat.o(342414);
        return paramViewGroup;
      }
      Object localObject = this.FvI;
      AppCompatActivity localAppCompatActivity = this.FvI.getContext();
      kotlin.g.b.s.checkNotNull(localAppCompatActivity);
      paramViewGroup = localAppCompatActivity.getLayoutInflater().inflate(e.f.finder_post_at_header_item, paramViewGroup, false);
      kotlin.g.b.s.s(paramViewGroup, "context!!.layoutInflater…ader_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new FinderContactSearchIncludeFollowUI.c((FinderContactSearchIncludeFollowUI)localObject, paramViewGroup);
      AppMethodBeat.o(342414);
      return paramViewGroup;
    }
    
    public final void d(RecyclerView.v paramv, int paramInt)
    {
      AppMethodBeat.i(342421);
      kotlin.g.b.s.u(paramv, "holder");
      i(paramv, paramInt);
      AppMethodBeat.o(342421);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(342402);
      if ((this.requestType == 3) && (FinderContactSearchIncludeFollowUI.j(this.FvI).size() != 0))
      {
        this.FvH = 0;
        this.FvG = false;
        Iterator localIterator = FinderContactSearchIncludeFollowUI.j(this.FvI).iterator();
        if (localIterator.hasNext())
        {
          buy localbuy = (buy)localIterator.next();
          Object localObject = FinderContactSearchIncludeFollowUI.FvA;
          String str = FinderContactSearchIncludeFollowUI.access$getTAG$cp();
          localObject = localbuy.contact;
          if (localObject == null)
          {
            localObject = null;
            label89:
            Log.i(str, kotlin.g.b.s.X("getItemCount isFollow:", localObject));
            localObject = com.tencent.mm.plugin.finder.api.d.AwY;
            localObject = localbuy.contact;
            if (localObject != null) {
              break label155;
            }
          }
          label155:
          for (localObject = null;; localObject = ((FinderContact)localObject).username)
          {
            if (!d.a.a((String)localObject, null, false, false, 14)) {
              break label163;
            }
            this.FvG = true;
            this.FvH += 1;
            break;
            localObject = ((FinderContact)localObject).username;
            break label89;
          }
        }
        label163:
        if (this.FvG)
        {
          if (this.FvH == FinderContactSearchIncludeFollowUI.j(this.FvI).size())
          {
            i = FinderContactSearchIncludeFollowUI.j(this.FvI).size();
            AppMethodBeat.o(342402);
            return i;
          }
          i = FinderContactSearchIncludeFollowUI.j(this.FvI).size();
          AppMethodBeat.o(342402);
          return i + 2;
        }
      }
      int i = FinderContactSearchIncludeFollowUI.j(this.FvI).size();
      AppMethodBeat.o(342402);
      return i;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(342405);
      if ((this.requestType == 3) && (this.FvG))
      {
        if (this.FvH == FinderContactSearchIncludeFollowUI.j(this.FvI).size())
        {
          AppMethodBeat.o(342405);
          return 3;
        }
        if (paramInt == 0)
        {
          AppMethodBeat.o(342405);
          return 1;
        }
        if (paramInt == this.FvH + 1)
        {
          AppMethodBeat.o(342405);
          return 2;
        }
      }
      AppMethodBeat.o(342405);
      return 3;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$HeaderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI;Landroid/view/View;)V", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "setTitleTv", "(Landroid/widget/TextView;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends RecyclerView.v
  {
    TextView titleTv;
    
    public c()
    {
      super();
      AppMethodBeat.i(342354);
      this$1 = localObject.findViewById(e.e.title_tv);
      kotlin.g.b.s.s(FinderContactSearchIncludeFollowUI.this, "itemView.findViewById(R.id.title_tv)");
      this.titleTv = ((TextView)FinderContactSearchIncludeFollowUI.this);
      AppMethodBeat.o(342354);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderContactSearchIncludeFollowUI$initContentView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RefreshLoadMoreLayout.b
  {
    d(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI) {}
    
    public final void qI(int paramInt)
    {
      RefreshLoadMoreLayout localRefreshLoadMoreLayout2 = null;
      RefreshLoadMoreLayout localRefreshLoadMoreLayout1 = null;
      AppMethodBeat.i(342349);
      Object localObject = FinderContactSearchIncludeFollowUI.FvA;
      Log.i(FinderContactSearchIncludeFollowUI.access$getTAG$cp(), "onLoadMoreBegin");
      localObject = FinderContactSearchIncludeFollowUI.b(this.FvI);
      if (localObject != null)
      {
        FinderContactSearchIncludeFollowUI localFinderContactSearchIncludeFollowUI = this.FvI;
        if (FinderContactSearchIncludeFollowUI.c(localFinderContactSearchIncludeFollowUI) == 1)
        {
          FinderContactSearchIncludeFollowUI.a(localFinderContactSearchIncludeFollowUI, new dk((String)localObject, FinderContactSearchIncludeFollowUI.d(localFinderContactSearchIncludeFollowUI), FinderContactSearchIncludeFollowUI.e(localFinderContactSearchIncludeFollowUI), FinderContactSearchIncludeFollowUI.f(localFinderContactSearchIncludeFollowUI), FinderContactSearchIncludeFollowUI.g(localFinderContactSearchIncludeFollowUI), null, null, null, 480));
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)FinderContactSearchIncludeFollowUI.h(localFinderContactSearchIncludeFollowUI), 0);
          com.tencent.mm.kernel.h.aZW().a(3820, (com.tencent.mm.am.h)localFinderContactSearchIncludeFollowUI);
          localRefreshLoadMoreLayout2 = FinderContactSearchIncludeFollowUI.i(localFinderContactSearchIncludeFollowUI);
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
          localRefreshLoadMoreLayout2 = FinderContactSearchIncludeFollowUI.i(localFinderContactSearchIncludeFollowUI);
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
            localRefreshLoadMoreLayout2 = FinderContactSearchIncludeFollowUI.i(localFinderContactSearchIncludeFollowUI);
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
            AppMethodBeat.o(342349);
            return;
            localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
            break;
          }
        }
        localRefreshLoadMoreLayout1 = FinderContactSearchIncludeFollowUI.i(localFinderContactSearchIncludeFollowUI);
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
        localRefreshLoadMoreLayout1 = FinderContactSearchIncludeFollowUI.i(localFinderContactSearchIncludeFollowUI);
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
        localRefreshLoadMoreLayout1 = FinderContactSearchIncludeFollowUI.i(localFinderContactSearchIncludeFollowUI);
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
        AppMethodBeat.o(342349);
        return;
        localObject = (TextView)((View)localObject).findViewById(e.e.load_more_footer_tip_tv);
        break;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    e(FinderContactSearchIncludeFollowUI paramFinderContactSearchIncludeFollowUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderContactSearchIncludeFollowUI
 * JD-Core Version:    0.7.0.1
 */