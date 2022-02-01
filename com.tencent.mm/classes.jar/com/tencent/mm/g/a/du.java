package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class du
  extends IEvent
{
  public a dGN;
  public b dGO;
  
  public du()
  {
    this((byte)0);
  }
  
  private du(byte paramByte)
  {
    AppMethodBeat.i(115978);
    this.dGN = new a();
    this.dGO = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115978);
  }
  
  public static final class a
  {
    public String dGL;
    public String dGP;
  }
  
  public static final class b
  {
    public boolean dGQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.du
 * JD-Core Version:    0.7.0.1
 */