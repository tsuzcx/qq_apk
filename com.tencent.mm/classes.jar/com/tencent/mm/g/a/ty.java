package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ty
  extends IEvent
{
  public a eas;
  
  public ty()
  {
    this((byte)0);
  }
  
  private ty(byte paramByte)
  {
    AppMethodBeat.i(19834);
    this.eas = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19834);
  }
  
  public static final class a
  {
    public String dYs;
    public int msgType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ty
 * JD-Core Version:    0.7.0.1
 */