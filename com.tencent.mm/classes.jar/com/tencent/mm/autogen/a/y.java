package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class y
  extends IEvent
{
  public a hzL;
  
  public y()
  {
    this((byte)0);
  }
  
  private y(byte paramByte)
  {
    AppMethodBeat.i(104408);
    this.hzL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104408);
  }
  
  public static final class a
  {
    public String hzM;
    public int percentage;
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.y
 * JD-Core Version:    0.7.0.1
 */