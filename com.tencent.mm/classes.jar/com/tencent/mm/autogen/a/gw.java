package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gw
  extends IEvent
{
  public a hHt;
  public b hHu;
  
  public gw()
  {
    this((byte)0);
  }
  
  private gw(byte paramByte)
  {
    AppMethodBeat.i(116808);
    this.hHt = new a();
    this.hHu = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116808);
  }
  
  public static final class a
  {
    public int action;
    public long cTz;
    public long hHv;
    public long hHw;
  }
  
  public static final class b
  {
    public String config;
    public boolean hHx = false;
    public int hHy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gw
 * JD-Core Version:    0.7.0.1
 */