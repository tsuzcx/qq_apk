package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aao
  extends IEvent
{
  public a ehA;
  
  public aao()
  {
    this((byte)0);
  }
  
  private aao(byte paramByte)
  {
    AppMethodBeat.i(104423);
    this.ehA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104423);
  }
  
  public static final class a
  {
    public int dDe;
    public String[] ehB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.aao
 * JD-Core Version:    0.7.0.1
 */