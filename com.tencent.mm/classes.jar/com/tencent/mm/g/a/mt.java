package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mt
  extends IEvent
{
  public a dSq;
  
  public mt()
  {
    this((byte)0);
  }
  
  private mt(byte paramByte)
  {
    AppMethodBeat.i(200242);
    this.dSq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(200242);
  }
  
  public static final class a
  {
    public int dSr;
    public String id;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.mt
 * JD-Core Version:    0.7.0.1
 */