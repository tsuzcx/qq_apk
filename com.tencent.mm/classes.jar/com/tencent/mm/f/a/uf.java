package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uf
  extends IEvent
{
  public a fTx;
  public b fTy;
  
  public uf()
  {
    this((byte)0);
  }
  
  private uf(byte paramByte)
  {
    AppMethodBeat.i(19833);
    this.fTx = new a();
    this.fTy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19833);
  }
  
  public static final class a
  {
    public String userName;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.uf
 * JD-Core Version:    0.7.0.1
 */