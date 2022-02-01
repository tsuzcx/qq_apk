package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ui.recents.f;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"value", "", "showFooter", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;", "getShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;)Z", "setShowFooter", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendUILogic;Z)V", "show", "showThreeDots", "getShowThreeDots", "setShowThreeDots", "configFooterWording", "", "runOnUiThread", "action", "Lkotlin/Function0;", "setWordingText", "Lcom/tencent/mm/plugin/appbrand/ui/recents/AppBrandLauncherRecentsListFooter;", "wording", "", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  private static void a(f paramf, String paramString)
  {
    AppMethodBeat.i(51382);
    s.u(paramf, "<this>");
    s.u(paramString, "wording");
    ((TextView)paramf.caK.findViewById(ba.f.tv_app_brand_recents_list_footer_wording)).setText((CharSequence)paramString);
    AppMethodBeat.o(51382);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(51383);
    s.u(paramAppBrandRecommendUILogic, "<this>");
    s.u(parama, "action");
    paramAppBrandRecommendUILogic.uoZ.runOnUiThread(new i..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(51383);
  }
  
  public static final void a(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51379);
    s.u(paramAppBrandRecommendUILogic, "<this>");
    paramAppBrandRecommendUILogic.cNd().showLoading(paramBoolean);
    AppMethodBeat.o(51379);
  }
  
  private static final void ax(kotlin.g.a.a parama)
  {
    AppMethodBeat.i(322565);
    s.u(parama, "$action");
    parama.invoke();
    AppMethodBeat.o(322565);
  }
  
  public static final void b(AppBrandRecommendUILogic paramAppBrandRecommendUILogic, boolean paramBoolean)
  {
    AppMethodBeat.i(51380);
    s.u(paramAppBrandRecommendUILogic, "<this>");
    if (!paramBoolean) {
      f(paramAppBrandRecommendUILogic);
    }
    paramAppBrandRecommendUILogic.cNf().setLoading(paramBoolean);
    AppMethodBeat.o(51380);
  }
  
  public static final void f(AppBrandRecommendUILogic paramAppBrandRecommendUILogic)
  {
    AppMethodBeat.i(51381);
    s.u(paramAppBrandRecommendUILogic, "<this>");
    if (paramAppBrandRecommendUILogic.upd.cMW().isEmpty())
    {
      localf = paramAppBrandRecommendUILogic.cNf();
      paramAppBrandRecommendUILogic = com.tencent.mm.cd.a.bt(paramAppBrandRecommendUILogic.context, ba.i.app_brand_recommend_null_list_wording);
      s.s(paramAppBrandRecommendUILogic, "getString(context, R.str…ommend_null_list_wording)");
      a(localf, paramAppBrandRecommendUILogic);
      AppMethodBeat.o(51381);
      return;
    }
    f localf = paramAppBrandRecommendUILogic.cNf();
    paramAppBrandRecommendUILogic = com.tencent.mm.cd.a.bt(paramAppBrandRecommendUILogic.context, ba.i.app_brand_launcher_recents_list_footer_no_more);
    s.s(paramAppBrandRecommendUILogic, "getString(context, R.str…ents_list_footer_no_more)");
    a(localf, paramAppBrandRecommendUILogic);
    AppMethodBeat.o(51381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.i
 * JD-Core Version:    0.7.0.1
 */