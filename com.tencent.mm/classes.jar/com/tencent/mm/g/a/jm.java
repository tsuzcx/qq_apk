package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jm
  extends IEvent
{
  public a dOn;
  
  public jm()
  {
    this((byte)0);
  }
  
  private jm(byte paramByte)
  {
    AppMethodBeat.i(131790);
    this.dOn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131790);
  }
  
  public static final class a
  {
    public int dOo = 0;
    public boolean dOp = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.jm
 * JD-Core Version:    0.7.0.1
 */