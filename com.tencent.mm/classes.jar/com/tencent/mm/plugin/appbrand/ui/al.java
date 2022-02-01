package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.l.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dimenPX", "", "resId", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "luggage-wechat-full-sdk_release"})
public class al
  implements af
{
  private final AppBrandRuntime cCA;
  
  public al(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(239050);
    this.cCA = paramAppBrandRuntime;
    AppMethodBeat.o(239050);
  }
  
  public final int CU(int paramInt)
  {
    AppMethodBeat.i(148225);
    paramInt = getContext().getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(148225);
    return paramInt;
  }
  
  public af.a Qg()
  {
    AppMethodBeat.i(148223);
    af.a locala = new af.a(0, (CU(a.b.DefaultActionbarHeightPort) - CU(a.b.app_brand_default_capsule_actionbarheight)) / 2, CU(a.b.app_brand_actionbar_capsule_view_right_margin_wxa), 0);
    AppMethodBeat.o(148223);
    return locala;
  }
  
  public final af.b ckx()
  {
    AppMethodBeat.i(148224);
    Object localObject = getContext().getResources();
    p.j(localObject, "context.resources");
    localObject = new af.b(a.dm(((Resources)localObject).getDisplayMetrics().density * 96.0F), CU(a.b.app_brand_default_capsule_actionbarheight));
    AppMethodBeat.o(148224);
    return localObject;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(239048);
    Object localObject = this.cCA.getContext();
    if (localObject != null)
    {
      localObject = (Context)localObject;
      AppMethodBeat.o(239048);
      return localObject;
    }
    localObject = this.cCA.getAppContext();
    p.j(localObject, "rt.appContext");
    AppMethodBeat.o(239048);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.al
 * JD-Core Version:    0.7.0.1
 */