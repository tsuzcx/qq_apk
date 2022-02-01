package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class m
  extends IEvent
{
  public a dCj;
  public b dCk;
  
  public m()
  {
    this((byte)0);
  }
  
  private m(byte paramByte)
  {
    AppMethodBeat.i(121047);
    this.dCj = new a();
    this.dCk = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121047);
  }
  
  public static final class a
  {
    public String dCl;
  }
  
  public static final class b
  {
    public int dCm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.m
 * JD-Core Version:    0.7.0.1
 */