package com.tencent.mm.plugin.finder.search.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.af;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/ui/FinderSearchBaseUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "TAG", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "forceDarkMode", "", "getForceDarkMode", "()Z", "setForceDarkMode", "(Z)V", "loadingView", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "noResultView", "Landroid/widget/TextView;", "getNoResultView", "()Landroid/widget/TextView;", "setNoResultView", "(Landroid/widget/TextView;)V", "query", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getSearchView", "()Lcom/tencent/mm/ui/search/FTSSearchView;", "setSearchView", "(Lcom/tencent/mm/ui/search/FTSSearchView;)V", "getLoader", "Lcom/tencent/mm/plugin/finder/search/ui/IFinderSearchLoader;", "getViewConfig", "Lcom/tencent/mm/plugin/finder/search/ui/IFinderSearchViewConfig;", "goBack", "", "initContentView", "initData", "initSearchView", "onBackPressed", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onSearchKeyDown", "onSwipeBack", "onTagClick", "index", "", "tag", "refreshWhenDataReady", "currentSize", "originSize", "showLoadMoreFooter", "showNoMoreFooter", "startSearch", "startSearchNextPage", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class FinderSearchBaseUI
  extends MMFinderUI
  implements FTSEditTextView.c, FTSSearchView.b
{
  public WxRecyclerAdapter<cc> ALE;
  public RefreshLoadMoreLayout ATx;
  public TextView BnA;
  public FTSSearchView Bny;
  private boolean FyH;
  private final String TAG = "Finder.FinderSearchBaseUI";
  public RecyclerView mkw;
  public View njN;
  String query = "";
  
  private static final void a(int paramInt1, FinderSearchBaseUI paramFinderSearchBaseUI, int paramInt2)
  {
    s.u(paramFinderSearchBaseUI, "this$0");
    if (paramInt1 != 0)
    {
      Object localObject = RefreshLoadMoreLayout.d.agJr;
      localObject = new RefreshLoadMoreLayout.d(RefreshLoadMoreLayout.d.jMH());
      ((RefreshLoadMoreLayout.d)localObject).agJu = paramFinderSearchBaseUI.egd().aWl();
      if (paramInt2 - paramInt1 <= 0) {}
      for (boolean bool = true;; bool = false)
      {
        ((RefreshLoadMoreLayout.d)localObject).pzq = bool;
        ((RefreshLoadMoreLayout.d)localObject).agJv = (paramInt2 - paramInt1);
        paramFinderSearchBaseUI.getRlLayout().onPreFinishLoadMoreSmooth((RefreshLoadMoreLayout.d)localObject);
        return;
      }
    }
    paramFinderSearchBaseUI.getRlLayout().aFW(paramInt2);
  }
  
  private static final void a(FinderSearchBaseUI paramFinderSearchBaseUI, View paramView)
  {
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderSearchBaseUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/ui/FinderSearchBaseUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderSearchBaseUI, "this$0");
    paramFinderSearchBaseUI.onClickBackBtn(paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/search/ui/FinderSearchBaseUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  private static final boolean a(FinderSearchBaseUI paramFinderSearchBaseUI, View paramView, MotionEvent paramMotionEvent)
  {
    s.u(paramFinderSearchBaseUI, "this$0");
    paramFinderSearchBaseUI.ePo().getFtsEditText().dzv.clearFocus();
    paramFinderSearchBaseUI.hideVKB();
    return false;
  }
  
  private FTSSearchView ePo()
  {
    FTSSearchView localFTSSearchView = this.Bny;
    if (localFTSSearchView != null) {
      return localFTSSearchView;
    }
    s.bIx("searchView");
    return null;
  }
  
  private TextView ePp()
  {
    TextView localTextView = this.BnA;
    if (localTextView != null) {
      return localTextView;
    }
    s.bIx("noResultView");
    return null;
  }
  
  private View getLoadingView()
  {
    View localView = this.njN;
    if (localView != null) {
      return localView;
    }
    s.bIx("loadingView");
    return null;
  }
  
  private RecyclerView getRecyclerView()
  {
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null) {
      return localRecyclerView;
    }
    s.bIx("recyclerView");
    return null;
  }
  
  private RefreshLoadMoreLayout getRlLayout()
  {
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    if (localRefreshLoadMoreLayout != null) {
      return localRefreshLoadMoreLayout;
    }
    s.bIx("rlLayout");
    return null;
  }
  
  public void _$_clearFindViewByIdCache() {}
  
  public final boolean aWU()
  {
    hideVKB();
    Object localObject1 = ePo().getFtsEditText().getTotalQuery();
    if (localObject1 == null) {
      localObject1 = "";
    }
    while (Util.isNullOrNil((String)localObject1))
    {
      return true;
      localObject2 = n.bq((CharSequence)localObject1).toString();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
    }
    Log.i(this.TAG, s.X("startSearch query:", localObject1));
    this.query = ((String)localObject1);
    egd().awg((String)localObject1);
    getLoadingView().setVisibility(0);
    ePp().setVisibility(8);
    getRlLayout().setVisibility(8);
    localObject1 = getRecyclerView();
    Object localObject2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/finder/search/ui/FinderSearchBaseUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    ((RecyclerView)localObject1).scrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/finder/search/ui/FinderSearchBaseUI", "startSearch", "(Ljava/lang/String;)V", "Undefined", "scrollToPosition", "(I)V");
    return false;
  }
  
  public final void eeU() {}
  
  public abstract a egd();
  
  public abstract b ege();
  
  public final void fq(boolean paramBoolean) {}
  
  public final WxRecyclerAdapter<cc> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null) {
      return localWxRecyclerAdapter;
    }
    s.bIx("adapter");
    return null;
  }
  
  public final void il(int paramInt1, int paramInt2)
  {
    RecyclerView.a locala;
    if (paramInt1 == 0)
    {
      getLoadingView().setVisibility(8);
      ePp().setVisibility(0);
      getRlLayout().setVisibility(8);
      if (paramInt2 != 0) {
        break label101;
      }
      locala = getRecyclerView().getAdapter();
      if (locala != null) {
        locala.bZE.notifyChanged();
      }
    }
    for (;;)
    {
      getRlLayout().post(new FinderSearchBaseUI..ExternalSyntheticLambda2(paramInt2, this, paramInt1));
      return;
      getLoadingView().setVisibility(8);
      ePp().setVisibility(8);
      getRlLayout().setVisibility(0);
      break;
      label101:
      if (paramInt2 < paramInt1)
      {
        locala = getRecyclerView().getAdapter();
        if (locala != null) {
          locala.bA(paramInt2, paramInt1 - paramInt2);
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  public void onClickBackBtn(View paramView)
  {
    hideVKB();
    finish();
  }
  
  public void onClickCancelBtn(View paramView)
  {
    hideVKB();
    finish();
  }
  
  public void onClickClearTextBtn(View paramView)
  {
    ePo().getFtsEditText().aWT();
    showVKB();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new FTSSearchView((Context)this);
    s.u(paramBundle, "<set-?>");
    this.Bny = paramBundle;
    ePo().setSearchViewListener((FTSSearchView.b)this);
    ePo().getFtsEditText().setHint(getString(e.h.finder_activity_search_hint_content));
    ePo().getFtsEditText().setFtsEditTextListener((FTSEditTextView.c)this);
    ePo().getFtsEditText().setCanDeleteTag(false);
    ePo().getFtsEditText().jBL();
    if (this.FyH)
    {
      ePo().findViewById(e.e.cancel_btn).setVisibility(8);
      ePo().getSearchContainer().setBackground(null);
      int i = getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_64);
      ePo().getFtsEditText().getEditText().setTextColor(i);
      ePo().getSearchIcon().setIconColor(i);
      ePo().getFtsEditText().getClearBtn().getDrawable().setColorFilter(i, PorterDuff.Mode.SRC_ATOP);
      ePo().setBackgroundColor(getResources().getColor(e.b.full_black));
      setActionbarColor(getResources().getColor(e.b.full_black));
    }
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.setCustomView((View)ePo());
    }
    paramBundle = (WeImageView)ePo().findViewById(e.e.back_btn);
    if (paramBundle != null)
    {
      paramBundle.setVisibility(0);
      if (this.FyH) {
        paramBundle.setIconColor(getResources().getColor(e.b.hot_tab_BW_100_Alpha_0_64));
      }
      paramBundle.setOnClickListener(new FinderSearchBaseUI..ExternalSyntheticLambda0(this));
    }
    this.query = "";
    ePo().getFtsEditText().aWT();
    ePo().getFtsEditText().aWS();
    paramBundle = getContext().findViewById(e.e.rl_layout);
    s.s(paramBundle, "context.findViewById(R.id.rl_layout)");
    paramBundle = (RefreshLoadMoreLayout)paramBundle;
    s.u(paramBundle, "<set-?>");
    this.ATx = paramBundle;
    paramBundle = getRlLayout().getRecyclerView();
    s.u(paramBundle, "<set-?>");
    this.mkw = paramBundle;
    paramBundle = getContext().findViewById(e.e.no_result_tv);
    s.s(paramBundle, "context.findViewById(R.id.no_result_tv)");
    paramBundle = (TextView)paramBundle;
    s.u(paramBundle, "<set-?>");
    this.BnA = paramBundle;
    paramBundle = getContext().findViewById(e.e.loading_layout);
    s.s(paramBundle, "context.findViewById(R.id.loading_layout)");
    setLoadingView(paramBundle);
    getRecyclerView().setLayoutManager(ege().fT((Context)this));
    paramBundle = ege().getItemDecoration();
    if (paramBundle != null) {
      getRecyclerView().a(paramBundle);
    }
    paramBundle = new WxRecyclerAdapter(ege().dUK(), egd().ePn(), true);
    s.u(paramBundle, "<set-?>");
    this.ALE = paramBundle;
    getRecyclerView().setAdapter((RecyclerView.a)getAdapter());
    paramBundle = af.mU((Context)getContext()).inflate(e.f.load_more_footer, null);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = getRlLayout();
    s.s(paramBundle, "loadmoreFooter");
    localRefreshLoadMoreLayout.setLoadMoreFooter(paramBundle);
    if (!this.FyH) {
      ePp().setTextColor(getResources().getColor(e.b.hint_text_color));
    }
    for (;;)
    {
      getRecyclerView().setOnTouchListener(new FinderSearchBaseUI..ExternalSyntheticLambda1(this));
      getRlLayout().setEnablePullDownHeader(false);
      getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new a(this));
      paramBundle = this.query;
      ePo().getFtsEditText().V(paramBundle, null);
      return;
      ePp().setTextColor(getResources().getColor(e.b.hot_tab_BW93));
      ((TouchableLayout)findViewById(e.e.uiContainer)).setBackgroundColor(getResources().getColor(e.b.full_black));
      paramBundle = (TextView)paramBundle.findViewById(e.e.load_more_footer_tip_tv);
      if (paramBundle != null) {
        paramBundle.setTextColor(getResources().getColor(e.b.BW_100_Alpha_0_3));
      }
    }
  }
  
  public void onDestroy()
  {
    hideVKB();
    super.onDestroy();
  }
  
  public void onEditTextChange(String paramString1, String paramString2, List<FTSSearchView.c> paramList, FTSEditTextView.d paramd)
  {
    if (paramString1 == null) {
      paramString1 = "";
    }
    for (;;)
    {
      if (Util.isNullOrNil(paramString1))
      {
        getLoadingView().setVisibility(8);
        ePp().setVisibility(8);
        getRlLayout().setVisibility(8);
      }
      return;
      paramString2 = n.bq((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
    }
  }
  
  public void onSwipeBack()
  {
    super.onSwipeBack();
    hideVKB();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void setLoadingView(View paramView)
  {
    s.u(paramView, "<set-?>");
    this.njN = paramView;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/search/ui/FinderSearchBaseUI$initContentView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends RefreshLoadMoreLayout.b
  {
    a(FinderSearchBaseUI paramFinderSearchBaseUI) {}
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(342615);
      Log.i(FinderSearchBaseUI.a(this.FyI), "onLoadMoreBegin");
      FinderSearchBaseUI localFinderSearchBaseUI = this.FyI;
      if (localFinderSearchBaseUI.egd().aWl())
      {
        FinderSearchBaseUI.b(localFinderSearchBaseUI);
        AppMethodBeat.o(342615);
        return;
      }
      FinderSearchBaseUI.c(localFinderSearchBaseUI);
      AppMethodBeat.o(342615);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.ui.FinderSearchBaseUI
 * JD-Core Version:    0.7.0.1
 */