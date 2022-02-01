package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kp
  extends IEvent
{
  public a dPH;
  
  public kp()
  {
    this((byte)0);
  }
  
  private kp(byte paramByte)
  {
    AppMethodBeat.i(121032);
    this.dPH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121032);
  }
  
  public static final class a
  {
    public String dPI;
    public String dPJ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.kp
 * JD-Core Version:    0.7.0.1
 */