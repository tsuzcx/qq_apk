package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class ly
  extends IEvent
{
  public a dRv;
  public b dRw;
  
  public ly()
  {
    this((byte)0);
  }
  
  private ly(byte paramByte)
  {
    AppMethodBeat.i(55664);
    this.dRv = new a();
    this.dRw = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55664);
  }
  
  public static final class a
  {
    public ca dCM;
    public int dRq = 0;
    public boolean dRx = false;
    public String language;
  }
  
  public static final class b
  {
    public String dNk;
    public String dRy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ly
 * JD-Core Version:    0.7.0.1
 */