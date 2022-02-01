package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pk
  extends IEvent
{
  public a dVx;
  public b dVy;
  
  public pk()
  {
    this((byte)0);
  }
  
  private pk(byte paramByte)
  {
    AppMethodBeat.i(130031);
    this.dVx = new a();
    this.dVy = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130031);
  }
  
  public static final class a
  {
    public boolean dVA = false;
    public boolean dVz = false;
    public int type;
  }
  
  public static final class b
  {
    public boolean dVB = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.pk
 * JD-Core Version:    0.7.0.1
 */