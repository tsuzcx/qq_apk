package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum f
{
  static
  {
    AppMethodBeat.i(319658);
    tJW = new f("PIP_CLICKED", 0);
    tJX = new f("PIP_CLOSE_BUTTON_CLICKED", 1);
    tJY = new f("OTHER_VIDEO_AUTO_PLAY", 2);
    tJZ = new f("OTHER_VIDEO_PLAY", 3);
    tKa = new f("PAGE_RE_LAUNCH", 4);
    tKb = new f("EXIT_PIP_CALLED", 5);
    tKc = new f("OTHERS", 6);
    tKd = new f[] { tJW, tJX, tJY, tJZ, tKa, tKb, tKc };
    AppMethodBeat.o(319658);
  }
  
  private f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f
 * JD-Core Version:    0.7.0.1
 */