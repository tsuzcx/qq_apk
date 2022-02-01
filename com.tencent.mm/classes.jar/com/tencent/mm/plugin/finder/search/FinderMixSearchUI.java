package com.tencent.mm.plugin.finder.search;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.report.live.s.j;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSEditTextView.a;
import com.tencent.mm.ui.search.FTSEditTextView.b;
import com.tencent.mm.ui.search.a.b;
import com.tencent.mm.ui.search.a.c;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "()V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "isHotSearchEnable", "", "mOnScrollListener", "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1;", "popularListLogic", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "presenter", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchPresenter;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "viewCallback", "Lcom/tencent/mm/plugin/finder/search/FinderMixSearchViewCallback;", "getCommentScene", "", "getLayoutId", "getReportType", "initData", "", "initPopularList", "initSearchView", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onPause", "onResume", "onSearchKeyDown", "onSwipeBack", "onTagClick", "index", "tag", "reportStartSearch", "requestSearch", "showPopularList", "Companion", "plugin-finder_release"})
public final class FinderMixSearchUI
  extends MMFinderUI
  implements FTSEditTextView.a, a.b
{
  public static final a vuA;
  private HashMap _$_findViewCache;
  private FinderMixSearchPresenter presenter;
  private com.tencent.mm.ui.search.a ubO;
  private g ubP;
  private h vtK;
  private f vux;
  private boolean vuy;
  private final e vuz;
  
  static
  {
    AppMethodBeat.i(251322);
    vuA = new a((byte)0);
    AppMethodBeat.o(251322);
  }
  
  public FinderMixSearchUI()
  {
    AppMethodBeat.i(251321);
    this.vuz = new e();
    AppMethodBeat.o(251321);
  }
  
  private final boolean dpD()
  {
    AppMethodBeat.i(251318);
    g localg = this.ubP;
    if (localg != null)
    {
      Object localObject = this.vtK;
      if (localObject == null) {
        p.btv("historyLogic");
      }
      if (!((h)localObject).isShowing())
      {
        localObject = this.vux;
        if (localObject == null) {
          p.btv("viewCallback");
        }
        if (!((f)localObject).isShowing()) {}
      }
      else
      {
        localObject = this.ubO;
        if (localObject == null) {
          p.btv("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject).getFtsEditText().O("", null);
        localObject = this.ubO;
        if (localObject == null) {
          p.btv("searchView");
        }
        ((com.tencent.mm.ui.search.a)localObject).getFtsEditText().gUA();
        localObject = this.vux;
        if (localObject == null) {
          p.btv("viewCallback");
        }
        ((f)localObject).dpG();
        localObject = this.vtK;
        if (localObject == null) {
          p.btv("historyLogic");
        }
        ((h)localObject).dpU();
        boolean bool = localg.ow(true);
        AppMethodBeat.o(251318);
        return bool;
      }
    }
    AppMethodBeat.o(251318);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(251325);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(251325);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(251324);
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
    AppMethodBeat.o(251324);
    return localView1;
  }
  
  public final void a(String paramString1, String paramString2, List<a.c> paramList, FTSEditTextView.b paramb)
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
      paramString2 = n.trim((CharSequence)paramString1).toString();
      paramString1 = paramString2;
      if (paramString2 != null) {}
    }
    else
    {
      paramString1 = "";
    }
    paramString2 = this.vtK;
    if (paramString2 == null) {
      p.btv("historyLogic");
    }
    paramString2.auW(paramString1);
    paramString2 = this.vux;
    if (paramString2 == null) {
      p.btv("viewCallback");
    }
    if (Util.isNullOrNil(paramString1))
    {
      paramString2.vtJ.setVisibility(8);
      paramString2.hSw.setVisibility(8);
      paramString2.hak.setVisibility(8);
    }
    AppMethodBeat.o(166822);
  }
  
  public final boolean awE()
  {
    AppMethodBeat.i(166825);
    hideVKB();
    Object localObject1 = this.ubO;
    if (localObject1 == null) {
      p.btv("searchView");
    }
    localObject1 = ((com.tencent.mm.ui.search.a)localObject1).getFtsEditText();
    p.g(localObject1, "searchView.ftsEditText");
    localObject1 = ((FTSEditTextView)localObject1).getTotalQuery();
    if (localObject1 != null)
    {
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.CharSequence");
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
    if (Util.isNullOrNil((String)localObject1))
    {
      AppMethodBeat.o(166825);
      return true;
    }
    Object localObject2 = this.presenter;
    if (localObject2 == null) {
      p.btv("presenter");
    }
    ((FinderMixSearchPresenter)localObject2).br((String)localObject1, false);
    localObject2 = this.ubP;
    if (localObject2 != null) {
      ((g)localObject2).dpJ();
    }
    localObject2 = this.vtK;
    if (localObject2 == null) {
      p.btv("historyLogic");
    }
    ((h)localObject2).auX((String)localObject1);
    AppMethodBeat.o(166825);
    return true;
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final void dpw() {}
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(166823);
    g localg;
    if (paramBoolean)
    {
      localg = this.ubP;
      if (localg != null)
      {
        if (localg.tmh.getVisibility() == 0) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label141;
          }
          localObject = this.ubO;
          if (localObject == null) {
            p.btv("searchView");
          }
          localObject = ((com.tencent.mm.ui.search.a)localObject).getFtsEditText();
          p.g(localObject, "searchView.ftsEditText");
          localObject = ((FTSEditTextView)localObject).getTotalQuery();
          if (localObject == null) {
            break label155;
          }
          if (localObject != null) {
            break;
          }
          localObject = new t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(166823);
          throw ((Throwable)localObject);
        }
      }
    }
    label141:
    label155:
    for (Object localObject = n.trim((CharSequence)localObject).toString();; localObject = null)
    {
      if (Util.isNullOrNil((String)localObject))
      {
        localg.dpJ();
        localObject = this.vtK;
        if (localObject == null) {
          p.btv("historyLogic");
        }
        ((h)localObject).dpT();
      }
      localObject = com.tencent.mm.plugin.finder.report.l.vfB;
      com.tencent.mm.plugin.finder.report.l.doe();
      AppMethodBeat.o(166823);
      return;
    }
  }
  
  public final int getCommentScene()
  {
    return 23;
  }
  
  public final int getLayoutId()
  {
    return 2131494514;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(166820);
    hideVKB();
    if (dpD()) {
      finish();
    }
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
    paramView = this.ubO;
    if (paramView == null) {
      p.btv("searchView");
    }
    paramView.getFtsEditText().awD();
    showVKB();
    AppMethodBeat.o(166824);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(166818);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.storage.c.vCb;
    boolean bool;
    Object localObject;
    String str;
    if (((Number)com.tencent.mm.plugin.finder.storage.c.dwL().value()).intValue() == 1)
    {
      bool = true;
      this.vuy = bool;
      this.ubO = new com.tencent.mm.ui.search.a((Context)this);
      paramBundle = this.ubO;
      if (paramBundle == null) {
        p.btv("searchView");
      }
      paramBundle.setSearchViewListener((a.b)this);
      paramBundle = this.ubO;
      if (paramBundle == null) {
        p.btv("searchView");
      }
      paramBundle.getFtsEditText().setHint(getString(2131755972));
      paramBundle = this.ubO;
      if (paramBundle == null) {
        p.btv("searchView");
      }
      paramBundle.getFtsEditText().setFtsEditTextListener((FTSEditTextView.a)this);
      paramBundle = this.ubO;
      if (paramBundle == null) {
        p.btv("searchView");
      }
      paramBundle.getFtsEditText().setCanDeleteTag(false);
      if (this.vuy)
      {
        paramBundle = this.ubO;
        if (paramBundle == null) {
          p.btv("searchView");
        }
        paramBundle.gXh();
      }
      paramBundle = this.ubO;
      if (paramBundle == null) {
        p.btv("searchView");
      }
      paramBundle.getFtsEditText().awD();
      paramBundle = this.ubO;
      if (paramBundle == null) {
        p.btv("searchView");
      }
      paramBundle.getFtsEditText().awC();
      paramBundle = this.ubO;
      if (paramBundle == null) {
        p.btv("searchView");
      }
      paramBundle.getFtsEditText().gWY();
      paramBundle = getSupportActionBar();
      if (paramBundle == null) {
        p.hyc();
      }
      p.g(paramBundle, "supportActionBar!!");
      localObject = this.ubO;
      if (localObject == null) {
        p.btv("searchView");
      }
      paramBundle.setCustomView((View)localObject);
      this.vtK = new h((MMActivity)this, false, (kotlin.g.a.b)new b(this), (j)new c(this));
      this.presenter = new FinderMixSearchPresenter((MMActivity)this);
      paramBundle = (MMActivity)this;
      localObject = this.presenter;
      if (localObject == null) {
        p.btv("presenter");
      }
      this.vux = new f(paramBundle, (e.a)localObject);
      paramBundle = this.presenter;
      if (paramBundle == null) {
        p.btv("presenter");
      }
      localObject = this.vux;
      if (localObject == null) {
        p.btv("viewCallback");
      }
      paramBundle.a((e.b)localObject);
      paramBundle = this.vux;
      if (paramBundle == null) {
        p.btv("viewCallback");
      }
      paramBundle.hak.setOnTouchListener((View.OnTouchListener)new d(this));
      paramBundle = this.vtK;
      if (paramBundle == null) {
        p.btv("historyLogic");
      }
      paramBundle.dpT();
      paramBundle = this.vux;
      if (paramBundle == null) {
        p.btv("viewCallback");
      }
      paramBundle.hak.a((RecyclerView.l)this.vuz);
      if (!this.vuy)
      {
        paramBundle = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.auJ(String.valueOf(cl.aWA()));
        localObject = UUID.randomUUID().toString();
        p.g(localObject, "UUID.randomUUID().toString()");
        paramBundle = com.tencent.mm.plugin.finder.report.k.vfA;
        paramBundle = com.tencent.mm.plugin.finder.report.k.vfA;
        str = com.tencent.mm.plugin.finder.report.k.dob();
        paramBundle = FinderReporterUIC.wzC;
        paramBundle = getContext();
        p.g(paramBundle, "context");
        paramBundle = FinderReporterUIC.a.fH((Context)paramBundle);
        if (paramBundle == null) {
          break label587;
        }
      }
    }
    label587:
    for (paramBundle = paramBundle.dIx();; paramBundle = null)
    {
      com.tencent.mm.plugin.finder.report.k.a(str, (String)localObject, "", 1, 1, 1, 0, 0, paramBundle);
      AppMethodBeat.o(166818);
      return;
      bool = false;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(166819);
    Object localObject = this.vtK;
    if (localObject == null) {
      p.btv("historyLogic");
    }
    ((h)localObject).onDestroy();
    localObject = this.ubP;
    if (localObject != null) {
      ((g)localObject).onDestroy();
    }
    localObject = this.presenter;
    if (localObject == null) {
      p.btv("presenter");
    }
    ((FinderMixSearchPresenter)localObject).onDetach();
    hideVKB();
    localObject = this.vux;
    if (localObject == null) {
      p.btv("viewCallback");
    }
    ((f)localObject).hak.b((RecyclerView.l)this.vuz);
    if (!this.vuy)
    {
      localObject = com.tencent.mm.plugin.finder.report.k.vfA;
      com.tencent.mm.plugin.finder.report.k.auJ("");
    }
    super.onDestroy();
    AppMethodBeat.o(166819);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(251320);
    super.onPause();
    com.tencent.mm.plugin.finder.report.live.k localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.voA, s.j.vnQ.scene, com.tencent.mm.plugin.finder.report.live.c.vjg);
    AppMethodBeat.o(251320);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(251319);
    super.onResume();
    com.tencent.mm.plugin.finder.report.live.k localk = com.tencent.mm.plugin.finder.report.live.k.vkd;
    com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.voA, s.j.vnQ.scene, com.tencent.mm.plugin.finder.report.live.c.vjf);
    AppMethodBeat.o(251319);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(251317);
    super.onSwipeBack();
    hideVKB();
    AppMethodBeat.o(251317);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/search/FinderMixSearchUI$Companion;", "", "()V", "KEY_SEARCH_QUERY", "", "KEY_SEARCH_SESSION_BUFFER", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "query", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<String, x>
  {
    b(FinderMixSearchUI paramFinderMixSearchUI)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderMixSearchUI$initData$2", "Lcom/tencent/mm/plugin/finder/search/OnHistoryClearListener;", "onClear", "", "plugin-finder_release"})
  public static final class c
    implements j
  {
    public final void cwc()
    {
      AppMethodBeat.i(251313);
      FinderMixSearchUI.d(this.vuB);
      AppMethodBeat.o(251313);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
  static final class d
    implements View.OnTouchListener
  {
    d(FinderMixSearchUI paramFinderMixSearchUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(251314);
      FinderMixSearchUI.a(this.vuB).getFtsEditText().gUA();
      this.vuB.hideVKB();
      AppMethodBeat.o(251314);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
  public static final class e
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(251316);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(251316);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(251315);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramRecyclerView);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt1);
      ((com.tencent.mm.hellhoundlib.b.b)localObject).pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      localObject = com.tencent.mm.plugin.finder.report.live.k.vkd;
      com.tencent.mm.plugin.finder.report.live.k.b(paramRecyclerView, s.p.voA, s.j.vnQ.scene, com.tencent.mm.plugin.finder.report.live.c.vje);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderMixSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(251315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.FinderMixSearchUI
 * JD-Core Version:    0.7.0.1
 */