package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wi
  extends IEvent
{
  public a hZW;
  
  public wi()
  {
    this((byte)0);
  }
  
  private wi(byte paramByte)
  {
    AppMethodBeat.i(148369);
    this.hZW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(148369);
  }
  
  public static final class a
  {
    public byte[] buf;
    public int len;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.wi
 * JD-Core Version:    0.7.0.1
 */