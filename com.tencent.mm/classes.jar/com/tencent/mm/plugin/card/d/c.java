package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public int action = 0;
  
  static
  {
    AppMethodBeat.i(113753);
    oPs = new c("CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT", 0, 0);
    oPt = new c("CARDCODEREFRESHACTION_SHOWING_TIMEOUT", 1, 1);
    oPu = new c("CARDCODEREFRESHACTION_SNAPSHOT", 2, 2);
    oPv = new c("CARDCODEREFRESHACTION_DOREFRESH", 3, 3);
    oPw = new c("CARDCODEREFRESHACTION_ENTERFOREGROUND", 4, 4);
    oPx = new c("CARDCODEREFRESHACTION_BANCODE", 5, 5);
    oPy = new c("CARDCODEREFRESHACTION_UPDATECHANGE", 6, 6);
    oPz = new c("CARDCODEREFRESHACTION_ENTERCHANGE", 7, 7);
    oPA = new c[] { oPs, oPt, oPu, oPv, oPw, oPx, oPy, oPz };
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