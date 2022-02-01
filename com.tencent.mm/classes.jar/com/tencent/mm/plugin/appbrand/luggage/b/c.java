package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.appbrand.jsapi.ae.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/FontScaleProviderWC;", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/IFontScaleProvider;", "()V", "mFontScale", "", "getCurrentFontScale", "getFromSp", "onActivityResumed", "", "activity", "Landroid/app/Activity;", "watchApp", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.appbrand.af.a
  implements f
{
  public static final c tfv;
  private static float tfw;
  
  static
  {
    AppMethodBeat.i(50850);
    tfv = new c();
    AppMethodBeat.o(50850);
  }
  
  private static float cBe()
  {
    AppMethodBeat.i(50848);
    try
    {
      float f2 = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 4).getFloat("text_size_scale_key", 1.0F);
      f1 = f2;
      if (MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("screenResolution_isModifyDensity", true)) {
        if (!aw.bc(f2, 1.1F))
        {
          boolean bool = aw.bc(f2, 0.8F);
          f1 = f2;
          if (!bool) {}
        }
        else
        {
          f1 = 1.0F;
        }
      }
    }
    finally
    {
      for (;;)
      {
        float f1 = 1.0F;
      }
    }
    AppMethodBeat.o(50848);
    return f1;
  }
  
  public final float cuL()
  {
    AppMethodBeat.i(50847);
    if (tfw <= 0.0F) {
      tfw = cBe();
    }
    float f = tfw;
    AppMethodBeat.o(50847);
    return f;
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(50849);
    s.u(paramActivity, "activity");
    d.B((kotlin.g.a.a)a.tfx);
    AppMethodBeat.o(50849);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final a tfx;
    
    static
    {
      AppMethodBeat.i(50846);
      tfx = new a();
      AppMethodBeat.o(50846);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.b.c
 * JD-Core Version:    0.7.0.1
 */