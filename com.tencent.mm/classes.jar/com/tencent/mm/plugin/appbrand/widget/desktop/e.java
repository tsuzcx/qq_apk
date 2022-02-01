package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewBgParticleColorConfig;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "Companion", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e mYe;
  public static final e mYf;
  public static final e.a mYg;
  final int ggg;
  final int ggh;
  final int ggi;
  final int ggj;
  final int ggk;
  
  static
  {
    AppMethodBeat.i(189686);
    mYg = new e.a((byte)0);
    mYe = new e(-12105913, -13948117, -12105913, -14935012, -11316397);
    mYf = new e(-11975584, -13948609, -11975584, -15263959, -11120530);
    AppMethodBeat.o(189686);
  }
  
  private e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.ggg = paramInt1;
    this.ggh = paramInt2;
    this.ggi = paramInt3;
    this.ggj = paramInt4;
    this.ggk = paramInt5;
  }
  
  public static final e bDe()
  {
    AppMethodBeat.i(189687);
    if (al.isDarkMode())
    {
      locale = mYe;
      AppMethodBeat.o(189687);
      return locale;
    }
    e locale = mYf;
    AppMethodBeat.o(189687);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e
 * JD-Core Version:    0.7.0.1
 */