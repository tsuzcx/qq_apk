package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fl
  extends IEvent
{
  public a dIL;
  
  public fl()
  {
    this((byte)0);
  }
  
  private fl(byte paramByte)
  {
    AppMethodBeat.i(116013);
    this.dIL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116013);
  }
  
  public static final class a
  {
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.fl
 * JD-Core Version:    0.7.0.1
 */