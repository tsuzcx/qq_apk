package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dm
  extends IEvent
{
  public a dGw;
  
  public dm()
  {
    this((byte)0);
  }
  
  private dm(byte paramByte)
  {
    AppMethodBeat.i(104414);
    this.dGw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104414);
  }
  
  public static final class a
  {
    public int dDe;
    public String md5;
    public boolean success;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.dm
 * JD-Core Version:    0.7.0.1
 */