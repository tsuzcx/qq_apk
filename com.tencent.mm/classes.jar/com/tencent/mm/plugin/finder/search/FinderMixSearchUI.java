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
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.n.n;
import d.v;
import d.z;
import java.util.HashMap;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "TAG", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "getCommentScene", "", "getLayoutId", "getReportType", "initData", "", "initSearchView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "plugin-finder_release"})
public final class FinderMixSearchUI
  extends MMFinderUI
  implements FTSEditTextView.a, a.b
{
  private final String TAG = "Finder.FinderMixSearchUI";
  private HashMap _$_findViewCache;
  private FinderMixSearchPresenter presenter;
  private com.tencent.mm.ui.search.a ssF;
  private g ssL;
  private f stq;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203464);
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
    AppMethodBeat.o(203464);
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
    paramString2 = this.ssL;
    if (paramString2 == null) {
      p.bcb("historyLogic");
    }
    paramString2.ahV(paramString1);
    paramString2 = this.stq;
    if (paramString2 == null) {
      p.bcb("viewCallback");
    }
    if (bt.isNullOrNil(paramString1))
    {
      paramString2.ssK.setVisibility(8);
      paramString2.gWO.setVisibility(8);
      paramString2.gmV.setVisibility(8);
    }
    AppMethodBeat.o(166822);
  }
  
  public final boolean bzz()
  {
    AppMethodBeat.i(166825);
    hideVKB();
    Object localObject1 = this.ssF;
    if (localObject1 == null) {
      p.bcb("searchView");
    }
    localObject1 = ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText();
    p.g(localObject1, "searchView.ftsEditText");
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
    if (bt.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(166825);
      return true;
    }
    Object localObject2 = this.presenter;
    if (localObject2 == null) {
      p.bcb("presenter");
    }
    ((FinderMixSearchPresenter)localObject2).ahU((String)localObject1);
    localObject2 = this.ssL;
    if (localObject2 == null) {
      p.bcb("historyLogic");
    }
    ((g)localObject2).ahW((String)localObject1);
    AppMethodBeat.o(166825);
    return true;
  }
  
  public final int cAZ()
  {
    return 23;
  }
  
  public final int cBZ()
  {
    return 3;
  }
  
  public final void cED() {}
  
  public final int getLayoutId()
  {
    return 2131494068;
  }
  
  public final void ma(boolean paramBoolean)
  {
    AppMethodBeat.i(166823);
    if (paramBoolean)
    {
      i locali = i.soN;
      i.cDA();
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
    paramView = this.ssF;
    if (paramView == null) {
      p.bcb("searchView");
    }
    paramView.getFtsEditText().fJS();
    showVKB();
    AppMethodBeat.o(166824);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166818);
    super.onCreate(paramBundle);
    this.ssF = new com.tencent.mm.ui.search.a((Context)this);
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(2131755882));
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().fJS();
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().fJR();
    paramBundle = this.ssF;
    if (paramBundle == null) {
      p.bcb("searchView");
    }
    paramBundle.getFtsEditText().fJP();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      p.gfZ();
    }
    p.g(paramBundle, "supportActionBar!!");
    Object localObject = this.ssF;
    if (localObject == null) {
      p.bcb("searchView");
    }
    paramBundle.setCustomView((View)localObject);
    this.ssL = new g((MMActivity)this, (d.g.a.b)new a(this));
    this.presenter = new FinderMixSearchPresenter((MMActivity)this);
    paramBundle = (MMActivity)this;
    localObject = this.presenter;
    if (localObject == null) {
      p.bcb("presenter");
    }
    this.stq = new f(paramBundle, (e.a)localObject);
    paramBundle = this.presenter;
    if (paramBundle == null) {
      p.bcb("presenter");
    }
    localObject = this.stq;
    if (localObject == null) {
      p.bcb("viewCallback");
    }
    paramBundle.a((e.b)localObject);
    paramBundle = this.stq;
    if (paramBundle == null) {
      p.bcb("viewCallback");
    }
    paramBundle.gmV.setOnTouchListener((View.OnTouchListener)new b(this));
    AppMethodBeat.o(166818);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166819);
    Object localObject = this.ssL;
    if (localObject == null) {
      p.bcb("historyLogic");
    }
    ((g)localObject).onDestroy();
    localObject = this.presenter;
    if (localObject == null) {
      p.bcb("presenter");
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "query", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.b<String, z>
  {
    a(FinderMixSearchUI paramFinderMixSearchUI)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(FinderMixSearchUI paramFinderMixSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(166817);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchUI$initData$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
      FinderMixSearchUI.a(this.str).getFtsEditText().fHO();
      this.str.hideVKB();
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$initData$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(166817);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchUI
 * JD-Core Version:    0.7.0.1
 */