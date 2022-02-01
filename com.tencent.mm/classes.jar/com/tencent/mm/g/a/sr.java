package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sr
  extends IEvent
{
  public a dZh;
  public b dZi;
  
  public sr()
  {
    this((byte)0);
  }
  
  private sr(byte paramByte)
  {
    AppMethodBeat.i(93326);
    this.dZh = new a();
    this.dZi = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93326);
  }
  
  public static final class a {}
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.sr
 * JD-Core Version:    0.7.0.1
 */