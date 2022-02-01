package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum ai
{
  static
  {
    AppMethodBeat.i(176645);
    lcJ = new ai("PIP_CLICKED", 0);
    lcK = new ai("PIP_CLOSE_BUTTON_CLICKED", 1);
    lcL = new ai("OTHER_VIDEO_AUTO_PLAY", 2);
    lcM = new ai("OTHER_VIDEO_PLAY", 3);
    lcN = new ai("PAGE_RE_LAUNCH", 4);
    lcO = new ai("EXIT_PIP_CALLED", 5);
    lcP = new ai("OTHERS", 6);
    lcQ = new ai[] { lcJ, lcK, lcL, lcM, lcN, lcO, lcP };
    AppMethodBeat.o(176645);
  }
  
  private ai() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ai
 * JD-Core Version:    0.7.0.1
 */