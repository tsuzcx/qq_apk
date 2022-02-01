package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class le
  extends IEvent
{
  public a fIS;
  
  public le()
  {
    this((byte)0);
  }
  
  private le(byte paramByte)
  {
    AppMethodBeat.i(149866);
    this.fIS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149866);
  }
  
  public static final class a
  {
    public String fIT;
    public String fIU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.le
 * JD-Core Version:    0.7.0.1
 */