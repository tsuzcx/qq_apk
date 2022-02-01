package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tp
  extends IEvent
{
  public a dZZ;
  
  public tp()
  {
    this((byte)0);
  }
  
  private tp(byte paramByte)
  {
    AppMethodBeat.i(120832);
    this.dZZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(120832);
  }
  
  public static final class a
  {
    public boolean dDz;
    public int dEb;
    public String eaa;
    public String eab;
    public String eac;
    public int source = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.tp
 * JD-Core Version:    0.7.0.1
 */