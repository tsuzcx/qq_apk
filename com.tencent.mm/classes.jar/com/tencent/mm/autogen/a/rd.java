package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rd
  extends IEvent
{
  public a hUi;
  
  public rd()
  {
    this((byte)0);
  }
  
  private rd(byte paramByte)
  {
    AppMethodBeat.i(19823);
    this.hUi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19823);
  }
  
  public static final class a
  {
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rd
 * JD-Core Version:    0.7.0.1
 */