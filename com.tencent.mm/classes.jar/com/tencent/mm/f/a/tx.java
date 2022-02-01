package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class tx
  extends IEvent
{
  public a fTi;
  
  public tx()
  {
    this((byte)0);
  }
  
  private tx(byte paramByte)
  {
    AppMethodBeat.i(94799);
    this.fTi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94799);
  }
  
  public static final class a
  {
    public ca fNz;
    public String fTj;
    public ca fTk;
    public long fTl = 0L;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.tx
 * JD-Core Version:    0.7.0.1
 */