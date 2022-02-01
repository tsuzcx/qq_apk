package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jq
  extends IEvent
{
  public a dOw;
  public b dOx;
  
  public jq()
  {
    this((byte)0);
  }
  
  private jq(byte paramByte)
  {
    AppMethodBeat.i(91207);
    this.dOw = new a();
    this.dOx = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91207);
  }
  
  public static final class a
  {
    public int dOy = 0;
  }
  
  public static final class b
  {
    public String dOA;
    public boolean dOz = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.jq
 * JD-Core Version:    0.7.0.1
 */