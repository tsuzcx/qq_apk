package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f.b.j;
import a.l;
import a.y;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.recents.e;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"value", "", "showFooter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)Z", "setShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;Z)V", "show", "showThreeDots", "getShowThreeDots", "setShowThreeDots", "configFooterWording", "", "runOnUiThread", "action", "Lkotlin/Function0;", "setWordingText", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "wording", "", "plugin-appbrand-integration_release"})
public final class i
{
  private static void a(e parame, String paramString)
  {
    AppMethodBeat.i(135206);
    j.q(parame, "receiver$0");
    j.q(paramString, "wording");
    parame = parame.aku.findViewById(2131821348);
    j.p(parame, "this.itemView.findViewBy…ents_list_footer_wording)");
    ((TextView)parame).setText((CharSequence)paramString);
    AppMethodBeat.o(135206);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, a.f.a.a<y> parama)
  {
    AppMethodBeat.i(135207);
    j.q(paramAppBrandRecommendUILogic, "receiver$0");
    j.q(parama, "action");
    paramAppBrandRecommendUILogic.activity.runOnUiThread((Runnable)new i.a(parama));
    AppMethodBeat.o(135207);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(135203);
    j.q(paramAppBrandRecommendUILogic, "receiver$0");
    paramAppBrandRecommendUILogic.aNK().fv(paramBoolean);
    AppMethodBeat.o(135203);
  }
  
  public static final void b(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(135204);
    j.q(paramAppBrandRecommendUILogic, "receiver$0");
    if (!paramBoolean) {
      h(paramAppBrandRecommendUILogic);
    }
    paramAppBrandRecommendUILogic.aNM().eU(paramBoolean);
    AppMethodBeat.o(135204);
  }
  
  public static final void h(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
  {
    AppMethodBeat.i(135205);
    j.q(paramAppBrandRecommendUILogic, "receiver$0");
    if (paramAppBrandRecommendUILogic.iWC.aNz().isEmpty())
    {
      locale = paramAppBrandRecommendUILogic.aNM();
      paramAppBrandRecommendUILogic = com.tencent.mm.cb.a.aq(paramAppBrandRecommendUILogic.context, 2131296823);
      j.p(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ommend_null_list_wording)");
      a(locale, paramAppBrandRecommendUILogic);
      AppMethodBeat.o(135205);
      return;
    }
    e locale = paramAppBrandRecommendUILogic.aNM();
    paramAppBrandRecommendUILogic = com.tencent.mm.cb.a.aq(paramAppBrandRecommendUILogic.context, 2131296719);
    j.p(paramAppBrandRecommendUILogic, "ResourceHelper.getString…ents_list_footer_no_more)");
    a(locale, paramAppBrandRecommendUILogic);
    AppMethodBeat.o(135205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.i
 * JD-Core Version:    0.7.0.1
 */