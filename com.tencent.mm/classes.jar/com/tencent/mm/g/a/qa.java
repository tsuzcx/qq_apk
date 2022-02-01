package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qa
  extends IEvent
{
  public a dWj;
  public b dWk;
  
  public qa()
  {
    this((byte)0);
  }
  
  private qa(byte paramByte)
  {
    AppMethodBeat.i(149880);
    this.dWj = new a();
    this.dWk = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149880);
  }
  
  public static final class a
  {
    public int cSx = 0;
    public String dWl;
    public String scanResult;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.qa
 * JD-Core Version:    0.7.0.1
 */