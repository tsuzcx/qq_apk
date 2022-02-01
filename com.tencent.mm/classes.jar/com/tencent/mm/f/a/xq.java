package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xq
  extends IEvent
{
  public a fWA;
  
  public xq()
  {
    this((byte)0);
  }
  
  private xq(byte paramByte)
  {
    AppMethodBeat.i(125648);
    this.fWA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125648);
  }
  
  public static final class a
  {
    public String id;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xq
 * JD-Core Version:    0.7.0.1
 */