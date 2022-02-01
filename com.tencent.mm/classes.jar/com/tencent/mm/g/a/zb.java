package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zb
  extends IEvent
{
  public a efl;
  
  public zb()
  {
    this((byte)0);
  }
  
  private zb(byte paramByte)
  {
    AppMethodBeat.i(187329);
    this.efl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(187329);
  }
  
  public static final class a
  {
    public boolean efm;
    public long msgId;
    public boolean success;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.zb
 * JD-Core Version:    0.7.0.1
 */