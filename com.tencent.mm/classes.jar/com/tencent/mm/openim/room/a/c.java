package com.tencent.mm.openim.room.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;

public final class c
{
  private int iWs = 0;
  public int iWt;
  
  public final void xF(int paramInt)
  {
    this.iWs |= paramInt;
  }
  
  final void xG(int paramInt)
  {
    AppMethodBeat.i(151324);
    this.iWs &= (paramInt ^ 0xFFFFFFFF);
    if (this.iWs == 0)
    {
      WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcUpdateChatroomEnable, this.iWt);
      this.iWt = 0;
    }
    AppMethodBeat.o(151324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.room.a.c
 * JD-Core Version:    0.7.0.1
 */