package com.tencent.mm.plugin.card.c;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public int action = 0;
  
  static
  {
    AppMethodBeat.i(113753);
    wKj = new c("CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT", 0, 0);
    wKk = new c("CARDCODEREFRESHACTION_SHOWING_TIMEOUT", 1, 1);
    wKl = new c("CARDCODEREFRESHACTION_SNAPSHOT", 2, 2);
    wKm = new c("CARDCODEREFRESHACTION_DOREFRESH", 3, 3);
    wKn = new c("CARDCODEREFRESHACTION_ENTERFOREGROUND", 4, 4);
    wKo = new c("CARDCODEREFRESHACTION_BANCODE", 5, 5);
    wKp = new c("CARDCODEREFRESHACTION_UPDATECHANGE", 6, 6);
    wKq = new c("CARDCODEREFRESHACTION_ENTERCHANGE", 7, 7);
    wKr = new c[] { wKj, wKk, wKl, wKm, wKn, wKo, wKp, wKq };
    AppMethodBeat.o(113753);
  }
  
  private c(int paramInt)
  {
    this.action = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.c.c
 * JD-Core Version:    0.7.0.1
 */