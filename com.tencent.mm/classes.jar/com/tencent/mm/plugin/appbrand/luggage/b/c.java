package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.v.b;
import com.tencent.mm.sdk.platformtools.aj;
import d.y;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/FontScaleProviderWC;", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/IFontScaleProvider;", "()V", "mFontScale", "", "getCurrentFontScale", "getFromSp", "onActivityResumed", "", "activity", "Landroid/app/Activity;", "watchApp", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.aa.a
  implements b
{
  private static float kPd;
  public static final c kPe;
  
  static
  {
    AppMethodBeat.i(50850);
    kPe = new c();
    AppMethodBeat.o(50850);
  }
  
  private static float bht()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(50848);
    try
    {
      float f2 = aj.getContext().getSharedPreferences(aj.eFD(), 4).getFloat("text_size_scale_key", 1.0F);
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
  
  public final float bbU()
  {
    AppMethodBeat.i(50847);
    if (kPd <= 0.0F) {
      kPd = bht();
    }
    float f = kPd;
    AppMethodBeat.o(50847);
    return f;
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(50849);
    com.tencent.mm.ad.c.b(null, (d.g.a.a)a.kPf);
    AppMethodBeat.o(50849);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public static final a kPf;
    
    static
    {
      AppMethodBeat.i(50846);
      kPf = new a();
      AppMethodBeat.o(50846);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */