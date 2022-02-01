package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ao;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewBgParticleColorConfig;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "Companion", "plugin-appbrand-integration_release"})
public final class c
{
  public static final c ooq;
  public static final c oor;
  public static final a oos;
  private final int gRQ;
  private final int gRR;
  private final int gRS;
  final int gRT;
  private final int gRU;
  
  static
  {
    AppMethodBeat.i(229616);
    oos = new a((byte)0);
    ooq = new c(-12105913, -13948117, -12105913, -14935012, -11316397);
    oor = new c(-11975584, -13948609, -11975584, -15263959, -11120530);
    AppMethodBeat.o(229616);
  }
  
  private c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.gRQ = paramInt1;
    this.gRR = paramInt2;
    this.gRS = paramInt3;
    this.gRT = paramInt4;
    this.gRU = paramInt5;
  }
  
  public static final c caE()
  {
    AppMethodBeat.i(229617);
    if (ao.isDarkMode())
    {
      localc = ooq;
      AppMethodBeat.o(229617);
      return localc;
    }
    c localc = oor;
    AppMethodBeat.o(229617);
    return localc;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewBgParticleColorConfig$Companion;", "", "()V", "DARK_MODE_PARTICLE_COLOR_CONFIG", "Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewBgParticleColorConfig;", "LIGHT_MODE_PARTICLE_COLOR_CONFIG", "getCurrentThemeConfig", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.c
 * JD-Core Version:    0.7.0.1
 */