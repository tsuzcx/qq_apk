package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kx
  extends IEvent
{
  public a dPZ;
  
  public kx()
  {
    this((byte)0);
  }
  
  private kx(byte paramByte)
  {
    AppMethodBeat.i(19814);
    this.dPZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19814);
  }
  
  public static final class a
  {
    public byte[] dQa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.kx
 * JD-Core Version:    0.7.0.1
 */