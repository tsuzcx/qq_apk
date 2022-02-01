package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.h.a;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dimenPX", "", "resId", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "luggage-wechat-full-sdk_release"})
public class ac
  implements x
{
  private final Context context;
  
  public ac(Context paramContext)
  {
    AppMethodBeat.i(148226);
    this.context = paramContext;
    AppMethodBeat.o(148226);
  }
  
  public x.a Cq()
  {
    AppMethodBeat.i(148223);
    x.a locala = new x.a(0, (uT(2131165252) - uT(2131165755)) / 2, uT(2131167028), 0);
    AppMethodBeat.o(148223);
    return locala;
  }
  
  public final x.b bvH()
  {
    AppMethodBeat.i(148224);
    Object localObject = this.context.getResources();
    k.g(localObject, "context.resources");
    localObject = new x.b(a.cj(((Resources)localObject).getDisplayMetrics().density * 96.0F), uT(2131165755));
    AppMethodBeat.o(148224);
    return localObject;
  }
  
  public final int uT(int paramInt)
  {
    AppMethodBeat.i(148225);
    paramInt = this.context.getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(148225);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ac
 * JD-Core Version:    0.7.0.1
 */