package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class no
  extends IEvent
{
  public a fMb;
  
  public no()
  {
    this((byte)0);
  }
  
  private no(byte paramByte)
  {
    AppMethodBeat.i(257484);
    this.fMb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(257484);
  }
  
  public static final class a
  {
    public int errCode;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.no
 * JD-Core Version:    0.7.0.1
 */