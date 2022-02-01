package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vo
  extends IEvent
{
  public a ebL;
  
  public vo()
  {
    this((byte)0);
  }
  
  private vo(byte paramByte)
  {
    AppMethodBeat.i(125638);
    this.ebL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125638);
  }
  
  public static final class a
  {
    public String dHp;
    public String dRS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vo
 * JD-Core Version:    0.7.0.1
 */