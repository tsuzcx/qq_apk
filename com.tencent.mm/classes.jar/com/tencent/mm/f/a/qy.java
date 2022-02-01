package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qy
  extends IEvent
{
  public a fPO;
  public b fPP;
  
  public qy()
  {
    this((byte)0);
  }
  
  private qy(byte paramByte)
  {
    AppMethodBeat.i(149880);
    this.fPO = new a();
    this.fPP = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149880);
  }
  
  public static final class a
  {
    public int cUP = 0;
    public String fPQ;
    public String scanResult;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.qy
 * JD-Core Version:    0.7.0.1
 */