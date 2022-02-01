package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ks
  extends IEvent
{
  public a dPN;
  
  public ks()
  {
    this((byte)0);
  }
  
  private ks(byte paramByte)
  {
    AppMethodBeat.i(153184);
    this.dPN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153184);
  }
  
  public static final class a
  {
    public int delay;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ks
 * JD-Core Version:    0.7.0.1
 */