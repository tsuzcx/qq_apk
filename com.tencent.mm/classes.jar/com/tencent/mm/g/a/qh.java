package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qh
  extends IEvent
{
  public a dWE;
  public b dWF;
  
  public qh()
  {
    this((byte)0);
  }
  
  private qh(byte paramByte)
  {
    AppMethodBeat.i(127289);
    this.dWE = new a();
    this.dWF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127289);
  }
  
  public static final class a
  {
    public String dWG;
    public String talker;
  }
  
  public static final class b
  {
    public boolean dFE = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.qh
 * JD-Core Version:    0.7.0.1
 */