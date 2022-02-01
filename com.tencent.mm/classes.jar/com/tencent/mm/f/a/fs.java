package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fs
  extends IEvent
{
  public a fBC;
  
  public fs()
  {
    this((byte)0);
  }
  
  private fs(byte paramByte)
  {
    AppMethodBeat.i(116013);
    this.fBC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116013);
  }
  
  public static final class a
  {
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fs
 * JD-Core Version:    0.7.0.1
 */