package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bs
{
  private final String type;
  
  static
  {
    AppMethodBeat.i(135283);
    mfL = new bs("APP_LAUNCH", 0, "appLaunch");
    mfM = new bs("NAVIGATE_TO", 1, "navigateTo");
    mfN = new bs("NAVIGATE_BACK", 2, "navigateBack");
    mfO = new bs("REDIRECT_TO", 3, "redirectTo");
    mfP = new bs("REWRITE_ROUTE", 4, "rewriteRoute");
    mfQ = new bs("RE_LAUNCH", 5, "reLaunch");
    mfR = new bs("AUTO_RE_LAUNCH", 6, "autoReLaunch");
    mfS = new bs("SWITCH_TAB", 7, "switchTab");
    mfT = new bs("DISMISS_PIP", 8, "dismissPip");
    mfU = new bs[] { mfL, mfM, mfN, mfO, mfP, mfQ, mfR, mfS, mfT };
    AppMethodBeat.o(135283);
  }
  
  private bs(String paramString)
  {
    this.type = paramString;
  }
  
  public final String toString()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bs
 * JD-Core Version:    0.7.0.1
 */