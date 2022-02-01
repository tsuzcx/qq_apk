package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dm
  extends IEvent
{
  public a fzc;
  
  public dm()
  {
    this((byte)0);
  }
  
  private dm(byte paramByte)
  {
    AppMethodBeat.i(104410);
    this.fzc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104410);
  }
  
  public static final class a
  {
    public int subType = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.dm
 * JD-Core Version:    0.7.0.1
 */