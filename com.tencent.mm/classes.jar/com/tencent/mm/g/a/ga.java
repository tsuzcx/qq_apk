package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ga
  extends IEvent
{
  public a dJF;
  public b dJG;
  
  public ga()
  {
    this((byte)0);
  }
  
  private ga(byte paramByte)
  {
    AppMethodBeat.i(116020);
    this.dJF = new a();
    this.dJG = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116020);
  }
  
  public static final class a
  {
    public int op;
    public String username;
  }
  
  public static final class b
  {
    public boolean dFE = false;
    public String fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ga
 * JD-Core Version:    0.7.0.1
 */