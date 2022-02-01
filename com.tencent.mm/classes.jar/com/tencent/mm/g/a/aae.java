package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aae
  extends IEvent
{
  public a egS;
  public b egT;
  
  public aae()
  {
    this((byte)0);
  }
  
  private aae(byte paramByte)
  {
    AppMethodBeat.i(91231);
    this.egS = new a();
    this.egT = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91231);
  }
  
  public static final class a
  {
    public String egU;
  }
  
  public static final class b
  {
    public int status = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.aae
 * JD-Core Version:    0.7.0.1
 */