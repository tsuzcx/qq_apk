package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eqs;
import com.tencent.mm.sdk.event.IEvent;

public final class aq
  extends IEvent
{
  public a dDA;
  
  public aq()
  {
    this((byte)0);
  }
  
  private aq(byte paramByte)
  {
    AppMethodBeat.i(175415);
    this.dDA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(175415);
  }
  
  public static final class a
  {
    public int dDB;
    public eqs dDC;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.aq
 * JD-Core Version:    0.7.0.1
 */