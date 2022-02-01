package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vy
  extends IEvent
{
  public a ecb;
  
  public vy()
  {
    this((byte)0);
  }
  
  private vy(byte paramByte)
  {
    AppMethodBeat.i(125644);
    this.ecb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125644);
  }
  
  public static final class a
  {
    public long ecc = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vy
 * JD-Core Version:    0.7.0.1
 */