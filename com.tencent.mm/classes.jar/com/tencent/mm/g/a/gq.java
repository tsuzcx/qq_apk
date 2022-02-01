package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gq
  extends IEvent
{
  public a dKE;
  public b dKF;
  
  public gq()
  {
    this((byte)0);
  }
  
  private gq(byte paramByte)
  {
    AppMethodBeat.i(155367);
    this.dKE = new a();
    this.dKF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155367);
  }
  
  public static final class a
  {
    public String dKB;
    public String dKC;
  }
  
  public static final class b
  {
    public String dKG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gq
 * JD-Core Version:    0.7.0.1
 */