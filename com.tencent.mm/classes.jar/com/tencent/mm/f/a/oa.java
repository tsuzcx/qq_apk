package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class oa
  extends IEvent
{
  public a fMO;
  
  public oa()
  {
    this((byte)0);
  }
  
  private oa(byte paramByte)
  {
    AppMethodBeat.i(149875);
    this.fMO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149875);
  }
  
  public static final class a
  {
    public int errCode = 0;
    public String errMsg;
    public int errType = 0;
    public IEvent fMP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.oa
 * JD-Core Version:    0.7.0.1
 */