package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yl
  extends IEvent
{
  public a eeI;
  
  public yl()
  {
    this((byte)0);
  }
  
  private yl(byte paramByte)
  {
    AppMethodBeat.i(94801);
    this.eeI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94801);
  }
  
  public static final class a
  {
    public long eeJ = -1L;
    public long eeK = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.yl
 * JD-Core Version:    0.7.0.1
 */