package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wv
  extends IEvent
{
  public a edj;
  
  public wv()
  {
    this((byte)0);
  }
  
  private wv(byte paramByte)
  {
    AppMethodBeat.i(116049);
    this.edj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116049);
  }
  
  public static final class a
  {
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.wv
 * JD-Core Version:    0.7.0.1
 */