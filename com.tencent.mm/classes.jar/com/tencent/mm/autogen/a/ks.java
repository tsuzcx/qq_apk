package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ks
  extends IEvent
{
  public a hMq;
  
  public ks()
  {
    this((byte)0);
  }
  
  private ks(byte paramByte)
  {
    AppMethodBeat.i(123476);
    this.hMq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(123476);
  }
  
  public static final class a
  {
    public String appid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ks
 * JD-Core Version:    0.7.0.1
 */