package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aag
  extends IEvent
{
  public a ehb;
  public b ehc;
  
  public aag()
  {
    this((byte)0);
  }
  
  private aag(byte paramByte)
  {
    AppMethodBeat.i(116059);
    this.ehb = new a();
    this.ehc = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116059);
  }
  
  public static final class a
  {
    public String dQp;
  }
  
  public static final class b
  {
    public boolean ehd;
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.aag
 * JD-Core Version:    0.7.0.1
 */