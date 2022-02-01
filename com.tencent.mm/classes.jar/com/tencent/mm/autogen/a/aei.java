package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.appbrand.appcache.i;
import com.tencent.mm.sdk.event.IEvent;

public final class aei
  extends IEvent
{
  public a iiU;
  
  public aei()
  {
    this((byte)0);
  }
  
  private aei(byte paramByte)
  {
    AppMethodBeat.i(90538);
    this.iiU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(90538);
  }
  
  public static final class a
  {
    public long endMs;
    public i iiV;
    public b.a iiW;
    public long startMs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aei
 * JD-Core Version:    0.7.0.1
 */