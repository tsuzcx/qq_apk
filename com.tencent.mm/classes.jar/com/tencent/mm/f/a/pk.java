package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pk
  extends IEvent
{
  public a fOe;
  
  public pk()
  {
    this((byte)0);
  }
  
  private pk(byte paramByte)
  {
    AppMethodBeat.i(130780);
    this.fOe = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130780);
  }
  
  public static final class a
  {
    public int errCode = 0;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.pk
 * JD-Core Version:    0.7.0.1
 */