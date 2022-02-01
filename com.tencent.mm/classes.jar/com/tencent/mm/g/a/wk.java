package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wk
  extends IEvent
{
  public a ecw;
  
  public wk()
  {
    this((byte)0);
  }
  
  private wk(byte paramByte)
  {
    AppMethodBeat.i(125648);
    this.ecw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125648);
  }
  
  public static final class a
  {
    public String id;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.wk
 * JD-Core Version:    0.7.0.1
 */