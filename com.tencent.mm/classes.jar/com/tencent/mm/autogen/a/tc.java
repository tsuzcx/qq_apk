package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tc
  extends IEvent
{
  public a hWE;
  public b hWF;
  
  public tc()
  {
    this((byte)0);
  }
  
  private tc(byte paramByte)
  {
    AppMethodBeat.i(123933);
    this.hWE = new a();
    this.hWF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(123933);
  }
  
  public static final class a
  {
    public dn hWG;
    public int hWH = -1;
    public String hWI;
    public int hWJ = 0;
    public int opType = 1;
  }
  
  public static final class b
  {
    public boolean hCQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.tc
 * JD-Core Version:    0.7.0.1
 */