package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nq
  extends IEvent
{
  public a dTN;
  
  public nq()
  {
    this((byte)0);
  }
  
  private nq(byte paramByte)
  {
    AppMethodBeat.i(125622);
    this.dTN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125622);
  }
  
  public static final class a
  {
    public int position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.nq
 * JD-Core Version:    0.7.0.1
 */