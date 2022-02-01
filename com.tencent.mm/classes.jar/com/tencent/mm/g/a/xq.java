package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xq
  extends IEvent
{
  public a edR;
  public b edS;
  
  public xq()
  {
    this((byte)0);
  }
  
  private xq(byte paramByte)
  {
    AppMethodBeat.i(149891);
    this.edR = new a();
    this.edS = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149891);
  }
  
  public static final class a
  {
    public boolean edT = false;
    public boolean edU = false;
  }
  
  public static final class b
  {
    public String edV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.xq
 * JD-Core Version:    0.7.0.1
 */