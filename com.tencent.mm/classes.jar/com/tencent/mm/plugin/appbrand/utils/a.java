package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "androidOrientation2Orientation", "androidOrientation", "", "Companion", "luggage-commons-jsapi-default-impl_release"})
public final class a
  implements q
{
  public static final a mTz;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(197218);
    mTz = new a((byte)0);
    AppMethodBeat.o(197218);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(197217);
    this.context = paramContext;
    AppMethodBeat.o(197217);
  }
  
  public final ac bxC()
  {
    AppMethodBeat.i(197216);
    Object localObject = this.context.getResources();
    p.g(localObject, "context.resources");
    switch (((Resources)localObject).getConfiguration().orientation)
    {
    default: 
      localObject = ac.mUt;
      AppMethodBeat.o(197216);
      return localObject;
    case 1: 
      localObject = ac.mUu;
      AppMethodBeat.o(197216);
      return localObject;
    }
    localObject = ac.mUv;
    AppMethodBeat.o(197216);
    return localObject;
  }
  
  public final String getName()
  {
    return "AndroidOrientationGetter";
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-commons-jsapi-default-impl_release"})
  public static final class a
    implements q.a
  {
    public static a b(e parame)
    {
      AppMethodBeat.i(197214);
      if (parame != null)
      {
        Context localContext = parame.getContext();
        parame = localContext;
        if (localContext != null) {}
      }
      else
      {
        parame = ak.getContext();
        p.g(parame, "MMApplicationContext.getContext()");
      }
      parame = new a(parame);
      AppMethodBeat.o(197214);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a
 * JD-Core Version:    0.7.0.1
 */