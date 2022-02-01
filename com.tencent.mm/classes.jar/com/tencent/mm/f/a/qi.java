package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qi
  extends IEvent
{
  public a fPa;
  public b fPb;
  
  public qi()
  {
    this((byte)0);
  }
  
  private qi(byte paramByte)
  {
    AppMethodBeat.i(130031);
    this.fPa = new a();
    this.fPb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130031);
  }
  
  public static final class a
  {
    public boolean fPc = false;
    public boolean fPd = false;
    public int type;
  }
  
  public static final class b
  {
    public boolean fPe = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.qi
 * JD-Core Version:    0.7.0.1
 */