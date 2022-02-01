package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bc
  extends IEvent
{
  public a fwP;
  public b fwQ;
  
  public bc()
  {
    this((byte)0);
  }
  
  private bc(byte paramByte)
  {
    AppMethodBeat.i(91198);
    this.fwP = new a();
    this.fwQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91198);
  }
  
  public static final class a
  {
    public String fwR;
    public boolean fwS;
    public boolean fwT;
    public boolean fwU;
  }
  
  public static final class b
  {
    public boolean result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.bc
 * JD-Core Version:    0.7.0.1
 */