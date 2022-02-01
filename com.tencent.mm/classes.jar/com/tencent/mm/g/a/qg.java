package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qg
  extends IEvent
{
  public a dWB;
  public b dWC;
  
  public qg()
  {
    this((byte)0);
  }
  
  private qg(byte paramByte)
  {
    AppMethodBeat.i(9427);
    this.dWB = new a();
    this.dWC = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(9427);
  }
  
  public static final class a
  {
    public long dFm;
    public String xml;
  }
  
  public static final class b
  {
    public String dWD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.qg
 * JD-Core Version:    0.7.0.1
 */