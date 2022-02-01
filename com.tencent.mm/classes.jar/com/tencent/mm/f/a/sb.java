package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sb
  extends IEvent
{
  public a fRv;
  
  public sb()
  {
    this((byte)0);
  }
  
  private sb(byte paramByte)
  {
    AppMethodBeat.i(210362);
    this.fRv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(210362);
  }
  
  public static final class a
  {
    public String errMsg;
    public boolean fJQ = false;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.sb
 * JD-Core Version:    0.7.0.1
 */