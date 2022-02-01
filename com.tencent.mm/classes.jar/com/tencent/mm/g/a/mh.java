package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mh
  extends IEvent
{
  public a dRG;
  
  public mh()
  {
    this((byte)0);
  }
  
  private mh(byte paramByte)
  {
    AppMethodBeat.i(231466);
    this.dRG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(231466);
  }
  
  public static final class a
  {
    public int dRH = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.mh
 * JD-Core Version:    0.7.0.1
 */