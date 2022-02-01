package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pc
  extends IEvent
{
  public a fNW;
  
  public pc()
  {
    this((byte)0);
  }
  
  private pc(byte paramByte)
  {
    AppMethodBeat.i(117548);
    this.fNW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117548);
  }
  
  public static final class a
  {
    public int aNf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.pc
 * JD-Core Version:    0.7.0.1
 */