package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class in
  extends IEvent
{
  public a dNg;
  
  public in()
  {
    this((byte)0);
  }
  
  private in(byte paramByte)
  {
    AppMethodBeat.i(19810);
    this.dNg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19810);
  }
  
  public static final class a
  {
    public String data;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.in
 * JD-Core Version:    0.7.0.1
 */