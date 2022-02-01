package com.tencent.mm.plugin.appbrand.pip;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum e
{
  static
  {
    AppMethodBeat.i(197368);
    mnn = new e("PIP_CLICKED", 0);
    mno = new e("PIP_CLOSE_BUTTON_CLICKED", 1);
    mnp = new e("OTHER_VIDEO_AUTO_PLAY", 2);
    mnq = new e("OTHER_VIDEO_PLAY", 3);
    mnr = new e("PAGE_RE_LAUNCH", 4);
    mns = new e("EXIT_PIP_CALLED", 5);
    mnt = new e("OTHERS", 6);
    mnu = new e[] { mnn, mno, mnp, mnq, mnr, mns, mnt };
    AppMethodBeat.o(197368);
  }
  
  private e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.e
 * JD-Core Version:    0.7.0.1
 */