package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ns
  extends IEvent
{
  public a dTP;
  public b dTQ;
  
  public ns()
  {
    this((byte)0);
  }
  
  private ns(byte paramByte)
  {
    AppMethodBeat.i(110275);
    this.dTP = new a();
    this.dTQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(110275);
  }
  
  public static final class a
  {
    public boolean dTR = false;
    public String key;
    public int type = 0;
    public String username;
  }
  
  public static final class b
  {
    public long dTS;
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ns
 * JD-Core Version:    0.7.0.1
 */