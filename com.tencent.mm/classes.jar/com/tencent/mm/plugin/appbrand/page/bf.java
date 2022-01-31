package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum bf
{
  private final String type;
  
  static
  {
    AppMethodBeat.i(87347);
    izQ = new bf("APP_LAUNCH", 0, "appLaunch");
    izR = new bf("NAVIGATE_TO", 1, "navigateTo");
    izS = new bf("NAVIGATE_BACK", 2, "navigateBack");
    izT = new bf("REDIRECT_TO", 3, "redirectTo");
    izU = new bf("RE_LAUNCH", 4, "reLaunch");
    izV = new bf("AUTO_RE_LAUNCH", 5, "autoReLaunch");
    izW = new bf("SWITCH_TAB", 6, "switchTab");
    izX = new bf[] { izQ, izR, izS, izT, izU, izV, izW };
    AppMethodBeat.o(87347);
  }
  
  private bf(String paramString)
  {
    this.type = paramString;
  }
  
  public final String toString()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bf
 * JD-Core Version:    0.7.0.1
 */