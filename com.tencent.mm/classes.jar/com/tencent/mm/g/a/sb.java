package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sb
  extends IEvent
{
  public a dYE;
  
  public sb()
  {
    this((byte)0);
  }
  
  private sb(byte paramByte)
  {
    AppMethodBeat.i(187544);
    this.dYE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(187544);
  }
  
  public static final class a
  {
    public byte[] buffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.sb
 * JD-Core Version:    0.7.0.1
 */