package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hq
  extends IEvent
{
  public a dMi;
  
  public hq()
  {
    this((byte)0);
  }
  
  private hq(byte paramByte)
  {
    AppMethodBeat.i(241574);
    this.dMi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(241574);
  }
  
  public static final class a
  {
    public String dMj;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hq
 * JD-Core Version:    0.7.0.1
 */