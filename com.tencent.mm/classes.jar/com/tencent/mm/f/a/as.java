package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fbe;
import com.tencent.mm.sdk.event.IEvent;

public final class as
  extends IEvent
{
  public a fwj;
  
  public as()
  {
    this((byte)0);
  }
  
  private as(byte paramByte)
  {
    AppMethodBeat.i(175415);
    this.fwj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(175415);
  }
  
  public static final class a
  {
    public int fwk;
    public fbe fwl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.as
 * JD-Core Version:    0.7.0.1
 */