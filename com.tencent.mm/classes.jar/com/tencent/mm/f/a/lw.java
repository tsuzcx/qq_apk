package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609.a;
import com.tencent.mm.sdk.event.IEvent;

public final class lw
  extends IEvent
{
  public a fJK;
  
  public lw()
  {
    this((byte)0);
  }
  
  private lw(byte paramByte)
  {
    AppMethodBeat.i(43441);
    this.fJK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43441);
  }
  
  public static final class a
  {
    public kv_14609 fJL;
    public kv_14609.a fJM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.lw
 * JD-Core Version:    0.7.0.1
 */