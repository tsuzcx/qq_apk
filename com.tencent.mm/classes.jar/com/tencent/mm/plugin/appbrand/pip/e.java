package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e
{
  static
  {
    AppMethodBeat.i(193451);
    lNA = new e("PIP_CLICKED", 0);
    lNB = new e("PIP_CLOSE_BUTTON_CLICKED", 1);
    lNC = new e("OTHER_VIDEO_AUTO_PLAY", 2);
    lND = new e("OTHER_VIDEO_PLAY", 3);
    lNE = new e("PAGE_RE_LAUNCH", 4);
    lNF = new e("EXIT_PIP_CALLED", 5);
    lNG = new e("OTHERS", 6);
    lNH = new e[] { lNA, lNB, lNC, lND, lNE, lNF, lNG };
    AppMethodBeat.o(193451);
  }
  
  private e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.e
 * JD-Core Version:    0.7.0.1
 */