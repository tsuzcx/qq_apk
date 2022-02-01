package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rf
  extends IEvent
{
  public a dXV;
  
  public rf()
  {
    this((byte)0);
  }
  
  private rf(byte paramByte)
  {
    AppMethodBeat.i(19826);
    this.dXV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19826);
  }
  
  public static final class a
  {
    public int action;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.rf
 * JD-Core Version:    0.7.0.1
 */