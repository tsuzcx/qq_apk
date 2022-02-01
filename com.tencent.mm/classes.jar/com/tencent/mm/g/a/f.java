package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class f
  extends IEvent
{
  public a dBS;
  
  public f()
  {
    this((byte)0);
  }
  
  private f(byte paramByte)
  {
    AppMethodBeat.i(208799);
    this.dBS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208799);
  }
  
  public static final class a
  {
    public long dBT;
    public long id;
    public long localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.f
 * JD-Core Version:    0.7.0.1
 */