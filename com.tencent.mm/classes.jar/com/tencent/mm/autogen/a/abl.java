package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abl
  extends IEvent
{
  public a ieZ;
  
  public abl()
  {
    this((byte)0);
  }
  
  private abl(byte paramByte)
  {
    AppMethodBeat.i(369349);
    this.ieZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369349);
  }
  
  public static final class a
  {
    public String appId;
    public boolean hzt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abl
 * JD-Core Version:    0.7.0.1
 */