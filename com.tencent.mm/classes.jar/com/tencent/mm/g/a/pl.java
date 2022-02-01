package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pl
  extends IEvent
{
  public a dVC;
  public b dVD;
  
  public pl()
  {
    this((byte)0);
  }
  
  private pl(byte paramByte)
  {
    AppMethodBeat.i(130032);
    this.dVC = new a();
    this.dVD = new b();
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
    public boolean dVB = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.pl
 * JD-Core Version:    0.7.0.1
 */