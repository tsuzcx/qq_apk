package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zi
  extends IEvent
{
  public a efv;
  
  public zi()
  {
    this((byte)0);
  }
  
  private zi(byte paramByte)
  {
    AppMethodBeat.i(149894);
    this.efv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149894);
  }
  
  public static final class a
  {
    public boolean dCH = false;
    public boolean dCI = false;
    public boolean efw = false;
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.zi
 * JD-Core Version:    0.7.0.1
 */