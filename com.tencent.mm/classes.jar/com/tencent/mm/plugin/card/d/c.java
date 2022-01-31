package com.tencent.mm.plugin.card.d;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum c
{
  public int action = 0;
  
  static
  {
    AppMethodBeat.i(88825);
    kBY = new c("CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT", 0, 0);
    kBZ = new c("CARDCODEREFRESHACTION_SHOWING_TIMEOUT", 1, 1);
    kCa = new c("CARDCODEREFRESHACTION_SNAPSHOT", 2, 2);
    kCb = new c("CARDCODEREFRESHACTION_DOREFRESH", 3, 3);
    kCc = new c("CARDCODEREFRESHACTION_ENTERFOREGROUND", 4, 4);
    kCd = new c("CARDCODEREFRESHACTION_BANCODE", 5, 5);
    kCe = new c("CARDCODEREFRESHACTION_UPDATECHANGE", 6, 6);
    kCf = new c("CARDCODEREFRESHACTION_ENTERCHANGE", 7, 7);
    kCg = new c[] { kBY, kBZ, kCa, kCb, kCc, kCd, kCe, kCf };
    AppMethodBeat.o(88825);
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