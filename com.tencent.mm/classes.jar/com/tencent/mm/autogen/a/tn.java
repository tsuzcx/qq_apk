package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tn
  extends IEvent
{
  public a hXh;
  
  public tn()
  {
    this((byte)0);
  }
  
  private tn(byte paramByte)
  {
    AppMethodBeat.i(116041);
    this.hXh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116041);
  }
  
  public static final class a
  {
    public String filePath;
    public String result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.tn
 * JD-Core Version:    0.7.0.1
 */