package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchModeHelper;", "", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final a qYD;
  
  static
  {
    AppMethodBeat.i(323370);
    qYD = new a((byte)0);
    AppMethodBeat.o(323370);
  }
  
  public static final int a(HalfScreenConfig paramHalfScreenConfig)
  {
    AppMethodBeat.i(323369);
    int i = a.a(paramHalfScreenConfig, 0);
    AppMethodBeat.o(323369);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/AppBrandLaunchModeHelper$Companion;", "", "()V", "getLaunchMode", "", "config", "Lcom/tencent/mm/plugin/appbrand/config/HalfScreenConfig;", "default", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static int a(HalfScreenConfig paramHalfScreenConfig, int paramInt)
    {
      AppMethodBeat.i(323351);
      if (paramHalfScreenConfig == null)
      {
        AppMethodBeat.o(323351);
        return 0;
      }
      if (paramHalfScreenConfig.isEnable())
      {
        if (paramHalfScreenConfig.rac == HalfScreenConfig.g.raA)
        {
          AppMethodBeat.o(323351);
          return 3;
        }
        AppMethodBeat.o(323351);
        return 2;
      }
      AppMethodBeat.o(323351);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.j
 * JD-Core Version:    0.7.0.1
 */