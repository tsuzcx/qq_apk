package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wq
  extends IEvent
{
  public a fVJ;
  
  public wq()
  {
    this((byte)0);
  }
  
  private wq(byte paramByte)
  {
    AppMethodBeat.i(125635);
    this.fVJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125635);
  }
  
  public static final class a
  {
    public long fGk = 0L;
    public boolean fVK = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wq
 * JD-Core Version:    0.7.0.1
 */