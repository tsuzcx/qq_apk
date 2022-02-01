package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "androidOrientation2Orientation", "androidOrientation", "", "Companion", "luggage-commons-jsapi-default-impl_release"})
public final class a
  implements q
{
  public static final a ogC;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(193748);
    ogC = new a((byte)0);
    AppMethodBeat.o(193748);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(193747);
    this.context = paramContext;
    AppMethodBeat.o(193747);
  }
  
  public final ac bTN()
  {
    AppMethodBeat.i(193746);
    Object localObject = this.context.getResources();
    p.g(localObject, "context.resources");
    switch (((Resources)localObject).getConfiguration().orientation)
    {
    default: 
      localObject = ac.ohu;
      AppMethodBeat.o(193746);
      return localObject;
    case 1: 
      localObject = ac.ohv;
      AppMethodBeat.o(193746);
      return localObject;
    }
    localObject = ac.ohw;
    AppMethodBeat.o(193746);
    return localObject;
  }
  
  public final String getName()
  {
    return "AndroidOrientationGetter";
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-commons-jsapi-default-impl_release"})
  public static final class a
    implements q.a
  {
    public static a b(h paramh)
    {
      AppMethodBeat.i(193744);
      if (paramh != null)
      {
        Context localContext = paramh.getContext();
        paramh = localContext;
        if (localContext != null) {}
      }
      else
      {
        paramh = MMApplicationContext.getContext();
        p.g(paramh, "MMApplicationContext.getContext()");
      }
      paramh = new a(paramh);
      AppMethodBeat.o(193744);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a
 * JD-Core Version:    0.7.0.1
 */