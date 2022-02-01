package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cu;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.search.h.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.ui.search.a.b;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "()V", "popularListLogic", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getCommentScene", "", "getLayoutId", "getReportTag", "", "initPopularList", "", "initSearchView", "jumpToFeedList", "hotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "position", "hotWordList", "", "jumpToMixSearchUI", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSwipeBack", "reportStartSearch", "plugin-finder_release"})
public final class FinderLongVideoPreviewUI
  extends MMFinderUI
  implements a.b
{
  private HashMap _$_findViewCache;
  private a xNC;
  private com.tencent.mm.plugin.finder.search.h xQH;
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(277547);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(277547);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(277546);
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
    AppMethodBeat.o(277546);
    return localView1;
  }
  
  public final String dvl()
  {
    return "FinderLongVideoPreviewUI";
  }
  
  public final int getCommentScene()
  {
    return 6;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_popular_list_ui;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(277543);
    hideVKB();
    if (!isFinishing()) {
      finish();
    }
    AppMethodBeat.o(277543);
  }
  
  public final void onClickCancelBtn(View paramView) {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277539);
    super.onCreate(paramBundle);
    this.xNC = new a((Context)this);
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
    paramBundle.getFtsEditText().setCanDeleteTag(false);
    paramBundle = this.xNC;
    if (paramBundle == null) {
      p.bGy("searchView");
    }
    paramBundle.l((View.OnClickListener)new FinderLongVideoPreviewUI.b(this));
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
    Object localObject = this.xNC;
    if (localObject == null) {
      p.bGy("searchView");
    }
    paramBundle.setCustomView((View)localObject);
    this.xQH = new com.tencent.mm.plugin.finder.search.h((MMActivity)this, (kotlin.g.a.q)new FinderLongVideoPreviewUI.a(this));
    localObject = this.xQH;
    if (localObject != null)
    {
      com.tencent.mm.kernel.h.aGY().a(4069, (i)localObject);
      paramBundle = h.c.AbX;
      paramBundle = h.c.dRb();
      if (paramBundle != null)
      {
        com.tencent.mm.plugin.finder.search.h.a((com.tencent.mm.plugin.finder.search.h)localObject);
        ((com.tencent.mm.plugin.finder.search.h)localObject).eH(paramBundle);
        if (paramBundle != null) {}
      }
      else
      {
        ((com.tencent.mm.plugin.finder.search.h)localObject).wSF.setVisibility(8);
        paramBundle = x.aazN;
      }
      int i = cm.bfF();
      paramBundle = h.c.AbX;
      if (h.c.dQZ() != 0)
      {
        paramBundle = h.c.AbX;
        if (i - h.c.dQZ() <= 240)
        {
          paramBundle = ((com.tencent.mm.plugin.finder.search.h)localObject).AbM;
          if ((paramBundle == null) || (paramBundle.isEmpty() != true)) {
            break label401;
          }
        }
      }
      paramBundle = h.c.AbX;
      h.c.PZ(i);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)((com.tencent.mm.plugin.finder.search.h)localObject).AbI);
      paramBundle = aj.Bnu;
      paramBundle = aj.a.fZ((Context)((com.tencent.mm.plugin.finder.search.h)localObject).activity);
      if (paramBundle == null) {
        break label493;
      }
      paramBundle = paramBundle.ekY();
      ((com.tencent.mm.plugin.finder.search.h)localObject).AbI = new cu(10, null, paramBundle, null, null, 56);
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)((com.tencent.mm.plugin.finder.search.h)localObject).AbI);
    }
    label401:
    paramBundle = n.zWF;
    n.aEc(String.valueOf(cm.bfE()));
    localObject = UUID.randomUUID().toString();
    p.j(localObject, "UUID.randomUUID().toString()");
    paramBundle = n.zWF;
    paramBundle = n.zWF;
    String str = n.dPC();
    paramBundle = aj.Bnu;
    paramBundle = getContext();
    p.j(paramBundle, "context");
    paramBundle = aj.a.fZ((Context)paramBundle);
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.ekY();; paramBundle = null)
    {
      n.a(str, (String)localObject, "", 1, 1, 1, 0, 0, paramBundle);
      AppMethodBeat.o(277539);
      return;
      label493:
      paramBundle = null;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(277541);
    super.onDestroy();
    com.tencent.mm.plugin.finder.search.h localh = this.xQH;
    if (localh != null)
    {
      com.tencent.mm.kernel.h.aGY().b(4069, (i)localh);
      AppMethodBeat.o(277541);
      return;
    }
    AppMethodBeat.o(277541);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(277540);
    super.onResume();
    Object localObject = this.xNC;
    if (localObject == null) {
      p.bGy("searchView");
    }
    ((a)localObject).post((Runnable)new c(this));
    localObject = this.xQH;
    if (localObject != null)
    {
      ((com.tencent.mm.plugin.finder.search.h)localObject).dQU();
      AppMethodBeat.o(277540);
      return;
    }
    AppMethodBeat.o(277540);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(277542);
    super.onSwipeBack();
    hideVKB();
    AppMethodBeat.o(277542);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(FinderLongVideoPreviewUI paramFinderLongVideoPreviewUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(277164);
      com.tencent.mm.plugin.finder.search.h localh = FinderLongVideoPreviewUI.a(this.xQI);
      if (localh != null)
      {
        localh.cBa();
        AppMethodBeat.o(277164);
        return;
      }
      AppMethodBeat.o(277164);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */