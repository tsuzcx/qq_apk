package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bo
  extends IEvent
{
  public a hBC;
  
  public bo()
  {
    this((byte)0);
  }
  
  private bo(byte paramByte)
  {
    AppMethodBeat.i(116458);
    this.hBC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116458);
  }
  
  public static final class a
  {
    public String hBD;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bo
 * JD-Core Version:    0.7.0.1
 */