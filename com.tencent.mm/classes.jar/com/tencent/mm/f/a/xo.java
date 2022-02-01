package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xo
  extends IEvent
{
  public a fWx;
  
  public xo()
  {
    this((byte)0);
  }
  
  private xo(byte paramByte)
  {
    AppMethodBeat.i(125647);
    this.fWx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125647);
  }
  
  public static final class a
  {
    public String fWy;
    public String id;
    public String result;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xo
 * JD-Core Version:    0.7.0.1
 */