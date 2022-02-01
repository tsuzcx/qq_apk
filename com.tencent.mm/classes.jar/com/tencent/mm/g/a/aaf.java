package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaf
  extends IEvent
{
  public a egV;
  public b egW;
  
  public aaf()
  {
    this((byte)0);
  }
  
  private aaf(byte paramByte)
  {
    AppMethodBeat.i(116058);
    this.egV = new a();
    this.egW = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116058);
  }
  
  public static final class a
  {
    public String egX;
  }
  
  public static final class b
  {
    public int egY = -1;
    public int egZ = -1;
    public int eha = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.aaf
 * JD-Core Version:    0.7.0.1
 */