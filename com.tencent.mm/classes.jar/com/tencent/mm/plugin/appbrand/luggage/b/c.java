package com.tencent.mm.plugin.appbrand.luggage.b;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.b;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/customize/FontScaleProviderWC;", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/system/IFontScaleProvider;", "()V", "mFontScale", "", "getCurrentFontScale", "getFromSp", "onActivityResumed", "", "activity", "Landroid/app/Activity;", "watchApp", "app", "Landroid/app/Application;", "plugin-appbrand-integration_release"})
public final class c
  extends com.tencent.mm.plugin.appbrand.y.a
  implements b
{
  private static float lSB;
  public static final c lSC;
  
  static
  {
    AppMethodBeat.i(50850);
    lSC = new c();
    AppMethodBeat.o(50850);
  }
  
  private static float bsR()
  {
    float f1 = 1.0F;
    AppMethodBeat.i(50848);
    try
    {
      float f2 = ak.getContext().getSharedPreferences(ak.fow(), 4).getFloat("text_size_scale_key", 1.0F);
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
  
  public final float bnk()
  {
    AppMethodBeat.i(50847);
    if (lSB <= 0.0F) {
      lSB = bsR();
    }
    float f = lSB;
    AppMethodBeat.o(50847);
    return f;
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(50849);
    com.tencent.mm.ac.c.b(null, (d.g.a.a)a.lSD);
    AppMethodBeat.o(50849);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    public static final a lSD;
    
    static
    {
      AppMethodBeat.i(50846);
      lSD = new a();
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