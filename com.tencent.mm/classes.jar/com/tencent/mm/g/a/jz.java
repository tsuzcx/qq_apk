package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jz
  extends IEvent
{
  public a dOT;
  public b dOU;
  
  public jz()
  {
    this((byte)0);
  }
  
  private jz(byte paramByte)
  {
    AppMethodBeat.i(149865);
    this.dOT = new a();
    this.dOU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149865);
  }
  
  public static final class a
  {
    public String userName;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.jz
 * JD-Core Version:    0.7.0.1
 */