package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gy
  extends IEvent
{
  public a hHE;
  public b hHF;
  
  public gy()
  {
    this((byte)0);
  }
  
  private gy(byte paramByte)
  {
    AppMethodBeat.i(116024);
    this.hHE = new a();
    this.hHF = new b();
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
 * Qualified Name:     com.tencent.mm.autogen.a.gy
 * JD-Core Version:    0.7.0.1
 */