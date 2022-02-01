package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xd
  extends IEvent
{
  public a fWd;
  
  public xd()
  {
    this((byte)0);
  }
  
  private xd(byte paramByte)
  {
    AppMethodBeat.i(125644);
    this.fWd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125644);
  }
  
  public static final class a
  {
    public long fWe = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xd
 * JD-Core Version:    0.7.0.1
 */