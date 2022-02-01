package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.cgi.dw;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.search.i;
import com.tencent.mm.plugin.finder.search.i.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSSearchView;
import com.tencent.mm.ui.search.FTSSearchView.5;
import com.tencent.mm.ui.search.FTSSearchView.b;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "()V", "popularListLogic", "Lcom/tencent/mm/plugin/finder/search/FinderPopularListLogic;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "getCommentScene", "", "getLayoutId", "getReportTag", "", "initPopularList", "", "initSearchView", "jumpToFeedList", "hotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "position", "hotWordList", "", "jumpToMixSearchUI", "onClickBackBtn", "view", "Landroid/view/View;", "onClickCancelBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "onSwipeBack", "reportStartSearch", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLongVideoPreviewUI
  extends MMFinderUI
  implements FTSSearchView.b
{
  private FTSSearchView Bny;
  private i Bqf;
  
  private static final void a(FinderLongVideoPreviewUI paramFinderLongVideoPreviewUI)
  {
    AppMethodBeat.i(364909);
    kotlin.g.b.s.u(paramFinderLongVideoPreviewUI, "this$0");
    paramFinderLongVideoPreviewUI = paramFinderLongVideoPreviewUI.Bqf;
    if (paramFinderLongVideoPreviewUI != null) {
      paramFinderLongVideoPreviewUI.def();
    }
    AppMethodBeat.o(364909);
  }
  
  private static final void a(FinderLongVideoPreviewUI paramFinderLongVideoPreviewUI, View paramView)
  {
    AppMethodBeat.i(364916);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderLongVideoPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderLongVideoPreviewUI, "this$0");
    paramView = new Intent();
    localObject = as.GSQ;
    as.a.a((Context)paramFinderLongVideoPreviewUI, paramView, 0L, 0, false, 124);
    localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
    paramFinderLongVideoPreviewUI = paramFinderLongVideoPreviewUI.getContext();
    kotlin.g.b.s.s(paramFinderLongVideoPreviewUI, "context");
    com.tencent.mm.plugin.finder.utils.a.V((Context)paramFinderLongVideoPreviewUI, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderLongVideoPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364916);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return "FinderLongVideoPreviewUI";
  }
  
  public final int getCommentScene()
  {
    return 125;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_popular_list_ui;
  }
  
  public final void onClickBackBtn(View paramView)
  {
    AppMethodBeat.i(365003);
    hideVKB();
    if (!isFinishing()) {
      finish();
    }
    AppMethodBeat.o(365003);
  }
  
  public final void onClickCancelBtn(View paramView) {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364961);
    super.onCreate(paramBundle);
    this.Bny = new FTSSearchView((Context)this);
    paramBundle = this.Bny;
    Object localObject1;
    label129:
    Object localObject2;
    label364:
    int i;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
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
      paramBundle.getFtsEditText().setCanDeleteTag(false);
      paramBundle = this.Bny;
      if (paramBundle != null) {
        break label607;
      }
      kotlin.g.b.s.bIx("searchView");
      paramBundle = null;
      localObject1 = new FinderLongVideoPreviewUI..ExternalSyntheticLambda0(this);
      paramBundle.afCo.setVisibility(8);
      paramBundle.afCp.setVisibility(0);
      paramBundle.afCs = ((TextView)paramBundle.findViewById(a.g.hot_search_hint_text));
      paramBundle.afCn = paramBundle.findViewById(a.g.back_btn);
      paramBundle.afCn.setOnClickListener(new FTSSearchView.5(paramBundle));
      paramBundle.afCp.setClickable(true);
      paramBundle.afCp.setOnClickListener((View.OnClickListener)localObject1);
      paramBundle.afCn.setVisibility(0);
      paramBundle.CxW.setVisibility(8);
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
      this.Bqf = new i((MMActivity)this, (q)new a(this));
      localObject1 = this.Bqf;
      if (localObject1 != null)
      {
        com.tencent.mm.kernel.h.aZW().a(4069, (com.tencent.mm.am.h)localObject1);
        paramBundle = i.c.FxP;
        paramBundle = i.c.ePb();
        if (paramBundle != null) {
          break label610;
        }
        paramBundle = null;
        if (paramBundle == null) {
          ((i)localObject1).Api.setVisibility(8);
        }
        int j = cn.getSyncServerTimeSecond();
        paramBundle = i.c.FxP;
        if (i.c.ePa() != 0)
        {
          paramBundle = i.c.FxP;
          if (j - i.c.ePa() <= 60)
          {
            paramBundle = ((i)localObject1).FxK;
            if ((paramBundle == null) || (paramBundle.isEmpty() != true)) {
              break label626;
            }
            i = 1;
            label428:
            if (i == 0) {
              break label512;
            }
          }
        }
        paramBundle = i.c.FxP;
        i.c.Th(j);
        com.tencent.mm.kernel.h.aZW().a((p)((i)localObject1).FxG);
        paramBundle = as.GSQ;
        paramBundle = as.a.hu((Context)((i)localObject1).activity);
        if (paramBundle != null) {
          break label631;
        }
        paramBundle = null;
        label476:
        ((i)localObject1).FxG = new dw(10, null, paramBundle, null, null, 56);
        com.tencent.mm.kernel.h.aZW().a((p)((i)localObject1).FxG, 0);
      }
      label512:
      paramBundle = z.FrZ;
      z.azT(String.valueOf(cn.bDw()));
      localObject1 = UUID.randomUUID().toString();
      kotlin.g.b.s.s(localObject1, "randomUUID().toString()");
      paramBundle = z.FrZ;
      paramBundle = z.FrZ;
      localObject2 = z.eMW();
      paramBundle = as.GSQ;
      paramBundle = getContext();
      kotlin.g.b.s.s(paramBundle, "context");
      paramBundle = as.a.hu((Context)paramBundle);
      if (paramBundle != null) {
        break label639;
      }
    }
    label607:
    label610:
    label626:
    label631:
    label639:
    for (paramBundle = null;; paramBundle = paramBundle.fou())
    {
      z.a((String)localObject2, (String)localObject1, "", 1, 1, 1, 0, 0, paramBundle);
      AppMethodBeat.o(364961);
      return;
      break;
      break label129;
      i.a((i)localObject1);
      ((i)localObject1).q(paramBundle, false);
      break label364;
      i = 0;
      break label428;
      paramBundle = paramBundle.fou();
      break label476;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364978);
    super.onDestroy();
    i locali = this.Bqf;
    if (locali != null) {
      com.tencent.mm.kernel.h.aZW().b(4069, (com.tencent.mm.am.h)locali);
    }
    AppMethodBeat.o(364978);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364970);
    super.onResume();
    FTSSearchView localFTSSearchView = this.Bny;
    Object localObject = localFTSSearchView;
    if (localFTSSearchView == null)
    {
      kotlin.g.b.s.bIx("searchView");
      localObject = null;
    }
    ((FTSSearchView)localObject).post(new FinderLongVideoPreviewUI..ExternalSyntheticLambda1(this));
    localObject = this.Bqf;
    if (localObject != null) {
      ((i)localObject).eOV();
    }
    AppMethodBeat.o(364970);
  }
  
  public final void onSwipeBack()
  {
    AppMethodBeat.i(364987);
    super.onSwipeBack();
    hideVKB();
    AppMethodBeat.o(364987);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "hotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "position", "", "hotWordList", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<bux, Integer, List<? extends bux>, ah>
  {
    a(FinderLongVideoPreviewUI paramFinderLongVideoPreviewUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoPreviewUI
 * JD-Core Version:    0.7.0.1
 */