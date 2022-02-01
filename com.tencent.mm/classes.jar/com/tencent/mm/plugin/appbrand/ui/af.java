package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.h.a;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dimenPX", "", "resId", "getExpectedPadding", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Padding;", "getExpectedSize", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider$Size;", "luggage-wechat-full-sdk_release"})
public class af
  implements aa
{
  private final Context context;
  
  public af(Context paramContext)
  {
    AppMethodBeat.i(148226);
    this.context = paramContext;
    AppMethodBeat.o(148226);
  }
  
  public aa.a DS()
  {
    AppMethodBeat.i(148223);
    aa.a locala = new aa.a(0, (vD(2131165252) - vD(2131165755)) / 2, vD(2131167028), 0);
    AppMethodBeat.o(148223);
    return locala;
  }
  
  public final aa.b bAI()
  {
    AppMethodBeat.i(148224);
    Object localObject = this.context.getResources();
    p.g(localObject, "context.resources");
    localObject = new aa.b(a.cm(((Resources)localObject).getDisplayMetrics().density * 96.0F), vD(2131165755));
    AppMethodBeat.o(148224);
    return localObject;
  }
  
  public final int vD(int paramInt)
  {
    AppMethodBeat.i(148225);
    paramInt = this.context.getResources().getDimensionPixelSize(paramInt);
    AppMethodBeat.o(148225);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.af
 * JD-Core Version:    0.7.0.1
 */