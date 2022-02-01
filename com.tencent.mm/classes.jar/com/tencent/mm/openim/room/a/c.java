package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c
{
  private int foU = 0;
  public int foV;
  
  public final void ps(int paramInt)
  {
    this.foU |= paramInt;
  }
  
  final void pt(int paramInt)
  {
    AppMethodBeat.i(151324);
    this.foU &= (paramInt ^ 0xFFFFFFFF);
    if (this.foU == 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.foV);
      this.foV = 0;
    }
    AppMethodBeat.o(151324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.c
 * JD-Core Version:    0.7.0.1
 */