package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aba
  extends IEvent
{
  public a ieF;
  
  public aba()
  {
    this((byte)0);
  }
  
  private aba(byte paramByte)
  {
    AppMethodBeat.i(19842);
    this.ieF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19842);
  }
  
  public static final class a
  {
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aba
 * JD-Core Version:    0.7.0.1
 */