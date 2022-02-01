package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e
{
  static
  {
    AppMethodBeat.i(219511);
    nCV = new e("PIP_CLICKED", 0);
    nCW = new e("PIP_CLOSE_BUTTON_CLICKED", 1);
    nCX = new e("OTHER_VIDEO_AUTO_PLAY", 2);
    nCY = new e("OTHER_VIDEO_PLAY", 3);
    nCZ = new e("PAGE_RE_LAUNCH", 4);
    nDa = new e("EXIT_PIP_CALLED", 5);
    nDb = new e("OTHERS", 6);
    nDc = new e[] { nCV, nCW, nCX, nCY, nCZ, nDa, nDb };
    AppMethodBeat.o(219511);
  }
  
  private e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.e
 * JD-Core Version:    0.7.0.1
 */