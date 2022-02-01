package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rz
  extends IEvent
{
  public a dYA;
  
  public rz()
  {
    this((byte)0);
  }
  
  private rz(byte paramByte)
  {
    AppMethodBeat.i(187543);
    this.dYA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(187543);
  }
  
  public static final class a
  {
    public byte[] buffer;
    public String dYB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.rz
 * JD-Core Version:    0.7.0.1
 */