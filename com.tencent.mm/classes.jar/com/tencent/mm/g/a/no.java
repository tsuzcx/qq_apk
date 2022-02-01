package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class no
  extends IEvent
{
  public a dTI;
  
  public no()
  {
    this((byte)0);
  }
  
  private no(byte paramByte)
  {
    AppMethodBeat.i(19822);
    this.dTI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19822);
  }
  
  public static final class a
  {
    public int dTJ = 0;
    public int dTK = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.no
 * JD-Core Version:    0.7.0.1
 */