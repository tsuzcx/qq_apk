package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zh
  extends IEvent
{
  public a efu;
  
  public zh()
  {
    this((byte)0);
  }
  
  private zh(byte paramByte)
  {
    AppMethodBeat.i(140993);
    this.efu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140993);
  }
  
  public static final class a
  {
    public boolean dya;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.zh
 * JD-Core Version:    0.7.0.1
 */