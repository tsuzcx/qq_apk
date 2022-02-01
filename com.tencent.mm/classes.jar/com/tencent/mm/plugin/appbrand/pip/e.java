package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e
{
  static
  {
    AppMethodBeat.i(244290);
    qFg = new e("PIP_CLICKED", 0);
    qFh = new e("PIP_CLOSE_BUTTON_CLICKED", 1);
    qFi = new e("OTHER_VIDEO_AUTO_PLAY", 2);
    qFj = new e("OTHER_VIDEO_PLAY", 3);
    qFk = new e("PAGE_RE_LAUNCH", 4);
    qFl = new e("EXIT_PIP_CALLED", 5);
    qFm = new e("OTHERS", 6);
    qFn = new e[] { qFg, qFh, qFi, qFj, qFk, qFl, qFm };
    AppMethodBeat.o(244290);
  }
  
  private e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.e
 * JD-Core Version:    0.7.0.1
 */