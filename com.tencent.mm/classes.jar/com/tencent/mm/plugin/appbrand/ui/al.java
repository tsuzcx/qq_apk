package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import kotlin.g.b.p;
import kotlin.h.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dimenPX", "", "resId", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "luggage-wechat-full-sdk_release"})
public class al
  implements ag
{
  private final AppBrandRuntime cBW;
  
  public al(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(230233);
    this.cBW = paramAppBrandRuntime;
    AppMethodBeat.o(230233);
  }
  
  public ag.a No()
  {
    AppMethodBeat.i(148223);
    ag.a locala = new ag.a(0, (zr(2131165256) - zr(2131165774)) / 2, zr(2131165760), 0);
    AppMethodBeat.o(148223);
    return locala;
  }
  
  public final ag.b bXN()
  {
    AppMethodBeat.i(148224);
    Object localObject = getContext().getResources();
    p.g(localObject, "context.resources");
    localObject = new ag.b(a.cR(((Resources)localObject).getDisplayMetrics().density * 96.0F), zr(2131165774));
    AppMethodBeat.o(148224);
    return localObject;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(230232);
    Object localObject = this.cBW.getContext();
    if (localObject != null)
    {
      localObject = (Context)localObject;
      AppMethodBeat.o(230232);
      return localObject;
    }
    localObject = this.cBW.getAppContext();
    p.g(localObject, "rt.appContext");
    AppMethodBeat.o(230232);
    return localObject;
  }
  
  public final int zr(int paramInt)
  {
    AppMethodBeat.i(148225);
    paramInt = getContext().getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(148225);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.al
 * JD-Core Version:    0.7.0.1
 */