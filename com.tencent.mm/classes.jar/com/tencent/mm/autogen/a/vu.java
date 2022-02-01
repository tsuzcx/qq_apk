package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.LinkedList;

public final class vu
  extends IEvent
{
  public a hZs;
  public b hZt;
  
  public vu()
  {
    this((byte)0);
  }
  
  private vu(byte paramByte)
  {
    AppMethodBeat.i(91218);
    this.hZs = new a();
    this.hZt = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91218);
  }
  
  public static final class a
  {
    public LinkedList hZu;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vu
 * JD-Core Version:    0.7.0.1
 */