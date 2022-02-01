package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.b;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/FontScaleProviderWC;", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/IFontScaleProvider;", "()V", "mFontScale", "", "getCurrentFontScale", "getFromSp", "onActivityResumed", "", "activity", "Landroid/app/Activity;", "watchApp", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.z.a
  implements b
{
  private static float lOa;
  public static final c lOb;
  
  static
  {
    AppMethodBeat.i(50850);
    lOb = new c();
    AppMethodBeat.o(50850);
  }
  
  private static float bsg()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(50848);
    try
    {
      float f2 = aj.getContext().getSharedPreferences(aj.fkC(), 4).getFloat("text_size_scale_key", 1.0F);
      f1 = f2;
    }
    catch (Throwable localThrowable)
    {
      label28:
      break label28;
    }
    AppMethodBeat.o(50848);
    return f1;
  }
  
  public final float bmB()
  {
    AppMethodBeat.i(50847);
    if (lOa <= 0.0F) {
      lOa = bsg();
    }
    float f = lOa;
    AppMethodBeat.o(50847);
    return f;
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(50849);
    com.tencent.mm.ad.c.b(null, (d.g.a.a)a.lOc);
    AppMethodBeat.o(50849);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a lOc;
    
    static
    {
      AppMethodBeat.i(50846);
      lOc = new a();
      AppMethodBeat.o(50846);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */