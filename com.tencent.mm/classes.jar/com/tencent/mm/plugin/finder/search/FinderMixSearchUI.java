package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.e;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import d.g.a.b;
import d.g.b.k;
import d.n.n;
import d.v;
import d.y;
import java.util.HashMap;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "TAG", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "getCommentScene", "", "getLayoutId", "getReportType", "initData", "", "initSearchView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "plugin-finder_release"})
public final class FinderMixSearchUI
  extends MMFinderUI
  implements FTSEditTextView.a, a.b
{
  private final String TAG = "Finder.FinderMixSearchUI";
  private HashMap _$_findViewCache;
  private FinderMixSearchPresenter presenter;
  private g rAA;
  private a rAu;
  private f rBa;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202891);
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
    AppMethodBeat.o(202891);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
  {
    AppMethodBeat.i(166822);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(166822);
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
    paramString2 = this.rAA;
    if (paramString2 == null) {
      k.aVY("historyLogic");
    }
    paramString2.adW(paramString1);
    paramString2 = this.rBa;
    if (paramString2 == null) {
      k.aVY("viewCallback");
    }
    if (bs.isNullOrNil(paramString1))
    {
      paramString2.rAz.setVisibility(8);
      paramString2.gDe.setVisibility(8);
      paramString2.fTr.setVisibility(8);
    }
    AppMethodBeat.o(166822);
  }
  
  public final boolean bvs()
  {
    AppMethodBeat.i(166825);
    hideVKB();
    Object localObject1 = this.rAu;
    if (localObject1 == null) {
      k.aVY("searchView");
    }
    localObject1 = ((a)localObject1).getFtsEditText();
    k.g(localObject1, "searchView.ftsEditText");
    localObject1 = ((FTSEditTextView)localObject1).getTotalQuery();
    if (localObject1 != null)
    {
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(166825);
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
    if (bs.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(166825);
      return true;
    }
    Object localObject2 = this.presenter;
    if (localObject2 == null) {
      k.aVY("presenter");
    }
    ((FinderMixSearchPresenter)localObject2).adV((String)localObject1);
    localObject2 = this.rAA;
    if (localObject2 == null) {
      k.aVY("historyLogic");
    }
    ((g)localObject2).adX((String)localObject1);
    AppMethodBeat.o(166825);
    return true;
  }
  
  public final int cuI()
  {
    return 23;
  }
  
  public final int cvJ()
  {
    return 3;
  }
  
  public final void cxG() {}
  
  public final int getLayoutId()
  {
    return 2131494068;
  }
  
  public final void lF(boolean paramBoolean)
  {
    AppMethodBeat.i(166823);
    if (paramBoolean)
    {
      e locale = e.rxs;
      e.cwV();
    }
    AppMethodBeat.o(166823);
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
    paramView = this.rAu;
    if (paramView == null) {
      k.aVY("searchView");
    }
    paramView.getFtsEditText().fte();
    showVKB();
    AppMethodBeat.o(166824);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166818);
    super.onCreate(paramBundle);
    this.rAu = new a((Context)this);
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(2131755882));
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().fte();
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().ftd();
    paramBundle = this.rAu;
    if (paramBundle == null) {
      k.aVY("searchView");
    }
    paramBundle.getFtsEditText().ftb();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      k.fOy();
    }
    k.g(paramBundle, "supportActionBar!!");
    Object localObject = this.rAu;
    if (localObject == null) {
      k.aVY("searchView");
    }
    paramBundle.setCustomView((View)localObject);
    this.rAA = new g((MMActivity)this, (b)new a(this));
    this.presenter = new FinderMixSearchPresenter((MMActivity)this);
    paramBundle = (MMActivity)this;
    localObject = this.presenter;
    if (localObject == null) {
      k.aVY("presenter");
    }
    this.rBa = new f(paramBundle, (e.a)localObject);
    paramBundle = this.presenter;
    if (paramBundle == null) {
      k.aVY("presenter");
    }
    localObject = this.rBa;
    if (localObject == null) {
      k.aVY("viewCallback");
    }
    paramBundle.a((e.b)localObject);
    paramBundle = this.rBa;
    if (paramBundle == null) {
      k.aVY("viewCallback");
    }
    paramBundle.fTr.setOnTouchListener((View.OnTouchListener)new b(this));
    AppMethodBeat.o(166818);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166819);
    Object localObject = this.rAA;
    if (localObject == null) {
      k.aVY("historyLogic");
    }
    ((g)localObject).onDestroy();
    localObject = this.presenter;
    if (localObject == null) {
      k.aVY("presenter");
    }
    ((FinderMixSearchPresenter)localObject).onDetach();
    hideVKB();
    super.onDestroy();
    AppMethodBeat.o(166819);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "query", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<String, y>
  {
    a(FinderMixSearchUI paramFinderMixSearchUI)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(FinderMixSearchUI paramFinderMixSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(166817);
      FinderMixSearchUI.a(this.rBb).getFtsEditText().frb();
      this.rBb.hideVKB();
      AppMethodBeat.o(166817);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchUI
 * JD-Core Version:    0.7.0.1
 */