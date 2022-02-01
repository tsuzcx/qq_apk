package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abt
  extends IEvent
{
  public a ifk;
  
  public abt()
  {
    this((byte)0);
  }
  
  private abt(byte paramByte)
  {
    AppMethodBeat.i(153188);
    this.ifk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153188);
  }
  
  public static final class a
  {
    public int ifl;
    public boolean ifm = false;
    public boolean ifn = false;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.a.abt
 * JD-Core Version:    0.7.0.1
 */