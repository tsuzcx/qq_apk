package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e
{
  static
  {
    AppMethodBeat.i(207909);
    msl = new e("PIP_CLICKED", 0);
    msm = new e("PIP_CLOSE_BUTTON_CLICKED", 1);
    msn = new e("OTHER_VIDEO_AUTO_PLAY", 2);
    mso = new e("OTHER_VIDEO_PLAY", 3);
    msp = new e("PAGE_RE_LAUNCH", 4);
    msq = new e("EXIT_PIP_CALLED", 5);
    msr = new e("OTHERS", 6);
    mss = new e[] { msl, msm, msn, mso, msp, msq, msr };
    AppMethodBeat.o(207909);
  }
  
  private e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.e
 * JD-Core Version:    0.7.0.1
 */