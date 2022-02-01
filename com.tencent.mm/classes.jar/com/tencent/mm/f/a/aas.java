package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.sdk.event.IEvent;

public final class aas
  extends IEvent
{
  public a fZR;
  
  public aas()
  {
    this((byte)0);
  }
  
  private aas(byte paramByte)
  {
    AppMethodBeat.i(209830);
    this.fZR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(209830);
  }
  
  public static final class a
  {
    public ctd fZQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.aas
 * JD-Core Version:    0.7.0.1
 */