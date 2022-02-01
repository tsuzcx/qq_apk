package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kn
  extends IEvent
{
  public a dPD;
  
  public kn()
  {
    this((byte)0);
  }
  
  private kn(byte paramByte)
  {
    AppMethodBeat.i(149866);
    this.dPD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149866);
  }
  
  public static final class a
  {
    public String dPE;
    public String dPF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.kn
 * JD-Core Version:    0.7.0.1
 */