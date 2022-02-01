package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c
{
  private int lyv = 0;
  public int lyw;
  
  public final void xJ(int paramInt)
  {
    this.lyv |= paramInt;
  }
  
  final void xK(int paramInt)
  {
    AppMethodBeat.i(151324);
    this.lyv &= (paramInt ^ 0xFFFFFFFF);
    if (this.lyv == 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.lyw);
      this.lyw = 0;
    }
    AppMethodBeat.o(151324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.c
 * JD-Core Version:    0.7.0.1
 */