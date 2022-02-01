package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kh
  extends IEvent
{
  public a dPo;
  public b dPp;
  
  public kh()
  {
    this((byte)0);
  }
  
  private kh(byte paramByte)
  {
    AppMethodBeat.i(153017);
    this.dPo = new a();
    this.dPp = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153017);
  }
  
  public static final class a
  {
    public String dPq;
  }
  
  public static final class b
  {
    public String dPr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.kh
 * JD-Core Version:    0.7.0.1
 */