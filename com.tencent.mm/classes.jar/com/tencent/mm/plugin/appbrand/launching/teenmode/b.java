package com.tencent.mm.plugin.appbrand.launching.teenmode;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeUtils;", "", "()V", "TAG", "", "canAddCollection", "", "isTeenMode", "miniProgramOption", "", "canLaunchAppBrand", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "scene", "username", "versionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Ljava/lang/Integer;Ljava/lang/String;I)Z", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b tff;
  
  static
  {
    AppMethodBeat.i(321187);
    tff = new b();
    AppMethodBeat.o(321187);
  }
  
  public static final boolean a(AppBrandInitConfigWC paramAppBrandInitConfigWC, String paramString, int paramInt)
  {
    AppMethodBeat.i(321174);
    s.u(paramAppBrandInitConfigWC, "config");
    if ((paramAppBrandInitConfigWC.appServiceType == 7) || (paramAppBrandInitConfigWC.qYd))
    {
      AppMethodBeat.o(321174);
      return true;
    }
    boolean bool = ((d)h.ax(d.class)).aBu();
    if (!bool)
    {
      AppMethodBeat.o(321174);
      return true;
    }
    int i = ((d)h.ax(d.class)).hEr();
    Log.i("MicroMsg.AppBrandTeenModeUtils", "canLaunchAppBrand isTeenMode: %b, miniProgramOption: %d, serviceType: %d, isPluginApp: %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(paramAppBrandInitConfigWC.appServiceType), Boolean.valueOf(paramAppBrandInitConfigWC.qYd) });
    switch (i)
    {
    case 1: 
    default: 
      AppMethodBeat.o(321174);
      return true;
    case 0: 
      af localaf = (af)h.ax(af.class);
      paramAppBrandInitConfigWC = paramString;
      if (paramString == null) {
        paramAppBrandInitConfigWC = "";
      }
      bool = localaf.bP(paramAppBrandInitConfigWC, paramInt);
      AppMethodBeat.o(321174);
      return bool;
    }
    AppMethodBeat.o(321174);
    return false;
  }
  
  public static final boolean cAZ()
  {
    AppMethodBeat.i(321181);
    boolean bool = u(((d)h.ax(d.class)).aBu(), ((d)h.ax(d.class)).hEr());
    AppMethodBeat.o(321181);
    return bool;
  }
  
  public static final boolean u(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {}
    while (paramInt == 1) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.teenmode.b
 * JD-Core Version:    0.7.0.1
 */