package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public int action = 0;
  
  static
  {
    AppMethodBeat.i(113753);
    oVU = new c("CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT", 0, 0);
    oVV = new c("CARDCODEREFRESHACTION_SHOWING_TIMEOUT", 1, 1);
    oVW = new c("CARDCODEREFRESHACTION_SNAPSHOT", 2, 2);
    oVX = new c("CARDCODEREFRESHACTION_DOREFRESH", 3, 3);
    oVY = new c("CARDCODEREFRESHACTION_ENTERFOREGROUND", 4, 4);
    oVZ = new c("CARDCODEREFRESHACTION_BANCODE", 5, 5);
    oWa = new c("CARDCODEREFRESHACTION_UPDATECHANGE", 6, 6);
    oWb = new c("CARDCODEREFRESHACTION_ENTERCHANGE", 7, 7);
    oWc = new c[] { oVU, oVV, oVW, oVX, oVY, oVZ, oWa, oWb };
    AppMethodBeat.o(113753);
  }
  
  private c(int paramInt)
  {
    this.action = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.c
 * JD-Core Version:    0.7.0.1
 */