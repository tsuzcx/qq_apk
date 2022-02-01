package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ul
  extends IEvent
{
  public a hYf;
  
  public ul()
  {
    this((byte)0);
  }
  
  private ul(byte paramByte)
  {
    AppMethodBeat.i(116043);
    this.hYf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116043);
  }
  
  public static final class a
  {
    public String appId;
    public String hYg;
    public String mediaTagName;
    public String pkgName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ul
 * JD-Core Version:    0.7.0.1
 */