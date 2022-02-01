package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wl
  extends IEvent
{
  public a ecx;
  
  public wl()
  {
    this((byte)0);
  }
  
  private wl(byte paramByte)
  {
    AppMethodBeat.i(125649);
    this.ecx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125649);
  }
  
  public static final class a
  {
    public String id;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.wl
 * JD-Core Version:    0.7.0.1
 */