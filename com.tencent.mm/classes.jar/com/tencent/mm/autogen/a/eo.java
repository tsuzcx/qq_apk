package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class eo
  extends IEvent
{
  public a hEA;
  public b hEB;
  
  public eo()
  {
    this((byte)0);
  }
  
  private eo(byte paramByte)
  {
    AppMethodBeat.i(115981);
    this.hEA = new a();
    this.hEB = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115981);
  }
  
  public static final class a
  {
    public String hEl;
    public String hEy;
    public boolean hEz = false;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.eo
 * JD-Core Version:    0.7.0.1
 */