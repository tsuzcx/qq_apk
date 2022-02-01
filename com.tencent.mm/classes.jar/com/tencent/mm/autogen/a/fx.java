package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fx
  extends IEvent
{
  public a hGi;
  
  public fx()
  {
    this((byte)0);
  }
  
  private fx(byte paramByte)
  {
    AppMethodBeat.i(19798);
    this.hGi = new a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fx
 * JD-Core Version:    0.7.0.1
 */