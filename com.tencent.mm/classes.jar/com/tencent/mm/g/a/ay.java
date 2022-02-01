package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ay
  extends IEvent
{
  public a dEa;
  
  public ay()
  {
    this((byte)0);
  }
  
  private ay(byte paramByte)
  {
    AppMethodBeat.i(120830);
    this.dEa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(120830);
  }
  
  public static final class a
  {
    public int dEb;
    public int scene = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ay
 * JD-Core Version:    0.7.0.1
 */