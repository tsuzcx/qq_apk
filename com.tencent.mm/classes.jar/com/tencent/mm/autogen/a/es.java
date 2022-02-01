package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class es
  extends IEvent
{
  public a hEI;
  public b hEJ;
  
  public es()
  {
    this((byte)0);
  }
  
  private es(byte paramByte)
  {
    AppMethodBeat.i(115984);
    this.hEI = new a();
    this.hEJ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115984);
  }
  
  public static final class a
  {
    public boolean hEz = false;
  }
  
  public static final class b
  {
    public String hEK;
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.es
 * JD-Core Version:    0.7.0.1
 */