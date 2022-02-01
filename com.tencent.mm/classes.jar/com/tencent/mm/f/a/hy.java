package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hy
  extends IEvent
{
  public a fEZ;
  
  public hy()
  {
    this((byte)0);
  }
  
  private hy(byte paramByte)
  {
    AppMethodBeat.i(292155);
    this.fEZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(292155);
  }
  
  public static final class a
  {
    public String fFa;
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.hy
 * JD-Core Version:    0.7.0.1
 */