package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kz
  extends IEvent
{
  public a hMI;
  
  public kz()
  {
    this((byte)0);
  }
  
  private kz(byte paramByte)
  {
    AppMethodBeat.i(149862);
    this.hMI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149862);
  }
  
  public static final class a
  {
    public String appId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.kz
 * JD-Core Version:    0.7.0.1
 */