package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.u.b;
import com.tencent.mm.sdk.platformtools.ai;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/FontScaleProviderWC;", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/IFontScaleProvider;", "()V", "mFontScale", "", "getCurrentFontScale", "getFromSp", "onActivityResumed", "", "activity", "Landroid/app/Activity;", "watchApp", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.z.a
  implements b
{
  private static float lqC;
  public static final c lqD;
  
  static
  {
    AppMethodBeat.i(50850);
    lqD = new c();
    AppMethodBeat.o(50850);
  }
  
  private static float bon()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(50848);
    try
    {
      float f2 = ai.getContext().getSharedPreferences(ai.eUX(), 4).getFloat("text_size_scale_key", 1.0F);
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
  
  public final float biP()
  {
    AppMethodBeat.i(50847);
    if (lqC <= 0.0F) {
      lqC = bon();
    }
    float f = lqC;
    AppMethodBeat.o(50847);
    return f;
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(50849);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)a.lqE);
    AppMethodBeat.o(50849);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final a lqE;
    
    static
    {
      AppMethodBeat.i(50846);
      lqE = new a();
      AppMethodBeat.o(50846);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */