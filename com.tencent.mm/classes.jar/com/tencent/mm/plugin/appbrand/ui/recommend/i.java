package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import d.g.b.p;
import d.l;
import d.z;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"value", "", "showFooter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)Z", "setShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;Z)V", "show", "showThreeDots", "getShowThreeDots", "setShowThreeDots", "configFooterWording", "", "runOnUiThread", "action", "Lkotlin/Function0;", "setWordingText", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "wording", "", "plugin-appbrand-integration_release"})
public final class i
{
  private static void a(g paramg, String paramString)
  {
    AppMethodBeat.i(51382);
    p.h(paramg, "$this$setWordingText");
    p.h(paramString, "wording");
    paramg = paramg.auu.findViewById(2131306108);
    p.g(paramg, "this.itemView.findViewBy…ents_list_footer_wording)");
    ((TextView)paramg).setText((CharSequence)paramString);
    AppMethodBeat.o(51382);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, d.g.a.a<z> parama)
  {
    AppMethodBeat.i(51383);
    p.h(paramAppBrandRecommendUILogic, "$this$runOnUiThread");
    p.h(parama, "action");
    paramAppBrandRecommendUILogic.mSF.runOnUiThread((Runnable)new i.a(parama));
    AppMethodBeat.o(51383);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51379);
    p.h(paramAppBrandRecommendUILogic, "$this$showFooter");
    paramAppBrandRecommendUILogic.bBZ().showLoading(paramBoolean);
    AppMethodBeat.o(51379);
  }
  
  public static final void b(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51380);
    p.h(paramAppBrandRecommendUILogic, "$this$showThreeDots");
    if (!paramBoolean) {
      h(paramAppBrandRecommendUILogic);
    }
    paramAppBrandRecommendUILogic.bCb().hO(paramBoolean);
    AppMethodBeat.o(51380);
  }
  
  public static final void h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
  {
    AppMethodBeat.i(51381);
    p.h(paramAppBrandRecommendUILogic, "$this$configFooterWording");
    if (paramAppBrandRecommendUILogic.mSr.bBP().isEmpty())
    {
      localg = paramAppBrandRecommendUILogic.bCb();
      paramAppBrandRecommendUILogic = com.tencent.mm.cb.a.az(paramAppBrandRecommendUILogic.context, 2131755623);
      p.g(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ommend_null_list_wording)");
      a(localg, paramAppBrandRecommendUILogic);
      AppMethodBeat.o(51381);
      return;
    }
    g localg = paramAppBrandRecommendUILogic.bCb();
    paramAppBrandRecommendUILogic = com.tencent.mm.cb.a.az(paramAppBrandRecommendUILogic.context, 2131755500);
    p.g(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ents_list_footer_no_more)");
    a(localg, paramAppBrandRecommendUILogic);
    AppMethodBeat.o(51381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.i
 * JD-Core Version:    0.7.0.1
 */