package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class c
  extends IEvent
{
  public a hyG;
  
  public c()
  {
    this((byte)0);
  }
  
  private c(byte paramByte)
  {
    AppMethodBeat.i(93321);
    this.hyG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93321);
  }
  
  public static final class a
  {
    public String hyH;
    public int resultCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.c
 * JD-Core Version:    0.7.0.1
 */