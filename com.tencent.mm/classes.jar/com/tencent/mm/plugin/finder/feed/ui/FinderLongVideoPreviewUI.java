package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.cp;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.search.g.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a.b;
import java.util.HashMap;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "()V", "popularListLogic", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getCommentScene", "", "getLayoutId", "initPopularList", "", "initSearchView", "jumpToFeedList", "hotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "jumpToMixSearchUI", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSwipeBack", "reportStartSearch", "plugin-finder_release"})
public final class FinderLongVideoPreviewUI
  extends MMFinderUI
  implements a.b
{
  private HashMap _$_findViewCache;
  private com.tencent.mm.ui.search.a ubO;
  private com.tencent.mm.plugin.finder.search.g ubP;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245428);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245428);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245427);
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
    AppMethodBeat.o(245427);
    return localView1;
  }
  
  public final int getCommentScene()
  {
    return 6;
  }
  
  public final int getLayoutId()
  {
    return 2131494561;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(245424);
    hideVKB();
    if (!isFinishing()) {
      finish();
    }
    AppMethodBeat.o(245424);
  }
  
  public final void onClickCancelBtn(View paramView) {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245420);
    super.onCreate(paramBundle);
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
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.ubO;
    if (paramBundle == null) {
      p.btv("searchView");
    }
    paramBundle.j((View.OnClickListener)new b(this));
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
    Object localObject = this.ubO;
    if (localObject == null) {
      p.btv("searchView");
    }
    paramBundle.setCustomView((View)localObject);
    this.ubP = new com.tencent.mm.plugin.finder.search.g((MMActivity)this, (kotlin.g.a.b)new a(this));
    paramBundle = this.ubP;
    if (paramBundle != null)
    {
      com.tencent.mm.kernel.g.azz().a(4069, (i)paramBundle);
      paramBundle.dpK();
      int i = cl.aWB();
      localObject = g.c.vuZ;
      if (g.c.dpQ() != 0)
      {
        localObject = g.c.vuZ;
        if (i - g.c.dpQ() <= 240) {}
      }
      else
      {
        localObject = g.c.vuZ;
        g.c.KO(i);
        com.tencent.mm.kernel.g.azz().a((com.tencent.mm.ak.q)paramBundle.vuK);
        paramBundle.vuK = new cp((byte)0);
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramBundle.vuK);
      }
    }
    paramBundle = k.vfA;
    k.auJ(String.valueOf(cl.aWA()));
    localObject = UUID.randomUUID().toString();
    p.g(localObject, "UUID.randomUUID().toString()");
    paramBundle = k.vfA;
    paramBundle = k.vfA;
    String str = k.dob();
    paramBundle = FinderReporterUIC.wzC;
    paramBundle = getContext();
    p.g(paramBundle, "context");
    paramBundle = FinderReporterUIC.a.fH((Context)paramBundle);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.dIx();; paramBundle = null)
    {
      k.a(str, (String)localObject, "", 1, 1, 1, 0, 0, paramBundle);
      AppMethodBeat.o(245420);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245422);
    super.onDestroy();
    Object localObject = this.ubP;
    if (localObject != null) {
      ((com.tencent.mm.plugin.finder.search.g)localObject).onDestroy();
    }
    localObject = k.vfA;
    k.auJ("");
    AppMethodBeat.o(245422);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245421);
    super.onResume();
    Object localObject = this.ubO;
    if (localObject == null) {
      p.btv("searchView");
    }
    ((com.tencent.mm.ui.search.a)localObject).post((Runnable)new c(this));
    localObject = this.ubP;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.search.g)localObject).dpI();
      AppMethodBeat.o(245421);
      return;
    }
    AppMethodBeat.o(245421);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(245423);
    super.onSwipeBack();
    hideVKB();
    AppMethodBeat.o(245423);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "hotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<bby, x>
  {
    a(FinderLongVideoPreviewUI paramFinderLongVideoPreviewUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderLongVideoPreviewUI paramFinderLongVideoPreviewUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245418);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI$initSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderLongVideoPreviewUI.b(this.ubQ);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI$initSearchView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245418);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderLongVideoPreviewUI paramFinderLongVideoPreviewUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(245419);
      com.tencent.mm.plugin.finder.search.g localg = FinderLongVideoPreviewUI.a(this.ubQ);
      if (localg != null)
      {
        localg.cnl();
        AppMethodBeat.o(245419);
        return;
      }
      AppMethodBeat.o(245419);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */