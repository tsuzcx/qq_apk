package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yc
  extends IEvent
{
  public a eev;
  public b eew;
  
  public yc()
  {
    this((byte)0);
  }
  
  private yc(byte paramByte)
  {
    AppMethodBeat.i(116054);
    this.eev = new a();
    this.eew = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116054);
  }
  
  public static final class a
  {
    public String id;
  }
  
  public static final class b
  {
    public boolean eex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.yc
 * JD-Core Version:    0.7.0.1
 */