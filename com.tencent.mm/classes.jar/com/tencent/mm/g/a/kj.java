package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kj
  extends IEvent
{
  public a dPt;
  
  public kj()
  {
    this((byte)0);
  }
  
  private kj(byte paramByte)
  {
    AppMethodBeat.i(93324);
    this.dPt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93324);
  }
  
  public static final class a
  {
    public long dFm;
    public String dPu;
    public String dPv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.kj
 * JD-Core Version:    0.7.0.1
 */