package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lk
  extends IEvent
{
  public a hNh;
  public b hNi;
  
  public lk()
  {
    this((byte)0);
  }
  
  private lk(byte paramByte)
  {
    AppMethodBeat.i(91207);
    this.hNh = new a();
    this.hNi = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91207);
  }
  
  public static final class a
  {
    public int hNj = 0;
  }
  
  public static final class b
  {
    public boolean hNk = false;
    public String hNl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.lk
 * JD-Core Version:    0.7.0.1
 */