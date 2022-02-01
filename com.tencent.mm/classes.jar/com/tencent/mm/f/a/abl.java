package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abl
  extends IEvent
{
  public a gbi;
  public b gbj;
  
  public abl()
  {
    this((byte)0);
  }
  
  private abl(byte paramByte)
  {
    AppMethodBeat.i(91231);
    this.gbi = new a();
    this.gbj = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91231);
  }
  
  public static final class a
  {
    public String gbk;
  }
  
  public static final class b
  {
    public int status = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.abl
 * JD-Core Version:    0.7.0.1
 */