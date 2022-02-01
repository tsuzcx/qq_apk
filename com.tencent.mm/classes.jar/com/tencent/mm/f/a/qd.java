package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qd
  extends IEvent
{
  public a fON;
  
  public qd()
  {
    this((byte)0);
  }
  
  private qd(byte paramByte)
  {
    AppMethodBeat.i(186449);
    this.fON = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(186449);
  }
  
  public static final class a
  {
    public String fOO;
    public String fOP;
    public int fOQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.qd
 * JD-Core Version:    0.7.0.1
 */