package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class hw
  extends IEvent
{
  public a fEU;
  public b fEV;
  
  public hw()
  {
    this((byte)0);
  }
  
  private hw(byte paramByte)
  {
    AppMethodBeat.i(55662);
    this.fEU = new a();
    this.fEV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55662);
  }
  
  public static final class a
  {
    public ca fvt;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.hw
 * JD-Core Version:    0.7.0.1
 */