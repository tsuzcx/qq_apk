package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rn
  extends IEvent
{
  public a fQH;
  public b fQI;
  
  public rn()
  {
    this((byte)0);
  }
  
  private rn(byte paramByte)
  {
    AppMethodBeat.i(123933);
    this.fQH = new a();
    this.fQI = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(123933);
  }
  
  public static final class a
  {
    public dd fQJ;
    public int fQK = -1;
    public String fQL;
    public int fQM = 0;
    public int opType = 1;
  }
  
  public static final class b
  {
    public boolean fyl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.rn
 * JD-Core Version:    0.7.0.1
 */