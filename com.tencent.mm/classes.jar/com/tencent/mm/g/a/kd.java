package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kd
  extends IEvent
{
  public a dPd;
  
  public kd()
  {
    this((byte)0);
  }
  
  private kd(byte paramByte)
  {
    AppMethodBeat.i(125619);
    this.dPd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125619);
  }
  
  public static final class a
  {
    public boolean isResume = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.kd
 * JD-Core Version:    0.7.0.1
 */