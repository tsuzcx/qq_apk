package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public int action = 0;
  
  static
  {
    AppMethodBeat.i(113753);
    tGK = new c("CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT", 0, 0);
    tGL = new c("CARDCODEREFRESHACTION_SHOWING_TIMEOUT", 1, 1);
    tGM = new c("CARDCODEREFRESHACTION_SNAPSHOT", 2, 2);
    tGN = new c("CARDCODEREFRESHACTION_DOREFRESH", 3, 3);
    tGO = new c("CARDCODEREFRESHACTION_ENTERFOREGROUND", 4, 4);
    tGP = new c("CARDCODEREFRESHACTION_BANCODE", 5, 5);
    tGQ = new c("CARDCODEREFRESHACTION_UPDATECHANGE", 6, 6);
    tGR = new c("CARDCODEREFRESHACTION_ENTERCHANGE", 7, 7);
    tGS = new c[] { tGK, tGL, tGM, tGN, tGO, tGP, tGQ, tGR };
    AppMethodBeat.o(113753);
  }
  
  private c(int paramInt)
  {
    this.action = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.c
 * JD-Core Version:    0.7.0.1
 */