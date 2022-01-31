package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c
{
  private int eey = 0;
  public int eez;
  
  public final void mD(int paramInt)
  {
    this.eey |= paramInt;
  }
  
  final void mE(int paramInt)
  {
    AppMethodBeat.i(78980);
    this.eey &= (paramInt ^ 0xFFFFFFFF);
    if (this.eey == 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.eez);
      this.eez = 0;
    }
    AppMethodBeat.o(78980);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.c
 * JD-Core Version:    0.7.0.1
 */