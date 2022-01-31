package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum n$a
{
  static
  {
    AppMethodBeat.i(87856);
    koa = new a("NORMAL_TYPE", 0);
    kob = new a("INVALID_TYPE", 1);
    koc = new a("CAN_GIFT_TYPE", 2);
    kod = new a("GENERAL_TYPE", 3);
    koe = new a("MEMBER_CARD_TYPE", 4);
    kof = new a("HOME_MEMBER_CARD_TYPE", 5);
    kog = new a("GENERAL_WITHOUT_INVOICE_TYPE", 6);
    koh = new a[] { koa, kob, koc, kod, koe, kof, kog };
    AppMethodBeat.o(87856);
  }
  
  private n$a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.n.a
 * JD-Core Version:    0.7.0.1
 */