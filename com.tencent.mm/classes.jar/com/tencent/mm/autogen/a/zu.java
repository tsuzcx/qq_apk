package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zu
  extends IEvent
{
  public a idp;
  
  public zu()
  {
    this((byte)0);
  }
  
  private zu(byte paramByte)
  {
    AppMethodBeat.i(116049);
    this.idp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116049);
  }
  
  public static final class a
  {
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.zu
 * JD-Core Version:    0.7.0.1
 */