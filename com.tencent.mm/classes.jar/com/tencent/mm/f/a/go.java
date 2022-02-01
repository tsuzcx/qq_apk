package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class go
  extends IEvent
{
  public a fCR;
  public b fCS;
  
  public go()
  {
    this((byte)0);
  }
  
  private go(byte paramByte)
  {
    AppMethodBeat.i(116025);
    this.fCR = new a();
    this.fCS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116025);
  }
  
  public static final class a
  {
    public long msgId;
  }
  
  public static final class b
  {
    public String fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.go
 * JD-Core Version:    0.7.0.1
 */