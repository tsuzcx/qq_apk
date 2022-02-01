package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gp
  extends IEvent
{
  public b dKA;
  public a dKz;
  
  public gp()
  {
    this((byte)0);
  }
  
  private gp(byte paramByte)
  {
    AppMethodBeat.i(155366);
    this.dKz = new a();
    this.dKA = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155366);
  }
  
  public static final class a
  {
    public String dKB;
    public String dKC;
  }
  
  public static final class b
  {
    public boolean dKD = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.gp
 * JD-Core Version:    0.7.0.1
 */