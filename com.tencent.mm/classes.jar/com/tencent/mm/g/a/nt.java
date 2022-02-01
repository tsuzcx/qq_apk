package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nt
  extends IEvent
{
  public a dTT;
  
  public nt()
  {
    this((byte)0);
  }
  
  private nt(byte paramByte)
  {
    AppMethodBeat.i(181499);
    this.dTT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(181499);
  }
  
  public static final class a
  {
    public String dOe;
    public String dTU;
    public int op = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.nt
 * JD-Core Version:    0.7.0.1
 */