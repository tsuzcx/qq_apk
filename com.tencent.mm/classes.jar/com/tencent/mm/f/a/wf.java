package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wf
  extends IEvent
{
  public a fVs;
  
  public wf()
  {
    this((byte)0);
  }
  
  private wf(byte paramByte)
  {
    AppMethodBeat.i(125632);
    this.fVs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125632);
  }
  
  public static final class a
  {
    public boolean isStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wf
 * JD-Core Version:    0.7.0.1
 */