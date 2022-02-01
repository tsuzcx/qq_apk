package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uf
  extends IEvent
{
  public a eaC;
  
  public uf()
  {
    this((byte)0);
  }
  
  private uf(byte paramByte)
  {
    AppMethodBeat.i(194252);
    this.eaC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194252);
  }
  
  public static final class a
  {
    public String dNA;
    public long eaB;
    public Boolean eaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.uf
 * JD-Core Version:    0.7.0.1
 */