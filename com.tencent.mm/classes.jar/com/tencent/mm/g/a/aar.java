package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aar
  extends IEvent
{
  public a ehE;
  public b ehF;
  
  public aar()
  {
    this((byte)0);
  }
  
  private aar(byte paramByte)
  {
    AppMethodBeat.i(19850);
    this.ehE = new a();
    this.ehF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19850);
  }
  
  public static final class a
  {
    public int dDe;
    public String username;
  }
  
  public static final class b
  {
    public int ehG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.aar
 * JD-Core Version:    0.7.0.1
 */