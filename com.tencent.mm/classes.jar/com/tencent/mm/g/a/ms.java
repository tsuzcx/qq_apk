package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ms
  extends IEvent
{
  public a dSm;
  
  public ms()
  {
    this((byte)0);
  }
  
  private ms(byte paramByte)
  {
    AppMethodBeat.i(19821);
    this.dSm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19821);
  }
  
  public static final class a
  {
    public byte[] dSn;
    public int dSo;
    public boolean dSp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ms
 * JD-Core Version:    0.7.0.1
 */