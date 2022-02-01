package com.tencent.mm.plugin.finder.search;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.e;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.accessibility.q;
import com.tencent.mm.plugin.finder.e.a;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.n;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.report.aa;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.FTSEditTextView.d;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.4;
import com.tencent.mm.ui.search.FTSSearchView.b;
import com.tencent.mm.ui.search.FTSSearchView.c;
import com.tencent.mm.ui.widget.pulldown.f;
import com.tencent.mm.ui.y;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "isHotSearchEnable", "", "mOnScrollListener", "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "searchSceneForPull", "", "searchSuggestionManager", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "adapteNightMode", "", "finish", "getCommentScene", "getLayoutId", "getReportType", "initData", "initSearchView", "initSuggestion", "isFinderLiveSearch", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onPause", "onResume", "onSearchKeyDown", "onSwipeBack", "onTagClick", "index", "tag", "reportStartSearch", "requestSearch", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderMixSearchUI
  extends MMFinderUI
  implements FTSEditTextView.c, FTSSearchView.b
{
  public static final a Fxi;
  private j BnB;
  private l BnC;
  private FTSSearchView Bny;
  private h Fxj;
  private boolean Fxk;
  private int Fxl;
  private final e Fxm;
  public FinderMixSearchPresenter presenter;
  
  static
  {
    AppMethodBeat.i(342764);
    Fxi = new a((byte)0);
    AppMethodBeat.o(342764);
  }
  
  public FinderMixSearchUI()
  {
    AppMethodBeat.i(342720);
    this.Fxm = new e();
    AppMethodBeat.o(342720);
  }
  
  private static final boolean a(FinderMixSearchUI paramFinderMixSearchUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(342734);
    s.u(paramFinderMixSearchUI, "this$0");
    paramMotionEvent = paramFinderMixSearchUI.Bny;
    paramView = paramMotionEvent;
    if (paramMotionEvent == null)
    {
      s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().dzv.clearFocus();
    paramFinderMixSearchUI.hideVKB();
    AppMethodBeat.o(342734);
    return false;
  }
  
  private boolean dXY()
  {
    return this.Fxl == 13;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final boolean aWU()
  {
    Object localObject3 = null;
    AppMethodBeat.i(166825);
    hideVKB();
    Object localObject2 = this.Bny;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("searchView");
      localObject1 = null;
    }
    localObject1 = ((FTSSearchView)localObject1).getFtsEditText().getTotalQuery();
    if (localObject1 == null) {
      localObject1 = "";
    }
    while (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(166825);
      return true;
      localObject2 = n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    Object localObject4 = this.presenter;
    localObject2 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("presenter");
      localObject2 = null;
    }
    ((FinderMixSearchPresenter)localObject2).al((String)localObject1, 1, this.Fxl);
    localObject4 = this.BnB;
    localObject2 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("historyLogic");
      localObject2 = null;
    }
    ((j)localObject2).azd((String)localObject1);
    localObject1 = this.BnC;
    if (localObject1 == null)
    {
      s.bIx("searchSuggestionManager");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((l)localObject1).ePg();
      AppMethodBeat.o(166825);
      return true;
    }
  }
  
  public final int edC()
  {
    return 3;
  }
  
  public final void eeU() {}
  
  public final void finish()
  {
    AppMethodBeat.i(342806);
    super.finish();
    int i = e.a.anim_not_change;
    overridePendingTransition(i, i);
    AppMethodBeat.o(342806);
  }
  
  public final void fq(boolean paramBoolean)
  {
    AppMethodBeat.i(166823);
    if (paramBoolean)
    {
      aa localaa = aa.Fsi;
      aa.eMZ();
    }
    AppMethodBeat.o(166823);
  }
  
  public final int getCommentScene()
  {
    return 23;
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(342817);
    if (dXY())
    {
      i = e.f.finder_mix_search_ui_night_mode;
      AppMethodBeat.o(342817);
      return i;
    }
    int i = e.f.finder_mix_search_ui;
    AppMethodBeat.o(342817);
    return i;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(166820);
    hideVKB();
    finish();
    AppMethodBeat.o(166820);
  }
  
  public final void onClickCancelBtn(View paramView)
  {
    AppMethodBeat.i(166821);
    hideVKB();
    finish();
    AppMethodBeat.o(166821);
  }
  
  public final void onClickClearTextBtn(View paramView)
  {
    AppMethodBeat.i(166824);
    FTSSearchView localFTSSearchView = this.Bny;
    paramView = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      s.bIx("searchView");
      paramView = null;
    }
    paramView.getFtsEditText().aWT();
    showVKB();
    AppMethodBeat.o(166824);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166818);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.d.FAy;
    boolean bool;
    Object localObject1;
    label119:
    int i;
    label140:
    Object localObject2;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eVC().bmg()).intValue() == 1)
    {
      bool = true;
      this.Fxk = bool;
      this.Fxl = getIntent().getIntExtra("request_type", 0);
      paramBundle = getIntent().getStringExtra("key_click_sub_tab_context_id");
      if (!TextUtils.isEmpty((CharSequence)paramBundle))
      {
        localObject1 = k.aeZF;
        ((as)k.d((AppCompatActivity)this).q(as.class)).DnS = paramBundle;
      }
      if (!dXY()) {
        break label1041;
      }
      paramBundle = new FTSSearchView((Context)this, true);
      this.Bny = paramBundle;
      paramBundle = this.Bny;
      if (paramBundle != null) {
        break label1056;
      }
      s.bIx("searchView");
      paramBundle = null;
      paramBundle.setSearchViewListener((FTSSearchView.b)this);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setHint(getString(e.h.app_search));
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.c)this);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().setCanDeleteTag(false);
      if (this.Fxk)
      {
        if (!dXY()) {
          break label1059;
        }
        i = e.b.Dark_0;
        label262:
        localObject1 = this.Bny;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null)
        {
          s.bIx("searchView");
          paramBundle = null;
        }
        paramBundle.afCn = paramBundle.findViewById(a.g.back_btn);
        paramBundle.afCn.setOnClickListener(new FTSSearchView.4(paramBundle));
        paramBundle.afCn.setVisibility(0);
        paramBundle.CxW.setVisibility(8);
        i = paramBundle.getResources().getColor(i);
        paramBundle.afCo.setBackgroundColor(i);
        localObject1 = (LinearLayout.LayoutParams)paramBundle.Mhl.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).width = -2;
        ((LinearLayout.LayoutParams)localObject1).setMarginEnd((int)paramBundle.getResources().getDimension(a.e.Edge_2A));
        paramBundle.Mhl.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().aWT();
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().aWS();
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle.getFtsEditText().jBL();
      localObject2 = getSupportActionBar();
      s.checkNotNull(localObject2);
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      ((ActionBar)localObject2).setCustomView((View)paramBundle);
      this.BnB = new j((MMActivity)this, false, dXY(), (kotlin.g.a.b)new b(this), (m)new c());
      this.presenter = new FinderMixSearchPresenter((MMActivity)this, this.Fxl);
      localObject2 = (MMActivity)this;
      localObject1 = this.presenter;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("presenter");
        paramBundle = null;
      }
      this.Fxj = new h((MMActivity)localObject2, (g.a)paramBundle, this.Fxl);
      paramBundle = this.presenter;
      if (paramBundle != null) {
        break label1066;
      }
      s.bIx("presenter");
      paramBundle = null;
      label636:
      localObject2 = this.Fxj;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("viewCallback");
        localObject1 = null;
      }
      paramBundle.a((g.b)localObject1);
      localObject1 = this.Fxj;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("viewCallback");
        paramBundle = null;
      }
      paramBundle.mkw.setOnTouchListener(new FinderMixSearchUI..ExternalSyntheticLambda0(this));
      localObject2 = (MMActivity)this;
      localObject1 = this.Bny;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("searchView");
        paramBundle = null;
      }
      paramBundle = paramBundle.getFtsEditText();
      s.s(paramBundle, "searchView.ftsEditText");
      this.BnC = new l((MMActivity)localObject2, paramBundle, this.Fxl, 1, false, dXY(), (kotlin.g.a.b)new d(this));
      if (dXY())
      {
        getController().setActionbarColor(getContext().getResources().getColor(e.b.Dark_0));
        setBackGroundColorResource(e.b.Dark_0);
        paramBundle = getBounceView();
        if (paramBundle != null) {
          paramBundle.setStart2EndBgColor(getContext().getResources().getColor(e.b.Dark_0));
        }
        paramBundle = getBounceView();
        if (paramBundle != null) {
          paramBundle.setEnd2StartBgColor(getContext().getResources().getColor(e.b.Dark_0));
        }
      }
      localObject1 = this.BnB;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("historyLogic");
        paramBundle = null;
      }
      paramBundle.ESD.setVisibility(0);
      localObject1 = this.Fxj;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        s.bIx("viewCallback");
        paramBundle = null;
      }
      paramBundle.mkw.a((RecyclerView.l)this.Fxm);
      if (!this.Fxk)
      {
        paramBundle = z.FrZ;
        z.azT(String.valueOf(cn.bDw()));
        localObject1 = UUID.randomUUID().toString();
        s.s(localObject1, "randomUUID().toString()");
        paramBundle = z.FrZ;
        paramBundle = z.FrZ;
        localObject2 = z.eMW();
        paramBundle = as.GSQ;
        paramBundle = getContext();
        s.s(paramBundle, "context");
        paramBundle = as.a.hu((Context)paramBundle);
        if (paramBundle != null) {
          break label1069;
        }
      }
    }
    label1041:
    label1056:
    label1059:
    label1066:
    label1069:
    for (paramBundle = null;; paramBundle = paramBundle.fou())
    {
      z.a((String)localObject2, (String)localObject1, "", 1, 1, 1, 0, 0, paramBundle);
      AppMethodBeat.o(166818);
      return;
      bool = false;
      break;
      paramBundle = new FTSSearchView((Context)this);
      break label119;
      break label140;
      i = e.b.BW_93;
      break label262;
      break label636;
    }
  }
  
  public final void onDestroy()
  {
    Object localObject2 = null;
    AppMethodBeat.i(166819);
    Object localObject3 = this.BnB;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("historyLogic");
      localObject1 = null;
    }
    ((j)localObject1).onDestroy();
    localObject3 = this.presenter;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("presenter");
      localObject1 = null;
    }
    ((FinderMixSearchPresenter)localObject1).onDetach();
    hideVKB();
    localObject1 = this.Fxj;
    if (localObject1 == null)
    {
      s.bIx("viewCallback");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((h)localObject1).mkw.b((RecyclerView.l)this.Fxm);
      if (!this.Fxk)
      {
        localObject1 = z.FrZ;
        z.azT("");
      }
      super.onDestroy();
      AppMethodBeat.o(166819);
      return;
    }
  }
  
  public final void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    paramList = null;
    AppMethodBeat.i(166822);
    if (paramString1 == null)
    {
      paramString1 = "";
      paramd = this.BnB;
      paramString2 = paramd;
      if (paramd == null)
      {
        s.bIx("historyLogic");
        paramString2 = null;
      }
      paramString2.aAg(paramString1);
      paramString2 = this.Fxj;
      if (paramString2 != null) {
        break label122;
      }
      s.bIx("viewCallback");
      paramString2 = paramList;
    }
    label122:
    for (;;)
    {
      if (Util.isNullOrNil(paramString1))
      {
        paramString2.BnA.setVisibility(8);
        paramString2.njN.setVisibility(8);
        paramString2.mkw.setVisibility(8);
      }
      AppMethodBeat.o(166822);
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
    AppMethodBeat.i(342868);
    super.onPause();
    ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(null, q.w.DwP, q.n.Dtw.scene, com.tencent.mm.plugin.finder.live.report.d.Dng);
    l locall2 = this.BnC;
    l locall1 = locall2;
    if (locall2 == null)
    {
      s.bIx("searchSuggestionManager");
      locall1 = null;
    }
    locall1.onActivityPause();
    AppMethodBeat.o(342868);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(342856);
    super.onResume();
    ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(null, q.w.DwP, q.n.Dtw.scene, com.tencent.mm.plugin.finder.live.report.d.Dnf);
    l locall2 = this.BnC;
    l locall1 = locall2;
    if (locall2 == null)
    {
      s.bIx("searchSuggestionManager");
      locall1 = null;
    }
    locall1.onActivityResume();
    AppMethodBeat.o(342856);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(342828);
    super.onSwipeBack();
    hideVKB();
    AppMethodBeat.o(342828);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(342782);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(q.class);
    AppMethodBeat.o(342782);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI$Companion;", "", "()V", "KEY_SEARCH_EVENT_INFO", "", "KEY_SEARCH_QUERY", "KEY_SEARCH_SESSION_BUFFER", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "query", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    b(FinderMixSearchUI paramFinderMixSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderMixSearchUI$initData$2", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "onClear", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements m
  {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "suggestion", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    d(FinderMixSearchUI paramFinderMixSearchUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(342732);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(342732);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(342723);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(paramRecyclerView, q.w.DwP, q.n.Dtw.scene, com.tencent.mm.plugin.finder.live.report.d.Dne);
      a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(342723);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchUI
 * JD-Core Version:    0.7.0.1
 */