package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abm
  extends IEvent
{
  public a gbl;
  public b gbm;
  
  public abm()
  {
    this((byte)0);
  }
  
  private abm(byte paramByte)
  {
    AppMethodBeat.i(116058);
    this.gbl = new a();
    this.gbm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116058);
  }
  
  public static final class a
  {
    public String gbn;
  }
  
  public static final class b
  {
    public int gbo = -1;
    public int gbp = -1;
    public int gbq = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.abm
 * JD-Core Version:    0.7.0.1
 */