package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.sdk.event.IEvent;

public final class aar
  extends IEvent
{
  public a fZP;
  
  public aar()
  {
    this((byte)0);
  }
  
  private aar(byte paramByte)
  {
    AppMethodBeat.i(209821);
    this.fZP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(209821);
  }
  
  public static final class a
  {
    public ctd fZQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.aar
 * JD-Core Version:    0.7.0.1
 */