package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mj
  extends IEvent
{
  public a dRJ;
  
  public mj()
  {
    this((byte)0);
  }
  
  private mj(byte paramByte)
  {
    AppMethodBeat.i(19819);
    this.dRJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19819);
  }
  
  public static final class a
  {
    public boolean dgZ;
    public long progress;
    public long total;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.mj
 * JD-Core Version:    0.7.0.1
 */