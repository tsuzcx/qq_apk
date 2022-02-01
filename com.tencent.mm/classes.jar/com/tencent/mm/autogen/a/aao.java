package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aao
  extends IEvent
{
  public a ied;
  
  public aao()
  {
    this((byte)0);
  }
  
  private aao(byte paramByte)
  {
    AppMethodBeat.i(162263);
    this.ied = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(162263);
  }
  
  public static final class a
  {
    public String viewId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aao
 * JD-Core Version:    0.7.0.1
 */