package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dkf;
import com.tencent.mm.sdk.event.IEvent;

public final class acp
  extends IEvent
{
  public a ifZ;
  
  public acp()
  {
    this((byte)0);
  }
  
  private acp(byte paramByte)
  {
    AppMethodBeat.i(369430);
    this.ifZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369430);
  }
  
  public static final class a
  {
    public dkf ifY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acp
 * JD-Core Version:    0.7.0.1
 */