package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ml
  extends IEvent
{
  public a dRT;
  
  public ml()
  {
    this((byte)0);
  }
  
  private ml(byte paramByte)
  {
    AppMethodBeat.i(155544);
    this.dRT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155544);
  }
  
  public static final class a
  {
    public boolean dRU = false;
    public int dRV;
    public boolean dRW = false;
    public int dRX;
    public boolean dRY = false;
    public int dRZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ml
 * JD-Core Version:    0.7.0.1
 */