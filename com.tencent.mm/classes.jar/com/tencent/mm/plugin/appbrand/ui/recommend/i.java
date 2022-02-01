package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ui.recents.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"value", "", "showFooter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)Z", "setShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;Z)V", "show", "showThreeDots", "getShowThreeDots", "setShowThreeDots", "configFooterWording", "", "runOnUiThread", "action", "Lkotlin/Function0;", "setWordingText", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "wording", "", "plugin-appbrand-integration_release"})
public final class i
{
  private static void a(g paramg, String paramString)
  {
    AppMethodBeat.i(51382);
    p.k(paramg, "$this$setWordingText");
    p.k(paramString, "wording");
    paramg = paramg.amk.findViewById(au.f.tv_app_brand_recents_list_footer_wording);
    p.j(paramg, "this.itemView.findViewBy…ents_list_footer_wording)");
    ((TextView)paramg).setText((CharSequence)paramString);
    AppMethodBeat.o(51382);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(51383);
    p.k(paramAppBrandRecommendUILogic, "$this$runOnUiThread");
    p.k(parama, "action");
    paramAppBrandRecommendUILogic.rht.runOnUiThread((Runnable)new i.a(parama));
    AppMethodBeat.o(51383);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51379);
    p.k(paramAppBrandRecommendUILogic, "$this$showFooter");
    paramAppBrandRecommendUILogic.clL().showLoading(paramBoolean);
    AppMethodBeat.o(51379);
  }
  
  public static final void b(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51380);
    p.k(paramAppBrandRecommendUILogic, "$this$showThreeDots");
    if (!paramBoolean) {
      h(paramAppBrandRecommendUILogic);
    }
    paramAppBrandRecommendUILogic.clN().jQ(paramBoolean);
    AppMethodBeat.o(51380);
  }
  
  public static final void h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
  {
    AppMethodBeat.i(51381);
    p.k(paramAppBrandRecommendUILogic, "$this$configFooterWording");
    if (paramAppBrandRecommendUILogic.rhf.clz().isEmpty())
    {
      localg = paramAppBrandRecommendUILogic.clN();
      paramAppBrandRecommendUILogic = com.tencent.mm.ci.a.ba(paramAppBrandRecommendUILogic.context, au.i.app_brand_recommend_null_list_wording);
      p.j(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ommend_null_list_wording)");
      a(localg, paramAppBrandRecommendUILogic);
      AppMethodBeat.o(51381);
      return;
    }
    g localg = paramAppBrandRecommendUILogic.clN();
    paramAppBrandRecommendUILogic = com.tencent.mm.ci.a.ba(paramAppBrandRecommendUILogic.context, au.i.app_brand_launcher_recents_list_footer_no_more);
    p.j(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ents_list_footer_no_more)");
    a(localg, paramAppBrandRecommendUILogic);
    AppMethodBeat.o(51381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.i
 * JD-Core Version:    0.7.0.1
 */