package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kt
  extends IEvent
{
  public a dPO;
  
  public kt()
  {
    this((byte)0);
  }
  
  private kt(byte paramByte)
  {
    AppMethodBeat.i(204058);
    this.dPO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(204058);
  }
  
  public static final class a
  {
    public int currentIndex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.kt
 * JD-Core Version:    0.7.0.1
 */