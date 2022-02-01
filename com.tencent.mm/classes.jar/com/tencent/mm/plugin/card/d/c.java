package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public int action = 0;
  
  static
  {
    AppMethodBeat.i(113753);
    olX = new c("CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT", 0, 0);
    olY = new c("CARDCODEREFRESHACTION_SHOWING_TIMEOUT", 1, 1);
    olZ = new c("CARDCODEREFRESHACTION_SNAPSHOT", 2, 2);
    oma = new c("CARDCODEREFRESHACTION_DOREFRESH", 3, 3);
    omb = new c("CARDCODEREFRESHACTION_ENTERFOREGROUND", 4, 4);
    omc = new c("CARDCODEREFRESHACTION_BANCODE", 5, 5);
    omd = new c("CARDCODEREFRESHACTION_UPDATECHANGE", 6, 6);
    ome = new c("CARDCODEREFRESHACTION_ENTERCHANGE", 7, 7);
    omf = new c[] { olX, olY, olZ, oma, omb, omc, omd, ome };
    AppMethodBeat.o(113753);
  }
  
  private c(int paramInt)
  {
    this.action = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.d.c
 * JD-Core Version:    0.7.0.1
 */