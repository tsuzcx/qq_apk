package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.sdk.event.IEvent;

public final class lz
  extends IEvent
{
  public a hNQ;
  public b hNR;
  
  public lz()
  {
    this((byte)0);
  }
  
  private lz(byte paramByte)
  {
    AppMethodBeat.i(125621);
    this.hNQ = new a();
    this.hNR = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125621);
  }
  
  public static final class a
  {
    public String hES;
  }
  
  public static final class b
  {
    public TimeLineObject hNS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.lz
 * JD-Core Version:    0.7.0.1
 */