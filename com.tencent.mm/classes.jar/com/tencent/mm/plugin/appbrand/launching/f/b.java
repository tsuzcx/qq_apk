package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeUtils;", "", "()V", "TAG", "", "canAddCollection", "", "isTeenMode", "miniProgramOption", "", "canLaunchAppBrand", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "scene", "username", "versionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Ljava/lang/Integer;Ljava/lang/String;I)Z", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b mZB;
  
  static
  {
    AppMethodBeat.i(228796);
    mZB = new b();
    AppMethodBeat.o(228796);
  }
  
  public static final boolean a(AppBrandInitConfigWC paramAppBrandInitConfigWC, Integer paramInteger, String paramString, int paramInt)
  {
    AppMethodBeat.i(228794);
    p.h(paramAppBrandInitConfigWC, "config");
    if (paramInt != 0)
    {
      AppMethodBeat.o(228794);
      return true;
    }
    if (paramInteger == null) {}
    label34:
    label38:
    label42:
    label46:
    label50:
    label54:
    label58:
    label62:
    while (paramInteger.intValue() != 1045)
    {
      if (paramInteger != null) {
        break;
      }
      if (paramInteger != null) {
        break label115;
      }
      if (paramInteger != null) {
        break label128;
      }
      if (paramInteger != null) {
        break label141;
      }
      if (paramInteger != null) {
        break label154;
      }
      if (paramInteger != null) {
        break label167;
      }
      if (paramInteger != null) {
        break label180;
      }
      if (paramInteger != null) {
        break label193;
      }
      if (paramInteger != null) {
        break label206;
      }
      if ((paramAppBrandInitConfigWC.cyo != 7) && (!paramAppBrandInitConfigWC.ldN)) {
        break label219;
      }
      AppMethodBeat.o(228794);
      return true;
    }
    for (;;)
    {
      AppMethodBeat.o(228794);
      return true;
      label128:
      label141:
      label154:
      label167:
      label180:
      label193:
      label206:
      if (paramInteger.intValue() != 1046)
      {
        break;
        label115:
        if (paramInteger.intValue() != 1084)
        {
          break label34;
          if (paramInteger.intValue() != 1067)
          {
            break label38;
            if (paramInteger.intValue() != 1095)
            {
              break label42;
              if (paramInteger.intValue() != 1035)
              {
                break label46;
                if (paramInteger.intValue() != 1102)
                {
                  break label50;
                  if (paramInteger.intValue() != 1058)
                  {
                    break label54;
                    if (paramInteger.intValue() != 1091)
                    {
                      break label58;
                      if (paramInteger.intValue() != 1144) {
                        break label62;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label219:
    paramInteger = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(paramInteger, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)paramInteger).Vt();
    if (!bool)
    {
      AppMethodBeat.o(228794);
      return true;
    }
    paramInteger = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(paramInteger, "MMKernel.service(ITeenModeService::class.java)");
    int i = ((com.tencent.mm.plugin.teenmode.a.b)paramInteger).fvp();
    Log.i("MicroMsg.AppBrandTeenModeUtils", "canLaunchAppBrand isTeenMode: %b, miniProgramOption: %d, serviceType: %d, isPluginApp: %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(paramAppBrandInitConfigWC.cyo), Boolean.valueOf(paramAppBrandInitConfigWC.ldN) });
    if (i == 0)
    {
      paramInteger = (ag)g.af(ag.class);
      paramAppBrandInitConfigWC = paramString;
      if (paramString == null) {
        paramAppBrandInitConfigWC = "";
      }
      bool = paramInteger.bf(paramAppBrandInitConfigWC, paramInt);
      AppMethodBeat.o(228794);
      return bool;
    }
    if (i == 2)
    {
      AppMethodBeat.o(228794);
      return false;
    }
    AppMethodBeat.o(228794);
    return true;
  }
  
  public static final boolean bOn()
  {
    AppMethodBeat.i(228795);
    a locala = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)locala).Vt();
    locala = g.af(com.tencent.mm.plugin.teenmode.a.b.class);
    p.g(locala, "MMKernel.service(ITeenModeService::class.java)");
    bool = t(bool, ((com.tencent.mm.plugin.teenmode.a.b)locala).fvp());
    AppMethodBeat.o(228795);
    return bool;
  }
  
  public static final boolean t(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {}
    while (paramInt == 1) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.b
 * JD-Core Version:    0.7.0.1
 */