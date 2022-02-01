package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.event.IEvent;

public final class dr
  extends IEvent
{
  public a dGF;
  public b dGG;
  
  public dr()
  {
    this((byte)0);
  }
  
  private dr(byte paramByte)
  {
    AppMethodBeat.i(115975);
    this.dGF = new a();
    this.dGG = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115975);
  }
  
  public static final class a
  {
    public String dGH;
    public int dGI = 0;
    public q dGJ;
    public int opType = 0;
  }
  
  public static final class b
  {
    public q dGJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.dr
 * JD-Core Version:    0.7.0.1
 */