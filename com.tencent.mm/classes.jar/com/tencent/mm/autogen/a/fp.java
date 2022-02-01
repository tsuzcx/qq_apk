package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fp
  extends IEvent
{
  public a hFN;
  public b hFO;
  
  public fp()
  {
    this((byte)0);
  }
  
  private fp(byte paramByte)
  {
    AppMethodBeat.i(116007);
    this.hFN = new a();
    this.hFO = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116007);
  }
  
  public static final class a
  {
    public String data;
    public String hEl;
    public String hEy;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fp
 * JD-Core Version:    0.7.0.1
 */