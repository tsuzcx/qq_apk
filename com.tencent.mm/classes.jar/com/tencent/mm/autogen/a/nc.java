package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609.a;
import com.tencent.mm.sdk.event.IEvent;

public final class nc
  extends IEvent
{
  public a hPq;
  
  public nc()
  {
    this((byte)0);
  }
  
  private nc(byte paramByte)
  {
    AppMethodBeat.i(43441);
    this.hPq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43441);
  }
  
  public static final class a
  {
    public kv_14609 hPr;
    public kv_14609.a hPs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nc
 * JD-Core Version:    0.7.0.1
 */