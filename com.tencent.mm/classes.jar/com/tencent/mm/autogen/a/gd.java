package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gd
  extends IEvent
{
  public a hGr;
  
  public gd()
  {
    this((byte)0);
  }
  
  private gd(byte paramByte)
  {
    AppMethodBeat.i(116013);
    this.hGr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116013);
  }
  
  public static final class a
  {
    public boolean isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gd
 * JD-Core Version:    0.7.0.1
 */