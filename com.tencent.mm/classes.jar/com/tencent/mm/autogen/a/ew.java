package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ew
  extends IEvent
{
  public a hEX;
  public b hEY;
  
  public ew()
  {
    this((byte)0);
  }
  
  private ew(byte paramByte)
  {
    AppMethodBeat.i(115988);
    this.hEX = new a();
    this.hEY = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115988);
  }
  
  public static final class a
  {
    public String hEZ;
    public String hEl;
    public String hEy;
    public int type;
  }
  
  public static final class b
  {
    public boolean hFa;
    public String hFb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ew
 * JD-Core Version:    0.7.0.1
 */