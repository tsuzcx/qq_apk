package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abz
  extends IEvent
{
  public a gbX;
  
  public abz()
  {
    this((byte)0);
  }
  
  private abz(byte paramByte)
  {
    AppMethodBeat.i(117616);
    this.gbX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117616);
  }
  
  public static final class a
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.abz
 * JD-Core Version:    0.7.0.1
 */