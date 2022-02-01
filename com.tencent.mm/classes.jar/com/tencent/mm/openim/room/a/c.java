package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c
{
  private int fMW = 0;
  public int fMX;
  
  public final void qL(int paramInt)
  {
    this.fMW |= paramInt;
  }
  
  final void qM(int paramInt)
  {
    AppMethodBeat.i(151324);
    this.fMW &= (paramInt ^ 0xFFFFFFFF);
    if (this.fMW == 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.fMX);
      this.fMX = 0;
    }
    AppMethodBeat.o(151324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.c
 * JD-Core Version:    0.7.0.1
 */