package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ed
  extends IEvent
{
  public a hDT;
  public b hDU;
  
  public ed()
  {
    this((byte)0);
  }
  
  private ed(byte paramByte)
  {
    AppMethodBeat.i(104415);
    this.hDT = new a();
    this.hDU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104415);
  }
  
  public static final class a
  {
    public int type;
  }
  
  public static final class b
  {
    public boolean hDV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ed
 * JD-Core Version:    0.7.0.1
 */