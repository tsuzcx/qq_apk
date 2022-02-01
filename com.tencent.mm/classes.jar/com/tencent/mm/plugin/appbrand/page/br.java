package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum br
{
  private final String type;
  
  static
  {
    AppMethodBeat.i(135283);
    mkg = new br("APP_LAUNCH", 0, "appLaunch");
    mkh = new br("NAVIGATE_TO", 1, "navigateTo");
    mki = new br("NAVIGATE_BACK", 2, "navigateBack");
    mkj = new br("REDIRECT_TO", 3, "redirectTo");
    mkk = new br("REWRITE_ROUTE", 4, "rewriteRoute");
    mkl = new br("RE_LAUNCH", 5, "reLaunch");
    mkm = new br("AUTO_RE_LAUNCH", 6, "autoReLaunch");
    mkn = new br("SWITCH_TAB", 7, "switchTab");
    mko = new br("DISMISS_PIP", 8, "dismissPip");
    mkp = new br[] { mkg, mkh, mki, mkj, mkk, mkl, mkm, mkn, mko };
    AppMethodBeat.o(135283);
  }
  
  private br(String paramString)
  {
    this.type = paramString;
  }
  
  public final String toString()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.br
 * JD-Core Version:    0.7.0.1
 */