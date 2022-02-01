package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class td
  extends IEvent
{
  public a dZA;
  public b dZB;
  
  public td()
  {
    this((byte)0);
  }
  
  private td(byte paramByte)
  {
    AppMethodBeat.i(91218);
    this.dZA = new a();
    this.dZB = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91218);
  }
  
  public static final class a
  {
    public LinkedList dZC;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.td
 * JD-Core Version:    0.7.0.1
 */