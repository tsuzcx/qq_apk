package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fz
  extends IEvent
{
  public a hGk;
  public b hGl;
  
  public fz()
  {
    this((byte)0);
  }
  
  private fz(byte paramByte)
  {
    AppMethodBeat.i(19800);
    this.hGk = new a();
    this.hGl = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19800);
  }
  
  public static final class a
  {
    public boolean hEz = false;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fz
 * JD-Core Version:    0.7.0.1
 */