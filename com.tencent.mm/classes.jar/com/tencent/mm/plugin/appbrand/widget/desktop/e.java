package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.al;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/widget/desktop/AppBrandDesktopViewBgParticleColorConfig;", "", "particleColor1", "", "particleColor2", "particleColor3", "bgColor1", "bgColor2", "(IIIII)V", "getBgColor1", "()I", "getBgColor2", "getParticleColor1", "getParticleColor2", "getParticleColor3", "Companion", "plugin-appbrand-integration_release"})
public final class e
{
  public static final e ndl;
  public static final e ndm;
  public static final e.a ndn;
  final int giA;
  final int giB;
  final int giC;
  final int giy;
  final int giz;
  
  static
  {
    AppMethodBeat.i(223958);
    ndn = new e.a((byte)0);
    ndl = new e(-12105913, -13948117, -12105913, -14935012, -11316397);
    ndm = new e(-11975584, -13948609, -11975584, -15263959, -11120530);
    AppMethodBeat.o(223958);
  }
  
  private e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.giy = paramInt1;
    this.giz = paramInt2;
    this.giA = paramInt3;
    this.giB = paramInt4;
    this.giC = paramInt5;
  }
  
  public static final e bDW()
  {
    AppMethodBeat.i(223959);
    if (al.isDarkMode())
    {
      locale = ndl;
      AppMethodBeat.o(223959);
      return locale;
    }
    e locale = ndm;
    AppMethodBeat.o(223959);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.e
 * JD-Core Version:    0.7.0.1
 */