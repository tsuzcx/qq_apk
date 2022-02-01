package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gg
  extends IEvent
{
  public a dKa;
  public b dKb;
  
  public gg()
  {
    this((byte)0);
  }
  
  private gg(byte paramByte)
  {
    AppMethodBeat.i(116024);
    this.dKa = new a();
    this.dKb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116024);
  }
  
  public static final class a
  {
    public String fileName;
  }
  
  public static final class b
  {
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.gg
 * JD-Core Version:    0.7.0.1
 */