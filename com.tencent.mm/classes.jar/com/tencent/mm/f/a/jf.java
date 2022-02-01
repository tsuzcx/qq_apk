package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jf
  extends IEvent
{
  public a fGv;
  
  public jf()
  {
    this((byte)0);
  }
  
  private jf(byte paramByte)
  {
    AppMethodBeat.i(91205);
    this.fGv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91205);
  }
  
  public static final class a
  {
    public String fGw;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.jf
 * JD-Core Version:    0.7.0.1
 */