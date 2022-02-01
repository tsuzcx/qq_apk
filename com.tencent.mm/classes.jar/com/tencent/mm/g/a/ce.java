package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ce
  extends IEvent
{
  public a dFo;
  public b dFp;
  
  public ce()
  {
    this((byte)0);
  }
  
  private ce(byte paramByte)
  {
    AppMethodBeat.i(140934);
    this.dFo = new a();
    this.dFp = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140934);
  }
  
  public static final class a
  {
    public int dFq = 0;
  }
  
  public static final class b
  {
    public int retCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.ce
 * JD-Core Version:    0.7.0.1
 */