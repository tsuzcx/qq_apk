package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class tv
  extends IEvent
{
  public a eap;
  
  public tv()
  {
    this((byte)0);
  }
  
  private tv(byte paramByte)
  {
    AppMethodBeat.i(149889);
    this.eap = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149889);
  }
  
  public static final class a
  {
    public ca dCM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.tv
 * JD-Core Version:    0.7.0.1
 */