package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yk
  extends IEvent
{
  public a eeH;
  
  public yk()
  {
    this((byte)0);
  }
  
  private yk(byte paramByte)
  {
    AppMethodBeat.i(19843);
    this.eeH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19843);
  }
  
  public static final class a
  {
    public String countryCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.yk
 * JD-Core Version:    0.7.0.1
 */