package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dn
  extends IEvent
{
  public dn.a hDr;
  public b hDs;
  
  public dn()
  {
    this((byte)0);
  }
  
  private dn(byte paramByte)
  {
    AppMethodBeat.i(127402);
    this.hDr = new dn.a();
    this.hDs = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127402);
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.dn
 * JD-Core Version:    0.7.0.1
 */