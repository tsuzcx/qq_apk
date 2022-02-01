package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum by
{
  private final String type;
  
  static
  {
    AppMethodBeat.i(135283);
    lgo = new by("APP_LAUNCH", 0, "appLaunch");
    lgp = new by("NAVIGATE_TO", 1, "navigateTo");
    lgq = new by("NAVIGATE_BACK", 2, "navigateBack");
    lgr = new by("REDIRECT_TO", 3, "redirectTo");
    lgs = new by("REWRITE_ROUTE", 4, "rewriteRoute");
    lgt = new by("RE_LAUNCH", 5, "reLaunch");
    lgu = new by("AUTO_RE_LAUNCH", 6, "autoReLaunch");
    lgv = new by("SWITCH_TAB", 7, "switchTab");
    lgw = new by("DISMISS_PIP", 8, "dismissPip");
    lgx = new by[] { lgo, lgp, lgq, lgr, lgs, lgt, lgu, lgv, lgw };
    AppMethodBeat.o(135283);
  }
  
  private by(String paramString)
  {
    this.type = paramString;
  }
  
  public final String toString()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.by
 * JD-Core Version:    0.7.0.1
 */