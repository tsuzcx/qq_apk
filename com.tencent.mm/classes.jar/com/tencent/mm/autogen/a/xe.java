package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xe
  extends IEvent
{
  public a iaG;
  public b iaH;
  
  public xe()
  {
    this((byte)0);
  }
  
  private xe(byte paramByte)
  {
    AppMethodBeat.i(93327);
    this.iaG = new a();
    this.iaH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93327);
  }
  
  public static final class a
  {
    public String iaI;
    public String iaJ;
    public int iaK = 0;
  }
  
  public static final class b
  {
    public String iaI;
    public boolean isSuccess = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.a.xe
 * JD-Core Version:    0.7.0.1
 */