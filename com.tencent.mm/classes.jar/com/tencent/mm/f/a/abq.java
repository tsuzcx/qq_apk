package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abq
  extends IEvent
{
  public a gbx;
  
  public abq()
  {
    this((byte)0);
  }
  
  private abq(byte paramByte)
  {
    AppMethodBeat.i(117552);
    this.gbx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117552);
  }
  
  public static final class a
  {
    public long fNu;
    public String fQs;
    public String gby;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.abq
 * JD-Core Version:    0.7.0.1
 */