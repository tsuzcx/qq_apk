package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ux
  extends IEvent
{
  public a ebm;
  
  public ux()
  {
    this((byte)0);
  }
  
  private ux(byte paramByte)
  {
    AppMethodBeat.i(19836);
    this.ebm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19836);
  }
  
  public static final class a
  {
    public byte[] data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ux
 * JD-Core Version:    0.7.0.1
 */