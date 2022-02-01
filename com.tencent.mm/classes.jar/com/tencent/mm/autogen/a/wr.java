package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wr
  extends IEvent
{
  public a iam;
  
  public wr()
  {
    this((byte)0);
  }
  
  private wr(byte paramByte)
  {
    AppMethodBeat.i(19834);
    this.iam = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19834);
  }
  
  public static final class a
  {
    public String hYg;
    public int msgType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.wr
 * JD-Core Version:    0.7.0.1
 */