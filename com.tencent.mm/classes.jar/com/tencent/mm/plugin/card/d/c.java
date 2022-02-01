package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public int action = 0;
  
  static
  {
    AppMethodBeat.i(113753);
    nIX = new c("CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT", 0, 0);
    nIY = new c("CARDCODEREFRESHACTION_SHOWING_TIMEOUT", 1, 1);
    nIZ = new c("CARDCODEREFRESHACTION_SNAPSHOT", 2, 2);
    nJa = new c("CARDCODEREFRESHACTION_DOREFRESH", 3, 3);
    nJb = new c("CARDCODEREFRESHACTION_ENTERFOREGROUND", 4, 4);
    nJc = new c("CARDCODEREFRESHACTION_BANCODE", 5, 5);
    nJd = new c("CARDCODEREFRESHACTION_UPDATECHANGE", 6, 6);
    nJe = new c("CARDCODEREFRESHACTION_ENTERCHANGE", 7, 7);
    nJf = new c[] { nIX, nIY, nIZ, nJa, nJb, nJc, nJd, nJe };
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