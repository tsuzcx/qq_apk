package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ol
  extends IEvent
{
  public a dUx;
  
  public ol()
  {
    this((byte)0);
  }
  
  private ol(byte paramByte)
  {
    AppMethodBeat.i(131793);
    this.dUx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131793);
  }
  
  public static final class a
  {
    public int action = 0;
    public long dUy;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ol
 * JD-Core Version:    0.7.0.1
 */