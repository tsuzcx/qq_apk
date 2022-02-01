package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ace
  extends IEvent
{
  public a gcd;
  
  public ace()
  {
    this((byte)0);
  }
  
  private ace(byte paramByte)
  {
    AppMethodBeat.i(91237);
    this.gcd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91237);
  }
  
  public static final class a
  {
    public int result = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ace
 * JD-Core Version:    0.7.0.1
 */