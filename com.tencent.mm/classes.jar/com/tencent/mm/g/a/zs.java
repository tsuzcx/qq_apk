package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zs
  extends IEvent
{
  public a efL;
  
  public zs()
  {
    this((byte)0);
  }
  
  private zs(byte paramByte)
  {
    AppMethodBeat.i(116057);
    this.efL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116057);
  }
  
  public static final class a
  {
    public String uri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zs
 * JD-Core Version:    0.7.0.1
 */