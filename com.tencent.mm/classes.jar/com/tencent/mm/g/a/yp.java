package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yp
  extends IEvent
{
  public a eeQ;
  
  public yp()
  {
    this((byte)0);
  }
  
  private yp(byte paramByte)
  {
    AppMethodBeat.i(153188);
    this.eeQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153188);
  }
  
  public static final class a
  {
    public int eeR;
    public boolean eeS = false;
    public boolean eeT = false;
    public String title;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.yp
 * JD-Core Version:    0.7.0.1
 */