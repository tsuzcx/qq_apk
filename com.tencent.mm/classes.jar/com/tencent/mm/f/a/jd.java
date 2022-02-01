package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jd
  extends IEvent
{
  public a fGs;
  
  public jd()
  {
    this((byte)0);
  }
  
  private jd(byte paramByte)
  {
    AppMethodBeat.i(19810);
    this.fGs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19810);
  }
  
  public static final class a
  {
    public String data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.jd
 * JD-Core Version:    0.7.0.1
 */