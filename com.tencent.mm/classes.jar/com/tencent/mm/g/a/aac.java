package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aac
  extends IEvent
{
  public a egO;
  public b egP;
  
  public aac()
  {
    this((byte)0);
  }
  
  private aac(byte paramByte)
  {
    AppMethodBeat.i(91229);
    this.egO = new a();
    this.egP = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91229);
  }
  
  public static final class a {}
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.aac
 * JD-Core Version:    0.7.0.1
 */