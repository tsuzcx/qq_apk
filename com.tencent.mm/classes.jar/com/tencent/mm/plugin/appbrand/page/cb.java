package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum cb
{
  private final String type;
  
  static
  {
    AppMethodBeat.i(135283);
    tBm = new cb("APP_LAUNCH", 0, "appLaunch");
    tBn = new cb("NAVIGATE_TO", 1, "navigateTo");
    tBo = new cb("NAVIGATE_BACK", 2, "navigateBack");
    tBp = new cb("REDIRECT_TO", 3, "redirectTo");
    tBq = new cb("REWRITE_ROUTE", 4, "rewriteRoute");
    tBr = new cb("RE_LAUNCH", 5, "reLaunch");
    tBs = new cb("AUTO_RE_LAUNCH", 6, "autoReLaunch");
    tBt = new cb("SWITCH_TAB", 7, "switchTab");
    tBu = new cb("DISMISS_PIP", 8, "dismissPip");
    tBv = new cb("RELOAD", 9, "reload");
    tBw = new cb[] { tBm, tBn, tBo, tBp, tBq, tBr, tBs, tBt, tBu, tBv };
    AppMethodBeat.o(135283);
  }
  
  private cb(String paramString)
  {
    this.type = paramString;
  }
  
  public final String toString()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.cb
 * JD-Core Version:    0.7.0.1
 */