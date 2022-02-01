package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ba
  extends IEvent
{
  public a dEe;
  public b dEf;
  
  public ba()
  {
    this((byte)0);
  }
  
  private ba(byte paramByte)
  {
    AppMethodBeat.i(91198);
    this.dEe = new a();
    this.dEf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91198);
  }
  
  public static final class a
  {
    public String dEg;
    public boolean dEh;
    public boolean dEi;
    public boolean dEj;
  }
  
  public static final class b
  {
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ba
 * JD-Core Version:    0.7.0.1
 */