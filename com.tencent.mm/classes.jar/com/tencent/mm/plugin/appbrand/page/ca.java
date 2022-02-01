package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ca
{
  private final String type;
  
  static
  {
    AppMethodBeat.i(135283);
    qwx = new ca("APP_LAUNCH", 0, "appLaunch");
    qwy = new ca("NAVIGATE_TO", 1, "navigateTo");
    qwz = new ca("NAVIGATE_BACK", 2, "navigateBack");
    qwA = new ca("REDIRECT_TO", 3, "redirectTo");
    qwB = new ca("REWRITE_ROUTE", 4, "rewriteRoute");
    qwC = new ca("RE_LAUNCH", 5, "reLaunch");
    qwD = new ca("AUTO_RE_LAUNCH", 6, "autoReLaunch");
    qwE = new ca("SWITCH_TAB", 7, "switchTab");
    qwF = new ca("DISMISS_PIP", 8, "dismissPip");
    qwG = new ca("RELOAD", 9, "reload");
    qwH = new ca[] { qwx, qwy, qwz, qwA, qwB, qwC, qwD, qwE, qwF, qwG };
    AppMethodBeat.o(135283);
  }
  
  private ca(String paramString)
  {
    this.type = paramString;
  }
  
  public final String toString()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ca
 * JD-Core Version:    0.7.0.1
 */