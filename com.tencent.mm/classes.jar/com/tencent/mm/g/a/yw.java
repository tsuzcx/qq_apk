package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yw
  extends IEvent
{
  public a efe;
  public b eff;
  
  public yw()
  {
    this((byte)0);
  }
  
  private yw(byte paramByte)
  {
    AppMethodBeat.i(121052);
    this.efe = new a();
    this.eff = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121052);
  }
  
  public static final class a
  {
    public int action;
    public String dCl;
    public int option;
  }
  
  public static final class b
  {
    public boolean efg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.yw
 * JD-Core Version:    0.7.0.1
 */