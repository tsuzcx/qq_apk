package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.luggage.m.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.c.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "(Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "dimenPX", "", "resId", "getExpectedCapsuleMarginTop", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class at
  implements am
{
  private final AppBrandRuntime euM;
  
  public at(AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(322064);
    this.euM = paramAppBrandRuntime;
    AppMethodBeat.o(322064);
  }
  
  public final int Do(int paramInt)
  {
    AppMethodBeat.i(148225);
    paramInt = getContext().getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(148225);
    return paramInt;
  }
  
  public am.a aqq()
  {
    AppMethodBeat.i(148223);
    am.a locala = new am.a(0, (Do(a.b.DefaultActionbarHeightPort) - Do(a.b.app_brand_default_capsule_actionbarheight)) / 2, Do(a.b.app_brand_actionbar_capsule_view_right_margin_wxa), 0);
    AppMethodBeat.o(148223);
    return locala;
  }
  
  public int c(y paramy)
  {
    AppMethodBeat.i(322076);
    s.u(paramy, "service");
    paramy = paramy.qwF;
    if (paramy == null) {}
    for (paramy = null; paramy == null; paramy = paramy.getStatusBar())
    {
      AppMethodBeat.o(322076);
      return 0;
    }
    if (8 == paramy.visibility)
    {
      AppMethodBeat.o(322076);
      return 0;
    }
    int i = paramy.height;
    AppMethodBeat.o(322076);
    return i;
  }
  
  public final am.b cLL()
  {
    AppMethodBeat.i(148224);
    am.b localb = new am.b(a.eH(getContext().getResources().getDisplayMetrics().density * 96.0F), Do(a.b.app_brand_default_capsule_actionbarheight));
    AppMethodBeat.o(148224);
    return localb;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(322068);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.euM.mContext);
    if (localObject == null) {}
    for (localObject = this.euM.mContext;; localObject = (Context)localObject)
    {
      s.s(localObject, "rt.context ?: rt.appContext");
      AppMethodBeat.o(322068);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.at
 * JD-Core Version:    0.7.0.1
 */