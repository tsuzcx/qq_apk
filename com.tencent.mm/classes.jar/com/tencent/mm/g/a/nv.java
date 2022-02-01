package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class nv
  extends IEvent
{
  public a dTW;
  
  public nv()
  {
    this((byte)0);
  }
  
  private nv(byte paramByte)
  {
    AppMethodBeat.i(185944);
    this.dTW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(185944);
  }
  
  public static final class a
  {
    public ca dTX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.nv
 * JD-Core Version:    0.7.0.1
 */