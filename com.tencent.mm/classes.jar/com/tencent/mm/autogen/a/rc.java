package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rc
  extends IEvent
{
  public a hUd;
  public b hUe;
  
  public rc()
  {
    this((byte)0);
  }
  
  private rc(byte paramByte)
  {
    AppMethodBeat.i(116039);
    this.hUd = new a();
    this.hUe = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116039);
  }
  
  public static final class a
  {
    public String hDd;
    public String hUf;
    public int hUg;
    public int hUh;
    public int source;
  }
  
  public static final class b
  {
    public String xml;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rc
 * JD-Core Version:    0.7.0.1
 */