package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c
{
  private int fst = 0;
  public int fsu;
  
  public final void qg(int paramInt)
  {
    this.fst |= paramInt;
  }
  
  final void qh(int paramInt)
  {
    AppMethodBeat.i(151324);
    this.fst &= (paramInt ^ 0xFFFFFFFF);
    if (this.fst == 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.fsu);
      this.fsu = 0;
    }
    AppMethodBeat.o(151324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.c
 * JD-Core Version:    0.7.0.1
 */