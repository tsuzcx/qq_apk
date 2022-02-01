package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.h.a;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dimenPX", "", "resId", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "luggage-wechat-full-sdk_release"})
public class ad
  implements y
{
  private final Context context;
  
  public ad(Context paramContext)
  {
    AppMethodBeat.i(148226);
    this.context = paramContext;
    AppMethodBeat.o(148226);
  }
  
  public y.a CM()
  {
    AppMethodBeat.i(148223);
    y.a locala = new y.a(0, (ub(2131165252) - ub(2131165755)) / 2, ub(2131167028), 0);
    AppMethodBeat.o(148223);
    return locala;
  }
  
  public final y.b boM()
  {
    AppMethodBeat.i(148224);
    Object localObject = this.context.getResources();
    k.g(localObject, "context.resources");
    localObject = new y.b(a.bU(((Resources)localObject).getDisplayMetrics().density * 96.0F), ub(2131165755));
    AppMethodBeat.o(148224);
    return localObject;
  }
  
  public final int ub(int paramInt)
  {
    AppMethodBeat.i(148225);
    paramInt = this.context.getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(148225);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.ad
 * JD-Core Version:    0.7.0.1
 */