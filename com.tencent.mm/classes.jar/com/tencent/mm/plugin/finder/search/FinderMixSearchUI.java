package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.report.c;
import com.tencent.mm.plugin.finder.live.report.s.l;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.FTSEditTextView.c;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import com.tencent.mm.ui.w;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "isHotSearchEnable", "", "mOnScrollListener", "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "searchSceneForPull", "", "searchSuggestionManager", "Lcom/tencent/mm/plugin/finder/search/FinderSearchSuggestionManager;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "adapteNightMode", "", "getCommentScene", "getLayoutId", "getReportType", "initData", "initSearchView", "initSuggestion", "isFinderLiveSearch", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onPause", "onResume", "onSearchKeyDown", "onSwipeBack", "onTagClick", "index", "tag", "reportStartSearch", "requestSearch", "Companion", "plugin-finder_release"})
public final class FinderMixSearchUI
  extends MMFinderUI
  implements FTSEditTextView.b, a.b
{
  public static final a Abx;
  private g Abt;
  private boolean Abu;
  private int Abv;
  private final f Abw;
  private HashMap _$_findViewCache;
  private FinderMixSearchPresenter presenter;
  private com.tencent.mm.ui.search.a xNC;
  private i xNE;
  private k xNF;
  
  static
  {
    AppMethodBeat.i(239792);
    Abx = new a((byte)0);
    AppMethodBeat.o(239792);
  }
  
  public FinderMixSearchUI()
  {
    AppMethodBeat.i(239790);
    this.Abw = new f();
    AppMethodBeat.o(239790);
  }
  
  private boolean dpJ()
  {
    return this.Abv == 13;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(239808);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(239808);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(239805);
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
    AppMethodBeat.o(239805);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.c paramc)
  {
    AppMethodBeat.i(166822);
    if (paramString1 != null)
    {
      if (paramString1 == null)
      {
        paramString1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(166822);
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
    paramString2 = this.xNE;
    if (paramString2 == null) {
      p.bGy("historyLogic");
    }
    paramString2.aEm(paramString1);
    paramString2 = this.Abt;
    if (paramString2 == null) {
      p.bGy("viewCallback");
    }
    if (Util.isNullOrNil(paramString1))
    {
      paramString2.xND.setVisibility(8);
      paramString2.kGT.setVisibility(8);
      paramString2.jLl.setVisibility(8);
    }
    AppMethodBeat.o(166822);
  }
  
  public final boolean aDV()
  {
    AppMethodBeat.i(166825);
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
        localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(166825);
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
      AppMethodBeat.o(166825);
      return true;
    }
    Object localObject2 = this.presenter;
    if (localObject2 == null) {
      p.bGy("presenter");
    }
    ((FinderMixSearchPresenter)localObject2).ag((String)localObject1, 1, this.Abv);
    localObject2 = this.xNE;
    if (localObject2 == null) {
      p.bGy("historyLogic");
    }
    ((i)localObject2).aEn((String)localObject1);
    localObject1 = this.xNF;
    if (localObject1 == null) {
      p.bGy("searchSuggestionManager");
    }
    ((k)localObject1).dRj();
    AppMethodBeat.o(166825);
    return true;
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final void dvg() {}
  
  public final void eF(boolean paramBoolean)
  {
    AppMethodBeat.i(166823);
    if (paramBoolean)
    {
      o localo = o.zWG;
      o.dPE();
    }
    AppMethodBeat.o(166823);
  }
  
  public final int getCommentScene()
  {
    return 23;
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(239774);
    if (dpJ())
    {
      i = b.g.finder_mix_search_ui_night_mode;
      AppMethodBeat.o(239774);
      return i;
    }
    int i = b.g.finder_mix_search_ui;
    AppMethodBeat.o(239774);
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
    paramView = this.xNC;
    if (paramView == null) {
      p.bGy("searchView");
    }
    paramView.getFtsEditText().aDU();
    showVKB();
    AppMethodBeat.o(166824);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166818);
    super.onCreate(paramBundle);
    paramBundle = d.AjH;
    boolean bool;
    Object localObject;
    label119:
    int i;
    label239:
    String str;
    if (((Number)d.dWR().aSr()).intValue() == 1)
    {
      bool = true;
      this.Abu = bool;
      this.Abv = getIntent().getIntExtra("request_type", 0);
      paramBundle = getIntent().getStringExtra("key_click_sub_tab_context_id");
      if (!TextUtils.isEmpty((CharSequence)paramBundle))
      {
        localObject = com.tencent.mm.ui.component.g.Xox;
        ((aj)com.tencent.mm.ui.component.g.b((AppCompatActivity)this).i(aj.class)).yAU = paramBundle;
      }
      if (!dpJ()) {
        break label816;
      }
      paramBundle = new com.tencent.mm.ui.search.a((Context)this, true);
      this.xNC = paramBundle;
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
      if (this.Abu)
      {
        if (!dpJ()) {
          break label831;
        }
        i = b.c.Dark_0;
        paramBundle = this.xNC;
        if (paramBundle == null) {
          p.bGy("searchView");
        }
        paramBundle.axr(i);
      }
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
      localObject = this.xNC;
      if (localObject == null) {
        p.bGy("searchView");
      }
      paramBundle.setCustomView((View)localObject);
      this.xNE = new i((MMActivity)this, false, dpJ(), (kotlin.g.a.b)new b(this), (l)new c());
      this.presenter = new FinderMixSearchPresenter((MMActivity)this, this.Abv);
      paramBundle = (MMActivity)this;
      localObject = this.presenter;
      if (localObject == null) {
        p.bGy("presenter");
      }
      this.Abt = new g(paramBundle, (f.a)localObject, this.Abv);
      paramBundle = this.presenter;
      if (paramBundle == null) {
        p.bGy("presenter");
      }
      localObject = this.Abt;
      if (localObject == null) {
        p.bGy("viewCallback");
      }
      paramBundle.a((f.b)localObject);
      paramBundle = this.Abt;
      if (paramBundle == null) {
        p.bGy("viewCallback");
      }
      paramBundle.jLl.setOnTouchListener((View.OnTouchListener)new d(this));
      paramBundle = (MMActivity)this;
      localObject = this.xNC;
      if (localObject == null) {
        p.bGy("searchView");
      }
      localObject = ((com.tencent.mm.ui.search.a)localObject).getFtsEditText();
      p.j(localObject, "searchView.ftsEditText");
      this.xNF = new k(paramBundle, (FTSEditTextView)localObject, this.Abv, 1, false, dpJ(), (kotlin.g.a.b)new e(this));
      if (dpJ())
      {
        paramBundle = getController();
        localObject = getContext();
        p.j(localObject, "context");
        paramBundle.setActionbarColor(((AppCompatActivity)localObject).getResources().getColor(b.c.Dark_0));
        setBackGroundColorResource(b.c.Dark_0);
      }
      paramBundle = this.xNE;
      if (paramBundle == null) {
        p.bGy("historyLogic");
      }
      paramBundle.AbZ.setVisibility(0);
      paramBundle = this.Abt;
      if (paramBundle == null) {
        p.bGy("viewCallback");
      }
      paramBundle.jLl.a((RecyclerView.l)this.Abw);
      if (!this.Abu)
      {
        paramBundle = com.tencent.mm.plugin.finder.report.n.zWF;
        com.tencent.mm.plugin.finder.report.n.aEc(String.valueOf(cm.bfE()));
        localObject = UUID.randomUUID().toString();
        p.j(localObject, "UUID.randomUUID().toString()");
        paramBundle = com.tencent.mm.plugin.finder.report.n.zWF;
        paramBundle = com.tencent.mm.plugin.finder.report.n.zWF;
        str = com.tencent.mm.plugin.finder.report.n.dPC();
        paramBundle = aj.Bnu;
        paramBundle = getContext();
        p.j(paramBundle, "context");
        paramBundle = aj.a.fZ((Context)paramBundle);
        if (paramBundle == null) {
          break label838;
        }
      }
    }
    label816:
    label831:
    label838:
    for (paramBundle = paramBundle.ekY();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.n.a(str, (String)localObject, "", 1, 1, 1, 0, 0, paramBundle);
      AppMethodBeat.o(166818);
      return;
      bool = false;
      break;
      paramBundle = new com.tencent.mm.ui.search.a((Context)this);
      break label119;
      i = b.c.BW_93;
      break label239;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166819);
    Object localObject = this.xNE;
    if (localObject == null) {
      p.bGy("historyLogic");
    }
    ((i)localObject).onDestroy();
    localObject = this.presenter;
    if (localObject == null) {
      p.bGy("presenter");
    }
    ((FinderMixSearchPresenter)localObject).onDetach();
    hideVKB();
    localObject = this.Abt;
    if (localObject == null) {
      p.bGy("viewCallback");
    }
    ((g)localObject).jLl.b((RecyclerView.l)this.Abw);
    if (!this.Abu)
    {
      localObject = com.tencent.mm.plugin.finder.report.n.zWF;
      com.tencent.mm.plugin.finder.report.n.aEc("");
    }
    super.onDestroy();
    AppMethodBeat.o(166819);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(239787);
    super.onPause();
    Object localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
    com.tencent.mm.plugin.finder.live.report.k.b(null, s.t.yGN, s.l.yFS.scene, c.yAj);
    localObject = this.xNF;
    if (localObject == null) {
      p.bGy("searchSuggestionManager");
    }
    ((k)localObject).onActivityPause();
    AppMethodBeat.o(239787);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(239785);
    super.onResume();
    Object localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
    com.tencent.mm.plugin.finder.live.report.k.b(null, s.t.yGN, s.l.yFS.scene, c.yAi);
    localObject = this.xNF;
    if (localObject == null) {
      p.bGy("searchSuggestionManager");
    }
    ((k)localObject).onActivityResume();
    AppMethodBeat.o(239785);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(239778);
    super.onSwipeBack();
    hideVKB();
    AppMethodBeat.o(239778);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI$Companion;", "", "()V", "KEY_SEARCH_QUERY", "", "KEY_SEARCH_SESSION_BUFFER", "TAG", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "query", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, x>
  {
    b(FinderMixSearchUI paramFinderMixSearchUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderMixSearchUI$initData$2", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "onClear", "", "plugin-finder_release"})
  public static final class c
    implements l
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderMixSearchUI paramFinderMixSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(287433);
      FinderMixSearchUI.a(this.Aby).getFtsEditText().hUu();
      this.Aby.hideVKB();
      AppMethodBeat.o(287433);
      return false;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "suggestion", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<String, x>
  {
    e(FinderMixSearchUI paramFinderMixSearchUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class f
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(264827);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(264827);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(264825);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = com.tencent.mm.plugin.finder.live.report.k.yBj;
      com.tencent.mm.plugin.finder.live.report.k.b(paramRecyclerView, s.t.yGN, s.l.yFS.scene, c.yAh);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(264825);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchUI
 * JD-Core Version:    0.7.0.1
 */