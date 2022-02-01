package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uf
  extends IEvent
{
  public a hXW;
  public b hXX;
  
  public uf()
  {
    this((byte)0);
  }
  
  private uf(byte paramByte)
  {
    AppMethodBeat.i(369406);
    this.hXW = new a();
    this.hXX = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369406);
  }
  
  public static final class a
  {
    public int action = 0;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.a.uf
 * JD-Core Version:    0.7.0.1
 */