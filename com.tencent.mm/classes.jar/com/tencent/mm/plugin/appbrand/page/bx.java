package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bx
{
  private final String type;
  
  static
  {
    AppMethodBeat.i(135283);
    nuD = new bx("APP_LAUNCH", 0, "appLaunch");
    nuE = new bx("NAVIGATE_TO", 1, "navigateTo");
    nuF = new bx("NAVIGATE_BACK", 2, "navigateBack");
    nuG = new bx("REDIRECT_TO", 3, "redirectTo");
    nuH = new bx("REWRITE_ROUTE", 4, "rewriteRoute");
    nuI = new bx("RE_LAUNCH", 5, "reLaunch");
    nuJ = new bx("AUTO_RE_LAUNCH", 6, "autoReLaunch");
    nuK = new bx("SWITCH_TAB", 7, "switchTab");
    nuL = new bx("DISMISS_PIP", 8, "dismissPip");
    nuM = new bx[] { nuD, nuE, nuF, nuG, nuH, nuI, nuJ, nuK, nuL };
    AppMethodBeat.o(135283);
  }
  
  private bx(String paramString)
  {
    this.type = paramString;
  }
  
  public final String toString()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bx
 * JD-Core Version:    0.7.0.1
 */