package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hq
  extends IEvent
{
  public a fEE;
  
  public hq()
  {
    this((byte)0);
  }
  
  private hq(byte paramByte)
  {
    AppMethodBeat.i(241607);
    this.fEE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(241607);
  }
  
  public static final class a
  {
    public boolean fEF;
    public boolean fEG;
    public int fEH;
    public boolean fEs;
    public long feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.hq
 * JD-Core Version:    0.7.0.1
 */