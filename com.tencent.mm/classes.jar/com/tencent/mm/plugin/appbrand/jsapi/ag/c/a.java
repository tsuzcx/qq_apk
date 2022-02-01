package com.tencent.mm.plugin.appbrand.jsapi.ag.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class a
  extends IEvent
{
  public a mJH;
  
  public a()
  {
    this((byte)0);
  }
  
  private a(byte paramByte)
  {
    AppMethodBeat.i(215838);
    this.mJH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(215838);
  }
  
  public static final class a
  {
    public String appId;
    public int beL;
    public int dDe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.c.a
 * JD-Core Version:    0.7.0.1
 */