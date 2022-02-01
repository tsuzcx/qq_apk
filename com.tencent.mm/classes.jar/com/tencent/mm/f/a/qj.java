package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qj
  extends IEvent
{
  public a fPf;
  public b fPg;
  
  public qj()
  {
    this((byte)0);
  }
  
  private qj(byte paramByte)
  {
    AppMethodBeat.i(130032);
    this.fPf = new a();
    this.fPg = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130032);
  }
  
  public static final class a
  {
    public int type;
  }
  
  public static final class b
  {
    public boolean fPe = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.a.qj
 * JD-Core Version:    0.7.0.1
 */