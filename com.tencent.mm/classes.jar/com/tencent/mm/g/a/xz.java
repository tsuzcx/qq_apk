package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xz
  extends IEvent
{
  public a eeo;
  
  public xz()
  {
    this((byte)0);
  }
  
  private xz(byte paramByte)
  {
    AppMethodBeat.i(19842);
    this.eeo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19842);
  }
  
  public static final class a
  {
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.xz
 * JD-Core Version:    0.7.0.1
 */