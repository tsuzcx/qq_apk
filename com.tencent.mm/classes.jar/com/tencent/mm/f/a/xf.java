package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xf
  extends IEvent
{
  public a fWj;
  
  public xf()
  {
    this((byte)0);
  }
  
  private xf(byte paramByte)
  {
    AppMethodBeat.i(125645);
    this.fWj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125645);
  }
  
  public static final class a
  {
    public long fWe = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xf
 * JD-Core Version:    0.7.0.1
 */