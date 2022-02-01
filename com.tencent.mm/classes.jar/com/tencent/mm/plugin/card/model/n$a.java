package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum n$a
{
  static
  {
    AppMethodBeat.i(112798);
    pTQ = new a("NORMAL_TYPE", 0);
    pTR = new a("INVALID_TYPE", 1);
    pTS = new a("CAN_GIFT_TYPE", 2);
    pTT = new a("GENERAL_TYPE", 3);
    pTU = new a("MEMBER_CARD_TYPE", 4);
    pTV = new a("HOME_MEMBER_CARD_TYPE", 5);
    pTW = new a("GENERAL_WITHOUT_INVOICE_TYPE", 6);
    pTX = new a[] { pTQ, pTR, pTS, pTT, pTU, pTV, pTW };
    AppMethodBeat.o(112798);
  }
  
  private n$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.n.a
 * JD-Core Version:    0.7.0.1
 */