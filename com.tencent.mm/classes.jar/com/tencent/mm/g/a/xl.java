package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xl
  extends IEvent
{
  public a edI;
  
  public xl()
  {
    this((byte)0);
  }
  
  private xl(byte paramByte)
  {
    AppMethodBeat.i(131795);
    this.edI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131795);
  }
  
  public static final class a
  {
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.xl
 * JD-Core Version:    0.7.0.1
 */