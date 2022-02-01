package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "androidOrientation2Orientation", "androidOrientation", "", "Companion", "luggage-commons-jsapi-default-impl_release"})
public final class b
  implements s
{
  public static final a rip;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(205672);
    rip = new a((byte)0);
    AppMethodBeat.o(205672);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(205671);
    this.context = paramContext;
    AppMethodBeat.o(205671);
  }
  
  public final ae cgT()
  {
    AppMethodBeat.i(205670);
    Object localObject = this.context.getResources();
    p.j(localObject, "context.resources");
    switch (((Resources)localObject).getConfiguration().orientation)
    {
    default: 
      localObject = ae.rji;
      AppMethodBeat.o(205670);
      return localObject;
    case 1: 
      localObject = ae.rjj;
      AppMethodBeat.o(205670);
      return localObject;
    }
    localObject = ae.rjk;
    AppMethodBeat.o(205670);
    return localObject;
  }
  
  public final String getName()
  {
    return "AndroidOrientationGetter";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-commons-jsapi-default-impl_release"})
  public static final class a
    implements s.a
  {
    public static b b(g paramg)
    {
      AppMethodBeat.i(205506);
      if (paramg != null)
      {
        Context localContext = paramg.getContext();
        paramg = localContext;
        if (localContext != null) {}
      }
      else
      {
        paramg = MMApplicationContext.getContext();
        p.j(paramg, "MMApplicationContext.getContext()");
      }
      paramg = new b(paramg);
      AppMethodBeat.o(205506);
      return paramg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.b
 * JD-Core Version:    0.7.0.1
 */