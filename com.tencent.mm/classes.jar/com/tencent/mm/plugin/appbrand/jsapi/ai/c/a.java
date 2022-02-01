package com.tencent.mm.plugin.appbrand.jsapi.ai.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class a
  extends IEvent
{
  public a pKz;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte)
  {
    AppMethodBeat.i(224043);
    this.pKz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(224043);
  }
  
  public static final class a
  {
    public int aOm;
    public String appId;
    public int fvK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.c.a
 * JD-Core Version:    0.7.0.1
 */