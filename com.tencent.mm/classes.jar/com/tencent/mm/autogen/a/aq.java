package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aq
  extends IEvent
{
  public a hAp;
  public b hAq;
  
  public aq()
  {
    this((byte)0);
  }
  
  private aq(byte paramByte)
  {
    AppMethodBeat.i(42651);
    this.hAp = new a();
    this.hAq = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(42651);
  }
  
  public static final class a
  {
    public int hAr = 0;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aq
 * JD-Core Version:    0.7.0.1
 */