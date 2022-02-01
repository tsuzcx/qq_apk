package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tn
  extends IEvent
{
  public a dZX;
  
  public tn()
  {
    this((byte)0);
  }
  
  private tn(byte paramByte)
  {
    AppMethodBeat.i(223487);
    this.dZX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(223487);
  }
  
  public static final class a
  {
    public String dZW;
    public String deviceName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.tn
 * JD-Core Version:    0.7.0.1
 */