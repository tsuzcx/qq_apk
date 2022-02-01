package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xl
  extends IEvent
{
  public a iaO;
  public b iaP;
  
  public xl()
  {
    this((byte)0);
  }
  
  private xl(byte paramByte)
  {
    AppMethodBeat.i(153185);
    this.iaO = new a();
    this.iaP = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153185);
  }
  
  public static final class a
  {
    public boolean iaQ;
  }
  
  public static final class b
  {
    public boolean iaR;
    public boolean iaS;
    public boolean iaT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.xl
 * JD-Core Version:    0.7.0.1
 */