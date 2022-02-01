package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hh
  extends IEvent
{
  public a hIe;
  public b hIf;
  
  public hh()
  {
    this((byte)0);
  }
  
  private hh(byte paramByte)
  {
    AppMethodBeat.i(155366);
    this.hIe = new a();
    this.hIf = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155366);
  }
  
  public static final class a
  {
    public String hIg;
    public String hIh;
  }
  
  public static final class b
  {
    public boolean hIi = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.hh
 * JD-Core Version:    0.7.0.1
 */