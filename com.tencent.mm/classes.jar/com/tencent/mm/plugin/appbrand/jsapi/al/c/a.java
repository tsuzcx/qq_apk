package com.tencent.mm.plugin.appbrand.jsapi.al.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class a
  extends IEvent
{
  public a sPs;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte)
  {
    AppMethodBeat.i(327090);
    this.sPs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(327090);
  }
  
  public static final class a
  {
    public String appId;
    public int cIi;
    public int hAf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.a
 * JD-Core Version:    0.7.0.1
 */