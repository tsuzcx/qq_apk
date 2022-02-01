package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.sdk.event.IEvent;

public final class hx
  extends IEvent
{
  public a hJn;
  
  public hx()
  {
    this((byte)0);
  }
  
  private hx(byte paramByte)
  {
    AppMethodBeat.i(168628);
    this.hJn = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168628);
  }
  
  public static final class a
  {
    public m contact;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.hx
 * JD-Core Version:    0.7.0.1
 */