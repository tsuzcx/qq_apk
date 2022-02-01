package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.appbrand.jsapi.z.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/FontScaleProviderWC;", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/IFontScaleProvider;", "()V", "mFontScale", "", "getCurrentFontScale", "getFromSp", "onActivityResumed", "", "activity", "Landroid/app/Activity;", "watchApp", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.ac.a
  implements b
{
  private static float nab;
  public static final c nac;
  
  static
  {
    AppMethodBeat.i(50850);
    nac = new c();
    AppMethodBeat.o(50850);
  }
  
  private static float bOv()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(50848);
    try
    {
      float f2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getFloat("text_size_scale_key", 1.0F);
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
  
  public final float bIO()
  {
    AppMethodBeat.i(50847);
    if (nab <= 0.0F) {
      nab = bOv();
    }
    float f = nab;
    AppMethodBeat.o(50847);
    return f;
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(50849);
    d.i((kotlin.g.a.a)a.nad);
    AppMethodBeat.o(50849);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a nad;
    
    static
    {
      AppMethodBeat.i(50846);
      nad = new a();
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