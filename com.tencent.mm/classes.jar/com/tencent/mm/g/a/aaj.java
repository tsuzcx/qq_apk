package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaj
  extends IEvent
{
  public a ehg;
  
  public aaj()
  {
    this((byte)0);
  }
  
  private aaj(byte paramByte)
  {
    AppMethodBeat.i(117552);
    this.ehg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117552);
  }
  
  public static final class a
  {
    public long dTS;
    public String dWG;
    public String ehh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.aaj
 * JD-Core Version:    0.7.0.1
 */