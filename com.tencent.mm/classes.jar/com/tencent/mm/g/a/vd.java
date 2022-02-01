package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vd
  extends IEvent
{
  public a ebw;
  
  public vd()
  {
    this((byte)0);
  }
  
  private vd(byte paramByte)
  {
    AppMethodBeat.i(201821);
    this.ebw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(201821);
  }
  
  public static final class a
  {
    public int ebA = 0;
    public String ebx;
    public String eby;
    public String ebz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vd
 * JD-Core Version:    0.7.0.1
 */