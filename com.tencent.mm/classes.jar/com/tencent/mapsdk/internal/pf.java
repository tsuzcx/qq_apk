package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.map.tools.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class pf
{
  public static void a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(225450);
    if (paramContext == null)
    {
      AppMethodBeat.o(225450);
      return;
    }
    String str = mf.a(paramContext, null).a(paramString);
    me localme = me.a(paramContext);
    if (gw.b(localme.a("sdkVersion"), "4.0.9.1") < 0) {
      localme.a(new String[] { "mapConfigIndoorVersion", "mapPoiIcon3dIndoorVersion" });
    }
    int i = gw.b(gw.l(), localme.a("sdkVersion"));
    paramString = md.a(paramContext, paramString);
    mc.a(paramString, str);
    mc.a(paramContext, paramString, str, "mapconfig.dat");
    mc.a(paramContext, paramString, str, "poi_icon@2x.png");
    mc.a(paramContext, paramString, str, "indoor_style.dat");
    mc.a(paramContext, paramString, str, "indoor_style_night.dat");
    mc.a(paramContext, paramString, str, "poi_icon_indoor_ex@2x.png");
    mc.a(paramContext, paramString, str, "poi_icon_indoor_ex_night@2x.png");
    mc.a(paramContext, paramString, str, "escalator.dat");
    mc.a(paramContext, paramString, str, "escalator_night.dat");
    if (i > 0) {
      localme.a("sdkVersion", gw.l());
    }
    AppMethodBeat.o(225450);
  }
  
  private static void a(Context paramContext, final String paramString, Callback<Boolean> paramCallback)
  {
    AppMethodBeat.i(225438);
    paramString = jw.a(new jw.g()
    {
      private Boolean a()
      {
        AppMethodBeat.i(222719);
        pf.a(this.a, paramString);
        Boolean localBoolean = Boolean.TRUE;
        AppMethodBeat.o(222719);
        return localBoolean;
      }
    });
    Boolean localBoolean = Boolean.FALSE;
    if (paramCallback != null) {}
    for (paramContext = new jw.a()
        {
          private void a(Boolean paramAnonymousBoolean)
          {
            AppMethodBeat.i(222630);
            this.a.callback(paramAnonymousBoolean);
            AppMethodBeat.o(222630);
          }
        };; paramContext = null)
    {
      paramString.a(localBoolean, paramContext);
      AppMethodBeat.o(225438);
      return;
    }
  }
  
  private static void a(mb parammb)
  {
    AppMethodBeat.i(225461);
    if (gw.b(parammb.a("sdkVersion"), "4.0.9.1") < 0) {
      parammb.a(new String[] { "mapConfigIndoorVersion", "mapPoiIcon3dIndoorVersion" });
    }
    AppMethodBeat.o(225461);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.pf
 * JD-Core Version:    0.7.0.1
 */