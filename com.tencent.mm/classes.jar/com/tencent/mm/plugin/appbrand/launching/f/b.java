package com.tencent.mm.plugin.appbrand.launching.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.appusage.ag;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/launching/teenmode/AppBrandTeenModeUtils;", "", "()V", "TAG", "", "canAddCollection", "", "isTeenMode", "miniProgramOption", "", "canLaunchAppBrand", "config", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "scene", "username", "versionType", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Ljava/lang/Integer;Ljava/lang/String;I)Z", "plugin-appbrand-integration_release"})
public final class b
{
  public static final b pZZ;
  
  static
  {
    AppMethodBeat.i(283965);
    pZZ = new b();
    AppMethodBeat.o(283965);
  }
  
  public static final boolean a(AppBrandInitConfigWC paramAppBrandInitConfigWC, Integer paramInteger, String paramString, int paramInt)
  {
    AppMethodBeat.i(283963);
    p.k(paramAppBrandInitConfigWC, "config");
    if (paramInt != 0)
    {
      AppMethodBeat.o(283963);
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
      if ((paramAppBrandInitConfigWC.cwR != 7) && (!paramAppBrandInitConfigWC.nYb)) {
        break label219;
      }
      AppMethodBeat.o(283963);
      return true;
    }
    for (;;)
    {
      AppMethodBeat.o(283963);
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
    paramInteger = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(paramInteger, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)paramInteger).ZM();
    if (!bool)
    {
      AppMethodBeat.o(283963);
      return true;
    }
    paramInteger = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(paramInteger, "MMKernel.service(ITeenModeService::class.java)");
    int i = ((com.tencent.mm.plugin.teenmode.a.b)paramInteger).gks();
    Log.i("MicroMsg.AppBrandTeenModeUtils", "canLaunchAppBrand isTeenMode: %b, miniProgramOption: %d, serviceType: %d, isPluginApp: %b", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(paramAppBrandInitConfigWC.cwR), Boolean.valueOf(paramAppBrandInitConfigWC.nYb) });
    if (i == 0)
    {
      paramInteger = (ag)h.ae(ag.class);
      paramAppBrandInitConfigWC = paramString;
      if (paramString == null) {
        paramAppBrandInitConfigWC = "";
      }
      bool = paramInteger.by(paramAppBrandInitConfigWC, paramInt);
      AppMethodBeat.o(283963);
      return bool;
    }
    if (i == 2)
    {
      AppMethodBeat.o(283963);
      return false;
    }
    AppMethodBeat.o(283963);
    return true;
  }
  
  public static final boolean caH()
  {
    AppMethodBeat.i(283964);
    a locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    boolean bool = ((com.tencent.mm.plugin.teenmode.a.b)locala).ZM();
    locala = h.ae(com.tencent.mm.plugin.teenmode.a.b.class);
    p.j(locala, "MMKernel.service(ITeenModeService::class.java)");
    bool = w(bool, ((com.tencent.mm.plugin.teenmode.a.b)locala).gks());
    AppMethodBeat.o(283964);
    return bool;
  }
  
  public static final boolean w(boolean paramBoolean, int paramInt)
  {
    if (!paramBoolean) {}
    while (paramInt == 1) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.f.b
 * JD-Core Version:    0.7.0.1
 */