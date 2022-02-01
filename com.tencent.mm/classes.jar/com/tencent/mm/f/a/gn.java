package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gn
  extends IEvent
{
  public a fCP;
  public b fCQ;
  
  public gn()
  {
    this((byte)0);
  }
  
  private gn(byte paramByte)
  {
    AppMethodBeat.i(116024);
    this.fCP = new a();
    this.fCQ = new b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gn
 * JD-Core Version:    0.7.0.1
 */