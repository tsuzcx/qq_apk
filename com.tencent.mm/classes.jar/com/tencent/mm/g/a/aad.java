package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aad
  extends IEvent
{
  public a egQ;
  public b egR;
  
  public aad()
  {
    this((byte)0);
  }
  
  private aad(byte paramByte)
  {
    AppMethodBeat.i(91230);
    this.egQ = new a();
    this.egR = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91230);
  }
  
  public static final class a {}
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.aad
 * JD-Core Version:    0.7.0.1
 */