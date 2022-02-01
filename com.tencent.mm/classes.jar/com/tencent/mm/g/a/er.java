package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class er
  extends IEvent
{
  public a dHZ;
  
  public er()
  {
    this((byte)0);
  }
  
  private er(byte paramByte)
  {
    AppMethodBeat.i(116001);
    this.dHZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116001);
  }
  
  public static final class a
  {
    public boolean brW;
    public String dGL;
    public byte[] dHR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.er
 * JD-Core Version:    0.7.0.1
 */