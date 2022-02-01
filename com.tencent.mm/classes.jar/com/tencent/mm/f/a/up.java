package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class up
  extends IEvent
{
  public a fTS;
  
  public up()
  {
    this((byte)0);
  }
  
  private up(byte paramByte)
  {
    AppMethodBeat.i(187922);
    this.fTS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(187922);
  }
  
  public static final class a
  {
    public String fAo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.up
 * JD-Core Version:    0.7.0.1
 */