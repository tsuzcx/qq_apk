package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jt
  extends IEvent
{
  public a dOE;
  public b dOF;
  
  public jt()
  {
    this((byte)0);
  }
  
  private jt(byte paramByte)
  {
    AppMethodBeat.i(130778);
    this.dOE = new a();
    this.dOF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130778);
  }
  
  public static final class a
  {
    public int dOG = -1;
  }
  
  public static final class b
  {
    public int dOH = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.jt
 * JD-Core Version:    0.7.0.1
 */