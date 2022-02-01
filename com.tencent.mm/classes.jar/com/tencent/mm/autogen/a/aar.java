package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aar
  extends IEvent
{
  public a iel;
  
  public aar()
  {
    this((byte)0);
  }
  
  private aar(byte paramByte)
  {
    AppMethodBeat.i(149892);
    this.iel = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149892);
  }
  
  public static final class a
  {
    public boolean iem = false;
    public boolean ien = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aar
 * JD-Core Version:    0.7.0.1
 */