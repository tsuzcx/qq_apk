package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ip
  extends IEvent
{
  public a dNj;
  
  public ip()
  {
    this((byte)0);
  }
  
  private ip(byte paramByte)
  {
    AppMethodBeat.i(91205);
    this.dNj = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91205);
  }
  
  public static final class a
  {
    public String dNk;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.ip
 * JD-Core Version:    0.7.0.1
 */