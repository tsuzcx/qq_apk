package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ok
  extends IEvent
{
  public a fNj;
  
  public ok()
  {
    this((byte)0);
  }
  
  private ok(byte paramByte)
  {
    AppMethodBeat.i(19822);
    this.fNj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19822);
  }
  
  public static final class a
  {
    public int fNk = 0;
    public int fNl = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ok
 * JD-Core Version:    0.7.0.1
 */