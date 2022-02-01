package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ff
  extends IEvent
{
  public a dIC;
  
  public ff()
  {
    this((byte)0);
  }
  
  private ff(byte paramByte)
  {
    AppMethodBeat.i(19798);
    this.dIC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19798);
  }
  
  public static final class a
  {
    public byte[] data;
    public String mac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.ff
 * JD-Core Version:    0.7.0.1
 */