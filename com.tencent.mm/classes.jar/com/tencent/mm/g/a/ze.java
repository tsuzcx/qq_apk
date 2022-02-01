package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ze
  extends IEvent
{
  public a efp;
  
  public ze()
  {
    this((byte)0);
  }
  
  private ze(byte paramByte)
  {
    AppMethodBeat.i(19846);
    this.efp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19846);
  }
  
  public static final class a
  {
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ze
 * JD-Core Version:    0.7.0.1
 */