package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class tq
  extends IEvent
{
  public a fSZ;
  
  public tq()
  {
    this((byte)0);
  }
  
  private tq(byte paramByte)
  {
    AppMethodBeat.i(19829);
    this.fSZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19829);
  }
  
  public static final class a
  {
    public ca fvt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.tq
 * JD-Core Version:    0.7.0.1
 */