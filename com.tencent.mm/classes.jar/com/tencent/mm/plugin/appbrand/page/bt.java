package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bt
{
  private final String type;
  
  static
  {
    AppMethodBeat.i(135283);
    lGi = new bt("APP_LAUNCH", 0, "appLaunch");
    lGj = new bt("NAVIGATE_TO", 1, "navigateTo");
    lGk = new bt("NAVIGATE_BACK", 2, "navigateBack");
    lGl = new bt("REDIRECT_TO", 3, "redirectTo");
    lGm = new bt("REWRITE_ROUTE", 4, "rewriteRoute");
    lGn = new bt("RE_LAUNCH", 5, "reLaunch");
    lGo = new bt("AUTO_RE_LAUNCH", 6, "autoReLaunch");
    lGp = new bt("SWITCH_TAB", 7, "switchTab");
    lGq = new bt("DISMISS_PIP", 8, "dismissPip");
    lGr = new bt[] { lGi, lGj, lGk, lGl, lGm, lGn, lGo, lGp, lGq };
    AppMethodBeat.o(135283);
  }
  
  private bt(String paramString)
  {
    this.type = paramString;
  }
  
  public final String toString()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bt
 * JD-Core Version:    0.7.0.1
 */