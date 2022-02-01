package com.tencent.mm.plugin.appbrand.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "curOrientation", "Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "getCurOrientation", "()Lcom/tencent/mm/plugin/appbrand/utils/Orientation;", "name", "", "getName", "()Ljava/lang/String;", "androidOrientation2Orientation", "androidOrientation", "", "Companion", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements v
{
  public static final a uql;
  private final Context context;
  
  static
  {
    AppMethodBeat.i(317407);
    uql = new a((byte)0);
    AppMethodBeat.o(317407);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(317401);
    this.context = paramContext;
    AppMethodBeat.o(317401);
  }
  
  public final aj cHR()
  {
    AppMethodBeat.i(317418);
    switch (this.context.getResources().getConfiguration().orientation)
    {
    default: 
      localaj = aj.urx;
      AppMethodBeat.o(317418);
      return localaj;
    case 1: 
      localaj = aj.ury;
      AppMethodBeat.o(317418);
      return localaj;
    }
    aj localaj = aj.urz;
    AppMethodBeat.o(317418);
    return localaj;
  }
  
  public final String getName()
  {
    return "AndroidOrientationGetter";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter$Companion;", "Lcom/tencent/mm/plugin/appbrand/utils/IOrientationGetter$IFactory;", "()V", "create", "Lcom/tencent/mm/plugin/appbrand/utils/AndroidOrientationGetter;", "componentView", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentView;", "luggage-commons-jsapi-default-impl_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements v.a
  {
    public static b b(h paramh)
    {
      AppMethodBeat.i(317394);
      if (paramh == null) {}
      for (paramh = null;; paramh = paramh.getContext())
      {
        Object localObject = paramh;
        if (paramh == null) {
          localObject = MMApplicationContext.getContext();
        }
        s.s(localObject, "componentView?.context ?…ationContext.getContext()");
        paramh = new b((Context)localObject);
        AppMethodBeat.o(317394);
        return paramh;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.b
 * JD-Core Version:    0.7.0.1
 */