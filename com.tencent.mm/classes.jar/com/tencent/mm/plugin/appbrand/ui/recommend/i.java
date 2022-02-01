package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"value", "", "showFooter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)Z", "setShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;Z)V", "show", "showThreeDots", "getShowThreeDots", "setShowThreeDots", "configFooterWording", "", "runOnUiThread", "action", "Lkotlin/Function0;", "setWordingText", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "wording", "", "plugin-appbrand-integration_release"})
public final class i
{
  private static void a(g paramg, String paramString)
  {
    AppMethodBeat.i(51382);
    p.h(paramg, "$this$setWordingText");
    p.h(paramString, "wording");
    paramg = paramg.aus.findViewById(2131309452);
    p.g(paramg, "this.itemView.findViewBy…ents_list_footer_wording)");
    ((TextView)paramg).setText((CharSequence)paramString);
    AppMethodBeat.o(51382);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(51383);
    p.h(paramAppBrandRecommendUILogic, "$this$runOnUiThread");
    p.h(parama, "action");
    paramAppBrandRecommendUILogic.ofI.runOnUiThread((Runnable)new i.a(parama));
    AppMethodBeat.o(51383);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51379);
    p.h(paramAppBrandRecommendUILogic, "$this$showFooter");
    paramAppBrandRecommendUILogic.bZc().showLoading(paramBoolean);
    AppMethodBeat.o(51379);
  }
  
  public static final void b(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51380);
    p.h(paramAppBrandRecommendUILogic, "$this$showThreeDots");
    if (!paramBoolean) {
      h(paramAppBrandRecommendUILogic);
    }
    paramAppBrandRecommendUILogic.bZe().iT(paramBoolean);
    AppMethodBeat.o(51380);
  }
  
  public static final void h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
  {
    AppMethodBeat.i(51381);
    p.h(paramAppBrandRecommendUILogic, "$this$configFooterWording");
    if (paramAppBrandRecommendUILogic.ofu.bYP().isEmpty())
    {
      localg = paramAppBrandRecommendUILogic.bZe();
      paramAppBrandRecommendUILogic = com.tencent.mm.cb.a.aI(paramAppBrandRecommendUILogic.context, 2131755670);
      p.g(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ommend_null_list_wording)");
      a(localg, paramAppBrandRecommendUILogic);
      AppMethodBeat.o(51381);
      return;
    }
    g localg = paramAppBrandRecommendUILogic.bZe();
    paramAppBrandRecommendUILogic = com.tencent.mm.cb.a.aI(paramAppBrandRecommendUILogic.context, 2131755538);
    p.g(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ents_list_footer_no_more)");
    a(localg, paramAppBrandRecommendUILogic);
    AppMethodBeat.o(51381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.i
 * JD-Core Version:    0.7.0.1
 */