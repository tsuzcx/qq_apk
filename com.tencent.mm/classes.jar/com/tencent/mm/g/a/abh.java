package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abh
  extends IEvent
{
  public a gVp;
  
  public abh()
  {
    this((byte)0);
  }
  
  private abh(byte paramByte)
  {
    AppMethodBeat.i(258528);
    this.gVp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(258528);
  }
  
  public static final class a
  {
    public int action;
    public long commentId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.a.abh
 * JD-Core Version:    0.7.0.1
 */