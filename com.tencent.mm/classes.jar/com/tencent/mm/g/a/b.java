package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class b
  extends IEvent
{
  public a dBM;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte)
  {
    AppMethodBeat.i(93321);
    this.dBM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93321);
  }
  
  public static final class a
  {
    public String dBN;
    public int resultCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.b
 * JD-Core Version:    0.7.0.1
 */