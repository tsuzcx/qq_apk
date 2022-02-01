package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c
{
  private int gsh = 0;
  public int gsi;
  
  public final void uD(int paramInt)
  {
    this.gsh |= paramInt;
  }
  
  final void uE(int paramInt)
  {
    AppMethodBeat.i(151324);
    this.gsh &= (paramInt ^ 0xFFFFFFFF);
    if (this.gsh == 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.gsi);
      this.gsi = 0;
    }
    AppMethodBeat.o(151324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.c
 * JD-Core Version:    0.7.0.1
 */