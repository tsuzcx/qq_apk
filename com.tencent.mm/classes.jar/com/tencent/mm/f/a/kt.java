package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kt
  extends IEvent
{
  public a fIo;
  
  public kt()
  {
    this((byte)0);
  }
  
  private kt(byte paramByte)
  {
    AppMethodBeat.i(125619);
    this.fIo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125619);
  }
  
  public static final class a
  {
    public boolean isResume = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.kt
 * JD-Core Version:    0.7.0.1
 */