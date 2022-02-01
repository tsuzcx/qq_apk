package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bt
  extends IEvent
{
  public a dEW;
  
  public bt()
  {
    this((byte)0);
  }
  
  private bt(byte paramByte)
  {
    AppMethodBeat.i(117355);
    this.dEW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117355);
  }
  
  public static final class a
  {
    public Boolean dEX = Boolean.FALSE;
    public Boolean dEY = Boolean.FALSE;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.bt
 * JD-Core Version:    0.7.0.1
 */