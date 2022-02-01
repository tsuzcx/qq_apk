package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaf
  extends IEvent
{
  public a idJ;
  
  public aaf()
  {
    this((byte)0);
  }
  
  private aaf(byte paramByte)
  {
    AppMethodBeat.i(104421);
    this.idJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104421);
  }
  
  public static final class a
  {
    public String productId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aaf
 * JD-Core Version:    0.7.0.1
 */