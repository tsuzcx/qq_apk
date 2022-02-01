package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.appbrand.appcache.h;
import com.tencent.mm.sdk.event.IEvent;

public final class abb
  extends IEvent
{
  public a ein;
  
  public abb()
  {
    this((byte)0);
  }
  
  private abb(byte paramByte)
  {
    AppMethodBeat.i(90538);
    this.ein = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(90538);
  }
  
  public static final class a
  {
    public long dcl;
    public h eio;
    public c.a eip;
    public long eiq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.abb
 * JD-Core Version:    0.7.0.1
 */