package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609;
import com.tencent.mm.plugin.appbrand.report.model.kv_14609.a;
import com.tencent.mm.sdk.event.IEvent;

public final class lf
  extends IEvent
{
  public a dQt;
  
  public lf()
  {
    this((byte)0);
  }
  
  private lf(byte paramByte)
  {
    AppMethodBeat.i(43441);
    this.dQt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43441);
  }
  
  public static final class a
  {
    public kv_14609 dQu;
    public kv_14609.a dQv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.lf
 * JD-Core Version:    0.7.0.1
 */