package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fv
  extends IEvent
{
  public a hGf;
  public b hGg;
  
  public fv()
  {
    this((byte)0);
  }
  
  private fv(byte paramByte)
  {
    AppMethodBeat.i(19796);
    this.hGf = new a();
    this.hGg = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19796);
  }
  
  public static final class a
  {
    public boolean hEz = false;
    public String mac;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fv
 * JD-Core Version:    0.7.0.1
 */