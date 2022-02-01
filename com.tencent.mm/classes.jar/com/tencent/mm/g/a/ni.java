package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ni
  extends IEvent
{
  public a dTt;
  
  public ni()
  {
    this((byte)0);
  }
  
  private ni(byte paramByte)
  {
    AppMethodBeat.i(149875);
    this.dTt = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149875);
  }
  
  public static final class a
  {
    public IEvent dTu;
    public int errCode = 0;
    public String errMsg;
    public int errType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ni
 * JD-Core Version:    0.7.0.1
 */