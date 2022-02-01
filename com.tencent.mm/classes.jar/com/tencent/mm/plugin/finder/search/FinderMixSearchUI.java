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
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.bt;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "TAG", "", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "getCommentScene", "", "getLayoutId", "initData", "", "initSearchView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "", "onSearchKeyDown", "onTagClick", "index", "tag", "plugin-finder_release"})
public final class FinderMixSearchUI
  extends MMFinderUI
  implements FTSEditTextView.a, a.b
{
  private final String TAG = "Finder.FinderMixSearchUI";
  private HashMap _$_findViewCache;
  private FinderMixSearchPresenter presenter;
  private h qHE;
  private g qHZ;
  private a qHy;
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198938);
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
    AppMethodBeat.o(198938);
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
    paramString2 = this.qHE;
    if (paramString2 == null) {
      k.aPZ("historyLogic");
    }
    paramString2.Zo(paramString1);
    paramString2 = this.qHZ;
    if (paramString2 == null) {
      k.aPZ("viewCallback");
    }
    if (bt.isNullOrNil(paramString1))
    {
      paramString2.qHD.setVisibility(8);
      paramString2.lZo.setVisibility(8);
      paramString2.fPw.setVisibility(8);
    }
    AppMethodBeat.o(166822);
  }
  
  public final boolean bow()
  {
    AppMethodBeat.i(166825);
    hideVKB();
    Object localObject1 = this.qHy;
    if (localObject1 == null) {
      k.aPZ("searchView");
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
    if (bt.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(166825);
      return true;
    }
    Object localObject2 = this.presenter;
    if (localObject2 == null) {
      k.aPZ("presenter");
    }
    ((FinderMixSearchPresenter)localObject2).Zn((String)localObject1);
    localObject2 = this.qHE;
    if (localObject2 == null) {
      k.aPZ("historyLogic");
    }
    ((h)localObject2).Zp((String)localObject1);
    AppMethodBeat.o(166825);
    return true;
  }
  
  public final void cok() {}
  
  public final int getCommentScene()
  {
    return 23;
  }
  
  public final int getLayoutId()
  {
    return 2131494068;
  }
  
  public final void lb(boolean paramBoolean)
  {
    AppMethodBeat.i(166823);
    if (paramBoolean)
    {
      d locald = d.qFr;
      d.cnB();
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
    paramView = this.qHy;
    if (paramView == null) {
      k.aPZ("searchView");
    }
    paramView.getFtsEditText().fdj();
    showVKB();
    AppMethodBeat.o(166824);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166818);
    super.onCreate(paramBundle);
    this.qHy = new a((Context)this);
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.setSearchViewListener((a.b)this);
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().setHint(getString(2131755882));
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().fdj();
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().fdi();
    paramBundle = this.qHy;
    if (paramBundle == null) {
      k.aPZ("searchView");
    }
    paramBundle.getFtsEditText().fdg();
    paramBundle = getSupportActionBar();
    if (paramBundle == null) {
      k.fvU();
    }
    k.g(paramBundle, "supportActionBar!!");
    Object localObject = this.qHy;
    if (localObject == null) {
      k.aPZ("searchView");
    }
    paramBundle.setCustomView((View)localObject);
    this.qHE = new h((MMActivity)this, (b)new a(this));
    this.presenter = new FinderMixSearchPresenter((MMActivity)this);
    paramBundle = (MMActivity)this;
    localObject = this.presenter;
    if (localObject == null) {
      k.aPZ("presenter");
    }
    this.qHZ = new g(paramBundle, (f.a)localObject);
    paramBundle = this.presenter;
    if (paramBundle == null) {
      k.aPZ("presenter");
    }
    localObject = this.qHZ;
    if (localObject == null) {
      k.aPZ("viewCallback");
    }
    paramBundle.a((f.b)localObject);
    paramBundle = this.qHZ;
    if (paramBundle == null) {
      k.aPZ("viewCallback");
    }
    paramBundle.fPw.setOnTouchListener((View.OnTouchListener)new b(this));
    AppMethodBeat.o(166818);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166819);
    Object localObject = this.qHE;
    if (localObject == null) {
      k.aPZ("historyLogic");
    }
    ((h)localObject).onDestroy();
    localObject = this.presenter;
    if (localObject == null) {
      k.aPZ("presenter");
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "query", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements b<String, y>
  {
    a(FinderMixSearchUI paramFinderMixSearchUI)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(FinderMixSearchUI paramFinderMixSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(166817);
      FinderMixSearchUI.a(this.qIa).getFtsEditText().fbk();
      this.qIa.hideVKB();
      AppMethodBeat.o(166817);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchUI
 * JD-Core Version:    0.7.0.1
 */