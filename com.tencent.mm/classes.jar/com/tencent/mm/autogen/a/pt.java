package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pt
  extends IEvent
{
  public a hSV;
  
  public pt()
  {
    this((byte)0);
  }
  
  private pt(byte paramByte)
  {
    AppMethodBeat.i(19822);
    this.hSV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19822);
  }
  
  public static final class a
  {
    public int hSW = 0;
    public int hSX = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.pt
 * JD-Core Version:    0.7.0.1
 */