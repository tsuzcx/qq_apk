package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qb
  extends IEvent
{
  public a fOM;
  
  public qb()
  {
    this((byte)0);
  }
  
  private qb(byte paramByte)
  {
    AppMethodBeat.i(215313);
    this.fOM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(215313);
  }
  
  public static final class a
  {
    public int bnA = 0;
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.a.qb
 * JD-Core Version:    0.7.0.1
 */