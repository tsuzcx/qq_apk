package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import d.g.b.k;
import d.l;
import d.y;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"value", "", "showFooter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)Z", "setShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;Z)V", "show", "showThreeDots", "getShowThreeDots", "setShowThreeDots", "configFooterWording", "", "runOnUiThread", "action", "Lkotlin/Function0;", "setWordingText", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "wording", "", "plugin-appbrand-integration_release"})
public final class i
{
  private static void a(g paramg, String paramString)
  {
    AppMethodBeat.i(51382);
    k.h(paramg, "$this$setWordingText");
    k.h(paramString, "wording");
    paramg = paramg.arI.findViewById(2131306108);
    k.g(paramg, "this.itemView.findViewBy…ents_list_footer_wording)");
    ((TextView)paramg).setText((CharSequence)paramString);
    AppMethodBeat.o(51382);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, d.g.a.a<y> parama)
  {
    AppMethodBeat.i(51383);
    k.h(paramAppBrandRecommendUILogic, "$this$runOnUiThread");
    k.h(parama, "action");
    paramAppBrandRecommendUILogic.lLc.runOnUiThread((Runnable)new i.a(parama));
    AppMethodBeat.o(51383);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51379);
    k.h(paramAppBrandRecommendUILogic, "$this$showFooter");
    paramAppBrandRecommendUILogic.bqc().showLoading(paramBoolean);
    AppMethodBeat.o(51379);
  }
  
  public static final void b(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51380);
    k.h(paramAppBrandRecommendUILogic, "$this$showThreeDots");
    if (!paramBoolean) {
      h(paramAppBrandRecommendUILogic);
    }
    paramAppBrandRecommendUILogic.bqe().hh(paramBoolean);
    AppMethodBeat.o(51380);
  }
  
  public static final void h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
  {
    AppMethodBeat.i(51381);
    k.h(paramAppBrandRecommendUILogic, "$this$configFooterWording");
    if (paramAppBrandRecommendUILogic.lKO.bpS().isEmpty())
    {
      localg = paramAppBrandRecommendUILogic.bqe();
      paramAppBrandRecommendUILogic = com.tencent.mm.cd.a.aq(paramAppBrandRecommendUILogic.context, 2131755623);
      k.g(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ommend_null_list_wording)");
      a(localg, paramAppBrandRecommendUILogic);
      AppMethodBeat.o(51381);
      return;
    }
    g localg = paramAppBrandRecommendUILogic.bqe();
    paramAppBrandRecommendUILogic = com.tencent.mm.cd.a.aq(paramAppBrandRecommendUILogic.context, 2131755500);
    k.g(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ents_list_footer_no_more)");
    a(localg, paramAppBrandRecommendUILogic);
    AppMethodBeat.o(51381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.i
 * JD-Core Version:    0.7.0.1
 */