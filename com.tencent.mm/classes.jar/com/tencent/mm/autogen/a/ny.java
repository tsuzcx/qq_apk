package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ny
  extends IEvent
{
  public a hQx;
  
  public ny()
  {
    this((byte)0);
  }
  
  private ny(byte paramByte)
  {
    AppMethodBeat.i(116031);
    this.hQx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116031);
  }
  
  public static final class a
  {
    public int reason = 0;
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ny
 * JD-Core Version:    0.7.0.1
 */