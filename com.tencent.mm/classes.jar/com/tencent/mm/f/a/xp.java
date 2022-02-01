package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xp
  extends IEvent
{
  public a fWz;
  
  public xp()
  {
    this((byte)0);
  }
  
  private xp(byte paramByte)
  {
    AppMethodBeat.i(94817);
    this.fWz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94817);
  }
  
  public static final class a
  {
    public String mediaId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xp
 * JD-Core Version:    0.7.0.1
 */