package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fl
  extends IEvent
{
  public a fBs;
  
  public fl()
  {
    this((byte)0);
  }
  
  private fl(byte paramByte)
  {
    AppMethodBeat.i(19797);
    this.fBs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19797);
  }
  
  public static final class a
  {
    public int fAF;
    public long fBp;
    public String mac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.fl
 * JD-Core Version:    0.7.0.1
 */