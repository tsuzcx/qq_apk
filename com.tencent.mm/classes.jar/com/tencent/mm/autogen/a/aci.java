package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aci
  extends IEvent
{
  public a ifM;
  
  public aci()
  {
    this((byte)0);
  }
  
  private aci(byte paramByte)
  {
    AppMethodBeat.i(19846);
    this.ifM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19846);
  }
  
  public static final class a
  {
    public String path;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aci
 * JD-Core Version:    0.7.0.1
 */