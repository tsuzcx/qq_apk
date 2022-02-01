package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public int action = 0;
  
  static
  {
    AppMethodBeat.i(113753);
    qkO = new c("CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT", 0, 0);
    qkP = new c("CARDCODEREFRESHACTION_SHOWING_TIMEOUT", 1, 1);
    qkQ = new c("CARDCODEREFRESHACTION_SNAPSHOT", 2, 2);
    qkR = new c("CARDCODEREFRESHACTION_DOREFRESH", 3, 3);
    qkS = new c("CARDCODEREFRESHACTION_ENTERFOREGROUND", 4, 4);
    qkT = new c("CARDCODEREFRESHACTION_BANCODE", 5, 5);
    qkU = new c("CARDCODEREFRESHACTION_UPDATECHANGE", 6, 6);
    qkV = new c("CARDCODEREFRESHACTION_ENTERCHANGE", 7, 7);
    qkW = new c[] { qkO, qkP, qkQ, qkR, qkS, qkT, qkU, qkV };
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